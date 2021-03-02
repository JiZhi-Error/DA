package com.tencent.tinker.entry;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.tinker.anno.Keep;

@Keep
public abstract class ApplicationLike implements ApplicationLifeCycle {
    private final Application application;
    private final long applicationStartElapsedTime;
    private final long applicationStartMillisTime;
    private final int tinkerFlags;
    private final boolean tinkerLoadVerifyFlag;
    private final Intent tinkerResultIntent;

    public ApplicationLike(Application application2, int i2, boolean z, long j2, long j3, Intent intent) {
        this.application = application2;
        this.tinkerFlags = i2;
        this.tinkerLoadVerifyFlag = z;
        this.applicationStartElapsedTime = j2;
        this.applicationStartMillisTime = j3;
        this.tinkerResultIntent = intent;
    }

    public Application getApplication() {
        return this.application;
    }

    public final Intent getTinkerResultIntent() {
        return this.tinkerResultIntent;
    }

    public final int getTinkerFlags() {
        return this.tinkerFlags;
    }

    public final boolean getTinkerLoadVerifyFlag() {
        return this.tinkerLoadVerifyFlag;
    }

    public long getApplicationStartElapsedTime() {
        return this.applicationStartElapsedTime;
    }

    public long getApplicationStartMillisTime() {
        return this.applicationStartMillisTime;
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i2) {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
    }

    @Keep
    public Resources getResources(Resources resources) {
        return resources;
    }

    @Keep
    public ClassLoader getClassLoader(ClassLoader classLoader) {
        return classLoader;
    }

    @Keep
    public AssetManager getAssets(AssetManager assetManager) {
        return assetManager;
    }

    @Keep
    public Object getSystemService(String str, Object obj) {
        return obj;
    }

    @Keep
    public Context getBaseContext(Context context) {
        return context;
    }

    @Keep
    public int mzNightModeUseOf() {
        return 1;
    }
}
