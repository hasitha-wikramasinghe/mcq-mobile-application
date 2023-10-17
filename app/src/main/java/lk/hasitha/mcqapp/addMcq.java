package lk.hasitha.mcqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addMcq extends AppCompatActivity {

    Button mcqSave;
    EditText Question, Answer, w1, w2, w3, w4;

    private DBhelper dbhelper;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mcq);

        mcqSave = findViewById(R.id.btnSaveMcq);
        Question = findViewById(R.id.txtaddMcq);
        Answer = findViewById(R.id.txtCorrect);
        w1 = findViewById(R.id.txtWrong1);
        w2 = findViewById(R.id.txtWrong2);
        w3 = findViewById(R.id.txtWrong3);
        w4 = findViewById(R.id.txtWrong4);

        context = this;
        dbhelper = new DBhelper(context);

        mcqSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userQuestion = Question.getText().toString();
                String userAnswer = Answer.getText().toString();
                String userW1 = w1.getText().toString();
                String userW2 = w2.getText().toString();
                String userW3 = w3.getText().toString();
                String userw4 = w4.getText().toString();

                QuestionModelClass questionModelClass = new QuestionModelClass(userQuestion,userAnswer,userW1,userW2,userW3,userw4);
                dbhelper.addQuestion(questionModelClass);
            }
        });
    }
}
