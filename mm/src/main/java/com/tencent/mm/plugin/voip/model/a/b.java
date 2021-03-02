package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.protocal.protobuf.est;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b extends n<ess, est> {
    String TAG = "MicroMsg.NetSceneVoipAnswer";

    public b(int i2, int i3, int i4, byte[] bArr, byte[] bArr2, long j2, boolean z, boolean z2, LinkedList<csu> linkedList) {
        int i5;
        ess ess;
        AppMethodBeat.i(115219);
        d.a aVar = new d.a();
        aVar.iLN = new ess();
        aVar.iLO = new est();
        aVar.uri = "/cgi-bin/micromsg-bin/voipanswer";
        aVar.funcId = 172;
        aVar.iLP = 65;
        aVar.respCmdId = 1000000065;
        this.rr = aVar.aXF();
        ess ess2 = (ess) this.rr.iLK.iLR;
        ess2.Nqa = i2;
        ess2.LsZ = i4;
        ess2.Llx = i3;
        euk euk = new euk();
        euk.oUv = 2;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        euk.KMS = sKBuiltinBuffer_t;
        ess2.NpJ = euk;
        euk euk2 = new euk();
        euk2.oUv = 3;
        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t2.setBuffer(bArr2);
        euk2.KMS = sKBuiltinBuffer_t2;
        ess2.NpK = euk2;
        ess2.Lta = j2;
        if (z2) {
            ess2.Nqb = z ? 1 : 0;
        }
        ess2.NpN = System.currentTimeMillis();
        int Qr = ((a) g.af(a.class)).Qr(2);
        Log.i(this.TAG, "simType: %s", Integer.valueOf(Qr));
        if (Qr == 0) {
            i5 = 0;
            ess = ess2;
        } else if (Qr == 3) {
            i5 = 3;
            ess = ess2;
        } else if (Qr == 1) {
            i5 = 1;
            ess = ess2;
        } else {
            i5 = 2;
            ess = ess2;
        }
        ess.NpO = i5;
        if (linkedList != null) {
            ess2.NpP = linkedList.size();
            ess2.NpQ = linkedList;
        }
        AppMethodBeat.o(115219);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 172;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115220);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.b.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115218);
                e.Logi(b.this.TAG, "Anwser response:" + i2 + " errCode:" + i3 + " status:" + b.this.GWA.mStatus);
                if (b.this.GWA.mStatus == 1) {
                    e.Logi(b.this.TAG, "reject ok!");
                    AppMethodBeat.o(115218);
                } else if (b.this.GWA.mStatus != 4) {
                    e.Loge(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
                    AppMethodBeat.o(115218);
                } else if (i2 == 0) {
                    est est = (est) b.this.fIJ();
                    b.this.GWA.GVV.roomId = est.LsZ;
                    b.this.GWA.GVV.ypH = est.Lta;
                    b.this.GWA.GVV.ypO = est.NpR;
                    b.this.GWA.GVV.Hbl = est.Nqe;
                    b.this.GWA.GVV.Hbm = est.Nqf;
                    b.this.GWA.GVV.Hbn = est.Nqg;
                    b.this.GWA.GVV.Hbo = est.Nqh;
                    b.this.GWA.GVV.Hbq = est.Nqj;
                    b.this.GWA.GVV.Hbp = est.Nqo;
                    b.this.GWA.GVV.HaF = est.NpV;
                    b.this.GWA.GVV.Hbs = est.Nqq;
                    b.this.GWA.adl(est.NpT);
                    b.this.GWA.GVV.HaJ = est.NpW;
                    if (!(est.NpX == null || est.NpX.getBuffer() == null)) {
                        b.this.GWA.GVV.HaH = est.NpX.getBuffer().toByteArray();
                    }
                    if (est.NpX.getILen() >= 12) {
                        ByteBuffer wrap = ByteBuffer.wrap(est.NpX.getBuffer().toByteArray(), 8, 4);
                        ByteOrder nativeOrder = ByteOrder.nativeOrder();
                        ByteOrder order = wrap.order();
                        int i4 = wrap.getInt();
                        e.Logd(b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + i4 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
                        b.this.GWA.GVV.Hbr = i4;
                    }
                    e.Logi(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.GWA.GVV.Hbl + ",audioTsdEdge = " + b.this.GWA.GVV.Hbm + ",passthroughQosAlgorithm = " + b.this.GWA.GVV.Hbn + ",fastPlayRepair = " + b.this.GWA.GVV.Hbo + ", audioDtx = " + b.this.GWA.GVV.Hbq + ", switchtcppktCnt=" + b.this.GWA.GVV.HaE + ", SvrCfgListV=" + b.this.GWA.GVV.Hbp + ", setMaxBRForRelay=" + b.this.GWA.GVV.Hbs + ", RedirectreqThreshold=" + est.NpS.NrZ + ", BothSideSwitchFlag=" + est.NpS.Nsa + ", WifiScanInterval=" + est.NpW + ", BaseBRTuneRatio=" + b.this.GWA.GVV.Hbr);
                    b.this.GWA.GVV.Hbt = est.Nqn;
                    b.this.GWA.GVV.Hbu = est.Nqr;
                    e.Logi(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.GWA.GVV.Hbt);
                    b.this.GWA.fGE();
                    b.this.GWA.fGF();
                    b.this.GWA.GVv = true;
                    e.Logi(b.this.TAG, "answer ok, roomid =" + b.this.GWA.GVV.roomId + ",memberid = " + b.this.GWA.GVV.ypO);
                    final eue eue = est.NpS;
                    if (eue.yqc > 0) {
                        eue.yqc--;
                        e.Logi(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + eue.yqc + "] from answerresp relaydata");
                    } else {
                        eue.yqc = 1;
                        e.Logi(b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
                    }
                    e.Logi(b.this.TAG, "answer with relayData peerid.length =" + eue.NpJ.KMS.getILen());
                    e.Logi(b.this.TAG, "answer with relayData capinfo.length =" + eue.NpK.KMS.getILen());
                    b.this.GWA.adk(eue.NrE);
                    b.this.GWA.GWj.d(eue.Nse, eue.Nsd, b.this.GWA.GVV.roomId, b.this.GWA.GVV.ypH);
                    try {
                        g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.voip.model.a.b.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(115217);
                                c.fFg().fIj();
                                e.Logi(b.this.TAG, "steve:doublelink timer started!");
                                if (eue.Nrx == null || eue.Nrx.MPZ == 0) {
                                    dml dml = new dml();
                                    dml.LqX = 0;
                                    dml.LqY = "";
                                    dml.LqZ = "";
                                    dml.Lra = b.this.GWA.GVV.netType;
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
                                    ahj.Lra = b.this.GWA.GVV.netType;
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
                                e.Logi(b.this.TAG, "relay conn cnt: " + eue.Nrx.MPZ);
                                try {
                                    b.this.GWA.GVV.HbZ = eue.Nrx.toByteArray();
                                } catch (Exception e2) {
                                    Log.e(b.this.TAG, "relay conn info to byte array fail..");
                                }
                                try {
                                    b.this.GWA.GVV.Hca = eue.Nry.toByteArray();
                                } catch (Exception e3) {
                                    Log.e(b.this.TAG, "direct conn info to byte array fail..");
                                }
                                try {
                                    if (eue.Nsh.LYw > 0) {
                                        b.this.GWA.GVV.Hcb = eue.Nsh.toByteArray();
                                    }
                                } catch (Exception e4) {
                                    Log.e(b.this.TAG, "nic query info to byte array fail..");
                                }
                                if (eue.NpJ.KMS.getBuffer() != null) {
                                    b.this.GWA.ci(eue.NpJ.KMS.getBuffer().toByteArray());
                                } else {
                                    Log.e(b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                                }
                                if (!(eue.NrL == null || eue.NrL.getBuffer() == null || eue.NrX == null || eue.NrX.getBuffer() == null)) {
                                    b.this.GWA.a(eue.NrL.getBuffer().toByteArray(), eue.NrK, eue.yqc, eue.NrX.getBuffer().toByteArray());
                                }
                                b.this.GWA.k(eue.NrO, eue.NrP, eue.NrQ, eue.NrR, eue.NrS);
                                b.this.GWA.adj(eue.NrW);
                                if (!(eue.NrU == null || eue.NrV == null || eue.NrU.getBuffer() == null || eue.NrV.getBuffer() == null)) {
                                    b.this.GWA.c(eue.NrT, eue.NrU.getBuffer().toByteArray(), eue.NrV.getBuffer().toByteArray());
                                }
                                if (eue.NpK.KMS.getBuffer() != null) {
                                    b.this.GWA.cj(eue.NpK.KMS.getBuffer().toByteArray());
                                } else {
                                    Log.e(b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                                }
                                b.this.GWA.adi(eue.NrZ);
                                b.this.GWA.GVV.HbM = eue.Nsa;
                                if (!(eue.Nsc == null || eue.Nsc.getBuffer() == null)) {
                                    b.this.GWA.GVV.HaG = eue.Nsc.getBuffer().toByteArray();
                                }
                                if (b.this.GWA.GVx) {
                                    b.this.GWA.GVx = false;
                                    if (b.this.GWA.GVt) {
                                        e.Logi(b.this.TAG, "channel pre-connect already success, start talk");
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.voip.model.a.b.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(177027);
                                                b.this.GWA.fGy();
                                                AppMethodBeat.o(177027);
                                            }
                                        });
                                    } else if (b.this.GWA.GVw) {
                                        e.Logi(b.this.TAG, "channel pre-connect already failed");
                                        b.this.GWA.K(1, -9000, "");
                                        AppMethodBeat.o(115217);
                                        return;
                                    } else {
                                        e.Logi(b.this.TAG, "channel pre-connect still connecting...");
                                    }
                                } else {
                                    Log.i(b.this.TAG, "isPreConnect is false");
                                }
                                b.this.GWA.fGK();
                                b.this.GWA.fGI();
                                AppMethodBeat.o(115217);
                            }
                        });
                        AppMethodBeat.o(115218);
                    } catch (Exception e2) {
                        Log.e(b.this.TAG, "get proxy ip fail..");
                        AppMethodBeat.o(115218);
                    }
                } else if (i2 == 4) {
                    b.this.GWA.GVV.Hcw.GXc = 12;
                    b.this.GWA.GVV.Hcw.GXd = i3;
                    b.this.GWA.K(1, i3, "");
                    AppMethodBeat.o(115218);
                } else {
                    b.this.GWA.GVV.Hcw.GXc = 12;
                    b.this.GWA.GVV.Hcw.GXd = i3;
                    b.this.GWA.K(1, -9004, "");
                    AppMethodBeat.o(115218);
                }
            }
        };
        AppMethodBeat.o(115220);
        return r0;
    }
}
