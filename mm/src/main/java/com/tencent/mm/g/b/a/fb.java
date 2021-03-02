package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fb extends a {
    private String eDW = "";
    private String eDX = "";
    private long eEU = 0;
    private long eEV = 0;
    private long eEW = 0;
    private long eEX = 0;
    private long eEY = 0;
    private String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19776;
    }

    public final fb na(long j2) {
        this.eEU = j2;
        return this;
    }

    public final long afT() {
        return this.eEU;
    }

    public final fb nb(long j2) {
        this.eEV = j2;
        return this;
    }

    public final fb rX(String str) {
        AppMethodBeat.i(231477);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(231477);
        return this;
    }

    public final String getSessionId() {
        return this.eiB;
    }

    public final fb nc(long j2) {
        this.eEW = j2;
        return this;
    }

    public final long afU() {
        return this.eEW;
    }

    public final fb nd(long j2) {
        this.eEX = j2;
        return this;
    }

    public final fb ne(long j2) {
        this.eEY = j2;
        return this;
    }

    public final long afV() {
        return this.eEY;
    }

    public final fb rY(String str) {
        AppMethodBeat.i(231478);
        this.eDW = x("FileID", str, true);
        AppMethodBeat.o(231478);
        return this;
    }

    public final String afW() {
        return this.eDW;
    }

    public final fb rZ(String str) {
        AppMethodBeat.i(231479);
        this.eDX = x("AesKey", str, true);
        AppMethodBeat.o(231479);
        return this;
    }

    public final String getAesKey() {
        return this.eDX;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231480);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEU);
        stringBuffer.append(",");
        stringBuffer.append(this.eEV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eEW);
        stringBuffer.append(",");
        stringBuffer.append(this.eEX);
        stringBuffer.append(",");
        stringBuffer.append(this.eEY);
        stringBuffer.append(",");
        stringBuffer.append(this.eDW);
        stringBuffer.append(",");
        stringBuffer.append(this.eDX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231480);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231481);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OpenPictureTime:").append(this.eEU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpenPictureType:").append(this.eEV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeIconTime:").append(this.eEW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PictureConcluding:").append(this.eEX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IconType:").append(this.eEY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileID:").append(this.eDW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AesKey:").append(this.eDX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231481);
        return stringBuffer2;
    }
}
