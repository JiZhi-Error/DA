package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bf extends a {
    private String eoj = "";
    private long erW;
    private long erY;
    private long erZ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21345;
    }

    public final bf jf(String str) {
        AppMethodBeat.i(208859);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(208859);
        return this;
    }

    public final bf acz() {
        this.erY = 0;
        return this;
    }

    public final bf du(long j2) {
        this.erW = j2;
        return this;
    }

    public final bf dv(long j2) {
        this.erZ = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208860);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.erZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208860);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208861);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Followcount:").append(this.erZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208861);
        return stringBuffer2;
    }
}
