package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class iv extends a {
    public String eQe = "";
    public long eQf = 0;
    public long eQg = 0;
    public long eQh = 0;
    public long eQi = 0;
    public String eQj = "";
    public String eQk = "";
    public String emL = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18246;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(110276);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.eQe);
        stringBuffer.append(",");
        stringBuffer.append(this.eQf);
        stringBuffer.append(",");
        stringBuffer.append(this.eQg);
        stringBuffer.append(",");
        stringBuffer.append(this.eQh);
        stringBuffer.append(",");
        stringBuffer.append(this.eQi);
        stringBuffer.append(",");
        stringBuffer.append(this.eQj);
        stringBuffer.append(",");
        stringBuffer.append(this.eQk);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(110276);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(110277);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LaunchUserName:").append(this.eQe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eQf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("deleteCount:").append(this.eQg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("addCount:").append(this.eQh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditScene:").append(this.eQi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Identifier:").append(this.eQj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Punctuation:").append(this.eQk);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(110277);
        return stringBuffer2;
    }
}
