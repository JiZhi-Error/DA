package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Util;

public final class o {
    public static boolean y(CharSequence charSequence) {
        AppMethodBeat.i(155911);
        if (charSequence == null) {
            AppMethodBeat.o(155911);
            return false;
        } else if (ae.gKE.gGH == 1) {
            AppMethodBeat.o(155911);
            return true;
        } else if (Build.VERSION.SDK_INT != 16) {
            AppMethodBeat.o(155911);
            return false;
        } else if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0) {
            AppMethodBeat.o(155911);
            return false;
        } else {
            AppMethodBeat.o(155911);
            return true;
        }
    }

    public static String Eh(String str) {
        AppMethodBeat.i(155912);
        if (str == null) {
            AppMethodBeat.o(155912);
            return str;
        } else if (ae.gKE.gGH == 2) {
            AppMethodBeat.o(155912);
            return str;
        } else if (ae.gKE.gGS == 1) {
            AppMethodBeat.o(155912);
            return str;
        } else if (ae.gKE.gGH == 1) {
            if (str.toString().contains("\n")) {
                String replace = str.toString().replace("\n", " ");
                AppMethodBeat.o(155912);
                return replace;
            }
            AppMethodBeat.o(155912);
            return str;
        } else if (Build.VERSION.SDK_INT != 16) {
            AppMethodBeat.o(155912);
            return str;
        } else if (!str.toString().contains("\n")) {
            AppMethodBeat.o(155912);
            return str;
        } else if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0) {
            AppMethodBeat.o(155912);
            return str;
        } else {
            String replace2 = str.toString().replace("\n", " ");
            AppMethodBeat.o(155912);
            return replace2;
        }
    }
}
