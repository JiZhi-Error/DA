package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class i {
    public static void c(cbo cbo, cbl cbl, cyl cyl) {
        AppMethodBeat.i(177403);
        if (cbo == null || cbl == null) {
            AppMethodBeat.o(177403);
        } else if (cbo.Mht.isEmpty() && cbo.Mhr.isEmpty()) {
            AppMethodBeat.o(177403);
        } else if (cbl.Mhn.isEmpty()) {
            AppMethodBeat.o(177403);
        } else {
            Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenEvent8 BEGIN !!");
            j.a(cbl, cbo, false);
            j.a(cbo, cbl.Mhn.getFirst());
            j.d(cbo, cbl, cyl);
            AppMethodBeat.o(177403);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0081 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Map<java.lang.Long, java.util.List<com.tencent.mm.protocal.protobuf.dvi>> a(java.util.Map<java.lang.String, java.util.List<com.tencent.mm.protocal.protobuf.cbm>> r18, com.tencent.mm.protocal.protobuf.cyl r19) {
        /*
        // Method dump skipped, instructions count: 517
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.f.f.i.a(java.util.Map, com.tencent.mm.protocal.protobuf.cyl):java.util.Map");
    }

    public static Map<Long, dvi> a(cbm cbm, List<dvk> list) {
        boolean z;
        AppMethodBeat.i(122248);
        HashSet hashSet = new HashSet();
        String aoE = b.aoE(cbm.dMl);
        if (aoE == null) {
            AppMethodBeat.o(122248);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (dvk dvk : list) {
            dvg dvg = dvk.MWr.get(dvk.index + 1);
            if (aoE.equals(b.aoE(dvg.dMl))) {
                dvk.index++;
                if (dvk.index == dvk.MWr.size() - 1) {
                    dvk.index = -1;
                    z = true;
                } else {
                    z = false;
                }
                a(cbm, dvg, dvk.LPN);
                Iterator<cbn> it = cbm.LPG.iterator();
                while (it.hasNext()) {
                    cbn next = it.next();
                    if (next != null) {
                        hashSet.add(next.businessId);
                    }
                }
            } else {
                dvg dvg2 = dvk.MWr.get(0);
                if (aoE.equals(b.aoE(dvg2.dMl))) {
                    dvk.index = 0;
                    a(cbm, dvg2, dvk.LPN);
                    z = false;
                } else {
                    dvk.index = -1;
                    z = false;
                }
            }
            dvi dvi = new dvi();
            dvi.index = dvk.index;
            dvi.MWo = z;
            dvi.LPN = dvk.LPN;
            dvi.dRM = cbm.dRM;
            dvi.vtY = dvk.vtY;
            dvi.LPM = dvk.LPM;
            hashMap.put(Long.valueOf(dvk.LPN), dvi);
        }
        a.h(hashSet);
        AppMethodBeat.o(122248);
        return hashMap;
    }

    private static void a(cbm cbm, dvg dvg, long j2) {
        AppMethodBeat.i(220586);
        Iterator<erd> it = cbm.LPH.iterator();
        while (it.hasNext()) {
            erd next = it.next();
            if (next != null) {
                cgd cgd = new cgd();
                cgd.KVX = j2;
                Iterator<ere> it2 = dvg.MWm.iterator();
                while (it2.hasNext()) {
                    ere next2 = it2.next();
                    if (next2 != null && ((next2.viewId.equals(next.id) || next2.NoL.equals(next.NoL)) && g.gp(next.NoM, next2.NoR))) {
                        Log.i("HABBYGE-MALI.HellSessionReport", "recordRealDataPath: id=%s, res=%s", next.id, next.NoL);
                        next.NoQ = false;
                        Iterator<cyk> it3 = next2.MWl.iterator();
                        while (it3.hasNext()) {
                            cyk next3 = it3.next();
                            if (next3 != null) {
                                cgd.MlP.add(next3.dataPath);
                            }
                        }
                    }
                }
                if (!cgd.MlP.isEmpty()) {
                    next.NoP.add(cgd);
                }
            }
        }
        AppMethodBeat.o(220586);
    }

    static JSONObject j(cbo cbo) {
        AppMethodBeat.i(177405);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tbe", cbo.Mhp);
            long j2 = cbo.Mhq - cbo.Mhp;
            if (j2 <= 0) {
                j2 = 0;
            }
            jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j2);
            jSONObject.put("vv", "2.0");
            AppMethodBeat.o(177405);
            return jSONObject;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionReport", e2, "createJSONObjectHead, crash: %s", e2.getMessage());
            AppMethodBeat.o(177405);
            return null;
        }
    }

    static boolean aq(String str, long j2) {
        int length;
        AppMethodBeat.i(184381);
        if (str == null) {
            AppMethodBeat.o(184381);
            return false;
        }
        try {
            length = str.getBytes().length;
        } catch (Exception e2) {
            length = str.length();
        }
        if (length >= 20480 || System.currentTimeMillis() - j2 >= Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(184381);
            return true;
        }
        AppMethodBeat.o(184381);
        return false;
    }

    static void ag(Map<Long, List<dvi>> map) {
        List<dvi> arrayList;
        AppMethodBeat.i(177406);
        dvj aqP = k.aqP("mmkv_key_hellSPMatchSuche_");
        if (aqP == null || aqP.MWq.isEmpty()) {
            AppMethodBeat.o(177406);
            return;
        }
        Iterator<dvi> it = aqP.MWq.iterator();
        while (it.hasNext()) {
            dvi next = it.next();
            if (map.containsKey(Long.valueOf(next.LPN))) {
                arrayList = map.get(Long.valueOf(next.LPN));
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
            } else {
                arrayList = new ArrayList<>();
            }
            arrayList.add(next);
            map.put(Long.valueOf(next.LPN), arrayList);
        }
        AppMethodBeat.o(177406);
    }
}
