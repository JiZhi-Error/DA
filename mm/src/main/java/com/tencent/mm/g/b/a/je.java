package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class je extends a {
    private long eJU = 0;
    private String eQA = "";
    private String eQB = "";
    private long eQx = 0;
    private long eQy = 0;
    private long eQz = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16688;
    }

    public final je rs(long j2) {
        this.eJU = j2;
        return this;
    }

    public final long agP() {
        return this.eJU;
    }

    public final je rt(long j2) {
        this.eQz = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118483);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eQx);
        stringBuffer.append(",");
        stringBuffer.append(this.eQy);
        stringBuffer.append(",");
        stringBuffer.append(this.eJU);
        stringBuffer.append(",");
        stringBuffer.append(this.eQz);
        stringBuffer.append(",");
        stringBuffer.append(this.eQA);
        stringBuffer.append(",");
        stringBuffer.append(this.eQB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118483);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118484);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ComposeTime:").append(this.eQx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ComposeErrorType:").append(this.eQy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadTime:").append(this.eJU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadErrorType:").append(this.eQz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ComposeErrorTypeStr:").append(this.eQA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadErrorTypeStr:").append(this.eQB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118484);
        return stringBuffer2;
    }
}
