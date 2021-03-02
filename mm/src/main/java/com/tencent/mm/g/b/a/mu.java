package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mu extends com.tencent.mm.plugin.report.a {
    public long eJb = 0;
    private String eJx = "";
    private String eWb = "";
    private long eXc = 0;
    private long eYW = 0;
    private long erW = 0;
    private long fac = 0;
    public long fad = 0;
    private long fae = 0;
    private a feA;
    public long feB = 0;
    public b feC;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19986;
    }

    public final mu Ab(String str) {
        AppMethodBeat.i(226095);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(226095);
        return this;
    }

    public final mu Ac(String str) {
        AppMethodBeat.i(226096);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(226096);
        return this;
    }

    public final mu wV(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(226090);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(226090);
            return aVar;
        }

        static {
            AppMethodBeat.i(226091);
            AppMethodBeat.o(226091);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mG(int i2) {
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

    public final mu a(a aVar) {
        this.feA = aVar;
        return this;
    }

    public final mu wW(long j2) {
        this.eYW = j2;
        return this;
    }

    public final mu wX(long j2) {
        AppMethodBeat.i(226097);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(226097);
        return this;
    }

    public final mu wY(long j2) {
        this.erW = j2;
        return this;
    }

    public final mu wZ(long j2) {
        AppMethodBeat.i(226098);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(226098);
        return this;
    }

    public final mu xa(long j2) {
        AppMethodBeat.i(226099);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(226099);
        return this;
    }

    public enum b {
        sync(0),
        async(1);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(226093);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(226093);
            return bVar;
        }

        static {
            AppMethodBeat.i(226094);
            AppMethodBeat.o(226094);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3 = -1;
        AppMethodBeat.i(226100);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.feA != null) {
            i2 = this.feA.value;
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
        stringBuffer.append(this.feB);
        stringBuffer.append(",");
        if (this.feC != null) {
            i3 = this.feC.value;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226100);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226101);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.feA);
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
        stringBuffer.append("Ret:").append(this.feB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSync:").append(this.feC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226101);
        return stringBuffer2;
    }
}
