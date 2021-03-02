package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class m extends a {
    private int ekA = 0;
    private int ekw = 0;
    private int ekx = 0;
    private int eky = 0;
    private int ekz = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21711;
    }

    public final m jF(int i2) {
        this.ekw = i2;
        return this;
    }

    public final m jG(int i2) {
        this.ekx = i2;
        return this;
    }

    public final m jH(int i2) {
        this.eky = i2;
        return this;
    }

    public final m jI(int i2) {
        this.ekz = i2;
        return this;
    }

    public final m jJ(int i2) {
        this.ekA = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226035);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekw);
        stringBuffer.append(",");
        stringBuffer.append(this.ekx);
        stringBuffer.append(",");
        stringBuffer.append(this.eky);
        stringBuffer.append(",");
        stringBuffer.append(this.ekz);
        stringBuffer.append(",");
        stringBuffer.append(this.ekA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226035);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226036);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("memory:").append(this.ekw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isSingleProcessStrategy:").append(this.ekx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasAppBrandRunning:").append(this.eky);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("runningAppBrandCount:").append(this.ekz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("maxProcessMemory:").append(this.ekA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226036);
        return stringBuffer2;
    }
}
