package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.smtt.export.external.TbsCoreSettings;

public final class ny extends a {
    private String fgl = "";
    private long fgn;
    private long fgo;
    private String fgq = "";
    private String fiM = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21776;
    }

    public final ny Be(String str) {
        AppMethodBeat.i(226120);
        this.fgl = x("session", str, true);
        AppMethodBeat.o(226120);
        return this;
    }

    public final ny yt(long j2) {
        this.fgn = j2;
        return this;
    }

    public final ny yu(long j2) {
        this.fgo = j2;
        return this;
    }

    public final ny Bf(String str) {
        AppMethodBeat.i(226121);
        this.fiM = x("weapp_ID", str, true);
        AppMethodBeat.o(226121);
        return this;
    }

    public final ny Bg(String str) {
        AppMethodBeat.i(226122);
        this.fgq = x(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, str, true);
        AppMethodBeat.o(226122);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226123);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fgl);
        stringBuffer.append(",");
        stringBuffer.append(this.fgn);
        stringBuffer.append(",");
        stringBuffer.append(this.fgo);
        stringBuffer.append(",");
        stringBuffer.append(this.fiM);
        stringBuffer.append(",");
        stringBuffer.append(this.fgq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226123);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226124);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session:").append(this.fgl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_sum:").append(this.fgn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_index:").append(this.fgo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_ID:").append(this.fiM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_name:").append(this.fgq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226124);
        return stringBuffer2;
    }
}
