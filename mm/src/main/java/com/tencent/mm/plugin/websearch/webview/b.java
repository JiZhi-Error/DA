package com.tencent.mm.plugin.websearch.webview;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.finder.h;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.festival.a.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.as;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J&\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017J\b\u0010 \u001a\u0004\u0018\u00010!J\b\u0010\"\u001a\u0004\u0018\u00010!J\u0014\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "T", "", "()V", "TAG", "", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "setUiComponent", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "getCurrentLocation", "", NativeProtocol.WEB_DIALOG_PARAMS, "getFestivalLiveInfo", "getNetTypeAndSimCard", f.NAME, "getReportType", "", "getSearchDisplayNameList", "log", "onSearchWebQueryReady", "retCode", "errMsg", "json", "requestId", "openFinderFeed", h.NAME, "querySearchWeb", "reportSearchRealTimeStatistics", "reportSearchStatistics", "returnFail", "Lorg/json/JSONObject;", "returnSuccess", "showWeDrawHomeView", "Companion", "ui-websearch_release"})
public class b<T> {
    public static final a IHf = new a((byte) 0);
    public d<T> IHe;
    private final String TAG = "MicroMsg.WebSearch.BaseWebSearchJSApi";

    static {
        AppMethodBeat.i(198057);
        AppMethodBeat.o(198057);
    }

    public int ddN() {
        return 1;
    }

    @JavascriptInterface
    public String reportSearchStatistics(String str) {
        String valueOf;
        AppMethodBeat.i(198045);
        Log.i(this.TAG, "reportSearchStatistics %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            e.INSTANCE.kvStat(jSONObject.optInt("logId", 0), jSONObject.optString("logString", ""));
            valueOf = String.valueOf(fYQ());
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "reportSearchStatistics", new Object[0]);
            valueOf = String.valueOf(fYR());
        }
        AppMethodBeat.o(198045);
        return valueOf;
    }

    @JavascriptInterface
    public final String reportSearchRealTimeStatistics(String str) {
        String valueOf;
        AppMethodBeat.i(198046);
        Log.i(this.TAG, "reportSearchRealTimeStatistics %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            doc doc = new doc();
            doc.MRe = jSONObject.optString("logString", "");
            if (ddN() == 1) {
                g.azz().b(new ad(doc));
            } else {
                g.azz().b(new y(doc));
            }
            valueOf = String.valueOf(fYQ());
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "reportSearchRealTimeStatistics", new Object[0]);
            valueOf = String.valueOf(fYR());
        }
        AppMethodBeat.o(198046);
        return valueOf;
    }

    @JavascriptInterface
    public String getNetworkType(String str) {
        String valueOf;
        String str2;
        AppMethodBeat.i(198047);
        Log.i(this.TAG, "getNetworkType %s", str);
        try {
            JSONObject fYQ = fYQ();
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                str2 = "wifi";
            } else if (ai.isFreeSimCard()) {
                str2 = "wangka";
            } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                str2 = "4g";
            } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                str2 = "3g";
            } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                str2 = "2g";
            } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                str2 = "fail";
            } else {
                str2 = "";
            }
            fYQ.put("subtype", str2);
            if (p.j(str2, "wifi")) {
                fYQ.put("err_msg", "network_type:wifi");
            } else if (p.j(str2, "fail")) {
                fYQ.put("err_msg", "network_type:fail");
            } else {
                fYQ.put("err_msg", "network_type:wwan");
            }
            valueOf = fYQ.toString();
        } catch (Exception e2) {
            valueOf = String.valueOf(fYR());
        }
        AppMethodBeat.o(198047);
        return valueOf;
    }

    @JavascriptInterface
    public String openFinderFeed(String str) {
        String valueOf;
        AppMethodBeat.i(198048);
        try {
            Log.i(this.TAG, "openFinderFeed %s", str);
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("feedId", jSONObject.optString("feedId", ""));
            jSONObject2.put(IssueStorage.COLUMN_EXT_INFO, new JSONObject(jSONObject.optString(IssueStorage.COLUMN_EXT_INFO, "")));
            Intent intent = new Intent();
            ((aj) g.ah(aj.class)).fillContextIdToIntent(7, 2, 25, intent);
            ((aj) g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), jSONObject2.toString(), intent);
            valueOf = String.valueOf(fYQ());
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "openFinderFeed", new Object[0]);
            valueOf = String.valueOf(fYR());
        }
        AppMethodBeat.o(198048);
        return valueOf;
    }

    @JavascriptInterface
    public String openFinderProfile(String str) {
        String valueOf;
        AppMethodBeat.i(198049);
        try {
            Log.i(this.TAG, "openFinderProfile %s", str);
            String optString = new JSONObject(str).optString("userName", "");
            Intent intent = new Intent();
            intent.putExtra("finder_username", optString);
            intent.putExtra("key_from_profile_share_scene", 15);
            intent.putExtra("key_enter_profile_type", 1);
            ((aj) g.ah(aj.class)).fillContextIdToIntent(7, 2, 32, intent);
            ((aj) g.ah(aj.class)).enterFinderProfileUI(MMApplicationContext.getContext(), intent);
            valueOf = String.valueOf(fYQ());
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, h.NAME, new Object[0]);
            valueOf = String.valueOf(fYR());
        }
        AppMethodBeat.o(198049);
        return valueOf;
    }

    @JavascriptInterface
    public String log(String str) {
        AppMethodBeat.i(198050);
        Log.i(this.TAG, "log: %s", str);
        String valueOf = String.valueOf(fYQ());
        AppMethodBeat.o(198050);
        return valueOf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x008e, code lost:
        if (r0 == null) goto L_0x0090;
     */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getCurrentLocation(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.webview.b.getCurrentLocation(java.lang.String):void");
    }

    @JavascriptInterface
    public String getSearchDisplayNameList(String str) {
        String valueOf;
        AppMethodBeat.i(198052);
        try {
            JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("data"));
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.has("id") ? jSONObject.getString("id") : "";
                String string2 = jSONObject.has("userName") ? jSONObject.getString("userName") : "";
                String displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(string2);
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(string2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", string);
                jSONObject2.put("userName", string2);
                jSONObject2.put("displayName", displayName);
                p.g(Kn, "contact");
                jSONObject2.put("displaySex", Kn.ajE());
                jSONArray2.put(jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ret", 0);
            jSONObject3.put("data", jSONArray2.toString());
            valueOf = jSONObject3.toString();
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "getSearchDisplayNameList", new Object[0]);
            valueOf = String.valueOf(fYR());
        }
        AppMethodBeat.o(198052);
        return valueOf;
    }

    @JavascriptInterface
    public String querySearchWeb(String str) {
        a<T> dQk;
        AppMethodBeat.i(198053);
        Log.i(this.TAG, "querySearchWeb ".concat(String.valueOf(str)));
        if (str != null) {
            d<T> dVar = this.IHe;
            if (!(dVar == null || (dQk = dVar.dQk()) == null)) {
                p.h(str, "paramsStr");
                JSONObject jSONObject = new JSONObject(str);
                g.azz().b(new w(jSONObject.optString("requestId", ""), jSONObject.optString("commReq", ""), dQk.fXz()));
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(198053);
            return valueOf;
        }
        String valueOf2 = String.valueOf(fYR());
        AppMethodBeat.o(198053);
        return valueOf2;
    }

    @JavascriptInterface
    public String showWeDrawHomeView(String str) {
        AppMethodBeat.i(259501);
        Log.i(this.TAG, "showWeDrawHomeView: ".concat(String.valueOf(str)));
        try {
            ((com.tencent.mm.plugin.festival.a.a) g.af(com.tencent.mm.plugin.festival.a.a.class)).ba(MMApplicationContext.getContext(), new JSONObject(str).optInt("fromScene", 0));
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(259501);
            return valueOf;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(fYR());
            AppMethodBeat.o(259501);
            return valueOf2;
        }
    }

    @JavascriptInterface
    public String getFestivalLiveInfo(String str) {
        String valueOf;
        int i2;
        AppMethodBeat.i(259502);
        try {
            new JSONObject(str).optInt("fromScene", 0);
            a.C1051a dnB = ((com.tencent.mm.plugin.festival.a.a) g.af(com.tencent.mm.plugin.festival.a.a.class)).dnB();
            JSONObject jSONObject = new JSONObject();
            if (dnB.VC) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            jSONObject.put("isOpen", i2);
            valueOf = jSONObject.toString();
        } catch (Exception e2) {
            valueOf = String.valueOf(fYR());
        }
        AppMethodBeat.o(259502);
        return valueOf;
    }

    public final void h(int i2, String str, String str2, String str3) {
        WebSearchWebView dQg;
        AppMethodBeat.i(198054);
        p.h(str, "errMsg");
        p.h(str2, "json");
        p.h(str3, "requestId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", i2);
            jSONObject.put("errMsg", str);
            jSONObject.put("json", str2);
            jSONObject.put("requestId", str3);
        } catch (Exception e2) {
        }
        d<T> dVar = this.IHe;
        if (dVar == null || (dQg = dVar.dQg()) == null) {
            AppMethodBeat.o(198054);
            return;
        }
        i iVar = i.IHk;
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "requestObj.toString()");
        i.a(dQg, "onSearchWebQueryReady", jSONObject2);
        AppMethodBeat.o(198054);
    }

    public static JSONObject fYQ() {
        AppMethodBeat.i(198055);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(198055);
        return jSONObject;
    }

    public static JSONObject fYR() {
        AppMethodBeat.i(198056);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(198056);
        return jSONObject;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi$Companion;", "", "()V", "REPORT_TYPE_TOPSTORY", "", "REPORT_TYPE_WEBSEARCH", "ui-websearch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
