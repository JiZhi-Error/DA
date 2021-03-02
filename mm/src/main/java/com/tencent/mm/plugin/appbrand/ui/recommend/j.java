package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class j {
    public static void b(Context context, View view) {
        AppMethodBeat.i(49313);
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.rn);
            if (layoutParams != null) {
                layoutParams.rightMargin = dimensionPixelOffset;
                layoutParams.leftMargin = dimensionPixelOffset;
                layoutParams.topMargin = dimensionPixelOffset;
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.invalidate();
                linearLayout.requestLayout();
            }
        }
        AppMethodBeat.o(49313);
    }
}
