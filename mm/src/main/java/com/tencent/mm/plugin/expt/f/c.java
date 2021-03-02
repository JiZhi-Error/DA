package com.tencent.mm.plugin.expt.f;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.h.a;
import com.tencent.mm.plugin.expt.h.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements m {
    private i callback;
    private int iWD = 0;

    public c(int i2) {
        this.iWD = i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(220637);
        this.callback = iVar;
        try {
            d.a aVar = new d.a();
            aVar.iLN = new bna();
            aVar.iLO = new bnb();
            aVar.uri = "/cgi-bin/mmfddataappsvr/getexptappconfig";
            aVar.funcId = 1110;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            d aXF = aVar.aXF();
            bna bna = (bna) aXF.iLK.iLR;
            bna.Scene = this.iWD;
            bna.LVB = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_APP_LAST_TIME_SEC_INT, (Object) 0)).intValue();
            ahd ahd = new ahd();
            ahd.ljQ = Build.MANUFACTURER;
            ahd.model = Build.MODEL;
            ahd.LqN = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
            ahd.LqO = Build.CPU_ABI;
            bna.LVC = ahd;
            bna.LVF = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_APP_GLOBAL_SEQ_STRING, "");
            bna.LVE = this.iWD == 3 ? 0 : 1;
            if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_GET_EXPT_APP_NEED_ALL_INT, 0) == 1) {
                bna.LVE = 0;
            }
            int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_APP_NEED_LOCAL_LIST_INT, (Object) 1)).intValue();
            if (intValue == 1 || bna.LVE == 0) {
                bna.LVD = cRp();
            }
            e.INSTANCE.idkeyStat(863, 155, 1, false);
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(bna.Scene);
            objArr[1] = Integer.valueOf(bna.LVB);
            objArr[2] = Integer.valueOf(bna.LVE);
            objArr[3] = bna.LVF;
            objArr[4] = Integer.valueOf(intValue);
            objArr[5] = Integer.valueOf(bna.LVD != null ? bna.LVD.size() : 0);
            Log.i("MicroMsg.NetSceneGetExptApp", "get expt app scene[%d] lastGetSvrSec[%d] IsIncrement[%d] GlobalSequence[%s] nextReqNeedLocalList[%d] localExptList[%d]", objArr);
            int dispatch = dispatch(gVar, aXF, this);
            AppMethodBeat.o(220637);
            return dispatch;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneGetExptApp", e2, "", new Object[0]);
            AppMethodBeat.o(220637);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(220638);
        if (i3 == 0 && i4 == 0) {
            bnb bnb = (bnb) ((d) sVar).iLL.iLR;
            if (bnb == null) {
                z = false;
            } else if (bnb.BaseResponse.Ret != 0) {
                z = false;
            } else {
                ArrayList arrayList = new ArrayList();
                if (bnb.LVJ != null && bnb.LVJ.size() > 0) {
                    Iterator<akh> it = bnb.LVJ.iterator();
                    while (it.hasNext()) {
                        a aVar = new a();
                        aVar.TN(it.next().Ltt);
                        arrayList.add(aVar);
                    }
                }
                a.cRk();
                a.b(bnb.KHa, bnb.LVI, arrayList);
                Hz(bnb.LVG);
                int i5 = bnb.LVH;
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_INTERVAL_SEC_INT, Integer.valueOf(i5));
                int i6 = bnb.LVK;
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_NEED_LOCAL_LIST_INT, Integer.valueOf(i6));
                String str2 = bnb.LVF;
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_GLOBAL_SEQ_STRING, str2);
                Log.i("MicroMsg.NetSceneGetExptApp", "updateExpt interval[%d] nextReqNeedLocalList[%d] globalSeq[%s] updateList[%d]", Integer.valueOf(i5), Integer.valueOf(i6), str2, Integer.valueOf(arrayList.size()));
                z = true;
            }
            if (z) {
                e.INSTANCE.idkeyStat(863, 156, 1, false);
            } else {
                e.INSTANCE.idkeyStat(863, 157, 1, false);
            }
        } else {
            Log.w("MicroMsg.NetSceneGetExptApp", "get expt error");
            Hz((int) Util.nowSecond());
            e.INSTANCE.idkeyStat(863, 157, 1, false);
        }
        a.cRk();
        a.mq(false);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(220638);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1110;
    }

    private static LinkedList<akh> cRp() {
        AppMethodBeat.i(220639);
        LinkedList<akh> linkedList = new LinkedList<>();
        List<a> cRL = b.cRI().cRL();
        if (cRL.size() > 0) {
            at atVar = new at();
            for (a aVar : cRL) {
                if (aVar != null) {
                    akh akh = new akh();
                    akh.Ltq = aVar.sLf;
                    akh.Ltr = aVar.adT;
                    akh.Lts = aVar.sLg;
                    akh.Ltv = aVar.sLk;
                    atVar.eqq = akh.Ltq;
                    atVar.eqr = akh.Lts;
                    atVar.enW = 1;
                    atVar.eOp();
                    linkedList.add(akh);
                }
            }
        }
        AppMethodBeat.o(220639);
        return linkedList;
    }

    private static void Hz(int i2) {
        AppMethodBeat.i(220640);
        int nowSecond = (int) Util.nowSecond();
        if (nowSecond > i2) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_LAST_TIME_SEC_INT, Integer.valueOf(nowSecond));
            AppMethodBeat.o(220640);
            return;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_APP_LAST_TIME_SEC_INT, Integer.valueOf(i2));
        AppMethodBeat.o(220640);
    }
}
