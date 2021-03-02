package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.jsapi.k.s;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J4\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "liveId", "", "finderUsername", "", "objectId", "nonceId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "(JLjava/lang/String;JLjava/lang/String;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class c extends k<ape> {
    private final String TAG = "Finder.CgiFinderCloseLive";
    private final JSONObject ttQ;
    private final JSONObject tuL;
    private a uky;
    private apd ukz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, ape ape);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(long j2, String str, long j3, String str2, int i2, a aVar) {
        super((byte) 0);
        p.h(str, "finderUsername");
        p.h(str2, "nonceId");
        p.h(aVar, "callback");
        AppMethodBeat.i(246299);
        this.uky = aVar;
        this.ukz = new apd();
        this.ttQ = new JSONObject();
        this.tuL = new JSONObject();
        this.ukz.liveId = j2;
        this.ukz.finderUsername = str;
        this.ukz.hFK = j3;
        this.ukz.LBj = str2;
        this.ukz.scene = i2;
        this.tuL.put("liveId", j2);
        this.tuL.put("objectId", j3);
        this.ttQ.put(ch.COL_USERNAME, this.ukz.finderUsername);
        this.tuL.put("scene", i2);
        d.a aVar2 = new d.a();
        aVar2.c(this.ukz);
        ape ape = new ape();
        ape.setBaseResponse(new BaseResponse());
        ape.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(ape);
        aVar2.MB("/cgi-bin/micromsg-bin/findercloselive");
        aVar2.sG(s.CTRL_INDEX);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderCloseLive init liveId:" + this.ukz.liveId + ", username:" + this.ukz.finderUsername + ",objectId:" + this.ukz.hFK + ",nonceId:" + this.ukz.LBj + ",scene:" + this.ukz.scene);
        AppMethodBeat.o(246299);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246298);
        ape ape = (ape) dpc;
        p.h(ape, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            Log.i(this.TAG, "close live result:" + g.bN(ape));
        }
        this.uky.a(i2, i3, str, ape);
        AppMethodBeat.o(246298);
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
