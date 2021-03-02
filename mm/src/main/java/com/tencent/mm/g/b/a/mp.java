package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mp extends com.tencent.mm.plugin.report.a {
    public String eJx = "";
    public String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long erW = 0;
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    public a fcP;
    public long fcQ = 0;
    public long fcR = 0;
    public long fcS = 0;
    public long fcT = 0;
    public long fcU = 0;
    public long fcV = 0;
    public long fcW = 0;
    public long fcX = 0;
    public long fcY = 0;
    public long fcZ = 0;
    public long fda = 0;
    public long fdb = 0;
    public long fdc = 0;
    public long fdd = 0;
    public long fde = 0;
    public long fdf = 0;
    public long fdg = 0;
    public long fdh = 0;
    public long fdi = 0;
    public long fdj = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16023;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43642);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43642);
            return aVar;
        }

        static {
            AppMethodBeat.i(43643);
            AppMethodBeat.o(43643);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mA(int i2) {
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

    public final mp ajh() {
        AppMethodBeat.i(43644);
        this.fac = 0;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43644);
        return this;
    }

    public final mp aji() {
        AppMethodBeat.i(43645);
        this.fad = 0;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43645);
        return this;
    }

    public final mp ajj() {
        AppMethodBeat.i(43646);
        this.fae = 0;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43646);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43647);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fcP != null) {
            i2 = this.fcP.value;
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
        stringBuffer.append(this.fcQ);
        stringBuffer.append(",");
        stringBuffer.append(this.fcR);
        stringBuffer.append(",");
        stringBuffer.append(this.fcS);
        stringBuffer.append(",");
        stringBuffer.append(this.fcT);
        stringBuffer.append(",");
        stringBuffer.append(this.fcU);
        stringBuffer.append(",");
        stringBuffer.append(this.fcV);
        stringBuffer.append(",");
        stringBuffer.append(this.fcW);
        stringBuffer.append(",");
        stringBuffer.append(this.fcX);
        stringBuffer.append(",");
        stringBuffer.append(this.fcY);
        stringBuffer.append(",");
        stringBuffer.append(this.fcZ);
        stringBuffer.append(",");
        stringBuffer.append(this.fda);
        stringBuffer.append(",");
        stringBuffer.append(this.fdb);
        stringBuffer.append(",");
        stringBuffer.append(this.fdc);
        stringBuffer.append(",");
        stringBuffer.append(this.fdd);
        stringBuffer.append(",");
        stringBuffer.append(this.fde);
        stringBuffer.append(",");
        stringBuffer.append(this.fdf);
        stringBuffer.append(",");
        stringBuffer.append(this.fdg);
        stringBuffer.append(",");
        stringBuffer.append(this.fdh);
        stringBuffer.append(",");
        stringBuffer.append(this.fdi);
        stringBuffer.append(",");
        stringBuffer.append(this.fdj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43647);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43648);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fcP);
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
        stringBuffer.append("fps:").append(this.fcQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fpsVariance:").append(this.fcR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cpu:").append(this.fcS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("memory:").append(this.fcT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("memoryDiff:").append(this.fcU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("androidNativeMemory:").append(this.fcV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("androidDalvikMemory:").append(this.fcW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("runtimeDuration:").append(this.fcX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("runtimeCount:").append(this.fcY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mainCanvasType:").append(this.fcZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("triangles:").append(this.fda);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("drawcall:").append(this.fdb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("vertex:").append(this.fdc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("useCommandBuffer:").append(this.fdd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sceneId:").append(this.fde);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fpsEx:").append(this.fdf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("graphicsMemory:").append(this.fdg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cmdPool:").append(this.fdh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fpsLagCount:").append(this.fdi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fpsLowCount:").append(this.fdj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43648);
        return stringBuffer2;
    }
}
