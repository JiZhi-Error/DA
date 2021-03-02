package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class i extends d {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "shareFinderEndorsementToFriend";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(163989);
        if (!(fVar.getContext() instanceof Activity) || jSONObject == null) {
            fVar.i(i2, "fail");
            AppMethodBeat.o(163989);
            return;
        }
        String optString = jSONObject.optString("title", "");
        String optString2 = jSONObject.optString("desc", "");
        String optString3 = jSONObject.optString("relativePath", "");
        jSONObject.optInt("scene", 0);
        String optString4 = jSONObject.optString("sceneNote", "");
        k.b bVar = new k.b();
        com.tencent.mm.plugin.finder.api.d dVar = new com.tencent.mm.plugin.finder.api.d();
        dVar.title = optString;
        dVar.desc = optString2;
        dVar.tsr = optString3;
        dVar.dCw = optString4;
        dVar.desc = optString2;
        bVar.type = 52;
        bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
        bVar.title = optString;
        bVar.desc = optString2;
        bVar.a(dVar);
        String a2 = k.b.a(bVar, null, null);
        Log.i("MicroMsg.Finder.JsApiShareFinderEndorsementToFriend", "msgContent %s", a2);
        Intent intent = new Intent();
        intent.setClassName(fVar.getContext(), MMApplicationContext.getSourcePackageName() + ".ui.transmit.MsgRetransmitUI");
        intent.putExtra("Retr_Msg_Type", 19);
        intent.putExtra("Retr_Msg_content", a2);
        intent.putExtra("Multi_Retr", true);
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.luggage.h.f.aK(fVar.getContext()).a(intent, new f.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.i.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.b
            public final void a(int i2, Intent intent) {
                AppMethodBeat.i(163988);
                if (i2 == -1) {
                    fVar.i(i2, a.a("", 0, new JSONObject()));
                    AppMethodBeat.o(163988);
                    return;
                }
                fVar.i(i2, a.a("", 1, new JSONObject()));
                AppMethodBeat.o(163988);
            }
        });
        AppMethodBeat.o(163989);
    }
}
