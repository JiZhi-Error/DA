package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public int HWi;
    public String HWj;
    public String HWk;
    public String HWl;
    public String HWm;
    public String HWn;

    public static f aVf(String str) {
        AppMethodBeat.i(70237);
        if (!Util.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                f fVar = new f();
                fVar.HWi = jSONObject.optInt("menu_jump_type", -1);
                fVar.HWj = jSONObject.optString("menu_jump_url", "");
                fVar.HWk = jSONObject.optString("menu_username", "");
                fVar.HWl = jSONObject.optString("menu_path", "");
                fVar.HWm = jSONObject.optString("menu_title", "");
                fVar.HWn = jSONObject.optString("menu_icon_url", "");
                Log.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", Integer.valueOf(fVar.HWi), fVar.HWm);
                AppMethodBeat.o(70237);
                return fVar;
            } catch (JSONException e2) {
                Log.printErrStackTrace("BindCardMenu", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(70237);
        return null;
    }
}
