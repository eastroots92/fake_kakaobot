package com.openull.eastroots92.fake_kakaobot.ui.activity;

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

    appendChat(chat);
  }

  private void appendChat(Chat chat) {
    this.chats.add(chat);
    this.chattingAdapter.notifyItemInserted(this.chats.size() -1);
  }


}
