package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class k implements o {
    private String pfa = null;

    public k(String str) {
        this.pfa = str;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.o
    public final void a(cot cot, ca caVar) {
        AppMethodBeat.i(22365);
        StringBuilder sb = new StringBuilder();
        sb.append("<msgsource>");
        sb.append("<strangerantispamticket ticket=\"" + this.pfa + "\"></strangerantispamticket>");
        sb.append(Util.nullAsNil(br.aVV()));
        cot.KHq = (Util.isNullOrNil(cot.KHq) || !cot.KHq.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : cot.KHq;
        cot.KHq = cot.KHq.replace("<msgsource>", sb.toString());
        AppMethodBeat.o(22365);
    }
}
