package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.f;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.c;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;

public final class b implements e, c {
    private d.a szF;
    private d szG = new d(this);
    private c szH = new c();
    private boolean szI = a.cNt();

    public b() {
        AppMethodBeat.i(121919);
        AppMethodBeat.o(121919);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.c
    public final void a(d.a aVar) {
        this.szF = aVar;
        this.szH.szF = aVar;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.c
    public final void l(Application application) {
        AppMethodBeat.i(121920);
        if (application == null) {
            AppMethodBeat.o(121920);
        } else if (!a.cNo()) {
            AppMethodBeat.o(121920);
        } else {
            d dVar = this.szG;
            com.tencent.mm.hellhoundlib.a.axP().hlG = dVar.szM;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
            arrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
            arrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
            arrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
            com.tencent.mm.hellhoundlib.a.axP();
            com.tencent.mm.hellhoundlib.a.a(arrayList, dVar.szN);
            AppMethodBeat.o(121920);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void a(Activity activity, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String gv;
        ComponentName component;
        AppMethodBeat.i(121921);
        if (this.szI) {
            long currentTimeMillis = System.currentTimeMillis();
            eci eci = new eci();
            eci.Mhd = new eih();
            if (activity != null) {
                String canonicalName = activity.getClass().getCanonicalName();
                eci.Mhd.aHK = activity.hashCode();
                Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, fromActivityName: %s", canonicalName);
                com.tencent.mm.vending.j.c<String, Boolean> Y = c.Y(activity);
                eci.LOY = (String) Y.get(0);
                eci.LPb = ((Boolean) Y.get(1)).booleanValue();
                str3 = canonicalName;
            } else {
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                bn cNR = e.cNR();
                if (cNR != null) {
                    str3 = cNR.KFh.activityName;
                    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, stackTop, fromActivityName: %s", str3);
                } else {
                    str3 = null;
                }
            }
            eci.Mhd.activityName = str3;
            eci.Mhd.timestamp = currentTimeMillis;
            if (intent == null || (component = intent.getComponent()) == null) {
                str4 = null;
            } else {
                str4 = component.getClassName();
            }
            eci.Mhe = new eih();
            eci.Mhe.activityName = str4;
            eci.Mhe.aHK = 0;
            Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, dstActivityName: %s", str4);
            eci.Mhe.timestamp = currentTimeMillis;
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    eci.LPa = extras.getString("Chat_User");
                    int i2 = extras.getInt("minimize_secene", -1);
                    String string = extras.getString("KPublisherId", null);
                    eci.Mhf = String.valueOf(i2);
                    eci.Mhg = string;
                }
                eci.flags = intent.getFlags();
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str3)) {
                Fragment apm = h.apm(str3);
                if (apm != null) {
                    str3 = apm.getClass().getCanonicalName();
                }
                if (com.tencent.mm.plugin.expt.hellhound.core.b.aoT(str3)) {
                    gv = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gv(str3, str4);
                } else {
                    gv = "-1";
                }
            } else {
                if (com.tencent.mm.plugin.expt.hellhound.core.b.aoT(str3)) {
                    gv = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gv(str3, str4);
                }
                eci.timestamp = currentTimeMillis;
                String str5 = eci.Mhe.activityName;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEP = 4;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEQ = str5;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d(str5, intent);
                k.apP(str5);
                k.apN(str5);
                k.apS(str5);
                a.aov(str5);
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(100, eci);
                com.tencent.mm.plugin.expt.hellhound.a.b.a.a(eci.Mhe.activityName, -1, 0);
                AppMethodBeat.o(121921);
                return;
            }
            cPO.sIr = gv + "_" + currentTimeMillis;
            Log.i("HABBYGE-MALI.HellSessionMonitor", "setCurSessionIdLocal, sessionId: %s", cPO.sIr);
            eci.timestamp = currentTimeMillis;
            String str52 = eci.Mhe.activityName;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEP = 4;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEQ = str52;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d(str52, intent);
            k.apP(str52);
            k.apN(str52);
            k.apS(str52);
            a.aov(str52);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(100, eci);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.a(eci.Mhe.activityName, -1, 0);
            AppMethodBeat.o(121921);
            return;
        }
        if (activity != null) {
            str = activity.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivity: %s", str);
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.Z(activity);
        } else {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            bn cNR2 = e.cNR();
            if (cNR2 != null) {
                str = cNR2.KFh.activityName;
                Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivityName: %s", str);
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().apj(str);
            } else {
                str = null;
            }
        }
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(str, null, 100);
        ComponentName component2 = intent.getComponent();
        if (component2 != null) {
            str2 = component2.getClassName();
        } else {
            str2 = null;
        }
        Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, dstActivityName: %s", str2);
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(str2, null, 101);
        Bundle extras2 = intent.getExtras();
        if (extras2 != null) {
            String string2 = extras2.getString("Chat_User");
            if (!TextUtils.isEmpty(string2)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("Chat_User", string2);
            }
            int i3 = extras2.getInt("minimize_secene", -1);
            String string3 = extras2.getString("KPublisherId", null);
            if (i3 != 1 || string3 == null || !"jd_store".equals(string3)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("minimize_secene", "");
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("KPublisherId", "");
            } else {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("minimize_secene", String.valueOf(i3));
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("KPublisherId", string3);
            }
        }
        a(activity, intent, str, str2, 0);
        a.apd(str2);
        a.apf(str);
        a.GQ(0);
        AppMethodBeat.o(121921);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void b(Activity activity, boolean z) {
        AppMethodBeat.i(121922);
        if (this.szI) {
            cri cri = new cri();
            cri.LOX = new eih();
            cri.timestamp = System.currentTimeMillis();
            if (activity != null) {
                cri.LOX.activityName = activity.getClass().getCanonicalName();
                cri.LOX.aHK = activity.hashCode();
                cri.LOX.timestamp = cri.timestamp;
            }
            cri.Mhi = z;
            k.f(activity, cri.timestamp);
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sER = cri.LOX.activityName;
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(102, cri);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.e(activity, 2);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.a(activity.getClass().getCanonicalName(), Integer.valueOf(activity.hashCode()), 1);
            AppMethodBeat.o(121922);
            return;
        }
        com.tencent.mm.vending.j.c<String, Integer> W = W(activity);
        if (W != null) {
            String str = (String) W.get(0);
            ((Integer) W.get(1)).intValue();
            if (!TextUtils.isEmpty(str)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(str, null, 103);
                aX(str, false);
            }
        }
        AppMethodBeat.o(121922);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void P(Activity activity) {
        AppMethodBeat.i(121923);
        if (this.szI) {
            eih eih = new eih();
            if (activity != null) {
                eih.activityName = activity.getClass().getCanonicalName();
                eih.aHK = activity.hashCode();
                eih.timestamp = System.currentTimeMillis();
            }
            k.f(activity, eih.timestamp);
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sER = eih.activityName;
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(101, eih);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.e(activity, 2);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.a(activity.getClass().getCanonicalName(), Integer.valueOf(activity.hashCode()), 1);
            AppMethodBeat.o(121923);
            return;
        }
        com.tencent.mm.vending.j.c<String, Integer> W = W(activity);
        if (W != null) {
            String str = (String) W.get(0);
            ((Integer) W.get(1)).intValue();
            if (!TextUtils.isEmpty(str)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(str, null, 102);
                aX(str, true);
            }
        }
        AppMethodBeat.o(121923);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void d(Intent intent, Activity activity) {
        AppMethodBeat.i(121924);
        if (this.szI) {
            cuy g2 = c.g(intent, activity);
            k.cPn();
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(200, g2);
            AppMethodBeat.o(121924);
            return;
        }
        if (activity != null) {
            f(intent, activity);
        }
        AppMethodBeat.o(121924);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void e(Intent intent, Activity activity) {
        AppMethodBeat.i(121925);
        if (this.szI) {
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(201, c.g(intent, activity));
            AppMethodBeat.o(121925);
            return;
        }
        if (activity != null) {
            f(intent, activity);
        }
        AppMethodBeat.o(121925);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void Q(Activity activity) {
        AppMethodBeat.i(121926);
        if (this.szI) {
            com.tencent.mm.plugin.expt.hellhound.core.a.cNx().df(activity);
            if (activity != null && com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(activity.getClass().getSimpleName()) && f.af(activity)) {
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(TbsListener.ErrorCode.UNLZMA_FAIURE, "144");
            }
            k.a(activity, null, System.currentTimeMillis(), 5);
            eih eih = new eih();
            eih.activityName = activity.getClass().getCanonicalName();
            eih.aHK = activity.hashCode();
            eih.timestamp = System.currentTimeMillis();
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(202, eih);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b bVar = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(eih.activityName, activity);
            com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(0, eih.activityName, activity);
            com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cOp();
            k.apT(activity.getClass().getSimpleName());
            AppMethodBeat.o(121926);
            return;
        }
        String canonicalName = activity.getClass().getCanonicalName();
        int hashCode = activity.hashCode();
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(canonicalName, null, 105);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.apb(canonicalName);
        a(canonicalName, hashCode, com.tencent.mm.plugin.expt.hellhound.core.stack.a.RESUME);
        AppMethodBeat.o(121926);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void R(Activity activity) {
        AppMethodBeat.i(121927);
        if (this.szI) {
            long currentTimeMillis = System.currentTimeMillis();
            k.d(activity, currentTimeMillis);
            com.tencent.mm.plugin.expt.hellhound.core.a cNx = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
            if (activity != null) {
                cNx.syU.a(activity, currentTimeMillis);
            }
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(203, c.c(activity, currentTimeMillis));
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.e(activity, 0);
        }
        AppMethodBeat.o(121927);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void S(Activity activity) {
        AppMethodBeat.i(121928);
        if (activity == null) {
            AppMethodBeat.o(121928);
        } else if (this.szI) {
            eih eih = new eih();
            eih.aHK = activity.hashCode();
            eih.activityName = activity.getClass().getCanonicalName();
            eih.timestamp = System.currentTimeMillis();
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sES = eih.activityName;
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(204, eih);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b bVar = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(eih.activityName, activity);
            com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(1, eih.activityName, activity);
            com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cOq();
            k.apU(activity.getClass().getSimpleName());
            AppMethodBeat.o(121928);
        } else {
            String canonicalName = activity.getClass().getCanonicalName();
            int hashCode = activity.hashCode();
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(canonicalName, null, 106);
            a(canonicalName, hashCode, com.tencent.mm.plugin.expt.hellhound.core.stack.a.PAUSE);
            AppMethodBeat.o(121928);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void T(Activity activity) {
        AppMethodBeat.i(121929);
        if (this.szI) {
            long currentTimeMillis = System.currentTimeMillis();
            k.b(activity, null, currentTimeMillis, 7);
            k.e(activity, currentTimeMillis);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(205, c.c(activity, currentTimeMillis));
            com.tencent.mm.plugin.expt.hellhound.core.a cNx = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
            if (activity != null) {
                cNx.syU.b(activity, currentTimeMillis);
            }
        }
        AppMethodBeat.o(121929);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void U(Activity activity) {
        AppMethodBeat.i(121930);
        if (activity == null) {
            AppMethodBeat.o(121930);
        } else if (this.szI) {
            eih eih = new eih();
            eih.aHK = activity.hashCode();
            eih.activityName = activity.getClass().getCanonicalName();
            eih.timestamp = System.currentTimeMillis();
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(206, eih);
            AppMethodBeat.o(121930);
        } else {
            String canonicalName = activity.getClass().getCanonicalName();
            int hashCode = activity.hashCode();
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoG(canonicalName)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(canonicalName, null, 107);
                a(canonicalName, hashCode, com.tencent.mm.plugin.expt.hellhound.core.stack.a.STOP);
            }
            AppMethodBeat.o(121930);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.e
    public final void V(Activity activity) {
        AppMethodBeat.i(121931);
        if (activity == null) {
            AppMethodBeat.o(121931);
        } else if (this.szI) {
            eih eih = new eih();
            eih.activityName = activity.getClass().getCanonicalName();
            eih.aHK = activity.hashCode();
            eih.timestamp = System.currentTimeMillis();
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(207, eih);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b bVar = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b.e(eih.activityName, activity);
            com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(2, eih.activityName, activity);
            k.apR(eih.activityName);
            AppMethodBeat.o(121931);
        } else {
            String canonicalName = activity.getClass().getCanonicalName();
            int hashCode = activity.hashCode();
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(canonicalName, null, 108);
            a(canonicalName, hashCode, com.tencent.mm.plugin.expt.hellhound.core.stack.a.DESTROY);
            AppMethodBeat.o(121931);
        }
    }

    @Deprecated
    private static void aX(String str, boolean z) {
        AppMethodBeat.i(121932);
        a.GQ(1);
        if (z || !com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str)) {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            bn cNR = e.cNR();
            String str2 = null;
            if (cNR != null) {
                str2 = cNR.KFh.activityName;
            }
            a.apg(str);
            a.ape(str2);
            Log.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", str, str2);
            AppMethodBeat.o(121932);
            return;
        }
        Log.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
        AppMethodBeat.o(121932);
    }

    @Deprecated
    private static void f(Intent intent, Activity activity) {
        AppMethodBeat.i(121933);
        String canonicalName = activity.getClass().getCanonicalName();
        int hashCode = activity.hashCode();
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(canonicalName, null, 104);
        a(null, intent, null, canonicalName, hashCode);
        a(canonicalName, hashCode, com.tencent.mm.plugin.expt.hellhound.core.stack.a.CREATE);
        AppMethodBeat.o(121933);
    }

    @Deprecated
    private static void a(Activity activity, Intent intent, String str, String str2, int i2) {
        AppMethodBeat.i(220425);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM().a(activity, intent, str, str2, i2);
        AppMethodBeat.o(220425);
    }

    @Deprecated
    private static void a(String str, int i2, com.tencent.mm.plugin.expt.hellhound.core.stack.a aVar) {
        AppMethodBeat.i(220426);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(str, i2, aVar);
        AppMethodBeat.o(220426);
    }

    @Deprecated
    private static com.tencent.mm.vending.j.c<String, Integer> W(Activity activity) {
        AppMethodBeat.i(121936);
        if (activity == null) {
            try {
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                com.tencent.mm.vending.j.c<String, Integer> cNN = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNN();
                Log.d("HABBYGE-MALI.ActivityMonitor", "getActivityOnFinish: %s, %s", cNN.get(0), cNN.get(1));
                AppMethodBeat.o(121936);
                return cNN;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.ActivityMonitor", e2, "getActivityOnFinish", new Object[0]);
                AppMethodBeat.o(121936);
                return null;
            }
        } else {
            com.tencent.mm.vending.j.c<String, Integer> Q = com.tencent.mm.vending.j.a.Q(activity.getClass().getCanonicalName(), Integer.valueOf(activity.hashCode()));
            AppMethodBeat.o(121936);
            return Q;
        }
    }
}
