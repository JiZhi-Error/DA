package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.support.annotation.Keep;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class WcWss {
    private static HashMap<Pair<String, Integer>, a> mGM = new HashMap<>();

    public interface a {
        int doCertificateVerify(String str, byte[][] bArr);

        void onClose(String str, int i2, int i3, String str2);

        void onHandShake(String str, int i2, String[] strArr, String[] strArr2);

        void onMessage(String str, int i2, byte[] bArr, boolean z);

        void onOpen(String str, int i2, boolean z, String[] strArr, String[] strArr2, int i3, String str2, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9);
    }

    public static native void closeSocket(String str, int i2, int i3, String str2);

    private static native int connectSocket(String str, String str2, Object[] objArr, Object[] objArr2, Object[] objArr3, Object obj, Object[] objArr4);

    public static native void init();

    public static native int sendBuffer(String str, int i2, byte[] bArr, boolean z);

    public static native void setDebugIp(String str, int i2);

    static {
        AppMethodBeat.i(144293);
        WcWss.class.getClassLoader();
        j.Ed("wcwss");
        AppMethodBeat.o(144293);
    }

    public static void bLo() {
        AppMethodBeat.i(144282);
        Log.i("MicroMsg.WcWss", "initWcWss");
        init();
        AppMethodBeat.o(144282);
    }

    public static int a(a aVar, String str, String str2, Object[] objArr, Object[] objArr2, Object obj, Object[] objArr3) {
        AppMethodBeat.i(144283);
        int connectSocket = connectSocket(str, str2, objArr, objArr2, null, obj, objArr3);
        if (connectSocket > 0) {
            Log.i("MicroMsg.WcWss", "connect wss pair(%s, %d)", str, Integer.valueOf(connectSocket));
            Pair<String, Integer> pair = new Pair<>(str, Integer.valueOf(connectSocket));
            if (mGM.containsKey(pair)) {
                Log.e("MicroMsg.WcWss", "already exists pair(%s, %d)", str, Integer.valueOf(connectSocket));
                AppMethodBeat.o(144283);
                return -1;
            }
            mGM.put(pair, aVar);
        }
        AppMethodBeat.o(144283);
        return connectSocket;
    }

    @Keep
    public static void onHandShake(String str, int i2, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(144284);
        Log.i("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i2));
        Pair pair = new Pair(str, Integer.valueOf(i2));
        if (mGM.containsKey(pair)) {
            mGM.get(pair).onHandShake(str, i2, strArr, strArr2);
            AppMethodBeat.o(144284);
            return;
        }
        Log.e("MicroMsg.WcWss", "onHandShake callback is null");
        AppMethodBeat.o(144284);
    }

    @Keep
    public static void onOpen(String str, int i2, boolean z, String[] strArr, String[] strArr2, int i3, String str2, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        AppMethodBeat.i(175389);
        Log.i("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", str, Boolean.valueOf(z), str2, Integer.valueOf(i3), Integer.valueOf(i2));
        Pair pair = new Pair(str, Integer.valueOf(i2));
        if (mGM.containsKey(pair)) {
            mGM.get(pair).onOpen(str, i2, z, strArr, strArr2, i3, str2, j2, j3, j4, j5, j6, j7, j8, j9);
            if (!z) {
                mGM.remove(pair);
                AppMethodBeat.o(175389);
                return;
            }
        } else {
            Log.e("MicroMsg.WcWss", "onOpen callback is null");
        }
        AppMethodBeat.o(175389);
    }

    @Keep
    public static void onMessage(String str, int i2, byte[] bArr, boolean z) {
        AppMethodBeat.i(144286);
        Log.d("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i2), Boolean.valueOf(z));
        Pair pair = new Pair(str, Integer.valueOf(i2));
        if (mGM.containsKey(pair)) {
            mGM.get(pair).onMessage(str, i2, bArr, z);
            AppMethodBeat.o(144286);
            return;
        }
        Log.e("MicroMsg.WcWss", "onMessage callback is null");
        AppMethodBeat.o(144286);
    }

    @Keep
    public static void onClose(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(144287);
        Log.i("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i2), str2, Integer.valueOf(i3));
        Pair pair = new Pair(str, Integer.valueOf(i2));
        if (mGM.containsKey(pair)) {
            mGM.get(pair).onClose(str, i2, i3, str2);
            mGM.remove(pair);
            AppMethodBeat.o(144287);
            return;
        }
        Log.e("MicroMsg.WcWss", "onClose callback is null");
        AppMethodBeat.o(144287);
    }

    @Keep
    public static void onKvStat(int i2, String str) {
        AppMethodBeat.i(144288);
        Log.i("MicroMsg.WcWss", "onKvStat logId:%s", Integer.valueOf(i2));
        ((b) e.N(b.class)).kvStat(i2, str);
        AppMethodBeat.o(144288);
    }

    @Keep
    public static void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(144289);
        Log.v("MicroMsg.WcWss", "onIdKeyStat");
        ArrayList<IDKey> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            arrayList.add(new IDKey(iArr[i2], iArr2[i2], iArr3[i2]));
        }
        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).b(arrayList, false);
        AppMethodBeat.o(144289);
    }

    @Keep
    public static int getNetworkType() {
        AppMethodBeat.i(144290);
        int statisticsNetType = getStatisticsNetType();
        AppMethodBeat.o(144290);
        return statisticsNetType;
    }

    @Keep
    public static int doCertificateVerify(String str, int i2, String str2, byte[][] bArr) {
        AppMethodBeat.i(144291);
        Log.i("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", str, Integer.valueOf(i2), str2);
        Pair pair = new Pair(str, Integer.valueOf(i2));
        if (mGM.containsKey(pair)) {
            int doCertificateVerify = mGM.get(pair).doCertificateVerify(str2, bArr);
            AppMethodBeat.o(144291);
            return doCertificateVerify;
        }
        Log.e("MicroMsg.WcWss", "onMessage callback is null");
        AppMethodBeat.o(144291);
        return -1;
    }

    private static int getStatisticsNetType() {
        AppMethodBeat.i(144292);
        try {
            int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
            if (netType == -1) {
                AppMethodBeat.o(144292);
                return -1;
            } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                AppMethodBeat.o(144292);
                return 3;
            } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                AppMethodBeat.o(144292);
                return 4;
            } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                AppMethodBeat.o(144292);
                return 5;
            } else if (NetStatusUtil.isWifi(netType)) {
                AppMethodBeat.o(144292);
                return 1;
            } else if (NetStatusUtil.isWap(netType)) {
                AppMethodBeat.o(144292);
                return 2;
            } else {
                AppMethodBeat.o(144292);
                return 6;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WcWss", e2, "getStatisticsNetType_", new Object[0]);
            AppMethodBeat.o(144292);
            return -1;
        }
    }
}
