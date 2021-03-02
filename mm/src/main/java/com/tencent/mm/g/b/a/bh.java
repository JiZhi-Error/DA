package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bh extends a {
    private long esa;
    private long esb;
    private long esg;
    private long esm;
    private String esn = "";
    private long eso;
    private long esp;
    private long esq;
    private long esr;
    private long ess;
    private long est;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20688;
    }

    public final bh dy(long j2) {
        this.esb = j2;
        return this;
    }

    public final bh dz(long j2) {
        this.esm = j2;
        return this;
    }

    public final bh dA(long j2) {
        this.esa = j2;
        return this;
    }

    public final bh jg(String str) {
        AppMethodBeat.i(208864);
        this.esn = x("chatlistSessionid", str, true);
        AppMethodBeat.o(208864);
        return this;
    }

    public final bh dB(long j2) {
        this.eso = j2;
        return this;
    }

    public final bh dC(long j2) {
        this.esp = j2;
        return this;
    }

    public final bh dD(long j2) {
        this.esq = j2;
        return this;
    }

    public final bh dE(long j2) {
        this.esr = j2;
        return this;
    }

    public final bh dF(long j2) {
        this.ess = j2;
        return this;
    }

    public final bh dG(long j2) {
        this.esg = j2;
        return this;
    }

    public final bh dH(long j2) {
        this.est = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208865);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.esb);
        stringBuffer.append(",");
        stringBuffer.append(this.esm);
        stringBuffer.append(",");
        stringBuffer.append(this.esa);
        stringBuffer.append(",");
        stringBuffer.append(this.esn);
        stringBuffer.append(",");
        stringBuffer.append(this.eso);
        stringBuffer.append(",");
        stringBuffer.append(this.esp);
        stringBuffer.append(",");
        stringBuffer.append(this.esq);
        stringBuffer.append(",");
        stringBuffer.append(this.esr);
        stringBuffer.append(",");
        stringBuffer.append(this.ess);
        stringBuffer.append(",");
        stringBuffer.append(this.esg);
        stringBuffer.append(",");
        stringBuffer.append(this.est);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208865);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208866);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("myAccountType:").append(this.esb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isGreetSession:").append(this.esm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fromCommentScene:").append(this.esa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("chatlistSessionid:").append(this.esn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exposeSessionCount:").append(this.eso);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exposeChatCount:").append(this.esp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionClickCount:").append(this.esq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("openSessionCount:").append(this.esr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("delSessionCount:").append(this.ess);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("stayDuration:").append(this.esg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("dotClickCount:").append(this.est);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208866);
        return stringBuffer2;
    }
}
