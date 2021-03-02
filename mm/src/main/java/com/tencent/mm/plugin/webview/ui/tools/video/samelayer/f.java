package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.n;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J,\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\b\u0001\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u0004\u0018\u00010!J\b\u0010\"\u001a\u0004\u0018\u00010\u0010J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\u0012\u0010%\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isSyncInvoke", "", "removeLifecycleListener", "Companion", "plugin-webview_release"})
public final class f implements com.tencent.luggage.xweb_ext.extendplugin.a {
    public static final a JxS = new a((byte) 0);
    private final n JsF;
    final com.tencent.mm.plugin.webview.d.f JxI;

    static {
        AppMethodBeat.i(210684);
        AppMethodBeat.o(210684);
    }

    public f(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        p.h(fVar, "env");
        p.h(nVar, "msg");
        AppMethodBeat.i(210683);
        this.JxI = fVar;
        this.JsF = nVar;
        AppMethodBeat.o(210683);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String getAppId() {
        return "";
    }

    public final String gid() {
        AppMethodBeat.i(210675);
        if (this.JsF.IRs == null || !this.JsF.IRs.containsKey("name")) {
            AppMethodBeat.o(210675);
            return null;
        }
        String str = (String) this.JsF.IRs.get("name");
        AppMethodBeat.o(210675);
        return str;
    }

    public final String getCurrentUrl() {
        AppMethodBeat.i(210676);
        String str = (String) this.JsF.params.get("url");
        AppMethodBeat.o(210676);
        return str;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final Context getContext() {
        return this.JxI.context;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final boolean Pr() {
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final JSONObject Ps() {
        AppMethodBeat.i(210677);
        JSONObject jSONObject = this.JsF.ISf;
        p.g(jSONObject, "msg.rawParams");
        AppMethodBeat.o(210677);
        return jSONObject;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String Pt() {
        AppMethodBeat.i(210678);
        String str = this.JsF.mhO;
        p.g(str, "msg.function");
        AppMethodBeat.o(210678);
        return str;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String dP(String str) {
        AppMethodBeat.i(210679);
        this.JxI.IQZ.h(this.JsF.ISe, this.JsF.mhO + ':' + str, null);
        AppMethodBeat.o(210679);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String f(String str, Map<String, ? extends Object> map) {
        AppMethodBeat.i(210680);
        this.JxI.IQZ.h(this.JsF.ISe, this.JsF.mhO + ':' + str, map);
        AppMethodBeat.o(210680);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final void a(a.AbstractC0188a aVar) {
        AppMethodBeat.i(210681);
        if (this.JxI.context instanceof d) {
            Context context = this.JxI.context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
                AppMethodBeat.o(210681);
                throw tVar;
            }
            ((d) context).c(aVar);
        }
        AppMethodBeat.o(210681);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final void Pu() {
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final void b(a.AbstractC0188a aVar) {
        AppMethodBeat.i(210682);
        if ((this.JxI.context instanceof d) && aVar != null) {
            Context context = this.JxI.context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
                AppMethodBeat.o(210682);
                throw tVar;
            }
            ((d) context).d(aVar);
        }
        AppMethodBeat.o(210682);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final com.tencent.mm.plugin.appbrand.jsapi.f NN() {
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
