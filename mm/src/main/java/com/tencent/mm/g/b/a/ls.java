package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class ls extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    private String eWb = "";
    private long eXc;
    private long eYW;
    private a eZu;
    private String eZv = "";
    private long eZw;
    private b eZx;
    private long eZy;
    private long eZz;
    private long erW;
    private String exq = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19280;
    }

    public final ls za(String str) {
        AppMethodBeat.i(180156);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(180156);
        return this;
    }

    public final ls vh(long j2) {
        this.eXc = j2;
        return this;
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(180151);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(180151);
            return aVar;
        }

        static {
            AppMethodBeat.i(180152);
            AppMethodBeat.o(180152);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a md(int i2) {
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

    public final ls a(a aVar) {
        this.eZu = aVar;
        return this;
    }

    public final ls vi(long j2) {
        this.eYW = j2;
        return this;
    }

    public final ls zb(String str) {
        AppMethodBeat.i(180157);
        this.eZv = x("PluginAppid", str, true);
        AppMethodBeat.o(180157);
        return this;
    }

    public enum b {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(180154);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(180154);
            return bVar;
        }

        static {
            AppMethodBeat.i(180155);
            AppMethodBeat.o(180155);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    public final ls a(b bVar) {
        this.eZx = bVar;
        return this;
    }

    public final ls zc(String str) {
        AppMethodBeat.i(180158);
        this.exq = x("networkType", str, true);
        AppMethodBeat.o(180158);
        return this;
    }

    public final ls zd(String str) {
        AppMethodBeat.i(180159);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(180159);
        return this;
    }

    public final ls vj(long j2) {
        this.erW = j2;
        return this;
    }

    public final ls vk(long j2) {
        this.eZz = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3 = -1;
        AppMethodBeat.i(180160);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        if (this.eZu != null) {
            i2 = this.eZu.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.eZv);
        stringBuffer.append(",");
        stringBuffer.append(this.eZw);
        stringBuffer.append(",");
        if (this.eZx != null) {
            i3 = this.eZx.value;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        stringBuffer.append(this.exq);
        stringBuffer.append(",");
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eZy);
        stringBuffer.append(",");
        stringBuffer.append(this.eZz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(180160);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(180161);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppState:").append(this.eZu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PluginAppid:").append(this.eZv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PluginVersion:").append(this.eZw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PluginState:").append(this.eZx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networkType:").append(this.exq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("updateScene:").append(this.eZy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("updateResult:").append(this.eZz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(180161);
        return stringBuffer2;
    }
}
