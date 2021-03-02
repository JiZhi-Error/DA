package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class o extends a {
    public String ekH = "";
    public long ekI;
    public long ekJ;
    public long ekK;
    public long ekL;
    public long ekM;
    public long ekN;
    private long ekO;
    public long ekP;
    public long ekQ;
    public long opY;
    public long opZ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21927;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238089);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekH);
        stringBuffer.append(",");
        stringBuffer.append(this.ekI);
        stringBuffer.append(",");
        stringBuffer.append(this.ekJ);
        stringBuffer.append(",");
        stringBuffer.append(this.ekK);
        stringBuffer.append(",");
        stringBuffer.append(this.ekL);
        stringBuffer.append(",");
        stringBuffer.append(this.ekM);
        stringBuffer.append(",");
        stringBuffer.append(this.ekN);
        stringBuffer.append(",");
        stringBuffer.append(this.ekO);
        stringBuffer.append(",");
        stringBuffer.append(this.ekP);
        stringBuffer.append(",");
        stringBuffer.append(this.ekQ);
        stringBuffer.append(",");
        stringBuffer.append(this.opY);
        stringBuffer.append(",");
        stringBuffer.append(this.opZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238089);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238090);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session_id:").append(this.ekH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_type:").append(this.ekI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("background_status:").append(this.ekJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_cnt:").append(this.ekK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("brand_cnt:").append(this.ekL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("file_cnt:").append(this.ekM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("note_cnt:").append(this.ekN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mpvideo_cnt:").append(this.ekO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("finder_cnt:").append(this.ekP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("live_cnt:").append(this.ekQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("myweapp_cnt:").append(this.opY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("music_cnt:").append(this.opZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238090);
        return stringBuffer2;
    }
}
