package com.tencent.mm.loader.j;

import android.os.Build;
import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public final class a {
    public static String BUILD_TAG;
    public static String CLIENT_VERSION;
    public static String COMMAND;
    public static String HOSTNAME;
    public static boolean IS_ARM64;
    public static String OWNER;
    public static String REV;
    public static String SVNPATH;
    public static String TIME;
    public static String TINKER_ID;
    public static String icr;
    public static String ics = ("android-" + Build.VERSION.SDK_INT);
    public static String ict;
    public static String icu;

    public static String aKv() {
        return ict == null ? REV : REV + "." + ict;
    }

    public static String aKw() {
        return TINKER_ID;
    }

    public static String aKx() {
        return icu == null ? "" : icu;
    }

    public static boolean aKy() {
        return !"false".equalsIgnoreCase(icr);
    }

    public static void y(Bundle bundle) {
        if (bundle != null) {
            icr = bundle.getBoolean("com.tencent.mm.BuildInfo.PATCH_ENABLED") ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
            REV = bundle.getString("com.tencent.mm.BuildInfo.BUILD_REV");
            CLIENT_VERSION = "0x" + Integer.toHexString(bundle.getInt(TbsDownloader.TBS_METADATA));
            TIME = bundle.getString("com.tencent.mm.BuildInfo.BUILD_TIME");
            HOSTNAME = bundle.getString("com.tencent.mm.BuildInfo.BUILD_HOSTNAME");
            BUILD_TAG = bundle.getString("com.tencent.mm.BuildInfo.BUILD_TAG");
            OWNER = bundle.getString("com.tencent.mm.BuildInfo.BUILD_OWNER");
            COMMAND = bundle.getString("com.tencent.mm.BuildInfo.BUILD_COMMAND");
            SVNPATH = bundle.getString("com.tencent.mm.BuildInfo.BUILD_SVNPATH");
            IS_ARM64 = bundle.getBoolean("com.tencent.mm.BuildInfo.BUILD_IS_ARM64", false);
            TINKER_ID = bundle.getString(ShareConstants.TINKER_ID);
        }
    }
}
