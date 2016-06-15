package com.example.udit.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.udit.myapplication.R;
import com.example.udit.myapplication.model.Page;
import com.example.udit.myapplication.model.story;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private story mStory = new story();

    ImageView mImageView;
    TextView mTextView;
    Button mchoice1;
    Button mchoice2;
    String mname;
   private Page mCurrentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String mname = intent.getStringExtra(getString(R.string.key_name));
        if (mname == null)
            mname = "Friend";
        Log.d(TAG, mname);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mchoice1 = (Button) findViewById(R.id.choicebuton1);
        mchoice2 = (Button) findViewById(R.id.choicebutton2);
        loadPage(0);
    }

    private void loadPage( int pagenumber) {
         mCurrentpage = mStory.getPage(pagenumber);


        mImageView.setImageDrawable(getResources().getDrawable(mCurrentpage.getImageId()));
        String pageText = mCurrentpage.getText();
                pageText=String.format(pageText,mname);
        mTextView.setText(pageText);
        mchoice1.setText(mCurrentpage.getChoice1().getText());
        mchoice2.setText(mCurrentpage.getChoice2().getText());


        if(mCurrentpage.isFinal())
        {
            mchoice1.setVisibility(View.INVISIBLE);
            mchoice2.setText("PLAY AGAIN");
            mchoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        else {
            mchoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pnumber = mCurrentpage.getChoice1().getNextPage();
                    loadPage(pnumber);
                }
            });

            mchoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pnumber = mCurrentpage.getChoice2().getNextPage();
                    loadPage(pnumber);
                }
            });

        }
    }
}