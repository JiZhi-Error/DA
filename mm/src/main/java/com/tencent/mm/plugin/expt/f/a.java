package com.tencent.mm.plugin.expt.f;

import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.g.b.a.np;
import com.tencent.mm.g.b.a.nq;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.i.d;
import com.tencent.mm.plugin.expt.ui.ExptAppDebugUI;
import com.tencent.mm.plugin.expt.ui.ExptDebugUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class a implements c, b {
    private static a sJW;
    private int gTn = 0;
    private int iKV = 0;
    public d sJX;
    public com.tencent.mm.plugin.expt.i.b sJY;
    private final f<Integer, com.tencent.mm.plugin.expt.h.c> sJZ = new com.tencent.mm.memory.a.c(100);
    private final f<String, Integer> sKa = new com.tencent.mm.memory.a.c(100);
    private final IListener<ps> sKb = new IListener<ps>() {
        /* class com.tencent.mm.plugin.expt.f.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161608);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(161608);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            AppMethodBeat.i(122317);
            a.a(a.this);
            a.b(a.this);
            a.c(a.this);
            com.tencent.mm.plugin.expt.hellhound.b.a.cRb();
            AppMethodBeat.o(122317);
            return false;
        }
    };
    private final p sKc = new p() {
        /* class com.tencent.mm.plugin.expt.f.a.AnonymousClass2 */

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00ad  */
        @Override // com.tencent.mm.plugin.messenger.foundation.a.p
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.ak.h.b a(java.lang.String r12, java.util.Map<java.lang.String, java.lang.String> r13, com.tencent.mm.ak.h.a r14) {
            /*
            // Method dump skipped, instructions count: 187
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.f.a.AnonymousClass2.a(java.lang.String, java.util.Map, com.tencent.mm.ak.h$a):com.tencent.mm.ak.h$b");
        }
    };
    private final i sKd = new i() {
        /* class com.tencent.mm.plugin.expt.f.a.AnonymousClass3 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(122319);
            Log.i("MicroMsg.ExptService", "scene[%d] errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(qVar.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (qVar instanceof b) {
                a.d(a.this);
            }
            AppMethodBeat.o(122319);
        }
    };
    private final IListener<mi> sKe = new IListener<mi>() {
        /* class com.tencent.mm.plugin.expt.f.a.AnonymousClass4 */

        {
            AppMethodBeat.i(161609);
            this.__eventId = mi.class.getName().hashCode();
            AppMethodBeat.o(161609);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mi miVar) {
            AppMethodBeat.i(122321);
            h.RTc.a(new Runnable() {
                /* class com.tencent.mm.plugin.expt.f.a.AnonymousClass4.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(122320);
                    a.Hw(2);
                    com.tencent.mm.plugin.expt.hellhound.b.a.cRc();
                    AppMethodBeat.o(122320);
                }
            }, Util.MILLSECONDS_OF_MINUTE, "manual_get_expt");
            a.this.Hx(2);
            AppMethodBeat.o(122321);
            return false;
        }
    };

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(220636);
        aVar.cRi();
        AppMethodBeat.o(220636);
    }

    private void cRi() {
        this.gTn = 0;
        this.iKV = 0;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void cRj() {
        AppMethodBeat.i(122322);
        this.sJZ.clear();
        this.sKa.clear();
        AppMethodBeat.o(122322);
    }

    public static a cRk() {
        AppMethodBeat.i(122323);
        if (sJW == null) {
            sJW = new a();
        }
        a aVar = sJW;
        AppMethodBeat.o(122323);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(122324);
        AppMethodBeat.o(122324);
    }

    @Override // com.tencent.mm.plugin.expt.b.b
    public final void s(Context context, Intent intent) {
        AppMethodBeat.i(122325);
        intent.setClass(context, ExptDebugUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/expt/model/ExptService", "showExptUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/expt/model/ExptService", "showExptUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(122325);
    }

    @Override // com.tencent.mm.plugin.expt.b.b
    public final void t(Context context, Intent intent) {
        AppMethodBeat.i(220622);
        intent.setClass(context, ExptAppDebugUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/expt/model/ExptService", "showExptAppUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/expt/model/ExptService", "showExptAppUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(220622);
    }

    @Override // com.tencent.mm.plugin.expt.b.b
    public final boolean a(b.a aVar, boolean z) {
        int i2;
        AppMethodBeat.i(122326);
        String b2 = b(aVar, "");
        if (Util.isNullOrNil(b2)) {
            AppMethodBeat.o(122326);
            return z;
        }
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (Util.getInt(b2, i2) != 0) {
            AppMethodBeat.o(122326);
            return true;
        }
        AppMethodBeat.o(122326);
        return false;
    }

    @Override // com.tencent.mm.plugin.expt.b.b
    public final float a(b.a aVar, float f2) {
        AppMethodBeat.i(122327);
        String b2 = b(aVar, "");
        if (Util.isNullOrNil(b2)) {
            AppMethodBeat.o(122327);
            return f2;
        }
        float f3 = Util.getFloat(b2, f2);
        AppMethodBeat.o(122327);
        return f3;
    }

    @Override // com.tencent.mm.plugin.expt.b.b
    public final int a(b.a aVar, int i2) {
        AppMethodBeat.i(122328);
        String b2 = b(aVar, "");
        if (Util.isNullOrNil(b2)) {
            AppMethodBeat.o(122328);
            return i2;
        }
        int i3 = Util.getInt(b2, i2);
        AppMethodBeat.o(122328);
        return i3;
    }

    @Override // com.tencent.mm.plugin.expt.b.b
    public final long a(b.a aVar, long j2) {
        AppMethodBeat.i(122329);
        String b2 = b(aVar, "");
        if (Util.isNullOrNil(b2)) {
            AppMethodBeat.o(122329);
            return j2;
        }
        long j3 = Util.getLong(b2, j2);
        AppMethodBeat.o(122329);
        return j3;
    }

    @Override // com.tencent.mm.plugin.expt.b.b
    public final String a(b.a aVar, String str) {
        AppMethodBeat.i(122330);
        String b2 = b(aVar, str);
        AppMethodBeat.o(122330);
        return b2;
    }

    private String b(b.a aVar, String str) {
        AppMethodBeat.i(220623);
        if (aVar == null) {
            AppMethodBeat.o(220623);
            return str;
        }
        PString pString = new PString();
        int a2 = com.tencent.mm.plugin.expt.h.b.cRI().a(aVar.name(), str, pString);
        if (a2 > 0) {
            com.tencent.mm.plugin.expt.a.a.cMx();
            com.tencent.mm.plugin.expt.a.a.GK(a2);
            String str2 = pString.value;
            AppMethodBeat.o(220623);
            return str2;
        } else if (cRn()) {
            com.tencent.mm.plugin.expt.i.c.cSa();
            String c2 = com.tencent.mm.plugin.expt.i.c.c(aVar, str);
            Log.i("MicroMsg.ExptService", "API check Expt from mmkv result[%s] key[%s] def[%s]", c2, aVar, str);
            AppMethodBeat.o(220623);
            return c2;
        } else {
            long currentTicks = Util.currentTicks();
            String name = aVar.name();
            int arf = arf(name);
            nq nqVar = new nq();
            PBool pBool = new PBool();
            HashMap<String, String> a3 = a(arf, true, nqVar, pBool);
            if (a3 == null || a3.size() <= 0) {
                AppMethodBeat.o(220623);
                return str;
            }
            String str3 = a3.get(name);
            if (!Util.isNullOrNil(str3) && pBool.value) {
                nqVar.AO(name).AP(str3).eOq();
            }
            Log.i("MicroMsg.ExptService", "API Got Expt result[%s] exptId[%d] key[%s %s] defStr[%s] cost[%d]", str3, Integer.valueOf(arf), aVar, name, str, Long.valueOf(Util.ticksToNow(currentTicks)));
            if (!Util.isNullOrNil(str3)) {
                AppMethodBeat.o(220623);
                return str3;
            }
            AppMethodBeat.o(220623);
            return str;
        }
    }

    public final com.tencent.mm.plugin.expt.h.c Hv(int i2) {
        AppMethodBeat.i(122331);
        com.tencent.mm.plugin.expt.h.c cVar = this.sJZ.get(Integer.valueOf(i2));
        if (cVar != null) {
            AppMethodBeat.o(122331);
        } else {
            cVar = this.sJX.HD(i2);
            if (cVar != null) {
                this.sJZ.put(Integer.valueOf(i2), cVar);
            }
            AppMethodBeat.o(122331);
        }
        return cVar;
    }

    private int arf(String str) {
        AppMethodBeat.i(122332);
        Integer num = this.sKa.get(str);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(122332);
            return intValue;
        }
        int arf = this.sJY.arf(str);
        if (arf > 0) {
            this.sKa.put(str, Integer.valueOf(arf));
        }
        AppMethodBeat.o(122332);
        return arf;
    }

    public final HashMap<String, String> a(int i2, boolean z, nq nqVar, PBool pBool) {
        AppMethodBeat.i(122333);
        if (this.sJX == null) {
            Log.e("MicroMsg.ExptService", "Expt service is not init here! exptId[%d]", Integer.valueOf(i2));
            AppMethodBeat.o(122333);
            return null;
        } else if (i2 <= 0) {
            AppMethodBeat.o(122333);
            return null;
        } else {
            long currentTicks = Util.currentTicks();
            HashMap<String, String> hashMap = null;
            String str = null;
            com.tencent.mm.plugin.expt.h.c Hv = Hv(i2);
            if (Hv == null || Util.isNullOrNil(Hv.field_exptContent)) {
                Log.w("MicroMsg.ExptService", "expt item is null or expt content is null.");
            } else {
                str = Hv.field_exptContent;
                if (!z || Hv.isReady()) {
                    hashMap = Hv.cRH();
                    if (Hv.cRU()) {
                        pBool.value = true;
                        if (nqVar != null) {
                            nqVar.fid = (long) Hv.field_exptId;
                            nqVar.fie = (long) Hv.field_groupId;
                            nqVar.fif = (long) Hv.field_exptSeq;
                            nqVar.eLZ = Hv.field_startTime;
                            nqVar.fig = Hv.field_endTime;
                        }
                    }
                } else {
                    Log.w("MicroMsg.ExptService", "expt time is invalid time[%d %d] seq[%d]", Long.valueOf(Hv.field_startTime), Long.valueOf(Hv.field_endTime), Integer.valueOf(Hv.field_exptSeq));
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = hashMap != null ? hashMap : 0;
            objArr[2] = str;
            objArr[3] = Long.valueOf(Util.ticksToNow(currentTicks));
            Log.i("MicroMsg.ExptService", "get expt [%d] map[%s] expt[%s] cost[%d]", objArr);
            AppMethodBeat.o(122333);
            return hashMap;
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(122334);
        Log.i("MicroMsg.ExptService", "onAccountInitialized, %d", Integer.valueOf(hashCode()));
        Log.v("MicroMsg.ExptService", "add listener ");
        if (MMApplicationContext.isMMProcess()) {
            EventCenter.instance.add(this.sKb);
            EventCenter.instance.add(this.sKe);
            g.azz().a(2738, this.sKd);
            g.azz().a(1021, com.tencent.mm.plugin.expt.hellhound.b.a.sJF);
            ((s) g.ah(s.class)).getSysCmdMsgExtension().a("expt", this.sKc);
        }
        if (cVar != null) {
            try {
                if (cVar.hrc) {
                    Log.i("MicroMsg.ExptService", "client upgrade now, reset last update time. previous version [%d]", Integer.valueOf(cVar.hrd));
                    this.iKV = 0;
                    g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, (Object) 0);
                    com.tencent.mm.plugin.expt.hellhound.b.a.cRa();
                    Hx(3);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ExptService", e2, "onAccountInitialized error[%s]", e2.toString());
                AppMethodBeat.o(122334);
                return;
            }
        }
        AppMethodBeat.o(122334);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(122335);
        Log.i("MicroMsg.ExptService", "onAccountRelease");
        cRj();
        EventCenter.instance.removeListener(this.sKb);
        EventCenter.instance.removeListener(this.sKe);
        g.azz().b(2738, this.sKd);
        g.azz().b(1021, com.tencent.mm.plugin.expt.hellhound.b.a.sJF);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("expt", this.sKc);
        h.RTc.bqo("manual_get_expt");
        AppMethodBeat.o(122335);
    }

    public final void arg(String str) {
        int i2;
        AppMethodBeat.i(122336);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ExptService", "receive expt xml but content is null");
            AppMethodBeat.o(122336);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        com.tencent.mm.plugin.expt.h.c cVar = new com.tencent.mm.plugin.expt.h.c();
        if (cVar.TN(str)) {
            if (cVar.field_exptId == 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(863, 9, 1, false);
                try {
                    int optInt = new JSONObject(str).optInt("TryGetTime");
                    if (optInt <= 0) {
                        i2 = 1;
                    } else {
                        i2 = optInt;
                    }
                    g.aAf();
                    com.tencent.mm.b.p pVar = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin());
                    int abs = (int) Math.abs(pVar.longValue() % ((long) i2));
                    int nowSecond = (((int) Util.nowSecond()) + (abs * 60)) - LocalCache.TIME_DAY;
                    int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, (Object) 0)).intValue();
                    int min = Math.min(intValue, nowSecond);
                    g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(min));
                    cRi();
                    Log.i("MicroMsg.ExptService", "reset get expt time tryGetTime[%d] uin[%d] hashTime[%d] needUpdateTime[%d] lastTime[%d] fixLastUpdateTime[%d]", Integer.valueOf(i2), Long.valueOf(pVar.longValue()), Integer.valueOf(abs), Integer.valueOf(nowSecond), Integer.valueOf(intValue), Integer.valueOf(min));
                    AppMethodBeat.o(122336);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ExptService", e2, "on get xml msg reset get expt time error [%s]", e2.toString());
                    AppMethodBeat.o(122336);
                    return;
                }
            } else {
                if (cVar.field_exptSeq < 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(863, 3, 1, false);
                    com.tencent.mm.plugin.expt.h.c Hv = Hv(cVar.field_exptId);
                    if (Hv != null && Hv.cRM()) {
                        linkedList.add(Integer.valueOf(cVar.field_exptId));
                    }
                    if (Hv != null && Hv.cRN()) {
                        f("", false, true);
                    }
                    if (Hv != null && Hv.cRO()) {
                        aY("", true);
                    }
                    if (Hv != null && Hv.cRP()) {
                        b(cVar.cRW(), "", true, false);
                    }
                    cRk();
                    a(Hv, true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(cVar.field_exptId));
                    z = dv(arrayList) > 0;
                    com.tencent.mm.plugin.report.e.INSTANCE.a(17582, Integer.valueOf(cVar.field_exptId));
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(863, 4, 1, false);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(cVar);
                    z = du(arrayList2) > 0;
                    if (cVar.cRM()) {
                        linkedList2.add(cVar);
                    }
                    if (cVar.cRN()) {
                        f(cVar.cRX(), cVar.cRV(), false);
                    }
                    if (cVar.cRO()) {
                        aY(cVar.cRX(), false);
                    }
                    if (cVar.cRP()) {
                        b(cVar.cRW(), cVar.cRX(), false, cVar.cRV());
                    }
                    cRk();
                    a(cVar, false);
                    np npVar = new np();
                    npVar.fid = (long) cVar.field_exptId;
                    npVar.fie = (long) cVar.field_groupId;
                    npVar.fif = (long) cVar.field_exptSeq;
                    npVar.bfK();
                }
                cRl();
            }
        }
        if (linkedList2.size() > 0 || linkedList.size() > 0) {
            a(linkedList2, null, linkedList);
        }
        Log.i("MicroMsg.ExptService", "received expt xml dbFlag[%b] [%s] ", Boolean.valueOf(z), str);
        AppMethodBeat.o(122336);
    }

    protected static void cRl() {
        AppMethodBeat.i(122337);
        EventCenter.instance.publish(new fp());
        AppMethodBeat.o(122337);
    }

    public final ArrayList<Integer> cRm() {
        AppMethodBeat.i(220624);
        if (this.sJX != null) {
            ArrayList<Integer> cSd = this.sJX.cSd();
            AppMethodBeat.o(220624);
            return cSd;
        }
        AppMethodBeat.o(220624);
        return null;
    }

    public final int du(List<com.tencent.mm.plugin.expt.h.c> list) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(122341);
        if (list.size() <= 0) {
            AppMethodBeat.o(122341);
            return 0;
        }
        List<com.tencent.mm.plugin.expt.h.c> dB = this.sJX.dB(list);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (dB != null) {
            int size = dB.size();
            for (com.tencent.mm.plugin.expt.h.c cVar : dB) {
                this.sJZ.put(Integer.valueOf(cVar.field_exptId), cVar);
                HashMap<String, String> cRH = cVar.cRH();
                if (cRH != null) {
                    for (String str : cRH.keySet()) {
                        com.tencent.mm.plugin.expt.i.a ark = this.sJY.ark(str);
                        if (ark == null) {
                            ark = new com.tencent.mm.plugin.expt.i.a();
                            ark.field_exptId = cVar.field_exptId;
                            ark.field_exptKey = str;
                            linkedList2.add(ark);
                        } else if (ark.field_exptId != cVar.field_exptId) {
                            ark.field_exptId = cVar.field_exptId;
                            linkedList.add(ark);
                        }
                        Log.i("MicroMsg.ExptService", "exptKey:" + ark.field_exptKey);
                        this.sKa.put(ark.field_exptKey, Integer.valueOf(ark.field_exptId));
                        ck ckVar = new ck();
                        ckVar.dFF.dFG = ark.field_exptKey;
                        EventCenter.instance.publish(ckVar);
                    }
                }
            }
            i3 = this.sJY.dw(linkedList2);
            i2 = this.sJY.dx(linkedList);
            if (!com.tencent.mm.plugin.expt.i.c.cSa().dz(dB)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.e.d.CTRL_INDEX, 14);
            }
            i4 = size;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        Log.i("MicroMsg.ExptService", "replace ExptIds args[%d] db[%d] exptMap insert[list:%d  db:%d], update[list:%d db:%d]", Integer.valueOf(list.size()), Integer.valueOf(i4), Integer.valueOf(linkedList2.size()), Integer.valueOf(i3), Integer.valueOf(linkedList.size()), Integer.valueOf(i2));
        AppMethodBeat.o(122341);
        return i4;
    }

    private boolean cRn() {
        if (this.sJX == null || this.sJY == null) {
            return true;
        }
        return false;
    }

    public static void Hw(int i2) {
        AppMethodBeat.i(122343);
        g.azz().a(new b(i2), 0);
        AppMethodBeat.o(122343);
    }

    public static void a(List<com.tencent.mm.plugin.expt.h.c> list, List<ey> list2, List<Integer> list3) {
        AppMethodBeat.i(122344);
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (com.tencent.mm.plugin.expt.h.c cVar : list) {
                if (cVar != null && cVar.cRM()) {
                    com.tencent.mm.plugin.welab.b.c cVar2 = new com.tencent.mm.plugin.welab.b.c();
                    cVar2.sLf = cVar.field_exptId;
                    cVar2.adT = cVar.field_groupId;
                    cVar2.startTime = cVar.field_startTime;
                    cVar2.endTime = cVar.field_endTime;
                    cVar2.sLh = cVar.field_exptContent;
                    cVar2.sLg = cVar.field_exptSeq;
                    cVar2.map = cVar.cRH();
                    linkedList.add(cVar2);
                }
            }
        }
        LinkedList linkedList2 = new LinkedList();
        if (list2 != null) {
            for (ey eyVar : list2) {
                com.tencent.mm.plugin.welab.b.d dVar = new com.tencent.mm.plugin.welab.b.d();
                dVar.appId = eyVar.dNI;
                dVar.status = eyVar.status;
                linkedList2.add(dVar);
            }
        }
        ((com.tencent.mm.plugin.welab.b.a) g.af(com.tencent.mm.plugin.welab.b.a.class)).g(linkedList, linkedList2, list3);
        AppMethodBeat.o(122344);
    }

    public static void a(com.tencent.mm.plugin.expt.h.c cVar, boolean z) {
        AppMethodBeat.i(220625);
        if (cVar == null) {
            AppMethodBeat.o(220625);
        } else if (!cVar.cRT()) {
            AppMethodBeat.o(220625);
        } else {
            if (cVar != null && cVar.cRQ()) {
                cRk();
                d((long) cVar.field_exptId, cVar.cRX(), z);
            }
            if (cVar != null && cVar.cRR()) {
                cRk();
                e((long) cVar.field_exptId, cVar.cRX(), z);
            }
            if (cVar != null && cVar.cRS()) {
                cRk();
                f((long) cVar.field_exptId, cVar.cRX(), z);
            }
            AppMethodBeat.o(220625);
        }
    }

    public static void f(String str, boolean z, boolean z2) {
        AppMethodBeat.i(122345);
        Log.i("MicroMsg.ExptService", "notiy session config json[%b] needReport[%b] isDel[%b]", Boolean.valueOf(Util.isNullOrNil(str)), Boolean.valueOf(z), Boolean.valueOf(z2));
        ud udVar = new ud();
        udVar.eax.dNA = str;
        ud.a aVar = udVar.eax;
        if (!z2) {
            z2 = Util.isNullOrNil(str);
        }
        aVar.eaz = Boolean.valueOf(z2);
        udVar.eax.eay = Boolean.valueOf(z);
        EventCenter.instance.publish(udVar);
        AppMethodBeat.o(122345);
    }

    public static void aY(String str, boolean z) {
        AppMethodBeat.i(122346);
        Log.i("MicroMsg.ExptService", "notiy session uba config json[%b] isDel[%b]", Boolean.valueOf(Util.isNullOrNil(str)), Boolean.valueOf(z));
        uh uhVar = new uh();
        uhVar.eaG.dNA = str;
        uhVar.eaG.eaz = Boolean.valueOf(z);
        EventCenter.instance.publish(uhVar);
        AppMethodBeat.o(122346);
    }

    public static void b(long j2, String str, boolean z, boolean z2) {
        AppMethodBeat.i(122347);
        Log.i("MicroMsg.ExptService", "notiy session page config sessionPageId [%d] json[%s] needReport[%b] isDel[%b]", Long.valueOf(j2), str, Boolean.valueOf(z2), Boolean.valueOf(z));
        ug ugVar = new ug();
        ugVar.eaD.eaB = j2;
        ugVar.eaD.dNA = str;
        ugVar.eaD.eaz = Boolean.valueOf(z);
        ugVar.eaD.eaF = Boolean.valueOf(z2);
        ugVar.eaD.eaE = new ArrayList();
        ugVar.eaD.version = 1;
        EventCenter.instance.publish(ugVar);
        AppMethodBeat.o(122347);
    }

    private static void d(long j2, String str, boolean z) {
        AppMethodBeat.i(220626);
        Log.i("MicroMsg.ExptService", "notiy session view black list config sessionPageId [%d] json[%s] isDel[%b]", Long.valueOf(j2), str, Boolean.valueOf(z));
        ui uiVar = new ui();
        uiVar.eaH.eaz = Boolean.valueOf(z);
        uiVar.eaH.dNA = str;
        uiVar.eaH.eaB = j2;
        EventCenter.instance.publish(uiVar);
        AppMethodBeat.o(220626);
    }

    private static void e(long j2, String str, boolean z) {
        AppMethodBeat.i(220627);
        Log.i("MicroMsg.ExptService", "notiy session edge script config sessionPageId [%d] json[%s] isDel[%b]", Long.valueOf(j2), str, Boolean.valueOf(z));
        ue ueVar = new ue();
        ueVar.eaA.eaz = Boolean.valueOf(z);
        ueVar.eaA.dNA = str;
        ueVar.eaA.eaB = j2;
        EventCenter.instance.publish(ueVar);
        AppMethodBeat.o(220627);
    }

    private static void f(long j2, String str, boolean z) {
        AppMethodBeat.i(220628);
        Log.i("MicroMsg.ExptService", "notiy session edge sql config sessionPageId [%d] json[%s] isDel[%b]", Long.valueOf(j2), str, Boolean.valueOf(z));
        uf ufVar = new uf();
        ufVar.eaC.eaz = Boolean.valueOf(z);
        ufVar.eaC.dNA = str;
        ufVar.eaC.eaB = j2;
        EventCenter.instance.publish(ufVar);
        AppMethodBeat.o(220628);
    }

    public static void fO(int i2, int i3) {
        AppMethodBeat.i(220629);
        if (i2 <= 0) {
            AppMethodBeat.o(220629);
        } else if (i3 <= 0) {
            AppMethodBeat.o(220629);
        } else if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_APP_INTERVAL_SEC_INT, Integer.valueOf((int) LocalCache.TIME_DAY))).intValue() == i2) {
            AppMethodBeat.o(220629);
        } else {
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_APP_LAST_TIME_SEC_INT, (Object) 0)).intValue();
            int nowSecond = (int) Util.nowSecond();
            if (nowSecond - intValue >= i2) {
                g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_LAST_TIME_SEC_INT, Integer.valueOf(Math.min(intValue, (nowSecond + i3) - i2)));
            }
            g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_INTERVAL_SEC_INT, Integer.valueOf(i2));
            AppMethodBeat.o(220629);
        }
    }

    public static void mq(boolean z) {
        AppMethodBeat.i(220630);
        g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_NEED_ALL_INT, Integer.valueOf(z ? 1 : 0));
        AppMethodBeat.o(220630);
    }

    public final void Hx(int i2) {
        AppMethodBeat.i(220631);
        if (!a(b.a.clicfg_new_expt_app, true)) {
            AppMethodBeat.o(220631);
            return;
        }
        g.azz().a(new c(i2), 0);
        AppMethodBeat.o(220631);
    }

    public static void b(int i2, List<Integer> list, List<com.tencent.mm.plugin.expt.h.a> list2) {
        int i3;
        int i4;
        HashMap<String, String> cRH;
        AppMethodBeat.i(220632);
        long currentTicks = Util.currentTicks();
        if (i2 == 1) {
            com.tencent.mm.plugin.expt.h.b.cRI().removeAll();
        }
        com.tencent.mm.plugin.expt.h.b cRI = com.tencent.mm.plugin.expt.h.b.cRI();
        if (list == null || list.size() <= 0) {
            i3 = 0;
        } else {
            int i5 = 0;
            MultiProcessMMKV cRJ = cRI.cRJ();
            if (cRJ == null) {
                i3 = 0;
            } else {
                for (Integer num : list) {
                    int intValue = num.intValue();
                    if (cRJ.contains(String.valueOf(intValue))) {
                        cRJ.remove(String.valueOf(intValue));
                        i5++;
                    } else {
                        i5 = i5;
                    }
                }
                i3 = i5;
            }
        }
        com.tencent.mm.plugin.expt.h.b cRI2 = com.tencent.mm.plugin.expt.h.b.cRI();
        if (list2 != null && list2.size() > 0) {
            MultiProcessMMKV cRJ2 = cRI2.cRJ();
            MultiProcessMMKV cRK = cRI2.cRK();
            if (cRJ2 == null || cRK == null) {
                i4 = 0;
            } else {
                int i6 = 0;
                Iterator<com.tencent.mm.plugin.expt.h.a> it = list2.iterator();
                while (true) {
                    i4 = i6;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mm.plugin.expt.h.a next = it.next();
                    if (next != null && !Util.isNullOrNil(next.sLh) && (cRH = next.cRH()) != null && cRH.size() > 0) {
                        for (String str : cRH.keySet()) {
                            cRK.putInt(str, next.sLf);
                        }
                        cRJ2.putString(new StringBuilder().append(next.sLf).toString(), next.sLh);
                        i4++;
                    }
                    i6 = i4;
                }
            }
        } else {
            i4 = 0;
        }
        Log.i("MicroMsg.ExptService", "update Expt app flag = %d, delCount = %d, replaceCount = %d cost = %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(Util.ticksToNow(currentTicks)));
        at atVar = new at();
        if (list != null && list.size() > 0) {
            for (Integer num2 : list) {
                atVar.eqq = num2.intValue();
                atVar.eqr = 0;
                atVar.enW = 3;
                atVar.eOp();
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (com.tencent.mm.plugin.expt.h.a aVar : list2) {
                atVar.eqq = aVar.sLf;
                atVar.eqr = aVar.sLg;
                atVar.enW = 2;
                atVar.eOp();
            }
        }
        AppMethodBeat.o(220632);
    }

    public static ArrayList<Integer> cRo() {
        AppMethodBeat.i(220633);
        List<com.tencent.mm.plugin.expt.h.a> cRL = com.tencent.mm.plugin.expt.h.b.cRI().cRL();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (cRL.size() > 0) {
            for (com.tencent.mm.plugin.expt.h.a aVar : cRL) {
                arrayList.add(Integer.valueOf(aVar.sLf));
            }
        }
        AppMethodBeat.o(220633);
        return arrayList;
    }

    public static com.tencent.mm.plugin.expt.h.a Hy(int i2) {
        AppMethodBeat.i(220634);
        com.tencent.mm.plugin.expt.h.a HA = com.tencent.mm.plugin.expt.h.b.cRI().HA(i2);
        AppMethodBeat.o(220634);
        return HA;
    }

    public final int dv(List<Integer> list) {
        AppMethodBeat.i(122342);
        int dv = this.sJX.dv(list);
        Log.i("MicroMsg.ExptService", "delete expt ids deleteCount[%d] deleteMapCount[%d]", Integer.valueOf(dv), Integer.valueOf(this.sJY.dy(list)));
        cRj();
        com.tencent.mm.plugin.expt.i.c.cSa().dA(list);
        AppMethodBeat.o(122342);
        return dv;
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(220635);
        if (!g.aAc()) {
            Log.w("MicroMsg.ExptService", "account is not ready, don't get expt config");
            AppMethodBeat.o(220635);
        } else if (!MMApplicationContext.isMMProcess()) {
            Log.w("MicroMsg.ExptService", "it is not mm process, why you call update expt?");
            AppMethodBeat.o(220635);
        } else {
            if (aVar.iKV <= 0) {
                aVar.iKV = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, (Object) 0)).intValue();
            }
            if (aVar.gTn <= 0) {
                aVar.gTn = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_INTERVAL_SEC_INT, Integer.valueOf((int) LocalCache.TIME_DAY))).intValue();
                if (aVar.gTn <= 3600) {
                    Log.w("MicroMsg.ExptService", "interval is less than 1 hour, something warn here!!!");
                    aVar.gTn = LocalCache.TIME_HOUR;
                }
            }
            if (Util.secondsToNow((long) aVar.iKV) >= ((long) aVar.gTn)) {
                Hw(1);
            }
            AppMethodBeat.o(220635);
        }
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(122349);
        if (!g.aAc()) {
            Log.w("MicroMsg.ExptService", "account is not ready, don't get expt config");
            AppMethodBeat.o(122349);
        } else if (!MMApplicationContext.isMMProcess()) {
            Log.w("MicroMsg.ExptService", "it is not mm process, why you call update expt?");
            AppMethodBeat.o(122349);
        } else {
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_APP_LAST_TIME_SEC_INT, (Object) 0)).intValue();
            int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_APP_INTERVAL_SEC_INT, Integer.valueOf((int) LocalCache.TIME_DAY))).intValue();
            if (intValue2 <= 3600) {
                Log.w("MicroMsg.ExptService", "interval is less than 1 hour, something warn here!!!");
                intValue2 = 3600;
            }
            if (Util.secondsToNow((long) intValue) >= ((long) intValue2)) {
                aVar.Hx(1);
            }
            AppMethodBeat.o(122349);
        }
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(122350);
        if (!g.aAc()) {
            Log.w("MicroMsg.ExptService", "account is not ready, don't get expt config");
            AppMethodBeat.o(122350);
        } else if (!MMApplicationContext.isMMProcess()) {
            Log.w("MicroMsg.ExptService", "it is not mm process, why you call update expt?");
            AppMethodBeat.o(122350);
        } else {
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_REPORT_EXPT_APP_LAST_TIME_SEC_INT, (Object) 0)).intValue();
            int a2 = aVar.a(b.a.clicfg_new_expt_report, LocalCache.TIME_HOUR);
            if (a2 > 0 && Util.secondsToNow((long) intValue) >= ((long) a2)) {
                com.tencent.mm.plugin.expt.a.a.cMx();
                com.tencent.mm.plugin.expt.a.a.cMy();
            }
            AppMethodBeat.o(122350);
        }
    }
}
