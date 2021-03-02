package com.tencent.mm.sdk.platformtools;

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
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellIdentityGsm;
import android.telephony.CellInfoGsm;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NetStatusUtil {
    public static final String CELL_CDMA = "cdma";
    public static final String CELL_GSM = "gsm";
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    private static int INVAL_STRENGTH = 10000;
    public static final int IOS_NETTYPE_2G = 2;
    public static final int IOS_NETTYPE_3G = 3;
    public static final int IOS_NETTYPE_4G = 4;
    public static final int IOS_NETTYPE_UNKNOW = 0;
    public static final int IOS_NETTYPE_WIFI = 1;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_WIFI = 1;
    public static final int NETWORK_TYPE_NR = 20;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int NO_SIM_OPERATOR = 0;
    public static final int OLD_IOS_NETTYPE_2G = 3;
    public static final int OLD_IOS_NETTYPE_3G = 4;
    public static final int OLD_IOS_NETTYPE_4G = 5;
    public static final int OLD_IOS_NETTYPE_NOT_WIFI = 0;
    public static final int OLD_IOS_NETTYPE_WAP = 2;
    public static final int OLD_IOS_NETTYPE_WIFI = 1;
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
    private static int nowStrength = 10000;
    private static PhoneStateListener phoneListener = null;
    private static int phoneType = -1;
    private byte _hellAccFlag_;

    public static String dumpNetStatus(Context context) {
        AppMethodBeat.i(157730);
        StringBuilder sb = new StringBuilder();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            sb.append("isAvailable " + activeNetworkInfo.isAvailable() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("isAvailable " + activeNetworkInfo.isAvailable() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("isConnected " + activeNetworkInfo.isConnected() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("isRoaming " + activeNetworkInfo.isRoaming() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("isFailover " + activeNetworkInfo.isFailover() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("getSubtypeName " + activeNetworkInfo.getSubtypeName() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("getSubtype " + activeNetworkInfo.getSubtype() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("getType " + activeNetworkInfo.getType() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("getExtraInfo " + activeNetworkInfo.getExtraInfo() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("activeNetInfo " + activeNetworkInfo.toString() + APLogFileUtil.SEPARATOR_LINE);
            sb.append("is2G " + is2G(context) + APLogFileUtil.SEPARATOR_LINE);
            sb.append("is3G " + is3G(context) + APLogFileUtil.SEPARATOR_LINE);
            sb.append("is4G " + is4G(context) + APLogFileUtil.SEPARATOR_LINE);
            sb.append("isWifi " + isWifi(context) + APLogFileUtil.SEPARATOR_LINE);
            Log.i(TAG, "netstatus " + sb.toString());
        } catch (Exception e2) {
            Log.i(TAG, e2.getMessage());
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(157730);
        return sb2;
    }

    public static boolean isConnected(Context context) {
        boolean z;
        AppMethodBeat.i(157731);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(157731);
            return false;
        }
        try {
            z = connectivityManager.getActiveNetworkInfo().isConnected();
        } catch (Exception e2) {
            z = false;
        }
        AppMethodBeat.o(157731);
        return z;
    }

    public static String getNetTypeString(Context context) {
        AppMethodBeat.i(157732);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(157732);
                return "NON_NETWORK";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157732);
                return "NON_NETWORK";
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157732);
                return "WIFI";
            } else {
                Log.d(TAG, "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
                if (activeNetworkInfo.getExtraInfo() != null) {
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    AppMethodBeat.o(157732);
                    return extraInfo;
                }
                AppMethodBeat.o(157732);
                return "MOBILE";
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157732);
            return "NON_NETWORK";
        }
    }

    public static String getFormatedNetType(Context context) {
        AppMethodBeat.i(157733);
        if (is2G(context)) {
            AppMethodBeat.o(157733);
            return "2G";
        } else if (is3G(context)) {
            AppMethodBeat.o(157733);
            return "3G";
        } else if (is4G(context)) {
            AppMethodBeat.o(157733);
            return "4G";
        } else if (is5G(context)) {
            AppMethodBeat.o(157733);
            return "5G";
        } else if (isWifi(context)) {
            AppMethodBeat.o(157733);
            return "WIFI";
        } else {
            String netTypeString = getNetTypeString(context);
            AppMethodBeat.o(157733);
            return netTypeString;
        }
    }

    public static int getIOSNetType(Context context) {
        AppMethodBeat.i(157734);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157734);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157734);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.o(157734);
                return 2;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.o(157734);
                return 4;
            } else {
                if (activeNetworkInfo.getSubtype() >= 3) {
                    AppMethodBeat.o(157734);
                    return 3;
                }
                AppMethodBeat.o(157734);
                return 0;
            }
        } catch (Exception e2) {
        }
    }

    public static int getIOSOldNetType(Context context) {
        AppMethodBeat.i(157735);
        try {
            int netType = getNetType(context);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157735);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157735);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.o(157735);
                return 3;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.o(157735);
                return 5;
            } else if (activeNetworkInfo.getSubtype() >= 3) {
                AppMethodBeat.o(157735);
                return 4;
            } else {
                if (isWap(netType)) {
                    AppMethodBeat.o(157735);
                    return 2;
                }
                AppMethodBeat.o(157735);
                return 0;
            }
        } catch (Exception e2) {
        }
    }

    public static int getNetWorkType(Context context) {
        AppMethodBeat.i(157736);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                AppMethodBeat.o(157736);
                return type;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(157736);
        return -1;
    }

    public static int getNetType(Context context) {
        AppMethodBeat.i(157737);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(157737);
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(157737);
            return -1;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(157737);
            return 0;
        } else {
            Log.d(TAG, "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
            if (activeNetworkInfo.getExtraInfo() != null) {
                if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
                    AppMethodBeat.o(157737);
                    return 1;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
                    AppMethodBeat.o(157737);
                    return 2;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
                    AppMethodBeat.o(157737);
                    return 3;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
                    AppMethodBeat.o(157737);
                    return 4;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
                    AppMethodBeat.o(157737);
                    return 5;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
                    AppMethodBeat.o(157737);
                    return 6;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
                    AppMethodBeat.o(157737);
                    return 7;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
                    AppMethodBeat.o(157737);
                    return 8;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE")) {
                    AppMethodBeat.o(157737);
                    return 10;
                }
            }
            AppMethodBeat.o(157737);
            return 9;
        }
    }

    public static int getISPCode(Context context) {
        AppMethodBeat.i(157738);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            AppMethodBeat.o(157738);
            return 0;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            AppMethodBeat.o(157738);
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
            int intValue = Integer.valueOf(sb.toString()).intValue();
            AppMethodBeat.o(157738);
            return intValue;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157738);
            return 0;
        }
    }

    public static String getISPName(Context context) {
        AppMethodBeat.i(157739);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                AppMethodBeat.o(157739);
                return "";
            }
            Log.d(TAG, "getISPName ISPName=%s", telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimOperatorName().length() <= 100) {
                String simOperatorName = telephonyManager.getSimOperatorName();
                AppMethodBeat.o(157739);
                return simOperatorName;
            }
            String substring = telephonyManager.getSimOperatorName().substring(0, 100);
            AppMethodBeat.o(157739);
            return substring;
        } catch (Exception e2) {
            AppMethodBeat.o(157739);
            return "";
        }
    }

    public static int guessNetSpeed(Context context) {
        AppMethodBeat.i(230359);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(230359);
                return ShareConstants.MD5_FILE_BUF_LENGTH;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                    AppMethodBeat.o(230359);
                    return 4096;
                case 2:
                    AppMethodBeat.o(230359);
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
                    AppMethodBeat.o(230359);
                    return ShareConstants.MD5_FILE_BUF_LENGTH;
            }
            AppMethodBeat.o(230359);
            return ShareConstants.MD5_FILE_BUF_LENGTH;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
    }

    public static boolean isMobile(Context context) {
        AppMethodBeat.i(157740);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157740);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157740);
                return false;
            } else {
                AppMethodBeat.o(157740);
                return true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157740);
            return false;
        }
    }

    public static boolean isMobileNetworkOpen(Context context) {
        AppMethodBeat.i(230360);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                Method method = connectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]);
                method.setAccessible(true);
                boolean booleanValue = ((Boolean) method.invoke(connectivityManager, new Object[0])).booleanValue();
                AppMethodBeat.o(230360);
                return booleanValue;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(230360);
        return false;
    }

    public static boolean is2G(Context context) {
        AppMethodBeat.i(157741);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157741);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157741);
                return false;
            } else {
                Log.d(TAG, "is2G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                    AppMethodBeat.o(157741);
                    return true;
                }
                AppMethodBeat.o(157741);
                return false;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
    }

    public static boolean is4G(Context context) {
        AppMethodBeat.i(157742);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157742);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157742);
                return false;
            } else {
                Log.d(TAG, "is4G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() >= 13 && activeNetworkInfo.getSubtype() < 20) {
                    AppMethodBeat.o(157742);
                    return true;
                }
                AppMethodBeat.o(157742);
                return false;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
    }

    public static boolean is5G(Context context) {
        AppMethodBeat.i(230361);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(230361);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(230361);
                return false;
            } else {
                Log.d(TAG, "is5G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() >= 20) {
                    AppMethodBeat.o(230361);
                    return true;
                }
                AppMethodBeat.o(230361);
                return false;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
    }

    public static boolean isWap(Context context) {
        AppMethodBeat.i(157743);
        boolean isWap = isWap(getNetType(context));
        AppMethodBeat.o(157743);
        return isWap;
    }

    public static boolean isWap(int i2) {
        if (i2 == 2 || i2 == 5 || i2 == 7 || i2 == 3) {
            return true;
        }
        return false;
    }

    public static boolean is3G(Context context) {
        AppMethodBeat.i(157744);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157744);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157744);
                return false;
            } else {
                Log.d(TAG, "is3G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                    AppMethodBeat.o(157744);
                    return true;
                }
                AppMethodBeat.o(157744);
                return false;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
    }

    public static boolean isWifi(Context context) {
        AppMethodBeat.i(157745);
        boolean isWifi = isWifi(getNetType(context));
        AppMethodBeat.o(157745);
        return isWifi;
    }

    public static boolean isWifi(int i2) {
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    public static WifiInfo getWifiInfo(Context context) {
        AppMethodBeat.i(157746);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(157746);
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                AppMethodBeat.o(157746);
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                AppMethodBeat.o(157746);
                return null;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            AppMethodBeat.o(157746);
            return connectionInfo;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157746);
            return null;
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        AppMethodBeat.i(157747);
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                Log.e(TAG, "package  size" + installedPackages.size());
                for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                    try {
                        Log.e(TAG, "package " + installedPackages.get(i2).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(installedPackages.get(i2).packageName);
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                Log.e(TAG, "activityName count ".concat(String.valueOf(size)));
                                for (int i3 = 0; i3 < size; i3++) {
                                    ActivityInfo activityInfo = queryIntentActivities.get(i3).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        a bl = new a().bl(intent2);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        context.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(157747);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Exception e2) {
                                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e3) {
                        Log.printErrStackTrace(TAG, e3, "", new Object[0]);
                    }
                }
            }
        } catch (Exception e4) {
            Log.printErrStackTrace(TAG, e4, "", new Object[0]);
        }
        AppMethodBeat.o(157747);
        return null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void startSettingItent(Context context, int i2) {
        AppMethodBeat.i(157748);
        switch (i2) {
            case 0:
                AppMethodBeat.o(157748);
                return;
            case 1:
                try {
                    Intent intent = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(157748);
                    return;
                } catch (Exception e2) {
                    searchIntentByClass(context, "DevelopmentSettings");
                    AppMethodBeat.o(157748);
                    return;
                }
            case 2:
                try {
                    Intent intent2 = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                    intent2.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent2.setAction("android.intent.action.VIEW");
                    a bl2 = new a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(157748);
                    return;
                } catch (Exception e3) {
                    try {
                        Intent intent3 = new Intent(FilePathGenerator.ANDROID_DIR_SEP);
                        intent3.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                        intent3.setAction("android.intent.action.VIEW");
                        a bl3 = new a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl3.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(157748);
                        return;
                    } catch (Exception e4) {
                        searchIntentByClass(context, "ManageAccountsSettings");
                        AppMethodBeat.o(157748);
                        return;
                    }
                }
            case 3:
                try {
                    Intent intent4 = new Intent();
                    intent4.setAction("android.settings.WIFI_IP_SETTINGS");
                    a bl4 = new a().bl(intent4);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl4.axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl4.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(157748);
                    return;
                } catch (Exception e5) {
                    searchIntentByClass(context, "AdvancedSettings");
                    break;
                }
        }
        AppMethodBeat.o(157748);
    }

    public static int getWifiSleeepPolicy(Context context) {
        AppMethodBeat.i(230362);
        int i2 = Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
        AppMethodBeat.o(230362);
        return i2;
    }

    public static String getConnectedWifiSsid(Context context) {
        String str;
        AppMethodBeat.i(157749);
        if (getNetType(context) != 0) {
            Log.i(TAG, "wifi not connected. getConnectedWifiSsid() is empty");
            AppMethodBeat.o(157749);
            return "";
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            AppMethodBeat.o(157749);
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            AppMethodBeat.o(157749);
            return "";
        }
        String ssid = connectionInfo.getSSID();
        if (Build.VERSION.SDK_INT >= 27) {
            try {
                List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
                if (configuredNetworks != null) {
                    Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WifiConfiguration next = it.next();
                        if (next.networkId == connectionInfo.getNetworkId()) {
                            Log.i(TAG, "get wifi config ssid %s", next.SSID);
                            str = next.SSID;
                            break;
                        }
                    }
                }
                str = ssid;
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "get wifi ssid fail", new Object[0]);
            }
            String nullAsNil = Util.nullAsNil(str);
            Log.i(TAG, "getConnectedWifiSsid()=" + removeSsidQuote(nullAsNil));
            String removeSsidQuote = removeSsidQuote(nullAsNil);
            AppMethodBeat.o(157749);
            return removeSsidQuote;
        }
        str = ssid;
        String nullAsNil2 = Util.nullAsNil(str);
        Log.i(TAG, "getConnectedWifiSsid()=" + removeSsidQuote(nullAsNil2));
        String removeSsidQuote2 = removeSsidQuote(nullAsNil2);
        AppMethodBeat.o(157749);
        return removeSsidQuote2;
    }

    public static String getConnectedWifiBssid(Context context) {
        AppMethodBeat.i(157750);
        if (getNetType(context) != 0) {
            Log.i(TAG, "wifi not connected. getConnectedWifiBssid() is empty");
            AppMethodBeat.o(157750);
            return "";
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            AppMethodBeat.o(157750);
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            AppMethodBeat.o(157750);
            return "";
        }
        String lowerCase = Util.nullAsNil(connectionInfo.getBSSID()).toLowerCase();
        Log.i(TAG, "getConnectedWifiBssid()=".concat(String.valueOf(lowerCase)));
        AppMethodBeat.o(157750);
        return lowerCase;
    }

    public static String getConnectedWifiClientMac(Context context) {
        AppMethodBeat.i(157751);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            Log.e(TAG, "error wifiManager is null!!");
            AppMethodBeat.o(157751);
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            Log.e(TAG, "error wifiInfo is null!!");
            AppMethodBeat.o(157751);
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (Build.VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = getMacAddressFromNet();
        }
        String lowerCase = Util.nullAsNil(macAddress).toLowerCase();
        Log.i(TAG, "getConnectedWifiClientMac()=".concat(String.valueOf(lowerCase)));
        AppMethodBeat.o(157751);
        return lowerCase;
    }

    public static String getMacAddressFromNet() {
        AppMethodBeat.i(157752);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (NetworkInterface.getNetworkInterfaces() != null) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            Log.d(TAG, "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.o(157752);
                            return "02:00:00:00:00:00";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        Log.d(TAG, "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        String sb2 = sb.toString();
                        AppMethodBeat.o(157752);
                        return sb2;
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(TAG, "get mobile mac from net fail!".concat(String.valueOf(e2)));
        }
        Log.d(TAG, "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(157752);
        return "02:00:00:00:00:00";
    }

    public static String removeSsidQuote(String str) {
        AppMethodBeat.i(157753);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157753);
            return "";
        } else if (str.equals("<unknown ssid>")) {
            AppMethodBeat.o(157753);
            return "";
        } else {
            if (str.startsWith("\"") && str.endsWith("\"")) {
                str = str.substring(1, str.length() - 1);
            }
            AppMethodBeat.o(157753);
            return str;
        }
    }

    public static boolean isLimited(int i2) {
        if (i2 == 2 || i2 == 1 || i2 == 3) {
            return true;
        }
        return false;
    }

    public static int getBackgroundLimitType(Context context) {
        AppMethodBeat.i(157754);
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    AppMethodBeat.o(157754);
                    return 1;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        try {
            int wifiSleeepPolicy = getWifiSleeepPolicy(context);
            if (wifiSleeepPolicy == 2 || getNetType(context) != 0) {
                AppMethodBeat.o(157754);
                return 0;
            }
            if (wifiSleeepPolicy == 1 || wifiSleeepPolicy == 0) {
                AppMethodBeat.o(157754);
                return 3;
            }
            AppMethodBeat.o(157754);
            return 0;
        } catch (Exception e3) {
            Log.printErrStackTrace(TAG, e3, "", new Object[0]);
        }
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        AppMethodBeat.i(230363);
        if (Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0) {
            AppMethodBeat.o(230363);
            return true;
        }
        AppMethodBeat.o(230363);
        return false;
    }

    public static int getProxyInfo(Context context, StringBuffer stringBuffer) {
        AppMethodBeat.i(230364);
        try {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            Log.d(TAG, "dkwap api host:%s port:%d thr:%d", defaultHost, Integer.valueOf(defaultPort), Long.valueOf(Thread.currentThread().getId()));
            if (defaultHost == null || defaultHost.length() <= 0 || defaultPort <= 0) {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                Log.d(TAG, "dkwap vm host:%s port:%s thr:%d", property, property2, Long.valueOf(Thread.currentThread().getId()));
                int i2 = 80;
                if (property2 != null && property2.length() > 0) {
                    i2 = Integer.parseInt(property2);
                }
                if (property != null && property.length() > 0) {
                    stringBuffer.append(property);
                    AppMethodBeat.o(230364);
                    return i2;
                }
                AppMethodBeat.o(230364);
                return 0;
            }
            stringBuffer.append(defaultHost);
            AppMethodBeat.o(230364);
            return defaultPort;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
    }

    public static boolean isKnownDirectNet(Context context) {
        AppMethodBeat.i(230365);
        int netType = getNetType(context);
        if (6 == netType || 1 == netType || 4 == netType || 8 == netType || 10 == netType || netType == 0) {
            AppMethodBeat.o(230365);
            return true;
        }
        AppMethodBeat.o(230365);
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        AppMethodBeat.i(157755);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(157755);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(157755);
            return false;
        } else if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            AppMethodBeat.o(157755);
            return false;
        } else {
            AppMethodBeat.o(157755);
            return true;
        }
    }

    public static int getNetTypeForStat(Context context) {
        AppMethodBeat.i(157756);
        if (context == null) {
            AppMethodBeat.o(157756);
            return 999;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(157756);
                return 999;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(157756);
                return 999;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(157756);
                return 1;
            } else {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 0) {
                    AppMethodBeat.o(157756);
                    return 999;
                }
                int i2 = subtype * 1000;
                AppMethodBeat.o(157756);
                return i2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157756);
            return 999;
        }
    }

    public static boolean isWifiOr4G(Context context) {
        AppMethodBeat.i(157757);
        int netType = getNetType(context);
        if (netType == 0 || netType == 10) {
            Log.d(TAG, "[cpan] is wifi or 4g network");
            AppMethodBeat.o(157757);
            return true;
        }
        Log.d(TAG, "[cpan] is mobile network");
        AppMethodBeat.o(157757);
        return false;
    }

    public static class CellInfo {
        public static final int MAX_CID = 65535;
        public static final int MAX_LAC = 65535;
        public String cellid;
        public String dbm;
        public String lac;
        public String mcc;
        public String mnc;
        public String networkId;
        public String stationId;
        public String systemId;
        public String type;

        public CellInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            this.mcc = str;
            this.mnc = str2;
            this.lac = str3;
            this.type = str6;
            this.cellid = str4;
            this.stationId = str7;
            this.networkId = str8;
            this.systemId = str9;
            this.dbm = str5;
        }
    }

    public static class MacInfo {
        public String dbm;
        public String mac;

        public MacInfo(String str, String str2) {
            this.mac = str;
            this.dbm = str2;
        }
    }

    public static synchronized void initMobileStrengthListener(Context context) {
        synchronized (NetStatusUtil.class) {
            AppMethodBeat.i(157758);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            phoneType = telephonyManager.getPhoneType();
            if (phoneListener == null) {
                phoneListener = new PhoneStateListener() {
                    /* class com.tencent.mm.sdk.platformtools.NetStatusUtil.AnonymousClass1 */

                    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                        AppMethodBeat.i(157729);
                        super.onSignalStrengthsChanged(signalStrength);
                        if (NetStatusUtil.phoneType == 2) {
                            int unused = NetStatusUtil.nowStrength = signalStrength.getCdmaDbm();
                        }
                        if (NetStatusUtil.phoneType == 1) {
                            int unused2 = NetStatusUtil.nowStrength = (signalStrength.getGsmSignalStrength() * 2) + ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS;
                        }
                        Log.i(NetStatusUtil.TAG, "PhoneStateListener  type:%d  strength:%d", Integer.valueOf(NetStatusUtil.phoneType), Integer.valueOf(NetStatusUtil.nowStrength));
                        AppMethodBeat.o(157729);
                    }
                };
                a bl = c.a(256, new a()).bl(phoneListener);
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "initMobileStrengthListener", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "initMobileStrengthListener", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
            AppMethodBeat.o(157758);
        }
    }

    public static synchronized int getStrength(Context context) {
        int i2;
        synchronized (NetStatusUtil.class) {
            AppMethodBeat.i(157759);
            if (context == null) {
                AppMethodBeat.o(157759);
                i2 = 0;
            } else {
                try {
                    if (getNetTypeForStat(context) == 1) {
                        i2 = Math.abs(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi());
                        AppMethodBeat.o(157759);
                    } else {
                        if (phoneListener == null) {
                            Log.e(TAG, "getStrength phone Listener has not been inited");
                        }
                        i2 = Math.abs(nowStrength);
                        AppMethodBeat.o(157759);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    AppMethodBeat.o(157759);
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    public static synchronized List<CellInfo> getCellInfoList(Context context) {
        LinkedList linkedList;
        String str;
        synchronized (NetStatusUtil.class) {
            AppMethodBeat.i(157760);
            if (phoneListener == null) {
                Log.e(TAG, "getStrength phone Listener has not been inited");
                linkedList = null;
                AppMethodBeat.o(157760);
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                LinkedList linkedList2 = new LinkedList();
                String str2 = "460";
                String str3 = "";
                try {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (networkOperator == null || networkOperator.equals("")) {
                        String simOperator = telephonyManager.getSimOperator();
                        if (simOperator != null && !simOperator.equals("")) {
                            str2 = simOperator.substring(0, 3);
                            str3 = simOperator.substring(3, 5);
                        }
                        str = str3;
                    } else {
                        str2 = networkOperator.substring(0, 3);
                        str = networkOperator.substring(3, 5);
                    }
                    if (telephonyManager.getPhoneType() == 2) {
                        try {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                            if (cdmaCellLocation != null) {
                                String sb = nowStrength == INVAL_STRENGTH ? "" : new StringBuilder().append(nowStrength).toString();
                                if (!(cdmaCellLocation.getBaseStationId() == -1 || cdmaCellLocation.getNetworkId() == -1 || cdmaCellLocation.getSystemId() == -1)) {
                                    linkedList2.add(new CellInfo(str2, str, "", "", sb, CELL_CDMA, new StringBuilder().append(cdmaCellLocation.getBaseStationId()).toString(), new StringBuilder().append(cdmaCellLocation.getNetworkId()).toString(), new StringBuilder().append(cdmaCellLocation.getSystemId()).toString()));
                                }
                            }
                        } catch (Exception e2) {
                            try {
                                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                                if (gsmCellLocation != null) {
                                    int cid = gsmCellLocation.getCid();
                                    int lac = gsmCellLocation.getLac();
                                    if (!(lac >= 65535 || lac == -1 || cid == -1)) {
                                        linkedList2.add(new CellInfo(str2, str, String.valueOf(lac), String.valueOf(cid), "", CELL_GSM, "", "", ""));
                                    }
                                }
                            } catch (Exception e3) {
                                Log.printErrStackTrace(TAG, e3, "", new Object[0]);
                            }
                            List<android.telephony.CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                            if (allCellInfo != null && allCellInfo.size() > 0) {
                                for (android.telephony.CellInfo cellInfo : allCellInfo) {
                                    if (cellInfo instanceof CellInfoGsm) {
                                        CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                                        if (!(cellIdentity.getCid() == -1 || cellIdentity.getLac() > 65535 || cellIdentity.getLac() == -1)) {
                                            linkedList2.add(new CellInfo(str2, str, new StringBuilder().append(cellIdentity.getLac()).toString(), new StringBuilder().append(cellIdentity.getCid()).toString(), new StringBuilder().append((((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel() * 2) + ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS).toString(), CELL_GSM, "", "", ""));
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        try {
                            GsmCellLocation gsmCellLocation2 = (GsmCellLocation) telephonyManager.getCellLocation();
                            if (gsmCellLocation2 != null) {
                                int cid2 = gsmCellLocation2.getCid();
                                int lac2 = gsmCellLocation2.getLac();
                                if (!(lac2 >= 65535 || lac2 == -1 || cid2 == -1)) {
                                    linkedList2.add(new CellInfo(str2, str, String.valueOf(lac2), String.valueOf(cid2), nowStrength == INVAL_STRENGTH ? "" : new StringBuilder().append(nowStrength).toString(), CELL_GSM, "", "", ""));
                                }
                            }
                        } catch (Exception e4) {
                            Log.printErrStackTrace(TAG, e4, "", new Object[0]);
                        }
                        List<android.telephony.CellInfo> allCellInfo2 = telephonyManager.getAllCellInfo();
                        if (allCellInfo2 != null && allCellInfo2.size() > 0) {
                            for (android.telephony.CellInfo cellInfo2 : allCellInfo2) {
                                if (cellInfo2 instanceof CellInfoGsm) {
                                    CellIdentityGsm cellIdentity2 = ((CellInfoGsm) cellInfo2).getCellIdentity();
                                    if (cellIdentity2.getCid() != -1 && cellIdentity2.getLac() <= 65535) {
                                        String sb2 = new StringBuilder().append((((CellInfoGsm) cellInfo2).getCellSignalStrength().getAsuLevel() * 2) + ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS).toString();
                                        Log.v("checked", "lac:" + cellIdentity2.getLac() + "  cid:" + cellIdentity2.getCid() + " dbm:" + sb2);
                                        linkedList2.add(new CellInfo(str2, str, new StringBuilder().append(cellIdentity2.getLac()).toString(), new StringBuilder().append(cellIdentity2.getCid()).toString(), sb2, CELL_GSM, "", "", ""));
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(157760);
                    linkedList = linkedList2;
                } catch (Exception e5) {
                    Log.printErrStackTrace(TAG, e5, "", new Object[0]);
                    AppMethodBeat.o(157760);
                    linkedList = linkedList2;
                }
            }
        }
        return linkedList;
    }
}
