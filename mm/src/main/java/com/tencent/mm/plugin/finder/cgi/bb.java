package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUser", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bb extends ax {
    private static final String TAG = TAG;
    private static final int tvb = 1;
    private static final int tvc = 2;
    private static final int tvd = 3;
    public static final a tve = new a((byte) 0);
    private i callback;
    private final String dNc;
    private final long feedId;
    private final int opType;
    private d rr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bb(String str, int i2, bbn bbn, long j2) {
        super(bbn);
        p.h(str, "finderUser");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(242373);
        this.dNc = str;
        this.opType = i2;
        this.feedId = j2;
        d.a aVar = new d.a();
        aVar.sG(getType());
        arf arf = new arf();
        arf.LCo = this.dNc;
        arf.opType = this.opType;
        arf.refObjectId = this.feedId;
        am amVar = am.tuw;
        arf.uli = am.a(bbn);
        aov aov = arf.uli;
        if (aov != null) {
            aov.scene = bbn.tyh;
        }
        k kVar = k.vfA;
        long j3 = this.feedId;
        aov aov2 = arf.uli;
        arf.sessionBuffer = k.G(j3, aov2 != null ? aov2.scene : 0);
        arf.vkj = bbn.wyY;
        aVar.c(arf);
        arg arg = new arg();
        arg.setBaseResponse(new BaseResponse());
        aVar.d(arg);
        aVar.MB("/cgi-bin/micromsg-bin/finderfollow");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(TAG, "NetSceneFinderFollow init " + this.dNc + " opType " + this.opType + " scene " + bbn.tyh + " feedId " + this.feedId + " enterType" + bbn.wyY);
        AppMethodBeat.o(242373);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165213);
        AppMethodBeat.o(165213);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3867;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165210);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165210);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return b.Enable;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        String str2;
        int i5;
        AppMethodBeat.i(242372);
        Log.i(TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderFollowResponse");
                AppMethodBeat.o(242372);
                throw tVar;
            }
            FinderContact finderContact = ((arg) aYK).contact;
            if (finderContact != null) {
                Log.i(TAG, "newContact.followFlag: " + finderContact.followFlag);
                c.a aVar = c.tsp;
                str2 = this.dNc;
                i5 = finderContact.followFlag;
            } else {
                c.a aVar2 = c.tsp;
                str2 = this.dNc;
                if (this.opType == tvb) {
                    g.a aVar3 = com.tencent.mm.plugin.finder.api.g.tsD;
                    i5 = com.tencent.mm.plugin.finder.api.g.tsB;
                } else {
                    g.a aVar4 = com.tencent.mm.plugin.finder.api.g.tsD;
                    i5 = com.tencent.mm.plugin.finder.api.g.tsC;
                }
            }
            c.a.du(str2, i5);
        } else if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            u.makeText(MMApplicationContext.getContext(), "is debug info finderfollow: " + i3 + ' ' + i4, 1).show();
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242372);
    }
}
