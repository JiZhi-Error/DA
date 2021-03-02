package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public final class e {
    public static int[] a(Context context, View view, View view2, boolean z) {
        AppMethodBeat.i(126646);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int i2 = ao.az(context).x;
        view2.measure(0, 0);
        int measuredHeight = view2.getMeasuredHeight();
        int measuredWidth = view2.getMeasuredWidth();
        if (z) {
            iArr[0] = i2 - measuredWidth;
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[0] = i2 - measuredWidth;
            iArr[1] = iArr2[1] + height;
        }
        AppMethodBeat.o(126646);
        return iArr;
    }

    public static int[] b(Context context, View view, View view2, boolean z) {
        AppMethodBeat.i(126647);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        int height = view.getHeight();
        int i2 = ao.az(context).x;
        view2.measure(0, 0);
        int measuredHeight = view2.getMeasuredHeight();
        int measuredWidth = view2.getMeasuredWidth();
        if (z) {
            iArr[0] = (i2 - measuredWidth) / 2;
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[0] = (i2 - measuredWidth) / 2;
            iArr[1] = iArr2[1] + height;
        }
        AppMethodBeat.o(126647);
        return iArr;
    }

    public static int fX(View view) {
        AppMethodBeat.i(126648);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        AppMethodBeat.o(126648);
        return width;
    }

    public static int dip2px(Context context, float f2) {
        AppMethodBeat.i(126649);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        AppMethodBeat.o(126649);
        return i2;
    }
}
