package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;

public final class a {
    public static JSONArray wO(int i2) {
        AppMethodBeat.i(106570);
        if (i2 <= 0) {
            JSONArray jSONArray = new JSONArray();
            AppMethodBeat.o(106570);
            return jSONArray;
        }
        ArrayList arrayList = new ArrayList(3);
        if ((i2 & 1) == 1) {
            arrayList.add("fingerPrint");
        }
        if ((i2 & 8) == 8) {
            arrayList.add("facial");
        }
        if ((i2 & 2) == 2) {
            arrayList.add("speech");
        }
        Log.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", arrayList.toString());
        JSONArray jSONArray2 = new JSONArray((Collection) arrayList);
        AppMethodBeat.o(106570);
        return jSONArray2;
    }

    public static String o(JSONArray jSONArray) {
        AppMethodBeat.i(106571);
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        Log.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translating string array: %s", objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(106571);
            return "0x00";
        }
        byte b2 = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                b2 = (byte) (b2 | ZB(jSONArray.getString(i2)));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", e2, "hy: json error in translate", new Object[0]);
            }
        }
        String str = "0x" + Integer.toHexString(b2);
        Log.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", str);
        AppMethodBeat.o(106571);
        return str;
    }

    public static int ZB(String str) {
        AppMethodBeat.i(106572);
        if ("fingerPrint".equals(str)) {
            AppMethodBeat.o(106572);
            return 1;
        } else if ("facial".equals(str)) {
            AppMethodBeat.o(106572);
            return 8;
        } else if ("speech".equals(str)) {
            AppMethodBeat.o(106572);
            return 2;
        } else {
            Log.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
            AppMethodBeat.o(106572);
            return 0;
        }
    }
}
