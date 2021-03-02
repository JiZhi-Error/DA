package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public class c {
    private static c JMT = null;

    static /* synthetic */ long a(c cVar, o oVar) {
        AppMethodBeat.i(177089);
        long aa = cVar.aa(oVar);
        AppMethodBeat.o(177089);
        return aa;
    }

    static /* synthetic */ void aK(String str, int i2, int i3) {
        AppMethodBeat.i(200167);
        aJ(str, i2, i3);
        AppMethodBeat.o(200167);
    }

    public static synchronized c gkN() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(110663);
            if (JMT == null) {
                synchronized (c.class) {
                    try {
                        if (JMT == null) {
                            JMT = new c();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(110663);
                        throw th;
                    }
                }
            }
            cVar = JMT;
            AppMethodBeat.o(110663);
        }
        return cVar;
    }

    public final synchronized void gkO() {
        AppMethodBeat.i(110664);
        if (Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_WEPKG_EXPIRED_TIME_LONG, (Object) 0L))) > 86400) {
            g.aAh().azQ().set(ar.a.USERINFO_WEPKG_EXPIRED_TIME_LONG, Long.valueOf(Util.nowSecond()));
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg in one day");
            com.tencent.mm.plugin.game.commlib.c.a.dTf().a("wepkg_expired_clean", new a.AbstractC1395a() {
                /* class com.tencent.mm.plugin.wepkg.model.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
                public final void cBm() {
                    AppMethodBeat.i(200161);
                    d.cyh().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.wepkg.model.c.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            ArrayList arrayList;
                            AppMethodBeat.i(200160);
                            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                            wepkgCrossProcessTask.EX = 2005;
                            if (MMApplicationContext.isMMProcess()) {
                                wepkgCrossProcessTask.bjj();
                            } else {
                                AppBrandMainProcessService.b(wepkgCrossProcessTask);
                            }
                            List<WepkgVersion> list = wepkgCrossProcessTask.JNi;
                            if (!Util.isNullOrNil(list)) {
                                Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", Integer.valueOf(list.size()));
                                for (WepkgVersion wepkgVersion : list) {
                                    if (wepkgVersion != null) {
                                        c.aI(wepkgVersion.hhD, 2, 8);
                                    }
                                }
                            } else {
                                Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
                            }
                            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "start clean dirty wepkg");
                            c.gkP();
                            long currentTimeMillis = System.currentTimeMillis();
                            long a2 = c.a(c.this, new o(e.gkQ()));
                            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "local wepkg size: %d, cost time: %d", Long.valueOf(a2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            f gkF = f.gkF();
                            if (!gkF.lsb) {
                                arrayList = null;
                            } else {
                                Cursor rawQuery = gkF.rawQuery(String.format("select %s from %s order by %s asc", "pkgId", "WepkgVersion", "accessTime"), new String[0]);
                                ArrayList arrayList2 = new ArrayList();
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        do {
                                            String string = rawQuery.getString(0);
                                            if (!Util.isNullOrNil(string)) {
                                                arrayList2.add(string);
                                            }
                                        } while (rawQuery.moveToNext());
                                    }
                                    rawQuery.close();
                                }
                                arrayList = arrayList2;
                            }
                            if (Util.isNullOrNil(arrayList)) {
                                AppMethodBeat.o(200160);
                                return;
                            }
                            while (a2 > 209715200 && arrayList.size() > 0) {
                                String str = (String) arrayList.remove(0);
                                if (!Util.isNullOrNil(str)) {
                                    c.aI(str, 2, 10);
                                    a2 = c.a(c.this, new o(e.gkQ()));
                                }
                            }
                            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg finish!");
                            AppMethodBeat.o(200160);
                        }
                    });
                    AppMethodBeat.o(200161);
                }
            });
            AppMethodBeat.o(110664);
        } else {
            AppMethodBeat.o(110664);
        }
    }

    public final void aH(final String str, final int i2, final int i3) {
        AppMethodBeat.i(200162);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            d.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.model.c.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(110660);
                    c.aI(str, i2, i3);
                    AppMethodBeat.o(110660);
                }
            });
            AppMethodBeat.o(200162);
            return;
        }
        aI(str, i2, i3);
        AppMethodBeat.o(200162);
    }

    public static void aI(String str, int i2, int i3) {
        AppMethodBeat.i(200163);
        if (MMApplicationContext.isMMProcess()) {
            aJ(str, i2, i3);
            AppMethodBeat.o(200163);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
            AppMethodBeat.o(200163);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("ipc_param_pkgid", str);
            bundle.putInt("ipc_param_type", i2);
            bundle.putInt("ipc_param_reason", i3);
            h.a(MainProcessIPCService.dkO, bundle, b.class);
            AppMethodBeat.o(200163);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void aJ(String str, int i2, int i3) {
        AppMethodBeat.i(200164);
        if (!MMApplicationContext.isMMProcess()) {
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
            AppMethodBeat.o(200164);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
            AppMethodBeat.o(200164);
        } else {
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", str, Integer.valueOf(i2));
            switch (i2) {
                case 0:
                    f.gkF().gkI();
                    gz(e.gkQ(), i3);
                    AppMethodBeat.o(200164);
                    return;
                case 1:
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(200164);
                        return;
                    }
                    gz(e.bcx(str), i3);
                    f.gkF().bcl(str);
                    com.tencent.mm.plugin.wepkg.b.d.gkE().bcl(str);
                    AppMethodBeat.o(200164);
                    return;
                case 2:
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(200164);
                        return;
                    }
                    c(e.bcx(str), bcw(str), i3);
                    f.gkF().bcl(str);
                    com.tencent.mm.plugin.wepkg.b.d.gkE().bcl(str);
                    AppMethodBeat.o(200164);
                    return;
                case 3:
                    if (!Util.isNullOrNil(str)) {
                        String bcx = e.bcx(str);
                        List bcw = bcw(str);
                        WepkgVersion bcH = j.bcH(str);
                        if (bcH != null) {
                            bcw.add(bcH.version);
                        }
                        c(bcx, bcw, i3);
                        break;
                    } else {
                        AppMethodBeat.o(200164);
                        return;
                    }
            }
            AppMethodBeat.o(200164);
        }
    }

    private long aa(o oVar) {
        long j2 = 0;
        AppMethodBeat.i(177088);
        if (oVar == null) {
            AppMethodBeat.o(177088);
        } else {
            try {
                if (oVar.isDirectory()) {
                    o[] het = oVar.het();
                    for (o oVar2 : het) {
                        if (oVar2.isFile()) {
                            j2 += oVar2.length();
                        } else {
                            j2 += aa(oVar2);
                        }
                    }
                } else if (oVar.isFile()) {
                    j2 = 0 + oVar.length();
                }
            } catch (Exception e2) {
            }
            AppMethodBeat.o(177088);
        }
        return j2;
    }

    private static List bcw(String str) {
        String string;
        String string2;
        AppMethodBeat.i(110669);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110669);
            return arrayList;
        }
        Bundle bundle = (Bundle) h.a(ToolsProcessIPCService.dkO, new IPCString(str), a.class);
        if (!(bundle == null || (string2 = bundle.getString("used_wepkg_version")) == null)) {
            arrayList.add(string2);
        }
        Bundle bundle2 = (Bundle) h.a(ToolsMpProcessIPCService.dkO, new IPCString(str), a.class);
        if (!(bundle2 == null || (string = bundle2.getString("used_wepkg_version")) == null)) {
            arrayList.add(string);
        }
        AppMethodBeat.o(110669);
        return arrayList;
    }

    private static boolean gz(String str, int i2) {
        AppMethodBeat.i(200165);
        try {
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s, reason:%d", str, Integer.valueOf(i2));
            com.tencent.mm.plugin.wepkg.utils.a.b("WepkgRemove", null, e.bcy(str), e.bcz(str), (long) i2, 0, null);
            o oVar = new o(str);
            o oVar2 = new o(oVar.getParent(), oVar.getName() + "_temp");
            if (oVar.am(oVar2)) {
                s.dy(aa.z(oVar2.mUri), true);
                AppMethodBeat.o(200165);
                return true;
            }
        } catch (Exception e2) {
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + e2.getMessage());
        }
        AppMethodBeat.o(200165);
        return false;
    }

    private static boolean c(String str, List list, int i2) {
        AppMethodBeat.i(200166);
        if (Util.isNullOrNil(list)) {
            gz(str, i2);
            AppMethodBeat.o(200166);
            return true;
        }
        o oVar = new o(str);
        if (!oVar.exists() || !oVar.isDirectory()) {
            AppMethodBeat.o(200166);
            return false;
        }
        o[] het = oVar.het();
        if (het == null) {
            AppMethodBeat.o(200166);
            return false;
        }
        for (o oVar2 : het) {
            if (oVar2 != null && !list.contains(oVar2.getName())) {
                gz(aa.z(oVar2.her()), i2);
            }
        }
        AppMethodBeat.o(200166);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class a implements k<IPCString, Bundle> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(IPCString iPCString) {
            AppMethodBeat.i(110661);
            IPCString iPCString2 = iPCString;
            if (iPCString2 == null) {
                AppMethodBeat.o(110661);
                return null;
            }
            String str = iPCString2.value;
            String bcf = com.tencent.mm.plugin.wepkg.d.bcf(str);
            Log.i("MicroMsg.Wepkg.CleanWepkgMgr", "pkgid:%s used_version:%s", str, bcf);
            Bundle bundle = new Bundle();
            bundle.putString("used_wepkg_version", bcf);
            AppMethodBeat.o(110661);
            return bundle;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements k<Bundle, Bundle> {
        private b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(110662);
            Bundle bundle2 = bundle;
            if (bundle2 == null) {
                AppMethodBeat.o(110662);
            } else {
                c.aK(bundle2.getString("ipc_param_pkgid"), bundle2.getInt("ipc_param_type", -1), bundle2.getInt("ipc_param_reason", 0));
                AppMethodBeat.o(110662);
            }
            return null;
        }
    }

    static /* synthetic */ void gkP() {
        AppMethodBeat.i(110672);
        o oVar = new o(e.gkQ());
        if (!oVar.exists() || !oVar.isDirectory()) {
            AppMethodBeat.o(110672);
            return;
        }
        o[] het = oVar.het();
        if (het == null || het.length == 0) {
            AppMethodBeat.o(110672);
            return;
        }
        for (o oVar2 : het) {
            if (oVar2 != null) {
                aI(oVar2.getName(), 3, 9);
            }
        }
        AppMethodBeat.o(110672);
    }
}
