package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jr extends a {
    private long eQv = 0;
    private long eRK = 0;
    private String eSj = "";
    private String eSk = "";
    private long eqk = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16763;
    }

    public final jr sM(long j2) {
        this.eQv = j2;
        return this;
    }

    public final jr sN(long j2) {
        this.eRK = j2;
        return this;
    }

    public final jr sO(long j2) {
        this.eqk = j2;
        return this;
    }

    public final long ahy() {
        return this.eqk;
    }

    public final jr wX(String str) {
        AppMethodBeat.i(118512);
        this.eSj = x("StoryOwnerUserName", str, true);
        AppMethodBeat.o(118512);
        return this;
    }

    public final jr wY(String str) {
        AppMethodBeat.i(118513);
        this.eSk = x("StoryTid", str, true);
        AppMethodBeat.o(118513);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118514);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eQv);
        stringBuffer.append(",");
        stringBuffer.append(this.eRK);
        stringBuffer.append(",");
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eSj);
        stringBuffer.append(",");
        stringBuffer.append(this.eSk);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118514);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118515);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PreviewEnterScene:").append(this.eQv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ProfileSource:").append(this.eRK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StoryOwnerUserName:").append(this.eSj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StoryTid:").append(this.eSk);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118515);
        return stringBuffer2;
    }
}
