package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fr extends a {
    private String eGT = "";
    public long eGU = 0;
    private String eGV = "";
    public String eGW = "";
    public long eGX = 0;
    private String eiB = "";
    private String eqv = "";
    private long erW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16019;
    }

    public final fr agD() {
        this.erW = 47;
        return this;
    }

    public final fr sF(String str) {
        AppMethodBeat.i(116477);
        this.eGT = x("SearchId", str, true);
        AppMethodBeat.o(116477);
        return this;
    }

    public final fr sG(String str) {
        AppMethodBeat.i(116478);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(116478);
        return this;
    }

    public final fr sH(String str) {
        AppMethodBeat.i(116479);
        this.eqv = x("Query", str, true);
        AppMethodBeat.o(116479);
        return this;
    }

    public final fr sI(String str) {
        AppMethodBeat.i(116480);
        this.eGV = x("Path", str, true);
        AppMethodBeat.o(116480);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116481);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eGT);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eqv);
        stringBuffer.append(",");
        stringBuffer.append(this.eGU);
        stringBuffer.append(",");
        stringBuffer.append(this.eGV);
        stringBuffer.append(",");
        stringBuffer.append(this.eGW);
        stringBuffer.append(",");
        stringBuffer.append(this.eGX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116481);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116482);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SearchId:").append(this.eGT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Query:").append(this.eqv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpType:").append(this.eGU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Path:").append(this.eGV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WeappUsrname:").append(this.eGW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ServiceType:").append(this.eGX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116482);
        return stringBuffer2;
    }
}
