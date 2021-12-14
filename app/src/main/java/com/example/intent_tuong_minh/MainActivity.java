package com.example.intent_tuong_minh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_NUM = 100;
    Button buttonOK;
    EditText edtNum1, edtNum2;
    String s = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOK = findViewById(R.id.buttonOK);
        edtNum1 = findViewById(R.id.editTextNum1);
        edtNum2 = findViewById(R.id.editTextNum2);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNum1 = edtNum1.getText().toString();
                String sNum2 = edtNum2.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("chuoi1", sNum1);
                bundle.putString("chuoi2", sNum2);

                intent.putExtra("DATA", bundle);
                startActivityForResult(intent, REQUEST_NUM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_NUM && resultCode == SecondActivity.RESULT_CODE){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thông báo kết quả!");
            String s = data.getStringExtra("KetQua");
            builder.setMessage(s);
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}