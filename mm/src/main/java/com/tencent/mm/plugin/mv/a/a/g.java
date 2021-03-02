package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016J\r\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eJ\r\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0014J\b\u0010\u0019\u001a\u00020\u0010H\u0016J>\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "()Ljava/lang/Integer;", "getMegaVideoCount", "getNoMoreWording", "getResponse", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class g extends m {
    public static final a AqI = new a((byte) 0);
    private asn AqG;
    public aso AqH;
    private i callback;
    private final d iUB;

    static {
        AppMethodBeat.i(256838);
        AppMethodBeat.o(256838);
    }

    public g(String str, b bVar) {
        p.h(str, "finderUserName");
        AppMethodBeat.i(256837);
        d.a aVar = new d.a();
        aVar.sG(3965);
        aVar.MB("/cgi-bin/micromsg-bin/findergetlikedlist");
        aVar.c(new asn());
        aVar.d(new aso());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListRequest");
            AppMethodBeat.o(256837);
            throw tVar;
        }
        this.AqG = (asn) aYJ;
        asn asn = this.AqG;
        if (asn != null) {
            asn.LDu = 0;
        }
        asn asn2 = this.AqG;
        if (asn2 != null) {
            asn2.LAt = str;
        }
        asn asn3 = this.AqG;
        if (asn3 != null) {
            asn3.lastBuffer = bVar;
        }
        asn asn4 = this.AqG;
        if (asn4 != null) {
            asn4.tvp = "";
        }
        asn asn5 = this.AqG;
        if (asn5 != null) {
            asn5.dLS = 0;
        }
        asn asn6 = this.AqG;
        if (asn6 != null) {
            aov aov = new aov();
            aov.scene = 93;
            asn6.uli = aov;
            AppMethodBeat.o(256837);
            return;
        }
        AppMethodBeat.o(256837);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3965;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(256835);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256835);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256836);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i("MicroMsg.Mv.NetSceneMusicMvGetFinderLikeFeed", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
                AppMethodBeat.o(256836);
                throw tVar;
            }
            this.AqH = (aso) aYK;
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256836);
                return;
            }
            AppMethodBeat.o(256836);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256836);
            return;
        }
        AppMethodBeat.o(256836);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
