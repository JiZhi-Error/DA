package com.tencent.mm.plugin.soter.e;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.j.c;
import com.tencent.soter.a.a;
import com.tencent.soter.core.d.d;
import com.tencent.soter.core.d.e;

public final class b {
    public static boolean Fig = false;
    public static int Fih;
    private static e Fii = new e() {
        /* class com.tencent.mm.plugin.soter.e.b.AnonymousClass1 */

        @Override // com.tencent.soter.core.d.e
        public final void flY() {
            AppMethodBeat.i(130870);
            h.INSTANCE.idkeyStat(1104, 5, 1, false);
            AppMethodBeat.o(130870);
        }

        @Override // com.tencent.soter.core.d.e
        public final void onServiceConnected() {
            AppMethodBeat.i(130871);
            h.INSTANCE.idkeyStat(1104, 6, 1, false);
            if (!a.hlC()) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.soter.e.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(130869);
                        if (!a.hlC()) {
                            Log.i("MicroMsg.SoterInitManager", "bind service timeout, reinit");
                            b.a(false, new g() {
                                /* class com.tencent.mm.plugin.soter.e.b.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.soter.d.g
                                public final void bg(int i2, String str) {
                                    AppMethodBeat.i(130868);
                                    Log.i("MicroMsg.SoterInitManager", "init finish: %s, %s", Integer.valueOf(i2), str);
                                    on onVar = new on();
                                    onVar.dUC.errCode = i2;
                                    onVar.dUC.errMsg = str;
                                    EventCenter.instance.publish(onVar);
                                    AppMethodBeat.o(130868);
                                }
                            });
                        }
                        AppMethodBeat.o(130869);
                    }
                }, 5000);
            }
            AppMethodBeat.o(130871);
        }

        @Override // com.tencent.soter.core.d.e
        public final void flZ() {
            AppMethodBeat.i(130872);
            h.INSTANCE.idkeyStat(1104, 7, 1, false);
            AppMethodBeat.o(130872);
        }

        @Override // com.tencent.soter.core.d.e
        public final void fma() {
            AppMethodBeat.i(130873);
            h.INSTANCE.idkeyStat(1104, 8, 1, false);
            AppMethodBeat.o(130873);
        }

        @Override // com.tencent.soter.core.d.e
        public final void fmb() {
            AppMethodBeat.i(130874);
            Log.i("MicroMsg.SoterInitManager", "no service when calling");
            h.INSTANCE.idkeyStat(1104, 9, 1, false);
            AppMethodBeat.o(130874);
        }
    };

    static {
        AppMethodBeat.i(130879);
        AppMethodBeat.o(130879);
    }

    public static void a(boolean z, final g gVar) {
        AppMethodBeat.i(130877);
        Log.i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", Boolean.valueOf(z), Boolean.TRUE);
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            d.uid = Process.myUid();
            com.tencent.soter.core.a.a(Fii);
            com.tencent.mm.vending.g.g.O(Boolean.valueOf(z), Boolean.TRUE).e(new a()).e(new d()).e(new c()).e(new e()).a(new d.a<c<Integer, String>>() {
                /* class com.tencent.mm.plugin.soter.e.b.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.a
                public final /* synthetic */ void cn(c<Integer, String> cVar) {
                    AppMethodBeat.i(130876);
                    c<Integer, String> cVar2 = cVar;
                    int intValue = ((Integer) cVar2.get(0)).intValue();
                    String str = (String) cVar2.get(1);
                    Log.e("MicroMsg.SoterInitManager", "alvinluo onInterrupt errCode: %d, errMsg: %s", Integer.valueOf(intValue), str);
                    if (gVar != null) {
                        gVar.bg(intValue, str);
                    }
                    AppMethodBeat.o(130876);
                }
            }).a(new d.b<Boolean>() {
                /* class com.tencent.mm.plugin.soter.e.b.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.b
                public final /* synthetic */ void bz(Boolean bool) {
                    AppMethodBeat.i(130875);
                    Log.i("MicroMsg.SoterInitManager", "alvinluo onTerminate");
                    Log.i("MicroMsg.SoterInitManager", "alvinluo init takes %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (gVar != null) {
                        gVar.bg(0, "");
                    }
                    AppMethodBeat.o(130875);
                }
            });
            AppMethodBeat.o(130877);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SoterInitManager", e2, "alvinluo exception when init soter: %s", e2.getMessage());
            com.tencent.mm.plugin.soter.d.a.n(4, 1001, 1);
            gVar.bg(-1, "system error");
            AppMethodBeat.o(130877);
        }
    }

    public static boolean flW() {
        AppMethodBeat.i(130878);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference == null) {
            AppMethodBeat.o(130878);
            return false;
        }
        boolean z = defaultPreference.getBoolean("init_success", false);
        AppMethodBeat.o(130878);
        return z;
    }

    public static boolean flX() {
        if (Build.VERSION.SDK_INT < 28 || Fig || Fih != 2) {
            return false;
        }
        return true;
    }
}
