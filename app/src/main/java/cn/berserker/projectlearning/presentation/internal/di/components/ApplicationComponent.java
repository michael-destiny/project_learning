package cn.berserker.projectlearning.presentation.internal.di.components;

import android.content.Context;

import cn.berserker.projectlearning.presentation.internal.di.modules.ApplicationModule;
import dagger.Component;

/**
 *
 */
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {
    //Exposed to sub-graphs.
    Context context();
}
