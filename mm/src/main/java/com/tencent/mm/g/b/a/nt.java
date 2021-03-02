package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nt extends a {
    private String eBQ = "";
    public long ejW = 0;
    public long fiw = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15776;
    }

    public final nt AT(String str) {
        AppMethodBeat.i(111807);
        this.eBQ = x(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(111807);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(111808);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fiw);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eBQ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(111808);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(111809);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionScene:").append(this.fiw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("query:").append(this.eBQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(111809);
        return stringBuffer2;
    }
}
