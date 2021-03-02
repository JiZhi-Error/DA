package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0006\u0010\u0014\u001a\u00020\u000bJ>\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetActivityList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getActivityList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bd extends ax implements m {
    public static final a tvh = new a((byte) 0);
    private i callback;
    public d rr;

    static {
        AppMethodBeat.i(242383);
        AppMethodBeat.o(242383);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetActivityList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public bd(b bVar) {
        AppMethodBeat.i(242382);
        d.a aVar = new d.a();
        aVar.sG(getType());
        bbb bbb = new bbb();
        bbb.LDs = bVar;
        am amVar = am.tuw;
        bbb.LBM = am.cXY();
        aVar.c(bbb);
        aVar.d(new bbc());
        aVar.MB("/cgi-bin/micromsg-bin/finderrecommendevent");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i("NetSceneFinderGetActivityList", "NetSceneFinderGetActivityList init ");
        AppMethodBeat.o(242382);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242378);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242378);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5839;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242379);
        Log.i("NetSceneFinderGetActivityList", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        Log.i("NetSceneFinderGetActivityList", "firstPage " + (cYm() == null) + ", get " + cYl().size() + " activity");
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242379);
    }

    public final LinkedList<aqk> cYl() {
        AppMethodBeat.i(242380);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRecommendEventResponse");
            AppMethodBeat.o(242380);
            throw tVar;
        }
        LinkedList<aqk> linkedList = ((bbc) aYK).LKG;
        p.g(linkedList, "(rr.responseProtoBuf as …EventResponse).event_list");
        AppMethodBeat.o(242380);
        return linkedList;
    }

    public final b cYm() {
        AppMethodBeat.i(242381);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (!(aYK instanceof bbc)) {
            aYK = null;
        }
        bbc bbc = (bbc) aYK;
        if (bbc != null) {
            b bVar = bbc.LDs;
            AppMethodBeat.o(242381);
            return bVar;
        }
        AppMethodBeat.o(242381);
        return null;
    }
}
