package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kk extends a {
    private long eAD = 2020;
    private long eVA;
    private long eVB;
    private long eVC;
    private long eVD;
    private long eVE;
    private long eVF;
    private long eVG;
    private String eVH = "";
    private String eVI = "";
    private long eVJ = 2020;
    private long eVK;
    private long eVL;
    private String eVM = "";
    private String eVN = "";
    private long eVO;
    private long eVP;
    private String eVQ = "";
    private long eVR;
    private long eVS;
    private int eVT = 0;
    private int eVU = 0;
    private long eVV;
    private long eVW;
    private long eVX = 0;
    private long eVY = 1;
    private long eVZ = 0;
    private String ezR = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21177;
    }

    public final kk tl(long j2) {
        this.eVA = j2;
        return this;
    }

    public final kk tm(long j2) {
        this.eVB = j2;
        return this;
    }

    public final kk tn(long j2) {
        this.eVC = j2;
        return this;
    }

    public final kk to(long j2) {
        this.eVD = j2;
        return this;
    }

    public final kk tp(long j2) {
        this.eVF = j2;
        return this;
    }

    public final kk tq(long j2) {
        this.eVG = j2;
        return this;
    }

    public final kk xG(String str) {
        AppMethodBeat.i(190441);
        this.eVH = x("OutputVideoResolution", str, true);
        AppMethodBeat.o(190441);
        return this;
    }

    public final kk xH(String str) {
        AppMethodBeat.i(190442);
        this.eVI = x("OutputMediaInfo", str, true);
        AppMethodBeat.o(190442);
        return this;
    }

    public final kk xI(String str) {
        AppMethodBeat.i(190443);
        this.ezR = x("EditId", str, true);
        AppMethodBeat.o(190443);
        return this;
    }

    public final kk tr(long j2) {
        this.eVJ = j2;
        return this;
    }

    public final kk ts(long j2) {
        this.eAD = j2;
        return this;
    }

    public final kk tt(long j2) {
        this.eVK = j2;
        return this;
    }

    public final kk tu(long j2) {
        AppMethodBeat.i(190444);
        this.eVL = j2;
        super.bi("RemuxVideoTimeMs", this.eVL);
        AppMethodBeat.o(190444);
        return this;
    }

    public final kk tv(long j2) {
        AppMethodBeat.i(190445);
        this.eVO = j2;
        super.bi("UpdateCompositionTimeMs", this.eVO);
        AppMethodBeat.o(190445);
        return this;
    }

    public final kk xJ(String str) {
        AppMethodBeat.i(190446);
        this.eVQ = x("IntelligentFilterSceneResult", str, true);
        AppMethodBeat.o(190446);
        return this;
    }

    public final kk tw(long j2) {
        this.eVR = j2;
        return this;
    }

    public final kk tx(long j2) {
        this.eVS = j2;
        return this;
    }

    public final kk lP(int i2) {
        this.eVT = i2;
        return this;
    }

    public final kk lQ(int i2) {
        this.eVU = i2;
        return this;
    }

    public final kk ty(long j2) {
        this.eVV = j2;
        return this;
    }

    public final kk tz(long j2) {
        this.eVW = j2;
        return this;
    }

    public final kk tA(long j2) {
        this.eVX = j2;
        return this;
    }

    public final kk aio() {
        this.eVY = 0;
        return this;
    }

    public final kk tB(long j2) {
        this.eVZ = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(190447);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eVA);
        stringBuffer.append(",");
        stringBuffer.append(this.eVB);
        stringBuffer.append(",");
        stringBuffer.append(this.eVC);
        stringBuffer.append(",");
        stringBuffer.append(this.eVD);
        stringBuffer.append(",");
        stringBuffer.append(this.eVE);
        stringBuffer.append(",");
        stringBuffer.append(this.eVF);
        stringBuffer.append(",");
        stringBuffer.append(this.eVG);
        stringBuffer.append(",");
        stringBuffer.append(this.eVH);
        stringBuffer.append(",");
        stringBuffer.append(this.eVI);
        stringBuffer.append(",");
        stringBuffer.append(this.ezR);
        stringBuffer.append(",");
        stringBuffer.append(this.eVJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eAD);
        stringBuffer.append(",");
        stringBuffer.append(this.eVK);
        stringBuffer.append(",");
        stringBuffer.append(this.eVL);
        stringBuffer.append(",");
        stringBuffer.append(this.eVM);
        stringBuffer.append(",");
        stringBuffer.append(this.eVN);
        stringBuffer.append(",");
        stringBuffer.append(this.eVO);
        stringBuffer.append(",");
        stringBuffer.append(this.eVP);
        stringBuffer.append(",");
        stringBuffer.append(this.eVQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eVR);
        stringBuffer.append(",");
        stringBuffer.append(this.eVS);
        stringBuffer.append(",");
        stringBuffer.append(this.eVT);
        stringBuffer.append(",");
        stringBuffer.append(this.eVU);
        stringBuffer.append(",");
        stringBuffer.append(this.eVV);
        stringBuffer.append(",");
        stringBuffer.append(this.eVW);
        stringBuffer.append(",");
        stringBuffer.append(this.eVX);
        stringBuffer.append(",");
        stringBuffer.append(this.eVY);
        stringBuffer.append(",");
        stringBuffer.append(this.eVZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(190447);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(190448);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RenderLibVersion:").append(this.eVA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PagCreateCount:").append(this.eVB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PagCreateSuccessCount:").append(this.eVC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("avgRenderTime:").append(this.eVD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NormalFrameRenderTime:").append(this.eVE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TargetFPS:").append(this.eVF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputVideoFPS:").append(this.eVG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputVideoResolution:").append(this.eVH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputMediaInfo:").append(this.eVI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditId:").append(this.ezR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputResult:").append(this.eVJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RemuxType:").append(this.eAD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OutputVideoDurationMs:").append(this.eVK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RemuxVideoTimeMs:").append(this.eVL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalVideoGOPSize:").append(this.eVM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoSeekTimeMsStr:").append(this.eVN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UpdateCompositionTimeMs:").append(this.eVO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IntelligentFilterSceneTimeMs:").append(this.eVP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IntelligentFilterSceneResult:").append(this.eVQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RenderFrames:").append(this.eVR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalRenderTime:").append(this.eVS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLongVideo:").append(this.eVT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HevcOption:").append(this.eVU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioQuality:").append(this.eVV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoQuality:").append(this.eVW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSoftEncode:").append(this.eVX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileExist:").append(this.eVY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFallbackSize:").append(this.eVZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(190448);
        return stringBuffer2;
    }
}
