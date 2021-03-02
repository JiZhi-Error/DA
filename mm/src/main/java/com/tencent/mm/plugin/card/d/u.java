package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u {
    public static ArrayList<us> akq(String str) {
        us usVar;
        AppMethodBeat.i(113878);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113878);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("used_store_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                AppMethodBeat.o(113878);
                return null;
            }
            ArrayList<us> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject == null) {
                    usVar = null;
                } else {
                    usVar = new us();
                    usVar.name = jSONObject.optString("name");
                    usVar.descriptor = jSONObject.optString("descriptor");
                    usVar.pSm = jSONObject.optString("phone");
                    usVar.country = jSONObject.optString(UserDataStore.COUNTRY);
                    usVar.fuJ = jSONObject.optString("province");
                    usVar.fuK = jSONObject.optString("city");
                    usVar.iUO = jSONObject.optString("address");
                    usVar.DWG = (float) jSONObject.optDouble("distance");
                    usVar.dTj = (float) jSONObject.optDouble("longitude");
                    usVar.latitude = (float) jSONObject.optDouble("latitude");
                    usVar.pTL = jSONObject.optString("jump_url");
                    usVar.Leo = jSONObject.optString("app_brand_user_name");
                    usVar.Lep = jSONObject.optString("app_brand_pass");
                }
                if (usVar != null) {
                    arrayList.add(usVar);
                }
            }
            AppMethodBeat.o(113878);
            return arrayList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ShopInfoItemParser", e2, "", new Object[0]);
            AppMethodBeat.o(113878);
            return null;
        }
    }
}
