package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    private String edD;
    private int x;
    private int y;

    public b(int i2, int i3, String str) {
        this.x = i2;
        this.y = i3;
        this.edD = str;
    }

    @Override // com.tencent.mm.plugin.websearch.widget.c.a
    public final String getName() {
        return "onTap";
    }

    @Override // com.tencent.mm.plugin.websearch.widget.c.a
    public final String fYY() {
        AppMethodBeat.i(116656);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", this.x);
            jSONObject.put("y", this.y);
            jSONObject.put("eventId", this.edD);
        } catch (JSONException e2) {
            Log.printErrStackTrace("onTap", e2, "", new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(116656);
        return jSONObject2;
    }
}
