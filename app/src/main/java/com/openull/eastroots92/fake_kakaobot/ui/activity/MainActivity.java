package com.openull.eastroots92.fake_kakaobot.ui.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.openull.eastroots92.fake_kakaobot.R;
import com.openull.eastroots92.fake_kakaobot.model.Chat;
import com.openull.eastroots92.fake_kakaobot.ui.adapter.ChattingAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private EditText editText_input;
  private Button button_sned;
  private List<Chat> chats;
  private RecyclerView recyclerView_chatting;
  private ChattingAdapter chattingAdapter;

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

      handleChatSubmit(currentMessage);
      clearInput();

//      Fake 동작을 위해 추가
      fakeBotTalk();
    });
  }

  private void initChattingRecyclerView() {
    chats = new ArrayList<>();
    recyclerView_chatting = findViewById(R.id.recyclerView_chatting);

    recyclerView_chatting.setLayoutManager(new LinearLayoutManager(this));
    chattingAdapter = new ChattingAdapter(getApplicationContext(), chats);
    recyclerView_chatting.setAdapter(chattingAdapter);
  }

  private void handleChatSubmit(String currentMessage){
    Chat chat = new Chat();
    chat.setSpeech(currentMessage);
    chat.setViewType(1);

    appendChat(chat);
  }

  private void clearInput() {
    editText_input.setText("");
  }

  private void appendChat(Chat chat) {
    this.chats.add(chat);

    this.chattingAdapter.notifyItemInserted(this.chats.size() -1);
    recyclerView_chatting.scrollToPosition(this.chats.size() -1);
  }

  private void fakeBotTalk() {
    new Handler().postDelayed(() -> {
      Chat chat = new Chat();
      chat.setSpeech("뭐라는 건지 1도 모르겠음");
      chat.setViewType(2);

      appendChat(chat);
    }, 500);
  }
}
