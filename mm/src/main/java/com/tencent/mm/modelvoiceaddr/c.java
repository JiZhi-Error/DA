package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.esl;
import com.tencent.mm.protocal.protobuf.esn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c extends a implements m {
    private i callback;
    private String filename;
    private int gTn;
    private int jlB;
    private boolean jul;
    public h jvN;
    private boolean jvO;
    private boolean jvP;
    private int jvQ;
    private dqi jvR;
    private int jvS;
    private String[] jvT;
    private int jvU;
    private MMHandler jvV;
    private int retCode;
    private int scene;

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
        return this.jvT;
    }

    @Override // com.tencent.mm.modelvoiceaddr.a
    public final long bio() {
        return 0;
    }

    @Override // com.tencent.mm.modelvoiceaddr.a
    public final List<String> biq() {
        AppMethodBeat.i(148515);
        h hVar = this.jvN;
        ArrayList arrayList = new ArrayList();
        hVar.jwN.readLock().lock();
        for (h.a aVar : hVar.jwM.values()) {
            if (aVar.jwQ) {
                arrayList.add(aVar.jwP);
            }
        }
        hVar.jwN.readLock().unlock();
        AppMethodBeat.o(148515);
        return arrayList;
    }

    public c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(148516);
        this.retCode = 0;
        this.gTn = 120;
        this.jul = false;
        this.jvO = false;
        this.jvP = false;
        this.jlB = 0;
        this.jvQ = 0;
        this.filename = null;
        this.jvR = null;
        this.scene = 0;
        this.jvT = new String[0];
        this.jvU = 3960;
        this.jvV = new MMHandler(g.aAk().getLooper()) {
            /* class com.tencent.mm.modelvoiceaddr.c.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(148514);
                if (message.what != 291) {
                    AppMethodBeat.o(148514);
                    return;
                }
                if (c.this.bir()) {
                    g.azz().a(c.this, 0);
                }
                AppMethodBeat.o(148514);
            }
        };
        this.filename = str;
        this.jvN = new h(str2);
        this.jvR = new dqi().bhy(str3);
        this.jvS = i2;
        this.scene = i3;
        Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(148516);
    }

    public c(String str, h hVar, String str2, int i2) {
        AppMethodBeat.i(148517);
        this.retCode = 0;
        this.gTn = 120;
        this.jul = false;
        this.jvO = false;
        this.jvP = false;
        this.jlB = 0;
        this.jvQ = 0;
        this.filename = null;
        this.jvR = null;
        this.scene = 0;
        this.jvT = new String[0];
        this.jvU = 3960;
        this.jvV = new MMHandler(g.aAk().getLooper()) {
            /* class com.tencent.mm.modelvoiceaddr.c.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(148514);
                if (message.what != 291) {
                    AppMethodBeat.o(148514);
                    return;
                }
                if (c.this.bir()) {
                    g.azz().a(c.this, 0);
                }
                AppMethodBeat.o(148514);
            }
        };
        this.filename = str;
        this.jvN = hVar;
        this.jvR = new dqi().bhy(str2);
        this.jvS = i2;
        this.scene = 10;
        Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", str, hVar, str2, Integer.valueOf(i2), 10);
        AppMethodBeat.o(148517);
    }

    public final boolean bir() {
        AppMethodBeat.i(148518);
        Log.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.jvV.removeMessages(291);
        if ((!this.jvN.biB() || !this.jul) && !this.jvO) {
            h.a um = this.jvN.um(this.jlB);
            if (um != null) {
                long boW = s.boW(this.filename);
                long min = Math.min(boW, (long) um.jwS);
                Log.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", Long.valueOf(boW), Integer.valueOf(um.jwS), Long.valueOf(min));
                if (min <= 0) {
                    Log.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", this.filename);
                    this.retCode = f.getLine() + 40000;
                    this.jvQ = 0;
                    bis();
                    if (this.callback != null) {
                        this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
                    }
                    AppMethodBeat.o(148518);
                    return false;
                }
                this.jvQ = (int) (min - ((long) this.jlB));
                if (this.jvQ < 0) {
                    Log.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", Integer.valueOf(this.jvQ));
                    this.retCode = f.getLine() + 40000;
                    this.jvV.sendEmptyMessageDelayed(291, (long) (this.gTn * 2));
                    AppMethodBeat.o(148518);
                    return false;
                }
                Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", Integer.valueOf(this.jvQ), Integer.valueOf(um.jwT), Integer.valueOf(this.gTn));
                if (this.jvQ >= 500 || um.jwT <= 5) {
                    this.jvV.sendEmptyMessageDelayed(291, (long) this.gTn);
                } else {
                    Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", Integer.valueOf(this.jvQ));
                    this.jvV.sendEmptyMessageDelayed(291, (long) (this.gTn * 2));
                }
                AppMethodBeat.o(148518);
                return true;
            }
            this.jvV.sendEmptyMessageDelayed(291, (long) (this.gTn * 2));
            AppMethodBeat.o(148518);
            return true;
        }
        Log.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
        AppMethodBeat.o(148518);
        return false;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2;
        AppMethodBeat.i(148519);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new esl();
        aVar.iLO = new esn();
        aVar.uri = "/cgi-bin/micromsg-bin/voicetrans";
        aVar.funcId = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
        aVar.iLP = 381;
        aVar.respCmdId = 1000000381;
        d aXF = aVar.aXF();
        aXF.getReqObj().setShortSupport(false);
        esl esl = (esl) aXF.iLK.iLR;
        h.a um = this.jvN.um(this.jlB);
        esl.Scene = this.scene;
        if (um == null) {
            esl.BsI = new SKBuiltinBuffer_t();
            esl.KZk = this.jlB;
            esl.Nln = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            esl.jeU = 1;
            esl.Nlp = 2;
            esl.KXP = 0;
            esl.NpC = this.jvN.biA();
            esl.NpB = esl.NpC == null ? 0 : esl.NpC.size();
            esl.MRM = this.jvR;
            esl.NpD = this.jvS;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Iterator<dqi> it = esl.NpC.iterator();
            while (it.hasNext()) {
                sb.append(it.next().MTo).append(", ");
            }
            sb.append("]");
            Log.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", sb.toString(), Long.valueOf(System.currentTimeMillis()));
            int dispatch = dispatch(gVar, aXF, this);
            AppMethodBeat.o(148519);
            return dispatch;
        }
        um.jwQ = true;
        if (this.jvP) {
            um.jwR = true;
            esl.BsI = new SKBuiltinBuffer_t();
            Log.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.jvQ > this.jvU) {
                this.jvQ = this.jvU;
                um.jwR = false;
            } else if (this.jvQ <= this.jvU && (um.jwS != Integer.MAX_VALUE || this.jul)) {
                um.jwR = true;
            }
            esl.BsI = new SKBuiltinBuffer_t().setBuffer(s.aW(this.filename, this.jlB, this.jvQ));
        }
        esl.KZk = this.jlB;
        esl.Nln = um.jwP;
        if (um.jwR) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        esl.jeU = i2;
        esl.Nlp = 2;
        int i3 = um.jwT + 1;
        um.jwT = i3;
        esl.KXP = i3;
        esl.NpC = this.jvN.biA();
        esl.NpB = esl.NpC == null ? 0 : esl.NpC.size();
        esl.MRM = this.jvR;
        esl.NpD = this.jvS;
        Log.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", f.apq(), this.filename, Integer.valueOf(um.jwS), Integer.valueOf(this.jlB), Integer.valueOf(this.jvQ), Integer.valueOf(esl.BsI.getILen()), Boolean.valueOf(um.jwR), Integer.valueOf(esl.KXP), esl.NpC, esl.MRM, Integer.valueOf(esl.Scene));
        this.jlB = esl.BsI.getILen() + this.jlB;
        Log.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", um.jwP, Integer.valueOf(this.jlB));
        if (um.jwT == 1) {
            Log.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", Long.valueOf(System.currentTimeMillis()));
        }
        Log.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", Long.valueOf(System.currentTimeMillis()));
        int dispatch2 = dispatch(gVar, aXF, this);
        AppMethodBeat.o(148519);
        return dispatch2;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 2000;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(148520);
        Log.w("MicroMsg.NetSceneNewVoiceInput", f.apq() + " setSecurityCheckError e: %s", aVar);
        if (aVar == q.a.EReachMaxLimit) {
            bis();
            this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
        }
        AppMethodBeat.o(148520);
    }

    @Override // com.tencent.mm.ak.q
    public final boolean isSupportConcurrent() {
        return true;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(148521);
        Log.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", f.apq(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 3 && i4 == -1) {
            Log.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", Util.getStack(), Long.valueOf(Thread.currentThread().getId()));
        }
        esl esl = (esl) ((d) sVar).iLK.iLR;
        esn esn = (esn) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", esl.Nln, Integer.valueOf(esl.KXP), Long.valueOf(System.currentTimeMillis()));
            this.jvN.aI(esn.NpG);
            if (this.jvN.biB() && this.jul) {
                Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                bit();
            }
            this.jvT = new String[]{this.jvN.getResult()};
            this.callback.onSceneEnd(i3, i4, str, this);
            this.jvU = esn.NpH <= 0 ? this.jvU : esn.NpH;
            this.gTn = esn.MML < 0 ? 120 : esn.MML;
            Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", Integer.valueOf(this.jvU), Integer.valueOf(this.gTn));
            AppMethodBeat.o(148521);
            return;
        }
        Log.i("MicroMsg.NetSceneNewVoiceInput", f.apq() + " onGYNetEnd file: %s errType:%s errCode:%s", this.filename, Integer.valueOf(i3), Integer.valueOf(i4));
        bis();
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(148521);
    }

    public final void bis() {
        AppMethodBeat.i(148522);
        Log.d("MicroMsg.NetSceneNewVoiceInput", f.apq());
        if (this.jvP) {
            AppMethodBeat.o(148522);
            return;
        }
        this.jvP = true;
        bit();
        g.azz().sK(hashCode());
        final h.a um = this.jvN.um(this.jlB);
        if (um != null) {
            this.jvQ = 0;
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.modelvoiceaddr.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(148513);
                    Log.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", um.jwP, Integer.valueOf(um.jwS), Integer.valueOf(c.this.hashCode()));
                    g.azz().a(c.this, 0);
                    AppMethodBeat.o(148513);
                }
            });
        }
        AppMethodBeat.o(148522);
    }

    private void bit() {
        AppMethodBeat.i(148523);
        Log.d("MicroMsg.NetSceneNewVoiceInput", f.apq());
        if (this.jvV != null) {
            this.jvV.removeMessages(291);
        }
        this.jvO = true;
        AppMethodBeat.o(148523);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
    }

    public final void ul(int i2) {
        AppMethodBeat.i(148524);
        Log.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", f.apq(), Integer.valueOf(i2));
        if (i2 < 0) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(148524);
            throw illegalStateException;
        }
        this.jvN.ul(i2);
        AppMethodBeat.o(148524);
    }
}
