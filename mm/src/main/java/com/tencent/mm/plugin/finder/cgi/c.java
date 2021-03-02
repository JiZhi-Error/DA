package com.tencent.mm.plugin.finder.cgi;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.upload.action.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnq;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavResp;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "favId", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class c extends an<cnr> {
    private static long tsJ;
    public static final a tsK = new a((byte) 0);
    private long tal = cl.aWz();
    private cnq tsH;
    private final b tsI;

    static {
        AppMethodBeat.i(242202);
        AppMethodBeat.o(242202);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(b bVar, bbn bbn) {
        super(bbn);
        long j2;
        p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(242201);
        this.tsI = bVar;
        if (this.tal < tsJ) {
            long j3 = tsJ;
            tsJ = 1 + j3;
            this.tal = j3;
        }
        tsJ = this.tal;
        this.tsH = new cnq();
        cnq cnq = this.tsH;
        ap apVar = ap.tuF;
        cnq.MtV = ap.b(bbn);
        this.tsH.dYx = this.tsI.vTT ? 1 : 2;
        this.tsH.tal = this.tal;
        cnq cnq2 = this.tsH;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drg()) {
            j2 = 0;
        } else {
            j2 = this.tsI.feedId;
        }
        cnq2.twG = j2;
        this.tsH.LOd = this.tsI.objectNonceId;
        Log.i("CgiFavMegaVideo", "favId:" + this.tal + " opType:" + this.tsH.dYx + " likeId:" + this.tsH.tal + " action:" + this.tsI.vTT);
        d.a aVar = new d.a();
        aVar.c(this.tsH);
        cnr cnr = new cnr();
        cnr.setBaseResponse(new BaseResponse());
        cnr.getBaseResponse().ErrMsg = new dqi();
        aVar.d(cnr);
        aVar.MB("/cgi-bin/micromsg-bin/megavideofav");
        aVar.sG(6655);
        c(aVar.aXF());
        Log.i("CgiFavMegaVideo", "favId:" + this.tal + " CgiFavMegaVideo init " + this.tsH.twG + " and userName " + this.tsI.vTS.getUserName() + " nickname " + this.tsI.vTS.getNickName() + " totalCount:" + this.tsI.vTS.getFavCount());
        AppMethodBeat.o(242201);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, cnr cnr, q qVar) {
        AppMethodBeat.i(242200);
        p.h(cnr, "resp");
        AppMethodBeat.o(242200);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo$Companion;", "", "()V", "GlobalFavFeedId", "", "getGlobalFavFeedId", "()J", "setGlobalFavFeedId", "(J)V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
