package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ox extends a {
    private long enl;
    private String eoz = "";
    private long ery;
    private String euc = "";
    private String unb = "";
    private String unc = "";
    private String und = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22265;
    }

    public final ox bwZ(String str) {
        AppMethodBeat.i(259313);
        this.unb = x("AppID", str, true);
        AppMethodBeat.o(259313);
        return this;
    }

    public final ox RC(long j2) {
        this.enl = j2;
        return this;
    }

    public final ox bxa(String str) {
        AppMethodBeat.i(259314);
        this.euc = x("sessionID", str, true);
        AppMethodBeat.o(259314);
        return this;
    }

    public final ox bxb(String str) {
        AppMethodBeat.i(259315);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(259315);
        return this;
    }

    public final ox bxc(String str) {
        AppMethodBeat.i(259316);
        this.unc = x("click_tab_context_id", str, true);
        AppMethodBeat.o(259316);
        return this;
    }

    public final ox RD(long j2) {
        this.ery = j2;
        return this;
    }

    public final ox bxd(String str) {
        AppMethodBeat.i(259317);
        this.und = x("pageResrouceID", str, true);
        AppMethodBeat.o(259317);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259318);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.unb);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.euc);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.unc);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.und);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259318);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259319);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppID:").append(this.unb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionID:").append(this.euc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("click_tab_context_id:").append(this.unc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("pageResrouceID:").append(this.und);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259319);
        return stringBuffer2;
    }
}
