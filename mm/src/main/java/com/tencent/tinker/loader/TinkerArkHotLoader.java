package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareArkHotDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TinkerArkHotLoader {
    private static final String ARKHOT_PATH = "arkHot";
    private static final String ARK_MEAT_FILE = "assets/arkHot_meta.txt";
    private static final String TAG = "Tinker.TinkerArkHotLoader";
    private static HashSet<ShareArkHotDiffPatchInfo> arkHotApkInfo = new HashSet<>();
    private static boolean isArkHotRuning = ShareTinkerInternals.isArkHotRuning();

    private TinkerArkHotLoader() {
    }

    @TargetApi(14)
    public static boolean loadTinkerArkHot(TinkerApplication tinkerApplication, String str, Intent intent) {
        if (arkHotApkInfo.isEmpty()) {
            ShareTinkerLog.w(TAG, "there is no apk to load", new Object[0]);
            return true;
        }
        PathClassLoader pathClassLoader = (PathClassLoader) TinkerArkHotLoader.class.getClassLoader();
        if (pathClassLoader != null) {
            ShareTinkerLog.i(TAG, "classloader: " + pathClassLoader.toString(), new Object[0]);
            String str2 = str + "/arkHot/";
            ArrayList arrayList = new ArrayList();
            if (isArkHotRuning && !arkHotApkInfo.isEmpty()) {
                arrayList.add(new File(str2 + ShareConstants.ARKHOT_PATCH_NAME));
            }
            try {
                SystemClassLoaderAdder.installApk(pathClassLoader, arrayList);
                return true;
            } catch (Throwable th) {
                ShareTinkerLog.e(TAG, "install dexes failed", new Object[0]);
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, th);
                ShareIntentUtil.setIntentReturnCode(intent, -14);
                return false;
            }
        } else {
            ShareTinkerLog.e(TAG, "classloader is null", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -12);
            return false;
        }
    }

    public static boolean checkComplete(String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = shareSecurityCheck.getMetaContentMap().get("assets/arkHot_meta.txt");
        if (str2 == null) {
            return true;
        }
        arkHotApkInfo.clear();
        ArrayList arrayList = new ArrayList();
        ShareArkHotDiffPatchInfo.parseDiffPatchInfo(str2, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        HashMap hashMap = new HashMap(1);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareArkHotDiffPatchInfo shareArkHotDiffPatchInfo = (ShareArkHotDiffPatchInfo) it.next();
            if (!ShareArkHotDiffPatchInfo.checkDiffPatchInfo(shareArkHotDiffPatchInfo)) {
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -3);
                ShareIntentUtil.setIntentReturnCode(intent, -8);
                return false;
            } else if (isArkHotRuning && ShareConstants.ARKHOT_PATCH_NAME.equals(shareArkHotDiffPatchInfo.name)) {
                arkHotApkInfo.add(shareArkHotDiffPatchInfo);
            }
        }
        if (isArkHotRuning && !arkHotApkInfo.isEmpty()) {
            hashMap.put(ShareConstants.ARKHOT_PATCH_NAME, "");
        }
        String str3 = str + "/arkHot/";
        File file = new File(str3);
        if (!file.exists() || !file.isDirectory()) {
            ShareIntentUtil.setIntentReturnCode(intent, -9);
            return false;
        }
        Iterator it2 = hashMap.keySet().iterator();
        while (it2.hasNext()) {
            File file2 = new File(str3 + ((String) it2.next()));
            if (!SharePatchFileUtil.isLegalFile(file2)) {
                try {
                    intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH, file2.getCanonicalPath());
                } catch (IOException e2) {
                }
                ShareIntentUtil.setIntentReturnCode(intent, -10);
                return false;
            }
        }
        intent.putExtra(ShareIntentUtil.INTENT_PATCH_DEXES_PATH, hashMap);
        return true;
    }
}
