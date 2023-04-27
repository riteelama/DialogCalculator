package com.chapter5;

import static java.lang.Math.round;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class DialogActivity extends AppCompatActivity {
    MaterialButton calcBtn;
    MaterialButton calcAreaTriangle;
    MaterialButton calcSimpleInterest;
    MaterialButton calcAreaCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        calcBtn = findViewById(R.id.CalculateMBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        calcSimpleInterest = findViewById(R.id.simpleInterestMbtn);
        calcSimpleInterest.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ShowSimpleDialog();
            }
        });

        calcAreaTriangle = findViewById(R.id.calculateTriangleArea);
        calcAreaTriangle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ShowTriangleAreaDialog();
            }
        });

        calcAreaCircle = findViewById(R.id.calculateCircleArea);
        calcAreaCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCircleAreaDialog();
            }
        });
    }

    private void showDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("Caluclate Number");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog,null);
        builder.setView(view);

        EditText firstEt = view.findViewById(R.id.FirstEt);
        EditText secondEt = view.findViewById(R.id.SecondEt);
        MaterialButton calcBtn = view.findViewById(R.id.CalculateBtn);
        TextView resultTv = view.findViewById(R.id.resultTv);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int first, second, result;
                first = Integer.parseInt(firstEt.getText().toString());
                second = Integer.parseInt(secondEt.getText().toString());
                result = first + second;

                resultTv.setText(String.valueOf(result));
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void ShowSimpleDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.simple_interest_custom_dialog,null);
        builder.setView(view);

        EditText principleEt = view.findViewById(R.id.principleEt);
        EditText timeEt = view.findViewById(R.id.timeEt);
        EditText rateEt = view.findViewById(R.id.rateEt);
        MaterialButton siMbtn = view.findViewById(R.id.sIMBtn);
        TextView simpleResultTv = view.findViewById(R.id.sIResultTv);

        siMbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double principle, rate, time, result;
                principle = Double.parseDouble(principleEt.getText().toString());
                rate = Double.parseDouble(rateEt.getText().toString());
                time = Double.parseDouble(timeEt.getText().toString());
                result = (principle*rate*time)/100;
                simpleResultTv.setText(String.valueOf((result)));
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void ShowTriangleAreaDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.area_triangle_custom_dialog,null);
        builder.setView(view);

        EditText breadthEt = view.findViewById(R.id.BreadthEt);
        EditText lenghthEt = view.findViewById(R.id.LenghtEt);
        MaterialButton triangleCalc = view.findViewById(R.id.CalculateAreaTriangleBtn);
        TextView resultTriangleTv = view.findViewById(R.id.resultAreaTriangleTv);

        triangleCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double b, h, a;
                b = Double.parseDouble(breadthEt.getText().toString());
                h = Double.parseDouble(lenghthEt.getText().toString());

                a = (b*h)/2;
                resultTriangleTv.setText(String.valueOf(a));
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void ShowCircleAreaDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.area_circle_custom_dialog,null);
        builder.setView(view);

        EditText radiusEt = view.findViewById(R.id.RadiusEt);
        MaterialButton circleCalcBtn = view.findViewById(R.id.CalculateAreaCircleBtn);
        TextView circleAreaTv = view.findViewById(R.id.resultAreaCircleTv);

        circleCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double r, pi = Math.PI, a;
                r = Double.parseDouble(radiusEt.getText().toString());

                a = pi*r*r;
                circleAreaTv.setText(String.valueOf(a));
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}