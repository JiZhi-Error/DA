package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class j extends a {
    public long ekc = 0;
    private long ekd = 0;
    public long eke = 0;
    public long ekf = 0;
    public long ekg = 0;
    public long ekh = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16113;
    }

    public final j bK(long j2) {
        AppMethodBeat.i(19851);
        this.ekc = j2;
        super.bj("FirstInputTimeStampMs", this.ekc);
        AppMethodBeat.o(19851);
        return this;
    }

    public final j bL(long j2) {
        AppMethodBeat.i(19853);
        this.ekd = j2;
        super.bj("LastInputTimeStampMs", this.ekd);
        AppMethodBeat.o(19853);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(19855);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekc);
        stringBuffer.append(",");
        stringBuffer.append(this.ekd);
        stringBuffer.append(",");
        stringBuffer.append(this.eke);
        stringBuffer.append(",");
        stringBuffer.append(this.ekf);
        stringBuffer.append(",");
        stringBuffer.append(this.ekg);
        stringBuffer.append(",");
        stringBuffer.append(this.ekh);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(19855);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(19856);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FirstInputTimeStampMs:").append(this.ekc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastInputTimeStampMs:").append(this.ekd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SendStampMs:").append(this.eke);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickCount:").append(this.ekf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TextLength:").append(this.ekg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EmojiCount:").append(this.ekh);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(19856);
        return stringBuffer2;
    }

    public final j abX() {
        AppMethodBeat.i(19852);
        j bK = bK(Util.nowMilliSecond());
        AppMethodBeat.o(19852);
        return bK;
    }

    public final j abY() {
        AppMethodBeat.i(19854);
        j bL = bL(Util.nowMilliSecond());
        AppMethodBeat.o(19854);
        return bL;
    }
}
