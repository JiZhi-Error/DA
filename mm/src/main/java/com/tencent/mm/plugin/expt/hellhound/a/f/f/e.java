package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class e {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void f(com.tencent.mm.protocal.protobuf.cbo r10) {
        /*
        // Method dump skipped, instructions count: 432
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.f.f.e.f(com.tencent.mm.protocal.protobuf.cbo):void");
    }

    private static String h(cbo cbo) {
        AppMethodBeat.i(122226);
        if (cbo.Mhp <= 0) {
            AppMethodBeat.o(122226);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tbe", cbo.Mhp);
            long j2 = cbo.Mhq - cbo.Mhp;
            if (j2 <= 0) {
                j2 = 0;
            }
            jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j2);
            jSONObject.put("vv", "2.0");
            JSONArray jSONArray = new JSONArray();
            Iterator<cyl> it = cbo.Mhr.iterator();
            while (it.hasNext()) {
                cyl next = it.next();
                if (next.startTime > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sessionId", next.sessionId);
                    String aqz = b.aqz(next.kvy);
                    if (aqz == null) {
                        aqz = "";
                    }
                    jSONObject2.put("lastSessionId", aqz);
                    jSONObject2.put("tbe", next.startTime);
                    long j3 = next.endTime - next.startTime;
                    if (j3 <= 0) {
                        j3 = 0;
                    }
                    jSONObject2.put(LocaleUtil.INDONESIAN_NEWNAME, j3);
                    jSONArray.put(jSONObject2);
                }
            }
            Iterator<cyh> it2 = cbo.Mht.iterator();
            while (it2.hasNext()) {
                cyh next2 = it2.next();
                if (next2.startTime > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("sessionId", b.aqy(next2.dMl) + "_" + next2.startTime);
                    String aqz2 = b.aqz(next2.kvy);
                    if (aqz2 == null) {
                        aqz2 = "";
                    }
                    jSONObject3.put("lastSessionId", aqz2);
                    jSONObject3.put("tbe", next2.startTime);
                    long j4 = next2.endTime - next2.startTime;
                    if (j4 <= 0) {
                        j4 = 0;
                    }
                    jSONObject3.put(LocaleUtil.INDONESIAN_NEWNAME, j4);
                    jSONArray.put(jSONObject3);
                }
            }
            if (jSONArray.length() <= 0) {
                AppMethodBeat.o(122226);
                return null;
            }
            jSONObject.put("content", jSONArray);
            String jSONObject4 = jSONObject.toString();
            AppMethodBeat.o(122226);
            return jSONObject4;
        } catch (JSONException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionDetailReport", e2, "HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
            AppMethodBeat.o(122226);
            return null;
        }
    }

    private static boolean aqV(String str) {
        boolean z = false;
        z = false;
        AppMethodBeat.i(184377);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(184377);
        } else {
            Log.i("HABBYGE-MALI.HellSessionDetailReport", "reportSessionDetail: %s", str);
            List<String> aMr = a.aMr(str.replace(',', '#'));
            if (aMr != null) {
                hy hyVar = new hy();
                hyVar.eMF = Process.myPid();
                hy vH = hyVar.vH(g.aAe().azG().mProcessName);
                vH.eLd = (long) a.eOr();
                vH.eMH = (long) aMr.size();
                for (int i2 = 0; i2 < aMr.size(); i2++) {
                    hyVar.eMG = (long) i2;
                    hyVar.vI(aMr.get(i2)).bfK();
                }
                z = true;
            }
            AppMethodBeat.o(184377);
        }
        return z;
    }
}
