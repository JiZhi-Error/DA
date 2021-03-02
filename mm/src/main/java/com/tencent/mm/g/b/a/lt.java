package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class lt extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    public long eXc = 0;
    public a eZI;
    public b eZJ;
    public long eZK = 0;
    public long eZL = 0;
    public long eZM = 0;
    public long eZN = 0;
    public long eZO = 0;
    private String eiB = "";
    public long erW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16602;
    }

    public final lt ze(String str) {
        AppMethodBeat.i(43489);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(43489);
        return this;
    }

    public final lt zf(String str) {
        AppMethodBeat.i(43490);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43490);
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        eZR(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43484);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43484);
            return aVar;
        }

        static {
            AppMethodBeat.i(43485);
            AppMethodBeat.o(43485);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a me(int i2) {
            switch (i2) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return eZR;
                default:
                    return null;
            }
        }
    }

    public enum b {
        undefined(0),
        normal(1000),
        plugin(1001),
        wxstore(1002),
        merchant(1003),
        wagame(1004),
        gift(1005);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(43487);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(43487);
            return bVar;
        }

        static {
            AppMethodBeat.i(43488);
            AppMethodBeat.o(43488);
        }

        private b(int i2) {
            this.value = i2;
        }

        public static b mf(int i2) {
            switch (i2) {
                case 0:
                    return undefined;
                case 1000:
                    return normal;
                case 1001:
                    return plugin;
                case 1002:
                    return wxstore;
                case 1003:
                    return merchant;
                case 1004:
                    return wagame;
                case 1005:
                    return gift;
                default:
                    return null;
            }
        }
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3 = -1;
        AppMethodBeat.i(43491);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.eZI != null) {
            i2 = this.eZI.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        if (this.eZJ != null) {
            i3 = this.eZJ.value;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        stringBuffer.append(this.eZK);
        stringBuffer.append(",");
        stringBuffer.append(this.eZL);
        stringBuffer.append(",");
        stringBuffer.append(this.eZM);
        stringBuffer.append(",");
        stringBuffer.append(this.eZN);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eZO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43491);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43492);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.eZI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eZJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPreload:").append(this.eZK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreloadKey:").append(this.eZL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreloadValue:").append(this.eZM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isDownloadCode:").append(this.eZN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasSplashScreen:").append(this.eZO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43492);
        return stringBuffer2;
    }
}
