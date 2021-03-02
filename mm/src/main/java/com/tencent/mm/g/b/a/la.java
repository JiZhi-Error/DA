package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class la extends a {
    public long eiR = 0;
    public long erW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15509;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118318);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eiR);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118318);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118319);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTime:").append(this.eiR);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118319);
        return stringBuffer2;
    }
}
