package vn.hust.edu.myform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText HoTen, MSSV, NgaySinh, DiaChi, Sdt, Email;
    String HoTen_S, MSSV_S, NgaySinh_S, DiaChi_S, Gt_S, Sdt_S, Email_S;
    CheckBox checkTT, checkDL, checkAN, checkAccept;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HoTen = findViewById(R.id.editHoten);

        HoTen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                HoTen_S = s.toString();
            }
        });
        MSSV = findViewById(R.id.editTextMSSV);
        MSSV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                MSSV_S = s.toString();
            }
        });
        NgaySinh = findViewById(R.id.editTextDate);
        NgaySinh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                NgaySinh_S = s.toString();
            }
        });

        DiaChi = findViewById(R.id.editTextTextPostalAddress);
        DiaChi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                DiaChi_S = s.toString();
            }
        });
        Sdt = findViewById(R.id.editTextPhone);
        Sdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Sdt_S = s.toString();
            }
        });
        Email = findViewById(R.id.editTextTextEmailAddress);
        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Email_S = s.toString();
            }
        });

        RadioGroup rg = findViewById(R.id.radioGroup);
        int id = rg.getCheckedRadioButtonId();
        if (id == R.id.radio_Nam){
            Gt_S = "Nam";
        }else if (id == R.id.radio_Nu) {
            Gt_S = "Nữ";
        }

        btn_submit = findViewById(R.id.button_submit);

    }

    public void submit(View view) {
        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_SHORT;
        if(HoTen_S != null && MSSV_S != null && NgaySinh_S != null && Sdt_S != null && Email_S != null){
            if( Email_S.length() < 10){
                text = "Email phải có đuôi @gmail.com";
            }else if(!Email_S.substring(Email_S.length() - 10, Email_S.length()).equals("@gmail.com")) {
               text = "Email sai định dạng";
            }else {
                text = "Submitted successfully.";
            }
        } else {
            text = "Trường (*) không được để trống";
        }
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void clickAccept(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if(checked){
            btn_submit.setEnabled(true);
        } else {
            btn_submit.setEnabled(false);
        }
    }
}