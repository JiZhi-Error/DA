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
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m {
    private boolean CIm = false;
    public boolean GQR = false;
    private Handler GQS = null;
    private int GQT = 0;
    int NH = 0;
    private i callback;
    private String filename;
    private int fs = 0;
    private String kly = "";
    private final d rr;

    public j(String str, int i2) {
        AppMethodBeat.i(29785);
        Log.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", Integer.valueOf(i2));
        d.a aVar = new d.a();
        aVar.iLN = new eqg();
        aVar.iLO = new eqh();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        aVar.funcId = 613;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        eqg eqg = (eqg) this.rr.iLK.iLR;
        this.filename = str;
        this.fs = 0;
        eqg.MPS = i2;
        this.GQT = 0;
        eqg.MPQ = 0;
        Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i2), 0);
        this.GQR = true;
        fEC();
        AppMethodBeat.o(29785);
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
        AppMethodBeat.i(29786);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29786);
        return dispatch;
    }

    private int fEC() {
        com.tencent.mm.modelvoice.g dB;
        AppMethodBeat.i(29787);
        eqg eqg = (eqg) this.rr.iLK.iLR;
        esi esi = new esi();
        new com.tencent.mm.modelvoice.g();
        eqg.NnN = esi;
        n nVar = new n(m.cz(this.filename, false));
        int boW = (int) com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
        if (boW - this.fs >= 6000) {
            dB = nVar.dB(this.fs, 6000);
        } else {
            int i2 = this.fs;
            dB = nVar.dB(i2, boW - i2);
        }
        Log.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.fs), Integer.valueOf(dB.ret), Integer.valueOf(dB.dAc), Integer.valueOf(boW), Boolean.valueOf(this.GQR));
        if (dB.dAc == 0) {
            AppMethodBeat.o(29787);
            return -2;
        } else if (dB.ret < 0) {
            Log.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", Integer.valueOf(dB.ret));
            AppMethodBeat.o(29787);
            return -1;
        } else if (this.fs >= 469000) {
            Log.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.fs));
            AppMethodBeat.o(29787);
            return -1;
        } else {
            esi.Npz = new SKBuiltinBuffer_t().setBuffer(dB.buf);
            esi.BsG = this.fs;
            esi.Npx = dB.dAc;
            esi.Npy = 0;
            eqg.MPQ = this.GQT;
            if (this.GQR && dB.jsR >= ((int) com.tencent.mm.vfs.s.boW(m.cz(this.filename, false)))) {
                esi.Npy = 1;
                this.CIm = true;
                Log.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(boW));
            }
            this.fs = dB.jsR;
            eqg.NnN = esi;
            AppMethodBeat.o(29787);
            return 0;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 613;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29788);
        Log.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        eqh eqh = (eqh) ((d) sVar).iLL.iLR;
        if (i3 == 0 || i4 == 0) {
            this.GQT = eqh.MPQ;
            this.NH = eqh.LjQ;
            Log.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", Integer.valueOf(eqh.MPQ), Integer.valueOf(this.NH));
            if (this.CIm) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(29788);
                return;
            }
            Log.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(fEC()));
            doScene(dispatcher(), this.callback);
            Log.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            AppMethodBeat.o(29788);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29788);
    }
}
