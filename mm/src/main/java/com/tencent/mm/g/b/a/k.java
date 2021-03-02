package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class k extends a {
    private int eki;
    private long ekj;
    private long ekk;
    private long ekl;
    private long ekm;
    private String ekn = "";
    private String eko = "";
    private long ekp;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20808;
    }

    public final k jB(int i2) {
        this.eki = i2;
        return this;
    }

    public final k bM(long j2) {
        this.ekj = j2;
        return this;
    }

    public final k bN(long j2) {
        this.ekk = j2;
        return this;
    }

    public final k bO(long j2) {
        this.ekl = j2;
        return this;
    }

    public final k bP(long j2) {
        this.ekm = j2;
        return this;
    }

    public final k hN(String str) {
        AppMethodBeat.i(224142);
        this.ekn = x("ReqContent", str, true);
        AppMethodBeat.o(224142);
        return this;
    }

    public final k hO(String str) {
        AppMethodBeat.i(224143);
        this.eko = x("RespContent", str, true);
        AppMethodBeat.o(224143);
        return this;
    }

    public final k bQ(long j2) {
        this.ekp = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(224144);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eki);
        stringBuffer.append(",");
        stringBuffer.append(this.ekj);
        stringBuffer.append(",");
        stringBuffer.append(this.ekk);
        stringBuffer.append(",");
        stringBuffer.append(this.ekl);
        stringBuffer.append(",");
        stringBuffer.append(this.ekm);
        stringBuffer.append(",");
        stringBuffer.append(this.ekn);
        stringBuffer.append(",");
        stringBuffer.append(this.eko);
        stringBuffer.append(",");
        stringBuffer.append(this.ekp);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(224144);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(224145);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.eki);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReqNum:").append(this.ekj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RespNum:").append(this.ekk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataStartTime:").append(this.ekl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataEndTime:").append(this.ekm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReqContent:").append(this.ekn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RespContent:").append(this.eko);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataNum:").append(this.ekp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(224145);
        return stringBuffer2;
    }
}
