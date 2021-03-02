package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class a implements g {
    a() {
    }

    @Override // com.google.b.c.a.g
    public final void a(h hVar) {
        int i2;
        AppMethodBeat.i(12271);
        String str = hVar.msg;
        int i3 = hVar.pos;
        int length = str.length();
        if (i3 < length) {
            char charAt = str.charAt(i3);
            i2 = 0;
            while (j.isDigit(charAt) && i3 < length) {
                i2++;
                i3++;
                if (i3 < length) {
                    charAt = str.charAt(i3);
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 >= 2) {
            char charAt2 = hVar.msg.charAt(hVar.pos);
            char charAt3 = hVar.msg.charAt(hVar.pos + 1);
            if (!j.isDigit(charAt2) || !j.isDigit(charAt3)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not digits: " + charAt2 + charAt3);
                AppMethodBeat.o(12271);
                throw illegalArgumentException;
            }
            hVar.g((char) (((charAt2 - '0') * 10) + (charAt3 - '0') + 130));
            hVar.pos += 2;
            AppMethodBeat.o(12271);
            return;
        }
        char Im = hVar.Im();
        int b2 = j.b(hVar.msg, hVar.pos, 0);
        if (b2 != 0) {
            switch (b2) {
                case 1:
                    hVar.g(230);
                    hVar.cdF = 1;
                    AppMethodBeat.o(12271);
                    return;
                case 2:
                    hVar.g(239);
                    hVar.cdF = 2;
                    AppMethodBeat.o(12271);
                    return;
                case 3:
                    hVar.g(238);
                    hVar.cdF = 3;
                    AppMethodBeat.o(12271);
                    return;
                case 4:
                    hVar.g(240);
                    hVar.cdF = 4;
                    AppMethodBeat.o(12271);
                    return;
                case 5:
                    hVar.g(231);
                    hVar.cdF = 5;
                    AppMethodBeat.o(12271);
                    return;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Illegal mode: ".concat(String.valueOf(b2)));
                    AppMethodBeat.o(12271);
                    throw illegalStateException;
            }
        } else if (j.h(Im)) {
            hVar.g(235);
            hVar.g((char) ((Im - 128) + 1));
            hVar.pos++;
            AppMethodBeat.o(12271);
        } else {
            hVar.g((char) (Im + 1));
            hVar.pos++;
            AppMethodBeat.o(12271);
        }
    }
}
