package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ffu;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dBE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J4\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "sessionId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ad extends k<ffv> {
    private final String TAG = "Finder.CgiFinderActivateLiveMic";
    private ffu UKL = new ffu();
    private final a UKM;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "plugin-finder_release"})
    public interface a {
        void a(ffv ffv);
    }

    public ad(long j2, long j3, String str, byte[] bArr, String str2, a aVar) {
        super((byte) 0);
        AppMethodBeat.i(260504);
        this.UKM = aVar;
        this.UKL.hyH = j2;
        ffu ffu = this.UKL;
        am amVar = am.tuw;
        ffu.LBM = am.cXY();
        this.UKL.object_id = j3;
        this.UKL.object_nonce_id = str;
        this.UKL.LAt = z.aUg();
        this.UKL.scene = 1;
        this.UKL.LFp = b.cD(bArr);
        this.UKL.KDS = str2;
        Log.i(this.TAG, "activate live mic id:" + j2 + " objectId:" + j3 + " objectNonceId:" + str + " sessionId:" + str2);
        d.a aVar2 = new d.a();
        aVar2.c(this.UKL);
        ffv ffv = new ffv();
        ffv.setBaseResponse(new BaseResponse());
        ffv.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(ffv);
        aVar2.MB("/cgi-bin/micromsg-bin/finderactivatelivemic");
        aVar2.sG(6802);
        c(aVar2.aXF());
        AppMethodBeat.o(260504);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(260503);
        ffv ffv = (ffv) dpc;
        p.h(ffv, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.UKM;
        if (aVar != null) {
            aVar.a(ffv);
            AppMethodBeat.o(260503);
            return;
        }
        AppMethodBeat.o(260503);
    }
}
