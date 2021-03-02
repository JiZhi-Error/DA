package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class mz extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long eZK = 0;
    public long erW = 0;
    public long evl = 0;
    private long fac = 0;
    private long fad = 0;
    public long fae = 0;
    public a ffI;
    public long ffJ = 0;
    private String ffK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15813;
    }

    public final mz Ai(String str) {
        AppMethodBeat.i(43734);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43734);
        return this;
    }

    public final mz Aj(String str) {
        AppMethodBeat.i(43735);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43735);
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43732);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43732);
            return aVar;
        }

        static {
            AppMethodBeat.i(43733);
            AppMethodBeat.o(43733);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mL(int i2) {
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

    public final mz xu(long j2) {
        AppMethodBeat.i(43736);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43736);
        return this;
    }

    public final mz xv(long j2) {
        AppMethodBeat.i(43737);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43737);
        return this;
    }

    public final mz Ak(String str) {
        AppMethodBeat.i(43739);
        this.ffK = x("engineVersionStr", str, true);
        AppMethodBeat.o(43739);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43740);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.ffI != null) {
            i2 = this.ffI.value;
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
        stringBuffer.append(this.eZK);
        stringBuffer.append(",");
        stringBuffer.append(this.evl);
        stringBuffer.append(",");
        stringBuffer.append(this.ffJ);
        stringBuffer.append(",");
        stringBuffer.append(this.ffK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43740);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43741);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.ffI);
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
        stringBuffer.append("type:").append(this.evl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineVersion:").append(this.ffJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("engineVersionStr:").append(this.ffK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43741);
        return stringBuffer2;
    }

    public final mz ajn() {
        AppMethodBeat.i(43738);
        this.fae = Util.nowMilliSecond();
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43738);
        return this;
    }
}
