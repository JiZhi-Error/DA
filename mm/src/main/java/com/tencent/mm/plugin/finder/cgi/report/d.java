package com.tencent.mm.plugin.finder.cgi.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.bw.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0017J\u0006\u0010\u001e\u001a\u00020\u0017J\u0010\u0010\u001f\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "", "cigTrack", "Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;", "(Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;)V", "TAG", "", "TAG_DEBUG", "TAG_DETAIL", "actionTime", "", "cgiCostTime", "cgiLog", "", "cgiProcessTime", "fromCommentScene", "getFromCommentScene", "()I", "setFromCommentScene", "(I)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "cgiReport", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "endCgiNetWork", "endCgiProcess", "start", "plugin-finder_release"})
public final class d {
    private final String TAG = "Finder.FinderCgiReport";
    private long dCz;
    private f.a hvh = new f.a();
    public int tyh;
    private final String tyi = ("Finder.FinderCgiLogRP" + hashCode());
    private final String tyj = ("Finder.FinderCgiDetail" + hashCode());
    private long tyk;
    private long tyl;
    private final int tym;
    private final e tyn;

    public d(e eVar) {
        p.h(eVar, "cigTrack");
        AppMethodBeat.i(242693);
        this.tyn = eVar;
        c cVar = c.vCb;
        this.tym = c.dxc().value().intValue();
        AppMethodBeat.o(242693);
    }

    public final void g(com.tencent.mm.ak.d dVar) {
        a aYJ;
        AppMethodBeat.i(242689);
        this.hvh.reset();
        this.dCz = cl.aWA();
        if (this.tym == 1) {
            a aVar = a.tya;
            if (!(a.asQ(dVar != null ? dVar.getUri() : null) || dVar == null || (aYJ = dVar.aYJ()) == null)) {
                Log.i(this.tyj, "uri:" + dVar.getUri() + " request buf: " + g.bN(aYJ));
                AppMethodBeat.o(242689);
                return;
            }
        }
        AppMethodBeat.o(242689);
    }

    public final void cZt() {
        AppMethodBeat.i(242690);
        this.tyk = this.hvh.apr();
        AppMethodBeat.o(242690);
    }

    public final void cZu() {
        AppMethodBeat.i(242691);
        this.tyl = this.hvh.apr();
        AppMethodBeat.o(242691);
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x029b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.d r12) {
        /*
        // Method dump skipped, instructions count: 672
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.report.d.b(int, int, java.lang.String, com.tencent.mm.ak.d):void");
    }
}
