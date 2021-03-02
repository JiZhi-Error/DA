package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.c.b.b;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class e extends c {
    private static ArrayList<File> SjC = new ArrayList<>();
    private static ArrayList<ShareDexDiffPatchInfo> SjD = new ArrayList<>();
    private static HashMap<ShareDexDiffPatchInfo, File> SjE = new HashMap<>();
    private static boolean isVmArt = ShareTinkerInternals.isVmArt();

    protected static boolean a(File file, a aVar) {
        TinkerRuntimeException tinkerRuntimeException;
        boolean z;
        ShareElfFile shareElfFile = null;
        if (SjC.isEmpty()) {
            return true;
        }
        int size = SjD.size() * 30;
        if (size > 120) {
            size = 120;
        }
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", Integer.valueOf(SjD.size()), Integer.valueOf(SjC.size()), Integer.valueOf(size));
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 + 1;
            Iterator<File> it = SjC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                File next = it.next();
                if (!(SharePatchFileUtil.isLegalFile(next) || SharePatchFileUtil.shouldAcceptEvenIfIllegal(next))) {
                    ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", next.getName(), Integer.valueOf(i3));
                    z = false;
                    break;
                }
            }
            if (!z) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e2) {
                    ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:".concat(String.valueOf(e2)), new Object[0]);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<File> it2 = SjC.iterator();
        while (it2.hasNext()) {
            File next2 = it2.next();
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", next2.getPath(), Long.valueOf(next2.length()));
            if (!SharePatchFileUtil.isLegalFile(next2) && !SharePatchFileUtil.shouldAcceptEvenIfIllegal(next2)) {
                ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", next2.getName());
                arrayList.add(next2);
            }
        }
        if (!arrayList.isEmpty()) {
            aVar.SjV.a(file, arrayList, new TinkerRuntimeException(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL));
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Iterator<File> it3 = SjC.iterator();
            Throwable th = shareElfFile;
            while (it3.hasNext()) {
                File next3 = it3.next();
                if (!SharePatchFileUtil.shouldAcceptEvenIfIllegal(next3)) {
                    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", next3.getName(), Long.valueOf(next3.length()));
                    try {
                        if (ShareElfFile.getFileTypeByMagic(next3) == 1) {
                            try {
                                shareElfFile = new ShareElfFile(next3);
                            } catch (Throwable th2) {
                                th = th2;
                                ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not elf format, return false", next3.getName());
                                arrayList.add(next3);
                            } finally {
                                b.closeQuietly(shareElfFile);
                            }
                        }
                    } catch (IOException e3) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                if (th == null) {
                    tinkerRuntimeException = new TinkerRuntimeException(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL);
                } else {
                    tinkerRuntimeException = new TinkerRuntimeException(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL, th);
                }
                aVar.SjV.a(file, arrayList, tinkerRuntimeException);
                return false;
            }
        }
        return true;
    }

    private static boolean bqI(String str) {
        boolean z;
        if (SjD.isEmpty() || !isVmArt) {
            return false;
        }
        Iterator<ShareDexDiffPatchInfo> it = SjD.iterator();
        File file = null;
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        while (it.hasNext()) {
            ShareDexDiffPatchInfo next = it.next();
            File file2 = new File(str + next.realName);
            if (ShareConstants.CLASS_N_PATTERN.matcher(file2.getName()).matches()) {
                SjE.put(next, file2);
            }
            if (!next.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                file2 = file;
                next = shareDexDiffPatchInfo;
            }
            file = file2;
            shareDexDiffPatchInfo = next;
        }
        if (shareDexDiffPatchInfo != null) {
            SjE.put(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, SjE.size() + 1), file);
        }
        File file3 = new File(str, ShareConstants.CLASS_N_APK_NAME);
        if (file3.exists()) {
            Iterator<ShareDexDiffPatchInfo> it2 = SjE.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                ShareDexDiffPatchInfo next2 = it2.next();
                if (!SharePatchFileUtil.verifyDexFileMd5(file3, next2.rawName, next2.destMd5InArt)) {
                    ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", next2.rawName, Long.valueOf(file3.length()));
                    z = false;
                    break;
                }
            }
            if (!z) {
                SharePatchFileUtil.safeDeleteFile(file3);
            }
        } else {
            z = false;
        }
        if (z) {
            for (File file4 : SjE.values()) {
                SharePatchFileUtil.safeDeleteFile(file4);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r16, java.io.File r17, java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 488
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.c.e.a(android.content.Context, java.io.File, java.lang.String):boolean");
    }

    private static boolean a(Context context, List<File> list, String str, File file, com.tencent.tinker.lib.service.a aVar) {
        a lk = a.lk(context);
        SjC.clear();
        File file2 = new File(str);
        if (file2.exists() || file2.mkdirs()) {
            for (File file3 : list) {
                SjC.add(new File(SharePatchFileUtil.optimizedPathFor(file3, file2)));
            }
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", Integer.valueOf(list.size()), str);
            final Vector vector = new Vector();
            final Throwable[] thArr = new Throwable[1];
            if (aVar != null) {
                aVar.SjK = System.currentTimeMillis();
            }
            final boolean[] zArr = {false};
            TinkerDexOptimizer.optimizeAll(context, list, file2, TinkerApplication.getInstance().isUseDelegateLastClassLoader(), new TinkerDexOptimizer.ResultCallback() {
                /* class com.tencent.tinker.lib.c.e.AnonymousClass1 */
                long startTime;

                @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                public final void onStart(File file, File file2) {
                    this.startTime = System.currentTimeMillis();
                    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", file.getPath(), Long.valueOf(file.length()));
                }

                @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                public final void onSuccess(File file, File file2, File file3) {
                    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", file.getPath(), file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - this.startTime));
                    if (!file3.exists()) {
                        synchronized (zArr) {
                            zArr[0] = true;
                        }
                    }
                }

                @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                public final void onFailed(File file, File file2, Throwable th) {
                    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime));
                    vector.add(file);
                    thArr[0] = th;
                }
            });
            if (aVar != null) {
                synchronized (zArr) {
                    aVar.SjL = !zArr[0];
                }
            }
            if (vector.isEmpty()) {
                return true;
            }
            lk.SjV.a(file, vector, thArr[0]);
            return false;
        }
        ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
        return false;
    }

    private static boolean b(Context context, String str, String str2, File file) {
        Throwable th;
        ZipFile zipFile;
        Throwable th2;
        ZipFile zipFile2;
        String str3;
        SjD.clear();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str2, SjD);
        if (SjD.isEmpty()) {
            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", ShareTinkerInternals.getTypeString(3));
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        a lk = a.lk(context);
        ZipFile zipFile3 = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                SharePatchFileUtil.closeZip(null);
                SharePatchFileUtil.closeZip(null);
                return false;
            }
            ZipFile zipFile4 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile2 = new ZipFile(file);
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = zipFile4;
                SharePatchFileUtil.closeZip(zipFile);
                SharePatchFileUtil.closeZip(zipFile3);
                throw th2;
            }
            try {
                if (bqI(str)) {
                    ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "class n dex file %s is already exist, and md5 match, just continue", ShareConstants.CLASS_N_APK_NAME);
                    SharePatchFileUtil.closeZip(zipFile4);
                    SharePatchFileUtil.closeZip(zipFile2);
                    return true;
                }
                Iterator<ShareDexDiffPatchInfo> it = SjD.iterator();
                while (it.hasNext()) {
                    ShareDexDiffPatchInfo next = it.next();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (next.path.equals("")) {
                        str3 = next.rawName;
                    } else {
                        str3 = next.path + FilePathGenerator.ANDROID_DIR_SEP + next.rawName;
                    }
                    String str4 = next.dexDiffMd5;
                    String str5 = next.oldDexCrC;
                    if (isVmArt || !next.destMd5InDvm.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        String str6 = isVmArt ? next.destMd5InArt : next.destMd5InDvm;
                        if (!SharePatchFileUtil.checkIfMd5Valid(str6)) {
                            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(3), next.rawName, str6);
                            lk.SjV.e(file, c.asu(3));
                            SharePatchFileUtil.closeZip(zipFile4);
                            SharePatchFileUtil.closeZip(zipFile2);
                            return false;
                        }
                        File file3 = new File(str + next.realName);
                        if (!file3.exists()) {
                            file3.getParentFile().mkdirs();
                        } else if (SharePatchFileUtil.verifyDexFileMd5(file3, str6)) {
                            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", file3.getPath());
                        } else {
                            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                            file3.delete();
                        }
                        ZipEntry entry = zipFile2.getEntry(str3);
                        ZipEntry entry2 = zipFile4.getEntry(str3);
                        if (str5.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            if (entry == null) {
                                ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                lk.SjV.a(file, file3, next.rawName, 3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                SharePatchFileUtil.closeZip(zipFile2);
                                return false;
                            } else if (!a(zipFile2, entry, file3, next)) {
                                ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                lk.SjV.a(file, file3, next.rawName, 3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                SharePatchFileUtil.closeZip(zipFile2);
                                return false;
                            }
                        } else if (str4.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            if (!isVmArt) {
                                continue;
                            } else if (entry2 == null) {
                                ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                                lk.SjV.a(file, file3, next.rawName, 3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                SharePatchFileUtil.closeZip(zipFile2);
                                return false;
                            } else {
                                String valueOf = String.valueOf(entry2.getCrc());
                                if (!valueOf.equals(str5)) {
                                    ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, valueOf);
                                    lk.SjV.a(file, file3, next.rawName, 3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    SharePatchFileUtil.closeZip(zipFile2);
                                    return false;
                                }
                                a(zipFile4, entry2, file3, next);
                                if (!SharePatchFileUtil.verifyDexFileMd5(file3, str6)) {
                                    ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                    lk.SjV.a(file, file3, next.rawName, 3);
                                    SharePatchFileUtil.safeDeleteFile(file3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    SharePatchFileUtil.closeZip(zipFile2);
                                    return false;
                                }
                            }
                        } else if (entry == null) {
                            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                            lk.SjV.a(file, file3, next.rawName, 3);
                            SharePatchFileUtil.closeZip(zipFile4);
                            SharePatchFileUtil.closeZip(zipFile2);
                            return false;
                        } else if (!SharePatchFileUtil.checkIfMd5Valid(str4)) {
                            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(3), next.rawName, str4);
                            lk.SjV.e(file, c.asu(3));
                            SharePatchFileUtil.closeZip(zipFile4);
                            SharePatchFileUtil.closeZip(zipFile2);
                            return false;
                        } else if (entry2 == null) {
                            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:".concat(String.valueOf(str3)), new Object[0]);
                            lk.SjV.a(file, file3, next.rawName, 3);
                            SharePatchFileUtil.closeZip(zipFile4);
                            SharePatchFileUtil.closeZip(zipFile2);
                            return false;
                        } else {
                            String valueOf2 = String.valueOf(entry2.getCrc());
                            if (!valueOf2.equals(str5)) {
                                ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, valueOf2);
                                lk.SjV.a(file, file3, next.rawName, 3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                SharePatchFileUtil.closeZip(zipFile2);
                                return false;
                            }
                            a(zipFile4, zipFile2, entry2, entry, next, file3);
                            if (!SharePatchFileUtil.verifyDexFileMd5(file3, str6)) {
                                ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                lk.SjV.a(file, file3, next.rawName, 3);
                                SharePatchFileUtil.safeDeleteFile(file3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                SharePatchFileUtil.closeZip(zipFile2);
                                return false;
                            }
                            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, size: %d, use time: %d", file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        }
                    } else {
                        ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", str3);
                    }
                }
                if (!a(context, file, str)) {
                    SharePatchFileUtil.closeZip(zipFile4);
                    SharePatchFileUtil.closeZip(zipFile2);
                    return false;
                }
                SharePatchFileUtil.closeZip(zipFile4);
                SharePatchFileUtil.closeZip(zipFile2);
                return true;
            } catch (Throwable th4) {
                th2 = th4;
                zipFile3 = zipFile2;
                zipFile = zipFile4;
                SharePatchFileUtil.closeZip(zipFile);
                SharePatchFileUtil.closeZip(zipFile3);
                throw th2;
            }
        } catch (Throwable th5) {
            th2 = th5;
            zipFile = null;
            SharePatchFileUtil.closeZip(zipFile);
            SharePatchFileUtil.closeZip(zipFile3);
            throw th2;
        }
    }

    private static boolean b(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        boolean z = false;
        int i2 = 0;
        while (i2 < 2 && !z) {
            int i3 = i2 + 1;
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    b.closeQuietly(bufferedInputStream);
                    b.closeQuietly(zipOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                    for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                    b.closeQuietly(bufferedInputStream);
                    b.closeQuietly(zipOutputStream);
                    z = SharePatchFileUtil.verifyDexFileMd5(file, str);
                    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z));
                    if (!z && (!file.delete() || file.exists())) {
                        ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                    }
                    i2 = i3;
                } catch (Throwable th3) {
                    th = th3;
                    b.closeQuietly(bufferedInputStream);
                    b.closeQuietly(zipOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                zipOutputStream = null;
                b.closeQuietly(bufferedInputStream);
                b.closeQuietly(zipOutputStream);
                throw th;
            }
        }
        return z;
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        String str = isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
        String str2 = shareDexDiffPatchInfo.rawName;
        boolean z = shareDexDiffPatchInfo.isJarMode;
        if (!SharePatchFileUtil.isRawDexFile(str2) || !z) {
            return a(zipFile, zipEntry, file, str, true);
        }
        return b(zipFile, zipEntry, file, str);
    }

    private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        Throwable th;
        OutputStream outputStream = null;
        try {
            BufferedInputStream bufferedInputStream4 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            if (zipEntry2 != null) {
                try {
                    bufferedInputStream3 = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    bufferedInputStream2 = bufferedInputStream4;
                    b.closeQuietly(bufferedInputStream2);
                    b.closeQuietly(bufferedInputStream);
                    throw th;
                }
            } else {
                bufferedInputStream3 = null;
            }
            try {
                boolean isRawDexFile = SharePatchFileUtil.isRawDexFile(shareDexDiffPatchInfo.rawName);
                if (!isRawDexFile || shareDexDiffPatchInfo.isJarMode) {
                    try {
                        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                            if (!isRawDexFile) {
                                try {
                                    zipInputStream = new ZipInputStream(bufferedInputStream4);
                                    do {
                                        try {
                                            nextEntry = zipInputStream.getNextEntry();
                                            if (nextEntry == null) {
                                                break;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            b.closeQuietly(zipInputStream);
                                            throw th;
                                        }
                                    } while (!"classes.dex".equals(nextEntry.getName()));
                                    if (nextEntry == null) {
                                        throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                    }
                                    new com.tencent.tinker.c.a.a(zipInputStream, bufferedInputStream3).c(zipOutputStream);
                                    b.closeQuietly(zipInputStream);
                                } catch (Throwable th4) {
                                    th = th4;
                                    zipInputStream = null;
                                    b.closeQuietly(zipInputStream);
                                    throw th;
                                }
                            } else {
                                new com.tencent.tinker.c.a.a(bufferedInputStream4, bufferedInputStream3).c(zipOutputStream);
                            }
                            zipOutputStream.closeEntry();
                            b.closeQuietly(zipOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            outputStream = zipOutputStream;
                            b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        b.closeQuietly(outputStream);
                        throw th;
                    }
                } else {
                    com.tencent.tinker.c.a.a aVar = new com.tencent.tinker.c.a.a(bufferedInputStream4, bufferedInputStream3);
                    try {
                        OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            aVar.c(bufferedOutputStream);
                            b.closeQuietly(bufferedOutputStream);
                        } catch (Throwable th7) {
                            th = th7;
                            outputStream = bufferedOutputStream;
                            b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        b.closeQuietly(outputStream);
                        throw th;
                    }
                }
                b.closeQuietly(bufferedInputStream4);
                b.closeQuietly(bufferedInputStream3);
            } catch (Throwable th9) {
                th = th9;
                bufferedInputStream = bufferedInputStream3;
                bufferedInputStream2 = bufferedInputStream4;
                b.closeQuietly(bufferedInputStream2);
                b.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            bufferedInputStream = null;
            bufferedInputStream2 = null;
            b.closeQuietly(bufferedInputStream2);
            b.closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    protected static boolean a(a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file, com.tencent.tinker.lib.service.a aVar2) {
        boolean a2;
        if (!ShareTinkerInternals.isTinkerEnabledForDex(aVar.tinkerFlags)) {
            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
            return true;
        }
        String str2 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.DEX_META_FILE);
        if (str2 == null) {
            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str3 = str + "/dex/";
        if (!b(context, str3, str2, file)) {
            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
            a2 = false;
        } else {
            File[] listFiles = new File(str3).listFiles();
            ArrayList arrayList = new ArrayList();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (file2.isFile() && (name.endsWith(ShareConstants.DEX_SUFFIX) || name.endsWith(ShareConstants.JAR_SUFFIX) || name.endsWith(".apk"))) {
                        arrayList.add(file2);
                    }
                }
            }
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "legal files to do dexopt: ".concat(String.valueOf(arrayList)), new Object[0]);
            a2 = a(context, arrayList, str + "/odex/", file, aVar2);
        }
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", Boolean.valueOf(a2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        return a2;
    }
}
