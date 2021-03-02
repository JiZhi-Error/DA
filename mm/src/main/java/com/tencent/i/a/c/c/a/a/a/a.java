package com.tencent.i.a.c.c.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public abstract class a implements Application.ActivityLifecycleCallbacks {
    public abstract void s(Activity activity, String str);

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        s(activity, "onActivityPaused");
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
