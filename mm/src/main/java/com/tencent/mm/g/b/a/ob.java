package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ob extends a {
    public long fiR = 0;
    public String fiS = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15779;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116506);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fiR);
        stringBuffer.append(",");
        stringBuffer.append(this.fiS);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116506);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116507);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("canPreload:").append(this.fiR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("existPkgInfo:").append(this.fiS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116507);
        return stringBuffer2;
    }
}
