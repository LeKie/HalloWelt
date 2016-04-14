package com.example.kieferl.hallowelt.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import java.util.List;
import java.util.*;
import java.util.Stack;

import java.lang.*;
import android.view.View.OnClickListener;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static java.lang.Double.*;
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
    private Button pi;
    private Button e;
    private Button fakultät;
    private Button potenz;
    private Button wurzel;
    private Button sin;
    private Button cos;
    private Button tan;
    private Button ln;
    private Button log;
    private TextView nachricht;
    private TextView ergebnis;
    private Stack<String> umwandlung;
    private Stack<String> umwandlung2;
    private Stack<Double> stack;
    private List<String> list1;
    private List<String> list2;
    private Pair<Button,Drawable> previousClickedButton;

    private GoogleApiClient client;
    private static GoogleApiClient client2;

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
        pi = (Button) findViewById(R.id.pi);
        e = (Button) findViewById(R.id.e);
        fakultät = (Button) findViewById(R.id.fakultät);
        potenz = (Button) findViewById(R.id.potenz);
        wurzel = (Button) findViewById(R.id.wurzel);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        ln = (Button) findViewById(R.id.ln);
        log = (Button) findViewById(R.id.log);
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
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            pi.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    rechnung.setText("3.14159265359");
                    ergebnis.setText("");
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            e.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    rechnung.setText("2.71828182846");
                    ergebnis.setText("");
                }
            });
        }
        klammerAuf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "(");
                ergebnis.setText(" ");
                rechnung.setText("");
                list1.add("(");
                changeColor5(klammerAuf);
                changeColor4(klammerAuf);
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
                changeColor3(klammerZu);
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
                list1.add(text);
                if (!list1.isEmpty()) {
                    changeColor1(addition);
                    list1.add("+");
                    rechnung.setText("");
                }
            }
        });
        subtraktion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "-");
                list1.add(text);
                if (!list1.isEmpty()) {
                    changeColor1(subtraktion);
                    list1.add("-");
                    rechnung.setText("");
                }
            }
        });
        multiplikation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "*");
                list1.add(text);
                if (!list1.isEmpty()) {
                    changeColor1(multiplikation);
                    list1.add("*");
                    rechnung.setText("");
                }
            }
        });
        division.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                //rechnung.setText(text + "/");
                list1.add(text);
                if (!list1.isEmpty()) {
                    changeColor1(division);
                    list1.add("/");
                    rechnung.setText("");
                }
            }
        });
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            potenz.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add(text);
                    list1.add("^");
                    rechnung.setText("");
                    changeColor2(potenz);
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            wurzel.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add("W");
                    Toast.makeText(TaschenrechnerActivity.this, "Radikand in Klammern eingeben", Toast.LENGTH_SHORT).show();
                    changeColor2(wurzel);
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fakultät.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add(text);
                    list1.add("!");
                    rechnung.setText("");
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            sin.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add("sin");
                    Toast.makeText(TaschenrechnerActivity.this, "Winkelgröße in Klammern eingeben", Toast.LENGTH_SHORT).show();
                    changeColor2(sin);
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            cos.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add("cos");
                    Toast.makeText(TaschenrechnerActivity.this, "Winkelgröße in Klammern eingeben", Toast.LENGTH_SHORT).show();
                    changeColor2(cos);
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tan.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add("tan");
                    Toast.makeText(TaschenrechnerActivity.this, "Winkelgröße in Klammern eingeben", Toast.LENGTH_SHORT).show();
                    changeColor2(tan);
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ln.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add("ln");
                    Toast.makeText(TaschenrechnerActivity.this, "Wert in Klammern eingeben", Toast.LENGTH_SHORT).show();
                    changeColor2(ln);
                }
            });
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            log.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = rechnung.getText().toString();
                    list1.add("log");
                    Toast.makeText(TaschenrechnerActivity.this, "Wert in Klammern eingeben", Toast.LENGTH_SHORT).show();
                    changeColor2(log);
                }
            });
        }
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
                previousClickedButton.first.setBackground(previousClickedButton.second);
            }
        });
        backspace.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                StringBuffer buff = new StringBuffer(rechnung.getText());
                if (rechnung.length() > 0) {
                    buff.deleteCharAt(rechnung.length() - 1);
                    rechnung.setText(buff);
                }
            }
        });
        gleich.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = rechnung.getText().toString();
                previousClickedButton.first.setBackground(previousClickedButton.second);
                list1.add(text);
                rechnung.setText(" ");
                for (String element : list1) {
                    if (element == "(" || element == ")" || element == "+" || element == "-" || element == "*" || element == "/" || element == "^" || element == "W" || element == "!" || element == "sin" || element == "cos" || element == "tan" || element == "ln" || element == "log" || element == ")" || element == "") {
                        if (element == "(") {
                            umwandlung.push(element);
                        } else if (element == "+" || element == "-") {
                            while (!umwandlung.empty() && umwandlung.peek() != ("(")) {
                                list2.add(umwandlung.pop());
                            }
                            umwandlung.push(element);
                        } else if (element == "*" || element == "/") {
                            while (!umwandlung.empty() && umwandlung.peek() != ("(")) {
                                if (umwandlung.peek() == "*" || umwandlung.peek() == "/" || umwandlung.peek() == "^") {
                                    list2.add(umwandlung.pop());
                                } else if (umwandlung.peek() == "+" || umwandlung.peek() == "-") {
                                    umwandlung2.push(umwandlung.pop());
                                }
                            }
                            while (!umwandlung2.empty()) {
                                umwandlung.push(umwandlung2.pop());
                            }
                            umwandlung.push(element);
                        } else if (element == "^") {
                            while (!umwandlung.empty() && umwandlung.peek() != ("(")) {
                                if (umwandlung.peek() == "^") {
                                    list2.add(umwandlung.pop());
                                } else if (umwandlung.peek() == "+" || umwandlung.peek() == "-") {
                                    umwandlung2.push(umwandlung.pop());
                                } else if (umwandlung.peek() == "*" || umwandlung.peek() == "/") {
                                    umwandlung2.push(umwandlung.pop());
                                }
                            }
                            while (!umwandlung2.empty()) {
                                umwandlung.push(umwandlung2.pop());
                            }
                            umwandlung.push(element);
                        } else if (element == "W" || element == "sin" || element == "cos" || element == "tan" || element == "ln" || element == "log") {
                            umwandlung.push(element);
                        } else if (element == "!") {
                            list2.add(element);
                        } else if (element == ")") {
                            while (umwandlung.peek() != ("(")) {
                                list2.add(umwandlung.pop());
                            }
                            if (umwandlung.peek() == ("(")) {
                                int l = umwandlung.search("W");
                                int m = umwandlung.search("sin");
                                int n = umwandlung.search("cos");
                                int o = umwandlung.search("tan");
                                int p = umwandlung.search("ln");
                                int q = umwandlung.search("log");
                                if (l == 2) {
                                    list2.add("W");
                                    umwandlung.remove("W");
                                } else if (m == 2) {
                                    list2.add("sin");
                                    umwandlung.remove("sin");
                                } else if (n == 2) {
                                    list2.add("cos");
                                    umwandlung.remove("cos");
                                } else if (o == 2) {
                                    list2.add("tan");
                                    umwandlung.remove("tan");
                                } else if (p == 2) {
                                    list2.add("ln");
                                    umwandlung.remove("ln");
                                } else if (q == 2) {
                                    list2.add("log");
                                    umwandlung.remove("log");
                                }
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
                    if (umwandlung.peek() == "+" || umwandlung.peek() == "-" || umwandlung.peek() == "*" || umwandlung.peek() == "/" || umwandlung.peek() == "^" || umwandlung.peek() == "W" || umwandlung.peek() == "!" || umwandlung.peek() == "sin" || umwandlung.peek() == "cos" || umwandlung.peek() == "tan" || umwandlung.peek() == "ln" || umwandlung.peek() == "log") {
                        list2.add(umwandlung.pop());
                    } else if (umwandlung.peek() == "(") {
                        umwandlung.pop();
                    }
                }
                for (String element : list2) {
                    if (!(element == "+" || element == "-" || element == "*" || element == "/" || element == "^" || element == "W" || element == "!" || element == "sin" || element == "cos" || element == "tan" || element == "ln" || element == "log")) {
                        stack.push(parseDouble(element));
                    } else if (element == "+" || element == "-" || element == "*" || element == "/" || element == "^") {
                        double rechts = stack.pop();
                        double links = stack.pop();
                        double a = 0.0;
                        if (element == "+") {
                            a = links + rechts;
                        } else if (element == "-") {
                            a = links - rechts;
                        } else if (element == "*") {
                            a = links * rechts;
                        } else if (element == "/") {
                            a = links / rechts;
                        } else if (element == "^") {
                            a = Math.pow(links, rechts);
                        }
                        stack.push(a);
                    } else if (element == "W") {
                        double radikand = stack.pop();
                        double a = 0.0;
                        a = Math.sqrt(radikand);
                        stack.push(a);
                    } else if (element == "sin") {
                        double sin = stack.pop();
                        double a = 0.0;
                        a = Math.sin(sin);
                        stack.push(a);
                    } else if (element == "cos") {
                        double cos = stack.pop();
                        double a = 0.0;
                        a = Math.cos(cos);
                        stack.push(a);
                    } else if (element == "tan") {
                        double tan = stack.pop();
                        double a = 0.0;
                        a = Math.tan(tan);
                        stack.push(a);
                    } else if (element == "ln") {
                        double ln = stack.pop();
                        double a = 0.0;
                        a = Math.log(ln);
                        stack.push(a);
                    } else if (element == "log") {
                        double log = stack.pop();
                        double a = 0.0;
                        a = Math.log10(log);
                        stack.push(a);
                    } else if (element == "!") {
                        double popedDouble = stack.pop();
                        long factvar = (long) popedDouble;
                        stack.push(Double.parseDouble(fact(factvar) + ""));
                    }
                }
                ergebnis.setText(Double.toString(stack.pop()));
                list1.clear();
                //rechnung.setText("ERROR");
            }
        });
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public long fact(long n) {
        if (n == 1) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }
    public void changeColor1(Button currentButton) {
        if (previousClickedButton != null) {
            previousClickedButton.first.setBackground(previousClickedButton.second);
            String text = (String) rechnung.getText();
            if (list1.lastIndexOf(")") != list1.size()-1) {
                if (currentButton == addition && text == " " || text == "") {
                    list1.remove(list1.size() - 1);
                } else if (currentButton == subtraktion && text == " " || text == "") {
                    list1.remove(list1.size() - 1);
                } else if (currentButton == multiplikation && text == " " || text == "") {
                    list1.remove(list1.size() - 1);
                } else if (currentButton == division && text == " " || text == "") {
                    list1.remove(list1.size() - 1);
                }
            }
        }
            previousClickedButton = Pair.create(currentButton, currentButton.getBackground());
            currentButton.setBackground(getDrawable(R.drawable.button_change2));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            potenz.setBackground(getDrawable(R.drawable.button_border3));
        }
    }
    public void changeColor2 (Button buttonAn) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonAn.setBackground(getDrawable(R.drawable.button_change1));
            if (klammerZu.isPressed()) {
                buttonAn.setBackground(getDrawable(R.drawable.button_border3));
            }
        }
    }
    public void changeColor3 (Button alle) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            sin.setBackground(getDrawable(R.drawable.button_border3));
            cos.setBackground(getDrawable(R.drawable.button_border3));
            tan.setBackground(getDrawable(R.drawable.button_border3));
            ln.setBackground(getDrawable(R.drawable.button_border3));
            log.setBackground(getDrawable(R.drawable.button_border3));
            wurzel.setBackground(getDrawable(R.drawable.button_border3));
            potenz.setBackground(getDrawable(R.drawable.button_border3));
            fakultät.setBackground(getDrawable(R.drawable.button_border3));
            klammerAuf.setBackground(getDrawable(R.drawable.button_border3));
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            klammerAuf.setBackground(getDrawable(R.drawable.button_border2));
        }
        addition.setBackground(getDrawable(R.drawable.button_border2));
        subtraktion.setBackground(getDrawable(R.drawable.button_border2));
        multiplikation.setBackground(getDrawable(R.drawable.button_border2));
        division.setBackground(getDrawable(R.drawable.button_border2));
    }
    public void changeColor4 (Button operatoren) {
        addition.setBackground(getDrawable(R.drawable.button_border2));
        subtraktion.setBackground(getDrawable(R.drawable.button_border2));
        multiplikation.setBackground(getDrawable(R.drawable.button_border2));
        division.setBackground(getDrawable(R.drawable.button_border2));
    }
    public void changeColor5 (Button klammerAuf) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            klammerAuf.setBackground(getDrawable(R.drawable.button_change1));
            if (klammerZu.isPressed()) {
                klammerAuf.setBackground(getDrawable(R.drawable.button_border3));
            }
        } else {
            klammerAuf.setBackground(getDrawable(R.drawable.button_change2));
            if (klammerZu.isPressed()) {
                klammerAuf.setBackground(getDrawable(R.drawable.button_border2));
            }
        }
    }


    @Override
    public void onStart() {
       super.onStart();

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
