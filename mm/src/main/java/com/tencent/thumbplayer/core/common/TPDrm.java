package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPDrm {
    static native int[] native_getDRMCapabilities();

    public static int[] getDRMCapabilities() {
        AppMethodBeat.i(189732);
        int[] iArr = null;
        try {
            iArr = native_getDRMCapabilities();
        } catch (Exception e2) {
        }
        if (iArr == null) {
            int[] iArr2 = new int[0];
            AppMethodBeat.o(189732);
            return iArr2;
        }
        AppMethodBeat.o(189732);
        return iArr;
    }
}
