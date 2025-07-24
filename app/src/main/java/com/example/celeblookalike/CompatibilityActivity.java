package com.example.celeblookalike;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class CompatibilityActivity extends AppCompatActivity {
    String name1, birthDate1;
    EditText edtName2;
    DatePicker datePicker2;
    Button btnCheckCompatibility;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibility);

        name1 = getIntent().getStringExtra("name1");
        birthDate1 = getIntent().getStringExtra("birthDate1");
        edtName2 = findViewById(R.id.edtName2);
        datePicker2 = findViewById(R.id.datePicker2);
        btnCheckCompatibility = findViewById(R.id.btnCheckCompatibility);
        txtResult = findViewById(R.id.txtResult);

        btnCheckCompatibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name2 = edtName2.getText().toString().trim();
                int day1, month1, year1;
                String[] parts = birthDate1.split("/");
                day1 = Integer.parseInt(parts[0]);
                month1 = Integer.parseInt(parts[1]);
                year1 = Integer.parseInt(parts[2]);
                int day2 = datePicker2.getDayOfMonth();
                int month2 = datePicker2.getMonth() + 1;
                int year2 = datePicker2.getYear();
                int lifePath1 = getLifePathNumber(day1, month1, year1);
                int lifePath2 = getLifePathNumber(day2, month2, year2);
                String[] compat = getCompatibilityDetail(lifePath1, lifePath2);
                // Chuyển sang màn hình kết quả chi tiết
                Intent intent = new Intent(CompatibilityActivity.this, CompatibilityResultActivity.class);
                intent.putExtra("name1", name1);
                intent.putExtra("birthDate1", birthDate1);
                intent.putExtra("lifePath1", lifePath1);
                intent.putExtra("name2", name2);
                intent.putExtra("birthDate2", String.format("%02d/%02d/%d", day2, month2, year2));
                intent.putExtra("lifePath2", lifePath2);
                intent.putExtra("compatLevel", compat[0]);
                intent.putExtra("compatDesc", compat[1]);
                startActivity(intent);
            }
        });
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

    // Thay thế checkCompatibility bằng getCompatibilityDetail trả về cả mức độ và mô tả
    private String[] getCompatibilityDetail(int n1, int n2) {
        if (n1 == n2) return new String[]{"Rất hợp (cùng chí hướng, dễ đồng cảm)", "Hai bạn có cùng số chủ đạo nên rất dễ đồng cảm, chia sẻ mục tiêu và quan điểm sống. Sự tương đồng này giúp mối quan hệ bền vững và ít mâu thuẫn."};
        if ((n1 == 2 && n2 == 8) || (n1 == 8 && n2 == 2)) return new String[]{"Hợp (bổ sung cho nhau: 2-8)", "Số 2 và 8 là cặp bổ sung tuyệt vời: 2 nhạy cảm, biết lắng nghe, còn 8 mạnh mẽ, quyết đoán. Hai bạn có thể hỗ trợ nhau phát triển cá nhân và sự nghiệp."};
        if ((n1 == 3 && n2 == 6) || (n1 == 6 && n2 == 3)) return new String[]{"Hợp (bổ sung cho nhau: 3-6)", "Số 3 sáng tạo, vui vẻ, số 6 giàu tình cảm, biết chăm sóc. Sự kết hợp này tạo nên một mối quan hệ hài hòa, nhiều niềm vui và sự sẻ chia."};
        if ((n1 == 4 && n2 == 7) || (n1 == 7 && n2 == 4)) return new String[]{"Hợp (bổ sung cho nhau: 4-7)", "Số 4 thực tế, ổn định, số 7 sâu sắc, thích khám phá. Hai bạn có thể học hỏi lẫn nhau, cân bằng giữa thực tế và tinh thần."};
        if ((n1 == 1 && n2 == 9) || (n1 == 9 && n2 == 1)) return new String[]{"Hợp (bổ sung cho nhau: 1-9)", "Số 1 lãnh đạo, chủ động, số 9 vị tha, bao dung. Sự kết hợp này giúp cả hai phát triển toàn diện, bổ sung điểm mạnh cho nhau."};
        return new String[]{"Bình thường hoặc cần nỗ lực thấu hiểu lẫn nhau", "Hai bạn có số chủ đạo khác biệt, cần nhiều sự thấu hiểu, chia sẻ và tôn trọng để xây dựng mối quan hệ bền vững."};
    }
} 