package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ou extends a {
    private String eJm = "";
    private long erW;
    private String tCf = "";
    private long trN;
    private long trT;
    private long tsk;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22210;
    }

    public final ou bwM(String str) {
        AppMethodBeat.i(258287);
        this.eJm = x("ToUsername", str, true);
        AppMethodBeat.o(258287);
        return this;
    }

    public final ou QW(long j2) {
        this.erW = j2;
        return this;
    }

    public final ou QX(long j2) {
        this.trT = j2;
        return this;
    }

    public final ou QY(long j2) {
        this.tsk = j2;
        return this;
    }

    public final ou QZ(long j2) {
        this.trN = j2;
        return this;
    }

    public final ou bwN(String str) {
        AppMethodBeat.i(258288);
        this.tCf = x("SceneExtInfo", str, true);
        AppMethodBeat.o(258288);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(258289);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJm);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.trT);
        stringBuffer.append(",");
        stringBuffer.append(this.tsk);
        stringBuffer.append(",");
        stringBuffer.append(this.trN);
        stringBuffer.append(",");
        stringBuffer.append(this.tCf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(258289);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(258290);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ToUsername:").append(this.eJm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasTextStatusIcon:").append(this.trT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionResult:").append(this.tsk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTs:").append(this.trN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SceneExtInfo:").append(this.tCf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(258290);
        return stringBuffer2;
    }
}
