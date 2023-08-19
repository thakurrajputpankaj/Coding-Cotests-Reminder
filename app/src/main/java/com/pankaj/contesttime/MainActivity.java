package com.pankaj.contesttime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    TextView textView;
    Button all;
    Button hacker_rank;
    Button top_coder;
    Button code_chef;
    Button code_forces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.data);
        all = (Button) findViewById(R.id.all);
        hacker_rank = (Button) findViewById(R.id.hacker_rank);
        top_coder = (Button) findViewById(R.id.top_coder);
        code_chef = (Button) findViewById(R.id.code_chef);
        code_forces = (Button) findViewById(R.id.code_forces);

        //textView.setText("Hello");

        apiService = ApiClient.getClient("https://kontests.net/api/v1/").create(ApiService.class);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<Post>> call = apiService.getPost();
                EnqueueCall(call);
            }
        });

        hacker_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<Post>> call = apiService.getHackerRank();
                EnqueueCall(call);
            }
        });

        top_coder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<Post>> call = apiService.getTopCoder();
                EnqueueCall(call);
            }
        });

        code_forces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<Post>> call = apiService.getCodeForces();
                EnqueueCall(call);
            }
        });

        code_chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<Post>> call = apiService.getCodechef();
                EnqueueCall(call);
            }
        });

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