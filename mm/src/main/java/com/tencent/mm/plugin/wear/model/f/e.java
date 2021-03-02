package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.eym;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class e extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30125);
        int size = ((l) g.af(l.class)).eiy().eiK().size();
        eym eym = new eym();
        eym.xNF = a.fVK().aWj(z.aTY()).id;
        eym.Title = MMApplicationContext.getContext().getString(R.string.wx);
        eym.iAc = MMApplicationContext.getContext().getString(R.string.fep, Integer.valueOf(size));
        try {
            a.fVQ();
            r.a(20005, eym.toByteArray(), true);
            AppMethodBeat.o(30125);
        } catch (IOException e2) {
            AppMethodBeat.o(30125);
        }
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
