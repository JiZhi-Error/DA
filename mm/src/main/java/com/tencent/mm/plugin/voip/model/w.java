package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.cez;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.etm;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.eud;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.IOException;
import java.util.LinkedList;

public final class w {
    l GSZ = null;
    eue GZQ = new eue();
    private etn GZR = null;
    private int GZS = 0;

    public w(l lVar) {
        AppMethodBeat.i(115201);
        this.GSZ = lVar;
        AppMethodBeat.o(115201);
    }

    public final void adv(int i2) {
        AppMethodBeat.i(115202);
        byte[] int2bytes = e.int2bytes(i2);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(int2bytes);
        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
        try {
            sKBuiltinBuffer_t2.setBuffer(sKBuiltinBuffer_t.toByteArray());
            etm etm = new etm();
            etm.Lms = 3;
            etm.Lmt = sKBuiltinBuffer_t2;
            etm.xNH = z.aTY();
            etn etn = new etn();
            etn.oTz = 1;
            etn.oTA.add(etm);
            a(etn, false, 4);
            AppMethodBeat.o(115202);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
            AppMethodBeat.o(115202);
        }
    }

    private void a(etn etn) {
        AppMethodBeat.i(115203);
        if (etn == null) {
            e.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.GZS++;
            AppMethodBeat.o(115203);
            return;
        }
        if (this.GZR == null) {
            this.GZR = new etn();
        }
        for (int i2 = 0; i2 < etn.oTz; i2++) {
            this.GZR.oTA.add(etn.oTA.get(i2));
        }
        this.GZR.oTz = this.GZR.oTA.size();
        AppMethodBeat.o(115203);
    }

    private void b(etn etn) {
        AppMethodBeat.i(115204);
        if (this.GZR == null || this.GZR.oTz <= 0) {
            AppMethodBeat.o(115204);
            return;
        }
        for (int i2 = 0; i2 < this.GZR.oTz; i2++) {
            etn.oTA.add(this.GZR.oTA.get(i2));
        }
        etn.oTz = etn.oTA.size();
        fIE();
        AppMethodBeat.o(115204);
    }

    public final void fIE() {
        AppMethodBeat.i(115205);
        if (this.GZR == null) {
            AppMethodBeat.o(115205);
            return;
        }
        this.GZR.oTA.clear();
        this.GZR.oTz = 0;
        this.GZR = null;
        this.GZS = 0;
        AppMethodBeat.o(115205);
    }

    public final int a(etn etn, boolean z, int i2) {
        etn etn2;
        AppMethodBeat.i(115206);
        if (this.GSZ.GVV.roomId == 0) {
            e.Loge("MicroMsg.Voip.VoipSyncHandle", f.apq() + "failed to do voip sync , roomid = 0");
            AppMethodBeat.o(115206);
        } else if (this.GSZ.GWb) {
            e.Loge("MicroMsg.Voip.VoipSyncHandle", f.apq() + "voip syncing, push to cache...");
            a(etn);
            AppMethodBeat.o(115206);
        } else {
            this.GSZ.GWb = true;
            if (etn == null) {
                etn2 = new etn();
                etn2.oTz = 0;
                etn2.oTA = new LinkedList<>();
            } else {
                etn2 = etn;
            }
            b(etn2);
            this.GZS = 0;
            if (this.GSZ.GVZ == null) {
                this.GSZ.GVZ = "".getBytes();
            }
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + z + ",cmdList:" + etn2.oTz + ",syncKey.length:" + this.GSZ.GVZ.length + ",selector:" + i2);
            new m(this.GSZ.GVV.roomId, etn2, this.GSZ.GVZ, this.GSZ.GVV.ypH, i2).fII();
            AppMethodBeat.o(115206);
        }
        return 0;
    }

    public final void a(euv euv, int i2) {
        AppMethodBeat.i(115207);
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + euv.oTW);
        if (euv.oTW == 1) {
            this.GSZ.GVu = true;
            if (1 == i2) {
                this.GSZ.GVV.Hcw.fGS();
            }
            if (3 == i2) {
                this.GSZ.GVV.Hcw.fGT();
            }
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(i2)));
            this.GSZ.GVW.dZK();
            c.fFg().GYS.fIB();
            this.GSZ.GVv = true;
            if (this.GSZ.GVx) {
                this.GSZ.GVx = false;
                if (this.GSZ.GVt) {
                    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.w.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(115198);
                            w.this.GSZ.fGy();
                            AppMethodBeat.o(115198);
                        }
                    });
                } else if (this.GSZ.GVw) {
                    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.GSZ.K(1, -9000, "");
                } else {
                    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            h.INSTANCE.a(11519, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 2);
            this.GSZ.fGI();
            this.GSZ.fGK();
            AppMethodBeat.o(115207);
        } else if (euv.oTW == 6) {
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.GSZ.GVx = true;
            this.GSZ.GVV.Hbj = 1;
            this.GSZ.fGI();
            AppMethodBeat.o(115207);
        } else if (euv.oTW == 8) {
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.GSZ.GVV.Hcw.GXd = 211;
            this.GSZ.GVV.Hcw.GXc = 11;
            this.GSZ.GVV.Hcw.GXo = 12;
            h.INSTANCE.a(11519, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 3);
            this.GSZ.K(1, 211, "");
            this.GSZ.fGK();
            AppMethodBeat.o(115207);
        } else if (euv.oTW == 2) {
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.GSZ.GVV.Hcw.GXc = 103;
            this.GSZ.GVV.Hcw.GXo = 4;
            this.GSZ.GVV.Hcw.GXv = (int) (System.currentTimeMillis() - this.GSZ.GVV.Hcw.beginTime);
            h.INSTANCE.a(11519, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 1);
            this.GSZ.fGK();
            this.GSZ.K(4, 0, "");
            AppMethodBeat.o(115207);
        } else if (euv.oTW == 3) {
            this.GSZ.GVV.Hcw.GXo = 5;
            AppMethodBeat.o(115207);
        } else if (euv.oTW == 4) {
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.GSZ.mStatus < 6) {
                this.GSZ.GVV.Hcw.GXp = 1;
            }
            this.GSZ.GVV.Hcw.GXc = 110;
            this.GSZ.K(6, 0, "");
            this.GSZ.fGK();
            AppMethodBeat.o(115207);
        } else {
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + euv.oTW);
            AppMethodBeat.o(115207);
        }
    }

    public final void a(final eud eud) {
        AppMethodBeat.i(115208);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.w.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(115200);
                MMHandlerThread.postToMainThread(new Runnable(eud) {
                    /* class com.tencent.mm.plugin.voip.model.w.AnonymousClass2 */
                    final /* synthetic */ eud GZU;

                    {
                        this.GZU = r2;
                    }

                    public final void run() {
                        byte[] bArr;
                        byte[] bArr2 = null;
                        AppMethodBeat.i(115199);
                        if (this.GZU == null) {
                            AppMethodBeat.o(115199);
                            return;
                        }
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onGotNewConnData begin local conn set seq " + w.this.GSZ.GWf + " recv conn set seq " + this.GZU.GWf);
                        if (this.GZU.GWf <= w.this.GSZ.GWf) {
                            e.Logi("MicroMsg.Voip.VoipSyncHandle", "the recieved conn set is too old");
                            AppMethodBeat.o(115199);
                            return;
                        }
                        w.this.GSZ.GWf = this.GZU.GWf;
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "new relay conn cnt: " + this.GZU.Nrx.MPZ + " new direct conn cnt: " + this.GZU.Nry.Lri);
                        try {
                            bArr = this.GZU.Nrx.toByteArray();
                        } catch (Exception e2) {
                            Log.e("MicroMsg.Voip.VoipSyncHandle", "conn info to byte array fail..");
                            bArr = null;
                        }
                        int AddNewRelayConns = w.this.GSZ.GVV.AddNewRelayConns(bArr, bArr.length, 0);
                        if (AddNewRelayConns != 0) {
                            e.Loge("MicroMsg.Voip.VoipSyncHandle", "add new relay conns fail ret:".concat(String.valueOf(AddNewRelayConns)));
                        }
                        try {
                            bArr2 = this.GZU.Nry.toByteArray();
                        } catch (Exception e3) {
                            Log.e("MicroMsg.Voip.VoipSyncHandle", "conn info to byte array fail..");
                        }
                        int AddNewDirectConns = w.this.GSZ.GVV.AddNewDirectConns(bArr2, bArr2.length, 0);
                        if (AddNewDirectConns != 0) {
                            e.Loge("MicroMsg.Voip.VoipSyncHandle", "add new direct conns fail ret:".concat(String.valueOf(AddNewDirectConns)));
                        }
                        for (int i2 = 0; i2 < this.GZU.Nrz; i2++) {
                            int ActivateConn = w.this.GSZ.GVV.ActivateConn(this.GZU.NrA.get(i2).intValue());
                            if (ActivateConn != 0) {
                                e.Loge("MicroMsg.Voip.VoipSyncHandle", "activate conn " + this.GZU.NrA.get(i2) + " ret:" + ActivateConn);
                            }
                        }
                        for (int i3 = 0; i3 < this.GZU.NrB; i3++) {
                            int InactivateConn = w.this.GSZ.GVV.InactivateConn(this.GZU.NrC.get(i3).intValue());
                            if (InactivateConn != 0) {
                                e.Loge("MicroMsg.Voip.VoipSyncHandle", "inactivate conn " + this.GZU.NrC.get(i3) + " ret:" + InactivateConn);
                            }
                        }
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "redirect relay conn cnt: " + this.GZU.NrD.MPZ);
                        if (this.GZU.NrD.MPZ > 0) {
                            try {
                                bArr = this.GZU.NrD.toByteArray();
                            } catch (Exception e4) {
                                Log.e("MicroMsg.Voip.VoipSyncHandle", "conn info to byte array fail..");
                            }
                            int AddNewRelayConns2 = w.this.GSZ.GVV.AddNewRelayConns(bArr, bArr.length, 1);
                            if (AddNewRelayConns2 != 0) {
                                e.Loge("MicroMsg.Voip.VoipSyncHandle", "redirect relay conns fail ret:".concat(String.valueOf(AddNewRelayConns2)));
                            }
                        }
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onGotNewConnData end");
                        AppMethodBeat.o(115199);
                    }
                });
                AppMethodBeat.o(115200);
            }
        });
        AppMethodBeat.o(115208);
    }

    public final void a(final euk euk) {
        AppMethodBeat.i(115209);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.w.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(177026);
                e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
                try {
                    eue eue = (eue) new eue().parseFrom(euk.KMS.getBuffer().toByteArray());
                    if (!(eue.NpJ == null || eue.NpJ.KMS == null || eue.NpJ.KMS.getBuffer() == null)) {
                        w.this.GZQ.NpJ = eue.NpJ;
                    }
                    if (!(eue.NpK.KMS == null || eue.NpK.KMS.getBuffer() == null)) {
                        w.this.GZQ.NpK = eue.NpK;
                    }
                    if (eue.NrE != 0) {
                        w.this.GZQ.NrE = eue.NrE;
                    }
                    if (!(eue.NrF == null || eue.NrF.NpY == 0)) {
                        w.this.GZQ.NrF = eue.NrF;
                    }
                    if (!(eue.NrG == null || eue.NrG.NpY == 0)) {
                        w.this.GZQ.NrG = eue.NrG;
                    }
                    if (!(eue.Nsg == null || eue.Nsg.size() == 0)) {
                        w.this.GZQ.Nsg = eue.Nsg;
                        w.this.GZQ.Nsf = eue.Nsg.size();
                    }
                    if (eue.NrI != 0) {
                        w.this.GZQ.NrI = eue.NrI;
                    }
                    if (eue.NrJ != 0) {
                        w.this.GZQ.NrJ = eue.NrJ;
                    }
                    if (eue.NrN.NpY != 0) {
                        w.this.GZQ.NrN = eue.NrN;
                    }
                    if (eue.NrO > 0) {
                        w.this.GZQ.NrO = eue.NrO;
                    } else {
                        w.this.GZQ.NrO = 0;
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
                    }
                    if (eue.yqc > 0) {
                        w.this.GZQ.yqc = eue.yqc - 1;
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.GZQ.yqc + "] from relaydata");
                    } else {
                        w.this.GZQ.yqc = 1;
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
                    }
                    if (eue.NrP > 0) {
                        w.this.GZQ.NrP = eue.NrP;
                        w.this.GZQ.NrQ = eue.NrQ;
                        w.this.GZQ.NrR = eue.NrR;
                        w.this.GZQ.NrS = eue.NrS;
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + eue.NrP + ", ARQRttThreshold: " + eue.NrQ + ", ARQUsedRateThreshold: " + eue.NrR + ", ARQRespRateThreshold: " + eue.NrS);
                    } else {
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
                    }
                    if (eue.NrW > 0) {
                        w.this.GZQ.NrW = eue.NrW;
                    } else {
                        w.this.GZQ.NrW = 0;
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
                    }
                    w.this.GZQ.NrZ = eue.NrZ;
                    if (eue.Nsb != null) {
                        w.this.GZQ.Nsb = eue.Nsb;
                    }
                    w.this.GZQ.Nse = eue.Nse;
                    w.this.GZQ.Nsd = eue.Nsd;
                    w.this.GSZ.GWj.d(eue.Nse, eue.Nsd, w.this.GSZ.GVV.roomId, w.this.GSZ.GVV.ypH);
                    if (!((w.this.GZQ.NpJ == null || w.this.GZQ.NpJ.KMS == null || w.this.GZQ.NpJ.KMS.getBuffer() == null || w.this.GZQ.NrE == 0 || w.this.GZQ.NpK == null || w.this.GZQ.NpK.KMS == null || w.this.GZQ.NpK.KMS.getBuffer() == null || ((w.this.GZQ.NrF == null || w.this.GZQ.NrF.NpY == 0) && (eue.Nrx == null || eue.Nrx.MPZ <= 0))) ? false : true)) {
                        e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                        AppMethodBeat.o(177026);
                        return;
                    }
                    e.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.GZQ.NrZ + " BothSideSwitchFlag = " + eue.Nsa);
                    w.this.GSZ.adk(w.this.GZQ.NrE);
                    w.this.GSZ.ci(w.this.GZQ.NpJ.KMS.getBuffer().toByteArray());
                    if (!(eue.NrL == null || eue.NrL.getBuffer() == null || eue.NrX == null || eue.NrX.getBuffer() == null)) {
                        w.this.GSZ.a(eue.NrL.getBuffer().toByteArray(), eue.NrK, w.this.GZQ.yqc, eue.NrX.getBuffer().toByteArray());
                    }
                    if (c.fFg().fHU() != 0) {
                        w.this.GSZ.cj(w.this.GZQ.NpK.KMS.getBuffer().toByteArray());
                    }
                    if (eue.Nrx == null || eue.Nrx.MPZ == 0) {
                        dml dml = new dml();
                        dml.LqX = 0;
                        dml.LqY = "";
                        dml.LqZ = "";
                        dml.Lra = w.this.GSZ.GVV.netType;
                        dml.Lrb = 4;
                        dml.Lrc = 2;
                        dml.MPX = eue.NrF;
                        dml.MPY = eue.NrN;
                        eue.Nrx = new dmm();
                        eue.Nrx.MPZ = 1;
                        eue.Nrx.MQa = new LinkedList<>();
                        eue.Nrx.MQa.add(dml);
                    }
                    if (eue.Nry == null || eue.Nry.Lri == 0) {
                        ahj ahj = new ahj();
                        ahj.LqX = 1;
                        ahj.LqY = "";
                        ahj.LqZ = "";
                        ahj.Lra = w.this.GSZ.GVV.netType;
                        ahj.Lrb = 4;
                        ahj.Lrc = 2;
                        ahj.Lrd = eue.NrG;
                        ahj.Lre = eue.Nsf;
                        ahj.Lrf = eue.Nsg;
                        eue.Nry = new ahk();
                        eue.Nry.Lri = 1;
                        eue.Nry.Lrj = new LinkedList<>();
                        eue.Nry.Lrj.add(ahj);
                    }
                    e.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + eue.Nrx.MPZ);
                    try {
                        w.this.GSZ.GVV.HbZ = eue.Nrx.toByteArray();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Voip.VoipSyncHandle", "relay conn info to byte array fail..");
                    }
                    try {
                        w.this.GSZ.GVV.Hca = eue.Nry.toByteArray();
                    } catch (Exception e3) {
                        Log.e("MicroMsg.Voip.VoipSyncHandle", "direct conn info to byte array fail..");
                    }
                    try {
                        if (eue.Nsh.LYw > 0) {
                            w.this.GSZ.GVV.Hcb = eue.Nsh.toByteArray();
                        }
                    } catch (Exception e4) {
                        Log.e("MicroMsg.Voip.VoipSyncHandle", "nic query info to byte array fail..");
                    }
                    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.GZQ.Nsf);
                    w.this.GSZ.k(w.this.GZQ.NrO, w.this.GZQ.NrP, w.this.GZQ.NrQ, w.this.GZQ.NrR, w.this.GZQ.NrS);
                    w.this.GSZ.adj(w.this.GZQ.NrW);
                    l lVar = w.this.GSZ;
                    int i2 = w.this.GZQ.NrI;
                    int i3 = w.this.GZQ.NrJ;
                    lVar.GVV.HaC = i2;
                    lVar.GVV.HaD = i3;
                    w.this.GSZ.adi(w.this.GZQ.NrZ);
                    w.this.GSZ.GVV.HbM = eue.Nsa;
                    if (!(eue.Nsc == null || eue.Nsc.getBuffer() == null)) {
                        w.this.GSZ.GVV.HaG = eue.Nsc.getBuffer().toByteArray();
                    }
                    if (!(eue.NrU == null || eue.NrU.getBuffer() == null || eue.NrV == null || eue.NrV.getBuffer() == null)) {
                        w.this.GSZ.c(eue.NrT, eue.NrU.getBuffer().toByteArray(), eue.NrV.getBuffer().toByteArray());
                    }
                    l lVar2 = w.this.GSZ;
                    cez cez = w.this.GZQ.Nsb;
                    v2protocal v2protocal = lVar2.GVV;
                    e.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + cez.Mky + " Bitrate: " + cez.Mkz);
                    v2protocal.field_jbmParamArraySize = 27;
                    v2protocal.field_jbmBitratRsSvrParamArray = new int[v2protocal.field_jbmParamArraySize];
                    v2protocal.field_jbmBitratRsSvrParamArray[0] = cez.Mkx;
                    v2protocal.field_jbmBitratRsSvrParamArray[1] = cez.Mky;
                    v2protocal.field_jbmBitratRsSvrParamArray[2] = cez.Mkz;
                    v2protocal.field_jbmBitratRsSvrParamArray[3] = cez.MkA;
                    v2protocal.field_jbmBitratRsSvrParamArray[4] = cez.MkB;
                    v2protocal.field_jbmBitratRsSvrParamArray[5] = cez.MkC;
                    v2protocal.field_jbmBitratRsSvrParamArray[6] = cez.MkD;
                    v2protocal.field_jbmBitratRsSvrParamArray[7] = cez.MkG;
                    v2protocal.field_jbmBitratRsSvrParamArray[8] = cez.MkH;
                    v2protocal.field_jbmBitratRsSvrParamArray[9] = cez.MkK;
                    v2protocal.field_jbmBitratRsSvrParamArray[10] = cez.MkL;
                    v2protocal.field_jbmBitratRsSvrParamArray[11] = cez.MkO;
                    v2protocal.field_jbmBitratRsSvrParamArray[12] = cez.MkP;
                    v2protocal.field_jbmBitratRsSvrParamArray[13] = cez.MkS;
                    v2protocal.field_jbmBitratRsSvrParamArray[14] = cez.MkT;
                    v2protocal.field_jbmBitratRsSvrParamArray[15] = cez.MkW;
                    v2protocal.field_jbmBitratRsSvrParamArray[16] = cez.MkX;
                    v2protocal.field_jbmBitratRsSvrParamArray[17] = cez.Mla;
                    v2protocal.field_jbmBitratRsSvrParamArray[18] = cez.Mlb;
                    v2protocal.field_jbmBitratRsSvrParamArray[19] = cez.Mle;
                    v2protocal.field_jbmBitratRsSvrParamArray[20] = cez.Mlf;
                    v2protocal.field_jbmBitratRsSvrParamArray[21] = cez.Mli;
                    v2protocal.field_jbmBitratRsSvrParamArray[22] = cez.Mlj;
                    v2protocal.field_jbmBitratRsSvrParamArray[23] = cez.Mlm;
                    v2protocal.field_jbmBitratRsSvrParamArray[24] = cez.Mln;
                    v2protocal.field_jbmBitratRsSvrParamArray[25] = cez.Mlq;
                    v2protocal.field_jbmBitratRsSvrParamArray[26] = cez.Mlr;
                    v2protocal.field_jbmParamDoubleArraySize = 20;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray = new double[v2protocal.field_jbmParamDoubleArraySize];
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[0] = cez.MkE;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[1] = cez.MkF;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[2] = cez.MkI;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[3] = cez.MkJ;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[4] = cez.MkM;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[5] = cez.MkN;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[6] = cez.MkQ;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[7] = cez.MkR;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[8] = cez.MkU;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[9] = cez.MkV;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[10] = cez.MkY;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[11] = cez.MkZ;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[12] = cez.Mlc;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[13] = cez.Mld;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[14] = cez.Mlg;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[15] = cez.Mlh;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[16] = cez.Mlk;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[17] = cez.Mll;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[18] = cez.Mlo;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[19] = cez.Mlp;
                    w.this.GSZ.fGI();
                    e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                    AppMethodBeat.o(177026);
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e5, "", new Object[0]);
                    AppMethodBeat.o(177026);
                }
            }
        });
        AppMethodBeat.o(115209);
    }

    public final void b(euk euk) {
        AppMethodBeat.i(115210);
        this.GSZ.ck(euk.KMS.getBuffer().toByteArray());
        AppMethodBeat.o(115210);
    }

    public final void c(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(115211);
        int co = e.co(sKBuiltinBuffer_t.getBuffer().toByteArray());
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(co)));
        this.GSZ.ade(co & 255);
        AppMethodBeat.o(115211);
    }

    public final void p(q qVar) {
        eud eud;
        AppMethodBeat.i(115212);
        Log.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
        this.GSZ.GWb = false;
        eux eux = (eux) ((m) qVar).fIJ();
        if (this.GSZ.GVZ == null) {
            AppMethodBeat.o(115212);
            return;
        }
        this.GSZ.GVV.parseSyncKeyBuff(this.GSZ.GVZ, this.GSZ.GVZ.length);
        int i2 = this.GSZ.GVV.field_statusSyncKey;
        int i3 = this.GSZ.GVV.field_relayDataSyncKey;
        int i4 = this.GSZ.GVV.field_connectingStatusKey;
        this.GSZ.GVV.parseSyncKeyBuff(eux.Lev.getBuffer().toByteArray(), eux.Lev.getILen());
        int i5 = this.GSZ.GVV.field_statusSyncKey;
        int i6 = this.GSZ.GVV.field_relayDataSyncKey;
        int i7 = this.GSZ.GVV.field_connectingStatusKey;
        Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i2 + " oldRelayDataSyncKey:" + i3 + " oldConnectingStatusSyncKey:" + i4);
        Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i5 + " newRelayDataSyncKey:" + i6 + " newConnectingStatusSyncKey:" + i7);
        this.GSZ.GVZ = eux.Lev.getBuffer().toByteArray();
        Log.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + eux.KZh);
        LinkedList<etm> linkedList = eux.NsY.oTA;
        if (!(linkedList == null || linkedList.size() == 0)) {
            Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((m) qVar).fIH());
            for (int i8 = 0; i8 < linkedList.size(); i8++) {
                etm etm = linkedList.get(i8);
                int i9 = etm.Lms;
                Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i9)));
                if (i9 == 1) {
                    if (i5 > i2) {
                        if (this.GSZ.GVV.roomId == 0) {
                            e.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                euv euv = (euv) new euv().parseFrom(etm.Lmt.getBuffer().toByteArray());
                                e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + etm.xNH + ",itemStatus =  " + euv.oTW);
                                a(euv, 3);
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 2) {
                    if (i6 > i3) {
                        if (this.GSZ.GVV.roomId == 0) {
                            e.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                euk euk = (euk) new euk().parseFrom(etm.Lmt.getBuffer().toByteArray());
                                e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + euk.oUv + ",from user = " + etm.xNH);
                                if (euk.oUv == 5) {
                                    a(euk);
                                } else if (euk.oUv == 3) {
                                    this.GSZ.cj(euk.KMS.getBuffer().toByteArray());
                                    if (!(euk.KMS == null || euk.KMS.getBuffer() == null)) {
                                        this.GZQ.NpK = euk;
                                    }
                                } else if (euk.oUv == 2) {
                                    this.GSZ.ci(euk.KMS.getBuffer().toByteArray());
                                    if (!(euk.KMS == null || euk.KMS.getBuffer() == null)) {
                                        this.GZQ.NpJ = euk;
                                    }
                                } else if (euk.oUv == 1) {
                                    b(euk);
                                } else if (euk.oUv == 6) {
                                    try {
                                        eud = (eud) new eud().parseFrom(euk.KMS.getBuffer().toByteArray());
                                    } catch (IOException e3) {
                                        Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e3, "", new Object[0]);
                                        eud = null;
                                    }
                                    if (eud != null) {
                                        this.GSZ.GVY.a(eud);
                                    }
                                }
                            } catch (IOException e4) {
                                Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e4, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 3 && i7 > i4) {
                    if (this.GSZ.GVV.roomId == 0) {
                        Log.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            SKBuiltinBuffer_t parseFrom = new SKBuiltinBuffer_t().parseFrom(etm.Lmt.getBuffer().toByteArray());
                            if (etm.xNH.equals(z.aTY())) {
                                e.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                c(parseFrom);
                            }
                        } catch (IOException e5) {
                            Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e5, "", new Object[0]);
                        }
                    }
                }
            }
        }
        Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
        if ((this.GZR != null && this.GZR.oTz > 0) || this.GZS > 0) {
            a(null, false, 7);
        }
        AppMethodBeat.o(115212);
    }
}
