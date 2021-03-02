package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cn extends a {
    private long enl;
    private long erK;
    private String erP = "";
    private String err = "";
    private String etN = "";
    private String etO = "";
    private int etP;
    private String etQ = "";
    private long etR;
    private long evx;
    private String ewp = "";
    private String ewq = "";
    private long ewr;
    private long ews;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21054;
    }

    public final cn mx(String str) {
        AppMethodBeat.i(220101);
        this.etN = x("FinderUsrname", str, true);
        AppMethodBeat.o(220101);
        return this;
    }

    public final String acG() {
        return this.etN;
    }

    public final cn my(String str) {
        AppMethodBeat.i(220102);
        this.etO = x("FinderWxAppInfo", str, true);
        AppMethodBeat.o(220102);
        return this;
    }

    public final String acH() {
        return this.etO;
    }

    public final cn ke(int i2) {
        this.etP = i2;
        return this;
    }

    public final int acI() {
        return this.etP;
    }

    public final cn mz(String str) {
        AppMethodBeat.i(220103);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(220103);
        return this;
    }

    public final String acJ() {
        return this.etQ;
    }

    public final cn gJ(long j2) {
        AppMethodBeat.i(220104);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220104);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final cn mA(String str) {
        AppMethodBeat.i(220105);
        this.ewp = x("LiveId", str, true);
        AppMethodBeat.o(220105);
        return this;
    }

    public final String adj() {
        return this.ewp;
    }

    public final cn mB(String str) {
        AppMethodBeat.i(220106);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(220106);
        return this;
    }

    public final String adk() {
        return this.err;
    }

    public final cn mC(String str) {
        AppMethodBeat.i(220107);
        this.ewq = x("Description", str, true);
        AppMethodBeat.o(220107);
        return this;
    }

    public final String getDescription() {
        return this.ewq;
    }

    public final cn gK(long j2) {
        this.erK = j2;
        return this;
    }

    public final long aco() {
        return this.erK;
    }

    public final cn gL(long j2) {
        this.evx = j2;
        return this;
    }

    public final long adl() {
        return this.evx;
    }

    public final cn gM(long j2) {
        this.ewr = j2;
        return this;
    }

    public final long adm() {
        return this.ewr;
    }

    public final cn gN(long j2) {
        this.enl = j2;
        return this;
    }

    public final long acL() {
        return this.enl;
    }

    public final cn mD(String str) {
        AppMethodBeat.i(220108);
        this.erP = x("ActionResult", str, true);
        AppMethodBeat.o(220108);
        return this;
    }

    public final String acu() {
        return this.erP;
    }

    public final cn gO(long j2) {
        this.ews = j2;
        return this;
    }

    public final long adn() {
        return this.ews;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220109);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etN);
        stringBuffer.append(",");
        stringBuffer.append(this.etO);
        stringBuffer.append(",");
        stringBuffer.append(this.etP);
        stringBuffer.append(",");
        stringBuffer.append(this.etQ);
        stringBuffer.append(",");
        stringBuffer.append(this.etR);
        stringBuffer.append(",");
        stringBuffer.append(this.ewp);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.ewq);
        stringBuffer.append(",");
        stringBuffer.append(this.erK);
        stringBuffer.append(",");
        stringBuffer.append(this.evx);
        stringBuffer.append(",");
        stringBuffer.append(this.ewr);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.erP);
        stringBuffer.append(",");
        stringBuffer.append(this.ews);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220109);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220110);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FinderUsrname:").append(this.etN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderWxAppInfo:").append(this.etO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPrivate:").append(this.etP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderSessionId:").append(this.etQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeMs:").append(this.etR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveId:").append(this.ewp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Description:").append(this.ewq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveTime:").append(this.erK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LikeCount:").append(this.evx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OnlineCount:").append(this.ewr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionResult:").append(this.erP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceScene:").append(this.ews);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220110);
        return stringBuffer2;
    }
}
