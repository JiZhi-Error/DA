package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPhoneBindCardVerifySmsWeb;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = CDJ;
    public static final c JsB = new c();
    private static final String TAG = TAG;
    private static final String edq = "phoneBindCardVerifySms";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class a<T> implements d<Bundle> {
        final /* synthetic */ f CDE;
        final /* synthetic */ n pGr;

        a(f fVar, n nVar) {
            this.CDE = fVar;
            this.pGr = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Bundle bundle) {
            AppMethodBeat.i(210548);
            Bundle bundle2 = bundle;
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ':' + bundle2.getString("ret", "fail"), null);
            if (bundle2.getInt("closeWindow", 0) == 1 && (this.CDE.context instanceof WebViewUI)) {
                Context context = this.CDE.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                    AppMethodBeat.o(210548);
                    throw tVar;
                }
                ((WebViewUI) context).finish();
            }
            AppMethodBeat.o(210548);
        }
    }

    static {
        AppMethodBeat.i(210550);
        AppMethodBeat.o(210550);
    }

    private c() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(210549);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Log.i(TAG, "get data");
        Bundle bundle = new Bundle();
        bundle.putString("app_id", (String) nVar.params.get("appid"));
        bundle.putString("nonce_str", (String) nVar.params.get("noncestr"));
        bundle.putString("timeStamp", (String) nVar.params.get(AppMeasurement.Param.TIMESTAMP));
        bundle.putString("package", (String) nVar.params.get("package"));
        bundle.putString("signType", (String) nVar.params.get("signtype"));
        bundle.putString("paySign", (String) nVar.params.get("paysign"));
        bundle.putString("sessionid", (String) nVar.params.get("sessionid"));
        bundle.putString("jsapiName", "phoneBindCardVerifySms");
        bundle.putInt("jsapi_type", 0);
        h.a(MainProcessIPCService.dkO, bundle, IPCInvoke_KindaJSInvoke.class, new a(fVar, nVar));
        AppMethodBeat.o(210549);
        return true;
    }
}
