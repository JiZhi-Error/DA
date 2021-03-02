package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class e extends a {
    protected e(b bVar) {
        AppMethodBeat.i(140317);
        this.csh = bVar;
        this.csi = new JSONObject();
        AppMethodBeat.o(140317);
    }

    /* access modifiers changed from: package-private */
    public final void b(JSONObject jSONObject) {
        this.csi = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void l(Map<String, Object> map) {
        AppMethodBeat.i(140318);
        this.csi = new JSONObject(map);
        AppMethodBeat.o(140318);
    }
}
