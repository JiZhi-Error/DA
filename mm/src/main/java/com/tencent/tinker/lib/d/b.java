package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.List;

public class b implements d {
    private static boolean SjI = false;
    protected final Context context;

    public b(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.tinker.lib.d.d
    public void aE(Intent intent) {
        c.a aVar;
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        SjI = false;
        c lp = c.lp(this.context);
        if (!lp.Skt) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            ShareTinkerLog.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String bK = TinkerPatchService.bK(intent);
            if (bK == null) {
                ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(bK);
            String md5 = SharePatchFileUtil.getMD5(file);
            if (md5 == null) {
                ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            if (lp.Sku.exists()) {
                aVar = c.a.ag(lp.Sku);
                if (aVar.md5 == null || aVar.Skw == null || !md5.equals(aVar.md5)) {
                    lp.af(file);
                    aVar.md5 = md5;
                    aVar.Skw = "1";
                } else {
                    int parseInt = Integer.parseInt(aVar.Skw);
                    if (parseInt >= lp.yiR) {
                        SharePatchFileUtil.safeDeleteFile(lp.Skv);
                        ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    aVar.Skw = String.valueOf(parseInt + 1);
                }
            } else {
                lp.af(file);
                aVar = new c.a(md5, "1");
            }
            c.a.a(lp.Sku, aVar);
        }
    }

    @Override // com.tencent.tinker.lib.d.d
    public void e(File file, int i2) {
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i2));
        if (i2 == -3 || i2 == -4 || i2 == -8) {
            a.lk(this.context).ae(file);
        }
    }

    @Override // com.tencent.tinker.lib.d.d
    public void a(File file, SharePatchInfo sharePatchInfo, String str) {
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", file.getAbsolutePath(), str);
    }

    @Override // com.tencent.tinker.lib.d.d
    public void a(File file, File file2, String str, int i2) {
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", ShareTinkerInternals.getTypeString(i2), file.getPath(), file2.getPath(), str);
        a.lk(this.context).ae(file);
    }

    @Override // com.tencent.tinker.lib.d.d
    public void a(File file, List<File> list, Throwable th) {
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", file.getAbsolutePath(), Integer.valueOf(list.size()));
        ShareTinkerLog.printErrStackTrace("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL) || th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL)) {
            SjI = true;
            for (File file2 : list) {
                SharePatchFileUtil.safeDeleteFile(file2);
            }
            return;
        }
        a.lk(this.context).ae(file);
    }

    @Override // com.tencent.tinker.lib.d.d
    public void a(File file, boolean z, long j2) {
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j2));
        if (!SjI) {
            c lp = c.lp(this.context);
            if (!lp.Skt) {
                ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
            } else if (lp.Skv.exists()) {
                SharePatchFileUtil.safeDeleteFile(lp.Skv);
            }
        }
    }

    @Override // com.tencent.tinker.lib.d.d
    public void b(File file, String str, String str2) {
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", str, str2);
        a.lk(this.context).dZn();
    }

    @Override // com.tencent.tinker.lib.d.d
    public void a(File file, Throwable th) {
        ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", file.getAbsolutePath(), th.getMessage());
        ShareTinkerLog.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        ShareTinkerLog.printErrStackTrace("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        a.lk(this.context).tinkerFlags = 0;
        a.lk(this.context).ae(file);
    }
}
