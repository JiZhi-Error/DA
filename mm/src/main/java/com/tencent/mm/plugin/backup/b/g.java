package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g {
    private static List<String> gzY = null;
    public static boolean oJv = false;

    public static <T extends com.tencent.mm.bw.a> T a(T t, byte[] bArr) {
        AppMethodBeat.i(21170);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(21170);
            return null;
        }
        try {
            t.parseFrom(bArr);
            AppMethodBeat.o(21170);
            return t;
        } catch (Exception e2) {
            Log.e("MicroMsg.BackupUtil", "ERROR: parseProBuf [%s] [%s]", e2.getMessage(), Util.stackTraceToString(e2));
            AppMethodBeat.o(21170);
            return null;
        }
    }

    public static void a(String str, x xVar) {
        AppMethodBeat.i(21171);
        RandomAccessFile randomAccessFile = null;
        try {
            o oVar = new o(str);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            String str2 = str + xVar.oUz;
            o oVar2 = new o(str2);
            if (!oVar2.exists()) {
                oVar2.createNewFile();
            }
            RandomAccessFile dB = s.dB(s.k(str2, true), true);
            dB.setLength((long) xVar.oUB);
            dB.seek((long) xVar.oUC);
            dB.write(xVar.oTm.zy);
            if (dB != null) {
                try {
                    dB.close();
                } catch (Exception e2) {
                    AppMethodBeat.o(21171);
                    return;
                }
            }
            AppMethodBeat.o(21171);
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.BackupUtil", e3, "writeMediaToFile fail with exception", new Object[0]);
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (Exception e4) {
                    AppMethodBeat.o(21171);
                    return;
                }
            }
            AppMethodBeat.o(21171);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.o(21171);
            throw th;
        }
    }

    public static long agv(String str) {
        AppMethodBeat.i(21172);
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(21172);
            return -1;
        } else if (!oVar.canRead()) {
            AppMethodBeat.o(21172);
            return -2;
        } else if (!oVar.canWrite()) {
            AppMethodBeat.o(21172);
            return -3;
        } else {
            long length = oVar.length();
            AppMethodBeat.o(21172);
            return length;
        }
    }

    public static void b(String str, x xVar) {
        Object valueOf;
        AppMethodBeat.i(21173);
        if (TextUtils.isEmpty(str) || xVar == null) {
            Log.e("MicroMsg.BackupUtil", "appendFile dir:%s req:%s ", str, xVar);
            AppMethodBeat.o(21173);
        } else if (TextUtils.isEmpty(xVar.oUz) || xVar.oTm == null || Util.getLength(xVar.oTm.zy) <= 0) {
            Object[] objArr = new Object[3];
            objArr[0] = xVar.oUz;
            objArr[1] = xVar.oTm;
            if (xVar.oTm == null) {
                valueOf = BuildConfig.COMMAND;
            } else {
                valueOf = Integer.valueOf(Util.getLength(xVar.oTm.zy));
            }
            objArr[2] = valueOf;
            Log.e("MicroMsg.BackupUtil", "appendFile dataid:%s data:%s  %s", objArr);
            AppMethodBeat.o(21173);
        } else {
            int i2 = 3;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    long agv = agv(str + xVar.oUz);
                    int c2 = c(str, xVar);
                    long agv2 = agv(str + xVar.oUz);
                    if (c2 != 0 || agv2 < ((long) xVar.oTm.zy.length)) {
                        Log.e("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i3), Integer.valueOf(c2), Long.valueOf(agv), Long.valueOf(agv2), Integer.valueOf(xVar.oTm.zy.length));
                        i2 = i3;
                    } else {
                        AppMethodBeat.o(21173);
                        return;
                    }
                } else {
                    AppMethodBeat.o(21173);
                    return;
                }
            }
        }
    }

    private static int c(String str, x xVar) {
        AppMethodBeat.i(21174);
        try {
            o oVar = new o(str);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            String str2 = str + FilePathGenerator.ANDROID_DIR_SEP + xVar.oUz;
            o oVar2 = new o(str2);
            if (!oVar2.exists()) {
                oVar2.createNewFile();
            }
            byte[] bArr = xVar.oTm.zy;
            int e2 = s.e(str2, bArr, bArr.length);
            AppMethodBeat.o(21174);
            return e2;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
            AppMethodBeat.o(21174);
            return -1;
        }
    }

    public static int a(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(21175);
        try {
            o oVar = new o(str);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            String str3 = str + FilePathGenerator.ANDROID_DIR_SEP + str2;
            o oVar2 = new o(str3);
            if (!oVar2.exists()) {
                oVar2.createNewFile();
            }
            int e2 = s.e(str3, bArr, bArr.length);
            AppMethodBeat.o(21175);
            return e2;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
            AppMethodBeat.o(21175);
            return -1;
        }
    }

    public static String eE(Context context) {
        int i2;
        AppMethodBeat.i(21176);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            try {
                String connectedWifiSsid = NetStatusUtil.getConnectedWifiSsid(context);
                if (Util.isNullOrNil(connectedWifiSsid)) {
                    connectedWifiSsid = "wifi";
                }
                if (connectedWifiSsid.length() >= 2 && connectedWifiSsid.startsWith("\"") && connectedWifiSsid.endsWith("\"")) {
                    connectedWifiSsid = connectedWifiSsid.substring(1, connectedWifiSsid.length() - 1);
                }
                AppMethodBeat.o(21176);
                return connectedWifiSsid;
            } catch (Exception e2) {
                Log.e("MicroMsg.BackupUtil", "getConnectionInfo %s", e2);
                Log.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
                AppMethodBeat.o(21176);
                return "";
            }
        } else {
            int i3 = 13;
            try {
                i3 = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
                i2 = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e3) {
                Log.e("MicroMsg.BackupUtil", "getWifiApState %s", e3);
                Log.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
                i2 = 0;
            }
            if (i2 == i3) {
                Log.i("MicroMsg.BackupUtil", "getWifiName apmode");
                try {
                    String str = ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
                    AppMethodBeat.o(21176);
                    return str;
                } catch (Exception e4) {
                    Log.e("MicroMsg.BackupUtil", "getWifiApConfiguration %s", e4);
                    Log.printErrStackTrace("MicroMsg.BackupUtil", e4, "", new Object[0]);
                    AppMethodBeat.o(21176);
                    return "wifiap";
                }
            } else {
                AppMethodBeat.o(21176);
                return "";
            }
        }
    }

    public static void agw(String str) {
        AppMethodBeat.i(21177);
        Log.i("MicroMsg.BackupUtil", "BackupDelete Dir:%s", str);
        s.dy(str, true);
        if (oJv) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            StringBuilder sb = new StringBuilder("\n");
            sb.append("deleteTime:").append(simpleDateFormat.format(new Date(Util.nowMilliSecond()))).append("\n");
            sb.append("deletePath:").append(str).append("\n");
            a(cfb(), "backupTestInfo.txt", sb.toString().getBytes());
        }
        AppMethodBeat.o(21177);
    }

    public static void ceX() {
        AppMethodBeat.i(21178);
        Log.i("MicroMsg.BackupUtil", "BackupDelete clear MsgListDataId.");
        bg.aVF().aTt().aHo();
        if (oJv) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            StringBuilder sb = new StringBuilder("\nclear MsgListDataId\n");
            sb.append("deleteTime:").append(simpleDateFormat.format(new Date(Util.nowMilliSecond()))).append("\n");
            a(cfb(), "backupTestInfo.txt", sb.toString().getBytes());
        }
        AppMethodBeat.o(21178);
    }

    public static void ceY() {
        AppMethodBeat.i(21179);
        Log.i("MicroMsg.BackupUtil", "BackupDelete clear tempMoveTime.");
        bg.aVF().aTs().aHo();
        AppMethodBeat.o(21179);
    }

    public static String ceZ() {
        AppMethodBeat.i(21180);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.getAccPath()).append("backupRecover/").toString();
        AppMethodBeat.o(21180);
        return sb2;
    }

    public static String cfa() {
        AppMethodBeat.i(21181);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.getAccPath()).append("backupRecoverCopy/").toString();
        AppMethodBeat.o(21181);
        return sb2;
    }

    public static String cfb() {
        AppMethodBeat.i(21182);
        com.tencent.mm.kernel.g.aAi();
        String str = com.tencent.mm.kernel.g.aAh().hqF;
        AppMethodBeat.o(21182);
        return str;
    }

    public static String agx(String str) {
        AppMethodBeat.i(21183);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(21183);
            return "";
        }
        String str2 = ceZ() + "backupItem/" + agz(str);
        AppMethodBeat.o(21183);
        return str2;
    }

    public static String agy(String str) {
        AppMethodBeat.i(21184);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(21184);
            return "";
        }
        String str2 = ceZ() + "backupMeida/" + agz(str);
        AppMethodBeat.o(21184);
        return str2;
    }

    private static String agz(String str) {
        AppMethodBeat.i(21185);
        if (str == null) {
            AppMethodBeat.o(21185);
            return "";
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (messageDigest.length() > 0) {
            str2 = messageDigest.charAt(0) + FilePathGenerator.ANDROID_DIR_SEP;
        }
        if (messageDigest.length() >= 2) {
            str3 = messageDigest.charAt(1) + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str4 = str2 + str3;
        AppMethodBeat.o(21185);
        return str4;
    }

    public static int cfc() {
        boolean z;
        int i2;
        AppMethodBeat.i(21186);
        Intent registerReceiver = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            AppMethodBeat.o(21186);
            return 100;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery isCharging[%b]", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(21186);
            return 100;
        }
        int intExtra2 = registerReceiver.getIntExtra("level", -1);
        int intExtra3 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra2 < 0 || intExtra3 <= 0) {
            i2 = 100;
        } else {
            i2 = (intExtra2 * 100) / intExtra3;
        }
        Log.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery level remaining[%d]", Integer.valueOf(i2));
        AppMethodBeat.o(21186);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean agA(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 322
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.b.g.agA(java.lang.String):boolean");
    }

    private static boolean eR(int i2, int i3) {
        AppMethodBeat.i(21188);
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            boolean isIPv4Address = InetAddressUtils.isIPv4Address(upperCase);
                            Log.i("MicroMsg.BackupUtil", "check ip:%s, isIPv4:%b", upperCase, Boolean.valueOf(isIPv4Address));
                            if (isIPv4Address) {
                                String[] split = upperCase.split("\\.");
                                if ((i2 & i3) == (com.tencent.mm.b.o.S(new byte[]{(byte) (Util.getInt(split[0], 0) & 255), (byte) (Util.getInt(split[1], 0) & 255), (byte) (Util.getInt(split[2], 0) & 255), (byte) (Util.getInt(split[3], 0) & 255)}) & i2)) {
                                    AppMethodBeat.o(21188);
                                    return true;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(21188);
        return false;
    }

    public static boolean agB(String str) {
        AppMethodBeat.i(21189);
        if (str == null) {
            AppMethodBeat.o(21189);
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (XmlParser.parseXml(str, "msg", null) != null) {
            AppMethodBeat.o(21189);
            return true;
        }
        AppMethodBeat.o(21189);
        return false;
    }

    public static String a(is isVar, int i2) {
        AppMethodBeat.i(21190);
        String a2 = a(isVar, i2, (String) null);
        AppMethodBeat.o(21190);
        return a2;
    }

    public static String a(is isVar, int i2, String str) {
        AppMethodBeat.i(21191);
        if (isVar.KMU != i2 || isVar.KMS == null) {
            int i3 = 0;
            if (!(isVar.KMR == null || isVar.KMQ == null)) {
                Iterator<dqj> it = isVar.KMR.iterator();
                while (it.hasNext()) {
                    if (it.next().MTq == i2) {
                        String str2 = isVar.KMQ.get(i3).MTo;
                        if (!Util.isNullOrNil(str) && !str2.endsWith(str)) {
                            i3 = i3 + 1 + 1;
                        } else if (s.YS(agy(str2) + str2)) {
                            AppMethodBeat.o(21191);
                            return str2;
                        } else {
                            AppMethodBeat.o(21191);
                            return null;
                        }
                    } else {
                        i3++;
                    }
                }
            }
            AppMethodBeat.o(21191);
            return null;
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(isVar.KMS.getBuffer().zy);
        AppMethodBeat.o(21191);
        return messageDigest;
    }

    public static int cv(String str, int i2) {
        AppMethodBeat.i(21192);
        int i3 = Util.getInt(str, i2);
        AppMethodBeat.o(21192);
        return i3;
    }

    public static long agC(String str) {
        AppMethodBeat.i(21193);
        long j2 = 0;
        if (!Util.isNullOrNil(str)) {
            try {
                j2 = Long.valueOf(str).longValue();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(21193);
        return j2;
    }

    public static boolean b(is isVar, int i2, String str) {
        AppMethodBeat.i(21194);
        if (isVar.KMU == i2) {
            byte[] bArr = isVar.KMS.getBuffer().zy;
            if (bArr.length <= 0) {
                AppMethodBeat.o(21194);
                return false;
            }
            s.f(str, bArr, bArr.length);
            AppMethodBeat.o(21194);
            return true;
        }
        String a2 = a(isVar, i2, (String) null);
        if (!Util.isNullOrNil(a2)) {
            s.nx(agy(a2) + a2, str);
            AppMethodBeat.o(21194);
            return true;
        }
        AppMethodBeat.o(21194);
        return false;
    }

    public static boolean a(is isVar, String str) {
        AppMethodBeat.i(21195);
        if (isVar.KMU == 3) {
            byte[] bArr = isVar.KMS.getBuffer().zy;
            if (bArr.length <= 0) {
                AppMethodBeat.o(21195);
                return false;
            }
            s.f(str, bArr, bArr.length);
            AppMethodBeat.o(21195);
            return true;
        }
        String a2 = a(isVar, 3, (String) null);
        if (!Util.isNullOrNil(a2)) {
            s.nw(agy(a2) + a2, str);
            AppMethodBeat.o(21195);
            return true;
        }
        AppMethodBeat.o(21195);
        return false;
    }

    public static byte[] b(is isVar, int i2) {
        AppMethodBeat.i(21196);
        if (isVar.KMU != i2 || isVar.KMS == null) {
            if (!(isVar.KMR == null || isVar.KMQ == null)) {
                Iterator<dqj> it = isVar.KMR.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (it.next().MTq == i2) {
                        String str = isVar.KMQ.get(i3).MTo;
                        String str2 = agy(str) + str;
                        int boW = (int) s.boW(str2);
                        if (boW == 0 || boW > 1048576) {
                            Log.e("MicroMsg.BackupUtil", "thumb not exist or  too big!");
                            AppMethodBeat.o(21196);
                            return null;
                        }
                        byte[] aW = s.aW(str2, 0, -1);
                        AppMethodBeat.o(21196);
                        return aW;
                    }
                    i3++;
                }
            }
            AppMethodBeat.o(21196);
            return null;
        }
        byte[] bArr = isVar.KMS.getBuffer().zy;
        AppMethodBeat.o(21196);
        return bArr;
    }

    public static int c(is isVar, int i2) {
        AppMethodBeat.i(21197);
        if (isVar.KMU != i2) {
            if (!(isVar.KMR == null || isVar.KMQ == null)) {
                Iterator<dqj> it = isVar.KMR.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (it.next().MTq == i2) {
                        String str = isVar.KMQ.get(i3).MTo;
                        int boW = (int) s.boW(agy(str) + str);
                        AppMethodBeat.o(21197);
                        return boW;
                    }
                    i3++;
                }
            }
            AppMethodBeat.o(21197);
            return 0;
        } else if (isVar.KMS == null) {
            AppMethodBeat.o(21197);
            return 0;
        } else {
            int length = isVar.KMS.getBuffer().zy.length;
            AppMethodBeat.o(21197);
            return length;
        }
    }

    public static boolean d(is isVar, int i2) {
        AppMethodBeat.i(21198);
        if (isVar.KMU != i2 || isVar.KMS == null) {
            Iterator<dqj> it = isVar.KMR.iterator();
            while (it.hasNext()) {
                if (it.next().MTq == i2) {
                    AppMethodBeat.o(21198);
                    return true;
                }
            }
            AppMethodBeat.o(21198);
            return false;
        }
        AppMethodBeat.o(21198);
        return true;
    }

    public static List<String> cfd() {
        AppMethodBeat.i(21199);
        if (gzY != null) {
            List<String> list = gzY;
            AppMethodBeat.o(21199);
            return list;
        }
        gzY = new LinkedList();
        for (String str : ab.iCO) {
            gzY.add(str);
        }
        gzY.add("weixin");
        gzY.add("weibo");
        gzY.add("qqmail");
        gzY.add("fmessage");
        gzY.add("tmessage");
        gzY.add("qmessage");
        gzY.add("qqsync");
        gzY.add("floatbottle");
        gzY.add("lbsapp");
        gzY.add("shakeapp");
        gzY.add("medianote");
        gzY.add("qqfriend");
        gzY.add("readerapp");
        gzY.add("newsapp");
        gzY.add("blogapp");
        gzY.add("facebookapp");
        gzY.add("masssendapp");
        gzY.add("meishiapp");
        gzY.add("feedsapp");
        gzY.add("voipapp");
        gzY.add("officialaccounts");
        gzY.add("helper_entry");
        gzY.add("pc_share");
        gzY.add("cardpackage");
        gzY.add("voicevoipapp");
        gzY.add("voiceinputapp");
        gzY.add("linkedinplugin");
        gzY.add("appbrandcustomerservicemsg");
        List<String> list2 = gzY;
        AppMethodBeat.o(21199);
        return list2;
    }

    public static boolean a(PLong pLong, PLong pLong2, String str) {
        AppMethodBeat.i(21200);
        StatFs statFs = new StatFs(b.aKJ());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        o X = o.X(com.tencent.mm.compatible.util.g.getDataDirectory());
        StatFs statFs2 = new StatFs(aa.z(X.mUri));
        long blockCount = (long) statFs2.getBlockCount();
        long availableBlocks = (long) statFs2.getAvailableBlocks();
        pLong2.value = ((long) statFs2.getBlockSize()) * ((long) statFs2.getAvailableBlocks());
        Log.i("MicroMsg.BackupUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", Long.valueOf(pLong.value), Long.valueOf(pLong2.value), 0L);
        if (blockCount <= 0) {
            AppMethodBeat.o(21200);
            return false;
        } else if (blockCount - availableBlocks < 0) {
            AppMethodBeat.o(21200);
            return false;
        } else {
            if (pLong.value == pLong2.value || str.startsWith(aa.z(X.mUri))) {
                pLong.value = 0;
            }
            if (0 > pLong2.value) {
                AppMethodBeat.o(21200);
                return false;
            }
            AppMethodBeat.o(21200);
            return true;
        }
    }

    public static long agD(String str) {
        AppMethodBeat.i(21201);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long nowMilliSecond = Util.nowMilliSecond();
        try {
            nowMilliSecond = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            Log.e("MicroMsg.BackupUtil", "dateToTimeStamp failed. date:%s, stack:%s", str, Util.getStack());
        }
        AppMethodBeat.o(21201);
        return nowMilliSecond;
    }

    public static LinkedList<String> B(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21202);
        LinkedList<String> linkedList2 = new LinkedList<>();
        if (linkedList != null) {
            Iterator<f.b> it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(it.next().oJq);
            }
        }
        AppMethodBeat.o(21202);
        return linkedList2;
    }

    public static String b(String str, String str2, String... strArr) {
        StringBuilder sb;
        boolean z;
        AppMethodBeat.i(21203);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(21203);
            return str;
        }
        if (str.equals("")) {
            sb = new StringBuilder(strArr[0]);
            z = true;
        } else {
            sb = new StringBuilder(str);
            z = false;
        }
        for (String str3 : strArr) {
            if (z) {
                z = false;
            } else {
                sb.append(str2).append(str3);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(21203);
        return sb2;
    }

    public static String[] eQ(String str, String str2) {
        AppMethodBeat.i(21204);
        String[] split = str.split(str2);
        AppMethodBeat.o(21204);
        return split;
    }

    public static m Bu(long j2) {
        AppMethodBeat.i(21205);
        m mVar = new m();
        String dr = q.dr(false);
        if (TextUtils.isEmpty(dr)) {
            dr = q.aoG();
        }
        mVar.oTH = dr;
        mVar.oTI = Build.MANUFACTURER;
        mVar.oTJ = Build.MODEL;
        mVar.oTK = "Android";
        mVar.oTL = Build.VERSION.RELEASE;
        mVar.oTM = d.KyO;
        mVar.oTN = j2;
        Log.i("MicroMsg.BackupUtil", "getBackupStartGeneralInfo WechatVersion[%s], freespace[%d], deviceId[%s]", Integer.valueOf(d.KyO), Long.valueOf(j2), mVar.oTH);
        AppMethodBeat.o(21205);
        return mVar;
    }

    public static LinkedList<f.a> b(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.i(21206);
        if (linkedList == null || linkedList2 == null || linkedList.isEmpty() || linkedList.size() * 2 != linkedList2.size()) {
            AppMethodBeat.o(21206);
            return null;
        }
        LinkedList<f.a> linkedList3 = new LinkedList<>();
        HashMap hashMap = new HashMap();
        Iterator<Long> it = linkedList2.iterator();
        Iterator<String> it2 = linkedList.iterator();
        long j2 = 0;
        long j3 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            if (it.hasNext()) {
                j3 = it.next().longValue();
                if (it.hasNext()) {
                    j2 = it.next().longValue();
                }
            }
            int size = hashMap.size();
            if (hashMap.get(next) != null) {
                size = ((Integer) hashMap.get(next)).intValue();
            } else {
                hashMap.put(next, Integer.valueOf(size));
            }
            linkedList3.add(new f.a(size, next, j3, j2));
        }
        AppMethodBeat.o(21206);
        return linkedList3;
    }

    public static class a {
        public static String oJw = "<msg>";
        public static String oJx = "</msg>";

        public static String agE(String str) {
            AppMethodBeat.i(21168);
            k.a agG = k.agG(str);
            if (agG == null) {
                AppMethodBeat.o(21168);
                return null;
            }
            String str2 = agG.oNX;
            AppMethodBeat.o(21168);
            return str2;
        }

        public static String a(ca caVar, is isVar) {
            AppMethodBeat.i(21169);
            EmojiInfo blk = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgN().blk(caVar.field_imgPath);
            if (blk == null) {
                AppMethodBeat.o(21169);
                return null;
            }
            k.a agH = k.agH(blk.getMd5());
            if (agH == null) {
                agH = new k.a(blk.getMd5(), blk.getMd5(), blk.getMd5(), blk.getMd5());
            }
            StringWriter stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument(MimeTypeUtil.ContentType.DEFAULT_CHARSET, Boolean.TRUE);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", isVar.KHl.MTo);
                newSerializer.attribute(null, "tousername", isVar.KHm.MTo);
                newSerializer.attribute(null, "type", new StringBuilder().append(blk.field_type).toString());
                newSerializer.attribute(null, "idbuffer", blk.hYp());
                newSerializer.attribute(null, "md5", agH.oNY);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", agH.oNX);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", blk.field_groupId);
                newSerializer.attribute(null, "cdnurl", blk.field_cdnUrl == null ? "" : blk.field_cdnUrl);
                newSerializer.attribute(null, "designerid", blk.field_designerID == null ? "" : blk.field_designerID);
                newSerializer.attribute(null, "thumburl", blk.field_thumbUrl == null ? "" : blk.field_thumbUrl);
                newSerializer.attribute(null, "encrypturl", blk.field_encrypturl == null ? "" : blk.field_encrypturl);
                newSerializer.attribute(null, "aeskey", blk.field_aeskey == null ? "" : blk.field_aeskey);
                newSerializer.attribute(null, "externurl", blk.field_externUrl == null ? "" : blk.field_externUrl);
                newSerializer.attribute(null, "externmd5", blk.field_externMd5 == null ? "" : blk.field_externMd5);
                newSerializer.attribute(null, "width", String.valueOf(blk.field_width));
                newSerializer.attribute(null, "height", String.valueOf(blk.field_height));
                newSerializer.attribute(null, "tpurl", blk.field_tpurl == null ? "" : blk.field_tpurl);
                newSerializer.attribute(null, "tpauthkey", blk.field_tpauthkey == null ? "" : blk.field_tpauthkey);
                newSerializer.attribute(null, "attachedtext", blk.field_attachedText == null ? "" : blk.field_attachedText);
                newSerializer.attribute(null, "attachedtextcolor", blk.field_attachTextColor == null ? "" : blk.field_attachTextColor);
                newSerializer.attribute(null, "lensid", blk.field_lensId == null ? "" : blk.field_lensId);
                newSerializer.attribute(null, "activityid", blk.field_activityid == null ? "" : blk.field_activityid);
                newSerializer.endTag(null, "emoji");
                if (blk.NA()) {
                    newSerializer.startTag(null, "gameext");
                    Map<String, String> parseXml = XmlParser.parseXml(blk.getContent(), "gameext", null);
                    String nullAs = Util.nullAs(parseXml.get(".gameext.$type"), "");
                    String nullAs2 = Util.nullAs(parseXml.get(".gameext.$content"), "");
                    if (nullAs.equals("") || nullAs2.equals("")) {
                        stringWriter.close();
                        AppMethodBeat.o(21169);
                        return "";
                    }
                    newSerializer.attribute(null, "type", String.valueOf(nullAs));
                    newSerializer.attribute(null, "content", String.valueOf(nullAs2));
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                String stringBuffer = stringWriter.getBuffer().toString();
                try {
                    String substring = stringBuffer.substring(stringBuffer.indexOf(oJw), stringBuffer.indexOf(oJx) + oJx.length());
                    Log.d("MicroMsg.BackupUtil.EmojiConvert", "xml ".concat(String.valueOf(substring)));
                    AppMethodBeat.o(21169);
                    return substring;
                } catch (Exception e2) {
                    AppMethodBeat.o(21169);
                    return "";
                }
            } catch (XmlPullParserException e3) {
                Log.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e3, "", new Object[0]);
                AppMethodBeat.o(21169);
                return "";
            } catch (IllegalArgumentException e4) {
                Log.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e4, "", new Object[0]);
                AppMethodBeat.o(21169);
                return "";
            } catch (IllegalStateException e5) {
                Log.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e5, "", new Object[0]);
                AppMethodBeat.o(21169);
                return "";
            } catch (IOException e6) {
                Log.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e6, "", new Object[0]);
                AppMethodBeat.o(21169);
                return "";
            }
        }
    }
}
