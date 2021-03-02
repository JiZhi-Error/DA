package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nq extends a {
    public long eLZ = 0;
    public long fid = 0;
    public long fie = 0;
    public long fif = 0;
    public long fig = 0;
    private String fih = "";
    private String fii = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15452;
    }

    public final nq AO(String str) {
        AppMethodBeat.i(121785);
        this.fih = x("ExptKey", str, true);
        AppMethodBeat.o(121785);
        return this;
    }

    public final nq AP(String str) {
        AppMethodBeat.i(121786);
        this.fii = x("ExptVal", str, false);
        AppMethodBeat.o(121786);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121787);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fid);
        stringBuffer.append(",");
        stringBuffer.append(this.fie);
        stringBuffer.append(",");
        stringBuffer.append(this.fif);
        stringBuffer.append(",");
        stringBuffer.append(this.eLZ);
        stringBuffer.append(",");
        stringBuffer.append(this.fig);
        stringBuffer.append(",");
        stringBuffer.append(this.fih);
        stringBuffer.append(",");
        stringBuffer.append(this.fii);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121787);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121788);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptId:").append(this.fid);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupId:").append(this.fie);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExptSeq:").append(this.fif);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartTimeStampSec:").append(this.eLZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndTimeStampSec:").append(this.fig);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExptKey:").append(this.fih);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExptVal:").append(this.fii);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121788);
        return stringBuffer2;
    }
}
