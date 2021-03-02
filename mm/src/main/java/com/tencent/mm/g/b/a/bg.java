package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bg extends a {
    public String els = "";
    public long esa;
    public long esb;
    public String esc = "";
    public String esd = "";
    public String ese = "";
    public String esf = "";
    public long esg;
    public String esh = "";
    public long esi;
    private long esj;
    private long esk;
    public long esl;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20691;
    }

    public final bg dw(long j2) {
        this.esj = j2;
        return this;
    }

    public final bg dx(long j2) {
        this.esk = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208862);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.esa);
        stringBuffer.append(",");
        stringBuffer.append(this.esb);
        stringBuffer.append(",");
        stringBuffer.append(this.esc);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.esd);
        stringBuffer.append(",");
        stringBuffer.append(this.ese);
        stringBuffer.append(",");
        stringBuffer.append(this.esf);
        stringBuffer.append(",");
        stringBuffer.append(this.esg);
        stringBuffer.append(",");
        stringBuffer.append(this.esh);
        stringBuffer.append(",");
        stringBuffer.append(this.esi);
        stringBuffer.append(",");
        stringBuffer.append(this.esj);
        stringBuffer.append(",");
        stringBuffer.append(this.esk);
        stringBuffer.append(",");
        stringBuffer.append(this.esl);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208862);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208863);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("fromCommentScene:").append(this.esa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("myAccountType:").append(this.esb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("talkerUsername:").append(this.esc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clicktabcontextid:").append(this.esd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("chatListSessionid:").append(this.ese);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("chatSessionid:").append(this.esf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("stayDuration:").append(this.esg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("chatName:").append(this.esh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reddotCount:").append(this.esi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("newReceiveMsgCount:").append(this.esj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("newSendMsgCount:").append(this.esk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("openChatInfoCount:").append(this.esl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208863);
        return stringBuffer2;
    }
}
