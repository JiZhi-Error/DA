package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class io extends a {
    public String eOQ = "";
    public long eOR = 0;
    public long eOS = 0;
    public long eOT = 0;
    public long eOU = 0;
    public long eOV = 0;
    public long eOW = 0;
    public long eOX = 0;
    public long eOY = 0;
    public long eOZ = 0;
    public long ePa = 0;
    public long ePb = 0;
    public long ePc = 0;
    public long ePd = 0;
    private String ePe = "";
    private String ePf = "";
    private String ePg = "";
    private String ePh = "";
    public long ePi = 0;
    public long ePj = 0;
    public String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18448;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94840);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eOQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eOR);
        stringBuffer.append(",");
        stringBuffer.append(this.eOS);
        stringBuffer.append(",");
        stringBuffer.append(this.eOT);
        stringBuffer.append(",");
        stringBuffer.append(this.eOU);
        stringBuffer.append(",");
        stringBuffer.append(this.eOV);
        stringBuffer.append(",");
        stringBuffer.append(this.eOW);
        stringBuffer.append(",");
        stringBuffer.append(this.eOX);
        stringBuffer.append(",");
        stringBuffer.append(this.eOY);
        stringBuffer.append(",");
        stringBuffer.append(this.eOZ);
        stringBuffer.append(",");
        stringBuffer.append(this.ePa);
        stringBuffer.append(",");
        stringBuffer.append(this.ePb);
        stringBuffer.append(",");
        stringBuffer.append(this.ePc);
        stringBuffer.append(",");
        stringBuffer.append(this.ePd);
        stringBuffer.append(",");
        stringBuffer.append(this.ePe);
        stringBuffer.append(",");
        stringBuffer.append(this.ePf);
        stringBuffer.append(",");
        stringBuffer.append(this.ePg);
        stringBuffer.append(",");
        stringBuffer.append(this.ePh);
        stringBuffer.append(",");
        stringBuffer.append(this.ePi);
        stringBuffer.append(",");
        stringBuffer.append(this.ePj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94840);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94841);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublicID:").append(this.eOQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublicType:").append(this.eOR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SawLikeCount:").append(this.eOS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RealLikeCount:").append(this.eOT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SawLikeLines:").append(this.eOU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RealLikeLines:").append(this.eOV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLikeCollapsed:").append(this.eOW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SawCommentCount:").append(this.eOX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLiked:").append(this.eOY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsComment:").append(this.eOZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadAction:").append(this.ePa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickSpread:").append(this.ePb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BeginTimestamp:").append(this.ePc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndTimestamp:").append(this.ePd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpId:").append(this.ePe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupId:").append(this.ePf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SawLikeContent:").append(this.ePg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RealLikeContent:").append(this.ePh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CfgCollapseLines:").append(this.ePi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickShrink:").append(this.ePj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94841);
        return stringBuffer2;
    }
}
