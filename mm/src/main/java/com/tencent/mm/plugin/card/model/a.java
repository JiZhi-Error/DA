package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public String app_id;
    public String iwv;
    public String ixw;
    public int nHh;
    public String pRX;
    public String pRY;
    public String pRZ;
    public String pSa;
    public int pSb;
    public String pSc;
    public int pSd;
    public String pSe;
    public String pSf;
    public String pSg;
    public boolean pSh;
    public String pnW;
    public String title;
    public String userName;

    public static LinkedList<a> aji(String str) {
        LinkedList<a> linkedList = null;
        AppMethodBeat.i(112714);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112714);
        } else {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_cards"), false);
                AppMethodBeat.o(112714);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AvailableCardItem", e2, "", new Object[0]);
                AppMethodBeat.o(112714);
            }
        }
        return linkedList;
    }

    public static LinkedList<a> ajj(String str) {
        LinkedList<a> linkedList = null;
        AppMethodBeat.i(112715);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112715);
        } else {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_share_cards"), true);
                AppMethodBeat.o(112715);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AvailableCardItem", e2, "", new Object[0]);
                AppMethodBeat.o(112715);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> a(JSONArray jSONArray, boolean z) {
        AppMethodBeat.i(112716);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(112716);
            return null;
        }
        LinkedList<a> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            a aVar = new a();
            aVar.pRX = jSONObject.optString("card_tp_id");
            aVar.nHh = jSONObject.optInt("card_type");
            aVar.ixw = jSONObject.optString("color");
            aVar.iwv = jSONObject.optString("logo_url");
            aVar.title = jSONObject.optString("title");
            aVar.pRY = jSONObject.optString("sub_title");
            aVar.pRZ = jSONObject.optString("aux_title");
            aVar.pSa = jSONObject.optString("encrypt_code");
            aVar.userName = jSONObject.optString("from_user_name");
            aVar.app_id = jSONObject.optString("app_id");
            aVar.pSb = jSONObject.optInt("end_time");
            aVar.pSc = jSONObject.optString("card_user_id");
            aVar.pSd = jSONObject.optInt("choose_optional");
            aVar.pSf = jSONObject.optString("invoice_item");
            aVar.pSg = jSONObject.optString("invoice_status");
            aVar.pSe = jSONObject.optString("invoice_title");
            aVar.pSh = z;
            linkedList.add(aVar);
        }
        AppMethodBeat.o(112716);
        return linkedList;
    }
}
