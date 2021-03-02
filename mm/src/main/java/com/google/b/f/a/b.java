package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    public final int cfd;
    private final int[] cfq;

    public static b valueOf(String str) {
        AppMethodBeat.i(12306);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(12306);
        return bVar;
    }

    static {
        AppMethodBeat.i(12307);
        AppMethodBeat.o(12307);
    }

    private b(int[] iArr, int i2) {
        this.cfq = iArr;
        this.cfd = i2;
    }

    public final int a(c cVar) {
        char c2;
        int i2 = cVar.cfu;
        if (i2 <= 9) {
            c2 = 0;
        } else if (i2 <= 26) {
            c2 = 1;
        } else {
            c2 = 2;
        }
        return this.cfq[c2];
    }
}
