package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class b {
    private static final byte[] RMs = {Byte.MAX_VALUE, 69, 76, 70};

    public static boolean bpZ(String str) {
        FileInputStream fileInputStream;
        AppMethodBeat.i(138356);
        byte[] bArr = new byte[RMs.length];
        try {
            fileInputStream = new FileInputStream(str);
            try {
                if (fileInputStream.read(bArr, 0, RMs.length) != bArr.length) {
                    IOException iOException = new IOException("Read bytes less than " + bArr.length);
                    AppMethodBeat.o(138356);
                    throw iOException;
                }
                for (int i2 = 0; i2 < RMs.length; i2++) {
                    if (RMs[i2] != bArr[i2]) {
                        c.closeQuietly(fileInputStream);
                        AppMethodBeat.o(138356);
                        return false;
                    }
                }
                c.closeQuietly(fileInputStream);
                AppMethodBeat.o(138356);
                return true;
            } catch (Throwable th) {
                th = th;
                c.closeQuietly(fileInputStream);
                AppMethodBeat.o(138356);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            c.closeQuietly(fileInputStream);
            AppMethodBeat.o(138356);
            throw th;
        }
    }

    public static byte[] aVb(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        AppMethodBeat.i(138357);
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
                try {
                    c.c(fileInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray == null) {
                        byteArray = "".getBytes();
                    }
                    c.closeQuietly(fileInputStream);
                    c.closeQuietly(byteArrayOutputStream);
                    AppMethodBeat.o(138357);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    c.closeQuietly(fileInputStream);
                    c.closeQuietly(byteArrayOutputStream);
                    AppMethodBeat.o(138357);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                c.closeQuietly(fileInputStream);
                c.closeQuietly(byteArrayOutputStream);
                AppMethodBeat.o(138357);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            fileInputStream = null;
            c.closeQuietly(fileInputStream);
            c.closeQuietly(byteArrayOutputStream);
            AppMethodBeat.o(138357);
            throw th;
        }
    }

    public static byte[] hv(String str, int i2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        byte[] bArr;
        int i3 = 0;
        AppMethodBeat.i(138358);
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(138358);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr2 = new byte[i2];
                do {
                    int read = fileInputStream.read(bArr2, i3, i2 - i3);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                } while (i3 < i2);
                if (i3 == 0) {
                    c.closeQuietly(fileInputStream);
                    AppMethodBeat.o(138358);
                    return null;
                }
                if (i3 < i2) {
                    bArr = new byte[i3];
                    System.arraycopy(bArr2, 0, bArr, 0, i3);
                } else {
                    bArr = bArr2;
                }
                c.closeQuietly(fileInputStream);
                AppMethodBeat.o(138358);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                c.closeQuietly(fileInputStream);
                AppMethodBeat.o(138358);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            c.closeQuietly(fileInputStream);
            AppMethodBeat.o(138358);
            throw th;
        }
    }
}
