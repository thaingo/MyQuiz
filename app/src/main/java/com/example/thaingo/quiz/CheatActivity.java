package com.example.thaingo.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.thaingo.quiz.answer_is_true";
    private static final String EXTRA_SHOWN_ANSWER = "com.example.thaingo.quiz.shown_answer";

    private boolean mAnswerIsTrue;
    private TextView mTextView;
    private Button mShowAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mTextView = (TextView) findViewById(R.id.textview_answer);
        mShowAnswerButton = (Button) findViewById(R.id.button_show_answer);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mTextView.setText(R.string.button_true);
                } else {
                    mTextView.setText(R.string.button_false);
                }
                setShownAnswerResult(true);
            }
        });
    }

    private void setShownAnswerResult(boolean shown) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_SHOWN_ANSWER, shown);
        setResult(RESULT_OK, intent);
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    public static boolean wasAnswerShown(Intent intent) {
        return intent.getBooleanExtra(EXTRA_SHOWN_ANSWER, false);
    }
}
