package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class h extends a {
    public String ejC = "";
    public int ejD = 0;
    public int ejE = 0;
    public int ejF = 0;
    public int ejG = 0;
    public int ejH = 0;
    public int ejI = 0;
    public int ejJ = 0;
    public int ejK = 0;
    public int ejL = 0;
    public int ejM = 0;
    public int ejN = 0;
    public String ejO = "";
    public int ejP = 0;
    public int ejQ = 0;
    public long ejR = 0;
    public long ejS = 0;
    public long ejT = 0;
    public long ejU = 0;
    public String ejV = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20667;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(223489);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejC);
        stringBuffer.append(",");
        stringBuffer.append(this.ejD);
        stringBuffer.append(",");
        stringBuffer.append(this.ejE);
        stringBuffer.append(",");
        stringBuffer.append(this.ejF);
        stringBuffer.append(",");
        stringBuffer.append(this.ejG);
        stringBuffer.append(",");
        stringBuffer.append(this.ejH);
        stringBuffer.append(",");
        stringBuffer.append(this.ejI);
        stringBuffer.append(",");
        stringBuffer.append(this.ejJ);
        stringBuffer.append(",");
        stringBuffer.append(this.ejK);
        stringBuffer.append(",");
        stringBuffer.append(this.ejL);
        stringBuffer.append(",");
        stringBuffer.append(this.ejM);
        stringBuffer.append(",");
        stringBuffer.append(this.ejN);
        stringBuffer.append(",");
        stringBuffer.append(this.ejO);
        stringBuffer.append(",");
        stringBuffer.append(this.ejP);
        stringBuffer.append(",");
        stringBuffer.append(this.ejQ);
        stringBuffer.append(",");
        stringBuffer.append(this.ejR);
        stringBuffer.append(",");
        stringBuffer.append(this.ejS);
        stringBuffer.append(",");
        stringBuffer.append(this.ejT);
        stringBuffer.append(",");
        stringBuffer.append(this.ejU);
        stringBuffer.append(",");
        stringBuffer.append(this.ejV);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(223489);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(223490);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaId:").append(this.ejC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSend:").append(this.ejD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalLen:").append(this.ejE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimeCost:").append(this.ejF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileType:").append(this.ejG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.ejH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BzScene:").append(this.ejI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BizType:").append(this.ejJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Chattype:").append(this.ejK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Advideoflag:").append(this.ejL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Largesvideo:").append(this.ejM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RequestVideoFormat:").append(this.ejN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsScene:").append(this.ejO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsImageDownload:").append(this.ejP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoTaskType:").append(this.ejQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimeCostL:").append(this.ejR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CDNCallbackStartTime:").append(this.ejS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CDNCallbackEndTime:").append(this.ejT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ThreadId:").append(this.ejU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TaskName:").append(this.ejV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(223490);
        return stringBuffer2;
    }
}
