package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ki extends a {
    private long eLv = 0;
    private long eSx = 0;
    private long eSy = 0;
    private String eUZ = "";
    private String eVa = "";
    private String eVb = "";
    private String eVc = "";
    private long eVd = 0;
    private long eVe = 0;
    private long eVf = 0;
    private long eVg = 0;
    private long eVh = 0;
    private long eVi = 0;
    private long eVj = 0;
    private int eVk = 0;
    private long eVl = 0;
    private long eVm = 0;
    private long eVn = 0;
    private long eVo = 0;
    private long eVp = 0;
    private long eVq = 0;
    private long eVr = 0;
    private String eoP = "";
    private int eoQ = 0;
    private String eoR = "";
    private String epb = "";
    private long epc = 0;

    public ki() {
    }

    public ki(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(126701);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 27) {
                strArr = new String[27];
                Arrays.fill(strArr, 0, 27, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.eUZ = x("ToUser", strArr[0], true);
            this.eVa = x("MsgSource", strArr[1], true);
            this.eoQ = Util.getInt(strArr[2], 0);
            this.eVb = x("FieldId", strArr[3], true);
            this.eoR = x("NewMd5", strArr[4], true);
            this.eVc = x("SnsInfoId", strArr[5], true);
            this.eSx = Util.getLong(strArr[6], 0);
            this.eSy = Util.getLong(strArr[7], 0);
            this.eVd = Util.getLong(strArr[8], 0);
            this.eVe = Util.getLong(strArr[9], 0);
            this.eVf = Util.getLong(strArr[10], 0);
            this.eVg = Util.getLong(strArr[11], 0);
            this.eVh = Util.getLong(strArr[12], 0);
            this.eVi = Util.getLong(strArr[13], 0);
            this.eVj = Util.getLong(strArr[14], 0);
            this.eVk = Util.getInt(strArr[15], 0);
            this.eVl = Util.getLong(strArr[16], 0);
            this.eVm = Util.getLong(strArr[17], 0);
            this.eVn = Util.getLong(strArr[18], 0);
            this.eVo = Util.getLong(strArr[19], 0);
            this.eVp = Util.getLong(strArr[20], 0);
            this.eVq = Util.getLong(strArr[21], 0);
            this.eVr = Util.getLong(strArr[22], 0);
            this.eLv = Util.getLong(strArr[23], 0);
            this.epb = x("CDNIp", strArr[24], true);
            this.epc = Util.getLong(strArr[25], 0);
            this.eoP = x("SnsUrl", strArr[26], true);
        }
        AppMethodBeat.o(126701);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 13794;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(126702);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eUZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eVa);
        stringBuffer.append(",");
        stringBuffer.append(this.eoQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eVb);
        stringBuffer.append(",");
        stringBuffer.append(this.eoR);
        stringBuffer.append(",");
        stringBuffer.append(this.eVc);
        stringBuffer.append(",");
        stringBuffer.append(this.eSx);
        stringBuffer.append(",");
        stringBuffer.append(this.eSy);
        stringBuffer.append(",");
        stringBuffer.append(this.eVd);
        stringBuffer.append(",");
        stringBuffer.append(this.eVe);
        stringBuffer.append(",");
        stringBuffer.append(this.eVf);
        stringBuffer.append(",");
        stringBuffer.append(this.eVg);
        stringBuffer.append(",");
        stringBuffer.append(this.eVh);
        stringBuffer.append(",");
        stringBuffer.append(this.eVi);
        stringBuffer.append(",");
        stringBuffer.append(this.eVj);
        stringBuffer.append(",");
        stringBuffer.append(this.eVk);
        stringBuffer.append(",");
        stringBuffer.append(this.eVl);
        stringBuffer.append(",");
        stringBuffer.append(this.eVm);
        stringBuffer.append(",");
        stringBuffer.append(this.eVn);
        stringBuffer.append(",");
        stringBuffer.append(this.eVo);
        stringBuffer.append(",");
        stringBuffer.append(this.eVp);
        stringBuffer.append(",");
        stringBuffer.append(this.eVq);
        stringBuffer.append(",");
        stringBuffer.append(this.eVr);
        stringBuffer.append(",");
        stringBuffer.append(this.eLv);
        stringBuffer.append(",");
        stringBuffer.append(this.epb);
        stringBuffer.append(",");
        stringBuffer.append(this.epc);
        stringBuffer.append(",");
        stringBuffer.append(this.eoP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(126702);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(126703);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ToUser:").append(this.eUZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgSource:").append(this.eVa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetType:").append(this.eoQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FieldId:").append(this.eVb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewMd5:").append(this.eoR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsInfoId:").append(this.eVc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadStartTime:").append(this.eSx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadEndTime:").append(this.eSy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalSize:").append(this.eVd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalDuration:").append(this.eVe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalVideoBitrate:").append(this.eVf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalAudioBitrate:").append(this.eVg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalFps:").append(this.eVh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalWidth:").append(this.eVi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalHeight:").append(this.eVj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpStatus:").append(this.eVk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpSize:").append(this.eVl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpDuration:").append(this.eVm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpVideoBitrate:").append(this.eVn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpAudioiBitrate:").append(this.eVo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpFps:").append(this.eVp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpWidth:").append(this.eVq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CpHeight:").append(this.eVr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SendScene:").append(this.eLv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CDNIp:").append(this.epb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalAudioChannel:").append(this.epc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsUrl:").append(this.eoP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(126703);
        return stringBuffer2;
    }
}
