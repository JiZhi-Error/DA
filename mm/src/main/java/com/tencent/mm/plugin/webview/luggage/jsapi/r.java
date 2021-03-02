package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class r extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(175742);
        Intent intent = new Intent();
        String url = aVar.cta.getUrl();
        intent.putExtra("req_url", url);
        String appId = aVar.cta.ITw.getAppId();
        if (Util.isNullOrNil(appId) && !Util.isNullOrNil(url) && Uri.parse(url).getHost().equals(WeChatHosts.domainString(R.string.e1h))) {
            appId = "wx62d9035fd4fd2059";
        }
        intent.putExtra("req_app_id", appId);
        intent.putExtra("launch_from_webview", true);
        ((MMActivity) aVar.cta.mContext).mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.r.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(175741);
                if (i2 == (r.this.hashCode() & 65535)) {
                    ((MMActivity) aVar.cta.mContext).mmSetOnActivityResultCallback(null);
                    if (i3 == -1 && intent != null) {
                        String nullAs = Util.nullAs(intent.getStringExtra("nationalCode"), "");
                        String nullAs2 = Util.nullAs(intent.getStringExtra("userName"), "");
                        String nullAs3 = Util.nullAs(intent.getStringExtra("telNumber"), "");
                        String nullAs4 = Util.nullAs(intent.getStringExtra("addressPostalCode"), "");
                        String nullAs5 = Util.nullAs(intent.getStringExtra("proviceFirstStageName"), "");
                        String nullAs6 = Util.nullAs(intent.getStringExtra("addressCitySecondStageName"), "");
                        String nullAs7 = Util.nullAs(intent.getStringExtra("addressCountiesThirdStageName"), "");
                        String nullAs8 = Util.nullAs(intent.getStringExtra("addressDetailInfo"), "");
                        Log.i("MicroMsg.JsApiEditAddress", "first =  " + nullAs5 + " ; detail =" + nullAs8 + "; second = " + nullAs6 + " ; tel = " + nullAs3 + "; third = " + nullAs7);
                        if (!Util.isNullOrNil(nullAs2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("nationalCode", nullAs);
                            hashMap.put("userName", nullAs2);
                            hashMap.put("telNumber", nullAs3);
                            hashMap.put("addressPostalCode", nullAs4);
                            hashMap.put("proviceFirstStageName", nullAs5);
                            hashMap.put("addressCitySecondStageName", nullAs6);
                            hashMap.put("addressCountiesThirdStageName", nullAs7);
                            hashMap.put("addressDetailInfo", nullAs8);
                            aVar.e("", hashMap);
                            AppMethodBeat.o(175741);
                            return;
                        }
                    }
                    if (i3 == 0) {
                        aVar.c("cancel", null);
                        AppMethodBeat.o(175741);
                        return;
                    }
                    aVar.c("fail", null);
                }
                AppMethodBeat.o(175741);
            }
        });
        c.a(aVar.cta.mContext, "address", ".ui.WalletSelectAddrUI", intent, hashCode() & 65535, false);
        AppMethodBeat.o(175742);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "editAddress";
    }
}
