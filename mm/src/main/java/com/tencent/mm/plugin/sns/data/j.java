package com.tencent.mm.plugin.sns.data;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j {
    public static String DDV = "offline_video_error";
    public static String DDW = "offline_video_error2";
    public static String DDX = "fullcard_info_null";
    public static String DDY = "download_info_null";
    public static String DDZ = "video_end_in_anim";
    public static String DEa = "sight_del_err_file";
    public static String DEb = "cut_height_error";
    public static String DEc = "oaid_empty";
    public static String DEd = "gyroscope_sensor";
    public static String DEe = "dev_disable_hevc";
    public static String VaK = "twist_zone_sensor";

    public static void b(String str, String str2, int i2, int i3, String str3) {
        AppMethodBeat.i(202586);
        try {
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(202586);
                return;
            }
            String nullAs = Util.nullAs(str2, "");
            String nullAs2 = Util.nullAs(str3, "");
            Log.i("SnsAdTecReportUtil", "adTecReport, actName=" + str + ", actValue=" + nullAs + ", subType=" + i2 + ", subValue=" + i3 + ", extra=" + nullAs2);
            h.INSTANCE.a(19789, str, nullAs, Integer.valueOf(i2), Integer.valueOf(i3), nullAs2);
            AppMethodBeat.o(202586);
        } catch (Throwable th) {
            Log.e("SnsAdTecReportUtil", "adTecReport exp=" + th.toString());
            AppMethodBeat.o(202586);
        }
    }
}
