package com.example.kieferl.hallowelt.app;

    import android.support.v7.app.ActionBarActivity;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.app.Activity;
    import android.os.Bundle;

    import java.util.Arrays;
    import java.util.List;
    import java.util.ArrayList;
    import android.view.View.OnClickListener;
/**
  Created by kieferl on 05.04.2016.
 **/

public class TaschenrechnerActivity extends ActionBarActivity {

    private TextView rechnung;
    private Button klammerAuf;
    private Button klammerZu;
    private Button modulo;
    private Button clear;
    private Button addition;
    private Button subtraktion;
    private Button multiplikation;
    private Button division;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button komma;
    private Button enter;
    private TextView nachricht;
    private TextView ergebnis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taschenrechner);

        rechnung = (TextView) findViewById(R.id.rechnung);
        klammerAuf = (Button) findViewById(R.id.klammerAuf);
        klammerZu = (Button) findViewById(R.id.klammerZu);
        modulo = (Button) findViewById(R.id.modulo);
        clear = (Button) findViewById(R.id.clear);
        addition = (Button) findViewById(R.id.addition);
        subtraktion = (Button) findViewById(R.id.subtraktion);
        multiplikation = (Button) findViewById(R.id.multiplikation);
        division = (Button) findViewById(R.id.division);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        komma = (Button) findViewById(R.id.komma);
        enter = (Button) findViewById(R.id.enter);
        nachricht = (TextView) findViewById(R.id.nachricht);
        ergebnis = (TextView) findViewById(R.id.ergebnis);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text+"0");
            }
        });
        klammerAuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "(");
            }
        });
        klammerZu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + ")");
            }
        });
        komma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text+".");
            }
        });
        modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "%");
            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "+");
            }
        });
        subtraktion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text+"-");
            }
        });
        multiplikation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "*");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text+"/");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                /**if(rechnung.length() > 0)
                    rechnung.deleteCharAt(rechnung.length()-1);*/
                rechnung.setText(" ");
            }
        });         // möglicherweise noch verändern


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText("ERROR");
             //   List<String> listZahlen = new ArrayList<String>();
            //    Arrays.asList( "+-*/".split( " " ));

               // List<String> listOperatoren = new ArrayList<String>();
           //     Arrays.asList("0 1 2 3 4 5 6 7 8 9".replaceAll(Szring." " ));
            }
        });
    }
}

