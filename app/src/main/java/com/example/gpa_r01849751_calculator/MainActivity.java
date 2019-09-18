package com.example.gpa_r01849751_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double[] gpaList = new double[5];
    double finalGPA;
    TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (button.getText() == "Clear Form")
                {
                    EditText gpaInput1 = findViewById(R.id.class_1_GPA);
                    gpaInput1.getText().clear();

                    EditText gpaInput2 = findViewById(R.id.class_2_GPA);
                    gpaInput2.getText().clear();

                    EditText gpaInput3 = findViewById(R.id.class_3_GPA);
                    gpaInput3.getText().clear();

                    EditText gpaInput4 = findViewById(R.id.class_4_GPA);
                    gpaInput4.getText().clear();

                    EditText gpaInput5 = findViewById(R.id.class_5_GPA);
                    gpaInput5.getText().clear();

                    button.setText("Compute GPA");
                    TextView finalGPA = findViewById(R.id.finalDisplay);
                    finalGPA.setText("");
                    View view = findViewById(R.id.layout);
                    View root = view.getRootView();
                    root.setBackgroundColor(Color.WHITE);
                }
                else {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(button.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

                    mTv = findViewById(R.id.finalDisplay);
                    EditText gpaInput1 = findViewById(R.id.class_1_GPA);
                    String value1 = gpaInput1.getText().toString();
                    int gpa1;
                    try {
                        gpa1 = Integer.parseInt(value1);
                    }
                    catch(NumberFormatException ex) {
                        gpaInput1.setError("This cannot be empty");
                        return;
                    }
                    gpaList[0] = gpa1;


                    EditText gpaInput2 = findViewById(R.id.class_2_GPA);
                    String value2 = gpaInput2.getText().toString();
                    int gpa2;
                    try {
                        gpa2 = Integer.parseInt(value2);
                    }
                    catch(NumberFormatException ex) {
                        gpaInput2.setError("This cannot be empty");
                        return;
                    }
                    gpaList[1] = gpa2;

                    EditText gpaInput3 = findViewById(R.id.class_3_GPA);
                    String value3 = gpaInput3.getText().toString();
                    int gpa3;
                    try {
                        gpa3 = Integer.parseInt(value3);
                    }
                    catch(NumberFormatException ex) {
                        gpaInput3.setError("This cannot be empty");
                        return;
                    }
                    gpaList[2] = gpa3;

                    EditText gpaInput4 = findViewById(R.id.class_4_GPA);
                    String value4 = gpaInput4.getText().toString();
                    int gpa4;
                    try {
                        gpa4 = Integer.parseInt(value4);
                    }
                    catch(NumberFormatException ex) {
                        gpaInput4.setError("This cannot be empty");
                        return;
                    }
                    gpaList[3] = gpa4;

                    EditText gpaInput5 = findViewById(R.id.class_5_GPA);
                    String value5 = gpaInput5.getText().toString();
                    int gpa5;
                    try {
                        gpa5 = Integer.parseInt(value5);
                    }
                    catch(NumberFormatException ex) {
                        gpaInput5.setError("This cannot be empty");
                        return;
                    }
                    gpaList[4] = gpa5;

                    for (int i = 0; i < 5; i++) {
                        if (gpaList[i] > 100 || gpaList[i] < 0) {
                            Toast.makeText(getApplicationContext(), "Invalid GPA input (> 100 or < 0)", Toast.LENGTH_LONG).show();
                            mTv.setText("");
                        } else {
                            finalGPA = ((gpa1 + gpa2 + gpa3 + gpa4 + gpa5) / 5);
                            String finalGPAText = finalGPA + "";
                            mTv.setText(finalGPAText);
                        }
                    }
                    button.setText("Clear Form");

                    if (finalGPA < 60)
                    {
                        View view = findViewById(R.id.layout);
                        View root = view.getRootView();
                        root.setBackgroundColor(Color.RED);
                    } else if (finalGPA > 60 && finalGPA < 80) {
                        View view = findViewById(R.id.layout);
                        View root = view.getRootView();
                        root.setBackgroundColor(Color.YELLOW);
                    } else {
                        View view = findViewById(R.id.layout);
                        View root = view.getRootView();
                        root.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        });
    }
}