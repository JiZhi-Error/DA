package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    public static LinkedList<va> G(String str, int i2, String str2) {
        JSONObject jSONObject;
        AppMethodBeat.i(113810);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardTpInfoItemParser", "parseCardTpInfoItemArray jsonContent is null");
            AppMethodBeat.o(113810);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                Log.e("MicroMsg.CardTpInfoItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
                AppMethodBeat.o(113810);
                return null;
            }
            LinkedList<va> linkedList = new LinkedList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject == null) {
                    if (i2 == 26 && (jSONArray.opt(i3) instanceof String)) {
                        try {
                            jSONObject = new JSONObject(jSONArray.optString(i3));
                        } catch (JSONException e2) {
                            Log.printErrStackTrace("MicroMsg.CardTpInfoItemParser", e2, "protect itemJSON for AppBrand", new Object[0]);
                        }
                    }
                } else {
                    jSONObject = optJSONObject;
                }
                va vaVar = new va();
                vaVar.pRX = jSONObject.optString(i2 == 26 ? "cardId" : "card_id");
                vaVar.code = jSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                vaVar.Lfm = jSONObject.optString("openCardParams");
                vaVar.dNI = str2;
                linkedList.add(vaVar);
            }
            AppMethodBeat.o(113810);
            return linkedList;
        } catch (JSONException e3) {
            Log.printErrStackTrace("MicroMsg.CardTpInfoItemParser", e3, "", new Object[0]);
            AppMethodBeat.o(113810);
            return null;
        }
    }
}
