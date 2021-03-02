package com.tencent.mm.plugin.game.luggage;

import android.net.Uri;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.protobuf.dl;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.f.e;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class g {
    public static void a(final p pVar, String str) {
        AppMethodBeat.i(186840);
        final GameWebPerformanceInfo Fd = GameWebPerformanceInfo.Fd(str);
        Log.i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key begin, time: %d", Long.valueOf(System.currentTimeMillis()));
        Fd.hhS = System.currentTimeMillis();
        c cVar = new c();
        cVar.a(str, new a<bhj>() {
            /* class com.tencent.mm.plugin.game.luggage.g.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.String, java.lang.Object] */
            @Override // com.tencent.mm.plugin.webview.f.a
            public final /* bridge */ /* synthetic */ void a(int i2, String str, String str2, bhj bhj) {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, boolean, java.lang.String, java.lang.String, java.lang.Object] */
            @Override // com.tencent.mm.plugin.webview.f.a
            public final /* synthetic */ void a(int i2, boolean z, String str, String str2, bhj bhj) {
                AppMethodBeat.i(186839);
                Log.i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key end, time: %d", Long.valueOf(System.currentTimeMillis()));
                Map<String, String> ij = c.ij(bhj.LRq);
                Fd.hhT = System.currentTimeMillis();
                com.tencent.mm.plugin.webview.ui.tools.game.g.bH(str, System.currentTimeMillis());
                g.a((MMWebView) pVar.LG(), str2, ij);
                g.b(pVar, str2);
                AppMethodBeat.o(186839);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.Object] */
            @Override // com.tencent.mm.plugin.webview.f.a
            public final /* bridge */ /* synthetic */ boolean b(int i2, String str, bhj bhj) {
                return false;
            }

            @Override // com.tencent.mm.plugin.webview.f.a
            public final void C(int i2, String str, String str2) {
            }

            @Override // com.tencent.mm.plugin.webview.f.a
            public final void bx(int i2, String str) {
            }

            @Override // com.tencent.mm.plugin.webview.f.a
            public final void by(int i2, String str) {
                AppMethodBeat.i(186838);
                Fd.hhS = System.currentTimeMillis();
                com.tencent.mm.plugin.webview.ui.tools.game.g.bG(str, System.currentTimeMillis());
                AppMethodBeat.o(186838);
            }

            @Override // com.tencent.mm.plugin.webview.f.a
            public final void a(int i2, String str, int i3, int i4, String str2) {
            }
        });
        e.a(pVar.hashCode(), cVar);
        AppMethodBeat.o(186840);
    }

    public static void b(final p pVar, final String str) {
        AppMethodBeat.i(180130);
        com.tencent.mm.ipcinvoker.p.y(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(83011);
                pVar.a(new d() {
                    /* class com.tencent.mm.plugin.game.luggage.g.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.luggage.d.d
                    public final String name() {
                        return "onGetA8KeyUrl";
                    }

                    @Override // com.tencent.luggage.d.d
                    public final JSONObject Ld() {
                        AppMethodBeat.i(83010);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                            jSONObject.put("set_cookie", 1);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.LuggageGetA8KeyUtil", "onGetA8Key, e:" + e2.getMessage());
                        }
                        AppMethodBeat.o(83010);
                        return jSONObject;
                    }
                });
                AppMethodBeat.o(83011);
            }
        });
        AppMethodBeat.o(180130);
    }

    public static void a(final MMWebView mMWebView, final String str, final Map<String, String> map) {
        AppMethodBeat.i(180131);
        if (Util.isNullOrNil(str) || mMWebView == null) {
            Log.e("MicroMsg.LuggageGetA8KeyUtil", "url is null");
            AppMethodBeat.o(180131);
            return;
        }
        com.tencent.mm.ipcinvoker.p.y(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.g.AnonymousClass3 */

            public final void run() {
                com.tencent.mm.plugin.game.protobuf.a aVar;
                boolean z;
                boolean z2;
                AppMethodBeat.i(180129);
                com.tencent.xweb.d.lA(MMApplicationContext.getContext());
                com.tencent.xweb.c hsp = com.tencent.xweb.c.hsp();
                String str = "; max-age=" + com.tencent.mm.plugin.game.commlib.a.dSX();
                String str2 = str + "; httponly";
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                String scheme = parse.getScheme();
                if (Util.isNullOrNil(scheme)) {
                    scheme = "http";
                }
                if (Util.isNullOrNil(host)) {
                    Log.e("MicroMsg.LuggageGetA8KeyUtil", "host is null");
                    AppMethodBeat.o(180129);
                    return;
                }
                String str3 = host.startsWith(".") ? scheme + "://" + host : scheme + "://." + host;
                Log.i("MicroMsg.LuggageGetA8KeyUtil", "domain = %s", str3);
                Log.i("MicroMsg.LuggageGetA8KeyUtil", "before set cookies:%s", hsp.getCookie(str3));
                boolean z3 = false;
                if (map != null && map.size() > 0) {
                    for (String str4 : map.keySet()) {
                        hsp.setCookie(host, str4 + "=" + ((String) map.get(str4)) + "; max-age=0");
                        hsp.setCookie(str3, str4 + "=" + ((String) map.get(str4)) + str2);
                        z3 = true;
                    }
                }
                boolean z4 = z3;
                try {
                    if (com.tencent.mm.plugin.game.commlib.a.xvl != null) {
                        aVar = com.tencent.mm.plugin.game.commlib.a.xvl.A8Key;
                    } else {
                        com.tencent.mm.plugin.game.commlib.a.dSS();
                        if (com.tencent.mm.plugin.game.commlib.a.xvl != null) {
                            aVar = com.tencent.mm.plugin.game.commlib.a.xvl.A8Key;
                        } else {
                            aVar = null;
                        }
                    }
                    if (aVar == null || Util.isNullOrNil(aVar.xIw)) {
                        String queryParameter = parse.getQueryParameter(OpenSDKTool4Assistant.EXTRA_UIN);
                        String queryParameter2 = parse.getQueryParameter("key");
                        String queryParameter3 = parse.getQueryParameter("pass_ticket");
                        Log.i("MicroMsg.LuggageGetA8KeyUtil", "uin = %s, key = %s, pass_ticket = %s", queryParameter, queryParameter2, queryParameter3);
                        if (!Util.isNullOrNil(queryParameter)) {
                            hsp.setCookie(str3, "X-WECHAT-UIN=" + URLEncoder.encode(queryParameter, ProtocolPackage.ServerEncoding) + str2);
                        }
                        if (!Util.isNullOrNil(queryParameter2)) {
                            hsp.setCookie(str3, "X-WECHAT-KEY=" + URLEncoder.encode(queryParameter2, ProtocolPackage.ServerEncoding) + str2);
                        }
                        if (!Util.isNullOrNil(queryParameter3)) {
                            hsp.setCookie(str3, "pass_ticket=" + URLEncoder.encode(queryParameter3, ProtocolPackage.ServerEncoding) + str2);
                            z = true;
                        } else {
                            z = z4;
                        }
                    } else {
                        Iterator<dl> it = aVar.xIw.iterator();
                        while (it.hasNext()) {
                            dl next = it.next();
                            if (!Util.isNullOrNil(next.xMX)) {
                                String queryParameter4 = parse.getQueryParameter(next.xMX);
                                String str5 = Util.isNullOrNil(next.xMY) ? next.xMX : next.xMY;
                                Log.i("MicroMsg.LuggageGetA8KeyUtil", "key = %s, value = %s", str5, queryParameter4);
                                if (!Util.isNullOrNil(queryParameter4)) {
                                    hsp.setCookie(str3, str5 + "=" + URLEncoder.encode(queryParameter4, ProtocolPackage.ServerEncoding) + str2);
                                    z2 = true;
                                    z4 = z2;
                                }
                            }
                            z2 = z4;
                            z4 = z2;
                        }
                        z = z4;
                    }
                    Log.i("MicroMsg.LuggageGetA8KeyUtil", "hasSetCookie=".concat(String.valueOf(z)));
                    if (z) {
                        hsp.setCookie(str3, "cookie_passkey=1".concat(String.valueOf(str)));
                    }
                    com.tencent.xweb.d.hsr();
                    com.tencent.xweb.d.sync();
                    String cookie = hsp.getCookie(str3);
                    Log.i("MicroMsg.LuggageGetA8KeyUtil", "after set cookies:%s", cookie);
                    mMWebView.evaluateJavascript("javascript:if(window.__GAME_LOGIN_CALLBACK) {window.__GAME_LOGIN_CALLBACK({\"cookie_passkey\":1});}", null);
                    com.tencent.mm.game.report.api.a.hhr.a(10, z ? "SET_COOKIE_SUCCESS" : "SET_COOKIE_FAIL", URLEncoder.encode(cookie, ProtocolPackage.ServerEncoding), 0);
                    AppMethodBeat.o(180129);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.LuggageGetA8KeyUtil", e2, "", new Object[0]);
                    com.tencent.mm.game.report.api.a.hhr.a(10, "SET_COOKIE_FAIL", "exception", 0);
                    AppMethodBeat.o(180129);
                }
            }
        });
        AppMethodBeat.o(180131);
    }
}
