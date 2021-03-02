package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URLConnection;

public final class e {
    public static final String TTr;
    public static final char UeE = File.separatorChar;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(10310);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (r3 == null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(10310);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0054, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005f, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[SYNTHETIC, Splitter:B:15:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0047 A[SYNTHETIC, Splitter:B:27:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0053 A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f  */
    static {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.a.e.<clinit>():void");
    }

    public static void a(URLConnection uRLConnection) {
        AppMethodBeat.i(187041);
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
        AppMethodBeat.o(187041);
    }

    @Deprecated
    public static void a(Reader reader) {
        AppMethodBeat.i(187042);
        closeQuietly(reader);
        AppMethodBeat.o(187042);
    }

    @Deprecated
    public static void W(InputStream inputStream) {
        AppMethodBeat.i(10304);
        closeQuietly(inputStream);
        AppMethodBeat.o(10304);
    }

    @Deprecated
    public static void e(OutputStream outputStream) {
        AppMethodBeat.i(10305);
        closeQuietly(outputStream);
        AppMethodBeat.o(10305);
    }

    @Deprecated
    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(10306);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                AppMethodBeat.o(10306);
                return;
            }
        }
        AppMethodBeat.o(10306);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[SYNTHETIC, Splitter:B:13:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.io.InputStream r5) {
        /*
            r4 = 10307(0x2843, float:1.4443E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            org.apache.commons.a.a.a r3 = new org.apache.commons.a.a.a
            r3.<init>()
            r2 = 0
            copy(r5, r3)     // Catch:{ Throwable -> 0x0019, all -> 0x0034 }
            byte[] r0 = r3.toByteArray()     // Catch:{ Throwable -> 0x0019, all -> 0x0034 }
            r3.close()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x0019:
            r0 = move-exception
            r1 = 10307(0x2843, float:1.4443E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)     // Catch:{ all -> 0x0020 }
            throw r0     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            r2 = r0
        L_0x0022:
            if (r2 == 0) goto L_0x0030
            r3.close()     // Catch:{ Throwable -> 0x002b }
        L_0x0027:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x002b:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0027
        L_0x0030:
            r3.close()
            goto L_0x0027
        L_0x0034:
            r0 = move-exception
            r1 = r0
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.a.e.toByteArray(java.io.InputStream):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[SYNTHETIC, Splitter:B:13:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.InputStream r5, java.nio.charset.Charset r6) {
        /*
            r4 = 178789(0x2ba65, float:2.50537E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            org.apache.commons.a.a.b r3 = new org.apache.commons.a.a.b
            r3.<init>()
            r2 = 0
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x0027, all -> 0x0043 }
            java.nio.charset.Charset r1 = org.apache.commons.a.a.b(r6)     // Catch:{ Throwable -> 0x0027, all -> 0x0043 }
            r0.<init>(r5, r1)     // Catch:{ Throwable -> 0x0027, all -> 0x0043 }
            r1 = 4096(0x1000, float:5.74E-42)
            char[] r1 = new char[r1]     // Catch:{ Throwable -> 0x0027, all -> 0x0043 }
            a(r0, r3, r1)     // Catch:{ Throwable -> 0x0027, all -> 0x0043 }
            java.lang.String r0 = r3.toString()     // Catch:{ Throwable -> 0x0027, all -> 0x0043 }
            r3.close()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x0027:
            r0 = move-exception
            r1 = 178789(0x2ba65, float:2.50537E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)     // Catch:{ all -> 0x002f }
            throw r0     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            r2 = r0
        L_0x0031:
            if (r2 == 0) goto L_0x003f
            r3.close()     // Catch:{ Throwable -> 0x003a }
        L_0x0036:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x003a:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0036
        L_0x003f:
            r3.close()
            goto L_0x0036
        L_0x0043:
            r0 = move-exception
            r1 = r0
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.a.e.a(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(10308);
        long c2 = c(inputStream, outputStream);
        if (c2 > 2147483647L) {
            AppMethodBeat.o(10308);
            return -1;
        }
        int i2 = (int) c2;
        AppMethodBeat.o(10308);
        return i2;
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int i2) {
        AppMethodBeat.i(187043);
        byte[] bArr = new byte[i2];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
            } else {
                AppMethodBeat.o(187043);
                return j2;
            }
        }
    }

    private static long c(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(187044);
        long a2 = a(inputStream, outputStream, 4096);
        AppMethodBeat.o(187044);
        return a2;
    }

    private static long a(Reader reader, Writer writer, char[] cArr) {
        AppMethodBeat.i(178790);
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 != read) {
                writer.write(cArr, 0, read);
                j2 += (long) read;
            } else {
                AppMethodBeat.o(178790);
                return j2;
            }
        }
    }
}
