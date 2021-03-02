package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.support.v4.graphics.b;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.sdk.vendor.Oppo;
import com.tencent.mm.sdk.vendor.Vivo;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ao {
    private static Boolean OLF;
    private static Boolean OLG;
    private static Boolean OLH = null;
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
    private static Boolean hgd = null;
    private static Boolean hge = null;
    private static Boolean hgf = null;

    static {
        AppMethodBeat.i(153536);
        AppMethodBeat.o(153536);
    }

    @TargetApi(21)
    public static ViewGroup a(Window window, View view) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        AppMethodBeat.i(153488);
        if (window == null) {
            AppMethodBeat.o(153488);
            return null;
        }
        ViewGroup a2 = a(window);
        if (a2 != null) {
            AppMethodBeat.o(153488);
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
                AppMethodBeat.o(153488);
                return viewGroup3;
            } else if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(Integer.MIN_VALUE);
            }
        }
        ViewGroup viewGroup4 = viewGroup;
        AppMethodBeat.o(153488);
        return viewGroup4;
    }

    private static ViewGroup a(Window window) {
        AppMethodBeat.i(153489);
        if (Build.VERSION.SDK_INT >= 21) {
            c cVar = new c(window, "mContentRoot", null);
            if (cVar.apg()) {
                try {
                    ViewGroup viewGroup = (ViewGroup) cVar.get();
                    AppMethodBeat.o(153489);
                    return viewGroup;
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e2) {
                    Log.printErrStackTrace("MicroMsg.UIUtils", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(153489);
        return null;
    }

    @TargetApi(20)
    public static boolean p(final View view, final View view2) {
        AppMethodBeat.i(153490);
        if (!d.oD(21)) {
            AppMethodBeat.o(153490);
            return true;
        } else if (view == null || !(view instanceof ViewGroup) || view2 == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            AppMethodBeat.o(153490);
            return false;
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                /* class com.tencent.mm.ui.ao.AnonymousClass1 */

                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    AppMethodBeat.i(153485);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    ao.P(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                    AppMethodBeat.o(153485);
                    return onApplyWindowInsets;
                }
            });
            AppMethodBeat.o(153490);
            return true;
        }
    }

    public static void P(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(153491);
        hfN.set(i2, i3, i4, i5);
        AppMethodBeat.o(153491);
    }

    public static Rect gJG() {
        return hfN;
    }

    public static int aD(Context context) {
        int i2 = 0;
        AppMethodBeat.i(153492);
        if (aA(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i2 = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            AppMethodBeat.o(153492);
        } else {
            AppMethodBeat.o(153492);
        }
        return i2;
    }

    @TargetApi(17)
    public static boolean aA(Context context) {
        AppMethodBeat.i(153493);
        if (aB(context) > 0) {
            AppMethodBeat.o(153493);
            return true;
        }
        AppMethodBeat.o(153493);
        return false;
    }

    private static int aB(Context context) {
        AppMethodBeat.i(153494);
        if (context == null) {
            AppMethodBeat.o(153494);
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            Log.e("MicroMsg.UIUtils", "getRealBottomHeight, get NULL windowManager");
            AppMethodBeat.o(153494);
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point az = az(context);
        int max = Math.max(point.y, point.x);
        int max2 = Math.max(az.y, az.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom - rect.top, rect.right - rect.left);
        }
        int i2 = max2 - max;
        AppMethodBeat.o(153494);
        return i2;
    }

    public static Point az(Context context) {
        AppMethodBeat.i(153495);
        Point point = new Point();
        if (context == null) {
            AppMethodBeat.o(153495);
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
        AppMethodBeat.o(153495);
        return point;
    }

    public static Point gx(Context context) {
        AppMethodBeat.i(153496);
        Point point = new Point();
        if (context == null) {
            AppMethodBeat.o(153496);
            return point;
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        AppMethodBeat.o(153496);
        return point;
    }

    public static boolean jU(Context context) {
        AppMethodBeat.i(153497);
        if (context == null) {
            AppMethodBeat.o(153497);
            return false;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getRealSize(point);
        defaultDisplay.getSize(point2);
        if (((double) ((((float) point.x) * 1.0f) / ((float) point2.x))) >= 1.7d || ((double) ((((float) point.y) * 1.0f) / ((float) point2.y))) >= 1.7d) {
            AppMethodBeat.o(153497);
            return true;
        }
        AppMethodBeat.o(153497);
        return false;
    }

    public static void jV(Context context) {
        AppMethodBeat.i(153498);
        e(((Activity) context).getWindow());
        AppMethodBeat.o(153498);
    }

    public static void e(Window window) {
        AppMethodBeat.i(153499);
        if (window == null) {
            AppMethodBeat.o(153499);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.o(153499);
    }

    public static void q(Activity activity, int i2) {
        AppMethodBeat.i(153500);
        try {
            if (activity.getWindow() == null) {
                AppMethodBeat.o(153500);
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().setStatusBarColor(i2);
            }
            AppMethodBeat.o(153500);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.UIUtils", th, "", new Object[0]);
            AppMethodBeat.o(153500);
        }
    }

    public static boolean d(Window window, boolean z) {
        int i2;
        AppMethodBeat.i(153502);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(153502);
            return false;
        } else if (Build.VERSION.SDK_INT < 23 || (MIUI.isMIUI() && MIUI.isMIUIV8())) {
            AppMethodBeat.o(153502);
            return false;
        } else {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                i2 = systemUiVisibility | 8192;
            } else {
                i2 = systemUiVisibility & -8193;
            }
            decorView.setSystemUiVisibility(i2);
            AppMethodBeat.o(153502);
            return true;
        }
    }

    public static void e(Window window, boolean z) {
        int i2;
        AppMethodBeat.i(153503);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(153503);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                i2 = systemUiVisibility | 16;
            } else {
                i2 = systemUiVisibility & -17;
            }
            decorView.setSystemUiVisibility(i2);
        }
        AppMethodBeat.o(153503);
    }

    public static int agC(int i2) {
        return ((((int) ((((float) ((i2 >> 24) & 255)) * 0.78f) + 56.100006f)) & 255) << 24) | ((((int) ((((float) ((i2 >> 16) & 255)) * 0.78f) + 0.0f)) & 255) << 16) | ((((int) ((((float) ((i2 >> 8) & 255)) * 0.78f) + 0.0f)) & 255) << 8) | ((((int) ((((float) (i2 & 255)) * 0.78f) + 0.0f)) & 255) << 0);
    }

    public static int jK(Context context) {
        AppMethodBeat.i(153506);
        int D = n.D(context, 25);
        AppMethodBeat.o(153506);
        return D;
    }

    public static boolean aQ(Context context) {
        AppMethodBeat.i(153508);
        boolean H = H(context, false);
        AppMethodBeat.o(153508);
        return H;
    }

    private static boolean H(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.i(153509);
        if (Vivo.vivohasCutOut(context) || Oppo.oppohasCutOut(context) || Huawei.huaweihasCutOut(context) || I(context, z)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.UIUtils", "hasCutOut:%s", Boolean.valueOf(z2));
        AppMethodBeat.o(153509);
        return z2;
    }

    public static Rect bl(Activity activity) {
        AppMethodBeat.i(153510);
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        Rect d2 = d(activity, displayMetrics.widthPixels, displayMetrics.heightPixels);
        AppMethodBeat.o(153510);
        return d2;
    }

    private static synchronized Rect d(Activity activity, int i2, int i3) {
        Rect rect;
        WindowInsets windowInsets;
        boolean z = true;
        synchronized (ao.class) {
            AppMethodBeat.i(153511);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (hfQ.get(rotation) != null) {
                rect = hfQ.get(rotation);
                AppMethodBeat.o(153511);
            } else if (activity.getWindow() == null) {
                AppMethodBeat.o(153511);
                rect = null;
            } else {
                if (H(activity, true)) {
                    if (Build.VERSION.SDK_INT < 28 || (windowInsets = hfP.get(rotation)) == null || windowInsets.getDisplayCutout() == null) {
                        z = false;
                        rect = null;
                    } else {
                        rect = new Rect(windowInsets.getDisplayCutout().getSafeInsetLeft(), windowInsets.getDisplayCutout().getSafeInsetTop(), i2 - windowInsets.getDisplayCutout().getSafeInsetRight(), i3 - windowInsets.getDisplayCutout().getSafeInsetBottom());
                    }
                    if (!z) {
                        int D = n.D(activity, 25);
                        switch (rotation) {
                            case 0:
                                rect = new Rect(0, D, i2, i3);
                                break;
                            case 1:
                                rect = new Rect(D, 0, i2, i3);
                                break;
                            case 2:
                                rect = new Rect(0, 0, i2, i3 - D);
                                break;
                            case 3:
                                rect = new Rect(0, 0, i2 - D, i3);
                                break;
                            default:
                                rect = new Rect(0, 0, i2, i3);
                                break;
                        }
                    }
                } else {
                    rect = new Rect(0, 0, i2, i3);
                }
                hfQ.put(rotation, rect);
                AppMethodBeat.o(153511);
            }
        }
        return rect;
    }

    @TargetApi(28)
    private static boolean I(Context context, boolean z) {
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        AppMethodBeat.i(153512);
        if (context == null) {
            AppMethodBeat.o(153512);
            return false;
        } else if (!(context instanceof Activity)) {
            AppMethodBeat.o(153512);
            return false;
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                hfO = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean(hfM, false);
                final View decorView = ((Activity) context).getWindow().getDecorView();
                final int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
                synchronized (hfR) {
                    try {
                        WindowInsets windowInsets = hfP.get(rotation);
                        if (windowInsets == null) {
                            if (MMHandlerThread.isMainThread() && decorView.isAttachedToWindow()) {
                                windowInsets = decorView.getRootWindowInsets();
                                hfP.put(rotation, decorView.getRootWindowInsets());
                            } else if (!z || MMHandlerThread.isMainThread() || !decorView.isAttachedToWindow()) {
                                final ap bn = ap.bn((Activity) context);
                                bn.a(new View.OnApplyWindowInsetsListener() {
                                    /* class com.tencent.mm.ui.ao.AnonymousClass3 */

                                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                        DisplayCutout displayCutout;
                                        List<Rect> boundingRects;
                                        AppMethodBeat.i(153487);
                                        synchronized (ao.hfR) {
                                            try {
                                                ao.hfP.put(rotation, decorView.getRootWindowInsets());
                                                if (!(decorView.getRootWindowInsets() == null || (displayCutout = decorView.getRootWindowInsets().getDisplayCutout()) == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.size() <= 0)) {
                                                    boolean unused = ao.hfO = true;
                                                    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(ao.hfM, ao.hfO);
                                                }
                                            } catch (Throwable th) {
                                                AppMethodBeat.o(153487);
                                                throw th;
                                            }
                                        }
                                        bn.b(this);
                                        AppMethodBeat.o(153487);
                                        return windowInsets;
                                    }
                                });
                                return hfO;
                            } else {
                                windowInsets = (WindowInsets) new SyncTask<WindowInsets>() {
                                    /* class com.tencent.mm.ui.ao.AnonymousClass2 */

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // com.tencent.mm.sdk.platformtools.SyncTask
                                    public final /* synthetic */ WindowInsets run() {
                                        AppMethodBeat.i(153486);
                                        WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                                        AppMethodBeat.o(153486);
                                        return rootWindowInsets;
                                    }
                                }.exec(new MMHandler(Looper.getMainLooper()));
                                hfP.put(rotation, windowInsets);
                            }
                        }
                        if (!(windowInsets == null || (displayCutout = windowInsets.getDisplayCutout()) == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.size() <= 0)) {
                            hfO = true;
                            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(hfM, hfO);
                        }
                    } finally {
                        AppMethodBeat.o(153512);
                    }
                }
            } else {
                hfO = context.getPackageManager().hasSystemFeature("android.hardware.notch_support");
            }
            boolean z2 = hfO;
            AppMethodBeat.o(153512);
            return z2;
        }
    }

    private static int[] h(Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(153513);
        int[] iArr = new int[(i2 * i3)];
        Bitmap.createScaledBitmap(bitmap, i2, i3, false).getPixels(iArr, 0, i2, 0, 0, i2, i3);
        AppMethodBeat.o(153513);
        return iArr;
    }

    private static List<float[]> b(float[][] fArr) {
        AppMethodBeat.i(153514);
        int[] iArr = new int[8];
        SparseArray sparseArray = new SparseArray();
        for (int i2 = 0; i2 < fArr.length; i2++) {
            int i3 = 1;
            while (true) {
                if (i3 > 7) {
                    break;
                } else if (fArr[i2][0] < 360.0f * (((float) i3) / 7.0f)) {
                    iArr[i3] = iArr[i3] + 1;
                    List list = (List) sparseArray.get(i3);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fArr[i2]);
                    sparseArray.put(i3, list);
                } else {
                    i3++;
                }
            }
        }
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 1; i6 <= 7; i6++) {
            if (iArr[i6] > i5) {
                i5 = iArr[i6];
                i4 = i6;
            }
        }
        List<float[]> list2 = (List) sparseArray.get(i4, new ArrayList());
        AppMethodBeat.o(153514);
        return list2;
    }

    private static float[] g(List<float[]> list, int i2, int i3) {
        float[] fArr;
        AppMethodBeat.i(153515);
        if (list.size() > Math.max(i2, i3)) {
            float f2 = Float.MAX_VALUE;
            float[] fArr2 = null;
            int i4 = 0;
            while (i4 < list.size()) {
                if (list.get(i4)[2] < f2) {
                    fArr = list.get(i4);
                    f2 = fArr[2];
                } else {
                    fArr = fArr2;
                }
                i4++;
                fArr2 = fArr;
            }
            if (((double) fArr2[2]) <= 0.15d) {
                AppMethodBeat.o(153515);
                return fArr2;
            }
            if (((double) fArr2[1]) > 0.5d) {
                fArr2[1] = fArr2[1] - 0.1f;
            }
            fArr2[2] = fArr2[2] - 0.1f;
            AppMethodBeat.o(153515);
            return fArr2;
        }
        float[] fArr3 = list.get(0);
        fArr3[2] = 0.15f;
        AppMethodBeat.o(153515);
        return fArr3;
    }

    private static float[][] g(int[] iArr, int i2, int i3) {
        AppMethodBeat.i(153516);
        float[][] fArr = new float[(i2 * i3)][];
        int i4 = i2 * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            float[] fArr2 = new float[3];
            Color.colorToHSV(iArr[i5], fArr2);
            fArr[i5] = fArr2;
        }
        AppMethodBeat.o(153516);
        return fArr;
    }

    public static int[] aK(Bitmap bitmap) {
        AppMethodBeat.i(153517);
        int[] i2 = i(bitmap, 4, 4);
        AppMethodBeat.o(153517);
        return i2;
    }

    public static int[] i(Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(153518);
        float[] g2 = g(b(g(h(bitmap, i2, i3), i2, i3)), i2, i3);
        float[] fArr = new float[3];
        if (((double) g2[2]) <= 0.15d) {
            fArr[0] = g2[0];
            fArr[1] = g2[1];
            fArr[2] = g2[2] + 0.7f;
        } else {
            fArr[0] = g2[0];
            fArr[1] = g2[1];
            if (((double) g2[2]) + 0.5d >= 1.0d) {
                fArr[2] = g2[2] - 0.5f;
            } else {
                fArr[2] = g2[2] + 0.5f;
            }
        }
        if (fArr[1] > 0.5f) {
            fArr[1] = fArr[1] - 0.1f;
        }
        int[] iArr = {Color.HSVToColor(g2), Color.HSVToColor(fArr)};
        AppMethodBeat.o(153518);
        return iArr;
    }

    public static boolean gJH() {
        AppMethodBeat.i(153519);
        if (ac.jOp) {
            AppMethodBeat.o(153519);
            return true;
        } else if (OLF != null) {
            boolean booleanValue = OLF.booleanValue();
            AppMethodBeat.o(153519);
            return booleanValue;
        } else if (Huawei.ifHUAWEI() && gJM()) {
            Boolean bool = Boolean.TRUE;
            OLF = bool;
            boolean booleanValue2 = bool.booleanValue();
            AppMethodBeat.o(153519);
            return booleanValue2;
        } else if (gJJ() >= 600) {
            Boolean bool2 = Boolean.TRUE;
            OLF = bool2;
            boolean booleanValue3 = bool2.booleanValue();
            AppMethodBeat.o(153519);
            return booleanValue3;
        } else {
            Boolean bool3 = Boolean.FALSE;
            OLF = bool3;
            boolean booleanValue4 = bool3.booleanValue();
            AppMethodBeat.o(153519);
            return booleanValue4;
        }
    }

    public static boolean hYD() {
        AppMethodBeat.i(259378);
        if ((MMApplicationContext.getContext().getResources().getConfiguration().screenLayout & 15) >= 3) {
            AppMethodBeat.o(259378);
            return true;
        }
        AppMethodBeat.o(259378);
        return false;
    }

    public static boolean gJI() {
        AppMethodBeat.i(153520);
        if (OLG != null) {
            boolean booleanValue = OLG.booleanValue();
            AppMethodBeat.o(153520);
            return booleanValue;
        } else if (gJJ() >= 550) {
            Boolean bool = Boolean.TRUE;
            OLG = bool;
            boolean booleanValue2 = bool.booleanValue();
            AppMethodBeat.o(153520);
            return booleanValue2;
        } else {
            Boolean bool2 = Boolean.FALSE;
            OLG = bool2;
            boolean booleanValue3 = bool2.booleanValue();
            AppMethodBeat.o(153520);
            return booleanValue3;
        }
    }

    public static int gJJ() {
        AppMethodBeat.i(205134);
        Log.i("MicroMsg.UIUtils", "getWidthDp, getDeviceDpi:%d, getWindowDpi:%d, getDeviceWidth:%d", Integer.valueOf(gJP()), Integer.valueOf(gJQ()), Integer.valueOf(getDeviceWidth()));
        if (gJP() == 0) {
            AppMethodBeat.o(205134);
            return 0;
        } else if (gJP() == gJQ() || Pi()) {
            DisplayMetrics gJO = gJO();
            int round = Math.round(((float) Math.min(gJO.heightPixels, gJO.widthPixels)) / gJO.density);
            AppMethodBeat.o(205134);
            return round;
        } else {
            int round2 = Math.round(((float) getDeviceWidth()) / (((float) gJP()) / 160.0f));
            AppMethodBeat.o(205134);
            return round2;
        }
    }

    public static boolean gJK() {
        AppMethodBeat.i(205135);
        if (gJN()) {
            boolean kB = aw.kB(MMApplicationContext.getContext());
            AppMethodBeat.o(205135);
            return kB;
        }
        AppMethodBeat.o(205135);
        return false;
    }

    public static boolean gJL() {
        AppMethodBeat.i(205136);
        if (Huawei.ifHUAWEI() && !gJM()) {
            String str = Build.DEVICE;
            if (str.equals("HWTAH") || str.equals("HWTAH-C") || str.equals("unknownRLI") || str.equals("unknownTXL") || str.equals("unknownRHA") || str.equals("HWTET")) {
                AppMethodBeat.o(205136);
                return true;
            } else if (MMApplicationContext.getContext().getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")) {
                AppMethodBeat.o(205136);
                return true;
            }
        }
        AppMethodBeat.o(205136);
        return false;
    }

    public static boolean Pi() {
        AppMethodBeat.i(153521);
        String str = Build.BRAND;
        if (!Util.isNullOrNil(str)) {
            String lowerCase = str.toLowerCase();
            if ((lowerCase.contains("huawei") || lowerCase.contains("honor")) && (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27)) {
                Log.i("MicroMsg.UIUtils", "dancy huaweiSpecial!!");
                AppMethodBeat.o(153521);
                return true;
            }
        }
        AppMethodBeat.o(153521);
        return false;
    }

    public static boolean gJM() {
        AppMethodBeat.i(205137);
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            if ("tablet".equals(cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "ro.build.characteristics", "")) || MMApplicationContext.getContext().getPackageManager().hasSystemFeature("com.huawei.software.features.pad")) {
                AppMethodBeat.o(205137);
                return true;
            }
            AppMethodBeat.o(205137);
            return false;
        } catch (Exception e2) {
            AppMethodBeat.o(205137);
            return false;
        }
    }

    public static boolean gJN() {
        AppMethodBeat.i(205138);
        if (aw.gWy() == null) {
            aw.kA(MMApplicationContext.getContext());
        }
        boolean gWx = aw.gWx();
        AppMethodBeat.o(205138);
        return gWx;
    }

    public static DisplayMetrics gJO() {
        AppMethodBeat.i(153522);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        AppMethodBeat.o(153522);
        return displayMetrics;
    }

    public static int gJP() {
        Integer num;
        AppMethodBeat.i(153523);
        try {
            Method declaredMethod = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getInitialDisplayDensity", Integer.TYPE);
            declaredMethod2.setAccessible(true);
            num = (Integer) declaredMethod2.invoke(invoke, 0);
        } catch (Exception e2) {
            Log.e("MicroMsg.UIUtils", "Exception:%s", e2);
            num = 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(153523);
        return intValue;
    }

    public static int gJQ() {
        AppMethodBeat.i(153524);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.densityDpi;
        AppMethodBeat.o(153524);
        return i2;
    }

    public static int getDeviceWidth() {
        int i2;
        Display.Mode[] supportedModes;
        boolean z = false;
        AppMethodBeat.i(153525);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        if (Build.VERSION.SDK_INT < 23 || (supportedModes = defaultDisplay.getSupportedModes()) == null || supportedModes.length <= 0) {
            i2 = 0;
        } else {
            i2 = Math.min(supportedModes[0].getPhysicalWidth(), supportedModes[0].getPhysicalHeight());
            Log.i("MicroMsg.UIUtils", "getDeviceWidth:%s", Integer.valueOf(i2));
            if (supportedModes.length > 1) {
                int min = Math.min(supportedModes[1].getPhysicalWidth(), supportedModes[1].getPhysicalHeight());
                if (min > 0 && i2 > 1440 && min < i2) {
                    i2 = min;
                }
                Log.i("MicroMsg.UIUtils", "getDeviceWidthTwo:%s", Integer.valueOf(min));
            }
        }
        if (i2 == 0) {
            e.INSTANCE.idkeyStat(1055, 2, 1, false);
        }
        if (Math.round(((float) i2) / (((float) gJP()) / 160.0f)) >= 550 || gJL()) {
            z = true;
        }
        String str = Build.BRAND;
        if (!Util.isNullOrNil(str) && str.toLowerCase().contains("huawei") && z && d(displayMetrics) != 0) {
            i2 = d(displayMetrics);
        }
        AppMethodBeat.o(153525);
        return i2;
    }

    public static int getDeviceHeight() {
        int i2;
        Display.Mode[] supportedModes;
        AppMethodBeat.i(205139);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        if (Build.VERSION.SDK_INT < 23 || (supportedModes = defaultDisplay.getSupportedModes()) == null || supportedModes.length <= 0) {
            i2 = 0;
        } else {
            i2 = Math.max(supportedModes[0].getPhysicalWidth(), supportedModes[0].getPhysicalHeight());
            Log.i("MicroMsg.UIUtils", "getDeviceHeight:%s", Integer.valueOf(i2));
            if (supportedModes.length > 1) {
                int max = Math.max(supportedModes[1].getPhysicalWidth(), supportedModes[1].getPhysicalHeight());
                if (max > 0 && i2 > 1440 && max >= i2) {
                    i2 = max;
                }
                Log.i("MicroMsg.UIUtils", "getDeviceHeightTwo:%s", Integer.valueOf(max));
            }
        }
        if (i2 == 0) {
            e.INSTANCE.idkeyStat(1055, 2, 1, false);
        }
        AppMethodBeat.o(205139);
        return i2;
    }

    private static int d(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(153526);
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField("noncompatWidthPixels");
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(displayMetrics)).intValue();
            Field declaredField2 = DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
            declaredField2.setAccessible(true);
            int intValue2 = ((Integer) declaredField2.get(displayMetrics)).intValue();
            Log.i("MicroMsg.UIUtils", "noncompatWidth, width:%s, height:%s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            int min = Math.min(intValue, intValue2);
            AppMethodBeat.o(153526);
            return min;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.UIUtils", e2, "", new Object[0]);
            AppMethodBeat.o(153526);
            return 0;
        }
    }

    public static void a(Paint paint, float f2) {
        AppMethodBeat.i(153527);
        if (paint == null) {
            AppMethodBeat.o(153527);
            return;
        }
        if (!gJR()) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(f2);
        } else if (f2 == 0.8f) {
            paint.setFakeBoldText(true);
            AppMethodBeat.o(153527);
            return;
        }
        AppMethodBeat.o(153527);
    }

    public static void b(Paint paint) {
        AppMethodBeat.i(205140);
        if (paint == null) {
            AppMethodBeat.o(205140);
        } else if (gJR()) {
            paint.setFakeBoldText(false);
            AppMethodBeat.o(205140);
        } else {
            paint.setStyle(Paint.Style.FILL);
            AppMethodBeat.o(205140);
        }
    }

    private static boolean gJR() {
        boolean z = false;
        AppMethodBeat.i(205141);
        String str = Build.BRAND;
        if (!Util.isNullOrNil(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains("oppo") || lowerCase.contains("vivo") || lowerCase.contains("xiaomi") || lowerCase.contains("huawei") || lowerCase.contains("honor") || lowerCase.contains("samsung") || lowerCase.contains("meizu")) {
                if (lowerCase.contains("oppo")) {
                    if (Build.VERSION.SDK_INT == 27 || Oppo.isUnDefaultFont()) {
                        z = true;
                    }
                } else if ((lowerCase.contains("vivo") || l.apy()) && Build.VERSION.SDK_INT <= 27) {
                    z = true;
                } else if (gJS()) {
                    z = true;
                }
            } else if (Build.VERSION.SDK_INT <= 27) {
                z = true;
            }
        }
        AppMethodBeat.o(205141);
        return z;
    }

    private static boolean gJS() {
        boolean z;
        AppMethodBeat.i(205142);
        String str = Build.BRAND;
        if (!hfT) {
            hfT = true;
            String str2 = "";
            if (!Util.isNullOrNil(str)) {
                str = str.toLowerCase();
                if (str.contains("xiaomi")) {
                    o oVar = new o("/data/system/theme/fonts/", "Roboto-Regular.ttf");
                    z = oVar.exists();
                    str2 = aa.z(oVar.her());
                } else if (str.contains("huawei") || str.contains("honor")) {
                    o oVar2 = new o("/data/skin/fonts/", "DroidSansChinese.ttf");
                    z = oVar2.exists();
                    str2 = aa.z(oVar2.her());
                } else if (str.contains("samsung")) {
                    o oVar3 = new o("/data/app_fonts/0/", "sans.loc");
                    z = al(oVar3);
                    str2 = aa.z(oVar3.her());
                    if (!z) {
                        o oVar4 = new o("/data/user/0/com.android.settings/app_fonts/", "sans.loc");
                        z = al(oVar4);
                        str2 = aa.z(oVar4.her());
                    }
                } else if (str.contains("meizu")) {
                    o oVar5 = new o("/data/data/com.meizu.customizecenter/font/", "flymeFont.ttf");
                    z = oVar5.exists();
                    str2 = aa.z(oVar5.her());
                }
                hfS = z;
                Log.i("MicroMsg.UIUtils", "isCustomFont:[ %s, %b, %s]", str, Boolean.valueOf(z), str2);
            }
            z = false;
            hfS = z;
            Log.i("MicroMsg.UIUtils", "isCustomFont:[ %s, %b, %s]", str, Boolean.valueOf(z), str2);
        }
        boolean z2 = hfS;
        AppMethodBeat.o(205142);
        return z2;
    }

    private static boolean al(o oVar) {
        AppMethodBeat.i(175959);
        if (oVar.exists()) {
            try {
                String boY = s.boY(aa.z(oVar.her()));
                if (Util.isNullOrNil(boY)) {
                    AppMethodBeat.o(175959);
                    return false;
                } else if (!boY.contains("default#default")) {
                    AppMethodBeat.o(175959);
                    return true;
                } else {
                    AppMethodBeat.o(175959);
                    return false;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(175959);
                return false;
            }
        } else {
            AppMethodBeat.o(175959);
            return false;
        }
    }

    public static boolean as(float f2, float f3) {
        AppMethodBeat.i(153529);
        if (((double) Math.abs(f2 - f3)) <= 1.0E-5d) {
            AppMethodBeat.o(153529);
            return true;
        }
        AppMethodBeat.o(153529);
        return false;
    }

    public static boolean isDarkMode() {
        AppMethodBeat.i(153530);
        if (!awS()) {
            if (hgb == null) {
                hgb = Boolean.valueOf(MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode", false));
            }
            if (!hgb.booleanValue() || (!awO() && !awN())) {
                AppMethodBeat.o(153530);
                return false;
            }
            AppMethodBeat.o(153530);
            return true;
        } else if (!f(MMApplicationContext.getContext().getResources()) || !awN()) {
            AppMethodBeat.o(153530);
            return false;
        } else {
            AppMethodBeat.o(153530);
            return true;
        }
    }

    public static boolean f(Resources resources) {
        AppMethodBeat.i(153531);
        if (!awO() && !awN()) {
            AppMethodBeat.o(153531);
            return false;
        } else if (!awS()) {
            boolean isDarkMode = isDarkMode();
            AppMethodBeat.o(153531);
            return isDarkMode;
        } else if (resources == null) {
            Log.i("MicroMsg.UIUtils", "dancy test is not darkmode, activity is null ");
            AppMethodBeat.o(153531);
            return false;
        } else {
            switch (resources.getConfiguration().uiMode & 48) {
                case 16:
                    AppMethodBeat.o(153531);
                    return false;
                case 32:
                    AppMethodBeat.o(153531);
                    return true;
                default:
                    AppMethodBeat.o(153531);
                    return false;
            }
        }
    }

    public static boolean i(Configuration configuration) {
        if (Build.VERSION.SDK_INT < 8) {
            return false;
        }
        switch (configuration.uiMode & 48) {
            case 16:
            default:
                return false;
            case 32:
                return true;
        }
    }

    public static boolean awN() {
        AppMethodBeat.i(205143);
        if (!awP() || gJT() || ((!awT() && !awQ()) || !awR())) {
            AppMethodBeat.o(205143);
            return false;
        }
        AppMethodBeat.o(205143);
        return true;
    }

    public static boolean awO() {
        AppMethodBeat.i(205144);
        if (!awP() || gJT() || ((!awT() && !awQ()) || Build.VERSION.SDK_INT < 26)) {
            AppMethodBeat.o(205144);
            return false;
        }
        AppMethodBeat.o(205144);
        return true;
    }

    public static boolean j(Resources resources) {
        AppMethodBeat.i(175960);
        switch (resources.getConfiguration().uiMode & 48) {
            case 16:
                Log.i("MicroMsg.UIUtils", "dancy test isSystemDarkMode not darkmode");
                AppMethodBeat.o(175960);
                return false;
            case 32:
                Log.i("MicroMsg.UIUtils", "dancy test isSystemDarkMode darkmode");
                AppMethodBeat.o(175960);
                return true;
            default:
                AppMethodBeat.o(175960);
                return false;
        }
    }

    public static int hT(int i2) {
        AppMethodBeat.i(153532);
        if (isDarkMode()) {
            float[] fArr = new float[3];
            float[] fArr2 = new float[3];
            b.d(i2, fArr);
            float f2 = fArr[2];
            if (((double) f2) < 0.45d) {
                float f3 = 1.0f - f2;
                if (((double) f3) > 0.8d) {
                    f3 = 0.8f;
                }
                fArr2[0] = fArr[0];
                fArr2[1] = fArr[1];
                fArr2[2] = f3;
                i2 = b.c(fArr2);
            }
        }
        AppMethodBeat.o(153532);
        return i2;
    }

    private static boolean awP() {
        AppMethodBeat.i(153533);
        if (hfU == null) {
            try {
                if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_dark_mode_on", "1", false, true), 1) > 0) {
                    Log.i("MicroMsg.UIUtils", "dancy test, isDarkModeOn!!");
                    hfU = Boolean.TRUE;
                } else {
                    Log.i("MicroMsg.UIUtils", "dancy test, isDarkModeOn close!!");
                    hfU = Boolean.FALSE;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.UIUtils", e2, "isDarkModeOn", new Object[0]);
                hfU = Boolean.FALSE;
            }
        }
        boolean booleanValue = hfU.booleanValue();
        AppMethodBeat.o(153533);
        return booleanValue;
    }

    private static boolean awQ() {
        AppMethodBeat.i(162341);
        if (hfV == null) {
            try {
                if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_dark_mode_unused_on", "1", false, false), 1) > 0) {
                    Log.i("MicroMsg.UIUtils", "dancy test, isDarkModeUnusedOn!!");
                    hfV = Boolean.TRUE;
                } else {
                    Log.i("MicroMsg.UIUtils", "dancy test, isDarkModeUnusedOn close!!");
                    hfV = Boolean.FALSE;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.UIUtils", e2, "isDarkModeUnusedOn", new Object[0]);
                hfV = Boolean.FALSE;
            }
        }
        boolean booleanValue = hfV.booleanValue();
        AppMethodBeat.o(162341);
        return booleanValue;
    }

    private static boolean gJT() {
        AppMethodBeat.i(153534);
        if (hfW == null) {
            hfW = Boolean.FALSE;
            String lowerCase = Build.MODEL.toLowerCase();
            String b2 = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_dark_mode_disable_device", "", false, true);
            if (!Util.isNullOrNil(b2) && b2.contains(lowerCase)) {
                Log.i("MicroMsg.UIUtils", "isDarkModeDisableDevice ture!!!");
                Boolean bool = Boolean.TRUE;
                hfW = bool;
                boolean booleanValue = bool.booleanValue();
                AppMethodBeat.o(153534);
                return booleanValue;
            }
        }
        boolean booleanValue2 = hfW.booleanValue();
        AppMethodBeat.o(153534);
        return booleanValue2;
    }

    private static boolean awR() {
        AppMethodBeat.i(168795);
        if (hfX == null) {
            String str = null;
            hfX = Boolean.FALSE;
            try {
                str = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_dark_mode_brand_api", hfY, false, false);
                Log.i("MicroMsg.UIUtils", "dancy test darkModeUsableBrandAPI: %s", str);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.UIUtils", e2, "darModeUsableBrandAPI", new Object[0]);
            }
            if (!Util.isNullOrNil(str)) {
                String lowerCase = Build.BRAND.toLowerCase();
                if (hfY.contains(lowerCase)) {
                    String[] split = str.split(",");
                    for (String str2 : split) {
                        if (str2.contains(lowerCase)) {
                            Log.i("MicroMsg.UIUtils", "dancy test usable brandAPI: %s", str2);
                            String[] split2 = str2.split("&");
                            if (split2.length >= 2 && !Util.isNullOrNil(split2[1])) {
                                try {
                                    int parseInt = Integer.parseInt(split2[1]);
                                    Log.d("MicroMsg.UIUtils", "dancy test api: %s", Integer.valueOf(parseInt));
                                    if (Build.VERSION.SDK_INT >= parseInt) {
                                        hfX = Boolean.TRUE;
                                    }
                                } catch (NumberFormatException e3) {
                                    Log.printErrStackTrace("MicroMsg.UIUtils", e3, "parse api error!", new Object[0]);
                                }
                            }
                        }
                    }
                } else if (str.contains(FacebookRequestErrorClassification.KEY_OTHER) && Build.VERSION.SDK_INT >= 29) {
                    hfX = Boolean.TRUE;
                }
            }
        }
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            hfX = Boolean.TRUE;
        }
        boolean booleanValue = hfX.booleanValue();
        AppMethodBeat.o(168795);
        return booleanValue;
    }

    public static boolean awS() {
        AppMethodBeat.i(153535);
        if (!hga) {
            hfZ = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_follow_system", false);
            hga = true;
        }
        boolean z = hfZ;
        AppMethodBeat.o(153535);
        return z;
    }

    public static void gJU() {
        AppMethodBeat.i(205145);
        hfZ = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_follow_system", false);
        AppMethodBeat.o(205145);
    }

    public static boolean awT() {
        AppMethodBeat.i(162342);
        if (hgc == null) {
            hgc = Boolean.valueOf(MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_used", false));
        }
        boolean booleanValue = hgc.booleanValue();
        AppMethodBeat.o(162342);
        return booleanValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        if (gJW() != false) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    @android.annotation.TargetApi(26)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void bm(android.app.Activity r7) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.ao.bm(android.app.Activity):void");
    }

    private static boolean gJV() {
        AppMethodBeat.i(205147);
        if (hgd == null) {
            try {
                if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_new_widecolor_mode_on", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 1) > 0) {
                    Log.i("MicroMsg.UIUtils", "isWideColorModeOn!!");
                    hgd = Boolean.TRUE;
                } else {
                    Log.i("MicroMsg.UIUtils", "isWideColorModeOn close!!");
                    hgd = Boolean.FALSE;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.UIUtils", e2, "isWideColorModeOn", new Object[0]);
                hgd = Boolean.FALSE;
            }
        }
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            hgd = Boolean.TRUE;
        }
        boolean booleanValue = hgd.booleanValue();
        AppMethodBeat.o(205147);
        return booleanValue;
    }

    private static boolean gJW() {
        AppMethodBeat.i(205148);
        if (hgf == null) {
            String str = null;
            hgf = Boolean.FALSE;
            try {
                str = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_new_widecolor_mode_brand_api", "", false, false);
                Log.i("MicroMsg.UIUtils", "wideColorModeDisableBrandAPI: %s", str);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.UIUtils", e2, "wideColorModeDisableBrandAPI", new Object[0]);
            }
            if (!Util.isNullOrNil(str)) {
                String lowerCase = Build.BRAND.toLowerCase();
                String[] split = str.split(",");
                for (String str2 : split) {
                    if (str2.contains(lowerCase)) {
                        Log.i("MicroMsg.UIUtils", "disable widecolor brandAPI: %s", str2);
                        String[] split2 = str2.split("&");
                        if (split2.length >= 2 && !Util.isNullOrNil(split2[1])) {
                            try {
                                int parseInt = Integer.parseInt(split2[1]);
                                Log.d("MicroMsg.UIUtils", "widecolor api: %s", Integer.valueOf(parseInt));
                                if (Build.VERSION.SDK_INT >= parseInt) {
                                    hgf = Boolean.TRUE;
                                }
                            } catch (NumberFormatException e3) {
                                Log.printErrStackTrace("MicroMsg.UIUtils", e3, "parse widecolor api error!", new Object[0]);
                            }
                        }
                    }
                }
            }
        }
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            hgf = Boolean.TRUE;
        }
        boolean booleanValue = hgf.booleanValue();
        AppMethodBeat.o(205148);
        return booleanValue;
    }

    public static boolean gJX() {
        AppMethodBeat.i(205149);
        if (OLH == null) {
            OLH = Boolean.valueOf("meizu".equalsIgnoreCase(Build.MANUFACTURER));
        }
        boolean booleanValue = OLH.booleanValue();
        AppMethodBeat.o(205149);
        return booleanValue;
    }

    public static boolean isMultiTaskMode() {
        boolean z = true;
        AppMethodBeat.i(205150);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(205150);
            return true;
        }
        com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class);
        b.a aVar = b.a.clicfg_multitask_mode_enable;
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("total", "openMultiTaskMode")), 1) != 1) {
            z = false;
        }
        boolean a2 = bVar.a(aVar, z);
        AppMethodBeat.o(205150);
        return a2;
    }

    public static boolean gJY() {
        Throwable th;
        boolean z;
        AppMethodBeat.i(205151);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(205151);
            return true;
        }
        long a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitask_support_miniqb, 242063L);
        try {
            String miniQBVersion = com.tencent.xweb.x5.sdk.d.getMiniQBVersion(MMApplicationContext.getContext());
            if (!Util.isNullOrNil(miniQBVersion)) {
                String replaceAll = miniQBVersion.replaceAll("['.']", "");
                if (!Util.isNullOrNil(replaceAll) && Long.valueOf(replaceAll).longValue() >= a2) {
                    z = true;
                    Log.i("MicroMsg.UIUtils", "supportMultiTaskForMiniQB: %b, curVersion: %s", Boolean.valueOf(z), miniQBVersion);
                    AppMethodBeat.o(205151);
                    return z;
                }
            }
            z = false;
            try {
                Log.i("MicroMsg.UIUtils", "supportMultiTaskForMiniQB: %b, curVersion: %s", Boolean.valueOf(z), miniQBVersion);
            } catch (Throwable th2) {
                th = th2;
                Log.e("MicroMsg.UIUtils", "isSupportMultiTaskForMiniQB Exception:%s %s", th.getClass().getSimpleName(), th.getMessage());
                AppMethodBeat.o(205151);
                return z;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            Log.e("MicroMsg.UIUtils", "isSupportMultiTaskForMiniQB Exception:%s %s", th.getClass().getSimpleName(), th.getMessage());
            AppMethodBeat.o(205151);
            return z;
        }
        AppMethodBeat.o(205151);
        return z;
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(153504);
        int D = n.D(context, 25);
        AppMethodBeat.o(153504);
        return D;
    }

    public static int jJ(Context context) {
        AppMethodBeat.i(153505);
        int D = n.D(context, -1);
        if (D > 0) {
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (rect.top > D) {
                Log.w("MicroMsg.UIUtils", "[fixStatusBarHeight] top:%s statusHeight:%s", Integer.valueOf(rect.top), Integer.valueOf(D));
                AppMethodBeat.o(153505);
                return 0;
            }
            AppMethodBeat.o(153505);
            return D;
        } else if (context instanceof Activity) {
            Rect rect2 = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            int height = ((Activity) context).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height - rect2.height() < 0 || iArr[1] <= 200) {
                int i2 = rect2.top;
                AppMethodBeat.o(153505);
                return i2;
            }
            int height2 = height - rect2.height();
            AppMethodBeat.o(153505);
            return height2;
        } else {
            int fromDPToPix = a.fromDPToPix(context, 20);
            AppMethodBeat.o(153505);
            return fromDPToPix;
        }
    }

    public static int aP(Context context) {
        AppMethodBeat.i(153507);
        int D = n.D(context, 25);
        AppMethodBeat.o(153507);
        return D;
    }
}
