package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class du extends a {
    private String eAm = "";
    private long eBD;
    private long eBG;
    private long eBH;
    private long eBI;
    private long eBJ;
    private String eBK = "";
    private String eBL = "";
    private long eBM;
    private long eBN;
    private String eBw = "";
    private long eBy;
    private String eiB = "";
    private long ejA;
    private String eoz = "";
    private String erH = "";
    private String err = "";
    private long erz;
    private long eyO;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18948;
    }

    public final du pS(String str) {
        AppMethodBeat.i(184176);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(184176);
        return this;
    }

    public final du pT(String str) {
        AppMethodBeat.i(184177);
        this.eBw = x("CurrUI", str, true);
        AppMethodBeat.o(184177);
        return this;
    }

    public final du kL(long j2) {
        this.eBG = j2;
        return this;
    }

    public final du kM(long j2) {
        this.ejA = j2;
        return this;
    }

    public final du kN(long j2) {
        this.eBH = j2;
        return this;
    }

    public final du kO(long j2) {
        this.eBI = j2;
        return this;
    }

    public final du kP(long j2) {
        this.erz = j2;
        return this;
    }

    public final du kQ(long j2) {
        this.eBJ = j2;
        return this;
    }

    public final du pU(String str) {
        AppMethodBeat.i(184178);
        this.eBK = x("RedDotId", str, true);
        AppMethodBeat.o(184178);
        return this;
    }

    public final du pV(String str) {
        AppMethodBeat.i(186003);
        this.eBL = x("RedDotWording", str, true);
        AppMethodBeat.o(186003);
        return this;
    }

    public final du pW(String str) {
        AppMethodBeat.i(209183);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(209183);
        return this;
    }

    public final du pX(String str) {
        AppMethodBeat.i(209184);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(209184);
        return this;
    }

    public final du pY(String str) {
        AppMethodBeat.i(209185);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209185);
        return this;
    }

    public final du kR(long j2) {
        this.eyO = j2;
        return this;
    }

    public final du kS(long j2) {
        this.eBy = j2;
        return this;
    }

    public final du kT(long j2) {
        this.eBD = j2;
        return this;
    }

    public final du kU(long j2) {
        this.eBN = j2;
        return this;
    }

    public final du pZ(String str) {
        AppMethodBeat.i(209186);
        this.eAm = x("ExtInfo", str, true);
        AppMethodBeat.o(209186);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184179);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eBw);
        stringBuffer.append(",");
        stringBuffer.append(this.eBG);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eBH);
        stringBuffer.append(",");
        stringBuffer.append(this.eBI);
        stringBuffer.append(",");
        stringBuffer.append(this.erz);
        stringBuffer.append(",");
        stringBuffer.append(this.eBJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eBK);
        stringBuffer.append(",");
        stringBuffer.append(this.eBL);
        stringBuffer.append(",");
        stringBuffer.append(this.eBM);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eyO);
        stringBuffer.append(",");
        stringBuffer.append(this.eBy);
        stringBuffer.append(",");
        stringBuffer.append(this.eBD);
        stringBuffer.append(",");
        stringBuffer.append(this.eBN);
        stringBuffer.append(",");
        stringBuffer.append(this.eAm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184179);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184180);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrUI:").append(this.eBw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotType:").append(this.eBG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotSubType:").append(this.eBH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShowType:").append(this.eBI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnerVersion:").append(this.erz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotCount:").append(this.eBJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotId:").append(this.eBK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotWording:").append(this.eBL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotWordingType:").append(this.eBM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TabType:").append(this.eyO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsOpenRedDotButton:").append(this.eBy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentTabType:").append(this.eBD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AutoClick:").append(this.eBN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtInfo:").append(this.eAm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184180);
        return stringBuffer2;
    }
}
