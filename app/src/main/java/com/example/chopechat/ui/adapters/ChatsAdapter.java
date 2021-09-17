package com.example.chopechat.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.chopechat.R;
import com.example.chopechat.databinding.ItemChatReceiveBinding;
import com.example.chopechat.databinding.ItemChatSendBinding;
import com.example.chopechat.models.Chat;
import java.util.ArrayList;
import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Chat> chats = new ArrayList<>();

    public void update(List<Chat> chats){
        this.chats = chats;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == R.layout.item_chat_send) return new ChatSendHolder(ItemChatSendBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
        else return new ChatReceiveHolder(ItemChatReceiveBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChatSendHolder) ((ChatSendHolder) holder).bind(chats.get(position));
        if (holder instanceof ChatReceiveHolder) ((ChatReceiveHolder) holder).bind(chats.get(position));
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (chats.get(position).isSent()) return R.layout.item_chat_send;
        else return R.layout.item_chat_receive;
    }

    static class ChatReceiveHolder extends RecyclerView.ViewHolder{

        private final ItemChatReceiveBinding receiveBinding;

        public ChatReceiveHolder(@NonNull ItemChatReceiveBinding receiveBinding) {
            super(receiveBinding.getRoot());
            this.receiveBinding = receiveBinding;
        }

        void bind(Chat chat){
            receiveBinding.name.setText(chat.getFriendName());
            receiveBinding.message.setText(chat.getMessage());
        }
    }

    static class ChatSendHolder extends RecyclerView.ViewHolder{
        private final ItemChatSendBinding sendBinding;

        public ChatSendHolder(@NonNull ItemChatSendBinding sendBinding) {
            super(sendBinding.getRoot());
            this.sendBinding = sendBinding;
        }

        void bind(Chat chat){
            sendBinding.message.setText(chat.getMessage());
        }
    }
}
