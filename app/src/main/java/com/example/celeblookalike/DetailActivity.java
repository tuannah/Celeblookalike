package com.example.celeblookalike;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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
        // Button chuyển đến màn tử vi
        Button btnHoroscope = findViewById(R.id.btnHoroscope);
        btnHoroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Điều hướng đến màn xem tử vi
                Intent intent = new Intent(DetailActivity.this, HoroscopeActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getLifePathDescription(int number) {
        switch (number) {
            case 1:
                return "Số 1 trong thần số học đại diện cho sự lãnh đạo, độc lập và tiên phong. Những người mang số này thường có tầm nhìn xa, quyết đoán và luôn sẵn sàng đối mặt với thử thách. Họ có khả năng lãnh đạo bẩm sinh, có mục tiêu rõ ràng và kiên trì theo đuổi đến cùng. Tuy nhiên, họ có thể trở nên kiêu ngạo và ít khi lắng nghe ý kiến của người khác.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Tự lập và độc lập, có khả năng làm việc một mình.\n" +
                        "- Khả năng lãnh đạo mạnh mẽ, tạo được niềm tin và sự tôn trọng từ người khác.\n" +
                        "- Sáng tạo và luôn tìm cách cải tiến, không ngừng cải thiện bản thân.\n" +
                        "- Tính cách mạnh mẽ, không ngại thử thách và dám đứng ra dẫn dắt người khác.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Cứng đầu, đôi khi không lắng nghe ý kiến từ người khác.\n" +
                        "- Thiếu kiên nhẫn, dễ thất vọng khi không đạt được mục tiêu ngay lập tức.\n" +
                        "- Dễ cảm thấy cô đơn vì xu hướng độc lập quá mức.\n" +
                        "\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Lãnh đạo, CEO, giám đốc điều hành.\n" +
                        "- Doanh nhân, nhà sáng lập.\n" +
                        "- Nhà sáng tạo, nhà phát minh, nghệ sĩ.\n" +
                        "\n" +
                        "Màu sắc may mắn: Vàng, cam, đỏ.\n" +
                        "Hành tinh chi phối: Mặt trời.\n";
            case 2:
                return "Số 2 trong thần số học biểu trưng cho sự hòa hợp, nhạy cảm và hợp tác. Những người mang số này là những người biết lắng nghe, thấu hiểu và luôn tìm kiếm sự cân bằng trong mọi mối quan hệ. Họ có khả năng làm dịu những xung đột và giúp đỡ người khác tìm kiếm sự thỏa hiệp.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Tính cách nhạy cảm, dễ đồng cảm và luôn sẵn sàng giúp đỡ người khác.\n" +
                        "- Khả năng giao tiếp và làm việc nhóm rất tốt.\n" +
                        "- Luôn tìm kiếm sự hòa hợp và sự ổn định trong các mối quan hệ.\n" +
                        "- Trung thực, đáng tin cậy và có lòng vị tha.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Dễ bị tổn thương, thiếu tự tin và đôi khi dễ bị lợi dụng.\n" +
                        "- Thiếu quyết đoán, dễ bị ảnh hưởng bởi ý kiến của người khác.\n" +
                        "- Có thể hy sinh quá nhiều cho người khác, dẫn đến bỏ qua lợi ích của bản thân.\n" +
                        "\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Tư vấn viên, trị liệu viên.\n" +
                        "- Giáo viên, huấn luyện viên.\n" +
                        "- Nhà ngoại giao, chuyên gia hòa giải.\n" +
                        "\n" +
                        "Màu sắc may mắn: Trắng, bạc, xanh dương nhạt.\n" +
                        "Hành tinh chi phối: Mặt trăng.\n";
            case 3:
                return "Số 3 biểu trưng cho sự sáng tạo, giao tiếp và nghệ thuật. Những người mang số này thường rất vui vẻ, lạc quan và có khả năng truyền cảm hứng cho người khác. Họ yêu thích sự tự do trong việc thể hiện bản thân và tìm thấy sự thoải mái trong việc sáng tạo. Tuy nhiên, họ có thể thiếu kiên nhẫn và đôi khi thiếu tổ chức trong công việc.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Sáng tạo, có khả năng diễn đạt ý tưởng một cách sinh động.\n" +
                        "- Lạc quan, vui vẻ và dễ dàng kết nối với mọi người.\n" +
                        "- Khả năng giao tiếp tốt, thuyết phục và truyền cảm hứng.\n" +
                        "- Có khiếu nghệ thuật và thẩm mỹ cao.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Dễ bị phân tâm và thiếu kiên nhẫn.\n" +
                        "- Thiếu tổ chức và kỷ luật trong công việc.\n" +
                        "- Dễ bị hiểu lầm hoặc bỏ lỡ những chi tiết quan trọng.\n" +
                        "\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Nghệ sĩ, nhà văn, diễn viên.\n" +
                        "- Nhà báo, biên tập viên.\n" +
                        "- Nhà thiết kế, nhiếp ảnh gia.\n" +
                        "\n" +
                        "Màu sắc may mắn: Vàng, cam, xanh lá cây.\n" +
                        "Hành tinh chi phối: Sao Mộc.\n";
            case 4:
                return "Số 4 đại diện cho sự ổn định, kỷ luật và chăm chỉ. Những người mang số này thường rất thực tế, có tổ chức và luôn làm việc chăm chỉ để đạt được mục tiêu. Họ rất đáng tin cậy và có khả năng lập kế hoạch cẩn thận, nhưng có thể trở nên cứng nhắc và thiếu linh hoạt khi gặp phải những tình huống bất ngờ.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Đáng tin cậy, có trách nhiệm và chăm chỉ.\n" +
                        "- Có khả năng tổ chức và lập kế hoạch tốt.\n" +
                        "- Sự ổn định trong công việc và cuộc sống cá nhân.\n" +
                        "- Suy nghĩ thực tế và luôn nhìn nhận mọi vấn đề một cách khách quan.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Thiếu linh hoạt và cứng nhắc trong suy nghĩ.\n" +
                        "- Đôi khi có thể trở nên quá chú trọng vào công việc và thiếu thời gian cho bản thân.\n" +
                        "- Có thể gặp khó khăn khi phải đối mặt với sự thay đổi hoặc rủi ro.\n" +
                        "\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Kỹ sư, kiến trúc sư.\n" +
                        "- Quản lý dự án, tổ chức sự kiện.\n" +
                        "- Nhà nghiên cứu, nhà khoa học.\n" +
                        "\n" +
                        "Màu sắc may mắn: Xanh lá cây, nâu, đen.\n" +
                        "Hành tinh chi phối: Sao Thổ.\n";
            case 5:
                return "Số 5 đại diện cho sự tự do, thay đổi và phiêu lưu. Những người mang số này thường rất thích khám phá những điều mới mẻ và luôn tìm kiếm sự tự do trong cuộc sống. Họ có khả năng thích nghi nhanh chóng và rất linh hoạt, nhưng cũng dễ dàng cảm thấy nhàm chán khi phải đối mặt với sự lặp lại hoặc thiếu sự thay đổi.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Thích khám phá và trải nghiệm điều mới mẻ.\n" +
                        "- Tính cách năng động, thích thử thách.\n" +
                        "- Dễ dàng thích nghi với mọi hoàn cảnh.\n" +
                        "- Khả năng sáng tạo và tìm ra giải pháp mới cho các vấn đề.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Dễ thiếu kiên định và không tập trung vào một mục tiêu dài hạn.\n" +
                        "- Có thể thiếu kỷ luật và tổ chức trong công việc.\n" +
                        "- Dễ bị phân tâm bởi những yếu tố bên ngoài.\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Du lịch, hướng dẫn viên du lịch, nhà báo.\n" +
                        "- Doanh nhân, nhà sáng tạo nội dung.\n" +
                        "\n" +
                        "Màu sắc may mắn: Xanh lá cây, vàng, trắng.\n" +
                        "Hành tinh chi phối: Sao Thủy.\n";
            case 6:
                return "Số 6 trong thần số học là những người biết yêu thương, chăm sóc gia đình và sẵn lòng giúp đỡ người khác. Họ có sự sáng tạo và tài năng, nhưng đôi khi có xu hướng muốn kiểm soát người khác. Họ sống có trách nhiệm và luôn tìm cách hỗ trợ người khác vượt qua khó khăn.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Khả năng sắp xếp mọi thứ một cách ngăn nắp và có trật tự.\n" +
                        "- Trí tưởng tượng phong phú, luôn đưa ra những ý tưởng mới mẻ và sáng tạo.\n" +
                        "- Mắt thẩm mỹ nhạy bén và năng khiếu nghệ thuật ấn tượng.\n" +
                        "- Sức hút đặc biệt với người khác giới, tạo ra mối quan hệ thoải mái và thân thiện.\n" +
                        "- Sống có trách nhiệm cao, biết thấu hiểu, sẻ chia với mọi người.\n" +
                        "- Khả năng hy sinh bản thân để giúp đỡ người khác, tận tâm hỗ trợ mọi người vượt qua khó khăn.\n" +
                        "Nhược điểm:\n" +
                        "- Quá cầu toàn, đặt ra tiêu chuẩn cao đến mức khó ai đáp ứng được.\n" +
                        "- Đôi khi trở nên cố chấp và thích kiểm soát người khác.\n" +
                        "- Tự cho mình là đúng và không hiểu vì sao người khác không giống mình.\n" +
                        "- Có thể trở nên lạnh lùng và xa cách, tạo ra một bức tường ngăn cách họ với thế giới xung quanh.\n" +
                        "- Dễ bị ảnh hưởng bởi những người họ yêu thương, dễ đánh mất tính cách cá nhân.\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Giáo viên, nhân viên y tế, tư vấn viên.\n" +
                        "- Nhà trị liệu, nhân viên xã hội, tình nguyện viên.\n" +
                        "Màu sắc may mắn: Trắng, xanh dương nhạt, hồng.\n" +
                        "Hành tinh chi phối: Sao Kim.\n";
            case 7:
                return "Số 7 trong thần số học là biểu tượng của trí tuệ, phân tích và tìm kiếm sự thật. Những người mang số này có xu hướng sống nội tâm và thích phân tích mọi thứ xung quanh. Họ thích tìm kiếm câu trả lời cho những câu hỏi lớn của cuộc sống và có khả năng suy nghĩ sâu sắc. Tuy nhiên, họ có thể trở nên cô đơn và cảm thấy tách biệt vì sự khác biệt về tư duy.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Tư duy sâu sắc, yêu thích phân tích và nghiên cứu.\n" +
                        "- Tính cách độc lập, thích sống một mình và không cần sự bảo vệ của người khác.\n" +
                        "- Khả năng giải quyết vấn đề và đưa ra quyết định chính xác.\n" +
                        "- Tầm nhìn xa và khả năng dự đoán chính xác tương lai.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Dễ cảm thấy cô đơn, tách biệt với người khác.\n" +
                        "- Có thể thiếu giao tiếp và khó kết nối với người khác.\n" +
                        "- Đôi khi quá lý tưởng hóa và thiếu thực tế.\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Nhà khoa học, nhà nghiên cứu, triết gia.\n" +
                        "- Tư vấn viên, nhà phân tích.\n" +
                        "Màu sắc may mắn: Tím, xanh dương đậm.\n" +
                        "Hành tinh chi phối: Sao Thủy.\n";
            case 8:
                return "Số 8 trong thần số học là biểu tượng của quyền lực, tham vọng và thành công. Những người mang số này thường có khả năng lãnh đạo và luôn hướng đến sự thành công trong sự nghiệp. Họ có khả năng tổ chức và điều hành các dự án lớn. Tuy nhiên, đôi khi sự tham vọng có thể khiến họ trở nên lạnh lùng và thiếu cảm xúc trong các mối quan hệ.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Quyết đoán, mạnh mẽ và luôn tìm kiếm sự thành công.\n" +
                        "- Có khả năng lãnh đạo và tổ chức xuất sắc.\n" +
                        "- Tham vọng cao và luôn cố gắng đạt được mục tiêu.\n" +
                        "- Tính cách thực tế, không ngại đối mặt với khó khăn.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Tham vọng quá mức có thể khiến họ bỏ qua cảm xúc của người khác.\n" +
                        "- Dễ trở nên lạnh lùng và thiếu quan tâm đến các mối quan hệ.\n" +
                        "- Căng thẳng do áp lực công việc có thể ảnh hưởng đến sức khỏe và tinh thần.\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- CEO, nhà lãnh đạo, nhà đầu tư.\n" +
                        "- Kinh doanh, tài chính, quản lý.\n" +
                        "Màu sắc may mắn: Đen, xám, nâu.\n" +
                        "Hành tinh chi phối: Sao Thổ.\n";
            case 9:
                return "Số 9 trong thần số học là biểu tượng của lòng nhân ái, lý tưởng và sự hoàn thiện. Những người mang số này có một trái tim rộng mở và luôn mong muốn giúp đỡ người khác. Họ tìm kiếm sự hoàn thiện trong mọi việc và luôn có tầm nhìn toàn cầu. Tuy nhiên, họ có thể cảm thấy cô đơn và bị hiểu lầm do tính cách khác biệt và lý tưởng hóa quá mức.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Lòng nhân ái và luôn sẵn sàng giúp đỡ người khác.\n" +
                        "- Tầm nhìn rộng, biết nhìn nhận mọi việc dưới góc độ toàn cầu.\n" +
                        "- Khả năng làm việc nhóm và lãnh đạo rất tốt.\n" +
                        "- Lý tưởng, sáng suốt và đầy nhiệt huyết.\n" +
                        "\n" +
                        "Nhược điểm:\n" +
                        "- Cảm thấy cô đơn hoặc bị hiểu lầm vì tính cách khác biệt.\n" +
                        "- Quá lý tưởng hóa, thiếu thực tế trong một số tình huống.\n" +
                        "- Dễ bị lợi dụng vì tính cách dễ chịu.\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Tình nguyện viên, nhân viên xã hội.\n" +
                        "- Nhà hoạt động xã hội, nhà văn.\n" +
                        "- Nhà tư vấn, trị liệu viên.\n" +
                        "Màu sắc may mắn: Vàng, đỏ, cam.\n" +
                        "Hành tinh chi phối: Sao Hỏa.\n";
            case 10:
                return "Số 10 kết hợp giữa sự độc lập của số 1 và sự hoàn thiện của số 0. Những người mang số này có khả năng lãnh đạo, sáng tạo và hướng tới sự hoàn hảo. Họ có thể gặp khó khăn trong việc chấp nhận thất bại hoặc thiếu kiên nhẫn.\n" +
                        "\n" +
                        "Ưu điểm:\n" +
                        "- Lãnh đạo tự nhiên, sáng tạo và quyết đoán.\n" +
                        "- Thích thử thách và dám thay đổi.\n" +
                        "- Tính tự lập cao và biết cách độc lập làm việc.\n" +
                        "- Sự kết hợp giữa tư duy độc lập và khả năng làm việc nhóm.\n" +
                        "Nhược điểm:\n" +
                        "- Khó chấp nhận thất bại hoặc sai sót.\n" +
                        "- Dễ thiếu kiên nhẫn và thiếu sự mềm dẻo trong công việc.\n" +
                        "- Căng thẳng khi không đạt được mục tiêu.\n" +
                        "Nghề nghiệp phù hợp:\n" +
                        "- Doanh nhân, người sáng lập.\n" +
                        "- Quản lý, lãnh đạo.\n" +
                        "- Nhà sáng tạo, nhà tư tưởng.\n" +
                        "Màu sắc may mắn: Vàng, trắng, bạc.\n" +
                        "Hành tinh chi phối: Sao Thổ.\n";
            default:
                return "Chưa có thông tin cho số chủ đạo này.";
        }



    }
}
