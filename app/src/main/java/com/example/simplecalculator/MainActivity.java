package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private enum Operator {none, add, minus, multiply, divide};
    private double data1 = 0.0, data2 = 0.0;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void appendToText(View view, String text){
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        if (eText.getText().toString() == "0"){
            eText.setText(text);
        }
        else {
            eText.setText(eText.getText() + text);
        }
    }

    private void setOperator(View view, Operator operator){
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        optr = operator;
        eText.setText("");
    }

    public void btn00Click(View view){
        appendToText(view, "0");
    }
    public void btn01Click(View view){
        appendToText(view, "1");
    }
    public void btn02Click(View view){
        appendToText(view, "2");
    }
    public void btn03Click(View view){
        appendToText(view, "3");
    }
    public void btn04Click(View view){
        appendToText(view, "4");
    }
    public void btn05Click(View view){
        appendToText(view, "5");
    }
    public void btn06Click(View view){
        appendToText(view, "6");
    }
    public void btn07Click(View view){
        appendToText(view, "7");
    }
    public void btn08Click(View view){
        appendToText(view, "8");
    }
    public void btn09Click(View view){
        appendToText(view, "9");
    }
    public void btnDotClick(View view){
        appendToText(view, ".");
    }
    public void btnClearClick(View view){
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText("");
        data1=0.0;
        data2=0.0;
    }
    public void btnAddClick(View view){
        setOperator(view, Operator.add);
    }
    public void btnMinusClick(View view){
        setOperator(view, Operator.minus);
    }
    public void btnDivideClick(View view){
        setOperator(view, Operator.divide);
    }
    public void btnMultiplyClick(View view){
        setOperator(view, Operator.multiply);
    }
    public void btnResult(View view){
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        data2 = Double.parseDouble(eText.getText().toString());
        double result = 0.0;
        switch (optr){
            case add:
                result = data1 + data2;
                System.out.println("Adding "+ Double.toString(data1) + " and "+ Double.toString(data2));
                break;
            case minus:
                result = data1 - data2;
                break;
            case divide:
                result = data1 / data2;
                break;
            case multiply:
                result = data1 * data2;
                break;
            case none:
                result = data1;
                break;
        }
        data1=result;
        eText.setText(Double.toString(result));
    }
}