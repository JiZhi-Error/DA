package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class lv extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    public long eYW = 0;
    public long erW = 0;
    private long fac = 0;
    public long fad = 0;
    public long fae = 0;
    public a fak;
    public long fal = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17111;
    }

    public final lv zg(String str) {
        AppMethodBeat.i(43504);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43504);
        return this;
    }

    public final lv zh(String str) {
        AppMethodBeat.i(43505);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43505);
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43502);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43502);
            return aVar;
        }

        static {
            AppMethodBeat.i(43503);
            AppMethodBeat.o(43503);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mh(int i2) {
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

    public final lv vo(long j2) {
        AppMethodBeat.i(43506);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43506);
        return this;
    }

    public final lv vp(long j2) {
        AppMethodBeat.i(43507);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43507);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43509);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        if (this.fak != null) {
            i2 = this.fak.value;
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
        stringBuffer.append(this.fal);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43509);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43510);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fak);
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
        stringBuffer.append("IsPreload:").append(this.fal);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43510);
        return stringBuffer2;
    }

    public final lv aiT() {
        AppMethodBeat.i(43508);
        this.fae = Util.nowMilliSecond();
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43508);
        return this;
    }
}
