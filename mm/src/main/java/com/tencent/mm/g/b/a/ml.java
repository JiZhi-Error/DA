package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class ml extends com.tencent.mm.plugin.report.a {
    public String eJx = "";
    public String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long erW = 0;
    public String faI = "";
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    public long fbD = 0;
    public long fbF = 0;
    public long fbG = 0;
    public String fbm = "";
    public a fcp;
    public String fcq = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16006;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43612);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43612);
            return aVar;
        }

        static {
            AppMethodBeat.i(43613);
            AppMethodBeat.o(43613);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mx(int i2) {
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

    public final ml wn(long j2) {
        AppMethodBeat.i(43614);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43614);
        return this;
    }

    public final ml wo(long j2) {
        AppMethodBeat.i(43615);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43615);
        return this;
    }

    public final ml wp(long j2) {
        AppMethodBeat.i(43616);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43616);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43617);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fcp != null) {
            i2 = this.fcp.value;
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
        stringBuffer.append(this.fbm);
        stringBuffer.append(",");
        stringBuffer.append(this.fcq);
        stringBuffer.append(",");
        stringBuffer.append(this.fbD);
        stringBuffer.append(",");
        stringBuffer.append(this.fbG);
        stringBuffer.append(",");
        stringBuffer.append(this.fbF);
        stringBuffer.append(",");
        stringBuffer.append(this.faI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43617);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43618);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fcp);
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
        stringBuffer.append("path:").append(this.fbm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("referrer:").append(this.fcq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fileSize:").append(this.fbD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("useCodeCache:").append(this.fbG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineType:").append(this.fbF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineVersion:").append(this.faI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43618);
        return stringBuffer2;
    }
}
