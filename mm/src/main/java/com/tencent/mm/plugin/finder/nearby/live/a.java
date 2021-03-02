package com.tencent.mm.plugin.finder.nearby.live;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.nearby.report.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fBE\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J4\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "pullType", "", "commentScene", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "buildRedDotRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamRequest;", "buildResponse", "onCgiEnd", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "plugin-finder_release"})
public final class a extends an<auj> {
    public static final b uQE = new b((byte) 0);
    private final int pullType;
    private final int tCE;
    private final ab.c ttd;
    private final AbstractC1237a uQD;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "pullType", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.live.a$a  reason: collision with other inner class name */
    public interface AbstractC1237a {
        void a(int i2, int i3, String str, auj auj, int i4);
    }

    static {
        AppMethodBeat.i(249028);
        AppMethodBeat.o(249028);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, auj auj, q qVar) {
        AppMethodBeat.i(249026);
        auj auj2 = auj;
        p.h(auj2, "resp");
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("Finder.CgiNearbyLiveFeedStream", "[onCgiBack] pullType=" + this.pullType + " errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        ab.c cVar = this.ttd;
        if (cVar == null || !cVar.b(auj2)) {
            if (i2 == 0 && i3 == 0) {
                Log.i("Finder.CgiNearbyLiveFeedStream", "[onCgiBack#streamCgi] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " list=" + auj2.object.size() + " pullType=" + this.pullType + ' ');
            }
            this.uQD.a(i2, i3, str, auj2, this.pullType);
            Log.i("Finder.CgiNearbyLiveFeedStream", "[onCgiBack] Cost=" + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
            AppMethodBeat.o(249026);
            return;
        }
        Log.w("Finder.CgiNearbyLiveFeedStream", "has consume.");
        AppMethodBeat.o(249026);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(com.tencent.mm.bw.b bVar, AbstractC1237a aVar, int i2, int i3, ab.c cVar, bbn bbn, axj axj) {
        super(bbn);
        p.h(aVar, "callback");
        AppMethodBeat.i(249027);
        this.uQD = aVar;
        this.pullType = i2;
        this.tCE = i3;
        this.ttd = cVar;
        d.a aVar2 = new d.a();
        aui aui = new aui();
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        am amVar = am.tuw;
        aov cXY = am.cXY();
        cXY.scene = this.tCE;
        aui.LBM = cXY;
        aui.dTj = dHP.first.floatValue();
        aui.latitude = dHP.second.floatValue();
        aui.LDs = bVar;
        aui.LFc = this.pullType;
        if (axj != null) {
            aui.LFg = axj;
        }
        if (this.pullType == 1) {
            c cVar2 = c.uTk;
            if (c.JG(this.tCE)) {
                LinkedList<cmm> linkedList = aui.LFe;
                c cVar3 = c.uTk;
                linkedList.addAll(c.JF(this.tCE));
                LinkedList<bdv> linkedList2 = aui.LFf;
                c cVar4 = c.uTk;
                int i4 = this.tCE;
                c cVar5 = c.uTk;
                linkedList2.addAll(c.gb(i4, c.JH(this.tCE)));
            }
        }
        if (this.pullType == 1 || this.pullType == 0) {
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bbj ata = redDotManager.ata("NearbyLiveTab");
            boolean z = ata != null;
            aui.LFh = new auk();
            auk auk = aui.LFh;
            if (auk != null) {
                if (ata != null) {
                    auk.LFj = ata.object_id;
                    auk.LFk = ata.object_nonce_id;
                    auk.LFl = ata.tabTipsByPassInfo;
                    auk.LFm = "NearbyEntrance";
                } else {
                    k asX = redDotManager.asX("NearbyLiveTab");
                    if (asX != null) {
                        bbj bbj = asX.tLm;
                        auk.LFj = bbj.object_id;
                        auk.LFk = bbj.object_nonce_id;
                        auk.LFl = bbj.tabTipsByPassInfo;
                        auk.LFm = "NearbyLiveTab";
                    }
                }
                Log.i("Finder.FinderStream", "[buildRedDotRequest] isEnterRequest=" + z + " tab_tips_path=" + auk.LFm + ' ' + " tabTipsByPassInfo=" + (auk.LFl != null) + ' ' + "objectId=" + com.tencent.mm.ac.d.zs(auk.LFj) + ' ');
            }
        }
        aVar2.c(aui);
        auj auj = new auj();
        auj.setBaseResponse(new BaseResponse());
        auj.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(auj);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlbslivestream");
        aVar2.sG(4026);
        c(aVar2.aXF());
        StringBuilder append = new StringBuilder("[CgiFetchFinderTimeline#init] commentScene:").append(this.tCE).append(", pullType=").append(this.pullType).append(", longitude=").append(aui.dTj).append(" latitude=").append(aui.latitude).append(' ').append("tabInfo:");
        axj axj2 = aui.LFg;
        StringBuilder append2 = append.append(axj2 != null ? Integer.valueOf(axj2.LHQ) : null).append(" - ");
        axj axj3 = aui.LFg;
        Log.i("Finder.CgiNearbyLiveFeedStream", append2.append(axj3 != null ? axj3.LHR : null).toString());
        AppMethodBeat.o(249027);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }
}
