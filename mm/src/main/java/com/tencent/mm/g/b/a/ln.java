package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class ln extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private long eXc = 0;
    private a eYV;
    private long eYW = 0;
    private long eYX = 0;
    private String eYY = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17687;
    }

    public final ln yT(String str) {
        AppMethodBeat.i(43469);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43469);
        return this;
    }

    public final String getAppId() {
        return this.eJx;
    }

    public final ln vb(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43467);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43467);
            return aVar;
        }

        static {
            AppMethodBeat.i(43468);
            AppMethodBeat.o(43468);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mb(int i2) {
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

    public final ln a(a aVar) {
        this.eYV = aVar;
        return this;
    }

    public final ln vc(long j2) {
        this.eYW = j2;
        return this;
    }

    public final ln vd(long j2) {
        this.eYX = j2;
        return this;
    }

    public final long aiR() {
        return this.eYX;
    }

    public final ln yU(String str) {
        AppMethodBeat.i(180149);
        this.eYY = x("DirPrefix", str, true);
        AppMethodBeat.o(180149);
        return this;
    }

    public final String aiS() {
        return this.eYY;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43470);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.eYV != null) {
            i2 = this.eYV.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.eYX);
        stringBuffer.append(",");
        stringBuffer.append(this.eYY);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43470);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43471);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.eYV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileOccupation:").append(this.eYX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DirPrefix:").append(this.eYY);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43471);
        return stringBuffer2;
    }
}
