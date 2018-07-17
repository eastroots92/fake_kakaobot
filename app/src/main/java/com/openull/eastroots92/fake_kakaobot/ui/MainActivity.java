package com.openull.eastroots92.fake_kakaobot.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.openull.eastroots92.fake_kakaobot.R;

public class MainActivity extends AppCompatActivity {

  private EditText editText_input;
  private Button button_sned;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    init();
  }

  private void init() {
    editText_input = findViewById(R.id.editText_input);
    sendButtonListener();
  }

  private void sendButtonListener() {
    button_sned = findViewById(R.id.button_send);

    button_sned.setOnClickListener( (__) -> {
      String currentMessage = editText_input.getText().toString();

      Toast.makeText(this, currentMessage, Toast.LENGTH_SHORT).show();
    });
  }
}
