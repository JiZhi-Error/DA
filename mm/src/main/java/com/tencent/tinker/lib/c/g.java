package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class g extends a {
    @Override // com.tencent.tinker.lib.c.a
    public final boolean a(Context context, String str, a aVar) {
        SharePatchInfo sharePatchInfo;
        boolean a2;
        boolean z;
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(context);
        File file = new File(str);
        if (!ShareTinkerInternals.isTinkerEnabled(lk.tinkerFlags) || !ShareTinkerInternals.isTinkerEnableWithSharedPreferences(context)) {
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (!SharePatchFileUtil.isLegalFile(file)) {
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        } else {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int checkTinkerPackage = ShareTinkerInternals.checkTinkerPackage(context, lk.tinkerFlags, file, shareSecurityCheck);
            if (checkTinkerPackage != 0) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                lk.SjV.e(file, checkTinkerPackage);
                return false;
            }
            String md5 = SharePatchFileUtil.getMD5(file);
            if (md5 == null) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            aVar.SjM = md5;
            ShareTinkerLog.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", md5);
            String absolutePath = lk.SjS.getAbsolutePath();
            File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(absolutePath);
            File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(absolutePath);
            HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
            if (packagePropertiesIfPresent == null) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch packageProperties is null, do we process a valid patch apk ?", new Object[0]);
                return false;
            }
            String str2 = packagePropertiesIfPresent.get("is_protected_app");
            boolean z2 = str2 != null && !str2.isEmpty() && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2);
            SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
            if (readAndCheckPropertyWithLock == null) {
                sharePatchInfo = new SharePatchInfo("", md5, z2, false, Build.FINGERPRINT, "odex", false);
            } else if (readAndCheckPropertyWithLock.oldVersion == null || readAndCheckPropertyWithLock.newVersion == null || readAndCheckPropertyWithLock.oatDir == null) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                lk.SjV.b(file, readAndCheckPropertyWithLock.oldVersion, readAndCheckPropertyWithLock.newVersion);
                return false;
            } else if (!SharePatchFileUtil.checkIfMd5Valid(md5)) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", md5);
                lk.SjV.a(file, readAndCheckPropertyWithLock, md5);
                return false;
            } else {
                boolean equals = readAndCheckPropertyWithLock.oatDir.equals(ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH);
                if (equals || ShareTinkerInternals.isNullOrNil(readAndCheckPropertyWithLock.newVersion) || !readAndCheckPropertyWithLock.newVersion.equals(md5) || readAndCheckPropertyWithLock.isRemoveNewVersion) {
                    sharePatchInfo = new SharePatchInfo(readAndCheckPropertyWithLock.oldVersion, md5, z2, false, Build.FINGERPRINT, equals ? ShareConstants.CHANING_DEX_OPTIMIZE_PATH : readAndCheckPropertyWithLock.oatDir, false);
                } else {
                    ShareTinkerLog.e("Tinker.UpgradePatch", "patch already applied, md5: %s", md5);
                    c.lp(context).bqL(md5);
                    return true;
                }
            }
            String str3 = absolutePath + FilePathGenerator.ANDROID_DIR_SEP + SharePatchFileUtil.getPatchVersionDirectory(md5);
            ShareTinkerLog.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", str3);
            File file2 = new File(str3 + FilePathGenerator.ANDROID_DIR_SEP + SharePatchFileUtil.getPatchVersionFile(md5));
            try {
                if (!md5.equals(SharePatchFileUtil.getMD5(file2))) {
                    SharePatchFileUtil.copyFileUsingStream(file, file2);
                    ShareTinkerLog.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length()));
                }
                if (!e.a(lk, shareSecurityCheck, context, str3, file2, aVar)) {
                    ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                    return false;
                }
                b.a(shareSecurityCheck, context, str3, file2);
                if (!ShareTinkerInternals.isTinkerEnabledForNativeLib(lk.tinkerFlags)) {
                    ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
                    a2 = true;
                } else {
                    String str4 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.SO_META_FILE);
                    if (str4 == null) {
                        ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
                        a2 = true;
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a2 = d.a(context, str3 + "/lib/", str4, file2);
                        ShareTinkerLog.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", Boolean.valueOf(a2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                }
                if (!a2) {
                    ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                    return false;
                }
                if (!ShareTinkerInternals.isTinkerEnabledForResource(lk.tinkerFlags)) {
                    ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
                    z = true;
                } else {
                    String str5 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.RES_META_FILE);
                    if (str5 == null || str5.length() == 0) {
                        ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
                        z = true;
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        if (!f.c(context, str3 + "/res/", str5, file2)) {
                            ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                            z = false;
                        } else {
                            z = true;
                        }
                        ShareTinkerLog.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2));
                    }
                }
                if (!z) {
                    ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                    return false;
                } else if (!e.a(file, lk)) {
                    ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                    return false;
                } else if (!SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo, patchInfoLockFile)) {
                    ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                    lk.SjV.b(file, sharePatchInfo.oldVersion, sharePatchInfo.newVersion);
                    return false;
                } else {
                    c.lp(context).bqL(md5);
                    ShareTinkerLog.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                    return true;
                }
            } catch (IOException e2) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", file.getPath(), file2.getPath());
                lk.SjV.a(file, file2, file.getName(), 1);
                return false;
            }
        }
    }
}
