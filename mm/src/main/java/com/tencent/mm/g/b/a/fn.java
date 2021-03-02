package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fn extends a {
    private long eFY;
    private long eFZ;
    private long eGA;
    private long eGB;
    private long eGC = 0;
    private long eGD = 0;
    private long eGE = 0;
    private long eGF = 0;
    private long eGG;
    private long eGa;
    private long eGb;
    private long eGc;
    private long eGd;
    private long eGe;
    private long eGf;
    private long eGg;
    private long eGh;
    private long eGi;
    private long eGj;
    private long eGk;
    private long eGl;
    private String eGm = "";
    private long eGn;
    private long eGo;
    private long eGp;
    private long eGq;
    private long eGr;
    private String eGs = "";
    private long eGt;
    private String eGu = "";
    private String eGv = "";
    private long eGw;
    private long eGx;
    private long eGy;
    private long eGz;
    private long elI = 0;
    private long eoW;
    private long eoX;
    private long eoY;
    private long etK = 0;
    private String ewp = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21607;
    }

    public final fn su(String str) {
        AppMethodBeat.i(241586);
        this.ewp = x("LiveId", str, true);
        AppMethodBeat.o(241586);
        return this;
    }

    public final String adj() {
        return this.ewp;
    }

    public final fn oi(long j2) {
        this.eFY = j2;
        return this;
    }

    public final long getWidth() {
        return this.eFY;
    }

    public final fn oj(long j2) {
        this.eFZ = j2;
        return this;
    }

    public final long getHeight() {
        return this.eFZ;
    }

    public final fn ok(long j2) {
        this.eoY = j2;
        return this;
    }

    public final long agb() {
        return this.eoY;
    }

    public final fn ol(long j2) {
        this.eGa = j2;
        return this;
    }

    public final long agc() {
        return this.eGa;
    }

    public final fn om(long j2) {
        this.eoW = j2;
        return this;
    }

    public final long agd() {
        return this.eoW;
    }

    public final fn on(long j2) {
        this.eoX = j2;
        return this;
    }

    public final long age() {
        return this.eoX;
    }

    public final fn oo(long j2) {
        this.eGb = j2;
        return this;
    }

    public final long agf() {
        return this.eGb;
    }

    public final fn op(long j2) {
        this.eGc = j2;
        return this;
    }

    public final long agg() {
        return this.eGc;
    }

    public final fn oq(long j2) {
        this.eGd = j2;
        return this;
    }

    public final long agh() {
        return this.eGd;
    }

    public final fn or(long j2) {
        this.eGe = j2;
        return this;
    }

    public final long agi() {
        return this.eGe;
    }

    public final fn os(long j2) {
        this.eGf = j2;
        return this;
    }

    public final long agj() {
        return this.eGf;
    }

    public final fn ot(long j2) {
        this.eGg = j2;
        return this;
    }

    public final long agk() {
        return this.eGg;
    }

    public final fn ou(long j2) {
        this.eGh = j2;
        return this;
    }

    public final long agl() {
        return this.eGh;
    }

    public final fn ov(long j2) {
        this.eGi = j2;
        return this;
    }

    public final long agm() {
        return this.eGi;
    }

    public final fn ow(long j2) {
        this.eGj = j2;
        return this;
    }

    public final long agn() {
        return this.eGj;
    }

    public final fn ox(long j2) {
        AppMethodBeat.i(241587);
        this.eGk = j2;
        super.bi("TotalPlayTimeMs", this.eGk);
        AppMethodBeat.o(241587);
        return this;
    }

    public final fn oy(long j2) {
        AppMethodBeat.i(241588);
        this.eGl = j2;
        super.bi("TotalWaitTimeMs", this.eGl);
        AppMethodBeat.o(241588);
        return this;
    }

    public final long ago() {
        return this.eGl;
    }

    public final fn oz(long j2) {
        AppMethodBeat.i(241589);
        this.eGn = j2;
        long j3 = this.eGn;
        if (j3 <= 0) {
            super.jN("LiveStartPlayTimeSec", String.valueOf(j3));
        } else if (j3 >= 3600) {
            super.jN("LiveStartPlayTimeSec", String.valueOf(j3));
        }
        AppMethodBeat.o(241589);
        return this;
    }

    public final long agp() {
        return this.eGn;
    }

    public final fn oA(long j2) {
        AppMethodBeat.i(241590);
        this.eGo = j2;
        super.bi("FirstFrameTimeMs", this.eGo);
        AppMethodBeat.o(241590);
        return this;
    }

    public final long agq() {
        return this.eGo;
    }

    public final fn oB(long j2) {
        this.eGp = j2;
        return this;
    }

    public final long agr() {
        return this.eGp;
    }

    public final fn oC(long j2) {
        this.eGq = j2;
        return this;
    }

    public final long ags() {
        return this.eGq;
    }

    public final fn oD(long j2) {
        this.eGr = j2;
        return this;
    }

    public final long agt() {
        return this.eGr;
    }

    public final fn sv(String str) {
        AppMethodBeat.i(241591);
        this.eGs = x("CdnSvrIp", str, true);
        AppMethodBeat.o(241591);
        return this;
    }

    public final String agu() {
        return this.eGs;
    }

    public final fn oE(long j2) {
        this.eGt = j2;
        return this;
    }

    public final long agv() {
        return this.eGt;
    }

    public final fn sw(String str) {
        AppMethodBeat.i(241592);
        this.eGu = x("CpuUsageProcess", str, true);
        AppMethodBeat.o(241592);
        return this;
    }

    public final String agw() {
        return this.eGu;
    }

    public final fn sx(String str) {
        AppMethodBeat.i(241593);
        this.eGv = x("CpuUsageDevice", str, true);
        AppMethodBeat.o(241593);
        return this;
    }

    public final String agx() {
        return this.eGv;
    }

    public final fn oF(long j2) {
        this.eGw = j2;
        return this;
    }

    public final fn oG(long j2) {
        this.eGy = j2;
        return this;
    }

    public final fn oH(long j2) {
        this.eGz = j2;
        return this;
    }

    public final fn oI(long j2) {
        this.eGA = j2;
        return this;
    }

    public final fn oJ(long j2) {
        this.eGC = j2;
        return this;
    }

    public final fn agy() {
        this.eGD = 2;
        return this;
    }

    public final fn oK(long j2) {
        this.eGE = j2;
        return this;
    }

    public final fn oL(long j2) {
        this.eGF = j2;
        return this;
    }

    public final fn oM(long j2) {
        this.elI = j2;
        return this;
    }

    public final fn oN(long j2) {
        this.etK = j2;
        return this;
    }

    public final long agz() {
        return this.etK;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(241594);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ewp);
        stringBuffer.append(",");
        stringBuffer.append(this.eFY);
        stringBuffer.append(",");
        stringBuffer.append(this.eFZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eoY);
        stringBuffer.append(",");
        stringBuffer.append(this.eGa);
        stringBuffer.append(",");
        stringBuffer.append(this.eoW);
        stringBuffer.append(",");
        stringBuffer.append(this.eoX);
        stringBuffer.append(",");
        stringBuffer.append(this.eGb);
        stringBuffer.append(",");
        stringBuffer.append(this.eGc);
        stringBuffer.append(",");
        stringBuffer.append(this.eGd);
        stringBuffer.append(",");
        stringBuffer.append(this.eGe);
        stringBuffer.append(",");
        stringBuffer.append(this.eGf);
        stringBuffer.append(",");
        stringBuffer.append(this.eGg);
        stringBuffer.append(",");
        stringBuffer.append(this.eGh);
        stringBuffer.append(",");
        stringBuffer.append(this.eGi);
        stringBuffer.append(",");
        stringBuffer.append(this.eGj);
        stringBuffer.append(",");
        stringBuffer.append(this.eGk);
        stringBuffer.append(",");
        stringBuffer.append(this.eGl);
        stringBuffer.append(",");
        stringBuffer.append(this.eGm);
        stringBuffer.append(",");
        stringBuffer.append(this.eGn);
        stringBuffer.append(",");
        stringBuffer.append(this.eGo);
        stringBuffer.append(",");
        stringBuffer.append(this.eGp);
        stringBuffer.append(",");
        stringBuffer.append(this.eGq);
        stringBuffer.append(",");
        stringBuffer.append(this.eGr);
        stringBuffer.append(",");
        stringBuffer.append(this.eGs);
        stringBuffer.append(",");
        stringBuffer.append(this.eGt);
        stringBuffer.append(",");
        stringBuffer.append(this.eGu);
        stringBuffer.append(",");
        stringBuffer.append(this.eGv);
        stringBuffer.append(",");
        stringBuffer.append(this.eGw);
        stringBuffer.append(",");
        stringBuffer.append(this.eGx);
        stringBuffer.append(",");
        stringBuffer.append(this.eGy);
        stringBuffer.append(",");
        stringBuffer.append(this.eGz);
        stringBuffer.append(",");
        stringBuffer.append(this.eGA);
        stringBuffer.append(",");
        stringBuffer.append(this.eGB);
        stringBuffer.append(",");
        stringBuffer.append(this.eGC);
        stringBuffer.append(",");
        stringBuffer.append(this.eGD);
        stringBuffer.append(",");
        stringBuffer.append(this.eGE);
        stringBuffer.append(",");
        stringBuffer.append(this.eGF);
        stringBuffer.append(",");
        stringBuffer.append(this.eGG);
        stringBuffer.append(",");
        stringBuffer.append(this.elI);
        stringBuffer.append(",");
        stringBuffer.append(this.etK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(241594);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(241595);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LiveId:").append(this.ewp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Width:").append(this.eFY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Height:").append(this.eFZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoFps:").append(this.eoY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoGop:").append(this.eGa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoBitrate:").append(this.eoW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioBitrate:").append(this.eoX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetSpeed:").append(this.eGb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoCache:").append(this.eGc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioCache:").append(this.eGd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoSumCacheSize:").append(this.eGe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioVideoPlayInterval:").append(this.eGf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioVideoRecvInterval:").append(this.eGg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioCacheThreshold:").append(this.eGh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetJitter:").append(this.eGi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QualityLevel:").append(this.eGj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalPlayTimeMs:").append(this.eGk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalWaitTimeMs:").append(this.eGl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitDetails:").append(this.eGm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveStartPlayTimeSec:").append(this.eGn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstFrameTimeMs:").append(this.eGo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConnectMs:").append(this.eGp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RttMs:").append(this.eGq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkId:").append(this.eGr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CdnSvrIp:").append(this.eGs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CdnSvrPort:").append(this.eGt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpuUsageProcess:").append(this.eGu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpuUsageDevice:").append(this.eGv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BufferCount:").append(this.eGw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RegainAvgTime:").append(this.eGx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PeakVideoBitrate:").append(this.eGy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ValleyVideoBitrate:").append(this.eGz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PeakAudioBitrate:").append(this.eGA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ValleyAudioBitrate:").append(this.eGB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitWithoutPlay:").append(this.eGC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportType:").append(this.eGD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportInterval:").append(this.eGE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveProtocol:").append(this.eGF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoFormat:").append(this.eGG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetType:").append(this.elI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Role:").append(this.etK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(241595);
        return stringBuffer2;
    }
}
