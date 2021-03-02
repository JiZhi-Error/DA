package com.tencent.mm.game.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static void a(Context context, int i2, int i3, int i4, int i5, int i6, String str) {
        AppMethodBeat.i(108260);
        a(context, i2, i3, i4, i5, 0, null, i6, 0, null, null, str);
        AppMethodBeat.o(108260);
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        AppMethodBeat.i(108261);
        a(context, i2, i3, i4, i5, 0, str, i6, 0, null, null, str2);
        AppMethodBeat.o(108261);
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str, int i6, String str2, String str3) {
        AppMethodBeat.i(108262);
        a(context, i2, i3, i4, i5, 0, str, i6, 0, null, str2, str3);
        AppMethodBeat.o(108262);
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, int i6, String str, int i7, int i8, String str2, String str3, String str4) {
        AppMethodBeat.i(108263);
        a.hhr.a(b.e(12909, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, Integer.valueOf(i7), Integer.valueOf(i8), str2, Integer.valueOf(Util.getInt(str3, 0)), Integer.valueOf(com.tencent.mm.game.report.e.a.getNetworkType(context)), str4));
        AppMethodBeat.o(108263);
    }

    public static String ap(String str, String str2) {
        AppMethodBeat.i(108264);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("function_type", str);
            jSONObject.put("function_value", str2);
        } catch (JSONException e2) {
        }
        String Fh = com.tencent.mm.game.report.e.a.Fh(jSONObject.toString());
        AppMethodBeat.o(108264);
        return Fh;
    }

    public static String a(String str, String str2, String str3, Map map) {
        AppMethodBeat.i(108265);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2) || !Util.isNullOrNil(str3) || map != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!Util.isNullOrNil(str)) {
                    jSONObject.put("function_type", str);
                }
                if (!Util.isNullOrNil(str2)) {
                    jSONObject.put("function_value", str2);
                }
                if (!Util.isNullOrNil(str3)) {
                    jSONObject.put("ext_data", str3);
                }
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        try {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        } catch (Exception e2) {
                            AppMethodBeat.o(108265);
                            return "";
                        }
                    }
                }
            } catch (JSONException e3) {
            }
            String Fh = com.tencent.mm.game.report.e.a.Fh(jSONObject.toString());
            AppMethodBeat.o(108265);
            return Fh;
        }
        AppMethodBeat.o(108265);
        return null;
    }

    public static String t(Map map) {
        AppMethodBeat.i(184813);
        if (map == null) {
            AppMethodBeat.o(184813);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e2) {
                AppMethodBeat.o(184813);
                return "";
            }
        }
        String Fh = com.tencent.mm.game.report.e.a.Fh(jSONObject.toString());
        AppMethodBeat.o(184813);
        return Fh;
    }

    public static String aq(String str, String str2) {
        AppMethodBeat.i(108266);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
        }
        String Fh = com.tencent.mm.game.report.e.a.Fh(jSONObject.toString());
        AppMethodBeat.o(108266);
        return Fh;
    }
}
