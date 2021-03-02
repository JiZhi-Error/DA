package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class i {
    String csx;
    private JSONObject csy;

    i(m mVar) {
        AppMethodBeat.i(140324);
        JSONObject KX = mVar.KX();
        this.csx = KX.getString("event");
        this.csy = KX.optJSONObject("data");
        if (this.csy == null) {
            this.csy = new JSONObject();
        }
        AppMethodBeat.o(140324);
    }
}
