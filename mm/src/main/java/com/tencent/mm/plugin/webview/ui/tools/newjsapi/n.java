package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.ui.tools.video.a;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class n extends a {
    private static final int CDJ = CDJ;
    public static final n Jxy = new n();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(210625);
        AppMethodBeat.o(210625);
    }

    private n() {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.newjsapi.a
    public final String bCy() {
        return "video";
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
    public final boolean a(f fVar, com.tencent.mm.plugin.webview.d.n nVar) {
        c c2;
        Object obj;
        Object obj2;
        HashMap hashMap;
        boolean z = false;
        AppMethodBeat.i(210624);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str = (String) nVar.params.get(NativeProtocol.WEB_DIALOG_ACTION);
        Log.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", str);
        if (Util.isNullOrNil(str)) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail action is empty", null);
            AppMethodBeat.o(210624);
            return true;
        } else if (p.j("insertSameLayerVideo", str) || p.j("updateSameLayerVideo", str) || p.j("operateSameLayerVideo", str) || p.j("removeSameLayerVideo", str)) {
            if (!z.gsK()) {
                Log.e("MicroMsg.JsApiHandleVideoAction", "handleVideoAction not useSameLayerForVideo");
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail not support", null);
                AppMethodBeat.o(210624);
                return true;
            }
            p.h(fVar, "env");
            p.h(nVar, "msg");
            JSONObject jSONObject = nVar.ISf;
            if (jSONObject == null || !jSONObject.has("viewId")) {
                Log.w(this.TAG, "no viewId in data");
                fVar.IQZ.h(nVar.ISe, nVar.mhO + "fail:no viewId in data", null);
            } else {
                c c3 = a.c(fVar);
                if (c3 == null) {
                    Log.w(this.TAG, "webview has no plugin client");
                    fVar.IQZ.h(nVar.ISe, nVar.mhO + "fail:webview has no plugin client", null);
                } else {
                    c3.a(bCy(), jSONObject.optInt("viewId"), new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f(fVar, nVar));
                    z = true;
                }
            }
            if (p.j("removeSameLayerVideo", str) && nVar.ISf != null && nVar.ISf.has("viewId") && (c2 = c(fVar)) != null) {
                c2.p("video", nVar.ISf.optInt("viewId"));
            }
            AppMethodBeat.o(210624);
            return z;
        } else if (p.j("supportIFrameSameLayer", str)) {
            MMWebView mMWebView = fVar.IRa;
            if (mMWebView == null) {
                p.hyc();
            }
            if (!mMWebView.isXWalkKernel() || !XWalkEnvironment.isCurrentVersionSupportNativeView()) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            } else {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            }
            AppMethodBeat.o(210624);
            return true;
        } else {
            a aVar = a.JxN;
            if (!a.gic() || !p.j("getInitialParams", str)) {
                AppMethodBeat.o(210624);
                return false;
            }
            a aVar2 = a.JxN;
            HashMap hashMap2 = new HashMap();
            String string = ((MultiProcessMMKV) a.JxM.getSlot()).getString("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
            if (Util.isNullOrNil(string)) {
                Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid null");
                hashMap = null;
            } else {
                Map<String, Object> bbj = a.bbj(string);
                HashMap hashMap3 = hashMap2;
                if (bbj == null || (obj = bbj.get("videoInitialTime")) == null) {
                    obj = new Object();
                }
                hashMap3.put("videoInitialTime", obj);
                HashMap hashMap4 = hashMap2;
                if (bbj == null || (obj2 = bbj.get("videoInitialSnapshot")) == null) {
                    obj2 = new Object();
                }
                hashMap4.put("videoInitialSnapshot", obj2);
                ((MultiProcessMMKV) a.JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
                Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid = " + string + ", time = " + hashMap2.get("videoInitialTime"));
                hashMap = hashMap2;
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", hashMap);
            AppMethodBeat.o(210624);
            return true;
        }
    }
}
