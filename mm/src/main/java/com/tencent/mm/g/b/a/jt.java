package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jt extends a {
    private long eQv = 0;
    private String eSp = "";
    private String eSq = "";
    private long eSr = 0;
    private String eSs = "";
    private String eSt = "";
    private long eqk = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16842;
    }

    public final jt sP(long j2) {
        this.eqk = j2;
        return this;
    }

    public final jt sQ(long j2) {
        this.eQv = j2;
        return this;
    }

    public final jt xc(String str) {
        AppMethodBeat.i(118516);
        this.eSp = x("WaitPlayVideoList", str, true);
        AppMethodBeat.o(118516);
        return this;
    }

    public final String ahQ() {
        return this.eSp;
    }

    public final jt sR(long j2) {
        this.eSr = j2;
        return this;
    }

    public final jt xd(String str) {
        AppMethodBeat.i(118517);
        this.eSs = x("WaitPlayVideoList1", str, true);
        AppMethodBeat.o(118517);
        return this;
    }

    public final String ahR() {
        return this.eSs;
    }

    public final jt xe(String str) {
        AppMethodBeat.i(118518);
        this.eSt = x("WaitPlayVideoList2", str, true);
        AppMethodBeat.o(118518);
        return this;
    }

    public final String ahS() {
        return this.eSt;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118519);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eQv);
        stringBuffer.append(",");
        stringBuffer.append(this.eSp);
        stringBuffer.append(",");
        stringBuffer.append(this.eSq);
        stringBuffer.append(",");
        stringBuffer.append(this.eSr);
        stringBuffer.append(",");
        stringBuffer.append(this.eSs);
        stringBuffer.append(",");
        stringBuffer.append(this.eSt);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118519);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118520);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreviewEnterScene:").append(this.eQv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitPlayVideoList:").append(this.eSp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitPlayUinList:").append(this.eSq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("index:").append(this.eSr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitPlayVideoList1:").append(this.eSs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitPlayVideoList2:").append(this.eSt);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118520);
        return stringBuffer2;
    }
}
