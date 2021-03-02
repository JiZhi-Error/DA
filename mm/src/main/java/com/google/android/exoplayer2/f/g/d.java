package com.google.android.exoplayer2.f.g;

import android.text.Layout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class d {
    String aQa = "";
    int bCV;
    boolean bCW = false;
    boolean bCX = false;
    int bCY = -1;
    int bCZ = -1;
    String bDA = "";
    List<String> bDB = Collections.emptyList();
    String bDC = "";
    int bDa = -1;
    int bDb = -1;
    int bDc = -1;
    Layout.Alignment bDe = null;
    int backgroundColor;
    String fontFamily = null;
    float fontSize;

    public d() {
        AppMethodBeat.i(92891);
        AppMethodBeat.o(92891);
    }

    public final int getStyle() {
        int i2 = 0;
        if (this.bDa == -1 && this.bDb == -1) {
            return -1;
        }
        int i3 = this.bDa == 1 ? 1 : 0;
        if (this.bDb == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    static int b(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(92892);
        if (str.isEmpty() || i2 == -1) {
            AppMethodBeat.o(92892);
            return i2;
        } else if (str.equals(str2)) {
            int i4 = i2 + i3;
            AppMethodBeat.o(92892);
            return i4;
        } else {
            AppMethodBeat.o(92892);
            return -1;
        }
    }
}
