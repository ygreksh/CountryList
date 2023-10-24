package com.example.countrylist.ui.details;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import static androidx.lifecycle.SavedStateHandleSupport.createSavedStateHandle;
import static androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY;

import com.example.countrylist.App;

public class DetailsFragmentViewModel extends ViewModel {
    public DetailsFragmentViewModel(
//            CountryRepository repository,
            SavedStateHandle savedStateHandle
    ) {
    }

//    static final ViewModelInitializer<DetailsFragmentViewModel> initializer = new ViewModelInitializer<>(
//            DetailsFragmentViewModel.class,
//            creationExtras -> {
//                App app = (App) creationExtras.get(APPLICATION_KEY);
//                assert app != null;
//                SavedStateHandle savedStateHandle = createSavedStateHandle(creationExtras);
//
//                return new DetailsFragmentViewModel(
////                        app.getRepository(),
//                        savedStateHandle
//                );
//            }
//    );

}
