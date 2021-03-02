package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.m.a;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.eoi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.as;
import com.tencent.thumbplayer.api.TPOptionalID;
import junit.framework.Assert;

public final class f extends q implements m {
    i callback;
    private int endFlag;
    public String fileName;
    MTimerHandler iKj;
    private int jsR;
    private boolean jul;
    private int jup;
    long juq;
    public int retCode;
    private d rr;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(148417);
        this.retCode = 0;
        this.jsR = 0;
        this.jul = false;
        this.endFlag = 0;
        this.iKj = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.modelvoice.f.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(148416);
                r Ro = s.Ro(f.this.fileName);
                if (Ro == null || !Ro.big()) {
                    Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.this.fileName);
                    f.this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                    f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
                    AppMethodBeat.o(148416);
                    return false;
                }
                if (!(3 == Ro.status || 8 == Ro.status)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((currentTimeMillis / 1000) - Ro.jsm > 30) {
                        Log.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fileName);
                        f.this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                        f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
                        AppMethodBeat.o(148416);
                        return false;
                    } else if (currentTimeMillis - f.this.juq < 2000) {
                        Log.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fileName + " but last send time:" + (currentTimeMillis - f.this.juq));
                        AppMethodBeat.o(148416);
                        return true;
                    } else {
                        g dB = s.Rf(f.this.fileName).dB(Ro.jqP, 6000);
                        Log.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fileName + " readByte:" + dB.dAc + " stat:" + Ro.status);
                        if (dB.dAc < 2000) {
                            AppMethodBeat.o(148416);
                            return true;
                        }
                    }
                }
                if (f.this.doScene(f.this.dispatcher(), f.this.callback) == -1) {
                    f.this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                    f.this.callback.onSceneEnd(3, -1, "doScene failed", f.this);
                }
                AppMethodBeat.o(148416);
                return false;
            }
        }, true);
        Assert.assertTrue(str == null ? false : z);
        Log.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        this.jup = i2;
        AppMethodBeat.o(148417);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        int i2;
        int i3;
        int b2;
        AppMethodBeat.i(148418);
        this.callback = iVar;
        this.jul = false;
        if (this.fileName == null) {
            Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
            this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
            AppMethodBeat.o(148418);
            return -1;
        }
        r Ro = s.Ro(this.fileName);
        if (Ro == null || !Ro.big()) {
            Log.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
            AppMethodBeat.o(148418);
            return -1;
        }
        Log.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + Ro.jsp);
        if (!s.Re(this.fileName)) {
            Log.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
            s.QE(this.fileName);
            this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
            AppMethodBeat.o(148418);
            return -1;
        }
        g gVar2 = new g();
        if (Ro.status == 8) {
            Log.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
            this.endFlag = 0;
            s.Rk(Ro.fileName);
            i2 = 0;
            i3 = 1;
        } else {
            if (Ro.status == 3) {
                this.jul = true;
            }
            b Rf = s.Rf(this.fileName);
            if (Rf == null) {
                this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                Log.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", this.fileName);
                AppMethodBeat.o(148418);
                return -1;
            }
            int format = Rf.getFormat();
            Log.d("MicroMsg.NetSceneUploadVoice", "format ".concat(String.valueOf(format)));
            g dB = Rf.dB(Ro.jqP, 6000);
            Log.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + dB.ret + " readlen:" + dB.dAc + " newOff:" + dB.jsR + " netOff:" + Ro.jqP + " line:" + com.tencent.mm.compatible.util.f.getLine());
            if (dB.ret < 0) {
                h.INSTANCE.idkeyStat(111, 241, 1, false);
                Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + dB.ret + " readlen:" + dB.dAc + " newOff:" + dB.jsR + " netOff:" + Ro.jqP);
                s.QE(this.fileName);
                this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                AppMethodBeat.o(148418);
                return -1;
            }
            this.jsR = dB.jsR;
            if (this.jsR < Ro.jqP || this.jsR >= 469000) {
                h.INSTANCE.idkeyStat(111, 240, 1, false);
                Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.jsR + " OldtOff:" + Ro.jqP);
                s.QE(this.fileName);
                this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                AppMethodBeat.o(148418);
                return -1;
            }
            this.endFlag = 0;
            if (dB.dAc != 0 || this.jul) {
                if (this.jul) {
                    if (Ro.iKP <= 0) {
                        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + Ro.iKP);
                        s.QE(this.fileName);
                        this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                        AppMethodBeat.o(148418);
                        return -1;
                    } else if (Ro.iKP > this.jsR && dB.dAc < 6000) {
                        Log.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + dB.dAc + " newOff:" + dB.jsR + " netOff:" + Ro.jqP + " totalLen:" + Ro.iKP);
                        s.QE(this.fileName);
                        this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                        AppMethodBeat.o(148418);
                        return -1;
                    } else if (Ro.iKP <= this.jsR) {
                        Integer num = s.jvz.get(s.getFullPath(this.fileName));
                        if (!(num == null || num.intValue() == 0)) {
                            int intValue = s.jvA.get(s.getFullPath(this.fileName)).intValue();
                            g dB2 = Rf.dB(0, intValue);
                            int c2 = s.c(num.intValue() & 255, dB2.buf, dB2.dAc);
                            if (num.intValue() != c2) {
                                Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", Integer.valueOf(c2), num, Integer.valueOf(intValue), Integer.valueOf(dB2.dAc));
                                Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + dB.dAc + " newOff:" + dB.jsR + " netOff:" + Ro.jqP + " totalLen:" + Ro.iKP);
                                h.INSTANCE.idkeyStat(111, 173, 1, false);
                                s.jvz.put(s.getFullPath(this.fileName), Integer.valueOf(c2));
                                Integer num2 = s.jvB.get(s.getFullPath(this.fileName));
                                if (!(num2 == null || num2.intValue() == 0 || num2.intValue() == (b2 = s.b(0, dB2.buf, dB2.dAc)))) {
                                    Log.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", num2, Integer.valueOf(b2));
                                    s.QE(this.fileName);
                                    this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                                    h.INSTANCE.idkeyStat(111, 174, 1, false);
                                    AppMethodBeat.o(148418);
                                    return -1;
                                }
                            }
                        }
                        this.endFlag = 1;
                    }
                }
                i2 = format;
                i3 = 0;
                gVar2 = dB;
            } else {
                Log.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                AppMethodBeat.o(148418);
                return -1;
            }
        }
        int i4 = Ro.jvt;
        Log.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", Integer.valueOf(i4));
        if (i4 == 0) {
            i4 = s.Rp(this.fileName);
            Log.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", Integer.valueOf(i4));
            if (i4 < 0) {
                i4 = s.ui(this.jsR);
                Log.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", Integer.valueOf(i4));
            }
        }
        d.a aVar = new d.a();
        aVar.iLN = new eoh();
        aVar.iLO = new eoi();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoice";
        aVar.funcId = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        aVar.iLP = 19;
        aVar.respCmdId = 1000000019;
        this.rr = aVar.aXF();
        eoh eoh = (eoh) this.rr.iLK.iLR;
        eoh.xNH = z.aTY();
        eoh.xNG = Ro.dWq;
        eoh.KZk = Ro.jqP;
        eoh.KIz = Ro.clientId;
        eoh.KXq = i4;
        eoh.jeU = this.endFlag;
        eoh.Brn = Ro.dTS;
        eoh.LrF = i3;
        eoh.Nmg = this.jup;
        eoh.KHq = br.aVW();
        if (((s) com.tencent.mm.kernel.g.ah(s.class)).ifAddTicketByActionFlag(Ro.dWq)) {
            eoh.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(Ro.dWq);
        }
        eoh.KHq = a.C0409a.anC().K(Ro.dWq, Ro.jso);
        eoh.Msa = i2;
        if (i3 != 1) {
            eoh.BsI = new SKBuiltinBuffer_t().setBuffer(gVar2.buf, 0, gVar2.dAc);
            eoh.KUy = gVar2.dAc;
        } else {
            eoh.BsI = new SKBuiltinBuffer_t().setBuffer(b.cD(new byte[1]));
            eoh.KUy = 1;
        }
        Log.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + i3 + " endFlag:" + this.endFlag + " svrId:" + Ro.dTS);
        Log.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + eoh.Brn + " user:" + eoh.xNG + " offset:" + eoh.KZk + " dataLen:" + eoh.BsI.getILen() + " endFlag:" + eoh.jeU);
        Log.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + Ro.dTS + " voiceFormat:" + i2 + " file:" + this.fileName + " readBytes:" + gVar2.dAc + " neTTTOff:" + Ro.jqP + " neWWWOff:" + this.jsR + " endFlag:" + this.endFlag + " cancelFlag:" + i3 + " status:" + Ro.status + " voiceLen:" + i4);
        this.juq = System.currentTimeMillis();
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(148418);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(148419);
        eoh eoh = (eoh) ((d) sVar).iLK.iLR;
        Log.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + eoh.Brn + " offset:" + eoh.KZk + " dataLen:" + eoh.BsI.getILen() + " endFlag:" + eoh.jeU);
        if ((eoh.Brn != 0 || eoh.KZk == 0) && (!(eoh.BsI == null || eoh.BsI.getILen() == 0) || eoh.jeU == 1 || eoh.LrF == 1)) {
            q.b bVar = q.b.EOk;
            AppMethodBeat.o(148419);
            return bVar;
        }
        q.b bVar2 = q.b.EFailed;
        AppMethodBeat.o(148419);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 60;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        AppMethodBeat.i(148420);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        if (securityLimitCountReach) {
            h.INSTANCE.idkeyStat(111, 239, 1, false);
        }
        AppMethodBeat.o(148420);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(148421);
        h.INSTANCE.idkeyStat(111, 238, 1, false);
        s.QE(this.fileName);
        AppMethodBeat.o(148421);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(148422);
        Log.i("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + i3 + " errCode:" + i4);
        eoh eoh = (eoh) ((d) sVar).iLK.iLR;
        eoi eoi = (eoi) ((d) sVar).iLL.iLR;
        if (eoi != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((s) com.tencent.mm.kernel.g.ah(s.class)).setEnSendMsgActionFlag(eoi.LbO);
        }
        if (i3 == 4 && i4 == -22) {
            s.QF(this.fileName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148422);
        } else if (i3 == 4 && i4 != 0) {
            s.QE(this.fileName);
            h.INSTANCE.idkeyStat(111, 237, 1, false);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148422);
        } else if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + eoi.Brn + " toUser:" + eoh.xNG);
            if (eoi.Brn > 0 || as.IG(eoh.xNG)) {
                Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(eoi.Brn), Integer.valueOf(ac.jOD));
                if (10007 == ac.jOC && ac.jOD != 0) {
                    eoi.Brn = (long) ac.jOD;
                    ac.jOD = 0;
                }
                int a2 = s.a(this.fileName, this.jsR, eoi.Brn, eoi.KIz, this.endFlag, this.jup);
                Log.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + a2 + " file:" + this.fileName + " MsgSvrId:" + eoi.Brn + " clientId:" + eoi.KIz + " neWWOff:" + this.jsR + " neTTTT:" + eoi.KUy + " forwardflag:" + this.jup);
                if (a2 < 0) {
                    s.QE(this.fileName);
                    Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + a2);
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(148422);
                } else if (a2 == 1) {
                    Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
                    com.tencent.mm.modelstat.b.jmd.s(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb((long) s.Ro(this.fileName).jso));
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(148422);
                } else {
                    long j2 = this.jul ? 0 : 500;
                    Log.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + j2);
                    this.iKj.startTimer(j2);
                    AppMethodBeat.o(148422);
                }
            } else {
                h.INSTANCE.idkeyStat(111, 235, 1, false);
                Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + eoi.Brn + " netoff:" + eoi.KZk);
                s.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148422);
            }
        } else {
            h.INSTANCE.idkeyStat(111, 236, 1, false);
            Log.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148422);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
    }
}
