package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.r;

public final class y extends r {
    public static boolean cI(View view) {
        AppMethodBeat.i(135329);
        if (Build.VERSION.SDK_INT < 24) {
            AppMethodBeat.o(135329);
            return false;
        } else if (view == null) {
            AppMethodBeat.o(135329);
            return false;
        } else {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(view.getContext());
            if (castActivityOrNull == null || !castActivityOrNull.isInMultiWindowMode()) {
                AppMethodBeat.o(135329);
                return false;
            }
            AppMethodBeat.o(135329);
            return true;
        }
    }

    static int a(Window window, boolean z) {
        int i2;
        AppMethodBeat.i(135330);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z) {
            int i3 = systemUiVisibility | 1024 | 256;
            if (Build.VERSION.SDK_INT >= 20) {
                i3 = i3 | 512 | 2;
            }
            i2 = i3 | 4;
            if (Build.VERSION.SDK_INT >= 19) {
                i2 |= 4096;
            }
        } else {
            int i4 = systemUiVisibility & -1025 & -257;
            if (Build.VERSION.SDK_INT >= 20) {
                i4 = i4 & -513 & -3;
            }
            i2 = i4 & -5;
            if (Build.VERSION.SDK_INT >= 19) {
                i2 &= -4097;
            }
        }
        Log.i("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", Integer.valueOf(i2));
        AppMethodBeat.o(135330);
        return i2;
    }

    public static void x(Context context, boolean z) {
        AppMethodBeat.i(176774);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(context);
        if (castActivityOrNull == null || castActivityOrNull.getWindow() == null) {
            Log.w("MicroMsg.AppBrandUIUtil", "configFullScreen with context(%s), get NULL activity", context);
            AppMethodBeat.o(176774);
            return;
        }
        a(castActivityOrNull.getWindow(), z, false);
        AppMethodBeat.o(176774);
    }

    public static void a(final Window window, boolean z, boolean z2) {
        AppMethodBeat.i(176775);
        if (z) {
            window.getDecorView().setSystemUiVisibility(a(window, true));
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.y.AnonymousClass1 */

                public final void onSystemUiVisibilityChange(int i2) {
                    AppMethodBeat.i(176773);
                    Log.d("MicroMsg.AppBrandUIUtil", "visibility = ".concat(String.valueOf(i2)));
                    if ((i2 & 4) == 0) {
                        window.getDecorView().setSystemUiVisibility(y.a(window, true));
                    }
                    AppMethodBeat.o(176773);
                }
            });
            window.addFlags(1024);
            if (z2 && Build.VERSION.SDK_INT >= 28) {
                window.getAttributes().layoutInDisplayCutoutMode = 1;
                window.setAttributes(window.getAttributes());
            }
            AppMethodBeat.o(176775);
            return;
        }
        window.getDecorView().setSystemUiVisibility(a(window, false));
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        try {
            window.clearFlags(1024);
            AppMethodBeat.o(176775);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandUIUtil", e2, "[CAUGHT CRASH]", new Object[0]);
            AppMethodBeat.o(176775);
        }
    }

    public static boolean eq(Context context) {
        AppMethodBeat.i(178640);
        if (!(context instanceof Activity)) {
            AppMethodBeat.o(178640);
            return false;
        }
        try {
            if ((((Activity) context).getWindow().getAttributes().flags & 1024) == 1024) {
                AppMethodBeat.o(178640);
                return true;
            }
            AppMethodBeat.o(178640);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(178640);
            return false;
        }
    }
}
