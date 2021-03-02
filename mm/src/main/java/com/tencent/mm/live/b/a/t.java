package com.tencent.mm.live.b.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dly;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0016\u001a\u00020\u0012H\u0016J>\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "liveMicId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class t extends q implements m {
    public static final a hKE = new a((byte) 0);
    private i callback;
    private d hJu;
    private dly hKC;
    public dlz hKD;

    static {
        AppMethodBeat.i(207817);
        AppMethodBeat.o(207817);
    }

    public t(long j2, String str, String str2) {
        p.h(str, "wechatRoomId");
        p.h(str2, "liveMicId");
        AppMethodBeat.i(207816);
        d.a aVar = new d.a();
        aVar.c(new dly());
        aVar.d(new dlz());
        aVar.sG(760);
        aVar.MB("/cgi-bin/micromsg-bin/refreshlivemic");
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        com.tencent.mm.bw.a aYJ = this.hJu.aYJ();
        if (aYJ == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicRequest");
            AppMethodBeat.o(207816);
            throw tVar;
        }
        this.hKC = (dly) aYJ;
        this.hKC.hyH = j2;
        this.hKC.KDQ = str;
        this.hKC.KDS = str2;
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "liveId:" + j2 + ", wechatRoomId:" + str + ", liveMicId:" + str2);
        AppMethodBeat.o(207816);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 760;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(207814);
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(207814);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(207815);
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        if (sVar == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(207815);
            throw tVar;
        }
        com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
        if (aYK == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicResponse");
            AppMethodBeat.o(207815);
            throw tVar2;
        }
        this.hKD = (dlz) aYK;
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd error");
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(207815);
            return;
        }
        AppMethodBeat.o(207815);
    }
}
