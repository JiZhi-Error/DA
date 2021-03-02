package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public Map<String, Object> pQY = new HashMap();
    public CardInfo pQy = null;

    public e() {
        AppMethodBeat.i(112615);
        this.pQY.clear();
        AppMethodBeat.o(112615);
    }

    public final void putValue(String str, Object obj) {
        AppMethodBeat.i(112616);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112616);
            return;
        }
        this.pQY.put(str, obj);
        AppMethodBeat.o(112616);
    }

    public final Object getValue(String str) {
        AppMethodBeat.i(112617);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112617);
            return null;
        } else if (this.pQY.containsKey(str)) {
            Object obj = this.pQY.get(str);
            AppMethodBeat.o(112617);
            return obj;
        } else {
            AppMethodBeat.o(112617);
            return null;
        }
    }
}
