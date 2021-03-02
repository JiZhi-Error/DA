package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cc extends a {
    private String eiB = "";
    private String eoo = "";
    private String eoz = "";
    private String erH = "";
    private long erW;
    private String etv = "";
    private long etw;
    private String ety = "";
    private String euL = "";
    private String euM = "";
    private long euN;
    private long euO;
    private String euP = "";
    private long euQ;
    private String euR = "";
    private long euS;
    private String euT = "";
    private long euU;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19993;
    }

    public final cc fp(long j2) {
        this.erW = j2;
        return this;
    }

    public final cc kQ(String str) {
        AppMethodBeat.i(208953);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208953);
        return this;
    }

    public final cc kR(String str) {
        AppMethodBeat.i(208954);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(208954);
        return this;
    }

    public final cc kS(String str) {
        AppMethodBeat.i(208955);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(208955);
        return this;
    }

    public final cc kT(String str) {
        AppMethodBeat.i(208956);
        this.euL = x("ClickFeedid", str, true);
        AppMethodBeat.o(208956);
        return this;
    }

    public final cc kU(String str) {
        AppMethodBeat.i(208957);
        this.euM = x("AllFeedInfo", str, true);
        AppMethodBeat.o(208957);
        return this;
    }

    public final cc fq(long j2) {
        this.euN = j2;
        return this;
    }

    public final cc fr(long j2) {
        this.euO = j2;
        return this;
    }

    public final cc kV(String str) {
        AppMethodBeat.i(208958);
        this.euP = x("PageTag", str, true);
        AppMethodBeat.o(208958);
        return this;
    }

    public final cc kW(String str) {
        AppMethodBeat.i(208959);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(208959);
        return this;
    }

    public final cc fs(long j2) {
        this.euQ = j2;
        return this;
    }

    public final cc kX(String str) {
        AppMethodBeat.i(208960);
        this.euR = x("ScreenInfo", str, true);
        AppMethodBeat.o(208960);
        return this;
    }

    public final cc ft(long j2) {
        this.euS = j2;
        return this;
    }

    public final cc kY(String str) {
        AppMethodBeat.i(208961);
        this.euT = x("RecommendWording", str, true);
        AppMethodBeat.o(208961);
        return this;
    }

    public final cc kZ(String str) {
        AppMethodBeat.i(208962);
        this.etv = x("GroupID", str, true);
        AppMethodBeat.o(208962);
        return this;
    }

    public final cc fu(long j2) {
        this.etw = j2;
        return this;
    }

    public final cc la(String str) {
        AppMethodBeat.i(208963);
        this.ety = x("ActivityID", str, true);
        AppMethodBeat.o(208963);
        return this;
    }

    public final cc PJ(long j2) {
        this.euU = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208964);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.euL);
        stringBuffer.append(",");
        stringBuffer.append(this.euM);
        stringBuffer.append(",");
        stringBuffer.append(this.euN);
        stringBuffer.append(",");
        stringBuffer.append(this.euO);
        stringBuffer.append(",");
        stringBuffer.append(this.euP);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.euQ);
        stringBuffer.append(",");
        stringBuffer.append(this.euR);
        stringBuffer.append(",");
        stringBuffer.append(this.euS);
        stringBuffer.append(",");
        stringBuffer.append(this.euT);
        stringBuffer.append(",");
        stringBuffer.append(this.etv);
        stringBuffer.append(",");
        stringBuffer.append(this.etw);
        stringBuffer.append(",");
        stringBuffer.append(this.ety);
        stringBuffer.append(",");
        stringBuffer.append(this.euU);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208964);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208965);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickFeedid:").append(this.euL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AllFeedInfo:").append(this.euM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RefreshTime:").append(this.euN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTimeStamp:").append(this.euO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageTag:").append(this.euP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MediaType:").append(this.euQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ScreenInfo:").append(this.euR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecommendType:").append(this.euS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecommendWording:").append(this.euT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupID:").append(this.etv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TrackType:").append(this.etw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActivityID:").append(this.ety);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActivitySortType:").append(this.euU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208965);
        return stringBuffer2;
    }
}
