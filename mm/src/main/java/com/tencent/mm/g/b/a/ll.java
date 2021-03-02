package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ll extends a {
    private long eYH;
    private long eYI;
    private String eYJ = "";
    private String eYK = "";
    private int eYL;
    private int eYM;
    private String eYN = "";
    private String eYO = "";
    private int eYP;
    private String eiB = "";
    private int enq;
    private String eoz = "";
    private String eug = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19945;
    }

    public final ll yG(String str) {
        AppMethodBeat.i(220223);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(220223);
        return this;
    }

    public final String getSessionId() {
        return this.eiB;
    }

    public final ll yH(String str) {
        AppMethodBeat.i(220224);
        this.eug = x("ClickFeedId", str, true);
        AppMethodBeat.o(220224);
        return this;
    }

    public final String aiC() {
        return this.eug;
    }

    public final ll lT(int i2) {
        this.enq = i2;
        return this;
    }

    public final int getScene() {
        return this.enq;
    }

    public final ll uV(long j2) {
        AppMethodBeat.i(220225);
        this.eYH = j2;
        super.bi("UpdataTimeMs", this.eYH);
        AppMethodBeat.o(220225);
        return this;
    }

    public final long aiD() {
        return this.eYH;
    }

    public final ll uW(long j2) {
        AppMethodBeat.i(220226);
        this.eYI = j2;
        super.bi("ClickTimeMs", this.eYI);
        AppMethodBeat.o(220226);
        return this;
    }

    public final long aiE() {
        return this.eYI;
    }

    public final ll yI(String str) {
        AppMethodBeat.i(220227);
        this.eYJ = x("ItemExposureAreaWeigth", str, true);
        AppMethodBeat.o(220227);
        return this;
    }

    public final String aiF() {
        return this.eYJ;
    }

    public final ll yJ(String str) {
        AppMethodBeat.i(220228);
        this.eYK = x("ScreenExposureAreaWeigth", str, true);
        AppMethodBeat.o(220228);
        return this;
    }

    public final String aiG() {
        return this.eYK;
    }

    public final ll lU(int i2) {
        this.eYL = i2;
        return this;
    }

    public final int aiH() {
        return this.eYL;
    }

    public final ll lV(int i2) {
        this.eYM = i2;
        return this;
    }

    public final int aiI() {
        return this.eYM;
    }

    public final ll yK(String str) {
        AppMethodBeat.i(220229);
        this.eYN = x("ShotScreenJson", str, true);
        AppMethodBeat.o(220229);
        return this;
    }

    public final String aiJ() {
        return this.eYN;
    }

    public final ll yL(String str) {
        AppMethodBeat.i(220230);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(220230);
        return this;
    }

    public final String acj() {
        return this.eoz;
    }

    public final ll yM(String str) {
        AppMethodBeat.i(220231);
        this.eYO = x("ItemBufffer", str, true);
        AppMethodBeat.o(220231);
        return this;
    }

    public final String aiK() {
        return this.eYO;
    }

    public final ll lW(int i2) {
        this.eYP = i2;
        return this;
    }

    public final int aiL() {
        return this.eYP;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220232);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eug);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.eYH);
        stringBuffer.append(",");
        stringBuffer.append(this.eYI);
        stringBuffer.append(",");
        stringBuffer.append(this.eYJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eYK);
        stringBuffer.append(",");
        stringBuffer.append(this.eYL);
        stringBuffer.append(",");
        stringBuffer.append(this.eYM);
        stringBuffer.append(",");
        stringBuffer.append(this.eYN);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eYO);
        stringBuffer.append(",");
        stringBuffer.append(this.eYP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220232);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220233);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickFeedId:").append(this.eug);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UpdataTimeMs:").append(this.eYH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTimeMs:").append(this.eYI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemExposureAreaWeigth:").append(this.eYJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ScreenExposureAreaWeigth:").append(this.eYK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemDirection:").append(this.eYL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemIndex:").append(this.eYM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShotScreenJson:").append(this.eYN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemBufffer:").append(this.eYO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemArrayIndex:").append(this.eYP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220233);
        return stringBuffer2;
    }
}
