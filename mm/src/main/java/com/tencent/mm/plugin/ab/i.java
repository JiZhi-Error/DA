package com.tencent.mm.plugin.ab;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.k.e;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0005\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0007J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;)V", "dump", "", "tag", "", "data", "dumpToFile", "", "dumpFileName", "content", "getLogLevel", "", "getNetWorkType", "getPlatform", "idkey", "id", "", "key", "value", "idkeyList", "kv", "reportCgi", "businessId", "", "reqJson", "callback", "userAgent", "Companion", "webview-sdk_release"})
public final class i extends a<c> {
    private static final String IBf = (com.tencent.mm.loader.j.b.aKJ() + "jsengine/trace/");
    public static final a IBg = new a((byte) 0);
    private static final f pDC = g.ah(b.IBh);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(c cVar) {
        super("wxJsEngine", cVar);
        p.h(cVar, "context");
        AppMethodBeat.i(224822);
        AppMethodBeat.o(224822);
    }

    @JavascriptInterface
    public final void idkey(long j2, long j3, long j4) {
        AppMethodBeat.i(224814);
        if (j2 <= 0) {
            Log.e(this.TAG, "idkey id can't be 0");
            AppMethodBeat.o(224814);
            return;
        }
        h.INSTANCE.n(j2, j3, j4);
        AppMethodBeat.o(224814);
    }

    @JavascriptInterface
    public final void idkeyList(String str) {
        AppMethodBeat.i(224815);
        p.h(str, "idkeyList");
        com.tencent.mm.ab.f fVar = new com.tencent.mm.ab.f(str);
        LinkedList linkedList = new LinkedList();
        int length = fVar.length();
        for (int i2 = 0; i2 < length; i2++) {
            com.tencent.mm.ab.f pW = fVar.pW(i2);
            linkedList.add(new IDKey(pW.getLong(0), pW.getLong(1), pW.getLong(2)));
        }
        h hVar = h.INSTANCE;
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedList) {
            if (((IDKey) obj).GetID() > 0) {
                arrayList.add(obj);
            }
        }
        hVar.b(new ArrayList<>(arrayList), false);
        AppMethodBeat.o(224815);
    }

    @JavascriptInterface
    public final String userAgent() {
        AppMethodBeat.i(224816);
        Context context = MMApplicationContext.getContext();
        e.a aVar = e.JBw;
        String a2 = com.tencent.mm.plugin.appbrand.ac.p.a(context, e.a.giH(), (e) pDC.getValue());
        Log.d(this.TAG, "userAgent=".concat(String.valueOf(a2)));
        p.g(a2, "userAgent");
        AppMethodBeat.o(224816);
        return a2;
    }

    @JavascriptInterface
    public final String getPlatform() {
        return "android";
    }

    @JavascriptInterface
    public final int getLogLevel() {
        AppMethodBeat.i(224817);
        int logLevel = Log.getLogLevel();
        AppMethodBeat.o(224817);
        return logLevel;
    }

    @JavascriptInterface
    public final void reportCgi(Number number, String str, String str2) {
        AppMethodBeat.i(224818);
        p.h(number, "businessId");
        p.h(str, "reqJson");
        p.h(str2, "callback");
        d.a aVar = new d.a();
        aVar.c(new oc());
        aVar.d(new od());
        aVar.MB("/cgi-bin/mmbiz-bin/report/bizcommreport");
        aVar.sG(4779);
        d aXF = aVar.aXF();
        com.tencent.mm.bw.a aYJ = aXF.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizCommReportReq");
            AppMethodBeat.o(224818);
            throw tVar;
        }
        oc ocVar = (oc) aYJ;
        ocVar.KTE = number.intValue();
        ocVar.KTF = str;
        Log.d(this.TAG, "reportCgi %s", str);
        Log.i(this.TAG, "reportCgi businessId=".concat(String.valueOf(number)));
        aa.a(aXF, new c(this, str2));
        AppMethodBeat.o(224818);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class c implements aa.a {
        final /* synthetic */ i IBi;
        final /* synthetic */ String pwf;

        c(i iVar, String str) {
            this.IBi = iVar;
            this.pwf = str;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            AppMethodBeat.i(224812);
            p.h(dVar, "rr");
            p.h(qVar, "<anonymous parameter 4>");
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (!(aYK instanceof od)) {
                    aYK = null;
                }
                od odVar = (od) aYK;
                if (odVar == null) {
                    AppMethodBeat.o(224812);
                } else {
                    Log.i(this.IBi.TAG, "reportCgi resp_json=" + odVar.KTG);
                    c cVar = (c) this.IBi.IBa;
                    String str2 = this.pwf;
                    String str3 = odVar.KTG;
                    if (str3 == null) {
                        str3 = BuildConfig.COMMAND;
                    }
                    c.a.a(cVar, str2, str3, null, 4);
                    AppMethodBeat.o(224812);
                }
            } else {
                String str4 = this.pwf;
                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                iVar.U("err_code", i3);
                iVar.h("err_msg", "fail");
                String iVar2 = iVar.toString();
                p.g(iVar2, "JSONObject().apply {\n   …             }.toString()");
                c.a.a((c) this.IBi.IBa, str4, iVar2, null, 4);
                AppMethodBeat.o(224812);
            }
            return 0;
        }
    }

    @JavascriptInterface
    public final void dump(String str, String str2) {
        AppMethodBeat.i(224819);
        p.h(str, "tag");
        p.h(str2, "data");
        if (!WeChatEnvironment.hasDebugger()) {
            Log.w(this.TAG, "try to dump data without debugger");
            AppMethodBeat.o(224819);
            return;
        }
        String str3 = "CPU_" + str + '_' + MMSlotKt.now() + ".cpuprofile";
        if (eu(str3, str2)) {
            String str4 = IBf + str3;
            a.acb(str4 + " exported.");
            Log.i(this.TAG, str4 + " exported.");
            AppMethodBeat.o(224819);
            return;
        }
        a.acb(str3 + " export failed!");
        Log.e(this.TAG, str3 + " export failed!");
        AppMethodBeat.o(224819);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065 A[SYNTHETIC, Splitter:B:22:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[SYNTHETIC, Splitter:B:28:0x007e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean eu(java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ab.i.eu(java.lang.String, java.lang.String):boolean");
    }

    @JavascriptInterface
    public final String getNetWorkType() {
        AppMethodBeat.i(224821);
        Context context = MMApplicationContext.getContext();
        if (!NetStatusUtil.isConnected(context)) {
            Log.i(this.TAG, "getNetworkType, not connected");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("networkType", "none");
            String jSONObject2 = jSONObject.toString();
            p.g(jSONObject2, "org.json.JSONObject().ap…pe\", \"none\") }.toString()");
            AppMethodBeat.o(224821);
            return jSONObject2;
        }
        com.tencent.mm.plugin.misc.a.a aVar = (com.tencent.mm.plugin.misc.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class);
        Integer valueOf = aVar != null ? Integer.valueOf(aVar.Qr(16)) : null;
        Integer valueOf2 = Integer.valueOf((valueOf != null && valueOf.intValue() == 0) ? 0 : (valueOf != null && valueOf.intValue() == 1) ? 1 : 2);
        Log.i(this.TAG, "getNetworkType, type = " + NetStatusUtil.getNetType(context) + ", simType = " + valueOf2);
        if (NetStatusUtil.is2G(context)) {
            Log.i(this.TAG, "getNetworkType, 2g");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("networkType", "2g");
            jSONObject3.put("simtype", valueOf2.intValue());
            String jSONObject4 = jSONObject3.toString();
            p.g(jSONObject4, "org.json.JSONObject().ap…\n            }.toString()");
            AppMethodBeat.o(224821);
            return jSONObject4;
        } else if (NetStatusUtil.is3G(context)) {
            Log.i(this.TAG, "getNetworkType, 3g");
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("networkType", "3g");
            jSONObject5.put("simtype", valueOf2.intValue());
            String jSONObject6 = jSONObject5.toString();
            p.g(jSONObject6, "org.json.JSONObject().ap…\n            }.toString()");
            AppMethodBeat.o(224821);
            return jSONObject6;
        } else if (NetStatusUtil.is4G(context)) {
            Log.i(this.TAG, "getNetworkType, 4g");
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("networkType", "4g");
            jSONObject7.put("simtype", valueOf2.intValue());
            String jSONObject8 = jSONObject7.toString();
            p.g(jSONObject8, "org.json.JSONObject().ap…\n            }.toString()");
            AppMethodBeat.o(224821);
            return jSONObject8;
        } else if (NetStatusUtil.is5G(context)) {
            Log.i(this.TAG, "getNetworkType, 5g");
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("networkType", "5g");
            jSONObject9.put("simtype", valueOf2.intValue());
            String jSONObject10 = jSONObject9.toString();
            p.g(jSONObject10, "org.json.JSONObject().ap…\n            }.toString()");
            AppMethodBeat.o(224821);
            return jSONObject10;
        } else if (NetStatusUtil.isWifi(context)) {
            Log.i(this.TAG, "getNetworkType, wifi");
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("networkType", "wifi");
            jSONObject11.put("simtype", valueOf2.intValue());
            String jSONObject12 = jSONObject11.toString();
            p.g(jSONObject12, "org.json.JSONObject().ap…\n            }.toString()");
            AppMethodBeat.o(224821);
            return jSONObject12;
        } else {
            Log.w(this.TAG, "getNetworkType, unknown");
            JSONObject jSONObject13 = new JSONObject();
            jSONObject13.put("networkType", "none");
            String jSONObject14 = jSONObject13.toString();
            p.g(jSONObject14, "org.json.JSONObject().ap…pe\", \"none\") }.toString()");
            AppMethodBeat.o(224821);
            return jSONObject14;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineAPI$Companion;", "", "()V", "profilerPath", "", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "Lkotlin/Lazy;", "toast", "", "text", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static void acb(String str) {
            AppMethodBeat.i(224811);
            com.tencent.mm.ac.d.h(new C0510a(str));
            AppMethodBeat.o(224811);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.ab.i$a$a  reason: collision with other inner class name */
        public static final class C0510a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ String rry;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0510a(String str) {
                super(0);
                this.rry = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(224808);
                u.makeText(MMApplicationContext.getContext(), this.rry, 2000).show();
                x xVar = x.SXb;
                AppMethodBeat.o(224808);
                return xVar;
            }
        }
    }

    static {
        AppMethodBeat.i(224823);
        AppMethodBeat.o(224823);
    }

    @JavascriptInterface
    public final void kv(int i2, String str) {
        AppMethodBeat.i(224813);
        p.h(str, "data");
        Log.i(this.TAG, "kvStat id=" + i2 + ", data=" + str);
        h.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(224813);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<e> {
        public static final b IBh = new b();

        static {
            AppMethodBeat.i(224810);
            AppMethodBeat.o(224810);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ e invoke() {
            AppMethodBeat.i(224809);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            e eVar = new e(context);
            AppMethodBeat.o(224809);
            return eVar;
        }
    }
}
