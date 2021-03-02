package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public List<String> AZp = new ArrayList();

    public d() {
        AppMethodBeat.i(66885);
        amZ();
        AppMethodBeat.o(66885);
    }

    private void amZ() {
        AppMethodBeat.i(66886);
        this.AZp.clear();
        g.aAi();
        String str = (String) g.aAh().azQ().get(270340, "");
        Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(str)));
        for (String str2 : Util.stringsToList(str.split(";"))) {
            if (!Util.isNullOrNil(str2)) {
                this.AZp.add(str2);
            }
        }
        AppMethodBeat.o(66886);
    }

    public final boolean eDw() {
        AppMethodBeat.i(66887);
        Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.AZp.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.AZp) {
            if (!Util.isNullOrNil(str) && !str.contains(";")) {
                stringBuffer.append(str);
            }
        }
        Log.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.aAi();
        g.aAh().azQ().set(270340, stringBuffer.toString());
        AppMethodBeat.o(66887);
        return true;
    }
}
