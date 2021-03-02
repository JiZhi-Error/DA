package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.subapp.d.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.eoi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import junit.framework.Assert;

public final class b extends q implements m {
    i callback;
    private int endFlag = 0;
    String fileName;
    MTimerHandler iKj = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.subapp.d.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(28929);
            g aSP = d.fth().aSP(b.this.fileName);
            if (aSP == null || !aSP.big()) {
                Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.this.fileName);
                b.this.retCode = f.getLine() + 10000;
                b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
                AppMethodBeat.o(28929);
                return false;
            }
            if (!(3 == aSP.field_status || 8 == aSP.field_status)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis / 1000) - aSP.field_lastmodifytime > 30) {
                    Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.this.fileName);
                    b.this.retCode = f.getLine() + 10000;
                    b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
                    AppMethodBeat.o(28929);
                    return false;
                } else if (currentTimeMillis - b.this.juq < 2000) {
                    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fileName + " but last send time:" + (currentTimeMillis - b.this.juq));
                    AppMethodBeat.o(28929);
                    return true;
                } else {
                    c.a abk = h.aSM(b.this.fileName).abk(aSP.field_offset);
                    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fileName + " readByte:" + abk.dAc + " stat:" + aSP.field_status);
                    if (abk.dAc < 2000) {
                        AppMethodBeat.o(28929);
                        return true;
                    }
                }
            }
            if (b.this.doScene(b.this.dispatcher(), b.this.callback) == -1) {
                b.this.retCode = f.getLine() + 10000;
                b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
            }
            AppMethodBeat.o(28929);
            return false;
        }
    }, true);
    private int jsR = 0;
    private boolean jul = false;
    long juq;
    int retCode = 0;
    private d rr;

    public b(String str) {
        boolean z = true;
        AppMethodBeat.i(28930);
        Assert.assertTrue(str == null ? false : z);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        AppMethodBeat.o(28930);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        boolean a2;
        int i2;
        c.a aVar;
        int i3;
        AppMethodBeat.i(28931);
        this.callback = iVar;
        this.jul = false;
        if (this.fileName == null) {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(28931);
            return -1;
        }
        g aSP = d.fth().aSP(this.fileName);
        if (aSP == null || !aSP.big()) {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(28931);
            return -1;
        }
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + aSP.field_nettimes);
        String str = this.fileName;
        if (str == null) {
            a2 = false;
        } else {
            g aSP2 = d.fth().aSP(str);
            if (aSP2 == null) {
                a2 = false;
            } else if (aSP2.field_nettimes >= 80) {
                a2 = false;
            } else {
                aSP2.field_nettimes++;
                aSP2.cSx = 16384;
                a2 = h.a(aSP2);
            }
        }
        if (!a2) {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
            h.QE(this.fileName);
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(28931);
            return -1;
        }
        c.a aVar2 = new c.a();
        if (aSP.field_status == 8) {
            Log.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
            this.endFlag = 1;
            h.Rk(aSP.field_filename);
            i2 = 1;
            aVar = aVar2;
        } else {
            if (aSP.field_status == 3) {
                this.jul = true;
            }
            c aSM = h.aSM(this.fileName);
            if (aSM == null) {
                this.retCode = f.getLine() + 10000;
                AppMethodBeat.o(28931);
                return -1;
            }
            c.a abk = aSM.abk(aSP.field_offset);
            Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + abk.ret + " readlen:" + abk.dAc + " newOff:" + abk.jsR + " netOff:" + aSP.field_offset + " line:" + f.getLine());
            if (abk.ret < 0) {
                Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + abk.ret + " readlen:" + abk.dAc + " newOff:" + abk.jsR + " netOff:" + aSP.field_offset);
                h.QE(this.fileName);
                this.retCode = f.getLine() + 10000;
                AppMethodBeat.o(28931);
                return -1;
            }
            this.jsR = abk.jsR;
            if (this.jsR < aSP.field_offset || this.jsR >= 469000) {
                Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.jsR + " OldtOff:" + aSP.field_offset);
                h.QE(this.fileName);
                this.retCode = f.getLine() + 10000;
                AppMethodBeat.o(28931);
                return -1;
            }
            this.endFlag = 0;
            if (abk.dAc != 0 || this.jul) {
                if (this.jul) {
                    if (aSP.field_totallen <= 0) {
                        Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + aSP.field_totallen);
                        h.QE(this.fileName);
                        this.retCode = f.getLine() + 10000;
                        AppMethodBeat.o(28931);
                        return -1;
                    } else if (aSP.field_totallen > this.jsR && abk.dAc < 6000) {
                        Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + abk.dAc + " newOff:" + abk.jsR + " netOff:" + aSP.field_offset + " totalLen:" + aSP.field_totallen);
                        h.QE(this.fileName);
                        this.retCode = f.getLine() + 10000;
                        AppMethodBeat.o(28931);
                        return -1;
                    } else if (aSP.field_totallen <= this.jsR) {
                        this.endFlag = 1;
                    }
                }
                i2 = 0;
                aVar = abk;
            } else {
                Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                h.QE(this.fileName);
                this.retCode = f.getLine() + 10000;
                AppMethodBeat.o(28931);
                return -1;
            }
        }
        int i4 = aSP.field_voicelenght;
        if (i4 == 0) {
            i3 = ((this.jsR - 6) / 32) * 20;
        } else {
            i3 = i4;
        }
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + aSP.field_msgid);
        d.a aVar3 = new d.a();
        aVar3.iLN = new eoh();
        aVar3.iLO = new eoi();
        aVar3.uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
        aVar3.funcId = TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
        aVar3.iLP = 157;
        aVar3.respCmdId = 1000000157;
        this.rr = aVar3.aXF();
        eoh eoh = (eoh) this.rr.iLK.iLR;
        eoh.xNH = z.aTY();
        eoh.xNG = aSP.field_user;
        eoh.KZk = aSP.field_offset;
        eoh.KIz = aSP.field_clientid;
        eoh.KXq = i3;
        eoh.jeU = this.endFlag;
        eoh.Brn = aSP.field_msgid;
        eoh.LrF = i2;
        eoh.Nmf = (int) (aSP.field_createtime / 1000);
        eoh.Msa = 1;
        if (((s) com.tencent.mm.kernel.g.ah(s.class)).ifAddTicketByActionFlag(aSP.field_user)) {
            eoh.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(aSP.field_user);
        }
        if (i2 != 1) {
            eoh.BsI = new SKBuiltinBuffer_t().setBuffer(aVar.buf, 0, aVar.dAc);
            eoh.KUy = aVar.dAc;
        } else {
            eoh.BsI = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cD(new byte[1]));
            eoh.KUy = 1;
        }
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i2 + " endFlag:" + this.endFlag + " svrId:" + aSP.field_msgid);
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + eoh.Brn + " user:" + eoh.xNG + " offset:" + eoh.KZk + " dataLen:" + eoh.BsI.getILen() + " endFlag:" + eoh.jeU);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + aSP.field_msgid + " file:" + this.fileName + " readBytes:" + aVar.dAc + " neTTTOff:" + aSP.field_offset + " neWWWOff:" + this.jsR + " endFlag:" + this.endFlag + " cancelFlag:" + i2 + " status:" + aSP.field_status);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + eoh.toString());
        this.juq = System.currentTimeMillis();
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28931);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(28932);
        eoh eoh = (eoh) ((d) sVar).iLK.iLR;
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + eoh.KZk + " dataLen:" + eoh.BsI.getILen() + " endFlag:" + eoh.jeU);
        q.b bVar = q.b.EOk;
        AppMethodBeat.o(28932);
        return bVar;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 240;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(28933);
        h.QE(this.fileName);
        AppMethodBeat.o(28933);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(28934);
        Log.i("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + i3 + " errCode:" + i4);
        eoh eoh = (eoh) ((d) sVar).iLK.iLR;
        eoi eoi = (eoi) ((d) sVar).iLL.iLR;
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + eoi.toString());
        if (eoi != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((s) com.tencent.mm.kernel.g.ah(s.class)).setEnSendMsgActionFlag(eoi.LbO);
        }
        if (i3 == 4 && i4 == -22) {
            g aSP = d.fth().aSP(this.fileName);
            if (aSP != null) {
                if (aSP.field_status == 3) {
                    bg.aVF();
                    ca Hb = com.tencent.mm.model.c.aSQ().Hb((long) aSP.field_msglocalid);
                    Hb.setContent(f.b(aSP.field_human, (long) aSP.field_voicelenght, false));
                    Hb.setStatus(2);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a((long) aSP.field_msglocalid, Hb);
                }
                aSP.field_status = 97;
                aSP.field_lastmodifytime = System.currentTimeMillis() / 1000;
                aSP.cSx = 320;
                h.a(aSP);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(28934);
        } else if (i3 == 4 && i4 != 0) {
            h.QE(this.fileName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(28934);
        } else if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + eoi.Brn + " toUser:" + eoh.xNG);
            String str2 = this.fileName;
            int i6 = this.jsR;
            long j2 = eoi.Brn;
            String str3 = eoi.KIz;
            int i7 = this.endFlag;
            if (str2 == null) {
                i5 = -1;
            } else {
                Log.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str2 + "] newOff:" + i6 + " SvrID:" + j2 + " clientID:" + str3 + " hasSendEndFlag " + i7);
                g aSP2 = d.fth().aSP(str2);
                if (aSP2 == null) {
                    i5 = -1;
                } else {
                    aSP2.field_offset = i6;
                    aSP2.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    aSP2.cSx = 264;
                    if (Util.isNullOrNil(aSP2.field_clientid) && str3 != null) {
                        aSP2.field_clientid = str3;
                        aSP2.cSx |= 512;
                    }
                    if (aSP2.field_msgid == 0 && j2 != 0) {
                        aSP2.field_msgid = j2;
                        aSP2.cSx |= 4;
                    }
                    i5 = 0;
                    Log.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + aSP2.field_totallen + "  newOffset " + i6 + "  " + aSP2.field_status);
                    if (aSP2.field_totallen <= i6 && aSP2.field_status == 3 && i7 == 1) {
                        aSP2.field_status = 99;
                        aSP2.cSx |= 64;
                        bg.aVF();
                        ca Hb2 = com.tencent.mm.model.c.aSQ().Hb((long) aSP2.field_msglocalid);
                        Hb2.Cy(aSP2.field_user);
                        Hb2.yF(aSP2.field_msgid);
                        Hb2.setStatus(2);
                        Hb2.setContent(f.b(aSP2.field_human, (long) aSP2.field_voicelenght, false));
                        bg.aVF();
                        com.tencent.mm.model.c.aSQ().a((long) aSP2.field_msglocalid, Hb2);
                        Log.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str2 + " total:" + aSP2.field_totallen + " status:" + aSP2.field_status + " netTimes:" + aSP2.field_nettimes);
                        i5 = 1;
                        h.Rg(str2);
                    }
                    if (!h.a(aSP2)) {
                        i5 = -4;
                    }
                }
            }
            Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + i5 + " file:" + this.fileName + " MsgSvrId:" + eoi.Brn + " clientId:" + eoi.KIz + " neWWOff:" + this.jsR + " neTTTT:" + eoi.KUy);
            if (i5 < 0) {
                h.QE(this.fileName);
                Log.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + i5);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(28934);
            } else if (i5 == 1) {
                Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(28934);
            } else {
                long j3 = this.jul ? 0 : 500;
                Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + j3);
                this.iKj.startTimer(j3);
                AppMethodBeat.o(28934);
            }
        } else {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(28934);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
    }
}
