package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jn extends a {
    private String eRJ = "";
    public long erR = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16657;
    }

    public final jn sj(long j2) {
        this.erR = j2;
        return this;
    }

    public final jn wR(String str) {
        AppMethodBeat.i(118502);
        this.eRJ = x("StoryId", str, true);
        AppMethodBeat.o(118502);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118503);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erR);
        stringBuffer.append(",");
        stringBuffer.append(this.eRJ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118503);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118504);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PageType:").append(this.erR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StoryId:").append(this.eRJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118504);
        return stringBuffer2;
    }
}
