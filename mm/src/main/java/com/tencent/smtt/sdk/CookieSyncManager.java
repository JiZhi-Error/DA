package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public class CookieSyncManager extends z {

    /* renamed from: a  reason: collision with root package name */
    private static android.webkit.CookieSyncManager f1677a;

    /* renamed from: b  reason: collision with root package name */
    private static CookieSyncManager f1678b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1679c = false;

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            AppMethodBeat.i(55013);
            f1677a = android.webkit.CookieSyncManager.createInstance(context);
            if (f1678b == null || !f1679c) {
                f1678b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = f1678b;
            AppMethodBeat.o(55013);
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            AppMethodBeat.i(55014);
            if (f1678b == null) {
                IllegalStateException illegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
                AppMethodBeat.o(55014);
                throw illegalStateException;
            }
            cookieSyncManager = f1678b;
            AppMethodBeat.o(55014);
        }
        return cookieSyncManager;
    }

    private CookieSyncManager(Context context) {
        AppMethodBeat.i(55015);
        if (isX5Core()) {
            getCookieManagerImpl().syncManagerCreateInstance(context);
            f1679c = true;
        }
        AppMethodBeat.o(55015);
    }

    public void sync() {
        AppMethodBeat.i(55016);
        if (isX5Core()) {
            getCookieManagerImpl().syncManagerSync();
            AppMethodBeat.o(55016);
            return;
        }
        f1677a.sync();
        AppMethodBeat.o(55016);
    }

    public void stopSync() {
        AppMethodBeat.i(55017);
        if (isX5Core()) {
            getCookieManagerImpl().syncManagerStopSync();
            AppMethodBeat.o(55017);
            return;
        }
        f1677a.stopSync();
        AppMethodBeat.o(55017);
    }

    public void startSync() {
        AppMethodBeat.i(55018);
        if (isX5Core()) {
            getCookieManagerImpl().syncManagerStartSync();
            AppMethodBeat.o(55018);
            return;
        }
        f1677a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(f1677a)).setUncaughtExceptionHandler(new h());
            AppMethodBeat.o(55018);
        } catch (Exception e2) {
            AppMethodBeat.o(55018);
        }
    }
}
