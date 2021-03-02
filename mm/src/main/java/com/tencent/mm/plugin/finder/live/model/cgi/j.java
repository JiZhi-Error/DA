package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u001d\u001a\u00020\u001eH\u0002J4\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010#\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0013\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveCookie", "", "liveId", "", "count", "", "objectId", "scene", "nonceId", "", "finderUsername", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;[BJIJILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "getCount", "()I", "getLiveId", "()J", "getObjectId", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class j extends k<aun> {
    private final String TAG = "Finder.CgiFinderLikeLive";
    private final int count;
    private final long hFK;
    private final long liveId;
    private aum ukM = new aum();
    private final a ukN;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, aun aun);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(aov aov, byte[] bArr, long j2, int i2, long j3, String str, String str2, a aVar) {
        super((byte) 0);
        boolean z;
        Integer num;
        p.h(aov, "finderBaseRequest");
        p.h(str, "nonceId");
        p.h(str2, "finderUsername");
        AppMethodBeat.i(260512);
        this.liveId = j2;
        this.count = i2;
        this.hFK = j3;
        this.ukN = aVar;
        this.ukM.LBM = aov;
        this.ukM.hyH = this.liveId;
        this.ukM.LFp = b.cD(bArr);
        this.ukM.object_id = this.hFK;
        this.ukM.seq = 0;
        this.ukM.LFq = 0;
        aum aum = this.ukM;
        y yVar = y.vXH;
        aum.LFr = y.dCV();
        this.ukM.count = (long) this.count;
        this.ukM.scene = 1;
        this.ukM.object_nonce_id = str;
        this.ukM.LAt = str2;
        d.a aVar2 = new d.a();
        aVar2.c(this.ukM);
        aun aun = new aun();
        aun.setBaseResponse(new BaseResponse());
        aun.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(aun);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlikelive");
        aVar2.sG(564);
        c(aVar2.aXF());
        String str3 = this.TAG;
        StringBuilder append = new StringBuilder("[likeInfo]like live id:").append(this.liveId).append(" objectId:").append(this.hFK).append(" count:").append(this.count).append(",finder_username is empty:");
        if (this.ukM.LAt == null) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder append2 = append.append(z).append(",live_identity:");
        aov aov2 = this.ukM.LBM;
        if (aov2 != null) {
            num = Integer.valueOf(aov2.Viq);
        } else {
            num = null;
        }
        Log.i(str3, append2.append(num).toString());
        AppMethodBeat.o(260512);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246316);
        aun aun = (aun) dpc;
        p.h(aun, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.ukN;
        if (aVar != null) {
            aVar.a(i2, i3, aun);
            AppMethodBeat.o(246316);
            return;
        }
        AppMethodBeat.o(246316);
    }
}
