package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ap.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class e {
    public static boolean HgV = false;
    private static long HgW = 0;
    private static long HgX = 0;
    static BufferedOutputStream mOutputStream = null;
    private static int yvK = 0;

    public static int getNetType(Context context) {
        int i2;
        AppMethodBeat.i(115509);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(115509);
                return 2;
            }
            Log.i("MicroMsg.VoipHelper", "getNetType: %s %s", Integer.valueOf(activeNetworkInfo.getType()), Integer.valueOf(activeNetworkInfo.getSubtype()));
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(115509);
                return 4;
            } else if (activeNetworkInfo.getType() != 0) {
                AppMethodBeat.o(115509);
                return 2;
            } else {
                int subtype = activeNetworkInfo.getSubtype();
                switch (subtype) {
                    case 0:
                        i2 = 2;
                        break;
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        i2 = 1;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        i2 = 3;
                        break;
                    case 13:
                    case 18:
                    case 19:
                        i2 = 5;
                        break;
                    case 20:
                        i2 = 5;
                        break;
                    default:
                        Log.i("MicroMsg.VoipHelper", "NEWEST type, use wifi as default!");
                        i2 = 4;
                        break;
                }
                Log.i("MicroMsg.VoipHelper", "steve: subType:%s, getMobileType(2G/3G/4G/...): %s ", Integer.valueOf(subtype), Integer.valueOf(i2));
                AppMethodBeat.o(115509);
                return i2;
            }
        } catch (NullPointerException e2) {
            Log.printErrStackTrace("MicroMsg.VoipHelper", e2, "", new Object[0]);
            AppMethodBeat.o(115509);
            return 2;
        }
    }

    public static void fKc() {
    }

    private static void writeLogToFile(String str) {
        AppMethodBeat.i(115510);
        if (mOutputStream == null) {
            AppMethodBeat.o(115510);
            return;
        }
        try {
            mOutputStream.write(str.getBytes());
            AppMethodBeat.o(115510);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VoipHelper", e2, "", new Object[0]);
            AppMethodBeat.o(115510);
        }
    }

    public static void flushLogFile() {
        AppMethodBeat.i(115511);
        if (mOutputStream == null) {
            AppMethodBeat.o(115511);
            return;
        }
        try {
            mOutputStream.flush();
            AppMethodBeat.o(115511);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VoipHelper", e2, "", new Object[0]);
            AppMethodBeat.o(115511);
        }
    }

    public static int co(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = ((bArr[i3] & 255) << (i3 * 8)) | i2;
        }
        return i2;
    }

    public static byte[] int2bytes(int i2) {
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) (i2 >>> (i3 * 8));
        }
        return bArr;
    }

    public static void Loge(String str, String str2) {
        AppMethodBeat.i(115512);
        Log.e(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + ":" + str2 + " \n");
        AppMethodBeat.o(115512);
    }

    public static void Logi(String str, String str2) {
        AppMethodBeat.i(115513);
        Log.i(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + ":" + str2 + " \n");
        AppMethodBeat.o(115513);
    }

    public static void Logd(String str, String str2) {
        AppMethodBeat.i(115514);
        Log.d(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + ":" + str2 + " \n");
        AppMethodBeat.o(115514);
    }

    public static void Logw(String str, String str2) {
        AppMethodBeat.i(115515);
        Log.w(str, "[" + Thread.currentThread().getId() + "]" + str2);
        writeLogToFile(str + ":" + str2 + " \n");
        AppMethodBeat.o(115515);
    }

    public static void outputJniLog(byte[] bArr, String str, int i2) {
        AppMethodBeat.i(115516);
        if (Util.isNullOrNil(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i2 == 4) {
            Log.e(str, str2);
        } else if (i2 == 2) {
            Log.i(str, str2);
        } else {
            Log.d(str, str2);
        }
        if (!str.equals("MicroMsg.v2Core")) {
            writeLogToFile(str + ":" + str2 + " \n");
            AppMethodBeat.o(115516);
            return;
        }
        writeLogToFile(str + ":" + str2);
        AppMethodBeat.o(115516);
    }

    public static void adF(int i2) {
        AppMethodBeat.i(115517);
        try {
            Thread.sleep((long) i2);
            AppMethodBeat.o(115517);
        } catch (InterruptedException e2) {
            Log.printErrStackTrace("MicroMsg.VoipHelper", e2, "", new Object[0]);
            AppMethodBeat.o(115517);
        }
    }

    public static int aCD(String str) {
        AppMethodBeat.i(115519);
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i2 = 0;
                for (byte b2 : address) {
                    i2 = (i2 << 8) | (b2 & 255);
                }
                Log.d("MicroMsg.VoipHelper", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i2));
                AppMethodBeat.o(115519);
                return i2;
            }
        } catch (UnknownHostException e2) {
            Log.printErrStackTrace("MicroMsg.VoipHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(115519);
        return 0;
    }

    public static void c(int i2, long j2, int i3, int i4) {
        AppMethodBeat.i(115520);
        if (!(c.fFg().fHU() == 0 || c.fFg().fHV() == 0)) {
            HgW = c.fFg().fGu();
            yvK = i2;
            HgX = j2;
        }
        h.INSTANCE.a(16516, true, true, Long.valueOf(HgW), Integer.valueOf(yvK), Long.valueOf(HgX), Integer.valueOf(i3), Integer.valueOf(i4));
        Log.i("MicroMsg.VoipHelper", "room type " + HgW + "room id" + yvK + "room key" + HgX + "call type " + i3 + "type " + i4);
        AppMethodBeat.o(115520);
    }

    public static void adG(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        AppMethodBeat.i(115521);
        if (d.oF(28)) {
            i3 = b.apT() ? 1 : 2;
            if (b.apU()) {
                i4 = 1;
            } else {
                i4 = 2;
            }
        } else if (d.oD(26)) {
            if (b.aqa()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            if (b.aqb()) {
                i4 = 1;
            } else {
                i4 = 2;
            }
        } else {
            if (b.apR()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            if (b.apV()) {
                i4 = 1;
            } else {
                i4 = 2;
            }
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[12];
        objArr[0] = Integer.valueOf(c.fFg().fHU());
        objArr[1] = Long.valueOf(c.fFg().fHV());
        objArr[2] = Long.valueOf(c.fFg().fGu());
        if (a.isActive()) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        objArr[3] = Integer.valueOf(i5);
        if (b.apN()) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        objArr[4] = Integer.valueOf(i6);
        if (b.apP()) {
            i7 = 1;
        } else {
            i7 = 2;
        }
        objArr[5] = Integer.valueOf(i7);
        if (b.apQ()) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        objArr[6] = Integer.valueOf(i8);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(i4);
        if (b.apS()) {
            i9 = 1;
        } else {
            i9 = 2;
        }
        objArr[9] = Integer.valueOf(i9);
        if (b.apW()) {
            i10 = 1;
        }
        objArr[10] = Integer.valueOf(i10);
        objArr[11] = Integer.valueOf(i2);
        hVar.a(16366, true, true, objArr);
        AppMethodBeat.o(115521);
    }

    public static void a(int i2, long j2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(115522);
        Log.i("MicroMsg.VoipHelper", "before convert, beforeNetType:%s, afterNetType:%s", Integer.valueOf(i3), Integer.valueOf(i6));
        int adH = adH(i3);
        int adH2 = adH(i4);
        Log.i("MicroMsg.VoipHelper", "after convert, beforeNetType:%s, afterNetType:%s", Integer.valueOf(adH), Integer.valueOf(i6));
        h.INSTANCE.a(16519, true, true, Long.valueOf(c.fFg().fGu()), Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(adH), Integer.valueOf(adH2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        Log.i("MicroMsg.VoipHelper", "reportVoipNetChangeCost is memberIdx =" + i2 + "|switchNetworkTimestamp " + j2 + "|beforeNetType " + adH + "|afterNetType" + adH2 + "|beforeNetStrength" + i5 + "|afterNetStrength" + i6 + "|avgNetStrength" + i7);
        AppMethodBeat.o(115522);
    }

    private static int adH(int i2) {
        switch (i2) {
            case 2:
                return 4;
            case 3:
                return 2;
            case 4:
                return 5;
            case 5:
                return 3;
            default:
                return i2;
        }
    }
}
