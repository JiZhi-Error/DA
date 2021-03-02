package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fy extends a {
    private long eIk;
    private String eIl = "";
    private long eIm;
    private long elF;
    private String els = "";
    private String elt = "";
    private String erH = "";
    private String eui = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21155;
    }

    public final fy agI() {
        this.elF = 5;
        return this;
    }

    public final fy agJ() {
        this.eIk = 1;
        return this;
    }

    public final fy ta(String str) {
        AppMethodBeat.i(209266);
        this.eIl = x("MiniSessionId", str, true);
        AppMethodBeat.o(209266);
        return this;
    }

    public final fy pI(long j2) {
        this.eIm = j2;
        return this;
    }

    public final fy tb(String str) {
        AppMethodBeat.i(209267);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(209267);
        return this;
    }

    public final fy tc(String str) {
        AppMethodBeat.i(209268);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209268);
        return this;
    }

    public final fy td(String str) {
        AppMethodBeat.i(209269);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(209269);
        return this;
    }

    public final fy te(String str) {
        AppMethodBeat.i(209270);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209270);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209271);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elF);
        stringBuffer.append(",");
        stringBuffer.append(this.eIk);
        stringBuffer.append(",");
        stringBuffer.append(this.eIl);
        stringBuffer.append(",");
        stringBuffer.append(this.eIm);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209271);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209272);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OpType:").append(this.elF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpScene:").append(this.eIk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MiniSessionId:").append(this.eIl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TaskOrder:").append(this.eIm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209272);
        return stringBuffer2;
    }
}
