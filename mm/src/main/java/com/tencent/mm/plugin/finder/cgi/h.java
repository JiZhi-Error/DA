package com.tencent.mm.plugin.finder.cgi;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.upload.action.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J4\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class h extends an<aqu> {
    private static long tsS;
    public static final a tsT = new a((byte) 0);
    private final String TAG = "Finder.CgiFinderFavFeed";
    private final b tsI;
    private aqt tsQ;
    private long tsR = cl.aWz();

    static {
        AppMethodBeat.i(242214);
        AppMethodBeat.o(242214);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(b bVar, bbn bbn) {
        super(bbn);
        long j2;
        int i2;
        p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        AppMethodBeat.i(242213);
        this.tsI = bVar;
        if (this.tsR < tsS) {
            long j3 = tsS;
            tsS = 1 + j3;
            this.tsR = j3;
        }
        tsS = this.tsR;
        this.tsQ = new aqt();
        aqt aqt = this.tsQ;
        c cVar = c.vCb;
        if (c.drg()) {
            j2 = 0;
        } else {
            j2 = this.tsI.feedId;
        }
        aqt.hFK = j2;
        this.tsQ.objectNonceId = this.tsI.objectNonceId;
        this.tsQ.tal = this.tsR;
        this.tsQ.finderUsername = z.aUg();
        this.tsQ.dYx = this.tsI.vTT ? 1 : 2;
        aqt aqt2 = this.tsQ;
        am amVar = am.tuw;
        aqt2.LAI = am.a(bbn);
        aqt aqt3 = this.tsQ;
        k kVar = k.vfA;
        long j4 = this.tsI.feedId;
        if (bbn != null) {
            i2 = bbn.tCE;
        } else {
            i2 = 0;
        }
        aqt3.sessionBuffer = k.G(j4, i2);
        Log.i(this.TAG, "likeId:" + this.tsR + " objectId:" + this.tsQ.hFK + " opType:" + this.tsQ.dYx + " likeId:" + this.tsQ.tal + " username:" + this.tsQ.finderUsername + " action:" + this.tsI.vTT);
        d.a aVar = new d.a();
        aVar.c(this.tsQ);
        aqu aqu = new aqu();
        aqu.setBaseResponse(new BaseResponse());
        aqu.getBaseResponse().ErrMsg = new dqi();
        aVar.d(aqu);
        aVar.MB("/cgi-bin/micromsg-bin/finderfav");
        aVar.sG(3715);
        c(aVar.aXF());
        Log.i(this.TAG, "likeId:" + this.tsR + " CgiFinderLikeComment init " + this.tsQ.hFK + " and userName " + this.tsI.vTS.getUserName() + " nickname " + this.tsI.vTS.getNickName() + " totalCount:" + this.tsI.vTS.getLikeCount());
        AppMethodBeat.o(242213);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, aqu aqu, q qVar) {
        AppMethodBeat.i(242212);
        p.h(aqu, "resp");
        Log.i(this.TAG, "likeId:" + this.tsR + " [onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + " objectId:" + this.tsQ.hFK + " opType:" + this.tsQ.dYx + " likeId:" + this.tsQ.tal + " username:" + this.tsQ.finderUsername + " action:" + this.tsI.vTT);
        AppMethodBeat.o(242212);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
