package com.tencent.mm.sdk.platformtools;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ApplicationGlobal {
    private static final String TAG = "MicroMsg.sdk.ApplicationGlobal";
    private static Application sActivityThreadApp;
    private static Application sAttachedApp;

    public static synchronized Application context() {
        Application application;
        synchronized (ApplicationGlobal.class) {
            AppMethodBeat.i(230278);
            if (sAttachedApp != null) {
                application = sAttachedApp;
                AppMethodBeat.o(230278);
            } else if (sActivityThreadApp != null) {
                application = sActivityThreadApp;
                AppMethodBeat.o(230278);
            } else {
                Application activityThreadApplication = getActivityThreadApplication();
                sActivityThreadApp = activityThreadApplication;
                if (activityThreadApplication != null) {
                    application = sActivityThreadApp;
                    AppMethodBeat.o(230278);
                } else {
                    IllegalStateException illegalStateException = new IllegalStateException("Please make sure you do not call Applications#context() before or inside Application#attachBaseContext(Context). If you have to, please call Applications#attach(Application) first.");
                    AppMethodBeat.o(230278);
                    throw illegalStateException;
                }
            }
        }
        return application;
    }

    public static synchronized void attach(Application application) {
        synchronized (ApplicationGlobal.class) {
            if (sAttachedApp == null) {
                sAttachedApp = application;
            }
        }
    }

    private static Application getActivityThreadApplication() {
        Application application;
        AppMethodBeat.i(230279);
        try {
            Method declaredMethod = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            application = (Application) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e2) {
            try {
                Method declaredMethod2 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
                declaredMethod2.setAccessible(true);
                application = (Application) declaredMethod2.invoke(null, new Object[0]);
            } catch (Exception e3) {
                Log.w(TAG, "get activity thread fail, error = " + e2.getMessage() + " & " + e3.getMessage());
                application = null;
            }
        }
        AppMethodBeat.o(230279);
        return application;
    }
}
