package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends i {
    public static final int CTRL_INDEX = 780;
    public static final String NAME = "subscribeVoIPMembers";
    private static String TAG = "MicroMsg.OpenVoice.JsApiSubscribeVoIPMembers";

    public k() {
        AppMethodBeat.i(180257);
        c.aem(NAME);
        AppMethodBeat.o(180257);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
    public final void a(final com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(180258);
        if (jSONObject == null) {
            cVar.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(180258);
            return;
        }
        Log.i(TAG, "hy: appId:" + cVar.getAppId() + ", parmas:" + jSONObject.toString());
        q qVar = q.INSTANCE;
        qVar.aj(new Runnable(jSONObject, new b<Integer>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.k.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
            @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
            public final /* synthetic */ void a(int i2, int i3, String str, Integer num) {
                AppMethodBeat.i(180256);
                cVar.i(i2, k.this.h("ok", null));
                AppMethodBeat.o(180256);
            }
        }) {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass11 */
            final /* synthetic */ JSONObject mhb;
            final /* synthetic */ b qtX;

            {
                this.mhb = r2;
                this.qtX = r3;
            }

            public final void run() {
                efj akI;
                AppMethodBeat.i(90868);
                LinkedList linkedList = new LinkedList();
                JSONArray optJSONArray = this.mhb.optJSONArray("openIdList");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        linkedList.add(optJSONArray.optString(i2, ""));
                    }
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!(str == null || (akI = q.this.qtf.akI(str)) == null)) {
                        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: subscribe, get member OK for openid:%s", str);
                        arrayList.add(akI);
                    }
                }
                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: subscribe, videoMembers %s", arrayList);
                m.R(arrayList);
                this.qtX.a(0, 0, "ok", 0);
                AppMethodBeat.o(90868);
            }
        });
        AppMethodBeat.o(180258);
    }
}
