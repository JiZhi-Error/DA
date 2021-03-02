package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

public class SharePatchInfo {
    public static final String DEFAULT_DIR = "odex";
    public static final String FINGER_PRINT = "print";
    public static final String IS_PROTECTED_APP = "is_protected_app";
    public static final String IS_REMOVE_INTERPRET_OAT_DIR = "is_remove_interpret_oat_dir";
    public static final String IS_REMOVE_NEW_VERSION = "is_remove_new_version";
    public static final int MAX_EXTRACT_ATTEMPTS = 2;
    public static final String NEW_VERSION = "new";
    public static final String OAT_DIR = "dir";
    public static final String OLD_VERSION = "old";
    private static final String TAG = "Tinker.PatchInfo";
    public String fingerPrint;
    public boolean isProtectedApp;
    public boolean isRemoveInterpretOATDir;
    public boolean isRemoveNewVersion;
    public String newVersion;
    public String oatDir;
    public String oldVersion;

    public SharePatchInfo(String str, String str2, boolean z, boolean z2, String str3, String str4, boolean z3) {
        this.oldVersion = str;
        this.newVersion = str2;
        this.isProtectedApp = z;
        this.isRemoveNewVersion = z2;
        this.fingerPrint = str3;
        this.oatDir = str4;
        this.isRemoveInterpretOATDir = z3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041 A[SYNTHETIC, Splitter:B:24:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.tinker.loader.shareutil.SharePatchInfo readAndCheckPropertyWithLock(java.io.File r6, java.io.File r7) {
        /*
            r0 = 0
            r4 = 1
            r5 = 0
            if (r6 == 0) goto L_0x0007
            if (r7 != 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            java.io.File r1 = r7.getParentFile()
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0015
            r1.mkdirs()
        L_0x0015:
            com.tencent.tinker.loader.shareutil.ShareFileLockHelper r2 = com.tencent.tinker.loader.shareutil.ShareFileLockHelper.getFileLock(r7)     // Catch:{ Exception -> 0x0032, all -> 0x0054 }
            com.tencent.tinker.loader.shareutil.SharePatchInfo r0 = readAndCheckProperty(r6)     // Catch:{ Exception -> 0x0057 }
            if (r2 == 0) goto L_0x0007
            r2.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0007
        L_0x0023:
            r1 = move-exception
            java.lang.String r2 = "Tinker.PatchInfo"
            java.lang.String r3 = "releaseInfoLock error"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r5] = r1
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.w(r2, r3, r4)
            goto L_0x0007
        L_0x0032:
            r1 = move-exception
            r2 = r0
        L_0x0034:
            com.tencent.tinker.loader.TinkerRuntimeException r0 = new com.tencent.tinker.loader.TinkerRuntimeException     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "readAndCheckPropertyWithLock fail"
            r0.<init>(r3, r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            r1 = r0
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r2.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0044:
            throw r1
        L_0x0045:
            r0 = move-exception
            java.lang.String r2 = "Tinker.PatchInfo"
            java.lang.String r3 = "releaseInfoLock error"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r5] = r0
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.w(r2, r3, r4)
            goto L_0x0044
        L_0x0054:
            r1 = move-exception
            r2 = r0
            goto L_0x003f
        L_0x0057:
            r0 = move-exception
            r1 = r0
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchInfo.readAndCheckPropertyWithLock(java.io.File, java.io.File):com.tencent.tinker.loader.shareutil.SharePatchInfo");
    }

    public static boolean rewritePatchInfoFileWithLock(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            shareFileLockHelper = ShareFileLockHelper.getFileLock(file2);
            boolean rewritePatchInfoFile = rewritePatchInfoFile(file, sharePatchInfo);
            if (shareFileLockHelper == null) {
                return rewritePatchInfoFile;
            }
            try {
                shareFileLockHelper.close();
                return rewritePatchInfoFile;
            } catch (IOException e2) {
                ShareTinkerLog.i(TAG, "releaseInfoLock error", e2);
                return rewritePatchInfoFile;
            }
        } catch (Exception e3) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e3);
        } catch (Throwable th) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (IOException e4) {
                    ShareTinkerLog.i(TAG, "releaseInfoLock error", e4);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.tinker.loader.shareutil.SharePatchInfo readAndCheckProperty(java.io.File r13) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchInfo.readAndCheckProperty(java.io.File):com.tencent.tinker.loader.shareutil.SharePatchInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean rewritePatchInfoFile(java.io.File r7, com.tencent.tinker.loader.shareutil.SharePatchInfo r8) {
        /*
        // Method dump skipped, instructions count: 400
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchInfo.rewritePatchInfoFile(java.io.File, com.tencent.tinker.loader.shareutil.SharePatchInfo):boolean");
    }
}
