package com.tencent.mm.game.report.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    private static String uuid = null;

    public static int getNetworkType(Context context) {
        AppMethodBeat.i(108274);
        if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(108274);
            return 4;
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(108274);
            return 5;
        } else {
            switch (NetStatusUtil.getNetType(context)) {
                case -1:
                    AppMethodBeat.o(108274);
                    return 255;
                case 0:
                    AppMethodBeat.o(108274);
                    return 1;
                case 1:
                case 2:
                case 3:
                case 4:
                default:
                    AppMethodBeat.o(108274);
                    return 6;
                case 5:
                    AppMethodBeat.o(108274);
                    return 2;
                case 6:
                    AppMethodBeat.o(108274);
                    return 3;
            }
        }
    }

    public static String Fh(String str) {
        String str2;
        AppMethodBeat.i(108275);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(108275);
            return "";
        }
        try {
            str2 = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Exception e2) {
            str2 = "";
            Log.e("MicroMsg.GameReportUtil", e2.getMessage());
        }
        AppMethodBeat.o(108275);
        return str2;
    }

    public static String axg() {
        AppMethodBeat.i(108276);
        if (uuid == null) {
            String aoG = q.aoG();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < aoG.length() - 1; i2++) {
                sb.append(Integer.toHexString(aoG.charAt(i2)));
            }
            sb.append("00");
            uuid = sb.toString();
        }
        String str = uuid;
        AppMethodBeat.o(108276);
        return str;
    }

    public static String zn(long j2) {
        AppMethodBeat.i(108278);
        String bigInteger = new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(j2)).toString();
        Log.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = ".concat(String.valueOf(bigInteger)));
        AppMethodBeat.o(108278);
        return bigInteger;
    }

    public static String u(Map<String, String> map) {
        AppMethodBeat.i(108279);
        if (map == null || map.size() == 0) {
            AppMethodBeat.o(108279);
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e2) {
                Log.e("MicroMsg.GameReportUtil", e2.getMessage());
                AppMethodBeat.o(108279);
                return "";
            }
        }
        try {
            String encode = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(108279);
            return encode;
        } catch (Exception e3) {
            Log.e("MicroMsg.GameReportUtil", e3.getMessage());
            AppMethodBeat.o(108279);
            return "";
        }
    }

    public static int E(Context context, String str) {
        AppMethodBeat.i(108277);
        PackageInfo packageInfo = b.getPackageInfo(context, str);
        if (packageInfo == null) {
            AppMethodBeat.o(108277);
            return 0;
        }
        int i2 = packageInfo.versionCode;
        AppMethodBeat.o(108277);
        return i2;
    }
}
