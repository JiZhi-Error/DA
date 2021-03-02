package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class al extends a {
    private long eoE = 0;
    private long eoF = 0;
    private long eoG;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15185;
    }

    public final al cd(long j2) {
        this.eoE = j2;
        return this;
    }

    public final al ce(long j2) {
        this.eoF = j2;
        return this;
    }

    public final al acd() {
        this.eoG = 1;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208840);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoE);
        stringBuffer.append(",");
        stringBuffer.append(this.eoF);
        stringBuffer.append(",");
        stringBuffer.append(this.eoG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208840);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208841);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EntranceID:").append(this.eoE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SettingEvent:").append(this.eoF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("settingMethod:").append(this.eoG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208841);
        return stringBuffer2;
    }
}
