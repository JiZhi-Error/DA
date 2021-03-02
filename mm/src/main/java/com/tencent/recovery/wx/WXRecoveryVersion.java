package com.tencent.recovery.wx;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.smtt.sdk.TbsDownloader;

public class WXRecoveryVersion {
    private static String BaseClientVersion = null;

    public static String getBaseClientVersion(Context context) {
        if (context != null && BaseClientVersion == null) {
            try {
                BaseClientVersion = "0x" + Integer.toHexString(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt(TbsDownloader.TBS_METADATA));
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        return BaseClientVersion;
    }
}
