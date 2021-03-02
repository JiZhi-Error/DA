package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010 \u001a\u00020\nJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0010J\u0006\u0010#\u001a\u00020\nJ\b\u0010$\u001a\u0004\u0018\u00010\u0006J\u0006\u0010%\u001a\u00020\nJ\b\u0010&\u001a\u00020\nH\u0016J>\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMegaVideoCount", "getRespLastBuffer", "getTotalCount", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class co extends ax implements m {
    private final String TAG;
    private i callback;
    public int pullType;
    private d rr;

    public /* synthetic */ co(String str, b bVar, bbn bbn) {
        this(str, bVar, bbn, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public co(String str, b bVar, bbn bbn, int i2) {
        super(bbn);
        p.h(str, "finderUserName");
        AppMethodBeat.i(242541);
        this.TAG = "Finder.NetSceneFinerGetFavFeed";
        d.a aVar = new d.a();
        aVar.sG(getType());
        arz arz = new arz();
        arz.lastBuffer = bVar;
        am amVar = am.tuw;
        arz.LAI = am.a(bbn);
        arz.finderUsername = str;
        arz.dLS = i2;
        am amVar2 = am.tuw;
        arz.LAv = am.cXZ();
        aVar.c(arz);
        aVar.sG(getType());
        aVar.d(new asa());
        aVar.MB("/cgi-bin/micromsg-bin/findergetfavlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        AppMethodBeat.o(242541);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3966;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242534);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242534);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242535);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("server increatment size:");
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(242535);
            throw tVar;
        }
        Log.i(str2, sb.append(((asa) aYK).object.size()).toString());
        if (i3 == 0 && i4 == 0) {
            a aYK2 = this.rr.aYK();
            if (aYK2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
                AppMethodBeat.o(242535);
                throw tVar2;
            }
            asa asa = (asa) aYK2;
            com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
            baw baw = asa.LAF;
            LinkedList<FinderObject> linkedList = asa.object;
            p.g(linkedList, "resp.`object`");
            com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList, 3966);
            Iterator<T> it = cYD().iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242535);
    }

    public final List<FinderObject> cYD() {
        AppMethodBeat.i(242536);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(242536);
            throw tVar;
        }
        LinkedList<FinderObject> linkedList = ((asa) aYK).object;
        p.g(linkedList, "(rr.responseProtoBuf as …FavListResponse).`object`");
        LinkedList<FinderObject> linkedList2 = linkedList;
        AppMethodBeat.o(242536);
        return linkedList2;
    }

    public final int cZm() {
        AppMethodBeat.i(242537);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("favCount = ");
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(242537);
            throw tVar;
        }
        Log.i(str, sb.append(((asa) aYK).gAZ).toString());
        a aYK2 = this.rr.aYK();
        if (aYK2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(242537);
            throw tVar2;
        }
        int i2 = ((asa) aYK2).gAZ;
        AppMethodBeat.o(242537);
        return i2;
    }

    public final int cYy() {
        AppMethodBeat.i(242538);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(242538);
            throw tVar;
        }
        int i2 = ((asa) aYK).uKM;
        AppMethodBeat.o(242538);
        return i2;
    }

    public final b cYz() {
        AppMethodBeat.i(242539);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(242539);
            throw tVar;
        }
        b bVar = ((asa) aYK).lastBuffer;
        AppMethodBeat.o(242539);
        return bVar;
    }

    public final int cYA() {
        AppMethodBeat.i(242540);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(242540);
            throw tVar;
        }
        int i2 = ((asa) aYK).continueFlag;
        AppMethodBeat.o(242540);
        return i2;
    }
}
