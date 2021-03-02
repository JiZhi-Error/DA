package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B_\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0017\u001a\u00020\u0018H\u0002J4\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0012\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "liveId", "", "objectId", "rewardProductId", "", "rewardProductCount", "", ch.COL_USERNAME, "wecoin", "requestId", "comboId", "sendGiftTargetUserName", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "(JJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class v extends k<axc> {
    private final String TAG = "Finder.CgiFinderLiveReward";
    private axb ulp = new axb();
    private final a ulq;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, axc axc);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(long j2, long j3, String str, int i2, String str2, int i3, String str3, String str4, String str5, a aVar) {
        super((byte) 0);
        p.h(str5, "sendGiftTargetUserName");
        AppMethodBeat.i(260522);
        this.ulq = aVar;
        int i4 = i3 * i2;
        axb axb = this.ulp;
        am amVar = am.tuw;
        axb.LBM = am.cXY();
        this.ulp.hyH = j2;
        this.ulp.object_id = j3;
        this.ulp.LFM = str;
        this.ulp.LFQ = i2;
        this.ulp.LFR = i4;
        this.ulp.LAt = str2;
        this.ulp.request_id = str3;
        this.ulp.LFP = str4;
        this.ulp.Vjq = str5;
        String str6 = this.TAG;
        StringBuilder append = new StringBuilder("liveId:").append(j2).append(" objectId:").append(j3).append(" rewardProductId:").append(str).append(" rewardProductCount:").append(i2).append(" fromUser:").append(str2).append(" toUser:").append(str5).append(" requestId:").append(str3).append(" wecoin:").append(i3).append(",amountPrice:").append(i4).append(",live_identity:");
        aov aov = this.ulp.LBM;
        Log.i(str6, append.append(aov != null ? Integer.valueOf(aov.Viq) : null).toString());
        d.a aVar2 = new d.a();
        aVar2.c(this.ulp);
        axc axc = new axc();
        axc.setBaseResponse(new BaseResponse());
        axc.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(axc);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivereward");
        aVar2.sG(5891);
        c(aVar2.aXF());
        AppMethodBeat.o(260522);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246341);
        axc axc = (axc) dpc;
        p.h(axc, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.ulq;
        if (aVar != null) {
            aVar.a(i2, i3, str, axc);
            AppMethodBeat.o(246341);
            return;
        }
        AppMethodBeat.o(246341);
    }
}
