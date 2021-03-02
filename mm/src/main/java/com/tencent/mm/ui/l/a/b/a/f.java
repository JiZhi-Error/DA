package com.tencent.mm.ui.l.a.b.a;

import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.l.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class f extends ab<g> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getVisibleMsgMetas";
    private static final MMHandler mKp = new MMHandler(Looper.getMainLooper());

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(g gVar, JSONObject jSONObject) {
        HashMap hashMap;
        AppMethodBeat.i(259045);
        final g gVar2 = gVar;
        final boolean optBoolean = jSONObject.optBoolean("needFrame", false);
        List list = (List) new SyncTask<List<Map<String, Object>>>() {
            /* class com.tencent.mm.ui.l.a.b.a.f.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ List<Map<String, Object>> run() {
                AppMethodBeat.i(259044);
                if (!gVar2.isRunning() || gVar2.QlN == null || !gVar2.QlN.mIsRunning) {
                    Log.w("MicroMsg.JsApiGetVisibleMsgMetas", "hy: env released!!");
                    AppMethodBeat.o(259044);
                    return null;
                }
                a gWG = gVar2.QlN.gWG();
                if (gWG == null) {
                    Log.w("MicroMsg.JsApiGetVisibleMsgMetas", "hy: no chatting context attached!");
                    AppMethodBeat.o(259044);
                    return null;
                }
                List<Pair<Long, c.a>> a2 = com.tencent.mm.ui.l.b.a.a(gWG, false);
                if (a2 == null || a2.size() <= 0) {
                    Log.i("MicroMsg.JsApiGetVisibleMsgMetas", "hy: current no chatting items in the context");
                    AppMethodBeat.o(259044);
                    return null;
                }
                ArrayList arrayList = new ArrayList(5);
                for (Pair<Long, c.a> pair : a2) {
                    e a3 = e.a(((Long) pair.first).longValue(), gVar2, optBoolean);
                    if (a3 != null) {
                        arrayList.add(a3.gWU());
                    }
                }
                AppMethodBeat.o(259044);
                return arrayList;
            }
        }.exec(mKp);
        if (list != null) {
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("msgMetas", list);
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        String n = n("ok", hashMap);
        AppMethodBeat.o(259045);
        return n;
    }

    static {
        AppMethodBeat.i(259046);
        AppMethodBeat.o(259046);
    }
}
