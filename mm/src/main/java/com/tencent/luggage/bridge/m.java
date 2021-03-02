package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class m extends a {
    m(JSONObject jSONObject) {
        AppMethodBeat.i(140329);
        this.csh = b.valueOf(jSONObject.getString("type"));
        this.csi = jSONObject.optJSONObject("data");
        if (this.csi == null) {
            this.csi = new JSONObject();
        }
        AppMethodBeat.o(140329);
    }
}
