package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.c.ch;

public final class mv extends com.tencent.mm.plugin.report.a {
    public long eJb = 0;
    private String eJx = "";
    private String eWb = "";
    private long eXc = 0;
    private long eYW = 0;
    private long erW = 0;
    private String faT = "";
    private long fac = 0;
    public long fad = 0;
    private long fae = 0;
    private a feK;
    public c feL;
    public b feM;
    public long feN = 0;
    private long fer = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15765;
    }

    public final mv Ad(String str) {
        AppMethodBeat.i(43694);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43694);
        return this;
    }

    public final mv Ae(String str) {
        AppMethodBeat.i(43695);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43695);
        return this;
    }

    public final mv xb(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43686);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43686);
            return aVar;
        }

        static {
            AppMethodBeat.i(43687);
            AppMethodBeat.o(43687);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mH(int i2) {
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

    public final mv a(a aVar) {
        this.feK = aVar;
        return this;
    }

    public final mv xc(long j2) {
        this.eYW = j2;
        return this;
    }

    public final mv xd(long j2) {
        AppMethodBeat.i(43696);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43696);
        return this;
    }

    public final mv xe(long j2) {
        this.erW = j2;
        return this;
    }

    public final mv xf(long j2) {
        AppMethodBeat.i(43697);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43697);
        return this;
    }

    public final mv xg(long j2) {
        AppMethodBeat.i(43698);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43698);
        return this;
    }

    public enum c {
        ok(0),
        common_fail(1),
        bundle_null(2),
        jsapi_control_bytes_null(3);
        
        final int value;

        public static c valueOf(String str) {
            AppMethodBeat.i(43692);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(43692);
            return cVar;
        }

        static {
            AppMethodBeat.i(43693);
            AppMethodBeat.o(43693);
        }

        private c(int i2) {
            this.value = i2;
        }
    }

    public final mv a(c cVar) {
        this.feL = cVar;
        return this;
    }

    public enum b {
        sync(0),
        async(1);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(43689);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(43689);
            return bVar;
        }

        static {
            AppMethodBeat.i(43690);
            AppMethodBeat.o(43690);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    public final mv a(b bVar) {
        this.feM = bVar;
        return this;
    }

    public final mv xh(long j2) {
        this.eJb = j2;
        return this;
    }

    public final mv xi(long j2) {
        this.feN = j2;
        return this;
    }

    public final mv Af(String str) {
        AppMethodBeat.i(43699);
        this.faT = x(ch.COL_USERNAME, str, true);
        AppMethodBeat.o(43699);
        return this;
    }

    public final mv ajl() {
        this.fer = 1;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3;
        int i4 = -1;
        AppMethodBeat.i(43700);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.feK != null) {
            i2 = this.feK.value;
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
        if (this.feL != null) {
            i3 = this.feL.value;
        } else {
            i3 = -1;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        if (this.feM != null) {
            i4 = this.feM.value;
        }
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        stringBuffer.append(",");
        stringBuffer.append(this.feN);
        stringBuffer.append(",");
        stringBuffer.append(this.faT);
        stringBuffer.append(",");
        stringBuffer.append(this.fer);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43700);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43701);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.feK);
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
        stringBuffer.append("Ret:").append(this.feL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSync:").append(this.feM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsNormalOpen:").append(this.feN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("username:").append(this.faT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isParallel:").append(this.fer);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43701);
        return stringBuffer2;
    }
}
