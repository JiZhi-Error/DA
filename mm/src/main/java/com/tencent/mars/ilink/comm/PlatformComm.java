package com.tencent.mars.ilink.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.telephony.TelephonyManager;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm {
    static final int EMobile = 2;
    static final int ENoNet = -1;
    static final int EOtherNet = 3;
    static final int EWifi = 1;
    private static final boolean IS_PROXY_ON = false;
    static final int NETTYPE_2G = 3;
    static final int NETTYPE_3G = 4;
    static final int NETTYPE_4G = 5;
    static final int NETTYPE_NON = -1;
    static final int NETTYPE_NOT_WIFI = 0;
    static final int NETTYPE_UNKNOWN = 6;
    static final int NETTYPE_WAP = 2;
    static final int NETTYPE_WIFI = 1;
    private static final String TAG = "PlatformComm";
    public static Context context = null;
    public static Handler handler = null;

    public static class Assert {
        public static void assertTrue(String str, boolean z) {
        }

        public static void assertTrue(boolean z) {
        }
    }

    /* access modifiers changed from: package-private */
    public static class WifiInfo {
        public String bssid;
        public String ssid;

        WifiInfo() {
        }
    }

    static class SIMInfo {
        public String ispCode;
        public String ispName;

        SIMInfo() {
        }
    }

    static class APNInfo {
        public String extraInfo;
        public int netType;
        public int subNetType;

        APNInfo() {
        }
    }

    public static void init(Context context2, Handler handler2) {
        context = context2;
        handler = handler2;
        NetworkSignalUtil.InitNetworkSignalUtil(context2);
    }

    public static class C2Java {
        private static String exception2String(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        public static int getNetInfo() {
            ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            try {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return 2;
                    case 1:
                        return 1;
                    default:
                        return 3;
                }
            } catch (Exception e2) {
                return 3;
            }
        }

        public static int getProxyInfo(StringBuffer stringBuffer) {
            return -1;
        }

        public static int getStatisticsNetType() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return 0;
            }
            try {
                int netType = NetStatusUtil.getNetType(PlatformComm.context);
                if (netType == -1) {
                    return -1;
                }
                if (NetStatusUtil.is2G(PlatformComm.context)) {
                    return 3;
                }
                if (NetStatusUtil.is3G(PlatformComm.context)) {
                    return 4;
                }
                if (NetStatusUtil.is4G(PlatformComm.context)) {
                    return 5;
                }
                if (NetStatusUtil.isWifi(netType)) {
                    return 1;
                }
                if (NetStatusUtil.isWap(netType)) {
                    return 2;
                }
                return 6;
            } catch (Exception e2) {
                exception2String(e2);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return -1;
            }
        }

        public static boolean startAlarm(int i2, int i3, int i4) {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return Alarm.start(i2, (long) i3, i4, PlatformComm.context);
            } catch (Exception e2) {
                exception2String(e2);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return false;
            }
        }

        public static boolean stopAlarm(int i2) {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return Alarm.stop((long) i2, PlatformComm.context);
            } catch (Exception e2) {
                exception2String(e2);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return false;
            }
        }

        public static WifiInfo getCurWifiInfo() {
            try {
                if (PlatformComm.context == null) {
                    return null;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return null;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                    return null;
                }
                WifiManager wifiManager = (WifiManager) PlatformComm.context.getSystemService("wifi");
                if (wifiManager == null) {
                    return null;
                }
                android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    return null;
                }
                WifiInfo wifiInfo = new WifiInfo();
                wifiInfo.ssid = connectionInfo.getSSID();
                wifiInfo.bssid = connectionInfo.getBSSID();
                return wifiInfo;
            } catch (Exception e2) {
                return null;
            }
        }

        public static SIMInfo getCurSIMInfo() {
            int iSPCode;
            try {
                if (PlatformComm.context == null || (iSPCode = NetStatusUtil.getISPCode(PlatformComm.context)) == 0) {
                    return null;
                }
                SIMInfo sIMInfo = new SIMInfo();
                sIMInfo.ispCode = String.valueOf(iSPCode);
                sIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
                return sIMInfo;
            } catch (Exception e2) {
                return null;
            }
        }

        public static APNInfo getAPNInfo() {
            String extraInfo;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
                APNInfo aPNInfo = new APNInfo();
                if (activeNetworkInfo != null) {
                    aPNInfo.netType = activeNetworkInfo.getType();
                    aPNInfo.subNetType = activeNetworkInfo.getSubtype();
                    if (1 != activeNetworkInfo.getType()) {
                        if (activeNetworkInfo.getExtraInfo() == null) {
                            extraInfo = "";
                        } else {
                            extraInfo = activeNetworkInfo.getExtraInfo();
                        }
                        aPNInfo.extraInfo = extraInfo;
                        return aPNInfo;
                    }
                    aPNInfo.extraInfo = getCurWifiInfo().ssid;
                    return aPNInfo;
                }
            } catch (Exception e2) {
            }
            return null;
        }

        public static int getCurRadioAccessNetworkInfo() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return 0;
            }
            try {
                return ((TelephonyManager) PlatformComm.context.getSystemService("phone")).getNetworkType();
            } catch (Exception e2) {
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return 0;
            }
        }

        public static long getSignal(boolean z) {
            try {
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return 0;
                } else if (z) {
                    return NetworkSignalUtil.getWifiSignalStrength();
                } else {
                    return NetworkSignalUtil.getGSMSignalStrength();
                }
            } catch (Exception e2) {
                return 0;
            }
        }

        public static boolean isNetworkConnected() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return NetStatusUtil.isNetworkConnected(PlatformComm.context);
            } catch (Exception e2) {
                exception2String(e2);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return false;
            }
        }

        public static WakerLock wakeupLock_new() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return null;
            }
            try {
                return new WakerLock(PlatformComm.context);
            } catch (Exception e2) {
                exception2String(e2);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return null;
            }
        }
    }
}
