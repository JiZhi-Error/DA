package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends g {
    public int appType = -1;
    public int fileType = 0;
    public String gqq;
    public String[] gqr;
    public String[] gqs;
    public int gqt;
    public int gqu;
    public String host;
    public boolean isColdSnsData;
    public String referer;
    public String signalQuality;
    public String snsCipherKey = "";
    public String snsScene;
    public String url;

    public e() {
        this.gqK = true;
    }

    public String toString() {
        AppMethodBeat.i(120675);
        String format = String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", this.field_mediaId, this.url, this.host, this.referer, this.gqq, h(this.gqr), h(this.gqs), Integer.valueOf(this.gqt), Integer.valueOf(this.gqu), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene);
        AppMethodBeat.o(120675);
        return format;
    }

    private static String h(String[] strArr) {
        AppMethodBeat.i(120676);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(120676);
            return "";
        }
        String str = "";
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str + strArr[i2] + ",";
        }
        AppMethodBeat.o(120676);
        return str;
    }
}
