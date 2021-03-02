package com.tencent.tinker.lib.c;

import com.tencent.tinker.c.b.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class c {
    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < 2 && !z2) {
            int i3 = i2 + 1;
            ShareTinkerLog.i("Tinker.BasePatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                    b.closeQuietly(bufferedOutputStream);
                    b.closeQuietly(bufferedInputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                    b.closeQuietly(bufferedOutputStream2);
                    b.closeQuietly(bufferedInputStream);
                    if (str != null) {
                        z2 = z ? SharePatchFileUtil.verifyDexFileMd5(file, str) : SharePatchFileUtil.verifyFileMd5(file, str);
                    } else {
                        z2 = true;
                    }
                    ShareTinkerLog.i("Tinker.BasePatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z2));
                    if (!z2 && (!file.delete() || file.exists())) {
                        ShareTinkerLog.e("Tinker.BasePatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                    }
                    i2 = i3;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    b.closeQuietly(bufferedOutputStream);
                    b.closeQuietly(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedInputStream = null;
                b.closeQuietly(bufferedOutputStream);
                b.closeQuietly(bufferedInputStream);
                throw th;
            }
        }
        return z2;
    }

    public static int asu(int i2) {
        if (i2 == 3) {
            return -3;
        }
        if (i2 == 5) {
            return -4;
        }
        if (i2 == 6) {
            return -8;
        }
        return 0;
    }
}
