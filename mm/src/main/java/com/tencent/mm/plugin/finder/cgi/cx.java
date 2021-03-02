package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReportScreenShot;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "actionType", "", "extStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(ILjava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActionType", "()I", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getExtStats", "()Ljava/util/LinkedList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cx extends ax implements m {
    private final String TAG;
    private final int actionType = 0;
    private i callback;
    private d rr;
    private final LinkedList<alc> twP;

    public cx(LinkedList<alc> linkedList) {
        p.h(linkedList, "extStats");
        AppMethodBeat.i(242571);
        this.twP = linkedList;
        this.TAG = "Finder.NetSceneReportScreenShot";
        d.a aVar = new d.a();
        aVar.sG(getType());
        aqn aqn = new aqn();
        aqn.finderUsername = z.aUg();
        aqn.actionType = this.actionType;
        aqn.twP = this.twP;
        aVar.c(aqn);
        aqo aqo = new aqo();
        aqo.setBaseResponse(new BaseResponse());
        aVar.d(aqo);
        aVar.MB("/cgi-bin/micromsg-bin/finderextstatsreport");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        StringBuilder sb = new StringBuilder("");
        Iterator<T> it = this.twP.iterator();
        while (it.hasNext()) {
            sb.append(com.tencent.mm.ac.d.zs(it.next().hFK)).append(",");
        }
        Log.i(this.TAG, "NetSceneReportScreenShot start " + this.actionType + ", " + ((Object) sb));
        AppMethodBeat.o(242571);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242569);
        Log.i(this.TAG, "onGYNetEnd " + i2 + ' ' + i3 + ' ' + i4 + ' ' + str + ' ');
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242569);
            return;
        }
        AppMethodBeat.o(242569);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6681;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242570);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242570);
        return dispatch;
    }
}
