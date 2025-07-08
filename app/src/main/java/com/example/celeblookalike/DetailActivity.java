package com.example.celeblookalike;

import android.os.Bundle;
import android.widget.Button;
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

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish(); // Quay lại màn trước (ResultActivity)
        });
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
                return "Thần số học số 6 là những người biết yêu thương, chăm sóc gia đình và sẵn lòng giúp đỡ người khác. Họ có sự sáng tạo và tài năng, nhưng đôi khi có xu hướng muốn kiểm soát người khác.\n" +
                        "Ưu điểm\n" +
                        "- Người mang số 6 trong thần số học có khả năng sắp xếp mọi thứ một cách ngăn nắp và có trật tự.\n" +
                        "- Nhân số học 6 sở hữu trí tưởng tượng phong phú, luôn đưa ra những ý tưởng mới mẻ và sáng tạo.\n" +
                        "- Thần số học số 6 có mắt thẩm mỹ nhạy bén và năng khiếu nghệ thuật ấn tượng.\n" +
                        "- Số 6 thần số học có sức hút đặc biệt với người khác giới, tạo ra mối quan hệ thoải mái và thân thiện.\n" +
                        "- Người số 6 sống có trách nhiệm cao, biết thấu hiểu, sẻ chia với mọi người.\n" +
                        "- Người mang số 6 trong thần số học có khả năng hy sinh bản thân để giúp đỡ người khác, tận tâm hỗ trợ mọi người vượt qua khó khăn.\n" +
                        "Nhược điểm\n" +
                        "- Người số 6 thần số học thường quá cầu toàn, đặt ra tiêu chuẩn cao đến mức khó ai đáp ứng được, điều này có thể gây chán nản và bất mãn cho người khác.\n" +
                        "- Nhân số học 6 đôi khi trở nên cố chấp và thích kiểm soát người khác trong cuộc sống và công việc.\n" +
                        "- Đôi khi thần số học số 6 tự cho mình là đúng và không hiểu vì sao người khác không giống mình.\n" +
                        "- Thần số học 6 có thể trở nên lạnh lùng và xa cách, tạo ra một bức tường ngăn cách họ với thế giới xung quanh.\n" +
                        "- Người số 6 thường bị ảnh hưởng bởi những người họ yêu thương, dễ đánh mất tính cách cá nhân và chìm vào cuộc sống của người khác.\n" +
                        "- Số 6 trong thần số học có xu hướng dễ bị lợi dụng và phụ thuộc vào người khác. Họ thường thiếu tự tin vào khả năng của mình, lo lắng về việc không thể tự đứng vững trên đôi chân của mình.";
            default:
                return "Chưa có thông tin cho số chủ đạo này.";
        }
    }
}
