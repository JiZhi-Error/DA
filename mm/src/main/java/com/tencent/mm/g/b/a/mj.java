package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class mj extends a {
    private String eJx = "";
    private String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long eZK = 0;
    public long erW = 0;
    private String faI = "";
    private long fac = 0;
    public long fad = 0;
    public long fae = 0;
    public long fbC = 0;
    public long fbD = 0;
    public long fbF = 0;
    public long fbG = 0;
    public long fbH = 0;
    public long fbI = 0;
    private String fbS = "";
    private String fbZ = "";
    public long fca = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15815;
    }

    public final mj zw(String str) {
        AppMethodBeat.i(43591);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43591);
        return this;
    }

    public final mj zx(String str) {
        AppMethodBeat.i(43592);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43592);
        return this;
    }

    public final mj vW(long j2) {
        AppMethodBeat.i(43593);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43593);
        return this;
    }

    public final mj vX(long j2) {
        AppMethodBeat.i(43594);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43594);
        return this;
    }

    public final long aiV() {
        return this.fad;
    }

    public final mj vY(long j2) {
        AppMethodBeat.i(43595);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43595);
        return this;
    }

    public final long aiW() {
        return this.fae;
    }

    public final mj zy(String str) {
        AppMethodBeat.i(43596);
        this.fbZ = x(DownloadInfo.FILENAME, str, true);
        AppMethodBeat.o(43596);
        return this;
    }

    public final mj zz(String str) {
        AppMethodBeat.i(43597);
        this.fbS = x("libVersion", str, true);
        AppMethodBeat.o(43597);
        return this;
    }

    public final mj vZ(long j2) {
        this.fbD = j2;
        return this;
    }

    public final mj ajg() {
        this.fbF = 5;
        return this;
    }

    public final mj wa(long j2) {
        this.fbG = j2;
        return this;
    }

    public final mj wb(long j2) {
        this.fbH = j2;
        return this;
    }

    public final mj wc(long j2) {
        this.fbI = j2;
        return this;
    }

    public final mj zA(String str) {
        AppMethodBeat.i(43598);
        this.faI = x("engineVersion", str, true);
        AppMethodBeat.o(43598);
        return this;
    }

    public final mj wd(long j2) {
        this.fca = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43599);
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
        stringBuffer.append(this.eZK);
        stringBuffer.append(",");
        stringBuffer.append(this.fbZ);
        stringBuffer.append(",");
        stringBuffer.append(this.fbS);
        stringBuffer.append(",");
        stringBuffer.append(this.fbD);
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
        stringBuffer.append(this.fca);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43599);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43600);
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
        stringBuffer.append("isPreload:").append(this.eZK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fileName:").append(this.fbZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("libVersion:").append(this.fbS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fileSize:").append(this.fbD);
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
        stringBuffer.append("codeCacheType:").append(this.fca);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43600);
        return stringBuffer2;
    }
}
