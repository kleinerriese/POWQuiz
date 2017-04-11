package com.example.android.powquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean gotFirstQuestionRight;
    boolean gotSecondQuestionRight;
    boolean gotThirdQuestionRight;
    boolean gotFourthQuestionRight;
    boolean gotFifthQuestionRight;
    boolean gotSixthQuestionRight;
    boolean gotSeventhQuestionRight;
    boolean checkedAnswersOnce;
    int totalScore;
    int totalQuestions = 7;
    int totalNumOfCorrectAnswers;

    private void resetVariable () {
        gotFirstQuestionRight = false;
        gotSecondQuestionRight = false;
        gotThirdQuestionRight = false;
        gotFourthQuestionRight = false;
        gotFifthQuestionRight = false;
        gotSixthQuestionRight = false;
        gotSeventhQuestionRight = false;
        checkedAnswersOnce = false;
        totalScore = 0;
        totalNumOfCorrectAnswers = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        resetVariable();

    }

    private void answerCheck() {

        if (!checkedAnswersOnce) {

            checkedAnswersOnce = true;

            RadioButton answerOne = (RadioButton) findViewById(R.id.questionOne_optionTwo_radioButton);
            RadioButton answerThree = (RadioButton) findViewById(R.id.questionThree_optionOne_radioButton);
            RadioButton answerFour = (RadioButton) findViewById(R.id.questionFour_optionThree_radioButton);
            RadioButton answerFive = (RadioButton) findViewById(R.id.questionFive_optionThree_radioButton);
            RadioButton answerSix = (RadioButton) findViewById(R.id.questionSix_optionFour_radioButton);
            RadioButton answerSeven = (RadioButton) findViewById(R.id.questionSeven_optionTwo_radioButton);

            boolean answerOneChecked = answerOne.isChecked();
            boolean answerThreeChecked = answerThree.isChecked();
            boolean answerFourChecked = answerFour.isChecked();
            boolean answerFiveChecked = answerFive.isChecked();
            boolean answerSixChecked = answerSix.isChecked();
            boolean answerSevenChecked = answerSeven.isChecked();

            if (answerOneChecked) {
                gotFirstQuestionRight = true;
                totalNumOfCorrectAnswers += 1;
                totalScore += 1;
            }

            if (answerThreeChecked) {
                gotThirdQuestionRight = true;
                totalScore += 1;
                totalNumOfCorrectAnswers += 1;
            }

            if (answerFourChecked) {
                gotFourthQuestionRight = true;
                totalScore += 1;
                totalNumOfCorrectAnswers += 1;
            }

            if (answerFiveChecked) {
                gotFifthQuestionRight = true;
                totalScore += 1;
                totalNumOfCorrectAnswers += 1;
            }

            if (answerSixChecked) {
                gotSixthQuestionRight = true;
                totalScore += 1;
                totalNumOfCorrectAnswers += 1;
            }

            if (answerSevenChecked) {
                gotSeventhQuestionRight = true;
                totalScore += 1;
                totalNumOfCorrectAnswers += 1;
            }

            EditText secondQuestionField = (EditText) findViewById(R.id.second_answer_field);
            String secondQuestionAnswer = secondQuestionField.getText().toString();

            if (secondQuestionAnswer.equals("Jeremy Jones")) {
                gotSecondQuestionRight = true;
                totalScore += 1;
                totalNumOfCorrectAnswers += 1;
            }
        }

    }




    public void groupOne (View view) {
        LinearLayout Start = (LinearLayout) findViewById(R.id.Start);
        LinearLayout questionOne = (LinearLayout) findViewById(R.id.QuestionOne);
        questionOne.setVisibility(View.VISIBLE);
        Start.setVisibility(View.GONE);
    }

    public void groupTwo (View view) {
        LinearLayout questionOne = (LinearLayout) findViewById(R.id.QuestionOne);
        LinearLayout questionTwo = (LinearLayout) findViewById(R.id.QuestionTwo);
        questionTwo.setVisibility(View.VISIBLE);
        questionOne.setVisibility(View.GONE);
    }
    public void groupThree (View view) {
        LinearLayout questionTwo = (LinearLayout) findViewById(R.id.QuestionTwo);
        LinearLayout questionThree = (LinearLayout) findViewById(R.id.QuestionThree);
        questionThree.setVisibility(View.VISIBLE);
        questionTwo.setVisibility(View.GONE);
    }
    public void groupFour (View view) {
        LinearLayout questionThree = (LinearLayout) findViewById(R.id.QuestionThree);
        LinearLayout questionFour = (LinearLayout) findViewById(R.id.QuestionFour);
        questionFour.setVisibility(View.VISIBLE);
        questionThree.setVisibility(View.GONE);
    }
    public void groupFive (View view) {
        LinearLayout questionFour = (LinearLayout) findViewById(R.id.QuestionFour);
        LinearLayout questionFive = (LinearLayout) findViewById(R.id.QuestionFive);
        questionFive.setVisibility(View.VISIBLE);
        questionFour.setVisibility(View.GONE);
    }
    public void groupSix (View view) {
        LinearLayout questionFive = (LinearLayout) findViewById(R.id.QuestionFive);
        LinearLayout questionSix = (LinearLayout) findViewById(R.id.QuestionSix);
        questionSix.setVisibility(View.VISIBLE);
        questionFive.setVisibility(View.GONE);
    }
    public void groupSeven (View view) {
        LinearLayout questionSix = (LinearLayout) findViewById(R.id.QuestionSix);
        LinearLayout questionSeven = (LinearLayout) findViewById(R.id.QuestionSeven);
        questionSeven.setVisibility(View.VISIBLE);
        questionSix.setVisibility(View.GONE);
    }


    public void submit (View view){
        LinearLayout statsContainer = (LinearLayout) findViewById(R.id.StatsContainer);
        LinearLayout questionSeven = (LinearLayout) findViewById(R.id.QuestionSeven);
        TextView stats = (TextView) findViewById(R.id.stats);
        statsContainer.setVisibility(View.VISIBLE);
        questionSeven.setVisibility(View.GONE);
        String statsSummary = createStats();
        stats.setText(statsSummary);

    }

    private String createStats () {

        answerCheck();
        String wronglyAnswered = "";

        if (!gotFirstQuestionRight) {
            wronglyAnswered = " 1";
        }
        if (!gotSecondQuestionRight) {
            wronglyAnswered += " 2";
        }
        if (!gotThirdQuestionRight) {
            wronglyAnswered += " 3";
        }
        if (!gotFourthQuestionRight) {
            wronglyAnswered += " 4";
        }
        if (!gotFifthQuestionRight) {
            wronglyAnswered += " 5";
        }
        if (!gotSixthQuestionRight) {
            wronglyAnswered += " 6";
        }
        if (!gotSeventhQuestionRight) {
            wronglyAnswered += " 7";
        }
        if (wronglyAnswered.equals(" 1 2 3 4 5 6 7") ) {
            wronglyAnswered = "All wrong";
        }

        if (totalScore == 7) {
            wronglyAnswered = "0";
        }

        String statsSummary = "Your score: " + totalScore + "\nCorrectly answered: " + totalNumOfCorrectAnswers + "/" + totalQuestions;
        statsSummary += "\nQuestions you got wrong: " + wronglyAnswered ;

        String suggestions;
        if (totalScore == 0 ){
            suggestions = "Uuuh! Better start learning about climate change fast! You scored 0!";
        }
        else if (totalScore > 0 && totalScore <= 3) {
            suggestions = "Not Bad! Nearly half: Thought about getting involved in the topic?";
        }
        else if (totalScore > 3 && totalScore <= 6) {
            suggestions = "Wow you know a lot! How about helping to solve the problem?";
        }
        else {
            suggestions = "You nailed it! I guess you are already part of the project? ;)";
        }

        Toast.makeText(this, suggestions, Toast.LENGTH_SHORT).show();



        return statsSummary;
    }

    public void retake (View view) {
        resetVariable();
        RadioGroup groupOne = (RadioGroup) findViewById(R.id.RadioGroupOne);
        groupOne.clearCheck();
        RadioGroup groupThree = (RadioGroup) findViewById(R.id.RadioGroupThree);
        groupThree.clearCheck();
        RadioGroup groupFour = (RadioGroup) findViewById(R.id.RadioGroupFour);
        groupFour.clearCheck();
        RadioGroup groupFive = (RadioGroup) findViewById(R.id.RadioGroupFive);
        groupFive.clearCheck();
        RadioGroup groupSix = (RadioGroup) findViewById(R.id.RadioGroupSix);
        groupSix.clearCheck();
        RadioGroup groupSeven = (RadioGroup) findViewById(R.id.RadioGroupSeven);
        groupSeven.clearCheck();

        EditText answerTwoField = (EditText) findViewById(R.id.second_answer_field);
        answerTwoField.getText().clear();

        TextView stats = (TextView) findViewById(R.id.stats);
        stats.setText(null);
        LinearLayout statsContainer = (LinearLayout) findViewById(R.id.StatsContainer);
        LinearLayout Start = (LinearLayout) findViewById(R.id.Start);
        statsContainer.setVisibility(View.GONE);
        Start.setVisibility(View.VISIBLE);
    }

    public void sendAsMail (View view) {
        String statsSummary = createStats();
        Intent mailIntent = new Intent (Intent.ACTION_SENDTO);
        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "POW look at this!");
        mailIntent.putExtra(Intent.EXTRA_TEXT, statsSummary);
        if (mailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mailIntent);
        }

    }
}
