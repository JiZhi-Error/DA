package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mm extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long erW = 0;
    private String faI = "";
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    public long fbD = 0;
    public long fbF = 0;
    public long fbG = 0;
    private long fbv = 0;
    public a fcv;
    private String fcw = "";
    private String fcx = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16005;
    }

    public final mm zK(String str) {
        AppMethodBeat.i(43622);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43622);
        return this;
    }

    public final mm zL(String str) {
        AppMethodBeat.i(43623);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43623);
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43620);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43620);
            return aVar;
        }

        static {
            AppMethodBeat.i(43621);
            AppMethodBeat.o(43621);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a my(int i2) {
            switch (i2) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return demo;
                default:
                    return null;
            }
        }
    }

    public final mm wq(long j2) {
        AppMethodBeat.i(43624);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43624);
        return this;
    }

    public final mm wr(long j2) {
        AppMethodBeat.i(43625);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43625);
        return this;
    }

    public final mm ws(long j2) {
        AppMethodBeat.i(43626);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43626);
        return this;
    }

    public final mm zM(String str) {
        AppMethodBeat.i(43627);
        this.fcw = x("package", str, true);
        AppMethodBeat.o(43627);
        return this;
    }

    public final mm zN(String str) {
        AppMethodBeat.i(43628);
        this.faI = x("engineVersion", str, true);
        AppMethodBeat.o(43628);
        return this;
    }

    public final mm zO(String str) {
        AppMethodBeat.i(226088);
        this.fcx = x("lazyLoadKey", str, true);
        AppMethodBeat.o(226088);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43629);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fcv != null) {
            i2 = this.fcv.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
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
        stringBuffer.append(this.fcw);
        stringBuffer.append(",");
        stringBuffer.append(this.fbD);
        stringBuffer.append(",");
        stringBuffer.append(this.fbv);
        stringBuffer.append(",");
        stringBuffer.append(this.fbG);
        stringBuffer.append(",");
        stringBuffer.append(this.fbF);
        stringBuffer.append(",");
        stringBuffer.append(this.faI);
        stringBuffer.append(",");
        stringBuffer.append(this.fcx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43629);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43630);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fcv);
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
        stringBuffer.append("package:").append(this.fcw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fileSize:").append(this.fbD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPreloadPageFrame:").append(this.fbv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("useCodeCache:").append(this.fbG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineType:").append(this.fbF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineVersion:").append(this.faI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("lazyLoadKey:").append(this.fcx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43630);
        return stringBuffer2;
    }
}
