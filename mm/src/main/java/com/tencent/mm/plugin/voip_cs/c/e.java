package com.tencent.mm.plugin.voip_cs.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.y;
import com.tencent.mm.plugin.appbrand.jsapi.share.c;
import com.tencent.mm.plugin.voip_cs.c.c.a;
import com.tencent.mm.plugin.voip_cs.c.c.b;
import com.tencent.mm.plugin.voip_cs.c.c.d;
import com.tencent.mm.plugin.voip_cs.c.c.f;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esx;
import com.tencent.mm.protocal.protobuf.etb;
import com.tencent.mm.protocal.protobuf.ete;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.euh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Arrays;
import java.util.LinkedList;

public final class e implements i {
    public int GWg = 0;
    public b HrE;
    public int HrF = 0;
    public int HrG = 0;
    public int HrH = 0;
    public byte[] HrI = null;
    public int HrJ = 0;
    public int HrK = 0;
    public int HrL = 0;
    public String HrM = "";
    public int HrN = 0;
    public int HrO = 999;
    public MTimerHandler HrP = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip_cs.c.e.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(125356);
            Log.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
            e.this.fMz();
            AppMethodBeat.o(125356);
            return true;
        }
    }, true);
    public MTimerHandler HrQ = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip_cs.c.e.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(125357);
            Log.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
            g.azz().a(c.CTRL_INDEX, e.this);
            g.azz().a(new b(c.fMr().Hsv.Haw, c.fMr().Hsv.ypH), 0);
            AppMethodBeat.o(125357);
            return true;
        }
    }, true);
    public int Hrb = 0;
    public int ypQ = 0;

    public e() {
        AppMethodBeat.i(125358);
        AppMethodBeat.o(125358);
    }

    public final int fMy() {
        return this.HrL;
    }

    public final void fMz() {
        AppMethodBeat.i(125359);
        g.azz().a(818, this);
        g.azz().a(new f(c.fMr().Hsv.Haw, c.fMr().Hsv.ypH, this.HrF), 0);
        AppMethodBeat.o(125359);
    }

    public final void aY(String str, String str2, String str3) {
        AppMethodBeat.i(125360);
        Log.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + str + ",appid:" + str2 + ",voipCSContext:" + str3);
        this.HrM = str;
        this.HrL = 1;
        d fMt = c.fMt();
        Log.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
        if (fMt.Hry == 0) {
            fMt.Hry = (int) (System.currentTimeMillis() / 1000);
        }
        byte[] bArr = null;
        if (str3 != null && !str3.equals("")) {
            bArr = str3.getBytes();
        }
        g.azz().a(823, this);
        c.fMr().Hsv.ypJ = (int) (System.currentTimeMillis() / 1000);
        com.tencent.mm.plugin.voip_cs.c.c.c cVar = new com.tencent.mm.plugin.voip_cs.c.c.c(c.fMr().Hsv.ypJ, str, c.fMr().Hsv.netType, bArr, c.fMr().Hsv.field_capInfo, str2);
        Log.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.fMr().Hsv.field_capInfo));
        g.azz().a(cVar, 0);
        AppMethodBeat.o(125360);
    }

    private static void c(int i2, int i3, q qVar) {
        int AddNewRelayConns;
        AppMethodBeat.i(125361);
        Log.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i2 + " errCode:" + i3);
        if (i3 != 0) {
            Log.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(i3)));
            AppMethodBeat.o(125361);
            return;
        }
        ete ete = (ete) ((d) qVar).rr.iLL.iLR;
        Log.i("MicroMsg.voipcs.VoipCSService", "roomid " + ete.NeG + " key " + ete.Lta + "relay addr cnt " + ete.KMD.size());
        LinkedList<esv> linkedList = ete.KMD;
        esr esr = new esr();
        for (esv esv : linkedList) {
            esq esq = new esq();
            esq.NgC = esv.MpA;
            esq.MKe = esv.MKe;
            esr.NpZ.add(esq);
        }
        esr.NpY = linkedList.size();
        dmm dmm = new dmm();
        dml dml = new dml();
        dml.LqX = 0;
        dml.LqY = "";
        dml.LqZ = "";
        dml.Lra = 4;
        dml.Lrb = 4;
        dml.Lrc = 2;
        dml.MPX = esr;
        dml.MPY = new esr();
        dmm.MQa.add(dml);
        dmm.MPZ = 1;
        byte[] bArr = null;
        try {
            bArr = dmm.toByteArray();
        } catch (Exception e2) {
            Log.e("MicroMsg.voipcs.VoipCSService", "conn info to byte array fail..");
        }
        if (!(bArr == null || (AddNewRelayConns = c.fMr().Hsv.AddNewRelayConns(bArr, bArr.length, 1)) == 0)) {
            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(AddNewRelayConns)));
        }
        AppMethodBeat.o(125361);
    }

    public final void a(etj etj) {
        int length;
        AppMethodBeat.i(125362);
        if (etj.NqC <= this.HrF || c.fMs().HrL == 3) {
            AppMethodBeat.o(125362);
            return;
        }
        Log.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + etj.NqC + ",calleeMemberId:" + etj.NqD + ",calleeStatus:" + etj.NqE + ",calleeSubStatus:" + etj.NqF + ",recv roomId:" + etj.NeG + ",recv roomKey:" + etj.Lta);
        if (c.fMr().Hsv.Haw == 0 || c.fMr().Hsv.Haw == etj.NeG) {
            this.HrF = etj.NqC;
            this.Hrb = etj.NqD;
            this.HrG = etj.NqE;
            this.HrH = etj.NqF;
            c.fMt().Hrb = this.Hrb;
            if (this.HrG == 2) {
                Log.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                this.HrP.stopTimer();
                fMz();
                c.fMr().Hsv.ypH = etj.Lta;
                Log.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + etj.NeG + ",roomkey:" + etj.Lta);
                this.HrI = etj.NqG != null ? etj.NqG.toByteArray() : null;
                if (c.fMr().Hsv.field_capInfo == null) {
                    AppMethodBeat.o(125362);
                } else if (this.HrI == null) {
                    AppMethodBeat.o(125362);
                } else {
                    c.fMt().fMv();
                    c.fMr().Hsv.Hay = this.HrI;
                    Log.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.fMr().Hsv.Hay));
                    Log.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.HrI.length);
                    if (c.fMr().Hsv.Hay != null && c.fMr().Hsv.exchangeCabInfo(c.fMr().Hsv.Hay, c.fMr().Hsv.Hay.length) < 0) {
                        Log.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                    }
                    if (c.fMr().Hsv.HaB == null) {
                        length = 0;
                    } else {
                        length = c.fMr().Hsv.HaB.length;
                    }
                    int configInfo = c.fMr().Hsv.setConfigInfo(c.fMr().Hsv.Hav, c.fMr().Hsv.Haw, c.fMr().Hsv.ypO, c.fMr().Hsv.ypH, c.fMr().Hsv.field_peerId, 1, c.fMr().Hsv.HaC, c.fMr().Hsv.HaD, c.fMr().Hsv.HaA, length, c.fMr().Hsv.HaB, this.HrO, 1, c.fMr().Hsv.netType, c.fMr().Hsv.HbJ, c.fMr().Hsv.HbK, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
                    if (configInfo != 0) {
                        Log.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", Integer.valueOf(configInfo));
                    }
                    if (c.fMr().Hsv.HbZ == null) {
                        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
                    } else {
                        int AddNewRelayConns = c.fMr().Hsv.AddNewRelayConns(c.fMr().Hsv.HbZ, c.fMr().Hsv.HbZ.length, 0);
                        if (AddNewRelayConns < 0) {
                            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(AddNewRelayConns)));
                        }
                    }
                    if (this.HrQ.stopped()) {
                        this.HrQ.startTimer(50000);
                    }
                    c.fMt().Hrh = 1;
                    AppMethodBeat.o(125362);
                }
            } else {
                if (!(this.HrG == 0 || this.HrG == 1 || this.HrG != 3)) {
                    Log.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                    c.fMt().dataType = 5;
                    c.fMt().fMu();
                    c.fMt().Hrl = 2;
                    if (this.HrH == 1) {
                        c.fMt().Hrd = 12;
                    } else if (this.HrH == 3) {
                        c.fMt().Hrd = 99;
                    }
                    if (this.HrE != null) {
                        this.HrE.aeh(1);
                    }
                }
                AppMethodBeat.o(125362);
            }
        } else {
            Log.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.fMr().Hsv.Haw + ",recv roomId:" + etj.NeG + ",current and recv not equal!!");
            AppMethodBeat.o(125362);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(125363);
        Log.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 != 0 || i3 != 0) {
            Log.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 != 0 && i2 != 4) {
                this.HrN = -1;
                this.HrE.onError(10);
                AppMethodBeat.o(125363);
                return;
            } else if (qVar.getType() == 823) {
                if (i3 == 406) {
                    Log.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    AppMethodBeat.o(125363);
                    return;
                }
                c.fMt().dataType = 1;
                this.HrN = 823;
                this.HrE.onError(i3);
                AppMethodBeat.o(125363);
                return;
            } else if (!(qVar.getType() == 880 || qVar.getType() == 818 || qVar.getType() != 106)) {
                this.HrE.ln("", "");
            }
        } else if (qVar.getType() == 823) {
            etb etb = (etb) ((com.tencent.mm.plugin.voip_cs.c.c.c) qVar).rr.iLL.iLR;
            long j2 = etb.NeG;
            long j3 = etb.Lta;
            LinkedList<esv> linkedList = etb.KMD;
            LinkedList<esv> linkedList2 = etb.NqB;
            this.ypQ = etb.Ndy;
            this.HrO = etb.NqA;
            Log.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.HrO);
            c.fMr().Hsv.HaD = etb.ypX;
            this.HrJ = etb.ypR;
            c.fMr().Hsv.HbJ = etb.yqc;
            c.fMr().Hsv.HbK = etb.MKv.toByteArray();
            c.fMr().Hsv.HaC = etb.ypY;
            esr esr = new esr();
            for (esv esv : linkedList) {
                esq esq = new esq();
                esq.NgC = esv.MpA;
                esq.MKe = esv.MKe;
                esr.NpZ.add(esq);
            }
            esr.NpY = linkedList.size();
            esr esr2 = new esr();
            for (esv esv2 : linkedList2) {
                esq esq2 = new esq();
                esq2.NgC = esv2.MpA;
                esq2.MKe = esv2.MKe;
                esr2.NpZ.add(esq2);
            }
            esr2.NpY = linkedList2.size();
            c.fMr().Hsv.Haw = j2;
            c.fMr().Hsv.ypH = j3;
            Log.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + j2 + ",roomKey:" + j3);
            c.fMr().Hsv.HbT = etb.Nqy;
            c.fMr().Hsv.HbU = etb.Nqz;
            euh euh = new euh();
            euh.oXT = 0;
            euh.GWx = 0;
            euh.GWw = 0;
            euh.userName = "";
            euh.dQC = "";
            dml dml = new dml();
            dml.LqX = 0;
            dml.LqY = "";
            dml.LqZ = "";
            dml.Lra = 4;
            dml.Lrb = 4;
            dml.Lrc = 2;
            dml.MPX = esr;
            dml.MPY = esr2;
            dmm dmm = new dmm();
            dmm.MPZ = 1;
            dmm.MQa = new LinkedList<>();
            dmm.MQa.add(dml);
            try {
                c.fMr().Hsv.HbZ = dmm.toByteArray();
            } catch (Exception e2) {
                Log.e("MicroMsg.voipcs.VoipCSService", "relay conn info to byte array fail..");
            }
            d fMt = c.fMt();
            String str2 = this.HrM;
            Log.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            fMt.roomId = j2;
            fMt.ypH = j3;
            fMt.Hra = str2;
            if (this.HrP.stopped()) {
                if (this.ypQ > 0) {
                    this.HrP.startTimer((long) (this.ypQ * 1000));
                } else {
                    this.HrP.startTimer(4000);
                }
            }
            d fMt2 = c.fMt();
            Log.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (fMt2.Hry != 0) {
                fMt2.Hrz = (int) (System.currentTimeMillis() / 1000);
            }
            AppMethodBeat.o(125363);
            return;
        } else if (qVar.getType() == 818) {
            etj etj = (etj) ((f) qVar).rr.iLL.iLR;
            Log.i("MicroMsg.voipcs.VoipCSService", "sync status = " + etj.NqE + ",notifySeq = " + etj.NqC);
            a(etj);
            AppMethodBeat.o(125363);
            return;
        } else if (qVar.getType() == 880) {
            esx esx = (esx) ((a) qVar).rr.iLL.iLR;
            if (c.fMr().Hsv.Haw == esx.NeG && c.fMr().Hsv.ypH == esx.Lta) {
                Log.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            g.azz().b(y.CTRL_INDEX, this);
            c.fMt().aei(com.tencent.mm.plugin.voip_cs.c.a.a.fMB().qtg.fKX());
            AppMethodBeat.o(125363);
            return;
        } else if (qVar.getType() == 106) {
            com.tencent.mm.plugin.messenger.a.f fVar = (com.tencent.mm.plugin.messenger.a.f) qVar;
            String str3 = "";
            String str4 = "";
            if (fVar.eiq() != null) {
                str3 = fVar.eiq().Lir;
                str4 = fVar.eiq().Mjj.MTo;
            } else {
                Log.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            }
            this.HrE.ln(str3, str4);
            AppMethodBeat.o(125363);
            return;
        } else if (qVar.getType() == 285) {
            c(i2, i3, qVar);
            AppMethodBeat.o(125363);
            return;
        } else if (qVar.getType() == 312) {
            eth eth = (eth) ((com.tencent.mm.plugin.voip_cs.c.c.e) qVar).rr.iLL.iLR;
            if (eth.NeG == c.fMr().Hsv.Haw && eth.Lta == c.fMr().Hsv.ypH) {
                Log.i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
            AppMethodBeat.o(125363);
            return;
        }
        AppMethodBeat.o(125363);
    }
}
