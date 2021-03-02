package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class mg extends a {
    public String eJx = "";
    public String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long erW = 0;
    private String faI = "";
    private long fac = 0;
    public long fad = 0;
    public long fae = 0;
    public long fbC = 0;
    public long fbD = 0;
    public String fbE = "";
    public long fbF = 0;
    public long fbG = 0;
    public long fbH = 0;
    public long fbI = 0;
    public String fbJ = "";
    public String fbK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16007;
    }

    public final mg vQ(long j2) {
        AppMethodBeat.i(43570);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43570);
        return this;
    }

    public final mg vR(long j2) {
        AppMethodBeat.i(43571);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43571);
        return this;
    }

    public final mg zv(String str) {
        AppMethodBeat.i(177749);
        this.faI = x("engineVersion", str, true);
        AppMethodBeat.o(177749);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43573);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        stringBuffer.append(this.fbC);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.fac);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.fad);
        stringBuffer.append(",");
        stringBuffer.append(this.fae);
        stringBuffer.append(",");
        stringBuffer.append(this.fbD);
        stringBuffer.append(",");
        stringBuffer.append(this.fbE);
        stringBuffer.append(",");
        stringBuffer.append(this.fbF);
        stringBuffer.append(",");
        stringBuffer.append(this.fbG);
        stringBuffer.append(",");
        stringBuffer.append(this.fbH);
        stringBuffer.append(",");
        stringBuffer.append(this.fbI);
        stringBuffer.append(",");
        stringBuffer.append(this.faI);
        stringBuffer.append(",");
        stringBuffer.append(this.fbJ);
        stringBuffer.append(",");
        stringBuffer.append(this.fbK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43573);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43574);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fbC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTimeMs:").append(this.fac);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartTimeStampMs:").append(this.fad);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndTimeStampMs:").append(this.fae);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fileSize:").append(this.fbD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("filePath:").append(this.fbE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineType:").append(this.fbF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("useCodeCache:").append(this.fbG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("useIsolatedContext:").append(this.fbH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("compileTime:").append(this.fbI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineVersion:").append(this.faI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("pluginAppid:").append(this.fbJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("pluginVersion:").append(this.fbK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43574);
        return stringBuffer2;
    }

    public final mg ajd() {
        AppMethodBeat.i(43572);
        this.fae = Util.nowMilliSecond();
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43572);
        return this;
    }
}
