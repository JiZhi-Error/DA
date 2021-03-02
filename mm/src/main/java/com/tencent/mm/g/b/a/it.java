package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class it extends a {
    public String ePA = "";
    public long ePB;
    public int ePG;
    public int ePH;
    public long ePI;
    public long ePJ;
    public String eiB = "";
    public String eoK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21340;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(201839);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.ePA);
        stringBuffer.append(",");
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.ePB);
        stringBuffer.append(",");
        stringBuffer.append(this.ePG);
        stringBuffer.append(",");
        stringBuffer.append(this.ePH);
        stringBuffer.append(",");
        stringBuffer.append(this.ePI);
        stringBuffer.append(",");
        stringBuffer.append(this.ePJ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(201839);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(201840);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FoldedBlockId:").append(this.ePA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCount:").append(this.ePB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsExploded:").append(this.ePG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsClicked:").append(this.ePH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimelineBrowseFeedCount:").append(this.ePI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LocationIndex:").append(this.ePJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(201840);
        return stringBuffer2;
    }
}
