package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bi extends a {
    public String els = "";
    public long esb;
    public String esc = "";
    public String esd = "";
    public String esf = "";
    public String esh = "";
    public long esl;
    public long esu;
    public long esv;
    public long esw;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20692;
    }

    public final bi jh(String str) {
        AppMethodBeat.i(208867);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(208867);
        return this;
    }

    public final bi ji(String str) {
        AppMethodBeat.i(208868);
        this.esd = x("clicktabcontextid", str, true);
        AppMethodBeat.o(208868);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208869);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.esd);
        stringBuffer.append(",");
        stringBuffer.append(this.esf);
        stringBuffer.append(",");
        stringBuffer.append(this.esb);
        stringBuffer.append(",");
        stringBuffer.append(this.esh);
        stringBuffer.append(",");
        stringBuffer.append(this.esc);
        stringBuffer.append(",");
        stringBuffer.append(this.esu);
        stringBuffer.append(",");
        stringBuffer.append(this.esl);
        stringBuffer.append(",");
        stringBuffer.append(this.esv);
        stringBuffer.append(",");
        stringBuffer.append(this.esw);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208869);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208870);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clicktabcontextid:").append(this.esd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("chatSessionid:").append(this.esf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("myAccountType:").append(this.esb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("chatName:").append(this.esh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("talkerUsername:").append(this.esc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RejectMsgStatus:").append(this.esu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("openChatInfoCount:").append(this.esl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clearMsgHistoryClickCount:").append(this.esv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("complianClickCount:").append(this.esw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208870);
        return stringBuffer2;
    }
}
