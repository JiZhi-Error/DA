package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gd extends a {
    private String eIA = "";
    private String eIB = "";
    private String eIC = "";
    private String eID = "";
    private String eIE = "";
    private String eIF = "";
    private long eIG;
    private long eIH;
    private long eII;
    private long eIJ;
    private String eIK = "";
    private String eIL = "";
    private String eIM = "";
    private String eIN = "";
    private String eIO = "";
    private String eIP = "";
    private String eIQ = "";
    private String eIw = "";
    private String eIx = "";
    private String eIy = "";
    private String eIz = "";
    private long erY;
    private String esZ = "";
    private String ezQ = "";
    private String ezR = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19904;
    }

    public final gd tn(String str) {
        AppMethodBeat.i(237156);
        this.ezQ = x("PostId", str, true);
        AppMethodBeat.o(237156);
        return this;
    }

    public final gd to(String str) {
        AppMethodBeat.i(237157);
        this.ezR = x("EditId", str, true);
        AppMethodBeat.o(237157);
        return this;
    }

    public final gd tp(String str) {
        AppMethodBeat.i(237158);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(237158);
        return this;
    }

    public final gd tq(String str) {
        AppMethodBeat.i(237159);
        this.eIw = x("isBeauty", str, true);
        AppMethodBeat.o(237159);
        return this;
    }

    public final gd tr(String str) {
        AppMethodBeat.i(237160);
        this.eIx = x("targetDuration", str, true);
        AppMethodBeat.o(237160);
        return this;
    }

    public final gd ts(String str) {
        AppMethodBeat.i(237161);
        this.eIy = x("originDuration", str, true);
        AppMethodBeat.o(237161);
        return this;
    }

    public final gd tt(String str) {
        AppMethodBeat.i(237162);
        this.eIz = x("isSlowMotion", str, true);
        AppMethodBeat.o(237162);
        return this;
    }

    public final gd tu(String str) {
        AppMethodBeat.i(237163);
        this.eIA = x("dragCount", str, true);
        AppMethodBeat.o(237163);
        return this;
    }

    public final gd tv(String str) {
        AppMethodBeat.i(237164);
        this.eIB = x("scaleCount", str, true);
        AppMethodBeat.o(237164);
        return this;
    }

    public final gd tw(String str) {
        AppMethodBeat.i(237165);
        this.eIC = x("clickEditCount", str, true);
        AppMethodBeat.o(237165);
        return this;
    }

    public final gd tx(String str) {
        AppMethodBeat.i(237166);
        this.eID = x("durationCutCount", str, true);
        AppMethodBeat.o(237166);
        return this;
    }

    public final gd ty(String str) {
        AppMethodBeat.i(237167);
        this.eIE = x("durationScrollCount", str, true);
        AppMethodBeat.o(237167);
        return this;
    }

    public final gd tz(String str) {
        AppMethodBeat.i(237168);
        this.eIF = x("isDurationCut", str, true);
        AppMethodBeat.o(237168);
        return this;
    }

    public final gd pL(long j2) {
        this.eIG = j2;
        return this;
    }

    public final gd pM(long j2) {
        this.eIH = j2;
        return this;
    }

    public final gd pN(long j2) {
        this.eII = j2;
        return this;
    }

    public final gd pO(long j2) {
        this.eIJ = j2;
        return this;
    }

    public final gd tA(String str) {
        AppMethodBeat.i(237169);
        this.eIK = x("VideoType", str, true);
        AppMethodBeat.o(237169);
        return this;
    }

    public final gd tB(String str) {
        AppMethodBeat.i(237170);
        this.eIL = x("CaptionInfo", str, true);
        AppMethodBeat.o(237170);
        return this;
    }

    public final gd tC(String str) {
        AppMethodBeat.i(237171);
        this.eIM = x("TextInfo", str, true);
        AppMethodBeat.o(237171);
        return this;
    }

    public final gd tD(String str) {
        AppMethodBeat.i(237172);
        this.eIN = x("EmojiInfo", str, true);
        AppMethodBeat.o(237172);
        return this;
    }

    public final gd tE(String str) {
        AppMethodBeat.i(237173);
        this.eIO = x("TransitionInfo", str, true);
        AppMethodBeat.o(237173);
        return this;
    }

    public final gd tF(String str) {
        AppMethodBeat.i(237174);
        this.eIP = x("TrSpeedInfo", str, true);
        AppMethodBeat.o(237174);
        return this;
    }

    public final gd tG(String str) {
        AppMethodBeat.i(237175);
        this.eIQ = x("FilterInfo", str, true);
        AppMethodBeat.o(237175);
        return this;
    }

    public final String agL() {
        return this.eIQ;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(237176);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ezQ);
        stringBuffer.append(",");
        stringBuffer.append(this.ezR);
        stringBuffer.append(",");
        stringBuffer.append(this.esZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eIw);
        stringBuffer.append(",");
        stringBuffer.append(this.eIx);
        stringBuffer.append(",");
        stringBuffer.append(this.eIy);
        stringBuffer.append(",");
        stringBuffer.append(this.eIz);
        stringBuffer.append(",");
        stringBuffer.append(this.eIA);
        stringBuffer.append(",");
        stringBuffer.append(this.eIB);
        stringBuffer.append(",");
        stringBuffer.append(this.eIC);
        stringBuffer.append(",");
        stringBuffer.append(this.eID);
        stringBuffer.append(",");
        stringBuffer.append(this.eIE);
        stringBuffer.append(",");
        stringBuffer.append(this.eIF);
        stringBuffer.append(",");
        stringBuffer.append(this.eIG);
        stringBuffer.append(",");
        stringBuffer.append(this.eIH);
        stringBuffer.append(",");
        stringBuffer.append(this.eII);
        stringBuffer.append(",");
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.eIJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eIK);
        stringBuffer.append(",");
        stringBuffer.append(this.eIL);
        stringBuffer.append(",");
        stringBuffer.append(this.eIM);
        stringBuffer.append(",");
        stringBuffer.append(this.eIN);
        stringBuffer.append(",");
        stringBuffer.append(this.eIO);
        stringBuffer.append(",");
        stringBuffer.append(this.eIP);
        stringBuffer.append(",");
        stringBuffer.append(this.eIQ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(237176);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(237177);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PostId:").append(this.ezQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditId:").append(this.ezR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtraInfo:").append(this.esZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isBeauty:").append(this.eIw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("targetDuration:").append(this.eIx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("originDuration:").append(this.eIy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isSlowMotion:").append(this.eIz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("dragCount:").append(this.eIA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scaleCount:").append(this.eIB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickEditCount:").append(this.eIC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("durationCutCount:").append(this.eID);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("durationScrollCount:").append(this.eIE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isDurationCut:").append(this.eIF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cropRectChangeCount:").append(this.eIG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("seekBarDragCount:").append(this.eIH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("is60sDurationCut:").append(this.eII);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NextStep:").append(this.eIJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoType:").append(this.eIK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CaptionInfo:").append(this.eIL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TextInfo:").append(this.eIM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EmojiInfo:").append(this.eIN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TransitionInfo:").append(this.eIO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TrSpeedInfo:").append(this.eIP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FilterInfo:").append(this.eIQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(237177);
        return stringBuffer2;
    }
}
