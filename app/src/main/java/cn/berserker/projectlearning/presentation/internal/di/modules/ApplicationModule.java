package cn.berserker.projectlearning.presentation.internal.di.modules;

import android.content.Context;

import cn.berserker.projectlearning.presentation.LearningApp;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final LearningApp application;

    public ApplicationModule(LearningApp application) {
        this.application = application;
    }

    @Provides
    public Context provideContext() {
        return application.getApplicationContext();
    }
}
