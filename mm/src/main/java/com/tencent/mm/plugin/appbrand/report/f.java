package com.tencent.mm.plugin.appbrand.report;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReportProvider;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "hasAddActivityLifecycleCallbacks", "", "reporters", "", "Landroid/support/v4/app/FragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "of", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "onActivityCreated", "", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-appbrand-integration_release"})
public final class f implements Application.ActivityLifecycleCallbacks {
    private static boolean nGT;
    private static final Map<FragmentActivity, AppBrandLauncherDesktopReporter> nGU = new LinkedHashMap();
    public static final f nGV = new f();

    static {
        AppMethodBeat.i(180644);
        AppMethodBeat.o(180644);
    }

    private f() {
    }

    public static AppBrandLauncherDesktopReporter b(FragmentActivity fragmentActivity) {
        AppBrandLauncherDesktopReporter appBrandLauncherDesktopReporter;
        AppMethodBeat.i(180642);
        p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        synchronized (nGU) {
            try {
                if (!nGT) {
                    fragmentActivity.getApplication().registerActivityLifecycleCallbacks(nGV);
                    nGT = true;
                }
                appBrandLauncherDesktopReporter = nGU.get(fragmentActivity);
                if (appBrandLauncherDesktopReporter == null) {
                    appBrandLauncherDesktopReporter = new AppBrandLauncherDesktopReporter();
                    nGU.put(fragmentActivity, appBrandLauncherDesktopReporter);
                }
            } finally {
                AppMethodBeat.o(180642);
            }
        }
        return appBrandLauncherDesktopReporter;
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(180643);
        synchronized (nGU) {
            try {
                Map<FragmentActivity, AppBrandLauncherDesktopReporter> map = nGU;
                if (map == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                    AppMethodBeat.o(180643);
                    throw tVar;
                }
                af.fd(map).remove(activity);
            } finally {
                AppMethodBeat.o(180643);
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }
}
