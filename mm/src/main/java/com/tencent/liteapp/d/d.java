package com.tencent.liteapp.d;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private static SparseIntArray csc = new SparseIntArray();
    private static float density = -1.0f;
    private static float scale = 0.0f;

    static {
        AppMethodBeat.i(197805);
        AppMethodBeat.o(197805);
    }

    public static int ax(Context context) {
        AppMethodBeat.i(197804);
        if (context != null && density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        int round = Math.round(density * 25.0f);
        AppMethodBeat.o(197804);
        return round;
    }
}
