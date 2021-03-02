package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;

public final class r {
    private static String Kww = null;
    private static final String[] Kwx = {"", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use"};

    public static void pl(int i2) {
        AppMethodBeat.i(133687);
        gH(i2, 0);
        AppMethodBeat.o(133687);
    }

    public static void gH(int i2, int i3) {
        AppMethodBeat.i(133688);
        if (i2 <= 0 || i2 > 7) {
            Log.e("MicroMsg.TBSReporter", "report invalid scene = %d", Integer.valueOf(i2));
            AppMethodBeat.o(133688);
            return;
        }
        kF(i2, i3);
        Context context = MMApplicationContext.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        String iD = iD(context);
        h.INSTANCE.a(11633, false, true, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(installedTbsCoreVersion), Integer.valueOf(tbsSDKVersion), iD, Integer.valueOf(i3));
        AppMethodBeat.o(133688);
    }

    private static String iD(Context context) {
        AppMethodBeat.i(133689);
        if (Kww != null) {
            String str = Kww;
            AppMethodBeat.o(133689);
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(MMApplicationContext.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String string = applicationInfo.metaData.getString("com.tencent.mtt.TBS_CODE");
                if (!Util.isNullOrNil(string)) {
                    Kww = string;
                    AppMethodBeat.o(133689);
                    return string;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", e2.getMessage());
        }
        AppMethodBeat.o(133689);
        return null;
    }

    private static void kF(int i2, int i3) {
        AppMethodBeat.i(133690);
        Log.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", Integer.valueOf(i2), Kwx[i2], Integer.valueOf(i3));
        AppMethodBeat.o(133690);
    }
}
