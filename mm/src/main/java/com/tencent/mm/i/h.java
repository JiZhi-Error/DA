package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h extends g {
    public int concurrentCount = 1;
    public String dRL;
    public int dRN;
    public String dRS = "";
    public long dTS = 0;
    public String djw = "";
    public String filename;
    public long gqR;
    public String gqS;
    public int gqT;
    public int gqU;
    public String gqV;
    public int gqW;
    public int gqX = 0;
    public long gqY = 0;
    public int gqZ = 0;
    public String[] gqr;
    public long gra = 0;
    public int grb = 1;
    public boolean grc;
    public boolean grd;
    public a gre;
    public String host;
    public boolean isColdSnsData = false;
    public String referer;
    public String signalQuality = "";
    public String snsCipherKey;
    public String snsScene = "";
    public String url;
    public String videoFlag;

    public interface a {
        void Ds(String str);

        void a(String str, int i2, d dVar);

        void a(String str, long j2, long j3, String str2);

        void i(String str, long j2, long j3);

        void onDataAvailable(String str, long j2, long j3);
    }

    public String toString() {
        AppMethodBeat.i(120678);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("isPlayMode: ").append(this.gqU);
        stringBuffer.append(" videoFormat: ").append(this.field_requestVideoFormat);
        stringBuffer.append(" initialDownloadLength : ").append(this.gqz);
        stringBuffer.append(" initialDownloadOffset : ").append(this.gqA);
        stringBuffer.append(" videoXmlTotalLen : ").append(this.gqT);
        stringBuffer.append(" videoTaskType : ").append(this.gqP);
        stringBuffer.append(" filename : ").append(this.filename);
        if (alO()) {
            stringBuffer.append(" url : ").append(this.url);
            stringBuffer.append(" host : ").append(this.host);
            stringBuffer.append(" referer : ").append(this.referer);
            stringBuffer.append(" ip size : ").append(this.gqr != null ? this.gqr.length : 0);
            stringBuffer.append(" isColdSnsData : ").append(this.isColdSnsData);
            stringBuffer.append(" signalQuality : ").append(this.signalQuality);
            stringBuffer.append(" snsScene : ").append(this.snsScene);
            stringBuffer.append(" snsId : ").append(this.dRS);
        } else {
            stringBuffer.append(" field_mediaId : ").append(this.field_mediaId);
        }
        stringBuffer.append(" fileid : ").append(this.field_fileId);
        stringBuffer.append(" fileaeskey: ").append(this.field_aesKey);
        stringBuffer.append(" field_preloadRatio:").append(this.field_preloadRatio);
        stringBuffer.append(" newmd5: ").append(this.djw);
        stringBuffer.append(" snsCipherKey: ").append(this.snsCipherKey);
        stringBuffer.append("}");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(120678);
        return stringBuffer2;
    }
}
