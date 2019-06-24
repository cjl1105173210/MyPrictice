package com.example.MyPrictice.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.MyPrictice.mvp.contract.MainContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.MyPrictice.mvp.ui.activity.MainActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 06/18/2019 16:12
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = com.example.test.MyPrictice.di.module.MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MainComponent.Builder view(MainContract.View view);

        MainComponent.Builder appComponent(AppComponent appComponent);

        MainComponent build();
    }
}