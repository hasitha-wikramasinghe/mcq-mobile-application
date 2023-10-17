package lk.hasitha.mcqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   Button mcqAdd, domcq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcqAdd=findViewById(R.id.btnaddMCQ);
        mcqAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),addMcq.class);
                startActivity(intent);
            }
        });

        domcq=findViewById(R.id.btndoMCQ);
        domcq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DoMcq.class);
                startActivity(intent);
            }
        });
    }
}
