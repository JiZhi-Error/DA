package com.tencent.mm.plugin.expt.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.np;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.h.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class b extends q implements m {
    private i callback;
    private int iWD;

    b(int i2) {
        this.iWD = i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2738;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(122351);
        this.callback = iVar;
        try {
            long currentTicks = Util.currentTicks();
            d.a aVar = new d.a();
            aVar.iLN = new bnc();
            aVar.iLO = new bnd();
            aVar.uri = "/cgi-bin/mmexptappsvr-bin/getexptconfig";
            aVar.funcId = 2738;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            d aXF = aVar.aXF();
            bnc bnc = (bnc) aXF.iLK.iLR;
            bnc.Scene = this.iWD;
            bnc.LVB = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, (Object) 0)).intValue();
            List<c> cSc = a.cRk().sJX.cSc();
            if (cSc != null && cSc.size() > 0) {
                bnc.LVD = new LinkedList<>();
                for (c cVar : cSc) {
                    akl akl = new akl();
                    akl.Ltq = cVar.field_exptId;
                    akl.Ltr = cVar.field_groupId;
                    akl.Lts = cVar.field_exptSeq;
                    akl.Ltv = cVar.field_exptCheckSum;
                    bnc.LVD.add(akl);
                }
                Log.i("MicroMsg.NetSceneGetExpt", "req local exptList [%s] ", Arrays.toString(cSc.toArray()));
            }
            h.INSTANCE.idkeyStat(863, 0, 1, false);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bnc.Scene);
            objArr[1] = Integer.valueOf(bnc.LVB);
            objArr[2] = Integer.valueOf(bnc.LVD != null ? bnc.LVD.size() : 0);
            objArr[3] = Long.valueOf(Util.ticksToNow(currentTicks));
            Log.i("MicroMsg.NetSceneGetExpt", "get expt config scene[%d] lastGetSvrSec[%d] localExptList[%d] cost[%d]", objArr);
            int dispatch = dispatch(gVar, aXF, this);
            AppMethodBeat.o(122351);
            return dispatch;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneGetExpt", e2, "get expt error", new Object[0]);
            AppMethodBeat.o(122351);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        int i5;
        int i6;
        MultiProcessMMKV aTI;
        AppMethodBeat.i(122352);
        Log.i("MicroMsg.NetSceneGetExpt", "get expt on gy end. errType[%d] erroCode[%d] errMsg[%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            bnd bnd = (bnd) ((d) sVar).iLL.iLR;
            if (!(bnd == null || bnd.getBaseResponse() == null)) {
                if (bnd.getBaseResponse().Ret != 0) {
                    Log.w("MicroMsg.NetSceneGetExpt", "get expt error. resp baseResp [%d] [%s]", Integer.valueOf(bnd.getBaseResponse().Ret), bnd.getBaseResponse().ErrMsg);
                    h.INSTANCE.idkeyStat(863, 2, 1, false);
                } else {
                    long currentTicks = Util.currentTicks();
                    Hz(bnd.LVG);
                    int i7 = bnd.LVH;
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_INTERVAL_SEC_INT, Integer.valueOf(i7));
                    if (bnd.LVL == 1) {
                        h.INSTANCE.idkeyStat(863, 7, 1, false);
                        long currentTicks2 = Util.currentTicks();
                        a cRk = a.cRk();
                        int cRZ = cRk.sJX.cRZ();
                        Log.i("MicroMsg.ExptService", "delete all expt count[%d] map count[%d]", Integer.valueOf(cRZ), Integer.valueOf(cRk.sJY.cRZ()));
                        cRk.cRj();
                        if (com.tencent.mm.plugin.expt.i.c.cSa().cSb() && (aTI = com.tencent.mm.plugin.expt.i.c.aTI()) != null) {
                            aTI.clear().commit();
                        }
                        Log.i("MicroMsg.NetSceneGetExpt", "check need del all expt count[%d] cost[%d]", Integer.valueOf(cRZ), Long.valueOf(Util.ticksToNow(currentTicks2)));
                        z = true;
                    } else {
                        z = false;
                    }
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    LinkedList<Integer> linkedList3 = bnd.LVI;
                    if (linkedList3 == null || linkedList3.size() <= 0) {
                        i5 = 0;
                    } else {
                        Log.i("MicroMsg.NetSceneGetExpt", "delete expt [%s]", Arrays.toString(linkedList3.toArray()));
                        for (Integer num : linkedList3) {
                            c Hv = a.cRk().Hv(num.intValue());
                            if (Hv != null && Hv.cRM()) {
                                linkedList2.add(num);
                            }
                            if (Hv != null && Hv.cRN()) {
                                a.cRk();
                                a.f("", false, true);
                            }
                            if (Hv != null && Hv.cRO()) {
                                a.cRk();
                                a.aY("", true);
                            }
                            if (Hv != null && Hv.cRP()) {
                                a.cRk();
                                a.b(Hv.cRW(), "", true, false);
                            }
                            a.cRk();
                            a.a(Hv, true);
                            e.INSTANCE.a(17582, num);
                        }
                        i5 = a.cRk().dv(linkedList3);
                        if (i5 >= 10) {
                            e.INSTANCE.idkeyStat(863, 13, 1, false);
                        }
                    }
                    LinkedList<akl> linkedList4 = bnd.LVJ;
                    if (linkedList4 == null || linkedList4.size() <= 0) {
                        i6 = 0;
                    } else {
                        LinkedList linkedList5 = new LinkedList();
                        np npVar = new np();
                        for (akl akl : linkedList4) {
                            c cVar = new c();
                            cVar.TN(akl.Ltt);
                            cVar.field_exptCheckSum = akl.Ltv;
                            if (!(cVar.field_exptId == akl.Ltq && cVar.field_groupId == akl.Ltr && cVar.field_exptSeq == akl.Lts)) {
                                Log.w("MicroMsg.NetSceneGetExpt", "expt item proto[%d %d %d] is different expt content[%d %d %d]", Integer.valueOf(akl.Ltq), Integer.valueOf(akl.Ltr), Integer.valueOf(akl.Lts), Integer.valueOf(cVar.field_exptId), Integer.valueOf(cVar.field_groupId), Integer.valueOf(cVar.field_exptSeq));
                                h.INSTANCE.idkeyStat(863, 6, 1, false);
                            }
                            linkedList5.add(cVar);
                            Log.i("MicroMsg.NetSceneGetExpt", "get expt item [%s]", cVar.toString());
                            if (cVar.cRM()) {
                                linkedList.add(cVar);
                            }
                            if (cVar.cRN()) {
                                a.cRk();
                                a.f(cVar.cRX(), cVar.cRV(), false);
                            }
                            if (cVar.cRO()) {
                                a.cRk();
                                a.aY(cVar.cRX(), false);
                            }
                            if (cVar.cRP()) {
                                a.cRk();
                                a.b(cVar.cRW(), cVar.cRX(), false, cVar.cRV());
                            }
                            a.cRk();
                            a.a(cVar, false);
                            npVar.fid = (long) cVar.field_exptId;
                            npVar.fie = (long) cVar.field_groupId;
                            npVar.fif = (long) cVar.field_exptSeq;
                            npVar.eOp();
                        }
                        i6 = a.cRk().du(linkedList5);
                    }
                    if (z || i5 > 0 || i6 > 0) {
                        a.cRk();
                        a.cRl();
                    }
                    a.cRk();
                    a.a(linkedList, bnd.KKx, linkedList2);
                    h.INSTANCE.idkeyStat(863, 1, 1, false);
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(bnd.LVG);
                    objArr[1] = Integer.valueOf(i7);
                    objArr[2] = Integer.valueOf(bnd.LVL);
                    objArr[3] = Integer.valueOf(linkedList3 != null ? linkedList3.size() : 0);
                    objArr[4] = Integer.valueOf(i5);
                    objArr[5] = Integer.valueOf(linkedList4 != null ? linkedList4.size() : 0);
                    objArr[6] = Integer.valueOf(i6);
                    objArr[7] = Long.valueOf(Util.ticksToNow(currentTicks));
                    Log.i("MicroMsg.NetSceneGetExpt", "update expt svrTime:%d interval:%d exptFlag:%d  deleteCount:[svr:%d local:%d] replaceCount:[svr:%d local:%d] cost[%d]", objArr);
                }
            }
        } else {
            h.INSTANCE.idkeyStat(863, 2, 1, false);
            Log.w("MicroMsg.NetSceneGetExpt", "get expt error");
            Hz((int) Util.nowSecond());
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(122352);
    }

    private static void Hz(int i2) {
        AppMethodBeat.i(122353);
        int nowSecond = (int) Util.nowSecond();
        if (nowSecond > i2) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(nowSecond));
            AppMethodBeat.o(122353);
            return;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(i2));
        AppMethodBeat.o(122353);
    }
}
