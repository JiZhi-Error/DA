package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0007H\u0016J>\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ar extends ax implements m {
    public static final a tuK = new a((byte) 0);
    private i callback;
    private final String dDJ;
    private final int dYx;
    private d rr;
    private final String userName;

    static {
        AppMethodBeat.i(242338);
        AppMethodBeat.o(242338);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ar(String str, String str2, int i2, bbn bbn) {
        super(bbn);
        p.h(str, "userName");
        p.h(str2, "noticeId");
        AppMethodBeat.i(242337);
        this.userName = str;
        this.dDJ = str2;
        this.dYx = i2;
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/finderaudiencereservelive");
        aVar.sG(getType());
        aor aor = new aor();
        aor.LAN = this.userName;
        aor.dDJ = this.dDJ;
        aor.opType = this.dYx;
        aos aos = new aos();
        aVar.c(aor);
        aVar.d(aos);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i("Finder.NetSceneAudienceReserveLive", "NetSceneAudienceReserveLive init userName:" + this.userName + ", noticeId:" + this.dDJ + " ,optype:" + this.dYx + ' ');
        AppMethodBeat.o(242337);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242335);
        this.callback = iVar;
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        int dispatch = dispatch(gVar, dVar, this);
        AppMethodBeat.o(242335);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6276;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        boolean z = true;
        AppMethodBeat.i(242336);
        Log.i("Finder.NetSceneAudienceReserveLive", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
        }
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.plugin.finder.live.a aVar = com.tencent.mm.plugin.finder.live.a.ufi;
            com.tencent.mm.plugin.finder.live.a.q(this.userName, this.dDJ, this.dYx == 1);
            hw hwVar = new hw();
            hwVar.dMx.dDJ = this.dDJ;
            hw.a aVar2 = hwVar.dMx;
            if (this.dYx != 1) {
                z = false;
            }
            aVar2.dCs = z;
            EventCenter.instance.publish(hwVar);
        }
        AppMethodBeat.o(242336);
    }
}
