package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class od extends a {
    private String ekG = "";
    private int eqe;
    private int eql;
    private long oqb;
    private long oqc;
    private long oqd;
    private int oqf;
    private long oqg;
    private int oqh;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22339;
    }

    public final od PA(long j2) {
        this.oqb = j2;
        return this;
    }

    public final od fL(String str) {
        AppMethodBeat.i(261931);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(261931);
        return this;
    }

    public final od Jp(int i2) {
        this.eqe = i2;
        return this;
    }

    public final od Jr(int i2) {
        this.eql = i2;
        return this;
    }

    public final od PB(long j2) {
        this.oqc = j2;
        return this;
    }

    public final od PC(long j2) {
        this.oqd = j2;
        return this;
    }

    public final od LV(int i2) {
        this.oqf = i2;
        return this;
    }

    public final od PD(long j2) {
        this.oqg = j2;
        return this;
    }

    public final od MQ(int i2) {
        this.oqh = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(261932);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.oqb);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.eqe);
        stringBuffer.append(",");
        stringBuffer.append(this.eql);
        stringBuffer.append(",");
        stringBuffer.append(this.oqc);
        stringBuffer.append(",");
        stringBuffer.append(this.oqd);
        stringBuffer.append(",");
        stringBuffer.append(this.oqf);
        stringBuffer.append(",");
        stringBuffer.append(this.oqg);
        stringBuffer.append(",");
        stringBuffer.append(this.oqh);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(261932);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(261933);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actiontime:").append(this.oqb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.eqe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.eql);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("wishNum:").append(this.oqc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentNum:").append(this.oqd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isSlide:").append(this.oqf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("likeNum:").append(this.oqg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exitType:").append(this.oqh);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(261933);
        return stringBuffer2;
    }
}
