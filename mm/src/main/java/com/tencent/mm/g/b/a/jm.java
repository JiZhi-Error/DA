package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jm extends a {
    private long eRE = 0;
    private long eRF = 0;
    private long eRG = 0;
    private long eRH = 0;
    private int eRI = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17654;
    }

    public final jm sg(long j2) {
        this.eRE = j2;
        return this;
    }

    public final jm sh(long j2) {
        this.eRF = j2;
        return this;
    }

    public final jm ahu() {
        this.eRG = 1;
        return this;
    }

    public final jm si(long j2) {
        this.eRH = j2;
        return this;
    }

    public final jm lM(int i2) {
        this.eRI = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118500);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eRE);
        stringBuffer.append(",");
        stringBuffer.append(this.eRF);
        stringBuffer.append(",");
        stringBuffer.append(this.eRG);
        stringBuffer.append(",");
        stringBuffer.append(this.eRH);
        stringBuffer.append(",");
        stringBuffer.append(this.eRI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118500);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118501);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StartZipTime:").append(this.eRE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Enable:").append(this.eRF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Exceed:").append(this.eRG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Cost:").append(this.eRH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Result:").append(this.eRI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118501);
        return stringBuffer2;
    }
}
