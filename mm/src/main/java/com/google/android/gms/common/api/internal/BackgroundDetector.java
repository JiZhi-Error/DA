package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final BackgroundDetector zzem = new BackgroundDetector();
    private final AtomicBoolean zzen = new AtomicBoolean();
    private final AtomicBoolean zzeo = new AtomicBoolean();
    @GuardedBy("sInstance")
    private final ArrayList<BackgroundStateChangeListener> zzep = new ArrayList<>();
    @GuardedBy("sInstance")
    private boolean zzeq = false;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    static {
        AppMethodBeat.i(4491);
        AppMethodBeat.o(4491);
    }

    @KeepForSdk
    private BackgroundDetector() {
        AppMethodBeat.i(4482);
        AppMethodBeat.o(4482);
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return zzem;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        AppMethodBeat.i(4483);
        synchronized (zzem) {
            try {
                if (!zzem.zzeq) {
                    application.registerActivityLifecycleCallbacks(zzem);
                    application.registerComponentCallbacks(zzem);
                    zzem.zzeq = true;
                }
            } finally {
                AppMethodBeat.o(4483);
            }
        }
    }

    private final void onBackgroundStateChanged(boolean z) {
        AppMethodBeat.i(4490);
        synchronized (zzem) {
            try {
                ArrayList<BackgroundStateChangeListener> arrayList = this.zzep;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    BackgroundStateChangeListener backgroundStateChangeListener = arrayList.get(i2);
                    i2++;
                    backgroundStateChangeListener.onBackgroundStateChanged(z);
                }
            } finally {
                AppMethodBeat.o(4490);
            }
        }
    }

    @KeepForSdk
    public final void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        AppMethodBeat.i(4486);
        synchronized (zzem) {
            try {
                this.zzep.add(backgroundStateChangeListener);
            } finally {
                AppMethodBeat.o(4486);
            }
        }
    }

    @KeepForSdk
    public final boolean isInBackground() {
        AppMethodBeat.i(4485);
        boolean z = this.zzen.get();
        AppMethodBeat.o(4485);
        return z;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(4487);
        boolean compareAndSet = this.zzen.compareAndSet(true, false);
        this.zzeo.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
        AppMethodBeat.o(4487);
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(4488);
        boolean compareAndSet = this.zzen.compareAndSet(true, false);
        this.zzeo.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
        AppMethodBeat.o(4488);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(4489);
        if (i2 == 20 && this.zzen.compareAndSet(false, true)) {
            this.zzeo.set(true);
            onBackgroundStateChanged(true);
        }
        AppMethodBeat.o(4489);
    }

    @KeepForSdk
    @TargetApi(16)
    public final boolean readCurrentStateIfPossible(boolean z) {
        AppMethodBeat.i(4484);
        if (!this.zzeo.get()) {
            if (PlatformVersion.isAtLeastJellyBean()) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                if (!this.zzeo.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                    this.zzen.set(true);
                }
            } else {
                AppMethodBeat.o(4484);
                return z;
            }
        }
        boolean isInBackground = isInBackground();
        AppMethodBeat.o(4484);
        return isInBackground;
    }
}
