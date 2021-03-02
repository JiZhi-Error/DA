package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.mv.a.b;
import com.tencent.mm.plugin.mv.a.c;
import com.tencent.mm.plugin.mv.a.h;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001d\u001a\u00020\u0007H\u0016J>\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFeedDetail;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "feedId", "", "nonceId", "", "musicMvHashCode", "", "pageHashCode", "(JLjava/lang/String;II)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedId", "()J", "getMusicMvHashCode", "()I", "getNonceId", "()Ljava/lang/String;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class f extends m {
    public ars Apk;
    private arr AqD;
    public final int AqE;
    private final String TAG = ("MicroMsg.NetSceneMusicMvGetFinderFeedDetail@" + hashCode());
    private i callback;
    private final long feedId;
    private final String hwg;
    private final d iUB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(long j2, String str, int i2, int i3) {
        super(i3);
        p.h(str, "nonceId");
        AppMethodBeat.i(259196);
        this.feedId = j2;
        this.hwg = str;
        this.AqE = i2;
        d.a aVar = new d.a();
        aVar.sG(3763);
        aVar.MB("/cgi-bin/micromsg-bin/findergetcommentdetail");
        aVar.c(new arr());
        aVar.d(new ars());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailRequest");
            AppMethodBeat.o(259196);
            throw tVar;
        }
        this.AqD = (arr) aYJ;
        arr arr = this.AqD;
        if (arr != null) {
            arr.hFK = this.feedId;
        }
        arr arr2 = this.AqD;
        if (arr2 != null) {
            arr2.objectNonceId = this.hwg;
        }
        arr arr3 = this.AqD;
        if (arr3 != null) {
            arr3.LDb = 1;
            AppMethodBeat.o(259196);
            return;
        }
        AppMethodBeat.o(259196);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3763;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256831);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256831);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256832);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailResponse");
                AppMethodBeat.o(256832);
                throw tVar;
            }
            this.Apk = (ars) aYK;
            ars ars = new ars();
            ars ars2 = this.Apk;
            ars.parseFrom(ars2 != null ? ars2.toByteArray() : null);
            h hVar = h.Aqi;
            long j2 = this.feedId;
            String str2 = this.hwg;
            p.h(str2, "nonceId");
            p.h(ars, "response");
            if (h.mxg) {
                long currentTicks = Util.currentTicks();
                Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putFinderFeedDetail, feedId:" + j2 + ", nonceId:" + str2 + ", response:" + ars.hashCode() + ",timestamp:" + currentTicks);
                h.Aqf.put(new c(j2, str2), new b(ars, currentTicks));
                hVar.Hs(currentTicks);
            }
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256832);
                return;
            }
            AppMethodBeat.o(256832);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256832);
            return;
        }
        AppMethodBeat.o(256832);
    }
}
