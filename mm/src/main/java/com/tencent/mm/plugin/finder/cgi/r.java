package com.tencent.mm.plugin.finder.cgi;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J4\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class r extends an<aup> {
    private static long tsS;
    public static final a ttr = new a((byte) 0);
    private final String TAG = "Finder.CgiFinderLikeFriend";
    private long tsR = cl.aWz();
    private auo ttj;
    private final bfp ttp;
    private final aul ttq;

    static {
        AppMethodBeat.i(242239);
        AppMethodBeat.o(242239);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(bfp bfp, aul aul, bbn bbn) {
        super(bbn);
        int i2;
        p.h(bfp, NativeProtocol.WEB_DIALOG_ACTION);
        p.h(aul, "likeInfo");
        AppMethodBeat.i(242238);
        this.ttp = bfp;
        this.ttq = aul;
        if (this.tsR < tsS) {
            long j2 = tsS;
            tsS = 1 + j2;
            this.tsR = j2;
        }
        tsS = this.tsR;
        this.ttj = new auo();
        this.ttj.hFK = this.ttp.feedId;
        this.ttj.objectNonceId = this.ttp.objectNonceId;
        this.ttj.tsR = this.tsR;
        this.ttj.commentId = this.ttq.tsR;
        this.ttj.username = z.aUg();
        this.ttj.scene = this.ttp.scene;
        this.ttj.LFu = this.ttq.dMW;
        this.ttj.opType = this.ttq.likeFlag == 1 ? 5 : 6;
        auo auo = this.ttj;
        am amVar = am.tuw;
        auo.uli = am.a(bbn);
        auo auo2 = this.ttj;
        k kVar = k.vfA;
        long j3 = this.ttp.feedId;
        if (bbn != null) {
            i2 = bbn.tCE;
        } else {
            i2 = 0;
        }
        auo2.sessionBuffer = k.G(j3, i2);
        Log.i(this.TAG, "likeId:" + this.tsR + " objectId:" + this.ttj.hFK + " commentId：" + this.ttj.commentId + " opType:" + this.ttj.opType + " likeId:" + this.ttj.tsR + " username:" + this.ttj.username + " action:" + this.ttq.likeFlag);
        d.a aVar = new d.a();
        aVar.c(this.ttj);
        aup aup = new aup();
        aup.setBaseResponse(new BaseResponse());
        aup.getBaseResponse().ErrMsg = new dqi();
        aVar.d(aup);
        aVar.MB("/cgi-bin/micromsg-bin/finderlike");
        aVar.sG(3710);
        c(aVar.aXF());
        Log.i(this.TAG, "likeId:" + this.tsR + " CgiFinderLikeComment init " + this.ttj.hFK + ' ');
        AppMethodBeat.o(242238);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, aup aup, q qVar) {
        AppMethodBeat.i(242237);
        p.h(aup, "resp");
        Log.i(this.TAG, "likeId:" + this.tsR + " [onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + " objectId:" + this.ttj.hFK + " opType:" + this.ttj.opType + " likeId:" + this.ttj.tsR + " username:" + this.ttj.username + " action:" + this.ttq.likeFlag);
        AppMethodBeat.o(242237);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
