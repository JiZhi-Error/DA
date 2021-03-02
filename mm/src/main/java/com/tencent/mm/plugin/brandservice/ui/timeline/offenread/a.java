package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    private static float omJ = 4.5f;
    private static int omK = 4;

    public static void init(Context context) {
        AppMethodBeat.i(6126);
        if (c(context, 4.5f) <= com.tencent.mm.cb.a.fromDPToPix(context, 8)) {
            omJ = 3.5f;
            omK = 3;
            AppMethodBeat.o(6126);
            return;
        }
        omJ = 4.5f;
        omK = 4;
        AppMethodBeat.o(6126);
    }

    public static float getShowCountPerPage() {
        return omJ;
    }

    public static int getCompletelyCountPerPage() {
        return omK;
    }

    public static int ev(Context context) {
        AppMethodBeat.i(6127);
        if (context == null) {
            AppMethodBeat.o(6127);
            return 0;
        }
        int aH = (int) (((float) com.tencent.mm.cb.a.aH(context, R.dimen.tf)) * ez(context));
        Log.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", Integer.valueOf(aH));
        AppMethodBeat.o(6127);
        return aH;
    }

    private static int eM(Context context) {
        int i2 = 0;
        AppMethodBeat.i(6129);
        try {
            i2 = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.o(6129);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", e2, "alvinluo getViewWidth exception", new Object[0]);
            AppMethodBeat.o(6129);
        }
        return i2;
    }

    private static int c(Context context, float f2) {
        AppMethodBeat.i(6130);
        if (context == null) {
            AppMethodBeat.o(6130);
            return 0;
        }
        int ev = ev(context);
        int eM = eM(context);
        int floor = (int) (((double) (2.0f * (((float) eM) - (((float) ev) * f2)))) / ((Math.floor((double) f2) * 2.0d) + 1.0d));
        if (floor < 0) {
            floor = 0;
        }
        Log.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo getItemPadding itemWidth: %d, itemPadding: %d, viewWidth: %d", Integer.valueOf(ev), Integer.valueOf(floor), Integer.valueOf(eM));
        AppMethodBeat.o(6130);
        return floor;
    }

    public static int eN(Context context) {
        AppMethodBeat.i(195012);
        if (context == null) {
            AppMethodBeat.o(195012);
            return 0;
        }
        int eM = (int) (((double) (eM(context) * 2)) / ((Math.floor((double) omJ) * 2.0d) + 1.0d));
        AppMethodBeat.o(195012);
        return eM;
    }

    public static int eO(Context context) {
        AppMethodBeat.i(6131);
        int aH = (int) (((float) com.tencent.mm.cb.a.aH(context, R.dimen.te)) * ez(context));
        AppMethodBeat.o(6131);
        return aH;
    }

    public static int eP(Context context) {
        AppMethodBeat.i(195013);
        int aH = (int) (((float) com.tencent.mm.cb.a.aH(context, R.dimen.td)) * ez(context));
        AppMethodBeat.o(195013);
        return aH;
    }

    private static float ez(Context context) {
        AppMethodBeat.i(6132);
        float ez = com.tencent.mm.cb.a.ez(context);
        if (ez == com.tencent.mm.cb.a.jb(context) || ez == com.tencent.mm.cb.a.jc(context) || ez == com.tencent.mm.cb.a.jd(context)) {
            ez = com.tencent.mm.cb.a.ja(context);
        }
        AppMethodBeat.o(6132);
        return ez;
    }

    public static int ew(Context context) {
        AppMethodBeat.i(6128);
        int c2 = c(context, omJ);
        AppMethodBeat.o(6128);
        return c2;
    }
}
