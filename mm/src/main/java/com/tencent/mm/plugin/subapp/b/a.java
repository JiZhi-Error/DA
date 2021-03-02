package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.io.OutputStream;

public final class a extends q implements m {
    int FJG = 0;
    private i callback;
    private MTimerHandler iKj = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.subapp.b.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            epe epe;
            AppMethodBeat.i(28899);
            if (a.this.FJG < 0) {
                AppMethodBeat.o(28899);
                return false;
            }
            bxi bxi = (bxi) a.this.rr.iLL.iLR;
            try {
                epe = bxi.Mdh.get(a.this.FJG);
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.this.FJG + " not Found");
                epe = null;
            }
            if (!(epe == null || epe.Nnb == null || epe.Nnb.getBuffer() == null || epe.Nna == null || epe.Nna.getBuffer() == null)) {
                Log.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + bxi.Version + " idx:" + a.this.FJG + " id:" + Integer.toHexString(epe.ID) + " size:" + epe.Nna.getILen() + " hdsize:" + epe.Nnb.getILen());
                a.a(epe.ID, true, epe.Nnb.getBuffer().toByteArray());
                a.a(epe.ID, false, epe.Nna.getBuffer().toByteArray());
            }
            a aVar = a.this;
            aVar.FJG--;
            AppMethodBeat.o(28899);
            return true;
        }
    }, true);
    final d rr;

    public a() {
        int i2 = 0;
        AppMethodBeat.i(28900);
        bg.aVF();
        int nullAsNil = Util.nullAsNil((Integer) c.azQ().get(66052, (Object) null));
        if (ay.a.iDs.rX(nullAsNil)) {
            bg.aVF();
            i2 = Util.nullAsNil((Integer) c.azQ().get(66053, (Object) null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(nullAsNil)).append(" inver:");
        bg.aVF();
        Log.d("MicroMsg.NetSceneGetVUserInfo", append.append(Util.nullAsNil((Integer) c.azQ().get(66053, (Object) null))).append(" reqver:").append(i2).toString());
        d.a aVar = new d.a();
        aVar.iLN = new bxh();
        aVar.iLO = new bxi();
        aVar.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        aVar.funcId = TbsListener.ErrorCode.STARTDOWNLOAD_8;
        aVar.iLP = 60;
        aVar.respCmdId = 1000000060;
        this.rr = aVar.aXF();
        ((bxh) this.rr.iLK.iLR).Version = i2;
        AppMethodBeat.o(28900);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28901);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28901);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.STARTDOWNLOAD_8;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5 = 0;
        AppMethodBeat.i(28902);
        if (i3 == 0 && i4 == 0) {
            bxi bxi = (bxi) ((d) sVar).iLL.iLR;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(bxi.Version).append(" old version:");
            bg.aVF();
            Log.d("MicroMsg.NetSceneGetVUserInfo", append.append(Util.nullAsNil((Integer) c.azQ().get(66053, (Object) null))).append(" Count:").append(bxi.Mdh.size()).toString());
            bg.aVF();
            c.azQ().set(66053, Integer.valueOf(bxi.Version));
            if (bxi.Mdh.size() <= 0) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(28902);
                return;
            }
            for (int i6 = 0; i6 < bxi.Mdh.size(); i6++) {
                i5 |= bxi.Mdh.get(i6).ID;
            }
            bg.aVF();
            c.azQ().set(66052, Integer.valueOf(i5));
            this.callback.onSceneEnd(i3, i4, str, this);
            this.FJG = bxi.Mdh.size() - 1;
            this.iKj.startTimer(50);
            AppMethodBeat.o(28902);
            return;
        }
        Log.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28902);
    }

    static boolean a(int i2, boolean z, byte[] bArr) {
        AppMethodBeat.i(28903);
        OutputStream outputStream = null;
        try {
            outputStream = com.tencent.mm.vfs.s.dw(ay.a.iDs.E(i2, z), false);
            outputStream.write(bArr);
            outputStream.close();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(28903);
            return true;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e3, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e4) {
                }
            }
            AppMethodBeat.o(28903);
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.o(28903);
            throw th;
        }
    }
}
