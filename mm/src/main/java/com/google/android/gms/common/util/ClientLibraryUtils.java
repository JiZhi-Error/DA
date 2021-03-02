package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class ClientLibraryUtils {
    public static final int GMS_CLIENT_VERSION_UNKNOWN = -1;

    private ClientLibraryUtils() {
    }

    public static int getClientVersion(Context context, String str) {
        AppMethodBeat.i(5064);
        int clientVersion = getClientVersion(getPackageInfo(context, str));
        AppMethodBeat.o(5064);
        return clientVersion;
    }

    public static int getClientVersion(PackageInfo packageInfo) {
        AppMethodBeat.i(5065);
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            AppMethodBeat.o(5065);
            return -1;
        }
        Bundle bundle = packageInfo.applicationInfo.metaData;
        if (bundle == null) {
            AppMethodBeat.o(5065);
            return -1;
        }
        int i2 = bundle.getInt(GooglePlayServicesUtilLight.KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION, -1);
        AppMethodBeat.o(5065);
        return i2;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        AppMethodBeat.i(5066);
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 128);
            AppMethodBeat.o(5066);
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(5066);
            return null;
        }
    }

    public static boolean isPackageSide() {
        return false;
    }

    public static boolean isPackageStopped(Context context, String str) {
        AppMethodBeat.i(5067);
        "com.google.android.gms".equals(str);
        try {
            if ((Wrappers.packageManager(context).getApplicationInfo(str, 0).flags & TPMediaCodecProfileLevel.HEVCHighTierLevel6) != 0) {
                AppMethodBeat.o(5067);
                return true;
            }
            AppMethodBeat.o(5067);
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(5067);
            return false;
        }
    }
}
