package com.tencent.mm.ext.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.liteapp.a;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.a.a.a;
import com.tencent.mm.ext.b.c;
import java.lang.reflect.Method;

public final class e {
    public static String hfM = "has_cutout";
    private static Rect hfN = new Rect(0, 0, 0, 0);
    private static boolean hfO = false;
    private static SparseArray<WindowInsets> hfP = new SparseArray<>(4);
    private static SparseArray<Rect> hfQ = new SparseArray<>(4);
    private static final Object hfR = new Object();
    private static boolean hfS = false;
    private static boolean hfT = false;
    private static Boolean hfU = null;
    private static Boolean hfV = null;
    private static Boolean hfW = null;
    private static Boolean hfX = null;
    private static String hfY = "xiaomi&28, redmi&28, samsung&28, vivo&28, oppo&29, huawei&29, honor&29, oneplus&29, meizu&24, smartisan&24, other&29";
    private static boolean hfZ = false;
    private static boolean hga = false;
    private static Boolean hgb = null;
    private static Boolean hgc = null;
    @TargetApi(26)
    private static Boolean hgd = null;
    private static Boolean hge = null;
    private static Boolean hgf = null;

    static {
        AppMethodBeat.i(197878);
        AppMethodBeat.o(197878);
    }

    @TargetApi(21)
    public static ViewGroup a(Window window, View view) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        AppMethodBeat.i(197864);
        if (window == null) {
            AppMethodBeat.o(197864);
            return null;
        }
        ViewGroup a2 = a(window);
        if (a2 != null) {
            AppMethodBeat.o(197864);
            return a2;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            while (parent != window.getDecorView() && parent != null) {
                viewGroup2 = parent;
                parent = parent.getParent();
            }
            viewGroup = viewGroup2;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            View childAt = ((ViewGroup) window.getDecorView()).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup3 = (ViewGroup) childAt;
                AppMethodBeat.o(197864);
                return viewGroup3;
            } else if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(Integer.MIN_VALUE);
            }
        }
        ViewGroup viewGroup4 = viewGroup;
        AppMethodBeat.o(197864);
        return viewGroup4;
    }

    private static ViewGroup a(Window window) {
        AppMethodBeat.i(197865);
        if (Build.VERSION.SDK_INT >= 21) {
            a aVar = new a(window, "mContentRoot");
            if (aVar.apg()) {
                try {
                    ViewGroup viewGroup = (ViewGroup) aVar.get();
                    AppMethodBeat.o(197865);
                    return viewGroup;
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e2) {
                    b.e("MicroMsg.UIUtils", e2.toString(), new Object[0]);
                }
            }
        }
        AppMethodBeat.o(197865);
        return null;
    }

    public static Point az(Context context) {
        AppMethodBeat.i(197866);
        Point point = new Point();
        if (context == null) {
            AppMethodBeat.o(197866);
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
        AppMethodBeat.o(197866);
        return point;
    }

    public static boolean aQ(Context context) {
        AppMethodBeat.i(197868);
        boolean cI = cI(context);
        AppMethodBeat.o(197868);
        return cI;
    }

    public static boolean cI(Context context) {
        boolean z;
        AppMethodBeat.i(197869);
        if (c.vivohasCutOut(context) || com.tencent.mm.ext.b.b.oppohasCutOut(context) || com.tencent.mm.ext.b.a.huaweihasCutOut(context)) {
            z = true;
        } else {
            z = false;
        }
        b.i("MicroMsg.UIUtils", "hasCutOut:%s", Boolean.valueOf(z));
        AppMethodBeat.o(197869);
        return z;
    }

    private static boolean isDarkMode() {
        AppMethodBeat.i(197870);
        if (awS()) {
            a.C0147a aVar = com.tencent.liteapp.a.cqJ;
            if (!f(a.C0147a.getAppContext().getResources()) || !awN()) {
                AppMethodBeat.o(197870);
                return false;
            }
            AppMethodBeat.o(197870);
            return true;
        }
        if (hgb == null) {
            hgb = Boolean.FALSE;
        }
        if (!hgb.booleanValue() || (!awO() && !awN())) {
            AppMethodBeat.o(197870);
            return false;
        }
        AppMethodBeat.o(197870);
        return true;
    }

    public static boolean f(Resources resources) {
        AppMethodBeat.i(197871);
        if (!awO() && !awN()) {
            AppMethodBeat.o(197871);
            return false;
        } else if (!awS()) {
            boolean isDarkMode = isDarkMode();
            AppMethodBeat.o(197871);
            return isDarkMode;
        } else if (resources == null) {
            b.i("MicroMsg.UIUtils", "dancy test is not darkmode, activity is null ", new Object[0]);
            AppMethodBeat.o(197871);
            return false;
        } else {
            switch (resources.getConfiguration().uiMode & 48) {
                case 16:
                    AppMethodBeat.o(197871);
                    return false;
                case 32:
                    AppMethodBeat.o(197871);
                    return true;
                default:
                    AppMethodBeat.o(197871);
                    return false;
            }
        }
    }

    private static boolean awN() {
        AppMethodBeat.i(197872);
        if (!awP() || ((!awT() && !awQ()) || !awR())) {
            AppMethodBeat.o(197872);
            return false;
        }
        AppMethodBeat.o(197872);
        return true;
    }

    private static boolean awO() {
        AppMethodBeat.i(197873);
        if (!awP() || ((!awT() && !awQ()) || Build.VERSION.SDK_INT < 26)) {
            AppMethodBeat.o(197873);
            return false;
        }
        AppMethodBeat.o(197873);
        return true;
    }

    private static boolean awP() {
        AppMethodBeat.i(197874);
        if (hfU == null) {
            hfU = Boolean.TRUE;
        }
        boolean booleanValue = hfU.booleanValue();
        AppMethodBeat.o(197874);
        return booleanValue;
    }

    private static boolean awQ() {
        AppMethodBeat.i(197875);
        if (hfV == null) {
            try {
                hfV = Boolean.FALSE;
            } catch (Exception e2) {
                b.e("MicroMsg.UIUtils", "isDarkModeUnusedOn %s", e2.toString());
                hfV = Boolean.FALSE;
            }
        }
        boolean booleanValue = hfV.booleanValue();
        AppMethodBeat.o(197875);
        return booleanValue;
    }

    private static boolean awR() {
        AppMethodBeat.i(197876);
        if (hfX == null) {
            hfX = Boolean.FALSE;
            try {
                b.i("MicroMsg.UIUtils", "dancy test darkModeUsableBrandAPI: %s", "");
            } catch (Exception e2) {
                b.e("MicroMsg.UIUtils", "darModeUsableBrandAPI %s", e2.toString());
            }
            if (!TextUtils.isEmpty("")) {
                String lowerCase = Build.BRAND.toLowerCase();
                if (hfY.contains(lowerCase)) {
                    String[] split = "".split(",");
                    for (String str : split) {
                        if (str.contains(lowerCase)) {
                            b.i("MicroMsg.UIUtils", "dancy test usable brandAPI: %s", str);
                            String[] split2 = str.split("&");
                            if (split2.length >= 2 && !TextUtils.isEmpty(split2[1])) {
                                try {
                                    int parseInt = Integer.parseInt(split2[1]);
                                    b.d("MicroMsg.UIUtils", "dancy test api: %s", Integer.valueOf(parseInt));
                                    if (Build.VERSION.SDK_INT >= parseInt) {
                                        hfX = Boolean.TRUE;
                                    }
                                } catch (NumberFormatException e3) {
                                    b.e("MicroMsg.UIUtils", "parse api error! %s", e3.toString());
                                }
                            }
                        }
                    }
                } else if ("".contains(FacebookRequestErrorClassification.KEY_OTHER) && Build.VERSION.SDK_INT >= 29) {
                    hfX = Boolean.TRUE;
                }
            }
        }
        boolean booleanValue = hfX.booleanValue();
        AppMethodBeat.o(197876);
        return booleanValue;
    }

    private static boolean awS() {
        if (!hga) {
            hfZ = false;
            hga = true;
        }
        return hfZ;
    }

    private static boolean awT() {
        AppMethodBeat.i(197877);
        if (hgc == null) {
            hgc = Boolean.FALSE;
        }
        boolean booleanValue = hgc.booleanValue();
        AppMethodBeat.o(197877);
        return booleanValue;
    }

    public static int aP(Context context) {
        AppMethodBeat.i(197867);
        int cH = com.tencent.mm.ext.a.b.b.cH(context);
        AppMethodBeat.o(197867);
        return cH;
    }
}
