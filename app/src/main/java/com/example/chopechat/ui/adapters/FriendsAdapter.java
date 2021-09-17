package com.example.chopechat.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.chopechat.databinding.ItemFriendsAdapterBinding;
import com.example.chopechat.models.Friend;
import com.example.chopechat.ui.interfaces.FriendViewHolderListener;
import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendViewHolder> {

    private List<Friend> friends = new ArrayList<>();
    private FriendViewHolderListener listener;

    public FriendsAdapter(FriendViewHolderListener listener) {
        this.listener = listener;
    }

    public void update(List<Friend> friends){
        this.friends = friends;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendViewHolder(ItemFriendsAdapterBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        holder.bind(friends.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    static class FriendViewHolder extends RecyclerView.ViewHolder{
        private final ItemFriendsAdapterBinding binding;

        public FriendViewHolder(final ItemFriendsAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Friend friend, FriendViewHolderListener listener){
            binding.friendName.setText(friend.getName());
            binding.lastChat.setText(friend.getLastMessage());

            binding.friendCard.setOnClickListener(v -> {
                listener.onItemClicked(v, getAdapterPosition());
            });
        }
    }
}
