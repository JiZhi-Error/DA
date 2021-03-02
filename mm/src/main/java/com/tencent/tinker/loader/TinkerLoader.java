package com.tencent.tinker.loader;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    @Override // com.tencent.tinker.loader.AbstractTinkerLoader
    public Intent tryLoad(TinkerApplication tinkerApplication) {
        ShareTinkerLog.d(TAG, "tryLoad test test", new Object[0]);
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.setIntentPatchCostTime(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x016c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void tryLoadPatchFilesInternal(com.tencent.tinker.loader.app.TinkerApplication r20, android.content.Intent r21) {
        /*
        // Method dump skipped, instructions count: 1217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerLoader.tryLoadPatchFilesInternal(com.tencent.tinker.loader.app.TinkerApplication, android.content.Intent):void");
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        int safeModeCount = ShareTinkerInternals.getSafeModeCount(tinkerApplication);
        if (safeModeCount >= 2) {
            ShareTinkerInternals.setSafeModeCount(tinkerApplication, 0);
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        ShareTinkerInternals.setSafeModeCount(tinkerApplication, safeModeCount + 1);
        return true;
    }
}
