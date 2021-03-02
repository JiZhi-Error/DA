package com.tencent.mm.plugin.sns.ad.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.sns.ad.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private static Map<Integer, String> DAc = new ConcurrentHashMap();
    private static Map<Integer, String> DAd = new ConcurrentHashMap();
    private static Map<Integer, String> DAe = new ConcurrentHashMap();
    private static String DAf;
    private static String Dsg = "";
    private static String Dsm = "";
    private static String Dsp = "";
    private static String androidId = "";
    private static String dGL = "";
    private static String imei = "";
    private static volatile String uuid = "";

    static {
        AppMethodBeat.i(192765);
        AppMethodBeat.o(192765);
    }

    public static String aoK() {
        AppMethodBeat.i(192753);
        if (!Util.isNullOrNil(Dsg)) {
            String str = Dsg;
            AppMethodBeat.o(192753);
            return str;
        }
        try {
            Dsg = q.aoK();
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getOAID: " + th.toString());
        }
        String str2 = Dsg;
        AppMethodBeat.o(192753);
        return str2;
    }

    public static String getDeviceId() {
        Context context;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(192754);
        if (!Util.isNullOrNil(dGL)) {
            String str = dGL;
            AppMethodBeat.o(192754);
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && (context = MMApplicationContext.getContext()) != null) {
            try {
                Object systemService = context.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (!Util.isNullOrNil(deviceId)) {
                        dGL = deviceId;
                    }
                }
            } catch (Throwable th) {
                Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId: " + th.toString());
            }
        }
        String str2 = dGL;
        AppMethodBeat.o(192754);
        return str2;
    }

    public static String getDeviceId(int i2) {
        Context context;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(192755);
        String str = DAc.get(Integer.valueOf(i2));
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(192755);
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT >= 23 && (context = MMApplicationContext.getContext()) != null) {
            try {
                Object systemService = context.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String deviceId = telephonyManager.getDeviceId(i2);
                    if (!Util.isNullOrNil(deviceId)) {
                        DAc.put(Integer.valueOf(i2), deviceId);
                    }
                }
            } catch (Throwable th) {
                Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId" + i2 + ": " + th.toString());
            }
        }
        String nullAsNil = Util.nullAsNil(DAc.get(Integer.valueOf(i2)));
        AppMethodBeat.o(192755);
        return nullAsNil;
    }

    public static String aoz() {
        Context context;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(192756);
        if (!Util.isNullOrNil(imei)) {
            String str = imei;
            AppMethodBeat.o(192756);
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT >= 26 && (context = MMApplicationContext.getContext()) != null) {
            try {
                Object systemService = context.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String imei2 = telephonyManager.getImei();
                    if (!Util.isNullOrNil(imei2)) {
                        imei = imei2;
                    }
                }
            } catch (Throwable th) {
                Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI: " + th.toString());
            }
        }
        String str2 = imei;
        AppMethodBeat.o(192756);
        return str2;
    }

    public static String XT(int i2) {
        Context context;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(192757);
        String str = DAd.get(Integer.valueOf(i2));
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(192757);
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT >= 26 && (context = MMApplicationContext.getContext()) != null) {
            try {
                Object systemService = context.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String imei2 = telephonyManager.getImei(i2);
                    if (!Util.isNullOrNil(imei2)) {
                        DAd.put(Integer.valueOf(i2), imei2);
                    }
                }
            } catch (Throwable th) {
                Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI" + i2 + ": " + th.toString());
            }
        }
        String nullAsNil = Util.nullAsNil(DAd.get(Integer.valueOf(i2)));
        AppMethodBeat.o(192757);
        return nullAsNil;
    }

    public static String eYi() {
        Context context;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(192758);
        if (!Util.isNullOrNil(Dsm)) {
            String str = Dsm;
            AppMethodBeat.o(192758);
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT >= 26 && (context = MMApplicationContext.getContext()) != null) {
            try {
                Object systemService = context.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String meid = telephonyManager.getMeid();
                    if (!Util.isNullOrNil(meid)) {
                        Dsm = meid;
                    }
                }
            } catch (Throwable th) {
                Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID: " + th.toString());
            }
        }
        String str2 = Dsm;
        AppMethodBeat.o(192758);
        return str2;
    }

    public static String XU(int i2) {
        Context context;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(192759);
        String str = DAe.get(Integer.valueOf(i2));
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(192759);
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT >= 26 && (context = MMApplicationContext.getContext()) != null) {
            try {
                Object systemService = context.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String meid = telephonyManager.getMeid(i2);
                    if (!Util.isNullOrNil(meid)) {
                        DAe.put(Integer.valueOf(i2), meid);
                    }
                }
            } catch (Throwable th) {
                Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID" + i2 + ": " + th.toString());
            }
        }
        String nullAsNil = Util.nullAsNil(DAe.get(Integer.valueOf(i2)));
        AppMethodBeat.o(192759);
        return nullAsNil;
    }

    public static String aoA() {
        Context context;
        TelephonyManager telephonyManager;
        AppMethodBeat.i(192760);
        if (!Util.isNullOrNil(Dsp)) {
            String str = Dsp;
            AppMethodBeat.o(192760);
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && (context = MMApplicationContext.getContext()) != null) {
            try {
                Object systemService = context.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String subscriberId = telephonyManager.getSubscriberId();
                    if (!TextUtils.isEmpty(subscriberId)) {
                        Dsp = subscriberId;
                    }
                }
            } catch (Throwable th) {
                Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMSI: " + th.toString());
            }
        }
        String str2 = Dsp;
        AppMethodBeat.o(192760);
        return str2;
    }

    public static String eYj() {
        AppMethodBeat.i(192761);
        try {
            String dr = q.dr(false);
            AppMethodBeat.o(192761);
            return dr;
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEIWx: " + th.toString());
            AppMethodBeat.o(192761);
            return "";
        }
    }

    public static String getAndroidId() {
        AppMethodBeat.i(192762);
        if (!Util.isNullOrNil(androidId)) {
            String str = androidId;
            AppMethodBeat.o(192762);
            return str;
        }
        try {
            String string = Settings.System.getString(MMApplicationContext.getContext().getContentResolver(), "android_id");
            if (!Util.isNullOrNil(string)) {
                androidId = string;
            }
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidId: " + th.toString());
        }
        String str2 = androidId;
        AppMethodBeat.o(192762);
        return str2;
    }

    public static String eYk() {
        AppMethodBeat.i(192763);
        try {
            if (!Util.isNullOrNil(DAf)) {
                String str = DAf;
                AppMethodBeat.o(192763);
                return str;
            }
            String nullAsNil = Util.nullAsNil(System.getProperty("http.agent"));
            DAf = nullAsNil;
            AppMethodBeat.o(192763);
            return nullAsNil;
        } catch (Throwable th) {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidUserAgent: " + th.toString());
            AppMethodBeat.o(192763);
            return "";
        }
    }

    public static String eYl() {
        AppMethodBeat.i(192764);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.i.f.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(192752);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
                        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
                        String unused = f.uuid = "";
                        AppMethodBeat.o(192752);
                        return;
                    }
                    b bVar = new b("Tencent/ams/cache", "meta.dat");
                    b bVar2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
                    if (!bVar.open() || !bVar2.open()) {
                        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
                        String unused2 = f.uuid = "";
                        bVar.close();
                        bVar2.close();
                        AppMethodBeat.o(192752);
                        return;
                    }
                    String eWG = bVar.eWG();
                    String eWG2 = bVar2.eWG();
                    if (!Util.isNullOrNil(eWG)) {
                        Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is ".concat(String.valueOf(eWG)));
                    } else if (!Util.isNullOrNil(eWG2)) {
                        Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from fileBackup is ".concat(String.valueOf(eWG2)));
                        eWG = eWG2;
                    } else {
                        eWG = "";
                        Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file and fileBackup is null");
                    }
                    String unused3 = f.uuid = eWG;
                    bVar.close();
                    bVar2.close();
                    Log.i("AdDeviceInfo.DeviceInfoUtils", "getUUId, timeCost = " + (System.currentTimeMillis() - currentTimeMillis) + ", len = " + eWG.length() + ", result = " + eWG);
                    AppMethodBeat.o(192752);
                } catch (Throwable th) {
                    Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: " + th.toString());
                    AppMethodBeat.o(192752);
                }
            }
        });
        String str = uuid;
        AppMethodBeat.o(192764);
        return str;
    }
}
