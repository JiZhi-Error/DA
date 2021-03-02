package com.tencent.mm.plugin.appbrand.task;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService1;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService2;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService3;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService4;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService1;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService2;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService3;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService4;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.task.preload.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import junit.framework.Assert;
import kotlin.g.a.m;
import kotlin.x;

public class h implements p, p.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final LinkedList<n> nPK;
    private static final LinkedList<n> nPL;
    public static final n nPM = new d();
    private static final ConcurrentHashMap<String, String> nPN = new ConcurrentHashMap<>();
    private static final Set<String> nPO = new HashSet();
    private static final ConcurrentSkipListSet<AppBrandRemoteTaskController> nPP = new ConcurrentSkipListSet<AppBrandRemoteTaskController>(new Comparator<AppBrandRemoteTaskController>() {
        /* class com.tencent.mm.plugin.appbrand.task.h.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AppBrandRemoteTaskController appBrandRemoteTaskController, AppBrandRemoteTaskController appBrandRemoteTaskController2) {
            AppMethodBeat.i(48434);
            AppBrandRemoteTaskController appBrandRemoteTaskController3 = appBrandRemoteTaskController;
            AppBrandRemoteTaskController appBrandRemoteTaskController4 = appBrandRemoteTaskController2;
            int compareTo = appBrandRemoteTaskController3.mAppId.compareTo(appBrandRemoteTaskController4.mAppId);
            if (compareTo == 0) {
                int i2 = appBrandRemoteTaskController3.mDebugType - appBrandRemoteTaskController4.mDebugType;
                AppMethodBeat.o(48434);
                return i2;
            }
            AppMethodBeat.o(48434);
            return compareTo;
        }
    }) {
        /* class com.tencent.mm.plugin.appbrand.task.h.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.AbstractCollection, java.util.concurrent.ConcurrentSkipListSet, java.util.Collection, java.util.Set
        public final /* synthetic */ boolean add(AppBrandRemoteTaskController appBrandRemoteTaskController) {
            String str;
            AppMethodBeat.i(227487);
            AppBrandRemoteTaskController appBrandRemoteTaskController2 = appBrandRemoteTaskController;
            if (appBrandRemoteTaskController2 == null || TextUtils.isEmpty(appBrandRemoteTaskController2.mAppId)) {
                Object[] objArr = new Object[2];
                if (appBrandRemoteTaskController2 == null) {
                    str = null;
                } else {
                    str = appBrandRemoteTaskController2.mAppId;
                }
                objArr[0] = str;
                objArr[1] = Log.getStackTraceString(new Throwable());
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandTaskManager", "PERSISTENT_TASK_CONTROLLERS.add get invalid element, appId:%s, stack:%s", objArr);
                AppMethodBeat.o(227487);
                return false;
            }
            boolean add = super.add(appBrandRemoteTaskController2);
            AppMethodBeat.o(227487);
            return add;
        }
    };

    static {
        boolean z;
        AppMethodBeat.i(48471);
        if (!h.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
        LinkedList<n> linkedList = new LinkedList<>();
        nPK = linkedList;
        linkedList.add(new n(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class));
        nPK.add(new n(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class));
        nPK.add(new n(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class));
        nPK.add(new n(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class));
        nPK.add(new n(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class));
        LinkedList<n> linkedList2 = new LinkedList<>();
        nPL = linkedList2;
        linkedList2.addAll(nPK);
        nPL.add(nPM);
        AppMethodBeat.o(48471);
    }

    /* synthetic */ h(byte b2) {
        this();
    }

    static /* synthetic */ n afl(String str) {
        AppMethodBeat.i(227511);
        n afh = afh(str);
        AppMethodBeat.o(227511);
        return afh;
    }

    static /* synthetic */ boolean c(n nVar) {
        AppMethodBeat.i(227510);
        boolean a2 = a(nVar);
        AppMethodBeat.o(227510);
        return a2;
    }

    static /* synthetic */ int w(g gVar) {
        AppMethodBeat.i(227509);
        int s = s(gVar);
        AppMethodBeat.o(227509);
        return s;
    }

    private h() {
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(String str, String str2, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(48438);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(48438);
            return;
        }
        nPN.put(str, str2);
        if (appBrandRemoteTaskController != null) {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "stashPersistentApp appId:%s, processName:%s, controller.id:%s", str, str2, appBrandRemoteTaskController.jEY);
            nPP.remove(appBrandRemoteTaskController);
            nPP.add(appBrandRemoteTaskController);
        }
        AppMethodBeat.o(48438);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(String str, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(48439);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(48439);
            return;
        }
        nPN.remove(str);
        if (appBrandRemoteTaskController != null) {
            nPP.remove(appBrandRemoteTaskController);
        }
        AppMethodBeat.o(48439);
    }

    private static void ck(String str, int i2) {
        AppMethodBeat.i(48440);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(48440);
            return;
        }
        Iterator<AppBrandRemoteTaskController> it = nPP.iterator();
        LinkedList<AppBrandRemoteTaskController> linkedList = new LinkedList();
        while (it.hasNext()) {
            AppBrandRemoteTaskController next = it.next();
            if (str.equals(next.mAppId) && (i2 == next.mDebugType || i2 < 0)) {
                next.afa(str);
                linkedList.add(next);
            }
        }
        for (AppBrandRemoteTaskController appBrandRemoteTaskController : linkedList) {
            nPP.remove(appBrandRemoteTaskController);
        }
        AppMethodBeat.o(48440);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final int g(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(227494);
        int d2 = d(null, appBrandInitConfigWC, appBrandStatObject);
        AppMethodBeat.o(227494);
        return d2;
    }

    public static void afd(String str) {
        AppMethodBeat.i(227495);
        c.a(str, KSProcessWeAppLaunch.stepContainerUILaunch);
        AppMethodBeat.o(227495);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x026b  */
    @Override // com.tencent.mm.plugin.appbrand.task.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(android.content.Context r18, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC r19, com.tencent.mm.plugin.appbrand.report.AppBrandStatObject r20) {
        /*
        // Method dump skipped, instructions count: 1025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.task.h.d(android.content.Context, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC, com.tencent.mm.plugin.appbrand.report.AppBrandStatObject):int");
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void cl(String str, int i2) {
        AppMethodBeat.i(48442);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(48442);
            return;
        }
        n afh = afh(str);
        if (afh == null) {
            ck(str, i2);
            AppMethodBeat.o(48442);
            return;
        }
        if ((i2 < 0 || afh.afo(str).intValue() == i2) && afh.afq(str) != null) {
            afh.afq(str).afa(str);
        }
        AppMethodBeat.o(48442);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void bVX() {
        AppMethodBeat.i(227496);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : it.next().bWx()) {
                appBrandRemoteTaskController.zl(4);
            }
        }
        AppMethodBeat.o(227496);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void zn(int i2) {
        AppMethodBeat.i(48443);
        if (2 == i2) {
            HashMap hashMap = new HashMap();
            Iterator<n> it = bVZ().iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!TextUtils.isEmpty(next.nQm)) {
                    if (next.bWp()) {
                        String str = next.nQm;
                        Boolean bool = Boolean.TRUE;
                        if (Build.VERSION.SDK_INT >= 24) {
                            hashMap.putIfAbsent(str, bool);
                        } else if (hashMap.get(str) == null) {
                            hashMap.put(str, bool);
                        }
                    } else {
                        hashMap.put(next.nQm, Boolean.FALSE);
                    }
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() != null && ((Boolean) entry.getValue()).booleanValue()) {
                    String str2 = (String) entry.getKey();
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE kill process(%s)", str2);
                    b.Lm(str2);
                    com.tencent.mm.bv.a.cs(MMApplicationContext.getContext(), str2);
                }
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
            a(g.WASERVICE, z.APPBRAND_PROCESS_RESTART, true);
            a(g.WAGAME, z.APPBRAND_PROCESS_RESTART, true);
            AppMethodBeat.o(48443);
            return;
        }
        Iterator<n> it2 = bVZ().iterator();
        while (it2.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : it2.next().bWx()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.zl(i2);
                }
            }
        }
        Iterator<AppBrandRemoteTaskController> it3 = nPP.iterator();
        while (it3.hasNext()) {
            AppBrandRemoteTaskController next2 = it3.next();
            if (next2 != null) {
                next2.zl(i2);
            }
        }
        if (3 == i2) {
            nPP.clear();
        }
        AppMethodBeat.o(48443);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void afe(String str) {
        AppMethodBeat.i(48444);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (!(next == null || next.afq(str) == null)) {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "clearDuplicatedApp task:%s, appId:%s", next.nQk, str);
                next.afq(str).afa(str);
            }
        }
        ck(str, -1);
        AppMethodBeat.o(48444);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(g gVar, z zVar) {
        AppMethodBeat.i(227497);
        a(gVar, zVar, z.d(zVar));
        AppMethodBeat.o(227497);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void e(z zVar) {
        boolean z;
        AppMethodBeat.i(227498);
        if (e.bWG()) {
            AppMethodBeat.o(227498);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, zVar.nMT);
        if (z.d(zVar) || e.a(e.a.WASERVICE_FAKE_NATIVE, new m<Boolean, Boolean, x>() {
            /* class com.tencent.mm.plugin.appbrand.task.h.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Boolean bool, Boolean bool2) {
                AppMethodBeat.i(227488);
                e.a(e.a.WASERVICE, bool.booleanValue(), bool2.booleanValue());
                x xVar = x.SXb;
                AppMethodBeat.o(227488);
                return xVar;
            }
        }) != -1) {
            z = false;
        } else {
            z = true;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "preloadPluginUIProcess, hitLimit[%b], scene[%s]", Boolean.valueOf(z), zVar.name());
        if (!z) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, zVar.nMU);
            n nVar = nPM;
            nVar.iB(a(nVar));
        }
        AppMethodBeat.o(227498);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final void a(g gVar, z zVar, final boolean z) {
        AppMethodBeat.i(227499);
        if (!i.bxK() || e.bWG() || gVar == g.NIL) {
            AppMethodBeat.o(227499);
            return;
        }
        int iF = e.iF(g.WAGAME == gVar);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(iF, zVar.nMT);
        int a2 = e.a(e.a.A(gVar), new m<Boolean, Boolean, x>() {
            /* class com.tencent.mm.plugin.appbrand.task.h.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Boolean bool, Boolean bool2) {
                AppMethodBeat.i(227489);
                Boolean bool3 = bool;
                Boolean bool4 = bool2;
                if (!z) {
                    e.a(e.a.WASERVICE, bool3.booleanValue(), bool4.booleanValue());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(227489);
                return xVar;
            }
        });
        if (z || a2 != -1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(iF, zVar.nMU);
            if (z) {
                a2 = 2;
            }
            switch (gVar) {
                case WASERVICE:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 0);
                    break;
                case WAGAME:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 1);
                    break;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType[%s] scene[%s] preload level[%d]", gVar, zVar, Integer.valueOf(a2));
            n u = u(gVar);
            if (u != null) {
                u.z(gVar);
                u.R(a2, a(u));
                if (a2 != 2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(915, 30);
                }
                switch (gVar) {
                    case WASERVICE:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 3);
                        AppMethodBeat.o(227499);
                        return;
                    case WAGAME:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 4);
                        break;
                }
                AppMethodBeat.o(227499);
                return;
            }
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s], preload level = [%d] has no AppBrandUITask", gVar, Integer.valueOf(a2));
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(915, 33);
            AppMethodBeat.o(227499);
            return;
        }
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess type[%s] scene[%s] hit interval limit", gVar, zVar);
        AppMethodBeat.o(227499);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(String str, final g gVar) {
        AppMethodBeat.i(227501);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(227501);
            return;
        }
        final n b2 = b(str, null);
        if (nPM == b2) {
            b2 = b(AppBrandUI.class.getName(), null);
        }
        if (b2 == null) {
            AppMethodBeat.o(227501);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.task.h.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(227490);
                if (b2.nQv == g.NIL && gVar != g.NIL && h.w(gVar) < gVar.nPG) {
                    b2.z(gVar);
                }
                b2.iB(h.c(b2));
                AppMethodBeat.o(227490);
            }
        }, 500);
        AppMethodBeat.o(227501);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void onNetworkChange() {
        AppMethodBeat.i(48451);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : it.next().bWx()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.bVT();
                }
            }
        }
        AppMethodBeat.o(48451);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final Class aff(String str) {
        AppMethodBeat.i(48452);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.nQk.equals(str)) {
                Class cls = next.nQo;
                AppMethodBeat.o(48452);
                return cls;
            }
        }
        AppMethodBeat.o(48452);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final Class afg(String str) {
        AppMethodBeat.i(48453);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.nQk.equals(str)) {
                Class cls = next.nQp;
                AppMethodBeat.o(48453);
                return cls;
            }
        }
        AppMethodBeat.o(48453);
        return null;
    }

    private static int s(g gVar) {
        AppMethodBeat.i(227502);
        int i2 = 0;
        Iterator<n> it = nPK.iterator();
        while (it.hasNext()) {
            if (it.next().nQv == gVar) {
                i2++;
            } else {
                i2 = i2;
            }
        }
        AppMethodBeat.o(227502);
        return i2;
    }

    private static n a(List<n> list, g gVar) {
        AppMethodBeat.i(48454);
        for (n nVar : list) {
            if (nVar.nQv == gVar) {
                AppMethodBeat.o(48454);
                return nVar;
            }
        }
        AppMethodBeat.o(48454);
        return null;
    }

    private static boolean t(g gVar) {
        AppMethodBeat.i(48455);
        int s = s(gVar);
        if (s > gVar.nPG) {
            IllegalStateException illegalStateException = new IllegalStateException(Util.safeFormatString("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", gVar.name(), Integer.valueOf(s), Integer.valueOf(gVar.nPG)));
            AppMethodBeat.o(48455);
            throw illegalStateException;
        } else if (s == gVar.nPG) {
            AppMethodBeat.o(48455);
            return true;
        } else {
            AppMethodBeat.o(48455);
            return false;
        }
    }

    private static n u(g gVar) {
        n a2;
        String str;
        AppMethodBeat.i(48456);
        synchronized (nPK) {
            try {
                if (t(gVar)) {
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", gVar);
                    a2 = null;
                } else {
                    Iterator<n> it = nPK.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            a2 = it.next();
                            if (a2.bWp() && a2.nQv == gVar) {
                                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task[%s], which can be used as [%s]", a2.nQm, gVar);
                                AppMethodBeat.o(48456);
                                break;
                            }
                        } else {
                            a2 = a(nPK, g.NIL);
                            Object[] objArr = new Object[2];
                            objArr[0] = gVar;
                            if (a2 == null) {
                                str = BuildConfig.COMMAND;
                            } else {
                                str = a2.nQk;
                            }
                            objArr[1] = str;
                            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", objArr);
                            AppMethodBeat.o(48456);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(48456);
            }
        }
        return a2;
    }

    private static n v(g gVar) {
        n nVar;
        AppMethodBeat.i(48457);
        synchronized (nPK) {
            n nVar2 = null;
            try {
                Iterator<n> it = nPK.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        nVar = nVar2;
                        break;
                    }
                    nVar = it.next();
                    if (nVar.bWp() && nVar.nQv == gVar) {
                        if (nVar2 == null) {
                            nVar2 = nVar;
                        }
                        if (nVar.nQw.get()) {
                            break;
                        }
                    }
                    nVar2 = nVar2;
                }
                if (nVar != null) {
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s], info [%s]", gVar, nVar);
                } else if (t(gVar)) {
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", gVar);
                    nVar = a(nPK, gVar);
                    if (!$assertionsDisabled && nVar == null) {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.o(48457);
                        throw assertionError;
                    }
                } else {
                    nVar = a(nPK, g.NIL);
                    if (nVar != null) {
                        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", gVar);
                    } else {
                        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", gVar);
                        nVar = nPK.getFirst();
                    }
                }
            } finally {
                AppMethodBeat.o(48457);
            }
        }
        return nVar;
    }

    private static n afh(String str) {
        AppMethodBeat.i(48458);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.bWw().contains(str)) {
                AppMethodBeat.o(48458);
                return next;
            }
        }
        AppMethodBeat.o(48458);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final n b(String str, g gVar) {
        AppMethodBeat.i(227503);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.nQk.equals(str)) {
                AppMethodBeat.o(227503);
                return next;
            }
        }
        Assert.assertTrue(true);
        AppMethodBeat.o(227503);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final n a(String str, String str2, g gVar) {
        AppMethodBeat.i(227504);
        Iterator<n> it = bVZ().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.bWw().contains(str) && next.nQk.equals(str2)) {
                AppMethodBeat.o(227504);
                return next;
            }
        }
        AppMethodBeat.o(227504);
        return null;
    }

    private AppBrandRemoteTaskController cm(final String str, final int i2) {
        AppMethodBeat.i(48461);
        AppBrandRemoteTaskController appBrandRemoteTaskController = (AppBrandRemoteTaskController) new android.arch.a.c.a<Void, AppBrandRemoteTaskController>() {
            /* class com.tencent.mm.plugin.appbrand.task.h.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public final /* synthetic */ AppBrandRemoteTaskController apply(Void r7) {
                AppMethodBeat.i(227491);
                n afl = h.afl(str);
                if (afl == null) {
                    Iterator it = h.nPP.iterator();
                    while (it.hasNext()) {
                        AppBrandRemoteTaskController appBrandRemoteTaskController = (AppBrandRemoteTaskController) it.next();
                        if (str.equals(appBrandRemoteTaskController.mAppId)) {
                            if (i2 == appBrandRemoteTaskController.mDebugType) {
                                AppMethodBeat.o(227491);
                                return appBrandRemoteTaskController;
                            } else if (i2 < 0) {
                                AppMethodBeat.o(227491);
                                return appBrandRemoteTaskController;
                            }
                        }
                    }
                    AppMethodBeat.o(227491);
                    return null;
                } else if (i2 < 0 || Util.nullAs(afl.afo(str), -1) == i2) {
                    AppBrandRemoteTaskController afq = afl.afq(str);
                    AppMethodBeat.o(227491);
                    return afq;
                } else {
                    AppMethodBeat.o(227491);
                    return null;
                }
            }
        }.apply(null);
        if (appBrandRemoteTaskController == null || !appBrandRemoteTaskController.bVS()) {
            AppMethodBeat.o(48461);
            return null;
        }
        AppMethodBeat.o(48461);
        return appBrandRemoteTaskController;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final boolean cn(String str, int i2) {
        AppMethodBeat.i(48462);
        if (cm(str, i2) != null) {
            AppMethodBeat.o(48462);
            return true;
        }
        AppMethodBeat.o(48462);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final boolean afi(String str) {
        AppMethodBeat.i(185914);
        boolean cn = cn(str, -1);
        AppMethodBeat.o(185914);
        return cn;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final Pair<String, Integer> afj(String str) {
        AppMethodBeat.i(160619);
        AppBrandRemoteTaskController cm = cm(str, -1);
        if (cm == null) {
            AppMethodBeat.o(160619);
            return null;
        }
        Pair<String, Integer> create = Pair.create(cm.mAppId, Integer.valueOf(cm.mDebugType));
        AppMethodBeat.o(160619);
        return create;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final String co(String str, int i2) {
        String str2 = null;
        AppMethodBeat.i(48464);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(48464);
        } else {
            try {
                AppBrandRemoteTaskController cm = cm(str, i2);
                if (cm != null) {
                    str2 = cm.nPi;
                    AppMethodBeat.o(48464);
                }
            } catch (NullPointerException e2) {
                if (BuildInfo.IS_FLAVOR_RED) {
                    AppMethodBeat.o(48464);
                    throw e2;
                }
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandTaskManager", e2, "[NOT CRASH]getAliveInstanceId", new Object[0]);
            }
            AppMethodBeat.o(48464);
        }
        return str2;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final int[] bVY() {
        AppMethodBeat.i(48465);
        LinkedList<n> bVZ = bVZ();
        int[] iArr = new int[bVZ.size()];
        Iterator<n> it = bVZ.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().nPc;
            i2++;
        }
        AppMethodBeat.o(48465);
        return iArr;
    }

    private static LinkedList<n> bVZ() {
        LinkedList<n> linkedList;
        AppMethodBeat.i(48466);
        synchronized (nPL) {
            try {
                linkedList = new LinkedList<>(nPL);
            } finally {
                AppMethodBeat.o(48466);
            }
        }
        return linkedList;
    }

    public static List<String> bWa() {
        AppMethodBeat.i(227505);
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = nPL.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null) {
                next.bWw();
                if (next.bWw().size() > 0) {
                    arrayList.addAll(next.bWw());
                }
            }
        }
        Iterator<AppBrandRemoteTaskController> it2 = nPP.iterator();
        while (it2.hasNext()) {
            AppBrandRemoteTaskController next2 = it2.next();
            if (!(next2 == null || next2.mAppId == null)) {
                arrayList.add(next2.mAppId);
            }
        }
        AppMethodBeat.o(227505);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final void afk(String str) {
        AppMethodBeat.i(48468);
        n afh = afh(str);
        if (afh != null) {
            afh.afk(str);
            if (afh.bWw().isEmpty()) {
                synchronized (nPL) {
                    try {
                        nPL.remove(afh);
                        nPL.addFirst(afh);
                    } finally {
                        AppMethodBeat.o(48468);
                    }
                }
                synchronized (nPK) {
                    try {
                        if (nPK.contains(afh)) {
                            nPK.remove(afh);
                            nPK.addFirst(afh);
                        }
                    } finally {
                        AppMethodBeat.o(48468);
                    }
                }
                return;
            }
        }
        AppMethodBeat.o(48468);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final void b(n nVar) {
        AppMethodBeat.i(48469);
        synchronized (nPL) {
            try {
                nPL.remove(nVar);
                nPL.addLast(nVar);
            } finally {
                AppMethodBeat.o(48469);
            }
        }
        synchronized (nPK) {
            try {
                if (nPK.contains(nVar)) {
                    nPK.remove(nVar);
                    nPK.addLast(nVar);
                }
            } finally {
                AppMethodBeat.o(48469);
            }
        }
    }

    public static p bWb() {
        AppMethodBeat.i(227506);
        if (!MMApplicationContext.isMainProcess()) {
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandTaskManager", "getInstance: only getInstance from main process:", Log.getStackTraceString(new Throwable()));
        }
        if (com.tencent.mm.plugin.appbrand.ui.p.bXu()) {
            i.b bVar = i.nPZ;
            i.a aVar = i.a.nQc;
            i bWk = i.a.bWk();
            AppMethodBeat.o(227506);
            return bWk;
        }
        h hVar = a.nPV;
        AppMethodBeat.o(227506);
        return hVar;
    }

    static p.a bWc() {
        AppMethodBeat.i(227507);
        if (com.tencent.mm.plugin.appbrand.ui.p.bXu()) {
            i.b bVar = i.nPZ;
            i.a aVar = i.a.nQc;
            i bWk = i.a.bWk();
            AppMethodBeat.o(227507);
            return bWk;
        }
        h hVar = a.nPV;
        AppMethodBeat.o(227507);
        return hVar;
    }

    static LinkedList<n> bWd() {
        LinkedList<n> linkedList;
        AppMethodBeat.i(48467);
        if (com.tencent.mm.plugin.appbrand.ui.p.bXu()) {
            LinkedList<n> linkedList2 = new LinkedList<>();
            linkedList2.addAll(i.bWj());
            AppMethodBeat.o(48467);
            return linkedList2;
        }
        synchronized (nPL) {
            try {
                linkedList = new LinkedList<>(nPL);
            } finally {
                AppMethodBeat.o(48467);
            }
        }
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static final h nPV = new h((byte) 0);

        static {
            AppMethodBeat.i(227493);
            AppMethodBeat.o(227493);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void Ue(String str) {
        AppMethodBeat.i(227508);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskManager", "onRuntimeFinish appId=".concat(String.valueOf(str)));
        nPO.remove(str);
        AppMethodBeat.o(227508);
    }

    private static boolean a(n nVar) {
        AppMethodBeat.i(227500);
        boolean endsWith = nVar.nQk.endsWith(AppBrandPluginUI.class.getSimpleName());
        AppMethodBeat.o(227500);
        return endsWith;
    }
}
