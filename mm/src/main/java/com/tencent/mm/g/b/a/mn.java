package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class mn extends a {
    public String eJx = "";
    public long eYW;
    public String fbm = "";
    public long fcC;
    public long fcD;
    public long fcE;
    public String fcF = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18852;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43631);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fcC);
        stringBuffer.append(",");
        stringBuffer.append(this.fcD);
        stringBuffer.append(",");
        stringBuffer.append(this.fcE);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.fbm);
        stringBuffer.append(",");
        stringBuffer.append(this.fcF);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43631);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43632);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("visitScene:").append(this.fcC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("businessScene:").append(this.fcD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("innerScene:").append(this.fcE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("path:").append(this.fbm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("openRate:").append(this.fcF);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43632);
        return stringBuffer2;
    }
}
