package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class aj extends a {
    public String eiB = "";
    public long eoA;
    public long eoq;
    public long eor;
    public long eos;
    public long eot;
    public long eou;
    public long eov;
    public long eow;
    public long eox;
    private String eoy = "";
    public String eoz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19025;
    }

    public final aj ip(String str) {
        AppMethodBeat.i(208837);
        this.eoy = x("EnterRedDotId", str, true);
        AppMethodBeat.o(208837);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208838);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoq);
        stringBuffer.append(",");
        stringBuffer.append(this.eor);
        stringBuffer.append(",");
        stringBuffer.append(this.eos);
        stringBuffer.append(",");
        stringBuffer.append(this.eot);
        stringBuffer.append(",");
        stringBuffer.append(this.eou);
        stringBuffer.append(",");
        stringBuffer.append(this.eov);
        stringBuffer.append(",");
        stringBuffer.append(this.eow);
        stringBuffer.append(",");
        stringBuffer.append(this.eox);
        stringBuffer.append(",");
        stringBuffer.append(this.eoy);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eoA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208838);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208839);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReddotFlag:").append(this.eoq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasLocation:").append(this.eor);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasLocationPermission:").append(this.eos);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FollowInitPosition:").append(this.eot);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendInitPosition:").append(this.eou);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LBSInitPosition:").append(this.eov);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HotInitPosition:").append(this.eow);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTab:").append(this.eox);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterRedDotId:").append(this.eoy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AutoRefresh:").append(this.eoA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208839);
        return stringBuffer2;
    }
}
