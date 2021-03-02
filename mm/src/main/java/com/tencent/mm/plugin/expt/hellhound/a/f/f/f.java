package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class f {
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void f(com.tencent.mm.protocal.protobuf.cbo r12) {
        /*
        // Method dump skipped, instructions count: 340
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.f.f.f.f(com.tencent.mm.protocal.protobuf.cbo):void");
    }

    private static String i(cbo cbo) {
        AppMethodBeat.i(184378);
        try {
            HashMap hashMap = new HashMap();
            Iterator<cyl> it = cbo.Mhr.iterator();
            while (it.hasNext()) {
                cyl next = it.next();
                String aqn = b.aqn(next.sessionId);
                if (aqn != null) {
                    if (hashMap.containsKey(aqn)) {
                        JSONObject jSONObject = (JSONObject) hashMap.get(aqn);
                        if (jSONObject == null) {
                            JSONObject p = p(next);
                            if (p != null) {
                                hashMap.put(aqn, p);
                            }
                        } else if (next.startTime > 0) {
                            long optLong = jSONObject.optLong(LocaleUtil.INDONESIAN_NEWNAME);
                            long j2 = next.endTime - next.startTime;
                            if (j2 <= 0) {
                                j2 = 0;
                            }
                            jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j2 + optLong);
                            jSONObject.put("count", jSONObject.optInt("count") + 1);
                            hashMap.put(aqn, jSONObject);
                        }
                    } else {
                        JSONObject p2 = p(next);
                        if (p2 != null) {
                            hashMap.put(aqn, p2);
                        }
                    }
                }
            }
            Iterator<cyh> it2 = cbo.Mht.iterator();
            while (it2.hasNext()) {
                cyh next2 = it2.next();
                String aqy = b.aqy(next2.dMl);
                if (aqy != null) {
                    if (hashMap.containsKey(aqy)) {
                        JSONObject jSONObject2 = (JSONObject) hashMap.get(aqy);
                        if (jSONObject2 == null) {
                            JSONObject d2 = d(next2);
                            if (d2 != null) {
                                hashMap.put(aqy, d2);
                            }
                        } else if (next2.startTime > 0) {
                            long optLong2 = jSONObject2.optLong(LocaleUtil.INDONESIAN_NEWNAME);
                            long j3 = next2.endTime - next2.startTime;
                            if (j3 <= 0) {
                                j3 = 0;
                            }
                            jSONObject2.put(LocaleUtil.INDONESIAN_NEWNAME, j3 + optLong2);
                            jSONObject2.put("count", jSONObject2.optInt("count") + 1);
                            hashMap.put(aqy, jSONObject2);
                        }
                    } else {
                        JSONObject d3 = d(next2);
                        if (d3 != null) {
                            hashMap.put(aqy, d3);
                        }
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : hashMap.entrySet()) {
                jSONArray.put(entry.getValue());
            }
            if (jSONArray.length() <= 0) {
                AppMethodBeat.o(184378);
                return null;
            }
            if (cbo.Mhp > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("tbe", cbo.Mhp);
                long j4 = cbo.Mhq - cbo.Mhp;
                if (j4 <= 0) {
                    j4 = 0;
                }
                jSONObject3.put(LocaleUtil.INDONESIAN_NEWNAME, j4);
                jSONObject3.put("vv", "2.0");
                jSONObject3.put("content", jSONArray);
                String jSONObject4 = jSONObject3.toString();
                AppMethodBeat.o(184378);
                return jSONObject4;
            }
            AppMethodBeat.o(184378);
            return null;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionMergeReport", e2, "HellSessionMergereport crash: %s", e2.getMessage());
        }
    }

    private static JSONObject p(cyl cyl) {
        AppMethodBeat.i(122230);
        if (cyl.startTime <= 0) {
            AppMethodBeat.o(122230);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sid", b.aqn(cyl.sessionId));
            long j2 = cyl.endTime - cyl.startTime;
            if (j2 <= 0) {
                j2 = 0;
            }
            jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j2);
            jSONObject.put("count", 1);
            AppMethodBeat.o(122230);
            return jSONObject;
        } catch (Exception e2) {
            AppMethodBeat.o(122230);
            return null;
        }
    }

    private static JSONObject d(cyh cyh) {
        AppMethodBeat.i(122231);
        if (cyh.startTime <= 0) {
            AppMethodBeat.o(122231);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sid", b.aqy(cyh.dMl));
            long j2 = cyh.endTime - cyh.startTime;
            if (j2 <= 0) {
                j2 = 0;
            }
            jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j2);
            jSONObject.put("count", 1);
            AppMethodBeat.o(122231);
            return jSONObject;
        } catch (Exception e2) {
            AppMethodBeat.o(122231);
            return null;
        }
    }

    private static boolean aqW(String str) {
        boolean z = false;
        z = false;
        AppMethodBeat.i(184379);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(184379);
        } else {
            Log.i("HABBYGE-MALI.HellSessionMergeReport", "reportSessionMerge: %s", str);
            List<String> aMr = a.aMr(str.replace(',', '#'));
            if (aMr != null) {
                hx hxVar = new hx();
                hxVar.eMF = Process.myPid();
                hx vF = hxVar.vF(g.aAe().azG().mProcessName);
                vF.eLd = (long) a.eOr();
                vF.eMH = (long) aMr.size();
                for (int i2 = 0; i2 < aMr.size(); i2++) {
                    hxVar.eMG = (long) i2;
                    hxVar.vG(aMr.get(i2)).bfK();
                }
                z = true;
            }
            AppMethodBeat.o(184379);
        }
        return z;
    }
}
