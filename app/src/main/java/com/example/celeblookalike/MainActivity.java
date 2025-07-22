package com.example.celeblookalike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    DatePicker datePicker;
    Button btnSubmit;
    Button btnPersonalDevelopment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        datePicker = findViewById(R.id.datePicker);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnPersonalDevelopment = findViewById(R.id.btnPersonalDevelopment);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1; // tháng bắt đầu từ 0
                int year = datePicker.getYear();
                String birthDate = String.format("%02d/%02d/%d", day, month, year);

                int lifePathNumber = getLifePathNumber(day, month, year);

                // Chuyển sang ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("birthDate", birthDate);
                intent.putExtra("lifePath", lifePathNumber);
                startActivity(intent);



            }

        });

        btnPersonalDevelopment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                String birthDate = String.format("%02d/%02d/%d", day, month, year);
                Intent intent = new Intent(MainActivity.this, PersonalDevelopmentActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("birthDate", birthDate);
                startActivity(intent);
            }
        });

    }

    private int getLifePathNumber(int day, int month, int year) {
        int total = sumDigits(day) + sumDigits(month) + sumDigits(year);
        while (total > 9 && total != 11 && total != 22 && total != 33) {
            total = sumDigits(total);
        }
        return total;
    }

    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
