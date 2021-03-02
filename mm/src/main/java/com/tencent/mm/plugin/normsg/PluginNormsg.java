package com.tencent.mm.plugin.normsg;

import android.os.Build;
import com.tencent.e.e.b.a.a.b;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.normsg.d.a;
import com.tencent.mm.plugin.normsg.d.b;
import com.tencent.mm.plugin.normsg.d.k;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public class PluginNormsg extends f implements c, q, a {
    private static final String AEB = b.INSTANCE.aIJ("\u001c:/-9+\n.\"0:41\r\"!");
    private static final String AEC = b.INSTANCE.aIJ("\u0005#64 2\u0004(,");
    private static final String AED = b.INSTANCE.aIJ("\u0000&31%7\u00009-\f.,");

    static {
        AppMethodBeat.i(149007);
        AppMethodBeat.o(149007);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(148985);
        alias(a.class);
        AppMethodBeat.o(148985);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(148986);
        dependsOn(d.class);
        dependsOn(com.tencent.mm.plugin.report.c.class);
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(a.class);
            dependsOn(s.class);
        }
        AppMethodBeat.o(148986);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(148987);
        com.tencent.mm.plugin.normsg.a.d.a(b.INSTANCE);
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.normsg.PluginNormsg.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "wc-msaid-init";
            }

            public final void run() {
                AppMethodBeat.i(148982);
                b.kW(MMApplicationContext.getContext());
                b bVar = b.INSTANCE;
                CrashReportFactory.setX86Env(b.isX86Env());
                b bVar2 = b.INSTANCE;
                CrashReportFactory.setDualByTools(b.isDualByTools());
                b bVar3 = b.INSTANCE;
                CrashReportFactory.setHookedByXposed(b.isHookedByXposed());
                AppMethodBeat.o(148982);
            }
        });
        AppMethodBeat.o(148987);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(148988);
        com.tencent.mm.plugin.normsg.d.a exW = com.tencent.mm.plugin.normsg.d.a.exW();
        com.tencent.mm.kernel.b.h azG = com.tencent.mm.kernel.g.aAe().azG();
        if (!a.c.isEnabled()) {
            Log.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
        } else {
            int eyc = a.c.eyc();
            if (eyc <= 0) {
                eyc = 26;
            }
            if (Build.VERSION.SDK_INT > eyc) {
                Log.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
            } else if (com.tencent.mm.plugin.normsg.d.a.AFa.contains(com.tencent.mm.plugin.normsg.d.a.gj(azG.mProcessName))) {
                try {
                    com.tencent.mm.plugin.normsg.d.b eye = com.tencent.mm.plugin.normsg.d.b.eye();
                    eye.initialize(azG.ca);
                    eye.ensureInitialized();
                    eye.AFG.add(exW);
                    Log.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
                } catch (b.f e2) {
                    Log.printErrStackTrace("MircoMsg.AEDHLP", e2, "[tomys] aed install failed.", new Object[0]);
                    exW.n(e2);
                }
            } else {
                Log.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
            }
        }
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a(AEB, this);
        k.start();
        AppMethodBeat.o(148988);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(148989);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b(AEB, this);
        k.stop();
        AppMethodBeat.o(148989);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.q
    public void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(148990);
        AppMethodBeat.o(148990);
    }
}
