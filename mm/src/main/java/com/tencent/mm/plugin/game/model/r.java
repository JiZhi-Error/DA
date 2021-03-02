package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class r {
    public static boolean c(o oVar) {
        AppMethodBeat.i(41480);
        String nullAsNil = Util.nullAsNil(oVar.field_gameMsgId);
        String nullAsNil2 = Util.nullAsNil((String) g.aAh().azQ().get(ar.a.USERINFO_GAME_FUNCTION_MSG_DELETED_STRING, ""));
        Log.i("MicroMsg.GameMessageService", "filter msgIds:%s", nullAsNil2);
        try {
            JSONArray jSONArray = new JSONArray(nullAsNil2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (nullAsNil.equals(jSONArray.getString(i2))) {
                    Log.i("MicroMsg.GameMessageService", "filter deleted message. gameMsgId:%s", nullAsNil);
                    AppMethodBeat.o(41480);
                    return true;
                }
            }
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(41480);
        return false;
    }

    public static void d(o oVar) {
        AppMethodBeat.i(183859);
        if (!oVar.xFf) {
            g.aAh().azQ().set(ar.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L);
        } else if (!c.aAN(oVar.xFQ.xGN)) {
            g.aAh().azQ().set(ar.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(oVar.field_msgId));
            AppMethodBeat.o(183859);
            return;
        }
        AppMethodBeat.o(183859);
    }

    public static void e(o oVar) {
        AppMethodBeat.i(183860);
        if (!Util.isNullOrNil(oVar.xFw.url)) {
            g.aAh().azQ().set(ar.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(oVar.field_msgId));
            AppMethodBeat.o(183860);
            return;
        }
        dVr();
        AppMethodBeat.o(183860);
    }

    public static void f(o oVar) {
        AppMethodBeat.i(183861);
        if (oVar.xFh) {
            g.aAh().azQ().set(ar.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(oVar.field_msgId));
            AppMethodBeat.o(183861);
            return;
        }
        dVt();
        AppMethodBeat.o(183861);
    }

    public static void g(o oVar) {
        AppMethodBeat.i(183862);
        if (!Util.isNullOrNil(oVar.xFN.xGf)) {
            g.aAh().azQ().set(ar.a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(oVar.field_msgId));
            AppMethodBeat.o(183862);
            return;
        }
        dVv();
        AppMethodBeat.o(183862);
    }

    public static o dVm() {
        AppMethodBeat.i(183863);
        o dVn = dVn();
        if (dVn == null) {
            dVn = dVq();
        }
        if (dVn == null) {
            dVn = dVs();
        }
        if (dVn == null) {
            dVn = dVu();
        }
        if (dVn != null) {
            dVn.dVl();
        }
        AppMethodBeat.o(183863);
        return dVn;
    }

    public static boolean h(o oVar) {
        AppMethodBeat.i(204167);
        List<g.a> dVg = g.dVg();
        long nowSecond = Util.nowSecond();
        for (g.a aVar : dVg) {
            if (aVar.startTime <= nowSecond && aVar.endTime >= nowSecond) {
                if (oVar.xFg.xGk == aVar.xEF || aVar.xEG.contains(oVar.field_gameMsgId)) {
                    AppMethodBeat.o(204167);
                    return true;
                }
            }
        }
        AppMethodBeat.o(204167);
        return false;
    }

    public static o dVn() {
        o oVar;
        AppMethodBeat.i(41481);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        if (longValue != 0) {
            oVar = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        } else {
            oVar = null;
        }
        if (oVar == null || oVar.field_isHidden || i(oVar)) {
            a.aAy("");
            AppMethodBeat.o(41481);
            return null;
        }
        AppMethodBeat.o(41481);
        return oVar;
    }

    public static void dVo() {
        AppMethodBeat.i(41482);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        o oVar = null;
        if (longValue != 0) {
            oVar = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        }
        if (oVar == null || oVar.field_isHidden) {
            AppMethodBeat.o(41482);
            return;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L);
        AppMethodBeat.o(41482);
    }

    public static o dVp() {
        AppMethodBeat.i(41483);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        o oVar = null;
        if (longValue != 0) {
            oVar = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        }
        AppMethodBeat.o(41483);
        return oVar;
    }

    public static o dVq() {
        AppMethodBeat.i(41484);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        if (longValue == 0) {
            AppMethodBeat.o(41484);
            return null;
        }
        o GJ = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        if (GJ == null || GJ.field_isHidden || i(GJ)) {
            AppMethodBeat.o(41484);
            return null;
        }
        AppMethodBeat.o(41484);
        return GJ;
    }

    public static void dVr() {
        AppMethodBeat.i(41485);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        o oVar = null;
        if (longValue != 0) {
            oVar = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        }
        if (oVar == null || oVar.field_isHidden) {
            AppMethodBeat.o(41485);
            return;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, (Object) 0L);
        AppMethodBeat.o(41485);
    }

    public static o dVs() {
        AppMethodBeat.i(41486);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        if (longValue == 0) {
            AppMethodBeat.o(41486);
            return null;
        }
        o GJ = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        if (GJ == null || GJ.field_isHidden || i(GJ)) {
            AppMethodBeat.o(41486);
            return null;
        }
        AppMethodBeat.o(41486);
        return GJ;
    }

    public static void dVt() {
        AppMethodBeat.i(41487);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        o oVar = null;
        if (longValue != 0) {
            oVar = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        }
        if (oVar == null || oVar.field_isHidden) {
            AppMethodBeat.o(41487);
            return;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, (Object) 0L);
        AppMethodBeat.o(41487);
    }

    private static o dVu() {
        AppMethodBeat.i(41488);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        if (longValue == 0) {
            AppMethodBeat.o(41488);
            return null;
        }
        o GJ = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        if (GJ == null || GJ.field_isHidden || i(GJ)) {
            AppMethodBeat.o(41488);
            return null;
        }
        AppMethodBeat.o(41488);
        return GJ;
    }

    public static void dVv() {
        AppMethodBeat.i(41489);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, (Object) 0L)).longValue();
        o oVar = null;
        if (longValue != 0) {
            oVar = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().GJ(longValue);
        }
        if (oVar == null || oVar.field_isHidden) {
            AppMethodBeat.o(41489);
            return;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, (Object) 0L);
        AppMethodBeat.o(41489);
    }

    private static boolean i(o oVar) {
        AppMethodBeat.i(41490);
        if (oVar.field_expireTime < System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(41490);
            return true;
        }
        AppMethodBeat.o(41490);
        return false;
    }

    public static void j(o oVar) {
        o oVar2;
        LinkedList<o> linkedList;
        int i2 = 1;
        AppMethodBeat.i(41491);
        if (oVar.field_showType != 0) {
            if (oVar.xFQ.xGI > 1 && !Util.isNullOrNil(oVar.xFQ.xGH)) {
                LinkedList linkedList2 = new LinkedList();
                Cursor rawQuery = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().rawQuery("select * from GameRawMessage where showType=1 and interactiveMergeId= \"" + oVar.field_interactiveMergeId + "\" and isRead=0 order by createTime desc", new String[0]);
                if (rawQuery == null) {
                    linkedList = linkedList2;
                } else {
                    if (rawQuery.moveToFirst()) {
                        do {
                            o oVar3 = new o();
                            oVar3.convertFrom(rawQuery);
                            linkedList2.add(oVar3);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                    linkedList = linkedList2;
                }
                for (o oVar4 : linkedList) {
                    i2 = oVar4.field_hasMergedCount + i2;
                }
                if (i2 >= oVar.xFQ.xGI) {
                    oVar.field_hasMergedCount = i2;
                    for (o oVar5 : linkedList) {
                        ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().delete(oVar5, new String[0]);
                    }
                }
                AppMethodBeat.o(41491);
                return;
            }
        } else if (Util.isNullOrNil(oVar.field_mergerId)) {
            AppMethodBeat.o(41491);
            return;
        } else {
            o oVar6 = new o();
            Cursor rawQuery2 = ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().rawQuery("select * from GameRawMessage where msgType=" + oVar.field_msgType + " and mergerId= \"" + oVar.field_mergerId + "\" order by createTime desc limit 1", new String[0]);
            if (rawQuery2 == null) {
                oVar2 = null;
            } else {
                if (rawQuery2.moveToFirst()) {
                    oVar6.convertFrom(rawQuery2);
                }
                rawQuery2.close();
                oVar2 = oVar6;
            }
            if (oVar2 != null) {
                oVar2.dVl();
                if (!Util.isNullOrNil(oVar2.xFe)) {
                    oVar.dVl();
                    LinkedList linkedList3 = new LinkedList(oVar2.xFe);
                    if (!Util.isNullOrNil(oVar.xFe)) {
                        String str = oVar.xFe.get(0).userName;
                        if (!Util.isNullOrNil(str)) {
                            Iterator<o.k> it = oVar2.xFe.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                o.k next = it.next();
                                if (next.userName.equals(str)) {
                                    linkedList3.remove(next);
                                    break;
                                }
                            }
                        }
                    }
                    if (!Util.isNullOrNil(linkedList3)) {
                        oVar.field_rawXML = ah.a(oVar.field_rawXML, linkedList3, oVar2.xFj);
                    }
                    ((f) com.tencent.mm.kernel.g.af(f.class)).dSK().delete(oVar2, new String[0]);
                }
            }
        }
        AppMethodBeat.o(41491);
    }

    public static boolean k(o oVar) {
        AppMethodBeat.i(183864);
        if (oVar == null) {
            AppMethodBeat.o(183864);
            return false;
        } else if (oVar.xFg.xGl) {
            AppMethodBeat.o(183864);
            return false;
        } else {
            boolean Om = e.Om(oVar.xFg.xGk);
            AppMethodBeat.o(183864);
            return Om;
        }
    }
}
