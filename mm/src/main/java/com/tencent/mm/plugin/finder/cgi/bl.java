package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0006\u0010\u0019\u001a\u00020\u0007J>\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u000b\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bl extends ax {
    private static final String TAG = TAG;
    private static final int tvl = 1;
    private static final int tvm = 2;
    public static final a tvn = new a((byte) 0);
    private i callback;
    private d rr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList$Companion;", "", "()V", "MMFinder_FeedLikedListAll", "", "MMFinder_FeedLikedListFriend", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242426);
        AppMethodBeat.o(242426);
    }

    public bl(b bVar, long j2, boolean z) {
        boolean z2;
        AppMethodBeat.i(242425);
        d.a aVar = new d.a();
        aVar.sG(getType());
        asb asb = new asb();
        asb.finderUsername = z.aUg();
        asb.lastBuffer = bVar;
        asb.hFK = j2;
        asb.scene = z ? tvm : tvl;
        am amVar = am.tuw;
        asb.LAI = am.cXY();
        aVar.c(asb);
        aVar.d(new asc());
        aVar.MB("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        String str = TAG;
        StringBuilder append = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(j2).append(", scene: $").append(asb.scene).append(", lastBuff is Null? ");
        if (bVar == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i(str, append.append(z2).toString());
        AppMethodBeat.o(242425);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3593;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242418);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242418);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242419);
        Log.i(TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242419);
            return;
        }
        AppMethodBeat.o(242419);
    }

    public final b cYn() {
        AppMethodBeat.i(242420);
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
            AppMethodBeat.o(242420);
            throw tVar;
        }
        b bVar = ((asb) aYJ).lastBuffer;
        AppMethodBeat.o(242420);
        return bVar;
    }

    public final b cYm() {
        AppMethodBeat.i(242421);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
            AppMethodBeat.o(242421);
            throw tVar;
        }
        b bVar = ((asc) aYK).lastBuffer;
        AppMethodBeat.o(242421);
        return bVar;
    }

    public final LinkedList<aul> cYw() {
        AppMethodBeat.i(242422);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
            AppMethodBeat.o(242422);
            throw tVar;
        }
        LinkedList<aul> linkedList = ((asc) aYK).likeList;
        p.g(linkedList, "(rr.responseProtoBuf as …edLikedListResp).likeList");
        AppMethodBeat.o(242422);
        return linkedList;
    }

    public final boolean cYp() {
        AppMethodBeat.i(242423);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
            AppMethodBeat.o(242423);
            throw tVar;
        } else if (((asc) aYK).continueFlag != 0) {
            AppMethodBeat.o(242423);
            return true;
        } else {
            AppMethodBeat.o(242423);
            return false;
        }
    }

    public final asc cYx() {
        AppMethodBeat.i(242424);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
            AppMethodBeat.o(242424);
            throw tVar;
        }
        asc asc = (asc) aYK;
        AppMethodBeat.o(242424);
        return asc;
    }
}
