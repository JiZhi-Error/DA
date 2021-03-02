package com.tencent.mm.plugin.soter;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public class PluginSoter extends f implements c, a {
    private static com.tencent.mm.plugin.soter.d.c FgZ = new com.tencent.mm.plugin.soter.d.c();
    private static b Fha = new b();
    private com.tencent.mm.plugin.soter.d.f FgX = null;
    private boolean FgY = false;
    private int Fhb = 0;
    private com.tencent.mm.vending.b.b kJs;
    private String mRa = "";

    static /* synthetic */ int access$108(PluginSoter pluginSoter) {
        int i2 = pluginSoter.Fhb;
        pluginSoter.Fhb = i2 + 1;
        return i2;
    }

    static /* synthetic */ boolean access$200(PluginSoter pluginSoter) {
        AppMethodBeat.i(192227);
        boolean shouldPreparedASK = pluginSoter.shouldPreparedASK();
        AppMethodBeat.o(192227);
        return shouldPreparedASK;
    }

    static /* synthetic */ void access$300(PluginSoter pluginSoter) {
        AppMethodBeat.i(192228);
        pluginSoter.initSoter();
        AppMethodBeat.o(192228);
    }

    static {
        AppMethodBeat.i(130796);
        AppMethodBeat.o(130796);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-soter";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(130785);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", gVar.mProcessName);
            this.FgY = true;
            Log.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
            this.FgX = new com.tencent.mm.plugin.soter.d.f();
            safeAddListener(this.FgX);
        }
        AppMethodBeat.o(130785);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void uninstalled() {
        AppMethodBeat.i(130786);
        super.uninstalled();
        safeRemoveListener(this.FgX);
        AppMethodBeat.o(130786);
    }

    private void safeAddListener(IListener iListener) {
        AppMethodBeat.i(130787);
        if (iListener == null) {
            Log.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
            AppMethodBeat.o(130787);
        } else if (EventCenter.instance.hadListened(iListener)) {
            Log.w("MicroMsg.PluginSoter", "hy: already has listener");
            AppMethodBeat.o(130787);
        } else {
            EventCenter.instance.addListener(iListener);
            AppMethodBeat.o(130787);
        }
    }

    private void safeRemoveListener(IListener iListener) {
        AppMethodBeat.i(130788);
        if (iListener == null) {
            Log.w("MicroMsg.PluginSoter", "alvinluo listener is null");
            AppMethodBeat.o(130788);
            return;
        }
        EventCenter.instance.removeListener(iListener);
        AppMethodBeat.o(130788);
    }

    private boolean block() {
        AppMethodBeat.i(130789);
        String str = Build.MODEL;
        if ("NCE-AL10".equals(str) || "NCE-AL00".equals(str) || "NCE-TL10".equals(str)) {
            AppMethodBeat.o(130789);
            return true;
        }
        AppMethodBeat.o(130789);
        return false;
    }

    private void initSoter() {
        AppMethodBeat.i(130791);
        new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.soter.PluginSoter.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                String aUb;
                AppMethodBeat.i(130782);
                if (!com.tencent.mm.kernel.g.aAf().azp()) {
                    Log.i("MicroMsg.PluginSoter", "account not ready.");
                    AppMethodBeat.o(130782);
                    return false;
                }
                if (!Util.isNullOrNil(PluginSoter.this.mRa)) {
                    aUb = PluginSoter.this.mRa;
                } else {
                    aUb = z.aUb();
                }
                String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_LAST_USERNAME_STRING_SYNC, "");
                Log.i("MicroMsg.PluginSoter", "username old: %s, new: %s, %s", str, aUb, PluginSoter.this.mRa);
                if (!Util.isNullOrNil(aUb) || PluginSoter.this.Fhb >= 10) {
                    if (Util.isNullOrNil(str) || str.equals(aUb)) {
                        if (Util.isNullOrNil(str)) {
                            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_LAST_USERNAME_STRING_SYNC, aUb);
                        }
                        m.Fib = aUb;
                    } else {
                        Log.i("MicroMsg.PluginSoter", "have changed username, old: %s, new: %s", str, aUb);
                        m.Fib = str;
                    }
                    Log.i("MicroMsg.PluginSoter", "do init soter: %s, %s, %s", Integer.valueOf(PluginSoter.this.Fhb), aUb, m.Fib);
                    if (PluginSoter.this.Fhb >= 10) {
                        h.INSTANCE.dN(1104, 44);
                    } else if (PluginSoter.this.Fhb > 0) {
                        h.INSTANCE.dN(1104, 45);
                    } else {
                        h.INSTANCE.dN(1104, 47);
                    }
                    com.tencent.mm.plugin.soter.e.b.a(PluginSoter.access$200(PluginSoter.this), new com.tencent.mm.plugin.soter.d.g() {
                        /* class com.tencent.mm.plugin.soter.PluginSoter.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.soter.d.g
                        public final void bg(int i2, String str) {
                            AppMethodBeat.i(130781);
                            Log.i("MicroMsg.PluginSoter", "init finish: %s, %s", Integer.valueOf(i2), str);
                            on onVar = new on();
                            onVar.dUC.errCode = i2;
                            onVar.dUC.errMsg = str;
                            EventCenter.instance.publish(onVar);
                            AppMethodBeat.o(130781);
                        }
                    });
                    AppMethodBeat.o(130782);
                    return false;
                }
                Log.i("MicroMsg.PluginSoter", "username is null, delay init");
                PluginSoter.access$108(PluginSoter.this);
                AppMethodBeat.o(130782);
                return true;
            }
        }, true).startTimer(100, 1000);
        AppMethodBeat.o(130791);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(130792);
        Log.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", Boolean.valueOf(this.FgY));
        if (this.FgY) {
            m.flO();
            this.mRa = z.aUb();
            initSoter();
            this.kJs = ((com.tencent.mm.plugin.auth.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b() {
                /* class com.tencent.mm.plugin.soter.PluginSoter.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.auth.a.b
                public final void a(j.h hVar, j.i iVar, boolean z) {
                    AppMethodBeat.i(130784);
                    Log.i("MicroMsg.PluginSoter", "autoAuth: %s", Boolean.valueOf(z));
                    com.tencent.f.h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.plugin.soter.PluginSoter.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(130783);
                            long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_SOTER_REPORT_TIMESTAMP_LONG_SYNC, (Object) 0L)).longValue();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - longValue > Util.MILLSECONDS_OF_DAY && com.tencent.soter.a.a.hlC()) {
                                h.INSTANCE.dN(1034, 1);
                                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SOTER_REPORT_TIMESTAMP_LONG_SYNC, Long.valueOf(currentTimeMillis));
                            }
                            AppMethodBeat.o(130783);
                        }
                    });
                    if (!z && com.tencent.soter.a.c.b.hlG().isInit() && com.tencent.soter.a.c.b.hlG().hlI().get(1).equals("WechatAuthKeyPay&null")) {
                        Log.i("MicroMsg.PluginSoter", "init error, reinit");
                        com.tencent.soter.a.c.b.hlG().DQ(false);
                        PluginSoter.access$300(PluginSoter.this);
                    }
                    AppMethodBeat.o(130784);
                }

                @Override // com.tencent.mm.plugin.auth.a.b
                public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
                }
            });
        }
        if (!EventCenter.instance.hadListened(FgZ)) {
            EventCenter.instance.addListener(FgZ);
        }
        if (!EventCenter.instance.hadListened(Fha)) {
            EventCenter.instance.addListener(Fha);
        }
        AppMethodBeat.o(130792);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(130793);
        Log.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
        if (this.FgY) {
            this.kJs.dead();
        }
        AppMethodBeat.o(130793);
    }

    private boolean shouldPreparedASK() {
        boolean z;
        AppMethodBeat.i(130790);
        com.tencent.mm.plugin.soter.d.e flM = d.flM();
        if (Util.isNullOrNil(flM.FhU) || Util.isNullOrNil(flM.hFF)) {
            z = false;
        } else {
            z = true;
        }
        if (z || block()) {
            AppMethodBeat.o(130790);
            return false;
        }
        AppMethodBeat.o(130790);
        return true;
    }
}
