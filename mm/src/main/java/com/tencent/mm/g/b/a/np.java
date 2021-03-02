package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class np extends a {
    public long fid = 0;
    public long fie = 0;
    public long fif = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16909;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121783);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fid);
        stringBuffer.append(",");
        stringBuffer.append(this.fie);
        stringBuffer.append(",");
        stringBuffer.append(this.fif);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121783);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121784);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptId:").append(this.fid);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupId:").append(this.fie);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExptSeq:").append(this.fif);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121784);
        return stringBuffer2;
    }
}
