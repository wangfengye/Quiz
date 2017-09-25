package com.ascend.wangfeng.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup result1Btn;
    private RadioGroup result2Btn;
    private EditText result3Edit;
    private CheckBox result41Box;
    private CheckBox result42Box;
    private CheckBox result43Box;
    private Button mRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        result1Btn = (RadioGroup) findViewById(R.id.q1_result);
        result2Btn = (RadioGroup) findViewById(R.id.q2_result);
        result3Edit = (EditText) findViewById(R.id.q3_result);
        result41Box = (CheckBox) findViewById(R.id.q4_result_1);
        result42Box = (CheckBox) findViewById(R.id.q4_result_2);
        result43Box = (CheckBox) findViewById(R.id.q4_result_3);

        mRate = (Button) findViewById(R.id.submit);
        mRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate();
            }
        });
    }

    /**
     * 评分
     */
    private void rate() {
        //总分
        int score = 0;
        StringBuilder builder = new StringBuilder();
        //Q1
        int result1 = result1Btn.getCheckedRadioButtonId();
        if (result1 == R.id.q1_result_2) {
            score += 2;
            builder.append(getString(R.string.q_1)).append(getString(R.string.q_true));
        } else {
            builder.append(getString(R.string.q_1)).append(getString(R.string.q_false));
        }
        //Q2
        int result2 = result2Btn.getCheckedRadioButtonId();
        if (result2 == R.id.q2_result_2) {
            score += 2;
            builder.append(getString(R.string.q_2)).append(getString(R.string.q_true));
        } else {
            builder.append(getString(R.string.q_2)).append(getString(R.string.q_false));
        }
        //Q3
        if (getString(R.string.q3_result).equals(result3Edit.getText().toString())) {
            score += 2;
            builder.append(getString(R.string.q_3)).append(getString(R.string.q_true));
        } else {
            builder.append(getString(R.string.q_3)).append(getString(R.string.q_false));
        }
        //Q4
        if (result41Box.isChecked() && result42Box.isChecked() && !result43Box.isChecked()) {
            score += 4;
            builder.append(getString(R.string.q_4)).append(getString(R.string.q_true));
        } else {
            builder.append(getString(R.string.q_4)).append(getString(R.string.q_false));
        }
        builder.append(getString(R.string.total_score)).append(String.valueOf(score));
        Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show();
    }
}
