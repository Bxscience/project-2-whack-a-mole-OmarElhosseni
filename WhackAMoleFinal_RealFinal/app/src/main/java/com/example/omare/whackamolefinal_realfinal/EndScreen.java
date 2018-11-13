package com.example.omare.whackamolefinal_realfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        TextView scoreView = (TextView) findViewById(R.id.textView);
        scoreView.setText("Score : " + getIntent().getStringExtra("SCORE"));

    }

    public void restartGame(View view) {
        Intent firstActivity = new Intent(this, MainActivity.class);
        startActivity(firstActivity);
    }

    public void endGame(View view) {
        finish();
        moveTaskToBack(true);
    }
}
