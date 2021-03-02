package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fh extends a {
    private String eFc = "";
    private long eFd;
    private long eFf;
    private String eFx = "";
    private String eFy = "";
    private long erw;
    private String evz = "";
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19896;
    }

    public final fh afZ() {
        this.erw = 1;
        return this;
    }

    public final fh sg(String str) {
        AppMethodBeat.i(207421);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207421);
        return this;
    }

    public final fh nD(long j2) {
        this.eyI = j2;
        return this;
    }

    public final fh sh(String str) {
        AppMethodBeat.i(207422);
        this.evz = x("topic", str, true);
        AppMethodBeat.o(207422);
        return this;
    }

    public final fh nE(long j2) {
        this.eFd = j2;
        return this;
    }

    public final fh nF(long j2) {
        this.eFf = j2;
        return this;
    }

    public final fh si(String str) {
        AppMethodBeat.i(207423);
        this.eFy = x("liveusername", str, true);
        AppMethodBeat.o(207423);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207424);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.evz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFx);
        stringBuffer.append(",");
        stringBuffer.append(this.eFd);
        stringBuffer.append(",");
        stringBuffer.append(this.eFf);
        stringBuffer.append(",");
        stringBuffer.append(this.eFy);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207424);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207425);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topic:").append(this.evz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveuin:").append(this.eFx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomRole:").append(this.eFd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audienceCount:").append(this.eFf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveusername:").append(this.eFy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207425);
        return stringBuffer2;
    }
}
