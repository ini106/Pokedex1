package com.example.iwcnrlee1.pokedex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String dataString ="";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        InputStream is=getResources().openRawResource(R.raw.pokemon);
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
        StringBuffer data=new StringBuffer();
        String line= null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(line!=null)
        {
            dataString+=line.toString();
        }
        Toast.makeText(this,dataString,Toast.LENGTH_SHORT);
    }
}
