package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.x;
import java.util.ArrayList;
import java.util.List;

@a(gRF = x.class)
public class aa extends a implements x {
    private List<Long> Pql = new ArrayList();

    public aa() {
        AppMethodBeat.i(233104);
        AppMethodBeat.o(233104);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(233105);
        super.gIn();
        Log.i("MicroMsg.groupsolitaire.GroupSolitaireComponent", "onChattingExitAnimStart");
        this.Pql.clear();
        AppMethodBeat.o(233105);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.x
    public final void Nx(long j2) {
        AppMethodBeat.i(233106);
        if (!this.Pql.contains(Long.valueOf(j2))) {
            this.Pql.add(Long.valueOf(j2));
        }
        AppMethodBeat.o(233106);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.x
    public final boolean cd(ca caVar) {
        AppMethodBeat.i(233107);
        if (caVar == null || caVar.field_solitaireFoldInfo == null) {
            AppMethodBeat.o(233107);
            return false;
        } else if (this.Pql.contains(Long.valueOf(caVar.field_msgId))) {
            AppMethodBeat.o(233107);
            return false;
        } else {
            AppMethodBeat.o(233107);
            return true;
        }
    }
}
