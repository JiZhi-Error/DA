package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.g;
import com.tencent.mm.m.a;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class o implements h, com.tencent.mm.plugin.messenger.foundation.a.o {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.o
    public final void a(cot cot, ca caVar) {
        AppMethodBeat.i(22375);
        if (g.DQ(caVar.field_talker)) {
            cot.KHq = caVar.fqK;
            if (Util.isNullOrNil(cot.KHq)) {
                cot.KHq = a.C0409a.anC().o(caVar);
                AppMethodBeat.o(22375);
                return;
            }
        } else {
            cot.KHq = caVar.fqK;
        }
        AppMethodBeat.o(22375);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.h
    public final String Z(ca caVar) {
        AppMethodBeat.i(22376);
        if (g.DQ(caVar.field_talker)) {
            String ajw = e.ajw();
            AppMethodBeat.o(22376);
            return ajw;
        }
        String aVW = br.aVW();
        AppMethodBeat.o(22376);
        return aVW;
    }
}
