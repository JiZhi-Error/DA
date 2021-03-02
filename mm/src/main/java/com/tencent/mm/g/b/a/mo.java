package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mo extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    private long eXc = 0;
    private long eYW = 0;
    private long erW = 0;
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    private a fcG;
    private long fcH = 0;
    private long fcI = 0;
    private String fcJ = "";
    private long fcK = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18032;
    }

    public final mo zP(String str) {
        AppMethodBeat.i(43636);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43636);
        return this;
    }

    public final mo zQ(String str) {
        AppMethodBeat.i(43637);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43637);
        return this;
    }

    public final mo wt(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43634);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43634);
            return aVar;
        }

        static {
            AppMethodBeat.i(43635);
            AppMethodBeat.o(43635);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mz(int i2) {
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

    public final mo a(a aVar) {
        this.fcG = aVar;
        return this;
    }

    public final mo wu(long j2) {
        this.eYW = j2;
        return this;
    }

    public final mo wv(long j2) {
        this.erW = j2;
        return this;
    }

    public final mo ww(long j2) {
        this.fcH = j2;
        return this;
    }

    public final mo wx(long j2) {
        this.fcI = j2;
        return this;
    }

    public final mo zR(String str) {
        AppMethodBeat.i(43638);
        this.fcJ = x("distribution", str, true);
        AppMethodBeat.o(43638);
        return this;
    }

    public final mo wy(long j2) {
        this.fcK = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43639);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fcG != null) {
            i2 = this.fcG.value;
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
        stringBuffer.append(this.fcH);
        stringBuffer.append(",");
        stringBuffer.append(this.fcI);
        stringBuffer.append(",");
        stringBuffer.append(this.fcJ);
        stringBuffer.append(",");
        stringBuffer.append(this.fcK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43639);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43640);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fcG);
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
        stringBuffer.append("processNum:").append(this.fcH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("runtimeNum:").append(this.fcI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("distribution:").append(this.fcJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mmtoolsAlive:").append(this.fcK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43640);
        return stringBuffer2;
    }
}
