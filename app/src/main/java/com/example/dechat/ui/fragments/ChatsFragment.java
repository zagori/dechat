package com.example.dechat.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.dechat.databinding.FragmentChatsBinding;
import com.example.dechat.models.Chat;
import com.example.dechat.ui.adapters.ChatsAdapter;
import com.example.dechat.viewmodels.ChatViewModel;

import java.util.List;

public class ChatsFragment extends Fragment {
    private ChatViewModel viewModel;

    private FragmentChatsBinding binding;
    private ChatsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ChatViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatsBinding.inflate(inflater, container, false);

        binding.toolbar.setTitle(viewModel.selectedFriend.getFriendName());
        binding.toolbar.setNavigationOnClickListener(v -> requireActivity().onBackPressed());

        adapter = new ChatsAdapter();
        binding.recyclerView.setAdapter(adapter);

        binding.sendBtn.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(binding.messageInput.getText())) {
                viewModel.addChats(new Chat(binding.messageInput.getText().toString(), true,
                        System.nanoTime(), viewModel.selectedFriend.getFriendName()));
            }
        });

        setDataObserver();

        return binding.getRoot();
    }

    void setDataObserver() {
        viewModel.chatsLiveData.observe(requireActivity(), response -> {
            switch (response.getStatus()) {
                case LOADING:
                    break;

                case SUCCESS:
                    adapter.update((List<Chat>) response.getData());
                    binding.messageInput.setText("");
                    break;

                case ERROR:
                    break;
            }
        });
        viewModel.loadChats(viewModel.selectedFriend.getFriendName());
    }
}