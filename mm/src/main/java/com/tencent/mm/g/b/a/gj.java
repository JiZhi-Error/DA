package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gj extends a {
    private long eHS;
    private long eJs;
    private long eJt;
    private long ejA;
    private String eoz = "";
    private long erW;
    private long ewu;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21920;
    }

    public final gj qh(long j2) {
        this.ejA = j2;
        return this;
    }

    public final gj tV(String str) {
        AppMethodBeat.i(200259);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(200259);
        return this;
    }

    public final gj qi(long j2) {
        this.erW = j2;
        return this;
    }

    public final gj qj(long j2) {
        this.eJs = j2;
        return this;
    }

    public final gj qk(long j2) {
        this.eHS = j2;
        return this;
    }

    public final gj ql(long j2) {
        this.eJt = j2;
        return this;
    }

    public final gj qm(long j2) {
        this.ewu = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(200260);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eJs);
        stringBuffer.append(",");
        stringBuffer.append(this.eHS);
        stringBuffer.append(",");
        stringBuffer.append(this.eJt);
        stringBuffer.append(",");
        stringBuffer.append(this.ewu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(200260);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(200261);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserAction:").append(this.eJs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FullScreen:").append(this.eHS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TaskCount:").append(this.eJt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Duration:").append(this.ewu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(200261);
        return stringBuffer2;
    }
}
