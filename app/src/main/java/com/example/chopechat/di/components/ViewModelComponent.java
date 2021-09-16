package com.example.chopechat.di.components;

import com.example.chopechat.di.modules.CompositeDisposableModule;
import com.example.chopechat.di.scopes.CoreScope;
import com.example.chopechat.viewmodels.ChatViewModel;
import dagger.Component;

@Component(
        dependencies = {CoreComponent.class},
        modules = {CompositeDisposableModule.class}
)
@CoreScope
public interface ViewModelComponent {

    @Component.Factory
    interface Factory{
        ViewModelComponent create(CoreComponent coreComponent);
    }

    void inject(ChatViewModel chatViewModel);

    // Add inject to other viewModel in here, when there is any
}
