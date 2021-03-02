package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J<\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "context", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class f extends q implements m {
    public static final a FYZ = new a((byte) 0);
    public n FYY;
    private i callback;
    private final d iUB;

    static {
        AppMethodBeat.i(216192);
        AppMethodBeat.o(216192);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f(String str, b bVar) {
        p.h(str, "statusId");
        AppMethodBeat.i(216191);
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/textstatusgetselflikeds");
        aVar.c(new com.tencent.mm.plugin.textstatus.g.m());
        aVar.d(new n());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsReq");
            AppMethodBeat.o(216191);
            throw tVar;
        }
        com.tencent.mm.plugin.textstatus.g.m mVar = (com.tencent.mm.plugin.textstatus.g.m) aYJ;
        mVar.Gas = str;
        mVar.GaF = bVar;
        AppMethodBeat.o(216191);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6621;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(216189);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(216189);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(216190);
        p.h(sVar, "rr");
        Log.i("MicroMsg.TxtStatus.NetSceneTextStatusGetSelfLikeds", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsResp");
                AppMethodBeat.o(216190);
                throw tVar;
            }
            this.FYY = (n) aYK;
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(216190);
            return;
        }
        AppMethodBeat.o(216190);
    }
}
