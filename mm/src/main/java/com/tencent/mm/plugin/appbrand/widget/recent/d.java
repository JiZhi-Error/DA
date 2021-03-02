package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    private static int omD = 1;
    public static float omE = 4.5f;
    public static int omF = 4;
    public static float omG = 3.5f;
    public static int omH = 3;
    public static final int omI = AppBrandGlobalSystemConfig.bzP().lcW;
    private static float omJ = omE;
    private static int omK = omF;
    private static int omL = 1;
    private static int omM = 0;

    static {
        AppMethodBeat.i(227784);
        AppMethodBeat.o(227784);
    }

    public static boolean cak() {
        return omD == 2;
    }

    public static int byo() {
        AppMethodBeat.i(227782);
        if (omM == 0) {
            omM = ((ag) g.af(ag.class)).bxH();
        }
        int i2 = omM;
        AppMethodBeat.o(227782);
        return i2;
    }

    public static boolean ccS() {
        return true;
    }

    public static void init(Context context) {
        AppMethodBeat.i(227783);
        Log.i("MicroMsg.AppBrandRecentConfig", "alvinluo DesktopConfig init mCurrentType: %d", Integer.valueOf(omD));
        if (omD == 1) {
            omE = 4.0f;
            omF = 4;
            omG = 3.0f;
            omH = 3;
            omJ = omE;
            omK = omF;
        }
        int c2 = f.c(context, omJ);
        if (omD == 1) {
            c2 = (int) (((float) c2) + (((float) (context.getResources().getDimensionPixelSize(R.dimen.k5) * 2)) * f.ez(context)));
        }
        if (c2 <= a.fromDPToPix(context, 10)) {
            omJ = omG;
            omK = omH;
        } else {
            omJ = omE;
            omK = omF;
        }
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_appbrand_desktop_recent_max_show_lines, 1);
        omL = a2;
        int max = Math.max(a2, 1);
        omL = max;
        omL = Math.min(max, 4);
        Log.i("MicroMsg.AppBrandRecentConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", Float.valueOf(omJ), Integer.valueOf(omK), Integer.valueOf(omL));
        AppMethodBeat.o(227783);
    }

    public static float getShowCountPerPage() {
        return omJ;
    }

    public static int getCompletelyCountPerPage() {
        return omK;
    }
}
