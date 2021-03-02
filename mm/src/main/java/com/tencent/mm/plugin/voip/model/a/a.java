package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.eso;
import com.tencent.mm.protocal.protobuf.esp;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a extends n<eso, esp> {
    String TAG = "MicroMsg.NetSceneVoipAck";

    public a(int i2, long j2, int i3, byte[] bArr, byte[] bArr2, String str, LinkedList<csu> linkedList) {
        int i4;
        eso eso;
        AppMethodBeat.i(115215);
        d.a aVar = new d.a();
        aVar.iLN = new eso();
        aVar.iLO = new esp();
        aVar.uri = "/cgi-bin/micromsg-bin/voipack";
        aVar.funcId = 305;
        aVar.iLP = 123;
        aVar.respCmdId = 1000000123;
        this.rr = aVar.aXF();
        eso eso2 = (eso) this.rr.iLK.iLR;
        eso2.LsZ = i2;
        eso2.Lta = j2;
        eso2.NpM = i3;
        if (i3 != 1) {
            eso2.NpI = 0;
            AppMethodBeat.o(115215);
            return;
        }
        eso2.NpL = str;
        euk euk = new euk();
        euk.oUv = 2;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        euk.KMS = sKBuiltinBuffer_t;
        eso2.NpJ = euk;
        euk euk2 = new euk();
        euk2.oUv = 3;
        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t2.setBuffer(bArr2);
        euk2.KMS = sKBuiltinBuffer_t2;
        eso2.NpK = euk2;
        eso2.NpN = System.currentTimeMillis();
        eso2.NpI = 1;
        int Qr = ((com.tencent.mm.plugin.misc.a.a) g.af(com.tencent.mm.plugin.misc.a.a.class)).Qr(2);
        Log.i(this.TAG, "simType: %s", Integer.valueOf(Qr));
        if (Qr == 0) {
            i4 = 0;
            eso = eso2;
        } else if (Qr == 3) {
            i4 = 3;
            eso = eso2;
        } else if (Qr == 1) {
            i4 = 1;
            eso = eso2;
        } else {
            i4 = 2;
            eso = eso2;
        }
        eso.NpO = i4;
        eso2.NpP = linkedList.size();
        eso2.NpQ = linkedList;
        AppMethodBeat.o(115215);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 305;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115216);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115214);
                e.Logi(a.this.TAG, "ack response:" + i2 + " errCode:" + i3 + " status:" + a.this.GWA.mStatus);
                if (a.this.GWA.mStatus == 1) {
                    e.Logi(a.this.TAG, "reject ok!");
                    AppMethodBeat.o(115214);
                } else if (a.this.GWA.mStatus != 3) {
                    e.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
                    AppMethodBeat.o(115214);
                } else if (i2 == 0) {
                    esp esp = (esp) a.this.fIJ();
                    if (esp.NpI != 1) {
                        e.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
                        AppMethodBeat.o(115214);
                        return;
                    }
                    a.this.GWA.GVx = true;
                    a.this.GWA.GVV.Hbj = 1;
                    a.this.GWA.GVV.roomId = esp.LsZ;
                    a.this.GWA.GVV.ypH = esp.Lta;
                    a.this.GWA.GVV.ypO = esp.NpR;
                    a.this.GWA.GVV.HaF = esp.NpV;
                    a.this.GWA.GVV.HaJ = esp.NpW;
                    a.this.GWA.adl(esp.NpT);
                    e.Logi(a.this.TAG, "ack ok, roomid =" + a.this.GWA.GVV.roomId + ",memberid = " + a.this.GWA.GVV.ypO);
                    final eue eue = esp.NpS;
                    if (eue.yqc > 0) {
                        eue.yqc--;
                        e.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + eue.yqc + "] from ackresp relaydata");
                    } else {
                        eue.yqc = 1;
                        e.Logi(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
                    }
                    e.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.GWA.GVV.HaE + " RedirectReqThreshold =" + eue.NrZ + " BothSideSwitchFlag =" + eue.Nsa + " WifiScanInterval =" + esp.NpW);
                    a.this.GWA.GVV.HbM = eue.Nsa;
                    if (!(eue.Nsc == null || eue.Nsc.getBuffer() == null)) {
                        a.this.GWA.GVV.HaG = eue.Nsc.getBuffer().toByteArray();
                    }
                    a.this.GWA.adk(eue.NrE);
                    a.this.GWA.ci(eue.NpJ.KMS.getBuffer().toByteArray());
                    a.this.GWA.fGE();
                    a.this.GWA.fGF();
                    if (!(eue.NrL == null || eue.NrL.getBuffer() == null || eue.NrX == null || eue.NrX.getBuffer() == null)) {
                        a.this.GWA.a(eue.NrL.getBuffer().toByteArray(), eue.NrK, eue.yqc, eue.NrX.getBuffer().toByteArray());
                    }
                    a.this.GWA.k(eue.NrO, eue.NrP, eue.NrQ, eue.NrR, eue.NrS);
                    a.this.GWA.cj(eue.NpK.KMS.getBuffer().toByteArray());
                    g.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.a.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(115213);
                            if (eue.Nrx == null || eue.Nrx.MPZ == 0) {
                                dml dml = new dml();
                                dml.LqX = 0;
                                dml.LqY = "";
                                dml.LqZ = "";
                                dml.Lra = a.this.GWA.GVV.netType;
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
                                ahj.Lra = a.this.GWA.GVV.netType;
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
                            e.Logi(a.this.TAG, "relay conn cnt: " + eue.Nrx.MPZ);
                            try {
                                a.this.GWA.GVV.HbZ = eue.Nrx.toByteArray();
                            } catch (Exception e2) {
                                Log.e(a.this.TAG, "relay conn info to byte array fail..");
                            }
                            try {
                                a.this.GWA.GVV.Hca = eue.Nry.toByteArray();
                            } catch (Exception e3) {
                                Log.e(a.this.TAG, "direct conn info to byte array fail..");
                            }
                            try {
                                if (eue.Nsh.LYw > 0) {
                                    a.this.GWA.GVV.Hcb = eue.Nsh.toByteArray();
                                }
                            } catch (Exception e4) {
                                Log.e(a.this.TAG, "nic query info to byte array fail..");
                            }
                            a.this.GWA.adj(eue.NrW);
                            a.this.GWA.adi(eue.NrZ);
                            if (!(eue.NrU == null || eue.NrV == null)) {
                                a.this.GWA.c(eue.NrT, eue.NrU.getBuffer().toByteArray(), eue.NrV.getBuffer().toByteArray());
                            }
                            e.Logi(a.this.TAG, "ack success, try connect channel");
                            a.this.GWA.fGI();
                            AppMethodBeat.o(115213);
                        }
                    });
                    AppMethodBeat.o(115214);
                } else if (i2 == 4) {
                    a.this.GWA.GVV.Hcw.GXc = 12;
                    a.this.GWA.GVV.Hcw.GXd = i3;
                    a.this.GWA.K(1, i3, "");
                    AppMethodBeat.o(115214);
                } else {
                    a.this.GWA.GVV.Hcw.GXc = 12;
                    a.this.GWA.GVV.Hcw.GXd = i3;
                    a.this.GWA.K(1, -9004, "");
                    AppMethodBeat.o(115214);
                }
            }
        };
        AppMethodBeat.o(115216);
        return r0;
    }
}
