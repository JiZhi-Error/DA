package com.tencent.mm.plugin.product.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n {
    public List<a> AZH = new ArrayList();
    public String name;

    public static class a {
        public String data;
        public String iconUrl;
        public String title;
        public int type;
        public String url;
    }

    public n() {
        AppMethodBeat.i(66913);
        AppMethodBeat.o(66913);
    }

    public static List<n> parse(String str) {
        AppMethodBeat.i(66914);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("group_list");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                n nVar = new n();
                nVar.name = jSONObject.getString("name");
                JSONArray jSONArray2 = jSONObject.getJSONArray(FirebaseAnalytics.b.ITEM_LIST);
                int length2 = jSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    a aVar = new a();
                    aVar.title = jSONObject2.getString("title");
                    aVar.type = jSONObject2.getInt("jump_type");
                    aVar.data = jSONObject2.getString("native_url_args");
                    aVar.iconUrl = jSONObject2.getString("icon_url");
                    aVar.url = jSONObject2.getString("h5_url");
                    nVar.AZH.add(aVar);
                }
                arrayList.add(nVar);
            }
            AppMethodBeat.o(66914);
            return arrayList;
        } catch (Exception e2) {
            AppMethodBeat.o(66914);
            return null;
        }
    }
}
