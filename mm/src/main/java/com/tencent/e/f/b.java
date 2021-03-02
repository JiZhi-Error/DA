package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public final class b {
    public static byte[] compress(byte[] bArr) {
        AppMethodBeat.i(138455);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e2) {
            }
            AppMethodBeat.o(138455);
            return byteArray;
        } catch (Exception e3) {
            h.ez("deflater(), exception: ".concat(String.valueOf(e3)));
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e4) {
            }
            AppMethodBeat.o(138455);
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e5) {
            }
            AppMethodBeat.o(138455);
            throw th;
        }
    }

    public static byte[] cV(byte[] bArr) {
        AppMethodBeat.i(138456);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inflaterInputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } catch (Exception e2) {
                h.ez("inflater(), exception: ".concat(String.valueOf(e2)));
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
                AppMethodBeat.o(138456);
                return null;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                }
                AppMethodBeat.o(138456);
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayInputStream.close();
            inflaterInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e5) {
        }
        AppMethodBeat.o(138456);
        return byteArray;
    }
}
