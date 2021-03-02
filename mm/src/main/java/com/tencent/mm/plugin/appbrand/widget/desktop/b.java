package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class b {
    private static boolean onb = false;

    public static int ev(Context context) {
        AppMethodBeat.i(49555);
        if (context == null) {
            AppMethodBeat.o(49555);
            return 0;
        }
        int aH = (int) (((float) a.aH(context, R.dimen.pf)) * ez(context));
        AppMethodBeat.o(49555);
        return aH;
    }

    public static int ew(Context context) {
        AppMethodBeat.i(49556);
        int c2 = c(context, a.getShowCountPerPage());
        AppMethodBeat.o(49556);
        return c2;
    }

    public static int b(int i2, Context context) {
        AppMethodBeat.i(49557);
        int a2 = a(i2, context, a.getShowCountPerPage());
        AppMethodBeat.o(49557);
        return a2;
    }

    private static int getScreenWidth(Context context) {
        AppMethodBeat.i(49558);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (context.getResources().getConfiguration().orientation != 2) {
                int i2 = (int) (((float) context.getResources().getConfiguration().screenWidthDp) * displayMetrics.density);
                AppMethodBeat.o(49558);
                return i2;
            } else if (ao.aQ(context)) {
                int i3 = ao.az(context).x;
                AppMethodBeat.o(49558);
                return i3;
            } else {
                int i4 = (int) (((float) context.getResources().getConfiguration().screenHeightDp) * displayMetrics.density);
                AppMethodBeat.o(49558);
                return i4;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandDesktopSizeHelper", e2, "alvinluo getScreenWidth exception", new Object[0]);
            AppMethodBeat.o(49558);
            return 0;
        }
    }

    private static int a(int i2, Context context, float f2) {
        int i3;
        AppMethodBeat.i(49559);
        if (context == null) {
            AppMethodBeat.o(49559);
            return 0;
        }
        int ev = ev(context);
        if (a.cak()) {
            i3 = (int) (((double) (((float) i2) - (((float) ev) * f2))) / Math.ceil((double) f2));
        } else {
            onb = false;
            int ex = ex(context);
            i3 = ((i2 - (ex * 2)) - (((int) f2) * ev)) / ((((int) f2) - 1) * 2);
            if (i3 > ex) {
                i3 = (i2 - (((int) f2) * ev)) / (((int) f2) * 2);
                onb = true;
            } else {
                onb = false;
            }
        }
        if (i3 < 0) {
            i3 = 0;
        }
        Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d, countPerPage: %f, leftRightPaddingZero: %b", Integer.valueOf(ev), Integer.valueOf(i3), Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(onb));
        AppMethodBeat.o(49559);
        return i3;
    }

    public static int c(Context context, float f2) {
        AppMethodBeat.i(49560);
        if (context == null) {
            AppMethodBeat.o(49560);
            return 0;
        }
        int a2 = a(getScreenWidth(context), context, f2);
        AppMethodBeat.o(49560);
        return a2;
    }

    public static int ex(Context context) {
        AppMethodBeat.i(49561);
        if (onb) {
            AppMethodBeat.o(49561);
            return 0;
        }
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.pg);
        float ez = ez(context);
        if (!(ez == a.iX(context) || ez == a.iW(context))) {
            dimensionPixelOffset = (ez == a.iY(context) || ez == a.iZ(context) || ez == a.ja(context)) ? context.getResources().getDimensionPixelOffset(R.dimen.hs) : context.getResources().getDimensionPixelOffset(R.dimen.ir);
        }
        Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo getLeftRightPadding: %d", Integer.valueOf(dimensionPixelOffset));
        AppMethodBeat.o(49561);
        return dimensionPixelOffset;
    }

    public static float ey(Context context) {
        AppMethodBeat.i(49562);
        float aH = ((float) a.aH(context, R.dimen.pb)) * ez(context);
        Log.d("MicroMsg.AppBrandDesktopSizeHelper", "alvinluo iconSize: %f", Float.valueOf(aH));
        AppMethodBeat.o(49562);
        return aH;
    }

    public static float ez(Context context) {
        AppMethodBeat.i(49563);
        float ez = a.ez(context);
        if (ez == a.jb(context) || ez == a.jc(context) || ez == a.jd(context)) {
            ez = a.ja(context);
        }
        AppMethodBeat.o(49563);
        return ez;
    }
}
