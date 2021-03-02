package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetRandomValues;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class bm extends d<s> {
    public static final int CTRL_INDEX = 916;
    public static final String NAME = "getRandomValues";
    public static final a lzH = new a((byte) 0);

    static {
        AppMethodBeat.i(228285);
        AppMethodBeat.o(228285);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetRandomValues$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        int i3 = -1;
        AppMethodBeat.i(228284);
        s sVar2 = sVar;
        if (sVar2 != null) {
            if (jSONObject != null) {
                i3 = jSONObject.optInt("length", -1);
            }
            if (i3 <= 0) {
                sVar2.i(i2, Zf("fail: illegal length"));
                AppMethodBeat.o(228284);
                return;
            }
            byte[] bArr = new byte[i3];
            new SecureRandom().nextBytes(bArr);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ByteBuffer aP = x.aP(bArr);
            p.g(aP, "NativeBufferUtil.wrapDirectByteBuffer(byteArray)");
            linkedHashMap.put("randomValues", aP);
            if (x.b.FAIL_SIZE_EXCEED_LIMIT == x.a(sVar2.getJsRuntime(), linkedHashMap, (x.a) sVar2.av(x.a.class))) {
                sVar2.i(i2, Zf("fail: internal error"));
                Log.w("MicroMsg.JsApiGetRandomValues", "invoke, convert NativeBuffer fail");
                AppMethodBeat.o(228284);
                return;
            }
            sVar2.i(i2, n("ok", linkedHashMap));
        }
        AppMethodBeat.o(228284);
    }
}
