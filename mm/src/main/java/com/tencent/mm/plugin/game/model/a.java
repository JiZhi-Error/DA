package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.c;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String TAG = "MicroMsg.GameABTestStrategy";

    /* renamed from: com.tencent.mm.plugin.game.model.a$a  reason: collision with other inner class name */
    public static class C1403a {
        public int cSx = 0;
        public String url = "";
    }

    public static C1403a dUL() {
        AppMethodBeat.i(41346);
        C1403a aVar = new C1403a();
        c Fu = d.aXu().Fu("100001");
        if (!Fu.isValid()) {
            Log.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(Fu.field_startTime), Long.valueOf(Fu.field_endTime));
            AppMethodBeat.o(41346);
            return aVar;
        }
        Map<String, String> gzz = Fu.gzz();
        aVar.cSx = Util.getInt(gzz.get("game_homepage_jump"), 0);
        String str = gzz.get("game_homepage_url");
        if (str == null) {
            str = "";
        }
        aVar.url = str;
        a(Fu, 901, aVar.url, aVar.cSx);
        Log.i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", Fu.field_layerId, Fu.field_expId, Integer.valueOf(aVar.cSx), aVar.url);
        AppMethodBeat.o(41346);
        return aVar;
    }

    public static C1403a ei(String str, int i2) {
        AppMethodBeat.i(41347);
        C1403a aVar = new C1403a();
        if (Util.isNullOrNil(str)) {
            Log.e(TAG, "appid is null");
            AppMethodBeat.o(41347);
            return aVar;
        }
        c Fu = d.aXu().Fu("100002");
        if (!Fu.isValid()) {
            Log.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(Fu.field_startTime), Long.valueOf(Fu.field_endTime));
            AppMethodBeat.o(41347);
            return aVar;
        }
        Log.i(TAG, "getDetailABTestInfo success, layerId = %s", Fu.field_layerId);
        Map<String, String> gzz = Fu.gzz();
        aVar.cSx = Util.getInt(gzz.get("game_detail_jump"), 0);
        String str2 = gzz.get("game_detail_url");
        aVar.url = str2 == null ? "" : str2 + str;
        a(Fu, i2, aVar.url, aVar.cSx);
        AppMethodBeat.o(41347);
        return aVar;
    }

    public static C1403a dUM() {
        AppMethodBeat.i(41348);
        C1403a aVar = new C1403a();
        c Fu = d.aXu().Fu("100003");
        if (!Fu.isValid()) {
            Log.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(Fu.field_startTime), Long.valueOf(Fu.field_endTime));
            AppMethodBeat.o(41348);
            return aVar;
        }
        Log.i(TAG, "getLibraryABTestInfo success, layerId = %s", Fu.field_layerId);
        Map<String, String> gzz = Fu.gzz();
        aVar.cSx = Util.getInt(gzz.get("game_library_jump"), 0);
        String str = gzz.get("game_library_url");
        if (str == null) {
            str = "";
        }
        aVar.url = str;
        a(Fu, 1005, aVar.url, aVar.cSx);
        AppMethodBeat.o(41348);
        return aVar;
    }

    public static C1403a dUN() {
        AppMethodBeat.i(41349);
        C1403a aVar = new C1403a();
        c Fu = d.aXu().Fu("100022");
        if (!Fu.isValid()) {
            AppMethodBeat.o(41349);
            return aVar;
        }
        Map<String, String> gzz = Fu.gzz();
        aVar.cSx = Util.getInt(gzz.get("game_message_jump"), 0);
        String str = gzz.get("game_message_url");
        if (str == null) {
            str = "";
        }
        aVar.url = str;
        a(Fu, 1001, aVar.url, aVar.cSx);
        AppMethodBeat.o(41349);
        return aVar;
    }

    private static void a(c cVar, int i2, String str, int i3) {
        AppMethodBeat.i(41350);
        if (cVar == null) {
            Log.i(TAG, "ABTestItem is null");
            AppMethodBeat.o(41350);
            return;
        }
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            if (!Util.isNullOrNil(str)) {
                jSONObject.put("url", str);
            }
            jSONObject.put("jumpType", i3);
            str2 = q.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException | JSONException e2) {
        }
        Log.i(TAG, "reportABTest : " + cVar.field_layerId + " , " + cVar.field_business + " , " + cVar.field_expId + " , " + cVar.field_sequence + " , " + cVar.field_prioritylevel + " , " + cVar.field_startTime + " , " + cVar.field_endTime + " , " + i2 + " , " + str2);
        h.INSTANCE.a(14841, cVar.field_layerId, cVar.field_business, cVar.field_expId, Long.valueOf(cVar.field_sequence), Integer.valueOf(cVar.field_prioritylevel), Long.valueOf(cVar.field_startTime), Long.valueOf(cVar.field_endTime), Integer.valueOf(i2), str2);
        AppMethodBeat.o(41350);
    }
}
