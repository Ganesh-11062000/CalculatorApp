package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

// This is used to evaluate math equation in the form of string
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView historyTextView,equationTextView;
    String equation = "";
    String answer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyTextView = (TextView)findViewById(R.id.history);
        equationTextView = (TextView)findViewById(R.id.equation);
    }

    public void createEquation(View view){
        Button btn = (Button)view;
        String str = btn.getText().toString();

        if(str.equals("Clear")){
            equation = "";
        } else if(str.equals("X")){
            if(equation != null && equation.length() > 0){
                equation = equation.substring(0,equation.length()-1);
            }
        } else{
            equation += str;
        }

        equationTextView.setText(equation);
    }

    public void solve(View view) throws ScriptException{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        try{
            //this is where we evaluate the expression
            Double result = (double)engine.eval(equation);

            answer = result.toString();
            historyTextView.setText(answer);
            equation = "";
            equationTextView.setText(equation);

        }catch (Exception e){
            Toast.makeText(this,"Illegal Expression",Toast.LENGTH_SHORT).show();
        }
    }
}