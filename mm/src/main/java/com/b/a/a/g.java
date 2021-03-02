package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* access modifiers changed from: package-private */
public final class g {
    protected static byte[] compress(byte[] bArr) {
        AppMethodBeat.i(87928);
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Error | Exception e2) {
        }
        AppMethodBeat.o(87928);
        return bArr2;
    }
}
