package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;

public final class e {
    public static final int oYI = au.getStatusBarHeight(MMApplicationContext.getContext());
    public static final int oYJ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a6e);
    public static final int oYK = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a6j);
    public static final int oYL = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a6i);
    public static final int oYM = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a6f);
    public static final int oYN = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a6g);
    public static final int oYO = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a7g);
    public static final int oYP;
    public static final float oYQ;
    public static final int oYR = (com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) - (oYK + oYN));
    public static final int oYS = (oYJ + oYI);
    public static final int oYT = ((com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()) - oYJ) - ((oYK + oYL) + oYM));
    public static int oYU = aD(MMApplicationContext.getContext());
    public static final int oYV = oYS;
    public static final int oYW = ((int) (((float) com.tencent.mm.cb.a.jo(MMApplicationContext.getContext())) * 0.3f));

    static {
        AppMethodBeat.i(106369);
        int dimensionPixelSize = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a7f);
        oYP = dimensionPixelSize;
        oYQ = ((float) dimensionPixelSize) / ((float) oYO);
        AppMethodBeat.o(106369);
    }

    private static int aD(Context context) {
        int i2 = 0;
        AppMethodBeat.i(106367);
        try {
            i2 = au.aD(context);
        } catch (Exception e2) {
            Log.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", e2);
        }
        AppMethodBeat.o(106367);
        return i2;
    }

    public static void eG(Context context) {
        AppMethodBeat.i(106368);
        oYU = aD(context);
        AppMethodBeat.o(106368);
    }

    public enum a {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT;

        public static a valueOf(String str) {
            AppMethodBeat.i(106365);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(106365);
            return aVar;
        }

        static {
            AppMethodBeat.i(106366);
            AppMethodBeat.o(106366);
        }
    }
}
