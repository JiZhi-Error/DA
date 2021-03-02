package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nv extends a {
    private String eBQ = "";
    private String eXu = "";
    private String els = "";
    private long erw = 0;
    private String fiD = "";
    private String fiE = "";
    private String fix = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16032;
    }

    public final nv ajr() {
        this.erw = 47;
        return this;
    }

    public final nv AU(String str) {
        AppMethodBeat.i(116498);
        this.eXu = x("content", str, true);
        AppMethodBeat.o(116498);
        return this;
    }

    public final nv AV(String str) {
        AppMethodBeat.i(116499);
        this.fix = x("searchid", str, true);
        AppMethodBeat.o(116499);
        return this;
    }

    public final nv AW(String str) {
        AppMethodBeat.i(116500);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(116500);
        return this;
    }

    public final nv AX(String str) {
        AppMethodBeat.i(116501);
        this.eBQ = x(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(116501);
        return this;
    }

    public final nv AY(String str) {
        AppMethodBeat.i(116502);
        this.fiD = x("resulttype", str, true);
        AppMethodBeat.o(116502);
        return this;
    }

    public final nv AZ(String str) {
        AppMethodBeat.i(116503);
        this.fiE = x("resultsubtypelist", str, true);
        AppMethodBeat.o(116503);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116504);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eXu);
        stringBuffer.append(",");
        stringBuffer.append(this.fix);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.eBQ);
        stringBuffer.append(",");
        stringBuffer.append(this.fiD);
        stringBuffer.append(",");
        stringBuffer.append(this.fiE);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116504);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116505);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("content:").append(this.eXu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchid:").append(this.fix);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("query:").append(this.eBQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("resulttype:").append(this.fiD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("resultsubtypelist:").append(this.fiE);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116505);
        return stringBuffer2;
    }
}
