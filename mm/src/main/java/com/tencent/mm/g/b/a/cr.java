package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cr extends a {
    private String elt = "";
    private long enl;
    private String erH = "";
    private long erN;
    private String erS = "";
    private String erT = "";
    private String etQ = "";
    private long etR;
    private String exj = "";
    private String exk = "";
    private String exl = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21158;
    }

    public final cr ne(String str) {
        AppMethodBeat.i(220143);
        this.exj = x("FinderUsrName", str, true);
        AppMethodBeat.o(220143);
        return this;
    }

    public final String aef() {
        return this.exj;
    }

    public final cr nf(String str) {
        AppMethodBeat.i(220144);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(220144);
        return this;
    }

    public final String acJ() {
        return this.etQ;
    }

    public final cr hL(long j2) {
        AppMethodBeat.i(220145);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220145);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final cr hM(long j2) {
        this.enl = j2;
        return this;
    }

    public final long acL() {
        return this.enl;
    }

    public final cr ng(String str) {
        AppMethodBeat.i(220146);
        this.exk = x("EnterLiveId", str, true);
        AppMethodBeat.o(220146);
        return this;
    }

    public final String aeg() {
        return this.exk;
    }

    public final cr aeh() {
        this.erN = 0;
        return this;
    }

    public final long acr() {
        return this.erN;
    }

    public final cr nh(String str) {
        AppMethodBeat.i(220147);
        this.exl = x("commentscene", str, true);
        AppMethodBeat.o(220147);
        return this;
    }

    public final String aei() {
        return this.exl;
    }

    public final cr ni(String str) {
        AppMethodBeat.i(220148);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(220148);
        return this;
    }

    public final String aej() {
        return this.elt;
    }

    public final cr nj(String str) {
        AppMethodBeat.i(220149);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(220149);
        return this;
    }

    public final String ack() {
        return this.erH;
    }

    public final cr nk(String str) {
        AppMethodBeat.i(220150);
        this.erS = x("AdData", str, true);
        AppMethodBeat.o(220150);
        return this;
    }

    public final String acx() {
        return this.erS;
    }

    public final cr nl(String str) {
        AppMethodBeat.i(220151);
        this.erT = x("Scenenote", str, true);
        AppMethodBeat.o(220151);
        return this;
    }

    public final String acy() {
        return this.erT;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220152);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.exj);
        stringBuffer.append(",");
        stringBuffer.append(this.etQ);
        stringBuffer.append(",");
        stringBuffer.append(this.etR);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.exk);
        stringBuffer.append(",");
        stringBuffer.append(this.erN);
        stringBuffer.append(",");
        stringBuffer.append(this.exl);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.erS);
        stringBuffer.append(",");
        stringBuffer.append(this.erT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220152);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220153);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FinderUsrName:").append(this.exj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderSessionId:").append(this.etQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeMs:").append(this.etR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterLiveId:").append(this.exk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterStatus:").append(this.erN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentscene:").append(this.exl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AdData:").append(this.erS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scenenote:").append(this.erT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220153);
        return stringBuffer2;
    }
}
