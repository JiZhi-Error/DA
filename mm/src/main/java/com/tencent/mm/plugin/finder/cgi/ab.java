package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.report.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0015\u001a\u00020\rH\u0016J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"})
public final class ab extends an<bda> {
    public static final b tub = new b((byte) 0);
    private final int dLS;
    private final com.tencent.mm.bw.b lastBuffer;
    private final int pullType;
    private final bcz ttZ = new bcz();
    private final c ttd;
    private final boolean tte = false;
    private final a tua;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public interface a {
        void a(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
    public interface c {
        boolean b(dpc dpc);
    }

    static {
        AppMethodBeat.i(165175);
        AppMethodBeat.o(165175);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02f5, code lost:
        if ((!r1.isEmpty()) == false) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0306, code lost:
        if ((!r1.isEmpty()) != false) goto L_0x0308;
     */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void b(int r12, int r13, java.lang.String r14, com.tencent.mm.protocal.protobuf.bda r15, com.tencent.mm.ak.q r16) {
        /*
        // Method dump skipped, instructions count: 1119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.ab.b(int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(a aVar, int i2, int i3, c cVar, com.tencent.mm.bw.b bVar, bbn bbn) {
        super(bbn);
        byte[] bArr;
        char mD5String;
        p.h(aVar, "callback");
        AppMethodBeat.i(242292);
        this.tua = aVar;
        this.pullType = i2;
        this.dLS = i3;
        this.ttd = cVar;
        this.lastBuffer = bVar;
        if (this.pullType == 0 && this.tte) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            ao azQ = aAh.azQ();
            y yVar = y.vXH;
            azQ.set(y.LK(this.dLS), (Object) null);
        }
        d.a aVar2 = new d.a();
        if (this.tte) {
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            ao azQ2 = aAh2.azQ();
            y yVar2 = y.vXH;
            Object obj = azQ2.get(y.LK(this.dLS), "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(242292);
                throw tVar;
            }
            this.ttZ.lastBuffer = com.tencent.mm.bw.b.cD(Util.decodeHexString((String) obj));
        } else {
            this.ttZ.lastBuffer = this.lastBuffer;
        }
        this.ttZ.pullType = this.pullType;
        this.ttZ.dLS = this.dLS;
        if (this.pullType == 1 && (this.dLS == 1 || this.dLS == 3 || this.dLS == 4)) {
            bcz bcz = this.ttZ;
            FinderStreamPartialExposeUIC.a aVar3 = FinderStreamPartialExposeUIC.wAt;
            bcz.LMz = FinderStreamPartialExposeUIC.a.MH(this.dLS);
            Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.dLS + " partialExposedObjectId=" + this.ttZ.LMz + " h:" + hashCode());
        }
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        this.ttZ.dTj = dHP.first.floatValue();
        this.ttZ.latitude = dHP.second.floatValue();
        bcz bcz2 = this.ttZ;
        am amVar = am.tuw;
        bcz2.uli = am.a(bbn);
        bcz bcz3 = this.ttZ;
        String cMD = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        bcz3.sessionId = cMD == null ? "" : cMD;
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        FinderTipsShowEntranceExtInfo IA = ((PluginFinder) ah).getRedDotManager().IA(this.dLS);
        if (IA.object_id != 0) {
            this.ttZ.LMx = IA.object_id;
            this.ttZ.LMy = IA.object_nonce_id;
            Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.dLS + " request with showInfo. objectId=" + com.tencent.mm.ac.d.zs(this.ttZ.LMx) + " h:" + hashCode());
        }
        apc apc = new apc();
        apc.osName = com.tencent.mm.protocal.d.KyL;
        apc.osVersion = com.tencent.mm.protocal.d.KyM;
        apc.deviceBrand = com.tencent.mm.protocal.d.KyI;
        apc.deviceModel = com.tencent.mm.protocal.d.KyJ;
        apc.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        k kVar = k.vfA;
        apc.netType = k.dod();
        apc.LBf = CdnLogic.getRecentAverageSpeed(2);
        b.a aVar5 = com.tencent.mm.plugin.finder.video.reporter.b.whK;
        apc.LBg = com.tencent.mm.plugin.finder.video.reporter.b.whI;
        apc.LBh.add("h264");
        if (com.tencent.mm.modelcontrol.e.sX(4)) {
            apc.LBh.add("h265");
        }
        bcz bcz4 = this.ttZ;
        as asVar = as.uOL;
        bcz4.LIs = as.Jt(this.dLS);
        this.ttZ.LAv = apc;
        g.a aVar6 = com.tencent.mm.plugin.finder.report.g.vek;
        LinkedList<ecq> Kc = g.a.Kc(this.dLS);
        if (Kc != null) {
            this.ttZ.LEw = Kc;
        }
        aVar2.c(this.ttZ);
        bda bda = new bda();
        bda.setBaseResponse(new BaseResponse());
        bda.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(bda);
        aVar2.MB("/cgi-bin/micromsg-bin/finderstream");
        aVar2.sG(3901);
        c(aVar2.aXF());
        StringBuilder append = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.dLS).append(" init ").append(this.pullType).append(" lastBuffer ").append(this.ttZ.lastBuffer == null).append(", ");
        if (this.ttZ.lastBuffer == null) {
            mD5String = '1';
        } else {
            com.tencent.mm.bw.b bVar2 = this.ttZ.lastBuffer;
            if (bVar2 != null) {
                bArr = bVar2.zy;
            } else {
                bArr = null;
            }
            mD5String = MD5Util.getMD5String(bArr);
        }
        Log.i("Finder.CgiFinderTimelineStream", append.append(mD5String).append(" longitude=").append(this.ttZ.dTj).append(" latitude=").append(this.ttZ.latitude).append(" h:").append(hashCode()).toString());
        AppMethodBeat.o(242292);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final boolean cXQ() {
        return true;
    }
}
