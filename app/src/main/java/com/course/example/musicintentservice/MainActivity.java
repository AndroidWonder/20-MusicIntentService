//This example plays musiv streams without the user needing to create threads.
package com.course.example.musicintentservice;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String MSG_START_HARVARD = "start_Harvard";
    public static final String MSG_START_BBC = "start_BBC";
    public static final String MSG_STOP = "stop";

    private Button button01, button02, button03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button01 = (Button)findViewById(R.id.Button01);
        button02 = (Button)findViewById(R.id.Button02);
        button03 = (Button)findViewById(R.id.Button03);

        button01.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent msgIntent = new Intent(MainActivity.this, MyIntentService.class);
                        msgIntent.putExtra("MSG", MSG_START_HARVARD);
                        startService(msgIntent);
                    }});

        button02.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent msgIntent = new Intent(MainActivity.this, MyIntentService.class);
                        msgIntent.putExtra("MSG", MSG_START_BBC);
                        startService(msgIntent);
                    }});

        button03.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent msgIntent = new Intent(MainActivity.this, MyIntentService.class);
                        msgIntent.putExtra("MSG", MSG_STOP);
                        startService(msgIntent);
                    }});


    }
}
