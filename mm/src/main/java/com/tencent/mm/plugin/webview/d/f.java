package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "", "context", "Landroid/content/Context;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getContext", "()Landroid/content/Context;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getWv", "()Lcom/tencent/mm/ui/widget/MMWebView;", "hasPermission", "", "controlByte", "", "webview-sdk_release"})
public final class f {
    final JsapiPermissionWrapper IBv;
    public final h IQZ;
    public final MMWebView IRa;
    public final Context context;
    public final e mHh;

    public f(Context context2, JsapiPermissionWrapper jsapiPermissionWrapper, e eVar, h hVar, MMWebView mMWebView) {
        p.h(context2, "context");
        p.h(jsapiPermissionWrapper, "jsPerm");
        p.h(hVar, "jsApiHandler");
        AppMethodBeat.i(225102);
        this.context = context2;
        this.IBv = jsapiPermissionWrapper;
        this.mHh = eVar;
        this.IQZ = hVar;
        this.IRa = mMWebView;
        AppMethodBeat.o(225102);
    }
}
