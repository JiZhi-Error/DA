package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J4\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0011\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class d extends k<avm> {
    private final String TAG = "Finder.CgiFinderCloseLiveMic";
    private avl ukA = new avl();
    private final a ukB;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder_release"})
    public interface a {
        void onCgiBack(int i2, int i3, String str, avm avm);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(long j2, long j3, String str, byte[] bArr, int i2, aut aut, a aVar) {
        super((byte) 0);
        p.h(aut, "msg");
        AppMethodBeat.i(246301);
        this.ukB = aVar;
        this.ukA.hyH = j2;
        avl avl = this.ukA;
        am amVar = am.tuw;
        avl.LBM = am.cXY();
        this.ukA.object_id = j3;
        this.ukA.object_nonce_id = str;
        this.ukA.LAt = z.aUg();
        this.ukA.scene = i2;
        this.ukA.LFp = b.cD(bArr);
        this.ukA.uio = aut;
        d.a aVar2 = new d.a();
        aVar2.c(this.ukA);
        avm avm = new avm();
        avm.setBaseResponse(new BaseResponse());
        avm.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(avm);
        aVar2.MB("/cgi-bin/micromsg-bin/finderliveclosemicwithaudience");
        aVar2.sG(4142);
        com.tencent.mm.ak.d aXF = aVar2.aXF();
        Log.i(this.TAG, "liveId:" + this.ukA.hyH + " objectId:" + this.ukA.object_id + " objectNonceId:" + this.ukA.object_nonce_id + " scene:" + this.ukA.scene);
        c(aXF);
        AppMethodBeat.o(246301);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246300);
        avm avm = (avm) dpc;
        p.h(avm, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.ukB;
        if (aVar != null) {
            aVar.onCgiBack(i2, i3, str, avm);
            AppMethodBeat.o(246300);
            return;
        }
        AppMethodBeat.o(246300);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
    }
}
