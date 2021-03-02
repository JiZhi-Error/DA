package com.tencent.matrix.a.c;

import android.text.TextUtils;
import com.tencent.matrix.g.c;
import com.tencent.matrix.g.d;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

public final class e {
    private static final byte[] sBuffer = new byte[128];

    public static a io(int i2) {
        return ev("/proc/" + i2 + "/stat");
    }

    public static a cf(int i2, int i3) {
        return ev("/proc/" + i2 + "/task/" + i3 + "/stat");
    }

    private static a ev(String str) {
        try {
            a e2 = e(str, sBuffer);
            if (e2 != null && e2.cUd != null) {
                return e2;
            }
            c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with buffer fail, fallback with spilts", new Object[0]);
            String eu = c.eu(str);
            a aVar = new a();
            if (!TextUtils.isEmpty(eu)) {
                int indexOf = eu.indexOf(")");
                if (indexOf <= 0) {
                    throw new IllegalStateException(eu + " has not ')'");
                }
                String substring = eu.substring(0, indexOf);
                aVar.cUd = substring.substring(substring.indexOf("(") + 1, indexOf);
                String[] split = eu.substring(indexOf + 1).split(" ");
                aVar.cUe = d.eT(split[12]);
                aVar.cUf = d.eT(split[13]);
                aVar.cUg = d.eT(split[14]);
                aVar.cUh = d.eT(split[15]);
            }
            if (aVar.cUd != null) {
                return aVar;
            }
            c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with splits fail", new Object[0]);
            return null;
        } catch (Throwable th) {
            c.printErrStackTrace("Matrix.battery.ProcStatUtil", th, "#parseJiffies fail", new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.matrix.a.c.e.a e(java.lang.String r5, byte[] r6) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x000d
        L_0x000c:
            return r0
        L_0x000d:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0029 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0029 }
            int r1 = r3.read(r6)     // Catch:{ Throwable -> 0x0020, all -> 0x0041 }
            r3.close()
        L_0x0019:
            if (r1 <= 0) goto L_0x000c
            com.tencent.matrix.a.c.e$a r0 = P(r6)
            goto L_0x000c
        L_0x0020:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r1 = move-exception
        L_0x0023:
            if (r2 == 0) goto L_0x003d
            r3.close()     // Catch:{ Throwable -> 0x0038 }
        L_0x0028:
            throw r1
        L_0x0029:
            r1 = move-exception
            java.lang.String r2 = "Matrix.battery.ProcStatUtil"
            java.lang.String r3 = "read buffer from file fail"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.tencent.matrix.g.c.printErrStackTrace(r2, r1, r3, r4)
            r1 = -1
            goto L_0x0019
        L_0x0038:
            r3 = move-exception
            r2.addSuppressed(r3)
            goto L_0x0028
        L_0x003d:
            r3.close()
            goto L_0x0028
        L_0x0041:
            r1 = move-exception
            r2 = r0
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.a.c.e.e(java.lang.String, byte[]):com.tencent.matrix.a.c.e$a");
    }

    private static a P(byte[] bArr) {
        a aVar = new a();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            if (Character.isSpaceChar(bArr[i3])) {
                i2++;
                i3++;
            } else {
                switch (i2) {
                    case 1:
                        int i4 = 0;
                        int i5 = i3;
                        while (i5 < length && 41 != bArr[i5]) {
                            i5++;
                            i4++;
                        }
                        if (40 == bArr[i3]) {
                            i3++;
                            i4--;
                        }
                        if (41 == bArr[(i3 + i4) - 1]) {
                            i4--;
                        }
                        if (i4 > 0) {
                            aVar.cUd = z(bArr, i3, i4);
                        }
                        i2 = 2;
                        i3 = i5;
                        continue;
                    case 14:
                        int i6 = 0;
                        int i7 = i3;
                        while (i7 < length && !Character.isSpaceChar(bArr[i7])) {
                            i7++;
                            i6++;
                        }
                        aVar.cUe = d.eT(z(bArr, i3, i6));
                        i3 = i7;
                        continue;
                    case 15:
                        int i8 = 0;
                        int i9 = i3;
                        while (i9 < length && !Character.isSpaceChar(bArr[i9])) {
                            i9++;
                            i8++;
                        }
                        aVar.cUf = d.eT(z(bArr, i3, i8));
                        i3 = i9;
                        continue;
                    case 16:
                        int i10 = 0;
                        int i11 = i3;
                        while (i11 < length && !Character.isSpaceChar(bArr[i11])) {
                            i11++;
                            i10++;
                        }
                        aVar.cUg = d.eT(z(bArr, i3, i10));
                        i3 = i11;
                        continue;
                    case 17:
                        int i12 = 0;
                        int i13 = i3;
                        while (i13 < length && !Character.isSpaceChar(bArr[i13])) {
                            i13++;
                            i12++;
                        }
                        aVar.cUh = d.eT(z(bArr, i3, i12));
                        i3 = i13;
                        continue;
                    default:
                        i3++;
                        continue;
                }
            }
        }
        return aVar;
    }

    private static String z(byte[] bArr, int i2, int i3) {
        CharBuffer decode = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(bArr, i2, i3));
        return String.valueOf(decode.array(), 0, decode.limit());
    }

    public static class a {
        public String cUd = "";
        public long cUe = -1;
        public long cUf = -1;
        public long cUg = -1;
        public long cUh = -1;

        public final long Sr() {
            return this.cUe + this.cUf + this.cUg + this.cUh;
        }
    }
}
