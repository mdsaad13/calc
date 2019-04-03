package com.example.calcdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity<button> extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    //private Button b00;
    private Button btadd;
    private Button bsub;
    private Button bmul;
    private Button bdiv;
    private Button bdot;
    private Button bequal;
    private Button bclear;
    private Button bdel;
    private TextView binfo;
    private TextView bresult;
    private final char ADDITION ='+';
    private final char SUBTRACTION ='-';
    private final char MULTIPLICATION ='*';
    private final char DIVISION ='/';
    private final char EQU = 0;
    private double val1= Double.NaN;
    private double val3= Double.NaN;
    private double val2;
    private char ACTION;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"1");

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"2");

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"3");

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"4");

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"5");

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"6");

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"7");

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"8");

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"9");

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+"0");

            }
        });
//        b00.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                binfo.setText(binfo.getText().toString()+"00");
//
//            }
//        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binfo.setText(binfo.getText().toString()+".");

            }
        });


        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=ADDITION;
                bresult.setText(String.valueOf(val1)+"+");
                binfo.setText(null);
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=SUBTRACTION;
                bresult.setText(String.valueOf(val1)+"-");
                binfo.setText(null);
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=MULTIPLICATION;
                bresult.setText(String.valueOf(val1)+"*");
                binfo.setText(null);
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=DIVISION;
                bresult.setText(String.valueOf(val1)+"/");
                binfo.setText(null);
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=EQU;
                bresult.setText(bresult.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                binfo.setText(null);

            }
        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1=Double.NaN;
                val2=Double.NaN;
                binfo.setText(null);
                bresult.setText(null);

            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binfo.getText().length() > 0){
                    CharSequence name = binfo.getText().toString();
                    binfo.setText(name.subSequence(0,name.length()-1));
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    binfo.setText(null);
                    bresult.setText(null);
                }

            }
        });


    }
    private void setupUI() {
        b1 = (Button)findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b0 = (Button) findViewById(R.id.btn0);
       // b00 = (Button) findViewById(R.id.btn00);
        btadd = (Button) findViewById(R.id.btnadd) ;
        bsub = (Button) findViewById(R.id.btnminus);
        bmul = (Button) findViewById(R.id.btnmul);
        bdiv = (Button) findViewById(R.id.btndiv);
        bdot = (Button) findViewById(R.id.btndot);
        bclear = (Button) findViewById(R.id.btnc);
        bdel = (Button) findViewById(R.id.btndel);
        bequal = (Button) findViewById(R.id.btnequal);
        binfo = (TextView) findViewById(R.id.RController);
        bresult = (TextView) findViewById(R.id.Rres);

    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(binfo.getText().toString());

            switch (ACTION){
                case ADDITION:
                    val1=val1+val2;
                    break;
                case SUBTRACTION:
                    val1=val1-val2;
                    break;
                case MULTIPLICATION:
                    val1=val1*val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                    break;
                case EQU:
                    break;
            }
        }
        else{
            val1=Double.parseDouble(binfo.getText().toString());

        }
    }
}
