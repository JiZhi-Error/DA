package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    public static j akm(String str) {
        AppMethodBeat.i(113874);
        Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
            AppMethodBeat.o(113874);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.pVW = jSONObject.optString("consumed_box_id");
            jVar.pVX = jSONObject.optString("subscribe_wording");
            jVar.pVY = jSONObject.optString("subscribe_app_username");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
                AppMethodBeat.o(113874);
                return null;
            }
            ArrayList<q> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                q qVar = new q();
                qVar.eaP = optJSONObject.optString("card_ext");
                qVar.pTh = f.ay(optJSONObject.optJSONObject("card_tp_info"));
                arrayList.add(qVar);
            }
            jVar.dtS = arrayList;
            Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + arrayList.size());
            if (TextUtils.isEmpty(jVar.pVW)) {
                Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
            }
            if (TextUtils.isEmpty(jVar.pVX)) {
                Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
            }
            AppMethodBeat.o(113874);
            return jVar;
        } catch (JSONException e2) {
            Log.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", e2, "", new Object[0]);
            AppMethodBeat.o(113874);
            return null;
        }
    }
}
