package com.pankaj.contesttime;

import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class PostAdapter extends ArrayAdapter<Post> {

    public PostAdapter(Context context, List<Post> posts) {
        super(context, android.R.layout.simple_list_item_1, posts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        Post post = getItem(position);

        if(post != null){
            String startTime = convertIso8601ToHumanReadable(post.getStartTime());
            String endTime = convertIso8601ToHumanReadable(post.getEndTime());
            int duration = post.getDuration()/3600;
            String _duration = duration+" Hours";

            String data = String.format("Contest Name : %s\nStart Time : %s\nEnd Time : %s\nDuration : %s\nIn 24 Hours : %s\nStatus : %s",
                          post.getName(),startTime,endTime,_duration,post.getIn24Hours(),post.getStatus());
            if(post.getSite() != null){
                String site = "\nSite : "+post.getSite();
                data+=site;
                textView.setText(data);
            }else {
                textView.setText(data);
            }


            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openUrl(post.getUrl());
                }
            });
        }
        return convertView;
    }
    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        getContext().startActivity(intent);
    }
    public static String convertIso8601ToHumanReadable(String iso8601Date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy, HH:mm (z)");
        outputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            Date date = inputFormat.parse(iso8601Date);
            return outputFormat.format(date);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
            return iso8601Date;
        }
    }

}
