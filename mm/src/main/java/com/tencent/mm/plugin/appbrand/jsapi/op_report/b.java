package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import org.json.JSONObject;

public final class b extends d<com.tencent.luggage.sdk.b.a.c.d> {
    private static final int CTRL_INDEX = 245;
    private static final String NAME = "reportPageData";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.luggage.sdk.b.a.c.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147211);
        final com.tencent.luggage.sdk.b.a.c.d dVar2 = dVar;
        AppBrandInitConfigLU ON = dVar2.NP().ON();
        AppBrandSysConfigLU OM = dVar2.NP().OM();
        AppBrandStatObject appBrandStatObject = dVar2.NP().ON().cyA;
        final String appId = dVar2.getAppId();
        dol dol = new dol();
        dol.MRN = new clh();
        if (OM != null) {
            dol.MRN.dNI = OM.appId;
            dol.MRN.username = ON.username;
            dol.MRN.MjZ = OM.leE.kNW;
            dol.MRN.KSa = OM.leE.pkgVersion;
            ICommLibReader bqZ = dVar2.bqZ();
            if (bqZ != null) {
                dol.MRN.MqF = bqZ.bvd();
            }
        }
        if (appBrandStatObject != null) {
            dol.MRN.Scene = appBrandStatObject.scene;
            dol.MRN.MqC = appBrandStatObject.ecU;
        }
        dol.MRN.MqD = 1;
        c Oq = dVar2.Oq();
        if (Oq != null) {
            dol.MRN.MqE = Oq.lBI;
        }
        dol.xuE = jSONObject.toString();
        ((com.tencent.mm.plugin.appbrand.networking.c) dVar2.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", dol, dom.class).c(new a<Object, dom>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.op_report.b.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(dom dom) {
                AppMethodBeat.i(147210);
                dom dom2 = dom;
                if (dom2 == null) {
                    Log.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, null response");
                    dVar2.i(i2, b.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147210);
                } else if (dom2.BaseResponse.Ret != 0) {
                    Log.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(dom2.BaseResponse.Ret), dom2.BaseResponse.ErrMsg);
                    dVar2.i(i2, b.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147210);
                } else {
                    AppBrandOpReportLogic.b.bM(appId, dom2.MRO);
                    dVar2.i(i2, b.this.h("ok", null));
                    AppMethodBeat.o(147210);
                }
                return null;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.op_report.b.AnonymousClass1 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(147209);
                Log.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, message = %s", obj);
                dVar2.i(i2, b.this.h("fail:cgi fail", null));
                AppMethodBeat.o(147209);
            }
        });
        AppMethodBeat.o(147211);
    }
}
