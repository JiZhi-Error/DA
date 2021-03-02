package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class an extends a {
    private String eoL = "";
    private String eoM = "";
    private long eoN = 0;
    private String eoO = "";
    private String eoP = "";
    private int eoQ = 0;
    private String eoR = "";
    private long eoS = 0;
    private long eoT = 0;
    private long eoU = 0;
    private long eoV = 0;
    private long eoW = 0;
    private long eoX = 0;
    private long eoY = 0;
    private long eoZ = 0;
    private long epa = 0;
    private String epb = "";
    private long epc = 0;
    private long epd = 0;
    private long epe = 0;
    private String epf = "";

    public an() {
    }

    public an(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(126681);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 21) {
                strArr = new String[21];
                Arrays.fill(strArr, 0, 21, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.eoL = x("FromUser", strArr[0], true);
            this.eoM = x("Session", strArr[1], true);
            this.eoN = Util.getLong(strArr[2], 0);
            this.eoO = x("FileId", strArr[3], true);
            this.eoP = x("SnsUrl", strArr[4], true);
            this.eoQ = Util.getInt(strArr[5], 0);
            this.eoR = x("NewMd5", strArr[6], true);
            this.eoS = Util.getLong(strArr[7], 0);
            this.eoT = Util.getLong(strArr[8], 0);
            this.eoU = Util.getLong(strArr[9], 0);
            this.eoV = Util.getLong(strArr[10], 0);
            this.eoW = Util.getLong(strArr[11], 0);
            this.eoX = Util.getLong(strArr[12], 0);
            this.eoY = Util.getLong(strArr[13], 0);
            this.eoZ = Util.getLong(strArr[14], 0);
            this.epa = Util.getLong(strArr[15], 0);
            this.epb = x("CDNIp", strArr[16], true);
            this.epc = Util.getLong(strArr[17], 0);
            this.epd = Util.getLong(strArr[18], 0);
            this.epe = Util.getLong(strArr[19], 0);
            this.epf = x("Publishid", strArr[20], true);
        }
        AppMethodBeat.o(126681);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 13795;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(126682);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoL);
        stringBuffer.append(",");
        stringBuffer.append(this.eoM);
        stringBuffer.append(",");
        stringBuffer.append(this.eoN);
        stringBuffer.append(",");
        stringBuffer.append(this.eoO);
        stringBuffer.append(",");
        stringBuffer.append(this.eoP);
        stringBuffer.append(",");
        stringBuffer.append(this.eoQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eoR);
        stringBuffer.append(",");
        stringBuffer.append(this.eoS);
        stringBuffer.append(",");
        stringBuffer.append(this.eoT);
        stringBuffer.append(",");
        stringBuffer.append(this.eoU);
        stringBuffer.append(",");
        stringBuffer.append(this.eoV);
        stringBuffer.append(",");
        stringBuffer.append(this.eoW);
        stringBuffer.append(",");
        stringBuffer.append(this.eoX);
        stringBuffer.append(",");
        stringBuffer.append(this.eoY);
        stringBuffer.append(",");
        stringBuffer.append(this.eoZ);
        stringBuffer.append(",");
        stringBuffer.append(this.epa);
        stringBuffer.append(",");
        stringBuffer.append(this.epb);
        stringBuffer.append(",");
        stringBuffer.append(this.epc);
        stringBuffer.append(",");
        stringBuffer.append(this.epd);
        stringBuffer.append(",");
        stringBuffer.append(this.epe);
        stringBuffer.append(",");
        stringBuffer.append(this.epf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(126682);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(126683);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FromUser:").append(this.eoL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Session:").append(this.eoM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatNum:").append(this.eoN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileId:").append(this.eoO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsUrl:").append(this.eoP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetType:").append(this.eoQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewMd5:").append(this.eoR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadStartTime:").append(this.eoS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadEndTime:").append(this.eoT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoSize:").append(this.eoU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoDuration:").append(this.eoV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoBitrate:").append(this.eoW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioBitrate:").append(this.eoX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoFps:").append(this.eoY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoWidth:").append(this.eoZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoHeight:").append(this.epa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CDNIp:").append(this.epb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalAudioChannel:").append(this.epc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadPreloadSize:").append(this.epd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadPreloadCompletion:").append(this.epe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Publishid:").append(this.epf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(126683);
        return stringBuffer2;
    }
}
