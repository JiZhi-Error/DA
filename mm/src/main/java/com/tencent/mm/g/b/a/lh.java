package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lh extends a {
    public long eYp = 0;
    public String eYq = "";
    public long eYr = 0;
    public String eYs = "";
    public long eYt;
    public long eYu;
    public String eYv = "";
    public long enl = 0;
    public long eua = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20998;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187802);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eua);
        stringBuffer.append(",");
        stringBuffer.append(this.eYp);
        stringBuffer.append(",");
        stringBuffer.append(this.eYq);
        stringBuffer.append(",");
        stringBuffer.append(this.eYr);
        stringBuffer.append(",");
        stringBuffer.append(this.eYs);
        stringBuffer.append(",");
        stringBuffer.append(this.eYt);
        stringBuffer.append(",");
        stringBuffer.append(this.eYu);
        stringBuffer.append(",");
        stringBuffer.append(this.eYv);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187802);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187803);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStamp:").append(this.eua);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResultType:").append(this.eYp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResultQuery:").append(this.eYq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareScene:").append(this.eYr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareSceneId:").append(this.eYs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CreateTime:").append(this.eYt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimelineEnterSource:").append(this.eYu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SearchSessionId:").append(this.eYv);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187803);
        return stringBuffer2;
    }
}
