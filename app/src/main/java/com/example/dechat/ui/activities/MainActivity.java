package com.example.dechat.ui.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.dechat.base.BaseApplication;
import com.example.dechat.databinding.ActivityMainBinding;
import com.example.dechat.di.components.DaggerViewModelComponent;
import com.example.dechat.viewmodels.ChatViewModel;

public class MainActivity extends AppCompatActivity {

    private ChatViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ChatViewModel.class);
        DaggerViewModelComponent.factory()
                .create(((BaseApplication)getApplicationContext()).appComponent)
                .inject(viewModel);

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Add Jone and Kent
        viewModel.addRandomFriends();
    }
}
