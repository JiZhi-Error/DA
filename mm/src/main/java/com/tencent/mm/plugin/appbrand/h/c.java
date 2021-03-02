package com.tencent.mm.plugin.appbrand.h;

import com.tencent.luggage.xweb_ext.extendplugin.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public abstract class c extends d {
    public abstract String bCy();

    public int H(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1;
        }
        return jSONObject.optInt("viewId", -1);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        i iVar;
        ac currentPageView;
        if (fVar == null) {
            Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
            return;
        }
        int H = H(jSONObject);
        if (H == -1) {
            Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
            fVar.i(i2, h("fail:no viewId in data", null));
            return;
        }
        if (fVar instanceof ac) {
            iVar = fVar.getJsRuntime();
        } else if (!(fVar instanceof s) || (currentPageView = ((s) fVar).getCurrentPageView()) == null) {
            iVar = null;
        } else {
            iVar = currentPageView.getJsRuntime();
        }
        if (!b(fVar, jSONObject, i2)) {
            b bVar = iVar == null ? null : (b) iVar.R(b.class);
            if (bVar == null) {
                Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
                fVar.i(i2, h("fail:invalid runtime", null));
                return;
            }
            com.tencent.luggage.xweb_ext.extendplugin.b.c webViewPluginClientProxy = bVar.getWebViewPluginClientProxy();
            if (webViewPluginClientProxy == null) {
                Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
                fVar.i(i2, h("fail:webview has no plugin client", null));
                return;
            }
            webViewPluginClientProxy.a(bCy(), H, new b(i2, jSONObject, fVar, this));
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(f fVar, JSONObject jSONObject, int i2) {
        return false;
    }
}
