package com.example.celeblookalike;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnRegister;
    UserDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        db = new UserDatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {
            String email = edtEmail.getText().toString();
            String pass = edtPassword.getText().toString();

            if (db.registerUser(email, pass)) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish(); // Quay lại login
            } else {
                Toast.makeText(this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
