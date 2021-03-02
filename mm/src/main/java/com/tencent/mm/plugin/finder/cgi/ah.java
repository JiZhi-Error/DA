package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ4\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ah extends c<atp> {
    private static final boolean cWq;
    public static final a tup = new a((byte) 0);
    private final long feedId;
    private final String hwg;
    private final atn tuo;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, atp atp, q qVar) {
        AppMethodBeat.i(242304);
        atp atp2 = atp;
        p.h(atp2, "resp");
        super.a(i2, i3, str, atp2, qVar);
        StringBuilder append = new StringBuilder("[onCgiBack] related feedId=").append(d.zs(this.feedId)).append(" list=");
        LinkedList<FinderObject> linkedList = atp2.object;
        p.g(linkedList, "resp.`object`");
        LinkedList<FinderObject> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
        Iterator<T> it = linkedList2.iterator();
        while (it.hasNext()) {
            arrayList.add(d.zs(it.next().id));
        }
        Log.i("CgiGetHotRelatedList", append.append(arrayList).append(" errType=").append(i2).append(" errCode=").append(i3).append(" errMsg=").append(str).toString());
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
            baw baw = atp2.preloadInfo;
            LinkedList<FinderObject> linkedList3 = atp2.object;
            p.g(linkedList3, "resp.`object`");
            com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList3, 3688);
        }
        if (i2 == 0 && i3 == 0) {
            atp2.object.isEmpty();
        }
        AppMethodBeat.o(242304);
    }

    public ah(long j2, String str, atn atn, bbn bbn) {
        p.h(str, "nonceId");
        AppMethodBeat.i(242305);
        this.feedId = j2;
        this.hwg = str;
        this.tuo = atn;
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        ao azQ = aAh.azQ();
        y yVar = y.vXH;
        Object obj = azQ.get(y.LK(4), "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(242305);
            throw tVar;
        }
        b cD = b.cD(Util.decodeHexString((String) obj));
        d.a aVar = new d.a();
        aVar.sG(3688);
        ato ato = new ato();
        ato.hFK = this.feedId;
        ato.objectNonceId = this.hwg;
        am amVar = am.tuw;
        ato.LAI = am.a(bbn);
        ato.scene = 4;
        ato.dLS = 4;
        ato.txf = cD;
        ato.LEs = this.tuo;
        aVar.c(ato);
        aVar.d(new atp());
        aVar.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
        c(aVar.aXF());
        Log.i("CgiGetHotRelatedList", "feedId=" + com.tencent.mm.ac.d.zs(this.feedId) + " objectNonceId=" + this.hwg + " streamLastBuffer=" + cD + " related_entrance_info=" + (ato.LEs == null));
        AppMethodBeat.o(242305);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList$Companion;", "", "()V", "TAG", "", "isDebug", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        boolean z = false;
        AppMethodBeat.i(242306);
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger()) {
            z = true;
        }
        cWq = z;
        AppMethodBeat.o(242306);
    }
}
