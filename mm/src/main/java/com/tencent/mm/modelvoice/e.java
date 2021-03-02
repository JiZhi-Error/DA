package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e extends q implements m {
    private static ba juj = null;
    private static List<c> juk = new ArrayList();
    private i callback;
    private String dWq;
    public String fileName;
    private MTimerHandler iKj = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.modelvoice.e.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(148404);
            if (e.this.doScene(e.a(e.this), e.this.callback) == -1) {
                e.this.callback.onSceneEnd(3, -1, "doScene failed", e.this);
            }
            AppMethodBeat.o(148404);
            return false;
        }
    }, false);
    private String jui;
    private boolean jul = false;
    private boolean jum = false;
    public int retCode = 0;
    private d rr;

    static /* synthetic */ g a(e eVar) {
        AppMethodBeat.i(148414);
        g dispatcher = eVar.dispatcher();
        AppMethodBeat.o(148414);
        return dispatcher;
    }

    static {
        AppMethodBeat.i(148415);
        AppMethodBeat.o(148415);
    }

    public static void a(ba baVar) {
        if (juj == null) {
            juj = baVar;
        }
    }

    public static void a(c cVar) {
        AppMethodBeat.i(148405);
        if (!juk.contains(cVar)) {
            juk.add(cVar);
        }
        AppMethodBeat.o(148405);
    }

    public static void b(c cVar) {
        AppMethodBeat.i(148406);
        juk.remove(cVar);
        AppMethodBeat.o(148406);
    }

    private void doNotify() {
        AppMethodBeat.i(148407);
        final ca Rn = s.Rn(this.fileName);
        if (Rn != null) {
            if (juj != null) {
                juj.a(Rn);
            }
            for (final c cVar : juk) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.modelvoice.e.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(148403);
                        cVar.ah(Rn);
                        AppMethodBeat.o(148403);
                    }
                });
            }
        }
        AppMethodBeat.o(148407);
    }

    public e(r rVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(148408);
        if (rVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.fileName = rVar.fileName;
        if (this.fileName != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.jui = rVar.jui;
        this.dWq = rVar.dWq;
        Log.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice[%s]:  file[%s] voiceFormat[%s] user[%s]", toString(), this.fileName, this.jui, this.dWq);
        AppMethodBeat.o(148408);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(148409);
        this.callback = iVar;
        if (this.fileName == null) {
            Log.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(148409);
            return -1;
        }
        r Ro = s.Ro(this.fileName);
        if (Ro == null || !Ro.bif()) {
            Log.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(148409);
            return -1;
        }
        Log.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + Ro.jsp);
        if (!s.Re(this.fileName)) {
            Log.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
            s.QE(this.fileName);
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(148409);
            return -1;
        }
        int i2 = Ro.jqP - Ro.jsj;
        if (i2 > 0) {
            if (Ro.iKP == Ro.jqP) {
                this.jul = true;
            }
            d.a aVar = new d.a();
            aVar.iLN = new ahx();
            aVar.iLO = new ahy();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadvoice";
            aVar.funcId = 128;
            aVar.iLP = 20;
            aVar.respCmdId = 1000000020;
            this.rr = aVar.aXF();
            ahx ahx = (ahx) this.rr.iLK.iLR;
            ahx.KIz = Ro.clientId;
            ahx.Brn = Ro.dTS;
            ahx.KUy = i2;
            ahx.KZk = Ro.jsj;
            if (ab.Eq(this.dWq)) {
                ahx.KGO = this.dWq;
                ahx.LrE = Ro.jvv;
            }
            Log.i("MicroMsg.NetSceneDownloadVoice", "[%s]doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", toString(), ahx.KIz, Integer.valueOf(ahx.Brl), Long.valueOf(ahx.Brn), Integer.valueOf(ahx.KUy), Integer.valueOf(ahx.KZk), ahx.KGO, Long.valueOf(ahx.LrE));
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(148409);
            return dispatch;
        } else if (Ro.status == 5) {
            this.jum = true;
            Log.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + Ro.jqP + " Local:" + Ro.jsj);
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(148409);
            return -1;
        } else {
            s.a(this.fileName, Ro.jsj, (h.a) null);
            this.retCode = f.getLine() + 10000;
            AppMethodBeat.o(148409);
            return -1;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(148410);
        ahx ahx = (ahx) ((d) sVar).iLK.iLR;
        if (ahx.Brn == 0 || ahx.KIz == null || ahx.KIz.length() == 0 || ahx.KUy <= 0 || ahx.KZk < 0) {
            s.QE(this.fileName);
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(148410);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(148410);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 100;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(148411);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 233, 1, false);
        s.QE(this.fileName);
        AppMethodBeat.o(148411);
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        AppMethodBeat.i(148412);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        if (securityLimitCountReach) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 232, 1, false);
        }
        AppMethodBeat.o(148412);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(148413);
        Log.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd[" + toString() + "] file:" + this.fileName + " + id:" + i2 + " errtype:" + i3 + " errCode:" + i4);
        ahy ahy = (ahy) ((d) sVar).iLL.iLR;
        if (ahy.LrF == 1) {
            Log.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
            s.Rj(this.fileName);
            AppMethodBeat.o(148413);
        } else if (i4 == -22) {
            s.QE(this.fileName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148413);
        } else if (i3 == 4 && i4 != 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 231, 1, false);
            s.QE(this.fileName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148413);
        } else if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + ahy.BsI.getILen() + " fileOff:" + ahy.KZk);
            if (ahy.BsI.getBuffer() == null) {
                Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                s.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148413);
                return;
            }
            byte[] byteArray = ahy.BsI.getBuffer().toByteArray();
            if (byteArray.length == 0) {
                Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                s.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148413);
                return;
            }
            int write = s.bE(this.jui, this.fileName).write(byteArray, byteArray.length, ahy.KZk);
            if (write < 0) {
                Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + write);
                s.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148413);
                return;
            }
            s.a(this.fileName, byteArray, byteArray.length);
            Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + write + " voiceFormat:" + this.jui);
            int a2 = s.a(this.fileName, write, (h.a) null);
            Log.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd[" + toString() + "] : file:%s ret:%s", this.fileName, Integer.valueOf(a2));
            if (a2 < 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 229, 1, false);
                Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + a2);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148413);
            } else if (a2 == 1) {
                doNotify();
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(148413);
            } else {
                long j2 = 1000;
                if (this.jul) {
                    j2 = 0;
                }
                this.iKj.startTimer(j2);
                AppMethodBeat.o(148413);
            }
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 230, 1, false);
            Log.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " resp:" + sVar.getRespObj().getRetCode());
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148413);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 128;
    }
}
