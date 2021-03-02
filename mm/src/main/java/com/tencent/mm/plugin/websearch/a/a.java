package com.tencent.mm.plugin.websearch.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.a.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.h;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0017J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0017J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0017J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0017J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0017J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;)V", "TAG", "", "appendSearchTag", NativeProtocol.WEB_DIALOG_PARAMS, "getReportType", "", "getSearchData", "getSearchSuggestionData", "getUIComponent", "onSearchDataReady", "", "newQuery", "", "json", "requestId", "onSearchInputChange", SearchIntents.EXTRA_QUERY, "custom", "onSearchInputConfirm", "onSearchSuggestionDataReady", "openSearchWebView", "openWeAppPage", "setSearchInputWord", "setSearchTagResult", "startSearchItemDetailPage", "Companion", "ui-websearch_release"})
public final class a extends h<egj> {
    public static final C1938a IFU = new C1938a((byte) 0);
    private final String TAG = "MicroMsg.WebSearch.TagSearchJSApi";

    static {
        AppMethodBeat.i(197943);
        AppMethodBeat.o(197943);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(bVar);
        p.h(bVar, "uiComponent");
        AppMethodBeat.i(197942);
        AppMethodBeat.o(197942);
    }

    public static final /* synthetic */ b a(a aVar) {
        AppMethodBeat.i(197944);
        b fYC = aVar.fYC();
        AppMethodBeat.o(197944);
        return fYC;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.b
    public final int ddN() {
        return 1;
    }

    @JavascriptInterface
    public final String getSearchSuggestionData(String str) {
        d fYG;
        AppMethodBeat.i(197931);
        Log.i(this.TAG, "getSearchSuggestionData ".concat(String.valueOf(str)));
        if (str != null) {
            b fYC = fYC();
            if (!(fYC == null || (fYG = fYC.fYG()) == null)) {
                p.h(str, "paramsStr");
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    v vVar = new v();
                    try {
                        vVar.dDv = URLDecoder.decode(jSONObject.optString(SearchIntents.EXTRA_QUERY, ""), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    } catch (Exception e2) {
                    }
                    vVar.businessType = jSONObject.optInt("type", 0);
                    vVar.scene = jSONObject.optInt("scene", 0);
                    vVar.IDE = jSONObject.optInt("isHomePage", 0);
                    vVar.dVL = fYG.fXz();
                    String optString = jSONObject.optString("prefixQuery", "");
                    String str2 = optString;
                    if (!(!(str2 == null || str2.length() == 0))) {
                        optString = null;
                    }
                    if (optString != null) {
                        vVar.IDJ.add(optString);
                    }
                    int optInt = jSONObject.optInt("requestType", 0);
                    vVar.wVW = jSONObject.optInt("subtype", 0);
                    switch (optInt) {
                        case 0:
                            g.azz().b(new s(vVar));
                            break;
                    }
                } catch (Exception e3) {
                }
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(197931);
            return valueOf;
        }
        String valueOf2 = String.valueOf(fYR());
        AppMethodBeat.o(197931);
        return valueOf2;
    }

    @JavascriptInterface
    public final String getSearchData(String str) {
        d fYG;
        AppMethodBeat.i(197932);
        Log.i(this.TAG, "getSearchData ".concat(String.valueOf(str)));
        if (str != null) {
            b fYC = fYC();
            if (!(fYC == null || (fYG = fYC.fYG()) == null)) {
                p.h(str, "paramsStr");
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = jSONObject.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String next = keys.next();
                            p.g(next, LocaleUtil.ITALIAN);
                            hashMap.put(next, jSONObject.opt(next));
                        }
                    }
                    g.azz().b(new x(fYG.bh(hashMap)));
                } catch (Exception e2) {
                }
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(197932);
            return valueOf;
        }
        String valueOf2 = String.valueOf(fYR());
        AppMethodBeat.o(197932);
        return valueOf2;
    }

    @JavascriptInterface
    public final String appendSearchTag(String str) {
        AppMethodBeat.i(197933);
        Log.i(this.TAG, "appendSearchTag ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
            String optString2 = jSONObject.optString("searchId", "");
            String optString3 = jSONObject.optString("sessionId", "");
            String optString4 = jSONObject.optString("requestId", "");
            b fYC = fYC();
            if (fYC != null) {
                p.g(optString, "tag");
                p.g(optString3, "sessionId");
                p.g(optString2, "searchId");
                p.g(optString4, "requestId");
                fYC.F(optString, optString3, optString2, optString4);
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(197933);
            return valueOf;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(fYR());
            AppMethodBeat.o(197933);
            return valueOf2;
        }
    }

    @JavascriptInterface
    public final String setSearchTagResult(String str) {
        d fYG;
        WebSearchWebView webSearchWebView;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        AppMethodBeat.i(197934);
        Log.i(this.TAG, "setSearchTagResult ".concat(String.valueOf(str)));
        if (str != null) {
            b fYC = fYC();
            if (!(fYC == null || (fYG = fYC.fYG()) == null)) {
                p.h(str, "paramsStr");
                try {
                    q qVar = fYG.IGc;
                    if (qVar != null) {
                        g.azz().a(qVar);
                        fYG.IGc = null;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    buu buu = new buu();
                    buu.Scene = jSONObject.optInt("scene", 0);
                    buu.SessionId = jSONObject.optString("sessionId", "");
                    buu.Mba = jSONObject.optString("requestId", "");
                    buu.Mbb = jSONObject.optString("searchId", "");
                    buu.KXA = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
                    buu.iAc = jSONObject.optString("content", "");
                    buu.MaY = jSONObject.optInt("h5Version", 0);
                    q qVar2 = new q(buu, fYG.fXz());
                    g.azz().b(qVar2);
                    fYG.IGc = qVar2;
                    JSONObject optJSONObject = jSONObject.optJSONObject("screenshot");
                    b fYE = fYG.fYE();
                    if (fYE != null) {
                        webSearchWebView = fYE.dQg();
                    } else {
                        webSearchWebView = null;
                    }
                    if (!(optJSONObject == null || webSearchWebView == null)) {
                        b fYE2 = fYG.fYE();
                        if (fYE2 != null) {
                            context = fYE2.getActivityContext();
                        } else {
                            context = null;
                        }
                        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, optJSONObject.optInt("x", 0));
                        b fYE3 = fYG.fYE();
                        if (fYE3 != null) {
                            context2 = fYE3.getActivityContext();
                        } else {
                            context2 = null;
                        }
                        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(context2, optJSONObject.optInt("y", 0));
                        b fYE4 = fYG.fYE();
                        if (fYE4 != null) {
                            context3 = fYE4.getActivityContext();
                        } else {
                            context3 = null;
                        }
                        int fromDPToPix3 = com.tencent.mm.cb.a.fromDPToPix(context3, optJSONObject.optInt("w", 0));
                        b fYE5 = fYG.fYE();
                        if (fYE5 != null) {
                            context4 = fYE5.getActivityContext();
                        } else {
                            context4 = null;
                        }
                        Bitmap cropBitmap = BitmapUtil.cropBitmap(webSearchWebView.getBitmap(), fromDPToPix, fromDPToPix2, fromDPToPix3, com.tencent.mm.cb.a.fromDPToPix(context4, optJSONObject.optInt("h", 0)), true);
                        q qVar3 = fYG.IGc;
                        if (qVar3 != null) {
                            qVar3.aG(cropBitmap);
                        }
                    }
                    b fYE6 = fYG.fYE();
                    if (fYE6 != null) {
                        String str2 = buu.Mba;
                        p.g(str2, "request.RequestId");
                        fYE6.aXn(str2);
                    }
                } catch (Exception e2) {
                }
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(197934);
            return valueOf;
        }
        String valueOf2 = String.valueOf(fYR());
        AppMethodBeat.o(197934);
        return valueOf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0210  */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String openWeAppPage(java.lang.String r16) {
        /*
        // Method dump skipped, instructions count: 531
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.a.a.openWeAppPage(java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public final String setSearchInputWord(String str) {
        AppMethodBeat.i(197936);
        Log.i(this.TAG, "setSearchInputWord ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            d.h(new b(this, jSONObject.optString("word", ""), jSONObject.optBoolean("isInputChange", false)));
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(197936);
            return valueOf;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(fYR());
            AppMethodBeat.o(197936);
            return valueOf2;
        }
    }

    @JavascriptInterface
    public final String startSearchItemDetailPage(String str) {
        AppMethodBeat.i(197937);
        Log.i(this.TAG, "startSearchItemDetailPage ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("scene", 0);
            int optInt2 = jSONObject.optInt("type", 0);
            int optInt3 = jSONObject.optInt("subType", 0);
            String optString = jSONObject.optString("srcUserName", "");
            String optString2 = jSONObject.optString("jumpUrl", "");
            String optString3 = jSONObject.optString("cookie", "");
            String optString4 = jSONObject.optString("publishId", "");
            int optInt4 = jSONObject.optInt("payScene", 0);
            switch (optInt2) {
                case 1:
                    p.h(jSONObject, "requestObj");
                    String optString5 = jSONObject.optString("userName", "");
                    String optString6 = jSONObject.optString("nickName", "");
                    String optString7 = jSONObject.optString("headHDImgUrl", "");
                    int optInt5 = jSONObject.optInt("verifyFlag", 0);
                    String optString8 = jSONObject.optString("signature", "");
                    aeq aeq = new aeq();
                    aeq.kem = jSONObject.optInt("brandFlag", 0);
                    aeq.kep = jSONObject.optString("iconUrl", "");
                    aeq.keo = jSONObject.optString("brandInfo", "");
                    aeq.ken = jSONObject.optString("externalInfo", "");
                    String optString9 = jSONObject.optString("searchId", "");
                    String optString10 = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
                    int optInt6 = jSONObject.optInt("position", 0);
                    String optString11 = jSONObject.optString("extraParams", "");
                    am.aXh(optString5);
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", optString5);
                    intent.putExtra("Contact_Nick", optString6);
                    intent.putExtra("Contact_BrandIconURL", optString7);
                    intent.putExtra("Contact_Signature", optString8);
                    intent.putExtra("Contact_VUser_Info_Flag", optInt5);
                    intent.putExtra("Contact_Scene", 0);
                    try {
                        intent.putExtra("Contact_customInfo", aeq.toByteArray());
                    } catch (IOException e2) {
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("Contact_Ext_Args_Search_Id", optString9);
                    bundle.putString("Contact_Ext_Args_Query_String", optString10);
                    bundle.putInt("Contact_Scene", 0);
                    bundle.putInt("Contact_Ext_Args_Index", optInt6);
                    bundle.putString("Contact_Ext_Extra_Params", optString11);
                    intent.putExtra("preChatTYPE", 10);
                    intent.putExtra("Contact_Ext_Args", bundle);
                    c.b(MMApplicationContext.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    break;
                case 2:
                case 4:
                case 16:
                    p.g(optString2, "jumpUrl");
                    p.g(optString4, "publishId");
                    p.g(optString, "srcUserName");
                    p.g(optString3, "cookie");
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", optString2);
                    intent2.putExtra("convertActivityFromTranslucent", false);
                    intent2.putExtra("from_scence", optInt);
                    intent2.putExtra("subtype", optInt3);
                    intent2.putExtra("key_h5pay_cookie", optString3);
                    if (!Util.isNullOrNil(optString4)) {
                        intent2.putExtra("prePublishId", optString4);
                        intent2.putExtra("KPublisherId", optString4);
                    }
                    if (optInt4 > 0) {
                        intent2.putExtra("pay_channel", optInt4);
                    }
                    intent2.putExtra("geta8key_scene", 65);
                    intent2.putExtra("preChatTYPE", 10);
                    if (!Util.isNullOrNil(optString)) {
                        intent2.putExtra("srcUsername", optString);
                    }
                    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", intent2);
                    break;
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(197937);
            return valueOf;
        } catch (Exception e3) {
            String valueOf2 = String.valueOf(fYR());
            AppMethodBeat.o(197937);
            return valueOf2;
        }
    }

    @JavascriptInterface
    public final String openSearchWebView(String str) {
        String str2;
        String str3;
        egj egj;
        String optString;
        AppMethodBeat.i(197938);
        Log.i(this.TAG, "openSearchWebView ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString(SearchIntents.EXTRA_QUERY);
            int optInt = jSONObject.optInt("scene", 0);
            int optInt2 = jSONObject.optInt("type", 0);
            int optInt3 = jSONObject.optInt("subType", 0);
            String optString3 = jSONObject.optString("searchId", "");
            String optString4 = jSONObject.optString("sessionId", "");
            jSONObject.optString("subSessionId", "");
            int optInt4 = jSONObject.optInt("actionType", 0);
            String optString5 = jSONObject.optString("extParams", "");
            jSONObject.optString("docID", "");
            jSONObject.optInt("hideSearchBar", 0);
            jSONObject.optString("navBarColor", "");
            jSONObject.optString("statusBarStyle", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("nativeConfig");
            if (optJSONObject == null || (optString = optJSONObject.optString("title")) == null) {
                str2 = "";
            } else {
                str2 = optString;
            }
            switch (optInt4) {
                case 3:
                    Map<String, String> a2 = ai.a(optInt, false, optInt2, optString5);
                    a2.put(SearchIntents.EXTRA_QUERY, optString2);
                    a2.put("searchId", optString3);
                    a2.put("subType", String.valueOf(optInt3));
                    a2.put("sessionId", optString4);
                    a2.put("subSessionId", ai.afq(optInt));
                    egj egj2 = new egj();
                    b fYC = fYC();
                    if (fYC == null || (egj = (egj) fYC.dQl()) == null || (str3 = egj.talker) == null) {
                        str3 = "";
                    }
                    egj2.talker = str3;
                    c cVar = c.IFY;
                    p.g(a2, "urlParams");
                    egj2.url = c.bf(a2);
                    egj2.dDv = optString2;
                    egj2.scene = optInt;
                    egj2.hes = optString3;
                    egj2.sessionId = optString4;
                    egj2.dPI = ai.afq(optInt);
                    egj2.title = str2;
                    b fYC2 = fYC();
                    if (fYC2 != null) {
                        fYC2.a(egj2);
                        break;
                    }
                    break;
            }
            String valueOf = String.valueOf(fYQ());
            AppMethodBeat.o(197938);
            return valueOf;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(fYR());
            AppMethodBeat.o(197938);
            return valueOf2;
        }
    }

    public final void lK(String str, String str2) {
        WebSearchWebView dQg;
        AppMethodBeat.i(197939);
        p.h(str, SearchIntents.EXTRA_QUERY);
        p.h(str2, "custom");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SearchIntents.EXTRA_QUERY, str);
            jSONObject.put("custom", str2);
        } catch (Exception e2) {
        }
        com.tencent.mm.plugin.websearch.webview.d<T> dVar = this.IHe;
        if (dVar == null || (dQg = dVar.dQg()) == null) {
            AppMethodBeat.o(197939);
            return;
        }
        i iVar = i.IHk;
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "requestObj.toString()");
        i.a(dQg, "onSearchInputChange", jSONObject2);
        AppMethodBeat.o(197939);
    }

    public final void e(boolean z, String str, String str2) {
        WebSearchWebView dQg;
        AppMethodBeat.i(197940);
        p.h(str, "json");
        p.h(str2, "requestId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("newQuery", z);
            jSONObject.put("json", str);
            jSONObject.put("requestId", str2);
        } catch (Exception e2) {
        }
        com.tencent.mm.plugin.websearch.webview.d<T> dVar = this.IHe;
        if (dVar == null || (dQg = dVar.dQg()) == null) {
            AppMethodBeat.o(197940);
            return;
        }
        i iVar = i.IHk;
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "requestObj.toString()");
        i.a(dQg, "onSearchDataReady", jSONObject2);
        AppMethodBeat.o(197940);
    }

    public final void aXm(String str) {
        WebSearchWebView dQg;
        AppMethodBeat.i(197941);
        p.h(str, "json");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("json", str);
        } catch (Exception e2) {
        }
        com.tencent.mm.plugin.websearch.webview.d<T> dVar = this.IHe;
        if (dVar == null || (dQg = dVar.dQg()) == null) {
            AppMethodBeat.o(197941);
            return;
        }
        i iVar = i.IHk;
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "requestObj.toString()");
        i.a(dQg, "onSearchSuggestionDataReady", jSONObject2);
        AppMethodBeat.o(197941);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J@\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi$Companion;", "", "()V", "startSearchItemDetailPageBizContact", "", "requestObj", "Lorg/json/JSONObject;", "startSearchItemDetailPageUrl", "url", "", "publishIdFromSearch", "payScene", "", "srcUserName", "searchScene", "subType", "h5PayCookie", "ui-websearch_release"})
    /* renamed from: com.tencent.mm.plugin.websearch.a.a$a  reason: collision with other inner class name */
    public static final class C1938a {
        private C1938a() {
        }

        public /* synthetic */ C1938a(byte b2) {
            this();
        }
    }

    private final b fYC() {
        com.tencent.mm.plugin.websearch.webview.d<T> dVar = this.IHe;
        if (!(dVar instanceof b)) {
            dVar = null;
        }
        return (b) dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ a IFV;
        final /* synthetic */ String IFW;
        final /* synthetic */ boolean IFX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, boolean z) {
            super(0);
            this.IFV = aVar;
            this.IFW = str;
            this.IFX = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(197930);
            com.tencent.mm.plugin.websearch.a.a.b a2 = a.a(this.IFV);
            if (a2 != null) {
                String str = this.IFW;
                p.g(str, SearchIntents.EXTRA_QUERY);
                a2.cK(str, this.IFX);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(197930);
            return xVar;
        }
    }
}
