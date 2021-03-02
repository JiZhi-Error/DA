package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ar extends a {
    private int eki;
    private int enq;
    private int eqh;
    private String eqi = "";
    private String eqj = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19434;
    }

    public final ar jT(int i2) {
        this.eki = i2;
        return this;
    }

    public final ar jU(int i2) {
        this.enq = i2;
        return this;
    }

    public final ar iv(String str) {
        AppMethodBeat.i(183916);
        this.eqi = x("Pid", str, true);
        AppMethodBeat.o(183916);
        return this;
    }

    public final ar iw(String str) {
        AppMethodBeat.i(183917);
        this.eqj = x("Md5", str, true);
        AppMethodBeat.o(183917);
        return this;
    }

    public final ar jV(int i2) {
        this.eqh = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(183918);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eki);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.eqi);
        stringBuffer.append(",");
        stringBuffer.append(this.eqj);
        stringBuffer.append(",");
        stringBuffer.append(this.eqh);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(183918);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(183919);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.eki);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Pid:").append(this.eqi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Md5:").append(this.eqj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Index:").append(this.eqh);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(183919);
        return stringBuffer2;
    }
}
