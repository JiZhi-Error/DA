package com.tencent.mm.plugin.expt.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.h.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements m {
    private i callback;
    private long rNK;
    private long rNL;
    private a rNM;

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1020;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(220258);
        this.callback = iVar;
        this.rNM = a.cMx();
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_REPORT_EXPT_APP_LAST_TIME_SEC_INT, Integer.valueOf((int) Util.nowSecond()));
            this.rNK = a.cMx().rNI;
            if (this.rNK == 0) {
                Log.e("MicroMsg.ReportExptAppInfo", "acquisition did not start  [%d]", Long.valueOf(this.rNK));
                AppMethodBeat.o(220258);
                return -1;
            }
            this.rNL = Util.nowMilliSecond();
            Log.i("MicroMsg.ReportExptAppInfo", "acquisition beginTime[%d] endTime[%d]", Long.valueOf(this.rNK), Long.valueOf(this.rNL));
            try {
                d.a aVar = new d.a();
                aVar.iLN = new dni();
                aVar.iLO = new dnj();
                aVar.uri = "/cgi-bin/mmfddataappsvr/reportexptappinfo";
                aVar.funcId = 1020;
                aVar.iLP = 0;
                aVar.respCmdId = 0;
                d aXF = aVar.aXF();
                dni dni = (dni) aXF.iLK.iLR;
                dni.rNK = this.rNK;
                dni.rNL = this.rNL;
                ahd ahd = new ahd();
                ahd.ljQ = Build.MANUFACTURER;
                ahd.model = Build.MODEL;
                ahd.LqN = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
                ahd.LqO = Build.CPU_ABI;
                dni.LVC = ahd;
                List<aki> cMA = b.cMz().cMA();
                if (cMA.size() > 0) {
                    dni.MQB = new LinkedList<>();
                    for (aki aki : cMA) {
                        aki aki2 = new aki();
                        aki2.Ltq = aki.Ltq;
                        aki2.Ltr = aki.Ltr;
                        aki2.Lts = aki.Lts;
                        aki2.count = aki.count;
                        dni.MQB.add(aki2);
                    }
                    Log.i("MicroMsg.ReportExptAppInfo", "req local appInfoList [%d] ", Integer.valueOf(dni.MQB.size()));
                }
                e.INSTANCE.idkeyStat(863, 160, 1, false);
                int dispatch = dispatch(gVar, aXF, this);
                AppMethodBeat.o(220258);
                return dispatch;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ReportExptAppInfo", e2, "get appInfo error", new Object[0]);
                AppMethodBeat.o(220258);
                return -1;
            }
        } else {
            AppMethodBeat.o(220258);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(220259);
        Log.i("MicroMsg.ReportExptAppInfo", "get appInfo on gy end. errType[%d] erroCode[%d] errMsg[%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            dnj dnj = (dnj) ((d) sVar).iLL.iLR;
            if (dnj != null) {
                if (dnj.getBaseResponse().Ret != 0) {
                    Log.w("MicroMsg.ReportExptAppInfo", "get appInfo error. resp baseResp [%d] [%s]", Integer.valueOf(dnj.getBaseResponse().Ret), dnj.getBaseResponse().ErrMsg);
                    e.INSTANCE.idkeyStat(863, 162, 1, false);
                } else {
                    long currentTicks = Util.currentTicks();
                    ArrayList arrayList = new ArrayList();
                    if (dnj.LVJ != null && dnj.LVJ.size() > 0) {
                        Iterator<akh> it = dnj.LVJ.iterator();
                        while (it.hasNext()) {
                            a aVar = new a();
                            aVar.TN(it.next().Ltt);
                            arrayList.add(aVar);
                        }
                    }
                    com.tencent.mm.plugin.expt.f.a.cRk();
                    com.tencent.mm.plugin.expt.f.a.fO(dnj.LVH, dnj.MQC);
                    com.tencent.mm.plugin.expt.f.a.cRk();
                    com.tencent.mm.plugin.expt.f.a.b(0, dnj.LVI, arrayList);
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(dnj.LVH);
                    objArr[1] = Integer.valueOf(dnj.MQC);
                    objArr[2] = Integer.valueOf(dnj.LVI != null ? dnj.LVI.size() : 0);
                    objArr[3] = Integer.valueOf(arrayList.size());
                    objArr[4] = Long.valueOf(Util.ticksToNow(currentTicks));
                    Log.i("MicroMsg.ReportExptAppInfo", "updateExpt intervalSecond[%d] pullSecond [%d] del size [%d] replace [%d] cost[%d]", objArr);
                    e.INSTANCE.idkeyStat(863, 161, 1, false);
                }
            }
            b.cMz().cMB();
            if (!this.rNM.Dl(this.rNL)) {
                Log.e("MicroMsg.ReportExptAppInfo", "change Begin Time err [%d] [%d]", Long.valueOf(this.rNK), Long.valueOf(this.rNL));
            }
        } else {
            Log.i("MicroMsg.ReportExptAppInfo", "report change begin time  ok!");
            e.INSTANCE.idkeyStat(863, 162, 1, false);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(220259);
    }
}
