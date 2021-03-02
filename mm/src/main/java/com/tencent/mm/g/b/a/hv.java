package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hv extends a {
    public String eMA = "";
    private long eMB = 0;
    public String eMz = "";
    public String enR = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15961;
    }

    public final hv qW(long j2) {
        AppMethodBeat.i(116483);
        this.eMB = j2;
        super.bj("timestampMs", this.eMB);
        AppMethodBeat.o(116483);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116484);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.eMz);
        stringBuffer.append(",");
        stringBuffer.append(this.eMA);
        stringBuffer.append(",");
        stringBuffer.append(this.eMB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116484);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116485);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("api:").append(this.eMz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("arg:").append(this.eMA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timestampMs:").append(this.eMB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116485);
        return stringBuffer2;
    }
}
