package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.om;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements h {
    static /* synthetic */ String aWV(String str) {
        AppMethodBeat.i(201776);
        Map<String, String> br = com.tencent.mm.plugin.websearch.c.a.br(22, false);
        br.put("sessionId", str);
        String bd = com.tencent.mm.plugin.websearch.c.a.bd(br);
        AppMethodBeat.o(201776);
        return bd;
    }

    static /* synthetic */ int fXq() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void a(final ag agVar) {
        AppMethodBeat.i(201769);
        ((i) g.af(i.class)).a(agVar.context, new Runnable() {
            /* class com.tencent.mm.plugin.websearch.a.AnonymousClass1 */

            public final void run() {
                String str;
                AppMethodBeat.i(116526);
                if (!ai.afs(0)) {
                    Log.e("StartWebSearchService", "fts h5 template not avail");
                    AppMethodBeat.o(116526);
                    return;
                }
                Log.i("StartWebSearchService", "startWebSearch");
                a.b(agVar);
                String valueOf = String.valueOf(System.currentTimeMillis());
                String afq = ai.afq(agVar.scene);
                int i2 = 0;
                String str2 = null;
                if (agVar.dVU != null) {
                    i2 = Util.safeParseInt(agVar.dVU.get("chatSearch"));
                    str2 = agVar.dVU.get("reqKey");
                }
                if (!Util.isNullOrNil(agVar.IEr)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("parentSearchID", agVar.IEr);
                    } catch (Exception e2) {
                    }
                    str = Uri.encode(jSONObject.toString());
                } else {
                    str = "";
                }
                Log.i("StartWebSearchService", "preload web search data");
                ai.a(valueOf, agVar.sessionId, afq, agVar.query, agVar.scene, "", -1, agVar.IEr, i2, str2, agVar.dVU);
                Map<String, String> a2 = ai.a(agVar.scene, agVar.IEk, agVar.type, str, "", agVar.sessionId, agVar.query, "", afq, "", valueOf);
                if (agVar.dVU != null) {
                    a2.putAll(agVar.dVU);
                }
                try {
                    a2.put(SearchIntents.EXTRA_QUERY, q.encode(agVar.query, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (Exception e3) {
                    a2.put(SearchIntents.EXTRA_QUERY, agVar.query);
                }
                a2.put("sessionId", agVar.sessionId);
                a2.put("parentSearchID", agVar.IEr);
                String bd = ai.bd(a2);
                Intent fXX = ai.fXX();
                fXX.putExtra("ftsType", agVar.type);
                fXX.putExtra("title", agVar.title);
                fXX.putExtra("ftsbizscene", agVar.scene);
                fXX.putExtra("ftsQuery", agVar.query);
                fXX.putExtra("ftsInitToSearch", !TextUtils.isEmpty(agVar.query) || agVar.IEl);
                fXX.putExtra("sessionId", agVar.sessionId);
                fXX.putExtra("subSessionId", afq);
                fXX.putExtra("rawUrl", bd);
                fXX.putExtra("key_preload_biz", a.fXq());
                fXX.putExtra("key_weapp_url", a.aWV(agVar.sessionId));
                fXX.putExtra("hideSearchInput", agVar.IEm);
                fXX.putExtra("key_back_btn_type", agVar.IEn);
                fXX.putExtra("key_hide_shadow_view", agVar.IEo);
                fXX.putExtra("first_page_result", agVar.IEq);
                if (agVar.IEp) {
                    fXX.putExtra("status_bar_style", "black");
                }
                if (agVar.statusBarColor != Integer.MAX_VALUE) {
                    fXX.putExtra("customize_status_bar_color", agVar.statusBarColor);
                }
                fXX.putExtra("key_load_js_without_delay", true);
                if (agVar.scene == 56) {
                    fXX.putExtra("ftsneedkeyboard", true);
                }
                c.b(agVar.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", fXX);
                a.fXr();
                AppMethodBeat.o(116526);
            }
        });
        AppMethodBeat.o(201769);
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void M(Context context, String str, String str2) {
        AppMethodBeat.i(116527);
        a(context, 16, str, str2, null);
        AppMethodBeat.o(116527);
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void a(Context context, int i2, String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(116528);
        b(context, i2, str, str2, true, map, "");
        AppMethodBeat.o(116528);
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void a(Context context, int i2, String str, String str2, Map<String, String> map, String str3, int i3) {
        AppMethodBeat.i(116529);
        a(context, i2, str, str2, true, map, false, i3, str3, 0, true);
        AppMethodBeat.o(116529);
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void a(Context context, int i2, String str, String str2, boolean z, Map<String, String> map, int i3) {
        AppMethodBeat.i(201770);
        a(context, i2, str, str2, z, map, false, Integer.MAX_VALUE, "", i3, true);
        AppMethodBeat.o(201770);
    }

    private void a(Context context, int i2, String str, String str2, boolean z, Map<String, String> map, String str3) {
        AppMethodBeat.i(201771);
        a(context, i2, str, str2, z, map, false, Integer.MAX_VALUE, str3);
        AppMethodBeat.o(201771);
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void b(Context context, int i2, String str, String str2, boolean z, Map<String, String> map, String str3) {
        AppMethodBeat.i(201772);
        a(context, i2, str, str2, true, map, str3);
        AppMethodBeat.o(201772);
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void a(Context context, String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(116533);
        a(context, 3, str, str2, true, map, true, -1, "");
        AppMethodBeat.o(116533);
    }

    private void a(Context context, int i2, String str, String str2, boolean z, Map<String, String> map, boolean z2, int i3, String str3) {
        AppMethodBeat.i(116534);
        a(context, i2, str, str2, z, map, z2, i3, str3, 0, false);
        AppMethodBeat.o(116534);
    }

    @Override // com.tencent.mm.plugin.websearch.api.h
    public final void b(Context context, int i2, String str, String str2) {
        AppMethodBeat.i(201773);
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("key_trust_url", true);
        intent.putExtra("KRightBtn", true);
        intent.putExtra("ftsneedkeyboard", true);
        intent.putExtra("ftsType", 64);
        intent.putExtra("ftsbizscene", i2);
        Map<String, String> br = com.tencent.mm.plugin.websearch.c.a.br(i2, false);
        String aXE = b.aXE();
        br.put("WASessionId", aXE);
        if (!Util.isNullOrNil(str2)) {
            br.put(SearchIntents.EXTRA_QUERY, str2);
        }
        br.put("sessionId", aXE);
        br.put("subSessionId", aXE);
        intent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.c.a.bd(br));
        intent.putExtra("key_load_js_without_delay", true);
        intent.addFlags(67108864);
        intent.putExtra("key_session_id", aXE);
        intent.putExtra("sessionId", aXE);
        intent.putExtra("subSessionId", aXE);
        intent.putExtra("ftsQuery", str2);
        intent.putExtra("key_preload_biz", 5);
        if (!Util.isNullOrNil(str)) {
            intent.putExtra("key_search_place_holder", str);
        } else {
            Object obj = g.aAh().azQ().get(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, (Object) null);
            if (obj != null && (obj instanceof String)) {
                intent.putExtra("key_search_input_hint", (String) obj);
            }
        }
        c.b(context, "appbrand", ".ui.AppBrandSearchUI", intent);
        AppMethodBeat.o(201773);
    }

    private void a(final Context context, final int i2, final String str, final String str2, final boolean z, final Map<String, String> map, final boolean z2, final int i3, final String str3, final int i4, final boolean z3) {
        AppMethodBeat.i(201774);
        ((i) g.af(i.class)).a(context, new Runnable() {
            /* class com.tencent.mm.plugin.websearch.a.AnonymousClass2 */
            final /* synthetic */ boolean IDc = false;
            final /* synthetic */ int IDd = 0;
            final /* synthetic */ boolean IDe = false;

            public final void run() {
                AppMethodBeat.i(201768);
                if (!ai.afs(0)) {
                    Log.e("StartWebSearchService", "fts h5 template not avail");
                    AppMethodBeat.o(201768);
                } else if (!WeChatBrands.Business.Entries.DiscoverySearch.checkAvailable(context)) {
                    AppMethodBeat.o(201768);
                } else {
                    String str = "";
                    int i2 = -1;
                    JSONObject jSONObject = new JSONObject();
                    String str2 = "";
                    int i3 = 0;
                    if (map != null) {
                        String str3 = (String) map.get("sugId");
                        if (map.containsKey("parentSearchID")) {
                            str2 = (String) map.get("parentSearchID");
                        } else {
                            str2 = (map.containsKey("clickType") ? ((String) map.get("clickType")) + ":" : "0:") + str3 + ":" + str + ":";
                        }
                        try {
                            jSONObject.put("parentSearchID", str2);
                        } catch (JSONException e2) {
                            Log.printDebugStack("StartWebSearchService", "", e2);
                        }
                        i2 = Util.safeParseInt((String) map.get("sceneActionType"));
                        i3 = Util.safeParseInt((String) map.get("chatSearch"));
                        str = (String) map.get("sugId");
                    }
                    Log.i("StartWebSearchService", "startWebSearch parentSearchID=%s,scene=%s", str2, Integer.valueOf(i2));
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    String afq = ai.afq(i2);
                    if (z && i4 == 0 && i3 == 0) {
                        Log.i("StartWebSearchService", "preload web search data");
                        ai.a(valueOf, str2, afq, str, i2, str, i2, str2, i3, (String) null, (Map<String, String>) null);
                    }
                    om omVar = new om();
                    omVar.dUz.scene = 0;
                    EventCenter.instance.publish(omVar);
                    Map<String, String> a2 = ai.a(i2, z, i4, Uri.encode(jSONObject.toString()), "", str2, str, "", afq, "", valueOf);
                    if (map != null) {
                        a2.putAll(map);
                    }
                    try {
                        a2.put(SearchIntents.EXTRA_QUERY, q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                    } catch (Exception e3) {
                        a2.put(SearchIntents.EXTRA_QUERY, str);
                    }
                    a2.put("sessionId", str2);
                    String bd = ai.bd(a2);
                    ah.a(i2, str2, afq, z, str, i4, "", "");
                    Intent fXX = ai.fXX();
                    fXX.putExtra("ftsType", i4);
                    fXX.putExtra("title", str3);
                    fXX.putExtra("ftsbizscene", i2);
                    fXX.putExtra("ftsQuery", str);
                    fXX.putExtra("ftsInitToSearch", !TextUtils.isEmpty(str) || z3);
                    fXX.putExtra("sessionId", str2);
                    fXX.putExtra("subSessionId", afq);
                    fXX.putExtra("rawUrl", bd);
                    fXX.putExtra("key_preload_biz", a.fXq());
                    fXX.putExtra("key_weapp_url", a.aWV(str2));
                    fXX.putExtra("hideSearchInput", this.IDc);
                    fXX.putExtra("key_back_btn_type", this.IDd);
                    fXX.putExtra("key_hide_shadow_view", this.IDe);
                    if (z2) {
                        fXX.putExtra("status_bar_style", "black");
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        fXX.putExtra("customize_status_bar_color", i3);
                    }
                    fXX.putExtra("key_load_js_without_delay", true);
                    if (i2 == 56) {
                        fXX.putExtra("ftsneedkeyboard", true);
                    }
                    c.b(context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", fXX);
                    a.fXr();
                    AppMethodBeat.o(201768);
                }
            }
        });
        AppMethodBeat.o(201774);
    }

    static /* synthetic */ void b(ag agVar) {
        AppMethodBeat.i(201775);
        if (!(agVar.dVU == null || agVar.IEt == null || agVar.IEt.size() <= 0)) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : agVar.IEt.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                agVar.dVU.put("extClientParams", Uri.encode(jSONObject.toString()));
                AppMethodBeat.o(201775);
                return;
            } catch (JSONException e2) {
                Log.printDebugStack("StartWebSearchService", "", e2);
            }
        }
        AppMethodBeat.o(201775);
    }

    static /* synthetic */ void fXr() {
        AppMethodBeat.i(201777);
        ai.LW(1000);
        AppMethodBeat.o(201777);
    }
}
