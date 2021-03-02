package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.g.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.protocal.protobuf.eap;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends q implements m {
    public long DIt;
    public dzo DIu;
    private Object DIv;
    private int DIw;
    public i callback;
    public int ecf;
    private MMHandler handler;
    private d rr;
    public int type;

    public s(long j2, int i2) {
        this(j2, i2, (dzo) null, (Object) null);
    }

    public s(long j2, int i2, Object obj) {
        this(j2, i2, (dzo) null, obj);
    }

    public s(long j2, int i2, dzo dzo) {
        this(j2, i2, dzo, (Object) null);
    }

    private s(long j2, int i2, dzo dzo, Object obj) {
        AppMethodBeat.i(95601);
        this.type = -1;
        this.DIt = 0;
        this.ecf = -1;
        this.DIw = 0;
        this.handler = new MMHandler(Looper.getMainLooper());
        this.DIu = dzo;
        this.type = i2;
        this.DIt = j2;
        this.DIv = obj;
        Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j2 + "  op : " + i2);
        if (dzo != null) {
            Log.i("MicroMsg.NetSceneSnsObjectOp", dzo.MYT + " " + dzo.MYV);
        }
        d.a aVar = new d.a();
        aVar.iLN = new eah();
        aVar.iLO = new eai();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.funcId = 218;
        aVar.iLP = 104;
        aVar.respCmdId = 1000000104;
        this.rr = aVar.aXF();
        eah eah = (eah) this.rr.iLK.iLR;
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ != null) {
            this.ecf = JJ.localid;
        }
        eae a2 = a(j2, i2, this.DIu, obj);
        LinkedList<eae> linkedList = new LinkedList<>();
        linkedList.add(a2);
        eah.MZC = linkedList;
        eah.MZB = linkedList.size();
        if (i2 == 1) {
            try {
                ewf ewf = new ewf();
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
                eah.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
                AppMethodBeat.o(95601);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(95601);
    }

    public s(long j2, int i2, int i3, String str) {
        AppMethodBeat.i(95602);
        this.type = -1;
        this.DIt = 0;
        this.ecf = -1;
        this.DIw = 0;
        this.handler = new MMHandler(Looper.getMainLooper());
        this.DIu = null;
        this.type = 9;
        this.DIt = j2;
        Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j2 + "  op : " + this.type);
        d.a aVar = new d.a();
        aVar.iLN = new eah();
        aVar.iLO = new eai();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.funcId = 218;
        aVar.iLP = 104;
        aVar.respCmdId = 1000000104;
        this.rr = aVar.aXF();
        eah eah = (eah) this.rr.iLK.iLR;
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ != null) {
            this.ecf = JJ.localid;
        }
        eae V = V(j2, this.type);
        eag eag = new eag();
        eag.Scene = i2;
        eag.MZz = i3;
        eag.MZA = z.Su(str);
        try {
            V.MDa = new SKBuiltinBuffer_t().setBuffer(eag.toByteArray());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
        }
        LinkedList<eae> linkedList = new LinkedList<>();
        linkedList.add(V);
        eah.MZC = linkedList;
        eah.MZB = linkedList.size();
        AppMethodBeat.o(95602);
    }

    private static eae a(long j2, int i2, dzo dzo, Object obj) {
        SnsInfo snsInfo;
        String str;
        String str2;
        SnsInfo snsInfo2;
        AppMethodBeat.i(95603);
        eae V = V(j2, i2);
        Log.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i2 + " " + (obj == null ? "" : obj.toString()));
        String str3 = "";
        if (i2 == 8 || i2 == 10 || i2 == 7 || i2 == 8 || i2 == 6) {
            AdSnsInfo JE = aj.faR().JE(j2);
            if (JE != null) {
                snsInfo2 = JE.convertToSnsInfo();
            } else {
                snsInfo2 = null;
            }
            if (snsInfo2 == null || !snsInfo2.isAd()) {
                snsInfo = snsInfo2;
            } else {
                ADInfo adInfo = snsInfo2.getAdInfo();
                String str4 = adInfo == null ? "" : adInfo.uxInfo;
                Log.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(str4)));
                str3 = str4;
                snsInfo = snsInfo2;
            }
        } else {
            snsInfo = null;
        }
        if (i2 == 6) {
            if (dzo == null || (dzo.MYT == 0 && dzo.MYV == 0)) {
                AppMethodBeat.o(95603);
                return V;
            }
            dzh dzh = new dzh();
            dzh.MYP = dzo.MYV;
            dzh.MYD = z.Su(Util.nullAs(str3, ""));
            try {
                V.MDa = new SKBuiltinBuffer_t().setBuffer(dzh.toByteArray());
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i2 == 7) {
            dyz dyz = new dyz();
            dyz.MYD = z.Su(Util.nullAs(str3, ""));
            try {
                V.MDa = new SKBuiltinBuffer_t().setBuffer(dyz.toByteArray());
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e3, "", new Object[0]);
            }
        } else if (i2 == 8) {
            boolean z = obj != null && (obj instanceof ADInfo.c.a);
            if (z) {
                ADInfo.c.a aVar = (ADInfo.c.a) obj;
                str = Util.nullAs(str3, "") + ("&" + aVar.DDs + "|" + aVar.DWe);
            } else {
                str = str3;
            }
            dzc dzc = new dzc();
            dzc.MYD = z.Su(Util.nullAs(str, ""));
            if (snsInfo != null) {
                dzc.xub = snsInfo.getAdRecSrc();
                String snsId = snsInfo.getSnsId();
                SnsInfo aQl = aj.faO().aQl(snsId);
                if (aQl != null) {
                    str2 = j.b(aQl.getTimeLine());
                } else {
                    Log.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", snsId);
                    str2 = "";
                }
                dzc.MYF = z.Su(Util.nullAs(str2, ""));
            }
            if (!z || ((ADInfo.c.a) obj).DWd != ADInfo.c.a.DVZ) {
                aj.faR().delete(j2);
                aj.faT().JI(j2);
                g.JH(j2);
                if (z) {
                    dzc.MYG = ((ADInfo.c.a) obj).DWd;
                }
            } else {
                dzc.MYG = ADInfo.c.a.DVZ;
            }
            try {
                V.MDa = new SKBuiltinBuffer_t().setBuffer(dzc.toByteArray());
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e4, "", new Object[0]);
            }
        } else if (i2 == 4) {
            if (dzo == null || (dzo.MYT == 0 && dzo.MYV == 0)) {
                AppMethodBeat.o(95603);
                return V;
            }
            eaf eaf = new eaf();
            eaf.MYT = dzo.MYT;
            try {
                V.MDa = new SKBuiltinBuffer_t().setBuffer(eaf.toByteArray());
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e5, "", new Object[0]);
            }
        } else if (i2 == 10) {
            eap eap = new eap();
            if (obj instanceof b) {
                b bVar = (b) obj;
                eap.Nac = z.aC(bVar.zy);
                Log.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + bVar.zy.length);
            } else {
                Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] byteArray = eap.toByteArray();
                V.MDa = new SKBuiltinBuffer_t().setBuffer(byteArray);
                Log.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + byteArray.length);
            } catch (Exception e6) {
                Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e6.getMessage());
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e6, "", new Object[0]);
            }
        } else if (i2 == 12) {
            if (obj instanceof eab) {
                eab eab = (eab) obj;
                try {
                    V.MDa = z.aC(eab.toByteArray());
                    Log.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + eab.MZw);
                } catch (Exception e7) {
                    Log.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + e7.getMessage());
                }
            } else {
                Log.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
            }
        }
        AppMethodBeat.o(95603);
        return V;
    }

    private static eae V(long j2, int i2) {
        AppMethodBeat.i(95604);
        eae eae = new eae();
        eae.MDa = new SKBuiltinBuffer_t();
        eae.Id = j2;
        eae.him = i2;
        AppMethodBeat.o(95604);
        return eae;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(95605);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95605);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 218;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        dzo dzo;
        dzo dzo2;
        AppMethodBeat.i(95606);
        Log.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            switch (this.type) {
                case 1:
                    aj.faN().Js(this.DIt);
                    aj.faO().delete(this.DIt);
                    eai eai = (eai) ((d) sVar).iLL.iLR;
                    if (eai.MZE == 1) {
                        aj.faS().D(aj.fau(), eai.MZG);
                        break;
                    }
                    break;
                case 2:
                    SnsInfo JJ = aj.faO().JJ(this.DIt);
                    if (JJ != null) {
                        JJ.setPravited(1);
                        JJ.setLocalPrivate();
                        aj.faO().b(this.DIt, JJ);
                        break;
                    }
                    break;
                case 3:
                    SnsInfo JJ2 = aj.faO().JJ(this.DIt);
                    if (JJ2 != null) {
                        JJ2.setPravited(0);
                        JJ2.unLocalPrivate();
                        JJ2.setExtFlag();
                        aj.faO().b(this.DIt, JJ2);
                        break;
                    }
                    break;
                case 4:
                    SnsInfo JJ3 = aj.faO().JJ(this.DIt);
                    if (JJ3 != null) {
                        try {
                            SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JJ3.field_attrBuf);
                            Iterator<dzo> it = snsObject.CommentUserList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    dzo2 = it.next();
                                    if (this.DIu == null || dzo2.MYT != this.DIu.MYT) {
                                    }
                                } else {
                                    dzo2 = null;
                                }
                            }
                            if (dzo2 != null) {
                                snsObject.CommentUserList.remove(dzo2);
                            }
                            JJ3.setAttrBuf(snsObject.toByteArray());
                            aj.faO().S(JJ3);
                            aj.faT().j(JJ3.field_snsId, (long) this.DIu.MYT, this.DIu.oUv);
                            break;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    aj.faN().Ju(this.DIt);
                    break;
                case 6:
                    AdSnsInfo JE = aj.faR().JE(this.DIt);
                    if (JE != null) {
                        try {
                            SnsObject snsObject2 = (SnsObject) new SnsObject().parseFrom(JE.field_attrBuf);
                            Iterator<dzo> it2 = snsObject2.CommentUserList.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    dzo = it2.next();
                                    if (this.DIu == null || dzo.MYV != this.DIu.MYV) {
                                    }
                                } else {
                                    dzo = null;
                                }
                            }
                            if (dzo != null) {
                                snsObject2.CommentUserList.remove(dzo);
                            }
                            JE.setAttrBuf(snsObject2.toByteArray());
                            aj.faR().replace(JE);
                            aj.faT().j(JE.field_snsId, this.DIu.MYV, this.DIu.oUv);
                            break;
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e3, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    aj.faN().Ju(this.DIt);
                    break;
                case 8:
                    if (this.DIv == null || !(this.DIv instanceof ADInfo.c.a) || ((ADInfo.c.a) this.DIv).DWd != ADInfo.c.a.DVZ) {
                        aj.faR().delete(this.DIt);
                        aj.faT().JI(this.DIt);
                        g.JH(this.DIt);
                        EventCenter.instance.publish(new bs());
                        break;
                    }
                case 9:
                    SnsInfo JJ4 = aj.faO().JJ(this.DIt);
                    if (JJ4 != null) {
                        JJ4.removeSourceFlag(2);
                        aj.faO().b(this.DIt, JJ4);
                        break;
                    }
                    break;
                case 11:
                    Log.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.DIw);
                    if (this.DIw == 0) {
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.TRUE);
                    } else if (this.DIw == 1) {
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                    com.tencent.mm.kernel.g.aAi();
                    int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, (Object) 0)).intValue();
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(intValue + 1));
                    com.tencent.mm.kernel.g.aAi();
                    int intValue2 = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, (Object) 0)).intValue();
                    if (this.DIw == 0) {
                        intValue2++;
                        int i5 = (intValue2 * 2) + com.tencent.mm.plugin.appbrand.jsapi.p.z.CTRL_INDEX;
                        if (i5 >= 216) {
                            i5 = 216;
                        }
                        if (i5 >= 200) {
                            com.tencent.mm.plugin.sns.lucky.a.b.pl(i5);
                        }
                        Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i5 + " " + intValue2);
                    } else if (this.DIw == 1) {
                        intValue2++;
                        int i6 = (intValue2 * 2) + com.tencent.mm.plugin.appbrand.jsapi.p.z.CTRL_INDEX + 1;
                        if (i6 >= 217) {
                            i6 = 217;
                        }
                        if (i6 >= 201) {
                            com.tencent.mm.plugin.sns.lucky.a.b.pl(i6);
                        }
                        Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i6 + " " + intValue2);
                    }
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(intValue2));
                    break;
                case 12:
                    if (this.DIv != null && (this.DIv instanceof eab)) {
                        boolean z = ((eab) this.DIv).MZw == 1;
                        aj.faT().L(this.DIt, z);
                        Log.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", Long.valueOf(this.DIt), Boolean.valueOf(z));
                        break;
                    }
            }
            aj.faN().fan();
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95606);
            return;
        }
        if (i3 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    aj.faN().Js(this.DIt);
                    break;
                case 5:
                case 7:
                    aj.faN().Ju(this.DIt);
                    break;
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95606);
    }
}
