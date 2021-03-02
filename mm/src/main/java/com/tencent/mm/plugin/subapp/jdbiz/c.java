package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class c {
    public String FJA = "";
    public int FJB = 0;
    public String FJl = "";
    public String FJm = "";
    public boolean FJn = false;
    public boolean FJo = false;
    public String FJp = "";
    public String FJq = "";
    public long FJr;
    public long FJs;
    public long FJt;
    public long FJu;
    public String FJv = "";
    public String FJw = "";
    public String FJx = "";
    public String FJy = "";
    public String FJz = "";
    public String dWG = "";
    public String iconUrl = "";
    public long jmW = 0;
    public String jumpUrl = "";
    public long startTime;
    public String title = "";

    public static c fsN() {
        AppMethodBeat.i(28869);
        bg.aVF();
        String str = (String) com.tencent.mm.model.c.azQ().get(327942, "");
        c cVar = new c();
        Log.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
        cVar.feed(str);
        AppMethodBeat.o(28869);
        return cVar;
    }

    public final void feed(String str) {
        AppMethodBeat.i(28870);
        init();
        this.dWG = str;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(28870);
            return;
        }
        Log.i("MicroMsg.JdMsgContent", "feed xml %s", str);
        aS(XmlParser.parseXml(str, "sysmsg", null));
        AppMethodBeat.o(28870);
    }

    private void init() {
        this.FJl = "";
        this.FJm = "";
        this.jmW = 0;
        this.FJp = "";
        this.FJn = false;
        this.FJo = false;
        this.FJw = "";
        this.FJx = "";
        this.FJy = "";
        this.FJv = "";
        this.jumpUrl = "";
        this.dWG = "";
    }

    private void aS(Map<String, String> map) {
        AppMethodBeat.i(28871);
        if (map == null) {
            AppMethodBeat.o(28871);
            return;
        }
        this.FJl = Util.nullAs(map.get(".sysmsg.biztype"), "");
        this.FJv = Util.nullAs(map.get(".sysmsg.alert"), "");
        this.FJm = Util.nullAs(map.get(".sysmsg.activityid"), "");
        this.startTime = Util.safeParseLong(map.get(".sysmsg.starttime"));
        this.jmW = Util.safeParseLong(map.get(".sysmsg.expiretime"));
        this.title = Util.nullAs(map.get(".sysmsg.content.title"), "");
        this.iconUrl = Util.nullAs(map.get(".sysmsg.content.icon"), "");
        this.jumpUrl = Util.nullAs(map.get(".sysmsg.content.jumpurl"), "");
        this.FJz = Util.nullAs(map.get(".sysmsg.content.jumpweapp.username"), "");
        this.FJA = Util.nullAs(map.get(".sysmsg.content.jumpweapp.path"), "");
        this.FJB = Util.safeParseInt(map.get(".sysmsg.content.jumpweapp.version"));
        this.FJr = Util.safeParseLong(map.get(".sysmsg.content.urlstarttime"));
        this.FJs = Util.safeParseLong(map.get(".sysmsg.content.urlexpiretime"));
        this.FJp = Util.nullAs(map.get(".sysmsg.content.jdcelltitle"), "");
        this.FJq = Util.nullAs(map.get(".sysmsg.content.jdcellicon"), "");
        this.FJt = Util.safeParseLong(map.get(".sysmsg.content.titlestarttime"));
        this.FJu = Util.safeParseLong(map.get(".sysmsg.content.titleexpiretime"));
        this.FJn = "1".equals(map.get(".sysmsg.content.findshowreddot"));
        this.FJo = "1".equals(map.get(".sysmsg.content.jdcellshowred"));
        this.FJw = Util.nullAs(map.get(".sysmsg.content.alertviewtitle"), "");
        this.FJx = Util.nullAs(map.get(".sysmsg.content.alertviewconfirm"), "");
        this.FJy = Util.nullAs(map.get(".sysmsg.content.alertviewcancel"), "");
        AppMethodBeat.o(28871);
    }

    public final boolean isStart() {
        AppMethodBeat.i(28872);
        if (this.startTime < System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(28872);
            return true;
        }
        AppMethodBeat.o(28872);
        return false;
    }

    public final boolean dMp() {
        AppMethodBeat.i(28873);
        if (this.jmW == 0 || this.jmW >= System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(28873);
            return false;
        }
        AppMethodBeat.o(28873);
        return true;
    }

    public final boolean fsO() {
        AppMethodBeat.i(28874);
        if (this.FJr < System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(28874);
            return true;
        }
        AppMethodBeat.o(28874);
        return false;
    }

    public final boolean fsP() {
        AppMethodBeat.i(28875);
        if (this.FJs == 0 || this.FJs >= System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(28875);
            return false;
        }
        AppMethodBeat.o(28875);
        return true;
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(28876);
        if (cVar == null) {
            AppMethodBeat.o(28876);
            return true;
        } else if (!Util.nullAs(this.FJm, "").equals(Util.nullAs(cVar.FJm, ""))) {
            AppMethodBeat.o(28876);
            return true;
        } else {
            AppMethodBeat.o(28876);
            return false;
        }
    }

    public final String aBz() {
        AppMethodBeat.i(28877);
        String nullAs = Util.nullAs(this.dWG, "");
        AppMethodBeat.o(28877);
        return nullAs;
    }
}
