package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.util.Map;
import org.json.JSONObject;

public final class f {
    private static double mbq = -85.0d;
    private static double mbr = -1000.0d;
    private static double mbs = -85.0d;
    private static double mbt = -1000.0d;

    /* access modifiers changed from: package-private */
    public enum a {
        GPS,
        NETWORK;

        public static a valueOf(String str) {
            AppMethodBeat.i(143709);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(143709);
            return aVar;
        }

        static {
            AppMethodBeat.i(143710);
            AppMethodBeat.o(143710);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        if (r23 > 0.0d) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(double r14, double r16, double r18, double r20, java.lang.String r22, double r23) {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.k.a.f.a(double, double, double, double, java.lang.String, double):boolean");
    }

    public static double h(double d2, double d3) {
        double d4;
        AppMethodBeat.i(143712);
        mbs = d2;
        mbt = d3;
        if (mbq == -85.0d || mbr == -1000.0d) {
            d4 = 0.0d;
        } else {
            d4 = (Math.atan2(mbt - mbr, mbs - mbq) * 180.0d) / 3.141592d;
        }
        mbq = mbs;
        mbr = mbt;
        AppMethodBeat.o(143712);
        return d4;
    }

    public static float aL(float f2) {
        if (f2 > 0.0f) {
            return f2 % 360.0f;
        }
        return (((float) ((((((int) f2) * -1) / v2helper.VOIP_ENC_HEIGHT_LV1) + 1) * v2helper.VOIP_ENC_HEIGHT_LV1)) + f2) % 360.0f;
    }

    public static String i(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(143713);
        int ab = ab(jSONObject);
        if (ab == -1) {
            AppMethodBeat.o(143713);
            return "invalid_map_id";
        }
        String str = fVar.getComponentId() + "&" + ab;
        AppMethodBeat.o(143713);
        return str;
    }

    public static int ab(JSONObject jSONObject) {
        AppMethodBeat.i(143714);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.o(143714);
            return optInt;
        } catch (Exception e2) {
            AppMethodBeat.o(143714);
            return -1;
        }
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        String str3;
        AppMethodBeat.i(143715);
        Object obj = map.get(str);
        if (obj instanceof String) {
            str3 = (String) obj;
        } else if (obj != null) {
            str3 = String.valueOf(obj);
        } else {
            str3 = null;
        }
        if (str3 != null) {
            AppMethodBeat.o(143715);
            return str3;
        }
        AppMethodBeat.o(143715);
        return str2;
    }

    public static int a(Map<String, Object> map, String str, int i2) {
        AppMethodBeat.i(143716);
        Integer cG = cG(map.get(str));
        if (cG != null) {
            int intValue = cG.intValue();
            AppMethodBeat.o(143716);
            return intValue;
        }
        AppMethodBeat.o(143716);
        return i2;
    }

    private static Integer cG(Object obj) {
        AppMethodBeat.i(143717);
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            AppMethodBeat.o(143717);
            return num;
        } else if (obj instanceof Number) {
            Integer valueOf = Integer.valueOf(((Number) obj).intValue());
            AppMethodBeat.o(143717);
            return valueOf;
        } else {
            if (obj instanceof String) {
                try {
                    Integer valueOf2 = Integer.valueOf((int) Double.parseDouble((String) obj));
                    AppMethodBeat.o(143717);
                    return valueOf2;
                } catch (NumberFormatException e2) {
                }
            }
            AppMethodBeat.o(143717);
            return null;
        }
    }
}
