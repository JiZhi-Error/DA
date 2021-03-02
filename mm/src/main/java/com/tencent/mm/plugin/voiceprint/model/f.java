package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    private boolean CIm = false;
    private int DsN = 0;
    public boolean GQR = false;
    private Handler GQS = null;
    int GQT = 0;
    int GQU = 0;
    int NH = 0;
    private i callback;
    private String filename;
    private int fs = 0;
    private final d rr;

    public f(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(29767);
        Log.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.GQU = i2;
        d.a aVar = new d.a();
        aVar.iLN = new dmi();
        aVar.iLO = new dmj();
        aVar.uri = "/cgi-bin/micromsg-bin/registervoiceprint";
        aVar.funcId = 612;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dmi dmi = (dmi) this.rr.iLK.iLR;
        this.filename = str;
        this.fs = 0;
        dmi.MPS = i3;
        dmi.oUu = i2;
        this.GQT = i4;
        dmi.MPQ = i4;
        Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.GQR = true;
        fEC();
        AppMethodBeat.o(29767);
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 240;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29768);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29768);
        return dispatch;
    }

    private int fEC() {
        com.tencent.mm.modelvoice.g dB;
        AppMethodBeat.i(29769);
        dmi dmi = (dmi) this.rr.iLK.iLR;
        esi esi = new esi();
        new com.tencent.mm.modelvoice.g();
        dmi.MPR = esi;
        n nVar = new n(m.cz(this.filename, false));
        int boW = (int) com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
        if (boW - this.fs >= 6000) {
            dB = nVar.dB(this.fs, 6000);
        } else {
            int i2 = this.fs;
            dB = nVar.dB(i2, boW - i2);
        }
        Log.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.fs), Integer.valueOf(dB.ret), Integer.valueOf(dB.dAc), Integer.valueOf(boW), Boolean.valueOf(this.GQR));
        if (dB.dAc == 0) {
            AppMethodBeat.o(29769);
            return -2;
        } else if (dB.ret < 0) {
            Log.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", Integer.valueOf(dB.ret));
            AppMethodBeat.o(29769);
            return -1;
        } else if (this.fs >= 469000) {
            Log.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.fs));
            AppMethodBeat.o(29769);
            return -1;
        } else {
            esi.Npz = new SKBuiltinBuffer_t().setBuffer(dB.buf);
            esi.BsG = this.fs;
            esi.Npx = dB.dAc;
            esi.Npy = 0;
            dmi.MPQ = this.GQT;
            if (this.GQR && dB.jsR >= ((int) com.tencent.mm.vfs.s.boW(m.cz(this.filename, false)))) {
                esi.Npy = 1;
                this.CIm = true;
                Log.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(boW));
            }
            this.fs = dB.jsR;
            dmi.MPR = esi;
            AppMethodBeat.o(29769);
            return 0;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 612;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29770);
        Log.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        dmj dmj = (dmj) ((d) sVar).iLL.iLR;
        if (i3 == 0 || i4 == 0) {
            Log.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", Integer.valueOf(dmj.MPQ), Integer.valueOf(dmj.MPT), Integer.valueOf(dmj.MPU), Integer.valueOf(dmj.MPT));
            this.GQT = dmj.MPQ;
            this.DsN = dmj.MPU;
            this.NH = dmj.MPT;
            if (this.CIm) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(29770);
                return;
            }
            Log.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", Integer.valueOf(fEC()));
            doScene(dispatcher(), this.callback);
            Log.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
            AppMethodBeat.o(29770);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29770);
    }
}
