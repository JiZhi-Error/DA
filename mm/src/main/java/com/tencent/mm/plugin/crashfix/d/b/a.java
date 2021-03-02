package com.tencent.mm.plugin.crashfix.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a implements b {
    boolean isFront = false;
    private final int qCE = 0;
    private final int qCF = 1;
    private final String[] qCG = {"com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.app.WorkerProfile$", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI"};

    public a() {
        AppMethodBeat.i(225328);
        AppMethodBeat.o(225328);
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean Fh(int i2) {
        return true;
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean cAO() {
        AppMethodBeat.i(225329);
        AppForegroundDelegate.INSTANCE.a(new o() {
            /* class com.tencent.mm.plugin.crashfix.d.b.a.AnonymousClass1 */

            @Override // com.tencent.mm.app.o
            public final void onAppForeground(String str) {
                a.this.isFront = true;
            }

            @Override // com.tencent.mm.app.o
            public final void onAppBackground(String str) {
                a.this.isFront = false;
            }
        });
        EventCenter.instance.add(new IListener<lh>() {
            /* class com.tencent.mm.plugin.crashfix.d.b.a.AnonymousClass2 */

            {
                AppMethodBeat.i(225326);
                this.__eventId = lh.class.getName().hashCode();
                AppMethodBeat.o(225326);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(lh lhVar) {
                AppMethodBeat.i(225327);
                if (lhVar.dQy.action == 0) {
                    if (a.this.isFront) {
                        h.INSTANCE.idkeyStat(1453, 0, 1, false);
                    } else {
                        h.INSTANCE.idkeyStat(1453, 1, 1, false);
                    }
                    Log.e("MicroMsg.KillSelfMonitor", "killSelf!" + a.this.isFront);
                    String str = "";
                    StackTraceElement[] stackTrace = new Exception().getStackTrace();
                    for (int i2 = 0; i2 < stackTrace.length; i2++) {
                        str = str + stackTrace[i2].toString() + "\n";
                    }
                    Log.e("MicroMsg.KillSelfMonitor", "stack:".concat(String.valueOf(str)));
                    if (a.a(a.this, str)) {
                        AppMethodBeat.o(225327);
                        return true;
                    }
                    if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_killself_report, false)) {
                        h.INSTANCE.a(20683, MMApplicationContext.getProcessName(), str, Integer.valueOf(a.this.isFront ? 1 : -1));
                    }
                    AppMethodBeat.o(225327);
                    return true;
                }
                AppMethodBeat.o(225327);
                return false;
            }
        });
        AppMethodBeat.o(225329);
        return true;
    }

    static /* synthetic */ boolean a(a aVar, String str) {
        AppMethodBeat.i(225330);
        for (String str2 : aVar.qCG) {
            if (str.contains(str2)) {
                AppMethodBeat.o(225330);
                return true;
            }
        }
        AppMethodBeat.o(225330);
        return false;
    }
}
