package com.tencent.mm.plugin.websearch.api;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class al {
    public static dsh IEV;

    public static dsh fYg() {
        AppMethodBeat.i(117723);
        if (IEV == null) {
            String bKh = bKh();
            IEV = new dsh();
            String string = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0).getString(bKh, "");
            if (!Util.isNullOrNil(string)) {
                try {
                    IEV.parseFrom(Base64.decode(string.getBytes(), 0));
                } catch (IOException e2) {
                }
            }
        }
        dsh dsh = IEV;
        AppMethodBeat.o(117723);
        return dsh;
    }

    public static String bKh() {
        AppMethodBeat.i(117724);
        String str = "key_pb_history_list" + z.aTY();
        AppMethodBeat.o(117724);
        return str;
    }

    public static String fYh() {
        AppMethodBeat.i(117725);
        dsh fYg = fYg();
        int size = fYg.oTA.size();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            int i2 = 0;
            while (i2 < fYg.oTA.size() && i2 < size) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("word", fYg.oTA.get(i2).KXA);
                jSONArray2.put(jSONObject3);
                i2++;
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("count", jSONArray2.length());
            jSONObject2.put("type", 4);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
            jSONObject.put("ret", 0);
        } catch (JSONException e2) {
        }
        String jSONObject4 = jSONObject.toString();
        AppMethodBeat.o(117725);
        return jSONObject4;
    }
}
