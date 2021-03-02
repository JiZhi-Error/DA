package com.tencent.mm.an;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    public static int iRR = 1;
    public static int iRS = 2;
    public static int iRT = 3;
    public static int iRU = -1;
    public static int iRV = 3;
    public static int iRW = 4;
    public static int iRX = 5;
    public static int iRY = 1;
    public static int iRZ = 2;
    public static int iSa = -10001;
    public static int iSb = HttpClientWrapper.RET_CODE_PROTOCOL;
    public static int iSc = HttpClientWrapper.RET_CODE_ILLEGAL_STATE;
    public static int iSd = HttpClientWrapper.RET_CODE_FILE_NOT_FOUND;

    public static void outputJniLog(byte[] bArr, String str, int i2) {
        AppMethodBeat.i(150418);
        if (Util.isNullOrNil(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i2 == 4) {
            Log.e(str, str2);
            AppMethodBeat.o(150418);
        } else if (i2 == 3) {
            Log.w(str, str2);
            AppMethodBeat.o(150418);
        } else if (i2 == 2) {
            Log.i(str, str2);
            AppMethodBeat.o(150418);
        } else if (i2 == 1) {
            Log.d(str, str2);
            AppMethodBeat.o(150418);
        } else {
            if (i2 == 0) {
                Log.v(str, str2);
            }
            AppMethodBeat.o(150418);
        }
    }

    private static String Od(String str) {
        AppMethodBeat.i(150419);
        if (!Util.isNullOrNil(str)) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (!Util.isAlpha(charAt) && !Util.isNum(charAt)) {
                    AppMethodBeat.o(150419);
                    return null;
                }
            }
        }
        AppMethodBeat.o(150419);
        return str;
    }

    public static String a(String str, long j2, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.i(150420);
        Log.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", str, Long.valueOf(j2), str2, str3, Util.getStack());
        if (Util.isNullOrNil(Od(str))) {
            AppMethodBeat.o(150420);
        } else if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(150420);
        } else if (j2 <= 0) {
            AppMethodBeat.o(150420);
        } else {
            String nullAsNil = Util.nullAsNil(Od(str3));
            str4 = "a" + str + "_" + g.getMessageDigest((z.aTY() + "-" + str2).getBytes()).substring(0, 16) + "_" + j2;
            if (!Util.isNullOrNil(nullAsNil)) {
                str4 = str4 + "_" + nullAsNil;
            }
            AppMethodBeat.o(150420);
        }
        return str4;
    }

    public static int cX(Context context) {
        AppMethodBeat.i(150421);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                int i2 = iRR;
                AppMethodBeat.o(150421);
                return i2;
            } else if (activeNetworkInfo.getType() == 1) {
                int i3 = iRT;
                AppMethodBeat.o(150421);
                return i3;
            } else if (activeNetworkInfo.getSubtype() == 1) {
                int i4 = iRR;
                AppMethodBeat.o(150421);
                return i4;
            } else if (activeNetworkInfo.getSubtype() == 2) {
                int i5 = iRR;
                AppMethodBeat.o(150421);
                return i5;
            } else if (activeNetworkInfo.getSubtype() >= 3) {
                int i6 = iRS;
                AppMethodBeat.o(150421);
                return i6;
            } else {
                int i7 = iRR;
                AppMethodBeat.o(150421);
                return i7;
            }
        } catch (NullPointerException e2) {
            Log.e("MicroMsg.CdnUtil", "exception:%s", Util.stackTraceToString(e2));
            int i8 = iRR;
            AppMethodBeat.o(150421);
            return i8;
        }
    }

    public static int cY(Context context) {
        AppMethodBeat.i(150422);
        int netType = NetStatusUtil.getNetType(context);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            int i2 = iRU;
            AppMethodBeat.o(150422);
            return i2;
        } else if (activeNetworkInfo.getType() == 1) {
            int i3 = iRY;
            AppMethodBeat.o(150422);
            return i3;
        } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
            int i4 = iRV;
            AppMethodBeat.o(150422);
            return i4;
        } else if (activeNetworkInfo.getSubtype() >= 13) {
            int i5 = iRX;
            AppMethodBeat.o(150422);
            return i5;
        } else if (activeNetworkInfo.getSubtype() >= 3) {
            int i6 = iRW;
            AppMethodBeat.o(150422);
            return i6;
        } else if (NetStatusUtil.isWap(netType)) {
            int i7 = iRZ;
            AppMethodBeat.o(150422);
            return i7;
        } else {
            int i8 = iRV;
            AppMethodBeat.o(150422);
            return i8;
        }
    }

    public static boolean baL() {
        boolean z;
        AppMethodBeat.i(223567);
        if (1 == ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_cdn_upload_use_multi_socket, 0)) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.CdnUtil", "cdn UseMultiSocket(X-Lab):%s", Boolean.valueOf(z));
        AppMethodBeat.o(223567);
        return z;
    }
}
