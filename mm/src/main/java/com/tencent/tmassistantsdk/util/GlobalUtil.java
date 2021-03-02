package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GlobalUtil {
    static final int NET_TYPE_WIFI = 4;
    protected static final String SharedPreferencesName = "TMAssistantSDKSharedPreference";
    private static final String TAG = "GlobalUtil";
    protected static GlobalUtil mInstance = null;
    protected static int mMemUUID = 0;
    public final int JCE_CMDID_Empty;
    public final int JCE_CMDID_GetAppSimpleDetail;
    public final int JCE_CMDID_GetAppUpdate;
    public final int JCE_CMDID_GetAuthorized;
    public final int JCE_CMDID_GetSettings;
    public final int JCE_CMDID_ReportLog;
    protected Context mContext;
    public HashMap<Integer, String> mJCECmdIdMap;
    public String mQUA;

    protected GlobalUtil() {
        AppMethodBeat.i(102481);
        this.mQUA = "";
        this.JCE_CMDID_Empty = 0;
        this.JCE_CMDID_ReportLog = 1;
        this.JCE_CMDID_GetSettings = 2;
        this.JCE_CMDID_GetAppUpdate = 3;
        this.JCE_CMDID_GetAuthorized = 4;
        this.JCE_CMDID_GetAppSimpleDetail = 5;
        this.mJCECmdIdMap = null;
        this.mJCECmdIdMap = new HashMap<>();
        this.mJCECmdIdMap.put(1, "ReportLog");
        this.mJCECmdIdMap.put(2, "GetSettings");
        this.mJCECmdIdMap.put(3, "GetAppUpdate");
        this.mJCECmdIdMap.put(4, "GetAuthorized");
        this.mJCECmdIdMap.put(5, "GetAppSimpleDetail");
        AppMethodBeat.o(102481);
    }

    public static synchronized GlobalUtil getInstance() {
        GlobalUtil globalUtil;
        synchronized (GlobalUtil.class) {
            AppMethodBeat.i(102482);
            if (mInstance == null) {
                mInstance = new GlobalUtil();
            }
            globalUtil = mInstance;
            AppMethodBeat.o(102482);
        }
        return globalUtil;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        AppMethodBeat.i(102483);
        this.mContext = context;
        this.mQUA = new QUASetting(context).buildQUA();
        AppMethodBeat.o(102483);
    }

    public void destroy() {
        this.mContext = null;
        mInstance = null;
    }

    public int getJceCmdIdByClassName(String str) {
        AppMethodBeat.i(102484);
        if (str == null) {
            AppMethodBeat.o(102484);
            return 0;
        }
        if (this.mJCECmdIdMap != null) {
            for (Map.Entry<Integer, String> entry : this.mJCECmdIdMap.entrySet()) {
                if (entry != null) {
                    Integer key = entry.getKey();
                    String value = entry.getValue();
                    if (value != null && value.equals(str)) {
                        int intValue = key.intValue();
                        AppMethodBeat.o(102484);
                        return intValue;
                    }
                }
            }
        }
        AppMethodBeat.o(102484);
        return 0;
    }

    public String getNetworkOperator() {
        AppMethodBeat.i(102485);
        if (this.mContext == null) {
            AppMethodBeat.o(102485);
            return "";
        }
        String networkOperator = ((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkOperator();
        AppMethodBeat.o(102485);
        return networkOperator;
    }

    public int getNetworkType() {
        AppMethodBeat.i(102486);
        if (this.mContext == null) {
            AppMethodBeat.o(102486);
            return 0;
        }
        int networkType = ((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkType();
        AppMethodBeat.o(102486);
        return networkType;
    }

    public static String getAppPackageName(Context context) {
        AppMethodBeat.i(102487);
        if (context != null) {
            String packageName = context.getPackageName();
            AppMethodBeat.o(102487);
            return packageName;
        }
        AppMethodBeat.o(102487);
        return "";
    }

    public static int getAppVersionCode(Context context) {
        int i2 = 0;
        AppMethodBeat.i(102488);
        if (context != null) {
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                AppMethodBeat.o(102488);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(102488);
            }
        } else {
            AppMethodBeat.o(102488);
        }
        return i2;
    }

    public String getAndroidIdInPhone() {
        AppMethodBeat.i(102489);
        if (this.mContext == null) {
            AppMethodBeat.o(102489);
            return null;
        }
        String string = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
        AppMethodBeat.o(102489);
        return string;
    }

    public String getPhoneGuid() {
        AppMethodBeat.i(102490);
        if (this.mContext == null) {
            AppMethodBeat.o(102490);
            return "";
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
            AppMethodBeat.o(102490);
            return string;
        }
        AppMethodBeat.o(102490);
        return "";
    }

    public void setPhoneGuid(String str) {
        SharedPreferences sharedPreferences;
        AppMethodBeat.i(102491);
        if (this.mContext == null) {
            AppMethodBeat.o(102491);
            return;
        }
        if (!(str == null || (sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0)) == null)) {
            sharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", str).commit();
        }
        AppMethodBeat.o(102491);
    }

    public static String calcMD5AsString(String str) {
        AppMethodBeat.i(102492);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bytes, 0, bytes.length);
                byte[] digest = instance.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    stringBuffer.append(Integer.toHexString(b2 & 255));
                }
                str2 = stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102492);
        return str2;
    }

    public static synchronized int getMemUUID() {
        int i2;
        synchronized (GlobalUtil.class) {
            i2 = mMemUUID;
            mMemUUID = i2 + 1;
        }
        return i2;
    }

    public static ArrayList<String> String2List(String str) {
        AppMethodBeat.i(102493);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        AppMethodBeat.o(102493);
        return arrayList;
    }

    public void setNetTypeValue(byte b2) {
        AppMethodBeat.i(102494);
        if (this.mContext == null) {
            AppMethodBeat.o(102494);
            return;
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
        if (!(sharedPreferences == null || Byte.parseByte(sharedPreferences.getString("TMAssistantSDKNetType", AppEventsConstants.EVENT_PARAM_VALUE_NO)) == b2)) {
            sharedPreferences.edit().putString("TMAssistantSDKNetType", String.valueOf((int) b2)).commit();
        }
        AppMethodBeat.o(102494);
    }

    public boolean canReportValue() {
        return false;
    }

    public int getQQDownloaderAPILevel() {
        int i2 = 0;
        AppMethodBeat.i(102495);
        if (this.mContext == null) {
            AppMethodBeat.o(102495);
        } else {
            try {
                ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    AppMethodBeat.o(102495);
                } else {
                    i2 = applicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
                    AppMethodBeat.o(102495);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(102495);
            }
        }
        return i2;
    }

    public int getQQDownloaderVersionCode() {
        AppMethodBeat.i(102496);
        if (this.mContext == null) {
            AppMethodBeat.o(102496);
            return 0;
        }
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0);
                if (packageInfo == null) {
                    AppMethodBeat.o(102496);
                    return 0;
                }
                int i2 = packageInfo.versionCode;
                AppMethodBeat.o(102496);
                return i2;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(102496);
                return 0;
            }
        } else {
            AppMethodBeat.o(102496);
            return 0;
        }
    }

    public static void updateFilePathAuthorized(String str) {
        AppMethodBeat.i(102497);
        o oVar = new o(str);
        String parent = oVar.getParent();
        String parent2 = new o(parent).getParent();
        String parent3 = new o(parent2).getParent();
        try {
            Runtime.getRuntime().exec("chmod 777 " + aa.z(oVar.her()));
            Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(parent)));
            Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(parent2)));
            Runtime.getRuntime().exec("chmod 777".concat(String.valueOf(parent3)));
            AppMethodBeat.o(102497);
        } catch (IOException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102497);
        }
    }

    public static int assistantState2SDKState(int i2) {
        switch (i2) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            default:
                return 0;
            case 6:
                return 1;
            case 9:
                return 6;
        }
    }

    public static int assistantErrorCode2SDKErrorCode(int i2) {
        switch (i2) {
            case -1000:
            case -26:
            case -24:
            default:
                return 604;
            case -28:
                return 701;
            case -27:
                return 606;
            case -25:
                return 602;
            case -23:
                return 601;
            case -22:
                return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
            case -21:
                return 700;
            case -16:
                return 731;
            case -15:
                return 1;
            case -13:
                return 703;
            case -12:
                return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH;
            case -11:
                return 708;
            case -1:
                return 709;
            case 0:
                return 0;
        }
    }

    public static boolean isDBExist(String str) {
        AppMethodBeat.i(102498);
        if (getInstance().getContext() == null || !o.X(getInstance().getContext().getDatabasePath(str)).exists()) {
            AppMethodBeat.o(102498);
            return false;
        }
        AppMethodBeat.o(102498);
        return true;
    }

    public static void deleteOldDB(String str) {
        AppMethodBeat.i(102499);
        if (getInstance().getContext() != null) {
            o X = o.X(getInstance().getContext().getDatabasePath(str));
            if (X.exists()) {
                try {
                    X.delete();
                    TMLog.i(TAG, "deleteDB");
                    AppMethodBeat.o(102499);
                    return;
                } catch (Exception e2) {
                    TMLog.i(TAG, "deleteDB failed");
                }
            }
        }
        AppMethodBeat.o(102499);
    }
}
