package vn.hust.edu.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button btnCount;
    private Button btnZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        btnCount = (Button) findViewById(R.id.button_count);
        btnZero = (Button) findViewById(R.id.button_zero);
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null)
            btnZero.setBackgroundColor(0xFFeB6B34);
            mShowCount.setText(Integer.toString(mCount));
        if (mCount % 2 != 0){
            view.setBackgroundColor(0xFFCF6BEC);
        } else if(mCount % 2 == 0) {
            view.setBackgroundColor(0xFF39F107);
        }
    }

    public void setZero(View view){
        view.setBackgroundColor(0xFF808080);
        btnCount.setBackgroundColor(0xFF4E2FFF);
        if(mShowCount != null){
            mShowCount.setText("0");
            mCount = 0;
        }
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}