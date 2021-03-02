package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class iq extends a {
    public long eGx = 0;
    private long eIW;
    public long eJH = 0;
    public long eJb = 0;
    private String eKE = "";
    private int eKF = 0;
    private long eKG = 0;
    private int eKH = 0;
    private int eKI = 0;
    public long eKJ = 0;
    public long eKb = 0;
    private long eKc = 0;
    public long eKd = 0;
    public long eKe = 0;
    public long eKf = 0;
    private long eKg = 0;
    private long eKh = 0;
    private long eKi = 0;
    private int eKj = 0;
    private long eKk = 0;
    private long eKl = 0;
    private long eKm = 0;
    private long eKn = 0;
    private int eKo = 0;
    private long eKp = 0;
    private long eKq = 0;
    private long eKr = 0;
    private long eKs = 0;
    private long eKt = 0;
    private long eKu = 0;
    private long eKv = 0;
    private int eKw = 0;
    private int eKx = 0;
    public long eKy = 0;
    public int eKz = 0;
    private String ePp = "";
    private String ePq = "";
    private long ePr = 0;
    private int ePs = 0;
    private String ePt = "";
    private String ePu = "";
    public int ePv;
    private String ePw = "";
    public int ePx;
    public long eoV = 0;
    public long eoW = 0;
    private String epb = "";
    private long epd = 0;
    private long epe = 0;

    public iq() {
    }

    public iq(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(126690);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 49) {
                strArr = new String[49];
                Arrays.fill(strArr, 0, 49, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            wn(strArr[0]);
            this.ePq = x("SnsReserved1", strArr[1], true);
            this.eKb = Util.getLong(strArr[2], 0);
            this.eoV = Util.getLong(strArr[3], 0);
            this.eKc = Util.getLong(strArr[4], 0);
            this.eJH = Util.getLong(strArr[5], 0);
            this.eKd = Util.getLong(strArr[6], 0);
            this.eKe = Util.getLong(strArr[7], 0);
            this.eKf = Util.getLong(strArr[8], 0);
            this.eGx = Util.getLong(strArr[9], 0);
            this.eJb = Util.getLong(strArr[10], 0);
            this.eKg = Util.getLong(strArr[11], 0);
            this.eKh = Util.getLong(strArr[12], 0);
            this.eKi = Util.getLong(strArr[13], 0);
            this.ePr = Util.getLong(strArr[14], 0);
            this.ePs = Util.getInt(strArr[15], 0);
            this.eKj = Util.getInt(strArr[16], 0);
            this.eKk = Util.getLong(strArr[17], 0);
            this.eKl = Util.getLong(strArr[18], 0);
            this.eKm = Util.getLong(strArr[19], 0);
            this.eKn = Util.getLong(strArr[20], 0);
            this.eKo = Util.getInt(strArr[21], 0);
            this.eKp = Util.getLong(strArr[22], 0);
            this.eKq = Util.getLong(strArr[23], 0);
            this.eKr = Util.getLong(strArr[24], 0);
            this.eKs = Util.getLong(strArr[25], 0);
            this.eKt = Util.getLong(strArr[26], 0);
            this.eKu = Util.getLong(strArr[27], 0);
            this.eKv = Util.getLong(strArr[28], 0);
            this.eKw = Util.getInt(strArr[29], 0);
            this.eKx = Util.getInt(strArr[30], 0);
            this.eKy = Util.getLong(strArr[31], 0);
            this.eKz = Util.getInt(strArr[32], 0);
            this.eoW = Util.getLong(strArr[33], 0);
            this.ePt = x("postname", strArr[34], true);
            this.epb = x("CDNIp", strArr[35], true);
            wo(strArr[36]);
            this.eKE = x("XClientIp", strArr[37], true);
            this.eKF = Util.getInt(strArr[38], 0);
            this.eKG = Util.getLong(strArr[39], 0);
            this.epd = Util.getLong(strArr[40], 0);
            this.epe = Util.getLong(strArr[41], 0);
            this.eKH = Util.getInt(strArr[42], 0);
            this.eKI = Util.getInt(strArr[43], 0);
            this.ePv = Util.getInt(strArr[44], 0);
            wp(strArr[45]);
            this.ePx = Util.getInt(strArr[46], 0);
            this.eIW = Util.getLong(strArr[47], 0);
            this.eKJ = Util.getLong(strArr[48], 0);
        }
        AppMethodBeat.o(126690);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 13790;
    }

    public final iq wn(String str) {
        AppMethodBeat.i(126691);
        this.ePp = x("SnsVideoUrl", str, true);
        AppMethodBeat.o(126691);
        return this;
    }

    public final iq wo(String str) {
        AppMethodBeat.i(126692);
        this.ePu = x("SnsPublishid", str, true);
        AppMethodBeat.o(126692);
        return this;
    }

    public final iq wp(String str) {
        AppMethodBeat.i(126693);
        this.ePw = x("AutoPlaySessionID", str, true);
        AppMethodBeat.o(126693);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(126694);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ePp);
        stringBuffer.append(",");
        stringBuffer.append(this.ePq);
        stringBuffer.append(",");
        stringBuffer.append(this.eKb);
        stringBuffer.append(",");
        stringBuffer.append(this.eoV);
        stringBuffer.append(",");
        stringBuffer.append(this.eKc);
        stringBuffer.append(",");
        stringBuffer.append(this.eJH);
        stringBuffer.append(",");
        stringBuffer.append(this.eKd);
        stringBuffer.append(",");
        stringBuffer.append(this.eKe);
        stringBuffer.append(",");
        stringBuffer.append(this.eKf);
        stringBuffer.append(",");
        stringBuffer.append(this.eGx);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        stringBuffer.append(",");
        stringBuffer.append(this.eKg);
        stringBuffer.append(",");
        stringBuffer.append(this.eKh);
        stringBuffer.append(",");
        stringBuffer.append(this.eKi);
        stringBuffer.append(",");
        stringBuffer.append(this.ePr);
        stringBuffer.append(",");
        stringBuffer.append(this.ePs);
        stringBuffer.append(",");
        stringBuffer.append(this.eKj);
        stringBuffer.append(",");
        stringBuffer.append(this.eKk);
        stringBuffer.append(",");
        stringBuffer.append(this.eKl);
        stringBuffer.append(",");
        stringBuffer.append(this.eKm);
        stringBuffer.append(",");
        stringBuffer.append(this.eKn);
        stringBuffer.append(",");
        stringBuffer.append(this.eKo);
        stringBuffer.append(",");
        stringBuffer.append(this.eKp);
        stringBuffer.append(",");
        stringBuffer.append(this.eKq);
        stringBuffer.append(",");
        stringBuffer.append(this.eKr);
        stringBuffer.append(",");
        stringBuffer.append(this.eKs);
        stringBuffer.append(",");
        stringBuffer.append(this.eKt);
        stringBuffer.append(",");
        stringBuffer.append(this.eKu);
        stringBuffer.append(",");
        stringBuffer.append(this.eKv);
        stringBuffer.append(",");
        stringBuffer.append(this.eKw);
        stringBuffer.append(",");
        stringBuffer.append(this.eKx);
        stringBuffer.append(",");
        stringBuffer.append(this.eKy);
        stringBuffer.append(",");
        stringBuffer.append(this.eKz);
        stringBuffer.append(",");
        stringBuffer.append(this.eoW);
        stringBuffer.append(",");
        stringBuffer.append(this.ePt);
        stringBuffer.append(",");
        stringBuffer.append(this.epb);
        stringBuffer.append(",");
        stringBuffer.append(this.ePu);
        stringBuffer.append(",");
        stringBuffer.append(this.eKE);
        stringBuffer.append(",");
        stringBuffer.append(this.eKF);
        stringBuffer.append(",");
        stringBuffer.append(this.eKG);
        stringBuffer.append(",");
        stringBuffer.append(this.epd);
        stringBuffer.append(",");
        stringBuffer.append(this.epe);
        stringBuffer.append(",");
        stringBuffer.append(this.eKH);
        stringBuffer.append(",");
        stringBuffer.append(this.eKI);
        stringBuffer.append(",");
        stringBuffer.append(this.ePv);
        stringBuffer.append(",");
        stringBuffer.append(this.ePw);
        stringBuffer.append(",");
        stringBuffer.append(this.ePx);
        stringBuffer.append(",");
        stringBuffer.append(this.eIW);
        stringBuffer.append(",");
        stringBuffer.append(this.eKJ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(126694);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(126695);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SnsVideoUrl:").append(this.ePp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsReserved1:").append(this.ePq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileLength:").append(this.eKb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoDuration:").append(this.eoV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadLength:").append(this.eKc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayDuration:").append(this.eJH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstPlayWaitTime:").append(this.eKd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovWaitTime:").append(this.eKe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BlockCount:").append(this.eKf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RegainAvgTime:").append(this.eGx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadType:").append(this.eKg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartDownloadTime:").append(this.eKh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndDownloadTime:").append(this.eKi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatName:").append(this.ePr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HttpStatusCode:").append(this.ePs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RetCode:").append(this.eKj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterQueueTime:").append(this.eKk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstReqCostTime:").append(this.eKl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstReqSize:").append(this.eKm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstReqDownloadSize:").append(this.eKn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstReqCompleted:").append(this.eKo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AvgSpeed:").append(this.eKp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AvgConnectCost:").append(this.eKq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstConnectCostTime:").append(this.eKr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetConnectTimes:").append(this.eKs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovReqTimes:").append(this.eKt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovCostTime:").append(this.eKu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovSize:").append(this.eKv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovCompleted:").append(this.eKw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovFailReason:").append(this.eKx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UiStayTime:").append(this.eKy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayErrorCode:").append(this.eKz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoBitrate:").append(this.eoW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("postname:").append(this.ePt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CDNIp:").append(this.epb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsPublishid:").append(this.ePu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("XClientIp:").append(this.eKE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsCrossNet:").append(this.eKF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovPosition:").append(this.eKG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadPreloadSize:").append(this.epd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadPreloadCompletion:").append(this.epe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TransportProtocol:").append(this.eKH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TransportProtocolError:").append(this.eKI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AutoPlayScene:").append(this.ePv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AutoPlaySessionID:").append(this.ePw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AutoPlayReportTimstamp:").append(this.ePx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceType:").append(this.eIW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TraceId:").append(this.eKJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(126695);
        return stringBuffer2;
    }
}
