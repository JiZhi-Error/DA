package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J4\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001c0\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Callback", "Companion", "plugin-finder_release"})
public final class n extends an<atm> {
    public static final b tth = new b((byte) 0);
    private final int pullType;
    private final ab.c ttd;
    private final a ttg;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, atm atm, int i4);
    }

    static {
        AppMethodBeat.i(242230);
        AppMethodBeat.o(242230);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, atm atm, q qVar) {
        AppMethodBeat.i(242228);
        atm atm2 = atm;
        p.h(atm2, "resp");
        h.b(h.veu, 2);
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("Finder.CgiFinderGetNearbyList", "[onCgiBack] pullType=" + this.pullType + " errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        ab.c cVar = this.ttd;
        if (cVar == null || !cVar.b(atm2)) {
            if (i2 == 0 && i3 == 0) {
                LinkedList<azm> linkedList = atm2.LEm;
                if (linkedList != null) {
                    for (T t : linkedList) {
                        StringBuilder append = new StringBuilder("[onCgiBack] pullType=").append(this.pullType).append(" type:");
                        bcc bcc = t.tvs;
                        StringBuilder append2 = append.append(bcc != null ? Integer.valueOf(bcc.jjN) : null).append(" t:");
                        bcc bcc2 = t.tvs;
                        StringBuilder append3 = append2.append(bcc2 != null ? bcc2.qfq : null).append(" desc:");
                        bcc bcc3 = t.tvs;
                        StringBuilder append4 = append3.append(bcc3 != null ? bcc3.LLn : null).append(' ');
                        al alVar = al.tuv;
                        Log.i("Finder.CgiFinderGetNearbyList", append4.append(al.dQ(t.LCW)).toString());
                    }
                }
            } else {
                h hVar = h.veu;
                h.d(2, this.ttO);
            }
            this.ttg.a(i2, i3, str, atm2, this.pullType);
            Log.i("Finder.CgiFinderGetNearbyList", "[onCgiBack] Cost=" + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
            AppMethodBeat.o(242228);
            return;
        }
        Log.w("Finder.CgiFinderGetNearbyList", "has consume.");
        AppMethodBeat.o(242228);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(com.tencent.mm.bw.b bVar, a aVar, int i2, ab.c cVar, bbn bbn) {
        super(bbn);
        p.h(aVar, "callback");
        AppMethodBeat.i(242229);
        this.ttg = aVar;
        this.pullType = i2;
        this.ttd = cVar;
        d.a aVar2 = new d.a();
        aVar2.sG(375);
        atl atl = new atl();
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        atl.dTj = dHP.first.floatValue();
        atl.latitude = dHP.second.floatValue();
        atl.lastBuffer = bVar;
        am amVar = am.tuw;
        atl.LAI = am.cXY();
        am amVar2 = am.tuw;
        atl.LAv = am.cXZ();
        aVar2.c(atl);
        aVar2.d(new atm());
        aVar2.MB("/cgi-bin/micromsg-bin/findergetnearbylist");
        c(aVar2.aXF());
        Log.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + atl.latitude + ", " + atl.dTj + ' ' + this.pullType + ' ' + bVar);
        h hVar = h.veu;
        h.a(2, this.pullType, bbn, 4);
        AppMethodBeat.o(242229);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an, com.tencent.mm.ak.c
    public final f<c.a<atm>> aYI() {
        AppMethodBeat.i(242227);
        h.a(h.veu, 2, true, null, 12);
        f<c.a<atm>> aYI = super.aYI();
        AppMethodBeat.o(242227);
        return aYI;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final boolean cXQ() {
        return true;
    }
}
