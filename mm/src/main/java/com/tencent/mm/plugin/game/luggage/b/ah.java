package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.json.JSONObject;

public class ah extends br<com.tencent.luggage.d.a> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setGameData";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<com.tencent.luggage.d.a>.a aVar) {
        String str;
        String optString;
        AppMethodBeat.i(83092);
        Log.i("MicroMsg.JsApiSetGameData", "invokeInOwn");
        JSONObject jSONObject = aVar.ctb.csi;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSetGameData", "data is null");
            aVar.c("null_data", null);
            AppMethodBeat.o(83092);
            return;
        }
        CONTEXT context = aVar.cta;
        if (context instanceof i) {
            str = context.ITw.getAppId();
            if (Util.isNullOrNil(str)) {
                Uri parse = Uri.parse(Util.nullAsNil(context.coX()));
                if (parse.getHost() == null || !parse.getHost().equals(WeChatHosts.domainString(R.string.e1h))) {
                    Log.i("MicroMsg.JsApiSetGameData", "appId is null");
                    aVar.c("appid_null", null);
                    AppMethodBeat.o(83092);
                    return;
                }
            }
            optString = jSONObject.optString("key");
            final String optString2 = jSONObject.optString("value");
            String optString3 = jSONObject.optString("weight", "1");
            String optString4 = jSONObject.optString("expireTime");
            boolean optBoolean = jSONObject.optBoolean("autoClean", true);
            boolean optBoolean2 = jSONObject.optBoolean("pageCache", false);
            if (!Util.isNullOrNil(optString) || Util.isNullOrNil(optString2) || optString.length() > 80) {
                Log.i("MicroMsg.JsApiSetGameData", "key or value is invalid");
                aVar.c("null_key", null);
                AppMethodBeat.o(83092);
            }
            Bundle bundle = new Bundle();
            bundle.putString("appId", str);
            bundle.putString("key", optString);
            bundle.putString("weight", optString3);
            bundle.putString("expireTime", optString4);
            bundle.putBoolean("autoClean", optBoolean);
            com.tencent.mm.plugin.webview.b.b.gam();
            long lM = com.tencent.mm.plugin.webview.b.b.lM(optString, optString2);
            bundle.putLong("storeSize", lM);
            if (lM <= 204800 && !optBoolean2) {
                bundle.putString("value", optString2);
            }
            if (optBoolean2) {
                if (context instanceof i) {
                    boolean z = ((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_open_page_cache, 0) == 1;
                    boolean z2 = context.dTP().JLM;
                    Log.i("MicroMsg.JsApiSetGameData", "isOpenPageCache:%b, allowSetPageCache:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (!z) {
                        aVar.c("close_page_cache", null);
                        AppMethodBeat.o(83092);
                        return;
                    } else if (!z2) {
                        aVar.c("ban_set_page_cache", null);
                        AppMethodBeat.o(83092);
                        return;
                    }
                } else {
                    aVar.c("ban_set_page_cache", null);
                }
            }
            h.a(MainProcessIPCService.dkO, bundle, a.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.game.luggage.b.ah.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(83090);
                    Bundle bundle2 = bundle;
                    if (bundle2.getBoolean("backRet")) {
                        boolean z = bundle2.getBoolean("backIsFile", false);
                        String string = bundle2.getString("backFileName");
                        if (z && !Util.isNullOrNil(string)) {
                            Log.i("MicroMsg.JsApiSetGameData", "store data to file. fileName:%s", string);
                            com.tencent.mm.plugin.webview.b.b.gam();
                            com.tencent.mm.plugin.webview.b.b.lL(string, optString2);
                        }
                        aVar.c("", null);
                        AppMethodBeat.o(83090);
                        return;
                    }
                    aVar.c("exceed_size", null);
                    AppMethodBeat.o(83090);
                }
            });
            AppMethodBeat.o(83092);
            return;
        }
        str = "wx62d9035fd4fd2059";
        optString = jSONObject.optString("key");
        final String optString22 = jSONObject.optString("value");
        String optString32 = jSONObject.optString("weight", "1");
        String optString42 = jSONObject.optString("expireTime");
        boolean optBoolean3 = jSONObject.optBoolean("autoClean", true);
        boolean optBoolean22 = jSONObject.optBoolean("pageCache", false);
        if (!Util.isNullOrNil(optString)) {
        }
        Log.i("MicroMsg.JsApiSetGameData", "key or value is invalid");
        aVar.c("null_key", null);
        AppMethodBeat.o(83092);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            boolean a2;
            AppMethodBeat.i(83091);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("appId");
            String string2 = bundle2.getString("key");
            String string3 = bundle2.getString("value");
            String string4 = bundle2.getString("weight");
            String string5 = bundle2.getString("expireTime");
            boolean z = bundle2.getBoolean("autoClean");
            long j2 = bundle2.getLong("storeSize");
            Bundle bundle3 = new Bundle();
            if (!Util.isNullOrNil(string3)) {
                a2 = com.tencent.mm.plugin.webview.b.b.gam().a(string, string2, string3, string4, string5, z);
            } else {
                a2 = com.tencent.mm.plugin.webview.b.b.gam().a(string, string2, "", string4, string5, z, j2, string2);
                bundle3.putBoolean("backIsFile", true);
                bundle3.putString("backFileName", string2);
            }
            bundle3.putBoolean("backRet", a2);
            dVar.bn(bundle3);
            AppMethodBeat.o(83091);
        }
    }
}
