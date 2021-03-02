package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbu;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0016\u001a\u00020\u000eH\u0016J>\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getHotWords", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getResponse", "getTitle", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cp extends ax {
    private final String TAG;
    private i callback;
    private d iUB;
    public bbv twE;

    private cp() {
        super(null);
        AppMethodBeat.i(242544);
        this.TAG = "Finder.NetSceneGetHotWordList";
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/findersearchgethotwordlist");
        bbu bbu = new bbu();
        am amVar = am.tuw;
        bbu.uli = am.a((bbn) null);
        aVar.c(bbu);
        aVar.d(new bbv());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.iUB = aXF;
        Log.i(this.TAG, "NetSceneGetHotWordList init");
        AppMethodBeat.o(242544);
    }

    public /* synthetic */ cp(byte b2) {
        this();
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4069;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242542);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(242542);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242543);
        Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchGetHotWordListResponse");
                AppMethodBeat.o(242543);
                throw tVar;
            }
            this.twE = (bbv) aYK;
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242543);
            return;
        }
        AppMethodBeat.o(242543);
    }

    public final LinkedList<bby> cZn() {
        bbv bbv = this.twE;
        if (bbv != null) {
            return bbv.LJY;
        }
        return null;
    }
}
