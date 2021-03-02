package com.tencent.liteav.basic.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c {
    public static boolean a(Context context) {
        AppMethodBeat.i(14711);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(14711);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            AppMethodBeat.o(14711);
            return false;
        }
        AppMethodBeat.o(14711);
        return true;
    }

    public static boolean a(long j2) {
        AppMethodBeat.i(14713);
        AppMethodBeat.o(14713);
        return true;
    }

    public static long a(File file) {
        AppMethodBeat.i(222121);
        long a2 = a(file, 5);
        AppMethodBeat.o(222121);
        return a2;
    }

    public static long a(File file, int i2) {
        long length;
        long j2 = 0;
        AppMethodBeat.i(222122);
        if (i2 <= 0) {
            AppMethodBeat.o(222122);
        } else {
            try {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        length = a(file2, i2 - 1);
                    } else {
                        length = file2.length();
                    }
                    j2 += length;
                }
            } catch (Exception e2) {
                TXCLog.i("FileUtil", "getFolderSize exception " + e2.toString());
            }
            AppMethodBeat.o(222122);
        }
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[SYNTHETIC, Splitter:B:20:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A[SYNTHETIC, Splitter:B:29:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.c.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(222124);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(222124);
                return;
            }
        }
    }

    public static boolean a(String str) {
        AppMethodBeat.i(14714);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(14714);
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            AppMethodBeat.o(14714);
            return false;
        }
        AppMethodBeat.o(14714);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a A[SYNTHETIC, Splitter:B:18:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.c.b(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035 A[SYNTHETIC, Splitter:B:18:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a A[Catch:{ Exception -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b A[SYNTHETIC, Splitter:B:28:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0050 A[Catch:{ Exception -> 0x0057 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r6, byte[] r7) {
        /*
            r2 = 0
            r5 = 14716(0x397c, float:2.0622E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0027, all -> 0x0046 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x0027, all -> 0x0046 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0027, all -> 0x0046 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0027, all -> 0x0046 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x005e, all -> 0x0059 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x005e, all -> 0x0059 }
            r3.write(r7)     // Catch:{ Exception -> 0x0061 }
            r3.close()     // Catch:{ Exception -> 0x0022 }
            r1.close()     // Catch:{ Exception -> 0x0022 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0021:
            return
        L_0x0022:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0021
        L_0x0027:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x002a:
            java.lang.String r2 = "FileUtil"
            java.lang.String r4 = "write file failed."
            com.tencent.liteav.basic.log.TXCLog.e(r2, r4, r0)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x0038
            r3.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ Exception -> 0x0041 }
        L_0x003d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0021
        L_0x0041:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0021
        L_0x0046:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x0049:
            if (r3 == 0) goto L_0x004e
            r3.close()     // Catch:{ Exception -> 0x0057 }
        L_0x004e:
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0053:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x0057:
            r1 = move-exception
            goto L_0x0053
        L_0x0059:
            r0 = move-exception
            r3 = r2
            goto L_0x0049
        L_0x005c:
            r0 = move-exception
            goto L_0x0049
        L_0x005e:
            r0 = move-exception
            r3 = r2
            goto L_0x002a
        L_0x0061:
            r0 = move-exception
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.c.a(java.lang.String, byte[]):void");
    }

    public static boolean a(Context context, String str) {
        String[] list;
        AppMethodBeat.i(14717);
        try {
            for (String str2 : context.getAssets().list("")) {
                if (str2.equals(str.trim())) {
                    TXCLog.i("isAssetFileExists", str + " exist");
                    AppMethodBeat.o(14717);
                    return true;
                }
            }
            TXCLog.i("isAssetFileExists", str + " not exist");
            AppMethodBeat.o(14717);
            return false;
        } catch (IOException e2) {
            TXCLog.i("isAssetFileExists", str + " not exist");
            AppMethodBeat.o(14717);
            return false;
        }
    }

    public static String b(Context context, String str) {
        AppMethodBeat.i(14718);
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            if (open.read(bArr) <= 0) {
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(14718);
                return "";
            }
            open.close();
            String str2 = new String(bArr, ProtocolPackage.ServerEncoding);
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(14718);
            return str2;
        } catch (IOException e4) {
            TXCLog.e("FileUtil", "read asset file failed.", e4);
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(14718);
            return "";
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(14718);
            throw th;
        }
    }

    public static void a(Closeable closeable) {
        AppMethodBeat.i(14719);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                AppMethodBeat.o(14719);
                return;
            }
        }
        AppMethodBeat.o(14719);
    }
}
