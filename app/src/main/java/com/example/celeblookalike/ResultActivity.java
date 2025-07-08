package com.example.celeblookalike;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class ResultActivity extends AppCompatActivity {

    TextView txtWelcome, txtLifePath;
    LinearLayout layoutCelebrities;

    @SuppressLint("SetTextI18n")
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
                LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(700, 500);
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

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish(); // Quay lại màn trước (ResultActivity)
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

        celebrityMap.put(1, List.of(
                new Celebrity("Phạm Nhật Vượng", R.drawable.phamnhatvuong1, "Phạm Nhật Vượng " +
                        "(sinh ngày 5 tháng 8 năm 1968) là một nam doanh nhân kiêm tỷ phú người Việt Nam. Ông được biết đến là người sáng lập ra tập đoàn Vingroup.")

        ));

        celebrityMap.put(2, List.of(
                new Celebrity("Emma Charlotte Duerre Watson", R.drawable.emmawatson2, "Emma Charlotte Duerre Watson; " +
                        "(sinh ngày 15 tháng 4 năm 1990) là một nữ diễn viên, người mẫu kiêm nhà hoạt động xã hội người Anh. Sinh ra ở Paris và lớn lên tại Oxfordshire, Emma theo học tại Trường Brown và theo học khóa đào tạo diễn viên tại chi nhánh Oxford của trường Nghệ thuật Sân khấu Stagecoach.")

        ));

        celebrityMap.put(3, List.of(
                new Celebrity("Thành Long ", R.drawable.thanhlong3, "Trần Cảng Sinh.hay Phòng Sĩ Long (tiếng Trung: 房仕龍, tiếng Anh: Fang Shi-long), " +
                        "thường được biết đến với nghệ danh Thành Long (tiếng Trung: 成龙, tiếng Anh: Jackie Chan; sinh ngày 7 tháng 4 năm 1954), là một nam diễn viên, chỉ đạo võ thuật kiêm nhà làm phim người Hồng Kông. Được mệnh danh là vua hành động của châu Á")

        ));

        celebrityMap.put(4, List.of(
                new Celebrity("William Henry Gates", R.drawable.billgate4, "(sinh ngày 28 tháng 10 năm 1955), " +
                        "thường được biết tới với tên Bill Gates, là một nam doanh nhân, nhà từ thiện kiêm tác giả người Mỹ. Ông được biết đến là chủ tịch tập đoàn Microsoft, hãng phần mềm mà ông đồng sáng lập cùng với Paul Allen.")

        ));

        celebrityMap.put(5, List.of(
                new Celebrity("Mark Elliot Zuckerberg", R.drawable.markzuckerbug5, "Mark Elliot Zuckerberg " +
                        "(sinh ngày 14 tháng 5 năm 1984) là một nhà lập trình máy tính người Mỹ kiêm doanh nhân mảng công nghệ Internet. Anh là nhà đồng sáng lập của Meta (ban đầu tên là Facebook), và hiện đang điều hành công ty này với chức danh chủ tịch kiêm giám đốc điều hành.")

        ));

        celebrityMap.put(6, List.of(
                new Celebrity("Jeffrey Preston Bezos", R.drawable.jeffbezos6, "Jeffrey Preston Bezos " +
                        "( sinh ngày 12 tháng 1 năm 1964) là doanh nhân, nhà tư bản công nghiệp, trùm truyền thông và nhà đầu tư người Mỹ. Bezos được biết đến như là người sáng lập và là chủ tịch Hội đồng quản trị công ty công nghệ đa quốc gia Amazon.")

        ));

        celebrityMap.put(7, List.of(
                new Celebrity("Elon Reeve Musk", R.drawable.elonmusk7, "Elon Reeve Musk " +
                        "(sinh 28 tháng 6 năm 1971) là một doanh nhân người Mỹ, nhân viên đặc biệt của chính phủ Hoa Kỳ, được biết đến nhiều nhất với vai trò mấu chốt trong hai công ty Tesla, Inc. và SpaceX, cũng như chủ sở hữu của Twitter.")

        ));

        celebrityMap.put(8, List.of(
                new Celebrity("Sơn Tùng-MTP", R.drawable.sontungmtp8, "Nguyễn Thanh Tùng " +
                        "(sinh ngày 5 tháng 7 năm 1994), thường được biết đến với nghệ danh Sơn Tùng M-TP, là một nam ca sĩ kiêm nhạc sĩ sáng tác bài hát, nhà sản xuất thu âm, rapper và diễn viên người Việt Nam.")

        ));

        celebrityMap.put(9, List.of(
                new Celebrity("Đại Tướng Võ Nguyên Giáp", R.drawable.daituongvonguyengiap9, "Đại Tướng Võ Nguyên Giáp " +
                        "(25 tháng 8 năm 1911 – 4 tháng 10 năm 2013) còn được gọi là tướng Giáp hoặc anh Văn, là một nhà lãnh đạo quân sự và chính trị gia người Việt Nam.")

        ));

        celebrityMap.put(11, List.of(
                new Celebrity("Barack Obama", R.drawable.obama11, "Sinh ngày 4/8/1961 là một chính trị gia, luật sư và tác giả người Mỹ, tổng thống thứ 44 của Hoa Kỳ từ năm 2009 đến năm 2017.")

        ));



        return celebrityMap.getOrDefault(lifePath, new ArrayList<>());
    }


}
