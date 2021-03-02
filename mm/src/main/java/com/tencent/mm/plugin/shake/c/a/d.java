package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d {
    int Dhr = 0;
    long Dhs = 0;
    String Dht = "";
    public float gmu = -85.0f;
    public float gmv = -1000.0f;
    Map<String, Object> pQY = new HashMap();

    public d() {
        AppMethodBeat.i(28188);
        this.pQY.clear();
        AppMethodBeat.o(28188);
    }

    public final void putValue(String str, Object obj) {
        AppMethodBeat.i(28189);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(28189);
            return;
        }
        this.pQY.put(str, obj);
        AppMethodBeat.o(28189);
    }
}
