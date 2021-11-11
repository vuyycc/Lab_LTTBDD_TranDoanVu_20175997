package vn.hust.edu.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView workings;
    private TextView results;
    String textWorking = "";
    String textResults = "";
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '×';
    private final char DIVISION = '÷';
    private final char EQU = '=';
    private final char POWER = '^';
    private final char MODULUS = '%';
    private final char SQRT = 'c';
    private final char TREN = 'v';
    private char ACTION;
    private double valDou1 = 0.0;
    private String textStringRe = "";

    private double valDou2 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }


    private void initTextViews() {
        workings = (TextView) findViewById(R.id.workings);
        results = (TextView) findViewById(R.id.results);
    }
    private void setWorkings(String givenValue) {
        textWorking = textWorking + givenValue;
        workings.setText(textWorking);
    }

    private void setResults(String givenValue) {
        textResults = textResults + givenValue;
        results.setText(textResults);
    }

    public void clearonClick(View view) {
        workings.setText("");
        results.setText("0");
        textWorking = "";
        textResults ="";
        valDou1 = 0.0;
        valDou2 = 0.0;
        textStringRe = "";
    }

    public void zeroOnClick(View view) {
        setResults("0");
    }

    public void oneOnClick(View view) {
        setResults("1");
    }

    public void twoOnClick(View view) {
        setResults("2");
    }

    public void threeOnClick(View view) {
        setResults("3");
    }

    public void fourOnClick(View view) {
        setResults("4");
    }

    public void fiveOnClick(View view) {
        setResults("5");
    }

    public void sixOnClick(View view) {
        setResults("6");
    }

    public void sevenOnClick(View view) {
        setResults("7");
    }

    public void eightOnClick(View view) {
        setResults("8");
    }

    public void nhanOnClick(View view) {
        ACTION = MULTIPLICATION;
        valDou1 = Double.parseDouble(textResults);
        textWorking = textResults + "×";
        workings.setText(textWorking);
        results.setText(textResults);
        textResults = "";
    }

    public void nineOnClick(View view) {
        setResults("9");
    }

    public void congOnClick(View view) {
        ACTION = ADDITION;
        valDou1 = Double.parseDouble(textResults);
        textWorking = textResults + " + ";
        workings.setText(textWorking);
        results.setText(textResults);
        textResults = "";
    }


    public void truOnClick(View view) {
        ACTION = SUBTRACTION;
        valDou1 = Double.parseDouble(textResults);
        textWorking = textResults + " - ";
        workings.setText(textWorking);
        results.setText(textResults);
        textResults = "";
    }

    public void ChiaOnClick(View view) {
        ACTION = DIVISION;
        valDou1 = Double.parseDouble(textResults);
        textWorking = textResults + " ÷ ";
        workings.setText(textWorking);
        results.setText(textResults);
        textResults = "";
    }

    public void resultOnClick(View view) {
        if(textWorking.endsWith("=")){
            valDou1 = Double.parseDouble(textResults);
            String textval2 = String.valueOf(valDou2);
            if(textval2.substring(textval2.length() - 2, textval2.length()).equals(".0")) {
                textval2 = textval2.substring(0, textval2.length() - 2);
            }
            workings.setText(textResults+" "+ACTION+" "+textval2 +" =");
        }else {
            valDou2 = Double.parseDouble(textResults);
            setWorkings(" "+textResults + " =");
        }

        operation();
    }

    public void dotOnClick(View view) {
        setResults(".");
    }

    public void powerOnClick(View view) {
        ACTION = POWER;
        valDou1 = Double.parseDouble(textResults);

        if(textStringRe.isEmpty()) {
            textStringRe =  "sqr("+textResults+")";
        } else {
            textStringRe = "sqr("+textStringRe+")";
        }
        textWorking = textStringRe;
        workings.setText(textWorking);
        operation();
    }


    private void operation() {

            switch (ACTION) {
                case ADDITION:
                    valDou1 = valDou1 + valDou2;
                    break;
                case SUBTRACTION:
                    valDou1 = valDou1 - valDou2;
                    break;
                case MULTIPLICATION:
                    valDou1 = valDou1 * valDou2;
                    break;
                case DIVISION:
                    valDou1 = valDou1 / valDou2;
                    break;
                case POWER:
                    valDou1 = valDou1 * valDou1;
                    break;
                case MODULUS:
                    valDou1 = valDou1 % valDou2;
                    break;
                case SQRT:
                    valDou1 = Math.sqrt(valDou1);
                    break;
                case TREN:
                    valDou1 = 1 / valDou1;
                    break;
                case EQU:
                    break;
            }
            textResults = Double.toString(valDou1);

            if(textResults.substring(textResults.length() - 2, textResults.length()).equals(".0")) {
                textResults = textResults.substring(0, textResults.length() - 2);
            }
            results.setText(textResults);

    }

    public void xoaOnClick(View view) {
        if(textWorking.isEmpty()) {
            if(textResults.length() == 1) {
                results.setText("0");
            }else {
                textResults = textResults.substring(0, textResults.length() - 1);
                results.setText(textResults);
            }

        }else {
            textWorking = "";
            workings.setText("");
        }
    }

    public void canHaiOnClick(View view) {
        ACTION = SQRT;
        valDou1 = Double.parseDouble(textResults);
        if(textStringRe.isEmpty()) {
            textStringRe =  "sqrt("+textResults+")";
        } else {
            textStringRe = "sqrt("+textStringRe+")";
        }
        textWorking = textStringRe;
        workings.setText(textWorking);
        operation();
    }

    public void motChiaXOnClick(View view) {
        ACTION = TREN;
        valDou1 = Double.parseDouble(textResults);
        if(textStringRe.isEmpty()) {
            textStringRe =  "1/("+textResults+")";
        } else {
            textStringRe = "1/("+textStringRe+")";
        }
        textWorking = textStringRe;
        workings.setText(textWorking);
        operation();
    }
}