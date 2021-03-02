package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f extends JsApiShareAppMessageBase<a> {
    public static final int CTRL_INDEX = 589;
    public static final String NAME = "shareAppMessageForFakeNative";

    /* Return type fixed from 'com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase$d' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public /* synthetic */ a a(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(174914);
        a b2 = b(cVar, jSONObject);
        AppMethodBeat.o(174914);
        return b2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase$d, com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask, java.lang.String] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final /* synthetic */ Map a(a aVar, SendAppMessageTask sendAppMessageTask, String str) {
        AppMethodBeat.i(174911);
        Map<String, Object> a2 = super.a(aVar, sendAppMessageTask, str);
        if (a2 == null) {
            a2 = new HashMap<>(1);
        }
        a2.put("shareUsrs", Util.stringsToList(str.split(",")));
        AppMethodBeat.o(174911);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Intent, com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase$d] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final /* synthetic */ void a(Intent intent, a aVar) {
        AppMethodBeat.i(174913);
        super.a(intent, aVar);
        intent.putExtra("select_is_ret", false);
        AppMethodBeat.o(174913);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask, java.lang.String, java.lang.String, boolean, com.tencent.mm.plugin.appbrand.service.c, com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase$d] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final /* bridge */ /* synthetic */ void a(SendAppMessageTask sendAppMessageTask, String str, String str2, boolean z, c cVar, a aVar) {
        AppMethodBeat.i(180266);
        a aVar2 = aVar;
        super.a(sendAppMessageTask, str, str2, z, cVar, aVar2);
        if (sendAppMessageTask.msi == 1) {
            sendAppMessageTask.msi = 2;
            sendAppMessageTask.fuQ = aVar2.mrG;
            sendAppMessageTask.msh = aVar2.mrH;
        }
        sendAppMessageTask.mrI = aVar2.mrI;
        sendAppMessageTask.mrJ = aVar2.mrJ;
        AppMethodBeat.o(180266);
    }

    /* access modifiers changed from: package-private */
    public static class a extends JsApiShareAppMessageBase.d {
        public int mrG;
        public String mrH;
        public String mrI;
        public String mrJ;

        a() {
        }
    }

    /* access modifiers changed from: protected */
    public a b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(174910);
        a aVar = (a) super.a(cVar, jSONObject);
        aVar.mrG = jSONObject.optInt("bizType", k.a.BUSINESS_MAX.ordinal());
        if (!k.a.isValid(aVar.mrG)) {
            Log.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
            JsApiShareAppMessageBase.c cVar2 = new JsApiShareAppMessageBase.c("biz is invalid");
            AppMethodBeat.o(174910);
            throw cVar2;
        }
        String optString = jSONObject.optString("defaultHintUrl");
        if (Util.isNullOrNil(optString)) {
            optString = w.Ur(cVar.getAppId());
        }
        aVar.lho = optString;
        aVar.mrH = jSONObject.optString("tailLang", "");
        aVar.mrI = jSONObject.optString("bizSourceName", "");
        aVar.mrJ = jSONObject.optString("bizSourceIconUrl", "");
        aVar.mrv.put("biz", Integer.valueOf(aVar.mrG));
        aVar.mrv.put("tail_lang", aVar.mrH);
        aVar.mrv.put("icon_url", aVar.mrj.jyi);
        aVar.mrv.put("nickname", aVar.mrj.brandName);
        AppMethodBeat.o(174910);
        return aVar;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase$d' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final /* synthetic */ a bIJ() {
        AppMethodBeat.i(174915);
        a aVar = new a();
        AppMethodBeat.o(174915);
        return aVar;
    }
}
