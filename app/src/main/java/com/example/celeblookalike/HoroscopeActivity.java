package com.example.celeblookalike;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HoroscopeActivity extends AppCompatActivity {

    private static final String TAG = "HoroscopeActivity";

    // Views cho Destiny Number
    private LinearLayout destinyContainer;
    private TextView destinyDetail;
    private boolean isDestinyExpanded = false;

    // Views cho Soul Urge Number
    private LinearLayout soulUrgeContainer;
    private TextView soulUrgeDetail;
    private boolean isSoulUrgeExpanded = false;

    // Views cho Personality Number
    private LinearLayout personalityContainer;
    private TextView personalityDetail;
    private boolean isPersonalityExpanded = false;

    // Views cho Birth Day Number
    private LinearLayout birthDayContainer;
    private TextView birthDayDetail;
    private boolean isBirthDayExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        // Khởi tạo các thành phần giao diện
        TextView txtDestiny = findViewById(R.id.txtDestiny);
        TextView txtSoulUrge = findViewById(R.id.txtSoulUrge);
        TextView txtPersonality = findViewById(R.id.txtPersonality);
        TextView txtBirthDay = findViewById(R.id.txtLifePath);
        Button btnBack = findViewById(R.id.btnBack);

        // Khởi tạo containers và detail views
        destinyContainer = findViewById(R.id.destinyContainer);
        destinyDetail = findViewById(R.id.destinyDetail);
        soulUrgeContainer = findViewById(R.id.soulUrgeContainer);
        soulUrgeDetail = findViewById(R.id.soulUrgeDetail);
        personalityContainer = findViewById(R.id.personalityContainer);
        personalityDetail = findViewById(R.id.personalityDetail);
        birthDayContainer = findViewById(R.id.birthDayContainer);
        birthDayDetail = findViewById(R.id.birthDayDetail);

        // Lấy dữ liệu từ Intent
        String birthDate = getIntent().getStringExtra("birthDate");
        String name = getIntent().getStringExtra("name");
        if (birthDate == null || name == null) {
            Toast.makeText(this, "Dữ liệu không hợp lệ, vui lòng thử lại", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Tính toán các chỉ số
        int destinyNumber = calculateDestinyNumber(birthDate);
        int soulUrgeNumber = calculateSoulUrgeNumber(name);
        int personalityNumber = calculatePersonalityNumber(name);
        int birthDayNumber = calculateBirthDayNumber(birthDate);

        // Cập nhật giao diện
        txtDestiny.setText("Con số định mệnh: " + destinyNumber);
        txtSoulUrge.setText("Con số tâm hồn: " + soulUrgeNumber);
        txtPersonality.setText("Tính cách: " + personalityNumber);
        txtBirthDay.setText("Ngày sinh: " + birthDayNumber);

        // Cập nhật nội dung chi tiết
        destinyDetail.setText(getDestinyDescription(destinyNumber));
        soulUrgeDetail.setText(getSoulUrgeDescription(soulUrgeNumber));
        personalityDetail.setText(getPersonalityDescription(personalityNumber));
        birthDayDetail.setText(getBirthDayDescription(birthDayNumber));

        // Ẩn tất cả detail views ban đầu
        destinyDetail.setVisibility(View.GONE);
        soulUrgeDetail.setVisibility(View.GONE);
        personalityDetail.setVisibility(View.GONE);
        birthDayDetail.setVisibility(View.GONE);

        // Thiết lập click listeners
        destinyContainer.setOnClickListener(v -> toggleDropdown(destinyDetail, isDestinyExpanded, expanded -> isDestinyExpanded = expanded));
        soulUrgeContainer.setOnClickListener(v -> toggleDropdown(soulUrgeDetail, isSoulUrgeExpanded, expanded -> isSoulUrgeExpanded = expanded));
        personalityContainer.setOnClickListener(v -> toggleDropdown(personalityDetail, isPersonalityExpanded, expanded -> isPersonalityExpanded = expanded));
        birthDayContainer.setOnClickListener(v -> toggleDropdown(birthDayDetail, isBirthDayExpanded, expanded -> isBirthDayExpanded = expanded));

        // Xử lý nút quay lại
        btnBack.setOnClickListener(v -> finish());
    }

    private void toggleDropdown(TextView detailView, boolean isExpanded, ToggleCallback callback) {
        if (isExpanded) {
            // Thu gọn
            ObjectAnimator.ofFloat(detailView, "alpha", 1f, 0f).setDuration(200).start();
            detailView.setVisibility(View.GONE);
            callback.onToggle(false);
        } else {
            // Mở rộng
            detailView.setVisibility(View.VISIBLE);
            ObjectAnimator.ofFloat(detailView, "alpha", 0f, 1f).setDuration(200).start();
            callback.onToggle(true);
        }
    }

    private interface ToggleCallback {
        void onToggle(boolean expanded);
    }

    private String getDestinyDescription(int number) {
        switch (number) {
            case 1:
                return "Con số định mệnh 1 - Người lãnh đạo\n\nBạn sinh ra để dẫn đầu và khởi xướng. Có tinh thần độc lập mạnh mẽ, khả năng lãnh đạo tự nhiên và luôn muốn là người đầu tiên trong mọi việc. Bạn có thể thành công trong vai trò quản lý, khởi nghiệp hoặc bất kỳ lĩnh vực nào đòi hỏi sự sáng tạo và quyết đoán.";
            case 2:
                return "Con số định mệnh 2 - Người hòa giải\n\nBạn có khả năng kết nối và hòa hợp mọi người. Tính cách nhẹ nhàng, kiên nhẫn và luôn tìm cách giải quyết xung đột một cách hòa bình. Bạn thích hợp với công việc đòi hỏi sự hợp tác, tư vấn hoặc làm việc trong nhóm.";
            case 3:
                return "Con số định mệnh 3 - Người sáng tạo\n\nBạn có tài năng nghệ thuật và khả năng giao tiếp xuất sắc. Tính cách vui vẻ, lạc quan và có thể truyền cảm hứng cho người khác. Bạn có thể thành công trong các lĩnh vực nghệ thuật, truyền thông, giải trí hoặc bất kỳ công việc nào đòi hỏi sự sáng tạo.";
            case 4:
                return "Con số định mệnh 4 - Người xây dựng\n\nBạn có tính cách thực tế, chăm chỉ và kiên trì. Luôn làm việc một cách có hệ thống và đáng tin cậy. Bạn thích hợp với các công việc đòi hỏi sự tỉ mỉ, kỹ thuật hoặc quản lý dự án.";
            case 5:
                return "Con số định mệnh 5 - Người tự do\n\nBạn yêu thích tự do, phiêu lưu và khám phá. Có khả năng thích nghi tốt với thay đổi và luôn tìm kiếm những trải nghiệm mới. Bạn có thể thành công trong các lĩnh vực du lịch, bán hàng, truyền thông hoặc bất kỳ công việc nào mang tính linh hoạt.";
            case 6:
                return "Con số định mệnh 6 - Người chăm sóc\n\nBạn có khả năng chăm sóc tốt và luôn quan tâm đến những người yêu thương. Tính cách ấm áp, có trách nhiệm và sẵn sàng hy sinh vì người khác. Bạn thích hợp với các công việc trong lĩnh vực chăm sóc sức khỏe, giáo dục hoặc tư vấn.";
            case 7:
                return "Con số định mệnh 7 - Người tìm kiếm\n\nBạn có tâm hồn sâu sắc và luôn tìm kiếm ý nghĩa cuộc sống. Thích sự yên tĩnh, nghiên cứu và khám phá những điều bí ẩn. Bạn có thể thành công trong các lĩnh vực nghiên cứu, triết học, tâm linh hoặc khoa học.";
            case 8:
                return "Con số định mệnh 8 - Người quyền lực\n\nBạn có khả năng quản lý tài chính và kinh doanh xuất sắc. Tham vọng lớn, quyết đoán và có thể đạt được thành công vật chất. Bạn thích hợp với các công việc trong lĩnh vực kinh doanh, tài chính hoặc quản lý cấp cao.";
            case 9:
                return "Con số định mệnh 9 - Người phục vụ\n\nBạn có tâm hồn nhân ái và luôn muốn đóng góp cho xã hội. Có khả năng hiểu và cảm thông với người khác. Bạn có thể thành công trong các lĩnh vực từ thiện, giáo dục, y tế hoặc bất kỳ công việc nào phục vụ cộng đồng.";
            case 11:
                return "Con số định mệnh 11 - Người truyền cảm hứng\n\nBạn có trực giác mạnh mẽ và khả năng truyền cảm hứng cho người khác. Tâm hồn nhạy cảm, sáng tạo và có thể nhìn thấy những điều mà người khác không thể. Bạn có thể thành công trong các lĩnh vực nghệ thuật, tâm linh hoặc tư vấn.";
            case 22:
                return "Con số định mệnh 22 - Người kiến tạo\n\nBạn có khả năng biến ước mơ thành hiện thực và tạo ra những thay đổi lớn. Kết hợp giữa tầm nhìn và khả năng thực hiện. Bạn có thể thành công trong các dự án quy mô lớn, kiến trúc hoặc bất kỳ lĩnh vực nào đòi hỏi sự kết hợp giữa sáng tạo và thực tế.";
            default:
                return "Con số định mệnh " + number + " - Mang những đặc điểm độc đáo và cần được khám phá thêm.";
        }
    }

    private String getSoulUrgeDescription(int number) {
        switch (number) {
            case 1:
                return "Con số tâm hồn 1 - Khao khát độc lập\n\nBạn có khao khát mạnh mẽ về sự độc lập và tự do. Muốn được công nhận và tôn trọng. Trong tình yêu, bạn cần một người bạn đời hiểu và ủng hộ tham vọng của mình.";
            case 2:
                return "Con số tâm hồn 2 - Khao khát hòa hợp\n\nBạn khao khát sự hòa hợp và kết nối với người khác. Cần được yêu thương và cảm thấy thuộc về. Trong tình yêu, bạn là người đồng hành tuyệt vời, luôn tìm cách duy trì sự cân bằng.";
            case 3:
                return "Con số tâm hồn 3 - Khao khát sáng tạo\n\nBạn khao khát được thể hiện bản thân và sáng tạo. Cần được chú ý và đánh giá cao. Trong tình yêu, bạn cần một người bạn đời có thể chia sẻ và cổ vũ những ý tưởng sáng tạo của mình.";
            case 4:
                return "Con số tâm hồn 4 - Khao khát ổn định\n\nBạn khao khát sự ổn định và an toàn. Cần một môi trường có trật tự và có thể dự đoán được. Trong tình yêu, bạn tìm kiếm một mối quan hệ bền vững và đáng tin cậy.";
            case 5:
                return "Con số tâm hồn 5 - Khao khát tự do\n\nBạn khao khát tự do và những trải nghiệm mới. Sợ bị ràng buộc và thích thay đổi. Trong tình yêu, bạn cần một người bạn đời hiểu và tôn trọng nhu cầu tự do của mình.";
            case 6:
                return "Con số tâm hồn 6 - Khao khát chăm sóc\n\nBạn khao khát được chăm sóc và yêu thương người khác. Cần cảm thấy mình hữu ích và cần thiết. Trong tình yêu, bạn là người bạn đời tận tụy, luôn đặt gia đình lên hàng đầu.";
            case 7:
                return "Con số tâm hồn 7 - Khao khát hiểu biết\n\nBạn khao khát hiểu biết sâu sắc về cuộc sống. Cần thời gian riêng để suy ngẫm và tìm hiểu. Trong tình yêu, bạn cần một người bạn đời có thể hiểu được thế giới nội tâm phong phú của mình.";
            case 8:
                return "Con số tâm hồn 8 - Khao khát thành công\n\nBạn khao khát thành công và được công nhận về mặt vật chất. Cần cảm thấy mình có quyền lực và ảnh hưởng. Trong tình yêu, bạn cần một người bạn đời ủng hộ và hiểu được tham vọng của mình.";
            case 9:
                return "Con số tâm hồn 9 - Khao khát cống hiến\n\nBạn khao khát được cống hiến cho nhân loại. Cần cảm thấy mình đang làm điều gì đó có ý nghĩa. Trong tình yêu, bạn cần một người bạn đời có cùng lý tưởng và giá trị sống.";
            case 11:
                return "Con số tâm hồn 11 - Khao khát truyền cảm hứng\n\nBạn khao khát truyền cảm hứng và giúp đỡ người khác. Có trực giác mạnh mẽ và cần được hiểu. Trong tình yêu, bạn cần một người bạn đời có thể kết nối với tâm hồn nhạy cảm của mình.";
            case 22:
                return "Con số tâm hồn 22 - Khao khát kiến tạo\n\nBạn khao khát tạo ra những thay đổi lớn lao trong thế giới. Cần cảm thấy mình đang xây dựng điều gì đó vĩ đại. Trong tình yêu, bạn cần một người bạn đời có thể hiểu và ủng hộ tầm nhìn lớn lao của mình.";
            default:
                return "Con số tâm hồn " + number + " - Mang những khao khát độc đáo cần được khám phá.";
        }
    }

    private String getPersonalityDescription(int number) {
        switch (number) {
            case 1:
                return "Tính cách 1 - Người tự tin\n\nBạn có vẻ ngoài tự tin và quyết đoán. Người khác thấy bạn là người mạnh mẽ, độc lập và có khả năng lãnh đạo. Bạn thường để lại ấn tượng đầu tiên là một người có thể dựa vào và tin tưởng.";
            case 2:
                return "Tính cách 2 - Người hòa nhã\n\nBạn có vẻ ngoài nhẹ nhàng và thân thiện. Người khác thấy bạn là người dễ gần, kiên nhẫn và có khả năng lắng nghe. Bạn thường được người khác tìm đến khi họ cần lời khuyên hoặc sự an ủi.";
            case 3:
                return "Tính cách 3 - Người vui vẻ\n\nBạn có vẻ ngoài vui vẻ và hấp dẫn. Người khác thấy bạn là người thú vị, sáng tạo và có khả năng giải trí. Bạn thường là tâm điểm của buổi tiệc và có thể khiến người khác cảm thấy thoải mái.";
            case 4:
                return "Tính cách 4 - Người đáng tin cậy\n\nBạn có vẻ ngoài ổn định và đáng tin cậy. Người khác thấy bạn là người thực tế, chăm chỉ và có thể tin tưởng. Bạn thường được người khác nhờ vả khi họ cần một người có thể hoàn thành công việc một cách chắc chắn.";
            case 5:
                return "Tính cách 5 - Người năng động\n\nBạn có vẻ ngoài năng động và thích thú. Người khác thấy bạn là người linh hoạt, thích phiêu lưu và luôn sẵn sàng cho những trải nghiệm mới. Bạn thường thu hút những người yêu thích sự tự do và khám phá.";
            case 6:
                return "Tính cách 6 - Người ấm áp\n\nBạn có vẻ ngoài ấm áp và quan tâm. Người khác thấy bạn là người có trách nhiệm, đáng tin cậy và luôn sẵn sàng giúp đỡ. Bạn thường được người khác tìm đến khi họ cần sự chăm sóc và hỗ trợ.";
            case 7:
                return "Tính cách 7 - Người bí ẩn\n\nBạn có vẻ ngoài bí ẩn và sâu sắc. Người khác thấy bạn là người thông minh, trầm tư và có chiều sâu. Bạn thường thu hút những người đánh giá cao trí tuệ và sự hiểu biết.";
            case 8:
                return "Tính cách 8 - Người quyền lực\n\nBạn có vẻ ngoài mạnh mẽ và thành công. Người khác thấy bạn là người có tham vọng, quyết đoán và có khả năng đạt được mục tiêu. Bạn thường để lại ấn tượng là một người có thể thành công trong kinh doanh.";
            case 9:
                return "Tính cách 9 - Người từ ái\n\nBạn có vẻ ngoài từ bi và rộng lượng. Người khác thấy bạn là người có tâm hồn nhân ái, hiểu biết và luôn sẵn sàng giúp đỡ. Bạn thường thu hút những người có cùng giá trị về sự phục vụ cộng đồng.";
            case 11:
                return "Tính cách 11 - Người truyền cảm hứng\n\nBạn có vẻ ngoài đặc biệt và thu hút. Người khác thấy bạn là người có trực giác mạnh mẽ, nhạy cảm và có thể truyền cảm hứng. Bạn thường để lại ấn tượng sâu sắc và khó quên.";
            case 22:
                return "Tính cách 22 - Người kiến tạo\n\nBạn có vẻ ngoài ấn tượng và có tầm nhìn. Người khác thấy bạn là người có khả năng biến ước mơ thành hiện thực và tạo ra những thay đổi lớn. Bạn thường thu hút những người có cùng tầm nhìn về tương lai.";
            default:
                return "Tính cách " + number + " - Mang những đặc điểm độc đáo trong cách thể hiện bản thân.";
        }
    }

    private String getBirthDayDescription(int number) {
        switch (number) {
            case 1:
                return "Ngày sinh 1 - Tài năng lãnh đạo tiên phong\n\nBạn có tài năng lãnh đạo tự nhiên và khả năng khởi xướng. Thích làm việc độc lập và thường là người tiên phong trong các ý tưởng mới. Bạn thành công khi được giao trách nhiệm lớn.";
            case 2:
                return "Ngày sinh 2 - Tài năng hợp tác nhạy cảm\n\nBạn có tài năng làm việc nhóm và khả năng hòa giải tinh tế. Thích môi trường yên bình và thường là cầu nối giữa mọi người. Bạn thành công khi làm việc với người khác.";
            case 3:
                return "Ngày sinh 3 - Tài năng giao tiếp sáng tạo\n\nBạn có tài năng giao tiếp và khả năng sáng tạo độc đáo. Thích thể hiện bản thân qua nghệ thuật hoặc lời nói. Bạn thành công trong các lĩnh vực sáng tạo và truyền cảm hứng.";
            case 4:
                return "Ngày sinh 4 - Tài năng tổ chức chắc chắn\n\nBạn có tài năng tổ chức và khả năng xây dựng nền tảng vững chắc. Thích làm việc có kế hoạch và tỉ mỉ. Bạn thành công với các nhiệm vụ đòi hỏi sự kiên nhẫn.";
            case 5:
                return "Ngày sinh 5 - Tài năng thích nghi linh hoạt\n\nBạn có tài năng thích nghi và khả năng đối phó với thay đổi nhanh chóng. Thích tự do và khám phá mới. Bạn thành công trong môi trường năng động.";
            case 6:
                return "Ngày sinh 6 - Tài năng chăm sóc ấm áp\n\nBạn có tài năng chăm sóc và khả năng tạo sự hài hòa. Thích giúp đỡ gia đình hoặc cộng đồng. Bạn thành công khi làm việc với con người và xây dựng mối quan hệ.";
            case 7:
                return "Ngày sinh 7 - Tài năng phân tích sâu sắc\n\nBạn có tài năng phân tích và khả năng nghiên cứu chi tiết. Thích làm việc một mình và tìm kiếm tri thức. Bạn thành công với các vấn đề phức tạp.";
            case 8:
                return "Ngày sinh 8 - Tài năng quản lý mạnh mẽ\n\nBạn có tài năng quản lý và khả năng kinh doanh thực tế. Thích quyền lực và thành công vật chất. Bạn thành công trong các vai trò lãnh đạo hoặc kinh doanh.";
            case 9:
                return "Ngày sinh 9 - Tài năng phục vụ nhân đạo\n\nBạn có tài năng phục vụ và khả năng thấu hiểu. Thích làm việc vì lợi ích lớn hơn. Bạn thành công khi cống hiến cho cộng đồng.";
            case 10:
                return "Ngày sinh 10 - Tài năng lãnh đạo độc lập\n\nBạn có tài năng lãnh đạo kết hợp với sự sáng tạo. Thích bắt đầu dự án mới và tự tin trong quyết định. Bạn thành công khi kết hợp độc lập và đổi mới.";
            case 11:
                return "Ngày sinh 11 - Tài năng trực giác cao\n\nBạn có tài năng trực giác và khả năng nhạy cảm sâu sắc. Thích làm việc với các vấn đề tâm linh. Bạn thành công khi tin vào trực giác của mình.";
            case 12:
                return "Ngày sinh 12 - Tài năng sáng tạo hài hòa\n\nBạn có tài năng sáng tạo và khả năng hòa giải. Thích kết nối mọi người qua nghệ thuật. Bạn thành công khi kết hợp cảm xúc và sáng tạo.";
            case 13:
                return "Ngày sinh 13 - Tài năng tổ chức đổi mới\n\nBạn có tài năng tổ chức và khả năng vượt qua thử thách. Thích thay đổi để cải thiện. Bạn thành công với các dự án đòi hỏi sự kiên trì.";
            case 14:
                return "Ngày sinh 14 - Tài năng thích nghi tự do\n\nBạn có tài năng thích nghi và khả năng linh hoạt cao. Thích khám phá và thay đổi liên tục. Bạn thành công trong môi trường không ổn định.";
            case 15:
                return "Ngày sinh 15 - Tài năng chăm sóc nghệ thuật\n\nBạn có tài năng chăm sóc kết hợp với sự sáng tạo. Thích làm đẹp cho cuộc sống. Bạn thành công khi kết hợp tình yêu và thẩm mỹ.";
            case 16:
                return "Ngày sinh 16 - Tài năng phân tích sâu\n\nBạn có tài năng phân tích và khả năng tự phản ánh. Thích tìm hiểu bản thân và thế giới. Bạn thành công với các nghiên cứu nội tâm.";
            case 17:
                return "Ngày sinh 17 - Tài năng lãnh đạo tinh thần\n\nBạn có tài năng lãnh đạo kết hợp với trực giác. Thích truyền cảm hứng cho người khác. Bạn thành công khi dẫn dắt với tầm nhìn.";
            case 18:
                return "Ngày sinh 18 - Tài năng phục vụ sáng tạo\n\nBạn có tài năng phục vụ và khả năng nghệ thuật. Thích giúp đỡ qua sáng tạo. Bạn thành công khi kết hợp lý tưởng và hành động.";
            case 19:
                return "Ngày sinh 19 - Tài năng lãnh đạo độc lập\n\nBạn có tài năng lãnh đạo mạnh mẽ và tự chủ. Thích làm việc riêng và đạt thành tựu cá nhân. Bạn thành công khi tự lập.";
            case 20:
                return "Ngày sinh 20 - Tài năng hợp tác nhạy bén\n\nBạn có tài năng làm việc nhóm và khả năng nhạy cảm. Thích hỗ trợ người khác. Bạn thành công trong các mối quan hệ.";
            case 21:
                return "Ngày sinh 21 - Tài năng giao tiếp vui vẻ\n\nBạn có tài năng giao tiếp và khả năng lan tỏa niềm vui. Thích kết nối xã hội. Bạn thành công trong các môi trường thân thiện.";
            case 22:
                return "Ngày sinh 22 - Tài năng kiến tạo vĩ đại\n\nBạn có tài năng kiến tạo và khả năng thực hiện tầm nhìn lớn. Thích làm việc với mục tiêu dài hạn. Bạn thành công với các dự án lớn.";
            case 23:
                return "Ngày sinh 23 - Tài năng thích nghi sáng tạo\n\nBạn có tài năng thích nghi và khả năng đổi mới. Thích khám phá và phát triển. Bạn thành công trong các lĩnh vực năng động.";
            case 24:
                return "Ngày sinh 24 - Tài năng chăm sóc gia đình\n\nBạn có tài năng chăm sóc và xây dựng gia đình. Thích tạo sự ổn định. Bạn thành công khi làm việc với người thân yêu.";
            case 25:
                return "Ngày sinh 25 - Tài năng phân tích trực giác\n\nBạn có tài năng phân tích kết hợp với trực giác. Thích nghiên cứu sâu và cảm nhận. Bạn thành công với các vấn đề phức tạp.";
            case 26:
                return "Ngày sinh 26 - Tài năng quản lý thực tế\n\nBạn có tài năng quản lý và khả năng tổ chức tài chính. Thích xây dựng sự ổn định. Bạn thành công trong kinh doanh.";
            case 27:
                return "Ngày sinh 27 - Tài năng phục vụ trí tuệ\n\nBạn có tài năng phục vụ và khả năng truyền đạt tri thức. Thích giúp đỡ qua giáo dục. Bạn thành công khi chia sẻ.";
            case 28:
                return "Ngày sinh 28 - Tài năng lãnh đạo mạnh mẽ\n\nBạn có tài năng lãnh đạo và khả năng cạnh tranh. Thích vượt qua thử thách. Bạn thành công trong các vai trò quyền lực.";
            case 29:
                return "Ngày sinh 29 - Tài năng phục vụ nhạy cảm\n\nBạn có tài năng phục vụ và khả năng cảm xúc sâu sắc. Thích giúp đỡ người khác. Bạn thành công khi kết nối tình cảm.";
            case 30:
                return "Ngày sinh 30 - Tài năng giao tiếp nghệ thuật\n\nBạn có tài năng giao tiếp và khả năng sáng tạo cao. Thích thể hiện qua nghệ thuật. Bạn thành công trong các lĩnh vực biểu diễn.";
            case 31:
                return "Ngày sinh 31 - Tài năng lãnh đạo sáng tạo\n\nBạn có tài năng lãnh đạo và khả năng đổi mới. Thích làm việc độc lập với ý tưởng mới. Bạn thành công khi tự do sáng tạo.";
            default:
                return "Ngày sinh " + number + " - Mang những tài năng độc đáo cần được khám phá.";
        }
    }

    // Các phương thức tính toán giữ nguyên
    private int calculateDestinyNumber(String birthDate) {
        try {
            String[] parts = birthDate.split("/");
            if (parts.length != 3) {
                Log.e(TAG, "Invalid birth date format: " + birthDate);
                return 0;
            }
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            int sum = day + month + year;
            while (sum > 9 && sum != 11 && sum != 22) {
                sum = sumOfDigits(sum);
            }
            Log.d(TAG, "Destiny Number calculated: " + sum + " from " + birthDate);
            return sum;
        } catch (Exception e) {
            Log.e(TAG, "Error calculating Destiny Number", e);
            return 0;
        }
    }

    private int calculateBirthDayNumber(String birthDate) {
        try {
            String[] parts = birthDate.split("/");
            int day = Integer.parseInt(parts[0]);
            int sum = sumOfDigits(day);
            while (sum > 9 && sum != 11 && sum != 22) {
                sum = sumOfDigits(sum);
            }
            Log.d(TAG, "Birth Day Number calculated: " + sum + " from " + birthDate);
            return sum;
        } catch (Exception e) {
            Log.e(TAG, "Error calculating Birth Day Number", e);
            return 0;
        }
    }

    private int calculateSoulUrgeNumber(String name) {
        try {
            int sum = 0;
            name = name.toUpperCase();
            for (char c : name.toCharArray()) {
                switch (c) {
                    case 'A': sum += 1; break;
                    case 'E': sum += 5; break;
                    case 'I': sum += 9; break;
                    case 'O': sum += 15; break;
                    case 'U': sum += 21; break;
                }
            }
            while (sum > 9 && sum != 11 && sum != 22) {
                sum = sumOfDigits(sum);
            }
            Log.d(TAG, "Soul Urge Number calculated: " + sum + " from " + name);
            return sum;
        } catch (Exception e) {
            Log.e(TAG, "Error calculating Soul Urge Number", e);
            return 0;
        }
    }

    private int calculatePersonalityNumber(String name) {
        try {
            int sum = 0;
            name = name.toUpperCase();
            for (char c : name.toCharArray()) {
                if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    sum += c - 'A' + 1;
                }
            }
            while (sum > 9 && sum != 11 && sum != 22) {
                sum = sumOfDigits(sum);
            }
            Log.d(TAG, "Personality Number calculated: " + sum + " from " + name);
            return sum;
        } catch (Exception e) {
            Log.e(TAG, "Error calculating Personality Number", e);
            return 0;
        }
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}