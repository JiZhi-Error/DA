package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ap extends a {
    private long epY;
    private long epZ;
    public int eqa;
    private int eqb;
    private int eqc;
    public int eqd;
    private int eqe;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21843;
    }

    public final ap cV(long j2) {
        this.epY = j2;
        return this;
    }

    public final ap cW(long j2) {
        this.epZ = j2;
        return this;
    }

    public final ap jP(int i2) {
        this.eqb = i2;
        return this;
    }

    public final ap jQ(int i2) {
        this.eqc = i2;
        return this;
    }

    public final ap jR(int i2) {
        this.eqe = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(199741);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.epY);
        stringBuffer.append(",");
        stringBuffer.append(this.epZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eqa);
        stringBuffer.append(",");
        stringBuffer.append(this.eqb);
        stringBuffer.append(",");
        stringBuffer.append(this.eqc);
        stringBuffer.append(",");
        stringBuffer.append(this.eqd);
        stringBuffer.append(",");
        stringBuffer.append(this.eqe);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(199741);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(199742);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("result:").append(this.epY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errType:").append(this.epZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("emojiCount:").append(this.eqa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("oldVersion:").append(this.eqb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("newVersion:").append(this.eqc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("subType:").append(this.eqd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.eqe);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(199742);
        return stringBuffer2;
    }
}
