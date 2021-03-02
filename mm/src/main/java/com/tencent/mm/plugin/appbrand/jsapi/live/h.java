package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends d {
    private static final int CTRL_INDEX = 361;
    public static final String NAME = "updateLivePusher";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145899);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.o(145899);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(145900);
        Log.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView : livePusherId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiUpdateLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145900);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (!(view2 instanceof AppBrandLivePusherView)) {
            Log.e("MicroMsg.JsApiUpdateLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.o(145900);
            return false;
        }
        final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) view2;
        if (jSONObject.has("filterImage")) {
            appBrandLivePusherView.cHp = jSONObject.optString("filterImage", appBrandLivePusherView.cHp);
            appBrandLivePusherView.cHq = jSONObject.optString("filterImageMd5", null);
            if (Util.isNullOrNil(appBrandLivePusherView.cHp)) {
                try {
                    jSONObject.put("filterImage", "");
                } catch (JSONException e2) {
                    Log.w("MicroMsg.JsApiUpdateLivePusher", "parseFilterImage, ignore exception:%s", e2);
                }
            } else if (appBrandLivePusherView.cHp.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || appBrandLivePusherView.cHp.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                jSONObject.remove("filterImage");
            }
        }
        appBrandLivePusherView.P(k.Z(jSONObject));
        try {
            if (jSONObject.has("backgroundImage")) {
                final String string = jSONObject.getString("backgroundImage");
                String optString = jSONObject.optString("backgroundMD5");
                if (Util.isNullOrNil(string)) {
                    Log.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, url is null");
                } else {
                    c.a(hVar, string, optString, new c.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.live.h.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                        public final void Wz(String str) {
                            AppMethodBeat.i(145897);
                            if (!Util.isNullOrNil(str)) {
                                String k = q.k(str, false);
                                Log.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", k);
                                Bundle bundle = new Bundle();
                                bundle.putString("backgroundImage", k);
                                appBrandLivePusherView.P(bundle);
                                AppMethodBeat.o(145897);
                                return;
                            }
                            Log.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("url", string);
                            appBrandLivePusherView.a(ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "load background image fail", hashMap);
                            AppMethodBeat.o(145897);
                        }
                    });
                }
            }
        } catch (JSONException e3) {
            Log.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "backgroundImage", e3.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("filterImage")) {
                final String string2 = jSONObject.getString("filterImage");
                if (Util.isNullOrNil(string2)) {
                    Log.i("MicroMsg.JsApiUpdateLivePusher", "convertFilterImageToLocalPath, url is null");
                } else {
                    c.a(hVar, string2, null, new c.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.live.h.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                        public final void Wz(String str) {
                            AppMethodBeat.i(145898);
                            if (!Util.isNullOrNil(str)) {
                                String k = q.k(str, false);
                                Log.i("MicroMsg.JsApiUpdateLivePusher", "convertFilterImageToLocalPath, targetPath:%s", k);
                                Bundle bundle = new Bundle();
                                bundle.putString("filterImage", k);
                                appBrandLivePusherView.P(bundle);
                                AppMethodBeat.o(145898);
                                return;
                            }
                            Log.i("MicroMsg.JsApiUpdateLivePusher", "convertFilterImageToLocalPath, load background image fail");
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("url", string2);
                            appBrandLivePusherView.a(10005, "load filter image fail", hashMap);
                            AppMethodBeat.o(145898);
                        }
                    });
                }
            }
        } catch (JSONException e4) {
            Log.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "filterImage", e4.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkImage")) {
                String string3 = jSONObject.getString("watermarkImage");
                String optString2 = jSONObject.optString("watermarkMD5");
                if (Util.isNullOrNil(string3)) {
                    Log.i("MicroMsg.JsApiUpdateLivePusher", "convertWatermarkImageToLocalPath, url is null");
                } else {
                    c.a(hVar, string3, optString2, new c.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.live.h.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                        public final void Wz(String str) {
                            AppMethodBeat.i(182555);
                            if (!Util.isNullOrNil(str)) {
                                String k = q.k(str, false);
                                Log.i("MicroMsg.JsApiUpdateLivePusher", "convertWatermarkImageToLocalPath, targetPath:%s", k);
                                Bundle bundle = new Bundle();
                                bundle.putString("watermarkImage", k);
                                appBrandLivePusherView.P(bundle);
                            }
                            AppMethodBeat.o(182555);
                        }
                    });
                }
            }
        } catch (JSONException e5) {
            Log.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "watermarkImage", e5.getLocalizedMessage());
        }
        AppMethodBeat.o(145900);
        return true;
    }
}
