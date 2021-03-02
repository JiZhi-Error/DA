package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mq extends com.tencent.mm.plugin.report.a {
    public String eJx = "";
    public String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long erW = 0;
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    public long fbe;
    public long fbf;
    public long fdA;
    public long fdB;
    public long fdC;
    public int fdD = -1;
    public long fdE;
    public long fdF = 0;
    public long fdG;
    public long fdH;
    public long fdI;
    public long fdJ;
    public long fdK;
    public long fdL;
    public long fdM;
    public long fdN;
    public long fdO = 0;
    public long fdP;
    public a fdo;
    public long fdp;
    public long fdq;
    public long fdr;
    public long fds;
    public long fdt;
    public long fdu;
    public long fdv;
    public long fdw;
    public long fdx;
    public long fdy;
    public long fdz;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18859;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(160516);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(160516);
            return aVar;
        }

        static {
            AppMethodBeat.i(160517);
            AppMethodBeat.o(160517);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mB(int i2) {
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

    public final mq wz(long j2) {
        AppMethodBeat.i(160518);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(160518);
        return this;
    }

    public final mq wA(long j2) {
        AppMethodBeat.i(160519);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(160519);
        return this;
    }

    public final mq wB(long j2) {
        AppMethodBeat.i(160520);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(160520);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(160521);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fdo != null) {
            i2 = this.fdo.value;
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
        stringBuffer.append(this.fbe);
        stringBuffer.append(",");
        stringBuffer.append(this.fdp);
        stringBuffer.append(",");
        stringBuffer.append(this.fdq);
        stringBuffer.append(",");
        stringBuffer.append(this.fdr);
        stringBuffer.append(",");
        stringBuffer.append(this.fds);
        stringBuffer.append(",");
        stringBuffer.append(this.fdt);
        stringBuffer.append(",");
        stringBuffer.append(this.fdu);
        stringBuffer.append(",");
        stringBuffer.append(this.fdv);
        stringBuffer.append(",");
        stringBuffer.append(this.fdw);
        stringBuffer.append(",");
        stringBuffer.append(this.fdx);
        stringBuffer.append(",");
        stringBuffer.append(this.fbf);
        stringBuffer.append(",");
        stringBuffer.append(this.fdy);
        stringBuffer.append(",");
        stringBuffer.append(this.fdz);
        stringBuffer.append(",");
        stringBuffer.append(this.fdA);
        stringBuffer.append(",");
        stringBuffer.append(this.fdB);
        stringBuffer.append(",");
        stringBuffer.append(this.fdC);
        stringBuffer.append(",");
        stringBuffer.append(this.fdD);
        stringBuffer.append(",");
        stringBuffer.append(this.fdE);
        stringBuffer.append(",");
        stringBuffer.append(this.fdF);
        stringBuffer.append(",");
        stringBuffer.append(this.fdG);
        stringBuffer.append(",");
        stringBuffer.append(this.fdH);
        stringBuffer.append(",");
        stringBuffer.append(this.fdI);
        stringBuffer.append(",");
        stringBuffer.append(this.fdJ);
        stringBuffer.append(",");
        stringBuffer.append(this.fdK);
        stringBuffer.append(",");
        stringBuffer.append(this.fdL);
        stringBuffer.append(",");
        stringBuffer.append(this.fdM);
        stringBuffer.append(",");
        stringBuffer.append(this.fdN);
        stringBuffer.append(",");
        stringBuffer.append(this.fdO);
        stringBuffer.append(",");
        stringBuffer.append(this.fdP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(160521);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(160522);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fdo);
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
        stringBuffer.append("showAd:").append(this.fbe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("willCheckStageTimeStamp:").append(this.fdp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("didCheckStageTimeStamp:").append(this.fdq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("checkStageTimeCost:").append(this.fdr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("willFirstStepViewLayoutTimeStamp:").append(this.fds);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("didFirstStepViewLayoutTimeStamp:").append(this.fdt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("firstStepViewLayoutTimeCost:").append(this.fdu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("willAllViewLayoutTimeStamp:").append(this.fdv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("didAllViewLayoutTimeStamp:").append(this.fdw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("allViewLayoutTimeCost:").append(this.fdx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("checkShowAdTimeThreshold:").append(this.fbf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shouldShowReceivedTimeStamp:").append(this.fdy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shouldShowEventCostTime:").append(this.fdz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("showCallTimeStamp:").append(this.fdA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("showCallCostTime:").append(this.fdB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("checkShowAdCostTime:").append(this.fdC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("benchmarkLevel:").append(this.fdD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("prepareServiceCostTime:").append(this.fdE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("notShowAdErrorCode:").append(this.fdF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("adOperateCallTime:").append(this.fdG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("adOperateCallReceivedTime:").append(this.fdH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("adOperateCallbackTime:").append(this.fdI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("adOperateCallbackReceivedTime:").append(this.fdJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("adOperrateCallCostTime:").append(this.fdK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("adOperateCallClientCostTime:").append(this.fdL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("codeBlockTimeThreshold:").append(this.fdM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("checkAdTimeThreshold:").append(this.fdN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("serviceInjectReady:").append(this.fdO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("publicLibVersion:").append(this.fdP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(160522);
        return stringBuffer2;
    }
}
