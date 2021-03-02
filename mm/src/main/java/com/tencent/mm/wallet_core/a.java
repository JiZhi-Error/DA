package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private static Map<String, Class<?>> RrV = new ConcurrentHashMap();
    private static SparseArray<d> RrW = new SparseArray<>();

    static {
        AppMethodBeat.i(72640);
        AppMethodBeat.o(72640);
    }

    public static void j(String str, Class<?> cls) {
        AppMethodBeat.i(72624);
        if (RrV.containsKey(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("register process fail, exist process=".concat(String.valueOf(str)));
            AppMethodBeat.o(72624);
            throw illegalArgumentException;
        }
        RrV.put(str, cls);
        AppMethodBeat.o(72624);
    }

    private static String bz(Bundle bundle) {
        AppMethodBeat.i(72625);
        if (bundle == null) {
            AppMethodBeat.o(72625);
            return "";
        }
        String bundle2 = bundle.toString();
        AppMethodBeat.o(72625);
        return bundle2;
    }

    public static void remove(int i2) {
        AppMethodBeat.i(72626);
        RrW.remove(i2);
        AppMethodBeat.o(72626);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle) {
        AppMethodBeat.i(72627);
        a(activity, cls, bundle, (d.a) null);
        AppMethodBeat.o(72627);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle, d.a aVar) {
        AppMethodBeat.i(72628);
        Log.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", activity, cls.getSimpleName(), bz(bundle));
        try {
            if ((activity instanceof WalletBaseUI) && aVar != null) {
                ((WalletBaseUI) activity).keepProcessEnd(aVar);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getLong("key_SessionId", 0) == 0) {
                bundle.putLong("key_SessionId", System.currentTimeMillis());
            }
            d dVar = (d) cls.newInstance();
            dVar.bA(bundle);
            dVar.a(aVar, activity);
            dVar.a(activity, bundle);
            RrW.put(cls.hashCode(), dVar);
            AppMethodBeat.o(72628);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ProcessManager", e2, "", new Object[0]);
            AppMethodBeat.o(72628);
        }
    }

    public static void b(Activity activity, String str, Bundle bundle) {
        AppMethodBeat.i(72629);
        a(activity, str, bundle, (d.a) null);
        AppMethodBeat.o(72629);
    }

    public static void a(Activity activity, String str, Bundle bundle, d.a aVar) {
        AppMethodBeat.i(72630);
        try {
            Log.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", activity, str, bz(bundle));
            Class<?> cls = RrV.get(str);
            if (cls == null) {
                String format = String.format("start process=%s fail, process not register or plugin no import", str);
                Log.e("MicroMsg.ProcessManager", format);
                u.makeText(activity, format, 1).show();
                AppMethodBeat.o(72630);
                return;
            }
            a(activity, cls, bundle, aVar);
            AppMethodBeat.o(72630);
        } catch (Exception e2) {
            Log.e("MicroMsg.ProcessManager", "plugin load failed : " + e2.toString());
            Log.printErrStackTrace("MicroMsg.ProcessManager", e2, "", new Object[0]);
            AppMethodBeat.o(72630);
        }
    }

    public static void l(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72631);
        d by = by(activity);
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = bz(bundle);
        objArr[2] = by == null ? "" : by.dKC();
        Log.i("MicroMsg.ProcessManager", "forwardProcess to1 context: %s bundle: %s procName %s", objArr);
        if (by != null) {
            by.a(activity, 0, bundle);
        }
        AppMethodBeat.o(72631);
    }

    public static void bv(Activity activity) {
        AppMethodBeat.i(72632);
        d by = by(activity);
        Object[] objArr = new Object[2];
        objArr[0] = activity;
        objArr[1] = by == null ? "" : by.dKC();
        Log.i("MicroMsg.ProcessManager", "backProcess to1 context: %s procname %s", objArr);
        if (by != null) {
            by.g(activity, 0);
        }
        AppMethodBeat.o(72632);
    }

    public static void s(Activity activity, int i2) {
        AppMethodBeat.i(72633);
        if (activity == null) {
            Log.w("MicroMsg.ProcessManager", "hy: back context is null");
        }
        d by = by(activity);
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = by == null ? "" : by.dKC();
        Log.i("MicroMsg.ProcessManager", "backProcess to1 context: %s errCode %s procname %s ", objArr);
        if (by != null) {
            by.g(activity, i2);
            AppMethodBeat.o(72633);
            return;
        }
        if (!activity.isFinishing()) {
            activity.finish();
        }
        AppMethodBeat.o(72633);
    }

    public static void c(Activity activity, Bundle bundle, int i2) {
        AppMethodBeat.i(72634);
        Log.i("MicroMsg.ProcessManager", "endProcess with errCode : ".concat(String.valueOf(i2)));
        if (activity == null) {
            Log.w("MicroMsg.ProcessManager", "hy: end context is null");
        }
        d by = by(activity);
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = bz(bundle);
        objArr[2] = by == null ? "" : by.dKC();
        Log.i("MicroMsg.ProcessManager", "endProcess to1 context: %s bundle: %s procName %s", objArr);
        if (by != null) {
            by.b(activity, bundle);
            AppMethodBeat.o(72634);
            return;
        }
        if (!activity.isFinishing()) {
            activity.finish();
        }
        AppMethodBeat.o(72634);
    }

    public static boolean bw(Activity activity) {
        AppMethodBeat.i(72635);
        if (by(activity) != null) {
            AppMethodBeat.o(72635);
            return true;
        }
        AppMethodBeat.o(72635);
        return false;
    }

    public static Bundle bx(Activity activity) {
        AppMethodBeat.i(72636);
        d by = by(activity);
        if (by != null) {
            Bundle bundle = by.dQL;
            AppMethodBeat.o(72636);
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        AppMethodBeat.o(72636);
        return bundle2;
    }

    public static boolean m(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72637);
        d by = by(activity);
        if (by != null) {
            by.bA(bundle);
            AppMethodBeat.o(72637);
            return true;
        }
        AppMethodBeat.o(72637);
        return false;
    }

    public static d by(Activity activity) {
        AppMethodBeat.i(72638);
        if (activity == null) {
            Log.w("MicroMsg.ProcessManager", "hy: ac is null");
            AppMethodBeat.o(72638);
            return null;
        } else if (activity.getIntent() == null) {
            Log.w("MicroMsg.ProcessManager", "hy: get intent is null");
            AppMethodBeat.o(72638);
            return null;
        } else {
            d dVar = RrW.get(activity.getIntent().getIntExtra("process_id", 0));
            AppMethodBeat.o(72638);
            return dVar;
        }
    }

    public static List<d> bpk(String str) {
        AppMethodBeat.i(72639);
        ArrayList arrayList = new ArrayList();
        int size = RrW.size();
        for (int i2 = 0; i2 < size; i2++) {
            d valueAt = RrW.valueAt(i2);
            if (str.equals(valueAt.dKC())) {
                arrayList.add(valueAt);
            }
        }
        AppMethodBeat.o(72639);
        return arrayList;
    }
}
