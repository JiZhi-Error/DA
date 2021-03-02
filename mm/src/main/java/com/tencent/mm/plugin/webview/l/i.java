package com.tencent.mm.plugin.webview.l;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.l.c;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.fad;
import com.tencent.mm.protocal.protobuf.fae;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.bn;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u0000 .2\u00020\u0001:\u0001.B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0007J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0005H\u0007J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0005H\u0007J \u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0007J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0007J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0005H\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"})
public final class i {
    public static final a JEK = new a((byte) 0);
    private static final String TAG = TAG;
    private final com.tencent.mm.plugin.webview.d.b IBt = new b(this);
    public JsapiPermissionWrapper IBv;
    private final String JDJ;
    private final c JEJ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<c.j, x> {
        final /* synthetic */ i JEL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(i iVar) {
            super(1);
            this.JEL = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.j jVar) {
            AppMethodBeat.i(82943);
            p.h(jVar, "ex");
            i.a(this.JEL, "WeixinWebCompt.onError({retCode: 20002, webComptName:" + a.bbs(this.JEL.JDJ) + ", error:'refresh a8key failed'})");
            x xVar = x.SXb;
            AppMethodBeat.o(82943);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class g extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ i JEL;
        final /* synthetic */ String JEM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(i iVar, String str) {
            super(1);
            this.JEL = iVar;
            this.JEM = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(82944);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            i.a(this.JEL, "WeixinWebCompt._callback(" + a.bbs(this.JEM) + ',' + str2 + ')');
            x xVar = x.SXb;
            AppMethodBeat.o(82944);
            return xVar;
        }
    }

    public i(c cVar, String str) {
        p.h(cVar, "webComponent");
        p.h(str, "webComptName");
        AppMethodBeat.i(225217);
        this.JEJ = cVar;
        this.JDJ = str;
        AppMethodBeat.o(225217);
    }

    public final JsapiPermissionWrapper gdH() {
        AppMethodBeat.i(82945);
        JsapiPermissionWrapper jsapiPermissionWrapper = this.IBv;
        if (jsapiPermissionWrapper == null) {
            p.btv("jsPerm");
        }
        AppMethodBeat.o(82945);
        return jsapiPermissionWrapper;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032F\u0010\u0006\u001aB\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b\u0018\u00010\t0\u0007H\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
    static final class b implements com.tencent.mm.plugin.webview.d.b {
        final /* synthetic */ i JEL;

        b(i iVar) {
            this.JEL = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.b
        public final void h(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.i(82936);
            HashMap hashMap = new HashMap();
            p.g(str2, "ret");
            hashMap.put("err_msg", str2);
            if (map != null) {
                hashMap.putAll(map);
            }
            String a2 = n.a.a(str, (Map<String, Object>) hashMap, false, "");
            a aVar = i.JEK;
            Log.d(i.TAG, "invoke callback: " + str2 + ", " + a2);
            i iVar = this.JEL;
            StringBuilder sb = new StringBuilder("WeixinWebCompt._callback(");
            p.g(str, "callbackId");
            i.a(iVar, sb.append(a.bbs(str)).append(", ").append(a2).append("['__params'])").toString());
            AppMethodBeat.o(82936);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"dealMsg", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i JEL;
        final /* synthetic */ String yiu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(i iVar, String str) {
            super(0);
            this.JEL = iVar;
            this.yiu = str;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            h hVar;
            AppMethodBeat.i(82941);
            WeakReference<h> weakReference = this.JEL.JEJ.JCU;
            if (weakReference == null || (hVar = weakReference.get()) == null) {
                AppMethodBeat.o(82941);
                return;
            }
            String str = this.yiu;
            JsapiPermissionWrapper gdH = this.JEL.gdH();
            Bundle bundle = new Bundle();
            bundle.putString("name", this.JEL.JDJ);
            hVar.a(str, gdH, bundle, this.JEL.IBt);
            AppMethodBeat.o(82941);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void invoke(String str) {
        AppMethodBeat.i(82946);
        p.h(str, "message");
        d dVar = new d(this, str);
        if (!(str.length() == 0)) {
            Log.d(TAG, "invoke: ".concat(String.valueOf(str)));
            if (MMHandlerThread.isMainThread()) {
                dVar.invoke();
                AppMethodBeat.o(82946);
                return;
            }
            MMHandlerThread.postToMainThread(new e(dVar));
        }
        AppMethodBeat.o(82946);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ d JEN;

        e(d dVar) {
            this.JEN = dVar;
        }

        public final void run() {
            AppMethodBeat.i(82942);
            this.JEN.invoke();
            AppMethodBeat.o(82942);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void sendMessage(String str) {
        AppMethodBeat.i(82947);
        p.h(str, "data");
        c cVar = this.JEJ;
        p.h(str, "message");
        Log.v(c.TAG, "postToFront ".concat(String.valueOf(str)));
        c.a(cVar, "window.WeixinOpenTags && window.WeixinOpenTags.onMessage(" + str + ')');
        cVar.JCS.a(b.SEND_TO_MAIN_FRAME);
        AppMethodBeat.o(82947);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void refreshA8Key(String str) {
        AppMethodBeat.i(82948);
        p.h(str, "callbackId");
        c cVar = this.JEJ;
        String str2 = this.JDJ;
        f fVar = new f(this);
        g gVar = new g(this, str);
        p.h(str2, "webCompt");
        p.h(fVar, "onerror");
        p.h(gVar, "onsuccess");
        c.l.a aVar = (c.l.a) cVar.giJ().get(str2);
        if (aVar != null) {
            if (!kotlin.n.n.aL(aVar.JDU)) {
                kotlinx.coroutines.f.b(bn.TUK, (kotlin.d.f) null, new c.y(aVar, null, cVar, gVar, fVar), 3);
            }
            AppMethodBeat.o(82948);
            return;
        }
        AppMethodBeat.o(82948);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void errReport(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(82949);
        p.h(str, "errMsg");
        p.h(str2, "errStack");
        this.JEJ.h(this.JDJ, str, str2, i2, i3);
        AppMethodBeat.o(82949);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String performance(String str) {
        String str2;
        r rVar;
        String str3;
        z settings;
        AppMethodBeat.i(82950);
        p.h(str, "frontEndPerformance");
        c cVar = this.JEJ;
        String str4 = this.JDJ;
        p.h(str4, "webCompt");
        p.h(str, "frontEndPerformance");
        c.l.a aVar = (c.l.a) cVar.giJ().get(str4);
        if (aVar == null || (rVar = aVar.JDX) == null) {
            str2 = "";
        } else {
            String str5 = c.a(rVar, j.listOf((Object[]) new c.k[]{c.k.STEP_EVAL_MAIN_FRAME, c.k.STEP_FETCH_WORKER, c.k.STEP_GET_APP_SCRIPT, c.k.STEP_GET_A8KEY})) + str;
            Log.i(c.TAG, "performance: ".concat(String.valueOf(str5)));
            Object[] objArr = new Object[6];
            h hVar = cVar.JCU.get();
            if (hVar == null || (settings = hVar.getSettings()) == null || (str3 = settings.getUserAgentString()) == null) {
                str3 = "";
            }
            objArr[0] = a.htmlEncode(str3);
            objArr[1] = a.htmlEncode(aVar.pDH);
            objArr[2] = aVar.appId;
            objArr[3] = str4;
            c.b bVar = c.JDf;
            objArr[4] = Integer.valueOf(c.b.giU().getVersion());
            objArr[5] = aVar.JDW;
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(18151, j.a(j.listOf(objArr), ",", (CharSequence) null, ",", 0, (CharSequence) null, (kotlin.g.a.b) null, 58) + str5);
            str2 = str5;
        }
        if (str2 == null) {
            str2 = "";
        }
        AppMethodBeat.o(82950);
        return str2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void log(int i2, String str, String str2) {
        AppMethodBeat.i(82951);
        p.h(str, "tag");
        p.h(str2, "msg");
        String str3 = "webCompt[" + str + ']';
        switch (i2) {
            case 0:
                Log.v(str3, str2);
                AppMethodBeat.o(82951);
                return;
            case 1:
                Log.d(str3, str2);
                AppMethodBeat.o(82951);
                return;
            case 2:
                Log.i(str3, str2);
                AppMethodBeat.o(82951);
                return;
            case 3:
                Log.w(str3, str2);
                AppMethodBeat.o(82951);
                return;
            case 4:
                Log.e(str3, str2);
                AppMethodBeat.o(82951);
                return;
            case 5:
                Log.f(str3, str2);
                break;
        }
        AppMethodBeat.o(82951);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void kv(int i2, String str) {
        AppMethodBeat.i(82952);
        p.h(str, "data");
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(82952);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkey(long j2, long j3, long j4) {
        AppMethodBeat.i(82953);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(j2, j3, j4);
        AppMethodBeat.o(82953);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkeyList(String str) {
        AppMethodBeat.i(82954);
        p.h(str, "list");
        com.tencent.mm.ab.f fVar = new com.tencent.mm.ab.f(str);
        LinkedList linkedList = new LinkedList();
        int length = fVar.length();
        for (int i2 = 0; i2 < length; i2++) {
            com.tencent.mm.ab.f pW = fVar.pW(i2);
            linkedList.add(new IDKey(pW.getLong(0), pW.getLong(1), pW.getLong(2)));
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.b(new ArrayList<>(linkedList), false);
        AppMethodBeat.o(82954);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void cgi(String str, String str2) {
        AppMethodBeat.i(82955);
        p.h(str, "callbackId");
        p.h(str2, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        j jVar = this.JEJ.JCS;
        if (jVar != null) {
            jVar.a(b.REQUEST_CGI);
        }
        d.a aVar = new d.a();
        fad fad = new fad();
        fad.NvW = str2;
        aVar.c(fad);
        aVar.d(new fae());
        aVar.MB("/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi");
        aVar.sG(2936);
        aVar.sI(0);
        aVar.sJ(0);
        IPCRunCgi.a(aVar.aXF(), new c(this, str));
        AppMethodBeat.o(82955);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class c implements IPCRunCgi.a {
        final /* synthetic */ i JEL;
        final /* synthetic */ String JEM;

        c(i iVar, String str) {
            this.JEL = iVar;
            this.JEM = str;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            String str2;
            AppMethodBeat.i(82937);
            if (i2 == 0 && i3 == 0) {
                i iVar = this.JEL;
                StringBuilder append = new StringBuilder("WeixinWebCompt._callback(").append(a.bbs(this.JEM)).append(", ");
                p.g(dVar, "rr");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
                    AppMethodBeat.o(82937);
                    throw tVar;
                }
                i.a(iVar, append.append(((fae) aYK).NvX).append(')').toString());
                AppMethodBeat.o(82937);
                return;
            }
            i iVar2 = this.JEL;
            StringBuilder append2 = new StringBuilder("WeixinWebCompt._callback(").append(a.bbs(this.JEM)).append(", {errType:").append(i2).append(", errCode:").append(i3).append(", errMsg:");
            if (str == null || (str2 = a.bbs(str)) == null) {
                str2 = "";
            }
            i.a(iVar2, append2.append(str2).append("})").toString());
            j jVar = this.JEL.JEJ.JCS;
            if (jVar != null) {
                jVar.a(b.REQUEST_CGI_ERR);
                AppMethodBeat.o(82937);
                return;
            }
            AppMethodBeat.o(82937);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\f8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(82957);
        AppMethodBeat.o(82957);
    }

    public static final /* synthetic */ void a(i iVar, String str) {
        AppMethodBeat.i(82958);
        com.tencent.mm.plugin.appbrand.m.g bbt = iVar.JEJ.bbt(iVar.JDJ);
        if (bbt != null) {
            bbt.evaluateJavascript(str, null);
            AppMethodBeat.o(82958);
            return;
        }
        AppMethodBeat.o(82958);
    }
}
