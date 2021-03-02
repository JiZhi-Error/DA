package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.wxmm.v2encoder;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import oicq.wlogin_sdk.request.i;

public class util {
    public static int UdZ = 65535;
    public static int Uea = 128;
    public static int Ueb = 0;
    public static int Uec = 1;
    public static int Ued = 2;
    public static int Uee = 3;
    public static int Uef = 4;
    public static int Ueg = 5;
    public static int Ueh = 6;
    public static int Uei = 7;
    public static int Uej = 8;
    public static int Uek = 9;
    public static int Uel = 10;
    public static int Uem = 11;
    public static int Uen = 12;
    public static int Ueo = 13;
    public static int Uep = 14;
    public static b Ueq = null;
    public static boolean Uer = false;
    public static int Ues = 5;
    public static int gQV = 1;

    public static byte[] hPG() {
        AppMethodBeat.i(88157);
        byte[] bytes = new String("android").getBytes();
        AppMethodBeat.o(88157);
        return bytes;
    }

    public static byte[] hPH() {
        AppMethodBeat.i(88158);
        byte[] bytes = Build.VERSION.RELEASE.getBytes();
        AppMethodBeat.o(88158);
        return bytes;
    }

    public static void ag(byte[] bArr, int i2, int i3) {
        bArr[i2 + 0] = (byte) (i3 >> 0);
    }

    public static void ah(byte[] bArr, int i2, int i3) {
        bArr[i2 + 1] = (byte) (i3 >> 0);
        bArr[i2 + 0] = (byte) (i3 >> 8);
    }

    public static void ai(byte[] bArr, int i2, int i3) {
        bArr[i2 + 3] = (byte) (i3 >> 0);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 0] = (byte) (i3 >> 24);
    }

    public static void c(byte[] bArr, int i2, long j2) {
        bArr[i2 + 7] = (byte) ((int) (j2 >> 0));
        bArr[i2 + 6] = (byte) ((int) (j2 >> 8));
        bArr[i2 + 5] = (byte) ((int) (j2 >> 16));
        bArr[i2 + 4] = (byte) ((int) (j2 >> 24));
        bArr[i2 + 3] = (byte) ((int) (j2 >> 32));
        bArr[i2 + 2] = (byte) ((int) (j2 >> 40));
        bArr[i2 + 1] = (byte) ((int) (j2 >> 48));
        bArr[i2 + 0] = (byte) ((int) (j2 >> 56));
    }

    public static void d(byte[] bArr, int i2, long j2) {
        bArr[i2 + 3] = (byte) ((int) (j2 >> 0));
        bArr[i2 + 2] = (byte) ((int) (j2 >> 8));
        bArr[i2 + 1] = (byte) ((int) (j2 >> 16));
        bArr[i2 + 0] = (byte) ((int) (j2 >> 24));
    }

    public static int am(byte[] bArr, int i2) {
        return bArr[i2] & 255;
    }

    public static int an(byte[] bArr, int i2) {
        return ((bArr[i2] << 8) & 65280) + ((bArr[i2 + 1] << 0) & 255);
    }

    public static int ao(byte[] bArr, int i2) {
        return ((bArr[i2] << 24) & WebView.NIGHT_MODE_COLOR) + ((bArr[i2 + 1] << v2encoder.enumCODEC_vcodec2) & 16711680) + ((bArr[i2 + 2] << 8) & 65280) + ((bArr[i2 + 3] << 0) & 255);
    }

    public static int hPI() {
        AppMethodBeat.i(88159);
        int random = (int) (Math.random() * 2.147483647E9d);
        AppMethodBeat.o(88159);
        return random;
    }

    public static byte[] hPJ() {
        AppMethodBeat.i(88160);
        byte[] seed = SecureRandom.getSeed(16);
        AppMethodBeat.o(88160);
        return seed;
    }

    public static byte[] dv(byte[] bArr) {
        AppMethodBeat.i(88161);
        byte[] seed = SecureRandom.getSeed(16);
        byte[] bArr2 = new byte[(seed.length + bArr.length)];
        System.arraycopy(seed, 0, bArr2, 0, seed.length);
        System.arraycopy(bArr, 0, bArr2, seed.length, bArr.length);
        byte[] du = c.du(bArr2);
        AppMethodBeat.o(88161);
        return du;
    }

    public static long hPK() {
        AppMethodBeat.i(88162);
        long hPz = i.hPz();
        AppMethodBeat.o(88162);
        return hPz;
    }

    public static String dw(byte[] bArr) {
        AppMethodBeat.i(88163);
        if (bArr == null) {
            AppMethodBeat.o(88163);
            return "";
        }
        String str = "";
        for (int i2 = 0; i2 < bArr.length; i2++) {
            str = String.valueOf(String.valueOf(str) + Integer.toHexString((bArr[i2] >> 4) & 15)) + Integer.toHexString(bArr[i2] & 15);
        }
        AppMethodBeat.o(88163);
        return str;
    }

    public static long dx(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return (long) bArr.length;
    }

    private static byte n(byte b2) {
        if (b2 >= 48 && b2 <= 57) {
            return (byte) (b2 - 48);
        }
        if (b2 >= 97 && b2 <= 102) {
            return (byte) ((b2 - 97) + 10);
        }
        if (b2 < 65 || b2 > 70) {
            return 0;
        }
        return (byte) ((b2 - 65) + 10);
    }

    private static byte[] buX(String str) {
        AppMethodBeat.i(88164);
        if (str == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88164);
            return bArr;
        }
        byte[] bArr2 = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < str.length() / 2; i2++) {
            bArr2[i2] = (byte) ((n((byte) str.charAt(i2 * 2)) << 4) + n((byte) str.charAt((i2 * 2) + 1)));
        }
        AppMethodBeat.o(88164);
        return bArr2;
    }

    public static byte[] lQ(Context context) {
        WifiInfo connectionInfo;
        String macAddress;
        AppMethodBeat.i(88165);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (macAddress = connectionInfo.getMacAddress()) == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88165);
            return bArr;
        }
        byte[] bytes = macAddress.getBytes();
        AppMethodBeat.o(88165);
        return bytes;
    }

    public static byte[] lR(Context context) {
        String deviceId;
        AppMethodBeat.i(88166);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || (deviceId = telephonyManager.getDeviceId()) == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88166);
            return bArr;
        }
        byte[] bytes = deviceId.getBytes();
        AppMethodBeat.o(88166);
        return bytes;
    }

    public static byte[] lS(Context context) {
        String str;
        WifiInfo connectionInfo;
        String str2 = null;
        AppMethodBeat.i(88167);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getDeviceId();
        } else {
            str = null;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
            str2 = connectionInfo.getMacAddress();
        }
        String str3 = "";
        if (str != null) {
            str3 = String.valueOf(str3) + str;
        }
        if (str2 != null) {
            str3 = String.valueOf(str3) + str2;
        }
        if (str3.length() <= 0) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88167);
            return bArr;
        }
        byte[] du = c.du(str3.getBytes());
        AppMethodBeat.o(88167);
        return du;
    }

    public static byte[] lT(Context context) {
        AppMethodBeat.i(88168);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                byte[] bytes = telephonyManager.getSimOperatorName().getBytes();
                AppMethodBeat.o(88168);
                return bytes;
            }
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88168);
            return bArr;
        } catch (Throwable th) {
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(88168);
            return bArr2;
        }
    }

    public static int lU(Context context) {
        int i2;
        AppMethodBeat.i(88169);
        try {
            i2 = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (Exception e2) {
            i2 = 0;
        }
        if (i2 == 0) {
            AppMethodBeat.o(88169);
            return 1;
        } else if (i2 == 1) {
            AppMethodBeat.o(88169);
            return 2;
        } else {
            AppMethodBeat.o(88169);
            return 0;
        }
    }

    public static int lV(Context context) {
        AppMethodBeat.i(88170);
        int i2 = context.getSharedPreferences("WLOGIN_SERVER_INFO", 0).getInt(TPDownloadProxyEnum.USER_NETWORK_TYPE, 0);
        AppMethodBeat.o(88170);
        return i2;
    }

    public static void aY(Context context, int i2) {
        AppMethodBeat.i(88171);
        SharedPreferences.Editor edit = context.getSharedPreferences("WLOGIN_SERVER_INFO", 0).edit();
        edit.putInt(TPDownloadProxyEnum.USER_NETWORK_TYPE, i2);
        edit.commit();
        AppMethodBeat.o(88171);
    }

    public static void lW(Context context) {
        AppMethodBeat.i(88172);
        SharedPreferences.Editor edit = context.getSharedPreferences("WLOGIN_NET_RETRY_TYPE", 0).edit();
        edit.putInt("type", 0);
        edit.commit();
        AppMethodBeat.o(88172);
    }

    public static String lX(Context context) {
        AppMethodBeat.i(88173);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 0) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null) {
                    AppMethodBeat.o(88173);
                    return extraInfo;
                }
                AppMethodBeat.o(88173);
                return "wifi";
            }
            AppMethodBeat.o(88173);
            return "wifi";
        } catch (Exception e2) {
        }
    }

    public static void a(Context context, byte[] bArr) {
        AppMethodBeat.i(88174);
        byte[] lY = lY(context);
        if (lY == null || lY.length <= 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            edit.putString("ksid", dw(bArr));
            edit.commit();
        }
        AppMethodBeat.o(88174);
    }

    public static byte[] lY(Context context) {
        byte[] bArr;
        AppMethodBeat.i(88175);
        byte[] bytes = new String("").getBytes();
        try {
            bArr = buX(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new String("")));
        } catch (Exception e2) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
            e2.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            oG("exception", stringWriter.toString());
            bArr = bytes;
        }
        if (bArr == null || bArr.length <= 0) {
            LOGD("get_ksid:null");
        } else {
            LOGD("get_ksid:" + dw(bArr));
        }
        AppMethodBeat.o(88175);
        return bArr;
    }

    public static void b(Context context, byte[] bArr) {
        AppMethodBeat.i(88176);
        if (bArr != null && bArr.length > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            edit.putString("imei", dw(bArr));
            edit.commit();
        }
        AppMethodBeat.o(88176);
    }

    public static byte[] lZ(Context context) {
        AppMethodBeat.i(88177);
        byte[] bArr = new byte[0];
        try {
            bArr = buX(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new String("")));
        } catch (Exception e2) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
            e2.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            oG("exception", stringWriter.toString());
        }
        if (bArr.length <= 0) {
            bArr = new byte[0];
        } else {
            LOGD("get_imei:" + dw(bArr));
        }
        AppMethodBeat.o(88177);
        return bArr;
    }

    public static byte[] ma(Context context) {
        AppMethodBeat.i(88178);
        byte[] bytes = context.getPackageName().getBytes();
        AppMethodBeat.o(88178);
        return bytes;
    }

    public static byte[] df(Context context, String str) {
        AppMethodBeat.i(88179);
        try {
            byte[] bytes = context.getPackageManager().getPackageInfo(str, 0).versionName.getBytes();
            AppMethodBeat.o(88179);
            return bytes;
        } catch (Exception e2) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88179);
            return bArr;
        }
    }

    public static byte[] dg(Context context, String str) {
        AppMethodBeat.i(88180);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) {
                AppMethodBeat.o(88180);
                return null;
            }
            byte[] du = c.du(packageInfo.signatures[0].toByteArray());
            AppMethodBeat.o(88180);
            return du;
        } catch (Throwable th) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(88180);
            return bArr;
        }
    }

    private static String hPL() {
        AppMethodBeat.i(88181);
        try {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
            String str = "[" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            AppMethodBeat.o(88181);
            return str;
        } catch (Exception e2) {
            AppMethodBeat.o(88181);
            return "";
        }
    }

    public static void buY(String str) {
        AppMethodBeat.i(88182);
        try {
            if (gQV > 0) {
                if (Ueq != null) {
                    Ueq.J(1, str);
                    AppMethodBeat.o(88182);
                    return;
                } else if (Uer) {
                    new StringBuilder("wlogin_sdk").append(hPL());
                    AppMethodBeat.o(88182);
                    return;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(88182);
    }

    public static void LOGD(String str) {
        AppMethodBeat.i(88183);
        try {
            if (gQV >= 2) {
                if (Ueq != null) {
                    Ueq.J(2, str);
                    AppMethodBeat.o(88183);
                    return;
                } else if (Uer) {
                    new StringBuilder("wlogin_sdk").append(hPL());
                    AppMethodBeat.o(88183);
                    return;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(88183);
    }

    public static void oF(String str, String str2) {
        AppMethodBeat.i(88184);
        try {
            if (gQV >= 2) {
                if (Ueq != null) {
                    Ueq.OnLog(2, str, str2);
                    AppMethodBeat.o(88184);
                    return;
                } else if (Uer) {
                    new StringBuilder("wlogin_sdk").append(hPL());
                    new StringBuilder(String.valueOf(str)).append(":").append(str2);
                    AppMethodBeat.o(88184);
                    return;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(88184);
    }

    public static void oG(String str, String str2) {
        AppMethodBeat.i(88185);
        try {
            if (gQV >= 0) {
                if (Ueq != null) {
                    Ueq.OnLog(0, str, str2);
                    AppMethodBeat.o(88185);
                    return;
                } else if (Uer) {
                    new StringBuilder("wlogin_sdk").append(hPL());
                    new StringBuilder(String.valueOf(str)).append(":").append(str2);
                    AppMethodBeat.o(88185);
                    return;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(88185);
    }

    public static void r(Exception exc) {
        AppMethodBeat.i(88186);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        oG("exception:", stringWriter.toString());
        AppMethodBeat.o(88186);
    }

    public static boolean isFileExist(String str) {
        AppMethodBeat.i(88187);
        try {
            boolean exists = new File(str).exists();
            AppMethodBeat.o(88187);
            return exists;
        } catch (Exception e2) {
            AppMethodBeat.o(88187);
            return false;
        }
    }

    public static String hPM() {
        AppMethodBeat.i(88188);
        String str = new String("2014/02/28 14:20");
        AppMethodBeat.o(88188);
        return str;
    }

    public static Key RSAPubKeyFromJNI(byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(88189);
        if (bArr == null) {
            AppMethodBeat.o(88189);
            return null;
        }
        byte[] bArr2 = new byte[22];
        bArr2[0] = 48;
        bArr2[1] = -127;
        bArr2[2] = -97;
        bArr2[3] = 48;
        bArr2[4] = JceStruct.SIMPLE_LIST;
        bArr2[5] = 6;
        bArr2[6] = 9;
        bArr2[7] = 42;
        bArr2[8] = -122;
        bArr2[9] = 72;
        bArr2[10] = -122;
        bArr2[11] = -9;
        bArr2[12] = JceStruct.SIMPLE_LIST;
        bArr2[13] = 1;
        bArr2[14] = 1;
        bArr2[15] = 1;
        bArr2[16] = 5;
        bArr2[18] = 3;
        bArr2[19] = -127;
        bArr2[20] = -115;
        byte[] bArr3 = new byte[(bArr.length + 22)];
        if (bArr.length >= 22) {
            int i2 = 0;
            while (true) {
                if (i2 >= 22) {
                    break;
                } else if (bArr2[i2] != bArr[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (!z) {
            System.arraycopy(bArr2, 0, bArr3, 0, 22);
            System.arraycopy(bArr, 0, bArr3, 22, bArr.length);
            bArr = bArr3;
        }
        try {
            PublicKey generatePublic = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArr));
            AppMethodBeat.o(88189);
            return generatePublic;
        } catch (Exception e2) {
            r(e2);
            AppMethodBeat.o(88189);
            return null;
        }
    }

    public static Key RSAPrivKeyFromJNI(byte[] bArr) {
        AppMethodBeat.i(88190);
        if (bArr == null) {
            AppMethodBeat.o(88190);
            return null;
        }
        byte[] bArr2 = new byte[26];
        bArr2[0] = 48;
        bArr2[1] = -126;
        bArr2[2] = 2;
        bArr2[3] = 117;
        bArr2[4] = 2;
        bArr2[5] = 1;
        bArr2[7] = 48;
        bArr2[8] = JceStruct.SIMPLE_LIST;
        bArr2[9] = 6;
        bArr2[10] = 9;
        bArr2[11] = 42;
        bArr2[12] = -122;
        bArr2[13] = 72;
        bArr2[14] = -122;
        bArr2[15] = -9;
        bArr2[16] = JceStruct.SIMPLE_LIST;
        bArr2[17] = 1;
        bArr2[18] = 1;
        bArr2[19] = 1;
        bArr2[20] = 5;
        bArr2[22] = 4;
        bArr2[23] = -126;
        bArr2[24] = 2;
        bArr2[25] = 95;
        int length = bArr.length - 607;
        bArr2[3] = (byte) (bArr2[3] + length);
        bArr2[25] = (byte) (length + bArr2[25]);
        byte[] bArr3 = new byte[(bArr.length + 26)];
        System.arraycopy(bArr2, 0, bArr3, 0, 26);
        System.arraycopy(bArr, 0, bArr3, 26, bArr.length);
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(bArr3));
            AppMethodBeat.o(88190);
            return generatePrivate;
        } catch (Exception e2) {
            r(e2);
            AppMethodBeat.o(88190);
            return null;
        }
    }
}
