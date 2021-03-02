package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public class DefaultTinkerResultService extends AbstractResultService {
    @Override // com.tencent.tinker.lib.service.AbstractResultService
    public void a(a aVar) {
        if (aVar == null) {
            ShareTinkerLog.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        ShareTinkerLog.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", aVar.toString());
        b.ll(getApplicationContext());
        if (aVar.isSuccess) {
            ad(new File(aVar.SjJ));
            if (b(aVar)) {
                Process.killProcess(Process.myPid());
            } else {
                ShareTinkerLog.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }

    public static void ad(File file) {
        if (SharePatchFileUtil.isLegalFile(file)) {
            ShareTinkerLog.w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", file.getPath());
            String name = file.getName();
            if (!name.startsWith(ShareConstants.PATCH_BASE_NAME) || !name.endsWith(".apk")) {
                SharePatchFileUtil.safeDeleteFile(file);
                return;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.getName().startsWith(ShareConstants.PATCH_BASE_NAME)) {
                SharePatchFileUtil.safeDeleteFile(file);
                return;
            }
            File parentFile2 = parentFile.getParentFile();
            if (!parentFile2.getName().equals(ShareConstants.PATCH_DIRECTORY_NAME) && !parentFile2.getName().equals(ShareConstants.PATCH_DIRECTORY_NAME_SPEC)) {
                SharePatchFileUtil.safeDeleteFile(file);
            }
        }
    }

    public final boolean b(a aVar) {
        d dVar;
        a lk = a.lk(getApplicationContext());
        if (lk.Ska && (dVar = lk.SjZ) != null) {
            String str = dVar.Ske;
            if (aVar.SjM == null || !aVar.SjM.equals(str)) {
                return true;
            }
            return false;
        }
        return true;
    }
}
