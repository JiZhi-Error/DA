package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class RenderContextParams {
    private HashMap<String, Object> params = new HashMap<>();

    public RenderContextParams() {
        AppMethodBeat.i(218280);
        AppMethodBeat.o(218280);
    }

    public void putParam(String str, Object obj) {
        AppMethodBeat.i(218281);
        this.params.put(str, obj);
        AppMethodBeat.o(218281);
    }

    public Object getParam(String str) {
        AppMethodBeat.i(218282);
        Object obj = this.params.get(str);
        AppMethodBeat.o(218282);
        return obj;
    }
}
