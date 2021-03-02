package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class fs extends a {
    private String _ID = "";
    private long eGY = 0;
    private long eGZ = 0;
    private long eHa = 0;
    private long eHb = 0;
    private long eHc = 0;
    private long eHd = 0;
    private String eHe = "";
    private String eHf = "";
    private long eHg = 0;
    private long eHh = 0;
    private String eHi = "";
    private String eHj = "";
    public long eHk = 0;
    private long eHl = 0;
    private long eHm = 0;
    private String eHn = "";
    private String eHo = "";
    private String eHp = "";
    private long eHq = 0;
    private String eHr = "";
    private String eHs = "";
    private String eHt = "";
    public long eHu = 0;
    private long erW = 0;
    private long euQ = 0;

    public fs() {
    }

    public fs(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(94820);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 26) {
                strArr = new String[26];
                Arrays.fill(strArr, 0, 26, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this._ID = x("ID", strArr[0], true);
            this.euQ = Util.getLong(strArr[1], 0);
            this.eGY = Util.getLong(strArr[2], 0);
            this.eGZ = Util.getLong(strArr[3], 0);
            this.eHa = Util.getLong(strArr[4], 0);
            this.eHb = Util.getLong(strArr[5], 0);
            this.eHc = Util.getLong(strArr[6], 0);
            this.eHd = Util.getLong(strArr[7], 0);
            this.eHe = x(android.support.e.a.TAG_F_NUMBER, strArr[8], true);
            this.eHf = x(android.support.e.a.TAG_EXPOSURE_TIME, strArr[9], true);
            this.eHg = Util.getLong(strArr[10], 0);
            this.eHh = Util.getLong(strArr[11], 0);
            this.eHi = x(android.support.e.a.TAG_LENS_MODEL, strArr[12], true);
            this.eHj = x("CreatTime", strArr[13], true);
            this.eHk = Util.getLong(strArr[14], 0);
            this.erW = Util.getLong(strArr[15], 0);
            this.eHl = Util.getLong(strArr[16], 0);
            this.eHm = Util.getLong(strArr[17], 0);
            this.eHn = x("make", strArr[18], true);
            this.eHo = x("software", strArr[19], true);
            this.eHp = x("fileExt", strArr[20], true);
            this.eHq = Util.getLong(strArr[21], 0);
            this.eHr = x(android.support.e.a.TAG_Y_CB_CR_SUB_SAMPLING, strArr[22], true);
            this.eHs = x("md5", strArr[23], true);
            sJ(strArr[24]);
            this.eHu = Util.getLong(strArr[25], 0);
        }
        AppMethodBeat.o(94820);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16585;
    }

    public final fs sJ(String str) {
        AppMethodBeat.i(94821);
        this.eHt = x("publishId", str, true);
        AppMethodBeat.o(94821);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94822);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this._ID);
        stringBuffer.append(",");
        stringBuffer.append(this.euQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eGY);
        stringBuffer.append(",");
        stringBuffer.append(this.eGZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eHa);
        stringBuffer.append(",");
        stringBuffer.append(this.eHb);
        stringBuffer.append(",");
        stringBuffer.append(this.eHc);
        stringBuffer.append(",");
        stringBuffer.append(this.eHd);
        stringBuffer.append(",");
        stringBuffer.append(this.eHe);
        stringBuffer.append(",");
        stringBuffer.append(this.eHf);
        stringBuffer.append(",");
        stringBuffer.append(this.eHg);
        stringBuffer.append(",");
        stringBuffer.append(this.eHh);
        stringBuffer.append(",");
        stringBuffer.append(this.eHi);
        stringBuffer.append(",");
        stringBuffer.append(this.eHj);
        stringBuffer.append(",");
        stringBuffer.append(this.eHk);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eHl);
        stringBuffer.append(",");
        stringBuffer.append(this.eHm);
        stringBuffer.append(",");
        stringBuffer.append(this.eHn);
        stringBuffer.append(",");
        stringBuffer.append(this.eHo);
        stringBuffer.append(",");
        stringBuffer.append(this.eHp);
        stringBuffer.append(",");
        stringBuffer.append(this.eHq);
        stringBuffer.append(",");
        stringBuffer.append(this.eHr);
        stringBuffer.append(",");
        stringBuffer.append(this.eHs);
        stringBuffer.append(",");
        stringBuffer.append(this.eHt);
        stringBuffer.append(",");
        stringBuffer.append(this.eHu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94822);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94823);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ID:").append(this._ID);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MediaType:").append(this.euQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginWidth:").append(this.eGY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginHeight:").append(this.eGZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CompressedWidth:").append(this.eHa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CompressedHeight:").append(this.eHb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginSize:").append(this.eHc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CompressedSize:").append(this.eHd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FNumber:").append(this.eHe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposureTime:").append(this.eHf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ISO:").append(this.eHg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Flash:").append(this.eHh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LensModel:").append(this.eHi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CreatTime:").append(this.eHj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFromWeChat:").append(this.eHk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sceneType:").append(this.eHl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fileSource:").append(this.eHm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("make:").append(this.eHn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("software:").append(this.eHo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("fileExt:").append(this.eHp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("faceCount:").append(this.eHq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("YCbCrSubSampling:").append(this.eHr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("md5:").append(this.eHs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("publishId:").append(this.eHt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("destMeidaType:").append(this.eHu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94823);
        return stringBuffer2;
    }
}
