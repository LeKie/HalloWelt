package com.example.kieferl.hallowelt.app;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;

import java.nio.Buffer;
import java.util.List;
import java.util.*;
import java.util.Stack;

import java.lang.*;

import android.view.View.OnClickListener;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.graphics.Color.*;

/**
 * Created by kieferl on 05.04.2016.
 **/

public class TaschenrechnerActivity extends Activity {

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
    private Button backspace;
    private Button gleich;
    private TextView nachricht;
    private TextView ergebnis;
    private Stack<String> umwandlung;
    private Stack<String> umwandlung2;
    private Stack<Double> stack;
    private List<String> list1;
    private List<String> list2;

    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

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
        backspace = (Button) findViewById(R.id.backspace);
        gleich = (Button) findViewById(R.id.gleich);
        nachricht = (TextView) findViewById(R.id.nachricht);
        ergebnis = (TextView) findViewById(R.id.ergebnis);
        stack = new Stack<Double>();
        umwandlung = new Stack<String>();
        umwandlung2 = new Stack<String>();
        list1 = new LinkedList<String>();
        list2 = new LinkedList<String>();

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
                //rechnung.setText(text + "(");
                ergebnis.setText(" ");
                list1.add("(");
                rechnung.setText("");
            }
        });
        klammerZu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + ")");
                ergebnis.setText(" ");
                list1.add(text);
                list1.add(")");
                rechnung.setText("");
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
                if (text != "" && text != " ") {
                    list1.add(text);
                }
                list1.add("+");
                rechnung.setText("");
            }
        });
        subtraktion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "-");
                if (text != "" && text != " ") {
                    list1.add(text);
                }
                list1.add("-");
                rechnung.setText("");
            }
        });
        multiplikation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "*");
                if (text != "" && text != " ") {
                    list1.add(text);
                }
                list1.add("*");
                rechnung.setText("");
            }
        });
        division.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "/");
                if (text != "" && text != " ") {
                    list1.add(text);
                }
                list1.add("/");
                rechnung.setText("");
            }
        });
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                rechnung.setText(" ");
                ergebnis.setText(" ");
                stack.clear();
                umwandlung.clear();
                list1.clear();
                list2.clear();
            }
        });
        backspace.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                StringBuffer buff = new StringBuffer(rechnung.getText());
                if (rechnung.length() > 0) {
                    buff.deleteCharAt(rechnung.length() -1);
                    rechnung.setText(buff);
                }
            }
        });
        gleich.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                list1.add(text);
                rechnung.setText(" ");
                for (String element : list1) {
                    if (element == "(" || element == ")" || element == "+" || element == "-" || element == "*" || element == "/" || element == "") {
                        if (element == "(") {
                            umwandlung.push(element);
                        } else if (element == "+" || element == "-") {
                            while (!umwandlung.empty() && umwandlung.peek() != ("(")) {
                                list2.add(umwandlung.pop());
                            }
                            umwandlung.push(element);
                        } else if (element == "*" || element == "/") {
                            while (!umwandlung.empty() && umwandlung.peek() != ("(")) {
                                if (umwandlung.peek() == "*" || umwandlung.peek() == "/") {
                                    list2.add(umwandlung.pop());
                                } else if (umwandlung.peek() == "+" || umwandlung.peek() == "-") {
                                    umwandlung2.push(umwandlung.pop());
                            }
                            }
                            while (!umwandlung2.empty()) {
                                umwandlung.push(umwandlung2.pop());
                            }
                            umwandlung.push(element);
                        } else if (element == ")") {
                            while (umwandlung.peek() != ("(")) {
                                list2.add(umwandlung.pop());
                            }
                        } else if (element == "") {
                            list1.remove("");
                        } else if (element == " ") {
                            list1.remove(" ");
                        }
                    } else {
                        list2.add(element);
                    }
                }
                while (!umwandlung.empty()) {
                    if (umwandlung.peek() == "+" || umwandlung.peek() == "-" || umwandlung.peek() == "*" || umwandlung.peek() == "/") {
                        list2.add(umwandlung.pop());
                    } else if (umwandlung.peek() == "(") {
                        umwandlung.pop();
                    }
                }
                for (String element : list2) {
                    if (!(element == "+" || element == "-" || element == "*" || element == "/")) {
                        stack.push(Double.parseDouble(element));
                    } else {
                        double rechts = stack.pop();
                        double links = stack.pop();
                        double a = 0.0;
                        if (element == "+") {
                            a = links + rechts;
                        } else if (element == "-") {
                            a = links - rechts;
                        } else if (element == "*") {
                            a = links * rechts;
                        }else if (element == "/") {
                            a = links / rechts;
                        }
                        stack.push(a);
                    }
                }
                ergebnis.setText(Double.toString(stack.pop()));
                list1.clear();
                //rechnung.setText("ERROR");
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Taschenrechner Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.kieferl.hallowelt.app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Taschenrechner Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.kieferl.hallowelt.app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }
}
