package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class c {
    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(138359);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                AppMethodBeat.o(138359);
                return;
            }
        }
        AppMethodBeat.o(138359);
    }

    public static long c(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(138360);
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
            } else {
                AppMethodBeat.o(138360);
                return j2;
            }
        }
    }
}
