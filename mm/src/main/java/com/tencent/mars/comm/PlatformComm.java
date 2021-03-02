package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm {
    public static final int EMobile = 2;
    public static final int ENoNet = -1;
    public static final int EOtherNet = 3;
    public static final int EWifi = 1;
    private static final boolean IS_PROXY_ON = false;
    public static final int NETTYPE_2G = 3;
    public static final int NETTYPE_3G = 4;
    public static final int NETTYPE_4G = 5;
    public static final int NETTYPE_5G = 7;
    public static final int NETTYPE_NON = -1;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_UNKNOWN = 6;
    public static final int NETTYPE_WAP = 2;
    public static final int NETTYPE_WIFI = 1;
    private static final String TAG = "PlatformComm";
    private static Context context = null;
    private static MMHandler handler = null;
    public static IReportCrash reportCrashImp = null;
    public static IResetProcess resetprocessimp = null;

    public interface IReportCrash {
        void reportIdkey();
    }

    public interface IResetProcess {
        void restartProcess();
    }

    public static class SIMInfo {
        public String ispCode;
        public String ispName;
    }

    public static class WifiInfo {
        public String bssid;
        public String ssid;
    }

    static class Assert {
        Assert() {
        }

        static void assertTrue(String str, boolean z) {
        }

        static void assertTrue(boolean z) {
        }
    }

    static class APNInfo {
        public String extraInfo;
        public int netType;
        public int subNetType;

        APNInfo() {
        }
    }

    public static void init(Context context2, MMHandler mMHandler) {
        context = context2;
        handler = mMHandler;
        NetworkSignalUtil.InitNetworkSignalUtil(context2);
    }

    public static class C2Java {
        private static String exception2String(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        public static int getNetInfo() {
            NetworkInfo networkInfo;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return -1;
                }
                networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo == null) {
                    return -1;
                }
                try {
                    switch (networkInfo.getType()) {
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
                    Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                    return 3;
                }
            } catch (Exception e3) {
                networkInfo = null;
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
                if (NetStatusUtil.isWifi(netType)) {
                    return 1;
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
                if (NetStatusUtil.is5G(PlatformComm.context)) {
                    return 7;
                }
                if (NetStatusUtil.isWap(netType)) {
                    return 2;
                }
                return 6;
            } catch (Exception e2) {
                Log.e(PlatformComm.TAG, exception2String(e2));
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return -1;
            }
        }

        public static boolean startAlarm(int i2, int i3, int i4) {
            Log.i(PlatformComm.TAG, "start alarm type:%d id is %d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return Alarm.start(i2, (long) i3, i4, PlatformComm.context);
            } catch (Exception e2) {
                if (PlatformComm.reportCrashImp != null) {
                    PlatformComm.reportCrashImp.reportIdkey();
                }
                Log.e(PlatformComm.TAG, exception2String(e2));
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return false;
            }
        }

        public static boolean startAlarm(int i2, int i3) {
            Log.i(PlatformComm.TAG, "start alarm no type id is %d", Integer.valueOf(i2));
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return Alarm.start(113, (long) i2, i3, PlatformComm.context);
            } catch (Exception e2) {
                if (PlatformComm.reportCrashImp != null) {
                    PlatformComm.reportCrashImp.reportIdkey();
                }
                Log.e(PlatformComm.TAG, exception2String(e2));
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
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
                Log.e(PlatformComm.TAG, exception2String(e2));
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return false;
            }
        }

        public static void restartProcess() {
            if (PlatformComm.resetprocessimp != null) {
                try {
                    PlatformComm.handler.post(new Runnable() {
                        /* class com.tencent.mars.comm.PlatformComm.C2Java.AnonymousClass1 */

                        public final void run() {
                            PlatformComm.resetprocessimp.restartProcess();
                        }
                    });
                } catch (Exception e2) {
                    Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                }
            }
        }

        public static WifiInfo getCurWifiInfo() {
            NetworkInfo networkInfo;
            try {
                if (PlatformComm.context == null) {
                    return null;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return null;
                }
                try {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (Exception e2) {
                    Log.e(PlatformComm.TAG, "getActiveNetworkInfo failed.");
                    networkInfo = null;
                }
                if (networkInfo == null || 1 != networkInfo.getType()) {
                    return null;
                }
                WifiInfo wifiInfo = new WifiInfo();
                wifiInfo.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
                wifiInfo.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
                return wifiInfo;
            } catch (Exception e3) {
                Log.printErrStackTrace(PlatformComm.TAG, e3, "", new Object[0]);
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
                Log.d(PlatformComm.TAG, "getISPCode MCC_MNC=%s", sIMInfo.ispCode);
                sIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
                return sIMInfo;
            } catch (Exception e2) {
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
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
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
            }
            return null;
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
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
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
                Log.e(PlatformComm.TAG, exception2String(e2));
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return false;
            }
        }

        public static int getCurRadioAccessNetworkInfo() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return 0;
            }
            try {
                return ((TelephonyManager) PlatformComm.context.getSystemService("phone")).getNetworkType();
            } catch (Exception e2) {
                Log.e(PlatformComm.TAG, exception2String(e2));
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return 0;
            }
        }

        public static WakerLock wakeupLock_new() {
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                return null;
            }
            try {
                return new WakerLock(PlatformComm.context, PlatformComm.TAG);
            } catch (Exception e2) {
                Log.e(PlatformComm.TAG, exception2String(e2));
                Log.printErrStackTrace(PlatformComm.TAG, e2, "", new Object[0]);
                Assert.assertTrue(e2.getClass().getSimpleName() + ":" + e2.getStackTrace()[0] + ", " + e2.getStackTrace()[1], false);
                return null;
            }
        }
    }
}
