package com.example.cas.gridviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    ArrayList arrayList;

    private static String[] gridViewStrings={
            "ALPHABETS",
            "NUMBERS",
            "MONTH",
            "DAYS",
            "ANIMALS",
            "CALL US",

    };

    private static int[] gridViewImages={
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=(GridView)findViewById(R.id.grid);
        gridView.setAdapter(new GridViewAdapter(this,gridViewStrings,gridViewImages));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent;
                Class classObject;
                switch(position) {
                    case 0:
                        classObject=FirstActivity.class;
                        break;

                    case 1:
                        classObject=SecondActivity.class;
                        break;
                    case 2:
                        classObject=ThirdActivity.class;
                        break;
                    case 3:
                        classObject=FirstActivity.class;
                        break;
                    case 4:
                        classObject=SecondActivity.class;
                        break;
                    default:
                        classObject=FirstActivity.class;
                        break;
                }
                intent = new Intent(getBaseContext(), classObject);
                intent.putExtra("name","Position Clicked: "+position);
                startActivity(intent);
            }
        });
    }
}
