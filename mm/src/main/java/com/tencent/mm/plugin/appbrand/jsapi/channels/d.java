package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "()V", NativeProtocol.WEB_DIALOG_ACTION, "", "getAction", "()Ljava/lang/String;", "isParamValid", "", "extInfoJsonObj", "Lorg/json/JSONObject;", "preProcessExtInfo", "Companion", "plugin-appbrand-integration_release"})
public final class d extends c {
    private static final int CTRL_INDEX = 968;
    private static final String NAME = "openChannelsLive";
    public static final a lRA = new a((byte) 0);

    static {
        AppMethodBeat.i(228390);
        AppMethodBeat.o(228390);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLive$Companion;", "", "()V", ShareConstants.ACTION, "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_COMMENT_SCENE", "PARAM_VALUE_COMMENT_SCENE", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.channels.c
    public final String getAction() {
        return "openFinderLive";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.channels.c
    public final boolean T(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(228388);
        p.h(jSONObject, "extInfoJsonObj");
        String optString = jSONObject.optString("feedId");
        p.g(optString, "extInfoJsonObj.optString(PARAM_KEY_FEED_ID)");
        if (optString.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String optString2 = jSONObject.optString("nonceId");
            p.g(optString2, "extInfoJsonObj.optString(PARAM_KEY_NONCE_ID)");
            if (optString2.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                AppMethodBeat.o(228388);
                return true;
            }
        }
        AppMethodBeat.o(228388);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.channels.c
    public final boolean U(JSONObject jSONObject) {
        boolean z;
        AppMethodBeat.i(228389);
        p.h(jSONObject, "extInfoJsonObj");
        try {
            jSONObject.put("feedID", jSONObject.optString("feedId"));
            jSONObject.put("nonceID", jSONObject.optString("nonceId"));
            jSONObject.put("commentScene", 15);
            z = true;
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLive", "preProcessExtInfo, fail since ".concat(String.valueOf(e2)));
            z = false;
        }
        AppMethodBeat.o(228389);
        return z;
    }
}
