package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.plugin.finder.live.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ4\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAudienceReserveLive;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveRequest;", "getUserName", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class e extends an<aos> {
    private final String TAG = "Finder.CgiFinderAudienceReserveLive";
    private final String dDJ;
    private final int dYx = 1;
    private aor tsM = new aor();
    private final String userName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, String str2) {
        super(null);
        p.h(str, "userName");
        p.h(str2, "noticeId");
        AppMethodBeat.i(242206);
        this.userName = str;
        this.dDJ = str2;
        this.tsM.LAN = this.userName;
        this.tsM.dDJ = this.dDJ;
        this.tsM.opType = this.dYx;
        d.a aVar = new d.a();
        aVar.c(this.tsM);
        aos aos = new aos();
        aos.setBaseResponse(new BaseResponse());
        aos.getBaseResponse().ErrMsg = new dqi();
        aVar.d(aos);
        aVar.MB("/cgi-bin/micromsg-bin/finderaudiencereservelive");
        aVar.sG(6276);
        c(aVar.aXF());
        Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.dDJ + " ,optype:" + this.dYx + ' ');
        AppMethodBeat.o(242206);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, aos aos, q qVar) {
        boolean z = true;
        AppMethodBeat.i(242205);
        p.h(aos, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ' ');
        if (i2 == 0 && i3 == 0) {
            a aVar = a.ufi;
            a.q(this.userName, this.dDJ, this.dYx == 1);
            hw hwVar = new hw();
            hwVar.dMx.dDJ = this.dDJ;
            hw.a aVar2 = hwVar.dMx;
            if (this.dYx != 1) {
                z = false;
            }
            aVar2.dCs = z;
            EventCenter.instance.publish(hwVar);
        }
        AppMethodBeat.o(242205);
    }
}
