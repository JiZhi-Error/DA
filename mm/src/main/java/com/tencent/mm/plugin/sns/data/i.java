package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;

public final class i {
    public static void d(long j2, String str, String str2) {
        AppMethodBeat.i(202582);
        try {
            ADInfo aDInfo = new ADInfo(str);
            ADXml aDXml = new ADXml(str2);
            String aNZ = aNZ(aDInfo.uxInfo);
            String nullAsNil = Util.nullAsNil(aDXml.adExtInfo);
            Log.i("SnsAdReportAnalyseUtils", "reportAdPull: snsId = " + j2 + ", uxInfo = " + aNZ + ", adExtInfo = " + nullAsNil + ", reportType = 1, extInfo = " + "");
            h.INSTANCE.a(19553, Long.valueOf(j2), aNZ, nullAsNil, 1, "");
            AppMethodBeat.o(202582);
        } catch (Throwable th) {
            Log.e("SnsAdReportAnalyseUtils", th.toString());
            AppMethodBeat.o(202582);
        }
    }

    public static void a(int i2, long j2, ADInfo aDInfo, ADXml aDXml) {
        int i3 = 4;
        AppMethodBeat.i(202583);
        switch (i2) {
            case -1:
                AppMethodBeat.o(202583);
                return;
            case 0:
                i3 = 2;
                break;
            case 1:
                i3 = 3;
                break;
            case 2:
                break;
            case 3:
                i3 = 5;
                break;
            case 4:
                i3 = 6;
                break;
            case 5:
                i3 = 7;
                break;
            default:
                i3 = -1;
                break;
        }
        String str = "";
        String str2 = "";
        if (aDInfo != null) {
            try {
                str = aNZ(aDInfo.uxInfo);
            } catch (Throwable th) {
                Log.e("SnsAdReportAnalyseUtils", th.toString());
                AppMethodBeat.o(202583);
                return;
            }
        }
        if (aDXml != null) {
            str2 = Util.nullAsNil(aDXml.adExtInfo);
        }
        Log.i("SnsAdReportAnalyseUtils", "reportAdDel: snsId = " + r.Jb(j2) + ", uxInfo = " + str + ", adExtInfo = " + str2 + ", reportType = " + i3 + ", extInfo = " + "");
        h.INSTANCE.a(19553, Long.valueOf(j2), str, str2, Integer.valueOf(i3), "");
        AppMethodBeat.o(202583);
    }

    public static void a(String str, String str2, int i2, int i3, String str3, String str4, int i4) {
        AppMethodBeat.i(202584);
        try {
            Log.i("SnsAdReportAnalyseUtils", "snsId = " + str + ", uxInfo = " + str3 + ", adExtInfo = " + str4 + ", appId = " + str2 + ", reportType = " + i2 + ", reportScene = " + i3 + ", reportOrigin = " + i4);
            h.INSTANCE.a(19693, Long.valueOf(System.currentTimeMillis()), str, aNZ(str3), str4, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            AppMethodBeat.o(202584);
        } catch (Throwable th) {
            Log.e("SnsAdReportAnalyseUtils", th.toString());
            AppMethodBeat.o(202584);
        }
    }

    public static String aNZ(String str) {
        AppMethodBeat.i(202585);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(202585);
            return "";
        }
        try {
            str = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Exception e2) {
            Log.e("SnsAdReportAnalyseUtils", e2.toString());
        }
        AppMethodBeat.o(202585);
        return str;
    }
}
