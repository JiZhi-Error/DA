package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "liveId", "", "objectId", ch.COL_USERNAME, "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "", "requestId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class q extends k<awc> {
    private final String TAG = "Finder.CgiFinderLiveGetShoppingList";
    private a uld;
    private awb ule;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, awc awc);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(long j2, long j3, String str, b bVar, int i2, String str2, a aVar) {
        super((byte) 0);
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "requestId");
        p.h(aVar, "callback");
        AppMethodBeat.i(246330);
        this.uld = aVar;
        this.ule = new awb();
        this.ule.liveId = j2;
        this.ule.hFK = j3;
        this.ule.finderUsername = str;
        this.ule.scene = i2;
        this.ule.tVM = bVar;
        this.ule.LGw = str2;
        awb awb = this.ule;
        am amVar = am.tuw;
        awb.LAI = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.ule);
        awc awc = new awc();
        awc.setBaseResponse(new BaseResponse());
        awc.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(awc);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivegetshopwindowproduct");
        aVar2.sG(4254);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderLiveGetShoppingList init " + this.ule.liveId + ',' + this.ule.finderUsername);
        AppMethodBeat.o(246330);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(246329);
        awc awc = (awc) dpc;
        p.h(awc, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            Log.i(this.TAG, "shopping list result:" + g.bN(awc));
        }
        this.uld.a(i2, i3, str, awc);
        AppMethodBeat.o(246329);
    }
}
