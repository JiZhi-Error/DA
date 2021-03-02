package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.o;
import kotlin.h.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, hxF = {"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c {
    static final lo a(QualitySessionRuntime qualitySessionRuntime) {
        AppMethodBeat.i(50511);
        lo loVar = new lo();
        loVar.yV(qualitySessionRuntime.appId);
        loVar.ve((long) qualitySessionRuntime.nLk);
        loVar.a(lo.a.mc(qualitySessionRuntime.nJE));
        loVar.vf((long) qualitySessionRuntime.apptype);
        AppMethodBeat.o(50511);
        return loVar;
    }

    static final long w(o oVar) {
        AppMethodBeat.i(175168);
        long L = a.L(((double) oVar.length()) / 1024.0d);
        AppMethodBeat.o(175168);
        return L;
    }
}
