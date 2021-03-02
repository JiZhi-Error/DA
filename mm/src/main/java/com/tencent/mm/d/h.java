package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.RandomAccessFile;

public final class h {
    public static int a(String str, String str2, String str3, String str4) {
        int i2;
        AppMethodBeat.i(966);
        if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(966);
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            File file3 = new File(str2);
            if (!file.exists() || !file3.exists()) {
                System.err.println("MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=" + file.exists() + ", newFile.exists()=" + file2.exists() + ", patch.exists()=" + file3.exists());
                randomAccessFile.close();
                AppMethodBeat.o(966);
                return -1;
            }
            a fO = a.fO(str);
            if (fO == null || fO.dje == null) {
                i2 = 0;
            } else {
                i2 = fO.dje.djh + 8;
                System.out.println("MicroMsg.MergePatchApk:extLen = ".concat(String.valueOf(i2)));
            }
            if (d.a(randomAccessFile, file2, file3, i2) != 1) {
                System.out.println("MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                randomAccessFile.close();
                AppMethodBeat.o(966);
                return -1;
            }
            randomAccessFile.close();
            if (!str4.equalsIgnoreCase(g.getMD5(str3))) {
                AppMethodBeat.o(966);
                return -2;
            }
            b bVar = new b();
            bVar.apkMd5 = str4;
            new a(bVar).A(file2);
            AppMethodBeat.o(966);
            return 0;
        } catch (Exception e2) {
            System.out.println("MicroMsg.MergePatchApk:Exception in merge()");
            AppMethodBeat.o(966);
            return -1;
        }
    }
}
