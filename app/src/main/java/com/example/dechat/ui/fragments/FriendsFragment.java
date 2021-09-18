package com.example.dechat.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.example.dechat.R;
import com.example.dechat.databinding.FragmentFriendsBinding;
import com.example.dechat.models.Friend;
import com.example.dechat.ui.adapters.FriendsAdapter;
import com.example.dechat.ui.interfaces.FriendViewHolderListener;
import com.example.dechat.viewmodels.ChatViewModel;

import java.util.List;

public class FriendsFragment extends Fragment implements FriendViewHolderListener {
    private ChatViewModel viewModel;

    private FragmentFriendsBinding binding;
    private FriendsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ChatViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendsBinding.inflate(inflater, container, false);
        adapter = new FriendsAdapter(this);
        binding.recyclerView.setAdapter(adapter);

        setDataObserver();
        return binding.getRoot();
    }

    @Override
    public void onItemClicked(Friend friend) {
        viewModel.selectedFriend = friend;

        // navigate to chats fragment
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.friends_to_chats_action);
    }

    void setDataObserver() {
        viewModel.friendsLiveData.observe(requireActivity(), response -> {
            switch (response.getStatus()) {
                case LOADING:
                    break;

                case SUCCESS:
                    adapter.update((List<Friend>) response.getData());
                    break;

                case ERROR:
                    break;
            }
        });
        viewModel.loadFriends();
    }
}