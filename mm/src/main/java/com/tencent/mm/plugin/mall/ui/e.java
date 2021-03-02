package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e {
    private static boolean zmH = false;

    public static void ehs() {
        zmH = true;
    }

    public static int eht() {
        AppMethodBeat.i(66145);
        if (zmH) {
            int color = MMApplicationContext.getContext().getResources().getColor(R.color.zd);
            AppMethodBeat.o(66145);
            return color;
        }
        int color2 = MMApplicationContext.getContext().getResources().getColor(R.color.BW_93);
        AppMethodBeat.o(66145);
        return color2;
    }
}
