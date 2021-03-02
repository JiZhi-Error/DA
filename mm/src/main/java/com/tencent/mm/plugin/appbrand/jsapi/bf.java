package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetAppContact;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class bf extends d<s> {
    public static final int CTRL_INDEX = 927;
    public static final String NAME = "getAppContact";
    public static final a lzF = new a((byte) 0);

    static {
        AppMethodBeat.i(230062);
        AppMethodBeat.o(230062);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        boolean z;
        Object obj = null;
        AppMethodBeat.i(230061);
        s sVar2 = sVar;
        if (sVar2 == null) {
            AppMethodBeat.o(230061);
        } else if (jSONObject == null) {
            AppMethodBeat.o(230061);
        } else {
            String optString = jSONObject.optString("keyPath");
            Log.i("JsApiGetAppContact", "keyPath=".concat(String.valueOf(optString)));
            ab.bAu();
            WxaAttributes e2 = ab.e(sVar2.getAppId(), new String[0]);
            if (e2 != null) {
                p.g(optString, "keyPath");
                List<String> a2 = n.a(optString, new String[]{"."});
                try {
                    JSONObject jSONObject2 = new JSONObject(e2.bua());
                    Iterator<String> it = a2.iterator();
                    Object obj2 = null;
                    while (true) {
                        if (!it.hasNext()) {
                            obj = obj2;
                            break;
                        }
                        String next = it.next();
                        if (jSONObject2 == null) {
                            break;
                        }
                        if (jSONObject2.has(next)) {
                            obj2 = jSONObject2.opt(next);
                            if (obj2 == null) {
                                obj2 = "";
                            }
                        } else {
                            obj2 = null;
                        }
                        if (obj2 instanceof JSONObject) {
                            jSONObject2 = (JSONObject) obj2;
                        } else {
                            jSONObject2 = null;
                        }
                    }
                    StringBuilder sb = new StringBuilder("next=");
                    if (obj == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.i("JsApiGetAppContact", sb.append(z ? "is null" : String.valueOf(obj)).toString());
                    if (obj == null) {
                        sVar2.i(i2, Zf("fail: keyPath not found"));
                        AppMethodBeat.o(230061);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", obj);
                    sVar2.i(i2, n("ok", hashMap));
                    AppMethodBeat.o(230061);
                } catch (JSONException e3) {
                    Log.e("JsApiGetAppContact", e3.getMessage());
                    sVar2.i(i2, Zf("fail:internal error"));
                    AppMethodBeat.o(230061);
                }
            } else {
                AppMethodBeat.o(230061);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetAppContact$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
