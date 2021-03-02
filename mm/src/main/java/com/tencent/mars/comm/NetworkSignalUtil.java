package com.tencent.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class NetworkSignalUtil {
    public static final String TAG = "MicroMsg.NetworkSignalUtil";
    private static Context context = null;
    private static long strength = 10000;

    public static void InitNetworkSignalUtil(Context context2) {
        context = context2;
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mars.comm.NetworkSignalUtil.AnonymousClass1 */
            private byte _hellAccFlag_;

            public final void run() {
                Log.i("MicroMsg.NetworkSignalUtil", "[InitNetworkSignalUtil] run.. %s", Looper.myLooper());
                TelephonyManager telephonyManager = (TelephonyManager) NetworkSignalUtil.context.getSystemService("phone");
                a bl = c.a(256, new a()).bl(new PhoneStateListener() {
                    /* class com.tencent.mars.comm.NetworkSignalUtil.AnonymousClass1.AnonymousClass1 */

                    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                        super.onSignalStrengthsChanged(signalStrength);
                        NetworkSignalUtil.calSignalStrength(signalStrength);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mars/comm/NetworkSignalUtil$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mars/comm/NetworkSignalUtil$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
        });
    }

    public static long getNetworkSignalStrength(boolean z) {
        return 0;
    }

    public static long getGSMSignalStrength() {
        return strength;
    }

    public static long getWifiSignalStrength() {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getBSSID() == null) {
            Log.v("MicroMsg.NetworkSignalUtil", "Can Not Get Wifi Signal");
            return 0;
        }
        int calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 10);
        Log.v("MicroMsg.NetworkSignalUtil", "Wifi Signal:" + (calculateSignalLevel * 10));
        if (calculateSignalLevel > 10) {
            calculateSignalLevel = 10;
        }
        if (calculateSignalLevel < 0) {
            calculateSignalLevel = 0;
        }
        return (long) (calculateSignalLevel * 10);
    }

    /* access modifiers changed from: private */
    public static void calSignalStrength(SignalStrength signalStrength) {
        int cdmaDbm;
        long j2;
        if (signalStrength.isGsm()) {
            cdmaDbm = signalStrength.getGsmSignalStrength();
        } else {
            cdmaDbm = (signalStrength.getCdmaDbm() + 113) / 2;
        }
        if (!signalStrength.isGsm() || cdmaDbm != 99) {
            long j3 = (long) (((float) cdmaDbm) * 3.2258065f);
            strength = j3;
            long j4 = j3 > 100 ? 100 : strength;
            strength = j4;
            j2 = j4 < 0 ? 0 : strength;
        } else {
            j2 = -1;
        }
        strength = j2;
    }
}
