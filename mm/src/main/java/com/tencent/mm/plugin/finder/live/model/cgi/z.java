package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u000fH\u0016J>\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(JJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveWecoinHotInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "getNewTotalWecoinHot", "getTotalWecoinHot", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class z extends ax {
    public static final a ulw = new a((byte) 0);
    private i callback;
    public d rr;

    static {
        AppMethodBeat.i(246353);
        AppMethodBeat.o(246353);
    }

    public z(long j2, long j3, String str, b bVar) {
        AppMethodBeat.i(246352);
        d.a aVar = new d.a();
        aVar.sG(getType());
        asx asx = new asx();
        am amVar = am.tuw;
        asx.LBM = am.cXY();
        asx.LAt = com.tencent.mm.model.z.aUg();
        asx.hyH = j2;
        asx.object_id = j3;
        asx.LDs = bVar;
        asx.object_nonce_id = str;
        aVar.c(asx);
        aVar.d(new asy());
        aVar.MB("/cgi-bin/micromsg-bin/findergetliverewardgains");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i("Finder.NetSceneFinderGetLiveReward", "NetSceneFinderGetLiveReward init, finderUsername = " + asx.LAt + ", liveId = " + j2 + ", objectId = " + j3 + ", objectNonceId = " + str + ",  lastBuffer = " + bVar);
        AppMethodBeat.o(246352);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(246349);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(246349);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4168;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(246350);
        Log.i("Finder.NetSceneFinderGetLiveReward", "onGYNetEnd, errType:" + i3 + ", errCode:" + i4 + ", errMsg:" + str);
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(246350);
    }

    public final LinkedList<axa> dgH() {
        AppMethodBeat.i(246351);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
            AppMethodBeat.o(246351);
            throw tVar;
        }
        LinkedList<axa> linkedList = ((asy) aYK).LAj;
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(246351);
        return linkedList;
    }

    public final long hTl() {
        AppMethodBeat.i(260525);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
            AppMethodBeat.o(260525);
            throw tVar;
        }
        long j2 = ((asy) aYK).LDN;
        AppMethodBeat.o(260525);
        return j2;
    }
}
