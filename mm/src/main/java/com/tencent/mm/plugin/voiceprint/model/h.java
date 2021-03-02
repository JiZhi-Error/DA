package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bm;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends q implements m {
    private boolean CIm = false;
    public boolean GQR = false;
    private Handler GQS = null;
    private int GQT = 0;
    int NH = 0;
    i callback;
    private String filename;
    private int fs = 0;
    private final s iMO;
    String kly = "";

    public h(String str, int i2, String str2) {
        AppMethodBeat.i(29778);
        Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", Integer.valueOf(i2), Util.nullAs(str2, ""));
        this.iMO = new c();
        bm.a aVar = (bm.a) this.iMO.getReqObj();
        this.filename = str;
        this.fs = 0;
        aVar.iDW.MPS = i2;
        aVar.iDW.Mdm = str2;
        this.GQT = 0;
        aVar.iDW.MPQ = 0;
        Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i2), 0);
        this.GQR = true;
        fEC();
        AppMethodBeat.o(29778);
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
        AppMethodBeat.i(29779);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(29779);
        return dispatch;
    }

    private int fEC() {
        com.tencent.mm.modelvoice.g dB;
        AppMethodBeat.i(29780);
        bm.a aVar = (bm.a) this.iMO.getReqObj();
        esi esi = new esi();
        new com.tencent.mm.modelvoice.g();
        aVar.iDW.NnN = esi;
        n nVar = new n(m.cz(this.filename, false));
        int boW = (int) com.tencent.mm.vfs.s.boW(m.cz(this.filename, false));
        if (boW - this.fs >= 6000) {
            dB = nVar.dB(this.fs, 6000);
        } else {
            int i2 = this.fs;
            dB = nVar.dB(i2, boW - i2);
        }
        Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.fs), Integer.valueOf(dB.ret), Integer.valueOf(dB.dAc), Integer.valueOf(boW), Boolean.valueOf(this.GQR));
        if (dB.dAc == 0) {
            AppMethodBeat.o(29780);
            return -2;
        } else if (dB.ret < 0) {
            Log.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", Integer.valueOf(dB.ret));
            AppMethodBeat.o(29780);
            return -1;
        } else if (this.fs >= 469000) {
            Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.fs));
            AppMethodBeat.o(29780);
            return -1;
        } else {
            esi.Npz = new SKBuiltinBuffer_t().setBuffer(dB.buf);
            esi.BsG = this.fs;
            esi.Npx = dB.dAc;
            esi.Npy = 0;
            aVar.iDW.MPQ = this.GQT;
            if (this.GQR && dB.jsR >= ((int) com.tencent.mm.vfs.s.boW(m.cz(this.filename, false)))) {
                esi.Npy = 1;
                this.CIm = true;
                Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(boW));
            }
            this.fs = dB.jsR;
            aVar.iDW.NnN = esi;
            AppMethodBeat.o(29780);
            return 0;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 617;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int length;
        AppMethodBeat.i(29781);
        Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        bm.b bVar = (bm.b) sVar.getRespObj();
        if (i3 == 4 && i4 == -102) {
            final int i5 = sVar.getReqObj().getRsaInfo().ver;
            Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.voiceprint.model.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29777);
                    new com.tencent.mm.modelsimple.m().doScene(h.this.dispatcher(), new i() {
                        /* class com.tencent.mm.plugin.voiceprint.model.h.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(29776);
                            Log.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                h.this.doScene(h.this.dispatcher(), h.this.callback);
                                AppMethodBeat.o(29776);
                                return;
                            }
                            h.this.callback.onSceneEnd(i2, i3, "", h.this);
                            AppMethodBeat.o(29776);
                        }
                    });
                    AppMethodBeat.o(29777);
                }
            });
            AppMethodBeat.o(29781);
        } else if (i3 == 0 || i4 == 0) {
            this.GQT = bVar.iDX.MPQ;
            this.NH = bVar.iDX.LjQ;
            this.kly = bVar.iDX.NnO;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.iDX.MPQ);
            objArr[1] = Integer.valueOf(this.NH);
            objArr[2] = Boolean.valueOf(Util.isNullOrNil(this.kly));
            if (Util.isNullOrNil(this.kly)) {
                length = 0;
            } else {
                length = this.kly.length();
            }
            objArr[3] = Integer.valueOf(length);
            Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d", objArr);
            if (this.CIm) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(29781);
                return;
            }
            Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(fEC()));
            doScene(dispatcher(), this.callback);
            Log.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
            AppMethodBeat.o(29781);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29781);
        }
    }
}
