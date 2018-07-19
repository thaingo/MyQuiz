package com.example.thaingo.quiz;

public class Question {
    private int mQuestionId;
    private boolean mAnswerTrue;

    public Question(int mQuestionId, boolean mAnswerTrue) {
        this.mQuestionId = mQuestionId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
