package com.tencent.tinker.loader.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.tinker.anno.Keep;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.lang.reflect.Constructor;

public abstract class TinkerApplication extends Application {
    private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
    private static final TinkerApplication[] SELF_HOLDER = {null};
    private static final String TINKER_LOADER_METHOD = "tryLoad";
    private final String delegateClassName;
    private final String loaderClassName;
    protected ClassLoader mCurrentClassLoader;
    private Handler mInlineFence;
    private final int tinkerFlags;
    private final boolean tinkerLoadVerifyFlag;
    protected Intent tinkerResultIntent;
    private final boolean useDelegateLastClassLoader;
    private boolean useSafeMode;

    protected TinkerApplication(int i2) {
        this(i2, "com.tencent.tinker.entry.DefaultApplicationLike", TinkerLoader.class.getName(), false, false);
    }

    protected TinkerApplication(int i2, String str) {
        this(i2, str, TinkerLoader.class.getName(), false, false);
    }

    protected TinkerApplication(int i2, String str, String str2, boolean z, boolean z2) {
        this.mCurrentClassLoader = null;
        this.mInlineFence = null;
        synchronized (SELF_HOLDER) {
            SELF_HOLDER[0] = this;
        }
        this.tinkerFlags = i2;
        this.delegateClassName = str;
        this.loaderClassName = str2;
        this.tinkerLoadVerifyFlag = z;
        this.useDelegateLastClassLoader = z2;
    }

    public static TinkerApplication getInstance() {
        TinkerApplication tinkerApplication;
        synchronized (SELF_HOLDER) {
            if (SELF_HOLDER[0] == null) {
                throw new IllegalStateException("TinkerApplication is not initialized.");
            }
            tinkerApplication = SELF_HOLDER[0];
        }
        return tinkerApplication;
    }

    private void loadTinker() {
        try {
            Class<?> cls = Class.forName(this.loaderClassName, false, TinkerApplication.class.getClassLoader());
            this.tinkerResultIntent = (Intent) cls.getMethod(TINKER_LOADER_METHOD, TinkerApplication.class).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), this);
        } catch (Throwable th) {
            this.tinkerResultIntent = new Intent();
            ShareIntentUtil.setIntentReturnCode(this.tinkerResultIntent, -20);
            this.tinkerResultIntent.putExtra("intent_patch_exception", th);
        }
    }

    private Handler createInlineFence(Application application, int i2, String str, boolean z, long j2, long j3, Intent intent) {
        try {
            Object newInstance = Class.forName(str, false, this.mCurrentClassLoader).getConstructor(Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class).newInstance(application, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), intent);
            Constructor<?> constructor = Class.forName("com.tencent.tinker.entry.TinkerApplicationInlineFence", false, this.mCurrentClassLoader).getConstructor(Class.forName("com.tencent.tinker.entry.ApplicationLike", false, this.mCurrentClassLoader));
            constructor.setAccessible(true);
            return (Handler) constructor.newInstance(newInstance);
        } catch (Throwable th) {
            throw new TinkerRuntimeException("createInlineFence failed", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onBaseContextAttached(Context context, long j2, long j3) {
        try {
            loadTinker();
            this.mCurrentClassLoader = context.getClassLoader();
            this.mInlineFence = createInlineFence(this, this.tinkerFlags, this.delegateClassName, this.tinkerLoadVerifyFlag, j2, j3, this.tinkerResultIntent);
            TinkerInlineFenceAction.callOnBaseContextAttached(this.mInlineFence, context);
            if (this.useSafeMode) {
                ShareTinkerInternals.setSafeModeCount(this, 0);
            }
        } catch (TinkerRuntimeException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new TinkerRuntimeException(th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        Thread.setDefaultUncaughtExceptionHandler(new TinkerUncaughtHandler(this));
        onBaseContextAttached(context, elapsedRealtime, currentTimeMillis);
    }

    public void onCreate() {
        super.onCreate();
        if (this.mInlineFence != null) {
            TinkerInlineFenceAction.callOnCreate(this.mInlineFence);
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (this.mInlineFence != null) {
            TinkerInlineFenceAction.callOnTerminate(this.mInlineFence);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.mInlineFence != null) {
            TinkerInlineFenceAction.callOnLowMemory(this.mInlineFence);
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (this.mInlineFence != null) {
            TinkerInlineFenceAction.callOnTrimMemory(this.mInlineFence, i2);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mInlineFence != null) {
            TinkerInlineFenceAction.callOnConfigurationChanged(this.mInlineFence, configuration);
        }
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        return this.mInlineFence == null ? resources : TinkerInlineFenceAction.callGetResources(this.mInlineFence, resources);
    }

    public ClassLoader getClassLoader() {
        ClassLoader classLoader = super.getClassLoader();
        return this.mInlineFence == null ? classLoader : TinkerInlineFenceAction.callGetClassLoader(this.mInlineFence, classLoader);
    }

    public AssetManager getAssets() {
        AssetManager assets = super.getAssets();
        return this.mInlineFence == null ? assets : TinkerInlineFenceAction.callGetAssets(this.mInlineFence, assets);
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        return this.mInlineFence == null ? systemService : TinkerInlineFenceAction.callGetSystemService(this.mInlineFence, str, systemService);
    }

    public Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        return this.mInlineFence == null ? baseContext : TinkerInlineFenceAction.callGetBaseContext(this.mInlineFence, baseContext);
    }

    @Keep
    public int mzNightModeUseOf() {
        if (this.mInlineFence == null) {
            return 1;
        }
        return TinkerInlineFenceAction.callMZNightModeUseOf(this.mInlineFence);
    }

    public void setUseSafeMode(boolean z) {
        this.useSafeMode = z;
    }

    public boolean isTinkerLoadVerifyFlag() {
        return this.tinkerLoadVerifyFlag;
    }

    public int getTinkerFlags() {
        return this.tinkerFlags;
    }

    public boolean isUseDelegateLastClassLoader() {
        return this.useDelegateLastClassLoader;
    }
}
