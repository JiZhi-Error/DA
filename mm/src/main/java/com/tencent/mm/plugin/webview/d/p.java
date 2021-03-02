package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", ProviderConstants.API_PATH, "support", "webview-sdk_release"})
public final class p implements e {
    private static Map<String, a> ISh = new HashMap();
    private static final g ISj = new g();
    public static final p ISk = new p();

    static {
        AppMethodBeat.i(225119);
        AppMethodBeat.o(225119);
    }

    private p() {
    }

    public static void bN(Map<String, a> map) {
        AppMethodBeat.i(225115);
        kotlin.g.b.p.h(map, "<set-?>");
        ISh = map;
        AppMethodBeat.o(225115);
    }

    @Override // com.tencent.mm.plugin.webview.d.e
    public final boolean b(f fVar, n nVar) {
        AppMethodBeat.i(225116);
        kotlin.g.b.p.h(fVar, "env");
        kotlin.g.b.p.h(nVar, "msg");
        boolean containsKey = ISh.containsKey(nVar.mhO);
        AppMethodBeat.o(225116);
        return containsKey;
    }

    @Override // com.tencent.mm.plugin.webview.d.e
    public final boolean a(f fVar, n nVar) {
        boolean z;
        AppMethodBeat.i(225117);
        kotlin.g.b.p.h(fVar, "env");
        kotlin.g.b.p.h(nVar, "msg");
        if (BuildInfo.DEBUG && 1 > Log.getLogLevel()) {
            Assert.assertTrue("handleMsg jsApis isEmpty", !ISh.isEmpty());
        }
        if (ISh.containsKey(nVar.mhO)) {
            a aVar = ISh.get(nVar.mhO);
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            a aVar2 = aVar;
            if (ISj.afT(aVar2.ePA())) {
                fVar.IQZ.h(nVar.ISe, "system:too_frequent", null);
                Context context = fVar.context;
                if (context instanceof b) {
                    ISj.S(aVar2.ePA(), aVar2.ePz(), ((b) context).fZM());
                }
                AppMethodBeat.o(225117);
                return true;
            }
            if (fVar.IBv.pP(aVar2.ePA())) {
                z = aVar2.a(fVar, nVar);
            } else {
                Log.e("MicroMsg.WebViewJsApiPool", "handleMsg access denied func: " + nVar.mhO);
                fVar.IQZ.h(nVar.ISe, "system:access_denied", null);
                z = false;
            }
            if (z || !Util.isEqual(aVar2.ePz(), "handleMPPageAction")) {
                if (r.aYp(nVar.mhO)) {
                    Context context2 = fVar.context;
                    if (context2 instanceof b) {
                        r.bd(((b) context2).coX(), ((b) context2).fZM(), ((b) context2).getIntent().getStringExtra("srcUsername"));
                    }
                }
                if (nVar == null) {
                    Log.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
                } else {
                    String str = nVar.mhO;
                    Map<String, Object> gbq = nVar.gbq();
                    Object obj = nVar.params.get("key_wxapp_id");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    String nullAs = Util.nullAs((String) obj, "");
                    if (gbq != null) {
                        gbq.put("isSuccess", Boolean.valueOf(z));
                        gbq.put("containerEnv", nullAs);
                    }
                    r.P(str, gbq);
                }
                AppMethodBeat.o(225117);
                return true;
            }
            AppMethodBeat.o(225117);
            return false;
        }
        AppMethodBeat.o(225117);
        return false;
    }

    public static a aYo(String str) {
        AppMethodBeat.i(225118);
        kotlin.g.b.p.h(str, "function");
        if (ISh.containsKey(str)) {
            a aVar = ISh.get(str);
            AppMethodBeat.o(225118);
            return aVar;
        }
        AppMethodBeat.o(225118);
        return null;
    }
}
