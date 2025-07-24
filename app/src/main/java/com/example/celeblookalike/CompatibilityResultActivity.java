package com.example.celeblookalike;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CompatibilityResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibility_result);

        TextView txtName1 = findViewById(R.id.txtName1);
        TextView txtBirthDate1 = findViewById(R.id.txtBirthDate1);
        TextView txtLifePath1 = findViewById(R.id.txtLifePath1);
        TextView txtName2 = findViewById(R.id.txtName2);
        TextView txtBirthDate2 = findViewById(R.id.txtBirthDate2);
        TextView txtLifePath2 = findViewById(R.id.txtLifePath2);
        TextView txtCompatLevel = findViewById(R.id.txtCompatLevel);
        TextView txtCompatDesc = findViewById(R.id.txtCompatDesc);

        String name1 = getIntent().getStringExtra("name1");
        String birthDate1 = getIntent().getStringExtra("birthDate1");
        int lifePath1 = getIntent().getIntExtra("lifePath1", 0);
        String name2 = getIntent().getStringExtra("name2");
        String birthDate2 = getIntent().getStringExtra("birthDate2");
        int lifePath2 = getIntent().getIntExtra("lifePath2", 0);
        String compatLevel = getIntent().getStringExtra("compatLevel");
        String compatDesc = getIntent().getStringExtra("compatDesc");

        txtName1.setText("Tên: " + name1);
        txtBirthDate1.setText("Ngày sinh: " + birthDate1);
        txtLifePath1.setText("Số chủ đạo: " + lifePath1);
        txtName2.setText("Tên: " + name2);
        txtBirthDate2.setText("Ngày sinh: " + birthDate2);
        txtLifePath2.setText("Số chủ đạo: " + lifePath2);
        txtCompatLevel.setText("Mức độ tương hợp: " + compatLevel);
        txtCompatDesc.setText(compatDesc);

        android.widget.Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }
} 