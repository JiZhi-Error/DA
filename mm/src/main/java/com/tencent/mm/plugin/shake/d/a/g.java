package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class g extends e {
    private i callback;
    private final d rr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(byte[] bArr, int i2, long j2, int i3, boolean z, int i4) {
        super(j2);
        float f2;
        float f3;
        int i5 = 1;
        int i6 = 0;
        AppMethodBeat.i(28286);
        d.a aVar = new d.a();
        aVar.iLN = new dxc();
        aVar.iLO = new dxd();
        aVar.uri = "/cgi-bin/micromsg-bin/shaketv";
        aVar.funcId = 408;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dxc dxc = (dxc) this.rr.iLK.iLR;
        dxc.BsI = new SKBuiltinBuffer_t().setBuffer(bArr);
        dxc.MWV = i3;
        dxc.jeU = z ? 1 : 0;
        dxc.MWW = (float) i2;
        dxc.Llx = !ag.dm(MMApplicationContext.getContext()) ? 2 : i5;
        dxc.KIy = i4;
        try {
            bg.aVF();
            f3 = Util.getFloat((String) c.azQ().get(ar.a.USERINFO_SHAKE_TV_LATITUDE_STRING, (Object) null), 0.0f);
            try {
                bg.aVF();
                float f4 = Util.getFloat((String) c.azQ().get(ar.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, (Object) null), 0.0f);
                try {
                    bg.aVF();
                    i6 = Util.safeParseInt((String) c.azQ().get(ar.a.USERINFO_SHAKE_TV_ACCURACY_STRING, (Object) null));
                    f2 = f4;
                } catch (Exception e2) {
                    f2 = f4;
                }
            } catch (Exception e3) {
                f2 = 0.0f;
            }
        } catch (Exception e4) {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        dxc.LbD = f3;
        dxc.MWX = f2;
        o.a(2009, dxc.MWX, dxc.LbD, i6);
        AppMethodBeat.o(28286);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(28287);
        dxc dxc = (dxc) this.rr.iLK.iLR;
        Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(dxc.MWV), Integer.valueOf(dxc.BsI.getILen()), Integer.valueOf(dxc.jeU), Float.valueOf(dxc.MWW), Integer.valueOf(dxc.Llx), Integer.valueOf(dxc.KIy));
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28287);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28288);
        dxd dxd = (dxd) this.rr.iLL.iLR;
        Log.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(((dxc) this.rr.iLK.iLR).MWV), Integer.valueOf(dxd.jeU));
        if (i3 == 0 && i4 == 0 && dxd.jeU == 1) {
            this.dQA = true;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28288);
    }

    @Override // com.tencent.mm.plugin.shake.d.a.e
    public final dpc eUP() {
        return (dxd) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 408;
    }
}
