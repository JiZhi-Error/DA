package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J4\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u000f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveId", "", "finderUsername", "", "objectId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;JLjava/lang/String;JILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class y extends k<asu> {
    private final String TAG = "Finder.CgiFinderOnlineMember";
    private ast ulu = new ast();
    private final a ulv;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, asu asu);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(aov aov, long j2, String str, long j3, a aVar) {
        super((byte) 0);
        p.h(aov, "finderBaseRequest");
        p.h(str, "finderUsername");
        AppMethodBeat.i(246348);
        this.ulv = aVar;
        this.ulu.LAI = aov;
        this.ulu.liveId = j2;
        this.ulu.finderUsername = str;
        this.ulu.hFK = j3;
        this.ulu.scene = 2;
        d.a aVar2 = new d.a();
        aVar2.c(this.ulu);
        asu asu = new asu();
        asu.setBaseResponse(new BaseResponse());
        asu.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(asu);
        aVar2.MB("/cgi-bin/micromsg-bin/findergetliveonlinemember");
        aVar2.sG(3603);
        c(aVar2.aXF());
        Log.i(this.TAG, "[initReqResp] liveId =" + this.ulu.liveId + " finderUsername=" + this.ulu.finderUsername + " scene=" + this.ulu.scene);
        AppMethodBeat.o(246348);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246347);
        asu asu = (asu) dpc;
        p.h(asu, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.ulv;
        if (aVar != null) {
            aVar.a(i2, i3, str, asu);
            AppMethodBeat.o(246347);
            return;
        }
        AppMethodBeat.o(246347);
    }
}
