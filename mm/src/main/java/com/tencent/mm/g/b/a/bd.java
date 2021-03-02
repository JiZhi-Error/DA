package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bd extends a {
    private long ejA;
    private String eoC = "";
    private String eoK = "";
    private String eoo = "";
    private String eoz = "";
    private String erC = "";
    private String erD = "";
    private String erE = "";
    private String erF = "";
    private long erG;
    private String erH = "";
    private long erI;
    private long erJ;
    private long erK;
    private long erL;
    private long erM;
    private long erN;
    private long erO;
    private String erP = "";
    private long erQ;
    private long erR;
    private String erS = "";
    private String erT = "";
    private long oqR;
    private String oqS = "";
    private String oqT = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21084;
    }

    public final bd iQ(String str) {
        AppMethodBeat.i(220081);
        this.erC = x("LiveID", str, true);
        AppMethodBeat.o(220081);
        return this;
    }

    public final String ace() {
        return this.erC;
    }

    public final bd iR(String str) {
        AppMethodBeat.i(220082);
        this.erD = x("FeedID", str, true);
        AppMethodBeat.o(220082);
        return this;
    }

    public final String acf() {
        return this.erD;
    }

    public final bd iS(String str) {
        AppMethodBeat.i(220083);
        this.eoK = x("UserName", str, true);
        AppMethodBeat.o(220083);
        return this;
    }

    public final String getUserName() {
        return this.eoK;
    }

    public final bd iT(String str) {
        AppMethodBeat.i(220084);
        this.erE = x("Topic", str, true);
        AppMethodBeat.o(220084);
        return this;
    }

    public final String acg() {
        return this.erE;
    }

    public final bd iU(String str) {
        AppMethodBeat.i(220085);
        this.erF = x("CommentScene", str, true);
        AppMethodBeat.o(220085);
        return this;
    }

    public final String ach() {
        return this.erF;
    }

    public final bd dg(long j2) {
        this.erG = j2;
        return this;
    }

    public final long aci() {
        return this.erG;
    }

    public final bd iV(String str) {
        AppMethodBeat.i(220086);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(220086);
        return this;
    }

    public final String acj() {
        return this.eoz;
    }

    public final bd iW(String str) {
        AppMethodBeat.i(220087);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(220087);
        return this;
    }

    public final String ack() {
        return this.erH;
    }

    public final bd iX(String str) {
        AppMethodBeat.i(220088);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(220088);
        return this;
    }

    public final String acl() {
        return this.eoC;
    }

    public final bd iY(String str) {
        AppMethodBeat.i(220089);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(220089);
        return this;
    }

    public final String getSessionBuffer() {
        return this.eoo;
    }

    public final bd dh(long j2) {
        this.erI = j2;
        return this;
    }

    public final long acm() {
        return this.erI;
    }

    public final bd di(long j2) {
        this.erJ = j2;
        return this;
    }

    public final long acn() {
        return this.erJ;
    }

    public final bd dj(long j2) {
        this.erK = j2;
        return this;
    }

    public final long aco() {
        return this.erK;
    }

    public final bd dk(long j2) {
        this.erL = j2;
        return this;
    }

    public final long acp() {
        return this.erL;
    }

    public final bd dl(long j2) {
        this.erM = j2;
        return this;
    }

    public final long acq() {
        return this.erM;
    }

    public final bd dm(long j2) {
        this.erN = j2;
        return this;
    }

    public final long acr() {
        return this.erN;
    }

    public final bd dn(long j2) {
        this.erO = j2;
        return this;
    }

    public final long acs() {
        return this.erO;
    }

    /* renamed from: do  reason: not valid java name */
    public final bd m8do(long j2) {
        this.ejA = j2;
        return this;
    }

    public final long act() {
        return this.ejA;
    }

    public final bd iZ(String str) {
        AppMethodBeat.i(220090);
        this.erP = x("ActionResult", str, true);
        AppMethodBeat.o(220090);
        return this;
    }

    public final String acu() {
        return this.erP;
    }

    public final bd dp(long j2) {
        this.erQ = j2;
        return this;
    }

    public final long acv() {
        return this.erQ;
    }

    public final bd dq(long j2) {
        this.erR = j2;
        return this;
    }

    public final long acw() {
        return this.erR;
    }

    public final bd ja(String str) {
        AppMethodBeat.i(220091);
        this.erS = x("AdData", str, true);
        AppMethodBeat.o(220091);
        return this;
    }

    public final String acx() {
        return this.erS;
    }

    public final bd jb(String str) {
        AppMethodBeat.i(220092);
        this.erT = x("Scenenote", str, true);
        AppMethodBeat.o(220092);
        return this;
    }

    public final String acy() {
        return this.erT;
    }

    public final bd PI(long j2) {
        this.oqR = j2;
        return this;
    }

    public final long ajX() {
        return this.oqR;
    }

    public final bd ahU(String str) {
        AppMethodBeat.i(259536);
        this.oqS = x("request_id", str, true);
        AppMethodBeat.o(259536);
        return this;
    }

    public final String ajY() {
        return this.oqS;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220093);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erC);
        stringBuffer.append(",");
        stringBuffer.append(this.erD);
        stringBuffer.append(",");
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.erE);
        stringBuffer.append(",");
        stringBuffer.append(this.erF);
        stringBuffer.append(",");
        stringBuffer.append(this.erG);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.erI);
        stringBuffer.append(",");
        stringBuffer.append(this.erJ);
        stringBuffer.append(",");
        stringBuffer.append(this.erK);
        stringBuffer.append(",");
        stringBuffer.append(this.erL);
        stringBuffer.append(",");
        stringBuffer.append(this.erM);
        stringBuffer.append(",");
        stringBuffer.append(this.erN);
        stringBuffer.append(",");
        stringBuffer.append(this.erO);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.erP);
        stringBuffer.append(",");
        stringBuffer.append(this.erQ);
        stringBuffer.append(",");
        stringBuffer.append(this.erR);
        stringBuffer.append(",");
        stringBuffer.append(this.erS);
        stringBuffer.append(",");
        stringBuffer.append(this.erT);
        stringBuffer.append(",");
        stringBuffer.append(this.oqR);
        stringBuffer.append(",");
        stringBuffer.append(this.oqS);
        stringBuffer.append(",");
        stringBuffer.append(this.oqT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220093);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220094);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LiveID:").append(this.erC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedID:").append(this.erD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Topic:").append(this.erE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.erF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPrivate:").append(this.erG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShopPermit:").append(this.erI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSessionID:").append(this.erJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveTime:").append(this.erK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FullDuration:").append(this.erL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FloatDuration:").append(this.erM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterStatus:").append(this.erN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTS:").append(this.erO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionResult:").append(this.erP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterIconType:").append(this.erQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageType:").append(this.erR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AdData:").append(this.erS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scenenote:").append(this.erT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IdentityType:").append(this.oqR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("request_id:").append(this.oqS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.oqT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220094);
        return stringBuffer2;
    }
}
