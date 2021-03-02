package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class ab extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "imagePreview";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    static class a implements b<IPCString, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<Bundle> dVar) {
            String str;
            AppMethodBeat.i(78564);
            JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(iPCString.value);
            Bundle bundle = new Bundle();
            if (Zc == null) {
                dVar.bn(bundle);
            }
            String optString = Zc.optString("current");
            JSONArray optJSONArray = Zc.optJSONArray("urls");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
                dVar.bn(bundle);
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString2 = optJSONArray.optString(i2);
                if (Util.isNullOrNil(optString2) || optString2.equalsIgnoreCase(BuildConfig.COMMAND)) {
                    Log.e("MicroMsg.JsApiImagePreview", "null url, i = %d", Integer.valueOf(i2));
                } else {
                    if (Util.nullAsNil(optString2).startsWith("weixin://resourceid/")) {
                        WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(optString2);
                        if (aYO != null) {
                            optString2 = aYO.laR;
                        }
                    }
                    arrayList.add(optString2);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (Util.isNullOrNil(optString)) {
                str = strArr[0];
            } else if (optString.startsWith("weixin://resourceid/")) {
                WebViewJSSDKFileItem aYO2 = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(optString);
                str = aYO2 != null ? aYO2.laR : "";
            } else {
                str = optString;
            }
            bundle.putString("nowUrl", str);
            bundle.putStringArray("urlList", strArr);
            dVar.bn(bundle);
            AppMethodBeat.o(78564);
        }
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final com.tencent.luggage.d.b<g>.a aVar) {
        AppMethodBeat.i(78565);
        final JSONObject jSONObject = aVar.ctb.csi;
        if (jSONObject == null) {
            aVar.c("invalid_params", null);
            AppMethodBeat.o(78565);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            Log.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
            aVar.c("invalid_url", null);
            AppMethodBeat.o(78565);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("current", jSONObject.optString("current"));
        j.a(hashMap, aVar.cta.ITd);
        h.a(MainProcessIPCService.dkO, new IPCString(jSONObject.toString()), a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.ab.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                float f2;
                JSONObject optJSONObject;
                AppMethodBeat.i(78563);
                Bundle bundle2 = bundle;
                String string = bundle2.getString("nowUrl");
                String[] stringArray = bundle2.getStringArray("urlList");
                if (stringArray == null || stringArray.length == 0) {
                    Log.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
                    aVar.c("invalid_url", null);
                    AppMethodBeat.o(78563);
                    return;
                }
                Intent intent = new Intent();
                String cookie = c.hsp().getCookie(aVar.cta.getUrl());
                if (!Util.isNullOrNil(cookie)) {
                    intent.putExtra("cookie", cookie);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("currentInfo");
                float d2 = ab.d(aVar);
                if (d2 <= 0.0f) {
                    f2 = com.tencent.mm.cb.a.getDensity(aVar.cta.mContext);
                } else {
                    f2 = d2;
                }
                String aZt = j.aZt(string);
                if (j.aZu(aZt)) {
                    intent.putExtra("nowUrlPath", aZt);
                }
                boolean isFullScreen = aVar.cta.isFullScreen();
                if (!(!j.gdD() || optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("pos")) == null)) {
                    int height = aVar.cta.gbC().getHeight();
                    int optDouble = (int) (optJSONObject.optDouble("width") * ((double) f2));
                    int optDouble2 = (int) (optJSONObject.optDouble("height") * ((double) f2));
                    int optDouble3 = (int) (optJSONObject.optDouble("x") * ((double) f2));
                    double optDouble4 = optJSONObject.optDouble("y") * ((double) f2);
                    if (isFullScreen) {
                        height = 0;
                    }
                    int i2 = (int) (optDouble4 + ((double) height));
                    intent.putExtra("img_gallery_width", optDouble).putExtra("img_gallery_height", optDouble2).putExtra("img_gallery_left", optDouble3).putExtra("img_gallery_top", i2);
                    int jo = com.tencent.mm.cb.a.jo(aVar.cta.mContext);
                    Log.d("MicroMsg.JsApiImagePreview", "doPreviewImg left %d, top %d, w %d, h %d, density %f,screenHeight %d", Integer.valueOf(optDouble3), Integer.valueOf(i2), Integer.valueOf(optDouble), Integer.valueOf(optDouble2), Float.valueOf(f2), Integer.valueOf(jo));
                    if (optDouble > 0 && optDouble2 > 0 && optDouble2 < jo) {
                        intent.putExtra("shouldRunDragAnimation", true);
                    }
                }
                intent.putExtra("forBidForward", aVar.ctb.csi.optInt("forbidForward", 0) == 1);
                intent.putExtra("nowUrl", string);
                intent.putExtra("urlList", stringArray);
                intent.putExtra("type", -255);
                intent.putExtra("isFromWebView", true);
                intent.putExtra("currentPos", jSONObject.optInt("currentPos", -1));
                com.tencent.mm.br.c.b(aVar.cta.mContext, "subapp", ".ui.gallery.GestureGalleryUI", intent);
                aVar.c("", null);
                AppMethodBeat.o(78563);
            }
        });
        AppMethodBeat.o(78565);
    }

    static /* synthetic */ float d(b.a aVar) {
        AppMethodBeat.i(182689);
        float gvp = (aVar.cta.ITd.getWebCoreType() != WebView.c.WV_KIND_CW || !XWalkEnvironment.getUsingCustomContext()) ? com.tencent.mm.cc.a.gvp() : aVar.cta.ITd.getResources().getDisplayMetrics().density;
        AppMethodBeat.o(182689);
        return gvp;
    }
}
