package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import java.util.HashMap;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
public final class a extends s {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onInitialRenderingCacheReady";
    public static final C0706a moV = new C0706a((byte) 0);

    static {
        AppMethodBeat.i(147955);
        AppMethodBeat.o(147955);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatchReady", "", "content", "webviewData", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.v.a$a  reason: collision with other inner class name */
    public static final class C0706a {
        private C0706a() {
        }

        public /* synthetic */ C0706a(byte b2) {
            this();
        }
    }

    public static final void a(String str, String str2, ac acVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        AppMethodBeat.i(147956);
        if (str == null) {
            AppMethodBeat.o(147956);
        } else if (acVar == null) {
            AppMethodBeat.o(147956);
        } else {
            String str3 = str2;
            if (!(str3 == null || str3.length() == 0)) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e2) {
                    jSONObject = null;
                }
                jSONObject2 = jSONObject;
            }
            s g2 = new a().g(acVar);
            HashMap hashMap = new HashMap();
            hashMap.put("content", str);
            hashMap.put("webviewData", jSONObject2);
            hashMap.put("path", acVar.getURL());
            g2.L(hashMap).bEo();
            AppMethodBeat.o(147956);
        }
    }
}
