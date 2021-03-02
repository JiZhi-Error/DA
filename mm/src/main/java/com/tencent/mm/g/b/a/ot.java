package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ot extends a {
    private long ejA;
    private String eoC = "";
    private String erP = "";
    private String prO = "";
    private String qYQ = "";
    private String qoY = "";
    private String rha = "";
    private String sZo = "";
    private String sZq = "";
    private String sZr = "";
    private String sZs = "";
    private String soR = "";
    private long thL;
    private long thZ;
    private String tqG = "";
    private long tqW;
    private long trH;
    private long trM;
    private long trN;
    private long trv;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22216;
    }

    public final ot bwB(String str) {
        AppMethodBeat.i(258274);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(258274);
        return this;
    }

    public final ot bwC(String str) {
        AppMethodBeat.i(258275);
        this.prO = x("TopicID", str, true);
        AppMethodBeat.o(258275);
        return this;
    }

    public final ot bwD(String str) {
        AppMethodBeat.i(258276);
        this.qoY = x("TextStatusID", str, true);
        AppMethodBeat.o(258276);
        return this;
    }

    public final ot bwE(String str) {
        AppMethodBeat.i(258277);
        this.rha = x("IconID", str, true);
        AppMethodBeat.o(258277);
        return this;
    }

    public final ot bwF(String str) {
        AppMethodBeat.i(258278);
        this.soR = x("SourceID", str, true);
        AppMethodBeat.o(258278);
        return this;
    }

    public final ot bwG(String str) {
        AppMethodBeat.i(258279);
        this.sZo = x("SourceActivityID", str, true);
        AppMethodBeat.o(258279);
        return this;
    }

    public final ot bwH(String str) {
        AppMethodBeat.i(258280);
        this.sZq = x("SourceName", str, true);
        AppMethodBeat.o(258280);
        return this;
    }

    public final ot bwI(String str) {
        AppMethodBeat.i(258281);
        this.sZr = x("SourceExtraInfo", str, true);
        AppMethodBeat.o(258281);
        return this;
    }

    public final ot bwJ(String str) {
        AppMethodBeat.i(258282);
        this.sZs = x("CurrLikeIcon", str, true);
        AppMethodBeat.o(258282);
        return this;
    }

    public final ot QO(long j2) {
        this.thL = j2;
        return this;
    }

    public final ot QP(long j2) {
        this.thZ = j2;
        return this;
    }

    public final ot bwK(String str) {
        AppMethodBeat.i(258283);
        this.tqG = x("AuthorUsername", str, true);
        AppMethodBeat.o(258283);
        return this;
    }

    public final ot QQ(long j2) {
        this.tqW = j2;
        return this;
    }

    public final ot QR(long j2) {
        this.trv = j2;
        return this;
    }

    public final ot QS(long j2) {
        this.trH = j2;
        return this;
    }

    public final ot QT(long j2) {
        this.trM = j2;
        return this;
    }

    public final ot QU(long j2) {
        this.ejA = j2;
        return this;
    }

    public final ot bwL(String str) {
        AppMethodBeat.i(258284);
        this.erP = x("ActionResult", str, true);
        AppMethodBeat.o(258284);
        return this;
    }

    public final ot QV(long j2) {
        this.trN = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(258285);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.prO);
        stringBuffer.append(",");
        stringBuffer.append(this.qoY);
        stringBuffer.append(",");
        stringBuffer.append(this.qYQ);
        stringBuffer.append(",");
        stringBuffer.append(this.rha);
        stringBuffer.append(",");
        stringBuffer.append(this.soR);
        stringBuffer.append(",");
        stringBuffer.append(this.sZo);
        stringBuffer.append(",");
        stringBuffer.append(this.sZq);
        stringBuffer.append(",");
        stringBuffer.append(this.sZr);
        stringBuffer.append(",");
        stringBuffer.append(this.sZs);
        stringBuffer.append(",");
        stringBuffer.append(this.thL);
        stringBuffer.append(",");
        stringBuffer.append(this.thZ);
        stringBuffer.append(",");
        stringBuffer.append(this.tqG);
        stringBuffer.append(",");
        stringBuffer.append(this.tqW);
        stringBuffer.append(",");
        stringBuffer.append(this.trv);
        stringBuffer.append(",");
        stringBuffer.append(this.trH);
        stringBuffer.append(",");
        stringBuffer.append(this.trM);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.erP);
        stringBuffer.append(",");
        stringBuffer.append(this.trN);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(258285);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(258286);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TopicID:").append(this.prO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TextStatusID:").append(this.qoY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TopicText:").append(this.qYQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IconID:").append(this.rha);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceID:").append(this.soR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceActivityID:").append(this.sZo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceName:").append(this.sZq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceExtraInfo:").append(this.sZr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrLikeIcon:").append(this.sZs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrSameFriCnt:").append(this.thL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrChattingCnt:").append(this.thZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AuthorUsername:").append(this.tqG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UsersRelationship:").append(this.tqW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrScene:").append(this.trv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasNoticeEntrance:").append(this.trH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ListPos:").append(this.trM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionResult:").append(this.erP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTs:").append(this.trN);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(258286);
        return stringBuffer2;
    }
}
