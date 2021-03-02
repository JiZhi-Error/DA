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
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.protocal.protobuf.ffx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eBC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0016\u001a\u00020\u0017H\u0002J4\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0011\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ae extends k<ffx> {
    private final String TAG = "Finder.CgiFinderApplyLiveMicPk";
    private ffw UKN = new ffw();
    private final a UKO;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, ffx ffx);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae(long j2, long j3, String str, byte[] bArr, int i2, aut aut, a aVar) {
        super((byte) 0);
        p.h(aut, "msg");
        AppMethodBeat.i(260506);
        this.UKO = aVar;
        this.UKN.hyH = j2;
        ffw ffw = this.UKN;
        am amVar = am.tuw;
        ffw.LBM = am.cXY();
        this.UKN.object_id = j3;
        this.UKN.object_nonce_id = str;
        this.UKN.LAt = z.aUg();
        this.UKN.scene = i2;
        this.UKN.LFp = b.cD(bArr);
        this.UKN.uio = aut;
        Log.i(this.TAG, "apply live id:" + j2 + " objectId:" + j3 + " objectNonceId:" + str);
        d.a aVar2 = new d.a();
        aVar2.c(this.UKN);
        ffx ffx = new ffx();
        ffx.setBaseResponse(new BaseResponse());
        ffx.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(ffx);
        aVar2.MB("/cgi-bin/micromsg-bin/finderapplylivemic");
        aVar2.sG(3917);
        c(aVar2.aXF());
        AppMethodBeat.o(260506);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(260505);
        ffx ffx = (ffx) dpc;
        p.h(ffx, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.UKO;
        if (aVar != null) {
            aVar.a(i2, i3, str, ffx);
            AppMethodBeat.o(260505);
            return;
        }
        AppMethodBeat.o(260505);
    }
}
