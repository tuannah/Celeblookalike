package com.example.celeblookalike;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private LinearLayout layoutCelebrities;
    private TextView txtWelcome, txtLifePath, txtCelebrities;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize UI elements with null checks
        drawerLayout = findViewById(R.id.drawer_menu);
        NavigationView navigationView = findViewById(R.id.nav_view);
        layoutCelebrities = findViewById(R.id.layoutCelebrities);
        txtWelcome = findViewById(R.id.txtWelcome);
        txtLifePath = findViewById(R.id.txtLifePath);
        txtCelebrities = findViewById(R.id.txtCelebrities); // Thêm khai báo txtCelebrities
        btnBack = findViewById(R.id.btnBack);




        // Handle navigation item clicks if navigationView exists
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(item -> {
                Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                if (drawerLayout != null) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            });
        }

        // Get user data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String birthDate = intent.getStringExtra("birthDate");
        int lifePathNumber = intent.getIntExtra("lifePath", 0);

        // Display user profile and celebrities
        if (txtWelcome != null && txtLifePath != null && name != null && !name.isEmpty()) {
            txtWelcome.setText("Xin chào, " + name);
            txtLifePath.setText("Số chủ đạo của bạn là: " + lifePathNumber);

            if (txtCelebrities != null) {
                txtCelebrities.setText("Người nổi tiếng giống bạn:");
            }

            if (layoutCelebrities != null) {
                List<Celebrity> celebrities = getCelebritiesByLifePath(lifePathNumber);

                if (celebrities.isEmpty()) {
                    TextView txtEmpty = new TextView(this);
                    txtEmpty.setText("Chưa có dữ liệu người nổi tiếng cho số " + lifePathNumber);
                    layoutCelebrities.addView(txtEmpty);
                } else {
                    for (Celebrity celeb : celebrities) {
                        if (layoutCelebrities != null) {
                            // Image
                            ImageView imageView = new ImageView(this);
                            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(700, 500);
                            imageParams.setMargins(0, 24, 0, 8);
                            imageView.setLayoutParams(imageParams);
                            try {
                                imageView.setImageResource(celeb.getImageResId()); // Kiểm tra tài nguyên
                            } catch (Exception e) {
                                imageView.setImageResource(android.R.drawable.ic_menu_gallery); // Fallback nếu thiếu
                            }

                            // Mô tả
                            TextView descView = new TextView(this);
                            descView.setText(celeb.getDescription());
                            descView.setTextSize(14);
                            descView.setPadding(0, 0, 0, 16);

                            layoutCelebrities.addView(imageView);
                            layoutCelebrities.addView(descView);
                        }
                    }
                }
            }
        } else if (txtWelcome != null && txtLifePath != null) {
            txtWelcome.setText("Xin chào, Khách");
            txtLifePath.setText("Chưa có số chủ đạo.");
        }

        // Button back listener
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle != null && toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Class người nổi tiếng (giữ nguyên)
    private static class Celebrity {
        private final String name;
        private final int imageResId;
        private final String description;

        public Celebrity(String name, int imageResId, String description) {
            this.name = name;
            this.imageResId = imageResId;
            this.description = description;
        }

        public String getName() { return name; }
        public int getImageResId() { return imageResId; }
        public String getDescription() { return description; }
    }

    // Danh sách người nổi tiếng theo số chủ đạo (giữ nguyên)
    private List<Celebrity> getCelebritiesByLifePath(int lifePath) {
        Map<Integer, List<Celebrity>> celebrityMap = new HashMap<>();
        celebrityMap.put(1, List.of(new Celebrity("Phạm Nhật Vượng", R.drawable.phamnhatvuong1, "Phạm Nhật Vượng (sinh ngày 5 tháng 8 năm 1968) là một nam doanh nhân kiêm tỷ phú người Việt Nam.")));
        celebrityMap.put(2, List.of(new Celebrity("Emma Watson", R.drawable.emmawatson2, "Emma Charlotte Duerre Watson (sinh ngày 15 tháng 4 năm 1990) là một nữ diễn viên, người mẫu kiêm nhà hoạt động xã hội người Anh.")));
        celebrityMap.put(3, List.of(new Celebrity("Thành Long", R.drawable.thanhlong3, "Thành Long (sinh ngày 7 tháng 4 năm 1954) là một nam diễn viên, chỉ đạo võ thuật kiêm nhà làm phim người Hồng Kông.")));
        celebrityMap.put(4, List.of(new Celebrity("Bill Gates", R.drawable.billgate4, "Bill Gates (sinh ngày 28 tháng 10 năm 1955) là một nam doanh nhân, nhà từ thiện kiêm tác giả người Mỹ.")));
        celebrityMap.put(5, List.of(new Celebrity("Mark Zuckerberg", R.drawable.markzuckerbug5, "Mark Elliot Zuckerberg (sinh ngày 14 tháng 5 năm 1984) là nhà đồng sáng lập của Meta (Facebook).")));
        celebrityMap.put(6, List.of(new Celebrity("Jeff Bezos", R.drawable.jeffbezos6, "Jeff Bezos (sinh ngày 12 tháng 1 năm 1964) là người sáng lập và chủ tịch Amazon.")));
        celebrityMap.put(7, List.of(new Celebrity("Elon Musk", R.drawable.elonmusk7, "Elon Reeve Musk (sinh 28 tháng 6 năm 1971) là doanh nhân nổi tiếng với Tesla và SpaceX.")));
        celebrityMap.put(8, List.of(new Celebrity("Sơn Tùng M-TP", R.drawable.sontungmtp8, "Nguyễn Thanh Tùng (sinh ngày 5 tháng 7 năm 1994) là ca sĩ nổi tiếng người Việt Nam.")));
        celebrityMap.put(9, List.of(new Celebrity("Võ Nguyên Giáp", R.drawable.daituongvonguyengiap9, "Võ Nguyên Giáp (25 tháng 8 năm 1911 – 4 tháng 10 năm 2013) là nhà lãnh đạo quân sự và chính trị gia Việt Nam.")));
        celebrityMap.put(11, List.of(new Celebrity("Barack Obama", R.drawable.obama11, "Barack Obama (sinh ngày 4/8/1961) là tổng thống thứ 44 của Hoa Kỳ.")));

        return celebrityMap.getOrDefault(lifePath, new ArrayList<>());
    }
}