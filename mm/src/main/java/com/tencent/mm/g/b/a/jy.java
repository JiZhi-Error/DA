package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jy extends a {
    public long eDd = 0;
    public String eHs = "";
    private String ePe = "";
    public String eSU = "";
    public long eSV = 0;
    public String eSW = "";
    private int eSX;
    public String eSY = "";
    public String eSZ = "";
    public long eTa;
    public long eTb;
    public String eTc = "";
    public String eiB = "";
    public String ekv = "";
    public long enl = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 10994;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(199747);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eSU);
        stringBuffer.append(",");
        stringBuffer.append(this.ePe);
        stringBuffer.append(",");
        stringBuffer.append(this.eDd);
        stringBuffer.append(",");
        stringBuffer.append(this.eHs);
        stringBuffer.append(",");
        stringBuffer.append(this.eSV);
        stringBuffer.append(",");
        stringBuffer.append(this.eSW);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eSX);
        stringBuffer.append(",");
        stringBuffer.append(this.eSY);
        stringBuffer.append(",");
        stringBuffer.append(this.eSZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eTa);
        stringBuffer.append(",");
        stringBuffer.append(this.eTb);
        stringBuffer.append(",");
        stringBuffer.append(this.eTc);
        stringBuffer.append(",");
        stringBuffer.append(this.ekv);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(199747);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(199748);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Word:").append(this.eSU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpId:").append(this.ePe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Position:").append(this.eDd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("md5:").append(this.eHs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalCount:").append(this.eSV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Index:").append(this.eSW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLocal:").append(this.eSX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLocalSearch:").append(this.eSY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WordVersion:").append(this.eSZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WordType:").append(this.eTa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WordSize:").append(this.eTb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecSessionId:").append(this.eTc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatId:").append(this.ekv);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(199748);
        return stringBuffer2;
    }
}
