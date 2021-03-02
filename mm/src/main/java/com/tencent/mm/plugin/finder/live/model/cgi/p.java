package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;)V", "TAG", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class p extends k<awa> {
    private final String TAG = "Finder.CgiFinderLiveGetProductDetail";
    private a ulb;
    private avz ulc;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, awa awa);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(g gVar, axg axg, a aVar) {
        super((byte) 0);
        kotlin.g.b.p.h(gVar, "liveData");
        kotlin.g.b.p.h(axg, "product");
        kotlin.g.b.p.h(aVar, "callback");
        AppMethodBeat.i(246328);
        this.ulb = aVar;
        this.ulc = new avz();
        this.ulc.hyH = gVar.liveInfo.liveId;
        this.ulc.object_id = gVar.hFK;
        this.ulc.object_nonce_id = gVar.hwg;
        this.ulc.LGv = axg.uko;
        this.ulc.LGw = gVar.dPI;
        avz avz = this.ulc;
        am amVar = am.tuw;
        avz.LAI = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.ulc);
        awa awa = new awa();
        awa.setBaseResponse(new BaseResponse());
        awa.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(awa);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivegetshopproductdetail");
        aVar2.sG(6211);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderLiveGetProductDetail init " + this.ulc.hyH + ',' + this.ulc.LGv);
        AppMethodBeat.o(246328);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246327);
        awa awa = (awa) dpc;
        kotlin.g.b.p.h(awa, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            Log.i(this.TAG, "result:" + com.tencent.mm.ac.g.bN(awa));
        }
        this.ulb.a(i2, i3, awa);
        AppMethodBeat.o(246327);
    }
}
