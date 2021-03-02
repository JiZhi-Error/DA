package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class c extends a {
    public String eiP = "";
    public String eiQ = "";
    public long eiR;
    public String eiS = "";
    public String eiT = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21520;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238828);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiP);
        stringBuffer.append(",");
        stringBuffer.append(this.eiQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eiR);
        stringBuffer.append(",");
        stringBuffer.append(this.eiS);
        stringBuffer.append(",");
        stringBuffer.append(this.eiT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238828);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238829);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InputJson:").append(this.eiP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputJson:").append(this.eiQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTime:").append(this.eiR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ModelMd5:").append(this.eiS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriInputJson:").append(this.eiT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238829);
        return stringBuffer2;
    }
}
