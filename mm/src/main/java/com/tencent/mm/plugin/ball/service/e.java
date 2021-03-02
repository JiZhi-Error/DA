package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements d {
    private static List<BallInfo> oXv = new Vector();
    public static int oXw = 0;
    public static int oXx = com.tencent.mm.plugin.ball.f.e.oYW;
    public static boolean oXy = false;
    private static e oXz;

    static {
        AppMethodBeat.i(106235);
        AppMethodBeat.o(106235);
    }

    private e() {
        AppMethodBeat.i(106222);
        vC();
        if (g.af(a.class) != null) {
            ((a) g.af(a.class)).ff(oXv);
        }
        AppMethodBeat.o(106222);
    }

    public static e ciJ() {
        AppMethodBeat.i(106223);
        if (oXz == null) {
            synchronized (e.class) {
                try {
                    if (oXz == null) {
                        oXz = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(106223);
                    throw th;
                }
            }
        }
        e eVar = oXz;
        AppMethodBeat.o(106223);
        return eVar;
    }

    public static int ciK() {
        return oXw;
    }

    public static int ciL() {
        return oXx;
    }

    public static boolean ciM() {
        return oXy;
    }

    public static List<BallInfo> ciN() {
        return oXv;
    }

    public static int agV(String str) {
        AppMethodBeat.i(176965);
        int decodeInt = MultiProcessMMKV.getMMKV(cik()).decodeInt(str, 0);
        AppMethodBeat.o(176965);
        return decodeInt;
    }

    public static void cz(String str, int i2) {
        AppMethodBeat.i(176966);
        MultiProcessMMKV.getMMKV(cik()).encode(str, i2);
        AppMethodBeat.o(176966);
    }

    private static String UE(String str) {
        AppMethodBeat.i(106226);
        g.aAf();
        if (!com.tencent.mm.kernel.a.azo()) {
            AppMethodBeat.o(106226);
            return str;
        }
        StringBuilder sb = new StringBuilder();
        g.aAf();
        String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append("#").append(str).toString();
        AppMethodBeat.o(106226);
        return sb2;
    }

    public static String cik() {
        AppMethodBeat.i(106227);
        g.aAf();
        if (!com.tencent.mm.kernel.a.azo()) {
            AppMethodBeat.o(106227);
            return "float_ball_storage";
        }
        String UE = UE("float_ball_storage");
        AppMethodBeat.o(106227);
        return UE;
    }

    @Override // com.tencent.mm.plugin.ball.c.d
    public final void a(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(106228);
        oXv = list;
        ciO();
        AppMethodBeat.o(106228);
    }

    public final synchronized void clear() {
        AppMethodBeat.i(106229);
        MultiProcessMMKV.getMMKV(cik()).clear();
        AppMethodBeat.o(106229);
    }

    private synchronized void a(BallInfo ballInfo, JSONObject jSONObject) {
        AppMethodBeat.i(106230);
        if (ballInfo != null) {
            if (jSONObject != null) {
                Log.i("MicroMsg.FloatBallStorage", ">>>>>> saveBallInfo, dataKey:%s <<<<<<", ballInfo.cif());
                MultiProcessMMKV.getMMKV(cik()).encode(ballInfo.cif(), jSONObject.toString());
                AppMethodBeat.o(106230);
            } else {
                Log.i("MicroMsg.FloatBallStorage", ">>>>>> saveBallInfo, clear value, dataKey:%s <<<<<<", ballInfo.cif());
                MultiProcessMMKV.getMMKV(cik()).encode(ballInfo.cif(), "");
            }
        }
        AppMethodBeat.o(106230);
    }

    public final synchronized void l(BallInfo ballInfo) {
        AppMethodBeat.i(106231);
        if (ballInfo != null) {
            Log.i("MicroMsg.FloatBallStorage", ">>>>>> removeBallInfo, dataKey:%s <<<<<<", ballInfo.cif());
            MultiProcessMMKV.getMMKV(cik()).remove(ballInfo.cif()).commit();
        }
        AppMethodBeat.o(106231);
    }

    private synchronized void ciO() {
        int i2;
        int i3;
        AppMethodBeat.i(106232);
        JSONArray jSONArray = new JSONArray();
        try {
            if (com.tencent.mm.plugin.ball.f.d.h(oXv)) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < oXv.size()) {
                    BallInfo ballInfo = oXv.get(i4);
                    JSONObject x = BallInfo.x(ballInfo);
                    if (x != null) {
                        int i6 = i5 + 1;
                        jSONArray.put(i5, x);
                        a(ballInfo, x);
                        i3 = i6;
                    } else {
                        i3 = i5;
                    }
                    i4++;
                    i5 = i3;
                }
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallStorage", e2, "saveBallInfoList fail, exception:%s", e2);
        }
        MultiProcessMMKV.getMMKV(cik()).encode("balls", jSONArray.toString());
        List<BallInfo> cg = com.tencent.mm.plugin.ball.f.d.cg(oXv);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(cik());
        if (com.tencent.mm.plugin.ball.f.d.h(cg)) {
            i2 = cg.size();
        } else {
            i2 = 0;
        }
        mmkv.encode("ActiveCount", i2);
        AppMethodBeat.o(106232);
    }

    private static void ciP() {
        boolean z;
        AppMethodBeat.i(106234);
        String[] allKeys = MultiProcessMMKV.getMMKV(cik()).allKeys();
        int length = allKeys != null ? allKeys.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            String str = allKeys[i2];
            if (!Util.isEqual(str, "pos_x") && !Util.isEqual(str, "pos_y") && !Util.isEqual(str, "balls") && !Util.isEqual(str, "ActiveCount") && !Util.isEqual(str, "req_perm_cnt")) {
                Iterator<BallInfo> it = oXv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Util.isEqual(str, it.next().cif())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    Log.i("MicroMsg.FloatBallStorage", "fixExistedKeyValues, key:%s", str);
                    MultiProcessMMKV.getMMKV(cik()).remove(str).commit();
                }
            }
        }
        AppMethodBeat.o(106234);
    }

    private synchronized void vC() {
        BallInfo av;
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(106233);
            try {
                String[] allKeys = MultiProcessMMKV.getMMKV(cik()).allKeys();
                int length = allKeys != null ? allKeys.length : 0;
                Log.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, size:%s", Integer.valueOf(length));
                for (int i2 = 0; i2 < length; i2++) {
                    Log.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, key:%s", allKeys[i2]);
                }
                oXw = MultiProcessMMKV.getMMKV(cik()).decodeInt("pos_x", 0);
                oXx = MultiProcessMMKV.getMMKV(cik()).decodeInt("pos_y", com.tencent.mm.plugin.ball.f.e.oYW);
                if (MultiProcessMMKV.getMMKV(cik()).contains("dock_left")) {
                    z = MultiProcessMMKV.getMMKV(cik()).decodeBool("dock_left", false);
                } else if (oXw >= com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) / 2) {
                    z = false;
                }
                oXy = z;
                String decodeString = MultiProcessMMKV.getMMKV(cik()).decodeString("balls");
                if (Util.isNullOrNil(decodeString)) {
                    oXv = new Vector();
                    Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList is empty", Integer.valueOf(oXw), Integer.valueOf(oXx));
                    AppMethodBeat.o(106233);
                } else {
                    Log.i("MicroMsg.FloatBallStorage", "load, savedBalls:%s", decodeString);
                    try {
                        oXv = new Vector();
                        JSONArray jSONArray = new JSONArray(decodeString);
                        if (jSONArray.length() > 0) {
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                                if (!(optJSONObject == null || (av = BallInfo.av(optJSONObject)) == null)) {
                                    if (!av.oWr || av.type == 16) {
                                        av.nno = false;
                                        av.state = 0;
                                        oXv.add(av);
                                    } else {
                                        l(av);
                                    }
                                }
                            }
                        }
                        ciP();
                        Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList:%s", Integer.valueOf(oXw), Integer.valueOf(oXx), oXv);
                        AppMethodBeat.o(106233);
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.FloatBallStorage", e2, "load fail, exception:%s", e2);
                        AppMethodBeat.o(106233);
                    }
                }
            } catch (UnsatisfiedLinkError e3) {
                oXw = 0;
                oXx = com.tencent.mm.plugin.ball.f.e.oYW;
                oXy = false;
                oXv = new Vector();
                Log.printErrStackTrace("MicroMsg.FloatBallStorage", e3, "load fail, error:%s", e3);
                AppMethodBeat.o(106233);
            }
        }
    }
}
