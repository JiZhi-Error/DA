package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cp extends a {
    private long ejA;
    private String eoC = "";
    private String eoK = "";
    private String eoo = "";
    private String eoz = "";
    private String erD = "";
    private String erF = "";
    private long erG;
    private String erH = "";
    private long erN;
    private long erO;
    private long erQ;
    private long euV;
    private long ewY;
    private long ewZ;
    private String exa = "";
    private long exb;
    private String exc = "";
    private String exd = "";
    private long exe;
    private String exf = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21053;
    }

    public final cp mQ(String str) {
        AppMethodBeat.i(220125);
        this.eoK = x("UserName", str, true);
        AppMethodBeat.o(220125);
        return this;
    }

    public final String getUserName() {
        return this.eoK;
    }

    public final cp hy(long j2) {
        this.ewY = j2;
        return this;
    }

    public final cp mR(String str) {
        AppMethodBeat.i(220126);
        this.erD = x("FeedID", str, true);
        AppMethodBeat.o(220126);
        return this;
    }

    public final String acf() {
        return this.erD;
    }

    public final cp mS(String str) {
        AppMethodBeat.i(220127);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(220127);
        return this;
    }

    public final String acl() {
        return this.eoC;
    }

    public final cp hz(long j2) {
        this.erO = j2;
        return this;
    }

    public final long acs() {
        return this.erO;
    }

    public final cp hA(long j2) {
        this.ejA = j2;
        return this;
    }

    public final long act() {
        return this.ejA;
    }

    public final cp mT(String str) {
        AppMethodBeat.i(220128);
        this.erF = x("CommentScene", str, true);
        AppMethodBeat.o(220128);
        return this;
    }

    public final String ach() {
        return this.erF;
    }

    public final cp hB(long j2) {
        this.euV = j2;
        return this;
    }

    public final long adU() {
        return this.euV;
    }

    public final cp hC(long j2) {
        this.erN = j2;
        return this;
    }

    public final long acr() {
        return this.erN;
    }

    public final cp hD(long j2) {
        this.ewZ = j2;
        return this;
    }

    public final long adV() {
        return this.ewZ;
    }

    public final cp mU(String str) {
        AppMethodBeat.i(220129);
        this.exa = x("ShareUserName", str, true);
        AppMethodBeat.o(220129);
        return this;
    }

    public final String adW() {
        return this.exa;
    }

    public final cp mV(String str) {
        AppMethodBeat.i(220130);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(220130);
        return this;
    }

    public final String acj() {
        return this.eoz;
    }

    public final cp hE(long j2) {
        this.exb = j2;
        return this;
    }

    public final long adX() {
        return this.exb;
    }

    public final cp mW(String str) {
        AppMethodBeat.i(220131);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(220131);
        return this;
    }

    public final String ack() {
        return this.erH;
    }

    public final cp hF(long j2) {
        this.erG = j2;
        return this;
    }

    public final long aci() {
        return this.erG;
    }

    public final cp mX(String str) {
        AppMethodBeat.i(220132);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(220132);
        return this;
    }

    public final String getSessionBuffer() {
        return this.eoo;
    }

    public final cp mY(String str) {
        AppMethodBeat.i(220133);
        this.exc = x("LiveIDStr", str, true);
        AppMethodBeat.o(220133);
        return this;
    }

    public final String adY() {
        return this.exc;
    }

    public final cp mZ(String str) {
        AppMethodBeat.i(220134);
        this.exd = x("SnsFeedId", str, true);
        AppMethodBeat.o(220134);
        return this;
    }

    public final String adZ() {
        return this.exd;
    }

    public final cp hG(long j2) {
        this.exe = j2;
        return this;
    }

    public final long aea() {
        return this.exe;
    }

    public final cp hH(long j2) {
        this.erQ = j2;
        return this;
    }

    public final long acv() {
        return this.erQ;
    }

    public final cp na(String str) {
        AppMethodBeat.i(220135);
        this.exf = x("SnsSessionID", str, true);
        AppMethodBeat.o(220135);
        return this;
    }

    public final String aeb() {
        return this.exf;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220136);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.ewY);
        stringBuffer.append(",");
        stringBuffer.append(this.erD);
        stringBuffer.append(",");
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.erO);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.erF);
        stringBuffer.append(",");
        stringBuffer.append(this.euV);
        stringBuffer.append(",");
        stringBuffer.append(this.erN);
        stringBuffer.append(",");
        stringBuffer.append(this.ewZ);
        stringBuffer.append(",");
        stringBuffer.append(this.exa);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.exb);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.erG);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.exc);
        stringBuffer.append(",");
        stringBuffer.append(this.exd);
        stringBuffer.append(",");
        stringBuffer.append(this.exe);
        stringBuffer.append(",");
        stringBuffer.append(this.erQ);
        stringBuffer.append(",");
        stringBuffer.append(this.exf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220136);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220137);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveID:").append(this.ewY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedID:").append(this.erD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTS:").append(this.erO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.erF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Index:").append(this.euV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterStatus:").append(this.erN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareType:").append(this.ewZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareUserName:").append(this.exa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OnlineNum:").append(this.exb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPrivate:").append(this.erG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveIDStr:").append(this.exc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsFeedId:").append(this.exd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSessionId:").append(this.exe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterIconType:").append(this.erQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsSessionID:").append(this.exf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220137);
        return stringBuffer2;
    }
}
