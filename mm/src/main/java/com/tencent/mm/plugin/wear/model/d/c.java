package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enm;
import com.tencent.mm.protocal.protobuf.enn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.vfs.s;
import java.util.UUID;

public final class c extends q implements m {
    int Iym = 0;
    public String Iyn;
    public boolean Iyo;
    i callback;
    private String clientId;
    public int dEb;
    private int encodeType = 0;
    String filename = null;
    MTimerHandler iKj = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.wear.model.d.c.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(30060);
            long boW = s.boW(c.this.filename);
            long j2 = boW - ((long) c.this.Iym);
            Log.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", c.this.filename, Long.valueOf(boW), Integer.valueOf(c.this.Iym), Boolean.valueOf(c.this.jul), Long.valueOf(j2));
            if (j2 < 3300 && !c.this.jul) {
                AppMethodBeat.o(30060);
                return true;
            } else if (!c.this.jul || j2 > 0) {
                if (c.this.doScene(c.this.dispatcher(), c.this.callback) == -1) {
                    c.this.callback.onSceneEnd(3, -1, "doScene failed", c.this);
                }
                AppMethodBeat.o(30060);
                return false;
            } else {
                AppMethodBeat.o(30060);
                return false;
            }
        }
    }, true);
    public boolean jul = false;
    private boolean jvY = false;
    private d rr;
    public String talker;

    public c(String str, String str2, int i2) {
        AppMethodBeat.i(30061);
        this.dEb = i2;
        this.talker = str2;
        this.filename = str;
        this.encodeType = 0;
        this.clientId = UUID.randomUUID().toString();
        AppMethodBeat.o(30061);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30062);
        this.callback = iVar;
        int boW = (int) s.boW(this.filename);
        if (boW <= 0) {
            Log.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", this.filename);
            AppMethodBeat.o(30062);
            return -1;
        }
        int i2 = boW - this.Iym;
        if (i2 > 3960) {
            i2 = 3960;
        } else if (i2 < 3300 && !this.jul) {
            Log.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", Integer.valueOf(i2), Boolean.valueOf(this.jul));
            AppMethodBeat.o(30062);
            return -1;
        } else if (this.jul) {
            this.jvY = true;
        }
        Log.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", Integer.valueOf(boW), Integer.valueOf(this.Iym), Boolean.valueOf(this.jul), Boolean.valueOf(this.jvY), this.filename);
        byte[] aW = s.aW(this.filename, this.Iym, i2);
        if (aW != null) {
            d.a aVar = new d.a();
            aVar.iLN = new enm();
            aVar.iLO = new enn();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            aVar.funcId = 349;
            aVar.iLP = 158;
            aVar.respCmdId = 1000000158;
            this.rr = aVar.aXF();
            enm enm = (enm) this.rr.iLK.iLR;
            bg.aVF();
            enm.UserName = (String) com.tencent.mm.model.c.azQ().get(2, "");
            enm.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
            enm.KZk = this.Iym;
            enm.Nln = this.clientId;
            enm.jeU = this.jvY ? 1 : 0;
            enm.Nlo = 0;
            enm.KKD = 0;
            enm.Nlp = this.encodeType;
            enm.KKA = 0;
            int dispatch = dispatch(gVar, this.rr, this);
            this.Iym = enm.BsI.getILen() + enm.KZk;
            long j2 = this.jul ? 0 : 500;
            Log.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", this.filename, Long.valueOf(j2), Integer.valueOf(dispatch));
            this.iKj.startTimer(j2);
            AppMethodBeat.o(30062);
            return dispatch;
        } else if (this.jvY) {
            AppMethodBeat.o(30062);
            return 0;
        } else {
            Log.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", Integer.valueOf(i2), Boolean.valueOf(this.jul), Boolean.valueOf(this.jvY));
            AppMethodBeat.o(30062);
            return -1;
        }
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
        AppMethodBeat.i(30063);
        this.callback.onSceneEnd(3, 0, "securityCheckError", this);
        AppMethodBeat.o(30063);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(30064);
        Log.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", Integer.valueOf(i3), Integer.valueOf(i4), this.filename);
        enn enn = (enn) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", Integer.valueOf(enn.jeU), d(enn.Nlq));
            if (enn.jeU == 1) {
                this.Iyo = true;
                String d2 = d(enn.Nlq);
                if (d2 != null) {
                    this.Iyn = d2;
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(30064);
                return;
            }
            AppMethodBeat.o(30064);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(30064);
    }

    private static String d(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(30065);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(30065);
            return null;
        }
        String yO = sKBuiltinBuffer_t.getBuffer().yO();
        AppMethodBeat.o(30065);
        return yO;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 349;
    }
}
