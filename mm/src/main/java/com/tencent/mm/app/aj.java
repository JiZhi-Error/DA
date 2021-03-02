package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.f;
import com.tencent.mm.splash.m;
import com.tencent.mm.xlog.app.XLogSetup;

public final class aj {
    public static h dmN;

    private static void WT() {
        AppMethodBeat.i(160060);
        com.tencent.mm.splash.h.a(new c() {
            /* class com.tencent.mm.app.aj.AnonymousClass1 */

            @Override // com.tencent.mm.splash.c
            public final void a(Throwable th, String str) {
                AppMethodBeat.i(160029);
                Log.printErrStackTrace("WxSplash.WeChatSplash", th, str, new Object[0]);
                if (str == null) {
                    str = "";
                }
                com.tencent.mm.splash.h.gyq().NMC.add(str + "  " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(160029);
            }

            @Override // com.tencent.mm.splash.c
            public final void c(String str, String str2, Object... objArr) {
                AppMethodBeat.i(160030);
                Log.i(str, str2, objArr);
                AppMethodBeat.o(160030);
            }

            @Override // com.tencent.mm.splash.c
            public final void r(Activity activity) {
                AppMethodBeat.i(160028);
                if (aj.dmN != null && aj.dmN.aBb()) {
                    SharedPreferences sharedPreferences = activity.getSharedPreferences("system_config_prefs", g.aps());
                    if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                        sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                        XLogSetup.realSetupXlog();
                    }
                }
                AppMethodBeat.o(160028);
            }
        });
        com.tencent.mm.splash.h.a(new b() {
            /* class com.tencent.mm.app.aj.AnonymousClass2 */

            @Override // com.tencent.mm.splash.b
            public final boolean bR(Context context) {
                AppMethodBeat.i(160072);
                boolean cc = a.cc(context);
                AppMethodBeat.o(160072);
                return cc;
            }

            @Override // com.tencent.mm.splash.b
            public final boolean bS(Context context) {
                AppMethodBeat.i(160073);
                boolean bS = a.bS(context);
                AppMethodBeat.o(160073);
                return bS;
            }

            @Override // com.tencent.mm.splash.b
            public final void bT(Context context) {
                AppMethodBeat.i(160074);
                a.bT(context);
                AppMethodBeat.o(160074);
            }
        });
        com.tencent.mm.splash.h.a(new f() {
            /* class com.tencent.mm.app.aj.AnonymousClass3 */

            @Override // com.tencent.mm.splash.f
            public final void WU() {
                AppMethodBeat.i(160085);
                com.tencent.mm.blink.a.WU();
                AppMethodBeat.o(160085);
            }

            @Override // com.tencent.mm.splash.f
            public final void gn(String str) {
                AppMethodBeat.i(160086);
                com.tencent.mm.blink.a.gn(str);
                AppMethodBeat.o(160086);
            }

            @Override // com.tencent.mm.splash.f
            public final void WV() {
                AppMethodBeat.i(160087);
                com.tencent.mm.blink.a.nO(1);
                AppMethodBeat.o(160087);
            }
        });
        AppMethodBeat.o(160060);
    }

    public static void a(h hVar, String str) {
        AppMethodBeat.i(160061);
        dmN = hVar;
        WT();
        if (str == null) {
            Log.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
            AppMethodBeat.o(160061);
            return;
        }
        com.tencent.mm.blink.a.u(hVar.htz.getApplicationStartMillisTime(), hVar.htz.getApplicationStartElapsedTime());
        com.tencent.mm.splash.h.bil(MMApplicationContext.getLaunchName());
        com.tencent.mm.splash.h.bb(WeChatSplashActivity.class);
        com.tencent.mm.splash.h.bc(WeChatSplashFallbackActivity.class);
        if (!com.tencent.mm.plugin.fcm.a.fj(hVar.ca)) {
            com.tencent.mm.splash.h.bik("com.google.firebase.provider.FirebaseInitProvider");
        }
        m.a(hVar.ca, hVar.mProcessName, str);
        AppMethodBeat.o(160061);
    }
}
