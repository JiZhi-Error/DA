package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dt extends a {
    private long eBA;
    private long eBB;
    private String eBC = "";
    private long eBD;
    private long eBE;
    private long eBF;
    private long eBn;
    private String eBo = "";
    private String eBp = "";
    private String eBq = "";
    private long eBr;
    private long eBs;
    private String eBt = "";
    private String eBu = "";
    private long eBv;
    private String eBw = "";
    private String eBx = "";
    private long eBy;
    private long eBz;
    private String eoC = "";
    private String eoD = "";
    private long eyO;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20411;
    }

    public final dt kA(long j2) {
        this.eBn = j2;
        return this;
    }

    public final dt pI(String str) {
        AppMethodBeat.i(209171);
        this.eBo = x("RedDotTipsID", str, true);
        AppMethodBeat.o(209171);
        return this;
    }

    public final dt pJ(String str) {
        AppMethodBeat.i(209172);
        this.eBp = x("RedDotShowInfoPath", str, true);
        AppMethodBeat.o(209172);
        return this;
    }

    public final dt pK(String str) {
        AppMethodBeat.i(209173);
        this.eBq = x("RedDotShowInfoParentPath", str, true);
        AppMethodBeat.o(209173);
        return this;
    }

    public final dt kB(long j2) {
        this.eBr = j2;
        return this;
    }

    public final dt kC(long j2) {
        this.eBs = j2;
        return this;
    }

    public final dt pL(String str) {
        AppMethodBeat.i(209174);
        this.eBt = x("RedDotShowInfoTitle", str, true);
        AppMethodBeat.o(209174);
        return this;
    }

    public final dt pM(String str) {
        AppMethodBeat.i(209175);
        this.eBu = x("RedDotShowInfoExt", str, true);
        AppMethodBeat.o(209175);
        return this;
    }

    public final dt kD(long j2) {
        this.eBv = j2;
        return this;
    }

    public final dt pN(String str) {
        AppMethodBeat.i(209176);
        this.eBw = x("CurrUI", str, true);
        AppMethodBeat.o(209176);
        return this;
    }

    public final dt pO(String str) {
        AppMethodBeat.i(209177);
        this.eoD = x("ContextID", str, true);
        AppMethodBeat.o(209177);
        return this;
    }

    public final dt pP(String str) {
        AppMethodBeat.i(209178);
        this.eBx = x("ClickTabContextID", str, true);
        AppMethodBeat.o(209178);
        return this;
    }

    public final dt kE(long j2) {
        this.eyO = j2;
        return this;
    }

    public final dt kF(long j2) {
        this.eBy = j2;
        return this;
    }

    public final dt kG(long j2) {
        this.eBz = j2;
        return this;
    }

    public final dt afg() {
        this.eBA = 1;
        return this;
    }

    public final dt pQ(String str) {
        AppMethodBeat.i(209179);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(209179);
        return this;
    }

    public final dt kH(long j2) {
        this.eBB = j2;
        return this;
    }

    public final dt pR(String str) {
        AppMethodBeat.i(209180);
        this.eBC = x("RedDotShowInfoIconUrl", str, true);
        AppMethodBeat.o(209180);
        return this;
    }

    public final dt kI(long j2) {
        this.eBD = j2;
        return this;
    }

    public final dt kJ(long j2) {
        this.eBE = j2;
        return this;
    }

    public final dt kK(long j2) {
        this.eBF = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209181);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eBn);
        stringBuffer.append(",");
        stringBuffer.append(this.eBo);
        stringBuffer.append(",");
        stringBuffer.append(this.eBp);
        stringBuffer.append(",");
        stringBuffer.append(this.eBq);
        stringBuffer.append(",");
        stringBuffer.append(this.eBr);
        stringBuffer.append(",");
        stringBuffer.append(this.eBs);
        stringBuffer.append(",");
        stringBuffer.append(this.eBt);
        stringBuffer.append(",");
        stringBuffer.append(this.eBu);
        stringBuffer.append(",");
        stringBuffer.append(this.eBv);
        stringBuffer.append(",");
        stringBuffer.append(this.eBw);
        stringBuffer.append(",");
        stringBuffer.append(this.eoD);
        stringBuffer.append(",");
        stringBuffer.append(this.eBx);
        stringBuffer.append(",");
        stringBuffer.append(this.eyO);
        stringBuffer.append(",");
        stringBuffer.append(this.eBy);
        stringBuffer.append(",");
        stringBuffer.append(this.eBz);
        stringBuffer.append(",");
        stringBuffer.append(this.eBA);
        stringBuffer.append(",");
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.eBB);
        stringBuffer.append(",");
        stringBuffer.append(this.eBC);
        stringBuffer.append(",");
        stringBuffer.append(this.eBD);
        stringBuffer.append(",");
        stringBuffer.append(this.eBE);
        stringBuffer.append(",");
        stringBuffer.append(this.eBF);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209181);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209182);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RedDotCtrlType:").append(this.eBn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotTipsID:").append(this.eBo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoPath:").append(this.eBp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoParentPath:").append(this.eBq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoType:").append(this.eBr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoCountNum:").append(this.eBs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoTitle:").append(this.eBt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoExt:").append(this.eBu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotAction:").append(this.eBv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrUI:").append(this.eBw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextID:").append(this.eoD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextID:").append(this.eBx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TabType:").append(this.eyO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsOpenRedDotButton:").append(this.eBy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsTriggerByUser:").append(this.eBz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnverVersion:").append(this.eBA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecTimeStamp:").append(this.eBB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoIconUrl:").append(this.eBC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentTabType:").append(this.eBD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasFinderAccount:").append(this.eBE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotactiontimestamp:").append(this.eBF);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209182);
        return stringBuffer2;
    }
}
