package com.tencent.mm.plugin.finder.cgi;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class p extends an<aup> {
    private static long ttl;
    public static final a ttm = new a((byte) 0);
    private final String TAG = "Finder.CgiFinderLikeComment";
    private auo ttj;
    private final com.tencent.mm.plugin.finder.upload.action.l ttk;

    static {
        AppMethodBeat.i(165168);
        AppMethodBeat.o(165168);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(com.tencent.mm.plugin.finder.upload.action.l lVar, bbn bbn) {
        super(bbn);
        long j2;
        int i2;
        kotlin.g.b.p.h(lVar, NativeProtocol.WEB_DIALOG_ACTION);
        AppMethodBeat.i(242234);
        this.ttk = lVar;
        long aWz = cl.aWz();
        if (aWz < ttl) {
            aWz = ttl;
            ttl = 1 + aWz;
        }
        ttl = aWz;
        this.ttj = new auo();
        auo auo = this.ttj;
        c cVar = c.vCb;
        if (c.drg()) {
            j2 = 0;
        } else {
            j2 = this.ttk.feedId;
        }
        auo.hFK = j2;
        this.ttj.objectNonceId = this.ttk.objectNonceId;
        this.ttj.commentId = this.ttk.vUB.dyb().commentId;
        this.ttj.tsR = aWz;
        if (this.ttk.scene == 1) {
            this.ttj.username = z.aUg();
        }
        auo auo2 = this.ttj;
        am amVar = am.tuw;
        auo2.uli = am.a(bbn);
        this.ttj.scene = this.ttk.scene;
        this.ttj.opType = this.ttk.vUr ? 1 : 2;
        auo auo3 = this.ttj;
        k kVar = k.vfA;
        long j3 = this.ttk.feedId;
        aov aov = this.ttj.uli;
        if (aov != null) {
            i2 = aov.scene;
        } else {
            i2 = 0;
        }
        auo3.sessionBuffer = k.G(j3, i2);
        d.a aVar = new d.a();
        aVar.c(this.ttj);
        aup aup = new aup();
        aup.setBaseResponse(new BaseResponse());
        aup.getBaseResponse().ErrMsg = new dqi();
        aVar.d(aup);
        aVar.MB("/cgi-bin/micromsg-bin/finderlike");
        aVar.sG(3710);
        c(aVar.aXF());
        Log.i(this.TAG, "CgiFinderLikeComment init " + this.ttj.hFK + " and userName " + this.ttj.username + " comment:" + this.ttk.vUB);
        AppMethodBeat.o(242234);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, aup aup, q qVar) {
        AppMethodBeat.i(242233);
        kotlin.g.b.p.h(aup, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.v(i2, i3, str);
        com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.w(i2, i3, MMApplicationContext.getContext().getString(R.string.cpw));
        com.tencent.mm.plugin.finder.spam.a aVar3 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.x(i2, i3, MMApplicationContext.getContext().getString(R.string.cpv));
        AppMethodBeat.o(242233);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment$Companion;", "", "()V", "GlobalLikeCommentId", "", "getGlobalLikeCommentId", "()J", "setGlobalLikeCommentId", "(J)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
