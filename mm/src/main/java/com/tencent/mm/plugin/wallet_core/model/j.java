package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    public String HXO;
    public List<a> HXP;
    public String content;
    public String title;

    public static class a {
        public Orders.ShowInfo HXQ;
        public int id;

        public static a bI(JSONObject jSONObject) {
            AppMethodBeat.i(70281);
            if (jSONObject == null) {
                AppMethodBeat.o(70281);
                return null;
            }
            a aVar = new a();
            aVar.id = jSONObject.optInt("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("show_info");
            if (optJSONObject != null) {
                Orders.ShowInfo showInfo = new Orders.ShowInfo();
                showInfo.name = optJSONObject.optString("name");
                showInfo.value = optJSONObject.optString("value");
                showInfo.Iav = optJSONObject.optInt("value_attr");
                showInfo.xEk = optJSONObject.optString("name_color");
                showInfo.Iaq = optJSONObject.optString("value_color");
                aVar.HXQ = showInfo;
            }
            AppMethodBeat.o(70281);
            return aVar;
        }
    }

    public static j bH(JSONObject jSONObject) {
        AppMethodBeat.i(70282);
        if (jSONObject == null) {
            AppMethodBeat.o(70282);
            return null;
        }
        j jVar = new j();
        jVar.title = jSONObject.optString("title");
        jVar.content = jSONObject.optString("content");
        jVar.HXO = jSONObject.optString("content_not_enough");
        jVar.HXP = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("show_infos");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                a bI = a.bI(optJSONArray.optJSONObject(i2));
                if (bI != null) {
                    jVar.HXP.add(bI);
                }
            }
        }
        AppMethodBeat.o(70282);
        return jVar;
    }
}
