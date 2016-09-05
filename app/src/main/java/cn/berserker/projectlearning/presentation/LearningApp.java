package cn.berserker.projectlearning.presentation;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import cn.berserker.projectlearning.BuildConfig;
import cn.berserker.projectlearning.presentation.internal.di.components.ApplicationComponent;
import cn.berserker.projectlearning.presentation.internal.di.components.DaggerApplicationComponent;
import cn.berserker.projectlearning.presentation.internal.di.modules.ApplicationModule;
import timber.log.Timber;

/**
 *
 */
public class LearningApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent =
            DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(LearningApp.this)).build();

        //init timber.
        installTimber();
        initializeLeakDetection();
    }

    private void installTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

}
