package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J4\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u000b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "liveId", "", "objectId", "nonceId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class x extends k<ayd> {
    private final String TAG = "Finder.CgiFinderManualCloseLive";
    private final JSONObject ttQ;
    private final JSONObject tuL;
    private a uls;
    private ayc ult;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, ayd ayd);
    }

    public x(long j2, long j3, String str, a aVar) {
        super((byte) 0);
        AppMethodBeat.i(246346);
        this.uls = aVar;
        this.ult = new ayc();
        this.ttQ = new JSONObject();
        this.tuL = new JSONObject();
        this.ult.hyH = j2;
        this.ult.LAt = z.aUg();
        this.ult.object_id = j3;
        this.ult.object_nonce_id = str;
        this.ttQ.put("liveId", j2);
        this.ttQ.put(ch.COL_USERNAME, this.ult.LAt);
        this.ttQ.put("object_id", j3);
        d.a aVar2 = new d.a();
        aVar2.c(this.ult);
        ayd ayd = new ayd();
        ayd.setBaseResponse(new BaseResponse());
        ayd.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(ayd);
        aVar2.MB("/cgi-bin/micromsg-bin/findermanualcloselive");
        aVar2.sG(5857);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderManualCloseLive init liveId:" + this.ult.hyH + ", objectId:" + this.ult.object_id + ", nonceId:" + this.ult.object_nonce_id + ", finderUsername:" + this.ult.LAt);
        AppMethodBeat.o(246346);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246345);
        ayd ayd = (ayd) dpc;
        p.h(ayd, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            Log.i(this.TAG, "close live result:" + g.bN(ayd));
        }
        a aVar = this.uls;
        if (aVar != null) {
            aVar.a(i2, i3, str, ayd);
            AppMethodBeat.o(246345);
            return;
        }
        AppMethodBeat.o(246345);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final b cXS() {
        return b.Enable;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final JSONObject cXV() {
        return this.tuL;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final JSONObject cXW() {
        return this.ttQ;
    }
}
