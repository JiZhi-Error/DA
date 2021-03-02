package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class lu extends com.tencent.mm.plugin.report.a {
    public String eJx = "";
    public String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long erW = 0;
    public a fab;
    private long fac = 0;
    public long fad = 0;
    public long fae = 0;
    public long faf = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16900;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43494);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43494);
            return aVar;
        }

        static {
            AppMethodBeat.i(43495);
            AppMethodBeat.o(43495);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mg(int i2) {
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

    public final lu vl(long j2) {
        AppMethodBeat.i(43496);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43496);
        return this;
    }

    public final lu vm(long j2) {
        AppMethodBeat.i(43497);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43497);
        return this;
    }

    public final lu vn(long j2) {
        AppMethodBeat.i(43498);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43498);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43499);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fab != null) {
            i2 = this.fab.value;
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
        stringBuffer.append(this.faf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43499);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43500);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fab);
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
        stringBuffer.append("BootstepType:").append(this.faf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43500);
        return stringBuffer2;
    }
}
