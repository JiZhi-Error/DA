package com.tencent.mm.plugin.hp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.io.RandomAccessFile;

public final class b {
    public static int a(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(117378);
        if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(117378);
            return -1;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            s.boN(s.boZ(str3));
            File file3 = new File(str2);
            if (!file.exists() || !file3.exists()) {
                Log.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", Boolean.valueOf(file.exists()), Boolean.valueOf(file2.exists()), Boolean.valueOf(file3.exists()));
                randomAccessFile.close();
                AppMethodBeat.o(117378);
                return -1;
            }
            int i2 = 0;
            a fO = a.fO(str);
            if (!(fO == null || fO.dje == null)) {
                i2 = fO.dje.djh + 8;
                Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", Integer.valueOf(i2));
            }
            if (d.a(randomAccessFile, file2, file3, i2) != 1) {
                Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                randomAccessFile.close();
                AppMethodBeat.o(117378);
                return -1;
            }
            randomAccessFile.close();
            if (!str4.equalsIgnoreCase(s.bhK(str3))) {
                Log.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", str4, s.bhK(str3));
                AppMethodBeat.o(117378);
                return -2;
            }
            com.tencent.mm.d.b bVar = new com.tencent.mm.d.b();
            bVar.apkMd5 = str4;
            new a(bVar).A(file2);
            AppMethodBeat.o(117378);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", e2, "merge apk failed.", new Object[0]);
            AppMethodBeat.o(117378);
            return -1;
        }
    }

    public static int t(String str, String str2, String str3, String str4) {
        int i2;
        AppMethodBeat.i(196770);
        if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(196770);
            return -5;
        }
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            File file2 = new File(str3);
            s.boN(s.boZ(str3));
            File file3 = new File(str2);
            if (!file.exists() || !file3.exists()) {
                Log.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", Boolean.valueOf(file.exists()), Boolean.valueOf(file2.exists()), Boolean.valueOf(file3.exists()));
                randomAccessFile.close();
                AppMethodBeat.o(196770);
                return -1;
            }
            a fO = a.fO(str);
            if (fO == null || fO.dje == null) {
                i2 = 0;
            } else {
                i2 = fO.dje.djh + 8;
                Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", Integer.valueOf(i2));
            }
            if (d.a(randomAccessFile, file2, file3, i2) != 1) {
                Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
                randomAccessFile.close();
                AppMethodBeat.o(196770);
                return -2;
            }
            randomAccessFile.close();
            if (!str4.equalsIgnoreCase(s.bhK(str3))) {
                Log.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", str4, s.bhK(str3));
                AppMethodBeat.o(196770);
                return -3;
            }
            com.tencent.mm.d.b bVar = new com.tencent.mm.d.b();
            bVar.apkMd5 = str4;
            new a(bVar).A(file2);
            AppMethodBeat.o(196770);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", e2, "merge apk failed.", new Object[0]);
            AppMethodBeat.o(196770);
            return -4;
        }
    }
}
