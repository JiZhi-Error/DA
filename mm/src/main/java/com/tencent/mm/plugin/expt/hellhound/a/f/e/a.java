package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a {
    private static final Map<Integer, WeakReference<Activity>> sIN = new HashMap();
    private static WeakReference<Object> syV = null;

    static {
        AppMethodBeat.i(122193);
        AppMethodBeat.o(122193);
    }

    public static Object cNw() {
        AppMethodBeat.i(220572);
        if (syV == null) {
            Object cNw = com.tencent.mm.plugin.expt.hellhound.core.a.cNx().cNw();
            AppMethodBeat.o(220572);
            return cNw;
        }
        Object obj = syV.get();
        AppMethodBeat.o(220572);
        return obj;
    }

    public static void df(Object obj) {
        AppMethodBeat.i(220573);
        if (obj != null) {
            syV = new WeakReference<>(obj);
        }
        AppMethodBeat.o(220573);
    }

    public static void dp(String str, int i2) {
        AppMethodBeat.i(220574);
        if (sIN.isEmpty()) {
            AppMethodBeat.o(220574);
        } else if (i2 > 0) {
            try {
                sIN.remove(Integer.valueOf(i2));
                AppMethodBeat.o(220574);
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", e2, "HellPageParamsCatcher, onDestroy: %s", e2.getMessage());
                AppMethodBeat.o(220574);
            }
        } else {
            ArrayList<Integer> arrayList = new ArrayList();
            Iterator<Map.Entry<Integer, WeakReference<Activity>>> it = sIN.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, WeakReference<Activity>> next = it.next();
                if (next != null) {
                    Activity activity = next.getValue().get();
                    if (activity != null) {
                        String canonicalName = activity.getClass().getCanonicalName();
                        if (canonicalName != null && canonicalName.equals(str)) {
                            arrayList.add(next.getKey());
                            break;
                        }
                    } else {
                        arrayList.add(next.getKey());
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                for (Integer num : arrayList) {
                    sIN.remove(Integer.valueOf(num.intValue()));
                }
            }
            AppMethodBeat.o(220574);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void f(Activity activity, int i2) {
        AppMethodBeat.i(122182);
        if (activity == null) {
            AppMethodBeat.o(122182);
            return;
        }
        switch (i2) {
            case 0:
                int hashCode = activity.hashCode();
                if (!sIN.containsKey(Integer.valueOf(hashCode))) {
                    sIN.put(Integer.valueOf(hashCode), new WeakReference<>(activity));
                } else {
                    WeakReference<Activity> weakReference = sIN.get(Integer.valueOf(hashCode));
                    if (weakReference == null || weakReference.get() == null) {
                        sIN.remove(Integer.valueOf(hashCode));
                        sIN.put(Integer.valueOf(hashCode), new WeakReference<>(activity));
                    }
                }
                c.cNJ().m(400, Integer.valueOf(hashCode));
                AppMethodBeat.o(122182);
                return;
            case 2:
                int hashCode2 = activity.hashCode();
                if (!sIN.containsKey(Integer.valueOf(hashCode2))) {
                    sIN.put(Integer.valueOf(hashCode2), new WeakReference<>(activity));
                } else {
                    WeakReference<Activity> weakReference2 = sIN.get(Integer.valueOf(hashCode2));
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sIN.remove(Integer.valueOf(hashCode2));
                        sIN.put(Integer.valueOf(hashCode2), new WeakReference<>(activity));
                    }
                }
                c.cNJ().m(401, Integer.valueOf(hashCode2));
                break;
        }
        AppMethodBeat.o(122182);
    }

    @SuppressLint({"NewApi"})
    public static void Hn(int i2) {
        Activity activity;
        AppMethodBeat.i(122183);
        WeakReference<Activity> weakReference = sIN.get(Integer.valueOf(i2));
        if (weakReference == null || (activity = weakReference.get()) == null) {
            AppMethodBeat.o(122183);
        } else if (activity.isDestroyed()) {
            AppMethodBeat.o(122183);
        } else {
            cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
            if (cQo != null) {
                a(activity, cQo, true);
            }
            AppMethodBeat.o(122183);
        }
    }

    @SuppressLint({"NewApi"})
    public static void Ho(int i2) {
        Activity activity;
        AppMethodBeat.i(122184);
        WeakReference<Activity> weakReference = sIN.get(Integer.valueOf(i2));
        if (weakReference == null || (activity = weakReference.get()) == null) {
            AppMethodBeat.o(122184);
        } else if (activity.isDestroyed()) {
            AppMethodBeat.o(122184);
        } else {
            cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
            if (cQo != null) {
                Log.i("HABBYGE-MALI.HellPageParamsCatcher", "catchOnActivityFinishAsync: %s", cQo.sessionId);
                a(activity, cQo, false);
            }
            AppMethodBeat.o(122184);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(Fragment fragment, int i2) {
        AppMethodBeat.i(122185);
        if (fragment == null) {
            AppMethodBeat.o(122185);
            return;
        }
        switch (i2) {
            case 0:
                cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                if (cQo != null) {
                    a(fragment, cQo, true);
                }
                AppMethodBeat.o(122185);
                return;
            case 2:
                cyl cQo2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                if (cQo2 != null) {
                    a(fragment, cQo2, false);
                    break;
                }
                break;
        }
        AppMethodBeat.o(122185);
    }

    private static void a(Object obj, cyl cyl, boolean z) {
        String str;
        AppMethodBeat.i(122189);
        d.cQe();
        dvh cQf = d.cQf();
        if (cQf == null) {
            Log.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
            AppMethodBeat.o(122189);
            return;
        }
        String aqn = b.aqn(cyl.sessionId);
        if (b.aqu(cyl.sessionId)) {
            str = b.k(cyl);
        } else {
            str = aqn;
        }
        Iterator<dvk> it = cQf.MWn.iterator();
        while (it.hasNext()) {
            dvk next = it.next();
            if (next != null && (next.sGF.equals(str) || "-1".equals(next.sGF))) {
                a(obj, next, cyl, z);
            }
        }
        AppMethodBeat.o(122189);
    }

    private static void a(Object obj, dvk dvk, cyl cyl, boolean z) {
        AppMethodBeat.i(169351);
        String canonicalName = obj.getClass().getCanonicalName();
        int size = dvk.MWr.size();
        if (size == 1) {
            b(obj, dvk, cyl, z);
            AppMethodBeat.o(169351);
            return;
        }
        for (int i2 = 1; i2 < size; i2++) {
            dvg dvg = dvk.MWr.get(i2 - 1);
            dvg dvg2 = dvk.MWr.get(i2);
            if (!(dvg == null || dvg2 == null)) {
                if (dvk.type != 0) {
                    if (dvk.type != 1) {
                        continue;
                    } else if (size == 2) {
                        a(obj, dvg, dvg2, canonicalName, cyl, dvk.LPN, z);
                        AppMethodBeat.o(169351);
                        return;
                    }
                }
                a(obj, canonicalName, dvg, dvg2, cyl, z, dvk);
            }
        }
        AppMethodBeat.o(169351);
    }

    private static void a(Object obj, String str, dvg dvg, dvg dvg2, cyl cyl, boolean z, dvk dvk) {
        AppMethodBeat.i(177398);
        String cNy = com.tencent.mm.plugin.expt.hellhound.core.b.cNy();
        if (dvg2.dMl.equals(str) && dvg.dMl.equals(cNy)) {
            if (dvk.type == 0) {
                a(obj, str, dvg2, cyl.sessionId, z);
                AppMethodBeat.o(177398);
                return;
            } else if (dvk.type == 1) {
                a(obj, dvg2, str, cyl, dvk.LPN, z);
            }
        }
        AppMethodBeat.o(177398);
    }

    private static void b(Object obj, dvk dvk, cyl cyl, boolean z) {
        AppMethodBeat.i(169352);
        dvg dvg = dvk.MWr.get(0);
        if (dvg == null) {
            AppMethodBeat.o(169352);
            return;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        if (dvk.type == 0) {
            if (dvg.dMl.equals(canonicalName)) {
                a(obj, canonicalName, dvg, cyl.sessionId, z);
                AppMethodBeat.o(169352);
                return;
            }
        } else if (dvk.type == 1) {
            a(obj, dvg, canonicalName, cyl, dvk.LPN, z);
        }
        AppMethodBeat.o(169352);
    }

    private static void a(Object obj, dvg dvg, String str, cyl cyl, long j2, boolean z) {
        AppMethodBeat.i(169353);
        if (z) {
            if (dvg.dMl.equals(str)) {
                a(obj, dvg, cyl.sessionId, j2, true);
                AppMethodBeat.o(169353);
                return;
            }
        } else if (dvg.dMl.equals(str)) {
            a(obj, dvg, cyl.sessionId, j2, false);
        }
        AppMethodBeat.o(169353);
    }

    private static void a(Object obj, dvg dvg, dvg dvg2, String str, cyl cyl, long j2, boolean z) {
        AppMethodBeat.i(169354);
        if (z) {
            if (dvg2.dMl.equals(str)) {
                a(obj, dvg2, cyl.sessionId, j2, true);
                AppMethodBeat.o(169354);
                return;
            } else if (dvg.dMl.equals(str)) {
                a(obj, dvg, cyl.sessionId, j2, true);
                AppMethodBeat.o(169354);
                return;
            }
        } else if (dvg2.dMl.equals(str)) {
            a(obj, dvg2, cyl.sessionId, j2, false);
            AppMethodBeat.o(169354);
            return;
        } else if (dvg.dMl.equals(str)) {
            a(obj, dvg, cyl.sessionId, j2, false);
        }
        AppMethodBeat.o(169354);
    }

    private static void a(Object obj, dvg dvg, String str, long j2, boolean z) {
        AppMethodBeat.i(169355);
        Pair<bgb, Integer> ah = com.tencent.mm.plugin.expt.hellhound.a.d.d.ah(str, j2);
        if (ah == null) {
            AppMethodBeat.o(169355);
            return;
        }
        bgb bgb = (bgb) ah.first;
        int intValue = ((Integer) ah.second).intValue();
        Iterator<cyk> it = dvg.MWl.iterator();
        while (it.hasNext()) {
            cyk next = it.next();
            if (next != null) {
                b.a(obj, next, bgb, z);
            }
        }
        com.tencent.mm.plugin.expt.hellhound.a.d.d.a(str, bgb, intValue);
        AppMethodBeat.o(169355);
    }

    private static void a(Object obj, String str, dvg dvg, String str2, boolean z) {
        AppMethodBeat.i(169356);
        com.tencent.mm.vending.j.c<cbm, Integer> gw = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gw(str2, str);
        if (gw == null) {
            AppMethodBeat.o(169356);
            return;
        }
        cbm cbm = (cbm) gw.get(0);
        Iterator<cyk> it = dvg.MWl.iterator();
        while (it.hasNext()) {
            cyk next = it.next();
            if (next != null) {
                b.a(obj, next, cbm, false, z);
            }
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cbm, ((Integer) gw.get(1)).intValue());
        AppMethodBeat.o(169356);
    }
}
