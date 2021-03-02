package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;

public final class a {
    public static long a(az azVar, int i2, long j2) {
        AppMethodBeat.i(43075);
        if (azVar == null) {
            AppMethodBeat.o(43075);
            return 0;
        }
        if (j2 == 0) {
            j2 = Util.nowMilliSecond();
        }
        switch (i2) {
            case 2:
                long a2 = a(azVar, j2) | 4611686018427387904L;
                AppMethodBeat.o(43075);
                return a2;
            case 3:
                long a3 = a(azVar, j2) & -4611686018427387905L;
                AppMethodBeat.o(43075);
                return a3;
            case 4:
                long a4 = a(azVar, j2) & 4611686018427387904L;
                AppMethodBeat.o(43075);
                return a4;
            case 5:
                long a5 = a(azVar, j2) | 1152921504606846976L;
                AppMethodBeat.o(43075);
                return a5;
            case 6:
                long a6 = a(azVar, j2) & -1152921504606846977L;
                AppMethodBeat.o(43075);
                return a6;
            case 7:
                long a7 = a(azVar, j2) & 1152921504606846976L;
                AppMethodBeat.o(43075);
                return a7;
            default:
                long a8 = a(azVar, j2);
                AppMethodBeat.o(43075);
                return a8;
        }
    }

    public static long a(az azVar, long j2) {
        return (azVar.field_flag & -72057594037927936L) | (72057594037927935L & j2);
    }
}
