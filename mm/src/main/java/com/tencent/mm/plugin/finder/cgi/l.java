package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.preload.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J4\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedListScene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "getRelatedListScene", "()I", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class l extends an<atp> {
    private final String TAG = "Finder.CgiFinderGetFeedRelList";
    private final long feedId;
    private final String hwg;
    private d rr;
    private ato tta = new ato();
    private final int ttb = 5;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(long j2, String str, bbn bbn) {
        super(bbn);
        p.h(str, "nonceId");
        AppMethodBeat.i(242224);
        this.feedId = j2;
        this.hwg = str;
        ato ato = this.tta;
        am amVar = am.tuw;
        ato.LAI = am.a(bbn);
        this.tta.hFK = this.feedId;
        this.tta.objectNonceId = this.hwg;
        this.tta.scene = this.ttb;
        d.a aVar = new d.a();
        aVar.c(this.tta);
        atp atp = new atp();
        atp.setBaseResponse(new BaseResponse());
        atp.getBaseResponse().ErrMsg = new dqi();
        aVar.d(atp);
        aVar.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
        aVar.sG(3688);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        c(this.rr);
        Log.i(this.TAG, "init feedId:" + this.feedId + ", relatedListScene:" + this.ttb);
        AppMethodBeat.o(242224);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, atp atp, q qVar) {
        AppMethodBeat.i(242223);
        atp atp2 = atp;
        p.h(atp2, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ' ');
        if (i2 == 0 && i3 == 0) {
            a aVar = a.uTO;
            baw baw = atp2.preloadInfo;
            LinkedList<FinderObject> linkedList = atp2.object;
            p.g(linkedList, "resp.`object`");
            a.a(baw, linkedList, 3688);
            String str2 = atp2.LAH;
            if (str2 == null) {
                str2 = "";
            }
            p.g(str2, "resp.relatedStreamWording ?: \"\"");
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_FAV_SIMILAR_WORDING_STRING_SYNC, str2);
        }
        AppMethodBeat.o(242223);
    }
}
