package com.tencent.mm.plugin.textstatus.f;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.o;
import com.tencent.mm.plugin.textstatus.g.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J<\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetTopicShowInfos;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicIDs", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosReq;", "getRequest", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class h extends q implements m {
    public static final a FZd = new a((byte) 0);
    public final o FZb;
    private p FZc;
    private i callback;
    private final d iUB;

    static {
        AppMethodBeat.i(216200);
        AppMethodBeat.o(216200);
    }

    public h(LinkedList<String> linkedList) {
        kotlin.g.b.p.h(linkedList, "topicIDs");
        AppMethodBeat.i(216199);
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/textstatusgettopicshowinfos");
        aVar.c(new o());
        aVar.d(new p());
        d aXF = aVar.aXF();
        kotlin.g.b.p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetTopicShowInfosReq");
            AppMethodBeat.o(216199);
            throw tVar;
        }
        this.FZb = (o) aYJ;
        this.FZb.GaL = linkedList;
        AppMethodBeat.o(216199);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6284;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(216197);
        kotlin.g.b.p.h(gVar, "dispatcher");
        kotlin.g.b.p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(216197);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(216198);
        kotlin.g.b.p.h(sVar, "rr");
        Log.i("MicroMsg.TxtStatus.NetSceneTextStatusGetTopicShowInfos", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        com.tencent.mm.bw.a aYK = this.iUB.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetTopicShowInfosResp");
            AppMethodBeat.o(216198);
            throw tVar;
        }
        this.FZc = (p) aYK;
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(216198);
            return;
        }
        AppMethodBeat.o(216198);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetTopicShowInfos$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
