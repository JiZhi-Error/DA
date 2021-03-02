package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ie extends a {
    public int eNt;
    public int eNu;
    public int eNv;
    public int eNw;
    public int eNx;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17504;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94824);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eNt);
        stringBuffer.append(",");
        stringBuffer.append(this.eNu);
        stringBuffer.append(",");
        stringBuffer.append(this.eNv);
        stringBuffer.append(",");
        stringBuffer.append(this.eNw);
        stringBuffer.append(",");
        stringBuffer.append(this.eNx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94824);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94825);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.eNt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResourceAutoDownload:").append(this.eNu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImageSaveLocal:").append(this.eNv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SightSaveLocal:").append(this.eNw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SightAutoPlay:").append(this.eNx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94825);
        return stringBuffer2;
    }
}
