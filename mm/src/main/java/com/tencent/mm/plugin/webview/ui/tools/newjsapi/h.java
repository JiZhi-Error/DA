package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u00040\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetAdIdInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "hostList", "", "kotlin.jvm.PlatformType", "getHostList", "()Ljava/util/List;", "hostList$delegate", "Lkotlin/Lazy;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class h extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = CDJ;
    private static final f Jxh = g.ah(b.Jxj);
    public static final h Jxi = new h();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(210593);
        AppMethodBeat.o(210593);
    }

    private h() {
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
        AppMethodBeat.i(210592);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        if (nVar.IRs == null || Util.isNullOrNil(nVar.IRs.getString("name"))) {
            try {
                Object obj = nVar.params.get("url");
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210592);
                    throw tVar;
                }
                Uri parse = Uri.parse((String) obj);
                p.g(parse, "Uri.parse(url)");
                String host = parse.getHost();
                if (Util.isNullOrNil(host) || !((List) Jxh.getValue()).contains(host)) {
                    Log.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo but not valid host ".concat(String.valueOf(host)));
                    fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail invalid host", null);
                    AppMethodBeat.o(210592);
                    return false;
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo ex " + e2.getMessage());
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210592);
                return false;
            }
        }
        d.i(new a(fVar, nVar));
        AppMethodBeat.o(210592);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<List<? extends String>> {
        public static final b Jxj = new b();

        static {
            AppMethodBeat.i(210591);
            AppMethodBeat.o(210591);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends String> invoke() {
            AppMethodBeat.i(210590);
            String[] strArr = new String[7];
            strArr[0] = WeChatHosts.domainString(R.string.e20);
            strArr[1] = WeChatHosts.domainString(R.string.e26);
            strArr[2] = WeChatHosts.domainString(R.string.e25);
            strArr[3] = "pa.ugdtimg.com";
            strArr[4] = (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) ? "test-xj.gdt.qq.com" : "";
            strArr[5] = "h5.gdt.qq.com";
            strArr[6] = "xj.gdt.qq.com";
            List listOf = j.listOf((Object[]) strArr);
            AppMethodBeat.o(210590);
            return listOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f CDE;
        final /* synthetic */ n pGr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
            super(0);
            this.CDE = fVar;
            this.pGr = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210589);
            HashMap hashMap = new HashMap();
            String eWE = com.tencent.mm.plugin.sns.ad.b.a.eWE();
            p.g(eWE, "AdDeviceInfo.getImeiWx()");
            hashMap.put("imei", eWE);
            if (com.tencent.mm.plugin.sns.ad.i.a.eYf()) {
                String aoK = com.tencent.mm.plugin.sns.ad.b.a.aoK();
                if (Util.isNullOrNil(aoK) && this.CDE.mHh != null) {
                    try {
                        e eVar = this.CDE.mHh;
                        if (eVar == null) {
                            p.hyc();
                        }
                        aoK = eVar.j(112, new Bundle()).getString("oaid", "");
                    } catch (Exception e2) {
                        Log.e("MicroMsg.JsApiGetAdIdInfo", "getOaid ex " + e2.getMessage());
                    }
                }
                p.g(aoK, "oaid");
                hashMap.put("oaid", aoK);
                Log.d("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo oaid=".concat(String.valueOf(aoK)));
            }
            if (this.pGr.params.containsKey("waidPkg")) {
                Object obj = this.pGr.params.get("waidPkg");
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210589);
                    throw tVar;
                }
                String str = (String) obj;
                Log.i("MicroMsg.JsApiGetAdIdInfo", "waidPkg=".concat(String.valueOf(str)));
                String aRy = com.tencent.mm.plugin.sns.waid.b.aRy(str);
                p.g(aRy, "WaidHelper.getAppWaid(waidPkg)");
                hashMap.put("waid", aRy);
            } else {
                Log.w("MicroMsg.JsApiGetAdIdInfo", "no waidPkg param");
            }
            String eWC = com.tencent.mm.plugin.sns.ad.b.a.eWC();
            p.g(eWC, "AdDeviceInfo.getAllDeviceInfo()");
            hashMap.put("devIdInfo", eWC);
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":ok", hashMap);
            x xVar = x.SXb;
            AppMethodBeat.o(210589);
            return xVar;
        }
    }
}
