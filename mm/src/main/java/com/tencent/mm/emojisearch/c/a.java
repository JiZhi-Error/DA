package com.tencent.mm.emojisearch.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u000bH\u0016J>\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/emojisearch/model/NetSceneSearchEmoji;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getEmojiSearchList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "getSessionId", "", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-emojisdk_release"})
public final class a extends q implements m {
    public static final C0342a her = new C0342a((byte) 0);
    private i heq;
    public final d rr;

    static {
        AppMethodBeat.i(200029);
        AppMethodBeat.o(200029);
    }

    public a(SimilarEmojiQueryModel similarEmojiQueryModel) {
        p.h(similarEmojiQueryModel, "model");
        AppMethodBeat.i(200028);
        d.a aVar = new d.a();
        aVar.c(new dlc());
        aVar.d(new dld());
        aVar.MB("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
        aVar.sG(3793);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
            AppMethodBeat.o(200028);
            throw tVar;
        }
        ((dlc) aYJ).KXA = similarEmojiQueryModel.query;
        com.tencent.mm.bw.a aYJ2 = this.rr.aYJ();
        if (aYJ2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
            AppMethodBeat.o(200028);
            throw tVar2;
        }
        ((dlc) aYJ2).MOZ = similarEmojiQueryModel.NJk;
        com.tencent.mm.bw.a aYJ3 = this.rr.aYJ();
        if (aYJ3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
            AppMethodBeat.o(200028);
            throw tVar3;
        }
        ((dlc) aYJ3).SessionId = String.valueOf(similarEmojiQueryModel.timestamp);
        com.tencent.mm.bw.a aYJ4 = this.rr.aYJ();
        if (aYJ4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
            AppMethodBeat.o(200028);
            throw tVar4;
        }
        ((dlc) aYJ4).LXC = similarEmojiQueryModel.NJl;
        com.tencent.mm.bw.a aYJ5 = this.rr.aYJ();
        if (aYJ5 == null) {
            t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
            AppMethodBeat.o(200028);
            throw tVar5;
        }
        ((dlc) aYJ5).Scene = similarEmojiQueryModel.scene;
        AppMethodBeat.o(200028);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/emojisearch/model/NetSceneSearchEmoji$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emojisearch.c.a$a  reason: collision with other inner class name */
    public static final class C0342a {
        private C0342a() {
        }

        public /* synthetic */ C0342a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3793;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(200026);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(200026);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(200027);
        i iVar = this.heq;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(200027);
            return;
        }
        AppMethodBeat.o(200027);
    }
}
