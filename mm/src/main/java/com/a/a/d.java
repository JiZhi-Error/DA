package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class d {
    int pos;
    long value;

    d(long j2, int i2) {
        this.value = j2;
        this.pos = i2;
    }

    static d e(String str, int i2, int i3) {
        AppMethodBeat.i(206461);
        long j2 = 0;
        if (i2 >= i3) {
            AppMethodBeat.o(206461);
            return null;
        }
        int i4 = i2;
        while (i4 < i3) {
            char charAt = str.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j2 = (j2 * 10) + ((long) (charAt - '0'));
            if (j2 > 2147483647L) {
                AppMethodBeat.o(206461);
                return null;
            }
            i4++;
        }
        if (i4 == i2) {
            AppMethodBeat.o(206461);
            return null;
        }
        d dVar = new d(j2, i4);
        AppMethodBeat.o(206461);
        return dVar;
    }

    static d f(String str, int i2) {
        AppMethodBeat.i(206462);
        long j2 = 0;
        if (1 >= i2) {
            AppMethodBeat.o(206462);
            return null;
        }
        int i3 = 1;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                j2 = (j2 * 16) + ((long) (charAt - '0'));
            } else if (charAt < 'A' || charAt > 'F') {
                if (charAt < 'a' || charAt > 'f') {
                    break;
                }
                j2 = (j2 * 16) + ((long) (charAt - 'a')) + 10;
            } else {
                j2 = (j2 * 16) + ((long) (charAt - 'A')) + 10;
            }
            if (j2 > Util.MAX_32BIT_VALUE) {
                AppMethodBeat.o(206462);
                return null;
            }
            i3++;
        }
        if (i3 == 1) {
            AppMethodBeat.o(206462);
            return null;
        }
        d dVar = new d(j2, i3);
        AppMethodBeat.o(206462);
        return dVar;
    }
}
