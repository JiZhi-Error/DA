package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\tH\u0016J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetDetail;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "videoId", "", ch.COL_USERNAME, "", "videoNonceId", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getVideoId", "()J", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFinderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cu extends cr implements m {
    public static final a twK = new a((byte) 0);
    private i callback;
    private d rr;
    public final long twJ;

    static {
        AppMethodBeat.i(242561);
        AppMethodBeat.o(242561);
    }

    public /* synthetic */ cu(long j2, String str, String str2, bbn bbn) {
        this(j2, str, str2, 0, bbn);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetDetail$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public cu(long j2, String str, String str2, int i2, bbn bbn) {
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "videoNonceId");
        AppMethodBeat.i(242560);
        this.twJ = j2;
        cnm cnm = new cnm();
        ap apVar = ap.tuF;
        cnm.MtV = ap.b(bbn);
        cnm.twJ = this.twJ;
        cnm.username = str;
        cnm.LOd = str2;
        cnm.scene = i2;
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/megavideodetail");
        aVar.sG(getType());
        aVar.c(cnm);
        aVar.d(new cnn());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i("NetSceneMegaVideoGetDetail", "NetSceneMegaVideoGetDetail videoId " + this.twJ + " username " + str);
        AppMethodBeat.o(242560);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4195;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242557);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242557);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax, com.tencent.mm.plugin.finder.cgi.cr
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242558);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242558);
            return;
        }
        AppMethodBeat.o(242558);
    }

    public final ayj cZr() {
        AppMethodBeat.i(242559);
        ayj ayj = new ayj();
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoDetailResponse");
            AppMethodBeat.o(242559);
            throw tVar;
        }
        ayj.LIA = ((cnn) aYK).LIA;
        com.tencent.mm.bw.a aYK2 = this.rr.aYK();
        if (aYK2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoDetailResponse");
            AppMethodBeat.o(242559);
            throw tVar2;
        }
        ayj.contact = ((cnn) aYK2).contact;
        AppMethodBeat.o(242559);
        return ayj;
    }
}
