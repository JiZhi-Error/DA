package com.tencent.mm.plugin.recharge.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static final int[] BCV = {-1, -1};
    public static final int[] BCW = {-2, -2};
    public String BCX;
    public int[] BCY;
    public String ljO;
    public String name;
    public int sourceType;

    public a(String str, String str2, int i2) {
        this(str, str2, "", i2);
    }

    public a(String str, String str2, String str3, int i2) {
        this.BCY = BCV;
        this.BCX = str;
        this.name = str2;
        this.ljO = str3;
        this.sourceType = i2;
    }

    public final JSONObject toJson() {
        AppMethodBeat.i(67089);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("record", Util.nullAs(this.BCX, ""));
            jSONObject.put("name", Util.nullAs(this.name, ""));
            jSONObject.put(FirebaseAnalytics.b.LOCATION, Util.nullAs(this.ljO, ""));
            AppMethodBeat.o(67089);
            return jSONObject;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.MallInputRecord", e2, "", new Object[0]);
            AppMethodBeat.o(67089);
            return null;
        }
    }

    public static a bj(JSONObject jSONObject) {
        AppMethodBeat.i(67090);
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("record");
        String optString3 = jSONObject.optString(FirebaseAnalytics.b.LOCATION);
        if (!Util.isNullOrNil(optString2)) {
            a aVar = new a(optString2, optString, optString3, 2);
            AppMethodBeat.o(67090);
            return aVar;
        }
        AppMethodBeat.o(67090);
        return null;
    }
}
