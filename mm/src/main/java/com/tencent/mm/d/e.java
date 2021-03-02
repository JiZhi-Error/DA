package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class e {
    public static final boolean a(InputStream inputStream, byte[] bArr, int i2) {
        AppMethodBeat.i(943);
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3 + 0, i2 - i3);
            if (read < 0) {
                AppMethodBeat.o(943);
                return false;
            }
            i3 += read;
        }
        AppMethodBeat.o(943);
        return true;
    }
}
