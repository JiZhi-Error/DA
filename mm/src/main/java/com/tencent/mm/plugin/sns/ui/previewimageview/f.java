package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static float fE(View view) {
        AppMethodBeat.i(100301);
        float abs = (float) Math.abs((view.getRight() - view.getLeft()) / 2);
        AppMethodBeat.o(100301);
        return abs;
    }

    public static float fF(View view) {
        AppMethodBeat.i(100302);
        float abs = (float) Math.abs((view.getBottom() - view.getTop()) / 2);
        AppMethodBeat.o(100302);
        return abs;
    }

    public static int a(ViewGroup viewGroup, float f2, float f3) {
        AppMethodBeat.i(100303);
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            if (f(viewGroup.getChildAt(childCount), f2, f3)) {
                AppMethodBeat.o(100303);
                return childCount;
            }
        }
        AppMethodBeat.o(100303);
        return -1;
    }

    public static boolean f(View view, float f2, float f3) {
        AppMethodBeat.i(100304);
        if (view == null || f2 < ((float) view.getLeft()) || f2 > ((float) view.getRight()) || f3 < ((float) view.getTop()) || f3 > ((float) view.getBottom())) {
            AppMethodBeat.o(100304);
            return false;
        }
        AppMethodBeat.o(100304);
        return true;
    }
}
