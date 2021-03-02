package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends a {
    private static final String TAG = ("MicroMsg." + e.class.getSimpleName());
    private boolean isRetry = false;
    private int sQt;

    static {
        AppMethodBeat.i(103684);
        AppMethodBeat.o(103684);
    }

    e(Context context, f fVar, int i2) {
        super(context, fVar, i2, 0);
        this.sQt = i2;
    }
}
