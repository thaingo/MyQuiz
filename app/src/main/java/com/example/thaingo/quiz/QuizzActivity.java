package com.example.thaingo.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class QuizzActivity extends AppCompatActivity {
  private Button mTrueButton;
  private Button mFalseButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quizz);

    mTrueButton = (Button)findViewById(R.id.button_true);
    mFalseButton = (Button) findViewById(R.id.button_false);

    mTrueButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(QuizzActivity.this, R.string.toast_correct, Toast.LENGTH_SHORT).show();
        }
    });

    mFalseButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(QuizzActivity.this, R.string.toast_incorrect, Toast.LENGTH_SHORT).show();
        }
    });
  }
}
