package com.tencent.mm.ext.ui;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.liteapp.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static final SparseIntArray csc = new SparseIntArray();
    private static float density = -1.0f;

    static {
        AppMethodBeat.i(197825);
        AppMethodBeat.o(197825);
    }

    public static int E(Context context, int i2) {
        AppMethodBeat.i(197824);
        float f2 = (float) i2;
        if (context == null) {
            a.C0147a aVar = a.cqJ;
            context = a.C0147a.getAppContext();
        }
        float f3 = context.getResources().getDisplayMetrics().density;
        density = f3;
        int round = Math.round(f2 / f3);
        AppMethodBeat.o(197824);
        return round;
    }
}
