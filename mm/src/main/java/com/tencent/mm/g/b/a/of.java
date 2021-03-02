package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class of extends a {
    private String eKN = "";
    private String ekG = "";
    private int eqe;
    private int eql;
    private long oqi;
    private String oqj = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22340;
    }

    public final of PF(long j2) {
        this.oqi = j2;
        return this;
    }

    public final of GK(String str) {
        AppMethodBeat.i(261937);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(261937);
        return this;
    }

    public final of Tz(String str) {
        AppMethodBeat.i(261938);
        this.eKN = x("userName", str, true);
        AppMethodBeat.o(261938);
        return this;
    }

    public final of SM(int i2) {
        this.eqe = i2;
        return this;
    }

    public final of SR(int i2) {
        this.eql = i2;
        return this;
    }

    public final of TA(String str) {
        AppMethodBeat.i(261939);
        this.oqj = x("wishId", str, true);
        AppMethodBeat.o(261939);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(261940);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.oqi);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.eKN);
        stringBuffer.append(",");
        stringBuffer.append(this.eqe);
        stringBuffer.append(",");
        stringBuffer.append(this.eql);
        stringBuffer.append(",");
        stringBuffer.append(this.oqj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(261940);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(261941);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionstamp:").append(this.oqi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("userName:").append(this.eKN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.eqe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.eql);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("wishId:").append(this.oqj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(261941);
        return stringBuffer2;
    }
}
