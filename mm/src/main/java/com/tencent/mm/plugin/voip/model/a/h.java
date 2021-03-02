package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.eui;
import com.tencent.mm.protocal.protobuf.euj;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h extends n<eui, euj> {
    public h(int i2, long j2, int i3, int i4, int i5, int[] iArr, LinkedList<csu> linkedList) {
        AppMethodBeat.i(115240);
        d.a aVar = new d.a();
        aVar.iLN = new eui();
        aVar.iLO = new euj();
        aVar.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        aVar.funcId = ck.CTRL_INDEX;
        aVar.iLP = 240;
        aVar.respCmdId = 1000000240;
        this.rr = aVar.aXF();
        eui eui = (eui) this.rr.iLK.iLR;
        eui.LsZ = i2;
        eui.Lta = j2;
        eui.MKr = i3;
        eui.Nsn = i4;
        eui.Nso = i5;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            eul eul = new eul();
            int i8 = i6 + 1;
            eul.NsB = iArr[i6];
            int i9 = i8 + 1;
            eul.NsC = iArr[i8];
            int i10 = i9 + 1;
            eul.NsD = iArr[i9];
            int i11 = i10 + 1;
            eul.NsE = iArr[i10];
            i6 = i11 + 1;
            eul.NsF = iArr[i11];
            eui.Nsp.add(eul);
        }
        eui.Nsq = this.GWA.GVV.Hcw.GXD != 0 ? (int) ((System.currentTimeMillis() - this.GWA.GVV.Hcw.GXD) / 1000) : 0;
        eui.NpP = linkedList.size();
        eui.NpQ = linkedList;
        AppMethodBeat.o(115240);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ck.CTRL_INDEX;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final void jC(int i2, int i3) {
        AppMethodBeat.i(115241);
        if (i2 == 0 && i3 == 0) {
            euj euj = (euj) this.rr.iLL.iLR;
            if (euj != null) {
                Log.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(euj.LsZ), Long.valueOf(euj.Lta), Integer.valueOf(euj.MKr));
            }
            AppMethodBeat.o(115241);
            return;
        }
        Log.i("MicroMsg.Voip.Redirect", "Redirect error");
        AppMethodBeat.o(115241);
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115242);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.h.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115239);
                e.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + i2 + " errCode:" + i3 + " status:" + h.this.GWA.mStatus);
                if (i2 == 0 && i3 == 0) {
                    euj euj = (euj) h.this.fIJ();
                    e.Logi("MicroMsg.Voip.Redirect", "room " + euj.LsZ + " member " + euj.MKr + " key " + euj.Lta + " relay addr cnt " + euj.Nst + " RedirectThreshold " + euj.Nsy + " RedirectDecision " + euj.Nsz);
                    esr esr = new esr();
                    esr esr2 = new esr();
                    esr esr3 = new esr();
                    esr.NpY = euj.Nst;
                    esr.NpZ = euj.Nsu;
                    esr2.NpY = euj.Nsv;
                    esr2.NpZ = euj.Nsw;
                    esr3.NpY = euj.Nsx;
                    esr3.NpZ = euj.NqB;
                    h.this.GWA.GVY.a(euj.NsA);
                    if ((euj.NsA == null || euj.NsA.GWf == 0) && euj.Nst > 0) {
                        e.Logi("MicroMsg.Voip.Redirect", "use old method to add redirect conn");
                        dmm dmm = new dmm();
                        dml dml = new dml();
                        dml.LqX = 0;
                        dml.LqY = "";
                        dml.LqZ = "";
                        dml.Lra = h.this.GWA.GVV.netType;
                        dml.Lrb = 4;
                        dml.Lrc = 2;
                        dml.MPX = new esr();
                        dml.MPY = new esr();
                        dml.MPX.NpY = euj.Nst;
                        dml.MPX.NpZ = euj.Nsu;
                        dml.MPY.NpY = euj.Nsx;
                        dml.MPY.NpZ = euj.NqB;
                        dmm.MQa.add(dml);
                        dmm.MPZ = 1;
                        byte[] bArr = null;
                        try {
                            bArr = dmm.toByteArray();
                        } catch (Exception e2) {
                            Log.e("MicroMsg.Voip.Redirect", "conn info to byte array fail..");
                        }
                        int AddNewRelayConns = h.this.GWA.GVV.AddNewRelayConns(bArr, bArr.length, 1);
                        if (AddNewRelayConns != 0) {
                            e.Loge("MicroMsg.Voip.Redirect", "redirect relay conns fail ret:".concat(String.valueOf(AddNewRelayConns)));
                        }
                    }
                    AppMethodBeat.o(115239);
                    return;
                }
                e.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + i3 + "error type" + i2);
                AppMethodBeat.o(115239);
            }
        };
        AppMethodBeat.o(115242);
        return r0;
    }
}
