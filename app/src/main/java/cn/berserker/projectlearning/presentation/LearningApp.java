package cn.berserker.projectlearning.presentation;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import cn.berserker.projectlearning.BuildConfig;
import timber.log.Timber;

/**
 *
 */
public class LearningApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


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
