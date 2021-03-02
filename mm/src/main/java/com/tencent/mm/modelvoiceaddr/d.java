package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.protocal.protobuf.esf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.List;

public final class d extends a implements m {
    i callback;
    String filename;
    MTimerHandler iKj;
    private long jdI;
    int jlB;
    boolean jul;
    private boolean jvY;
    private int jvZ;
    private String[] jwa;
    int retCode;
    private com.tencent.mm.ak.d rr;

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

    public d(String str, int i2) {
        AppMethodBeat.i(148526);
        this.retCode = 0;
        this.jlB = 0;
        this.filename = null;
        this.jdI = -1;
        this.jvY = false;
        this.jul = false;
        this.jwa = new String[0];
        this.iKj = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.modelvoiceaddr.d.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(148525);
                long boW = s.boW(d.this.filename);
                Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + boW + " oldoff:" + d.this.jlB + " isFin:" + d.this.jul);
                if (boW - ((long) d.this.jlB) >= 3300 || d.this.jul) {
                    if (d.this.doScene(d.this.dispatcher(), d.this.callback) == -1) {
                        d.this.retCode = f.getLine() + 40000;
                        d.this.callback.onSceneEnd(3, -1, "doScene failed", d.this);
                    }
                    AppMethodBeat.o(148525);
                    return false;
                }
                AppMethodBeat.o(148525);
                return true;
            }
        }, true);
        this.jdI = Util.nowMilliSecond();
        this.filename = str;
        this.jvZ = i2;
        AppMethodBeat.o(148526);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(148527);
        this.callback = iVar;
        long boW = s.boW(this.filename);
        Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " read file:" + this.filename + " filelen:" + boW + " oldoff:" + this.jlB + " isFin:" + this.jul);
        if (boW <= 0) {
            Log.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.retCode = f.getLine() + 40000;
            AppMethodBeat.o(148527);
            return -1;
        }
        int i2 = (int) (boW - ((long) this.jlB));
        if (i2 > 3960) {
            i2 = 3960;
        } else if (i2 < 3300 && !this.jul) {
            Log.e("MicroMsg.NetSceneVoiceAddr", f.apq() + " read failed :" + this.filename + "can read:" + i2 + " isfinish:" + this.jul);
            this.retCode = f.getLine() + 40000;
            AppMethodBeat.o(148527);
            return -1;
        } else if (this.jul) {
            this.jvY = true;
        }
        Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " read file:" + this.filename + " filelen:" + boW + " oldoff:" + this.jlB + " isFin:" + this.jul + " endFlag:" + this.jvY);
        byte[] aW = s.aW(this.filename, this.jlB, i2);
        if (aW == null) {
            Log.e("MicroMsg.NetSceneVoiceAddr", f.apq() + " read failed :" + this.filename + " read:" + i2);
            this.retCode = f.getLine() + 40000;
            AppMethodBeat.o(148527);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLN = new ese();
        aVar.iLO = new esf();
        aVar.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        aVar.funcId = 206;
        aVar.iLP = 94;
        aVar.respCmdId = 1000000094;
        this.rr = aVar.aXF();
        ese ese = (ese) this.rr.iLK.iLR;
        ese.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
        Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " read file:" + this.filename + " readlen:" + aW.length + " datalen:" + ese.BsI.getBuffer().toByteArray().length + " dataiLen:" + ese.BsI.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(aW) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(ese.BsI.getBuffer().toByteArray()));
        ese.UserName = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
        ese.KZk = this.jlB;
        ese.Nln = new StringBuilder().append(this.jdI).toString();
        ese.jeU = this.jvY ? 1 : 0;
        ese.Nlo = 0;
        ese.KKD = 0;
        ese.Nlp = 0;
        ese.KKA = 0;
        ese.Nps = this.jvZ;
        Log.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.jdI);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(148527);
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
        AppMethodBeat.i(148528);
        this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
        AppMethodBeat.o(148528);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(148529);
        Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " onGYNetEnd file:" + this.filename + " errtype:" + i3 + " errCode:" + i4);
        updateDispatchId(i2);
        ese ese = (ese) ((com.tencent.mm.ak.d) sVar).iLK.iLR;
        esf esf = (esf) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " onGYNetEnd  file:" + this.filename + " endflag:" + esf.jeU + " lst:" + esf.KGP);
            if (ese.jeU == 1) {
                this.jwa = new String[esf.KGP.size()];
                for (int i5 = 0; i5 < esf.KGP.size(); i5++) {
                    this.jwa[i5] = esf.KGP.get(i5).MTo;
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148529);
                return;
            }
            this.jlB = ese.BsI.getILen() + ese.KZk;
            long j2 = this.jul ? 0 : 500;
            Log.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j2);
            this.iKj.startTimer(j2);
            AppMethodBeat.o(148529);
            return;
        }
        Log.e("MicroMsg.NetSceneVoiceAddr", f.apq() + " onGYNetEnd file:" + this.filename + " errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(148529);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 206;
    }
}
