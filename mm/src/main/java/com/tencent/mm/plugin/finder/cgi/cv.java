package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010-\u001a\u00020\nJ\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\b\u00101\u001a\u0004\u0018\u00010\bJ\u0006\u00102\u001a\u00020\nJ\b\u00103\u001a\u00020\nH\u0016J>\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "feedId", "", "nonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "", "fromUserName", "toUserName", "sessionId", "sessionBuffer", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFromUserName", "()Ljava/lang/String;", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "getToUserName", "buildStatsRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MegaVideoGetRelatedListReq;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "getRespLastBuffer", "getTotalCount", "getType", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cv extends cr implements m {
    public static final a twL = new a((byte) 0);
    private i callback;
    private final String dJw;
    private final String dYs;
    private final long feedId;
    private final String hwg;
    public int pullType;
    private d rr;
    private int scene;
    private final String sessionId;
    private final b tvj;

    static {
        AppMethodBeat.i(242566);
        AppMethodBeat.o(242566);
    }

    public /* synthetic */ cv(long j2, String str, b bVar, String str2, b bVar2, bbn bbn) {
        this(j2, str, bVar, "", "", str2, bVar2, bbn);
        AppMethodBeat.i(242565);
        AppMethodBeat.o(242565);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetRelatedList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private cv(long j2, String str, b bVar, String str2, String str3, String str4, b bVar2, bbn bbn) {
        p.h(str, "nonceId");
        AppMethodBeat.i(242564);
        this.feedId = j2;
        this.hwg = str;
        this.scene = 1;
        this.dYs = str2;
        this.dJw = str3;
        this.sessionId = str4;
        this.tvj = bVar2;
        cny cny = new cny();
        ap apVar = ap.tuF;
        cny.MtV = ap.b(bbn);
        cny.twJ = this.feedId;
        cny.LOd = this.hwg;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        cny.dTj = dHP.first.floatValue();
        cny.latitude = dHP.second.floatValue();
        cny.lastBuffer = bVar;
        cny.dkU = this.dYs;
        cny.dkV = this.dJw;
        cny.scene = this.scene;
        cny.Muo = this.tvj;
        cnk cnk = new cnk();
        cnk.osName = com.tencent.mm.protocal.d.KyL;
        cnk.osVersion = com.tencent.mm.protocal.d.KyM;
        cnk.deviceBrand = com.tencent.mm.protocal.d.KyI;
        cnk.deviceModel = com.tencent.mm.protocal.d.KyJ;
        cnk.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        k kVar = k.vfA;
        cnk.netType = k.dod();
        cnk.LBf = CdnLogic.getRecentAverageSpeed(2);
        cnk.MtQ.add("h264");
        if (e.sX(4)) {
            cnk.MtQ.add("h265");
        }
        cny.Mup = cnk;
        d.a aVar2 = new d.a();
        aVar2.MB("/cgi-bin/micromsg-bin/megavideogetrelatedlist");
        aVar2.sG(getType());
        aVar2.c(cny);
        aVar2.d(new cnz());
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i("NetSceneMegaVideoGetRelatedList", "NetSceneMegaVideoGetRelatedList lastBuffer ".concat(String.valueOf(bVar)));
        AppMethodBeat.o(242564);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6432;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242562);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242562);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax, com.tencent.mm.plugin.finder.cgi.cr
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242563);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242563);
            return;
        }
        AppMethodBeat.o(242563);
    }
}
