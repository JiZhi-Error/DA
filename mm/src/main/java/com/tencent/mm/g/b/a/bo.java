package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bo extends a {
    private String eiB = "";
    private long eor;
    private long ete;
    private long etf;
    private String etg = "";
    private long eth;
    private long eti;
    private long etj;
    private long etk;
    private long etl;
    private long etm;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19815;
    }

    public final bo jL(String str) {
        AppMethodBeat.i(208894);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208894);
        return this;
    }

    public final bo em(long j2) {
        this.ete = j2;
        return this;
    }

    public final bo en(long j2) {
        this.etf = j2;
        return this;
    }

    public final bo jM(String str) {
        AppMethodBeat.i(208895);
        this.etg = x("FailReasonWording", str, true);
        AppMethodBeat.o(208895);
        return this;
    }

    public final bo acC() {
        this.eth = 1;
        return this;
    }

    public final bo acD() {
        this.eti = 1;
        return this;
    }

    public final bo acE() {
        this.etk = 1;
        return this;
    }

    public final bo acF() {
        this.eor = 1;
        return this;
    }

    public final bo eo(long j2) {
        this.etm = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208896);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.ete);
        stringBuffer.append(",");
        stringBuffer.append(this.etf);
        stringBuffer.append(",");
        stringBuffer.append(this.etg);
        stringBuffer.append(",");
        stringBuffer.append(this.eth);
        stringBuffer.append(",");
        stringBuffer.append(this.eti);
        stringBuffer.append(",");
        stringBuffer.append(this.etj);
        stringBuffer.append(",");
        stringBuffer.append(this.etk);
        stringBuffer.append(",");
        stringBuffer.append(this.eor);
        stringBuffer.append(",");
        stringBuffer.append(this.etl);
        stringBuffer.append(",");
        stringBuffer.append(this.etm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208896);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208897);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Status:").append(this.ete);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FailReason:").append(this.etf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FailReasonWording:").append(this.etg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasAvatar:").append(this.eth);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasNickName:").append(this.eti);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasSignature:").append(this.etj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasSex:").append(this.etk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasLocation:").append(this.eor);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasCheckAgreement:").append(this.etl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("createscene:").append(this.etm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208897);
        return stringBuffer2;
    }
}
