package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t {
    public static l akn(String str) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(113875);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
            AppMethodBeat.o(113875);
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("list");
            if (optJSONObject == null) {
                Log.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
                AppMethodBeat.o(113875);
                return null;
            }
            l lVar = new l();
            lVar.pWb = optJSONObject.optString("local_city");
            lVar.pVZ = ako(optJSONObject.optString("local_city_list"));
            lVar.pWa = ako(optJSONObject.optString("other_city_list"));
            lVar.pWc = optJSONObject.optBoolean("local_end");
            lVar.pWd = optJSONObject.optBoolean("other_end");
            lVar.eaY = optJSONObject.optBoolean("show_red_dot");
            lVar.eaZ = optJSONObject.optBoolean("show_new");
            lVar.pWf = optJSONObject.optString("tips");
            lVar.pWe = akp(optJSONObject.optString("icons"));
            lVar.pWg = optJSONObject.optInt("newest_sharecard_time_second");
            Object[] objArr = new Object[5];
            if (lVar.pWc) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(lVar.pWd ? 1 : 0);
            objArr[2] = Integer.valueOf(lVar.eaY ? 1 : 0);
            if (!lVar.eaZ) {
                i3 = 0;
            }
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = lVar.pWf;
            Log.i("MicroMsg.ShareCardLayoutDataParser", "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s", objArr);
            AppMethodBeat.o(113875);
            return lVar;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e2, "", new Object[0]);
            AppMethodBeat.o(113875);
            return null;
        }
    }

    private static LinkedList<m> ako(String str) {
        AppMethodBeat.i(113876);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
            AppMethodBeat.o(113876);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(FirebaseAnalytics.b.ITEM_LIST);
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
                AppMethodBeat.o(113876);
                return null;
            }
            LinkedList<m> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                m mVar = new m();
                mVar.eaO = optJSONObject.optString("card_id");
                mVar.pRX = optJSONObject.optString("card_tp_id");
                mVar.pWh = optJSONObject.optString("announcement");
                mVar.pWi = (long) optJSONObject.optInt("end_time", 0);
                mVar.pWj = (long) optJSONObject.optInt("update_time", 0);
                mVar.pWk = optJSONObject.optInt("item_type", 0);
                mVar.top = optJSONObject.optInt("top", 0);
                Log.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + mVar.pRX + " top:" + mVar.top);
                linkedList.add(mVar);
            }
            AppMethodBeat.o(113876);
            return linkedList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e2, "", new Object[0]);
            AppMethodBeat.o(113876);
            return null;
        }
    }

    private static LinkedList<String> akp(String str) {
        AppMethodBeat.i(113877);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
            AppMethodBeat.o(113877);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                Log.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
                AppMethodBeat.o(113877);
                return null;
            }
            LinkedList<String> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                linkedList.add(jSONArray.optString(i2));
            }
            AppMethodBeat.o(113877);
            return linkedList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e2, "", new Object[0]);
            AppMethodBeat.o(113877);
            return null;
        }
    }
}
