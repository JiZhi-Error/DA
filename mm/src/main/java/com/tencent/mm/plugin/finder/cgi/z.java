package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.stats.LoggingConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.p;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J4\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", LoggingConstants.LOG_FILE_PREFIX, "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "buildStatsRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportRequest;", "getFluencyInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isEnableReport", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class z extends an<bct> {
    public static final a ttI = new a((byte) 0);
    private b ttH;

    static {
        AppMethodBeat.i(242260);
        AppMethodBeat.o(242260);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(List<? extends ecq> list, bbn bbn) {
        super(bbn);
        p.h(list, LoggingConstants.LOG_FILE_PREFIX);
        AppMethodBeat.i(242259);
        d.a aVar = new d.a();
        bcs bcs = new bcs();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            it.next().tCE = bbn != null ? bbn.tCE : 0;
        }
        aVar.c(bcs);
        bcs.LEw.addAll(list);
        bcs.finderUsername = com.tencent.mm.model.z.aUg();
        am amVar = am.tuw;
        bcs.uli = am.a(bbn);
        bcs.LLM = cl.aWA();
        apc apc = new apc();
        apc.osName = com.tencent.mm.protocal.d.KyL;
        apc.osVersion = com.tencent.mm.protocal.d.KyM;
        apc.deviceBrand = com.tencent.mm.protocal.d.KyI;
        apc.deviceModel = com.tencent.mm.protocal.d.KyJ;
        apc.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        k kVar = k.vfA;
        apc.netType = k.dod();
        apc.LBf = CdnLogic.getRecentAverageSpeed(2);
        LinkedList<aqj> linkedList = apc.LBg;
        b.a aVar2 = com.tencent.mm.plugin.finder.video.reporter.b.whK;
        linkedList.addAll(com.tencent.mm.plugin.finder.video.reporter.b.dFZ());
        StringBuilder sb = new StringBuilder("[buildStatsRequest] lastVideosDownloadInfo size=");
        b.a aVar3 = com.tencent.mm.plugin.finder.video.reporter.b.whK;
        Log.i("Finder.CgiFinderStatsReport", sb.append(com.tencent.mm.plugin.finder.video.reporter.b.dFZ().size()).toString());
        b.a aVar4 = com.tencent.mm.plugin.finder.video.reporter.b.whK;
        com.tencent.mm.plugin.finder.video.reporter.b.dFZ().clear();
        apc.LBh.add("h264");
        if (e.sX(4)) {
            apc.LBh.add("h265");
        }
        apc.LBi = cXR();
        bcs.LAv = apc;
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            p.a aVar5 = com.tencent.mm.plugin.finder.report.p.vgC;
            p.a.a(it2.next(), "Finder.CgiFinderStatsReport");
        }
        bct bct = new bct();
        bct.setBaseResponse(new BaseResponse());
        bct.getBaseResponse().ErrMsg = new dqi();
        aVar.d(bct);
        aVar.MB("/cgi-bin/micromsg-bin/finderstatsreport");
        aVar.sG(3776);
        c(aVar.aXF());
        this.ttH = com.tencent.mm.plugin.finder.cgi.report.b.Disable;
        AppMethodBeat.o(242259);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, bct bct, q qVar) {
        AppMethodBeat.i(242258);
        kotlin.g.b.p.h(bct, "resp");
        if (i2 >= 4) {
            this.ttH = com.tencent.mm.plugin.finder.cgi.report.b.Default;
        }
        AppMethodBeat.o(242258);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final synchronized LinkedList<arc> cXR() {
        LinkedList<arc> linkedList;
        AppMethodBeat.i(242257);
        linkedList = new LinkedList<>();
        h hVar = h.veu;
        linkedList.addAll(h.dnP());
        f fVar = f.veb;
        linkedList.addAll(f.dnP());
        AppMethodBeat.o(242257);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return this.ttH;
    }
}
