package com.pankaj.contesttime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.data);

        //textView.setText("Hello");

        apiService = ApiClient.getClient("https://kontests.net/api/v1/").create(ApiService.class);
        Call<List<Post>> call = apiService.getPost();
        EnqueueCall(call);
    }

    public void EnqueueCall (Call<List<Post>> call){
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> contests = response.body();
                    if (contests != null && contests.size() > 0) {
                        Post firstContest = contests.get(0);
                        textView.setText("First Contest Name: " + firstContest.getName());
                    } else {
                        textView.setText("No contests available.");
                    }
                } else {
                    Log.e("API_ERROR", "Failed to retrieve data: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API_ERROR", "API call failed: " + t.getMessage());
            }
        });
    }
}