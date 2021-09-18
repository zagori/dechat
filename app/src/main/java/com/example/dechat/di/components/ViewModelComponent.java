package com.example.dechat.di.components;

import com.example.dechat.di.modules.CompositeDisposableModule;
import com.example.dechat.di.scopes.CoreScope;
import com.example.dechat.viewmodels.ChatViewModel;
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
