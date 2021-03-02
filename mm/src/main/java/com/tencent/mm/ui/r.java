package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;
import java.lang.reflect.Method;

public class r {
    private static int aM(Context context, int i2) {
        AppMethodBeat.i(175975);
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.top > i2) {
            Log.w("Luggage.LuggageUIHelper", "[fixStatusBarHeight] top:%s statusHeight:%s", Integer.valueOf(rect.top), Integer.valueOf(i2));
            AppMethodBeat.o(175975);
            return 0;
        }
        AppMethodBeat.o(175975);
        return i2;
    }

    public static int jK(Context context) {
        AppMethodBeat.i(175976);
        int D = n.D(context, 0);
        AppMethodBeat.o(175976);
        return D;
    }

    public static void jV(Context context) {
        AppMethodBeat.i(259294);
        if (context instanceof Activity) {
            e(((Activity) context).getWindow());
        }
        AppMethodBeat.o(259294);
    }

    public static void e(Window window) {
        AppMethodBeat.i(175977);
        if (window == null) {
            AppMethodBeat.o(175977);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.o(175977);
    }

    private static boolean blR(String str) {
        AppMethodBeat.i(196227);
        String str2 = Build.MODEL;
        String str3 = Build.DEVICE;
        if (str2 == null && str3 == null) {
            AppMethodBeat.o(196227);
            return false;
        } else if (ne(str2, str) || ne(str3, str)) {
            AppMethodBeat.o(196227);
            return true;
        } else {
            AppMethodBeat.o(196227);
            return false;
        }
    }

    private static boolean ne(String str, String str2) {
        AppMethodBeat.i(196228);
        if (str == null || str2 == null) {
            AppMethodBeat.o(196228);
            return false;
        }
        boolean isEqual = Util.isEqual(str.toLowerCase(), str2.toLowerCase());
        AppMethodBeat.o(196228);
        return isEqual;
    }

    public static boolean gII() {
        AppMethodBeat.i(196229);
        if (blR("y83a") || blR("y83") || blR("v1732a") || blR("v1732t")) {
            AppMethodBeat.o(196229);
            return true;
        }
        AppMethodBeat.o(196229);
        return false;
    }

    public static boolean d(Window window, boolean z) {
        int i2;
        AppMethodBeat.i(175978);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(175978);
            return false;
        } else if (gIJ()) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                i2 = systemUiVisibility | 8192;
            } else {
                i2 = systemUiVisibility & -8193;
            }
            decorView.setSystemUiVisibility(i2);
            AppMethodBeat.o(175978);
            return true;
        } else {
            AppMethodBeat.o(175978);
            return false;
        }
    }

    public static boolean gIJ() {
        AppMethodBeat.i(175979);
        if (Build.VERSION.SDK_INT < 23 || MIUI.isMIUIV8()) {
            AppMethodBeat.o(175979);
            return false;
        }
        AppMethodBeat.o(175979);
        return true;
    }

    public static Point az(Context context) {
        AppMethodBeat.i(175980);
        Point point = new Point();
        if (context == null) {
            AppMethodBeat.o(175980);
            return point;
        }
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
        AppMethodBeat.o(175980);
        return point;
    }

    public static int agC(int i2) {
        return ((((int) ((((float) ((i2 >> 24) & 255)) * 0.78f) + 56.100006f)) & 255) << 24) | ((((int) ((((float) ((i2 >> 16) & 255)) * 0.78f) + 0.0f)) & 255) << 16) | ((((int) ((((float) ((i2 >> 8) & 255)) * 0.78f) + 0.0f)) & 255) << 8) | ((((int) ((((float) (i2 & 255)) * 0.78f) + 0.0f)) & 255) << 0);
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(175973);
        int D = n.D(context, 25);
        AppMethodBeat.o(175973);
        return D;
    }

    public static int jJ(Context context) {
        AppMethodBeat.i(175974);
        int D = n.D(context, -1);
        if (D > 0) {
            int aM = aM(context, D);
            AppMethodBeat.o(175974);
            return aM;
        } else if (context instanceof Activity) {
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = ((Activity) context).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height - rect.height() < 0 || iArr[1] <= 200) {
                int i2 = rect.top;
                AppMethodBeat.o(175974);
                return i2;
            }
            int height2 = height - rect.height();
            AppMethodBeat.o(175974);
            return height2;
        } else {
            int fromDPToPix = a.fromDPToPix(context, 20);
            AppMethodBeat.o(175974);
            return fromDPToPix;
        }
    }
}
