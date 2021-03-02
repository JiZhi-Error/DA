package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class lo extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private long eXc = 0;
    private long eYW = 0;
    private a eZd;
    private long eZe = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17688;
    }

    public final lo yV(String str) {
        AppMethodBeat.i(43475);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43475);
        return this;
    }

    public final lo ve(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43473);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43473);
            return aVar;
        }

        static {
            AppMethodBeat.i(43474);
            AppMethodBeat.o(43474);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mc(int i2) {
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

    public final lo a(a aVar) {
        this.eZd = aVar;
        return this;
    }

    public final lo vf(long j2) {
        this.eYW = j2;
        return this;
    }

    public final lo vg(long j2) {
        this.eZe = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43476);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.eZd != null) {
            i2 = this.eZd.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.eZe);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43476);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43477);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.eZd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileAllocSize:").append(this.eZe);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43477);
        return stringBuffer2;
    }
}
