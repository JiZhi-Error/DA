package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class ms extends com.tencent.mm.plugin.report.a {
    public long eJb = 0;
    private String eJx = "";
    private String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public String eoK = "";
    public long erW = 0;
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    public a fec;
    public c fed;
    public b fee;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15764;
    }

    public final ms zW(String str) {
        AppMethodBeat.i(43663);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43663);
        return this;
    }

    public final ms zX(String str) {
        AppMethodBeat.i(43664);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43664);
        return this;
    }

    public final ms wH(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43655);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43655);
            return aVar;
        }

        static {
            AppMethodBeat.i(43656);
            AppMethodBeat.o(43656);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mD(int i2) {
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

    public final ms a(a aVar) {
        this.fec = aVar;
        return this;
    }

    public final ms wI(long j2) {
        this.eYW = j2;
        return this;
    }

    public final ms wJ(long j2) {
        AppMethodBeat.i(43665);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43665);
        return this;
    }

    public final ms wK(long j2) {
        this.erW = j2;
        return this;
    }

    public final ms wL(long j2) {
        AppMethodBeat.i(43666);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43666);
        return this;
    }

    public final ms wM(long j2) {
        AppMethodBeat.i(43667);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43667);
        return this;
    }

    public enum c {
        ok(0),
        common_fail(1);
        
        final int value;

        public static c valueOf(String str) {
            AppMethodBeat.i(43661);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(43661);
            return cVar;
        }

        static {
            AppMethodBeat.i(43662);
            AppMethodBeat.o(43662);
        }

        private c(int i2) {
            this.value = i2;
        }
    }

    public enum b {
        sync(0),
        async(1);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(43658);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(43658);
            return bVar;
        }

        static {
            AppMethodBeat.i(43659);
            AppMethodBeat.o(43659);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3;
        int i4 = -1;
        AppMethodBeat.i(43668);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fec != null) {
            i2 = this.fec.value;
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
        if (this.fed != null) {
            i3 = this.fed.value;
        } else {
            i3 = -1;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        if (this.fee != null) {
            i4 = this.fee.value;
        }
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        stringBuffer.append(",");
        stringBuffer.append(this.eoK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43668);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43669);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fec);
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
        stringBuffer.append("Ret:").append(this.fed);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSync:").append(this.fee);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserName:").append(this.eoK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43669);
        return stringBuffer2;
    }
}
