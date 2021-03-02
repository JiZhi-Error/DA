package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class a extends an<api> {
    public static final C1090a tsF = new C1090a((byte) 0);
    private final List<bdv> tsE;

    static {
        AppMethodBeat.i(242197);
        AppMethodBeat.o(242197);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.tencent.mm.protocal.protobuf.bdv> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(List<? extends bdv> list, bbn bbn) {
        super(bbn);
        p.h(list, "unreadList");
        AppMethodBeat.i(242196);
        this.tsE = list;
        d.a aVar = new d.a();
        aph aph = new aph();
        am amVar = am.tuw;
        aph.LAI = am.a(bbn);
        aph.LBq.addAll(this.tsE);
        aVar.c(aph);
        api api = new api();
        api.setBaseResponse(new BaseResponse());
        api.getBaseResponse().ErrMsg = new dqi();
        aVar.d(api);
        aVar.MB("/cgi-bin/micromsg-bin/findercollectunread");
        aVar.sG(3980);
        c(aVar.aXF());
        StringBuilder sb = new StringBuilder("unreadList=");
        List<bdv> list2 = this.tsE;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        for (T t : list2) {
            arrayList.add(com.tencent.mm.ac.d.zs(t.hFK) + " sessionBuff=" + (t.sessionBuffer != null));
        }
        Log.i("CgiCollectUnreadItem", sb.append(arrayList).toString());
        AppMethodBeat.o(242196);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, api api, q qVar) {
        AppMethodBeat.i(242195);
        p.h(api, "resp");
        Log.i("CgiCollectUnreadItem", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        AppMethodBeat.o(242195);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.cgi.a$a  reason: collision with other inner class name */
    public static final class C1090a {
        private C1090a() {
        }

        public /* synthetic */ C1090a(byte b2) {
            this();
        }
    }
}
