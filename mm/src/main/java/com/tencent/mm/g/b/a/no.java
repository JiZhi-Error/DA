package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class no extends com.tencent.mm.plugin.report.a {
    private String eJx = "";
    public long erW = 0;
    private long eub = 0;
    private String fhA = "";
    public d fhB;
    public e fhC;
    public a fhD;
    private String fhv = "";
    private String fhw = "";
    private String fhx = "";
    public c fhy;
    public b fhz;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16024;
    }

    public final no AJ(String str) {
        AppMethodBeat.i(2602);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(2602);
        return this;
    }

    public final no AK(String str) {
        AppMethodBeat.i(2603);
        this.fhv = x("PageId", str, true);
        AppMethodBeat.o(2603);
        return this;
    }

    public final no AL(String str) {
        AppMethodBeat.i(2605);
        this.fhw = x("ShareTicket", str, true);
        AppMethodBeat.o(2605);
        return this;
    }

    public final no AM(String str) {
        AppMethodBeat.i(2606);
        this.fhx = x("ChattingId", str, true);
        AppMethodBeat.o(2606);
        return this;
    }

    public enum c {
        DEFAULT(0),
        YES(1),
        NO(2);
        
        final int value;

        public static c valueOf(String str) {
            AppMethodBeat.i(2594);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(2594);
            return cVar;
        }

        static {
            AppMethodBeat.i(2595);
            AppMethodBeat.o(2595);
        }

        private c(int i2) {
            this.value = i2;
        }
    }

    public enum b {
        SHAREAPPMSG(1),
        CLICKAPPMSG(2),
        CLICKSUBSCRIBETV(3),
        CLICKSTARTGAME(4);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(2591);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(2591);
            return bVar;
        }

        static {
            AppMethodBeat.i(2592);
            AppMethodBeat.o(2592);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    public final no AN(String str) {
        AppMethodBeat.i(2607);
        this.fhA = x("SceneNote", str, true);
        AppMethodBeat.o(2607);
        return this;
    }

    public enum d {
        DEFAULT(0),
        DOING(1),
        DONE(2);
        
        final int value;

        public static d valueOf(String str) {
            AppMethodBeat.i(2597);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(2597);
            return dVar;
        }

        static {
            AppMethodBeat.i(2598);
            AppMethodBeat.o(2598);
        }

        private d(int i2) {
            this.value = i2;
        }
    }

    public enum e {
        DEFAULT(0),
        NOTSUBSCRIBE(1),
        SUBSCRIBE(2);
        
        final int value;

        public static e valueOf(String str) {
            AppMethodBeat.i(2600);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(2600);
            return eVar;
        }

        static {
            AppMethodBeat.i(2601);
            AppMethodBeat.o(2601);
        }

        private e(int i2) {
            this.value = i2;
        }
    }

    public enum a {
        undefined(0),
        normal(1000),
        plugin(1001),
        wxstore(1002),
        merchant(1003),
        wagame(1004),
        gift(1005);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(2588);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(2588);
            return aVar;
        }

        static {
            AppMethodBeat.i(2589);
            AppMethodBeat.o(2589);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a mX(int i2) {
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
        int i3;
        int i4;
        int i5;
        int i6 = -1;
        AppMethodBeat.i(2608);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.fhv);
        stringBuffer.append(",");
        stringBuffer.append(this.eub);
        stringBuffer.append(",");
        stringBuffer.append(this.fhw);
        stringBuffer.append(",");
        stringBuffer.append(this.fhx);
        stringBuffer.append(",");
        if (this.fhy != null) {
            i2 = this.fhy.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        if (this.fhz != null) {
            i3 = this.fhz.value;
        } else {
            i3 = -1;
        }
        stringBuffer.append(i3);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.fhA);
        stringBuffer.append(",");
        if (this.fhB != null) {
            i4 = this.fhB.value;
        } else {
            i4 = -1;
        }
        stringBuffer.append(i4);
        stringBuffer.append(",");
        if (this.fhC != null) {
            i5 = this.fhC.value;
        } else {
            i5 = -1;
        }
        stringBuffer.append(i5);
        stringBuffer.append(",");
        if (this.fhD != null) {
            i6 = this.fhD.value;
        }
        stringBuffer.append(i6);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(2608);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(2609);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageId:").append(this.fhv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStampMs:").append(this.eub);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareTicket:").append(this.fhw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChattingId:").append(this.fhx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsGroupChatting:").append(this.fhy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventId:").append(this.fhz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SceneNote:").append(this.fhA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgState:").append(this.fhB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubScribeState:").append(this.fhC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.fhD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(2609);
        return stringBuffer2;
    }

    public final no ajq() {
        AppMethodBeat.i(2604);
        this.eub = Util.nowMilliSecond();
        super.bj("ActionTimeStampMs", this.eub);
        AppMethodBeat.o(2604);
        return this;
    }
}
