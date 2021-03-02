package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

/* renamed from: com.tencent.mm.g.b.a.if  reason: invalid class name */
public final class Cif extends a {
    private int eAa = -1;
    private int eNA = -1;
    private int eNB = -1;
    private int eNC = -1;
    private String eND = "";
    private String eNE = "";
    private String eNF = "";
    private String eNG = "";
    private String eNH = "";
    private int eNI = -1;
    private int eNJ = -1;
    private int eNK = -1;
    private int eNL = -1;
    private int eNM = -1;
    private int eNN = -1;
    private int eNO = -1;
    private int eNP = -1;
    private int eNQ = -1;
    private int eNR = -1;
    private int eNS = -1;
    private String eNT = "";
    private String eNU = "";
    private String eNV = "";
    private long eNW = 0;
    private String eNX = "";
    private String eNY = "";
    private String eNZ = "";
    private String eNy = "";
    private int eNz = -1;
    private long eOa = 0;
    private long eOb = 0;
    private long eOc = 0;
    private long eOd = 0;
    private long eOe = 0;
    private long eOf = 0;
    private long eOg = 0;
    private long eOh = 0;
    private long eOi = 0;
    private long eOj = 0;
    private int eoQ = -1;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21729;
    }

    public final Cif lq(int i2) {
        this.eoQ = i2;
        return this;
    }

    public final Cif lr(int i2) {
        this.eAa = i2;
        return this;
    }

    public final Cif vN(String str) {
        AppMethodBeat.i(237178);
        this.eNy = x("RouterMap", str, true);
        AppMethodBeat.o(237178);
        return this;
    }

    public final Cif ls(int i2) {
        this.eNz = i2;
        return this;
    }

    public final Cif lt(int i2) {
        this.eNA = i2;
        return this;
    }

    public final Cif lu(int i2) {
        this.eNB = i2;
        return this;
    }

    public final Cif lv(int i2) {
        this.eNC = i2;
        return this;
    }

    public final Cif vO(String str) {
        AppMethodBeat.i(237179);
        this.eND = x("RecordHighBitrateVideo", str, true);
        AppMethodBeat.o(237179);
        return this;
    }

    public final Cif vP(String str) {
        AppMethodBeat.i(237180);
        this.eNE = x("RecordLowBitrateVideo", str, true);
        AppMethodBeat.o(237180);
        return this;
    }

    public final Cif vQ(String str) {
        AppMethodBeat.i(237181);
        this.eNF = x("RouterLog", str, true);
        AppMethodBeat.o(237181);
        return this;
    }

    public final Cif vR(String str) {
        AppMethodBeat.i(237182);
        this.eNG = x("EditPathList", str, true);
        AppMethodBeat.o(237182);
        return this;
    }

    public final Cif vS(String str) {
        AppMethodBeat.i(237183);
        this.eNH = x("EditElementList", str, true);
        AppMethodBeat.o(237183);
        return this;
    }

    public final Cif lw(int i2) {
        this.eNI = i2;
        return this;
    }

    public final Cif lx(int i2) {
        this.eNJ = i2;
        return this;
    }

    public final Cif ly(int i2) {
        this.eNK = i2;
        return this;
    }

    public final Cif lz(int i2) {
        this.eNL = i2;
        return this;
    }

    public final Cif ahb() {
        this.eNM = 0;
        return this;
    }

    public final Cif lA(int i2) {
        this.eNN = i2;
        return this;
    }

    public final Cif lB(int i2) {
        this.eNO = i2;
        return this;
    }

    public final Cif lC(int i2) {
        this.eNP = i2;
        return this;
    }

    public final Cif lD(int i2) {
        this.eNQ = i2;
        return this;
    }

    public final Cif lE(int i2) {
        this.eNR = i2;
        return this;
    }

    public final Cif lF(int i2) {
        this.eNS = i2;
        return this;
    }

    public final Cif vT(String str) {
        AppMethodBeat.i(237184);
        this.eNT = x("RecordMuxerType", str, true);
        AppMethodBeat.o(237184);
        return this;
    }

    public final Cif vU(String str) {
        AppMethodBeat.i(237185);
        this.eNU = x("RemuxMuxerType", str, true);
        AppMethodBeat.o(237185);
        return this;
    }

    public final Cif vV(String str) {
        AppMethodBeat.i(237186);
        this.eNV = x("RemuxType", str, true);
        AppMethodBeat.o(237186);
        return this;
    }

    public final Cif qX(long j2) {
        this.eNW = j2;
        return this;
    }

    public final Cif vW(String str) {
        AppMethodBeat.i(237187);
        this.eNX = x("ConfigParam", str, true);
        AppMethodBeat.o(237187);
        return this;
    }

    public final Cif vX(String str) {
        AppMethodBeat.i(237188);
        this.eNY = x("PhotoAlbumVideoInfo", str, true);
        AppMethodBeat.o(237188);
        return this;
    }

    public final Cif vY(String str) {
        AppMethodBeat.i(237189);
        this.eNZ = x("MixVideoInfo", str, true);
        AppMethodBeat.o(237189);
        return this;
    }

    public final Cif qY(long j2) {
        this.eOa = j2;
        return this;
    }

    public final long ahc() {
        return this.eOa;
    }

    public final Cif qZ(long j2) {
        this.eOb = j2;
        return this;
    }

    public final long ahd() {
        return this.eOb;
    }

    public final Cif ra(long j2) {
        this.eOc = j2;
        return this;
    }

    public final long ahe() {
        return this.eOc;
    }

    public final Cif rb(long j2) {
        this.eOd = j2;
        return this;
    }

    public final long ahf() {
        return this.eOd;
    }

    public final Cif rc(long j2) {
        this.eOe = j2;
        return this;
    }

    public final Cif rd(long j2) {
        this.eOf = j2;
        return this;
    }

    public final Cif re(long j2) {
        this.eOg = j2;
        return this;
    }

    public final Cif rf(long j2) {
        this.eOh = j2;
        return this;
    }

    public final Cif rg(long j2) {
        this.eOi = j2;
        return this;
    }

    public final Cif rh(long j2) {
        this.eOj = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(237190);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eAa);
        stringBuffer.append(",");
        stringBuffer.append(this.eNy);
        stringBuffer.append(",");
        stringBuffer.append(this.eNz);
        stringBuffer.append(",");
        stringBuffer.append(this.eNA);
        stringBuffer.append(",");
        stringBuffer.append(this.eNB);
        stringBuffer.append(",");
        stringBuffer.append(this.eNC);
        stringBuffer.append(",");
        stringBuffer.append(this.eND);
        stringBuffer.append(",");
        stringBuffer.append(this.eNE);
        stringBuffer.append(",");
        stringBuffer.append(this.eNF);
        stringBuffer.append(",");
        stringBuffer.append(this.eNG);
        stringBuffer.append(",");
        stringBuffer.append(this.eNH);
        stringBuffer.append(",");
        stringBuffer.append(this.eNI);
        stringBuffer.append(",");
        stringBuffer.append(this.eNJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eNK);
        stringBuffer.append(",");
        stringBuffer.append(this.eNL);
        stringBuffer.append(",");
        stringBuffer.append(this.eNM);
        stringBuffer.append(",");
        stringBuffer.append(this.eNN);
        stringBuffer.append(",");
        stringBuffer.append(this.eNO);
        stringBuffer.append(",");
        stringBuffer.append(this.eNP);
        stringBuffer.append(",");
        stringBuffer.append(this.eNQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eNR);
        stringBuffer.append(",");
        stringBuffer.append(this.eNS);
        stringBuffer.append(",");
        stringBuffer.append(this.eNT);
        stringBuffer.append(",");
        stringBuffer.append(this.eNU);
        stringBuffer.append(",");
        stringBuffer.append(this.eNV);
        stringBuffer.append(",");
        stringBuffer.append(this.eNW);
        stringBuffer.append(",");
        stringBuffer.append(this.eNX);
        stringBuffer.append(",");
        stringBuffer.append(this.eNY);
        stringBuffer.append(",");
        stringBuffer.append(this.eNZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eOa);
        stringBuffer.append(",");
        stringBuffer.append(this.eOb);
        stringBuffer.append(",");
        stringBuffer.append(this.eOc);
        stringBuffer.append(",");
        stringBuffer.append(this.eOd);
        stringBuffer.append(",");
        stringBuffer.append(this.eOe);
        stringBuffer.append(",");
        stringBuffer.append(this.eOf);
        stringBuffer.append(",");
        stringBuffer.append(this.eOg);
        stringBuffer.append(",");
        stringBuffer.append(this.eOh);
        stringBuffer.append(",");
        stringBuffer.append(this.eOi);
        stringBuffer.append(",");
        stringBuffer.append(this.eOj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(237190);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(237191);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.eoQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterScene:").append(this.eAa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RouterMap:").append(this.eNy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecordCpuCrop:").append(this.eNz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecordDaemon:").append(this.eNA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecordCameraType:").append(this.eNB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecordCameraRet:").append(this.eNC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecordHighBitrateVideo:").append(this.eND);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecordLowBitrateVideo:").append(this.eNE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RouterLog:").append(this.eNF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditPathList:").append(this.eNG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditElementList:").append(this.eNH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ABAPramsUseDaemon:").append(this.eNI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UseDaemon:").append(this.eNJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForegroundMux:").append(this.eNK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MuxResult:").append(this.eNL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SNSDoubleCheck:").append(this.eNM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpToThirdApp:").append(this.eNN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitType:").append(this.eNO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CameraOpenCost:").append(this.eNP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CameraFirstFrameCost:").append(this.eNQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HighRecordStopWaitTime:").append(this.eNR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LowRecordStopWaitTime:").append(this.eNS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecordMuxerType:").append(this.eNT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RemuxMuxerType:").append(this.eNU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RemuxType:").append(this.eNV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SendType:").append(this.eNW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConfigParam:").append(this.eNX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PhotoAlbumVideoInfo:").append(this.eNY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MixVideoInfo:").append(this.eNZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterRecordTimeStamp:").append(this.eOa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpenCameraTimeStamp:").append(this.eOb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartPreviewTimeStamp:").append(this.eOc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreviewSuccessTImeStamp:").append(this.eOd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartRecordTimeStamp:").append(this.eOe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinishRecordTImeStamp:").append(this.eOf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CropStartTimeStamp:").append(this.eOg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CropEndTimeStamp:").append(this.eOh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartMuxTImeStamp:").append(this.eOi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinishMuxTimeStamp:").append(this.eOj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(237191);
        return stringBuffer2;
    }
}
