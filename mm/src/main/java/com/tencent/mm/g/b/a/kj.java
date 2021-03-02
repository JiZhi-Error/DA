package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kj extends a {
    private long eVs = 0;
    private long eVt = 0;
    private String eVu = "";
    private long eVv = 0;
    private String eVw = "";
    private long eVx = 0;
    private long eVy = 0;
    private long eVz = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17121;
    }

    public final kj xE(String str) {
        AppMethodBeat.i(74988);
        this.eVu = x("QueryContent", str, true);
        AppMethodBeat.o(74988);
        return this;
    }

    public final kj th(long j2) {
        this.eVv = j2;
        return this;
    }

    public final kj xF(String str) {
        AppMethodBeat.i(74989);
        this.eVw = x("Behavior", str, true);
        AppMethodBeat.o(74989);
        return this;
    }

    public final String ain() {
        return this.eVw;
    }

    public final kj ti(long j2) {
        this.eVx = j2;
        return this;
    }

    public final kj tj(long j2) {
        this.eVy = j2;
        return this;
    }

    public final kj tk(long j2) {
        this.eVz = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(74990);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eVs);
        stringBuffer.append(",");
        stringBuffer.append(this.eVt);
        stringBuffer.append(",");
        stringBuffer.append(this.eVu);
        stringBuffer.append(",");
        stringBuffer.append(this.eVv);
        stringBuffer.append(",");
        stringBuffer.append(this.eVw);
        stringBuffer.append(",");
        stringBuffer.append(this.eVx);
        stringBuffer.append(",");
        stringBuffer.append(this.eVy);
        stringBuffer.append(",");
        stringBuffer.append(this.eVz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(74990);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(74991);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SearchID:").append(this.eVs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecommentID:").append(this.eVt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QueryContent:").append(this.eVu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinishType:").append(this.eVv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Behavior:").append(this.eVw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MaxIndex:").append(this.eVx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewSearchID:").append(this.eVy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewRecommentID:").append(this.eVz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(74991);
        return stringBuffer2;
    }
}
