package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.fgs;
import com.tencent.mm.protocal.protobuf.fgt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010\u0011\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoResponse;", "liveId", "", "objectId", "nonceId", "", "liveCookies", "", "scene", "", "sendIdList", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "(JJLjava/lang/String;[BILjava/util/List;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder_release"})
public final class ai extends k<fgt> {
    public static final b UKY = new b((byte) 0);
    private final String TAG = "Finder.CgiFinderLiveGetRedPacketInfo";
    private fgs UKW = new fgs();
    private a UKX;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, fgt fgt);
    }

    static {
        AppMethodBeat.i(260520);
        AppMethodBeat.o(260520);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ai(long j2, long j3, String str, byte[] bArr, int i2, List<String> list, a aVar) {
        super((byte) 0);
        p.h(str, "nonceId");
        p.h(list, "sendIdList");
        AppMethodBeat.i(260519);
        this.UKX = aVar;
        this.UKW.hyH = j2;
        this.UKW.object_id = j3;
        this.UKW.object_nonce_id = str;
        fgs fgs = this.UKW;
        am amVar = am.tuw;
        fgs.LBM = am.cXY();
        this.UKW.LFp = com.tencent.mm.bw.b.cD(bArr);
        this.UKW.LAt = z.aUg();
        this.UKW.scene = i2;
        LinkedList<String> linkedList = this.UKW.Vjb;
        if (linkedList != null) {
            linkedList.addAll(list);
        }
        d.a aVar2 = new d.a();
        aVar2.c(this.UKW);
        fgt fgt = new fgt();
        fgt.setBaseResponse(new BaseResponse());
        fgt.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(fgt);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivegetredpacketinfo");
        aVar2.sG(6271);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderLiveGetRedPacketInfo, init liveId:" + this.UKW.hyH + ", objectId:" + this.UKW.object_id + ", nonceId:" + this.UKW.object_nonce_id + ", send_id_list:" + this.UKW.Vjb);
        AppMethodBeat.o(260519);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(260518);
        fgt fgt = (fgt) dpc;
        p.h(fgt, "resp");
        Log.i(this.TAG, "CgiFinderLiveGetRedPacketInfo [onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ",result:" + g.bN(fgt));
        a aVar = this.UKX;
        if (aVar != null) {
            aVar.a(i2, i3, fgt);
            AppMethodBeat.o(260518);
            return;
        }
        AppMethodBeat.o(260518);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$Companion;", "", "()V", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
    }
}
