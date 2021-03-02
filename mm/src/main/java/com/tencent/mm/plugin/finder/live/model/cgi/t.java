package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bBI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "liveId", "", "objectId", "audienceUsername", "", "productId", "promoteType", "", "adId", "scene", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "(JJLjava/lang/String;JIJILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class t extends k<aww> {
    private final String TAG = "Finder.CgiFinderLivePromoteProduct";
    private a ull;
    private awv ulm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, aww aww);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246337);
        aww aww = (aww) dpc;
        p.h(aww, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.ull;
        if (aVar != null) {
            aVar.a(i2, i3, str, aww);
            AppMethodBeat.o(246337);
            return;
        }
        AppMethodBeat.o(246337);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(long j2, long j3, String str, long j4, int i2, long j5, int i3, a aVar) {
        super((byte) 0);
        p.h(str, "audienceUsername");
        AppMethodBeat.i(260521);
        this.ull = aVar;
        this.ulm = new awv();
        this.ulm.liveId = j2;
        this.ulm.hFK = j3;
        this.ulm.finderUsername = str;
        this.ulm.uko = j4;
        this.ulm.scene = i3;
        this.ulm.Vjn = i2;
        this.ulm.UPE = j5;
        awv awv = this.ulm;
        am amVar = am.tuw;
        awv.LAI = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.ulm);
        aww aww = new aww();
        aww.setBaseResponse(new BaseResponse());
        aww.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(aww);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivepromoteproduct");
        aVar2.sG(5800);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderLivePromoteProduct init " + this.ulm.liveId + ',' + this.ulm.finderUsername);
        AppMethodBeat.o(260521);
    }
}
