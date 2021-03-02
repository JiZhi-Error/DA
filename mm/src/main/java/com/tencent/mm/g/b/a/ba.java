package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ba extends a {
    public long erm;
    public long ern;
    public long ero;
    public long erp = 0;
    public long erq = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18053;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(73526);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erm);
        stringBuffer.append(",");
        stringBuffer.append(this.ern);
        stringBuffer.append(",");
        stringBuffer.append(this.ero);
        stringBuffer.append(",");
        stringBuffer.append(this.erp);
        stringBuffer.append(",");
        stringBuffer.append(this.erq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(73526);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(73527);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("favid:").append(this.erm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("favsize:").append(this.ern);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cachecnt:").append(this.ero);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cachelsize:").append(this.erp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cachesuccess:").append(this.erq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73527);
        return stringBuffer2;
    }
}
