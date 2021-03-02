package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ae {
    public static x gKA = new x();
    public static x gKB = new x();
    public static a gKC = new a();
    private static int gKD = -1;
    public static k gKE = new k();
    public static p gKF = new p();
    public static o gKs = new o();
    public static c gKt = new c();
    public static b gKu = new b();
    public static aa gKv = new aa();
    public static ag gKw = new ag();
    public static t gKx = new t();
    public static y gKy = new y();
    public static ad gKz = new ad();

    static {
        AppMethodBeat.i(155825);
        AppMethodBeat.o(155825);
    }

    public static void DV(String str) {
        AppMethodBeat.i(155823);
        Log.i("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", str);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(155823);
        } else if (str.hashCode() == gKD) {
            AppMethodBeat.o(155823);
        } else {
            gKD = str.hashCode();
            gKs.reset();
            gKt.reset();
            gKu.reset();
            gKE.reset();
            gKv.reset();
            gKw.reset();
            t tVar = gKx;
            tVar.gIE = 0;
            tVar.gIF = 0;
            y yVar = gKy;
            yVar.gJB = "";
            yVar.gJC = null;
            ad adVar = gKz;
            adVar.edB = false;
            adVar.gKq = 0;
            adVar.gKr = false;
            gKA.reset();
            gKB.reset();
            a aVar = gKC;
            aVar.gDy = false;
            aVar.gDz = "";
            new s();
            if (!s.a(str, gKs, gKt, gKu, gKE, gKv, gKw, gKx, gKy, gKz, gKA, gKC, gKB)) {
                AppMethodBeat.o(155823);
                return;
            }
            Log.i("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + gKt.gGh + ", mVoipBeautyWhiteCfg=" + gKt.gGi);
            EventCenter.instance.publish(new cx());
            AppMethodBeat.o(155823);
        }
    }

    public static String cu(Context context) {
        AppMethodBeat.i(155824);
        try {
            Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer CurrentLanguage is %s", LocaleUtil.getCurrentLanguage(context));
            if (gKy == null || gKy.gJC == null || gKy.gJC.size() == 0) {
                Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer return is %s", Build.MANUFACTURER);
                String str = Build.MANUFACTURER;
                AppMethodBeat.o(155824);
                return str;
            }
            String str2 = gKy.gJC.get(".manufacturerName." + LocaleUtil.getCurrentLanguage(context));
            Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", str2);
            if (!Util.isNullOrNil(str2)) {
                AppMethodBeat.o(155824);
                return str2;
            }
            String str3 = gKy.gJC.get(".manufacturerName.en");
            Log.i("MicroMsg.SrvDeviceInfo", "lm: getManufacturer is %s", str3);
            if (!Util.isNullOrNil(str3)) {
                AppMethodBeat.o(155824);
                return str3;
            }
            String str4 = Build.MANUFACTURER;
            AppMethodBeat.o(155824);
            return str4;
        } catch (Exception e2) {
            String str5 = Build.MANUFACTURER;
            AppMethodBeat.o(155824);
            return str5;
        }
    }
}
