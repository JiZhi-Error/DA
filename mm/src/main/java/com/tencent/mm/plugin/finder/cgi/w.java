package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ4\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;", "opType", "", "objectId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IJLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getObjectId", "()J", "getOpType", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class w extends an<azb> {
    public static final a ttC = new a((byte) 0);
    private final long hFK;
    private final int opType = 1;

    static {
        AppMethodBeat.i(242250);
        AppMethodBeat.o(242250);
    }

    public w(long j2, bbn bbn) {
        AppMethodBeat.i(242249);
        this.hFK = j2;
        d.a aVar = new d.a();
        aza aza = new aza();
        aVar.c(aza);
        aza.dYx = this.opType;
        aza.finderUsername = z.aUg();
        aza.LIX.add(Long.valueOf(this.hFK));
        am amVar = am.tuw;
        aza.LBM = am.a(bbn);
        azb azb = new azb();
        azb.setBaseResponse(new BaseResponse());
        azb.getBaseResponse().ErrMsg = new dqi();
        aVar.d(azb);
        aVar.MB("/cgi-bin/micromsg-bin/findermodmentioned");
        aVar.sG(6205);
        c(aVar.aXF());
        AppMethodBeat.o(242249);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, azb azb, q qVar) {
        AppMethodBeat.i(242248);
        p.h(azb, "resp");
        Log.i("Finder.CgiFinderModMentioned", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " opType=" + this.opType + " objectId=" + this.hFK + ' ');
        AppMethodBeat.o(242248);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned$Companion;", "", "()V", "OP_TYPE_ADD", "", "OP_TYPE_DELETE", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
