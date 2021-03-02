package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.LinkedList;
import org.json.JSONObject;

public class y extends br {
    static /* synthetic */ void a(y yVar, b.a aVar) {
        AppMethodBeat.i(186878);
        yVar.c(aVar);
        AppMethodBeat.o(186878);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openGameUrlWithExtraWebView";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b.a aVar) {
        AppMethodBeat.i(83083);
        Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
        JSONObject optJSONObject = aVar.ctb.csi.optJSONObject("liteAppInfo");
        if (optJSONObject != null) {
            Context context = MMApplicationContext.getContext();
            AnonymousClass1 r2 = new a.AbstractC1459a() {
                /* class com.tencent.mm.plugin.game.luggage.b.y.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                public final void dTt() {
                    AppMethodBeat.i(186874);
                    Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openLiteApp success");
                    aVar.c("", null);
                    String bcO = d.bcO(aVar.ctb.csi.optString("url"));
                    if (!Util.isNullOrNil(bcO)) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(bcO);
                        WepkgVersionUpdater.F(linkedList, 4);
                    }
                    AppMethodBeat.o(186874);
                }

                @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                public final void dTu() {
                    AppMethodBeat.i(186875);
                    y.a(y.this, aVar);
                    AppMethodBeat.o(186875);
                }
            };
            if (optJSONObject == null) {
                r2.dTu();
                AppMethodBeat.o(83083);
                return;
            }
            String optString = optJSONObject.optString("appId");
            if (Util.isNullOrNil(optString)) {
                Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp appId is null");
                r2.dTu();
                AppMethodBeat.o(83083);
                return;
            }
            f.ecC();
            if (f.aCT(optString) == null) {
                Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp");
                r2.dTu();
                AppMethodBeat.o(83083);
                return;
            }
            String optString2 = optJSONObject.optString("path");
            String optString3 = optJSONObject.optString(SearchIntents.EXTRA_QUERY);
            Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp, appId : %s, path : %s, query : %s", optString, optString2, optString3);
            Bundle bundle = new Bundle();
            bundle.putString("appId", optString);
            bundle.putString("path", optString2);
            bundle.putString(SearchIntents.EXTRA_QUERY, optString3);
            ((a) g.af(a.class)).a(context, bundle, false, r2);
            AppMethodBeat.o(83083);
            return;
        }
        c(aVar);
        AppMethodBeat.o(83083);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    private void c(b.a aVar) {
        int i2;
        AppMethodBeat.i(186877);
        final String optString = aVar.ctb.csi.optString("url");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
            aVar.c("fail", null);
            AppMethodBeat.o(186877);
            return;
        }
        Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", optString);
        final s last = j.gbV().getLast();
        if (last == null) {
            AppMethodBeat.o(186877);
            return;
        }
        String optString2 = aVar.ctb.csi.optString("html");
        Uri parse = Uri.parse(optString);
        if (Util.nullAsNil(parse.getQueryParameter("not_in_game_luggage")).equals("1") || (parse.getHost() != null && !parse.getHost().equals(WeChatHosts.domainString(R.string.e1h)))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            aVar.c("", null);
            AppMethodBeat.o(186877);
            return;
        }
        String optString3 = aVar.ctb.csi.optString("statusBarColor");
        if (!Util.isNullOrNil(optString3)) {
            try {
                i2 = Color.parseColor(optString3);
            } catch (IllegalArgumentException e2) {
                Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", e2.getMessage());
                aVar.c("invalid_color", null);
                AppMethodBeat.o(186877);
                return;
            }
        } else {
            i2 = 0;
        }
        String optString4 = aVar.ctb.csi.optString("statusBarStyle");
        String optString5 = aVar.ctb.csi.optString("preInjectData");
        final Bundle bundle = new Bundle();
        bundle.putString("rawUrl", optString);
        bundle.putInt("customize_status_bar_color", i2);
        bundle.putString("status_bar_style", optString4);
        bundle.putString("game_pre_inject_data", optString5);
        bundle.putBoolean("from_find_more_friend", last.mParams.getBoolean("from_find_more_friend", false));
        if (!Util.isNullOrNil(optString2)) {
            bundle.putString("game_open_html", optString2);
        }
        if (last.mContext instanceof LuggageGameHalfWebViewUI) {
            Intent intent2 = new Intent();
            intent2.putExtras(bundle);
            c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.b.y.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(186876);
                    last.ctg.Ly().h(optString, bundle);
                    AppMethodBeat.o(186876);
                }
            });
        }
        aVar.c("", null);
        AppMethodBeat.o(186877);
    }
}
