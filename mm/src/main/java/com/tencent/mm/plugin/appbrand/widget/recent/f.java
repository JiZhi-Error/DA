package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class f {
    private static boolean onb = false;

    public static int ev(Context context) {
        AppMethodBeat.i(227785);
        if (context == null) {
            AppMethodBeat.o(227785);
            return 0;
        }
        int aH = (int) (((float) a.aH(context, R.dimen.pf)) * ez(context));
        AppMethodBeat.o(227785);
        return aH;
    }

    public static int ew(Context context) {
        AppMethodBeat.i(227786);
        int c2 = c(context, d.getShowCountPerPage());
        AppMethodBeat.o(227786);
        return c2;
    }

    private static int getScreenWidth(Context context) {
        AppMethodBeat.i(227787);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (context.getResources().getConfiguration().orientation != 2) {
                int i2 = (int) (((float) context.getResources().getConfiguration().screenWidthDp) * displayMetrics.density);
                AppMethodBeat.o(227787);
                return i2;
            } else if (ao.aQ(context)) {
                int i3 = ao.az(context).x;
                AppMethodBeat.o(227787);
                return i3;
            } else {
                int i4 = (int) (((float) context.getResources().getConfiguration().screenHeightDp) * displayMetrics.density);
                AppMethodBeat.o(227787);
                return i4;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandRecentSizeHelper", e2, "alvinluo getScreenWidth exception", new Object[0]);
            AppMethodBeat.o(227787);
            return 0;
        }
    }

    private static int a(int i2, Context context, float f2) {
        int i3;
        AppMethodBeat.i(227788);
        if (context == null) {
            AppMethodBeat.o(227788);
            return 0;
        }
        int ev = ev(context);
        if (d.cak()) {
            i3 = (int) (((double) (((float) i2) - (((float) ev) * f2))) / Math.ceil((double) f2));
        } else {
            onb = false;
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.pg);
            float ez = ez(context);
            if (!(ez == a.iX(context) || ez == a.iW(context))) {
                dimensionPixelOffset = (ez == a.iY(context) || ez == a.iZ(context) || ez == a.ja(context)) ? context.getResources().getDimensionPixelOffset(R.dimen.hs) : context.getResources().getDimensionPixelOffset(R.dimen.ir);
            }
            Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo getLeftRightPadding: %d", Integer.valueOf(dimensionPixelOffset));
            int i4 = ((i2 - (dimensionPixelOffset * 2)) - (((int) f2) * ev)) / ((((int) f2) - 1) * 2);
            if (i4 > dimensionPixelOffset) {
                i3 = (i2 - (((int) f2) * ev)) / (((int) f2) * 2);
                onb = true;
            } else {
                onb = false;
                i3 = i4;
            }
        }
        if (i3 < 0) {
            i3 = 0;
        }
        Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", Integer.valueOf(ev), Integer.valueOf(i3), Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(onb));
        AppMethodBeat.o(227788);
        return i3;
    }

    public static int c(Context context, float f2) {
        AppMethodBeat.i(227789);
        if (context == null) {
            AppMethodBeat.o(227789);
            return 0;
        }
        int a2 = a(getScreenWidth(context), context, f2);
        AppMethodBeat.o(227789);
        return a2;
    }

    public static float ey(Context context) {
        AppMethodBeat.i(227790);
        float aH = ((float) a.aH(context, R.dimen.pb)) * ez(context);
        Log.d("MicroMsg.AppBrandRecentSizeHelper", "alvinluo iconSize: %f", Float.valueOf(aH));
        AppMethodBeat.o(227790);
        return aH;
    }

    public static float eA(Context context) {
        AppMethodBeat.i(261640);
        float aH = ((float) a.aH(context, R.dimen.pc)) * ez(context);
        AppMethodBeat.o(261640);
        return aH;
    }

    public static float ez(Context context) {
        AppMethodBeat.i(227791);
        float ez = a.ez(context);
        if (ez == a.jb(context) || ez == a.jc(context) || ez == a.jd(context)) {
            ez = a.ja(context);
        }
        AppMethodBeat.o(227791);
        return ez;
    }
}
