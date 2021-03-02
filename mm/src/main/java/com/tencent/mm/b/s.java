package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;

public final class s {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[SYNTHETIC, Splitter:B:14:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A[SYNTHETIC, Splitter:B:31:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compress(byte[] r7) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.b.s.compress(byte[]):byte[]");
    }

    public static byte[] T(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        Exception e2 = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            byte[] bArr2 = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.Zlib", e3, "", new Object[0]);
            }
        } catch (Exception e4) {
            e2 = e4;
            Log.printErrStackTrace("MicroMsg.Zlib", e2, "exception when loop read byte", new Object[0]);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                Log.printErrStackTrace("MicroMsg.Zlib", e5, "", new Object[0]);
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
                Log.printErrStackTrace("MicroMsg.Zlib", e6, "", new Object[0]);
            }
            throw th;
        }
        inflater.end();
        if (e2 == null) {
            return bArr;
        }
        throw new Exception(e2);
    }
}
