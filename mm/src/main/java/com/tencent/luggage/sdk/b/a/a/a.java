package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class a {
    protected LockStepNative czB;
    public String czC = null;
    public boolean czD = true;
    public final C0179a czE = new C0179a(new Runnable() {
        /* class com.tencent.luggage.sdk.b.a.a.a.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(146748);
            synchronized (a.this) {
                try {
                    if (a.this.czB != null) {
                        Log.i("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
                        a.this.czB.destoryLockStep();
                        a.this.czB = null;
                    } else {
                        Log.i("Luggage.LockStepNativeInstallHelper", "DestroyTask lockStepNative is null");
                    }
                } finally {
                    AppMethodBeat.o(146748);
                }
            }
        }
    });

    public a() {
        AppMethodBeat.i(146750);
        AppMethodBeat.o(146750);
    }

    public static int getStatisticsNetType() {
        AppMethodBeat.i(146753);
        try {
            f.c dS = f.dS(MMApplicationContext.getContext());
            Log.i("Luggage.LockStepNativeInstallHelper", "networkType = %s", dS.value);
            Log.i("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())));
            if (dS == f.c.None) {
                AppMethodBeat.o(146753);
                return -1;
            } else if (dS == f.c.Mobile_2g) {
                AppMethodBeat.o(146753);
                return 2;
            } else if (dS == f.c.Mobile_3g) {
                AppMethodBeat.o(146753);
                return 3;
            } else if (dS == f.c.Mobile_4g) {
                AppMethodBeat.o(146753);
                return 4;
            } else if (dS == f.c.Mobile_5g) {
                AppMethodBeat.o(146753);
                return 5;
            } else if (dS == f.c.Wifi) {
                AppMethodBeat.o(146753);
                return 1;
            } else {
                AppMethodBeat.o(146753);
                return 0;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.LockStepNativeInstallHelper", e2, "getStatisticsNetType_", new Object[0]);
            AppMethodBeat.o(146753);
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.luggage.sdk.b.a.a.a$a  reason: collision with other inner class name */
    public class C0179a extends l implements m.a {
        C0179a(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.m.a
        public final void onDestroy() {
            AppMethodBeat.i(146749);
            run();
            AppMethodBeat.o(146749);
        }
    }
}
