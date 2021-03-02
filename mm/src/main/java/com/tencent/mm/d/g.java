package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g {
    private static String a(InputStream inputStream, int i2, byte[] bArr) {
        byte[] digest;
        AppMethodBeat.i(948);
        if (i2 <= 0) {
            AppMethodBeat.o(948);
            return null;
        }
        try {
            if (inputStream.skip(0) < 0) {
                AppMethodBeat.o(948);
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr2 = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
            int i3 = 0;
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1 || i3 >= i2) {
                    if (bArr != null && bArr.length > 0) {
                        instance.update(bArr);
                    }
                } else if (i3 + read <= i2) {
                    instance.update(bArr2, 0, read);
                    i3 += read;
                } else {
                    instance.update(bArr2, 0, i2 - i3);
                    i3 = i2;
                }
            }
            instance.update(bArr);
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(948);
            return sb2;
        } catch (Exception e2) {
            AppMethodBeat.o(948);
            return null;
        }
    }

    private static String b(InputStream inputStream, int i2) {
        byte[] digest;
        String str = null;
        AppMethodBeat.i(949);
        if (i2 <= 0) {
            AppMethodBeat.o(949);
        } else {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[i2];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                for (byte b2 : instance.digest()) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                str = sb.toString();
                AppMethodBeat.o(949);
            } catch (Exception e2) {
                AppMethodBeat.o(949);
            }
        }
        return str;
    }

    public static String getMD5(String str) {
        AppMethodBeat.i(950);
        if (str == null) {
            AppMethodBeat.o(950);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            String C = C(file);
            AppMethodBeat.o(950);
            return C;
        }
        AppMethodBeat.o(950);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[SYNTHETIC, Splitter:B:16:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044 A[SYNTHETIC, Splitter:B:22:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String C(java.io.File r8) {
        /*
            r4 = 102400(0x19000, double:5.05923E-319)
            r0 = 0
            r3 = 951(0x3b7, float:1.333E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            boolean r1 = r8.exists()
            if (r1 != 0) goto L_0x0013
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0012:
            return r0
        L_0x0013:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0035, all -> 0x0040 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0035, all -> 0x0040 }
            long r6 = r8.length()     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x0030
        L_0x0020:
            int r1 = (int) r4     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            java.lang.String r1 = b(r2, r1)     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            r2.close()     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            r2.close()     // Catch:{ IOException -> 0x004b }
        L_0x002b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
            goto L_0x0012
        L_0x0030:
            long r4 = r8.length()
            goto L_0x0020
        L_0x0035:
            r1 = move-exception
            r1 = r0
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ IOException -> 0x004d }
        L_0x003c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0012
        L_0x0040:
            r1 = move-exception
            r2 = r0
        L_0x0042:
            if (r2 == 0) goto L_0x0047
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x0047:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        L_0x004b:
            r0 = move-exception
            goto L_0x002b
        L_0x004d:
            r1 = move-exception
            goto L_0x003c
        L_0x004f:
            r0 = move-exception
            goto L_0x0047
        L_0x0051:
            r0 = move-exception
            r1 = r0
            goto L_0x0042
        L_0x0054:
            r1 = move-exception
            r1 = r2
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.d.g.C(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r4, int r5, byte[] r6) {
        /*
            r1 = 0
            r3 = 952(0x3b8, float:1.334E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x000e
            if (r5 > 0) goto L_0x0013
        L_0x000e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
        L_0x0012:
            return r0
        L_0x0013:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0026, all -> 0x0032 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0026, all -> 0x0032 }
            java.lang.String r0 = a(r2, r5, r6)     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r2.close()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r2.close()     // Catch:{ IOException -> 0x003d }
        L_0x0022:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0012
        L_0x0026:
            r0 = move-exception
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            r0.close()     // Catch:{ IOException -> 0x003f }
        L_0x002d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
            goto L_0x0012
        L_0x0032:
            r0 = move-exception
            r2 = r1
        L_0x0034:
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0039:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x003d:
            r1 = move-exception
            goto L_0x0022
        L_0x003f:
            r0 = move-exception
            goto L_0x002d
        L_0x0041:
            r1 = move-exception
            goto L_0x0039
        L_0x0043:
            r0 = move-exception
            goto L_0x0034
        L_0x0045:
            r0 = move-exception
            r0 = r2
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.d.g.a(java.io.File, int, byte[]):java.lang.String");
    }
}
