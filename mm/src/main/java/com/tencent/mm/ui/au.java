package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class au {
    public static int eu(Context context) {
        int i2;
        AppMethodBeat.i(159133);
        if (context == null) {
            as.w("WeUIToolHelper", "[getActionBarHeight] context is null!", new Object[0]);
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.b8);
        if (context instanceof AppCompatActivity) {
            if (((AppCompatActivity) context).getSupportActionBar() != null) {
                i2 = ((AppCompatActivity) context).getSupportActionBar().getHeight();
            }
            i2 = 0;
        } else {
            if ((context instanceof Activity) && ((Activity) context).getActionBar() != null) {
                i2 = ((Activity) context).getActionBar().getHeight();
            }
            i2 = 0;
        }
        if (i2 <= 0) {
            i2 = dimensionPixelSize;
        }
        as.i("WeUIToolHelper", "[getActionBarHeight] real:%s defaultVal:%s", Integer.valueOf(i2), Integer.valueOf(dimensionPixelSize));
        AppMethodBeat.o(159133);
        return i2;
    }

    public static int ay(Context context) {
        AppMethodBeat.i(159134);
        int y = y(context, at.fromDPToPix(context, 25));
        AppMethodBeat.o(159134);
        return y;
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(159135);
        int D = D(context, at.fromDPToPix(context, 25));
        AppMethodBeat.o(159135);
        return D;
    }

    public static int D(Context context, int i2) {
        AppMethodBeat.i(159136);
        int y = y(context, i2);
        if (y > 0) {
            int aM = aM(context, y);
            AppMethodBeat.o(159136);
            return aM;
        }
        if (y <= 0) {
            as.i("WeUIToolHelper", "[getStatusBarHeight] return default!!!", new Object[0]);
        } else {
            i2 = y;
        }
        AppMethodBeat.o(159136);
        return i2;
    }

    private static int y(Context context, int i2) {
        AppMethodBeat.i(159137);
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            i2 = context.getResources().getDimensionPixelSize(av.cL(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            as.printErrStackTrace("WeUIToolHelper", e2, "getStatusBarHeightFromSysR", new Object[0]);
        }
        as.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", Integer.valueOf(i2));
        AppMethodBeat.o(159137);
        return i2;
    }

    private static int aM(Context context, int i2) {
        AppMethodBeat.i(159138);
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = ((Activity) context).getResources().getDisplayMetrics();
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (displayMetrics != null && rect.height() > 0) {
                int height = displayMetrics.heightPixels - rect.height();
                as.i("WeUIToolHelper", "[fixStatusBarHeight] new statusBar:%s ", Integer.valueOf(height));
                if (height > i2 && height - i2 < 100) {
                    as.i("WeUIToolHelper", "[fixStatusBarHeight] return new statusBar:%s ", Integer.valueOf(height));
                    AppMethodBeat.o(159138);
                    return height;
                }
            }
        }
        AppMethodBeat.o(159138);
        return i2;
    }

    public static Point az(Context context) {
        AppMethodBeat.i(159139);
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (NoSuchMethodException e2) {
                as.printErrStackTrace("WeUIToolHelper", e2, "getDisplayRealSize NoSuchMethodException", new Object[0]);
            } catch (IllegalAccessException e3) {
                as.printErrStackTrace("WeUIToolHelper", e3, "getDisplayRealSize IllegalAccessException", new Object[0]);
            } catch (InvocationTargetException e4) {
                as.printErrStackTrace("WeUIToolHelper", e4, "getDisplayRealSize InvocationTargetException", new Object[0]);
            }
        } else {
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.o(159139);
        return point;
    }

    @TargetApi(17)
    public static boolean aA(Context context) {
        AppMethodBeat.i(159140);
        if (aB(context) > 0) {
            AppMethodBeat.o(159140);
            return true;
        }
        AppMethodBeat.o(159140);
        return false;
    }

    public static int aB(Context context) {
        AppMethodBeat.i(159141);
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
        AppMethodBeat.o(159141);
        return i2;
    }

    private static boolean aC(Context context) {
        AppMethodBeat.i(159142);
        if (context.getResources().getConfiguration().orientation == 1) {
            AppMethodBeat.o(159142);
            return true;
        }
        AppMethodBeat.o(159142);
        return false;
    }

    public static boolean jX(Context context) {
        AppMethodBeat.i(159143);
        if (!(context instanceof Activity)) {
            AppMethodBeat.o(159143);
            return true;
        } else if ((((Activity) context).getWindow().getAttributes().flags & 1024) != 1024) {
            AppMethodBeat.o(159143);
            return true;
        } else {
            AppMethodBeat.o(159143);
            return false;
        }
    }

    public static int aD(Context context) {
        int i2 = 0;
        AppMethodBeat.i(159144);
        if (aA(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i2 = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            int aB = aB(context);
            if (aB != 0 && aB < i2) {
                i2 = aB;
            }
            AppMethodBeat.o(159144);
        } else {
            AppMethodBeat.o(159144);
        }
        return i2;
    }
}
