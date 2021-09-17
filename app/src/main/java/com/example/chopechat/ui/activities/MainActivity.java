package com.example.chopechat.ui.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.chopechat.base.BaseApplication;
import com.example.chopechat.databinding.ActivityMainBinding;
import com.example.chopechat.di.components.DaggerViewModelComponent;
import com.example.chopechat.viewmodels.ChatViewModel;

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



        /*viewModel.getChatsLiveData().observe(this, response -> {
            switch (response.getStatus()){
                case LOADING:
                    break;
                case SUCCESS:
                    break;
                case ERROR:
                    break;
            }
        });*/

        viewModel.init();
    }
}
