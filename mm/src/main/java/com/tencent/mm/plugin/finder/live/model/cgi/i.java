package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J4\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0011\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "role", "", "nonceId", "sessionBuffer", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;", "(J[BLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class i extends k<auf> {
    private final String TAG = "Finder.CgiFinderJoinLive";
    private final JSONObject ttQ;
    private final JSONObject tuL;
    private a ukK;
    private aue ukL;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, auf auf);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(long j2, byte[] bArr, String str, long j3, int i2, String str2, String str3, a aVar) {
        super((byte) 0);
        boolean z;
        p.h(aVar, "callback");
        AppMethodBeat.i(246315);
        this.ukK = aVar;
        this.ukL = new aue();
        this.ttQ = new JSONObject();
        this.tuL = new JSONObject();
        aue aue = this.ukL;
        am amVar = am.tuw;
        aue.LAI = am.cXY();
        this.ukL.liveId = j2;
        this.ukL.LDx = b.cD(bArr);
        this.ukL.finderUsername = str;
        this.ukL.hFK = j3;
        this.ukL.scene = i2;
        this.ukL.object_nonce_id = str2;
        this.ukL.LER = str3;
        this.tuL.put("liveId", j2);
        this.tuL.put("finderUsername", str);
        this.tuL.put("objectId", j3);
        this.tuL.put("scene", i2);
        d.a aVar2 = new d.a();
        aVar2.c(this.ukL);
        auf auf = new auf();
        auf.setBaseResponse(new BaseResponse());
        auf.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(auf);
        aVar2.MB("/cgi-bin/micromsg-bin/finderjoinlive");
        aVar2.sG(3539);
        c(aVar2.aXF());
        String str4 = this.TAG;
        StringBuilder append = new StringBuilder("CgiFinderJoinLive init ").append(this.ukL.liveId).append(',').append(this.ukL.finderUsername).append(',').append(this.ukL.scene).append(",liveCookies is null:");
        if (this.ukL.LDx == null) {
            z = true;
        } else {
            z = false;
        }
        Log.i(str4, append.append(z).append(", sessionBuffer:").append(this.ukL.LER).toString());
        AppMethodBeat.o(246315);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246314);
        auf auf = (auf) dpc;
        p.h(auf, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        this.ukK.a(i2, i3, str, auf);
        if (i2 == 0 && i3 == 0) {
            h.INSTANCE.F(this.ukO, 25);
            Log.i(this.TAG, "FinderJoinLiveResp:" + g.bN(auf));
        } else {
            h.INSTANCE.F(this.ukO, 26);
        }
        h.INSTANCE.F(this.ukO, 24);
        AppMethodBeat.o(246314);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
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
