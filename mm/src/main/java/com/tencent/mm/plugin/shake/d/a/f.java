package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ay.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.smtt.sdk.TbsListener;

public final class f extends e {
    private i callback;
    private final d rr;

    public f(byte[] bArr, int i2, long j2, int i3, boolean z, int i4) {
        super(j2);
        int i5;
        AppMethodBeat.i(28283);
        d.a aVar = new d.a();
        aVar.iLN = new dwy();
        aVar.iLO = new dwz();
        aVar.uri = "/cgi-bin/micromsg-bin/shakemusic";
        aVar.funcId = 367;
        aVar.iLP = TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
        aVar.respCmdId = 1000000177;
        this.rr = aVar.aXF();
        dwy dwy = (dwy) this.rr.iLK.iLR;
        dwy.BsI = new SKBuiltinBuffer_t().setBuffer(bArr);
        dwy.MWV = i3;
        dwy.jeU = z ? 1 : 0;
        dwy.MWW = (float) i2;
        dwy.Llx = ag.dm(MMApplicationContext.getContext()) ? 1 : 2;
        dwy.KIy = i4;
        float f2 = 0.0f;
        float f3 = 0.0f;
        try {
            bg.aVF();
            f2 = Util.getFloat((String) c.azQ().get(ar.a.USERINFO_SHAKE_TV_LATITUDE_STRING, (Object) null), 0.0f);
            bg.aVF();
            f3 = Util.getFloat((String) c.azQ().get(ar.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, (Object) null), 0.0f);
            bg.aVF();
            i5 = Util.safeParseInt((String) c.azQ().get(ar.a.USERINFO_SHAKE_TV_ACCURACY_STRING, (Object) null));
        } catch (Exception e2) {
            i5 = 0;
        }
        dwy.LbD = f2;
        dwy.MWX = f3;
        dwy.LZS = e.bem() ? 0 : 1;
        dwy.LZT = e.bel() ? 1 : 0;
        o.a(2014, dwy.MWX, dwy.LbD, i5);
        AppMethodBeat.o(28283);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28284);
        dwy dwy = (dwy) this.rr.iLK.iLR;
        Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(dwy.MWV), Integer.valueOf(dwy.BsI.getILen()), Integer.valueOf(dwy.jeU), Float.valueOf(dwy.MWW), Integer.valueOf(dwy.Llx), Integer.valueOf(dwy.KIy));
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28284);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28285);
        dwz dwz = (dwz) this.rr.iLL.iLR;
        Log.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(((dwy) this.rr.iLK.iLR).MWV), Integer.valueOf(dwz.jeU));
        if (i3 == 0 && i4 == 0 && dwz.jeU == 1) {
            this.dQA = true;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28285);
    }

    @Override // com.tencent.mm.plugin.shake.d.a.e
    public final dpc eUP() {
        return (dwz) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 367;
    }
}
