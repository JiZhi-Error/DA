package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class i extends a {
    public long ejW = 0;
    public int ejX = 0;
    public long ejY = 0;
    private int ejZ = 0;
    private String eka = "";
    private String ekb = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15894;
    }

    public final i hM(String str) {
        AppMethodBeat.i(91238);
        this.ekb = x("session2", str, true);
        AppMethodBeat.o(91238);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(91239);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.ejX);
        stringBuffer.append(",");
        stringBuffer.append(this.ejY);
        stringBuffer.append(",");
        stringBuffer.append(this.ejZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eka);
        stringBuffer.append(",");
        stringBuffer.append(this.ekb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(91239);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(91240);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_result:").append(this.ejX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_code:").append(this.ejY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("session:").append(this.ejZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_ext:").append(this.eka);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("session2:").append(this.ekb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91240);
        return stringBuffer2;
    }
}
