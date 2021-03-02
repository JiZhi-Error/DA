package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.etw;
import com.tencent.mm.protocal.protobuf.etx;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.TbsListener;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g extends n<etw, etx> {
    public g(List<String> list, byte[] bArr, byte[] bArr2, int i2, int i3, int i4, LinkedList<csu> linkedList) {
        int i5;
        etw etw;
        AppMethodBeat.i(115237);
        d.a aVar = new d.a();
        aVar.iLN = new etw();
        aVar.iLO = new etx();
        aVar.uri = "/cgi-bin/micromsg-bin/voipinvite";
        aVar.funcId = TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
        aVar.iLP = 63;
        aVar.respCmdId = 1000000063;
        this.rr = aVar.aXF();
        etw etw2 = (etw) this.rr.iLK.iLR;
        LinkedList<dqi> linkedList2 = new LinkedList<>();
        for (int i6 = 0; i6 < list.size(); i6++) {
            linkedList2.add(new dqi().bhy(list.get(i6)));
        }
        etw2.MKC = z.aTY();
        etw2.NqW = linkedList2;
        etw2.NqV = linkedList2.size();
        etw2.Llx = i2;
        etw2.NbR = 0;
        etw2.NqJ = i3;
        etw2.MKg = i4;
        euk euk = new euk();
        euk.oUv = 2;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        euk.KMS = sKBuiltinBuffer_t;
        etw2.NpJ = euk;
        euk euk2 = new euk();
        euk2.oUv = 3;
        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t2.setBuffer(bArr2);
        euk2.KMS = sKBuiltinBuffer_t2;
        etw2.NpK = euk2;
        etw2.NpN = System.currentTimeMillis();
        int Qr = ((a) com.tencent.mm.kernel.g.af(a.class)).Qr(2);
        Log.i("MicroMsg.NetSceneVoipInvite", "simType: %s", Integer.valueOf(Qr));
        if (Qr == 0) {
            i5 = 0;
            etw = etw2;
        } else if (Qr == 3) {
            i5 = 3;
            etw = etw2;
        } else if (Qr == 1) {
            i5 = 1;
            etw = etw2;
        } else {
            i5 = 2;
            etw = etw2;
        }
        etw.NpO = i5;
        etw2.NpP = linkedList.size();
        etw2.NpQ = linkedList;
        AppMethodBeat.o(115237);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115238);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.g.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115236);
                e.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + i2 + " errCode:" + i3 + " status:" + g.this.GWA.mStatus);
                etx etx = (etx) g.this.fIJ();
                etw etw = (etw) ((g) qVar).fIK();
                if (i3 != 238 && c.fFg().GYS.GZG) {
                    c.fFg().b(etx.LsZ, etx.Lta, etw.NqJ);
                    e.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
                    AppMethodBeat.o(115236);
                } else if (g.this.GWA.mStatus != 2) {
                    e.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.GWA.mStatus + " should:2");
                    AppMethodBeat.o(115236);
                } else {
                    g.this.GWA.GVV.Hbl = etx.Nqe;
                    g.this.GWA.GVV.Hbm = etx.Nqf;
                    g.this.GWA.GVV.Hbn = etx.Nqg;
                    g.this.GWA.GVV.Hbo = etx.Nqh;
                    g.this.GWA.GVV.Hbq = etx.Nqj;
                    g.this.GWA.GVV.Hbp = etx.Nqo;
                    g.this.GWA.GVV.HbV = etx.NqZ;
                    g.this.GWA.GVV.HaF = etx.NpV;
                    g.this.GWA.GVV.Hbs = etx.Nqq;
                    g.this.GWA.adl(etx.NpT);
                    g.this.GWA.GVV.HaJ = etx.NpW;
                    if (!(etx.NpX == null || etx.NpX.getBuffer() == null)) {
                        g.this.GWA.GVV.HaH = etx.NpX.getBuffer().toByteArray();
                    }
                    if (etx.NpX != null && etx.NpX.getILen() >= 12) {
                        ByteBuffer wrap = ByteBuffer.wrap(etx.NpX.getBuffer().toByteArray(), 8, 4);
                        ByteOrder nativeOrder = ByteOrder.nativeOrder();
                        ByteOrder order = wrap.order();
                        int i4 = wrap.getInt();
                        e.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i4 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
                        g.this.GWA.GVV.Hbr = i4;
                    }
                    e.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.GWA.GVV.Hbl + ",audioTsdEdge = " + g.this.GWA.GVV.Hbm + ",passthroughQosAlgorithm = " + g.this.GWA.GVV.Hbn + ",fastPlayRepair = " + g.this.GWA.GVV.Hbo + ", audioDtx = " + g.this.GWA.GVV.Hbq + ",switchtcpPktCnt = " + g.this.GWA.GVV.HaE + ",SvrCfgListV = " + g.this.GWA.GVV.Hbp + ", setMaxBRForRelay=" + g.this.GWA.GVV.Hbs + ",EnableDataAccept = " + g.this.GWA.GVV.HbV + ",WifiScanInterval = " + g.this.GWA.GVV.HaJ + ",BaseBRTuneRatio=" + g.this.GWA.GVV.Hbr);
                    g.this.GWA.GVV.Hbt = etx.Nqn;
                    e.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.GWA.GVV.Hbt);
                    g.this.GWA.GVV.Hbu = etx.Nqr;
                    e.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.GWA.GVV.Hbu);
                    int netType = e.getNetType(MMApplicationContext.getContext());
                    if (i2 == 0) {
                        g.this.GWA.setStatus(4);
                        g.this.GWA.GVV.roomId = etx.LsZ;
                        g.this.GWA.GVV.ypH = etx.Lta;
                        g.this.GWA.GVV.ypO = etx.MKr;
                        h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 1, Integer.valueOf(netType));
                        if (etx.NqY > 0) {
                            g.this.GWA.GWl.startTimer((long) (etx.NqY * 1000));
                        }
                        c.fFg().fIj();
                        g.this.GWA.fGE();
                        g.this.GWA.fGF();
                        e.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.GWA.GVV.roomId + ",memberid = " + g.this.GWA.GVV.ypO + "VoipSyncInterval = " + etx.NqY);
                        g.this.GWA.GVW.fFO();
                        e.c(c.fFg().fHU(), c.fFg().fHV(), 0, 1);
                        AppMethodBeat.o(115236);
                    } else if (i2 == 4) {
                        e.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + etx.LsZ + "," + etx.Lta);
                        switch (i3) {
                            case 211:
                                g.this.GWA.GVV.Hcw.GXc = 12;
                                g.this.GWA.GVV.Hcw.GXo = 12;
                                h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 8, Integer.valueOf(netType));
                                break;
                            case TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS /*{ENCODED_INT: 233}*/:
                                g.this.GWA.GVV.Hcw.GXc = 12;
                                g.this.GWA.GVV.Hcw.GXo = 1;
                                h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 3, Integer.valueOf(netType));
                                break;
                            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS /*{ENCODED_INT: 234}*/:
                                g.this.GWA.GVV.Hcw.GXc = 13;
                                g.this.GWA.GVV.Hcw.GXo = 11;
                                h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 4, Integer.valueOf(netType));
                                break;
                            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL /*{ENCODED_INT: 235}*/:
                                g.this.GWA.GVV.Hcw.GXc = 13;
                                g.this.GWA.GVV.Hcw.GXo = 2;
                                h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 2, Integer.valueOf(netType));
                                break;
                            case 236:
                                g.this.GWA.GVV.Hcw.GXc = 12;
                                g.this.GWA.GVV.Hcw.GXo = 10;
                                h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 7, Integer.valueOf(netType));
                                break;
                            case TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS /*{ENCODED_INT: 237}*/:
                                g.this.GWA.GVV.Hcw.GXc = 13;
                                g.this.GWA.GVV.Hcw.GXo = 9;
                                h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 2, Integer.valueOf(netType));
                                break;
                            case TbsListener.ErrorCode.TPATCH_FAIL /*{ENCODED_INT: 238}*/:
                                g.this.GWA.GVv = true;
                                g.this.GWA.GVx = false;
                                g.this.GWA.GVw = false;
                                g.this.GWA.GVV.Hbk = 0;
                                g.this.GWA.GVV.Hbj = 0;
                                g.this.GWA.setStatus(3);
                                g.this.GWA.GVV.roomId = etx.LsZ;
                                g.this.GWA.GVV.ypH = etx.Lta;
                                g.this.GWA.GVV.ypO = etx.MKr;
                                g.this.GWA.GVV.Hcx |= 1;
                                e.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.GWA.GVV.Hcx);
                                g.this.GWA.GVW.acR(etw.NqJ);
                                AppMethodBeat.o(115236);
                                return;
                            case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /*{ENCODED_INT: 241}*/:
                                Log.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + etx.Nra + " seconds!");
                                c.fFg().GZa = System.currentTimeMillis();
                                if (etx.Nra == 0) {
                                    c.fFg().GZb = 30000;
                                    break;
                                } else {
                                    c.fFg().GZb = (long) (etx.Nra * 1000);
                                    break;
                                }
                            default:
                                g.this.GWA.GVV.Hcw.GXc = 12;
                                g.this.GWA.GVV.Hcw.GXo = 99;
                                h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 5, Integer.valueOf(netType));
                                break;
                        }
                        g.this.GWA.GVV.Hcw.GXd = i3;
                        g.this.GWA.K(1, i3, str);
                        AppMethodBeat.o(115236);
                    } else {
                        g.this.GWA.GVV.Hcw.GXc = 12;
                        g.this.GWA.GVV.Hcw.GXd = i3;
                        g.this.GWA.GVV.Hcw.GXo = 99;
                        h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 9, Integer.valueOf(netType));
                        g.this.GWA.K(1, -9004, "");
                        AppMethodBeat.o(115236);
                    }
                }
            }
        };
        AppMethodBeat.o(115238);
        return r0;
    }
}
