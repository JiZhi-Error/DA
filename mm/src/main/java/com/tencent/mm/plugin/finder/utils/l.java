package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "", "requestLocationPermission", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "plugin-finder_release"})
public final class l {
    private static final String TAG = TAG;
    public static final l vVE = new l();

    static {
        AppMethodBeat.i(253401);
        AppMethodBeat.o(253401);
    }

    private l() {
    }

    public static void a(kotlin.g.a.a<x> aVar, kotlin.g.a.a<x> aVar2, kotlin.g.a.a<x> aVar3) {
        AppMethodBeat.i(253397);
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
        if (FinderGlobalLocationVM.dHO()) {
            long aWy = cl.aWy() - FinderGlobalLocationVM.dHQ();
            c cVar = c.vCb;
            if (aWy < ((long) c.dse())) {
                aVar3.invoke();
                AppMethodBeat.o(253397);
                return;
            }
            aVar2.invoke();
            AppMethodBeat.o(253397);
        } else if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(253397);
        } else {
            AppMethodBeat.o(253397);
        }
    }

    public static boolean dBJ() {
        AppMethodBeat.i(253398);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
        boolean dHO = FinderGlobalLocationVM.dHO();
        AppMethodBeat.o(253398);
        return dHO;
    }

    public static void g(MMActivity mMActivity) {
        AppMethodBeat.i(253399);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (Build.VERSION.SDK_INT <= 23 || mMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
            FinderGlobalLocationVM.h(mMActivity);
            AppMethodBeat.o(253399);
            return;
        }
        h.a((Context) mMActivity, mMActivity.getString(R.string.fl_), mMActivity.getString(R.string.flp), mMActivity.getString(R.string.e_k), mMActivity.getString(R.string.sz), false, (DialogInterface.OnClickListener) new FinderGlobalLocationVM.e(mMActivity), (DialogInterface.OnClickListener) new FinderGlobalLocationVM.f(mMActivity));
        AppMethodBeat.o(253399);
    }

    public static boolean dBK() {
        boolean z;
        AppMethodBeat.i(253400);
        Object obj = new Object();
        try {
            synchronized (obj) {
                try {
                    Log.i(TAG, "start syncWaitLbs");
                    new a(obj).alive();
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                    p.g(viewModel, "UICProvider.of(PluginFin…alLocationVM::class.java)");
                    FinderGlobalLocationVM finderGlobalLocationVM = (FinderGlobalLocationVM) viewModel;
                    if (!FinderGlobalLocationVM.dHO()) {
                        Log.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
                        z = false;
                    } else {
                        Log.i("Finder.GlobalLocationVM", "[forceRequestLocation]...");
                        d.c("Finder.GlobalLocationVM#RequestLocation", new FinderGlobalLocationVM.b(finderGlobalLocationVM));
                        z = true;
                    }
                    if (z) {
                        Log.i(TAG, "wait syncWaitLbs");
                        c cVar = c.vCb;
                        obj.wait((long) c.dsf());
                        Log.i(TAG, "syncWaitLbs ok");
                        return true;
                    }
                    Log.i(TAG, "syncWaitLbs no permission");
                    AppMethodBeat.o(253400);
                    return false;
                } finally {
                    AppMethodBeat.o(253400);
                }
            }
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "syncWaitLbs exception", new Object[0]);
            AppMethodBeat.o(253400);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<hy> {
        final /* synthetic */ Object vVF;

        a(Object obj) {
            this.vVF = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hy hyVar) {
            AppMethodBeat.i(253396);
            boolean dBM = dBM();
            AppMethodBeat.o(253396);
            return dBM;
        }

        private boolean dBM() {
            AppMethodBeat.i(253395);
            dead();
            synchronized (this.vVF) {
                try {
                    l lVar = l.vVE;
                    Log.i(l.TAG, "notify syncWaitLbs");
                    this.vVF.notifyAll();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(253395);
                    throw th;
                }
            }
            AppMethodBeat.o(253395);
            return true;
        }
    }
}
