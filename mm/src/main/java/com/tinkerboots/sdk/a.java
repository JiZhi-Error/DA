package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.c.g;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;
import java.io.File;

public final class a {
    public static a SKw;
    public final com.tencent.tinker.lib.e.a SKx;
    public final com.tinkerboots.sdk.a.a SKy;
    private final ApplicationLike dks;

    public a(Context context, ApplicationLike applicationLike, c cVar, d dVar, b bVar, com.tencent.tinker.lib.c.a aVar, Class<? extends AbstractResultService> cls, com.tinkerboots.sdk.a.a.b bVar2) {
        AppMethodBeat.i(3427);
        com.tinkerboots.sdk.b.c.context = context;
        this.dks = applicationLike;
        this.SKy = com.tinkerboots.sdk.a.a.a(bVar2);
        a.C2216a aVar2 = new a.C2216a(applicationLike.getApplication());
        int tinkerFlags = applicationLike.getTinkerFlags();
        if (aVar2.status != -1) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerFlag is already set.");
            AppMethodBeat.o(3427);
            throw tinkerRuntimeException;
        }
        aVar2.status = tinkerFlags;
        if (cVar == null) {
            TinkerRuntimeException tinkerRuntimeException2 = new TinkerRuntimeException("loadReporter must not be null.");
            AppMethodBeat.o(3427);
            throw tinkerRuntimeException2;
        } else if (aVar2.SjU != null) {
            TinkerRuntimeException tinkerRuntimeException3 = new TinkerRuntimeException("loadReporter is already set.");
            AppMethodBeat.o(3427);
            throw tinkerRuntimeException3;
        } else {
            aVar2.SjU = cVar;
            if (bVar == null) {
                TinkerRuntimeException tinkerRuntimeException4 = new TinkerRuntimeException("listener must not be null.");
                AppMethodBeat.o(3427);
                throw tinkerRuntimeException4;
            } else if (aVar2.SjT != null) {
                TinkerRuntimeException tinkerRuntimeException5 = new TinkerRuntimeException("listener is already set.");
                AppMethodBeat.o(3427);
                throw tinkerRuntimeException5;
            } else {
                aVar2.SjT = bVar;
                if (dVar == null) {
                    TinkerRuntimeException tinkerRuntimeException6 = new TinkerRuntimeException("patchReporter must not be null.");
                    AppMethodBeat.o(3427);
                    throw tinkerRuntimeException6;
                } else if (aVar2.SjV != null) {
                    TinkerRuntimeException tinkerRuntimeException7 = new TinkerRuntimeException("patchReporter is already set.");
                    AppMethodBeat.o(3427);
                    throw tinkerRuntimeException7;
                } else {
                    aVar2.SjV = dVar;
                    Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
                    if (valueOf == null) {
                        TinkerRuntimeException tinkerRuntimeException8 = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
                        AppMethodBeat.o(3427);
                        throw tinkerRuntimeException8;
                    } else if (aVar2.Skd != null) {
                        TinkerRuntimeException tinkerRuntimeException9 = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
                        AppMethodBeat.o(3427);
                        throw tinkerRuntimeException9;
                    } else {
                        aVar2.Skd = valueOf;
                        com.tencent.tinker.lib.e.a hpi = aVar2.hpi();
                        com.tencent.tinker.lib.e.a.a(hpi);
                        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                        com.tencent.tinker.lib.e.a.sInstalled = true;
                        TinkerPatchService.a(aVar, cls);
                        ShareTinkerLog.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", Boolean.valueOf(ShareTinkerInternals.isTinkerEnabled(hpi.tinkerFlags)), "1.9.14.10");
                        if (!ShareTinkerInternals.isTinkerEnabled(hpi.tinkerFlags)) {
                            ShareTinkerLog.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
                        } else if (tinkerResultIntent == null) {
                            TinkerRuntimeException tinkerRuntimeException10 = new TinkerRuntimeException("intentResult must not be null.");
                            AppMethodBeat.o(3427);
                            throw tinkerRuntimeException10;
                        } else {
                            hpi.SjZ = new com.tencent.tinker.lib.e.d();
                            com.tencent.tinker.lib.e.d dVar2 = hpi.SjZ;
                            Context context2 = hpi.context;
                            com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(context2);
                            dVar2.Skq = ShareIntentUtil.getIntentReturnCode(tinkerResultIntent);
                            dVar2.costTime = ShareIntentUtil.getIntentPatchCostTime(tinkerResultIntent);
                            dVar2.Skg = ShareIntentUtil.getBooleanExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_SYSTEM_OTA, false);
                            dVar2.oatDir = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_OAT_DIR);
                            dVar2.useInterpretMode = ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH.equals(dVar2.oatDir);
                            boolean z = lk.FgY;
                            ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", Integer.valueOf(dVar2.Skq), ShareTinkerInternals.getProcessName(context2), Boolean.valueOf(z), Boolean.valueOf(dVar2.Skg), Build.FINGERPRINT, dVar2.oatDir, Boolean.valueOf(dVar2.useInterpretMode));
                            String stringExtra = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_OLD_VERSION);
                            String stringExtra2 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_NEW_VERSION);
                            File file = lk.SjS;
                            File file2 = lk.SjW;
                            if (!(stringExtra == null || stringExtra2 == null)) {
                                if (z) {
                                    dVar2.Ske = stringExtra2;
                                } else {
                                    dVar2.Ske = stringExtra;
                                }
                                ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", stringExtra, stringExtra2, dVar2.Ske);
                                String patchVersionDirectory = SharePatchFileUtil.getPatchVersionDirectory(dVar2.Ske);
                                if (!ShareTinkerInternals.isNullOrNil(patchVersionDirectory)) {
                                    dVar2.Skh = new File(file.getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP + patchVersionDirectory);
                                    dVar2.Ski = new File(dVar2.Skh.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(dVar2.Ske));
                                    dVar2.Skj = new File(dVar2.Skh, ShareConstants.DEX_PATH);
                                    dVar2.Skk = new File(dVar2.Skh, ShareConstants.SO_PATH);
                                    dVar2.Skl = new File(dVar2.Skh, ShareConstants.RES_PATH);
                                    dVar2.Skm = new File(dVar2.Skl, ShareConstants.RES_NAME);
                                }
                                dVar2.patchInfo = new SharePatchInfo(stringExtra, stringExtra2, ShareIntentUtil.getBooleanExtra(tinkerResultIntent, ShareIntentUtil.INTENT_IS_PROTECTED_APP, false), false, Build.FINGERPRINT, dVar2.oatDir, false);
                                dVar2.Skf = !stringExtra.equals(stringExtra2);
                            }
                            Throwable intentPatchException = ShareIntentUtil.getIntentPatchException(tinkerResultIntent);
                            if (intentPatchException == null) {
                                switch (dVar2.Skq) {
                                    case -10000:
                                        ShareTinkerLog.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                                        TinkerRuntimeException tinkerRuntimeException11 = new TinkerRuntimeException("can't get the right intent return code");
                                        AppMethodBeat.o(3427);
                                        throw tinkerRuntimeException11;
                                    case -24:
                                        if (dVar2.Skm != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", dVar2.Skm.getAbsolutePath());
                                            lk.SjU.b(dVar2.Skm, 6);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException12 = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException12;
                                        }
                                    case -22:
                                        if (dVar2.Skh != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", dVar2.Skm.getAbsolutePath());
                                            lk.SjU.a(dVar2.Skm, 6, false);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException13 = new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException13;
                                        }
                                    case -21:
                                        if (dVar2.Skh != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", dVar2.Skl.getAbsolutePath());
                                            lk.SjU.a(dVar2.Skl, 6, true);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException14 = new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException14;
                                        }
                                    case ShareConstants.ERROR_LOAD_PATCH_REWRITE_PATCH_INFO_FAIL:
                                        ShareTinkerLog.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                                        lk.SjU.b(stringExtra, stringExtra2, file2);
                                        break;
                                    case ShareConstants.ERROR_LOAD_PATCH_VERSION_LIB_FILE_NOT_EXIST:
                                        String stringExtra3 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_MISSING_LIB_PATH);
                                        if (stringExtra3 != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", stringExtra3);
                                            lk.SjU.a(new File(stringExtra3), 5, false);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException15 = new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException15;
                                        }
                                    case ShareConstants.ERROR_LOAD_PATCH_VERSION_LIB_DIRECTORY_NOT_EXIST:
                                        if (dVar2.Skh != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", dVar2.Skk.getAbsolutePath());
                                            lk.SjU.a(dVar2.Skk, 5, true);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException16 = new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException16;
                                        }
                                    case -16:
                                        lk.SjU.b(2, ShareIntentUtil.getIntentInterpretException(tinkerResultIntent));
                                        break;
                                    case -15:
                                        lk.SjU.b(1, ShareIntentUtil.getIntentInterpretException(tinkerResultIntent));
                                        break;
                                    case -13:
                                        String stringExtra4 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_MISMATCH_DEX_PATH);
                                        if (stringExtra4 != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", stringExtra4);
                                            lk.SjU.b(new File(stringExtra4), 3);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException17 = new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException17;
                                        }
                                    case -12:
                                        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case -11:
                                        String stringExtra5 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH);
                                        if (stringExtra5 != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", stringExtra5);
                                            lk.SjU.a(new File(stringExtra5), 4, false);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException18 = new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException18;
                                        }
                                    case -10:
                                        String stringExtra6 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH);
                                        if (stringExtra6 != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", stringExtra6);
                                            lk.SjU.a(new File(stringExtra6), 3, false);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException19 = new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException19;
                                        }
                                    case -9:
                                        if (dVar2.Skj != null) {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", dVar2.Skj.getAbsolutePath());
                                            lk.SjU.a(dVar2.Skj, 3, true);
                                            break;
                                        } else {
                                            ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                            TinkerRuntimeException tinkerRuntimeException20 = new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException20;
                                        }
                                    case -8:
                                        ShareTinkerLog.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                                        if (dVar2.Ski != null) {
                                            lk.SjU.c(dVar2.Ski, tinkerResultIntent.getIntExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -10000));
                                            break;
                                        } else {
                                            TinkerRuntimeException tinkerRuntimeException21 = new TinkerRuntimeException("error patch package check fail , but file is null");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException21;
                                        }
                                    case -7:
                                        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", dVar2.Ske);
                                        if (dVar2.Ski != null) {
                                            lk.SjU.a(dVar2.Ski, 1, false);
                                            break;
                                        } else {
                                            TinkerRuntimeException tinkerRuntimeException22 = new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                            AppMethodBeat.o(3427);
                                            throw tinkerRuntimeException22;
                                        }
                                    case -6:
                                        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", dVar2.Ske);
                                        lk.SjU.a(dVar2.Skh, 1, true);
                                        break;
                                    case -5:
                                        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                                        lk.SjU.b(stringExtra, stringExtra2, file2);
                                        break;
                                    case -3:
                                    case -2:
                                        ShareTinkerLog.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        ShareTinkerLog.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        ShareTinkerLog.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                                        lk.Ska = true;
                                        dVar2.Skn = ShareIntentUtil.getIntentPatchDexPaths(tinkerResultIntent);
                                        dVar2.Sko = ShareIntentUtil.getIntentPatchLibsPaths(tinkerResultIntent);
                                        dVar2.Skp = ShareIntentUtil.getIntentPackageConfig(tinkerResultIntent);
                                        if (dVar2.useInterpretMode) {
                                            lk.SjU.b(0, (Throwable) null);
                                        }
                                        if (z && dVar2.Skf) {
                                            lk.SjU.a(stringExtra, stringExtra2, file, dVar2.Skh.getName());
                                            break;
                                        }
                                }
                            } else {
                                ShareTinkerLog.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", Integer.valueOf(dVar2.Skq));
                                int i2 = -1;
                                switch (dVar2.Skq) {
                                    case -25:
                                        i2 = -4;
                                        break;
                                    case -23:
                                        i2 = -3;
                                        break;
                                    case -20:
                                        i2 = -1;
                                        break;
                                    case -14:
                                        i2 = -2;
                                        break;
                                }
                                lk.SjU.a(intentPatchException, i2);
                            }
                            hpi.SjU.a(hpi.SjS, hpi.SjZ.Skq, hpi.SjZ.costTime);
                            if (!hpi.Ska) {
                                ShareTinkerLog.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
                            }
                        }
                        this.SKx = hpi;
                        AppMethodBeat.o(3427);
                    }
                }
            }
        }
    }

    public static a a(a aVar) {
        AppMethodBeat.i(201268);
        if (aVar == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("TinkerClient init, tinkerClient should not be null.");
            AppMethodBeat.o(201268);
            throw tinkerRuntimeException;
        } else if (SKw != null) {
            TinkerRuntimeException tinkerRuntimeException2 = new TinkerRuntimeException("TinkerClient instance is already set.");
            AppMethodBeat.o(201268);
            throw tinkerRuntimeException2;
        } else {
            SKw = aVar;
            AppMethodBeat.o(201268);
            return aVar;
        }
    }

    public static a hvX() {
        AppMethodBeat.i(3428);
        if (SKw == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("you must init TinkerClient sdk first");
            AppMethodBeat.o(3428);
            throw tinkerRuntimeException;
        }
        a aVar = SKw;
        AppMethodBeat.o(3428);
        return aVar;
    }

    public final a Ey(final boolean z) {
        AppMethodBeat.i(3429);
        if (this.SKy == null || this.SKx == null) {
            ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            a aVar = SKw;
            AppMethodBeat.o(3429);
            return aVar;
        }
        Context context = com.tinkerboots.sdk.b.c.getContext();
        if (!com.tinkerboots.sdk.b.b.lL(context)) {
            ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
            a aVar2 = SKw;
            AppMethodBeat.o(3429);
            return aVar2;
        } else if (!ShareTinkerInternals.isTinkerEnabled(this.SKx.tinkerFlags) || !ShareTinkerInternals.isTinkerEnableWithSharedPreferences(context)) {
            ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
            a aVar3 = SKw;
            AppMethodBeat.o(3429);
            return aVar3;
        } else {
            if (this.SKx.FgY) {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                    /* class com.tinkerboots.sdk.a.AnonymousClass1 */

                    public final boolean queueIdle() {
                        AppMethodBeat.i(3425);
                        com.tinkerboots.sdk.a.a aVar = a.this.SKy;
                        boolean z = z;
                        SharedPreferences sharedPreferences = com.tinkerboots.sdk.b.c.getContext().getSharedPreferences("patch_server_config", 0);
                        long j2 = sharedPreferences.getLong("fetch_patch_last_check", 0);
                        if (j2 == -1) {
                            ShareTinkerLog.v("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis() - j2;
                            if (z || aVar.cWq || currentTimeMillis >= aVar.ldB) {
                                sharedPreferences.edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
                                com.tinkerboots.sdk.a.b.a aVar2 = aVar.SKF;
                                com.tinkerboots.sdk.a.a.b bVar = aVar.SKD;
                                if (bVar == null) {
                                    RuntimeException runtimeException = new RuntimeException("callback can't be null");
                                    AppMethodBeat.o(3425);
                                    throw runtimeException;
                                } else if (bVar.dZo()) {
                                    bVar.dZp();
                                    bVar.ao(aVar2.SKG.SKH);
                                }
                            } else {
                                ShareTinkerLog.v("Tinker.ServerClient", "tinker sync should wait interval %ss", Long.valueOf((aVar.ldB - currentTimeMillis) / 1000));
                            }
                        }
                        AppMethodBeat.o(3425);
                        return false;
                    }
                });
            }
            a aVar4 = SKw;
            AppMethodBeat.o(3429);
            return aVar4;
        }
    }

    public final a ol(String str, String str2) {
        AppMethodBeat.i(3430);
        if (this.SKy == null) {
            ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
            a aVar = SKw;
            AppMethodBeat.o(3430);
            return aVar;
        }
        ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition %s with value %s", str, str2);
        this.SKy.om(str, str2);
        a aVar2 = SKw;
        AppMethodBeat.o(3430);
        return aVar2;
    }

    public final a atk(int i2) {
        AppMethodBeat.i(3431);
        if (this.SKy == null) {
            ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
            a aVar = SKw;
            AppMethodBeat.o(3431);
            return aVar;
        }
        ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", Integer.valueOf(i2));
        this.SKy.atl(i2);
        a aVar2 = SKw;
        AppMethodBeat.o(3431);
        return aVar2;
    }

    /* renamed from: com.tinkerboots.sdk.a$a  reason: collision with other inner class name */
    public static class C2238a {
        private com.tencent.tinker.lib.c.a SKB;
        public Class<? extends AbstractResultService> SKC;
        private com.tinkerboots.sdk.a.a.b SKD;
        public b SjT;
        public c SjU;
        private d SjV;
        private final Context context;
        private final ApplicationLike dks;

        public C2238a(ApplicationLike applicationLike) {
            AppMethodBeat.i(3426);
            if (applicationLike == null) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("applicationLike must not be null.");
                AppMethodBeat.o(3426);
                throw tinkerRuntimeException;
            }
            this.context = applicationLike.getApplication();
            this.dks = applicationLike;
            AppMethodBeat.o(3426);
        }

        public final C2238a a(d dVar) {
            AppMethodBeat.i(201266);
            if (this.SjV != null) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("patchReporter is already set.");
                AppMethodBeat.o(201266);
                throw tinkerRuntimeException;
            }
            this.SjV = dVar;
            AppMethodBeat.o(201266);
            return this;
        }

        public final a hvY() {
            AppMethodBeat.i(201267);
            if (this.SjU == null) {
                this.SjU = new com.tinkerboots.sdk.tinker.b.a(this.context);
            }
            if (this.SjV == null) {
                this.SjV = new com.tinkerboots.sdk.tinker.b.c(this.context);
            }
            if (this.SjT == null) {
                this.SjT = new com.tinkerboots.sdk.tinker.b.b(this.context);
            }
            if (this.SKB == null) {
                this.SKB = new g();
            }
            if (this.SKC == null) {
                this.SKC = TinkerServerResultService.class;
            }
            if (this.SKD == null) {
                this.SKD = new com.tinkerboots.sdk.a.a.a();
            }
            a aVar = new a(this.context, this.dks, this.SjU, this.SjV, this.SjT, this.SKB, this.SKC, this.SKD);
            AppMethodBeat.o(201267);
            return aVar;
        }
    }
}
