package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.live.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ4\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAdLiveNotice;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeResponse;", "userName", "", "noticeId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeRequest;", "getUserName", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class d extends an<aok> {
    private final String TAG = "Finder.CgiFinderAdLiveNotice";
    private final String dDJ;
    private aoj tsL = new aoj();
    private final String userName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String str, String str2) {
        super(null);
        p.h(str, "userName");
        p.h(str2, "noticeId");
        AppMethodBeat.i(242204);
        this.userName = str;
        this.dDJ = str2;
        this.tsL.finderUsername = this.userName;
        this.tsL.dDJ = this.dDJ;
        d.a aVar = new d.a();
        aVar.c(this.tsL);
        aok aok = new aok();
        aok.setBaseResponse(new BaseResponse());
        aok.getBaseResponse().ErrMsg = new dqi();
        aVar.d(aok);
        aVar.MB("/cgi-bin/micromsg-bin/finderadlivenotice");
        aVar.sG(4164);
        c(aVar.aXF());
        Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.dDJ);
        AppMethodBeat.o(242204);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, aok aok, q qVar) {
        AppMethodBeat.i(242203);
        aok aok2 = aok;
        p.h(aok2, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ' ');
        if (i2 == 0 && i3 == 0 && aok2.LAs > 0) {
            a aVar = a.ufi;
            a.IV(aok2.LAs);
            Log.i(this.TAG, "requestInterval " + aok2.LAs);
        }
        AppMethodBeat.o(242203);
    }
}
