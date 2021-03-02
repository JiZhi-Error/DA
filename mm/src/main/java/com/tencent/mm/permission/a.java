package com.tencent.mm.permission;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class a {
    static Map<Integer, C0504a> jJJ;
    IListener jJK = new IListener<pk>() {
        /* class com.tencent.mm.permission.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161282);
            this.__eventId = pk.class.getName().hashCode();
            AppMethodBeat.o(161282);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pk pkVar) {
            AppMethodBeat.i(20682);
            pk pkVar2 = pkVar;
            if (true == pkVar2.dVx.dVz) {
                if (!a.uF(pkVar2.dVx.type)) {
                    if (com.tencent.mm.compatible.e.a.gKU == null) {
                        ArrayList<a.b> arrayList = new ArrayList();
                        com.tencent.mm.compatible.e.a.a(b.aKB() + "permissioncfg.cfg", arrayList, new ArrayList());
                        PInt pInt = new PInt(0);
                        PBool pBool = new PBool();
                        for (a.b bVar : arrayList) {
                            pInt.value = 0;
                            pBool.value = true;
                            if (com.tencent.mm.compatible.e.a.a(Build.MANUFACTURER, bVar.gKZ, pInt, pBool) && com.tencent.mm.compatible.e.a.a(Build.MODEL, bVar.model, pInt, pBool)) {
                                com.tencent.mm.compatible.e.a.a(Build.VERSION.RELEASE, bVar.version, pInt, pBool);
                            }
                            if (pBool.value && pInt.value > 0) {
                                com.tencent.mm.compatible.e.a.gKU = Boolean.valueOf(1 == bVar.gKX);
                            }
                        }
                        if ((com.tencent.mm.compatible.e.a.gKU == null || true != com.tencent.mm.compatible.e.a.gKU.booleanValue()) && com.tencent.mm.compatible.e.a.gKU == null) {
                            com.tencent.mm.compatible.e.a.gKU = Boolean.FALSE;
                        }
                    }
                    if (com.tencent.mm.compatible.e.a.gKU.booleanValue()) {
                        pkVar2.dVy.dVB = a.H(pkVar2.dVx.type, true);
                    }
                }
                pkVar2.dVy.dVB = false;
            } else {
                pkVar2.dVy.dVB = false;
            }
            AppMethodBeat.o(20682);
            return false;
        }
    };
    private IListener jJL = new IListener<pl>() {
        /* class com.tencent.mm.permission.a.AnonymousClass2 */

        {
            AppMethodBeat.i(161283);
            this.__eventId = pl.class.getName().hashCode();
            AppMethodBeat.o(161283);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pl plVar) {
            AppMethodBeat.i(20683);
            pl plVar2 = plVar;
            plVar2.dVD.dVB = a.H(plVar2.dVC.type, false);
            AppMethodBeat.o(20683);
            return false;
        }
    };
    private IListener jJM = new IListener<mm>() {
        /* class com.tencent.mm.permission.a.AnonymousClass3 */

        {
            AppMethodBeat.i(161284);
            this.__eventId = mm.class.getName().hashCode();
            AppMethodBeat.o(161284);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mm mmVar) {
            AppMethodBeat.i(20684);
            Log.i("MicroMsg.PermissionMgr", "show mute dlg");
            PermissionWarningDialog.dp(MMApplicationContext.getContext());
            AppMethodBeat.o(20684);
            return false;
        }
    };

    static {
        AppMethodBeat.i(20689);
        HashMap hashMap = new HashMap();
        jJJ = hashMap;
        hashMap.put(1, new C0504a(38, 40, 41, R.string.xo, R.string.xg));
        jJJ.put(2, new C0504a(43, 44, 45, R.string.xn, R.string.xh));
        AppMethodBeat.o(20689);
    }

    public a() {
        AppMethodBeat.i(20685);
        EventCenter.instance.addListener(this.jJK);
        EventCenter.instance.addListener(this.jJL);
        EventCenter.instance.addListener(this.jJM);
        AppMethodBeat.o(20685);
    }

    private static int Se(String str) {
        int i2 = 0;
        AppMethodBeat.i(20686);
        try {
            i2 = Util.getInt(h.aqJ().getValue(str), 0);
        } catch (Exception e2) {
            Log.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(20686);
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.permission.a$a  reason: collision with other inner class name */
    public static class C0504a {
        public int jJO;
        public int jJP;
        public int jJQ;
        public int jJR;
        public int jJS;

        public C0504a(int i2, int i3, int i4, int i5, int i6) {
            this.jJO = i2;
            this.jJP = i3;
            this.jJQ = i4;
            this.jJR = i5;
            this.jJS = i6;
        }
    }

    static /* synthetic */ boolean uF(int i2) {
        AppMethodBeat.i(20687);
        int ake = bg.aVD().ake(jJJ.get(Integer.valueOf(i2)).jJO);
        Log.i("MicroMsg.PermissionMgr", "current mark status: ".concat(String.valueOf(ake)));
        if (ake == 0) {
            AppMethodBeat.o(20687);
            return true;
        }
        AppMethodBeat.o(20687);
        return false;
    }

    static /* synthetic */ boolean H(int i2, boolean z) {
        int i3;
        boolean z2;
        AppMethodBeat.i(20688);
        f.a aVar = new f.a();
        int i4 = 1;
        int i5 = 1;
        if (bg.aAc()) {
            i4 = Se("ShowPermissionDialog");
            i5 = Se("OnlyScanRunningService");
            i3 = Se("Interval4ShowPmsDialog");
        } else {
            i3 = 3600000;
        }
        Log.i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3));
        long j2 = 0;
        for (C0504a aVar2 : jJJ.values()) {
            long j3 = bg.aVD().getLong(aVar2.jJP, 0);
            if (j2 < j3) {
                j2 = j3;
            }
        }
        boolean z3 = 1 == i4 && System.currentTimeMillis() - j2 >= ((long) i3);
        if (z3) {
            bg.aVD().setLong(jJJ.get(Integer.valueOf(i2)).jJP, System.currentTimeMillis());
            Log.i("MicroMsg.PermissionMgr", "tryDirectlyShowDefaultPermissionDialog, chkType: %s, filter: %s, dueToException: %s", Integer.valueOf(i2), Integer.valueOf(i5), Boolean.valueOf(z));
            if (1 == i2) {
                bg.aVD().setLong(42, System.currentTimeMillis());
                Context context = MMApplicationContext.getContext();
                if (1 == i5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                PermissionWarningDialog.b(context, z2, z);
            }
        }
        Log.i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + aVar.apr() + ", needShowDlg: " + z3);
        AppMethodBeat.o(20688);
        return false;
    }
}
