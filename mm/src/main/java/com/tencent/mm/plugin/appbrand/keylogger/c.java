package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class c {
    private static e mPf = new e();
    private static boolean mPg = false;

    static {
        AppMethodBeat.i(221296);
        AppMethodBeat.o(221296);
    }

    public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c cVar) {
        AppMethodBeat.i(221281);
        e eVar = mPf;
        Log.i("KeyStepLoggerWrapper", "setLoggerDelegate");
        eVar.mPk = cVar;
        AppMethodBeat.o(221281);
    }

    public static void bMP() {
        mPg = true;
    }

    public static com.tencent.mm.plugin.appbrand.keylogger.base.c bMQ() {
        return mPf;
    }

    public static void e(Class cls, String str) {
        AppMethodBeat.i(221282);
        List<j> g2 = f.g(cls, null);
        if (g2 == null) {
            AppMethodBeat.o(221282);
            return;
        }
        a(str, g2.get(0).mPG, "");
        d.ea(g2.get(0).mPG.bMU(), str);
        AppMethodBeat.o(221282);
    }

    public static void f(Class cls, String str) {
        AppMethodBeat.i(221283);
        List<j> g2 = f.g(cls, null);
        if (g2 == null) {
            AppMethodBeat.o(221283);
            return;
        }
        a(str, g2.get(g2.size() - 1).mPG, "");
        d.eb(g2.get(0).mPG.bMU(), str);
        AppMethodBeat.o(221283);
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(221284);
        if (mPg) {
            mPf.g(aVar.bMU(), "%d|%s|%s|%d|%s|%s", Long.valueOf(System.currentTimeMillis()), str, aVar.name(), 0, "stepStart", "");
        }
        d.a(str, aVar);
        AppMethodBeat.o(221284);
    }

    public static void a(String str, a aVar, String str2, long j2, long j3) {
        AppMethodBeat.i(221285);
        if (mPg) {
            mPf.g(aVar.bMU(), "%d|%s|%s|%d|%s|%s", Long.valueOf(j2), str, aVar.name(), 0, "stepStart", str2);
            e eVar = mPf;
            String bMU = aVar.bMU();
            Object[] objArr = new Object[6];
            objArr[0] = Long.valueOf(j3);
            objArr[1] = str;
            objArr[2] = aVar.name();
            objArr[3] = Integer.valueOf(aVar.bMV() ? 1 : 0);
            objArr[4] = "ok";
            objArr[5] = str2;
            eVar.g(bMU, "%d|%s|%s|%d|%s|%s", objArr);
        }
        d.a(str, aVar, j3 - j2);
        AppMethodBeat.o(221285);
    }

    public static void b(String str, a aVar) {
        AppMethodBeat.i(261726);
        a(str, aVar, "");
        AppMethodBeat.o(261726);
    }

    private static void a(String str, a aVar, String str2) {
        AppMethodBeat.i(221287);
        if (mPg) {
            a(aVar.bMU(), str, aVar.name(), aVar.bMV(), str2);
        }
        d.e(str, aVar);
        AppMethodBeat.o(221287);
    }

    private static void a(String str, String str2, String str3, boolean z, String str4) {
        int i2 = 1;
        AppMethodBeat.i(221288);
        e eVar = mPf;
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = str2;
        objArr[2] = str3;
        if (!z) {
            i2 = 0;
        }
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = "ok";
        objArr[5] = str4;
        eVar.g(str, "%d|%s|%s|%d|%s|%s", objArr);
        AppMethodBeat.o(221288);
    }

    public static void a(String str, a aVar, String str2, String str3, long j2, long j3) {
        AppMethodBeat.i(221289);
        if (mPg) {
            mPf.g(aVar.bMU(), "%d|%s|%s|%d|%s|%s", Long.valueOf(j2), str, aVar.name(), 0, "stepStart", str3);
            e eVar = mPf;
            String bMU = aVar.bMU();
            Object[] objArr = new Object[6];
            objArr[0] = Long.valueOf(j3);
            objArr[1] = str;
            objArr[2] = aVar.name();
            objArr[3] = Integer.valueOf(aVar.bMV() ? 1 : 0);
            objArr[4] = String.format("fail:%s", str2);
            objArr[5] = str3;
            eVar.g(bMU, "%d|%s|%s|%d|%s|%s", objArr);
        }
        d.d(str, aVar);
        AppMethodBeat.o(221289);
    }

    public static void c(String str, a aVar) {
        AppMethodBeat.i(221290);
        b(str, aVar, "");
        AppMethodBeat.o(221290);
    }

    public static void b(String str, a aVar, String str2) {
        AppMethodBeat.i(221291);
        a(str, aVar, str2, "");
        AppMethodBeat.o(221291);
    }

    private static void a(String str, a aVar, String str2, String str3) {
        AppMethodBeat.i(221292);
        if (mPg) {
            a(aVar.bMU(), str, aVar.name(), aVar.bMV(), str2, str3);
        }
        d.d(str, aVar);
        AppMethodBeat.o(221292);
    }

    private static void a(String str, String str2, String str3, boolean z, String str4, String str5) {
        int i2;
        AppMethodBeat.i(221293);
        e eVar = mPf;
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = str2;
        objArr[2] = str3;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = String.format("fail:%s", str4);
        objArr[5] = str5;
        eVar.g(str, "%d|%s|%s|%d|%s|%s", objArr);
        AppMethodBeat.o(221293);
    }

    public static void a(Class cls, String str, String str2) {
        AppMethodBeat.i(221294);
        if (!mPg) {
            AppMethodBeat.o(221294);
            return;
        }
        String aC = f.aC(cls);
        if (aC == null) {
            AppMethodBeat.o(221294);
            return;
        }
        mPf.g(aC, "%d|%s|%s|%d|%s|%s", Long.valueOf(System.currentTimeMillis()), str, "CollectKeyInfo", 0, "", str2);
        AppMethodBeat.o(221294);
    }

    public static IKeyStepAnalyser.StepLogInfo abR(String str) {
        boolean z;
        AppMethodBeat.i(221295);
        String abS = e.abS(str);
        if (Util.isNullOrNil(abS)) {
            AppMethodBeat.o(221295);
            return null;
        }
        String[] split = abS.split("\\|", -1);
        if (split == null) {
            Log.w("WeAppKeyLogger", "parse items null");
            AppMethodBeat.o(221295);
            return null;
        } else if (split.length != 6) {
            Log.w("WeAppKeyLogger", "parse items length illegal:%d", Integer.valueOf(split.length));
            AppMethodBeat.o(221295);
            return null;
        } else {
            try {
                IKeyStepAnalyser.StepLogInfo stepLogInfo = new IKeyStepAnalyser.StepLogInfo();
                stepLogInfo.time = Util.getLong(split[0], 0);
                stepLogInfo.sessionId = split[1];
                stepLogInfo.mPw = split[2];
                if (Util.getInt(split[3], 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                stepLogInfo.mPx = z;
                stepLogInfo.errMsg = split[4];
                stepLogInfo.mPy = split[5];
                AppMethodBeat.o(221295);
                return stepLogInfo;
            } catch (Exception e2) {
                Log.i("WeAppKeyLogger", "parse e:%s", e2);
                AppMethodBeat.o(221295);
                return null;
            }
        }
    }
}
