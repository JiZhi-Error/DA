package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class is extends a {
    private String ePA = "";
    public long ePB;
    public long ePC;
    public String ePD = "";
    public String ePE = "";
    public long ePF;
    public String eiB = "";
    public String eoK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21341;
    }

    public final is ws(String str) {
        AppMethodBeat.i(201836);
        this.ePA = x("FoldedBlockId", str, true);
        AppMethodBeat.o(201836);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(201837);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.ePA);
        stringBuffer.append(",");
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.ePB);
        stringBuffer.append(",");
        stringBuffer.append(this.ePC);
        stringBuffer.append(",");
        stringBuffer.append(this.ePD);
        stringBuffer.append(",");
        stringBuffer.append(this.ePE);
        stringBuffer.append(",");
        stringBuffer.append(this.ePF);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(201837);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(201838);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FoldedBlockId:").append(this.ePA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCount:").append(this.ePB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseFeedCount:").append(this.ePC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedList:").append(this.ePD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseFeedList:").append(this.ePE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseTime:").append(this.ePF);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(201838);
        return stringBuffer2;
    }
}
