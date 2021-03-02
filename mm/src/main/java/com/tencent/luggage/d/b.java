package com.tencent.luggage.d;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public abstract class b<CONTEXT extends c> {
    CONTEXT csZ;

    public abstract void a(b<CONTEXT>.a aVar);

    public abstract String name();

    public class a {
        public CONTEXT cta;
        public k ctb;

        public a() {
        }

        public final void e(String str, Map<String, Object> map) {
            AppMethodBeat.i(140369);
            k kVar = this.ctb;
            if (str == null) {
                str = "";
            }
            kVar.csB = str;
            kVar.csC = map != null ? new JSONObject(map) : null;
            if (kVar.csv != 0) {
                kVar.callback();
            }
            AppMethodBeat.o(140369);
        }

        public final void c(String str, JSONObject jSONObject) {
            AppMethodBeat.i(140370);
            this.ctb.c(str, jSONObject);
            AppMethodBeat.o(140370);
        }
    }
}
