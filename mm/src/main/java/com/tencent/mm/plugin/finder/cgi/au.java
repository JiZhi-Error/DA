package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\bH\u0016J>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class au extends ax implements m {
    public static final a tuN = new a((byte) 0);
    private i callback;
    private d rr;

    static {
        AppMethodBeat.i(242349);
        AppMethodBeat.o(242349);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public au(String str, awt awt, int i2, bbn bbn) {
        super(bbn);
        p.h(str, "userName");
        p.h(awt, "noticeInfo");
        AppMethodBeat.i(242348);
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/findercreatelivenotice");
        aVar.sG(getType());
        apy apy = new apy();
        apy.finderUsername = str;
        apy.liveNoticeInfo = awt;
        apy.dYx = i2;
        am amVar = am.tuw;
        apy.LAI = am.a(bbn);
        aov aov = apy.LAI;
        if (aov != null) {
            aov.scene = bbn != null ? bbn.tyh : 0;
        }
        apz apz = new apz();
        aVar.c(apy);
        aVar.d(apz);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i("Finder.NetSceneCreateLiveNotice", "NetSceneCreateLiveNotice init userName:" + str + ", startTime:" + awt.dvv + " ,opType:" + i2 + ' ');
        AppMethodBeat.o(242348);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242345);
        this.callback = iVar;
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        int dispatch = dispatch(gVar, dVar, this);
        AppMethodBeat.o(242345);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6653;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242346);
        Log.i("Finder.NetSceneCreateLiveNotice", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242346);
            return;
        }
        AppMethodBeat.o(242346);
    }

    public final apz cYf() {
        AppMethodBeat.i(242347);
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        com.tencent.mm.bw.a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateLiveNoticeResponse");
            AppMethodBeat.o(242347);
            throw tVar;
        }
        apz apz = (apz) aYK;
        AppMethodBeat.o(242347);
        return apz;
    }
}
