package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ar extends d<f> {
    public static final int CTRL_INDEX = 875;
    public static final String NAME = "bindGroup";
    public static final a lyK = new a((byte) 0);

    static {
        AppMethodBeat.i(228273);
        AppMethodBeat.o(228273);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppBindGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        String str;
        String str2 = null;
        AppMethodBeat.i(228272);
        String appId = fVar != null ? fVar.getAppId() : null;
        String str3 = appId;
        if (!(str3 == null || str3.length() == 0)) {
            String optString = jSONObject != null ? jSONObject.optString("signature") : null;
            if (jSONObject != null) {
                str = jSONObject.optString("groupId");
            } else {
                str = null;
            }
            if (jSONObject != null) {
                str2 = jSONObject.optString("nonceStr");
            }
            c.b bVar = new c.b();
            bVar.appId = appId;
            bVar.signature = optString;
            bVar.zpX = str;
            bVar.zpY = str2;
            ((c) g.af(c.class)).a(fVar.getContext(), bVar, new b(this, fVar, i2));
            AppMethodBeat.o(228272);
        } else if (fVar != null) {
            fVar.i(i2, Zf("fail:appId is null"));
            AppMethodBeat.o(228272);
        } else {
            AppMethodBeat.o(228272);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "success", "", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "groupOpenId", "onDealEnd"})
    static final class b implements c.a {
        final /* synthetic */ ar lyL;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        b(ar arVar, f fVar, int i2) {
            this.lyL = arVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.c.a
        public final void a(boolean z, String str, String str2) {
            AppMethodBeat.i(228271);
            if (z) {
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("openId", str2);
                    f fVar = this.lyn;
                    if (fVar != null) {
                        fVar.i(this.lyo, this.lyL.n("ok", hashMap));
                        AppMethodBeat.o(228271);
                        return;
                    }
                    AppMethodBeat.o(228271);
                    return;
                }
            }
            f fVar2 = this.lyn;
            if (fVar2 != null) {
                fVar2.i(this.lyo, this.lyL.Zf("fail"));
                AppMethodBeat.o(228271);
                return;
            }
            AppMethodBeat.o(228271);
        }
    }
}
