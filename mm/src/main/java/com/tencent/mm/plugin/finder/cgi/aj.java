package com.tencent.mm.plugin.finder.cgi;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeResponse;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class aj extends an<cob> {
    private static long tsS;
    public static final a tus = new a((byte) 0);
    private long tsR = cl.aWz();
    private final i ttn;
    private coa tur;

    static {
        AppMethodBeat.i(242315);
        AppMethodBeat.o(242315);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aj(i iVar, bbn bbn) {
        super(bbn);
        long j2;
        p.h(iVar, NativeProtocol.WEB_DIALOG_ACTION);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(242314);
        this.ttn = iVar;
        if (this.tsR < tsS) {
            long j3 = tsS;
            tsS = 1 + j3;
            this.tsR = j3;
        }
        tsS = this.tsR;
        this.tur = new coa();
        coa coa = this.tur;
        ap apVar = ap.tuF;
        coa.MtV = ap.b(bbn);
        this.tur.opType = this.ttn.vUr ? 1 : 2;
        this.tur.tsR = this.tsR;
        coa coa2 = this.tur;
        c cVar = c.vCb;
        if (c.drg()) {
            j2 = 0;
        } else {
            j2 = this.ttn.feedId;
        }
        coa2.twG = j2;
        this.tur.LOd = this.ttn.objectNonceId;
        Log.i("CgiLikeMegaVideo", "likeId:" + this.tsR + " opType:" + this.tur.opType + " likeId:" + this.tur.tsR + " action:" + this.ttn.vUr);
        d.a aVar = new d.a();
        aVar.c(this.tur);
        cob cob = new cob();
        cob.setBaseResponse(new BaseResponse());
        cob.getBaseResponse().ErrMsg = new dqi();
        aVar.d(cob);
        aVar.MB("/cgi-bin/micromsg-bin/megavideolike");
        aVar.sG(5232);
        c(aVar.aXF());
        Log.i("CgiLikeMegaVideo", "likeId:" + this.tsR + " CgiLikeMegaVideo init " + this.tur.twG + " and userName " + this.ttn.vTS.getUserName() + " nickname " + this.ttn.vTS.getNickName() + " totalCount:" + this.ttn.vTS.getLikeCount());
        AppMethodBeat.o(242314);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, cob cob, q qVar) {
        AppMethodBeat.i(242313);
        p.h(cob, "resp");
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.v(i2, i3, str);
        com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.w(i2, i3, MMApplicationContext.getContext().getString(R.string.cpw));
        com.tencent.mm.plugin.finder.spam.a aVar3 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.x(i2, i3, MMApplicationContext.getContext().getString(R.string.cpv));
        AppMethodBeat.o(242313);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
