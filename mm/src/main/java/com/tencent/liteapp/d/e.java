package com.tencent.liteapp.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e {
    public static int ay(Context context) {
        AppMethodBeat.i(197806);
        int y = y(context, d.ax(context));
        AppMethodBeat.o(197806);
        return y;
    }

    private static int y(Context context, int i2) {
        AppMethodBeat.i(197807);
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            i2 = context.getResources().getDimensionPixelSize(f.cL(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
        }
        b.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", Integer.valueOf(i2));
        AppMethodBeat.o(197807);
        return i2;
    }

    private static Point az(Context context) {
        AppMethodBeat.i(197808);
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            }
        } else {
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.o(197808);
        return point;
    }

    @TargetApi(17)
    private static boolean aA(Context context) {
        AppMethodBeat.i(197809);
        if (aB(context) > 0) {
            AppMethodBeat.o(197809);
            return true;
        }
        AppMethodBeat.o(197809);
        return false;
    }

    private static int aB(Context context) {
        AppMethodBeat.i(197810);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point az = az(context);
        int max = Math.max(point.y, point.x);
        if (aC(context)) {
            max = point.y;
        }
        int max2 = Math.max(az.y, az.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom, rect.right);
            if (aC(context)) {
                max = rect.bottom;
            }
        }
        int i2 = max2 - max;
        AppMethodBeat.o(197810);
        return i2;
    }

    private static boolean aC(Context context) {
        AppMethodBeat.i(197811);
        if (context.getResources().getConfiguration().orientation == 1) {
            AppMethodBeat.o(197811);
            return true;
        }
        AppMethodBeat.o(197811);
        return false;
    }

    public static int aD(Context context) {
        int i2 = 0;
        AppMethodBeat.i(197812);
        if (aA(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i2 = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            int aB = aB(context);
            if (aB != 0 && aB < i2) {
                i2 = aB;
            }
            AppMethodBeat.o(197812);
        } else {
            AppMethodBeat.o(197812);
        }
        return i2;
    }
}
