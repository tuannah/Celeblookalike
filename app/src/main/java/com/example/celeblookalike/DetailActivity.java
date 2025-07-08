package com.example.celeblookalike;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetail = findViewById(R.id.txtDetail);

        int lifePath = getIntent().getIntExtra("lifePath", 0);
        txtDetail.setText(getLifePathDescription(lifePath));
    }

    private String getLifePathDescription(int number) {
        switch (number) {
            case 1:
                return "Số 1 đại diện cho lãnh đạo, độc lập và tiên phong.";
            case 2:
                return "Số 2 đại diện cho sự hòa giải, nhạy cảm và hợp tác.";
            case 3:
                return "Số 3 biểu trưng cho sáng tạo, giao tiếp và nghệ thuật.";
            case 6:
                return "Số 6 mang ý nghĩa của tình yêu, trách nhiệm và gia đình.";
            default:
                return "Chưa có thông tin cho số chủ đạo này.";
        }
    }
}
