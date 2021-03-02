package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public HashSet<String> ANV = new HashSet<>();

    public b() {
        AppMethodBeat.i(66658);
        and();
        AppMethodBeat.o(66658);
    }

    private void and() {
        AppMethodBeat.i(66659);
        this.ANV.clear();
        g.aAi();
        for (String str : Util.stringsToList(((String) g.aAh().azQ().get(204803, "")).split(";"))) {
            if (!Util.isNullOrNil(str) && !this.ANV.contains(str)) {
                this.ANV.add(str);
            }
        }
        g.aAi();
        g.aAh().azQ().set(204817, Integer.valueOf(this.ANV.size()));
        Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.ANV.size());
        AppMethodBeat.o(66659);
    }

    public final void Yy() {
        AppMethodBeat.i(66660);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = this.ANV.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!Util.isNullOrNil(next)) {
                stringBuffer.append(next + ";");
            }
        }
        g.aAi();
        g.aAh().azQ().set(204803, stringBuffer.toString());
        AppMethodBeat.o(66660);
    }
}
