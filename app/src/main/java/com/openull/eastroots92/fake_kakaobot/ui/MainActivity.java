package com.openull.eastroots92.fake_kakaobot.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.openull.eastroots92.fake_kakaobot.R;
import com.openull.eastroots92.fake_kakaobot.model.Chat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  private EditText editText_input;
  private Button button_sned;
  private List<Chat> chat;
  private RecyclerView recyclerView_chatting;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    init();
  }

  private void init() {
    editText_input = findViewById(R.id.editText_input);
    sendButtonListener();
    initChattingRecyclerView();
  }

  private void sendButtonListener() {
    button_sned = findViewById(R.id.button_send);

    button_sned.setOnClickListener( (__) -> {
      String currentMessage = editText_input.getText().toString();

      Toast.makeText(this, currentMessage, Toast.LENGTH_SHORT).show();
    });
  }

  private void initChattingRecyclerView() {
    recyclerView_chatting = findViewById(R.id.recyclerView_chatting);

    recyclerView_chatting.setLayoutManager(new LinearLayoutManager(this));
  }

  private void appendChat(Chat chat) {
    this.chat.add(chat);
  }


}
