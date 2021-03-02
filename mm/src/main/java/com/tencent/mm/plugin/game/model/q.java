package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import java.util.Random;

public final class q {
    public static void a(o oVar) {
        AppMethodBeat.i(41463);
        if (Util.isNullOrNil(oVar.field_rawXML)) {
            Log.e("MicroMsg.GameMessageParser", "msg content is null");
            AppMethodBeat.o(41463);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(oVar.field_rawXML, "sysmsg", null);
        if (parseXml == null || parseXml.size() == 0) {
            Log.e("MicroMsg.GameMessageParser", "Parse failed");
            AppMethodBeat.o(41463);
        } else if (!"gamecenter".equalsIgnoreCase(parseXml.get(".sysmsg.$type"))) {
            Log.e("MicroMsg.GameMessageParser", "Type not matched");
            AppMethodBeat.o(41463);
        } else {
            c(parseXml, oVar);
            d(parseXml, oVar);
            g(parseXml, oVar);
            h(parseXml, oVar);
            i(parseXml, oVar);
            j(parseXml, oVar);
            k(parseXml, oVar);
            m(parseXml, oVar);
            f(parseXml, oVar);
            p(parseXml, oVar);
            e(parseXml, oVar);
            a(parseXml, oVar);
            AppMethodBeat.o(41463);
        }
    }

    public static void b(o oVar) {
        AppMethodBeat.i(204164);
        if (Util.isNullOrNil(oVar.field_rawXML)) {
            Log.e("MicroMsg.GameMessageParser", "msg content is null");
            AppMethodBeat.o(204164);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(oVar.field_rawXML, "sysmsg", null);
        if (parseXml == null || parseXml.size() == 0) {
            Log.e("MicroMsg.GameMessageParser", "Parse failed");
            AppMethodBeat.o(204164);
        } else if (!"gamecenter".equalsIgnoreCase(parseXml.get(".sysmsg.$type"))) {
            Log.e("MicroMsg.GameMessageParser", "Type not matched");
            AppMethodBeat.o(204164);
        } else {
            a(parseXml, oVar);
            AppMethodBeat.o(204164);
        }
    }

    public static void a(Map<String, String> map, o oVar) {
        AppMethodBeat.i(204165);
        if (oVar == null || map == null) {
            AppMethodBeat.o(204165);
            return;
        }
        if (oVar.xFV == 0) {
            oVar.xFV = oVar.field_msgType;
        }
        b(map, oVar);
        AppMethodBeat.o(204165);
    }

    private static void b(Map<String, String> map, o oVar) {
        int intRandom;
        AppMethodBeat.i(204166);
        oVar.xFP.iGB = Util.nullAs(map.get(".sysmsg.report_rule.$report_id"), "");
        oVar.xFP.xGO = Util.getInt(map.get(".sysmsg.report_rule.report_mode"), 0);
        oVar.xFP.xGP = Util.getInt(map.get(".sysmsg.report_rule.report_sample"), 0);
        if (oVar.xFP.eay == null) {
            switch (oVar.xFP.xGO) {
                case 0:
                    oVar.xFP.eay = Boolean.TRUE;
                    break;
                case 1:
                    oVar.xFP.eay = Boolean.FALSE;
                    break;
                case 2:
                    o GJ = ((f) g.af(f.class)).dSK().GJ(oVar.field_msgId);
                    if (GJ == null) {
                        try {
                            g.aAi();
                            g.aAf();
                            intRandom = new Random(((long) a.getUin()) ^ System.nanoTime()).nextInt(10001);
                        } catch (Exception e2) {
                            intRandom = Util.getIntRandom(10000, 0);
                        }
                        Log.i("MicroMsg.GameMessageParser", "randomValue:%d, reportSample:%d", Integer.valueOf(intRandom), Integer.valueOf(oVar.xFP.xGP));
                        if (intRandom >= oVar.xFP.xGP) {
                            oVar.xFP.eay = Boolean.FALSE;
                            break;
                        } else {
                            oVar.xFP.eay = Boolean.TRUE;
                            break;
                        }
                    } else {
                        oVar.xFP.eay = Boolean.valueOf(GJ.field_needReport);
                        break;
                    }
            }
            if (oVar.xFP.eay == null) {
                oVar.xFP.eay = Boolean.FALSE;
            }
        }
        oVar.field_needReport = Util.nullAs(oVar.xFP.eay, false);
        Log.i("MicroMsg.GameMessageParser", "gameMessageId:%s, needReport:%b", oVar.field_gameMsgId, Boolean.valueOf(oVar.field_needReport));
        AppMethodBeat.o(204166);
    }

    public static String al(Map<String, String> map) {
        AppMethodBeat.i(41464);
        String nullAs = Util.nullAs(map.get(".sysmsg.gamecenter.formatcontent"), "");
        AppMethodBeat.o(41464);
        return nullAs;
    }

    private static void c(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41465);
        oVar.xFr = Util.getInt(map.get(".sysmsg.gamecenter.wifi_flag"), 0);
        AppMethodBeat.o(41465);
    }

    private static void d(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41466);
        oVar.rfc = al(map);
        oVar.xEW = Util.nullAs(map.get(".sysmsg.gamecenter.url"), "");
        oVar.xFk = Util.nullAs(map.get(".sysmsg.gamecenter.msg_picture_url"), "");
        oVar.xEX = Util.nullAs(map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
        if (Util.isNullOrNil(oVar.xEX)) {
            oVar.xEX = Util.nullAs(map.get(".sysmsg.gamecenter.url"), "");
        }
        oVar.xFU = Util.getInt(map.get(".sysmsg.gamecenter.notify_type"), 0);
        AppMethodBeat.o(41466);
    }

    private static void e(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41467);
        switch (oVar.field_msgType) {
            case 2:
                l(map, oVar);
                Log.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", oVar.field_appId);
                AppMethodBeat.o(41467);
                return;
            case 3:
            case 7:
            case 8:
            case 9:
            default:
                Log.e("MicroMsg.GameMessageParser", "error gamecenter type: " + oVar.field_msgType);
                AppMethodBeat.o(41467);
                return;
            case 4:
                AppMethodBeat.o(41467);
                return;
            case 5:
                n(map, oVar);
                AppMethodBeat.o(41467);
                return;
            case 6:
                o(map, oVar);
                AppMethodBeat.o(41467);
                return;
            case 10:
            case 11:
                AppMethodBeat.o(41467);
                return;
        }
    }

    private static void f(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41468);
        oVar.xFl = Util.getInt(map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
        oVar.xFi.xGg = Util.nullAs(map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
        oVar.xFi.mDesc = Util.nullAs(map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
        AppMethodBeat.o(41468);
    }

    private static void g(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41469);
        oVar.mAppName = Util.nullAs(map.get(".sysmsg.gamecenter.appinfo.appname2"), "");
        if (Util.isNullOrNil(oVar.mAppName)) {
            oVar.mAppName = Util.nullAs(map.get(".sysmsg.gamecenter.appinfo.appname"), "");
        }
        if (oVar.field_msgType == 6) {
            oVar.xFc = Util.nullAs(map.get(".sysmsg.gamecenter.appinfo.groupname"), "");
            oVar.xFd = Util.nullAs(map.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
        } else {
            oVar.xFc = oVar.mAppName;
        }
        oVar.xEY = Util.nullAs(map.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
        oVar.xEZ = Util.nullAs(map.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
        oVar.xFa = Util.nullAs(map.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
        oVar.xFb = Util.getInt(map.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
        AppMethodBeat.o(41469);
    }

    private static void h(Map<String, String> map, o oVar) {
        String str;
        AppMethodBeat.i(41470);
        oVar.xFe.clear();
        int i2 = 0;
        while (true) {
            if (i2 == 0) {
                str = ".sysmsg.gamecenter.userinfo";
            } else {
                str = ".sysmsg.gamecenter.userinfo" + i2;
            }
            if (map.containsKey(str)) {
                o.k kVar = new o.k();
                kVar.userName = Util.nullAs(map.get(str + ".username"), "");
                kVar.nickName = Util.nullAs(map.get(str + ".nickname"), "");
                kVar.xGp = Util.nullAs(map.get(str + ".usericon"), "");
                kVar.xGr = Util.nullAs(map.get(str + ".badge_icon"), "");
                kVar.xGs = Util.nullAs(map.get(str + ".$jump_id"), "");
                oVar.xFe.add(kVar);
                i2++;
            } else {
                AppMethodBeat.o(41470);
                return;
            }
        }
    }

    private static void i(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41471);
        oVar.xFW = Util.nullAs(map.get(".sysmsg.gamecenter.noticeid"), "");
        AppMethodBeat.o(41471);
    }

    public static long am(Map<String, String> map) {
        AppMethodBeat.i(41472);
        long j2 = Util.getLong(map.get(".sysmsg.game_control_info.control_flag"), 0);
        AppMethodBeat.o(41472);
        return j2;
    }

    private static void j(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41473);
        oVar.xFt = am(map);
        AppMethodBeat.o(41473);
    }

    private static void k(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41474);
        oVar.xFg.xGi = Util.getInt(map.get(".sysmsg.gamecenter.badge_display_type"), 0);
        oVar.xFg.xGg = Util.nullAs(map.get(".sysmsg.gamecenter.showiconurl"), "");
        oVar.xFg.mText = Util.nullAs(map.get(".sysmsg.gamecenter.entrancetext"), "");
        AppMethodBeat.o(41474);
    }

    private static void l(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41475);
        oVar.xFm = Util.getInt(map.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
        oVar.xFn = Util.getInt(map.get(".sysmsg.game_control_info.display_name_type"), 1);
        oVar.xFo = Util.nullAs(map.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
        oVar.xFp = Util.nullAs(map.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
        oVar.xFq = Util.nullAs(map.get(".sysmsg.gameshare.share_message_info.media_url"), "");
        oVar.xFk = Util.nullAs(map.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
        AppMethodBeat.o(41475);
    }

    public static void m(Map<String, String> map, o oVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(41476);
        oVar.xFw.url = Util.nullAs(map.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
        o.a aVar = oVar.xFw;
        if (Util.getInt(map.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.xvW = z;
        oVar.xFw.orientation = Util.getInt(map.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
        o.a aVar2 = oVar.xFw;
        if (Util.getInt(map.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar2.crp = z2;
        AppMethodBeat.o(41476);
    }

    private static void n(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41477);
        oVar.xFB = Util.nullAs(map.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
        oVar.xFC = Util.nullAs(map.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
        oVar.xFD = Util.nullAs(map.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
        AppMethodBeat.o(41477);
    }

    private static void o(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41478);
        oVar.xFx = Util.nullAs(map.get(".sysmsg.gamecenter.topic.reply_content"), "");
        oVar.xFy = Util.nullAs(map.get(".sysmsg.gamecenter.topic.replied_content"), "");
        oVar.xFA = Util.nullAs(map.get(".sysmsg.gamecenter.topic.topic_title"), "");
        oVar.xFz = Util.nullAs(map.get(".sysmsg.gamecenter.topic.topic_url"), "");
        AppMethodBeat.o(41478);
    }

    private static void p(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41479);
        oVar.xFZ = Util.getInt(map.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
        oVar.xGa = Util.nullAs(map.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
        AppMethodBeat.o(41479);
    }
}
