package com.tencent.tinker.loader;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TinkerDexLoader {
    private static final String DEFAULT_DEX_OPTIMIZE_PATH = "odex";
    private static final String DEX_MEAT_FILE = "assets/dex_meta.txt";
    private static final String DEX_PATH = "dex";
    private static final String INTERPRET_DEX_OPTIMIZE_PATH = "interpet";
    private static final ArrayList<ShareDexDiffPatchInfo> LOAD_DEX_LIST = new ArrayList<>();
    private static final String TAG = "Tinker.TinkerDexLoader";
    private static HashSet<ShareDexDiffPatchInfo> classNDexInfo = new HashSet<>();
    private static boolean isVmArt = ShareTinkerInternals.isVmArt();

    private TinkerDexLoader() {
    }

    public static boolean loadTinkerJars(TinkerApplication tinkerApplication, String str, String str2, Intent intent, boolean z, boolean z2) {
        if (!LOAD_DEX_LIST.isEmpty() || !classNDexInfo.isEmpty()) {
            ClassLoader classLoader = TinkerDexLoader.class.getClassLoader();
            if (classLoader != null) {
                ShareTinkerLog.i(TAG, "classloader: " + classLoader.toString(), new Object[0]);
                String str3 = str + "/dex/";
                ArrayList arrayList = new ArrayList();
                Iterator<ShareDexDiffPatchInfo> it = LOAD_DEX_LIST.iterator();
                while (it.hasNext()) {
                    ShareDexDiffPatchInfo next = it.next();
                    if (!isJustArtSupportDex(next)) {
                        File file = new File(str3 + next.realName);
                        if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (!SharePatchFileUtil.verifyDexFileMd5(file, getInfoMd5(next))) {
                                ShareIntentUtil.setIntentReturnCode(intent, -13);
                                intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISMATCH_DEX_PATH, file.getAbsolutePath());
                                return false;
                            }
                            ShareTinkerLog.i(TAG, "verify dex file:" + file.getPath() + " md5, use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                        }
                        arrayList.add(file);
                    }
                }
                if (isVmArt && !classNDexInfo.isEmpty()) {
                    File file2 = new File(str3 + ShareConstants.CLASS_N_APK_NAME);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                        Iterator<ShareDexDiffPatchInfo> it2 = classNDexInfo.iterator();
                        while (it2.hasNext()) {
                            ShareDexDiffPatchInfo next2 = it2.next();
                            if (!SharePatchFileUtil.verifyDexFileMd5(file2, next2.rawName, next2.destMd5InArt)) {
                                ShareIntentUtil.setIntentReturnCode(intent, -13);
                                intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISMATCH_DEX_PATH, file2.getAbsolutePath());
                                return false;
                            }
                        }
                    }
                    ShareTinkerLog.i(TAG, "verify dex file:" + file2.getPath() + " md5, use time: " + (System.currentTimeMillis() - currentTimeMillis2), new Object[0]);
                    arrayList.add(file2);
                }
                File file3 = new File(str + FilePathGenerator.ANDROID_DIR_SEP + str2);
                if (z) {
                    final boolean[] zArr = {true};
                    final Throwable[] thArr = new Throwable[1];
                    try {
                        String currentInstructionSet = ShareTinkerInternals.getCurrentInstructionSet();
                        deleteOutOfDateOATFile(str);
                        ShareTinkerLog.w(TAG, "systemOTA, try parallel oat dexes, targetISA:".concat(String.valueOf(currentInstructionSet)), new Object[0]);
                        File file4 = new File(str + "/interpet");
                        TinkerDexOptimizer.optimizeAll(tinkerApplication, arrayList, file4, true, tinkerApplication.isUseDelegateLastClassLoader(), currentInstructionSet, new TinkerDexOptimizer.ResultCallback() {
                            /* class com.tencent.tinker.loader.TinkerDexLoader.AnonymousClass1 */
                            long start;

                            @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                            public final void onStart(File file, File file2) {
                                this.start = System.currentTimeMillis();
                                ShareTinkerLog.i(TinkerDexLoader.TAG, "start to optimize dex:" + file.getPath(), new Object[0]);
                            }

                            @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                            public final void onSuccess(File file, File file2, File file3) {
                                ShareTinkerLog.i(TinkerDexLoader.TAG, "success to optimize dex " + file.getPath() + ", use time " + (System.currentTimeMillis() - this.start), new Object[0]);
                            }

                            @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                            public final void onFailed(File file, File file2, Throwable th) {
                                zArr[0] = false;
                                thArr[0] = th;
                                ShareTinkerLog.i(TinkerDexLoader.TAG, "fail to optimize dex " + file.getPath() + ", use time " + (System.currentTimeMillis() - this.start), new Object[0]);
                            }
                        });
                        if (!zArr[0]) {
                            ShareTinkerLog.e(TAG, "parallel oat dexes failed", new Object[0]);
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_INTERPRET_EXCEPTION, thArr[0]);
                            ShareIntentUtil.setIntentReturnCode(intent, -16);
                            return false;
                        }
                        file3 = file4;
                    } catch (Throwable th) {
                        ShareTinkerLog.i(TAG, "getCurrentInstructionSet fail:".concat(String.valueOf(th)), new Object[0]);
                        deleteOutOfDateOATFile(str);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_INTERPRET_EXCEPTION, th);
                        ShareIntentUtil.setIntentReturnCode(intent, -15);
                        return false;
                    }
                }
                try {
                    SystemClassLoaderAdder.installDexes(tinkerApplication, classLoader, file3, arrayList, z2, tinkerApplication.isUseDelegateLastClassLoader());
                    return true;
                } catch (Throwable th2) {
                    ShareTinkerLog.e(TAG, "install dexes failed", new Object[0]);
                    intent.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, th2);
                    ShareIntentUtil.setIntentReturnCode(intent, -14);
                    return false;
                }
            } else {
                ShareTinkerLog.e(TAG, "classloader is null", new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -12);
                return false;
            }
        } else {
            ShareTinkerLog.w(TAG, "there is no dex to load", new Object[0]);
            return true;
        }
    }

    public static boolean checkComplete(String str, ShareSecurityCheck shareSecurityCheck, String str2, Intent intent) {
        String str3 = shareSecurityCheck.getMetaContentMap().get("assets/dex_meta.txt");
        if (str3 == null) {
            return true;
        }
        LOAD_DEX_LIST.clear();
        classNDexInfo.clear();
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str3, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
            if (!isJustArtSupportDex(shareDexDiffPatchInfo2)) {
                if (!ShareDexDiffPatchInfo.checkDexDiffPatchInfo(shareDexDiffPatchInfo2)) {
                    intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -3);
                    ShareIntentUtil.setIntentReturnCode(intent, -8);
                    return false;
                } else if (isVmArt && shareDexDiffPatchInfo2.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                } else if (!isVmArt || !ShareConstants.CLASS_N_PATTERN.matcher(shareDexDiffPatchInfo2.realName).matches()) {
                    hashMap.put(shareDexDiffPatchInfo2.realName, getInfoMd5(shareDexDiffPatchInfo2));
                    LOAD_DEX_LIST.add(shareDexDiffPatchInfo2);
                } else {
                    classNDexInfo.add(shareDexDiffPatchInfo2);
                }
            }
        }
        if (isVmArt && (shareDexDiffPatchInfo != null || !classNDexInfo.isEmpty())) {
            if (shareDexDiffPatchInfo != null) {
                classNDexInfo.add(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, classNDexInfo.size() + 1));
            }
            hashMap.put(ShareConstants.CLASS_N_APK_NAME, "");
        }
        String str4 = str + "/dex/";
        File file = new File(str4);
        if (!file.exists() || !file.isDirectory()) {
            ShareIntentUtil.setIntentReturnCode(intent, -9);
            return false;
        }
        File file2 = new File(str + FilePathGenerator.ANDROID_DIR_SEP + str2 + FilePathGenerator.ANDROID_DIR_SEP);
        Iterator it2 = hashMap.keySet().iterator();
        while (it2.hasNext()) {
            File file3 = new File(str4 + ((String) it2.next()));
            if (!SharePatchFileUtil.isLegalFile(file3)) {
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH, file3.getAbsolutePath());
                ShareIntentUtil.setIntentReturnCode(intent, -10);
                return false;
            }
            File file4 = new File(SharePatchFileUtil.optimizedPathFor(file3, file2));
            if (!SharePatchFileUtil.isLegalFile(file4) && !SharePatchFileUtil.shouldAcceptEvenIfIllegal(file4)) {
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH, file4.getAbsolutePath());
                ShareIntentUtil.setIntentReturnCode(intent, -11);
                return false;
            }
        }
        intent.putExtra(ShareIntentUtil.INTENT_PATCH_DEXES_PATH, hashMap);
        return true;
    }

    private static String getInfoMd5(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        return isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
    }

    private static void deleteOutOfDateOATFile(String str) {
        SharePatchFileUtil.deleteDir(str + "/odex/");
        if (ShareTinkerInternals.isAfterAndroidO()) {
            SharePatchFileUtil.deleteDir(str + "/dex/oat/");
        }
    }

    private static boolean isJustArtSupportDex(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (!isVmArt && shareDexDiffPatchInfo.destMd5InDvm.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return true;
        }
        return false;
    }
}
