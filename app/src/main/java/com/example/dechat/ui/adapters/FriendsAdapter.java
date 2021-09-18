package com.example.dechat.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dechat.databinding.ItemFriendsBinding;
import com.example.dechat.models.Friend;
import com.example.dechat.ui.interfaces.FriendViewHolderListener;
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
        return new FriendViewHolder(ItemFriendsBinding
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
        private final ItemFriendsBinding binding;

        public FriendViewHolder(final ItemFriendsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Friend friend, FriendViewHolderListener listener){
            binding.friendName.setText(friend.getFriendName());
            binding.lastChat.setText(friend.getLastMessage());

            binding.friendCard.setOnClickListener(v -> {
                listener.onItemClicked(friend);
            });
        }
    }
}
