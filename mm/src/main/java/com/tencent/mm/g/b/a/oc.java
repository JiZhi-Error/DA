package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class oc extends a {
    public String enR = "";
    public long exo = 0;
    public String fgP = "";
    public String fiT = "";
    public long fiU = 0;
    public long fiV = 0;
    public long fiW = 0;
    public long fiX = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15778;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116508);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.exo);
        stringBuffer.append(",");
        stringBuffer.append(this.fiT);
        stringBuffer.append(",");
        stringBuffer.append(this.fgP);
        stringBuffer.append(",");
        stringBuffer.append(this.fiU);
        stringBuffer.append(",");
        stringBuffer.append(this.fiV);
        stringBuffer.append(",");
        stringBuffer.append(this.fiW);
        stringBuffer.append(",");
        stringBuffer.append(this.fiX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116508);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116509);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appVersion:").append(this.exo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("pkgMd5:").append(this.fiT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("downloadUrl:").append(this.fgP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isSuccess:").append(this.fiU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timeCostInMs:").append(this.fiV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timeStampInMs:").append(this.fiW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("totalLen:").append(this.fiX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116509);
        return stringBuffer2;
    }
}
