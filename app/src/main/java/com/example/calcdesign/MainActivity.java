package com.example.calcdesign;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;

public class MainActivity<button> extends AppCompatActivity {

//    DBHelper db;
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
    private Button btadd;
    private Button bsub;
    private Button bmul;
    private Button bdiv;
    private Button bdot;
//    private Button bmod;
    private Button bequal;
    private Button bclear;
    private Button bdel;
//    private Button bhis;
    private TextView bresult;
//    private TextView binfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Database link
//        db = new DBHelper(this);

//        AllData();
//        ViewAll();

        setupUI();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"4");

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"5");

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"6");

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"7");

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"8");

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"9");

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"0");

            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+".");

            }
        });
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bresult.setText(bresult.getText().toString()+"+");
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(bresult.getText().toString()+"-");

            }
        });
//        bmod.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (bresult == null || bresult.length() == 0)
//                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
//                else
//                    bresult.setText(bresult.getText().toString() + "%");
//            }
//        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bresult == null || bresult.length() == 0)
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                else
                    bresult.setText(bresult.getText().toString() + "*");
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bresult == null || bresult.length() == 0)
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                else
                    bresult.setText(bresult.getText().toString()+"/");

            }
        });


        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bresult == null || bresult.length() == 0)
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                else{
//                    binfo.setText(bresult.getText().toString());

                    bresult = (TextView) findViewById(R.id.Rres);
                    // Read the expression
                    String txt = bresult.getText().toString();
                    // Create an Expression (A class from exp4j library)
                    Expression expression = new ExpressionBuilder(txt).build();
                    // Calculate the result and display
                    double result = expression.evaluate();

                    bresult.setText(Double.toString(result));
//                    ValidationResult res = result.validate(false);

                }
            }

        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bresult.setText(null);

            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bresult.getText().length() > 0){
                    CharSequence name = bresult.getText().toString();
                    bresult.setText(name.subSequence(0,name.length()-1));
                }
                else {
                    bresult.setText(null);
                }

            }
        });


    }

//    private void AllData() {
//
//        db.insertData(binfo.getText().toString(),
//                bresult.getText().toString());
//
//    }

//    private void ViewAll(){
//        bhis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res = db.getAllData();
//                if (res.getCount()==0){
//                    showMessage("ERROR","Nothing Found..!!!");
//                }
//                StringBuffer buffer = new StringBuffer();
//                while (res.moveToNext()){
//                    buffer.append("ID : " + res.getString(0)+ "\n");
//                    buffer.append("Input : " + res.getString(1)+ "\n");
//                    buffer.append("Output : " + res.getString(2)+ "\n");
//                }
//                showMessage("Student Details :",buffer.toString());
//
//            }
//        });
//    }

//    private void showMessage(String title, String message) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setCancelable(true);
//            builder.setTitle(title);
//            builder.setMessage(message);
//            builder.show();
//
//    }


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
//        bmod = (Button) findViewById(R.id.btnmod);
        bclear = (Button) findViewById(R.id.btnc);
        bdel = (Button) findViewById(R.id.btndel);
        bequal = (Button) findViewById(R.id.btnequal);
//        bhis = (Button) findViewById(R.id.btnhis);
        bresult = (TextView) findViewById(R.id.Rres);
//        binfo = (TextView) findViewById(R.id.Rinfo);

    }


}