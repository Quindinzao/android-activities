package com.quindinzao.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class TertiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tertiary);

        EditText editTxtNumberCode = findViewById(R.id.editTxtNumberCode);
        Button btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            String numberCode = editTxtNumberCode.getText().toString();

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("number_code", numberCode);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}