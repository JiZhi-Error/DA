package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nm extends a {
    public long eiR;
    public long erY;
    public long fgG;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20734;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187821);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fgG);
        stringBuffer.append(",");
        stringBuffer.append(this.eiR);
        stringBuffer.append(",");
        stringBuffer.append(this.erY);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187821);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187822);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WordCount:").append(this.fgG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTime:").append(this.eiR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187822);
        return stringBuffer2;
    }
}
