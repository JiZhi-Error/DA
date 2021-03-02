package com.tencent.mm.ad;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c implements Application.ActivityLifecycleCallbacks {
    private Application application;

    private c(Application application2) {
        this.application = application2;
    }

    public static void g(Application application2) {
        AppMethodBeat.i(125088);
        if (Build.MANUFACTURER.equals("samsung") && Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
            application2.registerActivityLifecycleCallbacks(new c(application2));
        }
        AppMethodBeat.o(125088);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(125089);
        try {
            Class<?> cls = Class.forName("com.samsung.android.emergencymode.SemEmergencyManager");
            Field declaredField = cls.getDeclaredField("sInstance");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("mContext");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, this.application);
        } catch (Exception e2) {
        }
        this.application.unregisterActivityLifecycleCallbacks(this);
        AppMethodBeat.o(125089);
    }
}
