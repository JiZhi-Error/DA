package com.tencent.recovery.wx.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    public static byte[] readFromStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        int i2 = 0;
        while (true) {
            try {
                i2 = inputStream.read(bArr, 0, 1024);
            } catch (IOException e2) {
            }
            if (i2 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017 A[SYNTHETIC, Splitter:B:10:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC, Splitter:B:16:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readStringFromFile(java.io.File r4) {
        /*
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0013, all -> 0x001c }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0013, all -> 0x001c }
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            byte[] r3 = readFromStream(r2)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r0.<init>(r3)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r2.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0012:
            return r0
        L_0x0013:
            r0 = move-exception
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()     // Catch:{ IOException -> 0x0026 }
        L_0x001a:
            r0 = r1
            goto L_0x0012
        L_0x001c:
            r0 = move-exception
            r2 = r1
        L_0x001e:
            if (r2 == 0) goto L_0x0023
            r2.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0023:
            throw r0
        L_0x0024:
            r1 = move-exception
            goto L_0x0012
        L_0x0026:
            r0 = move-exception
            goto L_0x001a
        L_0x0028:
            r1 = move-exception
            goto L_0x0023
        L_0x002a:
            r0 = move-exception
            goto L_0x001e
        L_0x002c:
            r0 = move-exception
            r0 = r2
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.util.FileUtil.readStringFromFile(java.io.File):java.lang.String");
    }
}
