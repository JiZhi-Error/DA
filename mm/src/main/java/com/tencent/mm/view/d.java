package com.tencent.mm.view;

import android.content.Context;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static int e(Context context, float f2) {
        AppMethodBeat.i(206170);
        int applyDimension = (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
        AppMethodBeat.o(206170);
        return applyDimension;
    }
}
