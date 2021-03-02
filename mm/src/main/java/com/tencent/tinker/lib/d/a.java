package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public class a implements c {
    public final Context context;

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.tinker.lib.d.c
    public void d(File file, int i2) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i2));
    }

    @Override // com.tencent.tinker.lib.d.c
    public void a(String str, String str2, File file, String str3) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchVersionChanged: patch version change from " + str + " to " + str2, new Object[0]);
        if (!(str == null || str2 == null || str.equals(str2) || !com.tencent.tinker.lib.e.a.lk(this.context).FgY)) {
            c.lp(this.context).bqL(str2);
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (file2.isDirectory() && !name.equals(str3)) {
                        SharePatchFileUtil.deleteDir(file2);
                    }
                }
            }
        }
    }

    @Override // com.tencent.tinker.lib.d.c
    public void b(int i2, Throwable th) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i2), th);
        switch (i2) {
            case 0:
                ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                ShareTinkerLog.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                ShareTinkerLog.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        hpc();
    }

    @Override // com.tencent.tinker.lib.d.c
    public void a(File file, int i2, boolean z) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType: %d, isDirectory: %b", file.getAbsolutePath(), Integer.valueOf(i2), Boolean.valueOf(z));
        if (i2 == 4) {
            hpc();
        } else {
            hpb();
        }
    }

    @Override // com.tencent.tinker.lib.d.c
    public void b(File file, int i2) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType: %d", file.getAbsolutePath(), Integer.valueOf(i2));
        hpb();
    }

    @Override // com.tencent.tinker.lib.d.c
    public void b(String str, String str2, File file) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", file.getAbsolutePath(), str, str2);
        hpb();
    }

    @Override // com.tencent.tinker.lib.d.c
    public void a(File file, int i2, long j2) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadResult: patch load result, path:%s, code: %d, cost: %dms", file.getAbsolutePath(), Integer.valueOf(i2), Long.valueOf(j2));
    }

    @Override // com.tencent.tinker.lib.d.c
    public void a(Throwable th, int i2) {
        switch (i2) {
            case -4:
                ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unCatch exception: %s", th);
                ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
                ShareTinkerLog.i("Tinker.DefaultLoadReporter", "unCaught exception disable tinker forever with sp", new Object[0]);
                String checkTinkerLastUncaughtCrash = SharePatchFileUtil.checkTinkerLastUncaughtCrash(this.context);
                if (!ShareTinkerInternals.isNullOrNil(checkTinkerLastUncaughtCrash)) {
                    SharePatchFileUtil.safeDeleteFile(SharePatchFileUtil.getPatchLastCrashFile(this.context));
                    ShareTinkerLog.e("Tinker.DefaultLoadReporter", "tinker uncaught real exception:".concat(String.valueOf(checkTinkerLastUncaughtCrash)), new Object[0]);
                    break;
                }
                break;
            case -3:
                if (th.getMessage().contains(ShareConstants.CHECK_RES_INSTALL_FAIL)) {
                    ShareTinkerLog.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker res check fail:" + th.getMessage(), new Object[0]);
                } else {
                    ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load resource exception: %s", th);
                }
                ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
                ShareTinkerLog.i("Tinker.DefaultLoadReporter", "res exception disable tinker forever with sp", new Object[0]);
                break;
            case -2:
                if (th.getMessage().contains(ShareConstants.CHECK_DEX_INSTALL_FAIL)) {
                    ShareTinkerLog.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker dex check fail:" + th.getMessage(), new Object[0]);
                } else {
                    ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load dex exception: %s", th);
                }
                ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
                ShareTinkerLog.i("Tinker.DefaultLoadReporter", "dex exception disable tinker forever with sp", new Object[0]);
                break;
            case -1:
                ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unknown exception: %s", th);
                break;
        }
        ShareTinkerLog.e("Tinker.DefaultLoadReporter", "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        ShareTinkerLog.printErrStackTrace("Tinker.DefaultLoadReporter", th, "tinker load exception", new Object[0]);
        com.tencent.tinker.lib.e.a.lk(this.context).tinkerFlags = 0;
        hpb();
    }

    @Override // com.tencent.tinker.lib.d.c
    public void c(File file, int i2) {
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path: %s, errorCode: %d", file.getAbsolutePath(), Integer.valueOf(i2));
        hpb();
    }

    public final void hpb() {
        SharePatchInfo sharePatchInfo;
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(this.context);
        if (lk.FgY) {
            d dVar = lk.SjZ;
            if (dVar.Skf && (sharePatchInfo = dVar.patchInfo) != null && !ShareTinkerInternals.isNullOrNil(sharePatchInfo.oldVersion)) {
                ShareTinkerLog.w("Tinker.DefaultLoadReporter", "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", sharePatchInfo.oldVersion);
                ShareTinkerInternals.killAllOtherProcess(this.context);
            }
        }
        lk.dZn();
    }

    public final boolean hpc() {
        File file;
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(this.context);
        if (!lk.FgY || (file = lk.SjZ.Ski) == null || !c.lp(this.context).bqK(SharePatchFileUtil.getMD5(file))) {
            return false;
        }
        ShareTinkerLog.i("Tinker.DefaultLoadReporter", "try to repair oat file on patch process", new Object[0]);
        com.tencent.tinker.lib.e.c.cY(this.context, file.getAbsolutePath());
        return true;
    }
}
