package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a<Boolean, cbc> {
    private boolean yjq = false;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ Boolean call(cbc cbc) {
        AppMethodBeat.i(55563);
        Boolean a2 = a(cbc);
        AppMethodBeat.o(55563);
        return a2;
    }

    public b(boolean z) {
        this.yjq = z;
    }

    private Boolean a(cbc cbc) {
        AppMethodBeat.i(55561);
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(55561);
            return bool;
        }
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, (Object) -1L)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - longValue));
        if (!this.yjq && currentTimeMillis - longValue < Util.MILLSECONDS_OF_DAY) {
            Log.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(55561);
            return bool2;
        } else if (this.yjq || !(cbc == null || cbc.Mgs == null)) {
            Log.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[41];
            objArr[0] = cbc.Mgs.imei;
            objArr[1] = cbc.Mgs.KOb;
            objArr[2] = cbc.Mgs.kxx;
            objArr[3] = cbc.Mgs.KOc;
            objArr[4] = cbc.Mgt.abi;
            objArr[5] = cbc.Mgt.LbP;
            objArr[6] = cbc.Mgt.kxx;
            objArr[7] = cbc.Mgt.LbR;
            objArr[8] = Integer.valueOf(cbc.Mgt.LbQ);
            objArr[9] = Integer.valueOf(cbc.Mgu.MuL);
            objArr[10] = Integer.valueOf(cbc.Mgu.MuM);
            objArr[11] = Integer.valueOf(cbc.Mgv.Ndq);
            objArr[12] = Integer.valueOf(cbc.Mgv.Ndr ? 1 : 0);
            objArr[13] = Integer.valueOf(cbc.Mgz.LPO ? 1 : 0);
            objArr[14] = Integer.valueOf(cbc.Mgz.LPP ? 1 : 0);
            objArr[15] = cbc.Mgw.resolution;
            objArr[16] = Integer.valueOf(cbc.Mgw.density);
            objArr[17] = cbc.Mgx.Lmu;
            objArr[18] = Integer.valueOf(cbc.Mgy.Lzc ? 1 : 0);
            objArr[19] = Integer.valueOf(cbc.Mgy.Lzd ? 1 : 0);
            objArr[20] = Integer.valueOf(cbc.Mgy.Lze ? 1 : 0);
            objArr[21] = Integer.valueOf(cbc.Mgy.Lzf ? 1 : 0);
            objArr[22] = Integer.valueOf(cbc.Mgy.Lzg ? 1 : 0);
            objArr[23] = Integer.valueOf(cbc.Mgy.Lzh ? 1 : 0);
            objArr[24] = Integer.valueOf(cbc.Mgy.Lzi ? 1 : 0);
            objArr[25] = Integer.valueOf(cbc.Mgy.Lzt ? 1 : 0);
            objArr[26] = Integer.valueOf(cbc.Mgy.Lzj ? 1 : 0);
            objArr[27] = Integer.valueOf(cbc.Mgy.Lzk ? 1 : 0);
            objArr[28] = Integer.valueOf(cbc.Mgy.Lzl ? 1 : 0);
            objArr[29] = Integer.valueOf(cbc.Mgy.Lzm ? 1 : 0);
            objArr[30] = Integer.valueOf(cbc.Mgy.Lzn ? 1 : 0);
            objArr[31] = Integer.valueOf(cbc.Mgy.Lzo ? 1 : 0);
            objArr[32] = Integer.valueOf(cbc.Mgy.Lzp ? 1 : 0);
            objArr[33] = Integer.valueOf(cbc.Mgy.Lzq ? 1 : 0);
            objArr[34] = Integer.valueOf(cbc.Mgy.Lzr ? 1 : 0);
            objArr[35] = Integer.valueOf(cbc.Mgy.Lzs ? 1 : 0);
            objArr[36] = Integer.valueOf(cbc.Mgu.AXb);
            objArr[37] = Integer.valueOf(cbc.Mgu.MuN);
            objArr[38] = cbc.Mgx.Lmv;
            objArr[39] = ba(cbc.Mgx.Lmw);
            objArr[40] = Integer.valueOf(cbc.Mgz.LPQ ? 1 : 0);
            hVar.a(14552, objArr);
            g.aAh().azQ().set(ar.a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, Long.valueOf(currentTimeMillis));
            h.INSTANCE.idkeyStat(661, 0, 1, false);
            Boolean bool3 = Boolean.TRUE;
            AppMethodBeat.o(55561);
            return bool3;
        } else {
            Log.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
            h.INSTANCE.idkeyStat(661, 1, 1, false);
            Boolean bool4 = Boolean.FALSE;
            AppMethodBeat.o(55561);
            return bool4;
        }
    }

    private static String ba(LinkedList<cow> linkedList) {
        AppMethodBeat.i(55562);
        JSONArray jSONArray = new JSONArray();
        if (linkedList != null) {
            try {
                Iterator<cow> it = linkedList.iterator();
                while (it.hasNext()) {
                    cow next = it.next();
                    if (next != null && !Util.isNullOrNil(next.mime)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("mimeName", next.mime);
                        JSONArray jSONArray2 = new JSONArray();
                        if (next.Mva != null) {
                            Iterator<String> it2 = next.Mva.iterator();
                            while (it2.hasNext()) {
                                jSONArray2.put(it2.next());
                            }
                        }
                        jSONObject.put("codecName", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
                String jSONArray3 = jSONArray.toString();
                AppMethodBeat.o(55562);
                return jSONArray3;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", e2, "hy: error when build up json", new Object[0]);
                AppMethodBeat.o(55562);
                return "";
            }
        } else {
            Log.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
            AppMethodBeat.o(55562);
            return "";
        }
    }
}
