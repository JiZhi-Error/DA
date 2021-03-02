package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.e.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class m {
    public static boolean i(Activity activity, Intent intent) {
        o oVar;
        JSONException e2;
        JSONObject jSONObject;
        AppMethodBeat.i(204160);
        if (intent == null) {
            AppMethodBeat.o(204160);
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
        boolean booleanExtra2 = intent.getBooleanExtra("has_game_life_chat_msg", false);
        ((e) g.af(e.class)).dSJ();
        o dVm = r.dVm();
        intent.putExtra("from_find_more_friend", true);
        GameTabData2 dWB = GameTabData2.dWB();
        if (dWB == null) {
            AppMethodBeat.o(204160);
            return false;
        }
        boolean z = true;
        Iterator it = dWB.xWX.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            GameTabData2.TabItem tabItem = (GameTabData2.TabItem) entry.getValue();
            if (tabItem != null) {
                if (!Util.isNullOrNil(tabItem.jumpUrl)) {
                    tabItem.jumpUrl = a(tabItem.jumpUrl, dVm, intent, z2);
                    z2 = false;
                }
                dWB.xWX.a((String) entry.getKey(), tabItem);
                if (tabItem.dLS == 1 && booleanExtra2) {
                    dWB.xWY = tabItem.xHB;
                }
            }
            z = z2;
        }
        ((e) g.af(e.class)).dSJ();
        o dVn = r.dVn();
        if (dVn != null && !booleanExtra2) {
            dVn.dVl();
            if (!Util.isNullOrNil(dVn.xFS.xGv) && dWB.xWX.containsKey(dVn.xFS.xGv)) {
                dWB.xWY = dVn.xFS.xGv;
            }
        }
        String stringExtra = intent.getStringExtra("default_game_tab_key");
        if (!Util.isNullOrNil(stringExtra) && dWB.xWX.containsKey(stringExtra)) {
            dWB.xWY = stringExtra;
        }
        s dSK = ((f) g.af(f.class)).dSK();
        String str = "select * from GameRawMessage where redDotExpireTime>" + Util.nowSecond() + " and isRead=0 and isHidden=0 order by redDotExpireTime desc";
        Log.i("MicroMsg.GameMessageStorage", "getTabRedDotMsg sql:%s", str);
        Cursor rawQuery = dSK.rawQuery(str, new String[0]);
        if (rawQuery == null) {
            oVar = null;
        } else {
            oVar = null;
            if (rawQuery.moveToFirst()) {
                do {
                    oVar = new o();
                    oVar.convertFrom(rawQuery);
                    if (dVn == null || oVar.field_msgId != dVn.field_msgId) {
                        break;
                    }
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        if (oVar != null) {
            oVar.dVl();
            intent.putExtra("game_red_dot_tab_key", oVar.xFS.xGw);
            intent.putExtra("game_tab_red_dot_msgid", oVar.field_gameMsgId);
        }
        GameTabData2.TabItem tabItem2 = (GameTabData2.TabItem) dWB.xWX.get(dWB.xWY);
        if (tabItem2 == null) {
            AppMethodBeat.o(204160);
            return false;
        }
        Log.i("MicroMsg.GameEntranceChecker", "defaultKey:%s, tabType:%d, gameTabData:%s", tabItem2.xHB, Integer.valueOf(tabItem2.dLS), dWB.toJson());
        if (booleanExtra) {
            if (dVn != null) {
                dVn.dVl();
                if (dVn.xFV == 107) {
                    intent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
                }
            }
            a(intent, "game_center_entrance", true, dVm, intExtra, tabItem2.jumpUrl);
            intent.putExtra("game_tab_data", dWB);
            intent.putExtra("game_tab_key", dWB.xWY);
            GameTabWidget2.a(activity, tabItem2, true);
            if (booleanExtra2) {
                int intExtra2 = intent.getIntExtra("game_life_msg_count", 0);
                JSONObject jSONObject2 = new JSONObject();
                b dXa = ((c) g.af(c.class)).dXa();
                int i2 = dXa.msgType;
                try {
                    jSONObject = new JSONObject(dXa.xEl);
                    try {
                        jSONObject.put("chatmsg_num", String.valueOf(intExtra2));
                    } catch (JSONException e3) {
                        e2 = e3;
                        Log.printErrStackTrace("MicroMsg.GameEntranceChecker", e2, "", new Object[0]);
                        com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 6, 0, null, 0, i2, null, null, com.tencent.mm.game.report.f.a(null, null, jSONObject.toString(), null));
                        AppMethodBeat.o(204160);
                        return true;
                    }
                } catch (JSONException e4) {
                    e2 = e4;
                    jSONObject = jSONObject2;
                    Log.printErrStackTrace("MicroMsg.GameEntranceChecker", e2, "", new Object[0]);
                    com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 6, 0, null, 0, i2, null, null, com.tencent.mm.game.report.f.a(null, null, jSONObject.toString(), null));
                    AppMethodBeat.o(204160);
                    return true;
                }
                com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 6, 0, null, 0, i2, null, null, com.tencent.mm.game.report.f.a(null, null, jSONObject.toString(), null));
            } else {
                b(7, true, tabItem2.jumpUrl);
                ((e) g.af(e.class)).dSJ();
                r.dVv();
            }
        } else {
            a(intent, "game_center_entrance", false, dVm, intExtra, tabItem2.jumpUrl);
            intent.putExtra("game_tab_data", dWB);
            intent.putExtra("game_tab_key", dWB.xWY);
            GameTabWidget2.a(activity, tabItem2, true);
        }
        AppMethodBeat.o(204160);
        return true;
    }

    public static void a(o oVar, int i2, int i3) {
        AppMethodBeat.i(41437);
        if (oVar == null) {
            ((e) g.af(e.class)).dSJ();
            oVar = r.dVq();
            if (oVar == null) {
                AppMethodBeat.o(41437);
                return;
            }
        }
        oVar.dVl();
        Log.i("MicroMsg.GameEntranceChecker", "float layer report");
        if (!Util.isNullOrNil(oVar.xFw.url)) {
            com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 10, 1006, 1, 1, 0, oVar.field_appId, i2, oVar.xFV, oVar.field_gameMsgId, oVar.xFW, com.tencent.mm.game.report.f.a("resource", String.valueOf(oVar.xFg.xGi), oVar.xFX, null));
            if (i3 == 1) {
                h.INSTANCE.idkeyStat(858, 16, 1, false);
            } else if (i3 == 2) {
                h.INSTANCE.idkeyStat(858, 17, 1, false);
            }
            oVar.field_isRead = true;
            ((f) g.af(f.class)).dSK().update(oVar, new String[0]);
        }
        ((e) g.af(e.class)).dSJ();
        r.dVr();
        AppMethodBeat.o(41437);
    }

    public static void a(Context context, Intent intent, String str, boolean z, o oVar, int i2) {
        AppMethodBeat.i(41438);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("game_check_float", z);
        if (z && oVar != null) {
            oVar.dVl();
            if (oVar.xFw.crp) {
                intent.putExtra("game_transparent_float_url", oVar.xFw.url);
            }
            intent.putExtra("game_sourceScene", i2);
            intent.putExtra("game_float_layer_url", oVar.xFw.url);
        }
        com.tencent.mm.plugin.game.e.c.w(intent, context);
        AppMethodBeat.o(41438);
    }

    public static void a(Intent intent, String str, boolean z, o oVar, int i2, String str2) {
        AppMethodBeat.i(204161);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("game_check_float", z);
        if (z && oVar != null) {
            oVar.dVl();
            if (oVar.xFw != null && !Util.isNullOrNil(oVar.xFw.url)) {
                GameFloatLayerInfo gameFloatLayerInfo = new GameFloatLayerInfo();
                gameFloatLayerInfo.url = hL(str2, oVar.xFw.url);
                gameFloatLayerInfo.xvW = oVar.xFw.xvW;
                int i3 = -1;
                switch (oVar.xFw.orientation) {
                    case 1:
                    case 3:
                        i3 = 0;
                        break;
                    case 2:
                    case 4:
                        i3 = 1;
                        break;
                }
                gameFloatLayerInfo.orientation = i3;
                GameWebViewLaunchParams gameWebViewLaunchParams = new GameWebViewLaunchParams();
                gameWebViewLaunchParams.xvZ = gameFloatLayerInfo;
                intent.putExtra("launchParams", gameWebViewLaunchParams);
                intent.putExtra("game_float_layer_url", oVar.xFw.url);
            }
        }
        a(oVar, i2, 1);
        AppMethodBeat.o(204161);
    }

    private static String hL(String str, String str2) {
        AppMethodBeat.i(41440);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(41440);
            return str2;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("nav_color");
        if (Util.isNullOrNil(queryParameter)) {
            AppMethodBeat.o(41440);
            return str2;
        }
        String hM = hM(str2, "nav_color=".concat(String.valueOf(queryParameter)));
        AppMethodBeat.o(41440);
        return hM;
    }

    public static String a(String str, o oVar, Intent intent, boolean z) {
        AppMethodBeat.i(204162);
        if (oVar != null) {
            oVar.dVl();
            if (intent != null && !intent.hasExtra("game_pre_inject_data")) {
                intent.putExtra("game_pre_inject_data", oVar.xFT.xGd);
            }
            if (!Util.isNullOrNil(oVar.xFw.url)) {
                if (z) {
                    fa(oVar.xFw.xGc);
                }
                str = hM(str, "h5FloatLayer=1");
                Log.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", str);
            }
            if (!Util.isNullOrNil(oVar.xFN.xGf)) {
                if (z) {
                    fa(oVar.xFN.xGc);
                }
                try {
                    str = hM(str, "h5BannerId=" + q.encode(oVar.xFN.xGf, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e2) {
                }
                Log.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", str);
            }
            if (!Util.isNullOrNil(oVar.xFi.mDesc) && !Util.isNullOrNil(oVar.xFi.xGg) && !Util.isNullOrNil(oVar.xFi.xGh)) {
                str = hM(str, "hasBubble=1");
            }
            str = hM(str, "gameMsgId=" + oVar.field_gameMsgId);
            if (!Util.isNullOrNil(oVar.xFY)) {
                try {
                    str = hM(str, "business_data=" + URLEncoder.encode(oVar.xFY, ProtocolPackage.ServerEncoding));
                } catch (UnsupportedEncodingException e3) {
                }
            }
        }
        AppMethodBeat.o(204162);
        return str;
    }

    private static void fa(List list) {
        AppMethodBeat.i(41442);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(41442);
            return;
        }
        aaz aaz = new aaz();
        aaz.eif.dDe = 8;
        aaz.eif.scene = 1;
        aaz.eif.eil = list;
        EventCenter.instance.publish(aaz);
        AppMethodBeat.o(41442);
    }

    private static String hM(String str, String str2) {
        String str3;
        AppMethodBeat.i(41443);
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        if (query != null) {
            str3 = query + "&" + str2;
        } else {
            str3 = str2;
        }
        try {
            str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str3, parse.getFragment()).toString();
        } catch (URISyntaxException e2) {
            Log.printErrStackTrace("MicroMsg.GameEntranceChecker", e2, "", new Object[0]);
        }
        AppMethodBeat.o(41443);
        return str;
    }

    public static void b(int i2, boolean z, String str) {
        AppMethodBeat.i(183858);
        ((e) g.af(e.class)).dSJ();
        o dVn = r.dVn();
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("luggage", "1");
        }
        if (str != null) {
            hashMap.put("entrance_url", str);
        }
        if (dVn == null) {
            hashMap.put("function_type", "resource");
            hashMap.put("function_value", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, i2, 0, a.u(hashMap));
            AppMethodBeat.o(183858);
            return;
        }
        dVn.dVl();
        com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, i2, 0, dVn.field_appId, 0, dVn.xFV, dVn.field_gameMsgId, dVn.xFW, com.tencent.mm.game.report.f.a("resource", String.valueOf(dVn.xFg.xGi), dVn.xFX, hashMap));
        ((e) g.af(e.class)).dSJ();
        r.dVo();
        h.INSTANCE.idkeyStat(858, 3, 1, false);
        AppMethodBeat.o(183858);
    }
}
