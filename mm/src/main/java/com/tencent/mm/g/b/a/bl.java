package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bl extends a {
    private long eiE;
    private long erZ;
    private long esH;
    private long esI;
    private long esJ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21077;
    }

    public final bl dP(long j2) {
        this.esH = j2;
        return this;
    }

    public final bl dQ(long j2) {
        this.esI = j2;
        return this;
    }

    public final bl dR(long j2) {
        this.esJ = j2;
        return this;
    }

    public final bl dS(long j2) {
        this.eiE = j2;
        return this;
    }

    public final bl dT(long j2) {
        this.erZ = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208885);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.esH);
        stringBuffer.append(",");
        stringBuffer.append(this.esI);
        stringBuffer.append(",");
        stringBuffer.append(this.esJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eiE);
        stringBuffer.append(",");
        stringBuffer.append(this.erZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208885);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208886);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickTimestamps:").append(this.esH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickType:").append(this.esI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Outcome:").append(this.esJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentScene:").append(this.eiE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Followcount:").append(this.erZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208886);
        return stringBuffer2;
    }
}
