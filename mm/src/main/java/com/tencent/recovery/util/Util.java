package com.tencent.recovery.util;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Util {
    private static final String TAG = "Recovery.Util";
    private static String processName = "";

    public static final boolean isNullOrNil(String str) {
        return str == null || str.length() == 0;
    }

    public static final int getUUID(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ConstantsRecovery.RECOVERY_INFO_CONF_NAME, 0);
        int i2 = sharedPreferences.getInt(ConstantsRecovery.SpKeys.KeySafeModeUUID, -1);
        if (i2 != -1) {
            return i2;
        }
        int genUUID = genUUID(context);
        sharedPreferences.edit().putInt(ConstantsRecovery.SpKeys.KeySafeModeUUID, genUUID).commit();
        return genUUID;
    }

    private static final int genUUID(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        String localMacAddress = getLocalMacAddress(context);
        if (localMacAddress == null) {
            localMacAddress = getLocalBtMacAddress();
        }
        if (localMacAddress == null) {
            localMacAddress = UUID.randomUUID().toString();
        }
        stringBuffer.append(localMacAddress);
        stringBuffer.append(getHardWareId());
        return ("A" + getMessageDigest(stringBuffer.toString().getBytes()).substring(0, 15)).hashCode();
    }

    private static final String getMessageDigest(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            return new String(cArr2);
        } catch (Exception e2) {
            return null;
        }
    }

    private static final String getHardWareId() {
        return Build.MANUFACTURER + Build.MODEL;
    }

    public static String getLocalMacAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getMacAddress();
        }
        return null;
    }

    public static String getLocalBtMacAddress() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.getAddress();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0037 A[SYNTHETIC, Splitter:B:24:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003c A[SYNTHETIC, Splitter:B:27:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0048 A[SYNTHETIC, Splitter:B:33:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x004d A[SYNTHETIC, Splitter:B:36:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyAppendFile(java.io.File r7, int r8, int r9, java.io.File r10) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.util.Util.copyAppendFile(java.io.File, int, int, java.io.File):void");
    }

    public static String readStringFromFile(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str = new String(byteArrayOutputStream.toByteArray());
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                }
                return str;
            } catch (Exception e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            throw e;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    public static String getTimeFormat(long j2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(j2));
    }

    public static String getMyProcessName(Context context) {
        return getProcessNameByPid(context, Process.myPid());
    }

    public static String getProcessNameByPid(Context context, int i2) {
        if (Process.myUid() >= 99000) {
            return ConstantsRecovery.ISOLATE_PROCESS_NAME;
        }
        if (!isNullOrNil(processName)) {
            return processName;
        }
        if (context == null) {
            context = Recovery.getContext();
        }
        if (context == null || i2 <= 0) {
            return processName;
        }
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i2 && runningAppProcessInfo.processName != null && !runningAppProcessInfo.processName.equals("")) {
                    processName = runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e2) {
            RecoveryLog.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        return processName;
    }

    public static boolean isUidIsolated(int i2) {
        return i2 >= 99000;
    }
}
