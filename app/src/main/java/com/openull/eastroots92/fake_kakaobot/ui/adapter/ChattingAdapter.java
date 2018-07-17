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

public class ChattingAdapter extends RecyclerView.Adapter{
  private static final int VIEW_TYPE_MESSAGE_MY = 1;
  private static final int VIEW_TYPE_MESSAGE_BOT = 2;

  private Context context;
  private List<Chat> chatData;

  public ChattingAdapter(Context applicationContext, List<Chat> chats) {
    this.context = applicationContext;
    this.chatData = chats;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view;

    if (viewType == VIEW_TYPE_MESSAGE_MY) {
      view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_my_talk, parent, false);
      return new MyChatHolder(view);
    } else if (viewType == VIEW_TYPE_MESSAGE_BOT) {
      view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_bot_talk, parent, false);
      return new BotChatHolder(view);
    }

    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
    Chat chat = chatData.get(position);

    switch (viewHolder.getItemViewType()) {
      case VIEW_TYPE_MESSAGE_MY:
        ((MyChatHolder) viewHolder).bind(chat);
        break;
      case VIEW_TYPE_MESSAGE_BOT:
        ((BotChatHolder) viewHolder).bind(chat);
    }

  }

  @Override
  public int getItemCount() {
    return chatData.size();
  }

  @Override
  public int getItemViewType(int position) {
    Chat chat = chatData.get(position);

    if (chat.getViewType() == 1) {
      return VIEW_TYPE_MESSAGE_MY;
    } else {
      return VIEW_TYPE_MESSAGE_BOT;
    }
  }

  private class MyChatHolder extends RecyclerView.ViewHolder {
    TextView textView_myTalk;

    MyChatHolder(@NonNull View itemView) {
      super(itemView);

      textView_myTalk = itemView.findViewById(R.id.textView_myTalk);
    }

    public void bind(Chat chat) {
      textView_myTalk.setText(chat.getSpeech());
    }
  }

  private class BotChatHolder extends RecyclerView.ViewHolder {
    TextView textView_botTalk;

    BotChatHolder(@NonNull View itemView) {
      super(itemView);

      textView_botTalk = itemView.findViewById(R.id.textView_botTalk);
    }

    public void bind(Chat chat) {
      textView_botTalk.setText(chat.getSpeech());
    }
  }
}
