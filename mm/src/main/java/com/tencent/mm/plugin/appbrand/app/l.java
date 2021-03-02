package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.e;
import java.util.List;

class l implements j {
    l() {
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j
    public e<Integer> UK(final String str) {
        AppMethodBeat.i(44171);
        f<_Ret> b2 = g.hio().b(new a<Integer, Void>() {
            /* class com.tencent.mm.plugin.appbrand.app.l.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Integer call(Void r3) {
                AppMethodBeat.i(44167);
                Integer buv = buv();
                AppMethodBeat.o(44167);
                return buv;
            }

            private Integer buv() {
                AppMethodBeat.i(44166);
                if (!com.tencent.mm.kernel.g.aAf().azp()) {
                    com.tencent.mm.vending.g.g.hdx().ej(new b());
                    AppMethodBeat.o(44166);
                } else {
                    AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.aaA(str);
                    final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                    com.tencent.mm.kernel.g.aAg().hqi.a(1345, new i() {
                        /* class com.tencent.mm.plugin.appbrand.app.l.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(44165);
                            if (c.b(qVar, str)) {
                                com.tencent.mm.kernel.g.aAg().hqi.b(1345, this);
                                try {
                                    hdH.G(Integer.valueOf(c.e(qVar)));
                                    AppMethodBeat.o(44165);
                                    return;
                                } catch (Exception e2) {
                                    hdH.ej(e2);
                                }
                            }
                            AppMethodBeat.o(44165);
                        }
                    });
                    AppMethodBeat.o(44166);
                }
                return null;
            }
        });
        AppMethodBeat.o(44171);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j
    public void UL(String str) {
        AppMethodBeat.i(44172);
        h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WASERVICE, z.H5_JSAPI_PRELOAD);
        AppMethodBeat.o(44172);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j
    public void p(String str, String str2, int i2) {
        AppMethodBeat.i(44173);
        SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
        sendDataToMiniProgramFromH5Event.lWe = str;
        sendDataToMiniProgramFromH5Event.data = str2;
        sendDataToMiniProgramFromH5Event.lWf = i2;
        com.tencent.mm.plugin.appbrand.ipc.e.b(str, sendDataToMiniProgramFromH5Event);
        AppMethodBeat.o(44173);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j
    public void bc(List<String> list) {
        AppMethodBeat.i(44174);
        aa.a(list, o.a.MP_PRELOAD, (aa.d) null).a(new d.b<List<String>>() {
            /* class com.tencent.mm.plugin.appbrand.app.l.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.g.d.b
            public final /* synthetic */ void bz(List<String> list) {
                AppMethodBeat.i(226328);
                final List<String> list2 = list;
                if (list2 == null || list2.size() <= 0) {
                    AppMethodBeat.o(226328);
                    return;
                }
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.app.l.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(226327);
                        com.tencent.mm.plugin.appbrand.config.a.b bVar = (com.tencent.mm.plugin.appbrand.config.a.b) n.W(com.tencent.mm.plugin.appbrand.config.a.b.class);
                        if (bVar != null) {
                            bVar.br(list2);
                        }
                        AppMethodBeat.o(226327);
                    }
                });
                AppMethodBeat.o(226328);
            }
        });
        AppMethodBeat.o(44174);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j
    public final int buu() {
        AppMethodBeat.i(44175);
        ICommLibReader bvT = at.bvT();
        if (bvT == null) {
            try {
                as.bvS();
                bvT = at.bvT();
            } catch (b e2) {
                AppMethodBeat.o(44175);
                return -1;
            }
        }
        if (bvT == null) {
            AppMethodBeat.o(44175);
            return -1;
        }
        int bvd = bvT.bvd();
        AppMethodBeat.o(44175);
        return bvd;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j
    public void cr(final String str, final String str2) {
        AppMethodBeat.i(44176);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage invalid uuid");
            AppMethodBeat.o(44176);
            return;
        }
        g.hio().h(new a<Void, Void>() {
            /* class com.tencent.mm.plugin.appbrand.app.l.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r3) {
                AppMethodBeat.i(226331);
                Void buw = buw();
                AppMethodBeat.o(226331);
                return buw;
            }

            private Void buw() {
                AppMethodBeat.i(226330);
                com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.act(str).aYI();
                try {
                    com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(str2);
                    com.tencent.mm.ab.i iVar2 = new com.tencent.mm.ab.i(iVar.optString("invokeData"));
                    String optString = iVar2.optString("miniprogramAppID");
                    if (TextUtils.isEmpty(optString)) {
                        Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
                        com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.acs(str).aYI();
                        Void r0 = QZL;
                        AppMethodBeat.o(226330);
                        return r0;
                    }
                    String optString2 = iVar2.optString("path", "__wx__/open-api-redirecting-page");
                    String optString3 = iVar2.optString("name");
                    String optString4 = iVar.optString("runtimeAppid");
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1111;
                    appBrandStatObject.dCw = optString4 + ":" + optString3;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.leo = 7;
                    appBrandLaunchReferrer.appId = null;
                    appBrandLaunchReferrer.ler = iVar2.toString();
                    LaunchParcel launchParcel = new LaunchParcel();
                    launchParcel.appId = optString;
                    launchParcel.kHw = optString2;
                    launchParcel.mYK = appBrandStatObject;
                    launchParcel.cys = appBrandLaunchReferrer;
                    launchParcel.mYN = new com.tencent.luggage.sdk.launching.a<ByRuntimeQrcodeResult>() {
                        /* class com.tencent.mm.plugin.appbrand.app.l.AnonymousClass3.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Parcelable] */
                        @Override // com.tencent.luggage.sdk.launching.a
                        public final /* synthetic */ void b(ByRuntimeQrcodeResult byRuntimeQrcodeResult) {
                            AppMethodBeat.i(226329);
                            ByRuntimeQrcodeResult byRuntimeQrcodeResult2 = byRuntimeQrcodeResult;
                            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.em(str, byRuntimeQrcodeResult2 == null ? "{}" : byRuntimeQrcodeResult2.bua()).aYI();
                            AppMethodBeat.o(226329);
                        }
                    };
                    com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(MMApplicationContext.getContext(), launchParcel);
                    Void r02 = QZL;
                    AppMethodBeat.o(226330);
                    return r02;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", e2, str, str2);
                    com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.acs(str).aYI();
                }
            }
        }).hdy();
        AppMethodBeat.o(44176);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j
    public void a(int i2, String str, Object obj) {
    }
}
