package com.tencent.mm.live.b.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.iy;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J>\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableComment", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class i extends q implements m {
    public static final a hJX = new a((byte) 0);
    private com.tencent.mm.ak.i callback;
    private iy hJV;
    private iz hJW;
    private d hJu;

    static {
        AppMethodBeat.i(207773);
        AppMethodBeat.o(207773);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public i(long j2, String str, boolean z) {
        p.h(str, "wechatRoomId");
        AppMethodBeat.i(207772);
        d.a aVar = new d.a();
        aVar.c(new iy());
        aVar.d(new iz());
        aVar.sG(3664);
        aVar.MB("/cgi-bin/micromsg-bin/banlivecomment");
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        com.tencent.mm.bw.a aYJ = this.hJu.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentRequest");
            AppMethodBeat.o(207772);
            throw tVar;
        }
        this.hJV = (iy) aYJ;
        iy iyVar = this.hJV;
        if (iyVar != null) {
            iyVar.hyH = j2;
        }
        iy iyVar2 = this.hJV;
        if (iyVar2 != null) {
            iyVar2.KDQ = str;
        }
        iy iyVar3 = this.hJV;
        if (iyVar3 != null) {
            iyVar3.KNv = z;
        }
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "BanLiveComment liveId:" + j2 + ", roomId:" + str + ", enableComment:" + z + ' ');
        AppMethodBeat.o(207772);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3664;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(207770);
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(207770);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(207771);
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(207771);
            throw tVar;
        }
        com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
        if (aYK == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentResponse");
            AppMethodBeat.o(207771);
            throw tVar2;
        }
        this.hJW = (iz) aYK;
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd error");
        }
        com.tencent.mm.ak.i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(207771);
            return;
        }
        AppMethodBeat.o(207771);
    }
}
