package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;

/* access modifiers changed from: package-private */
public final class c {
    d.a szF;
    private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d szJ = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d() {
        /* class com.tencent.mm.plugin.expt.hellhound.core.b.a.c.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:63:0x0210  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x021e  */
        @Override // com.tencent.mm.plugin.expt.hellhound.core.a.a.d
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.expt.hellhound.core.a.a.a r13) {
            /*
            // Method dump skipped, instructions count: 4450
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.core.b.a.c.AnonymousClass1.a(com.tencent.mm.plugin.expt.hellhound.core.a.a.a):void");
        }
    };

    c() {
        AppMethodBeat.i(121938);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().szl.szn = this.szJ;
        AppMethodBeat.o(121938);
    }

    static cuz c(Activity activity, long j2) {
        AppMethodBeat.i(184312);
        cuz cuz = new cuz();
        cuz.LOX = new eih();
        cuz.LOX.activityName = activity.getClass().getCanonicalName();
        cuz.LOX.aHK = activity.hashCode();
        cuz.LOX.timestamp = j2;
        com.tencent.mm.vending.j.d<String, Boolean, Boolean> X = X(activity);
        cuz.LOY = (String) X.get(0);
        cuz.LPb = ((Boolean) X.get(1)).booleanValue();
        cuz.Mhh = ((Boolean) X.get(2)).booleanValue();
        AppMethodBeat.o(184312);
        return cuz;
    }

    private static com.tencent.mm.vending.j.d<String, Boolean, Boolean> X(Activity activity) {
        AppMethodBeat.i(121940);
        com.tencent.mm.vending.j.c<String, Boolean> Y = Y(activity);
        if (!((Boolean) Y.get(1)).booleanValue()) {
            com.tencent.mm.vending.j.d<String, Boolean, Boolean> i2 = a.i(Y.get(0), Y.get(1), Boolean.FALSE);
            AppMethodBeat.o(121940);
            return i2;
        }
        com.tencent.mm.vending.j.d<String, Boolean, Boolean> i3 = a.i(Y.get(0), Y.get(1), Boolean.valueOf(b.aoz(activity.getClass().getCanonicalName())));
        AppMethodBeat.o(121940);
        return i3;
    }

    static cuy g(Intent intent, Activity activity) {
        AppMethodBeat.i(121941);
        cuy cuy = new cuy();
        if (intent != null) {
            cuy.flags = intent.getFlags();
        }
        cuy.LOX = new eih();
        if (activity == null) {
            AppMethodBeat.o(121941);
        } else {
            cuy.LOX.activityName = activity.getClass().getCanonicalName();
            cuy.LOX.aHK = activity.hashCode();
            cuy.LOX.timestamp = System.currentTimeMillis();
            AppMethodBeat.o(121941);
        }
        return cuy;
    }

    static com.tencent.mm.vending.j.c<String, Boolean> Y(Activity activity) {
        AppMethodBeat.i(121942);
        String str = null;
        Fragment aa = h.aa(activity);
        if (aa != null) {
            str = aa.getClass().getCanonicalName();
        }
        boolean z = true;
        if (str == null) {
            str = activity.getClass().getCanonicalName();
            z = false;
        }
        com.tencent.mm.vending.j.c<String, Boolean> Q = a.Q(str, Boolean.valueOf(z));
        AppMethodBeat.o(121942);
        return Q;
    }

    static void aX(String str, boolean z) {
        AppMethodBeat.i(121943);
        a.GQ(1);
        if (z || !b.aoz(str)) {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            bn cNR = e.cNR();
            String str2 = null;
            if (cNR != null) {
                str2 = cNR.KFh.activityName;
            }
            a.apg(str);
            a.ape(str2);
            Log.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", str, str2);
            AppMethodBeat.o(121943);
            return;
        }
        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
        AppMethodBeat.o(121943);
    }

    static void a(int i2, eih eih) {
        String str;
        AppMethodBeat.i(184313);
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(eih.activityName, null, 104);
        com.tencent.mm.vending.j.d<String, Boolean, String> GS = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GS(101);
        if (GS != null) {
            str = (String) GS.get(0);
        } else {
            str = null;
        }
        if (!eih.activityName.equals(str)) {
            Log.w("HABBYGE-MALI.AsyncActivityMonitor", "_onCreateEvent: %s, %s", str, eih.activityName);
            b(i2, null, null, eih.activityName, eih.aHK, eih.timestamp);
        }
        a(eih.activityName, eih.aHK, com.tencent.mm.plugin.expt.hellhound.core.stack.a.CREATE);
        AppMethodBeat.o(184313);
    }

    static void a(String str, int i2, com.tencent.mm.plugin.expt.hellhound.core.stack.a aVar) {
        AppMethodBeat.i(220427);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(str, i2, aVar);
        AppMethodBeat.o(220427);
    }

    static void b(int i2, String str, String str2, String str3, int i3, long j2) {
        AppMethodBeat.i(220428);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM().a(i2, str, str2, str3, i3, j2);
        AppMethodBeat.o(220428);
    }

    static eih a(eih eih) {
        AppMethodBeat.i(184315);
        if (eih == null || TextUtils.isEmpty(eih.activityName)) {
            try {
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                com.tencent.mm.vending.j.c<String, Integer> cNN = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNN();
                if (cNN == null) {
                    AppMethodBeat.o(184315);
                    return null;
                }
                if (eih == null) {
                    eih = new eih();
                    eih.timestamp = System.currentTimeMillis();
                }
                eih.activityName = (String) cNN.get(0);
                eih.aHK = ((Integer) cNN.get(1)).intValue();
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", e2, "getActivityOnFinish", new Object[0]);
                AppMethodBeat.o(184315);
                return null;
            }
        }
        AppMethodBeat.o(184315);
        return eih;
    }
}
