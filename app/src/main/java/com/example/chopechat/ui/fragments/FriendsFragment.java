package com.example.chopechat.ui.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chopechat.R;
import com.example.chopechat.databinding.FragmentFriendsBinding;
import com.example.chopechat.models.Friend;
import com.example.chopechat.ui.adapters.FriendsAdapter;
import com.example.chopechat.ui.interfaces.FriendViewHolderListener;
import com.example.chopechat.viewmodels.ChatViewModel;

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
        binding = FragmentFriendsBinding.inflate(inflater,container,false);
        binding.toolbar.setTitle(getString(R.string.friends_toolbar_title));
        adapter = new FriendsAdapter(this);
        binding.recyclerView.setAdapter(adapter);

        setDataObserver();
        return binding.getRoot();
    }

    @Override
    public void onItemClicked(View view, int position) {
        // navigate to chats fragment
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.friends_to_chats_action);
    }

    void setDataObserver(){
        viewModel.friendsLiveData.observe(requireActivity(), response -> {
            switch (response.getStatus()){
                case LOADING:
                    break;
                case SUCCESS:
                    //viewModel.friends = response.getData();
                    adapter.update((List<Friend>) response.getData());
                    break;
                case ERROR:
                    break;
            }
        });
        viewModel.loadFriends();
    }
}