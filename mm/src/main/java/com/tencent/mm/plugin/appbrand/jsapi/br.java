package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class br extends d<d> {
    public static final int CTRL_INDEX = 925;
    public static final String NAME = "requestOfflineUserBindQuery";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226678);
        final d dVar2 = dVar;
        Log.i("MicroMsg.JsApiOfflineUserBindQuery", "invoke JsApiOfflineUserBindQuery! data is ：%s", jSONObject.toString());
        if (dVar2 == null) {
            Log.e("MicroMsg.JsApiOfflineUserBindQuery", "fail:component is null");
            AppMethodBeat.o(226678);
        } else if (dVar2.getContext() == null) {
            Log.e("MicroMsg.JsApiOfflineUserBindQuery", "fail:context is null");
            dVar2.i(i2, h("fail:context is null", null));
            AppMethodBeat.o(226678);
        } else {
            AppBrandInitConfig OU = dVar2.getRuntime().OU();
            String str = OU.appId;
            String str2 = OU.brandName;
            String currentUrl = dVar2.getRuntime().brh().getCurrentUrl();
            String optString = jSONObject.optString("nonceStr");
            String optString2 = jSONObject.optString("timeStamp");
            String optString3 = jSONObject.optString("paySign");
            String optString4 = jSONObject.optString("signType");
            String optString5 = jSONObject.optString("package");
            Bundle bundle = new Bundle();
            bundle.putString("appId", str);
            bundle.putString("appName", str2);
            bundle.putString("appPath", currentUrl);
            bundle.putString("nonceStr", optString);
            bundle.putString("timeStamp", optString2);
            bundle.putString("paySign", optString3);
            bundle.putString("signType", optString4);
            bundle.putString("packageInfo", optString5);
            h.a(MainProcessIPCService.dkO, bundle, a.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.br.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(226675);
                    Bundle bundle2 = bundle;
                    if (bundle2 != null) {
                        String string = bundle2.getString("errMsg", "");
                        Log.i("MicroMsg.JsApiOfflineUserBindQuery", "onCallback，result ：%s", string);
                        dVar2.i(i2, br.this.h(string, null));
                        AppMethodBeat.o(226675);
                        return;
                    }
                    Log.i("MicroMsg.JsApiOfflineUserBindQuery", "onCallback，data == null");
                    dVar2.i(i2, br.this.h("fail", null));
                    AppMethodBeat.o(226675);
                }
            });
            AppMethodBeat.o(226678);
        }
    }

    static class a implements b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            JSONObject optJSONObject;
            AppMethodBeat.i(226677);
            Bundle bundle2 = bundle;
            final Bundle bundle3 = new Bundle();
            if (bundle2 != null) {
                Log.i("MicroMsg.IPCLoadPayOfflineUserBindQuery", "data != null");
                final lc lcVar = new lc();
                lcVar.dQg.appId = bundle2.getString("appId", "");
                lcVar.dQg.appName = bundle2.getString("appName", "");
                lcVar.dQg.dQi = bundle2.getString("appPath", "");
                lcVar.dQg.nonceStr = bundle2.getString("nonceStr");
                lcVar.dQg.timeStamp = bundle2.getString("timeStamp");
                lcVar.dQg.dQk = bundle2.getString("paySign");
                lcVar.dQg.signType = bundle2.getString("signType");
                lcVar.dQg.dQj = bundle2.getString("packageInfo");
                String string = bundle2.getString("packageInfo");
                if (Util.isNullOrNil(string)) {
                    Log.e("MicroMsg.IPCLoadPayOfflineUserBindQuery", "fail:packageInfo is null");
                    if (dVar != null) {
                        bundle3.putString("errMsg", "fail:packageInfo is null");
                        dVar.bn(bundle3);
                    }
                    AppMethodBeat.o(226677);
                    return;
                }
                String[] split = string.split("=");
                if (!Util.isNullOrNil(split[1])) {
                    try {
                        JSONArray optJSONArray = new JSONObject(split[1]).optJSONArray("busi_data");
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                                if (!(jSONObject == null || (optJSONObject = jSONObject.optJSONObject("new_card_info")) == null)) {
                                    lcVar.dQg.dQl = optJSONObject.optString("bank_type");
                                    lcVar.dQg.dQm = optJSONObject.optString("bind_serial");
                                    lcVar.dQg.dQn = optJSONObject.optString("open_success");
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.IPCLoadPayOfflineUserBindQuery", "parseTextViewData Exception:%s", e2.getMessage());
                    }
                }
                lcVar.dQg.callback = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.br.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(226676);
                        Log.i("MicroMsg.IPCLoadPayOfflineUserBindQuery", "event.data.callback，result ：%s", lcVar.dQh.errMsg);
                        bundle3.putString("errMsg", lcVar.dQh.errMsg);
                        dVar.bn(bundle3);
                        AppMethodBeat.o(226676);
                    }
                };
                EventCenter.instance.publish(lcVar);
                AppMethodBeat.o(226677);
                return;
            }
            Log.i("MicroMsg.IPCLoadPayOfflineUserBindQuery", "data is null");
            if (dVar != null) {
                bundle3.putString("errMsg", "fail:IPCLoadPayOfflineUserBindQuery data is null");
                dVar.bn(bundle3);
            }
            AppMethodBeat.o(226677);
        }
    }
}
