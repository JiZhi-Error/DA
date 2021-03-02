package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductResponse;", "liveId", "", "objectId", "audienceUsername", "", "productId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;", "(JJLjava/lang/String;JILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class r extends k<awp> {
    private final String TAG = "Finder.CgiFinderLiveModifyProduct";
    private a ulf;
    private awo ulg;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, awp awp);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(long j2, long j3, String str, long j4, int i2, a aVar) {
        super((byte) 0);
        p.h(str, "audienceUsername");
        p.h(aVar, "callback");
        AppMethodBeat.i(246332);
        this.ulf = aVar;
        this.ulg = new awo();
        this.ulg.liveId = j2;
        this.ulg.hFK = j3;
        this.ulg.finderUsername = str;
        this.ulg.uko = j4;
        this.ulg.scene = i2;
        awo awo = this.ulg;
        am amVar = am.tuw;
        awo.LAI = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.ulg);
        awp awp = new awp();
        awp.setBaseResponse(new BaseResponse());
        awp.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(awp);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivemodshopwindowproduct");
        aVar2.sG(6699);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderLiveModifyProduct init " + this.ulg.liveId + ',' + this.ulg.finderUsername);
        AppMethodBeat.o(246332);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246331);
        awp awp = (awp) dpc;
        p.h(awp, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        this.ulf.a(i2, i3, awp);
        AppMethodBeat.o(246331);
    }
}
