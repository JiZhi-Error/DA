package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t {
    public static void a(iw iwVar) {
        AppMethodBeat.i(41500);
        String str = iwVar.dNy.param;
        Log.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", str);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("type") || Util.getInt(jSONObject.optString("type"), 0) == 0) {
                    new JSONArray();
                    JSONArray jSONArray = jSONObject.getJSONArray("localIdList");
                    int length = jSONArray.length();
                    long[] jArr = new long[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        jArr[i2] = jSONArray.getLong(i2);
                    }
                    ((f) g.af(f.class)).dSK().c(jArr);
                    AppMethodBeat.o(41500);
                } else if (Util.getInt(jSONObject.optString("type"), 0) == 65536) {
                    ((f) g.af(f.class)).dSK().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
                    AppMethodBeat.o(41500);
                } else {
                    AppMethodBeat.o(41500);
                }
            } catch (JSONException e2) {
                Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e2.getMessage());
                AppMethodBeat.o(41500);
            }
        } else {
            AppMethodBeat.o(41500);
        }
    }

    public static void b(iw iwVar) {
        AppMethodBeat.i(204172);
        String str = iwVar.dNy.param;
        Log.d("MicroMsg.GameJsapiProcessor", "deleteMessage param=%s", str);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("deleteAll", false)) {
                    ((f) g.af(f.class)).dSK().dVA();
                    AppMethodBeat.o(204172);
                    return;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("localIdList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    long[] jArr = new long[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        jArr[i2] = optJSONArray.getLong(i2);
                    }
                    ((f) g.af(f.class)).dSK().d(jArr);
                }
                AppMethodBeat.o(204172);
            } catch (JSONException e2) {
                Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e2.getMessage());
                AppMethodBeat.o(204172);
            }
        } else {
            AppMethodBeat.o(204172);
        }
    }

    public static void c(iw iwVar) {
        o aAk;
        AppMethodBeat.i(204173);
        String str = iwVar.dNy.param;
        if (str != null) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("msgIdList");
                if (optJSONArray != null) {
                    JSONObject jSONObject = new JSONObject();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String string = optJSONArray.getString(i2);
                        if (!Util.isNullOrNil(string) && (aAk = ((f) g.af(f.class)).dSK().aAk(string)) != null) {
                            aAk.dVl();
                            jSONObject.put(string, c.aAN(aAk.xFQ.xGN));
                        }
                    }
                    iwVar.dNz.dNA = jSONObject.toString();
                }
                AppMethodBeat.o(204173);
            } catch (JSONException e2) {
                Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e2.getMessage());
                AppMethodBeat.o(204173);
            }
        } else {
            AppMethodBeat.o(204173);
        }
    }
}
