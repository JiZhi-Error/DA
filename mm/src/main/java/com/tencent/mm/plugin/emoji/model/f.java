package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private dp rbq = new dp();
    public final Map<String, Integer> rbr = new HashMap();

    public f() {
        AppMethodBeat.i(108585);
        AppMethodBeat.o(108585);
    }

    public final void h(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(108586);
        this.rbq.dGC.productId = str;
        this.rbq.dGC.status = i2;
        this.rbq.dGC.progress = i3;
        this.rbq.dGC.dGD = str2;
        EventCenter.instance.publish(this.rbq);
        if (i2 != 6) {
            this.rbr.remove(str);
            AppMethodBeat.o(108586);
        } else if (i3 < 0 || i3 >= 100) {
            this.rbr.remove(str);
            AppMethodBeat.o(108586);
        } else {
            this.rbr.put(str, Integer.valueOf(i3));
            AppMethodBeat.o(108586);
        }
    }
}
