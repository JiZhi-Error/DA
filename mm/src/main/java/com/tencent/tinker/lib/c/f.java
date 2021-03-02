package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.c.b.b;
import com.tencent.tinker.d.a.e;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.d.a.j;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class f extends c {
    static boolean c(Context context, String str, String str2, File file) {
        h hVar;
        h hVar2;
        i iVar;
        h hVar3;
        int i2;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.parseAllResPatchInfo(str2, shareResPatchInfo);
        ShareTinkerLog.i("Tinker.ResDiffPatchInternal", "res dir: %s, meta: %s", str, shareResPatchInfo.toString());
        a lk = a.lk(context);
        if (!SharePatchFileUtil.checkIfMd5Valid(shareResPatchInfo.resArscMd5)) {
            ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, md5: %s", ShareTinkerInternals.getTypeString(6), shareResPatchInfo.resArscMd5);
            lk.SjV.e(file, c.asu(6));
            return false;
        }
        File file2 = new File(str);
        File file3 = new File(file2, "res_temp");
        File file4 = new File(file2, ShareConstants.RES_NAME);
        if (!file4.exists()) {
            file4.getParentFile().mkdirs();
        } else if (SharePatchFileUtil.checkResourceArscMd5(file4, shareResPatchInfo.resArscMd5)) {
            ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "resource file %s is already exist, and md5 match, just return true", file4.getPath());
            return true;
        } else {
            ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "have a mismatch corrupted resource " + file4.getPath(), new Object[0]);
            file4.delete();
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                return false;
            }
            String str3 = applicationInfo.sourceDir;
            if (!a(context, str3, file2, file3, file, shareResPatchInfo)) {
                return false;
            }
            try {
                iVar = new i(new BufferedOutputStream(new FileOutputStream(file4)));
                try {
                    hVar3 = new h(str3);
                } catch (Throwable th) {
                    th = th;
                    hVar = null;
                    hVar2 = null;
                    b.closeQuietly(iVar);
                    b.closeQuietly(hVar2);
                    b.closeQuietly(hVar);
                    SharePatchFileUtil.deleteDir(file3);
                    throw th;
                }
                try {
                    h hVar4 = new h(file);
                    try {
                        Enumeration<? extends g> entries = hVar3.entries();
                        int i3 = 0;
                        while (entries.hasMoreElements()) {
                            g gVar = (g) entries.nextElement();
                            if (gVar == null) {
                                throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                            }
                            String str4 = gVar.name;
                            if (!str4.contains("../")) {
                                if (!ShareResPatchInfo.checkFileInPattern(shareResPatchInfo.patterns, str4) || shareResPatchInfo.deleteRes.contains(str4) || shareResPatchInfo.modRes.contains(str4) || shareResPatchInfo.largeModRes.contains(str4) || str4.equals(ShareConstants.RES_MANIFEST)) {
                                    i2 = i3;
                                } else {
                                    j.a(hVar3, gVar, iVar);
                                    i2 = i3 + 1;
                                }
                                i3 = i2;
                            }
                        }
                        g bqM = hVar3.bqM(ShareConstants.RES_MANIFEST);
                        if (bqM == null) {
                            ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "manifest patch entry is null. path:AndroidManifest.xml", new Object[0]);
                            lk.SjV.a(file, file4, ShareConstants.RES_MANIFEST, 6);
                            b.closeQuietly(iVar);
                            b.closeQuietly(hVar3);
                            b.closeQuietly(hVar4);
                            SharePatchFileUtil.deleteDir(file3);
                            return false;
                        }
                        j.a(hVar3, bqM, iVar);
                        int i4 = i3 + 1;
                        Iterator<String> it = shareResPatchInfo.largeModRes.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            g bqM2 = hVar3.bqM(next);
                            if (bqM2 == null) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "large patch entry is null. path:".concat(String.valueOf(next)), new Object[0]);
                                lk.SjV.a(file, file4, next, 6);
                                b.closeQuietly(iVar);
                                b.closeQuietly(hVar3);
                                b.closeQuietly(hVar4);
                                SharePatchFileUtil.deleteDir(file3);
                                return false;
                            }
                            ShareResPatchInfo.LargeModeInfo largeModeInfo = shareResPatchInfo.largeModMap.get(next);
                            j.a(bqM2, largeModeInfo.file, largeModeInfo.crc, iVar);
                            i4++;
                        }
                        Iterator<String> it2 = shareResPatchInfo.addRes.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            g bqM3 = hVar4.bqM(next2);
                            if (bqM3 == null) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "add patch entry is null. path:".concat(String.valueOf(next2)), new Object[0]);
                                lk.SjV.a(file, file4, next2, 6);
                                b.closeQuietly(iVar);
                                b.closeQuietly(hVar3);
                                b.closeQuietly(hVar4);
                                SharePatchFileUtil.deleteDir(file3);
                                return false;
                            }
                            if (shareResPatchInfo.storeRes.containsKey(next2)) {
                                j.a(bqM3, shareResPatchInfo.storeRes.get(next2), bqM3.crc, iVar);
                            } else {
                                j.a(hVar4, bqM3, iVar);
                            }
                            i4++;
                        }
                        Iterator<String> it3 = shareResPatchInfo.modRes.iterator();
                        while (it3.hasNext()) {
                            String next3 = it3.next();
                            g bqM4 = hVar4.bqM(next3);
                            if (bqM4 == null) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "mod patch entry is null. path:".concat(String.valueOf(next3)), new Object[0]);
                                lk.SjV.a(file, file4, next3, 6);
                                b.closeQuietly(iVar);
                                b.closeQuietly(hVar3);
                                b.closeQuietly(hVar4);
                                SharePatchFileUtil.deleteDir(file3);
                                return false;
                            }
                            if (shareResPatchInfo.storeRes.containsKey(next3)) {
                                j.a(bqM4, shareResPatchInfo.storeRes.get(next3), bqM4.crc, iVar);
                            } else {
                                j.a(hVar4, bqM4, iVar);
                            }
                            i4++;
                        }
                        hVar3.oa();
                        String str5 = hVar3.KJM;
                        if (str5 == null) {
                            iVar.Sky = i.SkU;
                        } else {
                            byte[] bytes = str5.getBytes(e.UTF_8);
                            i.D("Comment", bytes);
                            iVar.Sky = bytes;
                        }
                        b.closeQuietly(iVar);
                        b.closeQuietly(hVar3);
                        b.closeQuietly(hVar4);
                        SharePatchFileUtil.deleteDir(file3);
                        if (!SharePatchFileUtil.checkResourceArscMd5(file4, shareResPatchInfo.resArscMd5)) {
                            ShareTinkerLog.i("Tinker.ResDiffPatchInternal", "check final new resource file fail path:%s, entry count:%d, size:%d", file4.getAbsolutePath(), Integer.valueOf(i4), Long.valueOf(file4.length()));
                            SharePatchFileUtil.safeDeleteFile(file4);
                            lk.SjV.a(file, file4, ShareConstants.RES_NAME, 6);
                            return false;
                        }
                        ShareTinkerLog.i("Tinker.ResDiffPatchInternal", "final new resource file:%s, entry count:%d, size:%d", file4.getAbsolutePath(), Integer.valueOf(i4), Long.valueOf(file4.length()));
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        hVar = hVar4;
                        hVar2 = hVar3;
                        b.closeQuietly(iVar);
                        b.closeQuietly(hVar2);
                        b.closeQuietly(hVar);
                        SharePatchFileUtil.deleteDir(file3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    hVar = null;
                    hVar2 = hVar3;
                    b.closeQuietly(iVar);
                    b.closeQuietly(hVar2);
                    b.closeQuietly(hVar);
                    SharePatchFileUtil.deleteDir(file3);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                hVar = null;
                hVar2 = null;
                iVar = null;
                b.closeQuietly(iVar);
                b.closeQuietly(hVar2);
                b.closeQuietly(hVar);
                SharePatchFileUtil.deleteDir(file3);
                throw th;
            }
        } catch (Throwable th5) {
            throw new TinkerRuntimeException("patch " + ShareTinkerInternals.getTypeString(6) + " extract failed (" + th5.getMessage() + ").", th5);
        }
    }

    private static boolean a(Context context, String str, File file, File file2, File file3, ShareResPatchInfo shareResPatchInfo) {
        ZipFile zipFile;
        ZipFile zipFile2;
        InputStream inputStream;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        a lk = a.lk(context);
        ZipFile zipFile3 = null;
        ZipFile zipFile4 = null;
        try {
            zipFile2 = new ZipFile(str);
            try {
                ZipEntry entry = zipFile2.getEntry(ShareConstants.RES_ARSC);
                File file4 = new File(file, ShareConstants.RES_ARSC);
                if (entry == null) {
                    ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:resources.arsc", new Object[0]);
                    lk.SjV.a(file3, file4, ShareConstants.RES_ARSC, 6);
                    SharePatchFileUtil.closeZip(zipFile2);
                    SharePatchFileUtil.closeZip(null);
                    return false;
                }
                String valueOf = String.valueOf(entry.getCrc());
                if (!valueOf.equals(shareResPatchInfo.arscBaseCrc)) {
                    ShareTinkerLog.e("Tinker.ResDiffPatchInternal", "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", shareResPatchInfo.arscBaseCrc, valueOf);
                    lk.SjV.a(file3, file4, ShareConstants.RES_ARSC, 6);
                    SharePatchFileUtil.closeZip(zipFile2);
                    SharePatchFileUtil.closeZip(null);
                    return false;
                } else if (!shareResPatchInfo.largeModRes.isEmpty() || !shareResPatchInfo.storeRes.isEmpty()) {
                    zipFile = new ZipFile(file3);
                    try {
                        for (String str2 : shareResPatchInfo.storeRes.keySet()) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            File file5 = new File(file2, str2);
                            SharePatchFileUtil.ensureFileDirectory(file5);
                            ZipEntry entry2 = zipFile.getEntry(str2);
                            if (entry2 == null) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "store patch entry is null. path:".concat(String.valueOf(str2)), new Object[0]);
                                lk.SjV.a(file3, file5, str2, 6);
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile);
                                return false;
                            }
                            a(zipFile, entry2, file5, null, false);
                            if (entry2.getSize() != file5.length()) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "resource meta file size mismatch, type:%s, name: %s, patch size: %d, file size; %d", ShareTinkerInternals.getTypeString(6), str2, Long.valueOf(entry2.getSize()), Long.valueOf(file5.length()));
                                lk.SjV.e(file3, c.asu(6));
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile);
                                return false;
                            }
                            shareResPatchInfo.storeRes.put(str2, file5);
                            ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "success recover store file:%s, file size:%d, use time:%d", file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        }
                        Iterator<String> it = shareResPatchInfo.largeModRes.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            long currentTimeMillis3 = System.currentTimeMillis();
                            ShareResPatchInfo.LargeModeInfo largeModeInfo = shareResPatchInfo.largeModMap.get(next);
                            if (largeModeInfo == null) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "resource not found largeModeInfo, type:%s, name: %s", ShareTinkerInternals.getTypeString(6), next);
                                lk.SjV.e(file3, c.asu(6));
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile);
                                return false;
                            }
                            largeModeInfo.file = new File(file2, next);
                            SharePatchFileUtil.ensureFileDirectory(largeModeInfo.file);
                            if (!SharePatchFileUtil.checkIfMd5Valid(largeModeInfo.md5)) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(6), next, largeModeInfo.md5);
                                lk.SjV.e(file3, c.asu(6));
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile);
                                return false;
                            }
                            ZipEntry entry3 = zipFile.getEntry(next);
                            if (entry3 == null) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "large mod patch entry is null. path:".concat(String.valueOf(next)), new Object[0]);
                                lk.SjV.a(file3, largeModeInfo.file, next, 6);
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile);
                                return false;
                            }
                            ZipEntry entry4 = zipFile2.getEntry(next);
                            if (entry4 == null) {
                                ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:".concat(String.valueOf(next)), new Object[0]);
                                lk.SjV.a(file3, largeModeInfo.file, next, 6);
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile);
                                return false;
                            }
                            InputStream inputStream2 = null;
                            try {
                                inputStream2 = zipFile2.getInputStream(entry4);
                                InputStream inputStream3 = zipFile.getInputStream(entry3);
                                try {
                                    com.tencent.tinker.b.a.a(inputStream2, inputStream3, largeModeInfo.file);
                                    b.closeQuietly(inputStream2);
                                    b.closeQuietly(inputStream3);
                                    if (!SharePatchFileUtil.verifyFileMd5(largeModeInfo.file, largeModeInfo.md5)) {
                                        ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "Failed to recover large modify file:%s", largeModeInfo.file.getPath());
                                        SharePatchFileUtil.safeDeleteFile(largeModeInfo.file);
                                        lk.SjV.a(file3, largeModeInfo.file, next, 6);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile);
                                        return false;
                                    }
                                    ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "success recover large modify file:%s, file size:%d, use time:%d", largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = inputStream3;
                                    b.closeQuietly(inputStream2);
                                    b.closeQuietly(inputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                                b.closeQuietly(inputStream2);
                                b.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                        ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "success recover all large modify and store resources use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile);
                        return true;
                    } catch (Throwable th4) {
                        th = th4;
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile);
                        throw th;
                    }
                } else {
                    ShareTinkerLog.i("Tinker.ResDiffPatchInternal", "no large modify or store resources, just return", new Object[0]);
                    SharePatchFileUtil.closeZip(zipFile2);
                    SharePatchFileUtil.closeZip(null);
                    return true;
                }
            } catch (Throwable th5) {
                th = th5;
                zipFile = null;
                SharePatchFileUtil.closeZip(zipFile2);
                SharePatchFileUtil.closeZip(zipFile);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile = null;
            zipFile2 = null;
            SharePatchFileUtil.closeZip(zipFile2);
            SharePatchFileUtil.closeZip(zipFile);
            throw th;
        }
    }
}
