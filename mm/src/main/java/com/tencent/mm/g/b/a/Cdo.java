package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

/* renamed from: com.tencent.mm.g.b.a.do  reason: invalid class name */
public final class Cdo extends a {
    private String eiB = "";
    private String eiC = "";
    private String eiD = "";
    private long eiF;
    private String eiG = "";
    private long eiH;
    private long ery;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21923;
    }

    public final Cdo pk(String str) {
        AppMethodBeat.i(209138);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209138);
        return this;
    }

    public final Cdo pl(String str) {
        AppMethodBeat.i(209139);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(209139);
        return this;
    }

    public final Cdo pm(String str) {
        AppMethodBeat.i(209140);
        this.eiD = x("FinderContexId", str, true);
        AppMethodBeat.o(209140);
        return this;
    }

    public final Cdo km(long j2) {
        this.ery = j2;
        return this;
    }

    public final Cdo kn(long j2) {
        this.eiF = j2;
        return this;
    }

    public final Cdo pn(String str) {
        AppMethodBeat.i(209141);
        this.eiG = x("EventTime", str, true);
        AppMethodBeat.o(209141);
        return this;
    }

    public final Cdo ko(long j2) {
        this.eiH = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209142);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.eiD);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.eiF);
        stringBuffer.append(",");
        stringBuffer.append(this.eiG);
        stringBuffer.append(",");
        stringBuffer.append(this.eiH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209142);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209143);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderContexId:").append(this.eiD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventCode:").append(this.eiF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTime:").append(this.eiG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTarget:").append(this.eiH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209143);
        return stringBuffer2;
    }
}
