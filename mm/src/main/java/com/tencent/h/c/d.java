package com.tencent.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportErrorStatus;

public final class d {
    public static final int[] SpV = {118, 28, 44, -104, -48, -42, -86, -20, 116, 86, -120, 116, 15, -72, 74, -76};
    public static final int[] SpW = {104, -106, -82, 24, 97, -80, -13, -105, 108, 37, -93, -89, 21, 59, 9, -61, -78, -48, 72, -128};
    public static final int[] SpX = {31, -84, 34, 64, ExportErrorStatus.APPEND_VIDEO_SAMPLE_MAKE_CURRENT, -91, 81, -125, -40, -22, 33, -67, -73, 123, -23, -93};

    public static String V(int[] iArr) {
        AppMethodBeat.i(214638);
        byte[] bArr = new byte[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            bArr[i2] = (byte) iArr[i2];
        }
        byte[] o = b.o(bArr, b.hkP());
        if (o == null) {
            AppMethodBeat.o(214638);
            return null;
        }
        String str = new String(o);
        AppMethodBeat.o(214638);
        return str;
    }
}
