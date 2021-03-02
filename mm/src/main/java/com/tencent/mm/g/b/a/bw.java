package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bw extends a {
    private int enW;
    private int enq;
    private String eoz = "";
    private String erD = "";
    private String erH = "";
    private long ery;
    private String esZ = "";
    private String etY = "";
    private int etZ;
    private String eta = "";
    private long eua;
    private long eub;
    private String euc = "";
    private int eud;
    private String eue = "";
    private long euf;
    private String eug = "";
    private String euh = "";
    private String eui = "";
    private long euj;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18054;
    }

    public final bw ko(String str) {
        AppMethodBeat.i(208918);
        this.erD = x("FeedID", str, true);
        AppMethodBeat.o(208918);
        return this;
    }

    public final bw jY(int i2) {
        this.enW = i2;
        return this;
    }

    public final bw kp(String str) {
        AppMethodBeat.i(208919);
        this.etY = x("ActionValue", str, true);
        AppMethodBeat.o(208919);
        return this;
    }

    public final bw jZ(int i2) {
        this.etZ = i2;
        return this;
    }

    public final bw eP(long j2) {
        AppMethodBeat.i(208920);
        this.eub = j2;
        super.bj("ActionTimeStampMs", this.eub);
        AppMethodBeat.o(208920);
        return this;
    }

    public final bw kq(String str) {
        AppMethodBeat.i(208921);
        this.euc = x("sessionID", str, true);
        AppMethodBeat.o(208921);
        return this;
    }

    public final bw ka(int i2) {
        this.eud = i2;
        return this;
    }

    public final bw kr(String str) {
        AppMethodBeat.i(208922);
        this.eue = x("sessionBuffer", str, true);
        AppMethodBeat.o(208922);
        return this;
    }

    public final bw eQ(long j2) {
        this.euf = j2;
        return this;
    }

    public final bw eR(long j2) {
        this.ery = j2;
        return this;
    }

    public final bw ks(String str) {
        AppMethodBeat.i(208923);
        this.eug = x("ClickFeedId", str, true);
        AppMethodBeat.o(208923);
        return this;
    }

    public final bw kt(String str) {
        AppMethodBeat.i(208924);
        this.euh = x("ClickFeedContextId", str, true);
        AppMethodBeat.o(208924);
        return this;
    }

    public final bw ku(String str) {
        AppMethodBeat.i(208925);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(208925);
        return this;
    }

    public final bw kv(String str) {
        AppMethodBeat.i(208926);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(208926);
        return this;
    }

    public final bw kw(String str) {
        AppMethodBeat.i(208927);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(208927);
        return this;
    }

    public final bw kx(String str) {
        AppMethodBeat.i(208928);
        this.eta = x("enterSourceInfo", str, true);
        AppMethodBeat.o(208928);
        return this;
    }

    public final bw ky(String str) {
        AppMethodBeat.i(208929);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(208929);
        return this;
    }

    public final bw eS(long j2) {
        this.euj = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208930);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erD);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.enW);
        stringBuffer.append(",");
        stringBuffer.append(this.etY);
        stringBuffer.append(",");
        stringBuffer.append(this.etZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eua);
        stringBuffer.append(",");
        stringBuffer.append(this.eub);
        stringBuffer.append(",");
        stringBuffer.append(this.euc);
        stringBuffer.append(",");
        stringBuffer.append(this.eud);
        stringBuffer.append(",");
        stringBuffer.append(this.eue);
        stringBuffer.append(",");
        stringBuffer.append(this.euf);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.eug);
        stringBuffer.append(",");
        stringBuffer.append(this.euh);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.esZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eta);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
        stringBuffer.append(",");
        stringBuffer.append(this.euj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208930);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208931);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FeedID:").append(this.erD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionValue:").append(this.etY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionCurrentVersion:").append(this.etZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStamp:").append(this.eua);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStampMs:").append(this.eub);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionID:").append(this.euc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mediaType:").append(this.eud);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionBuffer:").append(this.eue);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("videoDurationTime:").append(this.euf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickFeedId:").append(this.eug);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickFeedContextId:").append(this.euh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtraInfo:").append(this.esZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterSourceInfo:").append(this.eta);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedDisplayType:").append(this.euj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208931);
        return stringBuffer2;
    }
}
