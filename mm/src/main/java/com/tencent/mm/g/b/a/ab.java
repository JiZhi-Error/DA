package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ab extends a {
    public int eki;
    private String eno = "";
    public int enp;
    public int enq;
    private String enr = "";
    private String ens = "";
    public int ent;
    private String enu = "";
    private String enw = "";
    public long enx = 0;
    private int eny;
    private String enz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20511;
    }

    public final ab ie(String str) {
        AppMethodBeat.i(187785);
        this.eno = x("RequestId", str, true);
        AppMethodBeat.o(187785);
        return this;
    }

    public final ab jK(int i2) {
        this.eki = i2;
        return this;
    }

    public final ab jL(int i2) {
        this.enp = i2;
        return this;
    }

    public final ab jM(int i2) {
        this.enq = i2;
        return this;
    }

    /* renamed from: if  reason: not valid java name */
    public final ab m7if(String str) {
        AppMethodBeat.i(187786);
        this.enr = x("MsgId", str, true);
        AppMethodBeat.o(187786);
        return this;
    }

    public final ab ig(String str) {
        AppMethodBeat.i(187787);
        this.ens = x("MsgFromUsername", str, true);
        AppMethodBeat.o(187787);
        return this;
    }

    public final ab jN(int i2) {
        this.ent = i2;
        return this;
    }

    public final ab ih(String str) {
        AppMethodBeat.i(187788);
        this.enu = x("ChatRoomID", str, true);
        AppMethodBeat.o(187788);
        return this;
    }

    public final ab ii(String str) {
        AppMethodBeat.i(187789);
        this.enw = x("PicMD5", str, true);
        AppMethodBeat.o(187789);
        return this;
    }

    public final ab bW(long j2) {
        this.enx = j2;
        return this;
    }

    public final ab jO(int i2) {
        this.eny = i2;
        return this;
    }

    public final ab ij(String str) {
        AppMethodBeat.i(187790);
        this.enz = x("CgiAction", str, true);
        AppMethodBeat.o(187790);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187791);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eno);
        stringBuffer.append(",");
        stringBuffer.append(this.eki);
        stringBuffer.append(",");
        stringBuffer.append(this.enp);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.enr);
        stringBuffer.append(",");
        stringBuffer.append(this.ens);
        stringBuffer.append(",");
        stringBuffer.append(this.ent);
        stringBuffer.append(",");
        stringBuffer.append(this.enu);
        stringBuffer.append(",");
        stringBuffer.append(this.enw);
        stringBuffer.append(",");
        stringBuffer.append(this.enx);
        stringBuffer.append(",");
        stringBuffer.append(this.eny);
        stringBuffer.append(",");
        stringBuffer.append(this.enz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187791);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187792);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RequestId:").append(this.eno);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.eki);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Source:").append(this.enp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgId:").append(this.enr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgFromUsername:").append(this.ens);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatType:").append(this.ent);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatRoomID:").append(this.enu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PicMD5:").append(this.enw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimeStampsInMs:").append(this.enx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CgiRet:").append(this.eny);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CgiAction:").append(this.enz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187792);
        return stringBuffer2;
    }
}
