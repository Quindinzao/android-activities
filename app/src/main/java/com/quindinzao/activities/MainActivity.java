package com.quindinzao.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTxtUsername = findViewById(R.id.editTxtUsername);
        EditText editTxtEmail = findViewById(R.id.editTxtNumberCode);
        Button btnSecondaryActivity = findViewById(R.id.btnSecondaryActivity);
        Button btnTertiaryActivity = findViewById(R.id.btnTertiaryActivity);
        Button btnUserActivity = findViewById(R.id.btnUserActivity);

        btnSecondaryActivity.setOnClickListener(v -> {
            String username = editTxtUsername.getText().toString();
            Intent intent = new Intent(this, SecondaryActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        btnTertiaryActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, TertiaryActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });

        btnUserActivity.setOnClickListener(v -> {
            String username = editTxtUsername.getText().toString();
            String email = editTxtEmail.getText().toString();

            User user = new User();
            user.setUsername(username);
            user.setEmail(email);

            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView txtNumberCode = findViewById(R.id.txtNumberCode);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                String numberCode = (String) data.getSerializableExtra("number_code");
                txtNumberCode.setText(numberCode);
            }
        }
    }
}