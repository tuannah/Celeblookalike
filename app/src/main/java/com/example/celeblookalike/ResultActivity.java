package com.example.celeblookalike;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class ResultActivity extends AppCompatActivity {

    TextView txtWelcome, txtLifePath;
    LinearLayout layoutCelebrities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtWelcome = findViewById(R.id.txtWelcome);
        txtLifePath = findViewById(R.id.txtLifePath);
        layoutCelebrities = findViewById(R.id.layoutCelebrities);

        String name = getIntent().getStringExtra("name");
        int lifePath = getIntent().getIntExtra("lifePath", 0);

        txtWelcome.setText("Xin chào, " + name);
        txtLifePath.setText("Số chủ đạo của bạn là: " + lifePath);

        List<Celebrity> celebrities = getCelebritiesByLifePath(lifePath);

        if (celebrities.isEmpty()) {
            TextView txtEmpty = new TextView(this);
            txtEmpty.setText("Chưa có dữ liệu người nổi tiếng cho số " + lifePath);
            layoutCelebrities.addView(txtEmpty);
        } else {
            for (Celebrity celeb : celebrities) {
                // Image
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(400, 400);
                imageParams.setMargins(0, 24, 0, 8);
                imageView.setLayoutParams(imageParams);
                imageView.setImageResource(celeb.getImageResId());

                // Tên
                TextView nameView = new TextView(this);
                nameView.setText(celeb.getName());
                nameView.setTextSize(18);
                nameView.setTypeface(null, Typeface.BOLD);

                // Mô tả
                TextView descView = new TextView(this);
                descView.setText(celeb.getDescription());
                descView.setTextSize(14);
                descView.setPadding(0, 0, 0, 16);

                layoutCelebrities.addView(imageView);
                layoutCelebrities.addView(nameView);
                layoutCelebrities.addView(descView);
            }
        }

        // Nút xem chi tiết
        Button btnDetails = new Button(this);
        btnDetails.setText("XEM CHI TIẾT");
        btnDetails.setAllCaps(false);
        btnDetails.setPadding(0, 32, 0, 0);
        layoutCelebrities.addView(btnDetails);

        btnDetails.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, DetailActivity.class);
            intent.putExtra("lifePath", lifePath);
            startActivity(intent);
        });
    }

    // Class người nổi tiếng
    private static class Celebrity {
        private final String name;
        private final int imageResId;
        private final String description;

        public Celebrity(String name, int imageResId, String description) {
            this.name = name;
            this.imageResId = imageResId;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getDescription() {
            return description;
        }
    }

    // Danh sách người nổi tiếng theo số chủ đạo
    private List<Celebrity> getCelebritiesByLifePath(int lifePath) {
        Map<Integer, List<Celebrity>> celebrityMap = new HashMap<>();

        celebrityMap.put(6, Arrays.asList(
                new Celebrity("Steve Jobs", R.drawable.stevejobs, "Nhà sáng lập Apple, biểu tượng đổi mới.")

        ));

        celebrityMap.put(2, Arrays.asList(
                new Celebrity("Barack Obama", R.drawable.stevejobs, "Tổng thống Mỹ, biểu tượng của sự hợp tác."),
                new Celebrity("Madonna", R.drawable.stevejobs, "Nữ hoàng nhạc pop, đầy sáng tạo.")
        ));

        celebrityMap.put(3, Arrays.asList(
                new Celebrity("David Beckham", R.drawable.stevejobs, "Cầu thủ bóng đá nổi tiếng, quyến rũ."),
                new Celebrity("Adele", R.drawable.stevejobs, "Ca sĩ tài năng với giọng ca truyền cảm.")
        ));

        return celebrityMap.getOrDefault(lifePath, new ArrayList<>());
    }
}
