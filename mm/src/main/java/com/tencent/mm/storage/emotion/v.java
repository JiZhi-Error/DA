package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class v {
    public int OsQ;
    public long hwQ;
    public String key;

    public final JSONObject toJson() {
        AppMethodBeat.i(105153);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.key);
            jSONObject.put("use_count", this.OsQ);
            jSONObject.put("last_time", this.hwQ);
            AppMethodBeat.o(105153);
            return jSONObject;
        } catch (JSONException e2) {
            AppMethodBeat.o(105153);
            return null;
        }
    }
}
