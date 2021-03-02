package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KReportService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.service.h;

public class ReportServiceImpl implements KReportService {
    @Override // com.tencent.kinda.gen.KReportService
    public void idkeyStat(long j2, long j3, long j4, boolean z) {
        AppMethodBeat.i(18677);
        h.INSTANCE.idkeyStat(j2, j3, j4, z);
        AppMethodBeat.o(18677);
    }

    @Override // com.tencent.kinda.gen.KReportService
    public void kvStat(int i2, String str) {
        AppMethodBeat.i(18678);
        h.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(18678);
    }

    @Override // com.tencent.kinda.gen.KReportService
    public long svrTimeMs() {
        AppMethodBeat.i(18679);
        long aWy = cl.aWy();
        AppMethodBeat.o(18679);
        return aWy;
    }
}
