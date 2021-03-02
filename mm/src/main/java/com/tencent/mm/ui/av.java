package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class av {
    private static Boolean OLS = null;

    public static Point az(Context context) {
        AppMethodBeat.i(159145);
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception e2) {
                }
            }
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.o(159145);
        return point;
    }

    @TargetApi(17)
    public static boolean aA(Context context) {
        AppMethodBeat.i(159146);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point az = az(context);
        if (Math.max(az.y, az.x) > Math.max(point.y, point.x)) {
            AppMethodBeat.o(159146);
            return true;
        }
        AppMethodBeat.o(159146);
        return false;
    }

    public static int aD(Context context) {
        int identifier;
        AppMethodBeat.i(168811);
        if (!aA(context) || (identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            AppMethodBeat.o(168811);
            return 0;
        }
        int dimensionPixelSize = Resources.getSystem().getDimensionPixelSize(identifier);
        AppMethodBeat.o(168811);
        return dimensionPixelSize;
    }

    public static int cL(String str) {
        int i2 = 0;
        AppMethodBeat.i(159147);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.decode(str).intValue();
                    AppMethodBeat.o(159147);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                as.printErrStackTrace("WeUIUtil", e2, "", new Object[0]);
                AppMethodBeat.o(159147);
            }
        }
        AppMethodBeat.o(159147);
        return i2;
    }

    public static boolean isMIUI() {
        AppMethodBeat.i(198198);
        if (OLS == null) {
            String str = Build.MANUFACTURER;
            OLS = Boolean.valueOf(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("xiaomi"));
        }
        boolean booleanValue = OLS.booleanValue();
        AppMethodBeat.o(198198);
        return booleanValue;
    }

    public static boolean gKb() {
        AppMethodBeat.i(198199);
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("blackshark")) {
            AppMethodBeat.o(198199);
            return false;
        }
        AppMethodBeat.o(198199);
        return true;
    }
}
