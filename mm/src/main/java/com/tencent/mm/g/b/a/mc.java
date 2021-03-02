package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;

public final class mc extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long eZK = 0;
    public long eZN = 0;
    public long erW = 0;
    private String exq = "";
    private String faT = "";
    private long fac = 0;
    public long fad = 0;
    public long fae = 0;
    public a fba;
    public long fbb = 0;
    public long fbc = 0;
    public long fbd;
    public long fbe = 0;
    public long fbf = 0;
    public long fbg = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18033;
    }

    public final mc zp(String str) {
        AppMethodBeat.i(43553);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43553);
        return this;
    }

    public final mc zq(String str) {
        AppMethodBeat.i(43554);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43554);
        return this;
    }

    public final mc vF(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43551);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43551);
            return aVar;
        }

        static {
            AppMethodBeat.i(43552);
            AppMethodBeat.o(43552);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mq(int i2) {
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

    public final mc a(a aVar) {
        this.fba = aVar;
        return this;
    }

    public final mc vG(long j2) {
        this.eYW = j2;
        return this;
    }

    public final mc vH(long j2) {
        AppMethodBeat.i(43555);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43555);
        return this;
    }

    public final mc vI(long j2) {
        this.erW = j2;
        return this;
    }

    public final mc vJ(long j2) {
        AppMethodBeat.i(43556);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43556);
        return this;
    }

    public final long aiV() {
        return this.fad;
    }

    public final long aiW() {
        return this.fae;
    }

    public final mc zr(String str) {
        AppMethodBeat.i(43558);
        this.faT = x(ch.COL_USERNAME, str, true);
        AppMethodBeat.o(43558);
        return this;
    }

    public final mc aiY() {
        this.eZN = 0;
        return this;
    }

    public final mc aiZ() {
        this.eZK = 0;
        return this;
    }

    public final mc zs(String str) {
        AppMethodBeat.i(43559);
        this.exq = x("networkType", str, true);
        AppMethodBeat.o(43559);
        return this;
    }

    public final mc vK(long j2) {
        this.fbb = j2;
        return this;
    }

    public final mc aja() {
        this.fbc = 2;
        return this;
    }

    public final mc ajb() {
        this.fbd = 0;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43560);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fba != null) {
            i2 = this.fba.value;
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
        stringBuffer.append(this.faT);
        stringBuffer.append(",");
        stringBuffer.append(this.eZN);
        stringBuffer.append(",");
        stringBuffer.append(this.eZK);
        stringBuffer.append(",");
        stringBuffer.append(this.exq);
        stringBuffer.append(",");
        stringBuffer.append(this.fbb);
        stringBuffer.append(",");
        stringBuffer.append(this.fbc);
        stringBuffer.append(",");
        stringBuffer.append(this.fbd);
        stringBuffer.append(",");
        stringBuffer.append(this.fbe);
        stringBuffer.append(",");
        stringBuffer.append(this.fbf);
        stringBuffer.append(",");
        stringBuffer.append(this.fbg);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43560);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43561);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fba);
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
        stringBuffer.append("username:").append(this.faT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isDownloadCode:").append(this.eZN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPreload:").append(this.eZK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networkType:").append(this.exq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isContactSync:").append(this.fbb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isLaunchSync:").append(this.fbc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("phase:").append(this.fbd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("showAd:").append(this.fbe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("checkShowAdTimeThreshold:").append(this.fbf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isCheckJsApiInfoSync:").append(this.fbg);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43561);
        return stringBuffer2;
    }

    public final mc aiX() {
        AppMethodBeat.i(43557);
        this.fae = Util.nowMilliSecond();
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43557);
        return this;
    }
}
