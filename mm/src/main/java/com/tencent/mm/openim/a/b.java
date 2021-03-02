package com.tencent.mm.openim.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public List<a> jGV = new LinkedList();

    public b() {
        AppMethodBeat.i(120689);
        AppMethodBeat.o(120689);
    }

    /* renamed from: com.tencent.mm.openim.a.b$b  reason: collision with other inner class name */
    public static class C0498b {
        public int action;
        String desc;
        public String icon;
        public int jGX;
        public String jGY;

        public final String Sb(String str) {
            AppMethodBeat.i(120688);
            if (this.jGX == 1) {
                String bN = ((a) g.af(a.class)).bN(str, this.desc);
                AppMethodBeat.o(120688);
                return bN;
            }
            String str2 = this.desc;
            AppMethodBeat.o(120688);
            return str2;
        }
    }

    public static class a {
        public List<C0498b> jGW = new LinkedList();
        public String title = "";

        public a() {
            AppMethodBeat.i(120686);
            AppMethodBeat.o(120686);
        }

        /* access modifiers changed from: package-private */
        public final a z(JSONObject jSONObject) {
            AppMethodBeat.i(120687);
            this.title = jSONObject.optString("title", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("detail");
            if (optJSONArray == null) {
                AppMethodBeat.o(120687);
            } else {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    C0498b bVar = new C0498b();
                    List<C0498b> list = this.jGW;
                    bVar.icon = jSONObject2.optString("icon");
                    bVar.desc = jSONObject2.optString("desc");
                    bVar.jGX = jSONObject2.optInt("desc_type");
                    bVar.action = jSONObject2.optInt(NativeProtocol.WEB_DIALOG_ACTION);
                    bVar.jGY = jSONObject2.optString("action_param");
                    list.add(bVar);
                }
                AppMethodBeat.o(120687);
            }
            return this;
        }
    }

    public final b Sa(String str) {
        AppMethodBeat.i(120690);
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("custom_info");
            if (optJSONArray == null) {
                AppMethodBeat.o(120690);
                return this;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.jGV.add(new a().z(optJSONArray.getJSONObject(i2)));
            }
            AppMethodBeat.o(120690);
            return this;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.OpenIMCustomDetail", e2, "parse", new Object[0]);
        }
    }
}
