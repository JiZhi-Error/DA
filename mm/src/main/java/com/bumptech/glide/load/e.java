package com.bumptech.glide.load;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class e extends IOException {
    private final int statusCode;

    public e(int i2) {
        this("Http request failed with status code: ".concat(String.valueOf(i2)), i2);
        AppMethodBeat.i(76842);
        AppMethodBeat.o(76842);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i2) {
        this(str, i2, (byte) 0);
    }

    private e(String str, int i2, byte b2) {
        super(str, null);
        this.statusCode = i2;
    }
}
