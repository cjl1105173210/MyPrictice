package com.example.MyPrictice.global;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;

import java.io.File;
import java.util.List;
/**
 * created by caijiulong on 2019/6/18
 * function:
 **/
public class GlobalConfiguration implements ConfigModule{
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        //使用 builder 可以为框架配置一些配置信息
        builder.baseurl("http://www.topeasypark.com")
                .cacheFile(new File("cache"));
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
         //向 Application的 生命周期中注入一些自定义逻辑
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }
}
