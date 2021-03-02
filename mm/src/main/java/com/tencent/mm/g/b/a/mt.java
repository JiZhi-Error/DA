package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class mt extends com.tencent.mm.plugin.report.a {
    public long eJb = 0;
    private String eJx = "";
    private String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long erW = 0;
    private String faT = "";
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    public a fep;
    public b feq;
    private long fer = 0;
    private long fes;

    public mt() {
    }

    public mt(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(43676);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 14) {
                strArr = new String[14];
                Arrays.fill(strArr, 0, 14, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            zY(strArr[0]);
            zZ(strArr[1]);
            this.eXc = Util.getLong(strArr[2], 0);
            this.fep = a.mE(Util.getInt(strArr[3], 0));
            this.eYW = Util.getLong(strArr[4], 0);
            wP(Util.getLong(strArr[5], 0));
            this.erW = Util.getLong(strArr[6], 0);
            wR(Util.getLong(strArr[7], 0));
            wS(Util.getLong(strArr[8], 0));
            this.feq = b.mF(Util.getInt(strArr[9], 0));
            this.eJb = Util.getLong(strArr[10], 0);
            Aa(strArr[11]);
            this.fer = Util.getLong(strArr[12], 0);
            this.fes = Util.getLong(strArr[13], 0);
        }
        AppMethodBeat.o(43676);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15798;
    }

    public final mt zY(String str) {
        AppMethodBeat.i(43677);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43677);
        return this;
    }

    public final mt zZ(String str) {
        AppMethodBeat.i(43678);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43678);
        return this;
    }

    public final String getAppId() {
        return this.eJx;
    }

    public final mt wN(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43671);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43671);
            return aVar;
        }

        static {
            AppMethodBeat.i(43672);
            AppMethodBeat.o(43672);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mE(int i2) {
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

    public final mt a(a aVar) {
        this.fep = aVar;
        return this;
    }

    public final mt wO(long j2) {
        this.eYW = j2;
        return this;
    }

    public final mt wP(long j2) {
        AppMethodBeat.i(43679);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43679);
        return this;
    }

    public final mt wQ(long j2) {
        this.erW = j2;
        return this;
    }

    public final mt wR(long j2) {
        AppMethodBeat.i(43680);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43680);
        return this;
    }

    public final long aiV() {
        return this.fad;
    }

    public final mt wS(long j2) {
        AppMethodBeat.i(43681);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43681);
        return this;
    }

    public final long aiW() {
        return this.fae;
    }

    public enum b {
        ok(0),
        common_fail(1);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(43674);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(43674);
            return bVar;
        }

        static {
            AppMethodBeat.i(43675);
            AppMethodBeat.o(43675);
        }

        private b(int i2) {
            this.value = i2;
        }

        public static b mF(int i2) {
            switch (i2) {
                case 0:
                    return ok;
                case 1:
                    return common_fail;
                default:
                    return null;
            }
        }
    }

    public final mt a(b bVar) {
        this.feq = bVar;
        return this;
    }

    public final mt wT(long j2) {
        this.eJb = j2;
        return this;
    }

    public final mt Aa(String str) {
        AppMethodBeat.i(43682);
        this.faT = x(ch.COL_USERNAME, str, true);
        AppMethodBeat.o(43682);
        return this;
    }

    public final mt ajk() {
        this.fer = 1;
        return this;
    }

    public final mt wU(long j2) {
        this.fes = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3 = -1;
        AppMethodBeat.i(43683);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fep != null) {
            i2 = this.fep.value;
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
        if (this.feq != null) {
            i3 = this.feq.value;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        stringBuffer.append(",");
        stringBuffer.append(this.faT);
        stringBuffer.append(",");
        stringBuffer.append(this.fer);
        stringBuffer.append(",");
        stringBuffer.append(this.fes);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43683);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43684);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fep);
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
        stringBuffer.append("Ret:").append(this.feq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("username:").append(this.faT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isParallel:").append(this.fer);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isUesd:").append(this.fes);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43684);
        return stringBuffer2;
    }
}
