package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jq extends a {
    private String eQC = "";
    private long eQF = 0;
    private long eQG = 0;
    private long eQM = 0;
    private long eQN = 0;
    private long eQO = 0;
    private long eQP = 2;
    private long eQQ = 0;
    private long eQS = 0;
    private long eQT = 0;
    private long eSc = 0;
    private long eSd = 0;
    private long eSe = 0;
    private long eSf = 0;
    private long eSg = 0;
    private long eSh = 0;
    private String eSi = "";
    private long elI = 0;
    private long eqk = 0;
    private long etp = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16639;
    }

    public final jq sB(long j2) {
        this.elI = j2;
        return this;
    }

    public final jq wV(String str) {
        AppMethodBeat.i(74984);
        this.eQC = x("PublishObjectId", str, true);
        AppMethodBeat.o(74984);
        return this;
    }

    public final jq sC(long j2) {
        this.etp = j2;
        return this;
    }

    public final jq sD(long j2) {
        this.eqk = j2;
        return this;
    }

    public final jq sE(long j2) {
        this.eSc = j2;
        return this;
    }

    public final jq ahL() {
        this.eSd = 1;
        return this;
    }

    public final jq ahM() {
        this.eSe = 1;
        return this;
    }

    public final jq sF(long j2) {
        this.eQF = j2;
        return this;
    }

    public final jq sG(long j2) {
        this.eQG = j2;
        return this;
    }

    public final jq sH(long j2) {
        this.eSf = j2;
        return this;
    }

    public final jq ahN() {
        this.eSg = 1;
        return this;
    }

    public final jq wW(String str) {
        AppMethodBeat.i(74985);
        this.eSi = x("NewActionTrace", str, true);
        AppMethodBeat.o(74985);
        return this;
    }

    public final jq sI(long j2) {
        this.eQM = j2;
        return this;
    }

    public final jq ahO() {
        this.eQN = 1;
        return this;
    }

    public final jq sJ(long j2) {
        this.eQO = j2;
        return this;
    }

    public final jq sK(long j2) {
        this.eQP = j2;
        return this;
    }

    public final jq sL(long j2) {
        this.eQQ = j2;
        return this;
    }

    public final jq ahP() {
        this.eQS = 1;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(74986);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elI);
        stringBuffer.append(",");
        stringBuffer.append(this.eQC);
        stringBuffer.append(",");
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eSc);
        stringBuffer.append(",");
        stringBuffer.append(this.eSd);
        stringBuffer.append(",");
        stringBuffer.append(this.eSe);
        stringBuffer.append(",");
        stringBuffer.append(this.eQF);
        stringBuffer.append(",");
        stringBuffer.append(this.eQG);
        stringBuffer.append(",");
        stringBuffer.append(this.eSf);
        stringBuffer.append(",");
        stringBuffer.append(this.eSg);
        stringBuffer.append(",");
        stringBuffer.append(this.eSh);
        stringBuffer.append(",");
        stringBuffer.append(this.eSi);
        stringBuffer.append(",");
        stringBuffer.append(this.eQM);
        stringBuffer.append(",");
        stringBuffer.append(this.eQN);
        stringBuffer.append(",");
        stringBuffer.append(this.eQO);
        stringBuffer.append(",");
        stringBuffer.append(this.eQP);
        stringBuffer.append(",");
        stringBuffer.append(this.eQQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eQS);
        stringBuffer.append(",");
        stringBuffer.append(this.eQT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(74986);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(74987);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.elI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublishObjectId:").append(this.eQC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QuitTime:").append(this.eSc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasRecordVideo:").append(this.eSd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasEnterAllbum:").append(this.eSe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EmojiWidgetCount:").append(this.eQF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TextWidgetCount:").append(this.eQG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isAddMusic:").append(this.eSf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isAddPosition:").append(this.eSg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTrace:").append(this.eSh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewActionTrace:").append(this.eSi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoObjectId:").append(this.eQM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsClickSearchMusic:").append(this.eQN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPublicTimeLine:").append(this.eQO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublishVideoType:").append(this.eQP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PhotoCount:").append(this.eQQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsAddTextIntro:").append(this.eQS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddTextIntroWordCount:").append(this.eQT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(74987);
        return stringBuffer2;
    }
}
