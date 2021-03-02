package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0005H\u0007¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"})
public final class ac {
    public static final ac lhm = new ac();

    static {
        AppMethodBeat.i(179493);
        AppMethodBeat.o(179493);
    }

    private ac() {
    }

    public static final WxaAttributes.WxaVersionInfo XM(String str) {
        boolean z;
        AppMethodBeat.i(179492);
        try {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                AppMethodBeat.o(179492);
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            WxaAttributes.WxaVersionInfo wxaVersionInfo = new WxaAttributes.WxaVersionInfo();
            wxaVersionInfo.appVersion = 0;
            wxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.XK(jSONObject.optString("module_list"));
            wxaVersionInfo.jmL = WxaAttributes.WxaWidgetInfo.XL(jSONObject.optString("widget_list"));
            if (!Util.isNullOrNil(wxaVersionInfo.moduleList)) {
                z = true;
            } else {
                z = false;
            }
            wxaVersionInfo.lgX = z;
            wxaVersionInfo.lgY = wxaVersionInfo.lgX ? jSONObject.optString("entrance_module") : "";
            wxaVersionInfo.lgV = WxaAttributes.WxaPluginCodeInfo.a(wxaVersionInfo.jmL, jSONObject.optString("separated_plugin_list"), 22);
            wxaVersionInfo.lgZ = jSONObject.optString("client_js_ext_info");
            AppMethodBeat.o(179492);
            return wxaVersionInfo;
        } catch (JSONException e2) {
            AppMethodBeat.o(179492);
            return null;
        }
    }
}
