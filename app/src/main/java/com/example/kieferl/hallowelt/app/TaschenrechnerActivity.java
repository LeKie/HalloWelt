package com.example.kieferl.hallowelt.app;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;

import java.util.List;
import java.util.*;
import java.util.Stack;

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
    private Stack<Double> stack;
    private List<String> list;

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
        stack = new Stack<Double>();
        list = new LinkedList<String>();

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
                list.add("(");
            }
        });
        klammerZu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(text + ")");
                ergebnis.setText("");
                list.add(")");
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
                list.add(text);
                list.add("+");
                rechnung.setText(" ");
            }
        });
        subtraktion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "-");
                list.add(text);
                list.add("-");
                rechnung.setText(" ");
            }
        });
        multiplikation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "*");
                list.add(text);
                list.add("*");
                rechnung.setText(" ");
            }
        });
        division.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "/");
                list.add(text);
                list.add("/");
                rechnung.setText(" ");
            }
        });
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //if(rechnung.length() > 0)
                //    rechnung.deleteCharAt(rechnung.length()-1);
                rechnung.setText(" ");
                ergebnis.setText(" ");
                stack.clear();
                list.clear();
            }
        });
        enter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                list.add(text);
                rechnung.setText(" ");
                ergebnis.setText(" ");
            }
        });
        gleich.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                /**for (String element : list) {
                    if (element == "(" || element == ")" || element == "+" || element == "-" || element == "*" || element == "/") {
                        if (element == "(") {
                            stack.push(Double.parseDouble(element));
                        }
                        if (element == "+" || element == "-") {
                            while (stack.peek() != Double.parseDouble("(")&& !stack.empty()) {
                                list.add(Double.toString(stack.pop()));
                            }
                            stack.push(Double.parseDouble(element));
                        }
                        if (element == "*" || element == "/") {
                            while (stack.peek() != Double.parseDouble("(")&&!stack.empty()) {
                                double l = Double.parseDouble(String.valueOf(stack.remove("*")));
                                list.add(String.valueOf(l));
                                double m = Double.parseDouble(String.valueOf(stack.remove("/")));
                                list.add(String.valueOf(m));
                            }

                            stack.push(Double.parseDouble(element));
                        }
                        if (element == ")") {
                            while (stack.peek() != Double.parseDouble("(")) {
                                double l = Double.parseDouble(String.valueOf(stack.remove("*")));
                                list.add(String.valueOf(l));
                                double m = Double.parseDouble(String.valueOf(stack.remove("/")));
                                list.add(String.valueOf(m));
                                double n = Double.parseDouble(String.valueOf(stack.remove("+")));
                                list.add(String.valueOf(n));
                                double o = Double.parseDouble(String.valueOf(stack.remove("-")));
                                list.add(String.valueOf(o));
                            }
                        } else {
                            list.add(element);
                        }
                    }
                }*/
                    for (String element : list) {
                        if (!(element == "+" || element == "-" || element == "*" || element == "/")) {
                            stack.push(Double.parseDouble(element));
                        } else {
                            double rechts = stack.pop();
                            double links = stack.pop();
                            double a = 0.0;
                            if (element == "+") {
                                a = links + rechts;
                            }
                            if (element == "-") {
                                a = links - rechts;
                            }
                            if (element == "*") {
                                a = links * rechts;
                            }
                            if (element == "/") {
                                a = links / rechts;
                            }
                            stack.push(a);
                        }
                    }
                    ergebnis.setText(Double.toString(stack.pop()));
                    stack.clear();
                    // rechnung.setText("ERROR");

            }
        });
    }
}
