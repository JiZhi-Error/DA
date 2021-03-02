package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class aq extends a {
    private int eki;
    public int eqf;
    private String eqg = "";
    public int eqh;
    private String eqi = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19435;
    }

    public final aq jS(int i2) {
        this.eki = i2;
        return this;
    }

    public final aq it(String str) {
        AppMethodBeat.i(183912);
        this.eqg = x("EnterPid", str, true);
        AppMethodBeat.o(183912);
        return this;
    }

    public final int getIndex() {
        return this.eqh;
    }

    public final aq iu(String str) {
        AppMethodBeat.i(183913);
        this.eqi = x("Pid", str, true);
        AppMethodBeat.o(183913);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(183914);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eki);
        stringBuffer.append(",");
        stringBuffer.append(this.eqf);
        stringBuffer.append(",");
        stringBuffer.append(this.eqg);
        stringBuffer.append(",");
        stringBuffer.append(this.eqh);
        stringBuffer.append(",");
        stringBuffer.append(this.eqi);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(183914);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(183915);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.eki);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsRed:").append(this.eqf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterPid:").append(this.eqg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Index:").append(this.eqh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Pid:").append(this.eqi);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(183915);
        return stringBuffer2;
    }
}
