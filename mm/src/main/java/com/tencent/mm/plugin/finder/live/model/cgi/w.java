package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J4\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveTopComment;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentResponse;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "TAG", "", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class w extends k<axn> {
    private final String TAG = "Finder.CgiFinderLiveTopComment";
    private g liveData;
    private awq uke;
    private axm ulr = new axm();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(g gVar, awq awq) {
        super((byte) 0);
        p.h(gVar, "liveData");
        p.h(awq, "msg");
        AppMethodBeat.i(246344);
        this.liveData = gVar;
        this.uke = awq;
        axm axm = this.ulr;
        am amVar = am.tuw;
        axm.LAI = am.cXY();
        this.ulr.liveId = this.liveData.liveInfo.liveId;
        this.ulr.hFK = this.liveData.hFK;
        this.ulr.fQY = this.uke.fQY;
        this.ulr.LDx = b.cD(this.liveData.hIt);
        this.ulr.seq = this.uke.seq;
        this.ulr.dYx = 0;
        this.ulr.LGk = d.Ga(this.liveData.hwg);
        this.ulr.finderUsername = this.liveData.hwd;
        this.ulr.LGs = this.liveData.hwg;
        d.a aVar = new d.a();
        aVar.c(this.ulr);
        axn axn = new axn();
        axn.setBaseResponse(new BaseResponse());
        aVar.d(axn);
        aVar.MB("/cgi-bin/micromsg-bin/finderlivetopcomment");
        aVar.sG(6295);
        c(aVar.aXF());
        Log.i(this.TAG, "CgiFinderLiveTopComment init " + this.ulr.liveId + ',' + this.liveData.hwd + ',' + this.uke.content);
        AppMethodBeat.o(246344);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246343);
        p.h((axn) dpc, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        AppMethodBeat.o(246343);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
    }
}
