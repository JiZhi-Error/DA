package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.l;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class SandBoxProfile extends d {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":sandbox");

    static {
        AppMethodBeat.i(19474);
        AppMethodBeat.o(19474);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19473);
        com.tencent.mm.booter.d cg = com.tencent.mm.booter.d.cg(MMApplicationContext.getContext());
        SandBoxProfile.class.getClassLoader();
        j.Ed("MMProtocalJni");
        SandBoxProfile.class.getClassLoader();
        j.Ed(Mars.libMarsBase);
        String str = CommLibFileName.quic;
        SandBoxProfile.class.getClassLoader();
        j.Ed(str);
        SandBoxProfile.class.getClassLoader();
        j.Ed(Mars.libMarsMM);
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.app.SandBoxProfile.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(19472);
                MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.KyO);
                AppMethodBeat.o(19472);
            }
        };
        try {
            r1.run();
        } catch (Throwable th) {
            r1.run();
        }
        u uVar = new u(cg);
        try {
            uVar.CN("SANDBOX");
            ac.jOr = Util.nullAs(uVar.CO(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            Log.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + ac.jOr);
        } catch (Error e2) {
        }
        l lVar = l.a.NGg;
        ab.WH();
        x.gmG();
        AppMethodBeat.o(19473);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return dkO;
    }
}
