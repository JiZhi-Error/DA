package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai {
    public static View m(d dVar) {
        AppMethodBeat.i(135382);
        ac i2 = df.i(dVar);
        if (i2 == null) {
            AppMethodBeat.o(135382);
            return null;
        }
        FrameLayout frameLayout = i2.noq;
        AppMethodBeat.o(135382);
        return frameLayout;
    }

    public static int[] n(d dVar) {
        AppMethodBeat.i(135383);
        int[] o = o(dVar);
        Log.v("Luggage.WXA.UIUtil", "getWindowWidthHeight: [x,y] = [%d,%d]", Integer.valueOf(o[0]), Integer.valueOf(o[1]));
        AppMethodBeat.o(135383);
        return o;
    }

    private static int[] o(d dVar) {
        AppMethodBeat.i(219593);
        View m = m(dVar);
        if (m != null && m.isLaidOut()) {
            Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: normal");
            int[] iArr = {m.getWidth(), m.getHeight()};
            AppMethodBeat.o(219593);
            return iArr;
        } else if (dVar.getContext() instanceof Activity) {
            Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: DecorView");
            View decorView = ((Activity) dVar.getContext()).getWindow().getDecorView();
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            if (rect.width() <= 0) {
                Log.e("Luggage.WXA.UIUtil", "getWindowWidthHeight try Method(DecorView) but rect.width()<=0, use Method(Screen) instead");
                int[] f2 = f(dVar);
                AppMethodBeat.o(219593);
                return f2;
            }
            int[] iArr2 = {rect.right - rect.left, (rect.bottom - rect.top) - dVar.getContext().getResources().getDimensionPixelSize(R.dimen.b7)};
            AppMethodBeat.o(219593);
            return iArr2;
        } else {
            Log.i("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: Screen");
            int[] f3 = f(dVar);
            AppMethodBeat.o(219593);
            return f3;
        }
    }

    public static int[] f(k kVar) {
        AppMethodBeat.i(135384);
        int[] g2 = g(kVar);
        Log.v("Luggage.WXA.UIUtil", "getScreenSize: [x,y] = [%d,%d]", Integer.valueOf(g2[0]), Integer.valueOf(g2[1]));
        AppMethodBeat.o(135384);
        return g2;
    }

    private static int[] g(k kVar) {
        DisplayMetrics displayMetrics;
        AppMethodBeat.i(219594);
        c windowAndroid = kVar.getRuntime() != null ? kVar.getRuntime().getWindowAndroid() : null;
        if (windowAndroid != null) {
            Log.v("Luggage.WXA.UIUtil", "getScreenSizeInner: V_DM");
            displayMetrics = windowAndroid.getVDisplayMetrics();
        } else {
            Log.v("Luggage.WXA.UIUtil", "getScreenSizeInner: normal DM");
            displayMetrics = kVar.getContext().getResources().getDisplayMetrics();
        }
        int[] iArr = {displayMetrics.widthPixels, displayMetrics.heightPixels};
        AppMethodBeat.o(219594);
        return iArr;
    }

    public static boolean et(Context context) {
        AppMethodBeat.i(219595);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double sqrt = Math.sqrt(Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d) + Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d));
        if ((context.getResources().getConfiguration().screenLayout & 15) < 3 || sqrt < 7.0d) {
            AppMethodBeat.o(219595);
            return false;
        }
        AppMethodBeat.o(219595);
        return true;
    }
}
