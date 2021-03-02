package com.tencent.mm.cq;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    private static String[] Rxc = {"BND-AL00", "BND-AL10", "BND-TL10", "NOVA 2S", "HWI-AL00", "HWI-TL00", "LLD-AL00", "LLD-AL10", "LLD-TL10", "MATE 9", "MHA-AL00", "MHA-TL00", "MATE 9 PRO", "LON-AL00", "PRA-AL00", "PRA-AL00X", "PRA-TL10", "STF-AL00", "STF-AL10", "STF-TL10", "P10", "VTR-AL00", "VTR-TL00", "P10 PLUS", "VKY-AL00", "VKY-TL00", "MATE10", "ALP-AL00", "ALP-TL00", "MATE10PRO", "BLA-AL00", "BLA-TL00", "P20", "EML-AL00", "EML-TL00", "P20PRO", "CLT-AL00", "CLT-AL01", "CLT-TL00", "MATE RS", "NEO-AL00", "COR-AL00", "COR-AL10", "COR-TL10", "NOVA3", "PAR-AL00", "PAR-TL00", "NOVA3I", "INE-AL00", "INE-TL00", "NOVA 3E", "ANE-AL00", "ANE-TL00", "COL-AL10", "COL-TL10"};

    public static boolean ml(int i2, int i3) {
        AppMethodBeat.i(152884);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_bigimgopt_for_huawei, 0);
        if (a2 == 1) {
            Log.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter clicfg notFilter: %d", Integer.valueOf(a2));
            AppMethodBeat.o(152884);
            return false;
        }
        if (!((i2 >= 5700 && i3 >= 8000) || (i2 >= 8000 && i3 >= 5700))) {
            AppMethodBeat.o(152884);
            return false;
        }
        String str = Build.MODEL;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152884);
            return false;
        }
        for (String str2 : Rxc) {
            if (str.equalsIgnoreCase(str2)) {
                Log.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter filter model: %s, width: %d, height: %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
                AppMethodBeat.o(152884);
                return true;
            }
        }
        AppMethodBeat.o(152884);
        return false;
    }
}
