package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mw extends com.tencent.mm.plugin.report.a {
    public String eJx = "";
    public String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    private long fac = 0;
    public a ffa;
    private long ffb = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15853;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43703);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43703);
            return aVar;
        }

        static {
            AppMethodBeat.i(43704);
            AppMethodBeat.o(43704);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mI(int i2) {
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

    public final mw xj(long j2) {
        AppMethodBeat.i(43705);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43705);
        return this;
    }

    public final mw xk(long j2) {
        AppMethodBeat.i(43706);
        this.ffb = j2;
        super.bi("WaitingTimeMs", this.ffb);
        AppMethodBeat.o(43706);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43707);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.ffa != null) {
            i2 = this.ffa.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.fac);
        stringBuffer.append(",");
        stringBuffer.append(this.ffb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43707);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43708);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.ffa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTimeMs:").append(this.fac);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitingTimeMs:").append(this.ffb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43708);
        return stringBuffer2;
    }
}
