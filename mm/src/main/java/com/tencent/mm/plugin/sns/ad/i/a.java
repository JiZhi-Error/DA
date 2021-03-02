package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static boolean eYe() {
        AppMethodBeat.i(192748);
        try {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_ad_androidid_switch, 1);
            Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportAndroidId is ".concat(String.valueOf(a2)));
            if (a2 == 1) {
                AppMethodBeat.o(192748);
                return true;
            }
            AppMethodBeat.o(192748);
            return false;
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", th.toString());
            AppMethodBeat.o(192748);
            return false;
        }
    }

    public static boolean eYf() {
        AppMethodBeat.i(192749);
        try {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_ad_oaid_switch, 1);
            Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportOAID is ".concat(String.valueOf(a2)));
            if (a2 == 1) {
                AppMethodBeat.o(192749);
                return true;
            }
            AppMethodBeat.o(192749);
            return false;
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", th.toString());
            AppMethodBeat.o(192749);
            return false;
        }
    }

    public static boolean eYg() {
        AppMethodBeat.i(192750);
        try {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_ad_imei_switch, 1);
            Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportIMEI is ".concat(String.valueOf(a2)));
            if (a2 == 1) {
                AppMethodBeat.o(192750);
                return true;
            }
            AppMethodBeat.o(192750);
            return false;
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", th.toString());
            AppMethodBeat.o(192750);
            return false;
        }
    }

    public static boolean eYh() {
        AppMethodBeat.i(192751);
        try {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_ad_uuid_switch, 1);
            Log.i("AdDeviceInfo.AdDeviceIdSwitchHelper", "isReportUUID is ".concat(String.valueOf(a2)));
            if (a2 == 1) {
                AppMethodBeat.o(192751);
                return true;
            }
            AppMethodBeat.o(192751);
            return false;
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.AdDeviceIdSwitchHelper", th.toString());
            AppMethodBeat.o(192751);
            return false;
        }
    }
}
