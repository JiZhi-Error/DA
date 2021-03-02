package com.tencent.mm.plugin.appbrand.ac;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g {
    private static DisplayMetrics ogw = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    private static Float ogx = null;
    private static boolean ogy = true;

    static {
        AppMethodBeat.i(140832);
        AppMethodBeat.o(140832);
    }

    public static void bZj() {
        ogy = false;
    }

    public static int r(JSONArray jSONArray) {
        int i2 = 0;
        AppMethodBeat.i(140809);
        if (jSONArray == null || jSONArray.length() < 3) {
            AppMethodBeat.o(140809);
        } else {
            if (jSONArray.length() == 3) {
                i2 = Color.rgb(jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
            } else {
                i2 = Color.argb(jSONArray.optInt(3) & 255, jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
            }
            if (ogy) {
                i2 = j.cDv.hT(i2);
            }
            AppMethodBeat.o(140809);
        }
        return i2;
    }

    public static int cu(String str, int i2) {
        AppMethodBeat.i(140810);
        try {
            i2 = afE(str);
            AppMethodBeat.o(140810);
        } catch (Exception e2) {
            AppMethodBeat.o(140810);
        }
        return i2;
    }

    public static int afD(String str) {
        AppMethodBeat.i(140811);
        int cu = cu(str, 0);
        AppMethodBeat.o(140811);
        return cu;
    }

    public static int afE(String str) {
        long parseLong;
        AppMethodBeat.i(140812);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("colorString isEmpty");
            AppMethodBeat.o(140812);
            throw illegalArgumentException;
        } else if (f.ogv.containsKey(str)) {
            int intValue = f.ogv.get(str).intValue();
            AppMethodBeat.o(140812);
            return intValue;
        } else if (str.charAt(0) == '#') {
            if (str.length() == 4) {
                StringBuilder sb = new StringBuilder(str);
                sb.insert(2, str.charAt(1));
                sb.insert(4, str.charAt(2));
                sb.insert(6, str.charAt(3));
                str = sb.toString();
            }
            if (str.length() == 7) {
                parseLong = Long.parseLong(str.substring(1), 16) | -16777216;
            } else if (str.length() != 9) {
                Log.printInfoStack("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", str);
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unknown color");
                AppMethodBeat.o(140812);
                throw illegalArgumentException2;
            } else {
                parseLong = Long.parseLong(str.substring(1, 7), 16) | (Long.parseLong(str.substring(7, 9), 16) << 24);
            }
            int i2 = (int) parseLong;
            AppMethodBeat.o(140812);
            return i2;
        } else {
            int parseColor = Color.parseColor(str);
            AppMethodBeat.o(140812);
            return parseColor;
        }
    }

    public static int zB(int i2) {
        AppMethodBeat.i(140813);
        int ceil = (int) Math.ceil((double) (((float) i2) / bZk()));
        AppMethodBeat.o(140813);
        return ceil;
    }

    public static int zC(int i2) {
        AppMethodBeat.i(140814);
        int bZk = (int) (((float) i2) / bZk());
        AppMethodBeat.o(140814);
        return bZk;
    }

    public static float aS(float f2) {
        AppMethodBeat.i(140815);
        float bZk = f2 / bZk();
        AppMethodBeat.o(140815);
        return bZk;
    }

    public static int zD(int i2) {
        AppMethodBeat.i(140816);
        int round = Math.round(bZk() * ((float) i2));
        AppMethodBeat.o(140816);
        return round;
    }

    public static float aT(float f2) {
        AppMethodBeat.i(140817);
        float bZk = bZk() * f2;
        AppMethodBeat.o(140817);
        return bZk;
    }

    public static int f(JSONObject jSONObject, String str) {
        AppMethodBeat.i(140818);
        int a2 = a(jSONObject, str, 0);
        AppMethodBeat.o(140818);
        return a2;
    }

    public static int a(JSONObject jSONObject, String str, int i2) {
        AppMethodBeat.i(140819);
        if (jSONObject == null) {
            AppMethodBeat.o(140819);
        } else {
            try {
                i2 = Math.round(((float) jSONObject.getDouble(str)) * bZk());
                AppMethodBeat.o(140819);
            } catch (Exception e2) {
                AppMethodBeat.o(140819);
            }
        }
        return i2;
    }

    public static int g(JSONObject jSONObject, String str) {
        AppMethodBeat.i(140820);
        int round = Math.round(((float) jSONObject.getDouble(str)) * bZk());
        AppMethodBeat.o(140820);
        return round;
    }

    public static float h(JSONObject jSONObject, String str) {
        AppMethodBeat.i(140821);
        float a2 = a(jSONObject, str, 0.0f);
        AppMethodBeat.o(140821);
        return a2;
    }

    public static float a(JSONObject jSONObject, String str, float f2) {
        AppMethodBeat.i(140822);
        if (jSONObject == null) {
            AppMethodBeat.o(140822);
            return f2;
        }
        try {
            float bZk = bZk() * ((float) jSONObject.optDouble(str, (double) f2));
            AppMethodBeat.o(140822);
            return bZk;
        } catch (Exception e2) {
            AppMethodBeat.o(140822);
            return f2;
        }
    }

    public static int c(JSONArray jSONArray, int i2) {
        AppMethodBeat.i(140823);
        int d2 = d(jSONArray, i2);
        AppMethodBeat.o(140823);
        return d2;
    }

    private static int d(JSONArray jSONArray, int i2) {
        int i3 = 0;
        AppMethodBeat.i(140824);
        if (jSONArray == null) {
            AppMethodBeat.o(140824);
        } else {
            try {
                i3 = Math.round(((float) jSONArray.getDouble(i2)) * bZk());
                AppMethodBeat.o(140824);
            } catch (Exception e2) {
                AppMethodBeat.o(140824);
            }
        }
        return i3;
    }

    public static int s(JSONArray jSONArray) {
        AppMethodBeat.i(140825);
        int round = Math.round(((float) jSONArray.getDouble(0)) * bZk());
        AppMethodBeat.o(140825);
        return round;
    }

    public static float i(JSONObject jSONObject, String str) {
        AppMethodBeat.i(140826);
        float f2 = ((float) jSONObject.getDouble(str)) * bZk();
        AppMethodBeat.o(140826);
        return f2;
    }

    public static float e(JSONArray jSONArray, int i2) {
        AppMethodBeat.i(140827);
        float f2 = ((float) jSONArray.getDouble(i2)) * bZk();
        AppMethodBeat.o(140827);
        return f2;
    }

    public static float f(JSONArray jSONArray, int i2) {
        AppMethodBeat.i(140828);
        float g2 = g(jSONArray, i2);
        AppMethodBeat.o(140828);
        return g2;
    }

    private static float g(JSONArray jSONArray, int i2) {
        AppMethodBeat.i(140829);
        if (jSONArray == null) {
            AppMethodBeat.o(140829);
            return 0.0f;
        }
        try {
            float bZk = bZk() * ((float) jSONArray.getDouble(i2));
            AppMethodBeat.o(140829);
            return bZk;
        } catch (Exception e2) {
            AppMethodBeat.o(140829);
            return 0.0f;
        }
    }

    public static void aU(float f2) {
        AppMethodBeat.i(140830);
        if (f2 > 0.0f) {
            ogx = Float.valueOf(f2);
        }
        AppMethodBeat.o(140830);
    }

    public static float bZk() {
        AppMethodBeat.i(140831);
        Float f2 = ogx;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            AppMethodBeat.o(140831);
            return floatValue;
        }
        DisplayMetrics displayMetrics = ogw;
        if (displayMetrics == null) {
            AppMethodBeat.o(140831);
            return 1.0f;
        }
        float f3 = displayMetrics.density;
        AppMethodBeat.o(140831);
        return f3;
    }
}
