package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.d.d;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.ehl;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004J\u0012\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020-H\u0014J(\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u000207H\u0014J\u0018\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016J\u000e\u0010;\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004J\u0018\u0010=\u001a\u00020-2\u0006\u00101\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R(\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d`\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8TX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setContext$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "msgIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMsgIds$plugin_brandservice_release", "()Ljava/util/HashMap;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "tlRenderJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "enterHotZone", "", "canvasId", "exitHotZone", "getLocalData", "key", "initEnv", "onConfigClient", UserDataStore.CITY, "data", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onInvoke", "func", "message", "onScreenShot", "scroll", "setLocalData", "validCgi", "", "cmdId", "", "cgiUrl", "Companion", "plugin-brandservice_release"})
public final class x extends com.tencent.mm.plugin.webcanvas.c {
    static final String TAG = TAG;
    private static final List<String> pvZ = n.a("openUrlWithExtraWebview;openADCanvas;profile;openWeApp;launchMiniProgram", new String[]{";"});
    private static final f pwa = g.ah(b.pwc);
    public static final a pwb = new a((byte) 0);
    private final String jzY = "wxf337cbaa27790d8e";
    WeakReference<Context> lAM = new WeakReference<>(MMApplicationContext.getContext());
    z psm;
    private final MMKVSlotManager pvV;
    private final d pvW;
    final HashMap<String, Long> pvX = new HashMap<>();
    ab pvY;

    public x() {
        AppMethodBeat.i(195419);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
        p.g(mmkv, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
        this.pvV = new MMKVSlotManager(mmkv, 15552000);
        com.tencent.mm.plugin.ac.a aVar = new com.tencent.mm.plugin.ac.a(WebViewStubService.class, "wxCanvas", "wxf337cbaa27790d8e", JsapiPermissionWrapper.Kzm);
        int hashCode = aVar.hashCode();
        h hVar = new h(null, null, hashCode);
        JsapiPermissionWrapper jsapiPermissionWrapper = aVar.IBv;
        Bundle bundle = new Bundle();
        bundle.putString("name", aVar.name);
        bundle.putString("appId", aVar.appId);
        hVar.a(jsapiPermissionWrapper, bundle);
        m mVar = m.INc;
        m.a(true, aVar.IBu, new a.b(hVar, hashCode));
        this.pvW = hVar;
        AppMethodBeat.o(195419);
    }

    @Override // com.tencent.mm.plugin.ab.k
    public final void setLocalData(String str, String str2) {
        AppMethodBeat.i(195412);
        p.h(str, "key");
        p.h(str2, "data");
        try {
            ((MultiProcessMMKV) this.pvV.getSlot()).encode(str, str2);
            Log.d(TAG, "setLocalData:" + str + ", " + str2);
            AppMethodBeat.o(195412);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "setLocalData:" + str + ", " + str2, new Object[0]);
            AppMethodBeat.o(195412);
        }
    }

    @Override // com.tencent.mm.plugin.ab.k
    public final String getLocalData(String str) {
        String str2;
        AppMethodBeat.i(195413);
        p.h(str, "key");
        try {
            str2 = ((MultiProcessMMKV) this.pvV.getSlot()).decodeString(str, "");
            Log.d(TAG, "getLocalData:" + str + ", " + str2);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "getLocalData:".concat(String.valueOf(str)), new Object[0]);
            str2 = null;
        }
        AppMethodBeat.o(195413);
        return str2;
    }

    @Override // com.tencent.mm.plugin.ab.k
    public final d cna() {
        return this.pvW;
    }

    @Override // com.tencent.mm.plugin.ab.k
    public final void fe(String str, String str2) {
        z zVar;
        AppMethodBeat.i(195414);
        p.h(str, "func");
        p.h(str2, "message");
        if (!pvZ.contains(str) || (zVar = this.psm) == null) {
            AppMethodBeat.o(195414);
            return;
        }
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, "");
        AppMethodBeat.o(195414);
    }

    @Override // com.tencent.mm.plugin.webcanvas.c
    public final String bje() {
        return this.jzY;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
    public static final class c implements com.tencent.mm.plugin.brandservice.ui.c.b {
        final /* synthetic */ String pmq;
        final /* synthetic */ String pmr;
        final /* synthetic */ x pwd;

        c(x xVar, String str, String str2) {
            this.pwd = xVar;
            this.pmr = str;
            this.pmq = str2;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.c.b
        public final Object getInfo(String str) {
            AppMethodBeat.i(195406);
            p.h(str, "key");
            switch (str.hashCode()) {
                case -229691438:
                    if (str.equals("videoChannelData")) {
                        com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
                        String clG = com.tencent.mm.plugin.brandservice.b.c.clG();
                        AppMethodBeat.o(195406);
                        return clG;
                    }
                    break;
                case -81550052:
                    if (str.equals("feedBackRecycleCardList")) {
                        String cmN = l.cmN();
                        AppMethodBeat.o(195406);
                        return cmN;
                    }
                    break;
                case 104191100:
                    if (str.equals("msgId")) {
                        Long l = this.pwd.pvX.get(this.pmr);
                        if (l == null) {
                            l = 0L;
                        }
                        String valueOf = String.valueOf(l);
                        Log.d(x.TAG, "getInfo canvasId=" + this.pmr + ", msgIds=" + valueOf);
                        AppMethodBeat.o(195406);
                        return valueOf;
                    }
                    break;
                case 607796817:
                    if (str.equals("sessionId")) {
                        com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
                        if (bVar != null) {
                            Integer valueOf2 = Integer.valueOf(bVar.clh());
                            AppMethodBeat.o(195406);
                            return valueOf2;
                        }
                        AppMethodBeat.o(195406);
                        return 0;
                    }
                    break;
                case 1043830850:
                    if (str.equals("videoChannelIconSize")) {
                        Float valueOf3 = Float.valueOf(((float) com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.eO(MMApplicationContext.getContext())) / com.tencent.mm.plugin.appbrand.ac.g.bZk());
                        AppMethodBeat.o(195406);
                        return valueOf3;
                    }
                    break;
                case 1546932043:
                    if (str.equals("videoChannelItemWidth")) {
                        Integer valueOf4 = Integer.valueOf(kotlin.h.a.cR(((float) com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.eN(MMApplicationContext.getContext())) / com.tencent.mm.plugin.appbrand.ac.g.bZk()));
                        Log.d(x.TAG, "getInfo canvasId=" + this.pmr + ", videoChannelItemWidth=" + valueOf4.intValue());
                        AppMethodBeat.o(195406);
                        return valueOf4;
                    }
                    break;
            }
            AppMethodBeat.o(195406);
            return null;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.c.b
        public final String getData() {
            return this.pmq;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.c.b
        public final void deleteCanvasCard(String str) {
            AppMethodBeat.i(195407);
            p.h(str, "fieldId");
            Log.i(x.TAG, "deleteCanvasCard ".concat(String.valueOf(str)));
            ag.ban().MX(Util.getLong(str, -1));
            AppMethodBeat.o(195407);
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.c.b
        public final void adRequest(String str, String str2, String str3) {
            AppMethodBeat.i(195408);
            p.h(str, "message");
            p.h(str2, "subType");
            p.h(str3, "callback");
            Log.d(x.TAG, "adRequest %s", str);
            d.a aVar = new d.a();
            ehk ehk = new ehk();
            ehk.KWE = 3;
            ehk.KWF = str;
            ehk.NgX = str2;
            ehk.KWz = System.currentTimeMillis();
            aVar.c(ehk);
            aVar.d(new ehl());
            aVar.MB("/cgi-bin/mmbiz-bin/recommend/timelinecard");
            aVar.sG(2781);
            aVar.sI(0);
            aVar.sJ(0);
            aa.a(aVar.aXF(), new a(this, str3));
            AppMethodBeat.o(195408);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
        static final class a implements aa.a {
            final /* synthetic */ c pwe;
            final /* synthetic */ String pwf;

            a(c cVar, String str) {
                this.pwe = cVar;
                this.pwf = str;
            }

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                AppMethodBeat.i(195403);
                if (i2 == 0 && i3 == 0) {
                    p.g(dVar, "rr");
                    com.tencent.mm.bw.a aYK = dVar.aYK();
                    if (!(aYK instanceof ehl)) {
                        aYK = null;
                    }
                    ehl ehl = (ehl) aYK;
                    if (ehl == null) {
                        Log.e(x.TAG, "adRequest resp is null");
                        AppMethodBeat.o(195403);
                    } else {
                        Log.d(x.TAG, "adRequest resp data: " + ehl.KWF);
                        x xVar = this.pwe.pwd;
                        String str2 = this.pwf;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("err_msg", "ok");
                        String str3 = ehl.KWF;
                        if (str3 == null) {
                            str3 = "";
                        }
                        jSONObject.put("data", str3);
                        String jSONObject2 = jSONObject.toString();
                        p.g(jSONObject2, "JSONObject().apply {\n   …             }.toString()");
                        c.a.a(xVar, str2, jSONObject2, null, 4);
                        AppMethodBeat.o(195403);
                    }
                } else {
                    Log.e(x.TAG, "adRequest callback errType=" + i2 + ", errCode=" + i3);
                    x xVar2 = this.pwe.pwd;
                    String str4 = this.pwf;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("err_code", i3);
                    jSONObject3.put("err_msg", "fail");
                    String jSONObject4 = jSONObject3.toString();
                    p.g(jSONObject4, "JSONObject().apply {\n   …             }.toString()");
                    c.a.a(xVar2, str4, jSONObject4, null, 4);
                    AppMethodBeat.o(195403);
                }
                return 0;
            }
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.c.b
        public final void canvasRequest(Number number, String str, String str2) {
            AppMethodBeat.i(195409);
            p.h(number, "businessId");
            p.h(str, "reqJson");
            p.h(str2, "callback");
            Log.d(x.TAG, "canvasRequest %s", str);
            d.a aVar = new d.a();
            aVar.c(new pq());
            aVar.d(new pr());
            aVar.MB("/cgi-bin/mmbiz-bin/timeline/bizrecommendtimelinecard");
            aVar.sG(1085);
            com.tencent.mm.ak.d aXF = aVar.aXF();
            com.tencent.mm.bw.a aYJ = aXF.aYJ();
            if (aYJ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendTimeLineCardReq");
                AppMethodBeat.o(195409);
                throw tVar;
            }
            pq pqVar = (pq) aYJ;
            pqVar.KWE = number.intValue();
            pqVar.KWF = str;
            pqVar.KWz = System.currentTimeMillis();
            aa.a(aXF, new b(this, str2));
            AppMethodBeat.o(195409);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
        static final class b implements aa.a {
            final /* synthetic */ c pwe;
            final /* synthetic */ String pwf;

            b(c cVar, String str) {
                this.pwe = cVar;
                this.pwf = str;
            }

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                AppMethodBeat.i(195404);
                if (i2 == 0 && i3 == 0) {
                    p.g(dVar, "rr");
                    com.tencent.mm.bw.a aYK = dVar.aYK();
                    if (!(aYK instanceof pr)) {
                        aYK = null;
                    }
                    pr prVar = (pr) aYK;
                    if (prVar != null) {
                        Log.i(x.TAG, "canvasRequest resp_json=" + prVar.KWF);
                        x xVar = this.pwe.pwd;
                        String str2 = this.pwf;
                        String str3 = prVar.KWF;
                        p.g(str3, "resp.Data");
                        c.a.a(xVar, str2, str3, null, 4);
                    }
                    AppMethodBeat.o(195404);
                } else {
                    x xVar2 = this.pwe.pwd;
                    String str4 = this.pwf;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("err_code", i3);
                    jSONObject.put("err_msg", "fail");
                    String jSONObject2 = jSONObject.toString();
                    p.g(jSONObject2, "JSONObject().apply {\n   …             }.toString()");
                    c.a.a(xVar2, str4, jSONObject2, null, 4);
                    AppMethodBeat.o(195404);
                }
                return 0;
            }
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.c.b
        public final void onItemClick(String str, int i2) {
            AppMethodBeat.i(195410);
            p.h(str, "fieldId");
            long j2 = Util.getLong(str, 0);
            Log.i(x.TAG, "onItemClick msgId=%s, pos=%d", Long.valueOf(j2), Integer.valueOf(i2));
            com.tencent.f.h.RTc.aX(new RunnableC0881c(this, j2));
            AppMethodBeat.o(195410);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.x$c$c  reason: collision with other inner class name */
        static final class RunnableC0881c implements Runnable {
            final /* synthetic */ c pwe;
            final /* synthetic */ long pwg;

            RunnableC0881c(c cVar, long j2) {
                this.pwe = cVar;
                this.pwg = j2;
            }

            public final void run() {
                String str = null;
                AppMethodBeat.i(195405);
                z MM = ag.ban().MM(this.pwg);
                if (MM != null) {
                    if (MM.gAu()) {
                        Context context = this.pwe.pwd.lAM.get();
                        if (!(context instanceof BizTimeLineUI)) {
                            context = null;
                        }
                        BizTimeLineUI bizTimeLineUI = (BizTimeLineUI) context;
                        if (bizTimeLineUI != null) {
                            bizTimeLineUI.j(MM);
                        }
                        ege gAD = MM.gAD();
                        if (!(gAD == null || gAD.style != 1001 || gAD.Ngc == null)) {
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr = new Object[7];
                            objArr[0] = Long.valueOf(MMSlotKt.now());
                            objArr[1] = gAD.Ngc.cardId;
                            objArr[2] = Long.valueOf(gAD.MOC);
                            objArr[3] = 5;
                            objArr[4] = 2;
                            objArr[5] = Integer.valueOf(gAD.style);
                            ale ale = gAD.Nga;
                            if (ale != null) {
                                str = ale.KUo;
                            }
                            objArr[6] = str;
                            hVar.a(21064, objArr);
                        }
                    }
                    AppMethodBeat.o(195405);
                    return;
                }
                AppMethodBeat.o(195405);
            }
        }
    }

    @Override // com.tencent.mm.plugin.webcanvas.c
    public final void a(Context context, String str, String str2, i iVar) {
        AppMethodBeat.i(195415);
        p.h(context, UserDataStore.CITY);
        p.h(str, "canvasId");
        p.h(str2, "data");
        p.h(iVar, "jsRuntime");
        super.a(context, str, str2, iVar);
        new com.tencent.mm.plugin.brandservice.ui.c.a(new c(this, str, str2)).f(iVar);
        AppMethodBeat.o(195415);
    }

    @Override // com.tencent.mm.plugin.webcanvas.c
    public final k cnb() {
        AppMethodBeat.i(195416);
        ab abVar = this.pvY;
        if (abVar == null) {
            p.btv("tlRenderJsEngine");
        }
        ab abVar2 = abVar;
        AppMethodBeat.o(195416);
        return abVar2;
    }

    @Override // com.tencent.mm.plugin.webcanvas.c
    public final void cnc() {
        AppMethodBeat.i(195417);
        this.pvY = new ab(this, fWA(), fWz(), this.IzG);
        super.cnc();
        AppMethodBeat.o(195417);
    }

    public final void ahP(String str) {
        AppMethodBeat.i(195418);
        p.h(str, "canvasId");
        Log.i(TAG, "exitHotZone #".concat(String.valueOf(str)));
        ab abVar = this.pvY;
        if (abVar == null) {
            p.btv("tlRenderJsEngine");
        }
        p.h(str, "canvasId");
        abVar.c("exitHotZone", str, null);
        com.tencent.mm.plugin.webcanvas.a aWC = cnb().aWC(str);
        if (aWC != null) {
            aWC.IyZ = false;
            AppMethodBeat.o(195418);
            return;
        }
        AppMethodBeat.o(195418);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion;", "", "()V", "CLICK_FUNC_LIST", "", "", "TAG", "cgiAllowList", "getCgiAllowList", "()Ljava/util/List;", "cgiAllowList$delegate", "Lkotlin/Lazy;", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(195420);
        AppMethodBeat.o(195420);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends String>> {
        public static final b pwc = new b();

        static {
            AppMethodBeat.i(195402);
            AppMethodBeat.o(195402);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends String> invoke() {
            AppMethodBeat.i(195401);
            String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_web_canvas_cgi_list, "/cgi-bin/micromsg-bin/often_read_bar_report;/cgi-bin/mmbiz-bin/report/bizcommreport;/cgi-bin/mmbiz-bin/timeline/bizfeedback;/cgi-bin/mmbiz-bin/timeline/recyclecardreport;/cgi-bin/mmbiz-bin/recommend/timelinecard");
            Log.i(x.TAG, "cgiAllowList ".concat(String.valueOf(a2)));
            p.g(a2, LocaleUtil.ITALIAN);
            List<String> a3 = n.a(a2, new String[]{";"});
            AppMethodBeat.o(195401);
            return a3;
        }
    }

    @Override // com.tencent.mm.plugin.ab.k
    public final boolean aD(int i2, String str) {
        AppMethodBeat.i(195411);
        p.h(str, "cgiUrl");
        if (!((List) pwa.getValue()).contains(str)) {
            Log.i(TAG, "do cgi cmdId=" + i2 + ", cgiUrl=" + str + " not allowed!!");
            AppMethodBeat.o(195411);
            return false;
        }
        AppMethodBeat.o(195411);
        return true;
    }
}
