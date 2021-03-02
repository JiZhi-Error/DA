package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0014R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"})
public final class i {
    private static final SparseArray<i> nFl = new SparseArray<>();
    public static final a nFm = new a((byte) 0);
    private final Context appContext;
    public final String lMQ = ("MicroMsg.AppBrand.AppBrandOrientationObservable#" + hashCode());
    private ad.a nFh;
    private ad.a nFi;
    public final ad nFj;
    public final List<j> nFk;

    public static final i F(Activity activity) {
        AppMethodBeat.i(176490);
        i F = a.F(activity);
        AppMethodBeat.o(176490);
        return F;
    }

    public i(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(176487);
        this.appContext = activity.getApplicationContext();
        this.nFh = ad.a.NONE;
        this.nFi = ad.a.NONE;
        this.nFj = new ad(this.appContext, new b(this));
        this.nFk = new CopyOnWriteArrayList();
        AppMethodBeat.o(176487);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
    static final class b implements ad.b {
        final /* synthetic */ i nFn;

        b(i iVar) {
            this.nFn = iVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.ad.b
        public final void a(ad.a aVar, ad.a aVar2) {
            AppMethodBeat.i(176486);
            boolean a2 = i.a(this.nFn);
            Log.d(this.nFn.lMQ, "onFourOrientationsChange, newOrientation: " + aVar2 + ", isSystemOrientationLocked: " + a2);
            if (!a2 && this.nFn.nFh != aVar2) {
                for (j jVar : this.nFn.nFk) {
                    p.g(aVar2, "newOrientation");
                    jVar.a(aVar2);
                }
                i iVar = this.nFn;
                p.g(aVar2, "newOrientation");
                iVar.nFh = aVar2;
            }
            i iVar2 = this.nFn;
            p.g(aVar2, "newOrientation");
            iVar2.nFi = aVar2;
            AppMethodBeat.o(176486);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "activity2OrientationObservableMap$annotations", "get", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "luggage-wxa-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static i F(Activity activity) {
            i iVar;
            AppMethodBeat.i(176485);
            p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            int hashCode = activity.hashCode();
            synchronized (i.nFl) {
                try {
                    iVar = (i) i.nFl.get(hashCode);
                    if (iVar == null) {
                        iVar = new i(activity);
                        i.nFl.put(hashCode, iVar);
                    }
                } finally {
                    AppMethodBeat.o(176485);
                }
            }
            return iVar;
        }
    }

    static {
        AppMethodBeat.i(176488);
        AppMethodBeat.o(176488);
    }

    public static final /* synthetic */ boolean a(i iVar) {
        AppMethodBeat.i(176489);
        Context context = iVar.appContext;
        p.g(context, "appContext");
        if (Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 0) {
            AppMethodBeat.o(176489);
            return true;
        }
        AppMethodBeat.o(176489);
        return false;
    }
}
