package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.c;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public String cacheKey;
    public Map<String, String> loD;
    public int loE;
    public int loF;
    public String path;
    public String title;

    public b() {
        super("onCanvasInsert");
    }

    b(int i2) {
        super("onCanvasInsert", i2);
    }

    @Override // com.tencent.mm.aa.b.c
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(121392);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("path", this.path);
            jSONObject.put(SearchIntents.EXTRA_QUERY, new JSONObject(this.loD == null ? new HashMap() : this.loD));
            jSONObject.put("cacheKey", this.cacheKey);
            jSONObject.put("width", g.zC(this.loE));
            jSONObject.put("height", g.zC(this.loF));
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(121392);
        return jSONObject;
    }
}
