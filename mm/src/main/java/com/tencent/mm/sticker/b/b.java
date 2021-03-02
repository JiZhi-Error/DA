package com.tencent.mm.sticker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J>\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u0015H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/sticker/net/NetSceneGetLensList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "plugin-sticker_release"})
public final class b extends q implements m {
    private final String TAG = "MicroMsg.NetSceneGetLensList";
    private i callback;
    private final d rr;

    public b() {
        AppMethodBeat.i(105980);
        d.a aVar = new d.a();
        aVar.c(new bph());
        aVar.d(new bpi());
        aVar.MB("/cgi-bin/micromsg-bin/getlenslist");
        aVar.sG(3847);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        AppMethodBeat.o(105980);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(105977);
        Log.i(this.TAG, "onGYNetEnd: " + i3 + ", " + i4);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
        }
        if (i3 == 4 && i4 == 2) {
            a aYJ = this.rr.aYJ();
            if (aYJ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListRequest");
                AppMethodBeat.o(105977);
                throw tVar;
            }
            bph bph = (bph) aYJ;
            a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensListResponse");
                AppMethodBeat.o(105977);
                throw tVar2;
            }
            bpi bpi = (bpi) aYK;
            if (bpi.LXB != null) {
                bph.LXB = bpi.LXB;
                doScene(dispatcher(), this.callback);
            }
        }
        AppMethodBeat.o(105977);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3847;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(105978);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(105978);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 20;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(105979);
        p.h(sVar, "rr");
        q.b bVar = q.b.EOk;
        AppMethodBeat.o(105979);
        return bVar;
    }
}
