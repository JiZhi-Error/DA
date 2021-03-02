package com.tencent.mm.plugin.finder.cgi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u0019\u001a\u00020\u000fJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010!\u001a\u0004\u0018\u00010\bJ\b\u0010\"\u001a\u00020\u000fH\u0016J>\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNoticeWording", "", "getPoiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getRespLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ca extends ax implements m {
    public static final a twa = new a((byte) 0);
    private i callback;
    public int pullType;
    public d rr;

    static {
        AppMethodBeat.i(242491);
        AppMethodBeat.o(242491);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ca(eaa eaa, y.a aVar, b bVar) {
        super(null);
        p.h(eaa, FirebaseAnalytics.b.LOCATION);
        p.h(aVar, "fromType");
        AppMethodBeat.i(242490);
        d.a aVar2 = new d.a();
        aVar2.sG(getType());
        bag bag = new bag();
        am amVar = am.tuw;
        bag.LBM = am.a((bbn) null);
        bag.dRy = eaa.LIb;
        bag.dTj = eaa.LbC;
        bag.latitude = eaa.LbD;
        bag.LJW = aVar.ordinal();
        bag.LDs = bVar;
        am amVar2 = am.tuw;
        bag.LAv = am.cXZ();
        aVar2.c(bag);
        aVar2.sG(getType());
        aVar2.d(new bah());
        aVar2.MB("/cgi-bin/micromsg-bin/finderpoistream");
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        AppMethodBeat.o(242490);
    }

    public /* synthetic */ ca(eaa eaa, y.a aVar, b bVar, byte b2) {
        this(eaa, aVar, bVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242487);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242487);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242488);
        Log.i("Finder.NetSceneFinderPoiStream", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        StringBuilder sb = new StringBuilder("server increatment size:");
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
            AppMethodBeat.o(242488);
            throw tVar;
        }
        Log.i("Finder.NetSceneFinderPoiStream", sb.append(((bah) aYK).object.size()).toString());
        if (i3 == 0 && i4 == 0) {
            if (this.rr.aYK() == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
                AppMethodBeat.o(242488);
                throw tVar2;
            }
            Iterator<T> it = cYD().iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242488);
            return;
        }
        AppMethodBeat.o(242488);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5225;
    }

    public final List<FinderObject> cYD() {
        AppMethodBeat.i(242489);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
            AppMethodBeat.o(242489);
            throw tVar;
        }
        LinkedList<FinderObject> linkedList = ((bah) aYK).object;
        p.g(linkedList, "(rr.responseProtoBuf as …iStreamResponse).`object`");
        LinkedList<FinderObject> linkedList2 = linkedList;
        AppMethodBeat.o(242489);
        return linkedList2;
    }
}
