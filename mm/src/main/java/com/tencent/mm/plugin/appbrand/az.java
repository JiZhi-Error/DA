package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.c;

/* access modifiers changed from: package-private */
public enum az {
    AppBrandPageContainer,
    PipContainer,
    LegacyDialogContainer,
    GlobalNativeWidgetContainerView,
    RemoteDebugFloatView,
    AuthorizeDialogContainer,
    LoadingSplash;
    
    private static final int kFR = R.id.r6;

    public static az valueOf(String str) {
        AppMethodBeat.i(219291);
        az azVar = (az) Enum.valueOf(az.class, str);
        AppMethodBeat.o(219291);
        return azVar;
    }

    static {
        AppMethodBeat.i(219294);
        AppMethodBeat.o(219294);
    }

    private int G(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219292);
        c cVar = appBrandRuntime.kAt;
        if (ordinal() >= cVar.getChildCount()) {
            for (int childCount = cVar.getChildCount() - 1; childCount >= 0; childCount--) {
                if (ordinal() < ((Integer) cVar.getChildAt(childCount).getTag(kFR)).intValue()) {
                    AppMethodBeat.o(219292);
                    return childCount;
                }
            }
        }
        int min = Math.min(ordinal(), cVar.getChildCount());
        AppMethodBeat.o(219292);
        return min;
    }

    /* access modifiers changed from: package-private */
    public final void a(AppBrandRuntime appBrandRuntime, View view) {
        AppMethodBeat.i(219293);
        Integer num = (Integer) view.getTag(kFR);
        if (num == null || ordinal() == num.intValue()) {
            view.setTag(kFR, Integer.valueOf(ordinal()));
            c cVar = appBrandRuntime.kAt;
            int G = G(appBrandRuntime);
            if (view.getParent() != cVar || G < cVar.getChildCount() - 1) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                cVar.addView(view, G);
                AppMethodBeat.o(219293);
                return;
            }
            cVar.bringChildToFront(view);
            AppMethodBeat.o(219293);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Child has already been added with index ".concat(String.valueOf(num)));
        AppMethodBeat.o(219293);
        throw illegalStateException;
    }
}
