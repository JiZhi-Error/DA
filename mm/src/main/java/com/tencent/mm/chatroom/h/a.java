package com.tencent.mm.chatroom.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static int cr(int i2, int i3) {
        AppMethodBeat.i(13023);
        switch (i2) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                AppMethodBeat.o(13023);
                return 31;
            case 1:
                if ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % 400 != 0) {
                    AppMethodBeat.o(13023);
                    return 28;
                }
                AppMethodBeat.o(13023);
                return 29;
            case 3:
            case 5:
            case 8:
            case 10:
                AppMethodBeat.o(13023);
                return 30;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid Month");
                AppMethodBeat.o(13023);
                throw illegalArgumentException;
        }
    }
}
