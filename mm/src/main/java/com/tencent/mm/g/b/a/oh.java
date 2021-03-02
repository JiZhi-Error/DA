package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class oh extends a {
    private String ekG = "";
    private int eqe;
    private int eql;
    private long oqb;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22341;
    }

    public final oh PH(long j2) {
        this.oqb = j2;
        return this;
    }

    public final oh agP(String str) {
        AppMethodBeat.i(261948);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(261948);
        return this;
    }

    public final oh abH(int i2) {
        this.eqe = i2;
        return this;
    }

    public final oh abJ(int i2) {
        this.eql = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(261949);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.oqb);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.eqe);
        stringBuffer.append(",");
        stringBuffer.append(this.eql);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(261949);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(261950);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actiontime:").append(this.oqb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.eqe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.eql);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(261950);
        return stringBuffer2;
    }
}
