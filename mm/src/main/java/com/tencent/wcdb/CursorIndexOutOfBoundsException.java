package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i2, int i3) {
        super("Index " + i2 + " requested, with a size of " + i3);
        AppMethodBeat.i(2670);
        AppMethodBeat.o(2670);
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}
