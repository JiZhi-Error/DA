package com.tencent.mm.plugin.wallet_core.model.mall;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static d Icw = null;
    private Map<String, MallNews> Icv = new HashMap();

    public static d fSk() {
        AppMethodBeat.i(70567);
        if (Icw == null) {
            Icw = new d();
        }
        d dVar = Icw;
        AppMethodBeat.o(70567);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(70568);
        amZ();
        AppMethodBeat.o(70568);
    }

    public final void amZ() {
        AppMethodBeat.i(70569);
        this.Icv.clear();
        g.aAi();
        String str = (String) g.aAh().azQ().get(270341, "");
        Log.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(str)));
        for (String str2 : Util.stringsToList(str.split(";"))) {
            MallNews aVw = aVw(str2);
            if (aVw != null) {
                this.Icv.put(aVw.iLU, aVw);
            }
        }
        AppMethodBeat.o(70569);
    }

    public final void b(MallNews mallNews) {
        AppMethodBeat.i(70570);
        if (mallNews == null) {
            Log.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            AppMethodBeat.o(70570);
            return;
        }
        mallNews.Ics = "<sysmsg><mallactivitynew><functionid>" + mallNews.iLU + "</functionid><activityid>" + mallNews.FJm + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.Icl + "</showflag><newsTipFlag>" + mallNews.Icm + "</newsTipFlag></mallactivitynew></sysmsg>;";
        this.Icv.put(mallNews.iLU, mallNews);
        eDw();
        AppMethodBeat.o(70570);
    }

    private boolean eDw() {
        AppMethodBeat.i(70571);
        Log.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.Icv.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.Icv.keySet()) {
            if (!Util.isNullOrNil(str)) {
                MallNews mallNews = this.Icv.get(str);
                stringBuffer.append(mallNews.Ics.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + mallNews.FJm + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.Icl + "</showflag><newsTipFlag>" + mallNews.Icm + "</newsTipFlag></mallactivitynew></sysmsg>;");
            }
        }
        Log.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + stringBuffer.toString());
        g.aAi();
        g.aAh().azQ().set(270341, stringBuffer.toString());
        AppMethodBeat.o(70571);
        return true;
    }

    public final MallNews aVx(String str) {
        AppMethodBeat.i(70572);
        MallNews mallNews = this.Icv.get(str);
        AppMethodBeat.o(70572);
        return mallNews;
    }

    public final MallNews aVv(String str) {
        AppMethodBeat.i(70573);
        Log.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str) || !this.Icv.containsKey(str)) {
            AppMethodBeat.o(70573);
            return null;
        }
        MallNews mallNews = this.Icv.get(str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(mallNews.Icl)) {
            mallNews.Icl = "1";
            eDw();
        }
        AppMethodBeat.o(70573);
        return mallNews;
    }

    private static MallNews aVw(String str) {
        AppMethodBeat.i(70574);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(70574);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            AppMethodBeat.o(70574);
            return null;
        }
        try {
            MallNews mallNews = new MallNews(parseXml.get(".sysmsg.mallactivitynew.functionid"));
            mallNews.FJm = parseXml.get(".sysmsg.mallactivitynew.activityid");
            mallNews.type = parseXml.get(".sysmsg.mallactivitynew.type");
            mallNews.dDG = Util.getInt(parseXml.get(".sysmsg.mallactivitynew.showtype"), 0);
            if (parseXml.containsKey(".sysmsg.mallactivitynew.showflag")) {
                mallNews.Icl = parseXml.get(".sysmsg.mallactivitynew.showflag");
            } else {
                mallNews.Icl = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (parseXml.containsKey(".sysmsg.mallactivitynew.newsTipFlag")) {
                mallNews.Icm = parseXml.get(".sysmsg.mallactivitynew.newsTipFlag");
            } else {
                mallNews.Icm = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            mallNews.Ics = str;
            if (Util.isNullOrNil(mallNews.iLU)) {
                AppMethodBeat.o(70574);
                return null;
            }
            AppMethodBeat.o(70574);
            return mallNews;
        } catch (Exception e2) {
            Log.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
            AppMethodBeat.o(70574);
            return null;
        }
    }
}
