package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class h {
    public static ArrayList<um> cR(String str, int i2) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        AppMethodBeat.i(113801);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            AppMethodBeat.o(113801);
            return null;
        }
        if (i2 == 8 || i2 == 0) {
            try {
                jSONArray = new JSONObject(str).optJSONArray("card_list");
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.CardListItemParser", e2, "", new Object[0]);
                AppMethodBeat.o(113801);
                return null;
            }
        } else if (i2 == 26) {
            jSONArray = new JSONArray(str);
        } else {
            jSONArray = new JSONArray(str);
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
            AppMethodBeat.o(113801);
            return null;
        }
        ArrayList<um> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject == null) {
                if (i2 == 26 && (jSONArray.opt(i3) instanceof String)) {
                    try {
                        jSONObject = new JSONObject(jSONArray.optString(i3));
                    } catch (JSONException e3) {
                        Log.printErrStackTrace("MicroMsg.CardListItemParser", e3, "protect itemJSON for AppBrand", new Object[0]);
                    }
                }
            } else {
                jSONObject = optJSONObject;
            }
            um umVar = new um();
            umVar.pRX = jSONObject.optString(i2 == 26 ? "cardId" : "card_id");
            umVar.eaP = jSONObject.optString(i2 == 26 ? "cardExt" : "card_ext");
            arrayList.add(umVar);
        }
        AppMethodBeat.o(113801);
        return arrayList;
    }

    public static String a(LinkedList<e> linkedList, boolean z, int i2) {
        AppMethodBeat.i(113802);
        if (linkedList.size() == 0) {
            Log.e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
            AppMethodBeat.o(113802);
            return "";
        }
        Log.i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + z + " scene:" + i2);
        JSONStringer jSONStringer = new JSONStringer();
        if (i2 == 8) {
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CardListItemParser", e2, "", new Object[0]);
                AppMethodBeat.o(113802);
                return "";
            }
        }
        jSONStringer.array();
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            jSONStringer.object();
            jSONStringer.key(i2 == 26 ? "cardId" : "card_id");
            jSONStringer.value(next.pRX);
            jSONStringer.key(i2 == 26 ? "cardExt" : "card_ext");
            jSONStringer.value(next.eaP == null ? "" : next.eaP);
            jSONStringer.key(i2 == 26 ? "isSuccess" : "is_succ");
            if (z) {
                jSONStringer.value(i2 == 26 ? Boolean.TRUE : 1);
            } else {
                jSONStringer.value(i2 == 26 ? Boolean.FALSE : 0);
            }
            jSONStringer.key(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            jSONStringer.value(next.code == null ? "" : next.code);
            jSONStringer.endObject();
        }
        jSONStringer.endArray();
        if (i2 == 8) {
            jSONStringer.endObject();
        }
        String jSONStringer2 = jSONStringer.toString();
        AppMethodBeat.o(113802);
        return jSONStringer2;
    }

    public static String cS(String str, int i2) {
        AppMethodBeat.i(113803);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            AppMethodBeat.o(113803);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
                AppMethodBeat.o(113803);
                return null;
            }
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.array();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                jSONStringer.object();
                jSONStringer.key(i2 == 26 ? "cardId" : "card_id");
                jSONStringer.value(optJSONObject.optString("card_id"));
                jSONStringer.key(i2 == 26 ? "cardExt" : "card_ext");
                jSONStringer.value(optJSONObject.optString("card_ext"));
                jSONStringer.key(i2 == 26 ? "isSuccess" : "is_succ");
                if (i2 != 26) {
                    jSONStringer.value((long) optJSONObject.optInt("is_succ"));
                } else if (optJSONObject.optInt("is_succ") == 1) {
                    jSONStringer.value(true);
                } else {
                    jSONStringer.value(false);
                }
                jSONStringer.key(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                if (!TextUtils.isEmpty(optJSONObject.optString("encrypt_code"))) {
                    jSONStringer.value(optJSONObject.optString("encrypt_code"));
                } else {
                    jSONStringer.value(optJSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE));
                }
                jSONStringer.endObject();
                Log.i("MicroMsg.CardListItemParser", "parseJsonToArray item" + i3 + "  is_succ:" + optJSONObject.optInt(i2 == 26 ? "isSuccess" : "is_succ"));
            }
            jSONStringer.endArray();
            String jSONStringer2 = jSONStringer.toString();
            AppMethodBeat.o(113803);
            return jSONStringer2;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardListItemParser", e2, "", new Object[0]);
            AppMethodBeat.o(113803);
            return "";
        }
    }
}
