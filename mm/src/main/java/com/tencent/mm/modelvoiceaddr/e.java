package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enm;
import com.tencent.mm.protocal.protobuf.enn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.List;

public final class e extends a implements m {
    i callback;
    private int encodeType;
    String filename;
    MTimerHandler iKj;
    private long jdI;
    int jlB;
    boolean jul;
    private boolean jvY;
    private String[] jwa;
    int retCode;
    private d rr;

    @Override // com.tencent.mm.modelvoiceaddr.a
    public final int bip() {
        return this.retCode;
    }

    @Override // com.tencent.mm.modelvoiceaddr.a
    public final void bim() {
        this.jul = true;
    }

    @Override // com.tencent.mm.modelvoiceaddr.a
    public final String[] bin() {
        return this.jwa;
    }

    @Override // com.tencent.mm.modelvoiceaddr.a
    public final long bio() {
        return this.jdI;
    }

    @Override // com.tencent.mm.modelvoiceaddr.a
    public final List<String> biq() {
        return null;
    }

    public e(String str, int i2) {
        AppMethodBeat.i(148531);
        this.retCode = 0;
        this.jul = false;
        this.jlB = 0;
        this.filename = null;
        this.jdI = -1;
        this.jvY = false;
        this.encodeType = 0;
        this.jwa = new String[0];
        this.iKj = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.modelvoiceaddr.e.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(148530);
                long boW = s.boW(e.this.filename);
                Log.d("MicroMsg.NetSceneVoiceInput", f.apq() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + boW + " oldoff:" + e.this.jlB + " isFin:" + e.this.jul);
                if (boW - ((long) e.this.jlB) >= 3300 || e.this.jul) {
                    if (e.this.doScene(e.this.dispatcher(), e.this.callback) == -1) {
                        e.this.retCode = f.getLine() + 40000;
                        e.this.callback.onSceneEnd(3, -1, "doScene failed", e.this);
                    }
                    AppMethodBeat.o(148530);
                    return false;
                }
                AppMethodBeat.o(148530);
                return true;
            }
        }, true);
        this.jdI = (long) new StringBuilder().append(Util.nowMilliSecond()).toString().hashCode();
        this.filename = str;
        this.encodeType = i2;
        AppMethodBeat.o(148531);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(148532);
        this.callback = iVar;
        int boW = (int) s.boW(this.filename);
        Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", this.filename, Integer.valueOf(boW), Integer.valueOf(this.jlB), Boolean.valueOf(this.jul));
        if (boW <= 0) {
            Log.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
            this.retCode = f.getLine() + 40000;
            AppMethodBeat.o(148532);
            return -1;
        }
        int i2 = boW - this.jlB;
        if (i2 > 3960) {
            i2 = 3960;
        } else if (i2 < 3300 && !this.jul) {
            Log.e("MicroMsg.NetSceneVoiceInput", f.apq() + " read failed :" + this.filename + "can read:" + i2 + " isfinish:" + this.jul);
            this.retCode = f.getLine() + 40000;
            AppMethodBeat.o(148532);
            return -1;
        } else if (this.jul) {
            this.jvY = true;
        }
        Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", this.filename, Integer.valueOf(boW), Boolean.valueOf(this.jul), Boolean.valueOf(this.jul), Boolean.valueOf(this.jvY));
        byte[] aW = s.aW(this.filename, this.jlB, i2);
        if (aW == null) {
            Log.e("MicroMsg.NetSceneVoiceInput", f.apq() + " read failed :" + this.filename + " read:" + i2);
            this.retCode = f.getLine() + 40000;
            AppMethodBeat.o(148532);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLN = new enm();
        aVar.iLO = new enn();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
        aVar.funcId = 349;
        aVar.iLP = 158;
        aVar.respCmdId = 1000000158;
        this.rr = aVar.aXF();
        enm enm = (enm) this.rr.iLK.iLR;
        enm.UserName = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
        enm.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
        Log.d("MicroMsg.NetSceneVoiceInput", f.apq() + " read file:" + this.filename + " readlen:" + aW.length + " datalen:" + enm.BsI.getBuffer().toByteArray().length + " dataiLen:" + enm.BsI.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(aW) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(enm.BsI.getBuffer().toByteArray()));
        enm.KZk = this.jlB;
        enm.Nln = new StringBuilder().append(this.jdI).toString();
        enm.jeU = this.jvY ? 1 : 0;
        enm.Nlo = 0;
        enm.KKD = 0;
        enm.Nlp = this.encodeType;
        enm.KKA = 0;
        Log.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.jdI);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(148532);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 20;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(148533);
        this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
        AppMethodBeat.o(148533);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(148534);
        Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + i3 + " errCode:" + i4);
        updateDispatchId(i2);
        enm enm = (enm) ((d) sVar).iLK.iLR;
        enn enn = (enn) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneVoiceInput", f.apq() + " onGYNetEnd  file:" + this.filename + " endflag:" + enn.jeU);
            if (enm.jeU == 1) {
                if (!(enn.Nlq == null || enn.Nlq.getBuffer() == null)) {
                    this.jwa = new String[]{enn.Nlq.getBuffer().yO()};
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148534);
                return;
            }
            this.jlB = enm.BsI.getILen() + enm.KZk;
            long j2 = this.jul ? 0 : 500;
            Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + j2);
            this.iKj.startTimer(j2);
            AppMethodBeat.o(148534);
            return;
        }
        Log.e("MicroMsg.NetSceneVoiceInput", f.apq() + " onGYNetEnd file:" + this.filename + " errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(148534);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 349;
    }
}
