package com.tencent.mm.plugin.appbrand.ac;

import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class o {
    private static DisplayMetrics ogw = MMApplicationContext.getContext().getResources().getDisplayMetrics();

    static {
        AppMethodBeat.i(146132);
        AppMethodBeat.o(146132);
    }

    public static int zE(int i2) {
        return ogw == null ? i2 : (int) (ogw.density * ((float) i2));
    }
}
