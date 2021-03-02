package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    public static g xEA;

    public static class a {
        public long endTime = 0;
        public long startTime = 0;
        public int xEF = -10;
        public List<String> xEG = new ArrayList();

        public a() {
            AppMethodBeat.i(204151);
            AppMethodBeat.o(204151);
        }

        public final String toJson() {
            AppMethodBeat.i(204152);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("startTime", this.startTime);
                jSONObject.put("endTime", this.endTime);
                jSONObject.put("basicType", this.xEF);
                JSONArray jSONArray = new JSONArray();
                for (String str : this.xEG) {
                    jSONArray.put(str);
                }
                jSONObject.put("msgIdList", jSONArray);
            } catch (JSONException e2) {
            }
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(204152);
            return jSONObject2;
        }

        static a aAj(String str) {
            AppMethodBeat.i(204153);
            a aVar = new a();
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(204153);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    aVar.startTime = jSONObject.optLong("startTime", 0);
                    aVar.endTime = jSONObject.optLong("endTime", 0);
                    aVar.xEF = jSONObject.optInt("basicType", -10);
                    JSONArray optJSONArray = jSONObject.optJSONArray("msgIdList");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            aVar.xEG.add(optJSONArray.optString(i2));
                        }
                    }
                } catch (JSONException e2) {
                }
                AppMethodBeat.o(204153);
            }
            return aVar;
        }
    }

    public static void ak(Map<String, String> map) {
        boolean z = true;
        AppMethodBeat.i(204154);
        if (map.get(".sysmsg.control_command.game_download") != null) {
            if (Util.getInt(map.get(".sysmsg.control_command.game_download.delete_all_download_task"), 0) != 1) {
                z = false;
            }
            String nullAs = Util.nullAs(map.get(".sysmsg.control_command.game_download.delete_download_task.$appid"), "");
            String nullAs2 = Util.nullAs(map.get(".sysmsg.control_command.game_download.delete_download_task.download_url"), "");
            if (z) {
                LinkedList<com.tencent.mm.plugin.downloader.g.a> cBt = d.cBt();
                if (!Util.isNullOrNil(cBt)) {
                    Iterator<com.tencent.mm.plugin.downloader.g.a> it = cBt.iterator();
                    while (it.hasNext()) {
                        f.cBv().Cn(it.next().field_downloadId);
                    }
                }
                AppMethodBeat.o(204154);
                return;
            }
            com.tencent.mm.plugin.downloader.g.a aVar = null;
            if (!Util.isNullOrNil(nullAs)) {
                aVar = d.alb(nullAs);
            } else if (!Util.isNullOrNil(nullAs2)) {
                aVar = d.ale(nullAs2);
            }
            if (aVar != null) {
                f.cBv().Cn(aVar.field_downloadId);
            }
        }
        AppMethodBeat.o(204154);
    }

    public static List<a> dVg() {
        AppMethodBeat.i(204155);
        String nullAsNil = Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GAME_MESSAGE_SETTING_HIDE_CONF_STRING, ""));
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(nullAsNil)) {
            AppMethodBeat.o(204155);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(nullAsNil);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(a.aAj(jSONArray.optString(i2)));
                }
            } catch (JSONException e2) {
            }
            AppMethodBeat.o(204155);
        }
        return arrayList;
    }

    public static void g(List<String> list, boolean z) {
        JSONArray jSONArray;
        o oVar;
        boolean z2;
        int i2;
        AppMethodBeat.i(204156);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(204156);
            return;
        }
        String nullAsNil = Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GAME_FUNCTION_MSG_DELETED_STRING, ""));
        try {
            if (!Util.isNullOrNil(nullAsNil)) {
                jSONArray = new JSONArray(nullAsNil);
            } else {
                jSONArray = new JSONArray();
            }
        } catch (JSONException e2) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GAME_FUNCTION_MSG_DELETED_STRING, "");
            Log.printErrStackTrace("MicroMsg.GameControlCmdParser", e2, "", new Object[0]);
            jSONArray = null;
        }
        if (jSONArray == null) {
            AppMethodBeat.o(204156);
            return;
        }
        for (String str : list) {
            if (jSONArray.length() > 100) {
                jSONArray.remove(0);
            }
            jSONArray.put(str);
            ((e) com.tencent.mm.kernel.g.af(e.class)).dSJ();
            o dVp = r.dVp();
            if (dVp != null && Util.nullAsNil(dVp.field_gameMsgId).equals(str)) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, (Object) 0L);
            }
            o aAk = ((com.tencent.mm.plugin.game.api.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().aAk(str);
            if (aAk == null || !str.equals(aAk.field_gameMsgId)) {
                Log.i("MicroMsg.GameMessageService", "dont have msgId:%s for delete", str);
                o oVar2 = new o();
                oVar2.field_gameMsgId = str;
                oVar = oVar2;
                z2 = false;
            } else {
                ((com.tencent.mm.plugin.game.api.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().delete(aAk, new String[0]);
                oVar = aAk;
                z2 = true;
            }
            if (z2) {
                i2 = 101;
            } else {
                i2 = 102;
            }
            if (z) {
                com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 0, 0, 0, 403, i2, oVar.field_appId, 0, oVar.xFV, oVar.field_gameMsgId, oVar.xFW, com.tencent.mm.game.report.f.a("resource", String.valueOf(oVar.xFg.xGi), oVar.xFX, null));
            }
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_GAME_FUNCTION_MSG_DELETED_STRING, jSONArray.toString());
        Log.i("MicroMsg.GameControlCmdParser", "deleted msg list:%s", jSONArray.toString());
        AppMethodBeat.o(204156);
    }

    public static List<String> D(String str, Map<String, String> map) {
        String str2;
        AppMethodBeat.i(204157);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            if (i2 == 0) {
                str2 = str + ".msg_id";
            } else {
                str2 = str + ".msg_id" + i2;
            }
            if (map.containsKey(str2)) {
                i2++;
                String str3 = map.get(str2);
                if (!Util.isNullOrNil(str3)) {
                    arrayList.add(str3);
                }
            } else {
                AppMethodBeat.o(204157);
                return arrayList;
            }
        }
    }

    public static void a(String str, Map<String, String> map, JSONObject jSONObject) {
        AppMethodBeat.i(204158);
        String concat = ".sysmsg.control_command.auto_run_switch.".concat(String.valueOf(str));
        if (!map.containsKey(concat)) {
            AppMethodBeat.o(204158);
            return;
        }
        try {
            jSONObject.put(str, Util.getInt(map.get(concat), 0));
            AppMethodBeat.o(204158);
        } catch (JSONException e2) {
            AppMethodBeat.o(204158);
        }
    }
}
