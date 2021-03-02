package com.tencent.ytcommon.auth;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class MacAddress {
    public static String getMac(Context context) {
        AppMethodBeat.i(186317);
        if (Build.VERSION.SDK_INT < 23) {
            String machineHardwareAddress = getMachineHardwareAddress();
            AppMethodBeat.o(186317);
            return machineHardwareAddress;
        } else if (Build.VERSION.SDK_INT < 24 && Build.VERSION.SDK_INT >= 23) {
            String macAddress = getMacAddress(context);
            AppMethodBeat.o(186317);
            return macAddress;
        } else if (Build.VERSION.SDK_INT < 24) {
            AppMethodBeat.o(186317);
            return "02:00:00:00:00:00";
        } else if (!TextUtils.isEmpty(getMachineHardwareAddress())) {
            String machineHardwareAddress2 = getMachineHardwareAddress();
            AppMethodBeat.o(186317);
            return machineHardwareAddress2;
        } else if (!TextUtils.isEmpty(getMacAddress())) {
            String macAddress2 = getMacAddress();
            AppMethodBeat.o(186317);
            return macAddress2;
        } else {
            String localMacAddressFromBusybox = getLocalMacAddressFromBusybox();
            AppMethodBeat.o(186317);
            return localMacAddressFromBusybox;
        }
    }

    public static String getLocalMacAddressFromWifiInfo(Context context) {
        AppMethodBeat.i(186318);
        String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        AppMethodBeat.o(186318);
        return macAddress;
    }

    public static String getMacAddress(Context context) {
        String str;
        AppMethodBeat.i(186319);
        if (Build.VERSION.SDK_INT < 23) {
            str = getMacAddress0(context);
            if (!TextUtils.isEmpty(str)) {
                AppMethodBeat.o(186319);
                return str;
            }
        }
        String str2 = "";
        str = "";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream()));
            while (true) {
                if (str2 != null) {
                    str2 = lineNumberReader.readLine();
                    if (str2 != null) {
                        str = str2.trim();
                        break;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e2) {
            new StringBuilder("getMacAddress:").append(e2.toString());
        }
        if (str == null || "".equals(str)) {
            try {
                str = loadFileAsString("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
                AppMethodBeat.o(186319);
            } catch (Exception e3) {
                new StringBuilder("getMacAddress:").append(e3.toString());
            }
            return str;
        }
        AppMethodBeat.o(186319);
        return str;
    }

    private static String getMacAddress0(Context context) {
        AppMethodBeat.i(186320);
        if (isAccessWifiStateAuthorized(context)) {
            try {
                String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                AppMethodBeat.o(186320);
                return macAddress;
            } catch (Exception e2) {
                new StringBuilder("getMacAddress0:").append(e2.toString());
            }
        }
        AppMethodBeat.o(186320);
        return "";
    }

    private static boolean isAccessWifiStateAuthorized(Context context) {
        AppMethodBeat.i(186321);
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            AppMethodBeat.o(186321);
            return true;
        }
        AppMethodBeat.o(186321);
        return false;
    }

    private static String loadFileAsString(String str) {
        AppMethodBeat.i(186322);
        FileReader fileReader = new FileReader(str);
        String loadReaderAsString = loadReaderAsString(fileReader);
        fileReader.close();
        AppMethodBeat.o(186322);
        return loadReaderAsString;
    }

    private static String loadReaderAsString(Reader reader) {
        AppMethodBeat.i(186323);
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        int read = reader.read(cArr);
        while (read >= 0) {
            sb.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(186323);
        return sb2;
    }

    public static String getMacAddress() {
        AppMethodBeat.i(186324);
        String str = null;
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(getLocalInetAddress()).getHardwareAddress();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < hardwareAddress.length; i2++) {
                if (i2 != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i2] & 255);
                if (hexString.length() == 1) {
                    hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
                }
                stringBuffer.append(hexString);
            }
            str = stringBuffer.toString().toUpperCase();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(186324);
        return str;
    }

    private static InetAddress getLocalInetAddress() {
        InetAddress inetAddress;
        AppMethodBeat.i(186325);
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress2 = null;
            while (true) {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        inetAddress = inetAddress2;
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (!inetAddresses.hasMoreElements()) {
                            inetAddress = inetAddress2;
                            break;
                        }
                        inetAddress = inetAddresses.nextElement();
                        try {
                            if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(":") == -1) {
                                break;
                            }
                            inetAddress2 = null;
                        } catch (SocketException e2) {
                        }
                    }
                    if (inetAddress != null) {
                        break;
                    }
                    inetAddress2 = inetAddress;
                } catch (SocketException e3) {
                    inetAddress = inetAddress2;
                }
            }
        } catch (SocketException e4) {
            inetAddress = null;
        }
        AppMethodBeat.o(186325);
        return inetAddress;
    }

    private static String getLocalIpAddress() {
        AppMethodBeat.i(186326);
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            String str = nextElement.getHostAddress().toString();
                            AppMethodBeat.o(186326);
                            return str;
                        }
                    }
                }
            }
        } catch (SocketException e2) {
        }
        AppMethodBeat.o(186326);
        return null;
    }

    public static String getMachineHardwareAddress() {
        Enumeration<NetworkInterface> enumeration;
        String str = null;
        AppMethodBeat.i(186327);
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e2) {
            enumeration = null;
        }
        if (enumeration == null) {
            AppMethodBeat.o(186327);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            try {
                str = bytesToString(enumeration.nextElement().getHardwareAddress());
                if (str != null) {
                    try {
                        arrayList.add(str);
                    } catch (SocketException e3) {
                    }
                }
            } catch (SocketException e4) {
                str = str;
            }
        }
        Collections.sort(arrayList);
        if (arrayList.size() > 0) {
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            AppMethodBeat.o(186327);
            return str2;
        }
        AppMethodBeat.o(186327);
        return str;
    }

    private static String bytesToString(byte[] bArr) {
        AppMethodBeat.i(186328);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(186328);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02X:", Byte.valueOf(bArr[i2])));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(186328);
        return sb2;
    }

    public static String getLocalMacAddressFromBusybox() {
        AppMethodBeat.i(186329);
        String callCmd = callCmd("busybox ifconfig", "HWaddr");
        if (callCmd == null) {
            AppMethodBeat.o(186329);
            return "网络异常";
        }
        if (callCmd.length() > 0 && callCmd.contains("HWaddr")) {
            callCmd = callCmd.substring(callCmd.indexOf("HWaddr") + 6, callCmd.length() - 1);
        }
        AppMethodBeat.o(186329);
        return callCmd;
    }

    private static String callCmd(String str, String str2) {
        AppMethodBeat.i(186330);
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            String str4 = str3;
            while (true) {
                try {
                    str3 = bufferedReader.readLine();
                    if (str3 == null || str3.contains(str2)) {
                        break;
                    }
                    str4 = str4 + str3;
                } catch (Exception e2) {
                    str3 = str4;
                }
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(186330);
        return str3;
    }
}
