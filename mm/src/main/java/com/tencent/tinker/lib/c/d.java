package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.c.b.b;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class d extends c {
    /* JADX INFO: finally extract failed */
    static boolean a(Context context, String str, String str2, File file) {
        ZipFile zipFile;
        ZipFile zipFile2;
        String str3;
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.parseDiffPatchInfo(str2, arrayList);
        if (arrayList.isEmpty()) {
            ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "extract patch list is empty! type:%s:", ShareTinkerInternals.getTypeString(5));
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        a lk = a.lk(context);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
            return false;
        }
        ZipFile zipFile3 = null;
        ZipFile zipFile4 = null;
        try {
            zipFile2 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
                zipFile = null;
                SharePatchFileUtil.closeZip(zipFile2);
                SharePatchFileUtil.closeZip(zipFile);
                throw th;
            }
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (shareBsDiffPatchInfo.path.equals("")) {
                        str3 = shareBsDiffPatchInfo.name;
                    } else {
                        str3 = shareBsDiffPatchInfo.path + FilePathGenerator.ANDROID_DIR_SEP + shareBsDiffPatchInfo.name;
                    }
                    String str4 = shareBsDiffPatchInfo.md5;
                    if (!SharePatchFileUtil.checkIfMd5Valid(str4)) {
                        ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(5), shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.md5);
                        lk.SjV.e(file, c.asu(5));
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile);
                        return false;
                    }
                    File file3 = new File(str + (shareBsDiffPatchInfo.path + FilePathGenerator.ANDROID_DIR_SEP + shareBsDiffPatchInfo.name));
                    if (!file3.exists()) {
                        file3.getParentFile().mkdirs();
                    } else if (str4.equals(SharePatchFileUtil.getMD5(file3))) {
                        ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "bsdiff file %s is already exist, and md5 match, just continue", file3.getPath());
                    } else {
                        ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                        file3.delete();
                    }
                    String str5 = shareBsDiffPatchInfo.patchMd5;
                    ZipEntry entry = zipFile.getEntry(str3);
                    if (entry == null) {
                        ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                        lk.SjV.a(file, file3, shareBsDiffPatchInfo.name, 5);
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile);
                        return false;
                    } else if (str5.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        if (!a(zipFile, entry, file3, str4, false)) {
                            ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "Failed to extract file " + file3.getPath(), new Object[0]);
                            lk.SjV.a(file, file3, shareBsDiffPatchInfo.name, 5);
                            SharePatchFileUtil.closeZip(zipFile2);
                            SharePatchFileUtil.closeZip(zipFile);
                            return false;
                        }
                    } else if (!SharePatchFileUtil.checkIfMd5Valid(str5)) {
                        ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(5), shareBsDiffPatchInfo.name, str5);
                        lk.SjV.e(file, c.asu(5));
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile);
                        return false;
                    } else {
                        ZipEntry entry2 = zipFile2.getEntry(str3);
                        if (entry2 == null) {
                            ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                            lk.SjV.a(file, file3, shareBsDiffPatchInfo.name, 5);
                            SharePatchFileUtil.closeZip(zipFile2);
                            SharePatchFileUtil.closeZip(zipFile);
                            return false;
                        }
                        String str6 = shareBsDiffPatchInfo.rawCrc;
                        String valueOf = String.valueOf(entry2.getCrc());
                        if (!valueOf.equals(str6)) {
                            ShareTinkerLog.e("Tinker.BsDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str6, valueOf);
                            lk.SjV.a(file, file3, shareBsDiffPatchInfo.name, 5);
                            SharePatchFileUtil.closeZip(zipFile2);
                            SharePatchFileUtil.closeZip(zipFile);
                            return false;
                        }
                        InputStream inputStream = null;
                        InputStream inputStream2 = null;
                        try {
                            inputStream = zipFile2.getInputStream(entry2);
                            inputStream2 = zipFile.getInputStream(entry);
                            com.tencent.tinker.b.a.a(inputStream, inputStream2, file3);
                            b.closeQuietly(inputStream);
                            b.closeQuietly(inputStream2);
                            if (!SharePatchFileUtil.verifyFileMd5(file3, str4)) {
                                ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "Failed to recover diff file " + file3.getPath(), new Object[0]);
                                lk.SjV.a(file, file3, shareBsDiffPatchInfo.name, 5);
                                SharePatchFileUtil.safeDeleteFile(file3);
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile);
                                return false;
                            }
                            ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "success recover bsdiff file: %s, use time: %d", file3.getPath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        } catch (Throwable th2) {
                            b.closeQuietly(inputStream);
                            b.closeQuietly(inputStream2);
                            throw th2;
                        }
                    }
                }
                SharePatchFileUtil.closeZip(zipFile2);
                SharePatchFileUtil.closeZip(zipFile);
                return true;
            } catch (Throwable th3) {
                th = th3;
                SharePatchFileUtil.closeZip(zipFile2);
                SharePatchFileUtil.closeZip(zipFile);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            zipFile2 = null;
            SharePatchFileUtil.closeZip(zipFile2);
            SharePatchFileUtil.closeZip(zipFile);
            throw th;
        }
    }
}
