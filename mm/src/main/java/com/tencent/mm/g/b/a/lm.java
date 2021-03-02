package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lm extends a {
    private long eYH;
    private String eYJ = "";
    private String eYK = "";
    private String eYO = "";
    private int eYP;
    private long eYQ;
    private long eYR;
    private int eYS = -1;
    private long eYT;
    private int eYU;
    private String eiB = "";
    private int enq;
    private String eoz = "";
    private String err = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19944;
    }

    public final lm yN(String str) {
        AppMethodBeat.i(220234);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(220234);
        return this;
    }

    public final String getSessionId() {
        return this.eiB;
    }

    public final lm yO(String str) {
        AppMethodBeat.i(220235);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(220235);
        return this;
    }

    public final String adk() {
        return this.err;
    }

    public final lm uX(long j2) {
        this.eYQ = j2;
        return this;
    }

    public final long aiM() {
        return this.eYQ;
    }

    public final lm uY(long j2) {
        this.eYR = j2;
        return this;
    }

    public final long aiN() {
        return this.eYR;
    }

    public final lm lX(int i2) {
        this.eYS = i2;
        return this;
    }

    public final int aiO() {
        return this.eYS;
    }

    public final lm yP(String str) {
        AppMethodBeat.i(220236);
        this.eYJ = x("ItemExposureAreaWeigth", str, true);
        AppMethodBeat.o(220236);
        return this;
    }

    public final String aiF() {
        return this.eYJ;
    }

    public final lm yQ(String str) {
        AppMethodBeat.i(220237);
        this.eYK = x("ScreenExposureAreaWeigth", str, true);
        AppMethodBeat.o(220237);
        return this;
    }

    public final String aiG() {
        return this.eYK;
    }

    public final lm yR(String str) {
        AppMethodBeat.i(220238);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(220238);
        return this;
    }

    public final String acj() {
        return this.eoz;
    }

    public final lm lY(int i2) {
        this.enq = i2;
        return this;
    }

    public final int getScene() {
        return this.enq;
    }

    public final lm uZ(long j2) {
        AppMethodBeat.i(220239);
        this.eYH = j2;
        super.bi("UpdataTimeMs", this.eYH);
        AppMethodBeat.o(220239);
        return this;
    }

    public final long aiD() {
        return this.eYH;
    }

    public final lm va(long j2) {
        AppMethodBeat.i(220240);
        this.eYT = j2;
        super.bi("ItemExposureTimeMs", this.eYT);
        AppMethodBeat.o(220240);
        return this;
    }

    public final long aiP() {
        return this.eYT;
    }

    public final lm lZ(int i2) {
        this.eYU = i2;
        return this;
    }

    public final int aiQ() {
        return this.eYU;
    }

    public final lm yS(String str) {
        AppMethodBeat.i(220241);
        this.eYO = x("ItemBufffer", str, true);
        AppMethodBeat.o(220241);
        return this;
    }

    public final String aiK() {
        return this.eYO;
    }

    public final lm ma(int i2) {
        this.eYP = i2;
        return this;
    }

    public final int aiL() {
        return this.eYP;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220242);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.eYQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eYR);
        stringBuffer.append(",");
        stringBuffer.append(this.eYS);
        stringBuffer.append(",");
        stringBuffer.append(this.eYJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eYK);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.eYH);
        stringBuffer.append(",");
        stringBuffer.append(this.eYT);
        stringBuffer.append(",");
        stringBuffer.append(this.eYU);
        stringBuffer.append(",");
        stringBuffer.append(this.eYO);
        stringBuffer.append(",");
        stringBuffer.append(this.eYP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220242);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220243);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartExposureMs:").append(this.eYQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndExposureMs:").append(this.eYR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DisAppearType:").append(this.eYS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemExposureAreaWeigth:").append(this.eYJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ScreenExposureAreaWeigth:").append(this.eYK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UpdataTimeMs:").append(this.eYH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemExposureTimeMs:").append(this.eYT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemPos:").append(this.eYU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemBufffer:").append(this.eYO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemArrayIndex:").append(this.eYP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220243);
        return stringBuffer2;
    }
}
