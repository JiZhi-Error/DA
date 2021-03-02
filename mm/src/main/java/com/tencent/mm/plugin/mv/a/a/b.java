package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\b\u0010\u001b\u001a\u00020\u0017H\u0016J>\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderFeedId", "", "finderNonceId", "", "likeIt", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderFeedId", "()J", "getFinderNonceId", "()Ljava/lang/String;", "likeId", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class b extends m {
    public static final a Aqs = new a((byte) 0);
    private static long tsS;
    private aup Aqp;
    private final long Aqq;
    private final String Aqr;
    private i callback;
    private final d iUB;
    private long tsR = cl.aWz();
    private auo ttj;

    static {
        AppMethodBeat.i(256818);
        AppMethodBeat.o(256818);
    }

    public b(long j2, String str, boolean z) {
        p.h(str, "finderNonceId");
        AppMethodBeat.i(256817);
        this.Aqq = j2;
        this.Aqr = str;
        d.a aVar = new d.a();
        aVar.sG(3710);
        aVar.MB("/cgi-bin/micromsg-bin/finderlike");
        aVar.c(new auo());
        aVar.d(new aup());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        if (this.tsR < tsS) {
            long j3 = tsS;
            tsS = 1 + j3;
            this.tsR = j3;
        }
        tsS = this.tsR;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeRequest");
            AppMethodBeat.o(256817);
            throw tVar;
        }
        this.ttj = (auo) aYJ;
        auo auo = this.ttj;
        if (auo != null) {
            auo.hFK = this.Aqq;
        }
        auo auo2 = this.ttj;
        if (auo2 != null) {
            auo2.commentId = 0;
        }
        auo auo3 = this.ttj;
        if (auo3 != null) {
            auo3.opType = z ? 3 : 4;
        }
        auo auo4 = this.ttj;
        if (auo4 != null) {
            auo4.tsR = this.tsR;
        }
        auo auo5 = this.ttj;
        if (auo5 != null) {
            auo5.LFu = z.aUg();
        }
        auo auo6 = this.ttj;
        if (auo6 != null) {
            auo6.scene = 91;
        }
        auo auo7 = this.ttj;
        if (auo7 != null) {
            auo7.objectNonceId = this.Aqr;
        }
        auo auo8 = this.ttj;
        if (auo8 != null) {
            auo8.LFu = "";
        }
        auo auo9 = this.ttj;
        if (auo9 != null) {
            auo9.vkk = 0;
        }
        auo auo10 = this.ttj;
        if (auo10 != null) {
            auo10.uFa = 0;
        }
        aov aov = new aov();
        aov.scene = 91;
        aov.LAS = 1;
        auo auo11 = this.ttj;
        if (auo11 != null) {
            auo11.uli = aov;
        }
        auo auo12 = this.ttj;
        if (auo12 != null) {
            k kVar = k.vfA;
            auo12.sessionBuffer = k.G(this.Aqq, 91);
            AppMethodBeat.o(256817);
            return;
        }
        AppMethodBeat.o(256817);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3710;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256815);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256815);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256816);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i("MicroMsg.Mv.NetSceneMusicMvMVFinderLike", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeResponse");
                AppMethodBeat.o(256816);
                throw tVar;
            }
            this.Aqp = (aup) aYK;
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
            }
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            com.tencent.mm.plugin.finder.spam.a.v(i3, i4, str);
            com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
            com.tencent.mm.plugin.finder.spam.a.w(i3, i4, MMApplicationContext.getContext().getString(R.string.cpw));
            com.tencent.mm.plugin.finder.spam.a aVar3 = com.tencent.mm.plugin.finder.spam.a.vwk;
            com.tencent.mm.plugin.finder.spam.a.x(i3, i4, MMApplicationContext.getContext().getString(R.string.cpv));
            AppMethodBeat.o(256816);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256816);
            return;
        }
        AppMethodBeat.o(256816);
    }
}
