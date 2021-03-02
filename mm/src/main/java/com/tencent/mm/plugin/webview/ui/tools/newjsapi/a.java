package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.mm.plugin.webview.d.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0004H&J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getPluginType", "handleJsApi", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public abstract class a extends com.tencent.mm.plugin.webview.d.c.a {
    final String TAG = "MicroMsg.BasePluginJsApi";

    public abstract String bCy();

    public static c c(f fVar) {
        p.h(fVar, "env");
        if (!(fVar.context instanceof com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a)) {
            return null;
        }
        Context context = fVar.context;
        if (context != null) {
            return ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a) context).getWebViewPluginClientProxy();
        }
        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewExtendPluginClientProxy");
    }
}
