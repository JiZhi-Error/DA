package com.tencent.tinker.lib.e;

import android.content.Intent;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public final class b {
    public static boolean c(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.getIntentReturnCode(tinkerResultIntent) == 0) {
            return true;
        }
        return false;
    }

    public static String d(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent == null) {
            return null;
        }
        String stringExtra = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_OLD_VERSION);
        String stringExtra2 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_NEW_VERSION);
        boolean isInMainProcess = ShareTinkerInternals.isInMainProcess(applicationLike.getApplication());
        if (stringExtra == null || stringExtra2 == null) {
            return null;
        }
        return isInMainProcess ? stringExtra2 : stringExtra;
    }

    public static void e(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        File patchDirectory = SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication());
        if (!patchDirectory.exists()) {
            ShareTinkerLog.w("Tinker.TinkerApplicationHelper", "try to clean patch while there're not any applied patches.", new Object[0]);
            return;
        }
        File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(patchDirectory.getAbsolutePath());
        if (!patchInfoFile.exists()) {
            ShareTinkerLog.w("Tinker.TinkerApplicationHelper", "try to clean patch while patch info file does not exist.", new Object[0]);
            return;
        }
        File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(patchDirectory.getAbsolutePath());
        SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
        if (readAndCheckPropertyWithLock != null) {
            readAndCheckPropertyWithLock.isRemoveNewVersion = true;
            SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, readAndCheckPropertyWithLock, patchInfoLockFile);
        }
    }
}
