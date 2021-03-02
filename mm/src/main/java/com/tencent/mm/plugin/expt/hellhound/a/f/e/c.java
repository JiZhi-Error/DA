package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.f.d.b;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.protocal.protobuf.dvp;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c {
    private static final Map<Integer, WeakReference<Activity>> sIN = new HashMap();

    static {
        AppMethodBeat.i(122214);
        AppMethodBeat.o(122214);
    }

    public static synchronized void dp(String str, int i2) {
        synchronized (c.class) {
            AppMethodBeat.i(220578);
            if (sIN.isEmpty()) {
                AppMethodBeat.o(220578);
            } else if (i2 > 0) {
                try {
                    sIN.remove(Integer.valueOf(i2));
                    AppMethodBeat.o(220578);
                } catch (NumberFormatException e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAParamsCatcher", e2, "HellSessionUBAParamsCatcher, onDestroy: %s", e2.getMessage());
                    AppMethodBeat.o(220578);
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
                AppMethodBeat.o(220578);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void f(Activity activity, int i2) {
        AppMethodBeat.i(122202);
        if (activity == null) {
            AppMethodBeat.o(122202);
            return;
        }
        switch (i2) {
            case 0:
                ag(activity);
                AppMethodBeat.o(122202);
                return;
            case 2:
                ah(activity);
                break;
        }
        AppMethodBeat.o(122202);
    }

    private static synchronized void ag(Activity activity) {
        synchronized (c.class) {
            AppMethodBeat.i(122203);
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
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(402, Integer.valueOf(hashCode));
            AppMethodBeat.o(122203);
        }
    }

    public static synchronized void Hn(int i2) {
        Activity activity;
        synchronized (c.class) {
            AppMethodBeat.i(122204);
            WeakReference<Activity> weakReference = sIN.get(Integer.valueOf(i2));
            if (weakReference == null || (activity = weakReference.get()) == null) {
                AppMethodBeat.o(122204);
            } else if (activity.isDestroyed()) {
                AppMethodBeat.o(122204);
            } else {
                cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                if (cQo != null) {
                    b(activity, cQo, true);
                }
                AppMethodBeat.o(122204);
            }
        }
    }

    private static synchronized void ah(Activity activity) {
        synchronized (c.class) {
            AppMethodBeat.i(122205);
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
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(403, Integer.valueOf(hashCode));
            AppMethodBeat.o(122205);
        }
    }

    public static synchronized void Ho(int i2) {
        Activity activity;
        synchronized (c.class) {
            AppMethodBeat.i(122206);
            WeakReference<Activity> weakReference = sIN.get(Integer.valueOf(i2));
            if (weakReference == null || (activity = weakReference.get()) == null) {
                AppMethodBeat.o(122206);
            } else if (activity.isDestroyed()) {
                AppMethodBeat.o(122206);
            } else {
                cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                if (cQo != null) {
                    b(activity, cQo, false);
                }
                AppMethodBeat.o(122206);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(Fragment fragment, int i2) {
        AppMethodBeat.i(122208);
        if (fragment == null) {
            AppMethodBeat.o(122208);
            return;
        }
        switch (i2) {
            case 0:
                cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                if (cQo != null) {
                    b(fragment, cQo, true);
                }
                AppMethodBeat.o(122208);
                return;
            case 2:
                cyl cQo2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                if (cQo2 != null) {
                    b(fragment, cQo2, false);
                    break;
                }
                break;
        }
        AppMethodBeat.o(122208);
    }

    private static void b(Object obj, cyl cyl, boolean z) {
        AppMethodBeat.i(122211);
        e.cQg();
        dvo cQh = e.cQh();
        if (cQh == null || cQh.gyp) {
            AppMethodBeat.o(122211);
            return;
        }
        Iterator<dvp> it = cQh.iAd.iterator();
        while (true) {
            if (it.hasNext()) {
                dvp next = it.next();
                if (next != null) {
                    a(obj, next, cyl, z);
                    break;
                }
            } else {
                break;
            }
        }
        AppMethodBeat.o(122211);
    }

    private static void a(Object obj, dvp dvp, cyl cyl, boolean z) {
        AppMethodBeat.i(122212);
        Iterator<cyk> it = dvp.KVY.iterator();
        while (true) {
            if (it.hasNext()) {
                cyk next = it.next();
                if (next != null) {
                    a(obj, next, cyl, z);
                    break;
                }
            } else {
                break;
            }
        }
        AppMethodBeat.o(122212);
    }

    private static void a(Object obj, cyk cyk, cyl cyl, boolean z) {
        AppMethodBeat.i(122213);
        com.tencent.mm.vending.j.c<cbm, Integer> gw = b.gw(cyl.sessionId, obj.getClass().getSimpleName());
        if (gw == null) {
            AppMethodBeat.o(122213);
            return;
        }
        cbm cbm = (cbm) gw.get(0);
        b.a(obj, cyk, cbm, true, z);
        b.a(cbm, ((Integer) gw.get(1)).intValue());
        AppMethodBeat.o(122213);
    }
}
