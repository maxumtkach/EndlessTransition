package com.example.endlesstransition;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView messagePhoto;
    Random random ;

    int min = 0;
      int max = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_main);

         random = new Random(System.currentTimeMillis());  //инициализация переменных
              int numberItem = min + random.nextInt(max - min + 1);
                   String photoString = getResources().getString(R.string.photo);


        messagePhoto = findViewById(R.id.text_message_photo);
            messagePhoto.setText(getString(R.string.welcome_messages,photoString,numberItem));

        Button clickStartButton = findViewById(R.id.button_start);
             clickStartButton.setOnClickListener(clickStartListener);

        Button clickEndButton = findViewById(R.id.button_end);
               clickEndButton.setOnClickListener(clickEndListener);
    }

    private final View.OnClickListener clickStartListener = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {

            finish();
        }

    };

    private final View.OnClickListener clickEndListener = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
        }
    };
}
