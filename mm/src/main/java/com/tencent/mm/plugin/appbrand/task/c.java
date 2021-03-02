package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.os.Debug;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.m.h;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\"\u0010\u0011\u001a\u00020\u000b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u001e\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J \u0010\u0018\u001a\u00020\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\b\u0010\u0019\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider;", "", "()V", "PERIOD_MS", "", "TAG", "", "listeners", "", "Lkotlin/Function2;", "", "", "memoryMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "pauseTask", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getAllTaskMemUsageAsync", "mb", "getMemUsageMBByPids", "Lkotlin/Pair;", "pids", "", "pause", "removeListener", "resume", "AppForegroundListener", "plugin-appbrand-integration_release"})
public final class c {
    private static final List<m<Integer, Integer, x>> listeners = new ArrayList();
    private static d<?> nOp;
    private static d<?> nOq;
    public static final c nOr = new c();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ m nOv;

        b(m mVar) {
            this.nOv = mVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUIProcess;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<m, String> {
            public static final a nOw = new a();

            static {
                AppMethodBeat.i(229376);
                AppMethodBeat.o(229376);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(m mVar) {
                AppMethodBeat.i(229375);
                m mVar2 = mVar;
                p.h(mVar2, "task");
                String bWo = mVar2.bWo();
                AppMethodBeat.o(229375);
                return bWo;
            }
        }

        public final void run() {
            T t;
            AppMethodBeat.i(229377);
            ActivityManager activityManager = (ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (activityManager == null) {
                this.nOv.invoke(0, 0);
                AppMethodBeat.o(229377);
                return;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            i.b bVar = i.nPZ;
            h d2 = kotlin.m.i.d(j.z(i.b.bWj()), a.nOw);
            p.h(d2, "$this$toSet");
            ArrayList arrayList = new ArrayList();
            for (String str : ak.C((Set) kotlin.m.i.a(d2, new LinkedHashSet()))) {
                p.g(runningAppProcesses, "runningProcesses");
                Iterator<T> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(((ActivityManager.RunningAppProcessInfo) next).processName, str)) {
                        t = next;
                        break;
                    }
                }
                T t2 = t;
                Integer valueOf = t2 != null ? Integer.valueOf(((ActivityManager.RunningAppProcessInfo) t2).pid) : null;
                if (valueOf != null) {
                    arrayList.add(valueOf);
                }
            }
            c cVar = c.nOr;
            o w = c.w(j.u((Collection<Integer>) arrayList));
            this.nOv.invoke(w.first, w.second);
            AppMethodBeat.o(229377);
        }
    }

    static {
        AppMethodBeat.i(229386);
        if (MMApplicationContext.isMainProcess() || !com.tencent.mm.plugin.appbrand.q.kDg) {
            AppForegroundDelegate.INSTANCE.a(new a());
            AppMethodBeat.o(229386);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Log.getStackTraceString(new Throwable()));
        AppMethodBeat.o(229386);
        throw illegalArgumentException;
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "mayCancelPauseTask", "", "onAppBackground", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-appbrand-integration_release"})
    static final class a implements com.tencent.mm.app.o {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ a nOs;

            b(a aVar) {
                this.nOs = aVar;
            }

            public final void run() {
                AppMethodBeat.i(229371);
                a.bVL();
                com.tencent.f.h.RTc.n(AnonymousClass1.nOu, 15000);
                AppMethodBeat.o(229371);
            }
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(229372);
            com.tencent.f.h.RTc.aV(new b(this));
            AppMethodBeat.o(229372);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.task.c$a$a  reason: collision with other inner class name */
        static final class RunnableC0798a implements Runnable {
            final /* synthetic */ a nOs;

            RunnableC0798a(a aVar) {
                this.nOs = aVar;
            }

            public final void run() {
                AppMethodBeat.i(229368);
                com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandMemoryPeriodicProvider", "onAppBackground: ");
                a.bVL();
                c cVar = c.nOr;
                c.nOp = com.tencent.f.h.RTc.n(AnonymousClass1.nOt, 600000);
                AppMethodBeat.o(229368);
            }
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(229373);
            com.tencent.f.h.RTc.aV(new RunnableC0798a(this));
            AppMethodBeat.o(229373);
        }

        public static final /* synthetic */ void bVL() {
            AppMethodBeat.i(229374);
            c cVar = c.nOr;
            d dVar = c.nOp;
            if (dVar != null) {
                if (!dVar.isDone()) {
                    c cVar2 = c.nOr;
                    d dVar2 = c.nOp;
                    if (dVar2 == null) {
                        p.hyc();
                    }
                    dVar2.cancel(true);
                    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandMemoryPeriodicProvider", "mayCancelPauseTask: pause task canceled");
                }
                AppMethodBeat.o(229374);
                return;
            }
            AppMethodBeat.o(229374);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.task.c$c  reason: collision with other inner class name */
    public static final class RunnableC0799c implements Runnable {
        public static final RunnableC0799c nOx = new RunnableC0799c();

        static {
            AppMethodBeat.i(229384);
            AppMethodBeat.o(229384);
        }

        RunnableC0799c() {
        }

        public final void run() {
            AppMethodBeat.i(229383);
            com.tencent.f.h.RTc.aV(AnonymousClass1.nOy);
            AppMethodBeat.o(229383);
        }
    }

    public static void c(m<? super Integer, ? super Integer, x> mVar) {
        AppMethodBeat.i(229385);
        p.h(mVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        listeners.add(mVar);
        AppMethodBeat.o(229385);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r0.isCancelled() != false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void bVH() {
        /*
            r6 = 229387(0x3800b, float:3.2144E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.f.i.d<?> r0 = com.tencent.mm.plugin.appbrand.task.c.nOq
            if (r0 == 0) goto L_0x0017
            com.tencent.f.i.d<?> r0 = com.tencent.mm.plugin.appbrand.task.c.nOq
            if (r0 != 0) goto L_0x0011
            kotlin.g.b.p.hyc()
        L_0x0011:
            boolean r0 = r0.isCancelled()
            if (r0 == 0) goto L_0x0039
        L_0x0017:
            java.lang.String r0 = "MicroMsg.AppBrandMemoryPeriodicProvider"
            java.lang.String r1 = "resume: "
            com.tencent.mm.sdk.platformtools.Log.d(r0, r1)
            com.tencent.f.i.d<?> r0 = com.tencent.mm.plugin.appbrand.task.c.nOq
            if (r0 == 0) goto L_0x0028
            r1 = 1
            r0.cancel(r1)
        L_0x0028:
            com.tencent.f.i r0 = com.tencent.f.h.RTc
            com.tencent.mm.plugin.appbrand.task.c$c r1 = com.tencent.mm.plugin.appbrand.task.c.RunnableC0799c.nOx
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 0
            r4 = 310000(0x4baf0, double:1.531604E-318)
            com.tencent.f.i.d r0 = r0.a(r1, r2, r4)
            com.tencent.mm.plugin.appbrand.task.c.nOq = r0
        L_0x0039:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.task.c.bVH():void");
    }

    public static final /* synthetic */ void bVJ() {
        AppMethodBeat.i(229388);
        d<?> dVar = nOq;
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandMemoryPeriodicProvider", "pause: isSuccess=[%b]", dVar != null ? Boolean.valueOf(dVar.cancel(true)) : null);
        AppMethodBeat.o(229388);
    }

    public static final /* synthetic */ void d(m mVar) {
        AppMethodBeat.i(229389);
        com.tencent.f.h.RTc.aZ(new b(mVar));
        AppMethodBeat.o(229389);
    }

    public static final /* synthetic */ o w(int[] iArr) {
        AppMethodBeat.i(229390);
        if (iArr != null) {
            if (!(iArr.length == 0)) {
                Object systemService = MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                if (!(systemService instanceof ActivityManager)) {
                    systemService = null;
                }
                ActivityManager activityManager = (ActivityManager) systemService;
                Debug.MemoryInfo[] processMemoryInfo = activityManager != null ? activityManager.getProcessMemoryInfo(iArr) : null;
                if (processMemoryInfo != null) {
                    if (!(processMemoryInfo.length == 0)) {
                        ArrayList arrayList = new ArrayList(processMemoryInfo.length);
                        for (Debug.MemoryInfo memoryInfo : processMemoryInfo) {
                            p.g(memoryInfo, LocaleUtil.ITALIAN);
                            arrayList.add(Integer.valueOf(memoryInfo.getTotalPss()));
                        }
                        ArrayList arrayList2 = arrayList;
                        Integer valueOf = Integer.valueOf(j.B(arrayList2) / 1024);
                        Integer num = (Integer) j.w(arrayList2);
                        o oVar = new o(valueOf, Integer.valueOf((num != null ? num.intValue() : 0) / 1024));
                        AppMethodBeat.o(229390);
                        return oVar;
                    }
                }
                o oVar2 = new o(0, 0);
                AppMethodBeat.o(229390);
                return oVar2;
            }
        }
        o oVar3 = new o(0, 0);
        AppMethodBeat.o(229390);
        return oVar3;
    }
}
