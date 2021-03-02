package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bj extends a {
    private long ejW;
    private String els = "";
    private long epY;
    private long esA;
    private String esd = "";
    private String esx = "";
    private String esy = "";
    private String esz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20671;
    }

    public final bj jj(String str) {
        AppMethodBeat.i(208871);
        this.esx = x("finderUsername", str, true);
        AppMethodBeat.o(208871);
        return this;
    }

    public final bj jk(String str) {
        AppMethodBeat.i(208872);
        this.esy = x("toUsername", str, true);
        AppMethodBeat.o(208872);
        return this;
    }

    public final bj jl(String str) {
        AppMethodBeat.i(208873);
        this.esz = x("toFinderUsername", str, true);
        AppMethodBeat.o(208873);
        return this;
    }

    public final bj dI(long j2) {
        this.ejW = j2;
        return this;
    }

    public final bj dJ(long j2) {
        this.epY = j2;
        return this;
    }

    public final bj jm(String str) {
        AppMethodBeat.i(208874);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(208874);
        return this;
    }

    public final String acA() {
        return this.els;
    }

    public final bj jn(String str) {
        AppMethodBeat.i(208875);
        this.esd = x("clicktabcontextid", str, true);
        AppMethodBeat.o(208875);
        return this;
    }

    public final String acB() {
        return this.esd;
    }

    public final bj dK(long j2) {
        this.esA = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208876);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.esx);
        stringBuffer.append(",");
        stringBuffer.append(this.esy);
        stringBuffer.append(",");
        stringBuffer.append(this.esz);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.epY);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.esd);
        stringBuffer.append(",");
        stringBuffer.append(this.esA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208876);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208877);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("finderUsername:").append(this.esx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("toUsername:").append(this.esy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("toFinderUsername:").append(this.esz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("result:").append(this.epY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clicktabcontextid:").append(this.esd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickScene:").append(this.esA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208877);
        return stringBuffer2;
    }
}
