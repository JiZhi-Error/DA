package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class mk extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    private long eXc = 0;
    private long eYW = 0;
    private String ekG = "";
    private String eoK = "";
    private long erW = 0;
    private String exq = "";
    private long fac = 0;
    private long fad = 0;
    private long fae = 0;
    private long fbM;
    private String fbm = "";
    private a fcb;
    private long fcc = 0;
    private long fcd = 0;
    private String fce = "";
    private String fcf = "";
    private String fcg = "";
    private int fch;
    private long fci;
    private long fcj;
    private String fck = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16367;
    }

    public final mk zB(String str) {
        AppMethodBeat.i(43604);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43604);
        return this;
    }

    public final String aiv() {
        return this.eWb;
    }

    public final mk zC(String str) {
        AppMethodBeat.i(43605);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43605);
        return this;
    }

    public final mk we(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43602);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43602);
            return aVar;
        }

        static {
            AppMethodBeat.i(43603);
            AppMethodBeat.o(43603);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mw(int i2) {
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

    public final mk a(a aVar) {
        this.fcb = aVar;
        return this;
    }

    public final mk wf(long j2) {
        this.eYW = j2;
        return this;
    }

    public final mk wg(long j2) {
        this.erW = j2;
        return this;
    }

    public final mk wh(long j2) {
        AppMethodBeat.i(43606);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43606);
        return this;
    }

    public final mk zD(String str) {
        AppMethodBeat.i(226082);
        this.exq = x("networkType", str, true);
        AppMethodBeat.o(226082);
        return this;
    }

    public final mk wi(long j2) {
        this.fcc = j2;
        return this;
    }

    public final mk zE(String str) {
        AppMethodBeat.i(43608);
        this.eoK = x("UserName", str, true);
        AppMethodBeat.o(43608);
        return this;
    }

    public final mk wj(long j2) {
        this.fcd = j2;
        return this;
    }

    public final mk wk(long j2) {
        this.fbM = j2;
        return this;
    }

    public final mk zF(String str) {
        AppMethodBeat.i(226083);
        this.fbm = x("path", str, true);
        AppMethodBeat.o(226083);
        return this;
    }

    public final mk zG(String str) {
        AppMethodBeat.i(226084);
        this.fcf = x("reload_referrer", str, true);
        AppMethodBeat.o(226084);
        return this;
    }

    public final mk zH(String str) {
        AppMethodBeat.i(226085);
        this.fcg = x("reload_reason", str, true);
        AppMethodBeat.o(226085);
        return this;
    }

    public final mk mv(int i2) {
        this.fch = i2;
        return this;
    }

    public final mk wl(long j2) {
        this.fci = j2;
        return this;
    }

    public final mk wm(long j2) {
        this.fcj = j2;
        return this;
    }

    public final mk zI(String str) {
        AppMethodBeat.i(226086);
        this.fck = x("shortLink", str, true);
        AppMethodBeat.o(226086);
        return this;
    }

    public final mk zJ(String str) {
        AppMethodBeat.i(226087);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(226087);
        return this;
    }

    public final String getSessionId() {
        return this.ekG;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43609);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.fcb != null) {
            i2 = this.fcb.value;
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
        stringBuffer.append(this.exq);
        stringBuffer.append(",");
        stringBuffer.append(this.fcc);
        stringBuffer.append(",");
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.fcd);
        stringBuffer.append(",");
        stringBuffer.append(this.fce);
        stringBuffer.append(",");
        stringBuffer.append(this.fbM);
        stringBuffer.append(",");
        stringBuffer.append(this.fbm);
        stringBuffer.append(",");
        stringBuffer.append(this.fcf);
        stringBuffer.append(",");
        stringBuffer.append(this.fcg);
        stringBuffer.append(",");
        stringBuffer.append(this.fch);
        stringBuffer.append(",");
        stringBuffer.append(this.fci);
        stringBuffer.append(",");
        stringBuffer.append(this.fcj);
        stringBuffer.append(",");
        stringBuffer.append(this.fck);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43609);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43610);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.fcb);
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
        stringBuffer.append("networkType:").append(this.exq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isLaunch:").append(this.fcc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("loadingType:").append(this.fcd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene_data:").append(this.fce);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("runningState:").append(this.fbM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("path:").append(this.fbm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reload_referrer:").append(this.fcf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reload_reason:").append(this.fcg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("user_type:").append(this.fch);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("launchMode:").append(this.fci);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("coldStartMode:").append(this.fcj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shortLink:").append(this.fck);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43610);
        return stringBuffer2;
    }
}
