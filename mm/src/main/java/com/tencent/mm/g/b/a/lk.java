package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lk extends a {
    public String eXp = "";
    public String eYE = "";
    public long eYF;
    public long eYG;
    public String eiB = "";
    public long enl;
    public String eno = "";
    public long etp;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21174;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187817);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.eYE);
        stringBuffer.append(",");
        stringBuffer.append(this.eno);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eXp);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eYF);
        stringBuffer.append(",");
        stringBuffer.append(this.eYG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187817);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187818);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSceneId:").append(this.eYE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RequestId:").append(this.eno);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QueryKey:").append(this.eXp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContentType:").append(this.eYF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTimeStamp:").append(this.eYG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187818);
        return stringBuffer2;
    }
}
