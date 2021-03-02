package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    public static int u(Activity activity) {
        AppMethodBeat.i(155862);
        if (activity instanceof AppCompatActivity) {
            if (((AppCompatActivity) activity).getSupportActionBar() != null) {
                int height = ((AppCompatActivity) activity).getSupportActionBar().getHeight();
                AppMethodBeat.o(155862);
                return height;
            }
        } else if (activity.getActionBar() != null) {
            int height2 = activity.getActionBar().getHeight();
            AppMethodBeat.o(155862);
            return height2;
        }
        int cy = cy(activity);
        AppMethodBeat.o(155862);
        return cy;
    }

    public static int cy(Context context) {
        AppMethodBeat.i(155863);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.z, typedValue, true)) {
            int complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            AppMethodBeat.o(155863);
            return complexToDimensionPixelSize;
        } else if (context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            int complexToDimensionPixelSize2 = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            AppMethodBeat.o(155863);
            return complexToDimensionPixelSize2;
        } else {
            AppMethodBeat.o(155863);
            return 0;
        }
    }
}
