package com.example.celeblookalike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtName;
    private DatePicker datePicker;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các thành phần giao diện
        edtName = findViewById(R.id.edtName);
        datePicker = findViewById(R.id.datePicker);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Xử lý sự kiện nhấn nút "Xem số chủ đạo"
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy tên từ EditText
                String name = edtName.getText().toString().trim();

                // Lấy ngày, tháng, năm từ DatePicker
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1; // Tháng bắt đầu từ 0 nên cần +1
                int year = datePicker.getYear();
                String birthDate = String.format("%02d/%02d/%d", day, month, year);

                // Tính số chủ đạo
                int lifePathNumber = getLifePathNumber(day, month, year);

                // Chuyển sang HomeActivity và gửi dữ liệu
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("birthDate", birthDate);
                intent.putExtra("lifePath", lifePathNumber);
                startActivity(intent);
                finish(); // Đóng MainActivity để không quay lại
            }
        });
    }

    // Hàm tính số chủ đạo từ ngày tháng năm sinh
    private int getLifePathNumber(int day, int month, int year) {
        int total = sumDigits(day) + sumDigits(month) + sumDigits(year);
        // Lặp lại cho đến khi tổng là số có một chữ số hoặc là số Master (11, 22, 33)
        while (total > 9 && total != 11 && total != 22 && total != 33) {
            total = sumDigits(total);
        }
        return total;
    }

    // Hàm tính tổng các chữ số của một số
    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}