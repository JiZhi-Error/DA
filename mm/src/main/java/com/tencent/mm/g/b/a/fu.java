package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fu extends a {
    private long eDl = 0;
    private long eFY = 0;
    private long eHA = 0;
    private long eHB = 0;
    private String eHC = "";
    private long eHD = 0;
    private long eHE = 0;
    private long eHF = 0;
    private long eHG = 0;
    private String eHH = "";
    private long eHI = 0;
    private long eHJ = 0;
    private long eHK = 0;
    private long eHL = 0;
    private long eHM = 0;
    private String eHN = "";
    private long eHO = 0;
    private long eHP = 0;
    private long eHQ = 0;
    private long eHR = 0;
    private long eHS = 0;
    private String eHT = "";
    private long eHU = 0;
    private String eHV = "";
    private long eHW = 0;
    private String eHX = "";
    private long eHY = 0;
    private long eHZ = 0;
    private String eHy = "";
    private long eHz = 0;
    private long eIa = 0;
    private long eIb = 0;
    private long eIc;
    private long eId = 0;
    private int eoQ = 0;
    private long erW = 0;
    private long ewu = 0;
    private long exh = 0;
    private long ezk = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17149;
    }

    public final fu lm(int i2) {
        this.eoQ = i2;
        return this;
    }

    public final fu sL(String str) {
        AppMethodBeat.i(77800);
        this.eHy = x("BizUserName", str, true);
        AppMethodBeat.o(77800);
        return this;
    }

    public final fu pl(long j2) {
        this.eHz = j2;
        return this;
    }

    public final fu pm(long j2) {
        this.eHA = j2;
        return this;
    }

    public final fu pn(long j2) {
        this.eHB = j2;
        return this;
    }

    public final fu sM(String str) {
        AppMethodBeat.i(77801);
        this.eHC = x("VideoId", str, true);
        AppMethodBeat.o(77801);
        return this;
    }

    public final fu po(long j2) {
        this.ewu = j2;
        return this;
    }

    public final fu pp(long j2) {
        this.eHD = j2;
        return this;
    }

    public final fu pq(long j2) {
        this.ezk = j2;
        return this;
    }

    public final fu pr(long j2) {
        this.eDl = j2;
        return this;
    }

    public final fu ps(long j2) {
        this.eHE = j2;
        return this;
    }

    public final fu pt(long j2) {
        this.eHF = j2;
        return this;
    }

    public final fu pu(long j2) {
        this.erW = j2;
        return this;
    }

    public final fu pv(long j2) {
        this.eHG = j2;
        return this;
    }

    public final fu sN(String str) {
        AppMethodBeat.i(77802);
        this.eHH = x("PlayErrType", str, true);
        AppMethodBeat.o(77802);
        return this;
    }

    public final fu pw(long j2) {
        this.eHI = j2;
        return this;
    }

    public final fu px(long j2) {
        this.eHK = j2;
        return this;
    }

    public final fu py(long j2) {
        this.eFY = j2;
        return this;
    }

    public final fu agE() {
        this.eHO = 2;
        return this;
    }

    public final fu agF() {
        this.eHS = 1;
        return this;
    }

    public final fu agG() {
        this.eId = 101;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(77803);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eHy);
        stringBuffer.append(",");
        stringBuffer.append(this.eHz);
        stringBuffer.append(",");
        stringBuffer.append(this.eHA);
        stringBuffer.append(",");
        stringBuffer.append(this.exh);
        stringBuffer.append(",");
        stringBuffer.append(this.eHB);
        stringBuffer.append(",");
        stringBuffer.append(this.eHC);
        stringBuffer.append(",");
        stringBuffer.append(this.ewu);
        stringBuffer.append(",");
        stringBuffer.append(this.eHD);
        stringBuffer.append(",");
        stringBuffer.append(this.ezk);
        stringBuffer.append(",");
        stringBuffer.append(this.eDl);
        stringBuffer.append(",");
        stringBuffer.append(this.eHE);
        stringBuffer.append(",");
        stringBuffer.append(this.eHF);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eHG);
        stringBuffer.append(",");
        stringBuffer.append(this.eHH);
        stringBuffer.append(",");
        stringBuffer.append(this.eHI);
        stringBuffer.append(",");
        stringBuffer.append(this.eHJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eHK);
        stringBuffer.append(",");
        stringBuffer.append(this.eFY);
        stringBuffer.append(",");
        stringBuffer.append(this.eHL);
        stringBuffer.append(",");
        stringBuffer.append(this.eHM);
        stringBuffer.append(",");
        stringBuffer.append(this.eHN);
        stringBuffer.append(",");
        stringBuffer.append(this.eHO);
        stringBuffer.append(",");
        stringBuffer.append(this.eHP);
        stringBuffer.append(",");
        stringBuffer.append(this.eHQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eHR);
        stringBuffer.append(",");
        stringBuffer.append(this.eHS);
        stringBuffer.append(",");
        stringBuffer.append(this.eHT);
        stringBuffer.append(",");
        stringBuffer.append(this.eHU);
        stringBuffer.append(",");
        stringBuffer.append(this.eHV);
        stringBuffer.append(",");
        stringBuffer.append(this.eHW);
        stringBuffer.append(",");
        stringBuffer.append(this.eHX);
        stringBuffer.append(",");
        stringBuffer.append(this.eHY);
        stringBuffer.append(",");
        stringBuffer.append(this.eHZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eIa);
        stringBuffer.append(",");
        stringBuffer.append(this.eIb);
        stringBuffer.append(",");
        stringBuffer.append(this.eIc);
        stringBuffer.append(",");
        stringBuffer.append(this.eId);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(77803);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(77804);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.eoQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BizUserName:").append(this.eHy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgId:").append(this.eHz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Idx:").append(this.eHA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.exh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterId:").append(this.eHB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoId:").append(this.eHC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Duration:").append(this.ewu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventType:").append(this.eHD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTime:").append(this.ezk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RealPlayTime:").append(this.eDl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndPlayTime:").append(this.eHE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTimeInPage:").append(this.eHF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Subscene:").append(this.eHG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayErrType:").append(this.eHH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFans:").append(this.eHI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BufferingTime:").append(this.eHJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Resolution:").append(this.eHK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Width:").append(this.eFY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OrStatus:").append(this.eHL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HitBizuin:").append(this.eHM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HitVid:").append(this.eHN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayerType:").append(this.eHO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DefinitionOptions:").append(this.eHP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DefinitionAfter:").append(this.eHQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DefinitionBefore:").append(this.eHR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FullScreen:").append(this.eHS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoreVideosInfo:").append(this.eHT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionPlayTime:").append(this.eHU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DefinitionOptionsStr:").append(this.eHV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoreVideosSeq:").append(this.eHW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionIdStr:").append(this.eHX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GetPlayUrlErrType:").append(this.eHY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoRecommendType:").append(this.eHZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoExtraCount:").append(this.eIa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RemindTrafficSize:").append(this.eIb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TrafficReminderType:").append(this.eIc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemShowType:").append(this.eId);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77804);
        return stringBuffer2;
    }
}
