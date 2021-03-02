package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class eo extends a {
    public long eDQ;
    public String eDR = "";
    public String eDS = "";
    public long eDT;
    public long eDU;
    public long eiR;
    public long ejA;
    public String eno = "";
    public String enr = "";
    public String ens = "";
    public String enu = "";
    public long erW;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20257;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187793);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eno);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eDQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eDR);
        stringBuffer.append(",");
        stringBuffer.append(this.eDS);
        stringBuffer.append(",");
        stringBuffer.append(this.enr);
        stringBuffer.append(",");
        stringBuffer.append(this.ens);
        stringBuffer.append(",");
        stringBuffer.append(this.eDT);
        stringBuffer.append(",");
        stringBuffer.append(this.enu);
        stringBuffer.append(",");
        stringBuffer.append(this.eiR);
        stringBuffer.append(",");
        stringBuffer.append(this.eDU);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187793);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187794);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RequestId:").append(this.eno);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasReddot:").append(this.eDQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HitWordList:").append(this.eDR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HitWordVersion:").append(this.eDS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgId:").append(this.enr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgFromUsername:").append(this.ens);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatType:").append(this.eDT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatRoomID:").append(this.enu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTime:").append(this.eiR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgContentLength:").append(this.eDU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187794);
        return stringBuffer2;
    }
}
