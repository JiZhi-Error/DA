package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ai extends a {
    private String eoj = "";
    private long eok;
    private long eol;
    private String eom = "";
    private String eon = "";
    private String eoo = "";
    private long eop;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21559;
    }

    public final ai il(String str) {
        AppMethodBeat.i(208830);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(208830);
        return this;
    }

    public final ai bY(long j2) {
        AppMethodBeat.i(208831);
        this.eok = j2;
        super.bj("actiontimestampms", this.eok);
        AppMethodBeat.o(208831);
        return this;
    }

    public final ai bZ(long j2) {
        this.eol = j2;
        return this;
    }

    public final ai im(String str) {
        AppMethodBeat.i(208832);
        this.eom = x("DailyPaperId", str, true);
        AppMethodBeat.o(208832);
        return this;
    }

    public final ai in(String str) {
        AppMethodBeat.i(208833);
        this.eon = x("DailyPaperWording", str, true);
        AppMethodBeat.o(208833);
        return this;
    }

    public final ai io(String str) {
        AppMethodBeat.i(208834);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(208834);
        return this;
    }

    public final ai ca(long j2) {
        this.eop = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208835);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.eok);
        stringBuffer.append(",");
        stringBuffer.append(this.eol);
        stringBuffer.append(",");
        stringBuffer.append(this.eom);
        stringBuffer.append(",");
        stringBuffer.append(this.eon);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.eop);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208835);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208836);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actiontimestampms:").append(this.eok);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("atcion:").append(this.eol);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DailyPaperId:").append(this.eom);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DailyPaperWording:").append(this.eon);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagClickable:").append(this.eop);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208836);
        return stringBuffer2;
    }
}
