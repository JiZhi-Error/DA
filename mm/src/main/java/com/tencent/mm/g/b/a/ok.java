package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ok extends a {
    private long orC = 0;
    private String orD = "";
    private String orj = "";
    private String ork = "";
    private long orl = 0;
    private long orm = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21976;
    }

    public final ok atP(String str) {
        AppMethodBeat.i(260014);
        this.orj = x("AppName", str, true);
        AppMethodBeat.o(260014);
        return this;
    }

    public final ok awy(String str) {
        AppMethodBeat.i(260015);
        this.ork = x("PermissionList", str, true);
        AppMethodBeat.o(260015);
        return this;
    }

    public final ok PM(long j2) {
        this.orl = j2;
        return this;
    }

    public final ok PN(long j2) {
        this.orm = j2;
        return this;
    }

    public final ok PO(long j2) {
        this.orC = j2;
        return this;
    }

    public final ok axE(String str) {
        AppMethodBeat.i(260016);
        this.orD = x("CpuInfo", str, true);
        AppMethodBeat.o(260016);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(260017);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.orj);
        stringBuffer.append(",");
        stringBuffer.append(this.ork);
        stringBuffer.append(",");
        stringBuffer.append(this.orl);
        stringBuffer.append(",");
        stringBuffer.append(this.orm);
        stringBuffer.append(",");
        stringBuffer.append(this.orC);
        stringBuffer.append(",");
        stringBuffer.append(this.orD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(260017);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(260018);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppName:").append(this.orj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PermissionList:").append(this.ork);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MemorySize:").append(this.orl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RamSize:").append(this.orm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RomSize:").append(this.orC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpuInfo:").append(this.orD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(260018);
        return stringBuffer2;
    }
}
