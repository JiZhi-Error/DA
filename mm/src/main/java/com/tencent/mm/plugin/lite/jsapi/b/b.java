package com.tencent.mm.plugin.lite.jsapi.b;

import android.content.Intent;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends com.tencent.mm.plugin.lite.jsapi.b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        String str2;
        String str3 = null;
        AppMethodBeat.i(198849);
        try {
            if (jSONObject.has("openId")) {
                str2 = jSONObject.getString("openId");
            } else {
                str2 = null;
            }
            if (jSONObject.has("userName")) {
                str3 = jSONObject.getString("userName");
            }
            if (str3 != null) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str3);
                intent.putExtra("Contact_Scene", 3);
                c.b(MMApplicationContext.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                this.yEn.ecz();
                AppMethodBeat.o(198849);
            } else if (str2 == null) {
                this.yEn.aCS("openId or userName is required");
                AppMethodBeat.o(198849);
            } else {
                final d dVar = new d(str2);
                g.azz().a(dVar.getType(), new i() {
                    /* class com.tencent.mm.plugin.lite.jsapi.b.b.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(198848);
                        g.azz().b(dVar.getType(), this);
                        if (i2 == 0 && i3 == 0) {
                            String str2 = ((d) qVar).fyb().username;
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str2);
                            intent.putExtra("Contact_Scene", 3);
                            if (str2 != null && str2.length() > 0) {
                                c.b(MMApplicationContext.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                b.this.yEn.ecz();
                            }
                            AppMethodBeat.o(198848);
                            return;
                        }
                        b.this.yEn.aCS("goUserProfile failed");
                        Log.e("LiteAppJsApiOpenProfileWithOpenId", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        AppMethodBeat.o(198848);
                    }
                });
                g.azz().a(dVar, 0);
                AppMethodBeat.o(198849);
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("LiteAppJsApiOpenProfileWithOpenId", e2, "get openId", new Object[0]);
            this.yEn.aCS("get openId exception");
            AppMethodBeat.o(198849);
        }
    }
}
