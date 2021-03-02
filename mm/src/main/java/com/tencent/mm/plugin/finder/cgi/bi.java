package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\b\u0010!\u001a\u0004\u0018\u00010\bJ\b\u0010\"\u001a\u0004\u0018\u00010\bJ\b\u0010#\u001a\u00020\u0014H\u0016J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020%H\u0016J>\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\f\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bi extends ax {
    private final String TAG = "Finder.NetSceneFinderGetFoldedList";
    private i callback;
    private final long feedId;
    public int pullType;
    public d rr;
    private final String tvk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bi(String str, long j2, String str2, b bVar, bbn bbn) {
        super(bbn);
        p.h(str, "friendUsername");
        p.h(str2, "nonceId");
        AppMethodBeat.i(242409);
        this.tvk = str;
        this.feedId = j2;
        d.a aVar = new d.a();
        aVar.sG(getType());
        asd asd = new asd();
        asd.tvk = this.tvk;
        asd.hFK = this.feedId;
        asd.lastBuffer = bVar;
        asd.objectNonceId = str2;
        am amVar = am.tuw;
        asd.LAI = am.a(bbn);
        aVar.c(asd);
        aVar.d(new ase());
        aVar.MB("/cgi-bin/micromsg-bin/findergetfoldedlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.tvk + " feedId:" + this.feedId + " nonceId:" + str2);
        AppMethodBeat.o(242409);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3904;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242406);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242406);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242407);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            e.INSTANCE.idkeyStat(1279, 9, 1, false);
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("friendUsername ").append(this.tvk).append("  feedId:").append(this.feedId).append(' ');
            al alVar = al.tuv;
            Log.i(str2, append.append(al.dQ(cYs())).toString());
            LinkedList<FinderObject> cYs = cYs();
            if (cYs != null) {
                Iterator<T> it = cYs.iterator();
                while (it.hasNext()) {
                    d(it.next());
                }
            }
        } else {
            e.INSTANCE.idkeyStat(1279, 10, 1, false);
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242407);
            return;
        }
        AppMethodBeat.o(242407);
    }

    public final LinkedList<FinderObject> cYs() {
        AppMethodBeat.i(242408);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
            AppMethodBeat.o(242408);
            throw tVar;
        }
        LinkedList<FinderObject> linkedList = ((ase) aYK).object;
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(242408);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final boolean cXQ() {
        return true;
    }
}
