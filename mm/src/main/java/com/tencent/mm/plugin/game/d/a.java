package com.tencent.mm.plugin.game.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class a {
    private static String xNZ = "";

    public static void a(int i2, int i3, int i4, long j2, String str, String str2, long j3, long j4) {
        AppMethodBeat.i(41850);
        com.tencent.mm.game.report.api.a.hhr.a(b.e(14683, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), str, null, str2, Long.valueOf(j3), Long.valueOf(j4), null));
        AppMethodBeat.o(41850);
    }

    public static void bz(int i2, String str) {
        AppMethodBeat.i(41851);
        b bVar = new b();
        bVar.hhs = i2;
        bVar.hht = str;
        com.tencent.mm.game.report.api.a.hhr.a(bVar);
        AppMethodBeat.o(41851);
    }

    public static String Fh(String str) {
        String str2;
        AppMethodBeat.i(41852);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41852);
            return "";
        }
        try {
            str2 = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Exception e2) {
            str2 = "";
            Log.e("MicroMsg.GameReportUtil", e2.getMessage());
        }
        AppMethodBeat.o(41852);
        return str2;
    }

    public static String u(Map<String, String> map) {
        AppMethodBeat.i(41853);
        if (map.size() == 0) {
            AppMethodBeat.o(41853);
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e2) {
                Log.e("MicroMsg.GameReportUtil", e2.getMessage());
                AppMethodBeat.o(41853);
                return "";
            }
        }
        try {
            String encode = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(41853);
            return encode;
        } catch (Exception e3) {
            Log.e("MicroMsg.GameReportUtil", e3.getMessage());
            AppMethodBeat.o(41853);
            return "";
        }
    }

    public static String as(String str, String str2, String str3) {
        AppMethodBeat.i(41854);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, str3);
        } catch (Exception e2) {
            Log.e("MicroMsg.GameReportUtil", e2.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = hN(str, jSONObject.toString());
        }
        String Fh = Fh(str);
        AppMethodBeat.o(41854);
        return Fh;
    }

    private static String hN(String str, String str2) {
        AppMethodBeat.i(41855);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41855);
            return str2;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    } catch (Exception e3) {
                        AppMethodBeat.o(41855);
                        return "";
                    }
                }
            }
            String jSONObject3 = jSONObject2.toString();
            AppMethodBeat.o(41855);
            return jSONObject3;
        } catch (JSONException e4) {
            AppMethodBeat.o(41855);
            return "";
        }
    }

    public static void aAy(String str) {
        xNZ = str;
    }

    public static void b(Context context, int i2, int i3, int i4, String str, int i5, String str2) {
        int i6;
        AppMethodBeat.i(41849);
        Log.i("MicroMsg.GameReportUtil", "reportExposureInfo : " + i2 + " , " + i3 + " , " + i4 + " , 1 , 0 , " + Util.nullAsNil(str) + " , " + i5 + " , 0 , " + Util.nullAsNil((String) null) + " , " + Util.nullAsNil((String) null) + " , " + Util.nullAsNil(str2));
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[12];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i4);
        objArr[3] = 1;
        objArr[4] = 0;
        objArr[5] = str;
        objArr[6] = Integer.valueOf(i5);
        objArr[7] = 0;
        objArr[8] = null;
        objArr[9] = Integer.valueOf(Util.getInt(null, 0));
        if (!NetStatusUtil.is3G(context)) {
            if (!NetStatusUtil.is4G(context)) {
                switch (NetStatusUtil.getNetType(context)) {
                    case -1:
                        i6 = 255;
                        break;
                    case 0:
                        i6 = 1;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    default:
                        i6 = 6;
                        break;
                    case 5:
                        i6 = 2;
                        break;
                    case 6:
                        i6 = 3;
                        break;
                }
            } else {
                i6 = 5;
            }
        } else {
            i6 = 4;
        }
        objArr[10] = Integer.valueOf(i6);
        objArr[11] = str2;
        hVar.a(13384, objArr);
        AppMethodBeat.o(41849);
    }
}
