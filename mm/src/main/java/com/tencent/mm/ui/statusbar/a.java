package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class a {
    private static b ho(View view) {
        AppMethodBeat.i(133796);
        if (view == null) {
            AppMethodBeat.o(133796);
            return null;
        }
        View view2 = view;
        while (!(view2 instanceof b)) {
            ViewParent parent = view2.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                AppMethodBeat.o(133796);
                return null;
            }
            view2 = (View) parent;
        }
        b bVar = (b) view2;
        AppMethodBeat.o(133796);
        return bVar;
    }

    public static void e(View view, int i2, boolean z) {
        AppMethodBeat.i(133797);
        if (view == null) {
            AppMethodBeat.o(133797);
        } else if (!c.Qow) {
            AppMethodBeat.o(133797);
        } else {
            b ho = ho(view);
            if (ho != null) {
                ho.S(i2, z);
                AppMethodBeat.o(133797);
                return;
            }
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(view.getContext());
            if (castActivityOrNull != null) {
                castActivityOrNull.getWindow().setStatusBarColor(i2);
                d.d(castActivityOrNull.getWindow(), z);
            }
            AppMethodBeat.o(133797);
        }
    }

    public static void T(View view, boolean z) {
        AppMethodBeat.i(133798);
        b ho = ho(view);
        if (ho != null) {
            ho.CF(z);
        }
        AppMethodBeat.o(133798);
    }

    public static int bF(Activity activity) {
        AppMethodBeat.i(259295);
        if (!c.Qow) {
            AppMethodBeat.o(259295);
            return 0;
        } else if (activity == null) {
            AppMethodBeat.o(259295);
            return 0;
        } else {
            int i2 = c.bt(activity).Qoz;
            AppMethodBeat.o(259295);
            return i2;
        }
    }
}
