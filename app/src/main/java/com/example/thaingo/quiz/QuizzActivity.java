package com.example.thaingo.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizzActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Question[] mQuestions = new Question[]{
            new Question(R.string.question_russia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_americas, true)
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quizz);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.textview_question);

        mTrueButton = (Button) findViewById(R.id.button_true);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.button_false);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.button_next);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
                updateQuestion();
            }
        });

        mCheatButton = (Button) findViewById(R.id.button_cheat);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answerIsTrue = mQuestions[mCurrentIndex].isAnswerTrue();
                Intent intent = CheatActivity.newIntent(QuizzActivity.this, answerIsTrue);
                startActivity(intent);
            }
        });

        updateQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        saveInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    private void updateQuestion() {
        int question = mQuestions[mCurrentIndex].getQuestionId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        // whether user click TRUE or FALSE button
        boolean answerIsTrue = mQuestions[mCurrentIndex].isAnswerTrue();

        int toastMessageId = 0;
        if (userPressedTrue == answerIsTrue) {
            toastMessageId = R.string.toast_correct;
        } else {
            toastMessageId = R.string.toast_incorrect;
        }

        Toast.makeText(this, toastMessageId, Toast.LENGTH_SHORT).show();

    }
}
