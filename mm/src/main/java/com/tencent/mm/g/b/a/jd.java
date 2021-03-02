package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jd extends a {
    public long eQv = 0;
    public long eQw = 0;
    public String eoK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16656;
    }

    public final String getUserName() {
        return this.eoK;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118481);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.eQv);
        stringBuffer.append(",");
        stringBuffer.append(this.eQw);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118481);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118482);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreviewEnterScene:").append(this.eQv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasUnreadStoryTips:").append(this.eQw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118482);
        return stringBuffer2;
    }
}
