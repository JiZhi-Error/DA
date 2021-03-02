package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mr extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    private long eXc = 0;
    private long eYW = 0;
    private long erW = 0;
    private String exq = "";
    private a fdU;
    private String fdV = "";
    private long fdW = 0;
    private long fdX = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17120;
    }

    public final mr zS(String str) {
        AppMethodBeat.i(180162);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(180162);
        return this;
    }

    public final mr wC(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43650);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43650);
            return aVar;
        }

        static {
            AppMethodBeat.i(43651);
            AppMethodBeat.o(43651);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mC(int i2) {
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

    public final mr a(a aVar) {
        this.fdU = aVar;
        return this;
    }

    public final mr wD(long j2) {
        this.eYW = j2;
        return this;
    }

    public final mr zT(String str) {
        AppMethodBeat.i(180163);
        this.fdV = x("Provider", str, true);
        AppMethodBeat.o(180163);
        return this;
    }

    public final mr wE(long j2) {
        this.fdW = j2;
        return this;
    }

    public final mr wF(long j2) {
        this.fdX = j2;
        return this;
    }

    public final mr zU(String str) {
        AppMethodBeat.i(180164);
        this.exq = x("networkType", str, true);
        AppMethodBeat.o(180164);
        return this;
    }

    public final mr zV(String str) {
        AppMethodBeat.i(180165);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(180165);
        return this;
    }

    public final mr wG(long j2) {
        this.erW = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43652);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fdU != null) {
            i2 = this.fdU.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.fdV);
        stringBuffer.append(",");
        stringBuffer.append(this.fdW);
        stringBuffer.append(",");
        stringBuffer.append(this.fdX);
        stringBuffer.append(",");
        stringBuffer.append(this.exq);
        stringBuffer.append(",");
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43652);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43653);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fdU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Provider:").append(this.fdV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Version:").append(this.fdW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Stage:").append(this.fdX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networkType:").append(this.exq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43653);
        return stringBuffer2;
    }
}
