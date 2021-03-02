package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class d {
    public static final String getMessageDigest(byte[] bArr) {
        AppMethodBeat.i(157002);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            String str = new String(cArr2);
            AppMethodBeat.o(157002);
            return str;
        } catch (Exception e2) {
            AppMethodBeat.o(157002);
            return null;
        }
    }

    private static String b(InputStream inputStream, int i2, int i3) {
        byte[] digest;
        AppMethodBeat.i(219075);
        try {
            if (inputStream.skip(0) < 0) {
                AppMethodBeat.o(219075);
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
            int i4 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1 || i4 >= 102400) {
                } else if (i4 + read <= 102400) {
                    instance.update(bArr, 0, read);
                    i4 += read;
                } else {
                    instance.update(bArr, 0, ShareConstants.MD5_FILE_BUF_LENGTH - i4);
                    i4 = 102400;
                }
            }
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(219075);
            return sb2;
        } catch (Exception e2) {
            AppMethodBeat.o(219075);
            return null;
        }
    }

    private static String b(InputStream inputStream, int i2) {
        byte[] digest;
        AppMethodBeat.i(157004);
        if (i2 <= 0) {
            AppMethodBeat.o(157004);
            return null;
        }
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
            String sb2 = sb.toString();
            AppMethodBeat.o(157004);
            return sb2;
        } catch (Exception e2) {
            AppMethodBeat.o(157004);
            return null;
        }
    }

    public static String getMD5(String str) {
        AppMethodBeat.i(157005);
        if (str == null) {
            AppMethodBeat.o(157005);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            String C = C(file);
            AppMethodBeat.o(157005);
            return C;
        }
        AppMethodBeat.o(157005);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[SYNTHETIC, Splitter:B:16:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[SYNTHETIC, Splitter:B:22:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String C(java.io.File r8) {
        /*
            r4 = 102400(0x19000, double:5.05923E-319)
            r0 = 0
            r3 = 157006(0x2654e, float:2.20012E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            boolean r1 = r8.exists()
            if (r1 != 0) goto L_0x0014
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0013:
            return r0
        L_0x0014:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0036, all -> 0x0041 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0036, all -> 0x0041 }
            long r6 = r8.length()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x0031
        L_0x0021:
            int r1 = (int) r4     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r1 = b(r2, r1)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.close()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.close()     // Catch:{ IOException -> 0x004c }
        L_0x002c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
            goto L_0x0013
        L_0x0031:
            long r4 = r8.length()
            goto L_0x0021
        L_0x0036:
            r1 = move-exception
            r1 = r0
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x004e }
        L_0x003d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0013
        L_0x0041:
            r1 = move-exception
            r2 = r0
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0048:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        L_0x004c:
            r0 = move-exception
            goto L_0x002c
        L_0x004e:
            r1 = move-exception
            goto L_0x003d
        L_0x0050:
            r0 = move-exception
            goto L_0x0048
        L_0x0052:
            r0 = move-exception
            r1 = r0
            goto L_0x0043
        L_0x0055:
            r1 = move-exception
            r1 = r2
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.util.d.C(java.io.File):java.lang.String");
    }

    public static boolean oi(String str, String str2) {
        AppMethodBeat.i(157007);
        String md5 = getMD5(str);
        if (md5 == null || str2 == null || !str2.equalsIgnoreCase(md5)) {
            AppMethodBeat.o(157007);
            return false;
        }
        AppMethodBeat.o(157007);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[SYNTHETIC, Splitter:B:14:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038 A[SYNTHETIC, Splitter:B:20:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String al(java.io.File r5) {
        /*
            r0 = 0
            r4 = 157008(0x26550, float:2.20015E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            boolean r1 = r5.exists()
            if (r1 != 0) goto L_0x0011
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0010:
            return r0
        L_0x0011:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0034 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0029, all -> 0x0034 }
            r1 = 0
            r3 = 102400(0x19000, float:1.43493E-40)
            java.lang.String r1 = b(r2, r1, r3)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r2.close()     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r1
            goto L_0x0010
        L_0x0029:
            r1 = move-exception
            r1 = r0
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0030:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0010
        L_0x0034:
            r1 = move-exception
            r2 = r0
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ IOException -> 0x0043 }
        L_0x003b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x003f:
            r0 = move-exception
            goto L_0x0024
        L_0x0041:
            r1 = move-exception
            goto L_0x0030
        L_0x0043:
            r0 = move-exception
            goto L_0x003b
        L_0x0045:
            r0 = move-exception
            r1 = r0
            goto L_0x0036
        L_0x0048:
            r1 = move-exception
            r1 = r2
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.util.d.al(java.io.File):java.lang.String");
    }
}
