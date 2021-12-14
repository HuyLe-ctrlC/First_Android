package com.example.intent_tuong_minh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    static final int RESULT_CODE = 200;
    EditText edtNum1, edtNum2, edtResult;
    Button buttonBack;
    String s = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        edtResult = findViewById(R.id.edtNum3);
        buttonBack = findViewById(R.id.btnSendBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("DATA");
        String s1 = b.getString("chuoi1");
        String s2 = b.getString("chuoi2");

        edtNum1.setText(s1);
        edtNum2.setText(s2);
        try {
            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);
            s = "" + (n1+n2);
        } catch (Exception e) {
            s = "Nhập sai dữ liệu";
        }

        edtResult.setText(s);
        Intent data = new Intent();
        data.putExtra("KetQua", s);
        setResult(RESULT_CODE, data);
    }
}