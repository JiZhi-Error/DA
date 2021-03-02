package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class mx extends com.tencent.mm.plugin.report.a {
    public long eJb = 0;
    public String eJx = "";
    public String eWb = "";
    public long eXc = 0;
    public long eYW = 0;
    public long eZK = 0;
    public long erW = 0;
    private long fac = 0;
    public long fad = 0;
    public long fae = 0;
    public long fbM;
    public long fbo = 0;
    public a ffg;
    public long ffh = 0;
    public c ffi;
    public b ffj;
    public long ffk = 0;
    private long ffl = 0;
    private long ffm = 0;
    private long ffn = 0;
    public long ffo;
    public long ffp;
    public long ffq;
    public long ffr;
    public d ffs;
    public long fft;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15766;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43710);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43710);
            return aVar;
        }

        static {
            AppMethodBeat.i(43711);
            AppMethodBeat.o(43711);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mJ(int i2) {
            switch (i2) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return demo;
                default:
                    return null;
            }
        }
    }

    public final mx xl(long j2) {
        AppMethodBeat.i(43718);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43718);
        return this;
    }

    public final mx xm(long j2) {
        AppMethodBeat.i(43719);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43719);
        return this;
    }

    public enum c {
        sync(0),
        unsync(1);
        
        final int value;

        public static c valueOf(String str) {
            AppMethodBeat.i(43716);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(43716);
            return cVar;
        }

        static {
            AppMethodBeat.i(43717);
            AppMethodBeat.o(43717);
        }

        private c(int i2) {
            this.value = i2;
        }
    }

    public enum b {
        sync(0),
        unsync(1);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(43713);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(43713);
            return bVar;
        }

        static {
            AppMethodBeat.i(43714);
            AppMethodBeat.o(43714);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    public final mx xn(long j2) {
        AppMethodBeat.i(43721);
        this.ffn = j2;
        super.bi("NonUICostTimeMs", this.ffn);
        AppMethodBeat.o(43721);
        return this;
    }

    public enum d {
        sync(0),
        unsync(1);
        
        final int value;

        public static d valueOf(String str) {
            AppMethodBeat.i(226103);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(226103);
            return dVar;
        }

        static {
            AppMethodBeat.i(226104);
            AppMethodBeat.o(226104);
        }

        private d(int i2) {
            this.value = i2;
        }
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3;
        int i4;
        int i5 = -1;
        AppMethodBeat.i(43722);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.ffg != null) {
            i2 = this.ffg.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.fac);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.fad);
        stringBuffer.append(",");
        stringBuffer.append(this.fae);
        stringBuffer.append(",");
        stringBuffer.append(this.ffh);
        stringBuffer.append(",");
        if (this.ffi != null) {
            i3 = this.ffi.value;
        } else {
            i3 = -1;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        if (this.ffj != null) {
            i4 = this.ffj.value;
        } else {
            i4 = -1;
        }
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        stringBuffer.append(",");
        stringBuffer.append(this.ffk);
        stringBuffer.append(",");
        stringBuffer.append(this.ffl);
        stringBuffer.append(",");
        stringBuffer.append(this.ffm);
        stringBuffer.append(",");
        stringBuffer.append(this.eZK);
        stringBuffer.append(",");
        stringBuffer.append(this.ffn);
        stringBuffer.append(",");
        stringBuffer.append(this.fbo);
        stringBuffer.append(",");
        stringBuffer.append(this.ffo);
        stringBuffer.append(",");
        stringBuffer.append(this.ffp);
        stringBuffer.append(",");
        stringBuffer.append(this.ffq);
        stringBuffer.append(",");
        stringBuffer.append(this.ffr);
        stringBuffer.append(",");
        if (this.ffs != null) {
            i5 = this.ffs.value;
        }
        stringBuffer.append(i5);
        stringBuffer.append(",");
        stringBuffer.append(this.fft);
        stringBuffer.append(",");
        stringBuffer.append(this.fbM);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43722);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43723);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.ffg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTimeMs:").append(this.fac);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartTimeStampMs:").append(this.fad);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndTimeStampMs:").append(this.fae);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PkgSize:").append(this.ffh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLaunchSync:").append(this.ffi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsContactSync:").append(this.ffj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasDownloadCode:").append(this.ffk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFirstDownload:").append(this.ffl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LaunchType:").append(this.ffm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPreload:").append(this.eZK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NonUICostTimeMs:").append(this.ffn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("initProcess:").append(this.fbo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("launchReadyT:").append(this.ffo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("packageReadyT:").append(this.ffp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UIReadyT:").append(this.ffq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("requestType:").append(this.ffr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isCheckJsApiInfoSync:").append(this.ffs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("checkJsApiInfoReadyT:").append(this.fft);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("runningState:").append(this.fbM);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43723);
        return stringBuffer2;
    }

    public final mx ajm() {
        AppMethodBeat.i(43720);
        this.fae = Util.nowMilliSecond();
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43720);
        return this;
    }
}
