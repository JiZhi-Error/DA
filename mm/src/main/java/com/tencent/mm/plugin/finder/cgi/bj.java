package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J>\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bj extends ax implements m {
    private final String TAG = "Finder.NetSceneFinderGetFollowList";
    private i callback;
    private d rr;

    public bj(b bVar) {
        AppMethodBeat.i(165225);
        d.a aVar = new d.a();
        aVar.sG(getType());
        asf asf = new asf();
        asf.lastBuffer = bVar;
        am amVar = am.tuw;
        asf.uli = am.cXY();
        aVar.c(asf);
        aVar.d(new asg());
        aVar.MB("/cgi-bin/micromsg-bin/findergetfollowlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetFollowList init ");
        AppMethodBeat.o(165225);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 713;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165221);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165221);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        boolean z = false;
        AppMethodBeat.i(242410);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            e.INSTANCE.idkeyStat(1279, 7, 1, false);
        } else {
            e.INSTANCE.idkeyStat(1279, 8, 1, false);
        }
        a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
            AppMethodBeat.o(242410);
            throw tVar;
        }
        if (((asf) aYJ).lastBuffer == null) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            ao azQ = aAh.azQ();
            ar.a aVar = ar.a.USERINFO_FINDER_FOLLOW_COUNT_INT_SYNC;
            a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
                AppMethodBeat.o(242410);
                throw tVar2;
            }
            azQ.set(aVar, Integer.valueOf(((asg) aYK).LDr));
            x xVar = x.SXb;
        }
        LinkedList<FinderContact> cYt = cYt();
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("firstPage ");
        if (cYm() == null) {
            z = true;
        }
        Log.i(str2, sb.append(z).append(", get ").append(cYt.size()).append(" follow contact ").toString());
        Iterator<T> it = cYt.iterator();
        while (it.hasNext()) {
            c.a aVar2 = c.tsp;
            c.a.a(it.next());
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242410);
    }

    public final LinkedList<FinderContact> cYt() {
        AppMethodBeat.i(165223);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
            AppMethodBeat.o(165223);
            throw tVar;
        }
        LinkedList<FinderContact> linkedList = ((asg) aYK).LCI;
        p.g(linkedList, "(rr.responseProtoBuf as …ListResponse).contactList");
        AppMethodBeat.o(165223);
        return linkedList;
    }

    public final boolean cYp() {
        AppMethodBeat.i(242411);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
            AppMethodBeat.o(242411);
            throw tVar;
        } else if (((asg) aYK).continueFlag != 0) {
            AppMethodBeat.o(242411);
            return true;
        } else {
            AppMethodBeat.o(242411);
            return false;
        }
    }

    public final b cYn() {
        AppMethodBeat.i(242412);
        a aYJ = this.rr.aYJ();
        if (!(aYJ instanceof asf)) {
            aYJ = null;
        }
        asf asf = (asf) aYJ;
        if (asf != null) {
            b bVar = asf.lastBuffer;
            AppMethodBeat.o(242412);
            return bVar;
        }
        AppMethodBeat.o(242412);
        return null;
    }

    public final b cYm() {
        AppMethodBeat.i(165224);
        a aYK = this.rr.aYK();
        if (!(aYK instanceof asg)) {
            aYK = null;
        }
        asg asg = (asg) aYK;
        if (asg != null) {
            b bVar = asg.lastBuffer;
            AppMethodBeat.o(165224);
            return bVar;
        }
        AppMethodBeat.o(165224);
        return null;
    }
}
