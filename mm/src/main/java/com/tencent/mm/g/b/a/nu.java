package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nu extends a {
    public String eBQ = "";
    public String els = "";
    public long erw = 0;
    public long fiA = 0;
    public String fiB = "";
    public long fiC = 0;
    public String fix = "";
    public long fiy = 0;
    public String fiz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16033;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116496);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.fix);
        stringBuffer.append(",");
        stringBuffer.append(this.fiy);
        stringBuffer.append(",");
        stringBuffer.append(this.fiz);
        stringBuffer.append(",");
        stringBuffer.append(this.fiA);
        stringBuffer.append(",");
        stringBuffer.append(this.fiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eBQ);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.fiC);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116496);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116497);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchid:").append(this.fix);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("businesstype:").append(this.fiy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("docid:").append(this.fiz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timestampInMs:").append(this.fiA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("expand2:").append(this.fiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("query:").append(this.eBQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("resultsubtype:").append(this.fiC);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116497);
        return stringBuffer2;
    }
}
