package com.example.celeblookalike;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class PersonalDevelopmentActivity extends AppCompatActivity {
    private static final String[] PERSONAL_YEAR_MEANINGS = {
            "Năm cá nhân 1 – Khởi đầu mới. Gợi ý: Đặt mục tiêu lớn, bắt đầu dự án cá nhân.",
            "Năm cá nhân 2 – Hợp tác & phát triển quan hệ. Gợi ý: Xây dựng mối quan hệ, học lắng nghe.",
            "Năm cá nhân 3 – Sáng tạo & thể hiện bản thân. Gợi ý: Tham gia hoạt động nghệ thuật, viết lách.",
            "Năm cá nhân 4 – Xây nền tảng vững chắc. Gợi ý: Lập kế hoạch tài chính, học kỹ năng mới.",
            "Năm cá nhân 5 – Thay đổi & trải nghiệm. Gợi ý: Du lịch, thử điều mới, học ngoại ngữ.",
            "Năm cá nhân 6 – Gia đình & trách nhiệm. Gợi ý: Chăm sóc bản thân, vun đắp gia đình.",
            "Năm cá nhân 7 – Phát triển tri thức. Gợi ý: Đọc sách mỗi ngày 30 phút, thiền định.",
            "Năm cá nhân 8 – Thành tựu & tài chính. Gợi ý: Đầu tư, phát triển sự nghiệp.",
            "Năm cá nhân 9 – Hoàn thiện & sẻ chia. Gợi ý: Làm từ thiện, tổng kết, buông bỏ cái cũ."
    };

    // Gợi ý chi tiết cho từng tháng của từng năm cá nhân (9 x 12)
    private static final String[][] PERSONAL_MONTHLY_SUGGESTIONS = {
            // Năm cá nhân 1
            {
                    "Tháng 1: Đặt mục tiêu lớn cho năm mới, khởi động dự án cá nhân.",
                    "Tháng 2: Xây dựng các mối quan hệ hỗ trợ mục tiêu mới.",
                    "Tháng 3: Thể hiện ý tưởng sáng tạo, chia sẻ với người khác.",
                    "Tháng 4: Lập kế hoạch chi tiết cho dự án, học kỹ năng quản lý.",
                    "Tháng 5: Đón nhận thay đổi, thử thách bản thân với điều mới.",
                    "Tháng 6: Cân bằng giữa công việc và gia đình, chăm sóc bản thân.",
                    "Tháng 7: Đầu tư vào tri thức, đọc sách phát triển bản thân.",
                    "Tháng 8: Tập trung phát triển sự nghiệp, tài chính cá nhân.",
                    "Tháng 9: Tổng kết tiến trình, chia sẻ thành quả với cộng đồng.",
                    "Tháng 10: Đổi mới phương pháp làm việc, học hỏi điều mới.",
                    "Tháng 11: Lắng nghe trực giác, điều chỉnh mục tiêu nếu cần.",
                    "Tháng 12: Tổng kết năm, lên kế hoạch cho chu kỳ mới."
            },
            // Năm cá nhân 2
            {
                    "Tháng 1: Xây dựng mối quan hệ, hợp tác với đồng nghiệp.",
                    "Tháng 2: Lắng nghe, chia sẻ cảm xúc với người thân.",
                    "Tháng 3: Tham gia hoạt động nhóm, phát triển kỹ năng giao tiếp.",
                    "Tháng 4: Học cách kiên nhẫn, giải quyết xung đột nhẹ nhàng.",
                    "Tháng 5: Mở rộng mạng lưới bạn bè, thử điều mới cùng người khác.",
                    "Tháng 6: Dành thời gian cho gia đình, vun đắp tình cảm.",
                    "Tháng 7: Tham gia lớp học phát triển bản thân cùng bạn bè.",
                    "Tháng 8: Hợp tác trong công việc, chia sẻ trách nhiệm.",
                    "Tháng 9: Đánh giá lại các mối quan hệ, buông bỏ điều không cần thiết.",
                    "Tháng 10: Học kỹ năng lắng nghe sâu, đồng cảm.",
                    "Tháng 11: Tham gia hoạt động thiện nguyện nhóm.",
                    "Tháng 12: Tổng kết các mối quan hệ, chuẩn bị cho năm mới."
            },
            // Năm cá nhân 3
            {
                    "Tháng 1: Tham gia hoạt động nghệ thuật, sáng tạo.",
                    "Tháng 2: Chia sẻ ý tưởng, cảm xúc với bạn bè.",
                    "Tháng 3: Viết lách, vẽ tranh, thể hiện bản thân.",
                    "Tháng 4: Học kỹ năng thuyết trình, giao tiếp.",
                    "Tháng 5: Tham gia sự kiện xã hội, mở rộng mối quan hệ.",
                    "Tháng 6: Tìm cảm hứng mới qua sách, phim, âm nhạc.",
                    "Tháng 7: Tham gia workshop sáng tạo.",
                    "Tháng 8: Chia sẻ thành quả sáng tạo với cộng đồng.",
                    "Tháng 9: Đánh giá lại quá trình phát triển bản thân.",
                    "Tháng 10: Học kỹ năng kể chuyện, truyền cảm hứng.",
                    "Tháng 11: Tham gia hoạt động nghệ thuật nhóm.",
                    "Tháng 12: Tổng kết thành tựu sáng tạo, lên ý tưởng mới."
            },
            // Năm cá nhân 4
            {
                    "Tháng 1: Lập kế hoạch tài chính cá nhân.",
                    "Tháng 2: Học kỹ năng quản lý thời gian.",
                    "Tháng 3: Xây dựng thói quen làm việc đều đặn.",
                    "Tháng 4: Đầu tư vào học tập, nâng cao chuyên môn.",
                    "Tháng 5: Sắp xếp lại không gian sống/làm việc.",
                    "Tháng 6: Duy trì sức khỏe, tập luyện thể thao.",
                    "Tháng 7: Đánh giá tiến trình, điều chỉnh kế hoạch.",
                    "Tháng 8: Học kỹ năng mới phục vụ công việc.",
                    "Tháng 9: Hoàn thiện dự án dang dở.",
                    "Tháng 10: Xây dựng mối quan hệ bền vững.",
                    "Tháng 11: Tiết kiệm, đầu tư nhỏ.",
                    "Tháng 12: Tổng kết, chuẩn bị cho năm mới ổn định."
            },
            // Năm cá nhân 5
            {
                    "Tháng 1: Thử điều mới, thay đổi thói quen cũ.",
                    "Tháng 2: Du lịch, khám phá địa điểm mới.",
                    "Tháng 3: Học ngoại ngữ, kỹ năng mới.",
                    "Tháng 4: Tham gia hoạt động ngoài trời.",
                    "Tháng 5: Đón nhận cơ hội bất ngờ.",
                    "Tháng 6: Kết bạn mới, mở rộng mạng lưới.",
                    "Tháng 7: Thay đổi phong cách sống.",
                    "Tháng 8: Đầu tư vào trải nghiệm cá nhân.",
                    "Tháng 9: Đánh giá lại mục tiêu, điều chỉnh hướng đi.",
                    "Tháng 10: Học kỹ năng thích nghi.",
                    "Tháng 11: Tham gia sự kiện, hội thảo mới.",
                    "Tháng 12: Tổng kết trải nghiệm, lên kế hoạch mới."
            },
            // Năm cá nhân 6
            {
                    "Tháng 1: Chăm sóc sức khỏe bản thân và gia đình.",
                    "Tháng 2: Dành thời gian cho người thân.",
                    "Tháng 3: Trang trí, làm đẹp không gian sống.",
                    "Tháng 4: Học kỹ năng nấu ăn, chăm sóc nhà cửa.",
                    "Tháng 5: Tham gia hoạt động cộng đồng.",
                    "Tháng 6: Gắn kết tình cảm gia đình.",
                    "Tháng 7: Học kỹ năng quản lý cảm xúc.",
                    "Tháng 8: Chia sẻ, giúp đỡ người khác.",
                    "Tháng 9: Đánh giá lại các mối quan hệ thân thiết.",
                    "Tháng 10: Học kỹ năng nuôi dạy con cái (nếu có).",
                    "Tháng 11: Tham gia hoạt động thiện nguyện.",
                    "Tháng 12: Tổng kết, tri ân gia đình."
            },
            // Năm cá nhân 7
            {
                    "Tháng 1: Đọc sách phát triển bản thân.",
                    "Tháng 2: Thiền định, tĩnh tâm.",
                    "Tháng 3: Học kỹ năng phân tích, nghiên cứu.",
                    "Tháng 4: Tham gia khóa học online.",
                    "Tháng 5: Viết nhật ký, tự phản chiếu.",
                    "Tháng 6: Dành thời gian cho sở thích cá nhân.",
                    "Tháng 7: Học kỹ năng tư duy phản biện.",
                    "Tháng 8: Tham gia nhóm học tập, nghiên cứu.",
                    "Tháng 9: Đánh giá lại tri thức đã học.",
                    "Tháng 10: Học kỹ năng mới về công nghệ.",
                    "Tháng 11: Tham gia hội thảo chuyên môn.",
                    "Tháng 12: Tổng kết tri thức, lên kế hoạch học tập mới."
            },
            // Năm cá nhân 8
            {
                    "Tháng 1: Đặt mục tiêu tài chính rõ ràng.",
                    "Tháng 2: Học kỹ năng đầu tư, quản lý tiền bạc.",
                    "Tháng 3: Tập trung phát triển sự nghiệp.",
                    "Tháng 4: Đánh giá lại các khoản đầu tư.",
                    "Tháng 5: Học kỹ năng đàm phán, thương lượng.",
                    "Tháng 6: Mở rộng cơ hội kinh doanh.",
                    "Tháng 7: Đầu tư vào bản thân (khóa học, sức khỏe).",
                    "Tháng 8: Đánh giá lại thành tựu cá nhân.",
                    "Tháng 9: Chia sẻ kinh nghiệm, giúp đỡ người khác.",
                    "Tháng 10: Học kỹ năng lãnh đạo.",
                    "Tháng 11: Tham gia hội thảo tài chính.",
                    "Tháng 12: Tổng kết tài chính, lên kế hoạch mới."
            },
            // Năm cá nhân 9
            {
                    "Tháng 1: Tổng kết, buông bỏ điều không còn phù hợp.",
                    "Tháng 2: Làm từ thiện, giúp đỡ cộng đồng.",
                    "Tháng 3: Chia sẻ tri thức, kinh nghiệm.",
                    "Tháng 4: Học kỹ năng tha thứ, buông bỏ.",
                    "Tháng 5: Tham gia hoạt động xã hội.",
                    "Tháng 6: Gắn kết với cộng đồng, nhóm thiện nguyện.",
                    "Tháng 7: Đánh giá lại hành trình phát triển bản thân.",
                    "Tháng 8: Học kỹ năng truyền cảm hứng.",
                    "Tháng 9: Chia sẻ thành quả, tri ân người hỗ trợ.",
                    "Tháng 10: Lên kế hoạch cho chu kỳ mới.",
                    "Tháng 11: Tham gia hoạt động tổng kết năm.",
                    "Tháng 12: Nghỉ ngơi, chuẩn bị cho khởi đầu mới."
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_development);

        LinearLayout layoutRoadmap = findViewById(R.id.layoutRoadmap);
        String name = getIntent().getStringExtra("name");
        String birthDate = getIntent().getStringExtra("birthDate");

        if (birthDate == null) {
            Toast.makeText(this, "Vui lòng nhập ngày sinh ở màn hình chính để cá nhân hóa lộ trình!", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        int personalYear = calculatePersonalYear(birthDate);
        String yearMeaning = PERSONAL_YEAR_MEANINGS[(personalYear - 1) % PERSONAL_YEAR_MEANINGS.length];

        // Card năm cá nhân nổi bật
        LinearLayout cardYear = new LinearLayout(this);
        cardYear.setOrientation(LinearLayout.HORIZONTAL);
        cardYear.setPadding(32, 32, 32, 32);
        LinearLayout.LayoutParams paramsYear = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        paramsYear.setMargins(0, 0, 0, 32);
        cardYear.setLayoutParams(paramsYear);
        cardYear.setGravity(Gravity.CENTER_VERTICAL);
        GradientDrawable bgYear = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{0xFFB2FEFA, 0xFF39479E}); // Gradient xanh
        bgYear.setCornerRadius(40);
        cardYear.setBackground(bgYear);

        ImageView iconYear = new ImageView(this);
        iconYear.setImageResource(android.R.drawable.ic_menu_my_calendar);
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(100, 100);
        iconParams.setMargins(0, 0, 32, 0);
        iconYear.setLayoutParams(iconParams);
        cardYear.addView(iconYear);

        LinearLayout yearTextLayout = new LinearLayout(this);
        yearTextLayout.setOrientation(LinearLayout.VERTICAL);
        yearTextLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView tvYearTitle = new TextView(this);
        tvYearTitle.setText("Năm cá nhân: " + personalYear);
        tvYearTitle.setTextSize(20);
        tvYearTitle.setTypeface(Typeface.DEFAULT_BOLD);
        tvYearTitle.setTextColor(0xFF39479E);
        yearTextLayout.addView(tvYearTitle);

        TextView tvYearDesc = new TextView(this);
        tvYearDesc.setText(yearMeaning);
        tvYearDesc.setTextSize(16);
        tvYearDesc.setTextColor(0xFF222222);
        yearTextLayout.addView(tvYearDesc);

        cardYear.addView(yearTextLayout);
        layoutRoadmap.addView(cardYear);

        // Icon cho từng tháng (dùng icon hệ thống Android)
        int[] monthIcons = {
                android.R.drawable.ic_menu_compass, // 1
                android.R.drawable.ic_menu_share,   // 2
                android.R.drawable.ic_menu_edit,    // 3
                android.R.drawable.ic_menu_agenda,  // 4
                android.R.drawable.ic_menu_rotate,  // 5
                android.R.drawable.ic_menu_myplaces,// 6
                android.R.drawable.ic_menu_info_details, // 7
                android.R.drawable.ic_menu_manage,  // 8
                android.R.drawable.ic_menu_send,    // 9
                android.R.drawable.ic_menu_add,     // 10
                android.R.drawable.ic_menu_view,    // 11
                android.R.drawable.ic_menu_revert   // 12
        };

        String[] roadmap = PERSONAL_MONTHLY_SUGGESTIONS[(personalYear - 1) % PERSONAL_MONTHLY_SUGGESTIONS.length];
        for (int i = 0; i < 12; i++) {
            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.HORIZONTAL);
            card.setPadding(24, 24, 24, 24);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, 20);
            card.setLayoutParams(params);
            card.setGravity(Gravity.CENTER_VERTICAL);
            // Gradient nền pastel nhẹ
            GradientDrawable bg = new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[]{0xFFE3E8FF, 0xFFF8F8FF});
            bg.setCornerRadius(32);
            bg.setStroke(2, 0xFFB2FEFA);
            card.setBackground(bg);
            card.setElevation(8f);

            ImageView icon = new ImageView(this);
            icon.setImageResource(monthIcons[i]);
            LinearLayout.LayoutParams iconMonthParams = new LinearLayout.LayoutParams(80, 80);
            iconMonthParams.setMargins(0, 0, 24, 0);
            icon.setLayoutParams(iconMonthParams);
            card.addView(icon);

            LinearLayout textLayout = new LinearLayout(this);
            textLayout.setOrientation(LinearLayout.VERTICAL);
            textLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView tvMonthNum = new TextView(this);
            tvMonthNum.setText("Tháng " + (i + 1));
            tvMonthNum.setTextSize(18);
            tvMonthNum.setTypeface(Typeface.DEFAULT_BOLD);
            tvMonthNum.setTextColor(0xFF39479E);
            textLayout.addView(tvMonthNum);

            TextView tvMonth = new TextView(this);
            tvMonth.setText(roadmap[i]);
            tvMonth.setTextSize(16);
            tvMonth.setTextColor(0xFF222222);
            textLayout.addView(tvMonth);

            card.addView(textLayout);
            layoutRoadmap.addView(card);
        }

        // Xử lý nút Back
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Tính năm cá nhân theo thần số học: (ngày + tháng sinh + năm hiện tại), cộng dồn từng chữ số đến khi còn 1 số
    private int calculatePersonalYear(String birthDate) {
        // birthDate dạng dd/MM/yyyy
        try {
            String[] parts = birthDate.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int total = sumDigits(day) + sumDigits(month) + sumDigits(year);
            while (total > 9) total = sumDigits(total);
            return total;
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi định dạng ngày sinh", Toast.LENGTH_SHORT).show();
            return 1;
        }
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