package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class me extends com.tencent.mm.plugin.report.a {
    public String eJx = "";
    public String eWb = "";
    public long eXc;
    public long eYW;
    public long eZK;
    public long erW;
    public String exq = "";
    private long fac;
    private long fad;
    public long fae;
    public String fbm = "";
    public long fbo;
    public a fbu;
    public long fbv;
    public long fbw;
    public long fbx;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18798;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43563);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43563);
            return aVar;
        }

        static {
            AppMethodBeat.i(43564);
            AppMethodBeat.o(43564);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a ms(int i2) {
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

    public final me vO(long j2) {
        AppMethodBeat.i(43565);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43565);
        return this;
    }

    public final me vP(long j2) {
        AppMethodBeat.i(43566);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43566);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43568);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fbu != null) {
            i2 = this.fbu.value;
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
        stringBuffer.append(this.fbm);
        stringBuffer.append(",");
        stringBuffer.append(this.eZK);
        stringBuffer.append(",");
        stringBuffer.append(this.fbv);
        stringBuffer.append(",");
        stringBuffer.append(this.exq);
        stringBuffer.append(",");
        stringBuffer.append(this.fbw);
        stringBuffer.append(",");
        stringBuffer.append(this.fbo);
        stringBuffer.append(",");
        stringBuffer.append(this.fbx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43568);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43569);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fbu);
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
        stringBuffer.append("path:").append(this.fbm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPreload:").append(this.eZK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPreloadPageFrame:").append(this.fbv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networkType:").append(this.exq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isSplitCodeLib:").append(this.fbw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("initProcess:").append(this.fbo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isFirstPageRenderingCacheAccepted:").append(this.fbx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43569);
        return stringBuffer2;
    }

    public final me ajc() {
        AppMethodBeat.i(43567);
        this.fae = Util.nowMilliSecond();
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43567);
        return this;
    }
}