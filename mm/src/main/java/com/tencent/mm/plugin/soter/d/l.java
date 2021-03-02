package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public enum l {
    INSTANCE;
    
    private String appId = null;
    private int errCode = 0;
    private int errType = 0;

    private l(String str) {
    }

    public static l valueOf(String str) {
        AppMethodBeat.i(130851);
        l lVar = (l) Enum.valueOf(l.class, str);
        AppMethodBeat.o(130851);
        return lVar;
    }

    static {
        AppMethodBeat.i(130853);
        AppMethodBeat.o(130853);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void r(String str, String str2, int i2, int i3) {
        boolean z;
        int i4;
        AppMethodBeat.i(130852);
        Log.d("MicroMsg.SoterReportManager", "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d", str, str2, Integer.valueOf(i2), Integer.valueOf(i3));
        switch (str.hashCode()) {
            case -1378849968:
                if (str.equals("requireSoterBiometricAuthentication")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 70807596:
                if (str.equals("getSupportSoter")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                i4 = 0;
                break;
            case true:
                i4 = 1;
                break;
            default:
                Log.e("MicroMsg.SoterReportManager", "unknown soter jsapi function name");
                i4 = -1;
                break;
        }
        Log.i("MicroMsg.SoterReportManager", "functionNameCode: %d", Integer.valueOf(i4));
        if (i4 != -1) {
            h.INSTANCE.a(13711, Integer.valueOf(i4), str2, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        AppMethodBeat.o(130852);
    }
}
