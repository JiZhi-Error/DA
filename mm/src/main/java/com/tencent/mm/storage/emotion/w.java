package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class w extends MStorage {
    public final LinkedList<v> zns = new LinkedList<>();

    public w() {
        AppMethodBeat.i(105154);
        gFs();
        AppMethodBeat.o(105154);
    }

    private void gFs() {
        AppMethodBeat.i(105155);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_RECENT_SMILEY_STRING, "");
        try {
            synchronized (this.zns) {
                try {
                    this.zns.clear();
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        v vVar = new v();
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        vVar.key = jSONObject.optString("key", "");
                        vVar.OsQ = jSONObject.optInt("use_count", 0);
                        vVar.hwQ = jSONObject.optLong("last_time", 0);
                        this.zns.add(vVar);
                    }
                } finally {
                    AppMethodBeat.o(105155);
                }
            }
        } catch (JSONException e2) {
            Log.w("SmileyUsageInfoStorage", "data error clear all");
            byC();
            AppMethodBeat.o(105155);
        }
    }

    public final List<v> cFQ() {
        AppMethodBeat.i(105156);
        ArrayList arrayList = new ArrayList();
        synchronized (this.zns) {
            try {
                Iterator<v> it = this.zns.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (e.gxR().containsKey(next.key)) {
                        arrayList.add(next);
                    }
                }
            } finally {
                AppMethodBeat.o(105156);
            }
        }
        return arrayList;
    }

    public final void byC() {
        AppMethodBeat.i(105157);
        g.aAh().azQ().set(ar.a.USERINFO_RECENT_SMILEY_STRING, (Object) null);
        this.zns.clear();
        AppMethodBeat.o(105157);
    }
}
