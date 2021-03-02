package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jf extends a {
    private String eQC = "";
    private long eQD = 0;
    private long eQE = 0;
    private long eQF = 0;
    private long eQG = 0;
    private String eQH = "";
    private long eQI = 0;
    private String eQJ = "";
    private String eQK = "";
    private String eQL = "";
    private long eQM = 0;
    private long eQN = 0;
    private long eQO = 1;
    private long eQP = 2;
    private long eQQ = 0;
    private long eQR = 0;
    private long eQS = 0;
    private long eQT = 0;
    private long eQU = 0;
    private String eQV = "";
    private long eQW = 0;
    private long eQX = 0;
    private long elI = 0;
    private long eoV = 0;
    private long epN = 0;
    private long epO = 0;
    private String epT = "";
    private long eqk = 0;
    private long etp = 0;
    private long ezS = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16638;
    }

    public final jf ru(long j2) {
        this.elI = j2;
        return this;
    }

    public final jf wC(String str) {
        AppMethodBeat.i(74975);
        this.eQC = x("PublishObjectId", str, true);
        AppMethodBeat.o(74975);
        return this;
    }

    public final String ahj() {
        return this.eQC;
    }

    public final jf rv(long j2) {
        this.etp = j2;
        return this;
    }

    public final jf rw(long j2) {
        this.eqk = j2;
        return this;
    }

    public final jf rx(long j2) {
        this.eQD = j2;
        return this;
    }

    public final jf ry(long j2) {
        this.eQE = j2;
        return this;
    }

    public final jf rz(long j2) {
        this.eoV = j2;
        return this;
    }

    public final jf rA(long j2) {
        this.ezS = j2;
        return this;
    }

    public final jf rB(long j2) {
        this.eQF = j2;
        return this;
    }

    public final jf rC(long j2) {
        this.eQG = j2;
        return this;
    }

    public final jf wD(String str) {
        AppMethodBeat.i(74976);
        this.eQH = x("MusicId", str, true);
        AppMethodBeat.o(74976);
        return this;
    }

    public final jf rD(long j2) {
        this.eQI = j2;
        return this;
    }

    public final jf wE(String str) {
        AppMethodBeat.i(74977);
        this.eQJ = x("PositionInfo", str, true);
        AppMethodBeat.o(74977);
        return this;
    }

    public final jf rE(long j2) {
        this.epN = j2;
        return this;
    }

    public final jf wF(String str) {
        AppMethodBeat.i(74978);
        this.eQK = x("PositionLatitude", str, true);
        AppMethodBeat.o(74978);
        return this;
    }

    public final jf wG(String str) {
        AppMethodBeat.i(74979);
        this.eQL = x("PositionLongitude", str, true);
        AppMethodBeat.o(74979);
        return this;
    }

    public final jf wH(String str) {
        AppMethodBeat.i(74980);
        this.epT = x("ActionTrace", str, true);
        AppMethodBeat.o(74980);
        return this;
    }

    public final jf rF(long j2) {
        this.eQM = j2;
        return this;
    }

    public final jf ahk() {
        this.eQN = 1;
        return this;
    }

    public final jf rG(long j2) {
        this.epO = j2;
        return this;
    }

    public final jf rH(long j2) {
        this.eQO = j2;
        return this;
    }

    public final jf rI(long j2) {
        this.eQP = j2;
        return this;
    }

    public final jf rJ(long j2) {
        this.eQQ = j2;
        return this;
    }

    public final jf ahl() {
        this.eQR = 1;
        return this;
    }

    public final jf ahm() {
        this.eQS = 1;
        return this;
    }

    public final jf wI(String str) {
        AppMethodBeat.i(74981);
        this.eQV = x("PhotoWidthHeightScales", str, true);
        AppMethodBeat.o(74981);
        return this;
    }

    public final jf rK(long j2) {
        this.eQX = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(74982);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elI);
        stringBuffer.append(",");
        stringBuffer.append(this.eQC);
        stringBuffer.append(",");
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eQD);
        stringBuffer.append(",");
        stringBuffer.append(this.eQE);
        stringBuffer.append(",");
        stringBuffer.append(this.eoV);
        stringBuffer.append(",");
        stringBuffer.append(this.ezS);
        stringBuffer.append(",");
        stringBuffer.append(this.eQF);
        stringBuffer.append(",");
        stringBuffer.append(this.eQG);
        stringBuffer.append(",");
        stringBuffer.append(this.eQH);
        stringBuffer.append(",");
        stringBuffer.append(this.eQI);
        stringBuffer.append(",");
        stringBuffer.append(this.eQJ);
        stringBuffer.append(",");
        stringBuffer.append(this.epN);
        stringBuffer.append(",");
        stringBuffer.append(this.eQK);
        stringBuffer.append(",");
        stringBuffer.append(this.eQL);
        stringBuffer.append(",");
        stringBuffer.append(this.epT);
        stringBuffer.append(",");
        stringBuffer.append(this.eQM);
        stringBuffer.append(",");
        stringBuffer.append(this.eQN);
        stringBuffer.append(",");
        stringBuffer.append(this.epO);
        stringBuffer.append(",");
        stringBuffer.append(this.eQO);
        stringBuffer.append(",");
        stringBuffer.append(this.eQP);
        stringBuffer.append(",");
        stringBuffer.append(this.eQQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eQR);
        stringBuffer.append(",");
        stringBuffer.append(this.eQS);
        stringBuffer.append(",");
        stringBuffer.append(this.eQT);
        stringBuffer.append(",");
        stringBuffer.append(this.eQU);
        stringBuffer.append(",");
        stringBuffer.append(this.eQV);
        stringBuffer.append(",");
        stringBuffer.append(this.eQW);
        stringBuffer.append(",");
        stringBuffer.append(this.eQX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(74982);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(74983);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.elI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublishObjectId:").append(this.eQC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartEditTime:").append(this.eQD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SendTime:").append(this.eQE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoDuration:").append(this.eoV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoSource:").append(this.ezS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EmojiWidgetCount:").append(this.eQF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TextWidgetCount:").append(this.eQG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MusicId:").append(this.eQH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MusicOrder:").append(this.eQI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PositionInfo:").append(this.eQJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MusicRequestId:").append(this.epN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PositionLatitude:").append(this.eQK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PositionLongitude:").append(this.eQL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTrace:").append(this.epT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoObjectId:").append(this.eQM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsClickSearchMusic:").append(this.eQN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSearchMusic:").append(this.epO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPublicTimeLine:").append(this.eQO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublishVideoType:").append(this.eQP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PhotoCount:").append(this.eQQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsShowLyric:").append(this.eQR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsAddTextIntro:").append(this.eQS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddTextIntroWordCount:").append(this.eQT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddEmojToTextIntroCount:").append(this.eQU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PhotoWidthHeightScales:").append(this.eQV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoCompoundTime:").append(this.eQW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPortraitVideo:").append(this.eQX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(74983);
        return stringBuffer2;
    }
}
