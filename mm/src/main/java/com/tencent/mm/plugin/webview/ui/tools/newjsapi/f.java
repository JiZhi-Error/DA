package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiCurrentMpInfoShow;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class f extends a {
    private static final int CDJ = 346;
    public static final f Jxf = new f();
    private static final String TAG = TAG;
    private static final String edq = edq;

    static {
        AppMethodBeat.i(175682);
        AppMethodBeat.o(175682);
    }

    private f() {
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
    public final boolean a(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        AppMethodBeat.i(210586);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Context context = fVar.context;
        if ((context instanceof WebViewUI) && ((WebViewUI) context).ILE != null) {
            Bundle bundle = new Bundle();
            String str = (String) nVar.params.get("url");
            String str2 = (String) nVar.params.get("brandName");
            String str3 = (String) nVar.params.get("userName");
            Log.d(TAG, edq + " brandName=" + str2 + ", userName=" + str3);
            if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(str3)) {
                bundle.putString("key_brand_name", str2);
                bundle.putString("key_brand_user_name", str3);
                bundle.putString("key_url", str);
            }
            bundle.putBoolean("key_current_info_show", true);
            ((WebViewUI) context).ILE.bd(bundle);
        }
        fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
        AppMethodBeat.o(210586);
        return true;
    }
}
