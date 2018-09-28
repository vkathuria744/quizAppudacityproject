package quizapp.com.quizapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    RadioGroup radioGroup1, radioGroup2;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    EditText et5_1;
    Button button;

    int ans;
    int score;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = (RadioGroup) findViewById(R.id.rg2);
        radioGroup2 = (RadioGroup) findViewById(R.id.rg3);
        checkBox1 = (CheckBox) findViewById(R.id.cb1_1);
        checkBox2 = (CheckBox) findViewById(R.id.cb1_2);
        checkBox3 = (CheckBox) findViewById(R.id.cb4_1);
        checkBox4 = (CheckBox) findViewById(R.id.cb4_2);
        checkBox5 = (CheckBox) findViewById(R.id.cb4_3);
        answer = (EditText) findViewById(R.id.et5_1);
        button = (Button) findViewById(R.id.check_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result(view);
            }
        });

    }


    public void result(View view){
        int selected2 = radioGroup1.getCheckedRadioButtonId();
        int selected3 = radioGroup2.getCheckedRadioButtonId();
        int finalScore = 0;
        ArrayList<String> result = new ArrayList<String>();
        EditText name = findViewById(R.id.Name_field);
        if(name.getText().toString().equals(""))
        {
            Toast.makeText(this,"Please enter your name!",Toast.LENGTH_SHORT).show();
            return;
        }
        //-- Question1
        if(checkBox1.isChecked())
        {
            finalScore++; result.add("Correct");
        }
        else
        {
            result.add("Incorrect");
        }

        //-- Question 2
        if(selected2==(R.id.r2_1))
        {
            finalScore++; result.add("Correct");
        }
        else
        {
            result.add("Incorrect");
        }

        //-- Question 3
        if(selected3==(R.id.r3_2))
        {
            finalScore++; result.add("Correct");
        }
        else
        {
            result.add("Incorrect");
        }

        //-- Question 4
        if(checkBox3.isChecked() && checkBox4.isChecked() && !checkBox5.isChecked())
        {
            finalScore++; result.add("Correct");
        }
        else
        {
            result.add("Incorrect");
        }
        Log.d("test"," "+answer.getText());
        //--Question 5
        if(answer.getText().toString().equals("3"))
        {
            finalScore++; result.add("Correct");
        }
        else
        {
            result.add("Incorrect");
        }

        String finalAnswer = "Question 1 : "+result.get(0) + "\n Question 2 : " + result.get(1) + "\n Question 3 : " + result.get(2)+ "\n Question 4 : " + result.get(3)+ "\n Question 5 : " + result.get(4) + "\n Final Score : "+finalScore;

        Toast.makeText(getBaseContext(),"Hello "+ name.getText().toString()+", \n Your test scores are : \n" + finalAnswer,Toast.LENGTH_LONG).show();
    }
}
