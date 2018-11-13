package com.example.omare.whackamolefinal_realfinal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Game45 extends AppCompatActivity {
    Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game45);
        final TextView mTextField = (TextView) findViewById(R.id.mtextField);
        final int moleCapacity = 12;
        final ArrayList<Integer> moles = new ArrayList<Integer>();
        final Intent gameEnd = new Intent(this, EndScreen.class);

        final String[] IDsOfImages = new String[moleCapacity];
        for(int i = 0; i < moleCapacity; i++) {
            IDsOfImages[i] = "image" + i;
        }

        for(String id : IDsOfImages) {
            int ConvertedIDofMole = getResources().getIdentifier(id, "id", getPackageName());
            ImageView image = (ImageView) findViewById(ConvertedIDofMole);

            image.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    int imageViewID = view.getId();
                    ImageView img = (ImageView) findViewById(imageViewID);

                    int idOfDiglett = getResources().getIdentifier("diglett", "drawable", getPackageName());//gets correct drawable and switches image found in activity
                    Drawable diglettDrawable = getDrawable(idOfDiglett);

                    int idOfHole = getResources().getIdentifier("hole", "drawable", getPackageName());//gets correct drawable and switches image found in activity
                    Drawable holeDrawable = getDrawable(idOfHole);

                    Log.d("CLICKED IMAGE", "Clicked: " + img.getTag());

                    if(img.getTag() != null) {
                        img.setImageDrawable(holeDrawable);
                        img.setTag(R.drawable.hole);
                        score++;
                        TextView scoreField = (TextView) findViewById(R.id.sTextField);
                        scoreField.setText("score : " + score.toString());
                    }
                }
            });

        }

        new CountDownTimer(60000, 1000) {
            int reps = 0;
            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds left: " + millisUntilFinished / 1000);//creates updating timer

                if(moles.size() <= 5 && reps >= 1) {
                    int newMole = (int) (Math.random() * moleCapacity);//picks random mole
                    while (moles.contains(newMole)) {
                        newMole = (int) (Math.random() * moleCapacity);
                    }
                    moles.add(newMole);//adds it to the picked moles arraylist

                    String IDofMolePicked = "image" + newMole;//gets the id of the image and create variable for it
                    int ConvertedIDofMole = getResources().getIdentifier(IDofMolePicked, "id", getPackageName());
                    ImageView ImageOfMole = (ImageView) findViewById(ConvertedIDofMole);

                    int idOFImage = getResources().getIdentifier("diglett", "drawable", getPackageName());//gets correct drawable and switches image found in activity
                    ImageOfMole.setImageDrawable(getDrawable(idOFImage));
                    ImageOfMole.setTag(R.drawable.diglett);
                }
                if(moles.size() >= 1 && reps%3 == 0) {
                    int removedMole = moles.get(0);

                    String IDofMolePicked = "image" + removedMole;//gets the id of the image and create variable for it
                    int ConvertedIDofMole = getResources().getIdentifier(IDofMolePicked, "id", getPackageName());
                    ImageView ImageOfMole = (ImageView) findViewById(ConvertedIDofMole);

                    int idOFImage = getResources().getIdentifier("hole", "drawable", getPackageName());//gets correct drawable and switches image found in activity
                    ImageOfMole.setImageDrawable(getDrawable(idOFImage));
                    ImageOfMole.setTag(R.drawable.hole);

                    moles.remove(0);//removes mole from the picked moles arraylist
                }
                reps++;

            }
            public void onFinish() {
                gameEnd.putExtra("SCORE", score.toString());
                startActivity(gameEnd);
            }
        }.start();
    }

}
