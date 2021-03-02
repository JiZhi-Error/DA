package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    public static boolean Aw(int i2) {
        return i2 >= 0 && i2 <= 59;
    }

    public static boolean Ax(int i2) {
        return i2 >= 0 && i2 <= 23;
    }

    public static int[] agg(String str) {
        AppMethodBeat.i(138087);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(138087);
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 2) {
            AppMethodBeat.o(138087);
            return null;
        }
        int agh = agh(split[0]);
        int agh2 = agh(split[1]);
        if (!Ax(agh) || !Aw(agh2)) {
            AppMethodBeat.o(138087);
            return null;
        }
        int[] iArr = {agh, agh2};
        AppMethodBeat.o(138087);
        return iArr;
    }

    private static int agh(String str) {
        AppMethodBeat.i(138088);
        try {
            int parseInt = Integer.parseInt(str, 10);
            AppMethodBeat.o(138088);
            return parseInt;
        } catch (Exception e2) {
            AppMethodBeat.o(138088);
            return -1;
        }
    }
}
