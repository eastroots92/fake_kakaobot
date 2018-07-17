package com.openull.eastroots92.fake_kakaobot.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openull.eastroots92.fake_kakaobot.R;
import com.openull.eastroots92.fake_kakaobot.model.Chat;

import java.util.List;

public class ChattingAdapter extends RecyclerView.Adapter<ChattingAdapter.ChattingHolder> {

  private Context context;
  private List<Chat> chatData;

  public ChattingAdapter(Context applicationContext, List<Chat> chats) {
    this.context = applicationContext;
    this.chatData = chats;
  }

  @NonNull
  @Override
  public ChattingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.item_my_talk, parent, false);

    return new ChattingHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ChattingHolder chattingHolder, int position) {
    Chat chat = this.chatData.get(position);

    chattingHolder.textView_myTalk.setText(chat.getSpeech());
  }

  @Override
  public int getItemCount() {
    return chatData.size();
  }

  public class ChattingHolder extends RecyclerView.ViewHolder {
    TextView textView_myTalk;

    public ChattingHolder(@NonNull View itemView) {
      super(itemView);

      textView_myTalk = itemView.findViewById(R.id.textView_myTalk);
    }
  }
}
