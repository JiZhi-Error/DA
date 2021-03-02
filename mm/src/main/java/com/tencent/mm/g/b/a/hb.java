package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class hb extends a {
    private long eLm = 0;
    private long eLn = 0;
    private int eLo = 0;
    private long eLp = 0;
    private long eLq = 0;
    private String eoL = "";
    private String eoM = "";
    private String eoO = "";
    private String eoP = "";
    private String eoR = "";
    private long eoS = 0;
    private long eoT = 0;
    private String epb = "";
    private String epf = "";

    public hb() {
    }

    public hb(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(126687);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 14) {
                strArr = new String[14];
                Arrays.fill(strArr, 0, 14, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.eoS = Util.getLong(strArr[0], 0);
            this.eoT = Util.getLong(strArr[1], 0);
            this.eLm = Util.getLong(strArr[2], 0);
            this.eoR = x("NewMd5", strArr[3], true);
            this.eLn = Util.getLong(strArr[4], 0);
            this.eLo = Util.getInt(strArr[5], 0);
            this.eLp = Util.getLong(strArr[6], 0);
            this.epb = x("CDNIp", strArr[7], true);
            this.eoL = x("FromUser", strArr[8], true);
            this.eoM = x("Session", strArr[9], true);
            this.eLq = Util.getLong(strArr[10], 0);
            this.eoO = x("FileId", strArr[11], true);
            this.eoP = x("SnsUrl", strArr[12], true);
            this.epf = x("Publishid", strArr[13], true);
        }
        AppMethodBeat.o(126687);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 14499;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(126688);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoS);
        stringBuffer.append(",");
        stringBuffer.append(this.eoT);
        stringBuffer.append(",");
        stringBuffer.append(this.eLm);
        stringBuffer.append(",");
        stringBuffer.append(this.eoR);
        stringBuffer.append(",");
        stringBuffer.append(this.eLn);
        stringBuffer.append(",");
        stringBuffer.append(this.eLo);
        stringBuffer.append(",");
        stringBuffer.append(this.eLp);
        stringBuffer.append(",");
        stringBuffer.append(this.epb);
        stringBuffer.append(",");
        stringBuffer.append(this.eoL);
        stringBuffer.append(",");
        stringBuffer.append(this.eoM);
        stringBuffer.append(",");
        stringBuffer.append(this.eLq);
        stringBuffer.append(",");
        stringBuffer.append(this.eoO);
        stringBuffer.append(",");
        stringBuffer.append(this.eoP);
        stringBuffer.append(",");
        stringBuffer.append(this.epf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(126688);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(126689);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DownloadStartTime:").append(this.eoS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadEndTime:").append(this.eoT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadSize:").append(this.eLm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewMd5:").append(this.eoR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgType:").append(this.eLn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadSpeed:").append(this.eLo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadFinishSize:").append(this.eLp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CDNIp:").append(this.epb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FromUser:").append(this.eoL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Session:").append(this.eoM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatroomNum:").append(this.eLq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileId:").append(this.eoO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsUrl:").append(this.eoP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Publishid:").append(this.epf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(126689);
        return stringBuffer2;
    }
}
