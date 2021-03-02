package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public class m extends j {
    public static final m mfl = new m();

    static {
        AppMethodBeat.i(46646);
        AppMethodBeat.o(46646);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j
    public boolean a(final d dVar, LaunchParcel launchParcel, final c.b bVar) {
        AppMethodBeat.i(46644);
        if (com.tencent.mm.model.gdpr.c.aXj()) {
            com.tencent.mm.model.gdpr.c.a(dVar.getContext(), a.MINI_PROGRAM, launchParcel.appId, new b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.m.AnonymousClass1 */

                @Override // com.tencent.mm.model.gdpr.b
                public final void sx(int i2) {
                    AppMethodBeat.i(46640);
                    if (i2 == 0) {
                        bVar.proceed();
                        AppMethodBeat.o(46640);
                        return;
                    }
                    bVar.cancel();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.m.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(46639);
                            com.tencent.mm.plugin.appbrand.widget.dialog.b bVar = new com.tencent.mm.plugin.appbrand.widget.dialog.b(dVar.getContext());
                            bVar.setTitle(R.string.a1h);
                            bVar.NIK.setVisibility(0);
                            bVar.NIC.setVisibility(0);
                            bVar.NIC.setText(R.string.a1g);
                            bVar.setCanceledOnTouchOutside(false);
                            bVar.a(R.string.x_, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.m.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(46638);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(46638);
                                }
                            });
                            dVar.getRuntime().jCK.b(bVar);
                            AppMethodBeat.o(46639);
                        }
                    });
                    AppMethodBeat.o(46640);
                }
            });
            AppMethodBeat.o(46644);
            return true;
        }
        AppMethodBeat.o(46644);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j
    public final com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(final d dVar, final LaunchParcel launchParcel, final JSONObject jSONObject) {
        AppMethodBeat.i(46645);
        if (dVar.getRuntime() == null || dVar.getRuntime().SO || dVar.getRuntime().isDestroyed()) {
            Log.e("MicroMsg.MiniProgramNavigatorWC", "prepareInitConfig but component not working, targetAppId:%s", launchParcel.appId);
            f ey = g.ey(null);
            AppMethodBeat.o(46645);
            return ey;
        }
        p.Un(dVar.getAppId()).kCT = launchParcel.appId;
        p.Un(dVar.getAppId()).kCU = launchParcel.kHw;
        String optString = jSONObject.optString("adUxInfo", null);
        if (!TextUtils.isEmpty(optString)) {
            if (launchParcel.ldQ == null) {
                launchParcel.ldQ = new PersistableBundle();
            }
            launchParcel.ldQ.putString("adUxInfo", optString);
        }
        com.tencent.mm.plugin.s.a.x("AppBrandRuntime", h.NAME, optString, "data");
        f<_Ret> b2 = g.hio().b(new com.tencent.mm.vending.c.a<AppBrandInitConfigLU, Void>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.m.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ AppBrandInitConfigLU call(Void r7) {
                AppMethodBeat.i(46642);
                final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                new AppBrandPreInitTask(dVar.getContext(), launchParcel, new AppBrandPreInitTask.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.m.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a
                    public final void a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
                        AppMethodBeat.i(226910);
                        if (appBrandInitConfigWC == null) {
                            hdH.G(null);
                            AppMethodBeat.o(226910);
                            return;
                        }
                        String optString = jSONObject.optString("adUxInfo", null);
                        if (!TextUtils.isEmpty(optString)) {
                            if (appBrandInitConfigWC.ldQ == null) {
                                appBrandInitConfigWC.ldQ = new PersistableBundle();
                            }
                            appBrandInitConfigWC.ldQ.putString("adUxInfo", optString);
                        }
                        hdH.G(appBrandInitConfigWC);
                        AppMethodBeat.o(226910);
                    }
                }).bNf();
                AppMethodBeat.o(46642);
                return null;
            }
        });
        AppMethodBeat.o(46645);
        return b2;
    }
}
