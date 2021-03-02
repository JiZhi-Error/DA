package com.a.a;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class c {
    static final int aPv;
    private static final Method aPw;

    static {
        AppMethodBeat.i(206460);
        try {
            aPv = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            aPw = Canvas.class.getMethod("save", Integer.TYPE);
        } finally {
            AppMethodBeat.o(206460);
        }
    }

    static void c(Canvas canvas, int i2) {
        AppMethodBeat.i(206459);
        try {
            aPw.invoke(canvas, Integer.valueOf(i2));
        } finally {
            AppMethodBeat.o(206459);
        }
    }
}
