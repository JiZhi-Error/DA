package com.tencent.mm.plugin.expt.g;

import android.app.Activity;
import android.app.Application;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.expt.g.c;
import com.tencent.mm.plugin.expt.hellhound.a.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements Application.ActivityLifecycleCallbacks, c, e {
    private static int[] sKk = {10, 1000, 10000, 100000};
    private static boolean sKl = false;
    private static d sKm;
    private IListener<l> appListener = new IListener<l>() {
        /* class com.tencent.mm.plugin.expt.g.d.AnonymousClass2 */

        {
            AppMethodBeat.i(161610);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(161610);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            e.a aVar;
            AppMethodBeat.i(122366);
            l lVar2 = lVar;
            if (lVar2 != null) {
                if (lVar2.dCi.isActive) {
                    aVar = e.a.MMAppMgr_Activated;
                } else {
                    aVar = e.a.MMAppMgr_Deactivated;
                }
                d.this.b(aVar.name(), aVar, hashCode(), System.currentTimeMillis());
            }
            AppMethodBeat.o(122366);
            return false;
        }
    };
    private boolean sKn = false;
    private boolean sKo = false;
    private String sKp = "";
    private HashSet<String> sKq = new HashSet<>();
    private IListener sKr = new IListener<mi>() {
        /* class com.tencent.mm.plugin.expt.g.d.AnonymousClass3 */

        {
            AppMethodBeat.i(161611);
            this.__eventId = mi.class.getName().hashCode();
            AppMethodBeat.o(161611);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mi miVar) {
            AppMethodBeat.i(122368);
            boolean cRx = cRx();
            AppMethodBeat.o(122368);
            return cRx;
        }

        private boolean cRx() {
            AppMethodBeat.i(122367);
            Log.i("MicroMsg.MMPageFlowService", "manual force login");
            if (!d.this.sKn) {
                d.this.sKn = true;
                com.tencent.mm.plugin.expt.hellhound.a.c.c.a(105, null, 0, System.currentTimeMillis());
                com.tencent.mm.plugin.expt.hellhound.a.c.c.cPx();
                a.Hi(7);
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(7);
            }
            AppMethodBeat.o(122367);
            return false;
        }
    };

    private d() {
        AppMethodBeat.i(122370);
        if (!MMApplicationContext.isMMProcess()) {
            sKl = true;
        }
        AppMethodBeat.o(122370);
    }

    private static void reset() {
        sKk = new int[]{10, 1000, 10000, 100000};
        sKl = false;
    }

    public static d cRu() {
        AppMethodBeat.i(122371);
        if (sKm == null) {
            sKm = new d();
        }
        d dVar = sKm;
        AppMethodBeat.o(122371);
        return dVar;
    }

    private String info() {
        AppMethodBeat.i(122372);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(122372);
        return sb;
    }

    private void a(Activity activity, e.a aVar) {
        AppMethodBeat.i(122373);
        if (activity != null) {
            b(activity.getComponentName().getClassName(), aVar, activity.hashCode(), System.currentTimeMillis());
        }
        AppMethodBeat.o(122373);
    }

    @Override // com.tencent.mm.plugin.expt.b.e
    public final void logout() {
        AppMethodBeat.i(122374);
        sKl = false;
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(106, null, 0, System.currentTimeMillis());
        com.tencent.mm.plugin.expt.hellhound.a.c.c.cPx();
        a.Hi(8);
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(8);
        a.mi(true);
        Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
        AppMethodBeat.o(122374);
    }

    public static boolean cRv() {
        return sKl;
    }

    private void a(String str, e.a aVar, int i2, int i3, long j2) {
        AppMethodBeat.i(122375);
        long currentTicks = Util.currentTicks();
        if (!MMApplicationContext.isMMProcess()) {
            if (c.sKi == null) {
                c.sKi = new c();
            }
            Log.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new StringBuilder().append(c.sKi.hashCode()).toString(), str, Integer.valueOf(i2), Long.valueOf(j2), aVar);
            Bundle bundle = new Bundle();
            bundle.putInt("key_page_flow_type", aVar.value);
            bundle.putString("key_page_flow_name", str);
            bundle.putInt("key_page_flow_hashcode", i2);
            bundle.putLong("key_page_flow_time_stamp", j2);
            h.INSTANCE.idkeyStat(932, 100, 1, false);
            String string = bundle.getString("key_page_flow_name");
            int i4 = bundle.getInt("key_page_flow_type");
            int i5 = bundle.getInt("key_page_flow_hashcode", 0);
            long j3 = bundle.getLong("key_page_flow_time_stamp", 0);
            String sb = new StringBuilder().append((i5 + "_" + j3).hashCode()).toString();
            ft ftVar = new ft();
            ftVar.eHx = (long) i5;
            ft sK = ftVar.sK(string);
            sK.erY = (long) i4;
            sK.pk(j3);
            b cRt = b.cRt();
            String abV = ftVar.abV();
            MultiProcessMMKV VQ = cRt.VQ();
            if (VQ != null) {
                VQ.putString(sb, abV);
            }
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, c.a.class, null);
            Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
            sKl = true;
        }
        if (!sKl) {
            Log.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
            AppMethodBeat.o(122375);
            return;
        }
        Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
        if (MMApplicationContext.isMMProcess()) {
            cRw();
        }
        a(str, aVar, i2, j2, i3);
        Log.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(122375);
    }

    public final void b(String str, e.a aVar, int i2, long j2) {
        AppMethodBeat.i(184399);
        a(str, aVar, i2, Process.myPid(), j2);
        AppMethodBeat.o(184399);
    }

    /* access modifiers changed from: protected */
    public final void cRw() {
        AppMethodBeat.i(122377);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(122377);
            return;
        }
        long currentTicks = Util.currentTicks();
        String[] allKeys = b.cRt().allKeys();
        ArrayList<ft> arrayList = new ArrayList();
        if (allKeys != null && allKeys.length > 0) {
            for (String str : allKeys) {
                if (!this.sKq.contains(str)) {
                    String str2 = b.cRt().get(str, "");
                    if (!Util.isNullOrNil(str2)) {
                        ft ftVar = new ft(str2);
                        if (ftVar.eHx > 0 && ftVar.eHw > 0) {
                            arrayList.add(new ft(str2));
                            this.sKq.add(str);
                        }
                        b.cRt().remove(str);
                    }
                }
                b.cRt().remove(str);
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new Comparator<ft>() {
                /* class com.tencent.mm.plugin.expt.g.d.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(ft ftVar, ft ftVar2) {
                    AppMethodBeat.i(122365);
                    int compare = Long.compare(ftVar.eHw, ftVar2.eHw);
                    AppMethodBeat.o(122365);
                    return compare;
                }
            });
            for (ft ftVar2 : arrayList) {
                a(ftVar2.eHv, e.a.GL((int) ftVar2.erY), (int) ftVar2.eHx, ftVar2.eHw);
            }
            h.INSTANCE.idkeyStat(932, 102, (long) arrayList.size(), false);
            Log.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", Integer.valueOf(arrayList.size()), Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        Log.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(122377);
    }

    private void a(String str, e.a aVar, int i2, long j2, int i3) {
        char c2;
        AppMethodBeat.i(122378);
        if (str.contains("WeChatSplashActivity") || str.contains("FakeSwitchAccountUI")) {
            AppMethodBeat.o(122378);
            return;
        }
        if (aVar.value <= 2) {
            c2 = 0;
        } else if (aVar.value <= 4) {
            c2 = 1;
        } else if (aVar.value <= 6) {
            c2 = 2;
        } else {
            c2 = 3;
        }
        if (aVar == e.a.MMActivity_Back2Front) {
            this.sKo = true;
        }
        if (aVar == e.a.MMActivity_Front2Back) {
            this.sKo = false;
        }
        gw gwVar = new gw();
        gwVar.euv = i3;
        gw uK = gwVar.uJ(g.aAe().azG().mProcessName).uK(str);
        int[] iArr = sKk;
        int i4 = iArr[c2];
        iArr[c2] = i4 + 1;
        uK.eLd = (long) i4;
        uK.erY = (long) aVar.value;
        gw qH = uK.qH(j2);
        qH.eHx = (long) i2;
        e.cRy().a(qH);
        Log.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", info(), qH.abW());
        if (aVar == e.a.MMActivity_Back2Front || aVar == e.a.MMActivity_Front2Back) {
            Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", info(), qH.abW());
        }
        if (MMApplicationContext.isMMProcess() && (aVar == e.a.MMActivity_Back2Front || aVar == e.a.MMActivity_Front2Back)) {
            r(j2, this.sKo);
            b.Hj(sKk[3]);
        }
        AppMethodBeat.o(122378);
    }

    public final void a(String str, e.a aVar, int i2, long j2) {
        AppMethodBeat.i(122379);
        a(str, aVar, i2, j2, Process.myPid());
        AppMethodBeat.o(122379);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        boolean z = true;
        AppMethodBeat.i(122380);
        reset();
        sKl = true;
        com.tencent.mm.plugin.expt.i.c.cSa();
        if (Util.getInt(com.tencent.mm.plugin.expt.i.c.c(b.a.clicfg_weixin_register_mm_app_active_event, ""), 0) <= 0) {
            z = false;
        }
        if (z) {
            EventCenter.instance.add(this.appListener);
        }
        EventCenter.instance.add(this.sKr);
        AppMethodBeat.o(122380);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(122381);
        reset();
        EventCenter.instance.removeListener(this.appListener);
        EventCenter.instance.removeListener(this.sKr);
        this.sKn = false;
        AppMethodBeat.o(122381);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(122382);
        a(activity, e.a.MMLifeCall_OnResume);
        AppMethodBeat.o(122382);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(122383);
        a(activity, e.a.MMLifeCall_OnPause);
        AppMethodBeat.o(122383);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(122384);
        String className = activity.getComponentName().getClassName();
        if (sKl && "com.tencent.mm.ui.LauncherUI".equals(className) && this.sKo) {
            Object[] objArr = new Object[2];
            objArr[0] = info();
            objArr[1] = Integer.valueOf(activity != null ? activity.hashCode() : -1);
            Log.i("MicroMsg.MMPageFlowService", "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]", objArr);
        }
        AppMethodBeat.o(122384);
    }

    private void r(final long j2, final boolean z) {
        AppMethodBeat.i(122385);
        if (!sKl) {
            AppMethodBeat.o(122385);
            return;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_weixin_unread_records_rpt_time, 0);
        if (a2 <= 0) {
            AppMethodBeat.o(122385);
            return;
        }
        if (Util.nowSecond() - g.aAh().azQ().a(ar.a.USERINFO_WEIXIN_UNREAD_RECORDS_LAST_RPT_TIME_LONG, 0) < ((long) a2)) {
            AppMethodBeat.o(122385);
            return;
        }
        com.tencent.f.h.RTc.bqo("calc_unread_task");
        com.tencent.f.h.RTc.a(new Runnable() {
            /* class com.tencent.mm.plugin.expt.g.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(122369);
                d.a(d.this, j2, z);
                AppMethodBeat.o(122369);
            }
        }, 5000, "calc_unread_task");
        AppMethodBeat.o(122385);
    }

    static /* synthetic */ void a(d dVar, long j2, boolean z) {
        int i2;
        String str;
        AppMethodBeat.i(122386);
        long currentTicks = Util.currentTicks();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        Cursor cursor = null;
        try {
            Cursor gCC = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().gCC();
            if (gCC != null) {
                while (gCC.moveToNext()) {
                    String string = gCC.getString(0);
                    int i17 = gCC.getInt(1);
                    if (ab.Js(string)) {
                        i16 += i17;
                    } else if (ab.JF(string) || ab.IJ(string)) {
                        i13 += i17;
                        i14++;
                    } else if (ab.Jx(string)) {
                        i15 += i17;
                    } else if (ab.JC(string)) {
                        i15 += i17;
                    } else if (string.startsWith("gh_")) {
                        i11 += i17;
                        i12++;
                    } else {
                        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(string);
                        if (Kn != null && !Util.isNullOrNil(Kn.field_username)) {
                            if (ab.Eq(string)) {
                                if (Kn.fuH == 0) {
                                    i9 += i17;
                                    i10++;
                                } else {
                                    i7 += i17;
                                    i8++;
                                }
                            } else if (!Kn.gBM()) {
                                if (Kn.Zx()) {
                                    i5 += i17;
                                    i6++;
                                } else {
                                    i3 += i17;
                                    i4++;
                                }
                            }
                        }
                    }
                }
            }
            i2 = i16;
            if (gCC != null) {
                gCC.close();
            }
        } catch (Exception e2) {
            i2 = 0;
            Log.printErrStackTrace("MicroMsg.MMPageFlowService", e2, "getUnreadStatus error", new Object[0]);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(122386);
            throw th;
        }
        long ticksToNow = Util.ticksToNow(currentTicks);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MStorageEventData.EventType.SINGLE, i3).put("singleSes", i4);
            jSONObject.put("singleMute", i5).put("singleMuteSes", i6);
            jSONObject.put("group", i7).put("groupSes", i8);
            jSONObject.put("groupMute", i9).put("groupMuteSes", i10);
            jSONObject.put("plugin", i13).put("pluginSes", i14);
            jSONObject.put("service", i11).put("serviceSes", i12);
            jSONObject.put("notifyMessage", i15).put("subscribe", i2).put("cost", ticksToNow);
            str = jSONObject.toString().replace(",", ".");
        } catch (JSONException e3) {
            Log.printErrStackTrace("MicroMsg.MMPageFlowService", e3, "toJson error", new Object[0]);
            str = "";
        }
        if (z) {
            dVar.sKp = String.format("\"tbe\":%d.\"be\":%s", Long.valueOf(j2), str);
            Log.d("MicroMsg.MMPageFlowService", "check unread status in [%s]", dVar.sKp);
            AppMethodBeat.o(122386);
            return;
        }
        String format = String.format("{%s.\"ten\":%d.\"en\":%s}", dVar.sKp, Long.valueOf(j2), str);
        Log.i("MicroMsg.MMPageFlowService", "check unread status back [%s]", format);
        h.INSTANCE.kvStat(16387, format);
        g.aAh().azQ().set(ar.a.USERINFO_WEIXIN_UNREAD_RECORDS_LAST_RPT_TIME_LONG, Long.valueOf(Util.nowSecond()));
        AppMethodBeat.o(122386);
    }
}
