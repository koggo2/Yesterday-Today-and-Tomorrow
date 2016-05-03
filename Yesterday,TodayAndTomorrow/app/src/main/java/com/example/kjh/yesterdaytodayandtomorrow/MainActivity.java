package com.example.kjh.yesterdaytodayandtomorrow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static String urlStr = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=125";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v)
    {
        Toast.makeText(this, "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();

        new ProcessWeatherTask().execute(null, null, null);
    }

    public void onButton2Clicked(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    public void onButton3Clicked(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-4878-8710"));
        startActivity(intent);
    }

    public void onButton4Clicked(View v)
    {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
