package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hz;
import com.tencent.mm.plugin.expt.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.d;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class k {
    static void a(cbo cbo, cbl cbl) {
        AppMethodBeat.i(122260);
        String b2 = b(cbo, cbl);
        if (g.eP(b2)) {
            AppMethodBeat.o(122260);
            return;
        }
        a.cMI().sxs.aoq(b2);
        e.cQg();
        boolean cQc = e.cQc();
        Log.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport: %b", Boolean.valueOf(cQc));
        if (cQc) {
            AppMethodBeat.o(122260);
            return;
        }
        aqZ(b2);
        a.cMI().sxs.aop(b2);
        AppMethodBeat.o(122260);
    }

    private static String b(cbo cbo, cbl cbl) {
        AppMethodBeat.i(122261);
        Map<String, List<cbm>> c2 = j.c(cbl);
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
                Log.i("HABBYGE-MALI.HellSessionUBAReport", "toJsonOfSessionUBA, session: %s", next.sessionId);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sessionId", next.sessionId);
                jSONObject2.put("tbe", next.startTime);
                jSONObject2.put("pagePath", b(c2, next));
                long j3 = next.endTime - next.startTime;
                if (j3 <= 0) {
                    j3 = 0;
                }
                jSONObject2.put(LocaleUtil.INDONESIAN_NEWNAME, j3);
                jSONArray.put(jSONObject2);
            }
            Iterator<cyh> it2 = cbo.Mht.iterator();
            while (it2.hasNext()) {
                cyh next2 = it2.next();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sessionId", b.aqy(next2.dMl) + "_" + next2.startTime);
                jSONObject3.put("tbe", next2.startTime);
                jSONObject3.put("pagePath", a(c2, next2));
                long j4 = next2.endTime - next2.startTime;
                if (j4 <= 0) {
                    j4 = 0;
                }
                jSONObject3.put(LocaleUtil.INDONESIAN_NEWNAME, j4);
                jSONArray.put(jSONObject3);
            }
            if (jSONArray.length() <= 0) {
                Log.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport content is NULL");
                AppMethodBeat.o(122261);
                return null;
            }
            jSONObject.put("content", jSONArray);
            String jSONObject4 = jSONObject.toString();
            AppMethodBeat.o(122261);
            return jSONObject4;
        } catch (JSONException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", e2, "HellSessionUBAReport, crash: %s", e2.getMessage());
            AppMethodBeat.o(122261);
            return null;
        }
    }

    private static JSONArray b(Map<String, List<cbm>> map, cyl cyl) {
        AppMethodBeat.i(184382);
        JSONArray jSONArray = new JSONArray();
        List<cbm> list = map.get(cyl.sessionId);
        if (list == null || list.isEmpty()) {
            Log.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForSession: NULL");
            AppMethodBeat.o(184382);
            return jSONArray;
        }
        JSONObject jSONObject = null;
        long j2 = 0;
        try {
            int i2 = 0;
            for (cbm cbm : list) {
                if (cbm != null) {
                    jSONObject = new JSONObject();
                    jSONObject.put("pageName", cbm.dMl);
                    jSONObject.put("tbe", cbm.startTime);
                    jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, cbm.duration);
                    j2 += cbm.duration;
                    i2++;
                    j.a(jSONObject, cbm, true, -1);
                    jSONArray.put(jSONObject);
                }
            }
            long j3 = cyl.endTime - cyl.startTime;
            if (j3 < 5000) {
                cyl.endTime = j2 + cyl.startTime;
            } else if (i2 == 1) {
                jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j3);
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", e2, "pagePathJsonArrayForSession json crash", new Object[0]);
        }
        AppMethodBeat.o(184382);
        return jSONArray;
    }

    private static JSONArray a(Map<String, List<cbm>> map, cyh cyh) {
        AppMethodBeat.i(184383);
        JSONArray jSONArray = new JSONArray();
        if (cyh.dMl == null || cyh.dMl.isEmpty()) {
            AppMethodBeat.o(184383);
            return jSONArray;
        }
        String str = cyh.dMl + "_" + cyh.startTime;
        Log.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknonwSessionId: %s", str);
        List<cbm> list = map.get(str);
        if (list == null || list.isEmpty()) {
            Log.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
            AppMethodBeat.o(184383);
            return jSONArray;
        }
        JSONObject jSONObject = null;
        long j2 = 0;
        try {
            int i2 = 0;
            for (cbm cbm : list) {
                if (cbm != null) {
                    jSONObject = new JSONObject();
                    jSONObject.put("pageName", cbm.dMl);
                    jSONObject.put("tbe", cbm.startTime);
                    jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, cbm.duration);
                    j2 += cbm.duration;
                    jSONArray.put(jSONObject);
                    i2++;
                }
            }
            long j3 = cyh.endTime - cyh.startTime;
            if (j3 < 5000) {
                cyh.endTime = j2 + cyh.startTime;
            } else if (i2 == 1) {
                jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j3);
            }
            Log.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage: %s", jSONArray.toString());
        } catch (JSONException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", e2, "pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        }
        AppMethodBeat.o(184383);
        return jSONArray;
    }

    private static boolean ara(String str) {
        boolean z = false;
        z = false;
        AppMethodBeat.i(184385);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(184385);
        } else {
            Log.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, reportSessionUBA: %s", str);
            List<String> aMr = com.tencent.mm.plugin.report.a.aMr(str.replace(',', '#'));
            if (aMr != null) {
                hz hzVar = new hz();
                hzVar.eMF = Process.myPid();
                hz vJ = hzVar.vJ(com.tencent.mm.kernel.g.aAe().azG().mProcessName);
                vJ.eLd = (long) com.tencent.mm.plugin.report.a.eOr();
                vJ.eMH = (long) aMr.size();
                for (int i2 = 0; i2 < aMr.size(); i2++) {
                    hzVar.eMG = (long) i2;
                    hzVar.vK(aMr.get(i2)).bfK();
                }
                z = true;
            }
            AppMethodBeat.o(184385);
        }
        return z;
    }

    private static void aqZ(String str) {
        AppMethodBeat.i(184384);
        long aqI = d.aqI(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQv());
        Log.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, lastReportTime: %s", Long.valueOf(aqI));
        if (aqI == -1) {
            com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqK(str);
            AppMethodBeat.o(184384);
        } else if (aqI == 0) {
            if (ara(str)) {
                com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqL(String.valueOf(System.currentTimeMillis()));
            }
            AppMethodBeat.o(184384);
        } else {
            String aqJ = d.aqJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQv());
            if ("-1".equals(aqJ)) {
                com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqK(str);
                AppMethodBeat.o(184384);
                return;
            }
            if (aqJ == null || aqJ.isEmpty()) {
                aqJ = str;
            } else if (str != null && !str.isEmpty()) {
                aqJ = aqJ + "|" + str;
            }
            if (i.aq(aqJ, aqI)) {
                if (ara(aqJ)) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqL(String.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(184384);
                return;
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqK(str);
            AppMethodBeat.o(184384);
        }
    }
}
