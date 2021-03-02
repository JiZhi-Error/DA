package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB'\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneExtStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "actionType", "", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/ExtStats;)V", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderExtStatsReportRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aw extends ax implements m {
    private final String TAG;
    private i callback;
    private d rr;
    private b ttH;
    private aqn tuQ;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public aw(bbn bbn, alc alc) {
        this(bbn, j.ac(alc));
        p.h(alc, "extStats");
        AppMethodBeat.i(242356);
        AppMethodBeat.o(242356);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aw(bbn bbn, List<? extends alc> list) {
        super(bbn);
        p.h(list, "extStats");
        AppMethodBeat.i(242357);
        this.TAG = "Finder.NetSceneExtStatsReport";
        this.ttH = b.Disable;
        d.a aVar = new d.a();
        aVar.sG(getType());
        aqn aqn = new aqn();
        aqn.finderUsername = z.aUg();
        aqn.actionType = 18054;
        aqn.twP.addAll(list);
        am amVar = am.tuw;
        aqn.LAI = am.a(bbn);
        this.tuQ = aqn;
        aVar.c(this.tuQ);
        aqo aqo = new aqo();
        aqo.setBaseResponse(new BaseResponse());
        aVar.d(aqo);
        aVar.MB("/cgi-bin/micromsg-bin/finderextstatsreport");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        AppMethodBeat.o(242357);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6681;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242354);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242354);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return this.ttH;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242355);
        Log.i(this.TAG, "onGYNetEnd " + i2 + ' ' + i3 + ' ' + i4 + ' ' + str + ' ');
        if (i3 >= 4) {
            this.ttH = b.Default;
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242355);
            return;
        }
        AppMethodBeat.o(242355);
    }
}
