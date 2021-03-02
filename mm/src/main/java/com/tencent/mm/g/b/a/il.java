package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class il extends a {
    public String eOG = "";
    public String eOH = "";
    public String eOI = "";
    public String eOJ = "";
    public String eOK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18670;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94834);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eOG);
        stringBuffer.append(",");
        stringBuffer.append(this.eOH);
        stringBuffer.append(",");
        stringBuffer.append(this.eOI);
        stringBuffer.append(",");
        stringBuffer.append(this.eOJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eOK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94834);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94835);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PublishId:").append(this.eOG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentIdList:").append(this.eOH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EmojiIdList:").append(this.eOI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickEmojiIconIdList:").append(this.eOJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickEmojiIdList:").append(this.eOK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94835);
        return stringBuffer2;
    }
}
