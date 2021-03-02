package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J6\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderConsumePrefetchReportResponse;", "tabType", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "getTabType", "()I", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class g extends c<apm> {
    public static final a tsP = new a((byte) 0);
    private final int dLS;
    private final b tsO;

    static {
        AppMethodBeat.i(242211);
        AppMethodBeat.o(242211);
    }

    public g(int i2, b bVar) {
        AppMethodBeat.i(242210);
        this.dLS = i2;
        this.tsO = bVar;
        d.a aVar = new d.a();
        apl apl = new apl();
        apl.tab_type = this.dLS;
        apl.LBu = this.tsO;
        aVar.c(apl);
        apm apm = new apm();
        apm.setBaseResponse(new BaseResponse());
        apm.getBaseResponse().ErrMsg = new dqi();
        aVar.d(apm);
        aVar.MB("/cgi-bin/micromsg-bin/finderconsumeprefetchreport");
        aVar.sG(3839);
        c(aVar.aXF());
        StringBuilder append = new StringBuilder("[init] tabType=").append(this.dLS).append(" lastBuff=");
        b bVar2 = this.tsO;
        Log.i("Cgi.FinderConsumePrefetchReport", append.append(bVar2 != null ? Integer.valueOf(bVar2.zy.length) : null).toString());
        AppMethodBeat.o(242210);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, apm apm, q qVar) {
        AppMethodBeat.i(242209);
        super.a(i2, i3, str, apm, qVar);
        Log.i("Cgi.FinderConsumePrefetchReport", "onCgiBack errType[" + i2 + "] errCode[" + i3 + "] errMsg[" + str + "] tabType[" + this.dLS + ']');
        AppMethodBeat.o(242209);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
