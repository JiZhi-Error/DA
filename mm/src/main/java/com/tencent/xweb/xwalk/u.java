package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class u {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063 A[SYNTHETIC, Splitter:B:21:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e A[SYNTHETIC, Splitter:B:32:0x007e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File[] r8, java.lang.String r9, int r10) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.u.a(java.io.File[], java.lang.String, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081 A[SYNTHETIC, Splitter:B:24:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f A[SYNTHETIC, Splitter:B:34:0x009f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean j(java.io.File r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.u.j(java.io.File, java.lang.String):boolean");
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str) {
        AppMethodBeat.i(154505);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        a(zipOutputStream, file2, file.getName() + File.separator + file2.getName() + File.separator);
                    } else {
                        a(zipOutputStream, file2, str);
                    }
                }
            }
            AppMethodBeat.o(154505);
            return;
        }
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                AppMethodBeat.o(154505);
                return;
            }
        }
    }

    private static void ch(String str, String str2) {
        AppMethodBeat.i(154507);
        String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
        if (split.length <= 1) {
            AppMethodBeat.o(154507);
            return;
        }
        for (int i2 = 0; i2 < split.length - 1; i2++) {
            str2 = str2 + split[i2] + FilePathGenerator.ANDROID_DIR_SEP;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        AppMethodBeat.o(154507);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A[SYNTHETIC, Splitter:B:23:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d A[Catch:{ IOException -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00de A[SYNTHETIC, Splitter:B:48:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e6 A[Catch:{ IOException -> 0x00ed }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean cg(java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.u.cg(java.lang.String, java.lang.String):boolean");
    }
}
