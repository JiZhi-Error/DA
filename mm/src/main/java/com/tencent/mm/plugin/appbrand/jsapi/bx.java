package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class bx extends d<k> {
    public static final int CTRL_INDEX = 643;
    public static final String NAME = "openWCCertHomePage";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45576);
        k kVar2 = kVar;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(45576);
            return;
        }
        c.b(castActivityOrNull, "card", ".ui.v2.CardTicketListUI", new Intent());
        kVar2.i(i2, h("ok", null));
        AppMethodBeat.o(45576);
    }
}
