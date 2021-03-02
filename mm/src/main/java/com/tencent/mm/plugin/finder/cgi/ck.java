package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topicId", "", "topicNonceId", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTopicId", "()J", "getTopicNonceId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ck extends ax {
    private static final String TAG = TAG;
    private static final int tvb = 1;
    private static final int tvc = 2;
    private static final int tvd = 3;
    public static final a twr = new a((byte) 0);
    private i callback;
    public final int opType;
    private d rr;
    public final long twp;
    private final String twq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ck(long j2, String str, int i2, bbn bbn) {
        super(bbn);
        p.h(str, "topicNonceId");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(242517);
        this.twp = j2;
        this.twq = str;
        this.opType = i2;
        d.a aVar = new d.a();
        aVar.sG(getType());
        arh arh = new arh();
        arh.dYx = this.opType;
        arh.twp = this.twp;
        arh.twq = this.twq;
        am amVar = am.tuw;
        arh.LCA = am.a(bbn);
        aov aov = arh.LCA;
        if (aov != null) {
            aov.scene = bbn.tyh;
        }
        f.a.a(c.vVc, "NetSceneFinderFollow_contextObj", bbn.tyh != 0, false, null, 28);
        aVar.c(arh);
        ari ari = new ari();
        ari.setBaseResponse(new BaseResponse());
        aVar.d(ari);
        aVar.MB("/cgi-bin/micromsg-bin/finderfollowtopic");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        bb.a aVar2 = bb.tve;
        Log.i(bb.TAG, "FinderTopicFollow init topicId:" + this.twp + " topicNonceId:" + this.twq + " opType " + this.opType + " scene " + bbn.tyh + "enterType" + bbn.wyY);
        AppMethodBeat.o(242517);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242518);
        AppMethodBeat.o(242518);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242515);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242515);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3844;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242516);
        Log.i(TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            k kVar = k.vfA;
            String Fg = k.Fg(this.twp);
            if (this.opType == tvb) {
                c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                g.a aVar2 = com.tencent.mm.plugin.finder.api.g.tsD;
                c.a.du(Fg, com.tencent.mm.plugin.finder.api.g.tsB);
            } else if (this.opType == tvc) {
                c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                g.a aVar4 = com.tencent.mm.plugin.finder.api.g.tsD;
                c.a.du(Fg, com.tencent.mm.plugin.finder.api.g.tsC);
            }
        } else if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            u.makeText(MMApplicationContext.getContext(), "is debug info FinderTopicFollow: " + i3 + ' ' + i4, 1).show();
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242516);
    }
}
