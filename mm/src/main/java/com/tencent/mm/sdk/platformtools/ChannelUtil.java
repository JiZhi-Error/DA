package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class ChannelUtil {
    public static final int AUTO_ADD_ACOUNT_BIND_MOBILE = 1;
    public static final int AUTO_ADD_ACOUNT_NOT_ADD = 0;
    public static final int AUTO_ADD_ACOUNT_NOT_BIND_MOBILE = 2;
    public static final int CHANNEL_ID_CROWDTEST = 1001;
    public static final int CHANNEL_ID_GP = 1;
    public static final int CHANNEL_ID_INVAILD = -1;
    public static final int CHANNEL_ID_OFFICIAL = 0;
    public static final int FLAG_NULL = 0;
    public static final int FLAG_UPDATE_EXTERNAL = 1;
    public static final int FLAG_UPDATE_NOTIP = 2;
    private static final String TAG = "MicroMsg.SDK.ChannelUtil";
    public static int autoAddAccount = 0;
    public static int buildRev = 0;
    public static int channelId = 0;
    public static boolean fullVersionInfo = false;
    public static int historyChannelId = 0;
    public static boolean isNokiaAol = false;
    public static boolean isShowingGprsAlert = true;
    public static String marketURL = ("market://details?id=" + MMApplicationContext.getPackageName());
    public static String profileDeviceType = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
    public static boolean shouldShowGprsAlert = false;
    public static int updateMode = 0;

    static {
        AppMethodBeat.i(125212);
        AppMethodBeat.o(125212);
    }

    private ChannelUtil() {
    }

    public static void setupChannelId(Context context) {
        AppMethodBeat.i(125206);
        try {
            channelId = Integer.parseInt(IniParser.parse(Util.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
            AppMethodBeat.o(125206);
        } catch (Exception e2) {
            Log.e(TAG, "setup channel id from channel.ini failed");
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(125206);
        }
    }

    public static void loadProfile(Context context) {
        AppMethodBeat.i(125207);
        try {
            Map<String, String> parse = IniParser.parse(Util.convertStreamToString(context.getAssets().open("profile.ini")));
            String nullAsNil = Util.nullAsNil(parse.get("PROFILE_DEVICE_TYPE"));
            profileDeviceType = nullAsNil;
            if (nullAsNil.length() <= 0) {
                profileDeviceType = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
            }
            updateMode = parseInt(parse.get("UPDATE_MODE"));
            buildRev = parseInt(parse.get("BUILD_REVISION"));
            shouldShowGprsAlert = parseBoolean(parse.get("GPRS_ALERT"));
            autoAddAccount = parseInt(parse.get("AUTO_ADD_ACOUNT"));
            isNokiaAol = parseBoolean(parse.get("NOKIA_AOL"));
            Log.w(TAG, "profileDeviceType=" + profileDeviceType);
            Log.w(TAG, "updateMode=" + updateMode);
            Log.w(TAG, "shouldShowGprsAlert=" + shouldShowGprsAlert);
            Log.w(TAG, "autoAddAccount=" + autoAddAccount);
            Log.w(TAG, "isNokiaol=" + isNokiaAol);
            String str = parse.get("MARKET_URL");
            if (!(str == null || str.trim().length() == 0 || Uri.parse(str) == null)) {
                marketURL = str;
            }
            Log.w(TAG, "marketURL=" + marketURL);
            AppMethodBeat.o(125207);
        } catch (Exception e2) {
            Log.e(TAG, "setup profile from profile.ini failed");
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(125207);
        }
    }

    private static int parseInt(String str) {
        AppMethodBeat.i(125208);
        try {
            int parseInt = Integer.parseInt(str);
            AppMethodBeat.o(125208);
            return parseInt;
        } catch (Exception e2) {
            Log.w(TAG, e2.getMessage());
            AppMethodBeat.o(125208);
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        AppMethodBeat.i(125209);
        try {
            z = Boolean.parseBoolean(str);
            AppMethodBeat.o(125209);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.w(TAG, e2.getMessage());
            AppMethodBeat.o(125209);
        }
        return z;
    }

    public static String formatVersion(Context context, int i2) {
        AppMethodBeat.i(125210);
        String formatVersion = formatVersion(context, i2, fullVersionInfo);
        AppMethodBeat.o(125210);
        return formatVersion;
    }

    public static String formatVersion(Context context, int i2, boolean z) {
        AppMethodBeat.i(125211);
        if (!Util.isNullOrNil(BuildInfo.OVERRIDE_VERSION_NAME)) {
            String str = BuildInfo.OVERRIDE_VERSION_NAME;
            AppMethodBeat.o(125211);
            return str;
        }
        String formatVersionImpl = formatVersionImpl(context, i2, z);
        AppMethodBeat.o(125211);
        return formatVersionImpl;
    }

    private static String formatVersionImpl(Context context, int i2, boolean z) {
        String str;
        AppMethodBeat.i(200838);
        int i3 = (i2 >> 8) & 255;
        if (i3 == 0) {
            str = ((i2 >> 24) & 15) + "." + ((i2 >> 16) & 255);
        } else {
            str = ((i2 >> 24) & 15) + "." + ((i2 >> 16) & 255) + "." + i3;
        }
        Log.d(TAG, "minminor ".concat(String.valueOf(i3)));
        int i4 = 268435455 & i2;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                if (packageInfo != null) {
                    i4 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        if (z) {
            String str2 = str + "_" + i4;
            Log.d(TAG, "full version: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(200838);
            return str2;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            AppMethodBeat.o(200838);
            return str;
        }
        String str3 = split[0] + "." + split[1];
        if (split[2].trim().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            AppMethodBeat.o(200838);
            return str3;
        }
        String str4 = str3 + "." + split[2];
        AppMethodBeat.o(200838);
        return str4;
    }

    public static boolean isGPVersion() {
        AppMethodBeat.i(200839);
        if (WeChatSomeFeatureSwitch.forceGooglePlayChannel() || channelId == 1) {
            AppMethodBeat.o(200839);
            return true;
        }
        AppMethodBeat.o(200839);
        return false;
    }

    public static boolean isCrowdTestVersion() {
        return channelId == 1001;
    }
}
