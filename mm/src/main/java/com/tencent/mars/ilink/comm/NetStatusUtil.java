package com.tencent.mars.ilink.comm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.List;

public class NetStatusUtil {
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_WIFI = 1;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int NO_SIM_OPERATOR = 0;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    private static final String TAG = "MicroMsg.NetStatusUtil";
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int UNKNOW_TYPE = 999;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;
    private static int nowStrength = 0;
    private byte _hellAccFlag_;

    public static void dumpNetStatus(Context context) {
        try {
            Log.i(TAG, ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().toString());
        } catch (Exception e2) {
            Log.e(TAG, "", e2);
        }
    }

    public static boolean isConnected(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (Exception e2) {
            return false;
        }
    }

    public static String getNetTypeString(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "NON_NETWORK";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo();
        }
        return "MOBILE";
    }

    public static int getNetWorkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
        } catch (Exception e2) {
        }
        return -1;
    }

    public static int getNetType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 0;
        }
        if (activeNetworkInfo.getExtraInfo() != null) {
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
                return 1;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
                return 2;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
                return 3;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
                return 4;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
                return 5;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
                return 6;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
                return 7;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
                return 8;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE")) {
                return 10;
            }
        }
        return 9;
    }

    public static int getISPCode(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return 0;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        try {
            int length = simOperator.length();
            if (length > 6) {
                length = 6;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isDigit(simOperator.charAt(i2))) {
                    if (sb.length() > 0) {
                        break;
                    }
                } else {
                    sb.append(simOperator.charAt(i2));
                }
            }
            return Integer.valueOf(sb.toString()).intValue();
        } catch (Exception e2) {
            return 0;
        }
    }

    public static String getISPName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        if (telephonyManager.getSimOperatorName().length() <= 100) {
            return telephonyManager.getSimOperatorName();
        }
        return telephonyManager.getSimOperatorName().substring(0, 100);
    }

    public static int guessNetSpeed(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return ShareConstants.MD5_FILE_BUF_LENGTH;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                    return 4096;
                case 2:
                    return 8192;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    return ShareConstants.MD5_FILE_BUF_LENGTH;
            }
            return ShareConstants.MD5_FILE_BUF_LENGTH;
        } catch (Exception e2) {
        }
    }

    public static boolean isMobile(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() != 1;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean is2G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                return true;
            }
            return false;
        } catch (Exception e2) {
        }
    }

    public static boolean is4G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() >= 13) {
                return true;
            }
            return false;
        } catch (Exception e2) {
        }
    }

    public static boolean isWap(Context context) {
        return isWap(getNetType(context));
    }

    public static boolean isWap(int i2) {
        return i2 == 2 || i2 == 5 || i2 == 7 || i2 == 3;
    }

    public static boolean is3G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                return true;
            }
            return false;
        } catch (Exception e2) {
        }
    }

    public static boolean isWifi(Context context) {
        return isWifi(getNetType(context));
    }

    public static boolean isWifi(int i2) {
        return i2 == 0;
    }

    public static WifiInfo getWifiInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            return wifiManager.getConnectionInfo();
        } catch (Exception e2) {
            return null;
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(installedPackages.get(i2).packageName);
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            for (int i3 = 0; i3 < size; i3++) {
                                try {
                                    ActivityInfo activityInfo = queryIntentActivities.get(i3).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        a bl = new a().bl(intent2);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        context.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mars/ilink/comm/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        return intent2;
                                    }
                                } catch (Exception e2) {
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Exception e4) {
        }
        return null;
    }

    public static void startSettingItent(Context context, int i2) {
        switch (i2) {
            case 0:
            default:
                return;
            case 1:
                try {
                    Intent intent = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    return;
                } catch (Exception e2) {
                    searchIntentByClass(context, "DevelopmentSettings");
                    return;
                }
            case 2:
                try {
                    Intent intent2 = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                    intent2.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent2.setAction("android.intent.action.VIEW");
                    a bl2 = new a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    return;
                } catch (Exception e3) {
                    try {
                        Intent intent3 = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                        intent3.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                        intent3.setAction("android.intent.action.VIEW");
                        a bl3 = new a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl3.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        return;
                    } catch (Exception e4) {
                        searchIntentByClass(context, "ManageAccountsSettings");
                        return;
                    }
                }
            case 3:
                try {
                    Intent intent4 = new Intent();
                    intent4.setAction("android.settings.WIFI_IP_SETTINGS");
                    a bl4 = new a().bl(intent4);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl4.axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl4.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mars/ilink/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    return;
                } catch (Exception e5) {
                    searchIntentByClass(context, "AdvancedSettings");
                    return;
                }
        }
    }

    public static int getWifiSleeepPolicy(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
    }

    public static boolean isLimited(int i2) {
        return i2 == 2 || i2 == 1 || i2 == 3;
    }

    public static int getBackgroundLimitType(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    return 1;
                }
            } catch (Exception e2) {
            }
        }
        try {
            int wifiSleeepPolicy = getWifiSleeepPolicy(context);
            if (wifiSleeepPolicy == 2 || getNetType(context) != 0) {
                return 0;
            }
            if (wifiSleeepPolicy == 1 || wifiSleeepPolicy == 0) {
                return 3;
            }
            return 0;
        } catch (Exception e3) {
        }
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0;
    }

    public static int getProxyInfo(Context context, StringBuffer stringBuffer) {
        try {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost == null || defaultHost.length() <= 0 || defaultPort <= 0) {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                int i2 = 80;
                if (property2 != null && property2.length() > 0) {
                    i2 = Integer.parseInt(property2);
                }
                if (property != null && property.length() > 0) {
                    stringBuffer.append(property);
                    return i2;
                }
                return 0;
            }
            stringBuffer.append(defaultHost);
            return defaultPort;
        } catch (Exception e2) {
        }
    }

    public static boolean isKnownDirectNet(Context context) {
        int netType = getNetType(context);
        if (6 == netType || 1 == netType || 4 == netType || 8 == netType || 10 == netType || netType == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }

    public static class StrengthListener extends PhoneStateListener {
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (!signalStrength.isGsm()) {
                int unused = NetStatusUtil.nowStrength = signalStrength.getCdmaDbm();
            } else {
                int unused2 = NetStatusUtil.nowStrength = signalStrength.getGsmSignalStrength();
            }
        }
    }

    public static int getNetTypeForStat(Context context) {
        if (context == null) {
            return 999;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 999;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 999;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 0) {
                return 999;
            }
            return subtype * 1000;
        } catch (Exception e2) {
            return 999;
        }
    }

    public static int getStrength(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (getNetTypeForStat(context) == 1) {
                return Math.abs(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi());
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            a bl = c.a(256, new a()).bl(new StrengthListener());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mars/ilink/comm/NetStatusUtil", "getStrength", "(Landroid/content/Context;)I", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mars/ilink/comm/NetStatusUtil", "getStrength", "(Landroid/content/Context;)I", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            return Math.abs(nowStrength);
        } catch (Exception e2) {
            return 0;
        }
    }
}
