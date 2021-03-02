package com.google.b.d;

import com.facebook.appevents.AppEventsConstants;
import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class p implements g {
    private final j ceu = new j();

    public p() {
        AppMethodBeat.i(12393);
        AppMethodBeat.o(12393);
    }

    @Override // com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12394);
        if (aVar != a.UPC_A) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12394);
            throw illegalArgumentException;
        }
        b a2 = this.ceu.a(cu(str), a.EAN_13, i2, i3, map);
        AppMethodBeat.o(12394);
        return a2;
    }

    private static String cu(String str) {
        AppMethodBeat.i(12395);
        int length = str.length();
        if (length == 11) {
            int i2 = 0;
            for (int i3 = 0; i3 < 11; i3++) {
                i2 += (i3 % 2 == 0 ? 3 : 1) * (str.charAt(i3) - '0');
            }
            str = str + ((1000 - i2) % 10);
        } else if (length != 12) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
            AppMethodBeat.o(12395);
            throw illegalArgumentException;
        }
        String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str));
        AppMethodBeat.o(12395);
        return concat;
    }
}
