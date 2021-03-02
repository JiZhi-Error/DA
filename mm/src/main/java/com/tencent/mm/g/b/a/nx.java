package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nx extends a {
    private String fhv = "";
    private String fiH = "";
    private String fiI = "";
    private int fiJ = -1;
    private long fiK = 0;
    private String fiL = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19316;
    }

    public final nx Ba(String str) {
        AppMethodBeat.i(220244);
        this.fiH = x("ViewId", str, true);
        AppMethodBeat.o(220244);
        return this;
    }

    public final nx Bb(String str) {
        AppMethodBeat.i(220245);
        this.fhv = x("PageId", str, true);
        AppMethodBeat.o(220245);
        return this;
    }

    public final nx Bc(String str) {
        AppMethodBeat.i(220246);
        this.fiI = x("LayoutId", str, true);
        AppMethodBeat.o(220246);
        return this;
    }

    public final nx mY(int i2) {
        this.fiJ = i2;
        return this;
    }

    public final nx ys(long j2) {
        this.fiK = j2;
        return this;
    }

    public final nx Bd(String str) {
        AppMethodBeat.i(220247);
        this.fiL = x("resName", str, true);
        AppMethodBeat.o(220247);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184287);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fiH);
        stringBuffer.append(",");
        stringBuffer.append(this.fhv);
        stringBuffer.append(",");
        stringBuffer.append(this.fiI);
        stringBuffer.append(",");
        stringBuffer.append(this.fiJ);
        stringBuffer.append(",");
        stringBuffer.append(this.fiK);
        stringBuffer.append(",");
        stringBuffer.append(this.fiL);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184287);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184288);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ViewId:").append(this.fiH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageId:").append(this.fhv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LayoutId:").append(this.fiI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpEvent:").append(this.fiJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timeConsuming:").append(this.fiK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("resName:").append(this.fiL);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184288);
        return stringBuffer2;
    }
}
