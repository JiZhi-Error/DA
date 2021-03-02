package com.tencent.mm.plugin.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;

public final class a {
    public static int AU(long j2) {
        AppMethodBeat.i(238897);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j2);
        int i2 = gregorianCalendar.get(11);
        AppMethodBeat.o(238897);
        return i2;
    }

    public static int AV(long j2) {
        int i2 = 7;
        AppMethodBeat.i(238898);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j2);
        int i3 = gregorianCalendar.get(7);
        if (i3 - 1 > 0) {
            i2 = i3 - 1;
        }
        AppMethodBeat.o(238898);
        return i2;
    }

    public static float f(int i2, float[] fArr) {
        AppMethodBeat.i(238899);
        if (fArr == null || fArr.length <= 0) {
            RuntimeException runtimeException = new RuntimeException("calc bucket but bucket is null.");
            AppMethodBeat.o(238899);
            throw runtimeException;
        }
        int i3 = 0;
        while (i3 < fArr.length && ((float) i2) > fArr[i3]) {
            i3++;
        }
        float length = (((float) i3) * 1.0f) / ((float) (fArr.length + 1));
        AppMethodBeat.o(238899);
        return length;
    }

    public static float a(float f2, float[] fArr) {
        AppMethodBeat.i(238900);
        if (fArr == null || fArr.length <= 0) {
            RuntimeException runtimeException = new RuntimeException("calc bucket but bucket is null.");
            AppMethodBeat.o(238900);
            throw runtimeException;
        }
        int i2 = 0;
        while (i2 < fArr.length && f2 > fArr[i2]) {
            i2++;
        }
        float length = (((float) i2) * 1.0f) / ((float) (fArr.length + 1));
        AppMethodBeat.o(238900);
        return length;
    }
}
