package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static int c(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(235075);
        int m = m(i3, f2 / f3) + i2;
        if (m < 0) {
            i3 = 0;
        } else if (m <= i3) {
            i3 = m;
        }
        AppMethodBeat.o(235075);
        return i3;
    }

    private static int m(int i2, float f2) {
        if (i2 > 180) {
            if (i2 <= 600) {
                i2 = 180;
            } else {
                i2 = i2 <= 1800 ? 300 : 600;
            }
        }
        return (int) (((float) i2) * f2);
    }
}
