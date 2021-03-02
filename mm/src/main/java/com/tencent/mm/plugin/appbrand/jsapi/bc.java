package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bc extends e {
    private f czm;
    private String lzw;
    private Map<String, Object> lzx;
    int lzy;

    public bc h(f fVar) {
        if (fVar != null) {
            this.czm = fVar;
            this.lzy = 0;
        }
        return this;
    }

    public bc b(f fVar, int i2) {
        AppMethodBeat.i(140643);
        h(fVar);
        this.lzy = i2;
        AppMethodBeat.o(140643);
        return this;
    }

    public final bc p(String str, Object obj) {
        AppMethodBeat.i(140644);
        if (this.lzx == null) {
            this.lzx = new HashMap();
        }
        this.lzx.put(str, obj);
        AppMethodBeat.o(140644);
        return this;
    }

    public bc Zh(String str) {
        this.lzw = str;
        return this;
    }

    public bc L(Map<String, Object> map) {
        AppMethodBeat.i(140645);
        if (map == null) {
            AppMethodBeat.o(140645);
        } else {
            e.m(map);
            this.lzx = map;
            AppMethodBeat.o(140645);
        }
        return this;
    }

    public final String getData() {
        AppMethodBeat.i(140646);
        if (this.lzw != null) {
            String str = this.lzw;
            AppMethodBeat.o(140646);
            return str;
        } else if (this.lzx != null) {
            e.m(this.lzx);
            String jSONObject = new JSONObject(this.lzx).toString();
            AppMethodBeat.o(140646);
            return jSONObject;
        } else {
            AppMethodBeat.o(140646);
            return null;
        }
    }

    public void bEo() {
        AppMethodBeat.i(140647);
        a(null);
        AppMethodBeat.o(140647);
    }

    public final void a(o oVar) {
        AppMethodBeat.i(221220);
        if (this.czm == null) {
            AppMethodBeat.o(221220);
            return;
        }
        this.czm.a(this, oVar);
        AppMethodBeat.o(221220);
    }
}
