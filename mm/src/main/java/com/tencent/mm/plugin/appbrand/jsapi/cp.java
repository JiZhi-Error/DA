package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiReturnCopyUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class cp extends d<d> {
    public static final int CTRL_INDEX = 755;
    public static final String NAME = "returnCopyUrl";
    public static final a lBH = new a((byte) 0);

    static {
        AppMethodBeat.i(169555);
        AppMethodBeat.o(169555);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiReturnCopyUrl$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        String str;
        boolean z;
        String str2;
        AppMethodBeat.i(169554);
        d dVar2 = dVar;
        if (dVar2 != null) {
            if (jSONObject == null || (str = jSONObject.optString("url")) == null) {
                str = "";
            }
            if (jSONObject == null || !jSONObject.optBoolean("shortLinkEnable", false)) {
                da daVar = da.lCI;
                da.a(ad.PAGE_PATH, str);
            } else {
                da daVar2 = da.lCI;
                da.a(ad.MP_SHORT_LINK, str);
            }
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, str);
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str2 = "fail:empty url";
            } else {
                str2 = "ok";
            }
            dVar2.i(i2, Zf(str2));
            AppMethodBeat.o(169554);
            return;
        }
        AppMethodBeat.o(169554);
    }
}
