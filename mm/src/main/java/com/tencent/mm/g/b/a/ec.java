package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ec extends a {
    private int eCs;
    private long eCt = -1;
    private String eCu = "";
    private String eCv = "";
    private int eCw = -1;
    private String eCx = "";
    private long eCy = -1;
    private long eCz = -1;
    private long eiE;
    private String eyH = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22138;
    }

    public final ec afx() {
        this.eCs = 8;
        return this;
    }

    public final ec lz(long j2) {
        this.eCt = j2;
        return this;
    }

    public final ec qF(String str) {
        AppMethodBeat.i(209212);
        this.eCu = x("actionName", str, true);
        AppMethodBeat.o(209212);
        return this;
    }

    public final ec qG(String str) {
        AppMethodBeat.i(209213);
        this.eCv = x("actionExt", str, true);
        AppMethodBeat.o(209213);
        return this;
    }

    public final ec le(int i2) {
        this.eCw = i2;
        return this;
    }

    public final ec qH(String str) {
        AppMethodBeat.i(209214);
        this.eCx = x("resultExt", str, true);
        AppMethodBeat.o(209214);
        return this;
    }

    public final ec lA(long j2) {
        this.eiE = j2;
        return this;
    }

    public final ec qI(String str) {
        AppMethodBeat.i(209215);
        this.eyH = x("snn", str, true);
        AppMethodBeat.o(209215);
        return this;
    }

    public final ec lB(long j2) {
        this.eCy = j2;
        return this;
    }

    public final ec lC(long j2) {
        this.eCz = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209216);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eCs);
        stringBuffer.append(",");
        stringBuffer.append(this.eCt);
        stringBuffer.append(",");
        stringBuffer.append(this.eCu);
        stringBuffer.append(",");
        stringBuffer.append(this.eCv);
        stringBuffer.append(",");
        stringBuffer.append(this.eCw);
        stringBuffer.append(",");
        stringBuffer.append(this.eCx);
        stringBuffer.append(",");
        stringBuffer.append(this.eiE);
        stringBuffer.append(",");
        stringBuffer.append(this.eyH);
        stringBuffer.append(",");
        stringBuffer.append(this.eCy);
        stringBuffer.append(",");
        stringBuffer.append(this.eCz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209216);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209217);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("innerversion:").append(this.eCs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionCode:").append(this.eCt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionName:").append(this.eCu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionExt:").append(this.eCv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("result:").append(this.eCw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("resultExt:").append(this.eCx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentScene:").append(this.eiE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("snn:").append(this.eyH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cost:").append(this.eCy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionTime:").append(this.eCz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209217);
        return stringBuffer2;
    }
}
