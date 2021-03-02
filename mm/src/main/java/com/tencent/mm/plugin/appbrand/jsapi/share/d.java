package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d extends JsApiShareAppMessageBase<JsApiShareAppMessageBase.d> {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final JsApiShareAppMessageBase.d a(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(174884);
        JsApiShareAppMessageBase.d a2 = super.a(cVar, jSONObject);
        ad.b bVar = a2.mri.yK(u.ShareAppMsg.ordinal()).lEi;
        ad.b bVar2 = a2.mri.yK(u.ShareToWork.ordinal()).lEi;
        if (bVar.JY("user_clicked_share_btn") || bVar2.JY("user_clicked_share_btn")) {
            bVar.H("user_clicked_share_btn", false);
            bVar2.H("user_clicked_share_btn", false);
            AppMethodBeat.o(174884);
            return a2;
        }
        JsApiShareAppMessageBase.c cVar2 = new JsApiShareAppMessageBase.c("not allow to share");
        AppMethodBeat.o(174884);
        throw cVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final void a(JsApiShareAppMessageBase.d dVar, int i2) {
        AppMethodBeat.i(174885);
        super.a(dVar, i2);
        a(dVar.appId, dVar.dCx, dVar.withShareTicket ? 16 : 2, "", 3, i2);
        AppMethodBeat.o(174885);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final void a(JsApiShareAppMessageBase.d dVar) {
        int i2;
        AppMethodBeat.i(174886);
        super.a(dVar);
        if (dVar.withShareTicket) {
            i2 = 16;
        } else {
            i2 = 2;
        }
        a(dVar.appId, dVar.dCx, i2, "", 2, -1);
        AppMethodBeat.o(174886);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final void a(boolean z, JsApiShareAppMessageBase.d dVar, String str) {
        AppMethodBeat.i(174887);
        super.a(z, dVar, str);
        if (z) {
            int i2 = 16;
            String str2 = str + ":";
            if (str.toLowerCase().endsWith("@chatroom")) {
                i2 = 15;
            }
            a(dVar.appId, dVar.dCx, i2, str2, 1, -1);
        } else {
            int i3 = 2;
            if (str.toLowerCase().endsWith("@chatroom")) {
                i3 = 9;
            }
            a(dVar.appId, dVar.dCx, i3, "", 1, -1);
        }
        dVar.mrm.b(dVar);
        AppMethodBeat.o(174887);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final JsApiShareAppMessageBase.d bIJ() {
        AppMethodBeat.i(174888);
        JsApiShareAppMessageBase.d dVar = new JsApiShareAppMessageBase.d();
        AppMethodBeat.o(174888);
        return dVar;
    }

    private static void a(String str, String str2, int i2, String str3, int i3, int i4) {
        AppMethodBeat.i(174889);
        i.a(str, str2, i2, str3, Util.nowSecond(), i3, i4);
        AppMethodBeat.o(174889);
    }
}
