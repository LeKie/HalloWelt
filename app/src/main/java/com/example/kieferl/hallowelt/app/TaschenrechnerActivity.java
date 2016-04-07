package com.example.kieferl.hallowelt.app;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;

import java.util.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import android.view.View.OnClickListener;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by kieferl on 05.04.2016.
 **/

public class TaschenrechnerActivity extends ActionBarActivity {

    private TextView rechnung;
    private Button klammerAuf;
    private Button klammerZu;
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
    private Button gleich;
    private TextView nachricht;
    private TextView ergebnis;
    private Stack<String> stack;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taschenrechner);

        rechnung = (TextView) findViewById(R.id.rechnung);
        klammerAuf = (Button) findViewById(R.id.klammerAuf);
        klammerZu = (Button) findViewById(R.id.klammerZu);
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
        gleich = (Button) findViewById(R.id.gleich);
        nachricht = (TextView) findViewById(R.id.nachricht);
        ergebnis = (TextView) findViewById(R.id.ergebnis);
        stack = new Stack<String>();

        one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "1");
                ergebnis.setText("");
            }
        });
        two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "2");
                ergebnis.setText("");
            }
        });
        three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "3");
                ergebnis.setText("");
            }
        });
        four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "4");
                ergebnis.setText("");
            }
        });
        five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "5");
                ergebnis.setText("");
            }
        });
        six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "6");
                ergebnis.setText("");
            }
        });
        seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "7");
                ergebnis.setText("");
            }
        });
        eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "8");
                ergebnis.setText("");
            }
        });
        nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "9");
                ergebnis.setText("");
            }
        });
        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "0");
            }
        });
        klammerAuf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + "(");
                ergebnis.setText("");
            }
        });
        klammerZu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + ")");
                ergebnis.setText("");

            }
        });
        komma.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + ".");
            }
        });
        addition.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "+");
                if (!stack.empty()) {
                    stack.push(text);
                    stack.push("+");

                }
                rechnung.setText("");
            }
        });
        subtraktion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "-");
                if (!stack.empty()) {
                    stack.push(text);
                    stack.push("-");

                }
                rechnung.setText("");
            }
        });
        multiplikation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "*");
                if (!stack.empty()) {
                    stack.push(text);
                    stack.push("*");
                }
                rechnung.setText("");
            }
        });
        division.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "/");
                if (!stack.empty()) {
                    stack.push(text);
                    stack.push("/");
                }
                rechnung.setText("");
            }
        });
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //if(rechnung.length() > 0)
                //    rechnung.deleteCharAt(rechnung.length()-1);
                rechnung.setText("");
                ergebnis.setText("");
                stack.clear();
            }
        });
        enter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                stack.push(text);
                rechnung.setText("");
                ergebnis.setText("");
            }
        });
        gleich.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = 0.0;
                double b = 0.0;
                double c = 0.0;
                double d = 0.0;
                double e = 0.0;
                double f = 0.0;
                double i;

                while (stack.size()>1) {
                    String l = stack.pop();
                    double m = Double.parseDouble(stack.pop());
                    if (!(stack.peek() == "+" || stack.peek() == "-" || stack.peek() == "*" || stack.peek() == "/")) {
                        double n = Double.parseDouble(stack.pop());
                        if (l == "+") {
                            a = n + m;
                        }
                        if (l == "-") {
                            a = n - m;
                        }
                        if (l == "*") {
                            a = n * m;
                        }
                        if (l == "/") {
                            a = n / m;
                        }
                        stack.push(Double.toString(a));
                        if (stack.size() > 1) {
                            stack.push("+");
                        }
                    } else {
                        String o = stack.pop();
                        double p = Double.parseDouble(stack.pop());
                        if (!(stack.peek() == "+" || stack.peek() == "-" || stack.peek() == "*" || stack.peek() == "/")) {
                            double q = Double.parseDouble(stack.pop());
                            if (o == "+") {
                                b = q + p;
                            }
                            if (o == "-") {
                                b = q - p;
                            }
                            if (o == "*") {
                                b = q * p;
                            }
                            if (o == "/") {
                                b = q / p;
                            }
                        }
                            stack.push(Double.toString(b));
                            stack.push(Double.toString(m));
                            stack.push(l);
                        } /**else {
                            String r = stack.pop();
                            double s = Double.parseDouble(stack.pop());
                            if (!(stack.peek() == "+" || stack.peek() == "-" || stack.peek() == "*" || stack.peek() == "/")) {
                                double t = Double.parseDouble(stack.pop());
                                if (r == "+") {
                                    c = t + s;
                                }
                                if (r == "-") {
                                    c = t - s;
                                }
                                if (r == "*") {
                                    c = t * s;
                                }
                                if (r == "/") {
                                    c = t / s;
                                }
                                //stack.push(Double.toString(c));
                                stack.push(Double.toString(p));
                                stack.push(o);
                            }
                        }
                    }
                    String g = stack.pop();
                    double h = Double.parseDouble(stack.pop());
                    if (!(stack.peek() == "+" || stack.peek() == "-" || stack.peek() == "*" || stack.peek() == "/")) {
                        double j = Double.parseDouble(stack.pop());
                        if (g == "+") {
                            d = j + h;
                        }
                        if (g == "-") {
                            d = j - h;
                        }
                        if (g == "*") {
                            d = j * h;
                        }
                        if (g == "/") {
                            d = j / h;
                        }
                        // stack.push(Double.toString(d));
                        if (stack.size() > 1) {
                            stack.push("+");
                        }
                    } else {
                        String k = stack.pop();
                        double u = Double.parseDouble(stack.pop());
                        if (!(stack.peek() == "+" || stack.peek() == "-" || stack.peek() == "*" || stack.peek() == "/")) {
                            double w = Double.parseDouble(stack.pop());
                            if (k == "+") {
                                e = w + u;
                            }
                            if (k == "-") {
                                e = w - u;
                            }
                            if (k == "*") {
                                e = w * u;
                            }
                            if (k == "/") {
                                e = w / u;
                            }

                            //stack.push(Double.toString(e));
                            stack.push(Double.toString(h));
                            stack.push(g);
                        } else {
                            String x = stack.pop();
                            double y = Double.parseDouble(stack.pop());
                            if (!(stack.peek() == "+" || stack.peek() == "-" || stack.peek() == "*" || stack.peek() == "/")) {
                                double z = Double.parseDouble(stack.pop());
                                if (x == "+") {
                                    f = z + y;
                                }
                                if (x == "-") {
                                    f = z - y;
                                }
                                if (x == "*") {
                                    f = z * y;
                                }
                                if (x == "/") {
                                    f = z / y;
                                }
                                //stack.push(Double.toString(f));
                                stack.push(Double.toString(u));
                                stack.push(k);
                            }
                        }
                    }
                }*/
                }
                    // i = a + b + c + d + e + f;
                    ergebnis.setText(Double.toString(a));


            }
            // rechnung.setText("ERROR");

        });
    }
}


