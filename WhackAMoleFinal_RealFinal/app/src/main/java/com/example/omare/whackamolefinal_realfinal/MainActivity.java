package com.example.omare.whackamolefinal_realfinal;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button23 = (Button) findViewById(R.id.button23);
        Button button34 = (Button) findViewById(R.id.button34);
        Button button45 = (Button) findViewById(R.id.button45);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startGame23(View view) {
        Intent intent = new Intent(this, Game23.class);
        startActivity(intent);
    }

    public void startGame34(View view) {
        Intent intent = new Intent(this, Game34.class);
        startActivity(intent);
    }

    public void startGame45(View view) {
        Intent intent = new Intent(this, Game45  .class);
        startActivity(intent);
    }
}
