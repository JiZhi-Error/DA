package com.tencent.magicbrush.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static float cPs = -1.0f;

    public static float getDensity(Context context) {
        AppMethodBeat.i(140067);
        if (cPs < 0.0f) {
            cPs = context.getResources().getDisplayMetrics().density;
        }
        float f2 = cPs;
        AppMethodBeat.o(140067);
        return f2;
    }

    private static int z(Context context, int i2) {
        AppMethodBeat.i(140068);
        int ceil = (int) Math.ceil((double) (((float) i2) / getDensity(context)));
        AppMethodBeat.o(140068);
        return ceil;
    }

    public static Point aV(Context context) {
        Point point;
        AppMethodBeat.i(140069);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point2 = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealSize(point2);
            if (!(point2.x == 0 || point2.y == 0)) {
                point = point2;
                point.x = z(context, point.x);
                point.y = z(context, point.y);
                AppMethodBeat.o(140069);
                return point;
            }
        }
        point2.x = context.getResources().getDisplayMetrics().widthPixels;
        point2.y = context.getResources().getDisplayMetrics().heightPixels;
        point = point2;
        point.x = z(context, point.x);
        point.y = z(context, point.y);
        AppMethodBeat.o(140069);
        return point;
    }
}
