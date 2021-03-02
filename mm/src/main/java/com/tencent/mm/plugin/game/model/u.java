package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class u {
    public static u xGT;

    public static u dVC() {
        AppMethodBeat.i(41503);
        if (xGT == null) {
            xGT = new u();
        }
        u uVar = xGT;
        AppMethodBeat.o(41503);
        return uVar;
    }

    public static void a(o oVar) {
        AppMethodBeat.i(41504);
        if (Util.isNullOrNil(oVar.field_rawXML)) {
            Log.e("MicroMsg.GameNewMessageParser", "msg content is null");
            AppMethodBeat.o(41504);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(oVar.field_rawXML, "sysmsg", null);
        if (parseXml == null || parseXml.size() == 0) {
            Log.e("MicroMsg.GameNewMessageParser", "Parse failed");
            AppMethodBeat.o(41504);
        } else if (!"gamecenter".equalsIgnoreCase(parseXml.get(".sysmsg.$type"))) {
            Log.e("MicroMsg.GameNewMessageParser", "Type not matched");
            AppMethodBeat.o(41504);
        } else {
            d(parseXml, oVar);
            q(parseXml, oVar);
            s(parseXml, oVar);
            f(parseXml, oVar);
            u(parseXml, oVar);
            k(parseXml, oVar);
            v(parseXml, oVar);
            c(parseXml, oVar);
            w(parseXml, oVar);
            x(parseXml, oVar);
            y(parseXml, oVar);
            z(parseXml, oVar);
            A(parseXml, oVar);
            B(parseXml, oVar);
            AppMethodBeat.o(41504);
        }
    }

    private static void d(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41505);
        oVar.xFE = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
        oVar.xFF = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
        oVar.xFG = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
        oVar.xFK.mContent = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
        oVar.xFK.xGg = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
        oVar.xFK.xGh = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
        oVar.xFH = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
        oVar.xFI = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
        r(map, oVar);
        h(map, oVar);
        t(map, oVar);
        AppMethodBeat.o(41505);
    }

    private static void q(Map<String, String> map, o oVar) {
        String str;
        AppMethodBeat.i(41506);
        oVar.xFj.clear();
        int i2 = 0;
        while (true) {
            if (i2 == 0) {
                str = ".sysmsg.gamecenter.jump_info.jump";
            } else {
                str = ".sysmsg.gamecenter.jump_info.jump" + i2;
            }
            if (map.containsKey(str)) {
                String str2 = map.get(str + ".$id");
                o.g gVar = new o.g();
                gVar.mJumpType = Util.getInt(map.get(str + ".jump_type"), 0);
                gVar.rHJ = Util.nullAs(map.get(str + ".jump_url"), "");
                if (!Util.isNullOrNil(str2)) {
                    oVar.xFj.put(str2, gVar);
                }
                i2++;
            } else {
                AppMethodBeat.o(41506);
                return;
            }
        }
    }

    private static void r(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41507);
        if (map.get(".sysmsg.gamecenter.msg_center.msg_sender") != null) {
            oVar.xFJ = new o.i();
            oVar.xFJ.xGm = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
            oVar.xFJ.xGn = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
            oVar.xFJ.xGo = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
            oVar.xFJ.xGh = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
        }
        AppMethodBeat.o(41507);
    }

    private static void h(Map<String, String> map, o oVar) {
        String str;
        AppMethodBeat.i(41508);
        oVar.xFe.clear();
        int i2 = 0;
        while (true) {
            if (i2 == 0) {
                str = ".sysmsg.gamecenter.msg_center.userinfo";
            } else {
                str = ".sysmsg.gamecenter.msg_center.userinfo" + i2;
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
                AppMethodBeat.o(41508);
                return;
            }
        }
    }

    public static void s(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41509);
        oVar.xFV = Util.getInt(map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        oVar.xFW = Util.nullAs(map.get(".sysmsg.gamecenter.report.noticeid"), "");
        oVar.xFX = Util.nullAs(map.get(".sysmsg.gamecenter.report.ext_data"), "");
        oVar.xFY = Util.nullAs(map.get(".sysmsg.gamecenter.report.business_data"), "");
        AppMethodBeat.o(41509);
    }

    private static void f(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41510);
        oVar.xFi.xGg = Util.nullAs(map.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
        oVar.xFi.mDesc = Util.nullAs(map.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
        oVar.xFi.xGh = Util.nullAs(map.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
        AppMethodBeat.o(41510);
    }

    private static void t(Map<String, String> map, o oVar) {
        boolean z;
        AppMethodBeat.i(41511);
        oVar.xFL.mName = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
        o.j jVar = oVar.xFL;
        if (Util.getInt(map.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        jVar.mClickable = z;
        oVar.xFL.xGh = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
        AppMethodBeat.o(41511);
    }

    public static void u(Map<String, String> map, o oVar) {
        boolean z = true;
        AppMethodBeat.i(41512);
        oVar.xFw.url = Util.nullAs(map.get(".sysmsg.gamecenter.float_layer.open_url"), "");
        oVar.xFw.xvW = Util.getInt(map.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1;
        oVar.xFw.orientation = Util.getInt(map.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
        o.a aVar = oVar.xFw;
        if (Util.getInt(map.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
            z = false;
        }
        aVar.crp = z;
        oVar.xFw.xGc.clear();
        oVar.xFw.xGc.addAll(E(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", map));
        AppMethodBeat.o(41512);
    }

    private static List<String> E(String str, Map<String, String> map) {
        String str2;
        AppMethodBeat.i(41513);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            if (i2 == 0) {
                str2 = str;
            } else {
                str2 = str + i2;
            }
            if (map.containsKey(str2)) {
                i2++;
                String str3 = map.get(str2 + ".$pkg_id");
                if (!Util.isNullOrNil(str3)) {
                    arrayList.add(str3);
                }
            } else {
                AppMethodBeat.o(41513);
                return arrayList;
            }
        }
    }

    public static void k(Map<String, String> map, o oVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(41514);
        oVar.xFg.xGi = Util.getInt(map.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
        oVar.xFg.xGg = Util.nullAs(map.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
        oVar.xFg.mText = Util.nullAs(map.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
        oVar.xFg.mIconWidth = Util.getInt(map.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2;
        oVar.xFg.mIconHeight = Util.getInt(map.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2;
        o.f fVar = oVar.xFg;
        if (Util.getInt(map.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        fVar.xGj = z;
        oVar.xFg.xGk = Util.getInt(map.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
        o.f fVar2 = oVar.xFg;
        if (Util.getInt(map.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
            z2 = false;
        }
        fVar2.xGl = z2;
        AppMethodBeat.o(41514);
    }

    private static void v(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41515);
        oVar.xFM.xGt = Util.nullAs(map.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
        oVar.xFM.pXp = Util.getInt(map.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
        oVar.xFM.xGu = Util.getLong(map.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
        AppMethodBeat.o(41515);
    }

    private static void c(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41516);
        oVar.xFr = Util.getInt(map.get(".sysmsg.gamecenter.wifi_flag"), 0);
        AppMethodBeat.o(41516);
    }

    public static void w(Map<String, String> map, o oVar) {
        AppMethodBeat.i(204174);
        oVar.xFs = Util.getInt(map.get(".sysmsg.gamecenter.device_flag"), 0);
        AppMethodBeat.o(204174);
    }

    public static void x(Map<String, String> map, o oVar) {
        AppMethodBeat.i(41517);
        oVar.xFN.xGf = Util.nullAs(map.get(".sysmsg.gamecenter.banner.$banner_id"), "");
        oVar.xFN.xGc.clear();
        oVar.xFN.xGc.addAll(E(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", map));
        AppMethodBeat.o(41517);
    }

    public static void y(Map<String, String> map, o oVar) {
        AppMethodBeat.i(183868);
        oVar.xFQ.xGy = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
        oVar.xFQ.xGz = Util.getInt(map.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
        oVar.xFQ.xGA = Util.getInt(map.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
        oVar.xFQ.xGB = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
        oVar.xFQ.xGC = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
        oVar.xFQ.xGD = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
        oVar.xFQ.xGE = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
        oVar.xFQ.xGF = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
        oVar.xFQ.xGG = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
        oVar.xFQ.xGH = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
        oVar.xFQ.xGI = Util.getInt(map.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
        oVar.xFQ.xGJ = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
        oVar.xFQ.xGK = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
        oVar.xFQ.xGL = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
        oVar.xFQ.xGM = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
        oVar.xFQ.xGN = Util.nullAs(map.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.related_id"), "");
        AppMethodBeat.o(183868);
    }

    public static void z(Map<String, String> map, o oVar) {
        AppMethodBeat.i(204175);
        oVar.xFR.dWA = Util.getInt(map.get(".sysmsg.gamecenter.gamelife.replace_notice"), 0) == 1;
        if (map.get(".sysmsg.gamecenter.gamelife.chatmsg") != null) {
            oVar.xFR.xGe = true;
            AppMethodBeat.o(204175);
            return;
        }
        oVar.xFR.xGe = false;
        AppMethodBeat.o(204175);
    }

    public static void A(Map<String, String> map, o oVar) {
        AppMethodBeat.i(204176);
        oVar.xFS.xGv = Util.nullAs(map.get(".sysmsg.gamecenter.tab_info.default_key"), "");
        oVar.xFS.xGw = Util.nullAs(map.get(".sysmsg.gamecenter.tab_info.red_dot.key"), "");
        if (!Util.isNullOrNil(oVar.xFS.xGw)) {
            oVar.xFS.xGx = oVar.field_createTime + Util.getLong(map.get(".sysmsg.gamecenter.tab_info.red_dot.expire_time"), 86400);
        }
        AppMethodBeat.o(204176);
    }

    public static void B(Map<String, String> map, o oVar) {
        AppMethodBeat.i(204177);
        oVar.xFT.xGd = f.bvi(Util.nullAs(map.get(".sysmsg.gamecenter.extra_data.preload"), ""));
        if (!Util.isNullOrNil(oVar.xFT.xGd) && oVar.xFT.xGd.getBytes().length > 204800) {
            oVar.xFT.xGd = "";
        }
        AppMethodBeat.o(204177);
    }
}
