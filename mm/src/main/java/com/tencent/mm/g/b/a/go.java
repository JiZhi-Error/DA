package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class go extends a {
    public long eDV = 0;
    private String eDW = "";
    private String eDX = "";
    public long eEt = 0;
    public long eJT = 0;
    public long eJU = 0;
    public long eJV = 0;
    public long eJW = 0;
    public long eJX = 0;
    public long eJY = 0;
    public long eJZ = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15435;
    }

    public final go qx(long j2) {
        this.eDV = j2;
        return this;
    }

    public final go qy(long j2) {
        this.eJT = j2;
        return this;
    }

    public final go qz(long j2) {
        this.eEt = j2;
        return this;
    }

    public final long agO() {
        return this.eEt;
    }

    public final go qA(long j2) {
        this.eJU = j2;
        return this;
    }

    public final long agP() {
        return this.eJU;
    }

    public final go qB(long j2) {
        this.eJV = j2;
        return this;
    }

    public final go qC(long j2) {
        this.eJW = j2;
        return this;
    }

    public final go qD(long j2) {
        this.eJX = j2;
        return this;
    }

    public final long agQ() {
        return this.eJX;
    }

    public final go agR() {
        this.eJY = 1;
        return this;
    }

    public final go agS() {
        this.eJZ = 1;
        return this;
    }

    public final go uq(String str) {
        AppMethodBeat.i(200110);
        this.eDW = x("FileID", str, true);
        AppMethodBeat.o(200110);
        return this;
    }

    public final go ur(String str) {
        AppMethodBeat.i(200111);
        this.eDX = x("AesKey", str, true);
        AppMethodBeat.o(200111);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(120836);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eDV);
        stringBuffer.append(",");
        stringBuffer.append(this.eJT);
        stringBuffer.append(",");
        stringBuffer.append(this.eEt);
        stringBuffer.append(",");
        stringBuffer.append(this.eJU);
        stringBuffer.append(",");
        stringBuffer.append(this.eJV);
        stringBuffer.append(",");
        stringBuffer.append(this.eJW);
        stringBuffer.append(",");
        stringBuffer.append(this.eJX);
        stringBuffer.append(",");
        stringBuffer.append(this.eJY);
        stringBuffer.append(",");
        stringBuffer.append(this.eJZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eDW);
        stringBuffer.append(",");
        stringBuffer.append(this.eDX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(120836);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(120837);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Source:").append(this.eDV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CaptureTime:").append(this.eJT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Result:").append(this.eEt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadTime:").append(this.eJU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OCRTranslateTime:").append(this.eJV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalTime:").append(this.eJW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShowOriginCount:").append(this.eJX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasSaveResultImage:").append(this.eJY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasSaveOriginImage:").append(this.eJZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileID:").append(this.eDW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AesKey:").append(this.eDX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(120837);
        return stringBuffer2;
    }
}
