package com.tencent.mm.bg;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.enq;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class a extends q implements m {
    private int audioFormat;
    i callback;
    private String filemd5;
    String filename;
    MTimerHandler iKj;
    private int jlA;
    int jlB;
    private int jlC;
    private String jlz;
    private d rr;
    private int sampleRate;

    public a(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(148371);
        this.jlz = null;
        this.filemd5 = null;
        this.filename = null;
        this.sampleRate = 0;
        this.jlA = 0;
        this.audioFormat = 0;
        this.jlB = 0;
        this.jlC = 5;
        this.iKj = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.bg.a.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(148370);
                Log.d("MicroMsg.NetSceneUploadMedia", f.apq() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + s.boW(a.this.filename) + " oldoff:" + a.this.jlB);
                if (a.this.doScene(a.this.dispatcher(), a.this.callback) == -1) {
                    a.this.callback.onSceneEnd(3, -1, "doScene failed", a.this);
                }
                AppMethodBeat.o(148370);
                return false;
            }
        }, true);
        this.jlz = new StringBuilder().append(Util.nowMilliSecond()).toString();
        this.filename = str;
        this.jlC = i2;
        this.sampleRate = i3;
        this.jlA = i4;
        this.audioFormat = i5;
        this.filemd5 = g.getMessageDigest(s.aW(this.filename, 0, (int) s.boW(this.filename)));
        AppMethodBeat.o(148371);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2 = 3960;
        AppMethodBeat.i(148372);
        this.callback = iVar;
        int boW = (int) s.boW(this.filename);
        Log.d("MicroMsg.NetSceneUploadMedia", f.apq() + " read file:" + this.filename + " filelen:" + boW + " oldoff:" + this.jlB + "this.filemd5 " + this.filemd5);
        if (boW <= 0) {
            Log.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            AppMethodBeat.o(148372);
            return -1;
        }
        int i3 = boW - this.jlB;
        if (i3 <= 3960) {
            i2 = i3;
        }
        Log.i("MicroMsg.NetSceneUploadMedia", f.apq() + " read file:" + this.filename + " filelen:" + boW + " oldoff:" + this.jlB + "  canReadLen " + i2);
        byte[] aW = s.aW(this.filename, this.jlB, i2);
        if (aW == null) {
            Log.e("MicroMsg.NetSceneUploadMedia", "read data error");
            AppMethodBeat.o(148372);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLN = new enq();
        aVar.iLO = new enr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        aVar.funcId = 240;
        aVar.iLP = 111;
        aVar.respCmdId = 1000000111;
        this.rr = aVar.aXF();
        enq enq = (enq) this.rr.iLK.iLR;
        enq.Nlu = new dqi().bhy(this.jlz);
        enq.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
        enq.BsH = aW.length;
        enq.Nlv = new dqi().bhy(this.filemd5);
        enq.BsF = boW;
        enq.BsG = this.jlB;
        enq.xuT = this.jlC;
        enq.Nlw = 1;
        enq.Nlx = this.sampleRate;
        enq.Nly = this.jlA;
        enq.Nlz = this.audioFormat;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(148372);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 240;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(148373);
        updateDispatchId(i2);
        Log.d("MicroMsg.NetSceneUploadMedia", f.apq() + " onGYNetEnd file:" + this.filename + " errtype:" + i3 + " errCode:" + i4);
        enq enq = (enq) ((d) sVar).iLK.iLR;
        String str2 = ((enr) ((d) sVar).iLL.iLR).jfl;
        Log.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", this.filename, str2, Integer.valueOf(enq.BsF), Integer.valueOf(enq.BsH), Integer.valueOf(enq.BsG));
        if (i3 != 0 || i4 != 0) {
            Log.e("MicroMsg.NetSceneUploadMedia", f.apq() + " onGYNetEnd file:" + this.filename + " errType:" + i3 + " errCode:" + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148373);
        } else if (enq.BsF > enq.BsH + enq.BsG || str2 == null || str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            this.jlB = enq.BsI.getILen() + enq.BsG;
            Log.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.iKj.startTimer(500);
            AppMethodBeat.o(148373);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(148373);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 60;
    }
}
