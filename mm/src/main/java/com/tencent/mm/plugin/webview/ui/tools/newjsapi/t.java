package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSaveWaid;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class t extends a {
    private static final int CDJ = CDJ;
    public static final t JxK = new t();
    private static final String TAG = TAG;
    private static final String edq = "saveWaid";

    static {
        AppMethodBeat.i(175689);
        AppMethodBeat.o(175689);
    }

    private t() {
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
        AppMethodBeat.i(210666);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        HashMap hashMap = new HashMap();
        try {
            Log.i(TAG, "h5 JsApiSaveWaid");
            p.g(nVar.ISf.toString(), "msg.rawParams.toString()");
            hashMap.put("result", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", hashMap);
            AppMethodBeat.o(210666);
            return true;
        } catch (Exception e2) {
            Log.e(TAG, "h5 JsApiSaveWaid exp=".concat(String.valueOf(e2)));
            hashMap.put("result", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", hashMap);
            AppMethodBeat.o(210666);
            return false;
        }
    }
}
