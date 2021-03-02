package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.HashMap;
import java.util.Map;

public final class c implements a {
    private String appId;
    private String hes;
    private String kZe;
    private Map<String, Integer> lpp = new HashMap();

    public c(String str, String str2) {
        AppMethodBeat.i(121458);
        this.appId = str;
        this.hes = str2;
        this.kZe = this.hes + "-" + this.appId;
        AppMethodBeat.o(121458);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.i.a
    public final void YD(String str) {
        AppMethodBeat.i(121459);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121459);
            return;
        }
        Integer num = this.lpp.get(str);
        if (num == null) {
            num = 0;
        }
        this.lpp.put(str, Integer.valueOf(num.intValue() + 1));
        AppMethodBeat.o(121459);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.i.a
    public final void report() {
        AppMethodBeat.i(121460);
        for (Map.Entry<String, Integer> entry : this.lpp.entrySet()) {
            h.INSTANCE.a(14705, entry.getKey(), entry.getValue(), this.kZe, this.hes, this.appId);
        }
        this.lpp.clear();
        AppMethodBeat.o(121460);
    }
}
