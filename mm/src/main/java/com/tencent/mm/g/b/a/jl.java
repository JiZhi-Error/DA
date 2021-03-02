package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jl extends a {
    private long eIT = 0;
    private long eRA = 0;
    private long eRB = 0;
    private long eRC = 0;
    private long eRD = 0;
    private long eRt = 0;
    private int eRu = 0;
    private long eRv = 0;
    private long eRw = 0;
    private long eRx = 0;
    private long eRy = 0;
    private long eRz = 0;
    private long eoU = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17653;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118498);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eIT);
        stringBuffer.append(",");
        stringBuffer.append(this.eRt);
        stringBuffer.append(",");
        stringBuffer.append(this.eRu);
        stringBuffer.append(",");
        stringBuffer.append(this.eoU);
        stringBuffer.append(",");
        stringBuffer.append(this.eRv);
        stringBuffer.append(",");
        stringBuffer.append(this.eRw);
        stringBuffer.append(",");
        stringBuffer.append(this.eRx);
        stringBuffer.append(",");
        stringBuffer.append(this.eRy);
        stringBuffer.append(",");
        stringBuffer.append(this.eRz);
        stringBuffer.append(",");
        stringBuffer.append(this.eRA);
        stringBuffer.append(",");
        stringBuffer.append(this.eRB);
        stringBuffer.append(",");
        stringBuffer.append(this.eRC);
        stringBuffer.append(",");
        stringBuffer.append(this.eRD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118498);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118499);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ImageCount:").append(this.eIT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RemuxCostTime:").append(this.eRt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RemuxSucc:").append(this.eRu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoSize:").append(this.eoU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BitRateMode:").append(this.eRv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Fps:").append(this.eRw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BitRate:").append(this.eRx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IFrameInterval:").append(this.eRy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContainMusic:").append(this.eRz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputWidth:").append(this.eRA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputHeight:").append(this.eRB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SupportCQ:").append(this.eRC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("useX264:").append(this.eRD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118499);
        return stringBuffer2;
    }
}
