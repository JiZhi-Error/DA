package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.p;
import com.tencent.mm.plugin.appbrand.utils.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static final LinkedHashMap<String, q> kzj = new LinkedHashMap() {
        /* class com.tencent.mm.plugin.appbrand.a.AnonymousClass2 */

        /* access modifiers changed from: protected */
        @Override // java.util.LinkedHashMap
        public final boolean removeEldestEntry(Map.Entry entry) {
            AppMethodBeat.i(43773);
            boolean z = size() >= a.Tp();
            if (z) {
                final q qVar = (q) entry.getValue();
                Log.i("MicroMsg.AppBrandBridge", "%s will be removed from sKeepNoRecycleRuntimeMap", qVar.toString());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.a.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(43772);
                        qVar.brJ();
                        AppMethodBeat.o(43772);
                    }
                });
            }
            AppMethodBeat.o(43773);
            return z;
        }
    };
    private static final Map<String, q> kzk = new HashMap();

    static {
        AppMethodBeat.i(43783);
        MMApplicationContext.getContext().registerComponentCallbacks(new i() {
            /* class com.tencent.mm.plugin.appbrand.a.AnonymousClass1 */

            public final void onTrimMemory(int i2) {
                AppMethodBeat.i(43771);
                Log.i("MicroMsg.AppBrandBridge", "onTrimMemory level=%d", Integer.valueOf(i2));
                switch (i2) {
                    case 10:
                    case 15:
                        synchronized (a.kzk) {
                            try {
                                Iterator it = new LinkedList(a.kzj.values()).iterator();
                                while (it.hasNext()) {
                                    q qVar = (q) it.next();
                                    if (!qVar.mResumed) {
                                        a.kzj.remove(qVar.mAppId);
                                        qVar.brJ();
                                    }
                                }
                            } finally {
                                AppMethodBeat.o(43771);
                            }
                        }
                        return;
                    default:
                        AppMethodBeat.o(43771);
                        return;
                }
            }
        });
        AppMethodBeat.o(43783);
    }

    public static boolean a(q qVar) {
        boolean containsValue;
        AppMethodBeat.i(43774);
        synchronized (kzk) {
            try {
                containsValue = kzj.containsValue(qVar);
            } finally {
                AppMethodBeat.o(43774);
            }
        }
        return containsValue;
    }

    public static void e(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(43775);
        LinkedList<q> linkedList = new LinkedList();
        synchronized (kzk) {
            try {
                for (q qVar : kzk.values()) {
                    if (!(qVar == null || !qVar.NA() || qVar == appBrandRuntime)) {
                        linkedList.add(qVar);
                    }
                }
            } finally {
                AppMethodBeat.o(43775);
            }
        }
        for (q qVar2 : linkedList) {
            qVar2.bsH();
        }
    }

    public static boolean bqU() {
        AppMethodBeat.i(43776);
        synchronized (kzk) {
            try {
                for (q qVar : kzk.values()) {
                    if (qVar != null && qVar.NA()) {
                        return true;
                    }
                }
                AppMethodBeat.o(43776);
                return false;
            } finally {
                AppMethodBeat.o(43776);
            }
        }
    }

    public static q TQ(String str) {
        q qVar;
        AppMethodBeat.i(43779);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43779);
            return null;
        }
        synchronized (kzk) {
            try {
                qVar = kzk.get(str);
            } finally {
                AppMethodBeat.o(43779);
            }
        }
        return qVar;
    }

    public static int bqV() {
        int size;
        AppMethodBeat.i(43780);
        synchronized (kzk) {
            try {
                size = kzk.size();
            } finally {
                AppMethodBeat.o(43780);
            }
        }
        return size;
    }

    @Deprecated
    public static AppBrandSysConfigWC TR(String str) {
        AppMethodBeat.i(43781);
        q TQ = TQ(str);
        if (TQ == null) {
            AppMethodBeat.o(43781);
            return null;
        }
        AppBrandSysConfigWC bsB = TQ.bsB();
        AppMethodBeat.o(43781);
        return bsB;
    }

    @Deprecated
    public static AppBrandStatObject TS(String str) {
        AppMethodBeat.i(43782);
        q TQ = TQ(str);
        if (TQ == null) {
            AppMethodBeat.o(43782);
            return null;
        }
        AppBrandStatObject appBrandStatObject = TQ.ON().cyA;
        AppMethodBeat.o(43782);
        return appBrandStatObject;
    }

    static void b(q qVar) {
        AppMethodBeat.i(43777);
        if (Util.isNullOrNil(qVar.mAppId)) {
            Log.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
            AppMethodBeat.o(43777);
            return;
        }
        synchronized (kzk) {
            try {
                q qVar2 = kzk.get(qVar.mAppId);
                if (qVar2 == null || qVar2 == qVar) {
                    kzk.remove(qVar.mAppId);
                    kzj.remove(qVar.mAppId);
                } else {
                    Log.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", Util.stackTraceToString(new Throwable()));
                }
            } finally {
                AppMethodBeat.o(43777);
            }
        }
    }

    static void setRuntime(q qVar) {
        AppMethodBeat.i(43778);
        if (Util.isNullOrNil(qVar.mAppId)) {
            Log.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
            AppMethodBeat.o(43778);
            return;
        }
        synchronized (kzk) {
            try {
                kzk.put(qVar.mAppId, qVar);
                kzj.put(qVar.mAppId, qVar);
            } finally {
                AppMethodBeat.o(43778);
            }
        }
        if (qVar.bsC() != null) {
            j.cg(qVar.mAppId, qVar.bsC().cyo);
        }
    }

    static /* synthetic */ int Tp() {
        AppMethodBeat.i(226130);
        if (p.bXv()) {
            AppMethodBeat.o(226130);
            return 5;
        }
        AppMethodBeat.o(226130);
        return 3;
    }
}
