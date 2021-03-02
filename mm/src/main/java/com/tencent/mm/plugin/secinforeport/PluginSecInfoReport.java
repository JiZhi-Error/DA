package com.tencent.mm.plugin.secinforeport;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.b.i;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.normsg.a;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class PluginSecInfoReport extends f implements b {
    private static MMHandler CWt = null;
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(89143);
            if (MMApplicationContext.isMainProcess()) {
                PluginSecInfoReport.access$000(PluginSecInfoReport.this);
            }
            AppMethodBeat.o(89143);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(89144);
            MMApplicationContext.isMainProcess();
            AppMethodBeat.o(89144);
        }
    };

    public PluginSecInfoReport() {
        AppMethodBeat.i(89155);
        AppMethodBeat.o(89155);
    }

    static /* synthetic */ void access$000(PluginSecInfoReport pluginSecInfoReport) {
        AppMethodBeat.i(89163);
        pluginSecInfoReport.TrustIdRequestAsync();
        AppMethodBeat.o(89163);
    }

    static /* synthetic */ void access$100(PluginSecInfoReport pluginSecInfoReport, int i2) {
        AppMethodBeat.i(89164);
        pluginSecInfoReport.reportSecurityInfoAsync(i2);
        AppMethodBeat.o(89164);
    }

    static /* synthetic */ void access$200(PluginSecInfoReport pluginSecInfoReport) {
        AppMethodBeat.i(89165);
        pluginSecInfoReport.asyncReportPaySecurityInfoThroughCgi();
        AppMethodBeat.o(89165);
    }

    static /* synthetic */ void access$300(PluginSecInfoReport pluginSecInfoReport, int i2) {
        AppMethodBeat.i(214395);
        pluginSecInfoReport.asyncReportFinderSecurityInfoThroughCgi(i2);
        AppMethodBeat.o(214395);
    }

    static /* synthetic */ void access$400(PluginSecInfoReport pluginSecInfoReport, String str, byte[] bArr) {
        AppMethodBeat.i(214396);
        pluginSecInfoReport.asyncReportSensorSceneInfoThroughCgi(str, bArr);
        AppMethodBeat.o(214396);
    }

    static /* synthetic */ void access$500(PluginSecInfoReport pluginSecInfoReport, byte[] bArr) {
        AppMethodBeat.i(214397);
        pluginSecInfoReport.asyncReportTuringOwnerThroughCgi(bArr);
        AppMethodBeat.o(214397);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(89156);
        alias(b.class);
        AppMethodBeat.o(89156);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(89157);
        dependsOn(d.class);
        dependsOn(c.class);
        dependsOn(a.class);
        AppMethodBeat.o(89157);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(89158);
        com.tencent.mm.plugin.secinforeport.a.d.a(c.INSTANCE);
        com.tencent.mm.plugin.secinforeport.a.a.a(a.INSTANCE);
        AppMethodBeat.o(89158);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(89159);
        if (CWt == null) {
            try {
                CWt = new MMHandler("SIRWorker");
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.PSIR", th, "[tomys] unexpected exception.", new Object[0]);
            }
        }
        EventCenter.instance.add(new IListener<ps>() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass9 */

            {
                AppMethodBeat.i(160763);
                this.__eventId = ps.class.getName().hashCode();
                AppMethodBeat.o(160763);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ps psVar) {
                AppMethodBeat.i(89146);
                PluginSecInfoReport.access$100(PluginSecInfoReport.this, 0);
                AppMethodBeat.o(89146);
                return false;
            }
        });
        EventCenter.instance.add(new IListener<com.tencent.mm.g.a.d>() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass10 */

            {
                AppMethodBeat.i(160764);
                this.__eventId = com.tencent.mm.g.a.d.class.getName().hashCode();
                AppMethodBeat.o(160764);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(com.tencent.mm.g.a.d dVar) {
                AppMethodBeat.i(89147);
                if (!dVar.dBP.dBQ) {
                    PluginSecInfoReport.access$100(PluginSecInfoReport.this, 0);
                }
                AppMethodBeat.o(89147);
                return false;
            }
        });
        EventCenter.instance.add(new IListener<ru>() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass11 */

            {
                AppMethodBeat.i(160765);
                this.__eventId = ru.class.getName().hashCode();
                AppMethodBeat.o(160765);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ru ruVar) {
                AppMethodBeat.i(89148);
                PluginSecInfoReport.access$200(PluginSecInfoReport.this);
                AppMethodBeat.o(89148);
                return false;
            }
        });
        EventCenter.instance.add(new IListener<rt>() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass12 */

            {
                AppMethodBeat.i(160766);
                this.__eventId = rt.class.getName().hashCode();
                AppMethodBeat.o(160766);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(rt rtVar) {
                AppMethodBeat.i(89149);
                rt rtVar2 = rtVar;
                if (!(rtVar2 == null || rtVar2.dYo == null)) {
                    PluginSecInfoReport.access$300(PluginSecInfoReport.this, rtVar2.dYo.dYp);
                }
                AppMethodBeat.o(89149);
                return false;
            }
        });
        EventCenter.instance.add(new IListener<lm>() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass13 */

            {
                AppMethodBeat.i(214384);
                this.__eventId = lm.class.getName().hashCode();
                AppMethodBeat.o(214384);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(lm lmVar) {
                String str;
                AppMethodBeat.i(214385);
                lm lmVar2 = lmVar;
                if (!(lmVar2 == null || lmVar2.dQO == null || lmVar2.dQO.dQP == null || !(lmVar2.dQO.dQP instanceof HashMap))) {
                    HashMap hashMap = lmVar2.dQO.dQP;
                    if (hashMap.get("url") != null && (hashMap.get("url") instanceof String) && (str = (String) hashMap.get("url")) != null && (str.equalsIgnoreCase("floatPay") || str.equalsIgnoreCase("jointPay"))) {
                        PluginSecInfoReport.access$200(PluginSecInfoReport.this);
                    }
                }
                AppMethodBeat.o(214385);
                return false;
            }
        });
        EventCenter.instance.add(new IListener<rz>() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass14 */

            {
                AppMethodBeat.i(214386);
                this.__eventId = rz.class.getName().hashCode();
                AppMethodBeat.o(214386);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(rz rzVar) {
                AppMethodBeat.i(214387);
                rz rzVar2 = rzVar;
                PluginSecInfoReport.access$400(PluginSecInfoReport.this, rzVar2.dYA.dYB, rzVar2.dYA.buffer);
                AppMethodBeat.o(214387);
                return false;
            }
        });
        EventCenter.instance.add(new IListener<sb>() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass15 */

            {
                AppMethodBeat.i(214388);
                this.__eventId = sb.class.getName().hashCode();
                AppMethodBeat.o(214388);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(sb sbVar) {
                AppMethodBeat.i(214389);
                PluginSecInfoReport.access$500(PluginSecInfoReport.this, sbVar.dYE.buffer);
                AppMethodBeat.o(214389);
                return false;
            }
        });
        ((com.tencent.mm.plugin.auth.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new b() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass16 */

            @Override // com.tencent.mm.plugin.auth.a.b
            public final void a(j.h hVar, j.i iVar, boolean z) {
                int i2 = 0;
                AppMethodBeat.i(214390);
                Log.i("MicroMsg.PSIR", "[+] type 1 report triggered, autoauth: %s", Boolean.valueOf(z));
                if (!z) {
                    i2 = 540999680;
                }
                PluginSecInfoReport.access$100(PluginSecInfoReport.this, i2);
                String aIT = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIT("ce_login_id");
                if (!TextUtils.isEmpty(aIT) && !z) {
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.eW(aIT, 2);
                }
                AppMethodBeat.o(214390);
            }

            @Override // com.tencent.mm.plugin.auth.a.b
            public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
                AppMethodBeat.i(214391);
                Log.i("MicroMsg.PSIR", "[+] type 2 report triggered.");
                PluginSecInfoReport.access$100(PluginSecInfoReport.this, 540999681);
                String aIT = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIT("ce_reg");
                if (!TextUtils.isEmpty(aIT)) {
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.eW(aIT, 1);
                }
                AppMethodBeat.o(214391);
            }
        });
        this.appForegroundListener.alive();
        AppMethodBeat.o(89159);
    }

    private void asyncReportPaySecurityInfoThroughCgi() {
        AppMethodBeat.i(89160);
        if (CWt == null) {
            Log.e("MicroMsg.PSIR", "[debug] workerposter[yap] is null, give up doing rest ops.");
            AppMethodBeat.o(89160);
            return;
        }
        CWt.post(new Runnable() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(89145);
                Log.i("MicroMsg.PSIR", "[+] report yap task start running.");
                try {
                    com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.eSt();
                    AppMethodBeat.o(89145);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.PSIR", th, "[yap] unexpected exception was thrown.", new Object[0]);
                    AppMethodBeat.o(89145);
                }
            }
        });
        AppMethodBeat.o(89160);
    }

    private void asyncReportSensorSceneInfoThroughCgi(final String str, final byte[] bArr) {
        AppMethodBeat.i(214392);
        if (CWt == null) {
            Log.e("MicroMsg.PSIR", "[debug] workerposter[sensor] is null, give up doing rest ops.");
            AppMethodBeat.o(214392);
            return;
        }
        CWt.post(new Runnable() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(214378);
                Log.i("MicroMsg.PSIR", "[+] report sensor scene info task start running.");
                try {
                    com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.u(str, bArr);
                    AppMethodBeat.o(214378);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.PSIR", th, "[sensor] unexpected exception was thrown.", new Object[0]);
                    AppMethodBeat.o(214378);
                }
            }
        });
        AppMethodBeat.o(214392);
    }

    private void asyncReportTuringOwnerThroughCgi(final byte[] bArr) {
        AppMethodBeat.i(214393);
        if (CWt == null) {
            Log.e("MicroMsg.PSIR", "[debug] workerposter[TuringOwner] is null, give up doing rest ops.");
            AppMethodBeat.o(214393);
            return;
        }
        CWt.post(new Runnable() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(214379);
                Log.i("MicroMsg.PSIR", "[+] report turing owner task start running.");
                try {
                    com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.ca(bArr);
                    AppMethodBeat.o(214379);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.PSIR", th, "[TuringOwner] unexpected exception was thrown.", new Object[0]);
                    AppMethodBeat.o(214379);
                }
            }
        });
        AppMethodBeat.o(214393);
    }

    private void asyncReportFinderSecurityInfoThroughCgi(final int i2) {
        AppMethodBeat.i(214394);
        if (CWt == null) {
            Log.e("MicroMsg.PSIR", "[debug] workerposter[finder] is null, give up doing rest ops.");
            AppMethodBeat.o(214394);
            return;
        }
        CWt.post(new Runnable() {
            /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(214380);
                Log.i("MicroMsg.PSIR", "[+] report finder task start running.");
                try {
                    com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.Xi(i2);
                    AppMethodBeat.o(214380);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.PSIR", th, "[finder] unexpected exception was thrown.", new Object[0]);
                    AppMethodBeat.o(214380);
                }
            }
        });
        AppMethodBeat.o(214394);
    }

    private void reportSecurityInfoAsync(final int i2) {
        AppMethodBeat.i(89161);
        if (CWt == null) {
            Log.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
            AppMethodBeat.o(89161);
        } else if (!com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(89161);
        } else {
            if (com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.aF(1, Util.MILLSECONDS_OF_DAY)) {
                Log.i("MicroMsg.PSIR", "[+] report task posted.");
                CWt.post(new Runnable() {
                    /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass6 */

                    public final void run() {
                        boolean z;
                        boolean z2;
                        int i2;
                        AppMethodBeat.i(214381);
                        Log.i("MicroMsg.PSIR", "[+] report task start running.");
                        try {
                            int i3 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("DisableRiskScanSdkProb", 0);
                            int i4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("DisableInstalledPkgInfoReportProb", 0);
                            com.tencent.mm.kernel.g.aAf();
                            int ch = i.ch(com.tencent.mm.kernel.a.getUin(), 101);
                            boolean z3 = i3 > 0 && ch >= 0 && ch <= i3;
                            if (i4 <= 0 || ch < 0 || ch > i4) {
                                z = false;
                            } else {
                                z = true;
                            }
                            int i5 = 16;
                            if (!z3) {
                                i5 = 17;
                            }
                            if (z) {
                                z2 = false;
                            } else {
                                try {
                                    if (com.tencent.mm.aw.b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null))) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                } catch (Throwable th) {
                                    Log.printErrStackTrace("MicroMsg.PSIR", th, "**** point 0, explained by source code.", new Object[0]);
                                    z2 = false;
                                }
                            }
                            if (z2) {
                                i2 = i5 | 14;
                            } else {
                                i2 = i5;
                            }
                            com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.ik(i2, i2 | 32);
                            AppMethodBeat.o(214381);
                        } catch (Throwable th2) {
                            Log.printErrStackTrace("MicroMsg.PSIR", th2, "unexpected exception was thrown.", new Object[0]);
                            AppMethodBeat.o(214381);
                        }
                    }
                });
            }
            if (com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.aF(2, Util.MILLSECONDS_OF_DAY)) {
                CWt.post(new Runnable() {
                    /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(214382);
                        com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.Xj(-2147483646);
                        AppMethodBeat.o(214382);
                    }
                });
            }
            AppMethodBeat.o(89161);
        }
    }

    private void TrustIdRequestAsync() {
        AppMethodBeat.i(89162);
        if (CWt == null) {
            Log.e("MicroMsg.PSIR", "[debug] workerposter is null, give up doing rest ops.");
            AppMethodBeat.o(89162);
            return;
        }
        if (com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.aG(3, Util.MILLSECONDS_OF_DAY) || !com.tencent.mm.plugin.normsg.a.d.INSTANCE.exL()) {
            Log.i("MicroMsg.PSIR", "[+] req task posted.");
            if (!ChannelUtil.shouldShowGprsAlert || !ChannelUtil.isShowingGprsAlert || !MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)) {
                CWt.post(new Runnable() {
                    /* class com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.AnonymousClass8 */

                    public final void run() {
                        int i2 = -1;
                        AppMethodBeat.i(214383);
                        com.tencent.mm.plugin.normsg.d.j jVar = new com.tencent.mm.plugin.normsg.d.j();
                        if (!com.tencent.mm.plugin.normsg.a.d.INSTANCE.exL()) {
                            byte[] TM = com.tencent.mm.plugin.normsg.a.d.INSTANCE.TM(1);
                            Object[] objArr = new Object[1];
                            if (TM != null) {
                                i2 = TM.length;
                            }
                            objArr[0] = Integer.valueOf(i2);
                            Log.d("TrustRequestManager", "[debug] doScene type:[init] dlen:[%d]", objArr);
                            if (TM == null || TM.length == 0) {
                                AppMethodBeat.o(214383);
                                return;
                            }
                            jVar.eyq();
                            if (!com.tencent.mm.kernel.g.azz().a(com.tencent.mm.kernel.g.aAc() ? new com.tencent.mm.plugin.normsg.b.b(false, TM) : new com.tencent.mm.plugin.normsg.b.b(true, TM), 0)) {
                                Log.e("TrustRequestManager", "[debug] doScene faild");
                                jVar.eyr();
                            }
                            AppMethodBeat.o(214383);
                            return;
                        }
                        byte[] TM2 = com.tencent.mm.plugin.normsg.a.d.INSTANCE.TM(2);
                        Object[] objArr2 = new Object[1];
                        if (TM2 != null) {
                            i2 = TM2.length;
                        }
                        objArr2[0] = Integer.valueOf(i2);
                        Log.d("TrustRequestManager", "[debug] doScene type:[refesh] dlen:[%d]", objArr2);
                        if (TM2 == null || TM2.length == 0) {
                            AppMethodBeat.o(214383);
                            return;
                        }
                        jVar.eyq();
                        if (!com.tencent.mm.kernel.g.azz().a(com.tencent.mm.kernel.g.aAc() ? new com.tencent.mm.plugin.normsg.b.a(false, TM2) : new com.tencent.mm.plugin.normsg.b.a(true, TM2), Util.getIntRandom(600000, 0))) {
                            Log.e("TrustRequestManager", "[debug] doScene faild");
                            jVar.eyr();
                        }
                        AppMethodBeat.o(214383);
                    }
                });
            } else {
                Log.i("MicroMsg.PSIR", "CTA alert is not checked Return here.");
                AppMethodBeat.o(89162);
                return;
            }
        }
        AppMethodBeat.o(89162);
    }
}
