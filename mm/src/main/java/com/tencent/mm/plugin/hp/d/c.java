package com.tencent.mm.plugin.hp.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class c {

    public interface a {
        void a(boolean z, b bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean dZz() {
        /*
            r2 = 0
            r8 = 117522(0x1cb12, float:1.64683E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            java.io.File r0 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x003b }
            android.os.StatFs r4 = new android.os.StatFs     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x003b }
            r4.<init>(r0)     // Catch:{ Exception -> 0x003b }
            int r0 = r4.getAvailableBlocks()     // Catch:{ Exception -> 0x003b }
            long r0 = (long) r0     // Catch:{ Exception -> 0x003b }
            int r5 = r4.getBlockSize()     // Catch:{ Exception -> 0x003b }
            long r6 = (long) r5
            long r0 = r0 * r6
            int r5 = r4.getBlockCount()     // Catch:{ Exception -> 0x0044 }
            long r6 = (long) r5     // Catch:{ Exception -> 0x0044 }
            int r4 = r4.getBlockSize()     // Catch:{ Exception -> 0x0044 }
            long r4 = (long) r4
            long r4 = r4 * r6
        L_0x002b:
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x003f
            r2 = 83886080(0x5000000, double:4.14452303E-316)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x003f
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
        L_0x003a:
            return r0
        L_0x003b:
            r0 = move-exception
            r0 = r2
        L_0x003d:
            r4 = r2
            goto L_0x002b
        L_0x003f:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            goto L_0x003a
        L_0x0044:
            r4 = move-exception
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hp.d.c.dZz():boolean");
    }

    public static boolean aBK(String str) {
        AppMethodBeat.i(117523);
        if (!Util.isNullOrNil(str) && str.length() == 10) {
            try {
                int intValue = Integer.decode(str).intValue();
                if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                    AppMethodBeat.o(117523);
                    return false;
                }
                AppMethodBeat.o(117523);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("Tinker.TinkerUtils", e2, "checkAplhVersion failed.", new Object[0]);
            }
        }
        AppMethodBeat.o(117523);
        return false;
    }

    public static String aBL(String str) {
        AppMethodBeat.i(117524);
        if (!Util.isNullOrNil(str)) {
            String str2 = new String(Base64.decode(str, 0));
            AppMethodBeat.o(117524);
            return str2;
        }
        AppMethodBeat.o(117524);
        return "";
    }

    public static Properties fastGetPatchPackageMeta(File file) {
        ZipFile zipFile;
        ZipFile zipFile2;
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        AppMethodBeat.i(117525);
        if (!file.isFile() || file.length() == 0) {
            AppMethodBeat.o(117525);
            return null;
        }
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(ShareConstants.PACKAGE_META_FILE);
                if (entry == null) {
                    SharePatchFileUtil.closeZip(zipFile2);
                    AppMethodBeat.o(117525);
                    return null;
                }
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.closeQuietly(inputStream);
                        SharePatchFileUtil.closeZip(zipFile2);
                        AppMethodBeat.o(117525);
                        return properties;
                    } catch (Throwable th3) {
                        th2 = th3;
                        SharePatchFileUtil.closeQuietly(inputStream);
                        AppMethodBeat.o(117525);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    inputStream = null;
                    SharePatchFileUtil.closeQuietly(inputStream);
                    AppMethodBeat.o(117525);
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
                try {
                    new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                    SharePatchFileUtil.closeZip(zipFile);
                    AppMethodBeat.o(117525);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile2 = zipFile;
                    SharePatchFileUtil.closeZip(zipFile2);
                    AppMethodBeat.o(117525);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                SharePatchFileUtil.closeZip(zipFile2);
                AppMethodBeat.o(117525);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
            SharePatchFileUtil.closeZip(zipFile);
            AppMethodBeat.o(117525);
            return null;
        } catch (Throwable th7) {
            th = th7;
            zipFile2 = null;
            SharePatchFileUtil.closeZip(zipFile2);
            AppMethodBeat.o(117525);
            throw th;
        }
    }
}
