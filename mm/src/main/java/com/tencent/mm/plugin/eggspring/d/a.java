package com.tencent.mm.plugin.eggspring.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J>\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "discountCouponParams", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "retCode", "", "getRetCode", "()Ljava/lang/Long;", "setRetCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "retMsg", "getRetMsg", "()Lcom/tencent/mm/protobuf/ByteString;", "setRetMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class a extends q implements m {
    public static final C0953a qVi = new C0953a((byte) 0);
    private i callback;
    public Long qVg;
    public b qVh;
    private d rr;

    static {
        AppMethodBeat.i(108156);
        AppMethodBeat.o(108156);
    }

    public a(b bVar) {
        p.h(bVar, "discountCouponParams");
        AppMethodBeat.i(108155);
        d.a aVar = new d.a();
        aVar.c(new dtj());
        aVar.d(new dtk());
        aVar.MB("/cgi-bin/mmpay-bin/mktsendaward");
        aVar.sG(2812);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendAwardRequest");
            AppMethodBeat.o(108155);
            throw tVar;
        }
        ((dtj) aYJ).MVz = bVar;
        AppMethodBeat.o(108155);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/net/NetSceneAcceptCoupon$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
    /* renamed from: com.tencent.mm.plugin.eggspring.d.a$a  reason: collision with other inner class name */
    public static final class C0953a {
        private C0953a() {
        }

        public /* synthetic */ C0953a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2812;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108153);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108153);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108154);
        Log.i("MicroMsg.NetSceneAcceptCoupon", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", Integer.valueOf(i3), Integer.valueOf(i4), str);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (!(aYK instanceof dtk)) {
            aYK = null;
        }
        dtk dtk = (dtk) aYK;
        Object[] objArr = new Object[2];
        objArr[0] = dtk != null ? Long.valueOf(dtk.LUH) : null;
        objArr[1] = dtk != null ? dtk.MVA : null;
        Log.d("MicroMsg.NetSceneAcceptCoupon", "ret[%s] msg[%s].", objArr);
        this.qVg = dtk != null ? Long.valueOf(dtk.LUH) : null;
        this.qVh = dtk != null ? dtk.MVA : null;
        i iVar = this.callback;
        if (iVar == null) {
            p.btv("callback");
        }
        iVar.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108154);
    }
}
