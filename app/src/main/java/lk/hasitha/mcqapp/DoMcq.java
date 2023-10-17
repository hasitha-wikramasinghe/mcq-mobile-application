package lk.hasitha.mcqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class DoMcq extends AppCompatActivity {

    List<QuestionModelClass> quesList;
    int score=0;
    int qui=0;
    QuestionModelClass quesClass;

    TextView question;
    RadioGroup radioGrp;
    RadioButton rad1, rad2, rad3, rad4;
    Button NextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_mcq);

        DBhelper db = new DBhelper(this);
        quesList = db.getAllQuestion();
        quesClass = quesList.get(qui);

        question=findViewById(R.id.tviewQuestion);
        radioGrp=findViewById(R.id.radioGroup);
        rad1=findViewById(R.id.radio1);
        rad2=findViewById(R.id.radio2);
        rad3=findViewById(R.id.radio3);
        rad4=findViewById(R.id.radio4);
        NextBtn=findViewById(R.id.btnNext);
        setQuestionView();

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup);
                if (grp.getCheckedRadioButtonId()==-1){
                    return;
                }
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());

                grp.clearCheck();

                if (quesClass.getAnswer().equals(answer.getText())){
                    score++;
                    Log.d("score","Your Score"+score);
                }
                if (qui<5){
                    quesClass=quesList.get(qui);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(DoMcq.this,ResultSheet.class);
                    Bundle b = new Bundle();
                    b.putInt("score",score);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionView() {
        question.setText(quesClass.getQuestion());
        rad1.setText(quesClass.getW1());
        rad2.setText(quesClass.getW2());
        rad3.setText(quesClass.getW3());
        rad4.setText(quesClass.getW4());
        qui++;
    }
}
