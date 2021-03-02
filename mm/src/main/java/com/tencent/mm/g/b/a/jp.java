package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jp extends a {
    public long eQM = 0;
    public long eRW = 0;
    public long eRX = 0;
    public long eRY = 0;
    private long eRZ = 0;
    private long eSa = 0;
    private long eSb = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16844;
    }

    public final jp ahG() {
        this.eRW = 0;
        return this;
    }

    public final jp ahH() {
        this.eRX = 0;
        return this;
    }

    public final jp ahI() {
        this.eRY = 0;
        return this;
    }

    public final jp sy(long j2) {
        this.eRZ = j2;
        return this;
    }

    public final jp sz(long j2) {
        this.eSa = j2;
        return this;
    }

    public final jp ahJ() {
        this.eQM = 0;
        return this;
    }

    public final long ahK() {
        return this.eQM;
    }

    public final jp sA(long j2) {
        this.eSb = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118510);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eRW);
        stringBuffer.append(",");
        stringBuffer.append(this.eRX);
        stringBuffer.append(",");
        stringBuffer.append(this.eRY);
        stringBuffer.append(",");
        stringBuffer.append(this.eRZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eSa);
        stringBuffer.append(",");
        stringBuffer.append(this.eQM);
        stringBuffer.append(",");
        stringBuffer.append(this.eSb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118510);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118511);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickMyProfileTime:").append(this.eRW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickCameraTime:").append(this.eRX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickGuidePageTime:").append(this.eRY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isProfileRedPoint:").append(this.eRZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isCameraRedPoint:").append(this.eSa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoObjectId:").append(this.eQM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isStoryCommentRedDot:").append(this.eSb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118511);
        return stringBuffer2;
    }
}
