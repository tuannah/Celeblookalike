package com.example.celeblookalike;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnRegister;
    TextView txtBackToLogin;
    UserDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtBackToLogin = findViewById(R.id.txtBackToLogin);
        db = new UserDatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            // Validate dữ liệu
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!db.validateInput(email, password)) {
                Toast.makeText(this, "Email không hợp lệ hoặc mật khẩu cần ít nhất 6 ký tự, chứa chữ và số", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                // First, check if email already exists
                if (db.checkEmailExists(email)) {
                    Toast.makeText(this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
                } else {
                    // If not, proceed with insertion
                    boolean success = db.insertUser(email, password);
                    if (success) {
                        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

                        // ✅ THAY ĐỔI: Chỉ đóng RegisterActivity, để quay về LoginActivity cũ
                        finish();

                        // ❌ XÓA BỎ: Không tạo LoginActivity mới
                        // Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        // startActivity(intent);
                        // finish();
                    } else {
                        // This message now correctly refers to a general insertion error
                        Toast.makeText(this, "Lỗi đăng ký, vui lòng thử lại", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception e) {
                Toast.makeText(this, "Lỗi hệ thống, vui lòng thử lại", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

        });

        txtBackToLogin.setOnClickListener(v -> {
            // ✅ THAY ĐỔI: Chỉ đóng RegisterActivity, để quay về LoginActivity cũ
            finish();

            // ❌ XÓA BỎ: Không tạo LoginActivity mới
            // Intent intent = new Intent(this, LoginActivity.class);
            // startActivity(intent);
            // finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null) {
            db.close();
        }
    }
}