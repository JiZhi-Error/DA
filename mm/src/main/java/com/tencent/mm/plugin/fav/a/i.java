package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    private static String taA = "";
    private static String taB = "";
    private static long taC = 0;
    public static List<a> taz;

    /* access modifiers changed from: package-private */
    public static class a {
        int in;
        String pageId;
        String sGF;
        long taD;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void start() {
        AppMethodBeat.i(103398);
        taz = new Vector();
        AppMethodBeat.o(103398);
    }

    public static void end() {
        AppMethodBeat.i(103399);
        if (taz == null) {
            taz = null;
            cUE();
            AppMethodBeat.o(103399);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (a aVar : taz) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", aVar.pageId);
                jSONObject.put("tbe", aVar.taD);
                jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, aVar.in);
                jSONObject.put("sid", aVar.sGF);
            } catch (JSONException e2) {
                Log.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
            }
            sb.append(jSONObject.toString()).append(";");
            if (sb.length() > 3072) {
                taz = null;
                cUE();
                AppMethodBeat.o(103399);
                return;
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        if (sb2.length() > 3072) {
            taz = null;
            cUE();
            AppMethodBeat.o(103399);
            return;
        }
        String[] strArr = new String[3];
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                strArr[i2] = "";
            } catch (Throwable th) {
                Log.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + th.getMessage());
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 >= 3) {
                break;
            }
            if (sb2.length() <= 1024) {
                strArr[i3] = sb2;
                break;
            }
            strArr[i3] = sb2.substring(0, 1024);
            sb2 = sb2.substring(1024);
            i3++;
        }
        h.INSTANCE.a(15508, strArr[0], strArr[1], strArr[2]);
        taz = null;
        cUE();
        AppMethodBeat.o(103399);
    }

    private static void a(String str, long j2, int i2, String str2) {
        AppMethodBeat.i(103400);
        if (taz == null) {
            AppMethodBeat.o(103400);
            return;
        }
        a aVar = new a((byte) 0);
        aVar.pageId = str;
        aVar.taD = j2;
        aVar.in = i2;
        if (Util.isNullOrNil(str2)) {
            aVar.sGF = "-1";
        } else {
            aVar.sGF = str2;
        }
        if (taz != null) {
            taz.add(aVar);
        }
        AppMethodBeat.o(103400);
    }

    private static void cUE() {
        taA = "";
        taB = "";
        taC = 0;
    }

    public static void gF(String str, String str2) {
        AppMethodBeat.i(103401);
        if (!Util.isNullOrNil(taA)) {
            gG(taA, taB);
        }
        taA = str;
        taB = str2;
        taC = System.currentTimeMillis();
        AppMethodBeat.o(103401);
    }

    public static void arT(String str) {
        AppMethodBeat.i(103402);
        gF(str, "");
        AppMethodBeat.o(103402);
    }

    private static void gG(String str, String str2) {
        AppMethodBeat.i(103403);
        if (Util.isNullOrNil(str) || !str.equals(taA)) {
            AppMethodBeat.o(103403);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - taC);
        taC /= 1000;
        if (Util.isNullOrNil(str2)) {
            str2 = "-1";
        }
        a(str, taC, currentTimeMillis, str2);
        cUE();
        AppMethodBeat.o(103403);
    }

    public static void arU(String str) {
        AppMethodBeat.i(103404);
        gG(str, "");
        AppMethodBeat.o(103404);
    }
}
