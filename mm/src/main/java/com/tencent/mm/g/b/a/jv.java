package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jv extends a {
    private long eGY = 0;
    private long eGZ = 0;
    private long eHc = 0;
    private String eRb = "";
    private long eSA = 0;
    private long eSB = 0;
    private long eSC = 0;
    private long eSD = 0;
    private long eSE = 0;
    private long eSF = 0;
    private long eSG = 0;
    private long eSH = 0;
    private long eSI = 0;
    private long eSJ = 0;
    private long eSK = 0;
    private long eSL = 0;
    private long eSM = 0;
    private String eSv = "";
    private String eSw = "";
    private long eSx = 0;
    private long eSy = 0;
    private long eSz = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16664;
    }

    public final jv xg(String str) {
        AppMethodBeat.i(118524);
        this.eSv = x("FileUrl", str, true);
        AppMethodBeat.o(118524);
        return this;
    }

    public final String ahT() {
        return this.eSv;
    }

    public final String ahU() {
        return this.eSw;
    }

    public final jv xh(String str) {
        AppMethodBeat.i(118525);
        this.eRb = x("Tid", str, true);
        AppMethodBeat.o(118525);
        return this;
    }

    public final String ahV() {
        return this.eRb;
    }

    public final jv sW(long j2) {
        this.eSx = j2;
        return this;
    }

    public final long ahW() {
        return this.eSx;
    }

    public final jv sX(long j2) {
        this.eSy = j2;
        return this;
    }

    public final long ahX() {
        return this.eSy;
    }

    public final long ahY() {
        return this.eHc;
    }

    public final long ahZ() {
        return this.eSz;
    }

    public final long aia() {
        return this.eSA;
    }

    public final long aib() {
        return this.eSC;
    }

    public final long aic() {
        return this.eGY;
    }

    public final long aid() {
        return this.eGZ;
    }

    public final long aie() {
        return this.eSD;
    }

    public final long aif() {
        return this.eSE;
    }

    public final long aig() {
        return this.eSF;
    }

    public final long aih() {
        return this.eSH;
    }

    public final long aii() {
        return this.eSI;
    }

    public final long aij() {
        return this.eSJ;
    }

    public final long aik() {
        return this.eSK;
    }

    public final long ail() {
        return this.eSL;
    }

    public final jv sY(long j2) {
        this.eSM = j2;
        return this;
    }

    public final long aim() {
        return this.eSM;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118526);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eSv);
        stringBuffer.append(",");
        stringBuffer.append(this.eSw);
        stringBuffer.append(",");
        stringBuffer.append(this.eRb);
        stringBuffer.append(",");
        stringBuffer.append(this.eSx);
        stringBuffer.append(",");
        stringBuffer.append(this.eSy);
        stringBuffer.append(",");
        stringBuffer.append(this.eHc);
        stringBuffer.append(",");
        stringBuffer.append(this.eSz);
        stringBuffer.append(",");
        stringBuffer.append(this.eSA);
        stringBuffer.append(",");
        stringBuffer.append(this.eSB);
        stringBuffer.append(",");
        stringBuffer.append(this.eSC);
        stringBuffer.append(",");
        stringBuffer.append(this.eGY);
        stringBuffer.append(",");
        stringBuffer.append(this.eGZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eSD);
        stringBuffer.append(",");
        stringBuffer.append(this.eSE);
        stringBuffer.append(",");
        stringBuffer.append(this.eSF);
        stringBuffer.append(",");
        stringBuffer.append(this.eSG);
        stringBuffer.append(",");
        stringBuffer.append(this.eSH);
        stringBuffer.append(",");
        stringBuffer.append(this.eSI);
        stringBuffer.append(",");
        stringBuffer.append(this.eSJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eSK);
        stringBuffer.append(",");
        stringBuffer.append(this.eSL);
        stringBuffer.append(",");
        stringBuffer.append(this.eSM);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118526);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118527);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FileUrl:").append(this.eSv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoMd5:").append(this.eSw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tid:").append(this.eRb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadStartTime:").append(this.eSx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadEndTime:").append(this.eSy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginSize:").append(this.eHc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginDuration:").append(this.eSz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginVideoBitrate:").append(this.eSA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginAudioBitrate:").append(this.eSB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginFps:").append(this.eSC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginWidth:").append(this.eGY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginHeight:").append(this.eGZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CPSize:").append(this.eSD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CPDuration:").append(this.eSE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CPVideoBitrate:").append(this.eSF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CPAudioBitrate:").append(this.eSG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CPFps:").append(this.eSH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CPWidth:").append(this.eSI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CPHight:").append(this.eSJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SendSource:").append(this.eSK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginAudioChannel:").append(this.eSL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetWorkType:").append(this.eSM);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118527);
        return stringBuffer2;
    }
}
