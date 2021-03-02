package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h;

public final class e extends h implements d {
    int fromScene = 0;

    public e(Context context, h.a aVar) {
        super(context, aVar);
    }

    @Override // com.tencent.mm.plugin.record.ui.h
    public final void a(a aVar) {
        AppMethodBeat.i(27863);
        this.BHQ = aVar;
        this.BHs.clear();
        this.BHs.addAll(aVar.BHs);
        notifyDataSetChanged();
        AppMethodBeat.o(27863);
    }

    @Override // com.tencent.mm.plugin.record.ui.h
    public final void d(b bVar) {
        bVar.dataType = 0;
        bVar.fromScene = this.fromScene;
        bVar.BHS = this.BHS;
        bVar.msgId = ((f) this.BHQ).msgId;
        bVar.dXH = ((f) this.BHQ).dXH;
    }

    @Override // com.tencent.mm.plugin.record.a.d
    public final void a(int i2, j jVar) {
        AppMethodBeat.i(27864);
        eIz();
        AppMethodBeat.o(27864);
    }
}
