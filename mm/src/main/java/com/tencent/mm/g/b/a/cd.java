package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cd extends a {
    private String eiC = "";
    private String eoj = "";
    private String eoo = "";
    private String erU = "";
    private String erV = "";
    private long erW;
    private String etv = "";
    private long etw;
    private String ety = "";
    private long euJ;
    private long euN;
    private String euP = "";
    private long euS;
    private String euT = "";
    private long euU;
    private long euV;
    private String euW = "";
    private long euX;
    private long euY;
    private long euZ;
    private long eva;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19997;
    }

    public final cd fv(long j2) {
        this.erW = j2;
        return this;
    }

    public final cd lb(String str) {
        AppMethodBeat.i(208966);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(208966);
        return this;
    }

    public final cd lc(String str) {
        AppMethodBeat.i(208967);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(208967);
        return this;
    }

    public final cd ld(String str) {
        AppMethodBeat.i(208968);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(208968);
        return this;
    }

    public final cd le(String str) {
        AppMethodBeat.i(208969);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(208969);
        return this;
    }

    public final cd fw(long j2) {
        this.euV = j2;
        return this;
    }

    public final cd lf(String str) {
        AppMethodBeat.i(208970);
        this.euW = x("IndexInfo", str, true);
        AppMethodBeat.o(208970);
        return this;
    }

    public final cd fx(long j2) {
        this.euN = j2;
        return this;
    }

    public final cd fy(long j2) {
        this.euX = j2;
        return this;
    }

    public final cd fz(long j2) {
        this.euY = j2;
        return this;
    }

    public final cd fA(long j2) {
        this.euZ = j2;
        return this;
    }

    public final cd fB(long j2) {
        this.eva = j2;
        return this;
    }

    public final cd lg(String str) {
        AppMethodBeat.i(208971);
        this.euP = x("PageTag", str, true);
        AppMethodBeat.o(208971);
        return this;
    }

    public final cd lh(String str) {
        AppMethodBeat.i(208972);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(208972);
        return this;
    }

    public final cd fC(long j2) {
        this.euJ = j2;
        return this;
    }

    public final cd fD(long j2) {
        this.euS = j2;
        return this;
    }

    public final cd li(String str) {
        AppMethodBeat.i(208973);
        this.euT = x("RecommendWording", str, true);
        AppMethodBeat.o(208973);
        return this;
    }

    public final cd lj(String str) {
        AppMethodBeat.i(208974);
        this.etv = x("GroupID", str, true);
        AppMethodBeat.o(208974);
        return this;
    }

    public final cd fE(long j2) {
        this.etw = j2;
        return this;
    }

    public final cd lk(String str) {
        AppMethodBeat.i(208975);
        this.ety = x("ActivityID", str, true);
        AppMethodBeat.o(208975);
        return this;
    }

    public final cd PK(long j2) {
        this.euU = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208976);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.euV);
        stringBuffer.append(",");
        stringBuffer.append(this.euW);
        stringBuffer.append(",");
        stringBuffer.append(this.euN);
        stringBuffer.append(",");
        stringBuffer.append(this.euX);
        stringBuffer.append(",");
        stringBuffer.append(this.euY);
        stringBuffer.append(",");
        stringBuffer.append(this.euZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eva);
        stringBuffer.append(",");
        stringBuffer.append(this.euP);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.euJ);
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
        AppMethodBeat.o(208976);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208977);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Index:").append(this.euV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IndexInfo:").append(this.euW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RefreshTime:").append(this.euN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeTime:").append(this.euX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartExposeTime:").append(this.euY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndExposeTime:").append(this.euZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCnt:").append(this.eva);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageTag:").append(this.euP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mediaType:").append(this.euJ);
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
        AppMethodBeat.o(208977);
        return stringBuffer2;
    }
}
