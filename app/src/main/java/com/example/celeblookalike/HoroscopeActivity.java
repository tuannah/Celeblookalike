package com.example.celeblookalike;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HoroscopeActivity extends AppCompatActivity {

    TextView txtName, txtHoroscopeResult;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        txtName = findViewById(R.id.txtName);
        txtHoroscopeResult = findViewById(R.id.txtHoroscopeResult);
        btnBack = findViewById(R.id.btnBack);

        // Lấy thông tin từ Intent
        String name = getIntent().getStringExtra("name");
        int lifePath = getIntent().getIntExtra("lifePath", 0);

        // Hiển thị tên
        txtName.setText("Tên: " + name);

        // Tính kết quả tử vi dựa trên Life Path Number
        String horoscopeResult = getHoroscopeResult(lifePath);
        txtHoroscopeResult.setText("Kết quả tử vi: " + horoscopeResult);

        // Quay lại MainActivity khi bấm nút
        btnBack.setOnClickListener(view -> finish());
    }

    // Hàm trả về kết quả tử vi dựa trên Life Path Number
    private String getHoroscopeResult(int lifePath) {
        String result = "";
        switch (lifePath) {
            case 1:
                result = "Bạn là người độc lập, quyết đoán và có khả năng lãnh đạo xuất sắc.";
                break;
            case 2:
                result = "Bạn có khả năng giao tiếp tốt, luôn hòa hợp và mang lại sự bình yên.";
                break;
            case 3:
                result = "Bạn rất sáng tạo, vui vẻ và có khả năng giao tiếp khéo léo.";
                break;
            case 4:
                result = "Bạn là người cần cù, kiên định và thích làm việc có tổ chức.";
                break;
            case 5:
                result = "Bạn là người yêu thích sự tự do, khám phá và thích thay đổi.";
                break;
            case 6:
                result = "Bạn là người chăm sóc, yêu thương và có khả năng kết nối với mọi người.";
                break;
            case 7:
                result = "Bạn rất phân tích, tìm tòi và có khả năng suy nghĩ sâu sắc.";
                break;
            case 8:
                result = "Bạn có mục tiêu rõ ràng, tham vọng và có khả năng đạt được thành công lớn.";
                break;
            case 9:
                result = "Bạn là người nhân ái, quan tâm đến mọi người và có tầm nhìn xa.";
                break;
            // Thêm các trường hợp khác từ 10 đến 33 nếu cần
            default:
                result = "Không có kết quả tử vi cho số này.";
        }
        return result;
    }
}
