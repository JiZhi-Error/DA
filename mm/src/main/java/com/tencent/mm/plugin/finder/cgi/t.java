package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u000f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentResponse;", "liveId", "", "objectId", "audienceUsername", "", "scene", "", "enable", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;", "(JJLjava/lang/String;IZLcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class t extends an<aou> {
    private final String TAG = "Finder.CgiFinderLiveBanComment";
    private a ttv;
    private aot ttw;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder_release"})
    public interface a {
        void mO(boolean z);

        void t(int i2, int i3, boolean z);
    }

    public t(long j2, long j3, String str, boolean z, a aVar) {
        p.h(str, "audienceUsername");
        p.h(aVar, "callback");
        AppMethodBeat.i(242243);
        this.ttv = aVar;
        this.ttw = new aot();
        this.ttw.liveId = j2;
        this.ttw.hFK = j3;
        this.ttw.LAP = str;
        this.ttw.scene = 2;
        this.ttw.enable = z;
        aot aot = this.ttw;
        am amVar = am.tuw;
        aot.LAI = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.ttw);
        aou aou = new aou();
        aou.setBaseResponse(new BaseResponse());
        aou.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(aou);
        aVar2.MB("/cgi-bin/micromsg-bin/finderbanlivecomment");
        aVar2.sG(6656);
        c(aVar2.aXF());
        Log.i(this.TAG, "CgiFinderLiveBanComment init " + this.ttw.liveId + ',' + this.ttw.LAP);
        AppMethodBeat.o(242243);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, aou aou, q qVar) {
        AppMethodBeat.i(242242);
        p.h(aou, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            this.ttv.mO(this.ttw.enable);
            AppMethodBeat.o(242242);
            return;
        }
        this.ttv.t(i2, i3, this.ttw.enable);
        AppMethodBeat.o(242242);
    }
}
