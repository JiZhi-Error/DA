package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b {
    public static boolean baS() {
        AppMethodBeat.i(150444);
        String value = ((a) g.af(a.class)).aqJ().getValue("C2CImgNotAutoDownloadTimeRange");
        Log.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(value)));
        boolean Of = Of(value);
        AppMethodBeat.o(150444);
        return Of;
    }

    public static boolean Of(String str) {
        String[] split;
        AppMethodBeat.i(150445);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150445);
            return false;
        }
        try {
            int baT = baT();
            for (String str2 : str.split(";")) {
                String[] split2 = str2.split("-");
                String[] split3 = split2[0].split(":");
                int safeParseInt = Util.safeParseInt(split3[1]);
                String[] split4 = split2[1].split(":");
                if (N(safeParseInt + (Util.safeParseInt(split3[0]) * 60), Util.safeParseInt(split4[1]) + (Util.safeParseInt(split4[0]) * 60), baT)) {
                    AppMethodBeat.o(150445);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e2, "", new Object[0]);
            Log.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e2.toString());
        }
        AppMethodBeat.o(150445);
        return false;
    }

    public static boolean ar(String str, int i2) {
        String[] split;
        AppMethodBeat.i(150446);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150446);
            return false;
        }
        try {
            int baT = baT();
            for (String str2 : str.split(";")) {
                String[] split2 = str2.split("-");
                String[] split3 = split2[0].split(":");
                int safeParseInt = Util.safeParseInt(split3[1]);
                String[] split4 = split2[1].split(":");
                if (N(safeParseInt + (Util.safeParseInt(split3[0]) * 60), Util.safeParseInt(split4[1]) + (Util.safeParseInt(split4[0]) * 60) + i2, baT)) {
                    AppMethodBeat.o(150446);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e2, "", new Object[0]);
            Log.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e2.toString());
        }
        AppMethodBeat.o(150446);
        return false;
    }

    private static int baT() {
        AppMethodBeat.i(150447);
        String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
        int safeParseInt = (Util.safeParseInt(split[1]) + (Util.safeParseInt(split[0]) * 60)) - ((((int) baU()) - 8) * 60);
        if (safeParseInt < 0) {
            safeParseInt += 1440;
        } else if (safeParseInt >= 1440) {
            safeParseInt -= 1440;
        }
        AppMethodBeat.o(150447);
        return safeParseInt;
    }

    public static long baU() {
        AppMethodBeat.i(150448);
        long rawOffset = ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / Util.MILLSECONDS_OF_MINUTE))) / 60;
        AppMethodBeat.o(150448);
        return rawOffset;
    }

    private static boolean N(int i2, int i3, int i4) {
        if (i2 < i3) {
            return i4 < i3 && i4 >= i2;
        }
        if (i4 > 1440 || i4 < i2) {
            return i4 < i3 && i4 >= 0;
        }
        return true;
    }
}
