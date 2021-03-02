package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nh extends a {
    public long erY = 0;
    public long fgr = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17040;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187819);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.fgr);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187819);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187820);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TemplateVersion:").append(this.fgr);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187820);
        return stringBuffer2;
    }
}
