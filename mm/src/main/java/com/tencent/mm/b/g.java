package com.tencent.mm.b;

import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g {
    public static final String getMessageDigest(byte[] bArr) {
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
            return new String(cArr2);
        } catch (Exception e2) {
            return null;
        }
    }

    public static final byte[] Q(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e2) {
            return null;
        }
    }

    public static final String a(InputStream inputStream, int i2, int i3) {
        return b(inputStream, 0, 256);
    }

    private static String b(InputStream inputStream, int i2, int i3) {
        byte[] digest;
        if (inputStream == null || i2 < 0 || i3 <= 0) {
            return null;
        }
        try {
            if (inputStream.skip((long) i2) < ((long) i2)) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
            int i4 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1 || i4 >= i3) {
                } else if (i4 + read <= i3) {
                    instance.update(bArr, 0, read);
                    i4 += read;
                } else {
                    instance.update(bArr, 0, i3 - i4);
                    i4 = i3;
                }
            }
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public static final String b(InputStream inputStream, int i2) {
        byte[] digest;
        if (inputStream == null || i2 <= 0) {
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
            return sb.toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        o oVar = new o(str);
        if (oVar.exists()) {
            return a(oVar, ShareConstants.MD5_FILE_BUF_LENGTH);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034 A[SYNTHETIC, Splitter:B:22:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC, Splitter:B:28:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.tencent.mm.vfs.o r8, int r9) {
        /*
            r1 = 0
            if (r8 == 0) goto L_0x000b
            if (r9 <= 0) goto L_0x000b
            boolean r0 = r8.exists()
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r0 = r1
        L_0x000c:
            return r0
        L_0x000d:
            java.io.InputStream r2 = com.tencent.mm.vfs.s.ao(r8)     // Catch:{ Exception -> 0x0030, all -> 0x0039 }
            long r4 = (long) r9
            long r6 = r8.length()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x002b
            long r4 = (long) r9     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
        L_0x001b:
            int r0 = (int) r4     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.lang.String r0 = b(r2, r0)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r2.close()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            if (r2 == 0) goto L_0x000c
            r2.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x000c
        L_0x0029:
            r1 = move-exception
            goto L_0x000c
        L_0x002b:
            long r4 = r8.length()
            goto L_0x001b
        L_0x0030:
            r0 = move-exception
            r0 = r1
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0037:
            r0 = r1
            goto L_0x000c
        L_0x0039:
            r0 = move-exception
            r2 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0040:
            throw r0
        L_0x0041:
            r0 = move-exception
            goto L_0x0037
        L_0x0043:
            r1 = move-exception
            goto L_0x0040
        L_0x0045:
            r0 = move-exception
            goto L_0x003b
        L_0x0047:
            r0 = move-exception
            r0 = r2
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.b.g.a(com.tencent.mm.vfs.o, int):java.lang.String");
    }

    public static String fb(String str) {
        if (str == null) {
            return null;
        }
        o oVar = new o(str);
        if (oVar.exists()) {
            return b(oVar);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[SYNTHETIC, Splitter:B:14:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b A[SYNTHETIC, Splitter:B:20:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(com.tencent.mm.vfs.o r4) {
        /*
            r0 = 0
            boolean r1 = r4.exists()
            if (r1 != 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            java.io.InputStream r2 = com.tencent.mm.vfs.s.ao(r4)     // Catch:{ Exception -> 0x001d, all -> 0x0027 }
            r1 = 0
            r3 = 256(0x100, float:3.59E-43)
            java.lang.String r1 = a(r2, r1, r3)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r2.close()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            if (r2 == 0) goto L_0x001b
            r2.close()     // Catch:{ IOException -> 0x002f }
        L_0x001b:
            r0 = r1
            goto L_0x0007
        L_0x001d:
            r1 = move-exception
            r1 = r0
        L_0x001f:
            if (r1 == 0) goto L_0x0007
            r1.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0007
        L_0x0025:
            r1 = move-exception
            goto L_0x0007
        L_0x0027:
            r1 = move-exception
            r2 = r0
        L_0x0029:
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x0031 }
        L_0x002e:
            throw r1
        L_0x002f:
            r0 = move-exception
            goto L_0x001b
        L_0x0031:
            r0 = move-exception
            goto L_0x002e
        L_0x0033:
            r0 = move-exception
            r1 = r0
            goto L_0x0029
        L_0x0036:
            r1 = move-exception
            r1 = r2
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.b.g.b(com.tencent.mm.vfs.o):java.lang.String");
    }
}
