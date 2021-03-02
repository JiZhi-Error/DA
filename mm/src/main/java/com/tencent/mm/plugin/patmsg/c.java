package com.tencent.mm.plugin.patmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static MultiProcessMMKV ARf = MultiProcessMMKV.getMMKV("pat_user_mmkv");

    static {
        AppMethodBeat.i(206944);
        AppMethodBeat.o(206944);
    }

    public static void jk(String str, String str2) {
        AppMethodBeat.i(206938);
        try {
            g(str, "pat_user_suffix_content", str2);
            AppMethodBeat.o(206938);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PatUserMMKV", e2, "", new Object[0]);
            AppMethodBeat.o(206938);
        }
    }

    public static String aJL(String str) {
        String str2;
        AppMethodBeat.i(206939);
        try {
            str2 = (String) jl(str, "pat_user_suffix_content");
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PatUserMMKV", e2, "", new Object[0]);
            str2 = "";
        }
        AppMethodBeat.o(206939);
        return str2;
    }

    public static void fa(String str, int i2) {
        AppMethodBeat.i(206940);
        try {
            g(str, "pat_user_suffix_version", Integer.valueOf(i2));
            AppMethodBeat.o(206940);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.PatUserMMKV", e2, "", new Object[0]);
            AppMethodBeat.o(206940);
        }
    }

    public static int aJM(String str) {
        int i2;
        AppMethodBeat.i(206941);
        try {
            i2 = ((Integer) jl(str, "pat_user_suffix_version")).intValue();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PatUserMMKV", e2, "", new Object[0]);
            i2 = 0;
        }
        AppMethodBeat.o(206941);
        return i2;
    }

    private static void g(String str, String str2, Object obj) {
        JSONObject jSONObject;
        AppMethodBeat.i(206942);
        if (!Util.isNullOrNil(str)) {
            if (ARf.containsKey(str)) {
                jSONObject = new JSONObject(ARf.getString(str, ""));
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put(str2, obj);
            ARf.putString(str, jSONObject.toString()).commit();
        }
        AppMethodBeat.o(206942);
    }

    private static Object jl(String str, String str2) {
        AppMethodBeat.i(206943);
        if (!Util.isNullOrNil(str) && ARf.containsKey(str)) {
            JSONObject jSONObject = new JSONObject(ARf.getString(str, ""));
            if (jSONObject.has(str2)) {
                Object obj = jSONObject.get(str2);
                AppMethodBeat.o(206943);
                return obj;
            }
        }
        AppMethodBeat.o(206943);
        return null;
    }
}
