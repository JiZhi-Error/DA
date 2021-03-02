package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class ad extends bs {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "jumpToBizProfile";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78569);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("tousername");
            String optString2 = jSONObject.optString("extmsg");
            Log.d("MicroMsg.JsApiJumpToBizProfile", "doJumpToBizProfile %s, %s", optString, optString2);
            String optString3 = jSONObject.optString("currentUrl");
            Intent intent = new Intent();
            intent.putExtra("toUserName", optString);
            intent.putExtra(IssueStorage.COLUMN_EXT_INFO, optString2);
            intent.putExtra("fromURL", optString3);
            intent.putExtra("source", 2);
            a.jRt.a(intent, hashCode() & 65535, new MMActivity.a() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.ad.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(78568);
                    if (i2 == (ad.this.hashCode() & 65535)) {
                        Log.i("MicroMsg.JsApiJumpToBizProfile", "request jumpToBizProfile, resultCode = ".concat(String.valueOf(i3)));
                        switch (i3) {
                            case -1:
                                aVar.i(null, null);
                                AppMethodBeat.o(78568);
                                return;
                            case 0:
                                aVar.i("cancel", null);
                                AppMethodBeat.o(78568);
                                return;
                            case 1:
                            default:
                                aVar.i("fail", null);
                                Log.e("MicroMsg.JsApiJumpToBizProfile", "unknown resultCode");
                                break;
                            case 2:
                            case 3:
                                aVar.i("check_fail", null);
                                AppMethodBeat.o(78568);
                                return;
                        }
                    }
                    AppMethodBeat.o(78568);
                }
            }, (MMActivity) context);
            AppMethodBeat.o(78569);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiJumpToBizProfile", "parase json fail");
            aVar.i("fail", null);
            AppMethodBeat.o(78569);
        }
    }
}
