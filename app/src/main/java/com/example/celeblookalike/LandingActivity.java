package com.example.celeblookalike;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    private static final String TAG = "LandingActivity";
    private Button signInButton;
    private Button attendanceButton;
    private UserDatabaseHelper dbHelper;
    private String loggedInEmail = null; // Save email of user

    // 1. Khai báo ActivityResultLauncher cho việc đăng nhập từ LoginActivity.
    private final ActivityResultLauncher<Intent> loginActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            loggedInEmail = data.getStringExtra("email");
                            if (loggedInEmail != null) {
                                // Đăng nhập thành công, chuyển tới MainActivity.
                                Intent intent = new Intent(LandingActivity.this, MainActivity.class);
                                intent.putExtra("email", loggedInEmail);
                                startActivity(intent);
                                finish(); // ✅ THÊM DÒNG NÀY - Đóng LandingActivity
                            } else {
                                Toast.makeText(LandingActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });

    // Launcher cho MainActivity
    private final ActivityResultLauncher<Intent> mainActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Log.d(TAG, "Returned from MainActivity with result code: " + result.getResultCode());
                // Xử lý kết quả trả về từ MainActivity nếu cần
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        dbHelper = new UserDatabaseHelper(this);
        signInButton = findViewById(R.id.sign_in_button);
        attendanceButton = findViewById(R.id.attendance_button);

        loggedInEmail = getIntent().getStringExtra("email");
        Log.d(TAG, "Initial loggedInEmail: " + loggedInEmail);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "signInButton clicked, loggedInEmail: " + loggedInEmail);
                if (loggedInEmail != null && dbHelper.isUserLoggedIn(loggedInEmail)) {
                    // Nếu đã đăng nhập, chuyển đến MainActivity.
                    Intent intent = new Intent(LandingActivity.this, MainActivity.class);
                    intent.putExtra("email", loggedInEmail);
                    startActivity(intent);
                    finish(); // ✅ THÊM DÒNG NÀY - Đóng LandingActivity khi đã đăng nhập
                } else {
                    // Nếu chưa đăng nhập, chuyển đến LoginActivity và chờ kết quả.
                    Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
                    loginActivityResultLauncher.launch(intent);
                }
            }
        });

        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "attendanceButton clicked, loggedInEmail: " + loggedInEmail);
                if (loggedInEmail != null && dbHelper.isUserLoggedIn(loggedInEmail)) {
                    Toast.makeText(LandingActivity.this, "Chức năng gọi đang phát triển", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu chưa đăng nhập, chuyển đến LoginActivity.
                    Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
                    loginActivityResultLauncher.launch(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}